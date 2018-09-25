package main.java.pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;


public class SearchRemittanceSearchCriteria {
	
	private TestBase testConfig;
	
	@FindBy(id="checkNumberInputId")
	WebElement checkNumber;
	
	@FindBy(id="paymentNumberInputId")
	WebElement paymentNumber;
	
	@FindBy(id="paymentNbrTypeSelection")
	WebElement paymentNumberType;
	
	@FindBy(id="patientLastNameId")
	WebElement patientLastName;
	
	@FindBy(id="patientFirstNameId")
	WebElement patientFirstName;
	
	@FindBy(id="providerLastNameID")
	WebElement providerLastName;
	
	@FindBy(name="searchRemittance")
	WebElement btnSearchRemittance;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[3]/td[5]/a[2]/img")
	WebElement dosTo;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[3]/td[5]/a[1]/img")
	WebElement dosFrom;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[4]/td[5]/a[2]/img")
	WebElement dopTo;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[4]/td[5]/a[1]/img")
	WebElement dopFrom;
	
	@FindBy(xpath = "//img[@alt='previous month']")
	WebElement btnPreviousMonth;
	
	@FindBy(xpath = "//img[@alt='next month']")
	WebElement btnNextMonth;
	
	@FindBy(xpath = "//img[@alt='previous year']")
	WebElement btnPreviousYear;
	
	@FindBy(xpath = "//img[@alt='next year']")
	WebElement btnNxtYear;
	
	@FindBy(xpath = "//table//table//table//tr//font")
	WebElement monthYearInCal;
	
	public SearchRemittanceSearchCriteria(TestBase testConfig)
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	
	public void fillSearchCriteria(String criteriaType) {
		
		Map data;
		String ePaymentNumber=null;
		
		switch(criteriaType)
		 {
		    case "byElectronicPaymentNumber":
		    {
		    	data=dataProvider(criteriaType);
		    	ePaymentNumber=data.get("DSPL_CONSL_PAY_NBR").toString();
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.click(paymentNumber, "Selecting Filter Criteria");
		    	Element.enterData(paymentNumber, ePaymentNumber, "Filling Electronic payment number", "payment number");
		    	clickSearchBtn();
		    	break;
		    }
		    
		    case "byCheckNumber":
		    {
		    	data=dataProvider(criteriaType);
		    	ePaymentNumber=data.get("UCONSL_PAY_NBR").toString();
		    	Element.selectByVisibleText(paymentNumberType, "Check Number", "Select payment number type");
		    	Element.click(checkNumber, "Selecting Filter Criteria");
		    	Element.enterData(checkNumber, ePaymentNumber, "Filling Check payment number", "payment number");
		    	clickSearchBtn();
		    	break;		    	
		    }
		    
		    case "byDateOfService":
		    {
		    	
		    	String toDateDos = Helper.getCurrentDate("dd/MM/yyyy");
		    	String fromDateDos = Helper.getDateBeforeOrAfterDays(-30,"dd/MM/yyyy");
		    	System.out.println(toDateDos+":"+fromDateDos);
		    	clickFromDateIcon(criteriaType).setDate(fromDateDos, criteriaType).clickToDateIcon(criteriaType).setDate(toDateDos, criteriaType).clickSearchBtn();
		    	/*Date date = new Date();
		    	Calendar cal = Calendar.getInstance();
		    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    	String toDateDos =  dateFormat.format(date);
		    	
				cal.add(Calendar.DAY_OF_MONTH, -30);
				date = cal.getTime();
				
				String fromDateDos=dateFormat.format(date);

		    	/* if (settlDate.compareTo(Helper.getDateBeforeOrAfterDays(-30,"yyyy-MM-dd")) >= 0 && settlDate.compareTo(Helper.getCurrentDate("yyyy-MM-dd")) < 0) 
		    			filterCriteria="Last 30 days"; 
		    	
		    	/*data=dataProvider(criteriaType);
		    	ePaymentNumber=data.get("UCONSL_PAY_NBR").toString();
		    	Element.selectByVisibleText(paymentNumberType, "Check Number", "Select payment number type");
		    	Element.click(checkNumber, "Selecting Filter Criteria");
		    	Element.enterData(checkNumber, ePaymentNumber, "Filling Check payment number", "payment number");
		    	clickSearchBtn();*/
		    	break;		    	
		    }
		    
		    case "byDateOfPayment":
		    {
		    	
		    	String toDateDos = Helper.getCurrentDate("dd/MM/yyyy");
		    	String fromDateDos = Helper.getDateBeforeOrAfterDays(-30,"dd/MM/yyyy");
		    	System.out.println(toDateDos+":"+fromDateDos);
		    	clickFromDateIcon(criteriaType).setDate(fromDateDos, criteriaType).clickToDateIcon(criteriaType).setDate(toDateDos, criteriaType).clickSearchBtn();
		    	break;		    	
		    }
		
		    default:
		    	Log.Comment("Criteria Type " + criteriaType + " not found");		
		 }		
	}
	
