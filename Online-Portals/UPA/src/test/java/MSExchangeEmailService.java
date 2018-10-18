package test.java;


import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import microsoft.exchange.webservices.data.Appointment;
import microsoft.exchange.webservices.data.AppointmentSchema;
import microsoft.exchange.webservices.data.CalendarFolder;
import microsoft.exchange.webservices.data.CalendarView;
import microsoft.exchange.webservices.data.EmailMessage;
import microsoft.exchange.webservices.data.ExchangeCredentials;
import microsoft.exchange.webservices.data.ExchangeService;
import microsoft.exchange.webservices.data.ExchangeVersion;
import microsoft.exchange.webservices.data.FindItemsResults;
import microsoft.exchange.webservices.data.Folder;
import microsoft.exchange.webservices.data.IAutodiscoverRedirectionUrl;
import microsoft.exchange.webservices.data.Item;
import microsoft.exchange.webservices.data.ItemId;
import microsoft.exchange.webservices.data.ItemSchema;
import microsoft.exchange.webservices.data.ItemView;
import microsoft.exchange.webservices.data.PropertySet;
import microsoft.exchange.webservices.data.SearchFilter;
import microsoft.exchange.webservices.data.ServiceLocalException;
import microsoft.exchange.webservices.data.WebCredentials;
import microsoft.exchange.webservices.data.WellKnownFolderName;

public class MSExchangeEmailService {

    public static class RedirectionUrlCallback implements IAutodiscoverRedirectionUrl {
        public boolean autodiscoverRedirectionUrlValidationCallback(String redirectionUrl) {
          return redirectionUrl.toLowerCase().startsWith("https://");
        }
    }

    private static ExchangeService service;
    private static Integer NUMBER_EMAILS_FETCH =2; // only latest 5 emails/appointments are fetched.
   
    /**
     * Firstly check, whether "https://webmail.xxxx.com/ews/Services.wsdl" and "https://webmail.xxxx.com/ews/Exchange.asmx"
     * is accessible, if yes that means the Exchange Webservice is enabled on your MS Exchange.
     */
    
