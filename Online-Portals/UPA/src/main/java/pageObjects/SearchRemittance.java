package main.java.pageObjects;

import groovy.transform.AutoClone;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.xml.sax.SAXException;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

//import main.java.Utils.Config;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.sFTPAccess;
import main.java.api.manage.EpsPaymentsSearch.EpsPaymentSearchRequestHelper;
import main.java.api.manage.EpsPaymentsSearch.EpsSearchRemittanceRequestHelper;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.api.pojo.epspaymentsearch.request.SearchByCriteriaRequest;
import main.java.api.pojo.*;
import main.java.api.pojo.epspaymentsearch.response.EpsConsolidatedClaimPaymentSummaries;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import main.java.reporting.LogTemp;

public class SearchRemittance extends paymentSummary {
	
	@FindBy(xpath="//td[@class='errors']")
	WebElement errorMsg;
	
	@FindBy(xpath="//td[contains(text(),'No records')]")
	WebElement CSRErrorMsg;
	
	@FindBy(xpath="//td[contains(text(),'Record Count')]")
	WebElement recordCount;
	
	//amit
	@FindBy(xpath = "//div[@id='SearchHeader']//table//tr") 
	public List<WebElement> divSearchResults;

	@FindBy(id = "SearchCriteriaVal")
	WebElement divSearchCriteria;

	@FindBy(xpath ="//input[@value='Print Search Results']")
	WebElement btnPrinttSearchResult;

	@FindBy(linkText = "Next Page") 
	WebElement lnkNextPage;
	
	@FindBy(linkText = "Last Page") 
	WebElement lnkLastPage;
	
//	@FindBy(xpath="//a[contains(text(),'Last Page')]")
//	WebElement lnkLastPage;
	
	@FindBy(linkText = "First Page") 
	WebElement lnkFirstPage;

	@FindBy(linkText = "Claim Amount")
	WebElement lnkClaimAmount;

	@FindBy(linkText = "Claim Date")
	WebElement lnkClaimDate;

	@FindBy(linkText = "Payer")
	WebElement lnkPayerName;

	@FindBy(linkText = "NPI")
	WebElement lnkNPI;

	@FindBy(linkText = "Patient Name")
	WebElement lnkPatientName;

	@FindBy(linkText = "Subscriber ID")
	WebElement lnkSubscriberId;

	@FindBy(linkText = "Account Number")
	WebElement lnkAccountNumber;

	@FindBy(linkText = "Claim #")
	WebElement lnkClaimHash;

	@FindBy(linkText = "Payment Number")
	WebElement lnkPaymentNumber;

	@FindBy(linkText = "Market Type")
	WebElement lnkMarketType;
	
	@FindBy(linkText = "Payment Date")
	WebElement lnkPaymentDate;
	
	@FindBy(linkText = "Amount")
	WebElement lnkPaymentAmount;
	
	@FindBy(linkText = "Archive")
	WebElement lnkArchive;
	
	@FindBy(xpath="//tr[@class='columnHeaderText']")
	List<WebElement> searchResultsHeaderRow;
	
	@FindBy(id = "saveArchive")
	WebElement btnSaveArchive;

	@FindBy(id = "paymentNbr_1")
	WebElement paymentNbr1;
	
	@FindBy(xpath="//span[contains(@id,'epra')]//img")
	WebElement imgEPRApdf;
	
	@FindBy(xpath = "//td[@class='commenlink' and @id='homeId']/a[1]") WebElement HomeBtn;
	@FindBy(xpath = "//a[contains(text(),'Search Remittance')]") WebElement SrchRemit;
	@FindBy(xpath = "//input[@name='providerTIN']") WebElement EnterTIN;
	@FindBy(xpath = "//input[@name='btnSubmit']") WebElement SearchBtn;
	
	
	private TestBase testConfig;
	static int flag=0;
	List<ArrayList<String>> listOfPatients=new ArrayList<ArrayList<String>>();
	public SearchRemittance(TestBase testConfig)
	{
		super(testConfig,true);
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		//Element.expectedWait(divSearchCriteria, testConfig, "Search Criteria section","Search Criteria section");
		
	}
	
	public SearchRemittance(TestBase testConfig,boolean flag)
	{
		super(testConfig,true);
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	
	
	public void verifySearchResults(String requestType) throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		EpsPaymentsSummarySearchResponse searchResponse=(EpsPaymentsSummarySearchResponse) getFISLResponse(requestType);
		String totalRecordsFromFISL=searchResponse.getResponseReturnStatus().getTotalCount();
		
		if(testConfig.getRunTimeProperty("testSuite").equals("UPA"))
		 {
		   if(!totalRecordsFromFISL.equalsIgnoreCase("0"))
			Helper.compareMaps(testConfig, "Payments Details Comparison ",getSRDetailsFromFISL(requestType,searchResponse), getSRDetailsFromUI(requestType));	
		  else
		 Element.verifyTextPresent(errorMsg,"No records match the selected search criteria. Choose a different search option or try your search again later.");
//		 Helper.compareEquals(testConfig, "Record Count from FISL and DB :",totalRecordsFromFISL,getRecordCountFromDB(requestType));
		}
		else 
			verifyPaymentDetailsForCSR(requestType,searchResponse);
     }
	
	
	public void verifyPaymentDetailsForCSR(String requestType,EpsPaymentsSummarySearchResponse searchResponse) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		String totalRecordsFromFISL=searchResponse.getResponseReturnStatus().getTotalCount();
		if(!totalRecordsFromFISL.equalsIgnoreCase("0"))
		  Helper.compareLinkedMaps(testConfig, "Payments Details Comparison ",getPaymentDetailsFromFISLForCSR(searchResponse), getPaymentDetailsFromCSRUI());
		else
		  Element.verifyTextPresent(CSRErrorMsg,"No records match the selected search criteria. Choose a different search option or try your search again later.");
		 
