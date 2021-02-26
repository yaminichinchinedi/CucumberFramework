package main.java.pageObjects;

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
import org.xml.sax.SAXException;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

//import main.java.Utils.Config;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.SFTPAccess;
import main.java.api.manage.EpsPaymentsSearch.EpsSearchRemittanceRequestHelper;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.api.pojo.epspaymentsearch.request.SearchByCriteriaRequest;
import main.java.api.pojo.epspaymentsearch.jsonrequest.DOP;
import main.java.api.pojo.epspaymentsearch.jsonrequest.DOS;
import main.java.api.pojo.epspaymentsearch.jsonrequest.ParameterMap;
import main.java.api.pojo.epspaymentsearch.jsonrequest.PaymentMadeOnDateRange;
import main.java.api.pojo.epspaymentsearch.jsonrequest.ClaimServiceDateRange;
import main.java.api.pojo.epspaymentsearch.jsonrequest.SearchCriteria;
import main.java.api.pojo.epspaymentsearch.jsonresponse.EpsConsolidatedClaimPaymentSummaries;
import main.java.api.pojo.epspaymentsearch.jsonresponse.EpsPaymentsSummarySearchResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class SearchRemittance extends ViewPayments {
	
	//@FindBy(xpath="//td[@class='errors']")
	@FindBy(xpath = "//td[contains(text(),'No records match the selected search criteria. Cho')]")
	WebElement errorMsg;
	
	@FindBy(xpath="//td[contains(text(),'No records')]")
	WebElement CSRErrorMsg;
	
	@FindBy(xpath="//td[contains(text(),'Record Count')]")
	WebElement recordCount;
	
	//amit
	//@FindBy(xpath = "//div[@id='SearchHeader']//table//tr") 
	@FindBy(xpath = "//*[@id='search-remmitance']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr")
	//*[@id="SearchHeader"]/table/tbody/tr[1]
	//*[@id="search-remmitance"]/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr[2]/td[1]
	public List<WebElement> divSearchResults;

	@FindBy(xpath = "//*[@id='SearchHeader']/table/tbody/tr")
	public List<WebElement> divSearchResultsUPA;
	
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
	
	//@FindBy(xpath="//tr[@class='columnHeaderText']")
	@FindBy(xpath="//tr[@class='search-remittance__table_header']")
	List<WebElement> searchResultsHeaderRow;
	
	@FindBy(xpath="//tr[@class='columnHeaderText']")
	List<WebElement> searchResultsPrintHeaderRow;
	
	@FindBy(id = "saveArchive")
	WebElement btnSaveArchive;

	@FindBy(id = "paymentNbr_1")
	WebElement paymentNbr1;
	
	@FindBy(xpath="//span[contains(@id,'epra')]//img")
	WebElement imgEPRApdf;
	
	@FindBy(name="printSearchResult")
	WebElement printSearchResultsButton;
	
	@FindBy(xpath="//b[contains(text(),'Payer')]")
	//@FindBy(xpath="//td[contains(text(),'Payer')]")
	WebElement payer;
	
	
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
		//Ask..why it is commented
		
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
		String totalRecordsFromFISL=String.valueOf(searchResponse.getData().getTotalCount());
		
		if(testConfig.getRunTimeProperty("testSuite").equals("UPA"))
		 {
			Helper.compareEquals(testConfig, "Record Count from FISL and UI :",totalRecordsFromFISL,getRecordCountFromUISR());
		   if(!totalRecordsFromFISL.equalsIgnoreCase("0"))
			Helper.compareMaps(testConfig, "Payments Details Comparison ",getSRDetailsFromFISL(requestType,searchResponse), getSRDetailsFromUI(requestType));	
		  else
		  Element.verifyTextPresent(errorMsg,"No records match the selected search criteria. Choose a different search option or try your search again later.");
//		   Helper.compareEquals(testConfig, "Record Count from FISL and DB :",totalRecordsFromFISL,getRecordCountFromDB(requestType));
		}
		else 
			Helper.compareMaps(testConfig, "Payments Details Comparison ",getSRDetailsFromFISL(requestType,searchResponse), getSRDetailsFromUI(requestType));	
			//verifyPaymentDetailsForCSR(requestType,searchResponse);
     }
	
	
	public void verifyPaymentDetailsForCSR(String requestType,EpsPaymentsSummarySearchResponse searchResponse) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		String totalRecordsFromFISL=String.valueOf(searchResponse.getData().getTotalCount());
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
		Object request = null;
		EpsSearchRemittanceRequestHelper epsSearchRemittanceRequestHelper = new EpsSearchRemittanceRequestHelper(requestType);
		if (requestType.contains("DOP")|| requestType.equals("byElectronicPaymentNo") || requestType.equals("byCheckNo")) {
			DOP dop = new DOP();
	        dop.setTaxIdentifier(testConfig.getRunTimeProperty("tin").trim());
	        dop.setUserRole("PROVIDER");
	        PaymentMadeOnDateRange paymentMadeOnDateRange = dop.getPaymentMadeOnDateRange();
	        paymentMadeOnDateRange.setFromDate(testConfig.getRunTimeProperty("fromDate"));
	        paymentMadeOnDateRange.setToDate(testConfig.getRunTimeProperty("toDate"));
			String[] identifier = new String[] {};
			dop.setEpsNationalProviderIdentifiers(identifier);
			if (requestType.equals("byElectronicPaymentNo") || requestType.equals("byCheckNo") ) {
				SearchCriteria searchCriteria = dop.getSearchCriteria();
				ArrayList<ParameterMap> parameterMapList = new ArrayList<>();
				ParameterMap parameterMap = new ParameterMap();
				parameterMap.setKey("PAYMENT_LEVEL_DETAIL");
				parameterMap.setValue("Y");
				parameterMap.setComparator("Equals");
				parameterMapList.add(parameterMap);
				parameterMap = new ParameterMap();
				parameterMap.setKey(testConfig.getRunTimeProperty("key1"));
				parameterMap.setValue(testConfig.getRunTimeProperty("value1"));
				parameterMap.setComparator("Equals");
				parameterMapList.add(parameterMap);

				searchCriteria.setParameterMap(parameterMapList);
				String[] identifiers = new String[] {};
				dop.setEpsNationalProviderIdentifiers(identifiers);
			}
			if (requestType.equals("byDOPAndNpi")) {
			String[] identifiers = new String[] {testConfig.getRunTimeProperty("NPI").trim()};
			dop.setEpsNationalProviderIdentifiers(identifiers);
			}
	        System.out.println("DOP=" + dop.toString());
	        request = dop;
		}
		if (requestType.equals("byDOS") || requestType.equals("byDOSAndAcntNo") || requestType.equals("byDOSAndSubscriberId") || requestType.equals("byDOSAndClmNo") || (requestType.equals("byDOSAndPtntNm")) || (requestType.equals("byDOSAndNpi"))) {
			DOS dos = new DOS();
			dos.setTaxIdentifier(testConfig.getRunTimeProperty("tin").trim());
			dos.setUserRole("PROVIDER");
			SearchCriteria searchCriteria = dos.getSearchCriteria();
			ArrayList<ParameterMap> parameterMapList = new ArrayList<>();
			ParameterMap parameterMap = new ParameterMap();
			parameterMap.setKey(testConfig.getRunTimeProperty("key"));
			parameterMap.setValue(testConfig.getRunTimeProperty("value"));
			parameterMap.setComparator("Equals");
			parameterMapList.add(parameterMap);
			if (requestType.equals("byDOSAndPtntNm")) {
				parameterMap = new ParameterMap();
				parameterMap.setKey(testConfig.getRunTimeProperty("key1"));
				parameterMap.setValue(testConfig.getRunTimeProperty("value1"));
				parameterMap.setComparator("Equals");
				parameterMapList.add(parameterMap);
			}
			searchCriteria.setParameterMap(parameterMapList);

			//String[] identifiers = new String[] {"03432","04271","04567","06111","19402","31417","36273","37602","56693","56758", "62952","65088","66214","78857","81400","86047","86050","87726","91785","94265","95378","95467","95959","96385","99726", "APP01","ECHOH","ERIE1","MCLRN","MDWS5","NYU01","PINNA","RPMP5","SAM1","TEX01","UFNEP","UMR01","VACCN","WID01"};
			if (requestType.equals("byDOSAndNpi")) {
			String[] identifiers = new String[] {testConfig.getRunTimeProperty("NPI").trim()};
			dos.setEpsNationalProviderIdentifiers(identifiers);
			}
			else {
			String[] identifiers = new String[] {};
			dos.setEpsNationalProviderIdentifiers(identifiers);
			}
			ClaimServiceDateRange claimServiceDateRange = dos.getClaimServiceDateRange();
			claimServiceDateRange.setFromDate(testConfig.getRunTimeProperty("fromDate"));
			claimServiceDateRange.setToDate(testConfig.getRunTimeProperty("toDate"));
			System.out.println("\nDOS=" + dos.toString());
			request = dos;
		}

		if (requestType.equals("byDOPAndAccountNo") || requestType.equals("byDOP&SubscriberID") || requestType.equals("byDOPAndClaimNo") || (requestType.equals("byDOPAndPatientNm"))) {
			DOP dopAccountNumber = new DOP();
			dopAccountNumber.setTaxIdentifier(testConfig.getRunTimeProperty("tin").trim());
			dopAccountNumber.setUserRole("PROVIDER");

			SearchCriteria searchCriteria = dopAccountNumber.getSearchCriteria();
			ArrayList<ParameterMap> parameterMapList = new ArrayList<>();
			ParameterMap parameterMap = new ParameterMap();
			parameterMap.setKey(testConfig.getRunTimeProperty("key"));
			parameterMap.setValue(testConfig.getRunTimeProperty("value"));
			parameterMap.setComparator("Equals");
			parameterMapList.add(parameterMap);
			if (requestType.equals("byDOPAndPatientNm")) {
				parameterMap = new ParameterMap();
				parameterMap.setKey(testConfig.getRunTimeProperty("key1"));
				parameterMap.setValue(testConfig.getRunTimeProperty("value1"));
				parameterMap.setComparator("Equals");
				parameterMapList.add(parameterMap);
			}
			searchCriteria.setParameterMap(parameterMapList);
			PaymentMadeOnDateRange paymentMadeOnDateRange = dopAccountNumber.getPaymentMadeOnDateRange();
			paymentMadeOnDateRange.setFromDate(testConfig.getRunTimeProperty("fromDate"));
			paymentMadeOnDateRange.setToDate(testConfig.getRunTimeProperty("toDate"));
			String[] identifier = new String[] {};
			dopAccountNumber.setEpsNationalProviderIdentifiers(identifier);
			System.out.println("\nDOP Account Number=" + dopAccountNumber.toString());
			request = dopAccountNumber;

		}


			EpsPaymentsSummarySearchResponse searchResponse = (EpsPaymentsSummarySearchResponse) epsSearchRemittanceRequestHelper.postRequestGetResponse(request);
	return searchResponse;
	}
	
	public Object getFISLResponse1(String requestType) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		/**Creates POJO for Request.xml so that we can modify the elements*/
		EpsSearchRemittanceRequestHelper epsSearchRemittanceRequestHelper = new EpsSearchRemittanceRequestHelper(requestType);
		EpsPaymentsSearchRequest epsSearchRemittanceSearchRequest=epsSearchRemittanceRequestHelper.createRequestPojo();

		/**set the request data*/
		epsSearchRemittanceSearchRequest=setTinNumber(epsSearchRemittanceSearchRequest);
		
		if(requestType.equals("byDOPAndPatientNm")||requestType.equals("byElectronicPaymentNo")||requestType.equals("byCheckNo"))
			setMapEntryKey2(epsSearchRemittanceSearchRequest);
		
	    setMapEntryKey(epsSearchRemittanceSearchRequest);
	    
	    try{
	    setServiceData(epsSearchRemittanceSearchRequest);
	    }
	    catch(Exception e)
	    {
	    	Log.Comment("check service daTA");
	    }
	    
	    if(requestType.contains("byDOPAndNpi")||requestType.contains("byDOSAndNpi"))
	    	setNPINumber(epsSearchRemittanceSearchRequest);
	    
	    if(requestType.contains("byDOS")) 
	     setToAndFromDateDOS(epsSearchRemittanceSearchRequest);
	    else
			setToAndFromDate(epsSearchRemittanceSearchRequest);
	 
	    if(testConfig.getRunTimeProperty("835ID")!=null)
	    setPayerID(epsSearchRemittanceSearchRequest);

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
		if(testConfig.getRunTimeProperty("key1")!=null)
	  {
		
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(1).setKey(testConfig.getRunTimeProperty("key1"));
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(1).setValue(testConfig.getRunTimeProperty("value1"));
	  }	
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
			Collections.sort(listString);
			
			/*Collections.sort(listOfPatients,new Comparator<ArrayList<String>>(){

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
					newList.add(listOfPatients.get(0).get(0));*/
				
