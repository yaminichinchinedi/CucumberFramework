package main.java.pageObjects;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import main.java.Utils.Helper;
import main.java.api.manage.EpsPaymentsSearch.EpsPaymentSearchRequestHelper;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.api.pojo.epspaymentsearch.request.SearchByCriteriaRequest;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class SearchRemittance extends TestBase {
	
	@FindBy(xpath="//td[@class='errors']")
	WebElement errorMsg;
	
	@FindBy(xpath="//td[contains(text(),'Record Count')]")
	WebElement recordCount;
	
	

	public SearchRemittance(TestBase testConfig)
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);

	}
	
	
	
	public void verifySearchResults() throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		System.out.println("Inside Verify Search Results");
		//Verifies Record count displayed on UI is same as we get from FISL		
		if(!getRecordCountFromFISL().equalsIgnoreCase("0"))
		 {
			System.out.println("Inside IF");
			
			Helper.compareEquals(testConfig, "Record Count from FISL and UI :",getRecordCountFromFISL(),getRecordCountFromUI());
			//Helper.compareMaps(testConfig, "Payments Details Comparison from FISL and UI : " + "<br>",getPaymentDetailsFromFISL(), getPaymentDetailsFromUI());			  
		 }
		else
		 Element.verifyTextPresent(errorMsg,"No payments have been made to this Organization.");
//		 Helper.compareEquals(testConfig, "Record Count from FISL and DB :",getRecordCountFromFISL(),getRecordCountFromDB());
     }
	
	public String getRecordCountFromFISL() throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		EpsPaymentsSummarySearchResponse responseFromFISL=(EpsPaymentsSummarySearchResponse) getFISLResponse();
		return responseFromFISL.getResponseReturnStatus().getTotalCount().trim(); 
	}
	
	public Object getFISLResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		EpsPaymentSearchRequestHelper epsPaymentSearchRequestHelper = new EpsPaymentSearchRequestHelper();
		/**Creates POJO for Request.xml so that we can modify the elements*/
		
		EpsPaymentsSearchRequest epsPaymentsSearchRequest=(EpsPaymentsSearchRequest) createRequest();
		epsPaymentsSearchRequest=setTinNumber(epsPaymentsSearchRequest);
		setToAndFromDate(epsPaymentsSearchRequest);
		setMapEntryKey(epsPaymentsSearchRequest);
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
	
	public EpsPaymentsSearchRequest setTinNumber(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		System.out.println(testConfig.getRunTimeProperty("tin"));
	   ((EpsPaymentsSearchRequest) object).setTaxIdentifierNumber(testConfig.getRunTimeProperty("tin").trim());	
		return (EpsPaymentsSearchRequest) object;
	}
	
	public EpsPaymentsSearchRequest setToAndFromDate(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		((EpsPaymentsSearchRequest) object).getPaymentMadeOnDateRange().setFromDate(testConfig.getRunTimeProperty("fromDate"));
		System.out.println(testConfig.getRunTimeProperty("toDate"));
		System.out.println(testConfig.getRunTimeProperty("fromDate"));
		((EpsPaymentsSearchRequest) object).getPaymentMadeOnDateRange().setToDate(testConfig.getRunTimeProperty("toDate"));
		return (EpsPaymentsSearchRequest) object;
	}
	
	
	public EpsPaymentsSearchRequest setTaxIdentifierType(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0).setValue(testConfig.getRunTimeProperty("taxIdentifierType"));
		return (EpsPaymentsSearchRequest) object;
	}
	
	public EpsPaymentsSearchRequest setMapEntryKey(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		System.out.println(testConfig.getRunTimeProperty("key"));
		System.out.println(testConfig.getRunTimeProperty("value"));
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0).setKey(testConfig.getRunTimeProperty("key"));
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0).setValue(testConfig.getRunTimeProperty("value"));
		return (EpsPaymentsSearchRequest) object;
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

}