		//Queries to be modified by Abhinav
		//Helper.compareEquals(testConfig, "Record Count from FISL and DB :",totalRecordsFromFISL,getRecordCountFromDB(requestType));
		
	}
	
	
	public Object createRequest(String requestType) throws JAXBException
	{
		EpsSearchRemittanceRequestHelper epsSearchRemittanceRequestHelper = new EpsSearchRemittanceRequestHelper(requestType);
	    EpsPaymentsSearchRequest epsSearchRemittanceSearchRequest=epsSearchRemittanceRequestHelper.createRequestPojo();
	    return epsSearchRemittanceSearchRequest;
	}

	public EpsPaymentsSearchRequest setServiceData(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		((EpsPaymentsSearchRequest) object).getServiceData().setApplicationIdentifier("EPS");
		((EpsPaymentsSearchRequest) object).getServiceData().setVersion("1.0");
		
		return (EpsPaymentsSearchRequest) object;
	}
	
	public Object getFISLResponse(String requestType) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		/**Creates POJO for Request.xml so that we can modify the elements*/
		EpsSearchRemittanceRequestHelper epsSearchRemittanceRequestHelper = new EpsSearchRemittanceRequestHelper(requestType);
		EpsPaymentsSearchRequest epsSearchRemittanceSearchRequest=epsSearchRemittanceRequestHelper.createRequestPojo();
		

		/**set the request data*/
		epsSearchRemittanceSearchRequest=setTinNumber(epsSearchRemittanceSearchRequest);
		
		if(requestType.equals("byDOPAndPatientNm")||requestType.equals("byElectronicPaymentNo")||requestType.equals("byCheckNo"))
			setMapEntryKey2(epsSearchRemittanceSearchRequest);
		
	    setMapEntryKey(epsSearchRemittanceSearchRequest);
	    setServiceData(epsSearchRemittanceSearchRequest);
	    if(requestType.contains("byDOS")) 
			setToAndFromDateDOS(epsSearchRemittanceSearchRequest);
		else
			setToAndFromDate(epsSearchRemittanceSearchRequest);

	    /**Posting the modified request and getting response*/
	    EpsPaymentsSummarySearchResponse searchResponse=(EpsPaymentsSummarySearchResponse) epsSearchRemittanceRequestHelper.postRequestGetResponse(epsSearchRemittanceSearchRequest);
	   return searchResponse;
	}
	
	
	public EpsPaymentsSearchRequest setToAndFromDateDOS(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		((EpsPaymentsSearchRequest) object).getClaimServiceDateRange().setFromDate(testConfig.getRunTimeProperty("fromDate"));
		((EpsPaymentsSearchRequest) object).getClaimServiceDateRange().setToDate(testConfig.getRunTimeProperty("toDate"));	
		return (EpsPaymentsSearchRequest) object;
	}
	
	public EpsPaymentsSearchRequest setMapEntryKey1(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0).setKey(testConfig.getRunTimeProperty("key"));
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0).setValue(testConfig.getRunTimeProperty("value"));

		return (EpsPaymentsSearchRequest) object;
	}
	
	
	public EpsPaymentsSearchRequest setMapEntryKey2(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(1).setKey(testConfig.getRunTimeProperty("key1"));
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(1).setValue(testConfig.getRunTimeProperty("value1"));
		
		return (EpsPaymentsSearchRequest) object;
	}
	
	public String getRecordCountFromDB(String requestType)
	{
		int totalRecord=0;
		List<String> schemas=Arrays.asList("PP001");
		int sqlRowNo=34;
		
		switch (requestType) {
		case "byDateOfService":
			sqlRowNo=48;
			break;
		default:
			sqlRowNo=34;
			break;
		}
		
		for(String schema:schemas)
		{
			testConfig.putRunTimeProperty("schema", schema);
			Map srchConsolTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			totalRecord=totalRecord+Integer.parseInt(srchConsolTable.get("RECORD_COUNT").toString().trim());
		}
		
		return String.valueOf(totalRecord);	
	}
	
	
	/**
	 * @author- amit
	 * @param colName
	 * @return
	 */
	public int getColumnNo(String colName)
	{
		int colNumber=0;
		divSearchResults=Element.findElements(testConfig, "xpath", "//div[@id='SearchHeader']//table//tr");
		int noOfColumns=divSearchResults.get(0).findElements(By.tagName("td")).size();
		for(int i=0;i<noOfColumns;i++)
		{
			String actualColName=divSearchResults.get(0).findElements(By.tagName("td")).get(i).getText().toString();
			if(actualColName.contains(colName))
			{
				colNumber=i;
				break;
			}
		}
		return colNumber;
	}
	
	public List<String> getColumnValue(String colName) 
	{	
		List<String> list = new ArrayList<String>();
		divSearchResults=Element.findElements(testConfig, "xpath", "//div[@id='SearchHeader']//table//tr");
		int noOfRows = divSearchResults.size();
		int colNumber=getColumnNo(colName);
		boolean p=true;
		if(colName.equals("Archive"))
			for (int i=2; i<noOfRows; i++) 
			{
				p=true;
				divSearchResults=Element.findElements(testConfig, "xpath", "//div[@id='SearchHeader']//table//tr");
				Map attMap=Element.getAllAttributes(testConfig, divSearchResults.get(i).findElements(By.tagName("td")).get(colNumber).findElement(By.tagName("input")), "Access Level Attributes");
				String result=(String)attMap.get("CHECKED");
				if(result==null)
					result=attMap.containsKey("checked")?"true":"false";
				if(result.equals("false") && flag==0)
				{
					p=false;
					divSearchResults.get(i).findElements(By.tagName("td")).get(colNumber).findElement(By.tagName("input")).click();
					Browser.wait(testConfig, 1);
					btnSaveArchive.click();
					Element.expectedWait(divSearchCriteria, testConfig, "Search Criteria section","Search Criteria section");
					i=1;
				}
				flag=1;
				if(p)
					list.add(result);
			}
		else
			for (int i=2; i<noOfRows; i++)
			{
				String result="";
				try
				{
					result = divSearchResults.get(i).findElements(By.tagName("td")).get(colNumber).getText();
				}
				catch(Exception e)
				{
					divSearchResults=Element.findElements(testConfig, "xpath", "//div[@id='SearchHeader']//table//tr");	
					result = divSearchResults.get(i).findElements(By.tagName("td")).get(colNumber).getText();
				}
				switch(result)
				{
					case "":
						break;
					default:
						list.add(result);
				}
			}
		return list;
	}


	public void verifySortingOrder(WebElement lnkName, String colName,String criteriaType) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException 
	{	
		List<String> newList=new ArrayList<String>();
		List<Double> newDoubleList=new ArrayList<Double>();
		switch(colName)
		{
		case "Payer":
		case "Payment Number":
		case "NPI":
		case "Subscriber ID":
		case "Account Number":
		case "Claim #":
		case "Archive":
		case "Market Type":
					List<String> listString = new ArrayList<String>();
					
					List<String> actualListString = new ArrayList<String>();

					listString=getExpectedDetailsFromFISL(criteriaType, colName);
					
					Collections.sort(listString);
					
					if(listString.size()<30)
						newList.addAll((listString.subList(0,listString.size())));
					else
						newList.addAll((listString.subList(0,30)));
					
					Element.clickByJS(testConfig, lnkName, colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					actualListString = getColumnValue(colName);					
					Helper.compareEquals(testConfig, colName, newList, actualListString);

					// now sorting in descending order
					
					
					Collections.sort(listString, Collections.reverseOrder());
					newList.clear();
					if(listString.size()<30)
						newList.addAll((listString.subList(0,listString.size())));
					else
						newList.addAll((listString.subList(0,30)));
					Element.clickByJS(testConfig, lnkName, colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					actualListString.clear();
					actualListString = getColumnValue(colName);
					Log.Comment("True specifies archive is checked and False specifies archive is unchecked");
					Helper.compareEquals(testConfig, colName, newList, actualListString);
					break;
					
		case "Patient Name":
					listString = new ArrayList<String>();
					actualListString = new ArrayList<String>();

					listString=getExpectedDetailsFromFISL(criteriaType, colName);
					Collections.sort(listOfPatients,new Comparator<ArrayList<String>>(){

						@Override
						public int compare(ArrayList<String> a1,ArrayList<String> a2) {
							int v1=a1.get(2).compareTo(a2.get(2));
			                int v2=a1.get(1).compareTo(a2.get(1));
			                int v3=a1.get(3).compareTo(a2.get(3));
			                if(v1==0)
			                    return (v2==0)?v3:v2;
			                else
			                    return v1;
						}
						
					});
					if(listString.size()<30)
						for(int i=0;i<listString.size();i++)
							newList.add(listOfPatients.get(0).get(0));
					else
						for(int i=0;i<30;i++)
							newList.add(listOfPatients.get(0).get(0));
					Element.clickByJS(testConfig, lnkName, colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					actualListString = getColumnValue(colName);					
					Helper.compareEquals(testConfig, colName, newList, actualListString);
		
					// now sorting in descending order
					Collections.sort(listString, Collections.reverseOrder());
					if(listString.size()<30)
						for(int i=0;i<listString.size();i++)
							newList.add(listOfPatients.get(0).get(0));
					else
						for(int i=0;i<30;i++)
							newList.add(listOfPatients.get(0).get(0));
					Element.clickByJS(testConfig, lnkName, colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					actualListString.clear();
					actualListString = getColumnValue(colName);
					Log.Comment("True specifies archive is checked and False specifies archive is unchecked");
					Helper.compareEquals(testConfig, colName, newList, actualListString);
					break;
			
		case "Amount":
		case "Claim Amount":
					List<Double> listDouble = new ArrayList<Double>();
					List<Double> actualListDouble = new ArrayList<Double>();

					listString=getExpectedDetailsFromFISL(criteriaType, colName);

					listDouble = convertFromStringToDouble(listString);
					Collections.sort(listDouble);
					if(listDouble.size()<30)
						newDoubleList.addAll((listDouble.subList(0,listDouble.size())));
					else
						newDoubleList.addAll((listDouble.subList(0,30)));
					Element.clickByJS(testConfig, lnkClaimAmount, colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					Browser.wait(testConfig,2);
					listString=getColumnValue(colName);
					actualListDouble = convertFromStringToDouble(listString);
					Helper.compareEquals(testConfig, colName, newDoubleList,actualListDouble);

					// now sorting in descending order
					Collections.sort(listDouble, Collections.reverseOrder());
					newDoubleList.clear();
					if(listDouble.size()<30)
						newDoubleList.addAll((listDouble.subList(0,listDouble.size())));
					else
						newDoubleList.addAll((listDouble.subList(0,30)));
					Element.clickByJS(testConfig, lnkClaimAmount,colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					Browser.wait(testConfig,2);
					listString=getColumnValue(colName);
					actualListDouble = convertFromStringToDouble(listString);					
					Helper.compareEquals(testConfig, colName, newDoubleList, actualListDouble);
					break;
					
		case "Payment Date":
		case "Claim Date":

				listString = getExpectedDetailsFromFISL(criteriaType, colName);
				Collections.sort(listString, new Comparator<String>()
					{
						DateFormat f = new SimpleDateFormat("MM/dd/yyyy");
						@Override
						public int compare(String o1, String o2) {
							try {
								return f.parse(o1).compareTo(f.parse(o2));
							} catch (ParseException e) {
								throw new IllegalArgumentException(e);
							}
						}
					});
				if(listString.size()<30)
					newList.addAll(listString.subList(0, listString.size()));
				else 
					newList.addAll(listString.subList(0, 30));
				Element.clickByJS(testConfig, lnkClaimDate, colName);
				Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
				Browser.wait(testConfig,2);
				actualListString = getColumnValue(colName);
				Helper.compareEquals(testConfig, colName, newList,actualListString);
				
				// now sorting in descending order		
				Collections.reverse(listString);
				newList.clear();
				if(listString.size()<30)
					newList.addAll(listString.subList(0, listString.size()));
				else 
					newList.addAll(listString.subList(0, 30));
				Element.clickByJS(testConfig, lnkClaimDate, colName);
				Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
				Browser.wait(testConfig,2);
				actualListString = getColumnValue(colName);
				Helper.compareEquals(testConfig, colName, newList,actualListString);
				break;
		}
	}

	public List<Double> convertFromStringToDouble(List<String> listString) {
		List<Double> l = new ArrayList<Double>();
		for(String s : listString)
		{
			double amount = Double.parseDouble(s.substring(1, s.length()).replace(",", ""));
			l.add(BigDecimal.valueOf(amount).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			
		}
		return l;
	}

	public List<Long> convertFromStringToInteger(List<String> listString) {
		List<Long> l = new ArrayList<Long>();
		for(String s : listString)
			l.add(Long.parseLong(s));
		return l;
	}


	public List<String> getExpectedDetailsFromFISL(String requestType,String colName) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		List<String> l= new ArrayList<String>();
		EpsPaymentsSummarySearchResponse searchResponse=(EpsPaymentsSummarySearchResponse) getFISLResponse(requestType);
		l=getDetailsFromFISL(searchResponse,colName);
		return l;
	}
	
	public void verifySorting(String colName) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException{
		String criteriaType="byDOP";
		switch(colName)
		{		
		case "Payer":
			verifySortingOrder(lnkPayerName,colName,criteriaType);
			break;
		case "Claim Date":
			verifySortingOrder(lnkClaimDate, colName,criteriaType);	
			break;
		case "NPI":
			verifySortingOrder(lnkNPI,"NPI",criteriaType);
			break;
		case "Payment Number":
			verifySortingOrder(lnkPaymentNumber,colName,criteriaType);
			break;
		case "Patient Name":
			verifySortingOrder(lnkPatientName,colName,criteriaType);
			break;
		case "Subscriber ID":
			verifySortingOrder(lnkSubscriberId,colName,criteriaType);
			break;
		case "Account Number":
			verifySortingOrder(lnkAccountNumber,colName,criteriaType);
			break;
		case "Claim #":
			verifySortingOrder(lnkClaimHash,colName,criteriaType);
			break;
		case "Claim Amount":
			verifySortingOrder(lnkClaimAmount, colName,criteriaType);
			break;
		case "Archive":
			verifySortingOrder(lnkArchive,colName,criteriaType);
			break;
		case "Market Type":
			verifySortingOrder(lnkMarketType,colName,criteriaType);
			break;		
		case "Payment Date":
			verifySortingOrder(lnkPaymentDate,colName,criteriaType);
			break;
		case "Amount":
			verifySortingOrder(lnkPaymentAmount, colName,criteriaType);
			break;
		default:
			Log.Comment("No such Column present on page");
			break;
		
		}
	}
	
	public void verifyPaymentStatus(String type)
	{
		String expectedStatus=getStatus(type);
		int rowNo=1,ACHflag=0,CHKflag=0,NONflag=0,VCPflag=0;
		if(divSearchResults.size()!=0){
			for(rowNo=2;rowNo<divSearchResults.size();rowNo++)
			 {
			   if(divSearchResults.get(rowNo).findElements(By.tagName("td")).get(10).getText().toString().equals("ACH") && ACHflag==0)
				 {
				   Helper.compareContains(testConfig, "Verify Status Code", "Successful ACH", divSearchResults.get(rowNo).findElements(By.tagName("td")).get(11).getText());
				   ACHflag=1;
				 }	
			   else if(divSearchResults.get(rowNo).findElements(By.tagName("td")).get(10).getText().toString().equals("CHK") && CHKflag==0)
			   {
				   Helper.compareContains(testConfig, "Verify Status Code", "Successful CHK", divSearchResults.get(rowNo).findElements(By.tagName("td")).get(11).getText());
				   CHKflag=1;
			   }
			   else if(divSearchResults.get(rowNo).findElements(By.tagName("td")).get(10).getText().toString().equals("NON") && NONflag==0)
			   {
				   Helper.compareContains(testConfig, "Verify Status Code", "N/A", divSearchResults.get(rowNo).findElements(By.tagName("td")).get(11).getText());
				   NONflag=1;
			   }
			   else if(divSearchResults.get(rowNo).findElements(By.tagName("td")).get(10).getText().toString().equals("VCP") && NONflag==0)
			   {
				   Helper.compareContains(testConfig, "Verify Status Code", expectedStatus, divSearchResults.get(rowNo).findElements(By.tagName("td")).get(11).getText());
				   NONflag=1;
			   }
	          }
		}
		else	
		{
		   divSearchResults=Element.findElements(testConfig, "xpath", ".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");
		   if(divSearchResults.get(rowNo).findElements(By.tagName("td")).get(6).getText().equals(type))
			   Helper.compareContains(testConfig, "Verify Status Code", expectedStatus, divSearchResults.get(rowNo).findElements(By.tagName("td")).get(13).getText());	
        }		
		 
	  }

	
	
	public String getStatus(String typeCode)
	{
		switch(typeCode)
		{
			case "ACH":
				return "Successful ACH";			
			case "CHK":
				return "Successful CHK";				
			case "VCP":
				if(testConfig.getRunTimeProperty("paymentMethCode").equals("NON") && testConfig.getRunTimeProperty("paymentStatusTypeID")!=null)
					return "N/A";
				else 
					return  testConfig.getRunTimeProperty("typeDescription");
			case "NON":
			case "DD":
				return "N/A";
			default:
				Log.Comment("Invalid Payment Type");			
				return "Unidentified typeCode";
		}
	}
	
	
	public void verifyReturnedReasonDisplayed(String criteriaType)
	{
		String actualColName="";
		if(testConfig.getRunTimeProperty("testSuite").equalsIgnoreCase("CSR"))
		 {
				divSearchResults=Element.findElements(testConfig, "xpath", ".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr"); //.//*[@id='searchRemittanceResultsForm']//tr[7]//tr[2]/td[13]/span
				actualColName=divSearchResults.get(0).findElements(By.tagName("td")).get(12).getText();
				Helper.compareContains(testConfig, "verify column Name", "Returned Reason", actualColName);
				switch(criteriaType)
				{
					case "byElectronicPaymentNo":
						String colData=divSearchResults.get(1).findElement(By.xpath("td[13]/span")).getText().toString();
						Helper.compareContains(testConfig, "verify Column Data", colData, testConfig.getRunTimeProperty("returnedReason"));
						break;
					case "byCheckNo":
						colData=divSearchResults.get(1).findElement(By.xpath("td[13]")).getText().toString();
						Helper.compareContains(testConfig, "verify Column Data", "", colData);
						break;	
				}
		 }
		else
		 {
				int numberOfCols=divSearchResults.get(0).findElements(By.tagName("td")).size();
				int colNumber=0;
				for(int i=0;i<numberOfCols;i++)
				{
					actualColName=divSearchResults.get(0).findElements(By.tagName("td")).get(i).getText().toString();
					if(actualColName.equals("Returned Reason"))
						colNumber=i;
				}
				if(colNumber==0)
					Log.Pass(actualColName +" is not present");
				else
					Log.Fail(actualColName + " is present");
				
		 }
	}
	
	//in progress--->not working
	public void verifyPrintFirstPage() throws IOException, AWTException, InterruptedException
	{
		Element.clickByJS(testConfig, btnPrinttSearchResult, "Export Search Result");	   
		Robot robot =new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);      
        robot.keyPress(KeyEvent.VK_TAB);   
        robot.keyPress(KeyEvent.VK_TAB);   
        robot.keyPress(KeyEvent.VK_ENTER);
   
//		FileInputStream fis = new FileInputStream("C:\\Users\\akushw10\\Downloads\\Search_Remit_Report.xls");
//	    HSSFWorkbook workbook = new HSSFWorkbook(fis);
//	    HSSFSheet sheet = workbook.getSheet("SearchRemitReport");
//	    HSSFRow row = sheet.getRow(0);
//	    int rowNum = sheet.getLastRowNum();
//	    System.out.println("Total Number of Rows in the excel is : "+rowNum);    
	}
	
	public void verifyPagination()
	{
		int noOfRecords=divSearchResults.size()>0?divSearchResults.size()-2:0;
		Log.Comment("No of records present is : " + noOfRecords);
		if(divSearchResults.size()>30)
		{
			Element.verifyElementPresent(lnkLastPage, "Last Page Link");
			Element.clickByJS(testConfig, lnkLastPage, "Last Page Link");
			Element.expectedWait(divSearchCriteria, testConfig, "Search Criteria section","Search Criteria section");
			Element.clickByJS(testConfig, lnkFirstPage, "First Page");
			Element.expectedWait(divSearchCriteria, testConfig, "Search Criteria section","Search Criteria section");
		}
		else
			Element.verifyElementNotPresent(lnkLastPage, "Last Page Link");
		
	}
	
	
	/**
	 * This function creates an outer map 
	 * with Key as payment number
	 * and  Value as another hash map i.e. inner map
	 * that contains all the details for key 
	 * like payer name, amount etc
	 * @return Outer map
	 */	
	public Map<String, LinkedHashMap<String, String>> getSRDetailsFromUI(String requestType)
	{	   
		
	   /**Gets headers List which will be key for following map*/
	   int startingLoop=2;
		if(requestType.equalsIgnoreCase("byElectronicPaymentNo")||requestType.equalsIgnoreCase("byCheckNo")||requestType.equalsIgnoreCase("byDOPAndNpi")||requestType.equalsIgnoreCase("byDOP&SubscriberID"))
			startingLoop=1;
		
	   LinkedHashMap<String,String> innerMap = null;
	   Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	   ArrayList<String> headers=getHeadersFromResultTable();
	   int totalNoOfPages=getNumberOfPages();
	   if(totalNoOfPages>2)
		 totalNoOfPages=1;
		   
	   if(divSearchResults.size()==0)
		   divSearchResults=Element.findElements(testConfig, "xpath", ".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");
	   
	   Log.Comment("Fetching all payments From UI..");
	   String details="";
	   String amount="";
	   int l=0;;
	
	   
	   for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
		   
			for(int i=startingLoop;i<divSearchResults.size();i++)
		    {
				System.out.println(divSearchResults.size());
				
			   innerMap=new LinkedHashMap<String,String>();
			   
			   for(int j=0,k=0;j<headers.size();j++,k++)
			    {	
				   if(headers.get(j).equals("Payer PRA"))
					   k=k+4;
				  details=divSearchResults.get(i).findElements(By.tagName("td")).get(k).getText();
			      details=details.replace("\n", "");
			      innerMap.put(headers.get(j), details);	
				 }
			    
			   if(requestType.equalsIgnoreCase("byElectronicPaymentNo")||requestType.equalsIgnoreCase("byCheckNo"))
			    { 
			      if(innerMap.get("Amount").contains(","))
			      {
			      amount=innerMap.get("Amount").replace(",", "");
			      innerMap.put("Amount", amount);
			      }
			    }
			   else
			   {
				  if(innerMap.get("Claim Amount").contains(","))
			       {
				      amount=innerMap.get("Claim Amount").replace(",", "");
				      innerMap.put("Claim Amount", amount);
				   }
			   }
			   innerMap.remove("Redemption Date");
			   innerMap.remove("Proxy Number");
			   innerMap.remove("Payer");
			   innerMap.remove("835 / EPRA");
			   innerMap.remove("Payer PRA");
			   innerMap.remove("Archive");
			   innerMap.remove("Payment Status / Trace Number");
			   outerMap.put(innerMap.get("Payment Number")+l, innerMap);
				  l++;
		    }
			  
			  if(pageNo%10!=0 && pageNo<totalNoOfPages)
			    {   
				   int pageToBeClicked=pageNo+1;
				   WebElement pageLink= Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]");
				   if(pageLink!=null)
					   pageLink.click();
				   else
				   Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]").click();
				   Log.Comment("Clicked Page number : " + pageToBeClicked);
				   Browser.wait(testConfig, 3);
			     }
			  else if(pageNo%10==0 && totalNoOfPages!=2)
				 {
				       Browser.wait(testConfig,1);
					   LogTemp.Comment("Page Number is multiple of 10..so clicking Next");
			           Element.click(lnkNextPage,"Next Link");
			           Browser.wait(testConfig,3);
			           pageNo++;
			     }
			 
		 }
	   
	   Log.Comment("UI detials " +(outerMap));
		return outerMap;
	   
    }
	
	
	
	public LinkedHashMap<String,String> getPaymentDetailsFromCSRUI()
	{	   
	   /**Gets headers List which will be key for following map*/
		
	   LinkedHashMap<String,String> innerMap = null;
	   Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	   ArrayList<String> headers=getHeadersFromResultTable();
	   
	   int totalNoOfPages=getNumberOfPages();
	   
	   if(totalNoOfPages>2)
		 totalNoOfPages=1;
		   
	   if(divSearchResults.size()==0)
		   divSearchResults=Element.findElements(testConfig, "xpath", ".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");
	     if(divSearchResults.size()==0)
	    	divSearchResults=Element.findElements(testConfig, "xpath",".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table//tr");
	   
//	   Log.Comment("Fetching all payments From UI..");
	   
	   for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
			for(int i=2;i<divSearchResults.size();i++)
		    {
			   innerMap=new LinkedHashMap<String,String>();
			   
			   for(int j=0;j<headers.size();j++)
			    {	
			      String details=divSearchResults.get(i).findElements(By.tagName("td")).get(j).getText();
			      details=details.replace("\n", "");
			     
			      if(headers.get(j).equals("Payment Status/Trace Number"))
			    	 innerMap.put(headers.get(j), divSearchResults.get(i).findElements(By.tagName("td")).get(13).getText());
			      if(headers.get(j).equals("Market Type"))
			    	 innerMap.put(headers.get(j),divSearchResults.get(i).findElements(By.tagName("td")).get(13).getText());
			      else
			      innerMap.put(headers.get(j), details);	
			    }
			  
			   if(innerMap.get("Claim Amount")!=null)
			   {
			     String amount=innerMap.get("Claim Amount").replace(",", "");
			     innerMap.put("Claim Amount", amount);
			   }
			   else 
			   {
				 String amount=innerMap.get("Amount").replace(",", "");
				 innerMap.put("Amount", amount); 
			   }
			   
			   innerMap.remove("Redemption Date");
			   innerMap.remove("Payment Status / Trace Number");
			   innerMap.remove("Proxy Number");
			   innerMap.remove("Payer"); 
			   innerMap.remove("835 / EPRA");
			   innerMap.remove("Payer PRA");
			   innerMap.remove("Returned Reason");
			   innerMap.remove("Archive");
//			   outerMap.put(divSearchResults.get(i).findElements(By.tagName("td")).get(3).getText().replace("\n",""), innerMap);
		    }
			  
			  if(pageNo%10!=0 && pageNo<totalNoOfPages)
			    {   
				   int pageToBeClicked=pageNo+1;
				   WebElement pageLink= Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]");
				   if(pageLink!=null)
					   pageLink.click();
				   else
				   Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]").click();
				   Log.Comment("Clicked Page number : " + pageToBeClicked);
				   Browser.wait(testConfig, 3);
			     }
			  else if(pageNo%10==0 && totalNoOfPages!=2)
				 {
				       Browser.wait(testConfig,1);
					   LogTemp.Comment("Page Number is multiple of 10..so clicking Next");
			           Element.click(lnkNextPage,"Next Link");
			           Browser.wait(testConfig,3);
			           pageNo++;
			     }
		 }
