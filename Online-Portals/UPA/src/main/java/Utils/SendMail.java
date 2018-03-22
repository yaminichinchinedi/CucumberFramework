package main.java.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.poi.util.IOUtils;
import org.testng.annotations.AfterSuite;

public class SendMail {

private static String USER_NAME = "Priyanka_Anand";  // Any user name

private static String RECIPIENT = "Priyanka_10@optum.com";

public static void sendEmail() throws FileNotFoundException, IOException {
String from = "Priyanka_Anand";
String[] to = {"priyanka_10@optum.com"}; // list of recipient email addresses
String subject = "Automation Report";
String body = "Below is the automation report :";
sendFromGMail(from, to, subject, body);
}


private static void sendFromGMail(String from,String[] to, String subject, String body) throws FileNotFoundException, IOException {
Properties props = System.getProperties();
String host = "mailinbound.uhc.com";

props.put("mail.smtp.starttls.enable", "true");

props.put("mail.smtp.host", host);

Session session = Session.getDefaultInstance(props);
MimeMessage message = new MimeMessage(session);


try {


    message.setFrom(new InternetAddress(from));
    InternetAddress[] toAddress = new InternetAddress[to.length];

    // To get the array of addresses
    for( int i = 0; i < to.length; i++ ) {
        toAddress[i] = new InternetAddress(to[i]);
    }

    for( int i = 0; i < toAddress.length; i++) {
        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
    }
    
    
    //Sets subject of email
    message.setSubject(subject);
    
    message.setContent("<html><head></head><body>Hi,<br><br></br>Please click the link below to view automation report.<br><br></br><a href='\\\\nas00912pn\\Apps\\Work\\Priyanka\\p1058\\index.html'>Report link</a><br><br></br>Thanks,<br>Priyanka</body></html>","text/html");
  
    Transport transport = session.getTransport("smtp");
    transport.connect(host,from);
  
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
    System.out.println("Mail sent!");

    
}
catch (AddressException ae) {
    ae.printStackTrace();
}
catch (MessagingException me) {
    me.printStackTrace();
  }
 }
} 