package main.java.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath = "//select[@id='taxIndNbrId']") WebElement prvdrTIN;
	
	@FindBy(xpath = "//input[@name='taxIdNbr']") WebElement tinDrpDwn;
	@FindBy(xpath = "//input[@name='billingProvTin']") WebElement bstinDrpDwn;
	@FindBy(xpath = "//input[@name='payerProvTin']") WebElement payertinDrpDwn;
	@FindBy(xpath = "//input[@name='btnSearch']") WebElement submitBtn;
	@FindBy(xpath = "//input[@value='Search']") WebElement srchBtn;
	
	
	
	
	
	
	private TestBase testConfig;
	
	public SearchTinPageViewPayments(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(testConfig.driver, this);
	  //Element.verifyElementPresent(txtboxTinNo, "Enter Tin Text Box is present");
    }
	
	public SearchTinPageViewPayments enterTin(String paymentType)
    {
      Element.enterData(txtboxTinNo, getTin(paymentType), "Enter Tin to proceed for View Payments", "Tin Textbox");
      return this;
    }
	

	
	
	public void enterTinUPA(String paymentType)
    {
		
		 String tin=getTin(paymentType);
		 System.setProperty("tin", tin); 
		 
	   switch(paymentType) 
		 {
	   
	        case "BS":
	         { 
	        	 Element.enterData(bstinDrpDwn, tin, "Entering BS TIN", "Entering BS TIN");
	        	 Element.click(submitBtn, "Search Button");
		         break;
	          }
	         
	      
	        case "Provider_Admin":
            {
            	Element.selectVisibleText(prvdrTIN,tin +" - Enrolled","TIN Selection from Dropdown");
            	break;
            }
            
            case "Provider_Gen":
            {
            	Element.selectVisibleText(prvdrTIN,tin +" - Enrolled","TIN Selection from Dropdown");
            	break;
            }
            
            case "Payer":
	         {
		         
	        	 Element.enterData(payertinDrpDwn, tin, "Entering Payer TIN", "Entering Payer TIN");
		         Element.click(submitBtn, "Search Button");
		         break;
	          }
            case "Payer_Admin":
	         {
		         
	        	 Element.enterData(payertinDrpDwn, tin, "Entering Payer TIN", "Entering Payer TIN");
		         Element.click(submitBtn, "Search Button");
		         break;
	          }
	         
            case "Payer_Gen":
	         {
		         
	        	 Element.enterData(payertinDrpDwn, tin, "Entering Payer TIN", "Entering Payer TIN");
		         Element.click(submitBtn, "Search Button");
		         break;
	          }
	         
            case "Tricare":
	         {
	        	 Element.selectVisibleText(prvdrTIN,tin +" - Enrolled","TIN Selection from Dropdown");
	        	 //Element.enterData(tinDrpDwn, tin, "Entering Tricare TIN", "Entering Tricare TIN");
		         break;
	          }
	         
            case "Tricare_BS":
	         {       
			         Element.clearData(tinDrpDwn, "clearing any previous TIN");
                     Browser.wait(testConfig, 7);
                     Element.enterData(tinDrpDwn, tin, "Enter Tin", "Enter Tin");
	        	     Element.click(srchBtn, "Search Button");
	        	 
	        	 //Element.enterData(tinDrpDwn, tin, "Entering Tricare TIN", "Entering Tricare TIN");
		         break;
	          }
	         
            case "Multiple PLB":
	         {
	        	 Element.selectVisibleText(prvdrTIN, tin +" - Enrolled", "Entering Multiple PLB TIN");
	        	 //Element.enterData(tinDrpDwn, "430687806", "Entering Multiple PLB TIN", "Entering Multiple PLB TIN");
		         break;
	          }
	         
            case "PLB Adj Only":
	         {
	        	 Element.selectVisibleText(prvdrTIN,tin +" - Enrolled", "Entering PLB Adj Only TIN");
	        	 //Element.enterData(tinDrpDwn, "371839681", "Entering PLB Adj Only TIN", "Entering PLB Adj Only TIN");
		         //Log.Comment("TIN selected: 371839681");
	             break;
	          }
	         
            case "RemitDetail":
	         { 
	        	 Element.selectVisibleText(prvdrTIN,tin +" - Enrolled","TIN Selection from Dropdown");
	             break;
	          }
	         
	         
            case "RemitDetail_ProvAdmin":
	         { 
	        	 Element.selectVisibleText(prvdrTIN,tin +" - Enrolled","TIN Selection from Dropdown");
	             break;
	          }
	         
            case "RemitDetail_ProvGen":
	         { 
	        	 Element.selectVisibleText(prvdrTIN,tin +" - Enrolled","TIN Selection from Dropdown");
	             break;
	          }
	         
	      
	        case "RemitDetail_BSAdmin":
	         { 
	        	 Element.enterData(bstinDrpDwn, tin, "Entering BS TIN", "Entering BS TIN");
	        	 Element.click(submitBtn, "Search Button");
		         break;
	          }
	         
	         
            case "RemitDetail_BSGen":
	         { 
	        	 Element.enterData(bstinDrpDwn, tin, "Entering BS TIN", "Entering BS TIN");
	        	 Element.click(submitBtn, "Search Button");
		         break;
	          }
         }
    }
	
	
	public void enterTinForBS(String paymentType)
    {
		
		 String tin=getTin(paymentType);
		 System.setProperty("tin", tin); 
		 
	   switch(paymentType) 
		 {
	   
	        case "BS_Admin":
	         { 
	        	 Element.enterData(bstinDrpDwn, tin, "Entering BS TIN", "Entering BS TIN");
	        	 Element.click(submitBtn, "Search Button");
		         break;
	          }
	         
	        case "BS_Gen":
	         { 
	        	 Element.enterData(bstinDrpDwn, tin, "Entering BS TIN", "Entering BS TIN");
	        	 Element.click(submitBtn, "Search Button");
		         break;
	          }
	       
            case "Tricare":
	         {
	        	 Element.enterData(tinDrpDwn, tin, "Entering TIN", "Entering TIN");
		         Element.click(srchBtn, "Search Button");
	        	 break;
	          }
	         
            case "Tricare_BS":
	         {
	        	 Element.enterData(tinDrpDwn, tin, "Entering TIN", "Entering TIN");
		         Element.click(srchBtn, "Search Button");
	        	 break;
	          }
	         
            case "Multiple PLB":
	         {
	        	 Element.enterData(tinDrpDwn, tin, "Entering TIN", "Entering TIN");
		         Element.click(srchBtn, "Search Button");
	        	 break;
	          }
	         
            case "PLB Adj Only":
	         {
	        	 Element.enterData(tinDrpDwn, tin, "Entering TIN", "Entering TIN");
		         Element.click(srchBtn, "Search Button");
	        	 break;
	         }
         }
    }
	
	
	public void enterTinForPayer(String paymentType)
    {
		
		 String tin=getTin(paymentType);
		 System.setProperty("tin", tin); 
		 
	   switch(paymentType) 
		 {
	   
		   case "Payer_Admin":
           {
	         
        	 Element.enterData(payertinDrpDwn, tin, "Entering Payer TIN", "Entering Payer TIN");
	         Element.click(submitBtn, "Search Button");
	         break;
            }
		   case "Payer_Gen":
           {
	         
        	 Element.enterData(payertinDrpDwn, tin, "Entering Payer TIN", "Entering Payer TIN");
	         Element.click(submitBtn, "Search Button");
	         break;
            }
           
            case "Tricare":
	         {
	        	 Element.enterData(tinDrpDwn, tin, "Entering TIN", "Entering TIN");
		         Element.click(srchBtn, "Search Button");
	        	 break;
	          }
	         
            case "Multiple PLB":
	         {
	        	 Element.enterData(tinDrpDwn, tin, "Entering TIN", "Entering TIN");
		         Element.click(srchBtn, "Search Button");
	        	 break;
	          }
	         
            case "PLB_Adj_Only_Pay_Admin":
	         {
	        	 Element.enterData(tinDrpDwn, tin, "Entering TIN", "Entering TIN");
		         Element.click(srchBtn, "Search Button");
	        	 break;
	         }
	         
	         
            case "PLB_Adj_Only_Pay_Gen":
	         {
	        	 Element.enterData(tinDrpDwn, tin, "Entering TIN", "Entering TIN");
		         Element.click(srchBtn, "Search Button");
	        	 break;
	         }
         }
    }
	
	
	public paymentSummary clickSearchBtn()
    {
      Element.clickByJS(testConfig,btnSubmit, "Search Button");
      return new paymentSummary(testConfig);
    }
	
	public String getTin(String paymentType)
	{
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		return dataProvider.getTinForPaymentType(paymentType);
	}

}