//			Element.clickByJS(testConfig, lnkName, colName);
			Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
			actualListString = getColumnValue(colName);	
			for(int i=0;i<listString.size();i++)
				newList.add(listString.get(i));
				
			Helper.compareEquals(testConfig, colName, newList, actualListString);

			// now sorting in descending order
			Collections.sort(listString, Collections.reverseOrder());
			newList.clear();
			if(listString.size()<30)
				for(int i=0;i<listString.size();i++)
					newList.add(listOfPatients.get(i).get(0));
			else
				for(int i=0;i<30;i++)
					newList.add(listOfPatients.get(i).get(0));
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
			double amount = Double.parseDouble(s.replace(",", "").replace("$", ""));
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
	   int startingLoop=1;
		if(requestType.equalsIgnoreCase("byElectronicPaymentNo")||requestType.equalsIgnoreCase("byCheckNo")||requestType.equalsIgnoreCase("byDOPAndNpi"))
			startingLoop=1;
	
	   LinkedHashMap<String,String> innerMap = null;
	
	   Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	   ArrayList<String> headers=getHeadersFromResultTable();
	   int totalNoOfPages=getNumberOfPagesSR();
	   if(totalNoOfPages>2)
		 totalNoOfPages=1;
	 
		   if("printPaymentSummary".equals(testConfig.getRunTimeProperty("page"))) {
		   		divSearchResultsUPA=Element.findElements(testConfig, "xpath", "//*[@id='SearchHeader']/table/tbody/tr/td/table/tbody/tr");
		   }
		   else {
	   			divSearchResultsUPA=Element.findElements(testConfig, "xpath", "//*[@id='SearchHeader']/table/tbody/tr");
		   }
	   
	   if(requestType.equalsIgnoreCase("byElectronicPaymentNo") || requestType.equalsIgnoreCase("byCheckNo")) {
		   if("printPaymentSummary".equals(testConfig.getRunTimeProperty("page"))) {
			   divSearchResultsUPA=Element.findElements(testConfig, "xpath", "//*[@id='searchRemittanceResultsForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr");
		   }
		   else {
			   divSearchResultsUPA=Element.findElements(testConfig, "xpath", "//*[@id='search-remmitance']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");
		   }
	   }
	   if(requestType.equalsIgnoreCase("byDOPAndNpi") || requestType.equalsIgnoreCase("byDOSAndNpi")) {
		   if("printPaymentSummary".equals(testConfig.getRunTimeProperty("page"))) {
			   divSearchResultsUPA=Element.findElements(testConfig, "xpath", "//*[@id='searchRemittanceResultsForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr");
	   }
		   else {
			   divSearchResultsUPA=Element.findElements(testConfig, "xpath", "//*[@id='search-remmitance']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr");
		   }
	   }
	   Log.Comment("Fetching all payments From UI..");
	   String details="";
	   String amount="";
	
	   for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
			for(int i=startingLoop;i<divSearchResultsUPA.size();i++)
		    {
			   innerMap=new LinkedHashMap<String,String>();
			   
			   for(int j=0,k=0;j<headers.size();j++,k++)
			    {	
				   if(headers.get(j).equals("Payer PRA"))
					   k=k+4;
				  details=divSearchResultsUPA.get(i).findElements(By.tagName("td")).get(k).getText();
			      //details=details.replace("\n", "");
			      if(headers.get(j).contains("Payment Status")) {
			    	  String[] detail = details.split("\n");
			    			  innerMap.put("Payment Status", detail[0]);}
			      
			      else
			      innerMap.put(headers.get(j), details);	
				 }
			    
			   if(requestType.equalsIgnoreCase("byElectronicPaymentNo")||requestType.equalsIgnoreCase("byCheckNo")||requestType.equalsIgnoreCase("byDOPAndNpi") || requestType.equalsIgnoreCase("byDOSAndNpi"))
			    { 
			      if(innerMap.get("Amount").contains(","))
			      {
			         amount=innerMap.get("Amount").replace(",", "");
			         innerMap.put("Amount", amount);
			      }
//			      if(innerMap.get("Amount").equals("$0.00")&& (innerMap.get("Type").equals("NON")||innerMap.get("Type").equals("DD")))
//					     innerMap.put("Type","Non||DD");
			    }
			   else
			   {
				  if(innerMap.get("Claim Amount").contains(","))
			       {
				      amount=innerMap.get("Claim Amount").replace(",", "");
				      innerMap.put("Claim Amount", amount);
				   }
			   }
			   
			   if(innerMap.keySet().contains("Account Number"))
			   {
				   String accNo=null;
			    if(innerMap.get("Account Number").contains(" "))
			    {
			    	accNo=innerMap.get("Account Number").replaceAll(" ", "");
			        innerMap.put("Account Number", accNo);
			    }
			   }
			   
			   
			   
			   innerMap.remove("Redemption Date");
			   innerMap.remove("Proxy Number");
			   innerMap.remove("Payer");
			   innerMap.remove("835 / EPRA");
			   innerMap.remove("Payer PRA");
			   innerMap.remove("Returned Reason");
//			   innerMap.put("Payment Status",innerMap.get("Payment Status / Trace Number"));
			   innerMap.remove("ACH Trace Number");
			   innerMap.remove("Payment Status");

			   
			   String cl=null;
			 
			   if(innerMap.get("Claim Date")!=null)
					cl=innerMap.get("Claim Date");
				else
					cl=innerMap.get("Payment Date");
			 
			   outerMap.put(innerMap.get("Payment Number")+"_"+innerMap.get("Patient Name")+"_"+innerMap.get("Subscriber ID")+"_"+cl, innerMap);
//			   if(requestType.equalsIgnoreCase("byDOPAndNpi"))
//				   i=i+2;
//				   else 
//			   if(requestType.equalsIgnoreCase("byDOSAndNpi"))
//				   i=i+1;
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
					   Log.Comment("Page Number is multiple of 10..so clicking Next");
			           Element.click(lnkNextPage,"Next Link");
			           Browser.wait(testConfig,3);
			           pageNo++;
			     }
			 
		 }
	   
