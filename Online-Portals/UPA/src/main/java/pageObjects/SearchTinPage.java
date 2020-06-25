package main.java.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.DataBase.DatabaseType;
import main.java.Utils.Helper;
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

	private TestBase testConfig;
	SearchTinPage(TestBase testConfig) 
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
			   sqlRowNo=15;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PROV_TIN_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(0), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(0), "Clicked search button");
			   break;
		   }
		   
		  case "BS" :
		   {
			   sqlRowNo=16;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("IDENTIFIER_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(1), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(2), "Clicked search button");
			   break;
		   }
		   
		  case "PAY" :
		   {
			   sqlRowNo=17;
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
			   sqlRowNo=15;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PROV_TIN_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(0), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(0), "Clicked search button");
			   break;
		   }
		   
		  case "BS" :
		   {
			   sqlRowNo=16;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("IDENTIFIER_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(1), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(2), "Clicked search button");
			   break;
		   }
		   
		  case "PAY" :
		   {
			   if(searchCriteria.equalsIgnoreCase("PurgedUsers"))
			       sqlRowNo=250;
			   else if(searchCriteria.equalsIgnoreCase("NoPurgedUsers"))
				   sqlRowNo=251;
			   
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
		Element.enterData(txtboxTinNo.get(0),userAndTinDetails.get(0),"Enter tin number as : " + userAndTinDetails.get(0) , "txtboxTinNo");
		testConfig.putRunTimeProperty("username", userAndTinDetails.get(1));
		return userAndTinDetails.get(0);
	}
	
	public List<String> getTinAndUserDetails(String typeOfTin)
	{
		Map tinDetails=null;
		int sqlRow;
		List<String> userAndTinDetails=new ArrayList<String>();
		switch(typeOfTin)
		{
		   case "tinWithOneActiveAdmin" :
		   {
			  sqlRow=163;
			  tinDetails=DataBase.executeSelectQuery(testConfig,sqlRow, 1);
			  Log.Comment("Fetched a tin that has only One Active Admin and it is : "+ tinDetails.get("PROV_TIN_NBR").toString());
			  break;
		    }
		   
		   case "tinWithMoreThanOneActiveAdmin" :
		   {
			  sqlRow=164;
			  tinDetails=DataBase.executeSelectQuery(testConfig,sqlRow, 1);
			  Log.Comment("Fetched a tin that has only 2 Active Admins and it is : "+ tinDetails.get("PROV_TIN_NBR").toString());
			  break;
		    }
			  
		   default :
			   Log.Comment("No Search criteria defined");
		   
		}
		
		userAndTinDetails.add(tinDetails.get("PROV_TIN_NBR").toString());
		userAndTinDetails.add(tinDetails.get("LST_NM").toString().toUpperCase() + "," +" " + tinDetails.get("FST_NM").toString().toUpperCase());
		return userAndTinDetails;
	}
	
	public ManageUsers clickSearch()
	{
		Element.clickByJS(testConfig,btnSearch.get(0), "Clicked search button");
		return new ManageUsers(testConfig);
	}
	
}
