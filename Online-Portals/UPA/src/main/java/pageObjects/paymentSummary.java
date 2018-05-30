package main.java.pageObjects;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.api.manage.EpsPaymentsSearch.EpsPaymentSearchRequestHelper;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.api.pojo.epspaymentsearch.request.SearchByCriteriaRequest;
import main.java.api.pojo.epspaymentsearch.response.EpsConsolidatedClaimPaymentSummaries;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

public class paymentSummary{
	
	
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
	
	@FindBy(xpath=".//*[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr")
	List<WebElement> searchResultRows;
	
	@FindBy(xpath="//td[@class='errors']")
	WebElement errorMsg;
	
	@FindBy(id="taxIndNbrId")
	WebElement drpDwnTin;
	
	@FindBy(xpath="//td[contains(text(),'Record Count')]")
	WebElement recordCount;
	
	private TestBase testConfig;
	public ValidateEnrollmentTypePage validateEnrollmentType;
	
	public paymentSummary(TestBase testConfig)
	{
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.verifyElementPresent(drpDwnQuickSearch,"Quick Search dropdown");
	}

	/** Verifies the default selected 
	 * filter dropdown values 
	 * @return object of this page
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
		
		getQuickSearchDates(expectedSelectedOption);
		verifyDefaultSearchRecordCount();
		return this;
	}
	
	/**
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
		
	/**
	 * Selecting all the required filters
	 * from respective dropdowns
	 * @param filterPayments,quickSearchFilter,Archivefilter,MktTypeFilter
	 */
	
	
	public void setSearchFilters(String filterPayments,String quickSearchFilter,String Archivefilter,String MktTypeFilter)
	{
		Element.selectByVisibleText(drpDwnFilterPayments,filterPayments,filterPayments + " " +" from 'Filter payments' dropdown");
		Browser.waitForLoad(testConfig.driver);
		
		Element.selectByVisibleText(drpDwnArchiveFilter,Archivefilter, Archivefilter + " " +" from 'Archive payments' dropdown");
		Browser.waitForLoad(testConfig.driver);
		
		Element.selectByVisibleText(drpDwnQuickSearch,quickSearchFilter,quickSearchFilter + " " +" from 'Quick Search' dropdown");
		Browser.waitForLoad(testConfig.driver);
		
		Element.selectByVisibleText(drpDwnMarketType,MktTypeFilter,MktTypeFilter + " " +" from 'Market Type' dropdown");		
	}
			
	/**
	 * Finds to and from date according to the quick search filter selected
	 * @param quick search dropdown value
	 * @return payment summary page
	 */
	
	public paymentSummary getQuickSearchDates(String quickSearchFilter) 
	{
	    String split[]=quickSearchFilter.split(" "); 
		if(split[split.length-1].contains("days"))
		{
			int LastNoOfdays=Integer.parseInt(split[split.length-2]);
			testConfig.putRunTimeProperty("fromDate",Helper.getDateBeforeOrAfterDays(-LastNoOfdays,"yyyy-MM-dd"));
			testConfig.putRunTimeProperty("toDate",Helper.getCurrentDate("yyyy-MM-dd"));	
		}
		
		else 
		{
			String monthRange=(split[split.length-2]);
			Map<String, String> startAndEndDates = Helper.getStartAndEndPeriod(monthRange);
			testConfig.putRunTimeProperty("fromDate",startAndEndDates.get("fromDate").toString());
			testConfig.putRunTimeProperty("toDate",startAndEndDates.get("toDate").toString());

		}	
		return this;
	}	

	/**
	 * gets the record count
	 * @return number of payments
	 */
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
	
	/**
	 * This function creates an outer map 
	 * with Key as payment number
	 * and  Value as another hash map i.e. inner map
	 * that contains all the details for key 
	 * like payer name, amount etc
	 * @return Outer map
	 */
	
	public Map<String,LinkedHashMap<String,String>> getPaymentNumberDetailsFromUI()
	{	   
	   /**Gets headers List which will be key for following map*/
		
	   ArrayList<String> headers=getHeadersFromResultTable();
	   LinkedHashMap<String,String> innerMap;
	   Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	   List <String> paymentNo=getPaymentNumbers();
		
		for(int i=1;i<searchResultRows.size();i++)
		  {
			innerMap=new LinkedHashMap<String,String>();
			for(int j=0;j<headers.size();j++)
			 {	
			   String details=searchResultRows.get(i).findElements(By.tagName("td")).get(j).getText();
			   details=details.replace("\n", "");
			   innerMap.put(headers.get(j), details);										
			 }
			String amount=innerMap.get("Amount").replace(",", "");
			innerMap.put("Amount", amount);
			innerMap.remove("Redemption Date");
			innerMap.remove("Payment Status / Trace Number");
			outerMap.put(paymentNo.get(i-1), innerMap);
		  }
		Log.Comment("Details from UI is : " +'\n' +outerMap);
		return outerMap;
	   
    }
	
	/**
	 * finds all the payment numbers from UI and users them as a key
	 * for next function
	 * @return payment numbers
	 */
	
	public ArrayList<String> getPaymentNumbers()
	{
		ArrayList<String> paymentNoList=new ArrayList<String>();
		for(int i=1;i<searchResultRows.size();i++)
		{
			String details=searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
			details=details.replace("\n", "");
			paymentNoList.add(details);	
		}
	 return paymentNoList;
	}
	
	
	/**
	 * Get Headers List till Market Type
	 * to store them as key in map
	 * @return HeaderList
	 */
	public ArrayList<String> getHeadersFromResultTable()
	{
	   List <String> headerList=new ArrayList<String>();
	   for (int i=0;i<10;i++)
	   {
	     String header=searchResultRows.get(0).findElements(By.tagName("th")).get(i).getText();
	     headerList.add(header);
		}
	return (ArrayList<String>) headerList;
	   
}
	    
		
	
