package main.java.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase.DatabaseType;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.reporting.LogTemp;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;

public class paymentSummary {
	
	
	@FindBy(id="periodId")
	WebElement drpDwnQuickSearch;
	
	@FindBy(id="mktTypeId")
	WebElement drpDwnMarketType;
	
	
	@FindBy(name="filterPayments")
	WebElement drpDwnFilterPayments;
	
	@FindBy(id="archiveFilterType")
	WebElement drpDwnArchiveFilter;
	
	@FindBy(css="#paymentsummaryform>table>tbody>tr>td>table>tbody")
	WebElement divSearchResults;
	
	private main.java.nativeFunctions.TestBase testConfig;
	public ValidateEnrollmentTypePage validateEnrollmentType;
	
	@FindBy(id="taxIndNbrId")
	WebElement drpDwnTin;
	
	@FindBy(xpath="//td[contains(text(),'Record Count')]")
	WebElement recordCount;
	
	public paymentSummary(main.java.nativeFunctions.TestBase testConfig)
	{
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		main.java.nativeFunctions.Element.verifyElementPresent(drpDwnQuickSearch,"Quick Search dropdown");
	}

	public paymentSummary verifyDefaultStateOfFilters()
	{   
		
		String expectedSelectedOption="Show All";
		main.java.Utils.Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption, main.java.nativeFunctions.Element.getFirstSelectedOption(testConfig, drpDwnFilterPayments,"text"));
		main.java.Utils.Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption, main.java.nativeFunctions.Element.getFirstSelectedOption(testConfig, drpDwnMarketType,"text"));
		
		expectedSelectedOption="Last 30 days";
		main.java.Utils.Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption, main.java.nativeFunctions.Element.getFirstSelectedOption(testConfig, drpDwnQuickSearch,"text"));
		
		expectedSelectedOption="Active Only";
		main.java.Utils.Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption, main.java.nativeFunctions.Element.getFirstSelectedOption(testConfig, drpDwnArchiveFilter,"text"));
		main.java.nativeFunctions.Element.selectByVisibleText(drpDwnArchiveFilter, "Archived Only", "Archived Only Payments");
		main.java.nativeFunctions.Element.verifyElementPresent(divSearchResults, "Search Results div");
		
		String tin=main.java.nativeFunctions.Element.getFirstSelectedOption(testConfig, drpDwnTin,"value");
		testConfig.putRunTimeProperty("tin", tin);
		
		List <String> quickSearchOptions=main.java.nativeFunctions.Element.getAllOptionsInSelect(testConfig, drpDwnQuickSearch);
		
		String [] expectedOptions= {"Last 30 days","Last 60 days","Last 90 days","Last 4-6 months","Last 6-9 months","Last 9-13 months"};
		int i=0;
		
		for (String option:quickSearchOptions)
		{    
			main.java.Utils.Helper.compareEquals(testConfig, "dropdown option" + " " + i,expectedOptions[i], option);
			i++;
		}
		return new paymentSummary(testConfig);
			
	}
	
	public void verifySearchResultsWithFilters(String filterPayments,String quickSearchFilter,String Archivefilter,String MktTypeFilter) throws IOException, InterruptedException
	{
		main.java.nativeFunctions.Element.selectByVisibleText(drpDwnFilterPayments,filterPayments, "Select" + " " + filterPayments);
		main.java.nativeFunctions.Browser.wait(testConfig, 5);
		main.java.nativeFunctions.Element.selectByVisibleText(drpDwnArchiveFilter,Archivefilter, "Select" + " " + Archivefilter);
		main.java.nativeFunctions.Browser.wait(testConfig, 5);
		main.java.nativeFunctions.Element.selectByVisibleText(drpDwnQuickSearch,quickSearchFilter, "Select" + " " + quickSearchFilter);
		main.java.nativeFunctions.Browser.wait(testConfig, 5);
		main.java.nativeFunctions.Element.selectByVisibleText(drpDwnMarketType,MktTypeFilter, "Select" + " " + MktTypeFilter);
		
		setQuickSearchDateInQuery(quickSearchFilter);
	
		int sqlRowNo=5;
	
		//Verifies count of records displayed in view payments tab from DB
		Map srchConsolTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		if (!(srchConsolTable.get("RECORD_COUNT").toString().contains("0")))
		{
		  String recordCountElement[]=recordCount.getText().split(":");
		  String actualCount=recordCountElement[recordCountElement.length-1];
		 Helper.compareEquals(testConfig,"Number of records in view payments", srchConsolTable.get("RECORD_COUNT").toString(), actualCount.trim());
		}
		else 
		{
			Element.verifyElementNotPresent("xpath", "//td[contains(text(),'Record Count')]", "Record Count");
		}
			
	}
	
	
	public void setQuickSearchDateInQuery(String quickSearchFilter)
	{
		//split quick search filter string by space
		String split[]=quickSearchFilter.split(" ");
		
		//if it contains days then convert the number of days into int 
		if(split[split.length-1].contains("days"))
		{
			int LastNoOfdays=Integer.parseInt(split[split.length-2]);
			
			testConfig.putRunTimeProperty("fromDate",Helper.getDateBeforeOrAfterDays(-LastNoOfdays,"yyyy-MM-dd"));
			testConfig.putRunTimeProperty("toDate",Helper.getCurrentDate("yyyy-MM-dd"));	
			
		}
		
		else {
			
			String monthRange[]=split[split.length-2].split("-");
			int toMonth=Integer.parseInt(monthRange[0]);
			toMonth=toMonth-1;
			int fromMonth=Integer.parseInt(monthRange[monthRange.length-1]);
			testConfig.putRunTimeProperty("fromDate",Helper.getDateBeforeOrAfterMonths(-fromMonth,"yyyy-MM-dd"));
			testConfig.putRunTimeProperty("toDate",Helper.getDateBeforeOrAfterMonths(-toMonth,"yyyy-MM-dd"));
			String a=testConfig.getRunTimeProperty("toDate");
			System.out.println(a);
			
		}
		
		
	}
	
}


