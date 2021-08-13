package main.java.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.DataBase.DatabaseType;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchTinPage {
	
	@FindBy(linkText="Manage Users")
	WebElement lnkManageUsers;
	
	@FindBy(id="userTypeSelection")
	WebElement drpDownUserType;
	
	@FindBy(id="payerdropdown")
	WebElement drpDownPayer;
	
	
//	@FindBy(id="taxNumber")
//	WebElement txtboxTinNo;
	
	
	@FindBy(xpath="//input[contains(@id,'taxNumber')]")
	List <WebElement> txtboxTinNo;
	
	@FindBy(name="btnSubmit")
	List <WebElement> btnSearch;

	@FindBy(name="taxIndNbr") 
	WebElement txtboxTin;
	
	@FindBy(xpath = "//input[@value='Search']") 
	WebElement btnSrch;
	
	private TestBase testConfig;
	public SearchTinPage(TestBase testConfig) 
	{
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		String expected = "viewProviderSearchTin.do";
		Element.expectedWait(drpDownUserType, testConfig, "Dropdown for selecting user Type", "Dropdown for selecting user Type");
		Helper.compareContains(testConfig, "URL", expected,testConfig.driver.getCurrentUrl());
		
	}
	
	public SearchTinPage selectUserType(String userType)
	{
		Element.selectByValue(drpDownUserType,userType, "User type as :" + " " + userType + " ");
		return this;
	}
	
	public ManageUsers doSearch(String userType)
	{
		int sqlRowNo;
		Map Searchedtin=null;
		String tin="";
		selectUserType(userType);
		
		switch(userType)
		{
		  case "PROV" :
		   {
			   if("Purged".equalsIgnoreCase(testConfig.getRunTimeProperty("Purged")))
			   {
				   sqlRowNo=260;
				   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
				   testConfig.putRunTimeProperty("portalUserID", Searchedtin.get("PORTAL_USER_ID").toString().trim());
			   }
			   else
			   {
				   sqlRowNo=15;
				   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   }
			   
			   tin=Searchedtin.get("PROV_TIN_NBR").toString().trim();
			   Element.enterDataByJS(testConfig, txtboxTinNo.get(0), tin, "txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(0), "Clicked search button");
			   break;
		   }
		   
		  case "BS" :
		   {
			   if("Purged".equalsIgnoreCase(testConfig.getRunTimeProperty("Purged")))
			   {
				   sqlRowNo=261;
				   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
				   testConfig.putRunTimeProperty("portalUserID", Searchedtin.get("PORTAL_USER_ID").toString().trim());
			   }
			   else
			   {
				   sqlRowNo=16;
				   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   }

			   tin=Searchedtin.get("PROV_TAX_ID_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(1), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(2), "Clicked search button");
			   break;
		   }
		   
		  case "PAY" :
		   {
			   sqlRowNo=17;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PAYR_DSPL_NM").toString().trim();
			   if("Purged".equalsIgnoreCase(testConfig.getRunTimeProperty("Purged")))
				   Element.selectByVisibleText(drpDownPayer, "UMR", "Payer as : UMR" );
			   else
				   Element.selectByVisibleText(drpDownPayer, tin, "Payer as :"+" " + tin );
			   Element.clickByJS(testConfig,btnSearch.get(1), "Clicked search button");
			   break;
		   }
		   
		    case "PROVPUTIN" :
		   {
			   sqlRowNo=258;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PROV_TIN_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(0), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(1), "Clicked search button");
			   break;
		   }
		   
		   default:
			   break;
		}
		
		testConfig.putRunTimeProperty("tin", tin);
		return new ManageUsers(testConfig);
	}
	
		public ManageUsers doSearchPUTIN(String userType)
	{
		int sqlRowNo;
		Map Searchedtin=null;
		String tin="";
		selectUserType(userType);
		//Element.selectByValue(drpDownUserType,userType, "User type as :" + " " + userType + " ");
		Element.selectByIndex(drpDownUserType, 1, "Provider User Type");
		 sqlRowNo=270;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PROV_TIN_NBR").toString().trim();
			   testConfig.putRunTimeProperty("Timestamp", Searchedtin.get("LST_CHG_BY_DTTM").toString().trim().substring(0,19));
			   testConfig.putRunTimeProperty("JobName", Searchedtin.get("LST_CHG_BY_ID").toString().trim());
			   testConfig.putRunTimeProperty("PurgedUser", Searchedtin.get("LST_NM").toString().trim()+", "+Searchedtin.get("FST_NM").toString().trim()+"   - Purged");
			 
			   Element.enterData(Element.findElement(testConfig, "css", "input#taxNumber"), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.enterData(txtboxTinNo.get(0), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			 //  Element.clickByJS(testConfig,btnSearch.get(1), "Clicked search button");
			
			   Element.click(  Element.findElement(testConfig, "xpath", "//input[@value='Search']"),"Search Button");
			   testConfig.putRunTimeProperty("tin", tin);
			   return new ManageUsers(testConfig);
	}
	
	public ManageUsers doSearch(String userType,String searchCriteria)
	{
		int sqlRowNo = 0;
		Map Searchedtin=null;
		String tin="";
		selectUserType(userType);
		
		switch(userType)
		{
		  case "PROV" :
		   {
			   if(searchCriteria.equalsIgnoreCase("Premium")||searchCriteria.equalsIgnoreCase("Standard")||searchCriteria.equalsIgnoreCase("Legacy"))
			       sqlRowNo=1605;
			   else
			   sqlRowNo=15;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   if(searchCriteria.equalsIgnoreCase("Premium")||searchCriteria.equalsIgnoreCase("Standard")||searchCriteria.equalsIgnoreCase("Legacy"))
			   tin=Searchedtin.get("PROV_TAX_ID_NBR").toString().trim();
			   else
			   tin=Searchedtin.get("PROV_TIN_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(0), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(0), "Clicked search button");
			   break;
		   }
		   
		  case "BS" :
		   {
			   sqlRowNo=16;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PROV_TAX_ID_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(1), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(2), "Clicked search button");
			   break;
		   }
		   
		  case "PAY" :
		   {
			   if(searchCriteria.equalsIgnoreCase("PurgedUsers"))
			       sqlRowNo=409;
			   else if(searchCriteria.equalsIgnoreCase("NoPurgedUsers"))
				   sqlRowNo=410;
			   
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PAYR_DSPL_NM").toString().trim();
			   Element.selectByVisibleText(drpDownPayer, tin, "Payer as :"+" " + tin );
			   Element.clickByJS(testConfig,btnSearch.get(1), "Clicked search button");
			   break;
		   }
		   
		   default:
			   break;
		}
		
		testConfig.putRunTimeProperty("tin", tin);
		return new ManageUsers(testConfig);
	}
	
	
	
	
	
	public String enterTin(String typeOfTin)
	{
		List<String> userAndTinDetails=getTinAndUserDetails(typeOfTin);
		if(typeOfTin.contentEquals("tinwithTermAndConditionBS"))
			Element.enterData(txtboxTinNo.get(1),userAndTinDetails.get(0),"Enter tin number as : " + userAndTinDetails.get(0) , "txtboxTinNo");
		else
			//Element.enterData(txtboxTinNo.get(0),userAndTinDetails.get(0),"Enter tin number as : " + userAndTinDetails.get(0) , "txtboxTinNo");
		     Element.enterDataByJS(testConfig,txtboxTinNo.get(0),userAndTinDetails.get(0),"Enter tin number as : " + userAndTinDetails.get(0));
		testConfig.putRunTimeProperty("username", userAndTinDetails.get(1));
		return userAndTinDetails.get(0);
	}
	
	public List<String> getTinAndUserDetails(String typeOfTin)
	{
		Map tinDetails=null;
		int sqlRow;
		List<String> userAndTinDetails=new ArrayList<String>();
		Map portalUserDetails=null;

		switch(typeOfTin)
		{
		   case "tinWithOneActiveAdmin" :
		   {
			  sqlRow=254;
			  tinDetails=DataBase.executeSelectQuery(testConfig,sqlRow, 1);
			  Log.Comment("Fetched a tin that has only One Active Admin and it is : "+ tinDetails.get("PROV_TIN_NBR").toString());
			  break;
		    }
		   
		   case "tinWithMoreThanOneActiveAdmin" :
		   {
			  sqlRow=256;
			  tinDetails=DataBase.executeSelectQuery(testConfig,sqlRow, 1);
			  Log.Comment("Fetched a tin that has only 2 Active Admins and it is : "+ tinDetails.get("PROV_TIN_NBR").toString());
			  break;
		    }
			  
		   case "tinwithTermAndConditionProv":
			  sqlRow=1501;
			  tinDetails=DataBase.executeSelectQuery(testConfig,sqlRow, 1);
			  testConfig.putRunTimeProperty("portalUserID", tinDetails.get("PORTAL_USER_ID").toString());
			  Log.Comment("Fetched a tin : "+ tinDetails.get("PROV_TIN_NBR").toString());
			  break;
		   case "tinwithTermAndConditionBS":
			  sqlRow=1502;
			  tinDetails=DataBase.executeSelectQuery(testConfig,sqlRow, 1);
			  testConfig.putRunTimeProperty("portalUserID", tinDetails.get("PORTAL_USER_ID").toString());
			  Log.Comment("Fetched a tin : "+ tinDetails.get("IDENTIFIER_NBR").toString());
			  break;
		   default :
			   Log.Comment("No Search criteria defined");
		   
		}
		if(typeOfTin.equals("tinwithTermAndConditionBS"))
		{
			userAndTinDetails.add(tinDetails.get("IDENTIFIER_NBR").toString());
			testConfig.putRunTimeProperty("tin", tinDetails.get("IDENTIFIER_NBR").toString());
		}
		else
		{
			userAndTinDetails.add(tinDetails.get("PROV_TIN_NBR").toString());
			testConfig.putRunTimeProperty("tin", tinDetails.get("PROV_TIN_NBR").toString());
		}
		if(typeOfTin.contains("OneActiveAdmin")){
		sqlRow=255;
		portalUserDetails=DataBase.executeSelectQuery(testConfig,sqlRow, 1);
		userAndTinDetails.add(portalUserDetails.get("LST_NM").toString().toUpperCase() + "," +" " + portalUserDetails.get("FST_NM").toString().toUpperCase());
		}
		else
			userAndTinDetails.add(tinDetails.get("FULLNAME").toString().toUpperCase());
		return userAndTinDetails;
	}
	
	public ManageUsers clickSearch()
	{
		Element.clickByJS(testConfig,btnSearch.get(0), "Clicked search button");
		return new ManageUsers(testConfig);
	}
	
	public ManageUsers clickSearch(String userType)
	{
		if(userType.equals("PROV"))
			Element.clickByJS(testConfig,btnSearch.get(0), "Clicked search button");
		else if(userType.equals("BS"))
			Element.clickByJS(testConfig,btnSearch.get(2), "Clicked search button");
		return new ManageUsers(testConfig);
	}

	public SearchTinPage searchToDelete(String userType) {
		
		if(userType.equalsIgnoreCase("PROV"))
			Element.enterDataByJS(testConfig,txtboxTinNo.get(0), testConfig.getRunTimeProperty("tin"),"Enter tin number as :" + " " + testConfig.getRunTimeProperty("tin"));
		else if(userType.equalsIgnoreCase("BS"))
			Element.enterDataByJS(testConfig,txtboxTinNo.get(1), testConfig.getRunTimeProperty("tin"),"Enter tin number as :" + " " + testConfig.getRunTimeProperty("tin"));	
		return this;
	}

	public SearchTinPage searchToEditBS() {
		int sqlRow=1119;
		Map tinDetails=DataBase.executeSelectQuery(testConfig,sqlRow, 1);
		testConfig.putRunTimeProperty("tin", tinDetails.get("IDENTIFIER_NBR").toString());
		Element.enterDataByJS(testConfig,txtboxTinNo.get(1),tinDetails.get("IDENTIFIER_NBR").toString(),"Enter tin number as :" + " " + tinDetails.get("IDENTIFIER_NBR").toString());
		String x=tinDetails.get("BILLING_SERVICE_ID").toString();
				testConfig.putRunTimeProperty("billing_service_id", tinDetails.get("BILLING_SERVICE_ID").toString());
		return this;
	}
	public void enterFetchedTIN(String userType){

		switch(userType){
	        case "BS":
	        {   
			   Element.selectByVisibleText(drpDownUserType, "Billing Service", "Billing Service dropdown");
			   Element.clickByJS(testConfig,txtboxTin, "Enter TIN");
			   Element.enterDataByJS(testConfig, txtboxTin, System.getProperty("tin"), "Enter TIN for BS");
			   Browser.wait(testConfig, 2);
			   Element.clickByJS(testConfig,btnSrch, "Click Search Button");
			   Browser.waitForPageLoad(testConfig.driver);
	  	       break;
	        }  
	       case "PROV":
	       {
			   Element.selectByVisibleText(drpDownUserType, "Provider", "Provider dropdown");
			   Element.click(txtboxTin, "Enter TIN");
			   Element.enterData(txtboxTin, System.getProperty("tin"), "Enter TIN for PROV", "Enter PROV TIN in CSR");
			   Element.click(btnSrch, "Click Search Button");

	  	       break;
	        }
		 }
	}
	
}
