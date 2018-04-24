package main.java.pageObjects;

import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.DataBase.DatabaseType;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

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
		Helper.compareContains(testConfig, "URL", expected,testConfig.driver.getCurrentUrl());
		
	}
	
	public void selectUserType(String userType)
	{
		Element.selectByValue(drpDownUserType,userType, "Select User type as :" + " " + userType);
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
			   Element.click(btnSearch.get(0), "Clicked search button");
			   break;
		   }
		   
		  case "BS" :
		   {
			   sqlRowNo=16;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("IDENTIFIER_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(1), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.click(btnSearch.get(2), "Clicked search button");
			   break;
		   }
		   
		  case "PAY" :
		   {
			   sqlRowNo=17;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PAYR_DSPL_NM").toString().trim();
			   Element.selectByVisibleText(drpDownPayer, tin, "Payer as :"+" " + tin );
			   Element.click(btnSearch.get(1), "Clicked search button");
			   break;
		   }
		   
		   default:
			   break;
		}
		
		testConfig.putRunTimeProperty("tin", tin);
		return new ManageUsers(testConfig);
	}
	
}