	/**
	 * Select all filters, takes arguments
	 * @param filterPayments,quickSearchFilter,Archivefilter & MktTypeFilter
	 * Gets the record count from UI and fISL api and compares them.
	 * @throws ParseException 
	 */
	
	
	public void verifySearchResultsWithFilters(String filterPayments,String quickSearchFilter,String Archivefilter,String MktTypeFilter) throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		int sqlRowNo=5;
		
		/**Select all filters*/
		
		setSearchFilters(filterPayments,quickSearchFilter,Archivefilter,MktTypeFilter);
		getQuickSearchDates(quickSearchFilter);
	
		/**Verifies Record count displayed on UI is same as we get from FISL API*/
		
		
		if(!getRecordCountFromFISL().equalsIgnoreCase("0"))
		{
		  Helper.compareMaps(testConfig, "Payments Details Comparison from FISL and API : " + '\n',getPaymentNumbersFromFISL(), getPaymentNumberDetailsFromUI());			
		  Helper.compareEquals(testConfig, "Record Count from FISL and UI :",getRecordCountFromFISL(),getRecordCountFromUI());
		}
		else
		 Element.verifyTextPresent(errorMsg,"No payments have been made to this Organization.");

		//Verifies count of records from DB and FISL API->Get query from Prashant and uncomment these lines
//		Map srchConsolTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
//		Helper.compareEquals(testConfig,"Number of records in view payments", srchConsolTable.get("RECORD_COUNT").toString(), getRecordCountFromFISL());
}
	
	/**
	 * Getting response from EPSA
	 * @return type object of search request
	 */
	
	public Object getFISLResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		EpsPaymentSearchRequestHelper epsPaymentSearchRequestHelper = new EpsPaymentSearchRequestHelper();
		
		/**Creates POJO for Request.xml so that we can modify the elements*/
		
		EpsPaymentsSearchRequest epsPaymentsSearchRequest=(EpsPaymentsSearchRequest) createRequest();
		epsPaymentsSearchRequest=setTinNumber(epsPaymentsSearchRequest);
		setToAndFromDate(epsPaymentsSearchRequest);
		setTaxIdentifierType(epsPaymentsSearchRequest);
		
    	
		/**Posting the modified request and getting response*/
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
	
	public Map<String, LinkedHashMap<String, String>> getPaymentNumbersFromFISL() throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{

		LinkedHashMap<String,String> innerMap;
		Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
		EpsPaymentsSummarySearchResponse responseFromFISL=(EpsPaymentsSummarySearchResponse) getFISLResponse();
		EpsConsolidatedClaimPaymentSummaries[] payments=responseFromFISL.getEpsConsolidatedClaimPaymentSummaries();
			
		for(int i=0;i<payments.length;i++)
		{
			innerMap=new LinkedHashMap<String, String>();
			
			innerMap.put("Payer",getDisplayPayerNameFromDB(payments[i].getPayerSummary().getName()));
			innerMap.put("Payment Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getPaymentMadeOn(),"yyyy-dd-mm", "dd-mm-yyyy")));
			innerMap.put("NPI",payments[i].getNationalProviderIdentifier());
			innerMap.put("Payment Number",payments[i].getDisplayConsolidatedPaymentNumber());
			innerMap.put("Proxy Number","");
			innerMap.put("Amount","$"+payments[i].getTotalAmount());
			innerMap.put("Type",getDisplayPaymentMethod(payments[i].getPayeePaymentMethod().getPaymentMethodCode().getCode()));
			innerMap.put("Market Type",getDisplayMarketType(payments[i].getPaymentTypeIndicator()));
			outerMap.put(innerMap.get("Payment Number"), innerMap);
		}
		Log.Comment("Details from FISL is :"  + '\n' +outerMap);
		return outerMap;
	}
	
	/**
	 * Gets the payer name from DB
	 * to be displayed on UI
	 * @param payerName
	 * @return display payername
	 */
	
	public String getDisplayPayerNameFromDB(String payerNameFromFISL)
	{
		int sqlRowNo=20;
		testConfig.putRunTimeProperty("payerName", payerNameFromFISL);
		Map payerTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		return payerTable.get("PAYR_DSPL_NM").toString().trim();	
	}
	
	/**
	 * Converts Market Type From API to 
	 * name that is displayed on UI
	 * @param maketTypeFromFISL
	 * @return maketType to be displayed
	 */
	public String getDisplayMarketType(String maketTypeFromFISL)
	{
		if (maketTypeFromFISL.equalsIgnoreCase("M"))
		{
			return "Medical";
		}
		
		else
			return "Unidentified";
			
	}
	
	/**
	 * Converts  Type From API to 
	 * name that is displayed on UI
	 * @param paymentMethodTypefromFISL
	 * @return payment method to be displayed
	 */
	public String getDisplayPaymentMethod(String paymentMethodTypefromFISL)
	{
		if (paymentMethodTypefromFISL.equalsIgnoreCase("NON") || paymentMethodTypefromFISL.equalsIgnoreCase("ACH"))
		{
			return "ACH";
		}
		
		else
			return "Unidentified";
			
	}
	
	
	public EpsPaymentsSearchRequest setTinNumber(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
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


