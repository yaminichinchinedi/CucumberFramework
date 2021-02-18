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

public class SearchTinPageSearchRemittance {
	
	private ViewPaymentsDataProvider dataProvider;
	
//	@FindBy(name="providerTIN")
//	public WebElement txtboxTinNo;
	
	@FindBy(xpath=".//*[contains(text(),'TIN:')]")
	public WebElement headerTinTxt;
	
	@FindBy(name="btnSubmit")
	public WebElement btnSubmit;

	@FindBy(xpath = "//select[@id='taxIndNbrId']") WebElement prvdrTIN;
	@FindBy(xpath = "//input[@value='Search']") WebElement submitBtn;
	@FindBy(xpath = "//ul[@id='tabmenu']/li[2]") WebElement archiveBtn;
	@FindBy(xpath = "//ul[@id='tabmenu']/li[1]") WebElement currentBtn;
	@FindBy(name="providerTIN") WebElement txtboxTinNo;
	@FindBy(id="taxIndNbrId") WebElement tinDrpDwn;
	@FindBy(name="taxIdNbr") WebElement bstinDrpDwn;
	@FindBy(name="taxIdNbr") WebElement payertinDrpDwn;
    
	
	
	
	//TestBase testConfig=TestBase.getInstance();
	
	@FindBy(name="taxIdNbr")
	public WebElement txtTinnumber;
	
	@FindBy(css="[value='Search']")
	public WebElement btnSearch;
	
	
	
	private TestBase testConfig;
	
	public SearchTinPageSearchRemittance(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(testConfig.driver, this);
	  //Element.verifyElementPresent(txtboxTinNo, "Text Box for entering tin number is present");
	  
	  //Element.verifyElementPresent(headerTinTxt, "Tin text entering tin number is present");
	  
    }
	
