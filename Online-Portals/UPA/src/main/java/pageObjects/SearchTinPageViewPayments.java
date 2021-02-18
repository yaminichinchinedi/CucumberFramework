package main.java.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class SearchTinPageViewPayments {

	private ViewPaymentsDataProvider dataProvider;
	
	@FindBy(name="providerTIN")
	public WebElement txtboxTinNo;
	
	@FindBy(name="btnSubmit")
	public WebElement btnSubmit;
	
	@FindBy(xpath = "//select[@id='taxIndNbrId']") 
	WebElement prvdrTIN;
	
	@FindBy(xpath = "//input[@name='taxIdNbr']")
	WebElement tinDrpDwn;
	
	@FindBy(xpath = "//input[@name='billingProvTin']")
	WebElement bstinDrpDwn;
	
	@FindBy(xpath = "//input[@name='payerProvTin']") 
	WebElement payertinDrpDwn;
	
	@FindBy(xpath = "//input[@name='btnSearch']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//input[@value='Search']")
	WebElement srchBtn;
	
	private TestBase testConfig;
	
	public SearchTinPageViewPayments(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(testConfig.driver, this);
    }
	
	public paymentSummary clickSearchBtn()
    {
      Element.clickByJS(testConfig,btnSubmit, "Search Button");
      return new paymentSummary(testConfig);
    }
	
	public String getTin(String userType,String paymentType,String tinType,String portalAccess)
	{
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		String tin=dataProvider.getTinForSearchCriteria(paymentType,tinType,portalAccess);
		if(System.getProperty("Application").contains("UPA"))
			dataProvider.associateTinWithUser(userType,tin);
		return tin;
	}
	
	public SearchTinPageViewPayments enterPaymentTin(String userType,String paymentType, String tinType,String portalAccess) {
		Helper.getPayerSchema(testConfig,paymentType);
		String tin = getTin(userType,paymentType,tinType,portalAccess); 
		System.setProperty("tin", tin);
		
		if(System.getProperty("Application").contains("UPA")){
			switch (userType)
			{
			   case "PROV": 
				 WebElement homeTab = Element.findElement(testConfig, "id", "tabHome");
				 List<String> tinList = Element.getAllOptionsInSelect(testConfig, prvdrTIN);
	
				 String Enrolledtin = tin + " - Enrolled";
				 if ((!tinList.contains(Enrolledtin))) 
				 {
					Element.click(homeTab, "home Tab");
					Browser.waitForLoad(TestBase.driver);
					Browser.wait(testConfig, 2);
					Element.expectedWait(prvdrTIN, testConfig, "Tin dropdown", "Tin dropdown");
				 }
				Element.selectVisibleText(prvdrTIN, tin + " - Enrolled", "TIN Selection from Dropdown");
				break;
			case "BS": 
				Browser.wait(testConfig, 2);
				Element.enterData(bstinDrpDwn, tin, "Enter Tin "+tin+" to proceed for View Payments","Tin Textbox");
				Element.click(submitBtn, "Search Button");
				break;
			case "Payer": 
				Browser.wait(testConfig, 2);
				Element.enterData(payertinDrpDwn, tin, "Enter Tin to proceed for View Payments","Tin Textbox");
				Element.click(submitBtn, "Search Button");
				break;
			}
		}
		else if(System.getProperty("Application").contains("CSR"))
		{
			Element.enterData(txtboxTinNo, tin, "Enter Tin "+tin+" to proceed for View Payments", "Tin Textbox");
		    Element.click(srchBtn, "Search Button");
		}
		return this;
	}

}

