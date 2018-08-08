package main.java.pageObjects;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.api.manage.EpsPaymentsSearch.EpsPaymentSearchRequestHelper;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.api.pojo.epspaymentsearch.request.SearchByCriteriaRequest;
import main.java.api.pojo.epspaymentsearch.response.EpsConsolidatedClaimPaymentSummaries;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import main.java.reporting.LogTemp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

public class paymentSummary extends ViewPaymentsDataProvider{
	
	
	@FindBy(xpath="//a[contains(text(),'PDF')]")
	WebElement lnkEpraPDF;
	
	@FindBy(id="periodId")
	WebElement drpDwnQuickSearch;
	
	@FindBy(id="mktTypeId")
	WebElement drpDwnMarketType;
	
	
	@FindBy(xpath="//span[(contains(@onmouseover,'Please contact Provider Support at 1-877-620-6194 option 1.'))]")
	WebElement failedPopUpTxt;
	
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
	
	@FindBy(id="tabHome")
	WebElement homeTab;
	
	@FindBy(xpath="//td[contains(text(),'Record Count')]")
	WebElement recordCount;
	
	@FindBy(xpath=".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]//a[not(contains(text(),'Last Page'))]")
	List <WebElement> pageLinks;
	
	@FindBy(linkText="Next")
	WebElement lnkNextPage;
	
	@FindBy(linkText="Payment Date")
	WebElement lnkPaymentDate;
	
	@FindBy(name = "payerProvTin")
	WebElement txtBoxPayerTin;

	@FindBy(name = "btnSearch")
	WebElement btnSearch;
	
	private TestBase testConfig;
	public ValidateEnrollmentTypePage validateEnrollmentType;
	String [] expectedOptions= {"Last 30 days","Last 60 days","Last 90 days","Last 4-6 months","Last 6-9 months","Last 9-13 months"};
	