	public SearchTinPageSearchRemittance enterTin(String paymentType)
    {
		
	  String tin=getTin(paymentType);
      Element.enterData(txtboxTinNo,tin, "Enter Tin as : " +tin, "Tin Textbox");
      return this;
    }

  
  	public SearchTinPageSearchRemittance enterTinUPA(String paymentType, String usertype)
      {
  		    if (paymentType.equals("EPRAViewPay"))
			{
			String tin=getTin(paymentType);
			System.setProperty("tin", tin);
			}
			else
		 {
  		    String tin=getTinUPA(paymentType,usertype);
  		    System.setProperty("tin", tin); 
  		
  		    switch(usertype) 
		 {
		 case "PROV_Admin":
         {   
        	 Element.selectVisibleText(tinDrpDwn,tin +" - Enrolled","TIN Selection from Dropdown");
        	 break;
          }
      case "PROV_Gen":
         {   
        	 Element.selectVisibleText(tinDrpDwn,tin +" - Enrolled","TIN Selection from Dropdown");
        	 break;
          }
      case "PROV":
         {   
        	 Element.click(archiveBtn, "Archive Button");
        	 Element.click(currentBtn, "Current Button");
        	 //Browser.browserRefresh(testConfig);
        	 //Browser.browserRefresh(testConfig);
        	 Element.selectVisibleText(tinDrpDwn,tin +" - Enrolled","TIN Selection from Dropdown");
        	 break;
          }  
      case "BS":
         {
        	 Element.enterData(bstinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
        	 Element.click(submitBtn, "Click Search Button");
        	 break;
          }
     case "Payer":
     case "PAYER":
         {
        	 Element.enterData(payertinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
        	 Element.click(submitBtn, "Click Search Button");
        	 break;
          }
         
     case "PAY_Admin":
     {
    	 Element.enterData(payertinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
    	 Element.click(submitBtn, "Click Search Button");
    	 break;
      } 
     
     case "PAY_Gen":
     {
    	 Element.enterData(payertinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
    	 Element.click(submitBtn, "Click Search Button");
    	 break;
      }  
     
     case "SUBPAYER":
     {
    	 Element.enterData(payertinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
    	 Element.click(submitBtn, "Click Search Button");
    	 break;
      }  
      
      }
	}
  		return this; 
      }
  	
  	
  	public SearchTinPageSearchRemittance enterTinCSR(String paymentType, String usertype)
    {
		    String tin=getTinCSR(paymentType);
		    System.setProperty("tin", tin); 
		
		    switch(usertype) 
		 {
		 
    case "PROV":
       {   
      	 //Element.selectVisibleText(txtboxTinNo,tin,"Enter TIN in CSR");
      	 Element.enterData(txtboxTinNo, tin, "Enter TIN", "Enter TIN in CSR");
      	 Element.click(submitBtn, "Click Search Button");
      	 break;
        }  
    case "BS":
       {
      	 Element.enterData(bstinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
      	 Element.click(submitBtn, "Click Search Button");
      	 break;
        }
   case "Payer":
       {
      	 Element.enterData(payertinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
      	 Element.click(submitBtn, "Click Search Button");
      	 break;
        }
    }
		return this; 
    }
	
	public SearchRemittanceSearchCriteria clickSearchBtn()
    {
      Element.clickByJS(testConfig,btnSubmit, "Search Button");
      return new SearchRemittanceSearchCriteria(testConfig);
    }
	
	public String getTin(String paymentType)
	{
		
		WebElement homeTab=Element.findElement(testConfig, "id", "tabHome");
		//WebElement drpDwnTin=Element.findElement(testConfig, "id", "taxIndNbrId");
		
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		String tin="";//dataProvider.getTinForPaymentType(paymentType);
        
		dataProvider.associateTinWithUser("PROV",tin);
		
		//dataProvider.associateTinWithUser(userType,tin);
		List <String> tinList=Element.getAllOptionsInSelect(testConfig,tinDrpDwn);
		String Enrolledtin=tin+" - Enrolled";
		
		if((!tinList.contains(Enrolledtin))){
		   Element.click(homeTab, "home Tab");
		   Browser.waitForLoad(testConfig.driver);
		   Browser.wait(testConfig, 3);
		   Element.expectedWait(tinDrpDwn, testConfig, "Tin dropdown", "Tin dropdown"); 
		 }
		
		Element.selectByVisibleText(tinDrpDwn,Enrolledtin, "Tin is : "  + Enrolledtin);
		Browser.waitForLoad(testConfig.driver);
		//return dataProvider.getTinForPaymentType(paymentType);
		return tin;
	}
	
	
	
	
	public String getTinUPA(String paymentType, String userType)
	{
		
		WebElement homeTab=Element.findElement(testConfig, "id", "tabHome");
		//WebElement drpDwnTin=Element.findElement(testConfig, "id", "taxIndNbrId");
		
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		String tin="";//dataProvider.getTinForPaymentType(paymentType);
        
		//dataProvider.associateTinWithUser("PROV",tin);
		//dataProvider.associateTinWithUser("BS",tin);
		
		//dataProvider.associateTinWithUser(userType,tin);
		
		dataProvider.associateTinWithUser(userType,tin);
		if(userType=="PROV")
		{
			//dataProvider.associateTinWithUser(userType,tin);
			List <String> tinList=Element.getAllOptionsInSelect(testConfig,tinDrpDwn);
		   
			String Enrolledtin=tin+" - Enrolled";
		  if((!tinList.contains(Enrolledtin))){
		   Element.click(homeTab, "home Tab");
		   Browser.waitForLoad(testConfig.driver);
		   Browser.wait(testConfig, 3);
		   Element.expectedWait(tinDrpDwn, testConfig, "Tin dropdown", "Tin dropdown"); 
		 }
		
		Element.selectByVisibleText(tinDrpDwn,Enrolledtin, "Tin is : "  + Enrolledtin);
		}
		
		else if (userType=="BS")
		{
			//dataProvider.associateTinWithUser(userType,tin);
			String Enrolledtin = tin;
			if((!tin.contains(Enrolledtin))){
				Element.enterData(bstinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
				Element.click(submitBtn, "Click Search Button");
		}
		}
			
			else if(userType=="Payer")
        {
	        String Enrolledtin = tin;
	         if((!tin.contains(Enrolledtin))){
	        	 
	        	 Element.enterData(payertinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
	        	 Element.click(submitBtn, "Click Search Button");
		     }
		
		}
		Browser.waitForLoad(testConfig.driver);
		//return dataProvider.getTinForPaymentType(paymentType);
		
		
		return tin;
	}
	
	public String getTinCSR(String paymentType)
	{
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		return "";//dataProvider.getTinForPaymentType(paymentType);
	}
	
	public SearchTinPageSearchRemittance enterHCTin(String Tin)
    {
	  Element.enterData(txtboxTinNo,Tin, "Enter Tin as : " +Tin, "Tin Textbox");
      return this;
    }
	
	public void enterTinUPA(String paymentType)
    {
		System.out.println("*****enterTinUPA 1");
		int sqlRowNo=0;
		String payType="";
		paymentSummary paySum=new paymentSummary(testConfig,"filter");

		switch(paymentType) 
		{
         case "EPRA":
         {
        	Element.selectVisibleText(tinDrpDwn,"020619423 - Enrolled","TIN Selection from Dropdown");
        	Log.Comment("TIN selected: 020619423 - Enrolled");
             break;
          }
         
         case "EPRAgenerated":
            {
         
              Element.selectVisibleText(tinDrpDwn,"020619423 - Enrolled","TIN Selection from Dropdown");
          Log.Comment("TIN selected: 020619423 - Enrolled");
          break;
            }
         default:
         {
        	 System.out.print("------>User is--->"+System.getProperty("User"));
        	 if(System.getProperty("User").equalsIgnoreCase("P"))
        	 {
        		 
        		 System.out.println("*-------enterTinUPA 2");
        		 Element.waitForPresenceOfElementLocated(testConfig,By.xpath("//select[@id='taxIndNbrId']"), 20);
            	 Element.selectVisibleText(tinDrpDwn,paymentType+" - Enrolled","TIN Selection from Dropdown");
            	 System.out.println("*****enterTinUPA 3");
                
        	 }
        	 else if(System.getProperty("User").equalsIgnoreCase("BS") || System.getProperty("User").equalsIgnoreCase("PA"))
        	 {        		 
        		 Element.waitForPresenceOfElementLocated(testConfig,By.name("taxIdNbr"), 20);
        		 Element.enterData(txtTinnumber,paymentType, "Enter Tin as : " +paymentType, "Tin Textbox");
        		 Element.click(btnSearch, "Tin Search button");        		 
        		 
        	 }
        	
             
             break;
         }
		} 
        
      }

}