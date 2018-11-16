package main.java.pageObjects;

import groovy.transform.AutoClone;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
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
	
	@FindBy(linkText = "Archive")
	WebElement lnkArchive;
	
	@FindBy(xpath="//tr[@class='columnHeaderText']")
	List<WebElement> searchResultsHeaderRow;
	
	private TestBase testConfig;

	public SearchRemittance(TestBase testConfig)
	{
		super();
//		super(testConfig,true);
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.expectedWait(divSearchCriteria, testConfig, "Search Criteria section","Search Criteria section");
		
	}
	
	
	public void verifySearchResults(String requestType) throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		EpsPaymentsSummarySearchResponse searchResponse=(EpsPaymentsSummarySearchResponse) getFISLResponse(requestType);
		String totalRecordsFromFISL=searchResponse.getResponseReturnStatus().getTotalCount();
		
		if(testConfig.getRunTimeProperty("testSuite").equals("UPA"))
		 {
		   if(!totalRecordsFromFISL.equalsIgnoreCase("0"))
		   {
			Helper.compareEquals(testConfig, "Record Count from FISL and UI :",totalRecordsFromFISL,getRecordCountFromUI());
			Helper.compareMaps(testConfig, "Payments Details Comparison ",getPaymentDetailsFromFISL(searchResponse), getPaymentDetailsFromUI());	
		  }
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
		  Helper.compareMaps(testConfig, "Payments Details Comparison ",getPaymentDetailsFromFISLForCSR(searchResponse), getPaymentDetailsFromCSRUI());	
		else
		  Element.verifyTextPresent(errorMsg,"No records match the selected search criteria. Choose a different search option or try your search again later.");
		 
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
		
		if(requestType.equals("byDOP&PatientName")||requestType.equals("byElectronicPaymentNo"))
			setMapEntryKey2(epsSearchRemittanceSearchRequest);
		
	    setMapEntryKey(epsSearchRemittanceSearchRequest);
	    setServiceData(epsSearchRemittanceSearchRequest);
	    if(requestType=="byDOS") 
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
		int colSize=divSearchResults.get(0).findElements(By.tagName("td")).size();
		for(int i=0;i<colSize;i++)
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
	
	public List<String> getColumnValueS(String colName) 
	{	
		List<String> list = new ArrayList<String>();
		divSearchResults=Element.findElements(testConfig, "xpath", "//div[@id='SearchHeader']//table//tr");
		int noOfRows = divSearchResults.size();
		int colNumber=getColumnNo(colName);
		
		if(colName.equals("Archive"))
			for (int i=2; i<noOfRows; i++) 
			{
				Map attMap=Element.getAllAttributes(testConfig, divSearchResults.get(i).findElements(By.tagName("td")).get(colNumber).findElement(By.tagName("input")), "Access Level Attributes");
				String result=(String)attMap.get("CHECKED");
				list.add(result);
			}
		else
			for (int i=2; i<noOfRows; i++)
			{
				String result = divSearchResults.get(i).findElements(By.tagName("td")).get(colNumber).getText().toString();
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

	public List<Long> getColumnValueI(String colName) {
		Element.findElement(testConfig, "xpath", "//div[@id='SearchHeader']//table//tr");
		int noOfRows = divSearchResults.size();
		int colNumber=getColumnNo(colName);
		List<Long> list = new ArrayList<Long>();
		for (int i = 2; i < noOfRows; i++) {
			Long result = Long.parseLong(divSearchResults.get(i).findElements(By.tagName("td")).get(colNumber).getText().toString());
			list.add(result);
		}
		return list;
	}

	public List<Double> getColumnValueD(String colName) {
		List<Double> list = new ArrayList<Double>();
		Element.findElement(testConfig, "xpath", "//div[@id='SearchHeader']//table//tr");
		int noOfRows = divSearchResults.size();
		int colNumber=getColumnNo(colName);
		for (int i = 2; i < noOfRows; i++) {
			
			String claimAmount = divSearchResults.get(i).findElements(By.tagName("td")).get(colNumber).getText().toString();
			double amount = Double.parseDouble(claimAmount.substring(1, claimAmount.length()).replace(",", ""));
			list.add(BigDecimal.valueOf(amount).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		}		
		return list;
	}

	public void verifySortingOrder(WebElement lnkName, String colName) 
	{	
		switch(colName)
		{
		case "Payer":
		case "Payment Number":
		case "Patient Name":
		case "Subscriber ID":
		case "Account Number":
		case "Claim #":
		case "Archive":
		case "Market Type":
					List<String> listString = new ArrayList<String>();
					List<String> actualListString = new ArrayList<String>();
					listString = getColumnValueS(colName);
					Collections.sort(listString);
					Element.clickByJS(testConfig, lnkName, colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					actualListString = getColumnValueS(colName);					
					Helper.compareEquals(testConfig, colName, listString, actualListString);

					// now sorting in descending order
					Collections.sort(listString, Collections.reverseOrder());
					Element.clickByJS(testConfig, lnkName, colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					actualListString.clear();
					actualListString = getColumnValueS(colName);
					Helper.compareEquals(testConfig, colName, listString, actualListString);
					break;
					
		case "NPI":
					List<Long> listInteger = new ArrayList<Long>();
					List<Long> actualListInteger = new ArrayList<Long>();
					listInteger = getColumnValueI(colName);
					Collections.sort(listInteger);
					Element.clickByJS(testConfig, lnkName, colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");					
					actualListInteger = getColumnValueI(colName);
					Log.Comment("True specifies archive is checked and False specifies archive is unchecked");
					Helper.compareEquals(testConfig, colName, listInteger,	actualListInteger);

					// now sorting in descending order
					Collections.sort(listInteger, Collections.reverseOrder());
					Element.clickByJS(testConfig, lnkName, colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					actualListInteger = getColumnValueI(colName);
					Helper.compareEquals(testConfig, colName, listInteger, actualListInteger);
					break;
						
		case "Claim Amount":
					List<Double> listDouble = new ArrayList<Double>();
					List<Double> actualListDouble = new ArrayList<Double>();
					listDouble = getColumnValueD(colName);
					Collections.sort(listDouble);
					Element.clickByJS(testConfig, lnkClaimAmount, colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					actualListDouble = getColumnValueD(colName);
					Helper.compareEquals(testConfig, colName, listDouble,actualListDouble);

					// now sorting in descending order
					Collections.sort(listDouble, Collections.reverseOrder());
					Element.clickByJS(testConfig, lnkClaimAmount,colName);
					Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
					actualListDouble = getColumnValueD(colName);					
					Helper.compareEquals(testConfig, colName, listDouble, actualListDouble);
					break;
					
		case "Claim Date":
				listString = getColumnValueS(colName);
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
				Element.clickByJS(testConfig, lnkClaimDate, colName);
				Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
				actualListString = getColumnValueS(colName);
				Helper.compareEquals(testConfig, colName, listString,actualListString);
				
				// now sorting in descending order		
				Collections.reverse(listString);
				Element.clickByJS(testConfig, lnkClaimDate, colName);
				Element.expectedWait(divSearchCriteria, testConfig, "Search Results div", "Search Results div");
				actualListString = getColumnValueS(colName);
				Helper.compareEquals(testConfig, colName, listString,actualListString);
				break;
		}
	}

	public void verifySorting(String colName){
		switch(colName)
		{
		case "Payer":
			verifySortingOrder(lnkPayerName,colName);
			break;
		case "Claim Date":
			verifySortingOrder(lnkClaimDate, colName);
			break;
		case "NPI":
			verifySortingOrder(lnkNPI,"NPI");
			break;
		case "Payment Number":
			verifySortingOrder(lnkPaymentNumber,colName);
			break;
		case "Patient Name":
			verifySortingOrder(lnkPatientName,colName);
			break;
		case "Subscriber ID":
			verifySortingOrder(lnkSubscriberId,colName);
			break;
		case "Account Number":
			verifySortingOrder(lnkAccountNumber,colName);
			break;
		case "Claim #":
			verifySortingOrder(lnkClaimHash,colName);
			break;
		case "Claim Amount":
			verifySortingOrder(lnkClaimAmount, colName);
			break;
		case "Archive":
			verifySortingOrder(lnkArchive,colName);
			break;
		case "Market Type":
			verifySortingOrder(lnkMarketType,colName);
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
	
	
	public void verifyreturnedReasonDisplayed(String criteriaType,String portalName)
	{
		System.out.println(System.getProperty("testSuite"));
		switch(portalName)
		{
			case "CSR":
				divSearchResults=Element.findElements(testConfig, "xpath", ".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr"); //.//*[@id='searchRemittanceResultsForm']//tr[7]//tr[2]/td[13]/span
				String actualColName=divSearchResults.get(0).findElements(By.tagName("td")).get(12).getText().toString();
				Helper.compareContains(testConfig, "verify column Name", "Returned Reason", actualColName);
				switch(criteriaType)
				{
					case "byElectronicPmt":
						String colData=divSearchResults.get(1).findElement(By.xpath("td[13]/span")).getText().toString();
						Helper.compareContains(testConfig, "verify Column Data", colData, testConfig.getRunTimeProperty("returnedReason"));
						break;
					case "byCheckPmt":
						colData=divSearchResults.get(1).findElement(By.xpath("td[13]")).getText().toString();
						Helper.compareContains(testConfig, "verify Column Data", "", colData);
						break;	
				}
				break;
			case "UPA":
				int numberOfCols=divSearchResults.get(0).findElements(By.tagName("td")).size();
				int colNumber=0;
				for(int i=0;i<numberOfCols;i++)
				{
					actualColName=divSearchResults.get(0).findElements(By.tagName("td")).get(i).getText().toString();
					if(actualColName.equals("Returned Reason"))
						colNumber=i;
				}
				if(colNumber==0)
					System.out.println("Column is not present, Test pass");
				else
					System.out.println("Column is present, Test failed");
				break;
			
			default:
				Log.Comment("Portal name not valid");
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
		if(divSearchResults.size()>30)
			Element.clickByJS(testConfig, lnkNextPage, "Next Page");
		Element.expectedWait(divSearchCriteria, testConfig, "Search Criteria section","Search Criteria section");
		Element.clickByJS(testConfig, lnkFirstPage, "First Page");
		if(divSearchResults.size()>30)
			Element.clickByJS(testConfig, lnkLastPage, "Last Page");
		Element.expectedWait(divSearchCriteria, testConfig, "Search Criteria section","Search Criteria section");
	}
	
	
	/**
	 * This function creates an outer map 
	 * with Key as payment number
	 * and  Value as another hash map i.e. inner map
	 * that contains all the details for key 
	 * like payer name, amount etc
	 * @return Outer map
	 */	
	public Map<String,LinkedHashMap<String,String>> getPaymentDetailsFromUI()
	{	   
	   /**Gets headers List which will be key for following map*/
		
	   LinkedHashMap<String,String> innerMap;
	   Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	   ArrayList<String> headers=getHeadersFromResultTable();
	   
	   int totalNoOfPages=getNumberOfPages();
	   
	   if(totalNoOfPages>2)
		 totalNoOfPages=1;
		   
	   if(divSearchResults.size()==0)
		   divSearchResults=Element.findElements(testConfig, "xpath", ".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");
	   
	   Log.Comment("Fetching all payments From UI..");
	   
	   for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
		   
			for(int i=2;i<divSearchResults.size();i++)
		    {
			   innerMap=new LinkedHashMap<String,String>();
			   
			   for(int j=0;j<headers.size();j++)
			    {	
			     String details=divSearchResults.get(i).findElements(By.tagName("td")).get(j).getText();
			     details=details.replace("\n", "");
			     innerMap.put(headers.get(j), details);										
			    }
			  
			   String amount=innerMap.get("Claim Amount").replace(",", "");
			   innerMap.put("Claim Amount", amount);
			   innerMap.remove("Redemption Date");
			   innerMap.remove("Proxy Number");
			   innerMap.remove("Payer");
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
		Log.Comment("Details from UI is : " +'\n' +outerMap);
		return outerMap;
	   
    }
	
	
	
	public Map<String,LinkedHashMap<String,String>> getPaymentDetailsFromCSRUI()
	{	   
	   /**Gets headers List which will be key for following map*/
		
	   LinkedHashMap<String,String> innerMap;
	   Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	   ArrayList<String> headers=getHeadersFromResultTable();
	   
	   int totalNoOfPages=getNumberOfPages();
	   
	   if(totalNoOfPages>2)
		 totalNoOfPages=1;
		   
	   if(divSearchResults.size()==0)
		   divSearchResults=Element.findElements(testConfig, "xpath", ".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");
	   
	   Log.Comment("Fetching all payments From UI..");
	   
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
			     else if(headers.get(j).equals("Market Type"))
			    	 innerMap.put(headers.get(j),divSearchResults.get(i).findElements(By.tagName("td")).get(15).getText());
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
			   innerMap.remove("Payment Status/Trace Number");
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
	   for (int i=0;i<14;i++)
	   {
	     String header=searchResultsHeaderRow.get(0).findElements(By.tagName("td")).get(i).getText();
	     headerList.add(header);
		}
	return (ArrayList<String>) headerList;
	   
    }
	
	public Map<String, LinkedHashMap<String, String>> getPaymentDetailsFromFISL(Object FISLResponse) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		int totalPayments;
		LinkedHashMap<String,String> innerMap;
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
			patientName=patientName.replace("null", "").trim();

			
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
			
			innerMap.put("Account Number","0");
			
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
 			innerMap.put("Payment Status / Trace Number",payments[i].getPaymentStatusCode().getDescription());
			innerMap.put("Market Type",getDisplayMarketType(payments[i].getPaymentTypeIndicator()));
			outerMap.put(innerMap.get("Payment Number"), innerMap);
		 }
		  
		 Log.Comment("Details from FISL is :"  + '\n' +outerMap);
		 return outerMap;
	}
	
	public Map<String, LinkedHashMap<String, String>> getPaymentDetailsFromFISLForCSR(Object FISLResponse) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		int totalPayments;
		LinkedHashMap<String,String> innerMap;
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
			patientName=patientName.replace("null", "").trim();
			System.out.println("Patient name is " + patientName);

			
			if(payments[i].getClaimDate()!=null)
			  innerMap.put("Claim Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getClaimDate(),"yyyy-MM-dd", "MM-dd-yyyy")));
			else 
			  innerMap.put("Payment Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getPaymentMadeOn(),"yyyy-MM-dd", "MM-dd-yyyy")));
		  
			if(payments[i].getNationalProviderIdentifier()!=null)
		    innerMap.put("NPI",payments[i].getNationalProviderIdentifier());
			else 
			innerMap.put("NPI",""); 
			
			innerMap.put("Payment Number",payments[i].getDisplayConsolidatedPaymentNumber());
			
//			if(patientName!="")
//			innerMap.put("Patient Name",patientName);
			
			if(payments[i].getSubscriberIdentifier()!=null)
			innerMap.put("Subscriber ID",payments[i].getSubscriberIdentifier());
			
			
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
			outerMap.put(innerMap.get("Payment Number"), innerMap);
		 }
		  
		 Log.Comment("Details from FISL is :"  + '\n' +outerMap);
		 return outerMap;
	}

}
