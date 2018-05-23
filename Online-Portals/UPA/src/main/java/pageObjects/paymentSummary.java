package main.java.pageObjects;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import main.java.Utils.Helper;
import main.java.api.manage.EpsPaymentsSearch.EpsPaymentSearchRequestHelper;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.api.pojo.epspaymentsearch.request.SearchByCriteriaRequest;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

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
	
	@FindBy(xpath="//td[@class='errors']")
	WebElement errorMsg;
			
	
	private TestBase testConfig;
	public ValidateEnrollmentTypePage validateEnrollmentType;
	
	@FindBy(id="taxIndNbrId")
	WebElement drpDwnTin;
	
	@FindBy(xpath="//td[contains(text(),'Record Count')]")
	WebElement recordCount;
	
	public paymentSummary(TestBase testConfig)
	{
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.verifyElementPresent(drpDwnQuickSearch,"Quick Search dropdown");
	}

	/* Verifies the default selected 
	 * filter dropdown values 
	 */
	
	public paymentSummary verifyDefaultSearchResultCount() throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{   
		int i=0;
		String expectedSelectedOption="Show All";
		Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption, Element.getFirstSelectedOption(testConfig, drpDwnFilterPayments,"text"));
		Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption, Element.getFirstSelectedOption(testConfig, drpDwnMarketType,"text"));
		
		expectedSelectedOption="Active Only";
		Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption, Element.getFirstSelectedOption(testConfig, drpDwnArchiveFilter,"text"));
		
		//Verify all options are displayed in Quick search Filter dropdown
		
		List <String> quickSearchOptions=Element.getAllOptionsInSelect(testConfig, drpDwnQuickSearch);
		String [] expectedOptions= {"Last 30 days","Last 60 days","Last 90 days","Last 4-6 months","Last 6-9 months","Last 9-13 months"};
		for (String option:quickSearchOptions){
			Helper.compareEquals(testConfig, "dropdown option" + " " + i,expectedOptions[i], option);
			i++;
		}
		
		//Verify by default quick search is set to last 30 days
		expectedSelectedOption="Last 30 days";
		Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption, Element.getFirstSelectedOption(testConfig, drpDwnQuickSearch,"text"));
		
		getQuickSearchDates(testConfig, expectedSelectedOption);
		verifyDefaultSearchRecordCount();
		return this;
	}
	
	/*
	 * By default record count should be the number 
	 * of payments for last 30 days
	 */
	public void verifyDefaultSearchRecordCount() throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		if(!getRecordCountFromFISL().equalsIgnoreCase("0"))
			Helper.compareEquals(testConfig, "Record count from FISL and UI where FISL : ", getRecordCountFromFISL(), getRecordCountFromUI());
			else
			 Element.verifyTextPresent(errorMsg,"No payments have been made to this Organization.");
	}
		
	/*
	 * Selecting all the required filters
	 * from respective dropdowns
	 * @param filterPayments,quickSearchFilter,Archivefilter,MktTypeFilter
	 */
	
	
	public void setSearchFilters(String filterPayments,String quickSearchFilter,String Archivefilter,String MktTypeFilter)
	{
		Element.selectByVisibleText(drpDwnFilterPayments,filterPayments,filterPayments + " " +" from Filter payments dropdown");
		Browser.waitForLoad(testConfig.driver);
		
		Element.selectByVisibleText(drpDwnArchiveFilter,Archivefilter, Archivefilter + " " +" from Archive payments dropdown");
		Browser.waitForLoad(testConfig.driver);
		
		Element.selectByVisibleText(drpDwnQuickSearch,quickSearchFilter,quickSearchFilter + " " +" from Quick Search dropdown");
		Browser.waitForLoad(testConfig.driver);
		
		Element.selectByVisibleText(drpDwnMarketType,MktTypeFilter,MktTypeFilter + " " +" from Market Type dropdown");		
	}
			
	/*
	 * Finds to and from date according to the quick search filter selected
	 * @param quick search dropdown value
	 */
	
	public paymentSummary getQuickSearchDates(TestBase testConfig,String quickSearchFilter) 
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
		
		//for months filter
		else {
			String monthRange[]=split[split.length-2].split("-");
			int toMonth=Integer.parseInt(monthRange[0]);
			toMonth=toMonth-1;
			int fromMonth=Integer.parseInt(monthRange[monthRange.length-1]);
			testConfig.putRunTimeProperty("fromDate",Helper.getDateBeforeOrAfterMonths(-fromMonth,"yyyy-MM-dd"));
			testConfig.putRunTimeProperty("toDate",Helper.getDateBeforeOrAfterMonths(-toMonth,"yyyy-MM-dd"));
			}	
		return this;
	}	

	public String getRecordCountFromUI()
	{
		try
		{
			String recordCountElement[]=recordCount.getText().split(":");
			return recordCountElement[recordCountElement.length-1].trim();
		}
		
		catch(Exception e)
		{
			Log.Fail("Exception occured : " + e);
			return null;
		}
	    
	}
	
	
	/*
	 * Select all filters, takes arguments
	 * @filterPayments,quickSearchFilter,Archivefilter & MktTypeFilter
	 * Gets the record count from UI and fISL api and compares them.
	 */
	
	
	public void verifySearchResultsWithFilters(String filterPayments,String quickSearchFilter,String Archivefilter,String MktTypeFilter) throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException
	{
		int sqlRowNo=5;
		
		setSearchFilters(filterPayments,quickSearchFilter,Archivefilter,MktTypeFilter);
		
		getQuickSearchDates(testConfig, quickSearchFilter);
	
		//Verifies Record count displayed on UI is same as we get from FISL API
		
		if(!getRecordCountFromFISL().equalsIgnoreCase("0"))
		Helper.compareEquals(testConfig, "Record Count from FISL and UI :",getRecordCountFromFISL(),getRecordCountFromUI());
		else
		 Element.verifyTextPresent(errorMsg,"No payments have been made to this Organization.");

		//Verifies count of records from DB and FISL API->Get query from Prashant and uncomment these lines
//		Map srchConsolTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
//		Helper.compareEquals(testConfig,"Number of records in view payments", srchConsolTable.get("RECORD_COUNT").toString(), getRecordCountFromFISL());
}
	
	/*
	 * Getting response from EPSA
	 * @return type object of search request
	 */
	
	public Object getFISLResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		EpsPaymentSearchRequestHelper epsPaymentSearchRequestHelper = new EpsPaymentSearchRequestHelper();
		
		//Creates POJO for Request.xml so that we can modify the elements
		EpsPaymentsSearchRequest epsPaymentsSearchRequest=(EpsPaymentsSearchRequest) createRequest();
		epsPaymentsSearchRequest=setTinNumber(epsPaymentsSearchRequest);
		setToAndFromDate(epsPaymentsSearchRequest);
		setTaxIdentifierType(epsPaymentsSearchRequest);
		
    	
		//Posting the modified request and getting response
		EpsPaymentsSummarySearchResponse searchResponse=(EpsPaymentsSummarySearchResponse) epsPaymentSearchRequestHelper.postRequestGetResponse(epsPaymentsSearchRequest);
		
		return searchResponse;
	}
	
	
	public Object createRequest() throws JAXBException
	{
	   EpsPaymentSearchRequestHelper epsPaymentSearchRequestHelper = new EpsPaymentSearchRequestHelper();
	   EpsPaymentsSearchRequest epsPaymentsSearchRequest=epsPaymentSearchRequestHelper.createRequestPojo();
	   return epsPaymentsSearchRequest;
		
	}
	
	public String getRecordCountFromFISL() throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		EpsPaymentsSummarySearchResponse responseFromFISL=(EpsPaymentsSummarySearchResponse) getFISLResponse();
		return responseFromFISL.getResponseReturnStatus().getTotalCount().trim(); 
	}
	
	
	public EpsPaymentsSearchRequest setTinNumber(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		testConfig.putRunTimeProperty("tin","109884928");
	   ((EpsPaymentsSearchRequest) object).setTaxIdentifierNumber(testConfig.getRunTimeProperty("tin").trim());	
		return (EpsPaymentsSearchRequest) object;
	}
	
	public EpsPaymentsSearchRequest setToAndFromDate(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		((EpsPaymentsSearchRequest) object).getPaymentMadeOnDateRange().setFromDate(testConfig.getRunTimeProperty("fromDate"));
		((EpsPaymentsSearchRequest) object).getPaymentMadeOnDateRange().setToDate(testConfig.getRunTimeProperty("toDate"));
		return (EpsPaymentsSearchRequest) object;
	}
	
	
	public EpsPaymentsSearchRequest setTaxIdentifierType(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0).setValue(testConfig.getRunTimeProperty("taxIdentifierType"));
		return (EpsPaymentsSearchRequest) object;
	}
	
}