    static{
        try{
            service = new ExchangeService(ExchangeVersion.Exchange2010);
            service.setUrl(new URI("https://oaw.uhc.com/ews/Exchange.asmx"));

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Initialize the Exchange Credentials. 
     * Don't forget to replace the "USRNAME","PWD","DOMAIN_NAME" variables. 
     */
    
    public MSExchangeEmailService() {
    	ExchangeCredentials credentials = new WebCredentials("p1058", "Pa@543210", "MS");
    	service.setCredentials(credentials);
        service.setTraceEnabled(true);
    }
    
    /**
     * Reading one email at a time. Using Item ID of the email.
     * Creating a message data map as a return value.   
     */
    public Map readEmailItem(ItemId itemId){
        Map messageData = new HashMap();
        try{
            Item itm = Item.bind(service, itemId, PropertySet.FirstClassProperties);
            EmailMessage emailMessage = EmailMessage.bind(service, itm.getId());
            messageData.put("emailItemId", emailMessage.getId().toString());
            messageData.put("subject", emailMessage.getSubject().toString());
            messageData.put("fromAddress",emailMessage.getFrom().getAddress().toString());
            messageData.put("senderName",emailMessage.getSender().getName().toString());
            Date dateTimeCreated = emailMessage.getDateTimeCreated();
            messageData.put("SendDate",dateTimeCreated.toString());
            Date dateTimeRecieved = emailMessage.getDateTimeReceived();
            messageData.put("RecievedDate",dateTimeRecieved.toString());
            messageData.put("Size",emailMessage.getSize()+"");
            System.out.println(emailMessage.getBody().toString());
            messageData.put("emailBody",emailMessage.getBody().toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return messageData;
    }
    
    /**
     * Number of email we want to read is defined as NUMBER_EMAILS_FETCH, 
     */
    public List readEmails(){
        @SuppressWarnings("rawtypes")
		List msgDataList = new ArrayList();
        try{
            Folder folder = Folder.bind(service, WellKnownFolderName.Inbox );
            FindItemsResults<Item> results = service.findItems(folder.getId(), new ItemView(NUMBER_EMAILS_FETCH));
            System.out.println("Total count of items" + results.getTotalCount());
            int i =1;
            for (Item item : results){
                Map messageData = new HashMap();
                messageData = readEmailItem(item.getId());
                System.out.println("\nEmails #" + (i++ ) + ":" );
                System.out.println("subject : " + messageData.get("subject").toString());
                System.out.println("Sender : " + messageData.get("senderName").toString());
                msgDataList.add(messageData);
            }
        }catch (Exception e) { 
            e.printStackTrace();
        }
        return msgDataList;
    }
    
    
    /**
     * Reading one appointment at a time. Using Appointment ID of the email.
     * Creating a message data map as a return value.   
     */
    public Map readAppointment(Appointment appointment){
        Map appointmentData = new HashMap();
        try {
            appointmentData.put("appointmentItemId", appointment.getId().toString());
            appointmentData.put("appointmentSubject", appointment.getSubject());
            appointmentData.put("appointmentStartTime", appointment.getStart()+"");
            appointmentData.put("appointmentEndTime", appointment.getEnd()+"");
            //appointmentData.put("appointmentBody", appointment.getBody().toString());
        } catch (ServiceLocalException e) {
            e.printStackTrace();
        }
        return appointmentData;
    }
    
    
    /**
      *Number of Appointments we want to read is defined as NUMBER_EMAILS_FETCH,
      *  Here I also considered the start data and end date which is a 30 day span.
      *  We need to set the CalendarView property depending upon the need of ours.   
     */
    public List readAppointments(){
        List apntmtDataList = new ArrayList();
        Calendar now = Calendar.getInstance();
        Date startDate = Calendar.getInstance().getTime();
        now.add(Calendar.DATE, 30);
                Date endDate = now.getTime();  
        try{
            CalendarFolder calendarFolder = CalendarFolder.bind(service, WellKnownFolderName.Calendar, new PropertySet());
            CalendarView cView = new CalendarView(startDate, endDate, 5);
            cView.setPropertySet(new PropertySet(AppointmentSchema.Subject, AppointmentSchema.Start, AppointmentSchema.End));// we can set other properties as well depending upon our need.

            //FindItemsResults appointments = calendarFolder.findAppointments(cView);
            FindItemsResults<Appointment> appointments = calendarFolder.findAppointments(cView);
            System.out.println("|------------------> Appointment count = " + appointments.getTotalCount());
            int i =1;
            //List appList = appointments.getItems();
            for (Appointment appointment : appointments.getItems()) {
                System.out.println("\nAPPOINTMENT #" + (i++ ) + ":" );
                Map appointmentData = new HashMap();
                appointmentData = readAppointment(appointment);
                System.out.println("subject : " + appointmentData.get("appointmentSubject").toString());
                System.out.println("On : " + appointmentData.get("appointmentStartTime").toString());
                apntmtDataList.add(appointmentData);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
       return apntmtDataList;
    }

    public static void getAllMeetings() throws Exception {

     try {

      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");      
      Date startDate = formatter.parse("2016-01-01 00:00:00");

      SearchFilter filter = new SearchFilter.IsGreaterThanOrEqualTo(ItemSchema.LastModifiedTime,startDate);

      FindItemsResults<Item> findResults = service.findItems(WellKnownFolderName.Calendar, filter, new ItemView(1000));
      System.out.println("|------------------> meetings count = " + findResults.getTotalCount());

      for (Item item : findResults.getItems())
      {
          Appointment appt = (Appointment)item;
          //appt.setStartTimeZone();
          System.out.println("TimeZone====="+appt.getTimeZone());
          System.out.println("SUBJECT====="+appt.getSubject());
          System.out.println("Location========"+appt.getLocation());
          System.out.println("Start Time========"+appt.getStart());
          System.out.println("End Time========"+appt.getEnd());
          System.out.println("Email Address========"+ appt.getOrganizer().getAddress());
          System.out.println("Last Modified Time========"+appt.getLastModifiedTime());
          System.out.println("Last Modified Time========"+appt.getLastModifiedName());
          System.out.println("*************************************************\n");
      } 
     } catch (Exception exp) {
         exp.printStackTrace();
     }
    }

    public static void main(String[] args) {
        MSExchangeEmailService msees = new MSExchangeEmailService();
        msees.readEmails();
        //msees.readAppointments();
//        try {
//            msees.getAllMeetings();
//        } catch (Exception ex) {
//            Logger.getLogger(MSExchangeEmailService.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}