	public paymentSummary(TestBase testConfig)
	{
		super(testConfig);
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		try{
		if(txtBoxPayerTin.isDisplayed())
			Log.Comment("Payer TinSearch box is displayed on the page");	
		else
		Element.verifyElementPresent(drpDwnQuickSearch,"Quick Search dropdown");
		}
		catch(Exception e)
		{
			Log.Warning("Exception occured " + e , testConfig);
		}
		
	}
	
	
	/**
	 * Sets quick search date range filter
	 * for the passed tin
	 * @param tin
	 * @return payment sumary page
	 */
	public paymentSummary setQuickSearchFilter(String paymentType)
	{
		String setlDate=null;
		
		if(paymentType.equalsIgnoreCase("nonEpraPayment"))
		   setlDate=testConfig.getRunTimeProperty("setlDate");
		else
			setlDate=getPaymentNoDetails(paymentType).get("setlDate");

		String filterToBeSelected=getQuickSearchFilterCriteria(setlDate);
		
		Element.selectByVisibleText(drpDwnQuickSearch,filterToBeSelected, filterToBeSelected +" from 'Filter payments' dropdown");
		Browser.waitForLoad(testConfig.driver);
		Element.expectedWait(drpDwnTin, testConfig, "Tin Dropdown", "Tin Dropdown");
		return this;
	}
	
	
	public void clickEpraPDFLink()
	{
		String actualPaymntNo="";
		String expectedPaymntNo=testConfig.getRunTimeProperty("paymentNo");
		
		int totalNoOfPages=getNumberOfPages();
    	Log.Comment("Total No. of pages are :" + totalNoOfPages);
    	
    	for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
    	    if(testConfig.driver.getPageSource().contains(expectedPaymntNo)) 
		     {
		       for(int i=1;i<searchResultRows.size();i++)
		        {
			      actualPaymntNo=searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
			      actualPaymntNo=actualPaymntNo.replace("\n", "");
			
			      if(actualPaymntNo.contains(expectedPaymntNo))
			       {	
				     WebElement lnkEpraPdf = searchResultRows.get(i).findElements(By.tagName("td")).get(10).findElements(By.tagName("a")).get(1);
				     Browser.scrollTillAnElement(testConfig, lnkEpraPdf, "Epra Link found for Display Consolidated No. :" + actualPaymntNo);
				     Element.click(lnkEpraPdf, "PDF Link for EPRA for Display Consolidated No. :" + actualPaymntNo);
					
				     String oldWindow=Browser.switchToNewWindow(testConfig,"EPRADisplayWindow");
				     Browser.switchToParentWindow(testConfig,oldWindow);
				     Browser.browserRefresh(testConfig);
				
				     WebElement txtEpraPDf=searchResultRows.get(i).findElements(By.tagName("td")).get(10).findElements(By.tagName("span")).get(1);
				     Element.expectedWait(txtEpraPDf, testConfig, "PDF Text for Epra", "PDF Text for Epra");
				     Browser.scrollTillAnElement(testConfig, txtEpraPDf, "Epra PDF text is found for Display Consolidated No. :" + actualPaymntNo);
				     Browser.wait(testConfig, 2);
				
		             Element.onMouseHover(testConfig, txtEpraPDf, "Hover mouse over PDF link that has become text now");	            
		             WebElement popUp=searchResultRows.get(i).findElements(By.tagName("td")).get(10).findElements(By.xpath("//span[contains(@title,'ePRA in process')]")).get(1);
    	             Helper.compareEquals(testConfig, "Hover message on PDF", "ePRA in process, please wait for completion", popUp.getAttribute("title"));
    	             break;   
				   }
		       }
		     }
    	    else if(pageNo%10!=0 && pageNo<totalNoOfPages){  
				 int pageToBeClicked=pageNo+1;
				 Log.Comment("Non ePRA payment not found on page number " + pageNo);
				 Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]").click();
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
    }
	
	
	/**
	 * Finds if a failed Payment is displayed 
	 * on payment summary page
	 * if yes, hovers mouse over 'Failed Payment' text
	 * and verifies that a pop appears and 
	 * verifies in it
	 */
    public void verifyFailedPaymentPopUp() 
     {	
    	String paymentStatus="";
    	int totalNoOfPages=getNumberOfPages();
    	Log.Comment("Total No. of pages are :" + totalNoOfPages);
    	
    	for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
    	    if(testConfig.driver.getPageSource().contains("Failed")) 
		     {
			   for(int i=1;i<searchResultRows.size();i++)
			    {	
				  paymentStatus=searchResultRows.get(i).findElements(By.tagName("td")).get(7).getText();
				  paymentStatus=paymentStatus.replace("\n", "");
				  if(paymentStatus.equals("Failed")) 
				    {
				      Element.onMouseHover(testConfig, searchResultRows.get(i).findElements(By.tagName("td")).get(7), "Failed Payment with payment number : " + searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText());
				      //add for text verification in pop up
				      break;
				    }
			    } 
		     }
			  
    	    else if(pageNo%10!=0 && pageNo<totalNoOfPages){  
				 int pageToBeClicked=pageNo+1;
				 Log.Comment("Failed payment not found on page number " + pageNo);
				 Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]").click();
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
			     Log.Warning("Could not find failed payment on any of the pages, please execute test case manually", testConfig);
		    }
     }
	      
	
    
    public void verifyRemitPaymentPopUp()
    {	
    	String paymentType="remitPayment";
    	String expectedPaymntNo=getPaymentNoDetails(paymentType).get("paymentNo");
    	String actualPaymntNo="";
    	
    	int totalNoOfPages=getNumberOfPages();
    	Log.Comment("Total No. of pages are :" + totalNoOfPages);
    	
    	for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
    		if (testConfig.driver.getPageSource().contains(expectedPaymntNo)) {
    			
    			for(int i=1;i<searchResultRows.size();i++)
    			  {
    				actualPaymntNo=searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText(); // fetching payment number from UI
    				actualPaymntNo=actualPaymntNo.replace("\n", "");
    				   if(actualPaymntNo.equals(expectedPaymntNo)) {
    					Element.onMouseHover(testConfig, searchResultRows.get(i).findElements(By.tagName("td")).get(3), "Remit Payment with payment number : " + actualPaymntNo);
    					 //add for text verification in pop up
    					break;
    			      }
    		       }
		     }
			  
    	    else if(pageNo%10!=0 && pageNo<totalNoOfPages){  
				 int pageToBeClicked=pageNo+1;
				 Log.Comment("Remit payment " +actualPaymntNo + " not found on page number " + pageNo);
				 Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]").click();
				 Log.Comment("Clicked Page number : " + pageToBeClicked);
				 Browser.waitForLoad(testConfig.driver);
				 Browser.wait(testConfig,2);
			     }
    	    
			  else if(pageNo%10==0 && totalNoOfPages!=2 && pageNo<totalNoOfPages){
				   Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
			       Element.click(lnkNextPage,"Next Link");
			       Browser.waitForLoad(testConfig.driver);
			    }
			  else
			     Log.Warning("Could not find Remit payment with number" + expectedPaymntNo + ", please execute test case manually", testConfig);
		    }
     }
    		   	

    
	public String getDisplayConsolidatedNumberFromUI(int rowNo)
	{
		return searchResultRows.get(rowNo).findElements(By.tagName("td")).get(3).getText();
	}
	
	
	/** Verifies the default selected 
	 * filter drop down values 
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
	 * @return 
	 */
	
	
	public paymentSummary setSearchFilters(String filterPayments,String quickSearchFilter,String Archivefilter,String MktTypeFilter)
	{
		Element.selectByVisibleText(drpDwnFilterPayments,filterPayments,filterPayments + " " +" from 'Filter payments' dropdown");
		Browser.waitForLoad(testConfig.driver);
		
		Element.selectByVisibleText(drpDwnArchiveFilter,Archivefilter, Archivefilter + " " +" from 'Archive payments' dropdown");
		Browser.waitForLoad(testConfig.driver);
		Browser.wait(testConfig,2);
		
		Element.selectByVisibleText(drpDwnQuickSearch,quickSearchFilter,quickSearchFilter + " " +" from 'Quick Search' dropdown");
		Browser.waitForLoad(testConfig.driver);
		
		getQuickSearchDates(quickSearchFilter);
		
		Element.selectByVisibleText(drpDwnMarketType,MktTypeFilter,MktTypeFilter + " " +" from 'Market Type' dropdown");	
		Browser.wait(testConfig,3);
		return this;
	}
			
	/**Finds to and from date according to the
	 * quick search filter selected
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
	public Map<String,LinkedHashMap<String,String>> getPaymentDetailsFromUI()
	{	   
	   /**Gets headers List which will be key for following map*/
		
	   LinkedHashMap<String,String> innerMap;
	   
	   Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	   
	   ArrayList<String> headers=getHeadersFromResultTable();
	   
	   int totalNoOfPages=getNumberOfPages();
	   
	   Log.Comment("Fetching all payments From UI..");
	   
	   for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 { 
			Element.findElements(testConfig, "xpath", ".//*[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr"); 
		  
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
			   innerMap.remove("Payer");
			   outerMap.put(searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText(), innerMap);
		    }
			  
			  if(pageNo%10!=0 && pageNo<totalNoOfPages)
			    {   
				   int pageToBeClicked=pageNo+1;
				   WebElement pageLink= Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]");
				   Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]").click();
				  // Browser.wait(testConfig,3);
				   Log.Comment("Clicked Page number : " + pageToBeClicked);
				   Element.expectedWait(pageLink, testConfig, "pageLink" + pageToBeClicked +1, "pageToBeClicked" + pageToBeClicked + 1);
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
		setSearchFilters(filterPayments,quickSearchFilter,Archivefilter,MktTypeFilter);
		