//	   Log.Comment("UI details " +(outerMap));
		return outerMap;
	   
    }
	
	
	public LinkedHashMap<String,String> getPaymentDetailsFromCSRUI()
	{	   
	   /**Gets headers List which will be key for following map*/
		
	   LinkedHashMap<String,String> innerMap = null;
	   Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	   ArrayList<String> headers=getHeadersFromResultTable();
	   
	   //int totalNoOfPages=getNumberOfPages();
	   
	   //if(totalNoOfPages>2)
		 int totalNoOfPages=1;
		   
	   //if(divSearchResults.size()==0)
		   divSearchResults=Element.findElements(testConfig, "xpath", ".//*[@id='search-remmitance']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");
	                                                                   //*[@id="searchRemittanceResultsForm"]/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody
	     //if(divSearchResults.size()==0)
	    	//divSearchResults=Element.findElements(testConfig, "xpath",".//*[@id='search-remmitance']/table/tbody/tr[8]/td/table/tbody/tr/td/table//tr");
	   
//	   Log.Comment("Fetching all payments From UI..");
	   
	   for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
			for(int i=1;i<divSearchResults.size();i++)
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
					   Log.Comment("Page Number is multiple of 10..so clicking Next");
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
	   for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
			for(int i=1;i<divSearchResults.size();i++)
		    {
			   innerMap=new LinkedHashMap<String,String>();
			   
			   for(int j=0;j<headers.size();j++)
			    {	
			      String details=divSearchResults.get(i).findElements(By.tagName("td")).get(j).getText();
			      details=details.replace("\n", "");
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
					   Log.Comment("Page Number is multiple of 10..so clicking Next");
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
		int noOfHeaders = 0;
	     String header;
	   List <String> headerList=new ArrayList<String>();
	   if("printPaymentSummary".equals(testConfig.getRunTimeProperty("page"))) {
		   noOfHeaders=searchResultsPrintHeaderRow.get(0).findElements(By.tagName("td")).size();
		   }
	   else {
		   noOfHeaders=searchResultsHeaderRow.get(0).findElements(By.tagName("td")).size();
	   }
	   for (int i=0;i<noOfHeaders;i++)
	   {
		   if("printPaymentSummary".equals(testConfig.getRunTimeProperty("page"))) {
			   	 header=searchResultsPrintHeaderRow.get(0).findElements(By.tagName("td")).get(i).getText();
		   }
		   else {
			     header=searchResultsHeaderRow.get(0).findElements(By.tagName("td")).get(i).getText();
		   }
		headerList.add(header);
		}
	return (ArrayList<String>) headerList;
	   
    }
	
	public Map<String, LinkedHashMap<String, String>> getSRDetailsFromFISL(String requestType,Object FISLResponse) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		int totalPayments;
		LinkedHashMap<String,String> innerMap = null;
	    EpsConsolidatedClaimPaymentSummaries[] payments=((EpsPaymentsSummarySearchResponse) FISLResponse).getData().getEpsConsolidatedClaimPaymentSummaries();
	    Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	    if(((EpsPaymentsSummarySearchResponse) FISLResponse).getData().getTotalCount()>30)
			 totalPayments=30;
		  else
			totalPayments=payments.length;
			
		  for(int i=0;i<totalPayments;i++)
		  {
			 
			innerMap=new LinkedHashMap<String, String>();
			
			if(requestType.equals("byDOP")||requestType.equals("byElectronicPaymentNo")||requestType.equalsIgnoreCase("byCheckNo")||requestType.equalsIgnoreCase("byDOPAndAccountNo"))
//			innerMap.put("Payer/Patient",getDisplayPayerNameFromDB(payments[i].getPayerSummary().getName()));
			
//			innerMap.put("Payer",getDisplayPayerNameFromDB(payments[i].getPayerSummary().getName()));
			innerMap.put("Payer","UnitedHealthcare");

			String patientName=payments[i].getPatientFirstName()+" " + payments[i].getPatientMiddleName()+" "+payments[i].getPatientLastName();
			patientName=patientName.replace("null ", "").trim();
			
			
			if(requestType.equals("byDOPAndAccountNo")||requestType.equals("byDOP")||requestType.equals("byDOPAndRenderingProvider")|| requestType.equals("byDOPAndPatientNm") ||
					requestType.equals("byDOSAndAcntNo")||requestType.equals("byDOS")||requestType.equals("byDOSAndRenderingProvider")|| requestType.equals("byDOSAndPatientNm") || requestType.equals("byDOSAndSubscriberId") || requestType.equals("byDOSAndClmNo") || requestType.equals("byDOPAndClaimNo")
					|| requestType.equals("byDOSAndPtntNm"))
			 {
			   if(payments[i].getClaimDate()!=null)
			   innerMap.put("Claim Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getClaimDate(),"yyyy-MM-dd", "MM-dd-yyyy")));
			  else 
			  innerMap.put("Claim Date","");
			 }
			else
//				if(payments[i].getClaimDate()!=null)
//					 innerMap.put("Claim Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getClaimDate(),"yyyy-MM-dd", "MM-dd-yyyy")));
//				else
			  innerMap.put("Payment Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getPaymentMadeOn(),"yyyy-MM-dd", "MM-dd-yyyy")));
		  
			if(payments[i].getNationalProviderIdentifier()!=null)
		    innerMap.put("NPI",payments[i].getNationalProviderIdentifier());
			else 
			innerMap.put("NPI",""); 
			innerMap.put("Payment Number",payments[i].getDisplayConsolidatedPaymentNumber());
			
			
			if(!(requestType.equals("byElectronicPaymentNo")||requestType.equals("byCheckNo")||requestType.equals("byDOPAndNpi")||requestType.equals("byDOSAndNpi")))
			 {
			    if(patientName!="")
			      innerMap.put("Patient Name",patientName);
			 }
			   
			if(!(requestType.equals("byDOPAndNpi") || requestType.equals("byDOSAndNpi"))) {
				if(payments[i].getSubscriberIdentifier()!=null)
				innerMap.put("Subscriber ID",payments[i].getSubscriberIdentifier());
			}
			if(!(requestType.equals("byElectronicPaymentNo")||requestType.equals("byCheckNo")||requestType.equals("byDOPAndNpi") || requestType.equals("byDOSAndNpi")))
			{
				if(payments[i].getPatientAccountNumber()!=null)
					innerMap.put("Account Number",payments[i].getPatientAccountNumber().replace(" ",""));
				else
					innerMap.put("Account Number","");
			}
				
			if(requestType.equals("byElectronicPaymentNo") || requestType.equals("byDOPAndNpi") || requestType.equals("byCheckNo") || requestType.equals("byDOSAndNpi")){
				if(payments[i].getClaimCountTotal()!=null)
					innerMap.put("Claim Count",String.valueOf(payments[i].getClaimCountTotal()));
//				else if(outerMap.containsValue("Claim Count")) {
//					innerMap.put("Claim Count" ,"");
//				}
				else
					innerMap.put("Claim Count","0");
			}
			
			
			if(!(requestType.equals("byElectronicPaymentNo") || requestType.equals("byDOPAndNpi") || requestType.equals("byCheckNo") || requestType.equals("byDOSAndNpi"))){
			if(payments[i].getClaimIdentifier()!=null)
			 {
			   innerMap.put("Claim #",payments[i].getClaimIdentifier());
			
			   if(payments[i].getClaimAmount().getAmmount() == 0.0 || payments[i].getClaimAmount().getAmmount() == 0.00)
			   innerMap.put("Claim Amount","$"+"0.00");
			   else
			  {
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format((payments[i].getClaimAmount().getAmmount()));
			    innerMap.put("Claim Amount","$"+ amount);
			    if(innerMap.get("Claim Amount").contains("-"))
			    {
			    	String claimAmount=innerMap.get("Claim Amount").replace("-", "");
			    	innerMap.put("Claim Amount","-"+ claimAmount);
			    }
			    	
			  }
			}
			}
			else
			{
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format((payments[i].getTotalAmount()));
			    innerMap.put("Amount","$"+ amount);
			}
			
//			innerMap.put("Type",payments[i].getPayeePaymentMethod().getPaymentMethodCode().getCode());
//			if(innerMap.get("Amount")!=null)
//			{ 
//			    if(innerMap.get("Amount").equals("$0.00"))
//				     innerMap.put("Type","Non||DD");
//			}
			
			 
// 			if(requestType.equals("byElectronicPaymentNo")||requestType.equals("byCheckNo")||requestType.contains("byDOP")||requestType.contains("byDOS")||requestType.equals("byDOSAndAcntNo"))
// 			{
// 				if(payments[i].getPaymentStatusCode().getDescription()!=null)
// 					innerMap.put("Payment Status".trim(),payments[i].getPaymentStatusCode().getDescription());
// 				else
// 					if(innerMap.get("Type").equals("ACH"))
// 						innerMap.put("Payment Status".trim(),"Successful ACH");
// 					else
// 					innerMap.put("Payment Status".trim(),"N/A");
// 			}
 			 
			innerMap.put("Market Type",getDisplayMarketType(payments[i].getPaymentTypeIndicator()));
			innerMap.remove("Payer");
			String cl=null;
			if(innerMap.get("Claim Date")!=null)
				cl=innerMap.get("Claim Date");
			else
				cl=innerMap.get("Payment Date");
			outerMap.put(innerMap.get("Payment Number")+"_"+innerMap.get("Patient Name")+"_"+innerMap.get("Subscriber ID")+"_"+cl, innerMap);
		 }
		  
		  
//		 Log.Comment("Details from FISL is :"  + '\n' +outerMap);
		 return outerMap;
	}
	
	public LinkedHashMap<String, String> getPaymentDetailsFromFISLForCSR(Object FISLResponse) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		int totalPayments;
		LinkedHashMap<String,String> innerMap = null;
		Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	
	    EpsConsolidatedClaimPaymentSummaries[] payments=((EpsPaymentsSummarySearchResponse) FISLResponse).getData().getEpsConsolidatedClaimPaymentSummaries();
		
//	    if((((EpsPaymentsSummarySearchResponse) FISLResponse).getData().getTotalCount())>30)
//			 totalPayments=30;
//		  else
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
			
			   if(payments[i].getClaimAmount().getAmmount() == 0.0 || payments[i].getClaimAmount().getAmmount() ==0.0)
			   innerMap.put("Claim Amount","$"+"0.00");
			   else
			  {
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format((payments[i].getClaimAmount().getAmmount()));
			    innerMap.put("Claim Amount","$"+ amount);
			  }
			}
			else
			{
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format(((payments[i].getTotalAmount())));
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
		
	    EpsConsolidatedClaimPaymentSummaries[] payments=((EpsPaymentsSummarySearchResponse) searchResponse).getData().getEpsConsolidatedClaimPaymentSummaries();
	    totalPayments=payments.length;
		
	    if(totalPayments>0)
	   {
		switch(colName)
		{
		
		case "Payer":
			for(int i=0;i<totalPayments;i++)
				list.add(getDisplayPayerNameFromDB(payments[i].getPayerSummary().getName()));
			break;
		case "Claim Date":
		case "Payment Date":
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
		case "Amount":
			for(int i=0;i<totalPayments;i++)
				if(payments[i].getClaimIdentifier()!=null && payments[i].getClaimAmount().getAmmount() ==0.0 || payments[i].getClaimAmount().getAmmount()==0.0)
					   list.add("$"+"0.00");
			   else
			  {
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format((payments[i].getClaimAmount().getAmmount()));
			    list.add("$"+ amount);
			  }
			break;
		case "Market Type":
			for(int i=0;i<totalPayments;i++)
				list.add(getDisplayMarketType(payments[i].getPaymentTypeIndicator()));
			break;	
		
		case "Archive":
			for(int i=0;i<totalPayments;i++)
				list.add(getArchiveIndicator(payments[i].getArchiveIndicator()));
			break;
		}
		
	  
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
		Browser.wait(testConfig, 2);
		Helper.isFileExist(fileDirectory,testConfig.getRunTimeProperty("tin"));
		return this;
	}
	
	public SearchRemittance clickEpraPDFlink(String srchType)
	{
		String actualPaymntNo="";
		String expectedPaymntNo="";
		boolean found=false;
		if(srchType.equals("byDOPAndNpi")||srchType.equals("EPRADOPAndNpi"))
		{
			//expectedPaymntNo=testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
			
			System.out.println(System.getProperty("ELECTRONIC_PAYMENT_NUMBER"));
	    	
			expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
			 System.setProperty("paymentNum", expectedPaymntNo);
			
			searchResultRows=Element.findElements(testConfig, "xpath", "//*[@id='searchRemittanceResultsForm']/table//tr[8]/td/table/tbody/tr/td/table/tbody/tr");
		}
		else if(srchType.equals("byElectronicPaymentNo")||srchType.equals("EPRAElectronicPaymentNo"))
		{
			//expectedPaymntNo=testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
			expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
			 System.setProperty("paymentNum", expectedPaymntNo);
			//String paymentNum = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
			searchResultRows=Element.findElements(testConfig, "xpath", "//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr");
		}
		else if(srchType.equals("viewPayments"))
		{
			searchResultRows=Element.findElements(testConfig, "xpath", "//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr");
			expectedPaymntNo=testConfig.getRunTimeProperty("dspl_consl_pay_nbr");
			 if ( expectedPaymntNo.length()>=15)
          	expectedPaymntNo= expectedPaymntNo.substring(0, 15);
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
				 if(actualPaymntNo.contains(expectedPaymntNo))
				// if(actualPaymntNo.equals(expectedPaymntNo))
			       {	
			    	  found=true;
			    	  if(srchType.equals("byDOPAndNpi")||srchType.equals("EPRADOPAndNpi"))
			    		  lnkEpraPdf=Element.findElement(testConfig, "xpath", "//*[@id='searchRemittanceResultsForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr["+(i+1)+"]/td[4]/../td[8]/table/tbody/tr/td[3]/span[3]//img");
			    	  else if(srchType.equals("byElectronicPaymentNo")||srchType.equals("EPRAElectronicPaymentNo"))
			    		  lnkEpraPdf=Element.findElement(testConfig, "xpath", "//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr["+(i+1)+"]/td[4]/../td[8]/table/tbody/tr/td[3]/span[3]//img");
			    	  else if(srchType.equals("viewPayments"))
			    		  lnkEpraPdf=Element.findElement(testConfig, "xpath", "//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr["+(i+1)+"]/td[11]/table/tbody/tr/td[3]/span/span/a/img");                  
					  
					 Browser.wait(testConfig, 5);
					// Browser.browserRefresh(testConfig);
					// Browser.wait(testConfig, 3);
					 if(srchType.equals("viewPayments"))
					 Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr["+(i+1)+"]/td[11]/table/tbody/tr/td[3]/span/span/a/img"), 60);
					 Element.verifyElementPresent(lnkEpraPdf, "EPRA pdf icon");
					 Browser.scrollTillAnElement(testConfig, lnkEpraPdf, "Epra Link found for Display Consolidated No. :" + actualPaymntNo);
				     Element.waitForElementTobeClickAble(testConfig, lnkEpraPdf, 60);
				     Element.click(lnkEpraPdf, "PDF Link for EPRA for Display Consolidated No. :" + actualPaymntNo);
				     Browser.wait(testConfig, 5);
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
		testConfig.getRunTimeProperty("id");
		//System.out.println("Login id is:"+testConfig.getRunTimeProperty("id"));
		Map data=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		
		Log.Comment("The Data from User Event Log Table is:" + data);
		Helper.compareContains(testConfig, "EPRA is downloaded",testConfig.getRunTimeProperty("id"), data.get("EVNT_MSG").toString());
		//Helper.compareContains(testConfig, "EPRA is downloaded",testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER"), data.get("EVNT_MSG").toString());
		//Helper.compareContains(testConfig, "EPRA is downloaded", "DataAccess:SUCCESS:Protected Data Access: :Payment Summary(PrintEPRA):P:", data.get("EVNT_MSG").toString());
		Browser.wait(testConfig, 3);
		if (testConfig.getRunTimeProperty("TobeDeleted")!=null && testConfig.getRunTimeProperty("TobeDeleted").equals("PROV"))
		DataBase.executeDeleteQuery(testConfig, 25);
		if (testConfig.getRunTimeProperty("TobeDeleted")!=null && testConfig.getRunTimeProperty("TobeDeleted").equals("BS"))
		DataBase.executeDeleteQuery(testConfig, 221);
		return this;
	}
	
	public SearchRemittance verifyNoEpraPdfIcon()
	{
		Element.verifyElementNotPresent(imgEPRApdf, "EPRA PDF ICON");
		Element.verifyElementNotPresent(lnkEpraPDF, "EPRA PDF link");
		return this;
	}
	
	public SearchRemittance verifyPayerText()
	{
		Helper.compareContains(testConfig, "Payer Text", "Payer", payer.getText());
		if(testConfig.driver.getPageSource().contains("No records match the selected search criteria. Cho")){
			Log.Comment("No Records Found", testConfig);
		}
		else{
			Element.click(printSearchResultsButton, "Print Search Results");
			String oldWindow=Browser.switchToNewWindow(testConfig,"printnpipaymentsearchresults.do");
			Helper.compareContains(testConfig, "Payer Text", "Payer", payer.getText());
		    Browser.switchToParentWindow(testConfig,oldWindow);
		}
		return this;
	}
	
	
	public SearchRemittance verifyUsrEvntLogRemitDetail()
	{
	
		System.getProperty("id");
		System.out.println(System.getProperty("id"));
		int sqlRowNo=207;
		Map data=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Log.Comment("The Data from User Event Log Table is:" + data);
		Helper.compareContains(testConfig, "EPRA is downloaded", testConfig.getRunTimeProperty("id"), data.get("EVNT_MSG").toString());
		Browser.wait(testConfig, 3);
		if (testConfig.getRunTimeProperty("TobeDeleted")!=null && testConfig.getRunTimeProperty("TobeDeleted").equals("PROV"))
		DataBase.executeDeleteQuery(testConfig, 25);
		if (testConfig.getRunTimeProperty("TobeDeleted")!=null && testConfig.getRunTimeProperty("TobeDeleted").equals("BS"))
		DataBase.executeDeleteQuery(testConfig, 221);
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
		Browser.wait(testConfig, 3);
		if (testConfig.getRunTimeProperty("TobeDeleted")!=null && testConfig.getRunTimeProperty("TobeDeleted").equals("PROV"))
		DataBase.executeDeleteQuery(testConfig, 25);
		if (testConfig.getRunTimeProperty("TobeDeleted")!=null && testConfig.getRunTimeProperty("TobeDeleted").equals("BS"))
		DataBase.executeDeleteQuery(testConfig, 221);
		return this;
		
	}
	
	public SearchRemittance verifyUsrEvntLogRemitDetailCSR(String userType)
	{
		
		String env=System.getProperty("env");
	    String id=testConfig.runtimeProperties.getProperty("CSR_"+"ID_"+userType+"_"+env);
	    
	    
	    int sqlRowNo=207;
	    testConfig.putRunTimeProperty("id", id);
		Map data=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Log.Comment("The Data from User Event Log Table is:" + data);
		Helper.compareContains(testConfig, "EPRA is downloaded", testConfig.getRunTimeProperty("id"), data.get("EVNT_MSG").toString());
		if (testConfig.getRunTimeProperty("TobeDeleted")!=null && testConfig.getRunTimeProperty("TobeDeleted").equals("PROV"))
			DataBase.executeDeleteQuery(testConfig, 25);
			if (testConfig.getRunTimeProperty("TobeDeleted")!=null && testConfig.getRunTimeProperty("TobeDeleted").equals("BS"))
			DataBase.executeDeleteQuery(testConfig, 221);
			
		return this;
	
	}
	
	public SearchRemittance verifyfileinNASDrive() throws SftpException, JSchException
	{
		
		SFTPAccess obj_FTPaccess = new SFTPAccess();	
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
	
	public ViewPayments verifyppraStatus(String expectedStatus) 
	 {
		int sqlRowNo=229;//34;		
		Map ppraStatusTbl = null;	
		for(int i=0;i<20;i++)
		{
			try
			{
				ppraStatusTbl=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
				System.out.print("Value status--->"+ppraStatusTbl.get("REQ_STS").toString());
				System.out.print("Value status--->"+expectedStatus);
				if(ppraStatusTbl.get("REQ_STS").toString().contains(expectedStatus)){
					break;				
				}
			}
			catch(Exception ex)
			{
				
			}
			
		}
		//ppraStatusTbl=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		
				
		Helper.compareEquals(testConfig, "Status in Epra status for payment number : " + ppraStatusTbl.get("CONSL_PAY_NBR"), expectedStatus, ppraStatusTbl.get("REQ_STS").toString());
		return this;		
		
	 } 
	
	public ViewPayments getPDFfileName() 
	 {
		int sqlRowNo=229;//34;
		Map epraStatusTbl=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		String str ;
		System.out.print("----Converted-PDFFIleName-->"+epraStatusTbl.get("PDF_FL_NM"));
		System.setProperty("PDFFileName", (String) epraStatusTbl.get("PDF_FL_NM"));
	
		return this;
		
	 } 

	
	public SearchRemittance validateHyfen()
{
		if (Element.findElement(testConfig, "xpath", "//*[@id='SearchCriteria']/table/tbody/tr/td").getText().contains("-"))
			Log.Fail("Search Criteria contains hyphen");
		else
			Log.Pass("Search Criteria do not contains hyphen");
		
		return this;
}


	
	public void verifyEPRAAndPayerPRA(String credentials) {
		if (credentials.equals("CSR")) {
			divSearchResults = Element.findElements(testConfig, "xpath",
					"//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");
			if (divSearchResults.get(1).findElements(By.tagName("td")).get(14).getText()
					.contentEquals("Patient Payments")) {
				Helper.compareEquals(testConfig, "Payer PRA", "N/A",
						divSearchResults.get(1).findElements(By.tagName("td")).get(11).getText());
				divSearchResults.get(1).findElements(By.tagName("td")).get(8).isDisplayed();
				Helper.compareEquals(testConfig, "835", "835",
						divSearchResults.get(1).findElements(By.tagName("td")).get(8).getText());
				Helper.compareEquals(testConfig, "EPRA", "N/A",
						divSearchResults.get(1).findElements(By.tagName("td")).get(10).getText());
			}

		} else {
			divSearchResults = Element.findElements(testConfig, "xpath",
					"//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");
			if (divSearchResults.get(1).findElements(By.tagName("td")).get(14).getText().contentEquals("Patient Payments")) {
				Helper.compareEquals(testConfig, "Payer PRA", "N/A",divSearchResults.get(1).findElements(By.tagName("td")).get(11).getText());
				
				divSearchResults.get(1).findElements(By.tagName("td")).get(8).isDisplayed();
				Helper.compareEquals(testConfig, "835", "835",divSearchResults.get(1).findElements(By.tagName("td")).get(8).getText());
				Helper.compareEquals(testConfig, "EPRA", "N/A",divSearchResults.get(1).findElements(By.tagName("td")).get(10).getText());
			}
		}

	}
	
	public SearchRemittance clickprintbutton(){
		Element.click(btnPrinttSearchResult, "Print Search Result Button");
		return this;
	}

	public ViewPayments verifyPrintSearchRemitPage(String requestType) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException{
		String parentWin=Browser.switchToNewWindow(testConfig);
		EpsPaymentsSummarySearchResponse searchResponse=(EpsPaymentsSummarySearchResponse) getFISLResponse(requestType);
		Helper.compareMaps(testConfig, "Print Search Remit Details Comparison",getSRDetailsFromFISL(requestType,searchResponse), getSRDetailsFromUI(requestType));
		Browser.switchToParentWindow(testConfig, parentWin);
		return this;
	}
	
}

