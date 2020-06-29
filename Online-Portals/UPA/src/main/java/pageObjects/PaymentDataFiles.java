package main.java.pageObjects;

import java.util.Calendar;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import main.java.reporting.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDataFiles {

	@FindBy(xpath = "//img[@alt='PickDate']")
	WebElement fromDateCal;
	
	@FindBy(xpath = "//img[@alt='Click Here to Pick up the date.']")
	WebElement toDateCal;
	
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

	@FindBy(xpath="//input[@value='Submit']")
	WebElement btnSubmit;


	private TestBase testConfig;
	
	
	public PaymentDataFiles(TestBase testConfig) {
		
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.expectedWait(fromDateCal, testConfig, "From Date Calendar Icon", "From Date Calendar Icon");
	}
	

	public PaymentDataFiles clickFromDateIcon()
	{
		Element.click(fromDateCal, "From date calendar");
		return this;
	}
	
	public PaymentDataFiles clickToDateIcon()
	{
		Element.click(toDateCal, "To date calendar");
		return this;
	}
	
	public PaymentDataFiles setDate(String date)
	{
		for(int i =0;i<3;i++){
			if(!(Browser.getNoOfWindowHandles(testConfig)<2))
				break;
			else
				clickFromDateIcon();
		}
			
		String oldWindow=Browser.switchToNewWindow(testConfig, "/calendar.html");
		selectDate(testConfig,date);
		Browser.switchToParentWindow(testConfig,oldWindow);
		return this;
	}
	
	
	public PaymentDataFiles clickSubmit()
	{
		Element.click(btnSubmit, "Submit button");
		return this;
	}

	
	public PaymentDataFiles selectDate(TestBase testConfig, String requiredDate)
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
