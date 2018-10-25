package main.java.pageObjects;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.api.manage.EpsPaymentsSearch.EpsPaymentSearchRequestHelper;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.api.pojo.epspaymentsearch.request.SearchByCriteriaRequest;
import main.java.api.pojo.epspaymentsearch.response.EpsConsolidatedClaimPaymentSummaries;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import main.java.fislServices.PaymentSummaryFislService;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;
import main.java.reporting.LogTemp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.xml.sax.SAXException;




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
	
	@FindBy(xpath="//*[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")
	WebElement payNo;
	
	@FindBy(name="billingProvTin")
	WebElement txtBoxBSTin;

	@FindBy(xpath="//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[1]/a")
	WebElement lnkPayer;
	
	@FindBy(xpath="//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[3]/a")
	WebElement lnkNPI;
	
	@FindBy(xpath="//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[4]/a")
	WebElement lnkPaymentNumber;

	@FindBy(xpath="//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[6]/a")
	WebElement lnkAmount;

	@FindBy(xpath="//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[7]/a")
	WebElement lnkType;

	@FindBy(xpath="//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[10]/a")
	WebElement lnkMarketType;

	@FindBy(xpath="//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[13]/a")
	WebElement lnkArchive;
	
	
	
	private TestBase testConfig;
	public ValidateEnrollmentTypePage validateEnrollmentType;
	String [] expectedOptions= {"Last 30 days","Last 60 days","Last 90 days","Last 4-6 months","Last 6-9 months","Last 9-13 months"};
	PaymentSummaryFislService service = null;
	
	public paymentSummary(TestBase testConfig)
	{
		super(testConfig);
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		
		service = new PaymentSummaryFislService();
		
		txtBoxPayerTin=Element.findElement(testConfig, "name", "payerProvTin");
		txtBoxBSTin=Element.findElement(testConfig, "name", "billingProvTin");
		
		if(txtBoxPayerTin!=null)
			Element.verifyElementPresent(txtBoxPayerTin, "Payer provider tin text box");
		else if(txtBoxBSTin !=null)
			Element.verifyElementPresent(txtBoxBSTin, "Billing Service provider tin text box");
		else
			Element.verifyElementPresent(drpDwnQuickSearch,"Quick Search dropdown");
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
		Element.expectedWait(drpDwnQuickSearch, testConfig, "Quick Search Filter", "Quick Search Filter");
		return this;
	}
	
	
	public paymentSummary clickEpraPDFLink()
	{
		String actualPaymntNo="";
		String expectedPaymntNo=testConfig.getRunTimeProperty("displayPaymentNo");
		WebElement popUp=null;
		
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
		             try{
		             popUp=searchResultRows.get(i).findElements(By.tagName("td")).get(10).findElements(By.xpath("//span[contains(@title,'ePRA in process')]")).get(1);}
		             catch(Exception e){
		            	 Element.expectedWait(searchResultRows.get(i).findElements(By.tagName("td")).get(10).findElements(By.xpath("//span[contains(@title,'ePRA in process')]")).get(1), testConfig, "hover pop up", "hover pop up");
		             }
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
		return this;
    }
	
	
	public paymentSummary verifyEpraStatus(String expectedStatus) 
	 {
		int sqlRowNo=34;
		Map epraStatusTbl=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "Status in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), expectedStatus, epraStatusTbl.get("REQ_STS").toString());
		return this;
		
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
		
		WebElement checkArchiveFilter=Element.findElement(testConfig, "id", "archiveFilterType");
       
		if(checkArchiveFilter!=null)
        {
        	Element.selectByVisibleText(drpDwnArchiveFilter,Archivefilter, Archivefilter + " " +" from 'Archive payments' dropdown");
        	Browser.waitForLoad(testConfig.driver);
    		Browser.wait(testConfig,2);
        }
        
		Element.selectByVisibleText(drpDwnQuickSearch,quickSearchFilter,quickSearchFilter + " " +" from 'Quick Search' dropdown");
		Browser.waitForLoad(testConfig.driver);
		
		getQuickSearchDates(quickSearchFilter);
		
		Element.selectByVisibleText(drpDwnMarketType,MktTypeFilter,MktTypeFilter + " " +" from 'Market Type' dropdown");	
		Browser.wait(testConfig,3);
		return this;
	}
	
	
	/**
	 * Set payer Filters
	 * @param filterPayments
	 * @param quickSearchFilter
	 * @param MktTypeFilter
	 * @return Payment Summary Page
	 */
	
	public paymentSummary setSearchFiltersPayer(String filterPayments,String quickSearchFilter,String MktTypeFilter)
	{
		Element.selectByVisibleText(drpDwnFilterPayments,filterPayments,filterPayments + " " +" from 'Filter payments' dropdown");
		Browser.waitForLoad(testConfig.driver);
				
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
	   
	   if(totalNoOfPages>2)
		 totalNoOfPages=1;
		   
	   
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
			   innerMap.remove("Proxy Number");
			   innerMap.remove("Payment Status / Trace Number");
			   innerMap.remove("Payer");
			   innerMap.remove("Type");
			   outerMap.put(searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText().replace("\n",""), innerMap);
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
	   for (int i=0;i<10;i++)
	   {
	     String header=searchResultRows.get(0).findElements(By.tagName("th")).get(i).getText();
	     if(header.equals("Original Payment Date"))
	    	 header="Payment Date";
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
		
		EpsPaymentsSummarySearchResponse searchResponse=(EpsPaymentsSummarySearchResponse) getFISLResponse();
		String totalRecordsFromFISL=searchResponse.getResponseReturnStatus().getTotalCount();
		
		if(!totalRecordsFromFISL.equalsIgnoreCase("0"))
		{
			Helper.compareEquals(testConfig, "Record Count from FISL and UI :",totalRecordsFromFISL,getRecordCountFromUI());
			Helper.compareMaps(testConfig, "Payments Details Comparison",getPaymentDetailsFromFISL(searchResponse), getPaymentDetailsFromUI());			  
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
			
			innerMap.put("Payment Date",Helper.changeDateFormatSeperator(Helper.changeDateFormat(payments[i].getPaymentMadeOn(),"yyyy-dd-mm", "dd-mm-yyyy")));
		    if(payments[i].getNationalProviderIdentifier()!=null)
		    innerMap.put("NPI",payments[i].getNationalProviderIdentifier());
			else 
			innerMap.put("NPI",""); 
			innerMap.put("Payment Number",payments[i].getDisplayConsolidatedPaymentNumber());
			if(payments[i].getTotalAmount().equalsIgnoreCase("0.0") || payments[i].getTotalAmount().equalsIgnoreCase("0.00"))
			innerMap.put("Amount","$"+"0.00");
			else
			{
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
			    String amount = decimalFormat.format(Double.parseDouble((payments[i].getTotalAmount())));
			    innerMap.put("Amount","$"+amount);
			}
// 			innerMap.put("Type",getDisplayPaymentMethod(payments[i].getPayeePaymentMethod().getPaymentMethodCode().getCode()));
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
		
		else if(maketTypeFromFISL.equalsIgnoreCase("Y"))
			return "Member Payments";

		else
		return maketTypeFromFISL;
			
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
		//int sqlRowNo=4;
		int totalRecord=0;
		
//		List<String> schemas=Arrays.asList("PP001","PP002","PP003","PP004","PP005","PP006","PP024");
//		
		int sqlRowNo=34;
//		for(String schema:schemas)
//		{
//			testConfig.putRunTimeProperty("schema", schema);
			Map srchConsolTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			totalRecord=totalRecord+Integer.parseInt(srchConsolTable.get("RECORD_COUNT").toString().trim());
//		}
		
		return String.valueOf(totalRecord);	
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
			 listDates.add(new SimpleDateFormat("MM/dd/yyyy").parse(date));
			 //listDates.add(Helper.changeStringToDate(date)); 
		 } 
	   return listDates;
	   
	}
	
	public void verifyPaymentDateSorting(String sortingOrder) throws ParseException
	{  
		List<Date> actualPaymentDates;
		List<Date> datesListFromUI=new ArrayList<Date>();
		List<Date> expectedPaymentDateList = new ArrayList<Date>();
		if(sortingOrder.contains("Asc"))
		{
			Log.Comment("Checking payment dates for Ascending order..");
			Element.click(lnkPaymentDate, "Payment Date Link");
			Browser.wait(testConfig,3);
			actualPaymentDates=getPaymentDates();
			for(Date date:actualPaymentDates)
	        {		
			  //String dates=Helper.changeDateFormat(date);
			  datesListFromUI.add(date);
	        }
			Collections.sort(actualPaymentDates);
		}

		else
		{
			Log.Comment("Checking payment dates for Descending order..");
			actualPaymentDates=getPaymentDates();
			for(Date date:actualPaymentDates)
	        {		
			  datesListFromUI.add(date);
	        }
			Collections.sort(actualPaymentDates, Collections.reverseOrder());
		}
		for(Date date:actualPaymentDates)
        {		
		  expectedPaymentDateList.add(date);
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
 */
	
	public void verifyZeroDollarPayments(String expectedPaymentType) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{	
		String archiveFilter = "Show All";	
		String actualPaymntNo = "";
		String ZeroDollar = "$0.00";
        String dateToValidate = getPaymentNoDetails(expectedPaymentType).get("setlDate");
       
    setSearchFilters(archiveFilter, getQuickSearchFilterCriteria(dateToValidate), archiveFilter, archiveFilter);        
        
		//FISL Response
		EpsPaymentsSummarySearchResponse responseFromFISL = (EpsPaymentsSummarySearchResponse) getFISLResponse();
		EpsConsolidatedClaimPaymentSummaries[] payments = responseFromFISL.getEpsConsolidatedClaimPaymentSummaries();	
		
		int totalNoOfPages=getNumberOfPages();
    	Log.Comment("Total No. of pages are :" + totalNoOfPages);
    	
    	OUTERLOOP: 	
		for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {
			for(int i=1; i<searchResultRows.size(); i++)
			  {    			
    			String paymentAmountUI = searchResultRows.get(i).findElements(By.tagName("td")).get(5).getText();
				
				if(paymentAmountUI.equalsIgnoreCase(ZeroDollar)){
					String paymentTypeUI = searchResultRows.get(i).findElements(By.tagName("td")).get(6).getText();
					
					if(paymentTypeUI.equalsIgnoreCase(expectedPaymentType)){
						Log.Pass("Expected and Actual Payment Type", expectedPaymentType, paymentTypeUI);
						
						actualPaymntNo=searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
						actualPaymntNo=actualPaymntNo.replace("\n", "");
						
						if(payments[i-1].getDisplayConsolidatedPaymentNumber().equals(actualPaymntNo)){
							Log.Pass("FISL and UI Payment No", payments[i-1].getDisplayConsolidatedPaymentNumber(), actualPaymntNo);
							break OUTERLOOP;
						}						
					}
					else{
						Log.Fail("Expected and Actual Payment Type", expectedPaymentType, paymentTypeUI);
					}
				}				
			  }
    		
    		if(pageNo%10!=0 && pageNo<totalNoOfPages){   
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
		
		int sqlRow=35;
		
		Map payerDetails=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		String payerTin = payerDetails.get("PROV_TAX_ID_NBR").toString();
		testConfig.putRunTimeProperty("tin", payerTin);
		
		System.out.println("payerTin: "+payerTin);
		Element.enterData(txtBoxPayerTin, payerTin,"Entered TIN", "Payer Tin");
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
		EpsPaymentsSearchRequest epsPaymentsSearchRequest=epsPaymentSearchRequestHelper.createRequestPojo();
		
		/**Creates POJO for Request.xml so that we can modify the elements*/
		
//		EpsPaymentsSearchRequest epsPaymentsSearchRequest=(EpsPaymentsSearchRequest) createRequest();
		epsPaymentsSearchRequest=setTinNumber(epsPaymentsSearchRequest);
		setToAndFromDate(epsPaymentsSearchRequest);
		setMapEntryKey(epsPaymentsSearchRequest);
		
		/**Posting the modified request and getting response*/
		EpsPaymentsSummarySearchResponse searchResponse=(EpsPaymentsSummarySearchResponse) epsPaymentSearchRequestHelper.postRequestGetResponse(epsPaymentsSearchRequest);
		return searchResponse;
	}
	

//	public Object createRequest() throws JAXBException
//	{
//	   EpsPaymentSearchRequestHelper epsPaymentSearchRequestHelper = new EpsPaymentSearchRequestHelper();
//	   EpsPaymentsSearchRequest epsPaymentsSearchRequest=epsPaymentSearchRequestHelper.createRequestPojo();
//	   return epsPaymentsSearchRequest;
//	}
	
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
	
	
	/**
	  * For example, to add a new item, do as follows:
	  * * <pre>
	  *  getEpsSecondaryPayerReferenceIdentifiers().add(newItem);
	   * </pre>
	  * 
	*/     
	public EpsPaymentsSearchRequest setPayerID(Object object) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{
	((EpsPaymentsSearchRequest) object).getEpsSecondaryPayerReferenceIdentifiers().add(testConfig.getRunTimeProperty("payerID"));
	return (EpsPaymentsSearchRequest) object;
	}

	
	
	
	
	//Methods related to BS User

	public paymentSummary bsTin(String providerTIN) 
	{
		testConfig.putRunTimeProperty("tin", providerTIN);
		Element.enterData(txtBoxBSTin, providerTIN,"Entered TIN", "Provider Tin");
		Element.click(btnSearch, "Search Button");
		Browser.waitForLoad(testConfig.driver);
		Browser.wait(testConfig, 2);
		return this;
	}

	public Object getSearchResults() 
	{
		try {
			String response= getFislPaymentSearchResponse();
			Object convertedData = convertResponseObject(response);
			return convertedData;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Object convertResponseObject(String response) throws Exception
	{
		PaymentSummaryFislService service = new PaymentSummaryFislService();
		JAXBElement<com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0.EpsPaymentsSummarySearchResponse> result = (JAXBElement<com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0.EpsPaymentsSummarySearchResponse>) service.toObject(response);
		Object fislResponse = result.getValue();
		return fislResponse;
	}

	
	public String getFislPaymentSearchResponse() throws JAXBException, IOException, SAXException, ParserConfigurationException {
		String response= "";
		EpsPaymentSearchRequestHelper epsPaymentSearchRequestHelper = new EpsPaymentSearchRequestHelper();
		EpsPaymentsSearchRequest epsPaymentsSearchRequest=epsPaymentSearchRequestHelper.createRequestPojo();
		epsPaymentsSearchRequest=setTinNumber(epsPaymentsSearchRequest);
		setToAndFromDate(epsPaymentsSearchRequest);
		setMapEntryKey(epsPaymentsSearchRequest);
		/**Posting the modified request and getting response*/
		response= (String) epsPaymentSearchRequestHelper.postRequestGetResponse(epsPaymentsSearchRequest);
		return response;
	}

	/*
	public Map<String, LinkedHashMap<String, String>> getPaymentDetailsFromFISL(Object searchResult) throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException
	{
		PaymentSummaryFislService service= new PaymentSummaryFislService();
		
		LinkedHashMap<String,String> innerMap;
		Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
		
		 List<EpsConsolidatedClaimPaymentSummary> responseFromFISL= service.getEpsConsolidatedClaimPaymentSummaries(searchResult);
		 EpsConsolidatedClaimPaymentSummary[] payments=responseFromFISL.toArray(new EpsConsolidatedClaimPaymentSummary[responseFromFISL.size()]);
		 
		int totalPayments;
		
		if(Integer.parseInt(service.getTotalCounts(searchResult))>30)
			 totalPayments=30;
		else
			totalPayments=payments.length;
			
		for(int i=0;i<totalPayments;i++)
		{
			innerMap=new LinkedHashMap<String, String>();
			
			//innerMap.put("Payer",getDisplayPayerNameFromDB(payments[i].getPayerSummary().getName()));
			innerMap.put("Payment Date",convertDateFromGregorianToString(payments[i].getPaymentMadeOn()));
			System.out.println(convertDateFromGregorianToString(payments[i].getPaymentMadeOn()));
			
		    if(payments[i].getNationalProviderIdentifier()!=null)
		    innerMap.put("NPI",payments[i].getNationalProviderIdentifier());
			else 
			innerMap.put("NPI","");
		    
			innerMap.put("Payment Number",payments[i].getDisplayConsolidatedPaymentNumber());
			
			if(payments[i].getTotalAmount().getValue() == 0 )
			{
				innerMap.put("Amount","$"+"0.00");
			}
			else
			{
				DecimalFormat decimalFormat = new DecimalFormat("#.00");
			    String amount = decimalFormat.format(payments[i].getTotalAmount().getValue());
			    innerMap.put("Amount","$"+amount);
			}
			
			innerMap.put("Market Type",getDisplayMarketType(payments[i].getPaymentTypeIndicator()));
			outerMap.put(innerMap.get("Payment Number"), innerMap);
		}
		Log.Comment("Details from FISL is :"  + '\n' +outerMap);
		return outerMap;
	}*/
	
	
	public void newVerifySearchResultsWithFilters(String filterPayments,String quickSearchFilter,String Archivefilter,String MktTypeFilter, Boolean changeDates) throws IOException, InterruptedException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{	
		Log.Comment("Setting Filters and drop downs in the view payments page");
		Browser.wait(testConfig, 2);		
		newSetSearchFilters( filterPayments, quickSearchFilter, Archivefilter, MktTypeFilter);
		
		if( Integer.parseInt(newGetRecordCountFromUI()) <= 1 )
		{
			if(changeDates)
			{
				quickSearchFilter = "Last 4-6 months";
				quickSearchFilter = setQuickSearchFilter(quickSearchFilter, false, 1);
			}
			else {
				Log.Fail("No payments exist for this TIN");
			}
		}
		
		Object searchResult = getSearchResults();
		PaymentSummaryFislService service = new PaymentSummaryFislService();		
		Log.Comment("Getting the FISL and UI record counts");
		String totalFislRecordCount  = service.getTotalCounts(searchResult);
		String totalUiRecordCount = newGetRecordCountFromUI();
		
		Map<String, LinkedHashMap<String, String>> paymentDetailsFromFISL = getPaymentDetailsFromFISL(searchResult);
		Map<String, LinkedHashMap<String, String>> paymentDetailsFromUI = getPaymentDetailsFromUI();

		paymentDetailsFromFISL= cleanUpAmount(paymentDetailsFromFISL);
		paymentDetailsFromUI= cleanUpAmount(paymentDetailsFromUI);

		Log.Comment("Comparing the FISL and UI Record counts in the view payments page");
		if(!totalFislRecordCount.equalsIgnoreCase("0"))
		{
			Helper.compareEquals(testConfig, "Record Count from FISL and UI :",totalUiRecordCount,totalFislRecordCount);
			Helper.compareEquals(testConfig, "Payment Records from FISL and UI :",paymentDetailsFromFISL,paymentDetailsFromUI);
		}
		else
		{
			Element.verifyTextPresent(errorMsg,"No payments in FISL have been made to this Organization.");
		}
     }

	private LinkedHashMap<String, LinkedHashMap<String, String>> cleanUpAmount(Map<String, LinkedHashMap<String, String>> paymentDetailsFromFISL) 
	{		
		LinkedHashMap<String, LinkedHashMap<String, String>> output=  new LinkedHashMap();
		for( String key : paymentDetailsFromFISL.keySet())
		{
			LinkedHashMap<String, String> data = paymentDetailsFromFISL.get(key);
			if(data.get("Amount").contains("$."))
			{
				data.put("Amount", data.get("Amount").replace("$.", "$0."));
			}
			if(data.get("Market Type").equals("D"))
			{
				data.put("Market Type", "Dental");
			}
			if(data.get("Market Type").equals("M"))
			{
				data.put("Market Type", "Medical");
			}
			output.put(key, data);
		}
		return output;
	}


	public void newVerifyZeroDollarPayments(String expectedPaymentType) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{	
		Boolean foundZeroDollarPayment= false;
		String filterPayments ="Show All";
		String archiveFilter = "Show All";
		String mktTypeFilter = "Show All";
		String quickSearchFilter = "Last 90 days";
		Log.Comment("Setting Filters and drop downs in the view payments page");
		Browser.wait(testConfig, 3);
		setSearchFilters(filterPayments, quickSearchFilter, archiveFilter, mktTypeFilter);

		if( Integer.parseInt(newGetRecordCountFromUI()) <= 1 )
		{
			quickSearchFilter = "Last 4-6 months";
			quickSearchFilter = setQuickSearchFilter( quickSearchFilter, false, 1);
		}
		
		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);
		Log.Comment("Fetching all payments From UI..");
		
		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) 
		{
			Element.findElements(testConfig, "xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr");

			for (int i = 1; i < searchResultRows.size(); i++) {
				String amount = searchResultRows.get(i).findElements(By.tagName("td")).get(5).getText();
				String paymentType = searchResultRows.get(i).findElements(By.tagName("td")).get(6).getText();
				String paymentStatus = searchResultRows.get(i).findElements(By.tagName("td")).get(7).getText();
				
				if(amount.equals("$0.00") && paymentType.equals(expectedPaymentType))
				{
					Log.Comment("Identified a zero dollar ACH Payment in the view payments page");
					foundZeroDollarPayment = true;
					if(paymentStatus.equals("N/A") == false)
					{
						Assert.fail("ACH Zero payment not marked N/A as expected");
						return;
					}
				}
			}
			Log.Comment("Navigating to the next page");
			gotoNextPage(pageNo, totalNoOfPages);
		}
		
		if(foundZeroDollarPayment == false)
		{
			setQuickSearch(quickSearchFilter);
		}		
	}
	
	public void newVerifyMaximumRecordsInAPage(String quickSearchFilter ) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{	
		quickSearchFilter = setQuickSearchFilter(quickSearchFilter, true, 0);
		
		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);
		Log.Comment("Fetching all payments From UI..");
		

		Log.Comment("Checking to see if there are multiple pages in the view payments page");
		if(totalNoOfPages >1)
		{
			//Since the header is also included in the searchResultsRows, the total row count in searchResultRows would be 31. Hence, subtracting 1.
			Log.Comment("Checking to see if there 30 records in a single page");
			int totalRowsInPage = searchResultRows.size()-1;
			if(totalRowsInPage == 30)
			{
				Log.Pass("Test case has passed. There are a total of 30 payments displayed on the screen.");
			}
			else if(totalRowsInPage != 30)
			{
				Assert.fail("Test case failed, number of records on first page is "+totalRowsInPage);
			}
		}
		else
		{
			Assert.fail("Test case failed, the TIN does not have sufficient payments to test this criteria");
		}
	}

	public void newVerifyPagination(String quickSearchFilter) throws JAXBException, IOException, SAXException, ParserConfigurationException
	{	
		Log.Comment("Validating pagination in the view payments page");
		quickSearchFilter = setQuickSearchFilter(quickSearchFilter, true,0);
		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);		
		validateViewPaymentsPagination();
	}
	
	
	
	public String setQuickSearchFilter(String quickSearchFilter, Boolean needPagination, int minRecordsRequired)
	{
		switch(quickSearchFilter)
		{
		case "Last 30 days":
			
			if( Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true)
			{
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			}
			else 
			{
				int totalNoOfPages = newGetNumberOfPages();
				if(totalNoOfPages <=1)
				{
					quickSearchFilter = "Last 60 days";
					Log.Comment("Changing quick search filter to :"+quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter( quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}	
			break;

		case "Last 60 days":
			setQuickSearch(quickSearchFilter);
			if( Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true)
			{
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			}
			else 
			{
				int totalNoOfPages = newGetNumberOfPages();
				if(totalNoOfPages <=1)
				{
					quickSearchFilter = "Last 90 days";
					Log.Comment("Changing quick search filter to :"+quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter( quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;

		case "Last 90 days":
			setQuickSearch(quickSearchFilter);
			if( Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true)
			{
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			}
			else 
			{
				int totalNoOfPages = newGetNumberOfPages();
				if(totalNoOfPages <=1)
				{
					quickSearchFilter = "Last 4-6 months";
					Log.Comment("Changing quick search filter to :"+quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter( quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;

		case "Last 4-6 months":
			setQuickSearch(quickSearchFilter);
			if( Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true)
			{
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			}
			else 
			{
				int totalNoOfPages = newGetNumberOfPages();
				if(totalNoOfPages <=1)
				{
					quickSearchFilter = "Last 6-9 months";
					Log.Comment("Changing quick search filter to :"+quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter( quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;
			
		case "Last 6-9 months":
			setQuickSearch(quickSearchFilter);
			if( Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true)
			{
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			}
			else 
			{
				int totalNoOfPages = newGetNumberOfPages();
				if(totalNoOfPages <=1)
				{
					quickSearchFilter = "Last 9-13 months";
					Log.Comment("Changing quick search filter to :"+quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter( quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;

		case "Last 9-13 months":
			setQuickSearch(quickSearchFilter);
			if( Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true)
			{
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			}
			else 
			{
				int totalNoOfPages = newGetNumberOfPages();
				if(totalNoOfPages <=1)
				{
					Assert.fail("Test case failed, the TIN does not have sufficient payments to validate this test case. Cannot validate because the number of pages is only "+totalNoOfPages);
				}
				else {
					return quickSearchFilter;
				}
			}
			break;
		default:
			if( Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true)
			{
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			}
			else 
			{
				int totalNoOfPages = newGetNumberOfPages();
				if(totalNoOfPages <=1)
				{
					quickSearchFilter = "Last 60 days";
					Log.Comment("Changing quick search filter to :"+quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter( quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;
		}
		return quickSearchFilter;
	}
	
	public String convertDateFromGregorianToString(XMLGregorianCalendar calendar)
	{
		Date date = calendar.toGregorianCalendar().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String finalResult = sdf.format(date);
		return finalResult;
	}
		
	public Map<String,LinkedHashMap<String,String>> getPaymentDetailsFromUIFirstPage()
	{	   
	   /**Gets headers List which will be key for following map*/
		
	   LinkedHashMap<String,String> innerMap;
	   
	   Map<String, LinkedHashMap<String,String> > outerMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	   
	   ArrayList<String> headers=getHeadersFromResultTable();
	   
	   int totalNoOfPages=getNumberOfPages();
	   
	   if(totalNoOfPages>2)
		 totalNoOfPages=1;
		   
	   
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
			   innerMap.remove("Proxy Number");
			   innerMap.remove("Payment Status / Trace Number");
			   innerMap.remove("Payer");
			   innerMap.remove("Type");
			   outerMap.put(searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText().replace("\n",""), innerMap);
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
	 * This function creates an outer map 
	 * with Key as payment number
	 * and  Value as another hash map i.e. inner map
	 * that contains all the details for key 
	 * like payer name, amount etc
	 * @return Outer map
	 */	
	public void validateViewPaymentsPagination()
	{	
	   HashSet<String> paymentNumbers = new HashSet<String>(); 
	   
	   int totalNoOfPages=getNumberOfPages();
	   
	   Log.Comment("Fetching payments and validating pagination in the UI..");	   
	   for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
	   { 
			ArrayList<String> paymentInfo = new ArrayList<String>();
			Integer numberOfPaymentsDisplayedInPage = searchResultRows.size()-1;
			
			Log.Comment("Checking to see if there are more 30 records in the page");
			if(pageNo != totalNoOfPages && numberOfPaymentsDisplayedInPage != 30)
			{
				String msg = numberOfPaymentsDisplayedInPage >30?"more than ":"less than";
				Log.Fail("Test failed. There are "+msg+"30 payments displayed in this page");				
			}
			
			Log.Comment("Checking to see if there are duplicate payments in the page");
			for(int i=1;i<=numberOfPaymentsDisplayedInPage;i++)
		    {
				String paymentNumber=searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
				paymentNumber=paymentNumber.replace("\n", "");
				if(!paymentNumbers.add(paymentNumber))
				{
					Log.Fail("Testing Failed, duplicate payment number "+paymentNumber+" found in the UI in the same of different page");
				}
		    }
			gotoNextPage(pageNo, totalNoOfPages);
	   }
	   Log.Pass("Pagination has been validated successfully. No duplicates found and every page has a maximum of 30 payments");
    }
		
	public void verifyOtherFieldSorting()
	{
		String quickSearchFilter ="Last 30 days";
		setQuickSearchFilter(quickSearchFilter, false, 5);				
		ArrayList<Double> reverseAmountOriginalData = new ArrayList<Double>();
		ArrayList<Boolean> reverseArchiveOriginalData = new ArrayList<Boolean>();
		ArrayList<Double> sortedAmountOriginalData = new ArrayList<Double>();
		ArrayList<Boolean> sortedArchiveOriginalData = new ArrayList<Boolean>();
		
		ArrayList<String> originalStrData= new ArrayList<String>();
		ArrayList<String> sortedAscStrData= new ArrayList<String>();
		ArrayList<String> sortedDescStrData= new ArrayList<String>();
		
		int[] strColumns = {0,2,3,6,9};
		int[] numColumns = {5};
		int[] boolColumns = {12};
		
		
		String ascMessage ="Sorting the column in ascending order :";
		String descMessage ="Sorting the column in descending order :";
		
		HashMap<Integer, Object> originalData = getMultipleColumnValues(strColumns, numColumns, boolColumns);
		
		Log.Comment(ascMessage+" Payer");
		originalStrData = (ArrayList<String>) originalData.get(0);
		Collections.sort(originalStrData);		
		SortElement(lnkPayer);
		sortedAscStrData = getAnyStringColumnValues(0);
		Helper.compareEquals(testConfig, "View Payments Payer Sorted Ascending", originalStrData, sortedAscStrData );
		
		Log.Comment(descMessage+" Payer");
		SortElement(lnkPayer);
		Collections.sort(originalStrData, Collections.reverseOrder());
		sortedDescStrData = getAnyStringColumnValues(0);
		Helper.compareEquals(testConfig, "View Payments Payer Sorted Descending", originalStrData, sortedDescStrData);
		

		originalStrData = new ArrayList<String>();
		sortedAscStrData = new ArrayList<String>();
		sortedDescStrData = new ArrayList<String>();
		
		

		Log.Comment(ascMessage+" NPI");
		originalStrData = (ArrayList<String>) originalData.get(2);
		Collections.sort(originalStrData);
		SortElement(lnkNPI);
		sortedAscStrData = getAnyStringColumnValues(2);
		Helper.compareEquals(testConfig, "View Payments NPI Sorted Ascending", originalStrData, sortedAscStrData );

		Log.Comment(descMessage+" NPI");
		SortElement(lnkNPI);
		Collections.sort(originalStrData, Collections.reverseOrder());
		sortedDescStrData = getAnyStringColumnValues(2);
		Helper.compareEquals(testConfig, "View Payments NPI Sorted Descending", originalStrData, sortedDescStrData);


		originalStrData = new ArrayList<String>();
		sortedAscStrData = new ArrayList<String>();
		sortedDescStrData = new ArrayList<String>();

		Log.Comment(ascMessage+" Payment Number");
		originalStrData = (ArrayList<String>) originalData.get(3);
		SortElement(lnkPaymentNumber);
		Collections.sort(originalStrData);	
		sortedAscStrData = getAnyStringColumnValues(3);
		Helper.compareEquals(testConfig, "View Payments Payment Number Sorted Ascending", originalStrData, sortedAscStrData );

		Log.Comment(descMessage+" Payment Number");
		SortElement(lnkPaymentNumber);
		Collections.sort(originalStrData, Collections.reverseOrder());
		sortedDescStrData = getAnyStringColumnValues(3);
		Helper.compareEquals(testConfig, "View Payments Payment Number Sorted Descending", originalStrData, sortedDescStrData);


		originalStrData = new ArrayList<String>();
		sortedAscStrData = new ArrayList<String>();
		sortedDescStrData = new ArrayList<String>();

		Log.Comment(ascMessage+" Type");
		originalStrData = (ArrayList<String>) originalData.get(6);
		SortElement(lnkType);
		Collections.sort(originalStrData);
		sortedAscStrData = getAnyStringColumnValues(6);
		Helper.compareEquals(testConfig, "View Payments Payments Type Sorted Ascending", originalStrData, sortedAscStrData );

		Log.Comment(descMessage+" Type");
		SortElement(lnkType);
		Collections.sort(originalStrData, Collections.reverseOrder());
		sortedDescStrData = getAnyStringColumnValues(6);
		Helper.compareEquals(testConfig, "View Payments Payments Type Sorted Descending", originalStrData, sortedDescStrData);


		originalStrData = new ArrayList<String>();
		sortedAscStrData = new ArrayList<String>();
		sortedDescStrData = new ArrayList<String>();
		
		Log.Comment(ascMessage+" Market Type");
		originalStrData = (ArrayList<String>) originalData.get(9);
		SortElement(lnkMarketType);
		Collections.sort(originalStrData);		
		sortedAscStrData = getAnyStringColumnValues(9);
		Helper.compareEquals(testConfig, "View Payments Market Type Sorted Ascending", originalStrData, sortedAscStrData );

		Log.Comment(descMessage+" Market Type");
		SortElement(lnkMarketType);
		Collections.sort(originalStrData, Collections.reverseOrder());
		sortedDescStrData = getAnyStringColumnValues(9);
		Helper.compareEquals(testConfig, "View Payments Market Type Sorted Descending", originalStrData, sortedDescStrData);
		

		Log.Comment(ascMessage+" Amount");
		ArrayList<Double> amountOriginalData = (ArrayList<Double>)originalData.get(5); 
		Collections.sort(amountOriginalData);
		SortElement(lnkAmount);
		sortedAmountOriginalData = getAnyNumericColumnValues(5);
		Helper.compareEquals(testConfig, "View Payments Amount Sorted Ascending", amountOriginalData, sortedAmountOriginalData);

		Log.Comment(descMessage+"Amount");
		SortElement(lnkAmount);
		reverseAmountOriginalData = getAnyNumericColumnValues(5);
		Collections.sort(amountOriginalData, Collections.reverseOrder());
		Helper.compareEquals(testConfig, "View Payments Amount Sorted Descending", amountOriginalData, reverseAmountOriginalData);
				
		

		Log.Comment(ascMessage+" Archive");
		ArrayList<Boolean> archiveOriginalData = (ArrayList<Boolean>)originalData.get(12);
		Collections.sort(archiveOriginalData);
		SortElement(lnkArchive);
		sortedArchiveOriginalData = getAnyBooleanColumnValues(12);
		Helper.compareEquals(testConfig, "View Payments Archived Sorted Ascending", archiveOriginalData, sortedArchiveOriginalData);

		Log.Comment(descMessage+" Archive");
		SortElement(lnkArchive);
		Collections.sort(archiveOriginalData, Collections.reverseOrder());
		reverseArchiveOriginalData = getAnyBooleanColumnValues(12);
		Helper.compareEquals(testConfig, "View Payments Archived Sorted Descending", archiveOriginalData, reverseArchiveOriginalData);
		
	}


	public HashMap<Integer, Object> getMultipleColumnValues(int[] strColumns,int[] numColumns,int[] boolColumns)
	{		
		HashMap<Integer, Object> returnData = new HashMap<Integer, Object>();
		HashMap<Integer, ArrayList<String>> strData = new HashMap<Integer, ArrayList<String>>();
		HashMap<Integer, ArrayList<Double>> numData = new HashMap<Integer, ArrayList<Double>>();
		HashMap<Integer, ArrayList<Boolean>> boolData = new HashMap<Integer, ArrayList<Boolean>>();

		if(strColumns !=null)
		{
			for(int column : strColumns)
			{
				strData.put(column, new ArrayList<String>());
			}
		}
		
		if(numColumns !=null)
		{
			for(int column : numColumns)
			{
				numData.put(column, new ArrayList<Double>());
			}
		}
		
		if(boolColumns != null)
		{
			for(int column : boolColumns)
			{
				boolData.put(column, new ArrayList<Boolean>());
			}
		}
			
		ArrayList<String> data = new ArrayList<String>(); 
		int totalNoOfPages=getNumberOfPages();
		
		for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		{ 
			for(int i=1;i<searchResultRows.size();i++)
			{	
				if(strColumns !=null)
				{
					for(int column : strColumns)
					{
						String value=searchResultRows.get(i).findElements(By.tagName("td")).get(column).getText();
						strData.get(column).add(value);
					}
				}
				
				if(numColumns !=null)
				{
					for(int column : numColumns)
					{
						
						Double value=Double.valueOf(searchResultRows.get(i).findElements(By.tagName("td")).get(column).getText().replace("$", "").replace(",", "").replace("\n", "").trim());
						numData.get(column).add(value);
					}
				}
				
				if(boolColumns !=null)
				{
					for(int column : boolColumns)
					{
						Boolean value=searchResultRows.get(i).findElements(By.tagName("td")).get(column).isSelected();
						boolData.get(column).add(value);
					}
				}
			}
			gotoNextPage(pageNo, totalNoOfPages);
		}

		if(strColumns !=null)
		{
			for(Integer key: strData.keySet())
			{
				returnData.put(key, strData.get(key));
			}
		}
		
		if(numColumns !=null)
		{
			for(Integer key: numData.keySet())
			{
				returnData.put(key, numData.get(key));
			}
		}
		
		if(boolColumns !=null)
		{
			for(Integer key: boolData.keySet())
			{
				returnData.put(key, boolData.get(key));
			}
		}
		
		return returnData;
	}

	public ArrayList<String> getAnyStringColumnValues(int columnNumber)
	{
		ArrayList<String> data = new ArrayList<String>(); 
		int totalNoOfPages=getNumberOfPages();
		
		for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		{ 
			for(int i=1;i<searchResultRows.size();i++)
			{	
			     String values=searchResultRows.get(i).findElements(By.tagName("td")).get(columnNumber).getText();
				 data.add(values);
			}
			gotoNextPage(pageNo, totalNoOfPages);
		}
		return data;
	}
		
	public ArrayList<Double> getAnyNumericColumnValues(int columnNumber)
	{
		ArrayList<Double> data = new ArrayList<Double>();
		int totalNoOfPages=getNumberOfPages();

		for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		{ 
			for(int i=1;i<searchResultRows.size();i++)
			{	
				Double values=Double.valueOf(searchResultRows.get(i).findElements(By.tagName("td")).get(columnNumber).getText().replace("$", "").replace(",", "").replace("\n", "").trim());
				data.add(values);
			}
			gotoNextPage(pageNo, totalNoOfPages);
		}
		return data;
	}

	public ArrayList<Boolean> getAnyBooleanColumnValues(int columnNumber)
	{
		ArrayList<Boolean> data = new ArrayList<Boolean>();
		int totalNoOfPages=getNumberOfPages();

		for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		{ 
			for(int i=1;i<searchResultRows.size();i++)
			{	
				Boolean values= searchResultRows.get(i).findElements(By.tagName("td")).get(columnNumber).isSelected();
				 data.add(values);
			}
			gotoNextPage(pageNo, totalNoOfPages);
		}
		return data;
	}
	
	
	public void setQuickSearch(String quickSearchFilter)
	{
		Element.selectByVisibleText(drpDwnQuickSearch,quickSearchFilter,quickSearchFilter + " " +" from 'Quick Search' dropdown");
		Browser.waitForLoad(testConfig.driver);
		Browser.wait(testConfig, 3);
	}
	
	public void setQuickSearchDateRange(String quickSearchFilter)
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
	}
	
	public void gotoFirstPage()
	{
		WebElement firstPage = Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),'First Page')]");
		if(firstPage != null)
		{
			firstPage.click();
			Browser.wait(testConfig, 3);				
		}
	}
	
	public void gotoNextPage(int pageNo,int totalNoOfPages)
	{
		if(pageNo%10!=0 && pageNo<totalNoOfPages)
		{  
			 int pageToBeClicked=pageNo+1;
			 Element.findElement(testConfig,"xpath",".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text()," + pageToBeClicked + ")]").click();
			 Log.Comment("Clicked Page number : " + pageToBeClicked);
			 Browser.waitForLoad(testConfig.driver);
		}
		else if(pageNo%10==0 && totalNoOfPages!=2 && pageNo<totalNoOfPages)
		{
		   Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
	       Element.click(lnkNextPage,"Next Link");
	       Browser.waitForLoad(testConfig.driver);
	    }
		Browser.wait(testConfig, 3);		
	}
	
	public void SortElement(WebElement element)
	{
		gotoFirstPage();
		element.click();
		Browser.wait(testConfig, 3);
	}

    public void verifyBSRemitPaymentPopUp()
    {	
    	String paymentType="remitPayment";
    	String actualPaymntNo="";
    	
    	int totalNoOfPages=getNumberOfPages();
    	Log.Comment("Total No. of pages are :" + totalNoOfPages);
    	
    	for(int pageNo=1;pageNo<=totalNoOfPages;pageNo++)
		 {  
			for(int i=1;i<searchResultRows.size();i++)
			{
				WebElement element =  Element.findElement(testConfig, "xpath", "//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]");
				String content = element.getAttribute("innerHTML");
				if(content.contains("<span"))
				{
					Element.onMouseHover(testConfig, element, "Payment details have been suppressed for this payment since we have not received remittance information from the payer" );
				}
			}
			gotoNextPage(pageNo, totalNoOfPages);
	    }
     }
    
	/**
	 * gets the record count
	 * @return number of payments
	 */
	public String newGetRecordCountFromUI()
	{
		try
		{
			if(!testConfig.driver.getPageSource().contains("No payments have been made to this Organization"))
			{
				String recordCountElement[]=recordCount.getText().split(":");
				return recordCountElement[recordCountElement.length-1].trim();
			}
			else
			{
				return "0";
			}
		}
		catch(Exception e)
		{
			return "0";
		}
	    
	}

	public int newGetNumberOfPages()
	 {
		int noOfPages=0;
		int recordsCount=Integer.parseInt(newGetRecordCountFromUI());
		if(recordsCount>30)
		 {
			noOfPages=recordsCount/30;
			if(recordsCount%30>0)
				noOfPages=noOfPages+1;
		 }
		else if(recordsCount%30 >=1)
		{
			noOfPages=1;
		}
		
    	return noOfPages;
	 } 
	
	/**
	 * Finds if a failed Payment is displayed 
	 * on payment summary page
	 * if yes, hovers mouse over 'Failed Payment' text
	 * and verifies that a pop appears and 
	 * verifies in it
	 */
    public void verifyFailedPaymentPopUp(String quickSearchFilter) 
     {
    	newSetSearchFilters(null, quickSearchFilter, "Show All", null);
    	String paymentStatus="";
    	String totalNoOfPayments = newGetRecordCountFromUI();
    	
    	if(totalNoOfPayments.equals("0"))
    	{
    		quickSearchFilter = "Last 4-6 months";
    		quickSearchFilter = setQuickSearchFilter(quickSearchFilter,false,1);
    	}

    	int totalNoOfPages=newGetNumberOfPages();
    	Boolean foundFailedPayment = false;
    	Boolean checkedAllPageOptions = false;
    	Log.Comment("Total No. of pages are :" + totalNoOfPages);
    	
    	while(foundFailedPayment != true && checkedAllPageOptions !=true)
    	{
        	totalNoOfPages=newGetNumberOfPages();
        	
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
						  foundFailedPayment = true;
					      Element.onMouseHover(testConfig, searchResultRows.get(i).findElements(By.tagName("td")).get(7), "Failed Payment with payment number : " + searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText());

					      Log.Warning("Please validate this test case manually. ", testConfig);
					      
					      break;
					  }
				    } 
	    	    }
    	    	else
    	    	{  
    	    		gotoNextPage(pageNo, totalNoOfPages);
    	    	}	    	
    	    }
	    	
	    	if(foundFailedPayment == false)
	    	{
	    		switch(quickSearchFilter)
	    		{
		    		case "Last 90 days":
		    			quickSearchFilter= "Last 4-6 months";
		    			setQuickSearch(quickSearchFilter);
		    			break;
		    		case "Last 4-6 months":
		    			quickSearchFilter= "Last 6-9 months";
		    			setQuickSearch(quickSearchFilter);
		    			break;
		    		case "Last 6-9 months":
		    			quickSearchFilter= "Last 9-13 months";
		    			setQuickSearch(quickSearchFilter);
		    			break;
		    		case "Last 9-13 months":
		    			Log.Fail("Could not find failed payment on any of the pages, please execute test case manually");
		    			checkedAllPageOptions = true;
		    			break;
	    		}
	    	}
	    	
    	}
     }
	
	public paymentSummary newSetSearchFilters(String filterPayments,String quickSearchFilter,String Archivefilter,String MktTypeFilter)
	{
		if(filterPayments != null) {
			Element.selectByVisibleText(drpDwnFilterPayments,filterPayments,filterPayments + " " +" from 'Filter payments' dropdown");
			Browser.waitForLoad(testConfig.driver);
    		Browser.wait(testConfig,2);	
		}
		
		if(quickSearchFilter != null) {
			Element.selectByVisibleText(drpDwnQuickSearch,quickSearchFilter,quickSearchFilter + " " +" from 'Quick Search' dropdown");
			getQuickSearchDates(quickSearchFilter);
			Browser.waitForLoad(testConfig.driver);
    		Browser.wait(testConfig,2);
		}
		else {
			quickSearchFilter ="Last 30 days";
			getQuickSearchDates(quickSearchFilter);
		}
		
		if(Archivefilter != null) 
		{	
        	Element.selectByVisibleText(drpDwnArchiveFilter,Archivefilter, Archivefilter + " " +" from 'Archive payments' dropdown");
        	Browser.waitForLoad(testConfig.driver);
    		Browser.wait(testConfig,2);
		}
		
		if(MktTypeFilter != null) 
		{
			Element.selectByVisibleText(drpDwnMarketType,MktTypeFilter,MktTypeFilter + " " +" from 'Market Type' dropdown");
			Browser.waitForLoad(testConfig.driver);	
    		Browser.wait(testConfig,2);
		}
		return this;
	}
	
  		  
	
	
}