	public void clickSearchBtn() {
		Element.click(btnSearchRemittance, "Search Remittance Button");		
	}
	
	public Map<String, String> dataProvider(String criteriaType) {
		int sqlRowNo=0;
		
		switch(criteriaType)
		{
			case "byElectronicPaymentNumber":
			{
				sqlRowNo=38;
				break;
			}
			
			case "byCheckNumber":
			{
				sqlRowNo=40;
				break;
			}
		}
		Map data=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		
		return data;
	}
	
	public SearchRemittanceSearchCriteria setDate(String date, String criteriaType)
	{
		for(int i =0;i<3;i++){
			if(!(Browser.getNoOfWindowHandles(testConfig)<2))
				break;
			else
				clickFromDateIcon(criteriaType);			   
		}
			
		String oldWindow=Browser.switchToNewWindow(testConfig, "/calendar.html");
		selectDate(testConfig,date);
	    System.out.println(Browser.getNoOfWindowHandles(testConfig));
		Browser.switchToParentWindow(testConfig,oldWindow);
		return this;
	}
	
	public SearchRemittanceSearchCriteria clickFromDateIcon(String criteriaType)
	{
		
		switch(criteriaType) {
		case "byDateOfService":
	    {	    	
	    	Element.click(dosFrom, "From date calendar");
	    	break;		    	
	    }
	    
		case "byDateOfPayment":
	    {
	    	Element.click(dopFrom, "From Date of Payment");
	    	
	    }
	
	    default:
	    	Log.Comment("Criteria Type " + criteriaType + " not found");
		}
		
		
		return this;
	}
	
	public SearchRemittanceSearchCriteria clickToDateIcon(String criteriaType)
	{
		switch(criteriaType) {
		case "byDateOfService":
	    {	    	
	    	Element.click(dosTo, "To date calendar");
	    	break;		    	
	    }
	    
		case "byDateOfPayment":
	    {
	    	Element.click(dopTo, "To Date of Payment");	    	
	    }
	
	    default:
	    	Log.Comment("Criteria Type " + criteriaType + " not found");
		}
		
		
		return this;
	}
	
	public SearchRemittanceSearchCriteria selectDate(TestBase testConfig, String requiredDate)
	{
	    String curr[] = Helper.getCurrentDate("dd/MM/yyyy").split("/");
	    String req[] = requiredDate.split("/");

//	    int currDate = Integer.parseInt(curr[0]);
	    int reqDate = Integer.parseInt(req[0]);
	    int currMonth = Integer.parseInt(curr[1]);
	    int reqMonth = Integer.parseInt(req[1]);
	    int currYr = Integer.parseInt(curr[2]);
	    int reqYr = Integer.parseInt(req[2]);
	    String date=String.valueOf(reqDate);
	    String monthAndYearInCal[]={};

	    
	    // Select required year
	    if (currYr > reqYr){
	        for (int i=0;i<(currYr-reqYr);i++){
	            //decrease year
	        	Element.click(btnPreviousYear, "Previous Year button to go back one year..year is now : " + String.valueOf(currYr-(i+1)));
	        	Browser.wait(testConfig,1);
	        	monthAndYearInCal=monthYearInCal.getText().split(" ");
	        	Helper.compareEquals(testConfig, "Selected Year", monthAndYearInCal[1], String.valueOf(currYr-(i+1)));
	        }   
	    } else if (currYr < reqYr){
	        for (int j=0;j<(reqYr-currYr);j++){
	            //increase year
	        	Element.click(btnNxtYear, "Next Year button to go ahead one year..year is now : " + String.valueOf(currYr+(j+1)));
	        	Browser.wait(testConfig, 2);
	        	monthAndYearInCal=monthYearInCal.getText().split(" ");
	        	Helper.compareEquals(testConfig, "Selected Year", monthAndYearInCal[1], String.valueOf(currYr+(j+1)));
	        }
	    }

	    
	    if (currMonth > reqMonth){
	        for (int i=0;i<(currMonth-reqMonth);i++){
	            //decrease month
	        	Element.click(btnPreviousMonth, "Previous month button to go back one month..month is now : " + String.valueOf(currMonth-(i+1)));
	        	Browser.wait(testConfig, 2);
	        	
	        }
	    } else if (currMonth < reqMonth){
	        for (int j=0;j<(reqMonth-currMonth);j++){
	            // increase month
	        	Element.click(btnNextMonth, "Next month to go ahead one month..month is now : " + String.valueOf(currMonth+(j+1)));
	        	Browser.wait(testConfig, 2);
	        }
	    }
	    monthAndYearInCal=monthYearInCal.getText().split(" ");
	    Log.Comment("Date to be selected is : " +  testConfig.driver.findElement(By.xpath("//a//font[contains(text()," + "'" + date + "'"+ ")"+ " " + "and @color='#000000']")).getText() + monthAndYearInCal[0] + monthAndYearInCal[1] );
	    testConfig.driver.findElement(By.xpath("//a//font[contains(text()," + "'" + date + "'"+ ")"+ " " + "and @color='#000000']")).click();	
	    return this;
	}
	
}