//		Log.Comment("Details from UI is : " +'\n' +outerMap);
		return innerMap;
	   
    }
	
	
	public Map<String,LinkedHashMap<String,String>> getPaymentDetailsFromCSRUI(String searchType)
	{	   
	   /**Gets headers List which will be key for following map*/
		
	   LinkedHashMap<String,String> innerMap;
	   Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	   ArrayList<String> headers=getHeadersFromResultTable();
	   
	   int totalNoOfPages=getNumberOfPages();
	   
	   if(totalNoOfPages>2)
		 totalNoOfPages=1;
		   
//	   if(divSearchResults.size()==0)
//		   divSearchResults=Element.findElements(testConfig, "xpath", ".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");
//	     if(divSearchResults.size()==0)
	    	divSearchResults=Element.findElements(testConfig, "xpath",".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table//tr");
	   
//	   Log.Comment("Fetching all payments From UI..");
	   System.out.println(divSearchResults.size());
	   for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
			for(int i=1;i<divSearchResults.size();i++)
		    {
			   innerMap=new LinkedHashMap<String,String>();
			   
			   for(int j=0;j<headers.size();j++)
			    {	
			      String details=divSearchResults.get(i).findElements(By.tagName("td")).get(j).getText();
			      details=details.replace("\n", "");
			     
			     System.out.println(divSearchResults.get(3).findElements(By.tagName("td")).get(j).getText());
			      if(headers.get(j).equals("Payment Status/Trace Number"))
			    	 innerMap.put(headers.get(j), divSearchResults.get(i).findElements(By.tagName("td")).get(13).getText());
			      if(headers.get(j).equals("Market Type"))
			    	 innerMap.put(headers.get(j),divSearchResults.get(i).findElements(By.tagName("td")).get(12).getText());
			      else
			      innerMap.put(headers.get(j), details);	
			    }
			  
			   if(innerMap.get("Claim Amount")!=null)
			   {
			     String amount=innerMap.get("Claim Amount").replace(",", "");
			     innerMap.put("Claim Amount", amount);
			   }
			   else 
			   {
				 String amount=innerMap.get("Amount").replace(",", "");
				 innerMap.put("Amount", amount); 
			   }
			   
			   innerMap.remove("Redemption Date");
			   innerMap.remove("Payment Status / Trace Number");
			   innerMap.remove("Proxy Number");
			   innerMap.remove("Payer"); 
			   innerMap.remove("835 / EPRA");
			   innerMap.remove("Payer PRA");
			   innerMap.remove("Returned Reason");
			   innerMap.remove("Archive");
			   outerMap.put(divSearchResults.get(i).findElements(By.tagName("td")).get(3).getText().replace("\n",""), innerMap);
		    }
			  
			  if(pageNo%10!=0 && pageNo<totalNoOfPages)
			    {   
				   int pageToBeClicked=pageNo+1;
				   WebElement pageLink= Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]");
				   if(pageLink!=null)
					   pageLink.click();
				   else
				   Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]").click();
				   Log.Comment("Clicked Page number : " + pageToBeClicked);
			     }
			  else if(pageNo%10==0 && totalNoOfPages!=2)
				 {
				       Browser.wait(testConfig,1);
					   LogTemp.Comment("Page Number is multiple of 10..so clicking Next");
			           Element.click(lnkNextPage,"Next Link");
			           pageNo++;
			     }
		 }
		Log.Comment("Details from UI is : " +'\n' +outerMap);
		return outerMap;
	   
    }
	/**
	 * Get Headers List till Market Type
	 * to store them as key in map
	 * @return HeaderList
	 */
	public ArrayList<String> getHeadersFromResultTable()
	{
	   List <String> headerList=new ArrayList<String>();
	 
	   int noOfHeaders=searchResultsHeaderRow.get(0).findElements(By.tagName("td")).size();
	   System.out.println(noOfHeaders);
	   
	   for (int i=0;i<noOfHeaders;i++)
	   {
	     String header=searchResultsHeaderRow.get(0).findElements(By.tagName("td")).get(i).getText();
	     headerList.add(header);
		}
	return (ArrayList<String>) headerList;
	   
    }
	
	public Map<String, LinkedHashMap<String, String>> getSRDetailsFromFISL(String requestType,Object FISLResponse) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		int totalPayments;
		LinkedHashMap<String,String> innerMap = null;
	    EpsConsolidatedClaimPaymentSummaries[] payments=((EpsPaymentsSummarySearchResponse) FISLResponse).getEpsConsolidatedClaimPaymentSummaries();
	    Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	    if(Integer.parseInt(((EpsPaymentsSummarySearchResponse) FISLResponse).getResponseReturnStatus().getTotalCount())>30)
			 totalPayments=30;
		  else
			totalPayments=payments.length;
			
		  for(int i=0;i<totalPayments;i++)
		  {
			 
			innerMap=new LinkedHashMap<String, String>();
			
//			if(requestType.equals("byDOP")||requestType.equals("byElectronicPaymentNo")||requestType.equalsIgnoreCase("byCheckNo")||requestType.equalsIgnoreCase("byDOPAndAccountNo"))
			innerMap.put("Payer/Patient",getDisplayPayerNameFromDB(payments[i].getPayerSummary().getName()));

			String patientName=payments[i].getPatientFirstName()+" " + payments[i].getPatientMiddleName()+" "+payments[i].getPatientLastName();
			patientName=patientName.replace("null ", "").trim();
			
			
			if(requestType.equals("byDOPAndAccountNo")||requestType.equals("byDOP"))
			 {
			   if(payments[i].getClaimDate()!=null)
			   innerMap.put("Claim Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getClaimDate(),"yyyy-MM-dd", "MM-dd-yyyy")));
			  else 
			  innerMap.put("Claim Date","");
			 }
			else
				if(payments[i].getClaimDate()!=null)
					 innerMap.put("Claim Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getClaimDate(),"yyyy-MM-dd", "MM-dd-yyyy")));
				else
			  innerMap.put("Payment Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getPaymentMadeOn(),"yyyy-MM-dd", "MM-dd-yyyy")));
		  
			if(payments[i].getNationalProviderIdentifier()!=null)
		    innerMap.put("NPI",payments[i].getNationalProviderIdentifier());
			else 
			innerMap.put("NPI",""); 
			innerMap.put("Payment Number",payments[i].getDisplayConsolidatedPaymentNumber());
			
			
			if(!(requestType.equals("byElectronicPaymentNo")||requestType.equals("byCheckNo")))
			 {
			    if(patientName!="")
			      innerMap.put("Patient Name",patientName);
			 }
			   
	
			if(payments[i].getSubscriberIdentifier()!=null)
			innerMap.put("Subscriber ID",payments[i].getSubscriberIdentifier());
			
			if(!(requestType.equals("byElectronicPaymentNo")||requestType.equals("byCheckNo")))
			{
				if(payments[i].getPatientAccountNumber()!=null)
					innerMap.put("Account Number",payments[i].getPatientAccountNumber());
				else
					innerMap.put("Account Number","");
			}
				
			
			
			
			if(payments[i].getClaimIdentifier()!=null)
			 {
			   innerMap.put("Claim #",payments[i].getClaimIdentifier());
			
			   if(payments[i].getClaimAmount().equalsIgnoreCase("0.0") || payments[i].getClaimAmount().equalsIgnoreCase("0.00"))
			   innerMap.put("Claim Amount","$"+"0.00");
			   else
			  {
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format(Double.parseDouble((payments[i].getClaimAmount())));
			    innerMap.put("Claim Amount","$"+ amount);
			  }
			}
			else
			{
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format(Double.parseDouble((payments[i].getTotalAmount())));
			    innerMap.put("Amount","$"+ amount);
			}
			
			innerMap.put("Type",payments[i].getPayeePaymentMethod().getPaymentMethodCode().getCode());
			if(innerMap.get("Amount")!=null)
			{
			    if(innerMap.get("Amount").equals("$0.00"))
				innerMap.put("Type","DD");
			}
			
			 
 			if(requestType.equals("byElectronicPaymentNo")||requestType.equals("byCheckNo"))
 			{
 				if(payments[i].getPaymentStatusCode().getDescription()!=null)
 					innerMap.put("Payment Status/Trace Number",payments[i].getPaymentStatusCode().getDescription());
 				else
 					if(innerMap.get("Type").equals("ACH"))
 						innerMap.put("Payment Status/Trace Number","Successful ACH");
 					else
 					innerMap.put("Payment Status/Trace Number","N/A");
 			}
 			 
			innerMap.put("Market Type",getDisplayMarketType(payments[i].getPaymentTypeIndicator()));
			outerMap.put(innerMap.get("Payment Number")+i, innerMap);
		 }
		  
		  
		 Log.Comment("Details from FISL is :"  + '\n' +outerMap);
		 return outerMap;
	}
	
	public LinkedHashMap<String, String> getPaymentDetailsFromFISLForCSR(Object FISLResponse) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		int totalPayments;
		LinkedHashMap<String,String> innerMap = null;
		Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	
	    EpsConsolidatedClaimPaymentSummaries[] payments=((EpsPaymentsSummarySearchResponse) FISLResponse).getEpsConsolidatedClaimPaymentSummaries();
		
	    if(Integer.parseInt(((EpsPaymentsSummarySearchResponse) FISLResponse).getResponseReturnStatus().getTotalCount())>30)
			 totalPayments=30;
		  else
			totalPayments=payments.length;
			
		  for(int i=0;i<totalPayments;i++)
		  {
			 
			innerMap=new LinkedHashMap<String, String>();
			//innerMap.put("Payer",getDisplayPayerNameFromDB(payments[i].getPayerSummary().getName()));
			
			String patientName=payments[i].getPatientFirstName()+" " + payments[i].getPatientMiddleName()+" "+payments[i].getPatientLastName();
			patientName=patientName.replace("null ", "").trim();

			if(payments[i].getClaimDate()!=null)
			  innerMap.put("Claim Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getClaimDate(),"yyyy-MM-dd", "MM-dd-yyyy")));
			else 
			  innerMap.put("Payment Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getPaymentMadeOn(),"yyyy-MM-dd", "MM-dd-yyyy")));
		  
			if(payments[i].getNationalProviderIdentifier()!=null)
		    innerMap.put("NPI",payments[i].getNationalProviderIdentifier());
			else 
			innerMap.put("NPI",""); 
			
			innerMap.put("Payment Number",payments[i].getDisplayConsolidatedPaymentNumber());
			
			if(patientName!="")
			innerMap.put("Patient Name",patientName);
			
			if(payments[i].getSubscriberIdentifier()!=null)
			innerMap.put("Subscriber ID",payments[i].getSubscriberIdentifier());
			innerMap.put("Account Number",payments[i].getPatientAccountNumber());
			
			
			if(payments[i].getClaimIdentifier()!=null)
			 {
			   innerMap.put("Claim #",payments[i].getClaimIdentifier());
			
			   if(payments[i].getClaimAmount().equalsIgnoreCase("0.0") || payments[i].getClaimAmount().equalsIgnoreCase("0.00"))
			   innerMap.put("Claim Amount","$"+"0.00");
			   else
			  {
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format(Double.parseDouble((payments[i].getClaimAmount())));
			    innerMap.put("Claim Amount","$"+ amount);
			  }
			}
			else
			{
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format(Double.parseDouble((payments[i].getTotalAmount())));
			    innerMap.put("Amount","$"+ amount);
			}
				
				
 			innerMap.put("Type",payments[i].getPayeePaymentMethod().getPaymentMethodCode().getCode());
// 			innerMap.put("Payment Status/Trace Number",payments[i].getPaymentStatusCode().getDescription());
			innerMap.put("Market Type",getDisplayMarketType(payments[i].getPaymentTypeIndicator()));
//			outerMap.put(innerMap.get("Payment Number"), innerMap);
		 }
		  
//		 Log.Comment("Details from FISL is :"  + '\n' +outerMap);
		 return innerMap;
	}

	public List<String> getDetailsFromFISL(EpsPaymentsSummarySearchResponse searchResponse,String colName) throws ParseException, JAXBException, IOException, SAXException, ParserConfigurationException
	{
		
		List<String> list= new ArrayList<String>();
		int totalPayments;
		
//		EpsPaymentsSummarySearchResponse searchResponse=(EpsPaymentsSummarySearchResponse) getFISLResponse(searchResponse2);
		
	    EpsConsolidatedClaimPaymentSummaries[] payments=((EpsPaymentsSummarySearchResponse) searchResponse).getEpsConsolidatedClaimPaymentSummaries();
		totalPayments=payments.length;
		
		switch(colName)
		{
		case "Payer":
			for(int i=0;i<totalPayments;i++)
				list.add(getDisplayPayerNameFromDB(payments[i].getPayerSummary().getName()));
			break;
		case "Claim Date":
			for(int i=0;i<totalPayments;i++)
				if(payments[i].getClaimDate()!=null)
					list.add(Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getClaimDate(),"yyyy-MM-dd", "MM-dd-yyyy")));
			break;
		case "NPI":
			for(int i=0;i<totalPayments;i++)
				if(payments[i].getNationalProviderIdentifier()!=null)
				    list.add(payments[i].getNationalProviderIdentifier());
			break;
		case "Payment Number":
			for(int i=0;i<totalPayments;i++)
				list.add(payments[i].getDisplayConsolidatedPaymentNumber());
			break;
		case "Subscriber ID":
			for(int i=0;i<totalPayments;i++)
				if(payments[i].getSubscriberIdentifier()!=null)
					list.add(payments[i].getSubscriberIdentifier());
			break;
		case "Patient Name":
			for(int i=0;i<totalPayments;i++)
			{
				String patientName=payments[i].getPatientFirstName()+" " + payments[i].getPatientMiddleName()+" "+payments[i].getPatientLastName();
				patientName=patientName.replace("null ", "").trim();
				if(patientName!="")
					list.add(patientName);
				ArrayList<String> test=new ArrayList<String>();
				test.add(patientName);
				test.add(payments[i].getPatientFirstName());
				test.add(payments[i].getPatientLastName());
				test.add(payments[i].getSubscriberIdentifier());
				listOfPatients.add(test);
			}
			break;
		case "Account Number":
			for(int i=0;i<totalPayments;i++)
				list.add(payments[i].getPatientAccountNumber());	
			break;
		case "Claim #":
			for(int i=0;i<totalPayments;i++)
				if(payments[i].getClaimIdentifier()!=null)
				   list.add(payments[i].getClaimIdentifier());
			break;
		case "Claim Amount":
			for(int i=0;i<totalPayments;i++)
				if(payments[i].getClaimIdentifier()!=null && payments[i].getClaimAmount().equalsIgnoreCase("0.0") || payments[i].getClaimAmount().equalsIgnoreCase("0.00"))
					   list.add("$"+"0.00");
			   else
			  {
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format(Double.parseDouble((payments[i].getClaimAmount())));
			    list.add("$"+ amount);
			  }
			break;
		case "Market Type":
			for(int i=0;i<totalPayments;i++)
				list.add(getDisplayMarketType(payments[i].getPaymentTypeIndicator()));
			break;
		}		 
		return list;
	}
	
	public RemittanceDetail clickPaymentNo(){
		Element.clickByJS(testConfig, paymentNbr1, "Payment Number of first Column");
		testConfig.putRunTimeProperty("dspl_nbr", paymentNbr1.getText());
		return new RemittanceDetail(testConfig);
	}

	public SearchRemittance verifyEpraPdfIcon(String srchType)
	{
		String filedir=System.getProperty("user.dir")+"\\Downloads";
		File fileDirectory=new File(filedir);
//		Element.verifyElementPresent(imgEPRApdf, "EPRA PDF ICON");
		Helper.purgeDirectory(fileDirectory);
//		Element.click(imgEPRApdf, "Epra PDF icon");
		clickEpraPDFlink(srchType);
		Browser.wait(testConfig, 5);
		Helper.isFileExist(fileDirectory,testConfig.getRunTimeProperty("tin"));
		return this;
	}
	
	public SearchRemittance clickEpraPDFlink(String srchType)
	{
		String actualPaymntNo="";
		String expectedPaymntNo="";
		boolean found=false;
		if(srchType.equals("byDOPAndNpi"))
		{
			//expectedPaymntNo=testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
			
			System.out.println(System.getProperty("ELECTRONIC_PAYMENT_NUMBER"));
	    	
	    	expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
	    	
	    	String paymentNum = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
			
			searchResultRows=Element.findElements(testConfig, "xpath", "//*[@id='searchRemittanceResultsForm']/table//tr[8]/td/table/tbody/tr/td/table/tbody/tr");
		}
		else if(srchType.equals("byElectronicPaymentNo"))
		{
			expectedPaymntNo=testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
			expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
			String paymentNum = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
			searchResultRows=Element.findElements(testConfig, "xpath", "//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr");
		}
		else if(srchType.equals("viewPayments"))
		{
			searchResultRows=Element.findElements(testConfig, "xpath", "//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr");
			expectedPaymntNo=testConfig.getRunTimeProperty("dspl_consl_pay_nbr");
			Log.Comment("The DSP_CONSL_PAY_NBR is :" + expectedPaymntNo);
		}
		WebElement popUp=null;
		WebElement lnkEpraPdf=null;
		int totalNoOfPages=getNumberOfPages();		
    	Log.Comment("Total No. of pages are :" + totalNoOfPages);
    	for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
    	    if(testConfig.driver.getPageSource().toString().contains(expectedPaymntNo)) 
		     {
		       for(int i=1;i<searchResultRows.size();i++)
		        {
		    	 if(srchType.equals("viewPayments"))
				{
				String xpath="//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr["+(i+1)+"]/td[4]";
				actualPaymntNo= Element.findElement(testConfig, "xpath", xpath).getText();
				}
				  else{
				  actualPaymntNo=searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
			      actualPaymntNo=actualPaymntNo.replace("\n", "");
				  }
				 //if(actualPaymntNo.contains(expectedPaymntNo))
				 if(actualPaymntNo.equals(expectedPaymntNo))
			       {	
			    	  found=true;
			    	  if(srchType.equals("byDOPAndNpi"))
			    		  lnkEpraPdf=Element.findElement(testConfig, "xpath", "//*[@id='searchRemittanceResultsForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr["+(i+1)+"]/td[4]/../td[8]/table/tbody/tr/td[3]/span[3]//img");
			    	  else if(srchType.equals("byElectronicPaymentNo"))
			    		  lnkEpraPdf=Element.findElement(testConfig, "xpath", "//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr["+(i+1)+"]/td[4]/../td[8]/table/tbody/tr/td[3]/span[3]//img");
			    	  else if(srchType.equals("viewPayments"))
			    		  lnkEpraPdf=Element.findElement(testConfig, "xpath", "//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr["+(i+1)+"]/td[11]/table/tbody/tr/td[3]/span/span/a/img");                  
					  
					  Browser.wait(testConfig, 5);
				     Browser.scrollTillAnElement(testConfig, lnkEpraPdf, "Epra Link found for Display Consolidated No. :" + actualPaymntNo);
				     Element.verifyElementPresent(lnkEpraPdf, "EPRA pdf icon");
				     Element.click(lnkEpraPdf, "PDF Link for EPRA for Display Consolidated No. :" + actualPaymntNo);
				     Browser.wait(testConfig, 10);
				     System.setProperty("expectedPaymntNo", expectedPaymntNo);
    	             break;   
				   }
		        }
		     }
    	    if(found==true)break;
    	    else if(pageNo%10!=0 && pageNo<totalNoOfPages){  
				 int pageToBeClicked=pageNo+1;
				 Log.Comment("Non ePRA payment not found on page number " + pageNo);
				 
				 Element.findElement(testConfig,"xpath","//body/div/table/tbody/tr/td/table/tbody/tr/td/form/table/tbody/tr[7]/td[1]/span[1]/a["+ pageToBeClicked +"]").click();
				 //Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]").click();
				 Log.Comment("Clicked Page number : " + pageToBeClicked);
				 Browser.waitForLoad(testConfig.driver);
			     }
   	    
			  else if(pageNo%10==0 && totalNoOfPages!=2 && pageNo<totalNoOfPages){
				   Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
			       Element.click(lnkNextPage,"Next Link");
			       Browser.waitForLoad(testConfig.driver);
			       Browser.wait(testConfig,3);
			       
			    }
			  else
			     Log.Warning("Could not find nonEpra payment on any of the pages, please execute test case manually", testConfig);
		    }
		 
		return this;
	}
	
	
	public SearchRemittance verifyUsrEvntLog()
	{
		int sqlRowNo=207;
		Map data=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		
		Log.Comment("The Data from User Event Log Table is:" + data);
		Helper.compareContains(testConfig, "EPRA is downloaded",testConfig.getRunTimeProperty("tin"), data.get("EVNT_MSG").toString());
		//Helper.compareContains(testConfig, "EPRA is downloaded",testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER"), data.get("EVNT_MSG").toString());
		//Helper.compareContains(testConfig, "EPRA is downloaded", "DataAccess:SUCCESS:Protected Data Access: :Payment Summary(PrintEPRA):P:", data.get("EVNT_MSG").toString());
		return this;
	}
	
	public SearchRemittance verifyNoEpraPdfIcon()
	{
		Element.verifyElementNotPresent(imgEPRApdf, "EPRA PDF ICON");
		Element.verifyElementNotPresent(lnkEpraPDF, "EPRA PDF link");
		return this;
	}
	
	
	
	public SearchRemittance verifyUsrEvntLogRemitDetail()
	{
	
	    
		int sqlRowNo=207;
		Map data=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Log.Comment("The Data from User Event Log Table is:" + data);
		Helper.compareContains(testConfig, "EPRA is downloaded", testConfig.getRunTimeProperty("id"), data.get("EVNT_MSG").toString());
		
		return this;
	}
	
	
	public SearchRemittance verifyUsrEvntLogForSrchRemit(String userType)
	{
//		String env=System.getProperty("env");
//	    String id=testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+userType+"_"+env);
//	    testConfig.putRunTimeProperty("id", id);
	    
		System.getProperty("id");
		System.out.println(System.getProperty("id"));
	    int sqlRowNo=207;
		Map data=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Log.Comment("The Data from User Event Log Table is:" + data);
		//Helper.compareContains(testConfig, "EPRA is downloaded", testConfig.getRunTimeProperty("id"), data.get("EVNT_MSG").toString());
		Helper.compareContains(testConfig, "EPRA is downloaded", System.getProperty("id"), data.get("EVNT_MSG").toString());
	    
		return this;
		
	}
	
	public SearchRemittance verifyUsrEvntLogRemitDetailCSR(String userType)
	{
		
		String env=System.getProperty("env");
	    String id=testConfig.runtimeProperties.getProperty("CSR_"+"ID_"+userType+"_"+env);
	    testConfig.putRunTimeProperty("id", id);
	    
	    int sqlRowNo=207;
		Map data=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Log.Comment("The Data from User Event Log Table is:" + data);
		Helper.compareContains(testConfig, "EPRA is downloaded", testConfig.getRunTimeProperty("id"), data.get("EVNT_MSG").toString());
		
		
		return this;
	
	}
	
	public SearchRemittance verifyfileinNASDrive() throws SftpException, JSchException
	{
		
		sFTPAccess obj_FTPaccess = new sFTPAccess();	
		//Connecting to sFTP location
		obj_FTPaccess.connect();	
		//Calling isFileAvailable function to validate file presence

		//srchRemittance.getPDFfileName();
		System.out.print("----File name using get property-->"+System.getProperty("PDFFileName"));
		
		String TIN = System.getProperty("tin");
		
		Log.Comment("Tin retrieved from other class is:" + TIN);

		Log.Comment("/home/ppsstg/stg/erapdf/pdf/"+System.getProperty("tin").substring(0,2)+"/"+System.getProperty("tin")+"/",System.getProperty("PDFFileName"));
		Log.Comment("/home/ppsstg/stg/erapdf/pdf/"+System.getProperty("tin").substring(0,2)+"/"+System.getProperty("tin")+"/"+System.getProperty("PDFFileName"));
		
		System.out.println((obj_FTPaccess.IsFileAvailable("/home/ppsstg/stg/erapdf/pdf/"+System.getProperty("tin").substring(0,2)+"/"+System.getProperty("tin")+"/",System.getProperty("PDFFileName"))));
		
		
		
		if(obj_FTPaccess.IsFileAvailable("/home/ppsstg/stg/erapdf/pdf/"+System.getProperty("tin").substring(0,2)+"/"+System.getProperty("tin")+"/"+"" ,System.getProperty("PDFFileName")))
		{
		System.out.print("*(((------File Available*");
		System.out.print("*(((------File PDFFileName*"+System.getProperty("PDFFileName")+"---");
		obj_FTPaccess.DeleteFile("/home/ppsstg/stg/erapdf/pdf/"+System.getProperty("tin").substring(0,2)+"/"+System.getProperty("tin")+"/",System.getProperty("PDFFileName"));
		Log.Comment("/******** Deleted File from NAS DRIVE *********/");
		
	}
		
		
		//Closing sFTP connection
		obj_FTPaccess.Closeconnection();
		
		//Deleting CONSL_PAY_NBR row from EPRA_STATUS Table 
		
		int sqlRowNo=209;
		String expectedPaymntNo="";
		expectedPaymntNo=testConfig.getRunTimeProperty("CONSL_PAY_NBR");
		DataBase.executeDeleteQuery(testConfig, 212);
		System.out.println(DataBase.executeDeleteQuery(testConfig, 1));
		Browser.wait(testConfig, 3);
		
		
		return this;
		
	}
	
	public paymentSummary verifyppraStatus(String expectedStatus) 
	 {
		int sqlRowNo=229;//34;		
		Map ppraStatusTbl=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "Status in Epra status for payment number : " + ppraStatusTbl.get("CONSL_PAY_NBR"), expectedStatus, ppraStatusTbl.get("REQ_STS").toString());
		return this;
		
	 } 
	
	public paymentSummary getPDFfileName() 
	 {
		int sqlRowNo=178;//34;
		Map epraStatusTbl=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		String str ;
		System.out.print("----Converted-PDFFIleName-->"+epraStatusTbl.get("PDF_FL_NM"));
		System.setProperty("PDFFileName", (String) epraStatusTbl.get("PDF_FL_NM"));
	
		return this;
		
	 } 
}
