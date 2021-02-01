package main.java.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OptumPaySoln {
	private WebDriver driver;
	private TestBase testConfig;
	
	@FindBy(className="wrapperTooltip")
	List <WebElement> titles;

	@FindBy(xpath = "//li[contains(text(),'Please enter a existing 9 digit TIN number.')]") 
	WebElement nonExistingTINmsgOptumPaySol;
	
	@FindBy(xpath = "//li[contains(text(),'Please enter a valid 9 digit TIN number.')]") 
	WebElement InValidTINmsgOptumPaySol;
	
	@FindBy(xpath = "//input[@name='taxIndNbr']") 
    WebElement enterTIN;
	
	@FindBy(xpath = "//input[@name='btnSubmit']")
	WebElement searchBtn;

	public OptumPaySoln(TestBase testBase)
	{
		this.testConfig=testBase;
		PageFactory.initElements(testConfig.driver, this);
	}
	public OptumPaySoln validateTitleNames(){
	
		ArrayList<String> expectdtitles=new ArrayList<String>(); 
		expectdtitles.add("Plan Type");
		expectdtitles.add("Rate");
		expectdtitles.add("Fees");
		expectdtitles.add("Manage My Plan");
		//String[] titles1={"Plan Type","Rate","Fees","Manage My Plan"};
		
		ArrayList<String> UItitles=new ArrayList<String>(); 
		for(WebElement title: titles)
		{
			UItitles.add(title.getText());
		}
		Helper.compareEquals(testConfig, "Title comparision", expectdtitles, UItitles);	
		return this;
	}
	
	public OptumPaySoln validateFeeTitle()
	{
		int sqlRowNo=1616;
		Map data = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	    String feeTitle=null;
		if (data.get("ACCRDFEE").toString().substring(data.get("ACCRDFEE").toString().length()-1).equals("0"))
		 feeTitle="Accrued fees month to date: $" +data.get("ACCRDFEE").toString().substring(0,data.get("ACCRDFEE").toString().length()-1);
		Helper.compareContains(testConfig, "1st part of Fee Title", feeTitle, Element.findElement(testConfig, "xpath", "//*[@id='optum-pay-options']/div/div[3]").getText());
		Helper.compareContains(testConfig, "2nd part of Fee Title", "Past due fees: $0.00", Element.findElement(testConfig, "xpath", "//*[@id='optum-pay-options']/div/div[3]").getText());

		return this;
	}
	

	public OptumPaySoln verifyInvalidTINonOptumPaySolution(String invalidTIN) throws Exception 
	{
		Element.expectedWait(enterTIN, testConfig, "TIN field","TIN Field");
		Element.enterData(enterTIN, invalidTIN, "TIN entered as : "+invalidTIN, "EnterTIN");
		Element.clickByJS(testConfig,searchBtn, "Search Button");
		Browser.wait(testConfig, 4);
		boolean isInteger;
		try {
		    int x = Integer.parseInt(invalidTIN);
		    isInteger=true;
		}
		catch(NumberFormatException nFE) {
			isInteger=false;
		}
		
		if(isInteger && invalidTIN.length()==9)
		{
			String ErrorMsgText = nonExistingTINmsgOptumPaySol.getText();
			Helper.compareEquals(testConfig, "Non-Existing TIN error msg", "Please enter a existing 9 digit TIN number.", ErrorMsgText);
		}
		else
		{
			String ErrorMsgText = InValidTINmsgOptumPaySol.getText();
			Helper.compareEquals(testConfig, "InValid TIN error msg", "Please enter a valid 9 digit TIN number.", ErrorMsgText);
		}
		return this;
	
	}
	
}