//		getQuickSearchDates(quickSearchFilter);
		
		//Verifies Record count displayed on UI is same as we get from FISL
		
		if(!getRecordCountFromFISL().equalsIgnoreCase("0"))
		 {
			Helper.compareEquals(testConfig, "Record Count from FISL and UI :",getRecordCountFromFISL(),getRecordCountFromUI());
			Helper.compareMaps(testConfig, "Payments Details Comparison from FISL and UI : " + "<br>",getPaymentDetailsFromFISL(), getPaymentDetailsFromUI());			  
		 }
		else
		 Element.verifyTextPresent(errorMsg,"No payments have been made to this Organization.");
		 Helper.compareEquals(testConfig, "Record Count from FISL and DB :",getRecordCountFromFISL(),getRecordCountFromDB());
     }
	


	public String getRecordCountFromFISL() throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		EpsPaymentsSummarySearchResponse responseFromFISL=(EpsPaymentsSummarySearchResponse) getFISLResponse();
		return responseFromFISL.getResponseReturnStatus().getTotalCount().trim(); 
	}
	
	public Map<String, LinkedHashMap<String, String>> getPaymentDetailsFromFISL() throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		LinkedHashMap<String,String> innerMap;
		Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
		EpsPaymentsSummarySearchResponse responseFromFISL=(EpsPaymentsSummarySearchResponse) getFISLResponse();
		EpsConsolidatedClaimPaymentSummaries[] payments=responseFromFISL.getEpsConsolidatedClaimPaymentSummaries();
			
		for(int i=0;i<payments.length;i++)
		{
			innerMap=new LinkedHashMap<String, String>();
			
			//innerMap.put("Payer",getDisplayPayerNameFromDB(payments[i].getPayerSummary().getName()));
			innerMap.put("Payment Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getPaymentMadeOn(),"yyyy-dd-mm", "dd-mm-yyyy")));
			
		    if(payments[i].getNationalProviderIdentifier()!=null)
		    innerMap.put("NPI",payments[i].getNationalProviderIdentifier());
			else 
			innerMap.put("NPI","");
			
			innerMap.put("Payment Number",payments[i].getDisplayConsolidatedPaymentNumber());
			innerMap.put("Proxy Number","");
			if(payments[i].getTotalAmount().equalsIgnoreCase("0.0"))
			innerMap.put("Amount","$"+"0.00");
			else
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
	 * @return display payer name
	 */
	
	public String getDisplayPayerNameFromDB(String payerNameFromFISL)
	{
		int sqlRowNo=20;
		testConfig.putRunTimeProperty("payerName", payerNameFromFISL);
		Map payerTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
//		if(payerTable.get("PAYR_DSPL_NM").toString().trim() != null)
		return payerTable.get("PAYR_DSPL_NM").toString().trim();	
//		else
//		sqlRowNo=20;
//		payerTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
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
		return "Medical";
		
		else if(maketTypeFromFISL.equalsIgnoreCase("H"))
		return "HRA";
			
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
		if (paymentMethodTypefromFISL==null || paymentMethodTypefromFISL.equalsIgnoreCase("NON") || paymentMethodTypefromFISL.equalsIgnoreCase("ACH"))
			return "ACH";
		
		else if(paymentMethodTypefromFISL.equalsIgnoreCase("VCP"))
			return "VCP";
			
		return "Unidentified";
			
	}
	
	public String getRecordCountFromDB()
	{
		int sqlRowNo=4;
		Map srchConsolTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		return srchConsolTable.get("RECORD_COUNT").toString().trim();	
	}	
	

	public int getNumberOfPages()
	 {
		int noOfPages=0;
		int recordsCount=Integer.parseInt(getRecordCountFromUI());
		if(recordsCount>30)
		 {
			noOfPages=recordsCount/30;
			if(recordsCount%30>0)
			noOfPages=noOfPages+1;
		 }
		else
		noOfPages=1;
    	return noOfPages;
	 } 
	
	/**
	 * Gets Payment Dates
	 * from Payment Results
	 * @param columnNo->1
	 * @return 
	 * @return list of data
	 * @throws ParseException 
	 */
	public List<Date> getPaymentDates() throws ParseException
	{
		List<Date> listDates = new ArrayList<Date>();
	    for(int i=1;i<searchResultRows.size();i++)
		 {	
		     String date=searchResultRows.get(i).findElements(By.tagName("td")).get(1).getText();
			 date=date.replace("\n", "");
			 listDates.add(Helper.changeStringToDate(date)); 
		 } 
	   return listDates;
	   
	}
	
	public void verifyPaymentDateSorting(String sortingOrder) throws ParseException
	{  
		List<Date> actualPaymentDates;
		List<String> datesListFromUI=new ArrayList<String>();
		List<String> expectedPaymentDateList = new ArrayList<String>();
		if(sortingOrder.contains("Asc"))
		{
			Log.Comment("Checking payment dates for Ascending order..");
			Element.click(lnkPaymentDate, "Payment Date Link");
			Browser.wait(testConfig,3);
			actualPaymentDates=getPaymentDates();
			for(Date date:actualPaymentDates)
	        {		
			  String dates=Helper.changeDateFormat(date);
			  datesListFromUI.add(dates);
	        }
			Collections.sort(actualPaymentDates);
		}

		else
		{
			Log.Comment("Checking payment dates for Descending order..");
			actualPaymentDates=getPaymentDates();
			Collections.reverse(actualPaymentDates);
			for(Date date:actualPaymentDates)
	        {		
			  String dates=Helper.changeDateFormat(date);
			  datesListFromUI.add(dates);
	        }
		}
			
		for(Date date:actualPaymentDates)
        {		
		  String dates=Helper.changeDateFormat(date);
		  expectedPaymentDateList.add(dates);
        }
		
		Helper.compareEquals(testConfig, "Payment Date Order", expectedPaymentDateList, datesListFromUI);
		 
	}
	
	/**
	 * 
	 * @param expectedPaymentType
	 * @throws JAXBException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void verifyZeroDollarPayments(String expectedPaymentType) throws JAXBException, IOException, SAXException, ParserConfigurationException, InterruptedException, ParseException
	{	
		int sqlRowNo = 0;
		String expectedPaymentAmount = "$0.00";
		String archiveFilter = "Show All";
		
	    ArrayList<String> paymentDetailsFromUI = new ArrayList<String>();
	 	ArrayList<String> paymentDetailsFromFISL = new ArrayList<String>();
	    
        if(expectedPaymentType.equalsIgnoreCase("ACH"))
			sqlRowNo = 33;
        
        else if(expectedPaymentType.equalsIgnoreCase("VCP"))
			sqlRowNo = 34;		

        Map zeroDollarPayments = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
        int dateDiff = Integer.parseInt(zeroDollarPayments.get("DATE_DIFF").toString());
        String dateToValidate = Helper.getDateBeforeOrAfterDays(-dateDiff,"yyyy-MM-dd");
        setSearchFilters(archiveFilter, getQuickSearchFilterCriteria(dateToValidate), archiveFilter, archiveFilter);        
        
		//FISL Response
		EpsPaymentsSummarySearchResponse responseFromFISL = (EpsPaymentsSummarySearchResponse) getFISLResponse();
		EpsConsolidatedClaimPaymentSummaries[] payments = responseFromFISL.getEpsConsolidatedClaimPaymentSummaries();	
		
		int totalNoOfPages=getNumberOfPages();
    	Log.Comment("Total No. of pages are :" + totalNoOfPages);
    	
    	for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 { 
    		if(testConfig.driver.getPageSource().contains("$0.00")) 
		     {
    			for(int i=1; i<searchResultRows.size(); i++)
    			  {			
    				   String paymentAmountUI = searchResultRows.get(i).findElements(By.tagName("td")).get(5).getText();			  
    				   paymentAmountUI = paymentAmountUI.replace("\n", "");			   
    				   String paymentTypeUI = searchResultRows.get(i).findElements(By.tagName("td")).get(6).getText();	
    				   paymentTypeUI = paymentTypeUI.replace("\n", "");
    				   String statusUI = searchResultRows.get(i).findElements(By.tagName("td")).get(7).getText();	
    				   statusUI = statusUI.replace("\n", "");	
    				   if(paymentAmountUI.equalsIgnoreCase(expectedPaymentAmount) && paymentTypeUI.equalsIgnoreCase(expectedPaymentType)){
    					   Helper.compareEquals(testConfig, "Payment Amount from Query and UI : ",  expectedPaymentAmount, paymentAmountUI);
    					   Helper.compareEquals(testConfig, "Payment Type from Query and UI : ", expectedPaymentType, paymentTypeUI);				   
    					   paymentDetailsFromUI.add(paymentAmountUI);
    					   paymentDetailsFromUI.add(paymentTypeUI);			   
    					   
    					 //Payment Details Comparison of UI and FISL
    		    			for(int j=0; j<payments.length; j++)
    		    			{
    		    				String paymentAmountFISL = "$"+payments[j].getTotalAmount();
    		    				
    		    				String paymentTypeFISL = getDisplayPaymentMethod(payments[j].getEpsPaymentStatusCode().getPaymentMode());
    		    				
    		    				if(paymentTypeFISL.equalsIgnoreCase(expectedPaymentType) && paymentAmountFISL.equalsIgnoreCase(expectedPaymentAmount)){
    		    					paymentDetailsFromFISL.add(paymentAmountFISL);
    		    					paymentDetailsFromFISL.add(paymentTypeFISL);
    		    					break;
    		    				}			
    		    			}		
    		    			Helper.compareEquals(testConfig, "Payment Details Comparison of UI and FISL: ",  paymentDetailsFromUI, paymentDetailsFromFISL);    					   
    				   }			   
    			  }
		     }
    		else if(pageNo%10!=0 && pageNo<totalNoOfPages){   
    			int pageToBeClicked=pageNo+1;
				Log.Comment("Failed payment not found on page number " + pageNo);
				Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]").click();
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
			     Log.Warning("Could not find failed payment on any of the pages, please execute test case manually", testConfig);
    		
		 }		
	}	
	
	
	public paymentSummary payerTin(){
		Element.enterData(txtBoxPayerTin, "411804774","Entered TIN", "Payer Tin");
		Element.click(btnSearch, "Search Button");
		return this;
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
		//setTaxIdentifierType(epsPaymentsSearchRequest);
		
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
	
	public EpsPaymentsSearchRequest setMapEntryKey(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0).setKey(testConfig.getRunTimeProperty("key"));
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0).setValue(testConfig.getRunTimeProperty("value"));
		return (EpsPaymentsSearchRequest) object;
	}

}


