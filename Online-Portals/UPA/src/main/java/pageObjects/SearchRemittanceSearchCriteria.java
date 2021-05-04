
package main.java.pageObjects;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.xml.sax.SAXException;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;


public class SearchRemittanceSearchCriteria {
	
	TestBase testConfig=TestBase.getInstance();
	private ViewPaymentsDataProvider dataProvider;
	private RemittanceDetail remittanceDetail = new RemittanceDetail(testConfig);
	
	@FindBy(id="checkNumberInputId")
	WebElement checkNumber;
	
	//@FindBy(id="paymentNumberInputId") WebElement paymentNumber;
	
	@FindBy(id="paymentNbrTypeSelection")
	WebElement paymentNumberType;
	
	@FindBy(id="patientLastNameId")
	WebElement patientLastName;
	
	@FindBy(id="patientFirstNameId")
	WebElement patientFirstName;
	
	@FindBy(id="providerLastNameID")
	WebElement renderingProvName;
	
	@FindBy(id="providerLastNameID")
	WebElement providerLastName;
	
	@FindBy(name="searchRemittance")
	WebElement btnSearchRemittance;
	
	@FindBy(xpath = "//input[@name='paymentNumber']") WebElement paymentNumber;
	
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[3]/td[3]/a[2]/img")
	WebElement dosTo;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[3]/td[3]/a[1]/img")
	WebElement dosFrom;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[5]/td[3]/a[2]/img")
	WebElement dopTo;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[5]/td[3]/a[1]/img")
	WebElement dopFrom;
	
	@FindBy(xpath = "//img[@alt='previous month']")
	WebElement btnPreviousMonth;
	
	@FindBy(xpath = "//img[@alt='next month']")
	WebElement btnNextMonth;
	
	@FindBy(xpath = "//img[@alt='previous year']")
	WebElement btnPreviousYear;
	
	@FindBy(xpath = "//img[@alt='next year']")
	WebElement btnNxtYear;
	
	@FindBy(xpath = "//table//table//table//tr//font")
	WebElement monthYearInCal;
	
	@FindBy(id="payerIdSelection")
	WebElement drpDwnPayer;
	
	@FindBy(id="ClaimAccountNum")
	WebElement accountNo;
	
	@FindBy(id="subscriberIDText")
	WebElement subscriberID;
	
	@FindBy(id="npiIDText")
	WebElement NPI;
	
	@FindBy(id="claimNumberID")
	WebElement claimNumber;
	
	@FindBy(id="zeroPaymentID")
	WebElement zeroPaymentClaims;
	
	@FindBy(xpath="//table[@id='newSearchParamTable']/tbody/tr[14]/td[1]/span")
	WebElement marketType;
	
	@FindBy(xpath="//table[@class='w-100']/tbody/tr[1]/td/span")
	WebElement allMktType;
	
	@FindBy(id="allMarketTypeId")
	WebElement allMarketType;
	
	@FindBy(xpath = "//font[contains(text(),'Start Date')]")
	WebElement strtDateErrorMsg;
	
	@FindBy(xpath = "//font[contains(text(),'End Date')]")
	WebElement endDateErrorMsg;
	
	@FindBy(xpath = "//font[contains(text(),'Date(s) of Service')]")
	WebElement DOSErrorMsg;
	
	@FindBy(xpath = "//font[contains(text(),'Date(s) of Payment')]")
	WebElement POSErrorMsg;
	
	@FindBy(name="taxIdNbr")
	WebElement txtboxTinNo;
	
	@FindBy(xpath="//td[contains(text(),'TIN:')]") WebElement tinnum1;
	
	
	@FindBy(xpath="//input[@id='startDateOfPaymentId']") WebElement startDOPDate;
	@FindBy(xpath="//input[@id='endDateOfPaymentId']") WebElement endDOPDate;
	
	@FindBy(id="startDateOfPaymentId")
	WebElement dopFromDate;
	
	@FindBy(id="endDateOfPaymentId")
	WebElement dopToDate;
	
	
	
	@FindBy(xpath=".//*[@class='Subheaderbold']//input[2]")
	WebElement btnSearch;
	Map dataRequiredForSearch;
	
	//Added by Mohammad
		@FindBy(xpath="//div[@class='topMessaggeDiv']/p[contains(text(),'As a reminder')]")
		WebElement premiumMsgTop_Provider;
		
		@FindBy(xpath="//div[@id='seachRemittancePremium']/h2")
		WebElement standardMsgTop_Header;
		
		@FindBy(xpath="//div[@id='seachRemittancePremium']/p[contains(text(),'Your basic level')]")
		WebElement standardMsgTop_Content;
		
		@FindBy(xpath="(//span[@class='ui-button-text'])[2]")
		WebElement standardMsgTop_GetStartedLink;
		
		
		//The messages for the Search Remittance page
		
		String msgTop_Prov = "As a reminder with the full functionality of Optum Pay, you have access to historical remittance and claims payment data dating back 36 months. ";
		String standardMsgTop_Header_Prov = "Activate Optum Pay now";
		String standardMsgTop_Content_Prov_Adm = "Your basic level of Optum Pay does not provide access to historical remittance and claim data. For data dating back 36 months, activate the full functionality of Optum Pay today.";
		String standardMsgTop_Content_Prov_Gen = "Your basic level of Optum Pay does not provide access to historical remittance and claim data. For data dating back 36 months, ask your account administrator to activate Optum Pay.";
		
	
	public SearchRemittanceSearchCriteria(TestBase testConfig)
	{
//		testConfig=this.testConfig;
		PageFactory.initElements(this.testConfig.driver, this);
		try{
			txtboxTinNo.getText();
		}
		catch(NoSuchElementException e)
		{
			txtboxTinNo=null;
		}
		
//		WebElement check=Element.findElement(testConfig, "name", "taxIdNbr");
//		if(txtboxTinNo==null)
//			Element.expectedWait(btnSearchRemittance, testConfig, "Search Remittance button", "Search Remittance button");
	}
	
	public void verifyFieldName()
	{
		Helper.compareEquals(testConfig, "Market Type text", marketType.getText(), "Market Type");
		Helper.compareEquals(testConfig, "All Market Types", allMktType.getText(), "All Market Types");
	}
	
	public SearchRemittance doSearch(String criteriaType) throws ParseException 
	{
		remittanceDetail.handleTechnicalDifficultyError();
		String date="";
		Map srchData=null;
		int sqlRow = 0;
		
		Log.Comment(testConfig.getRunTimeProperty("suite"));

		switch(criteriaType)
		 {
		
		 case "byElectronicPaymentNoRemit": {
			 Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Electronic Payment Number from 'Payment Number' dropdown");
		    	Browser.wait(testConfig, 5);
		    	Element.clickByJS(testConfig,paymentNumber, "Payment No text box");
		    	String dspl_consl_pay_nbr = testConfig.getRunTimeProperty("DSPL_CONSOL_PAY_NBR");
		    	System.out.println(dspl_consl_pay_nbr);
		    	Element.enterData(paymentNumber, dspl_consl_pay_nbr, "Enter Electronic payment number as: " + dspl_consl_pay_nbr, "payment number");
		    	break;
		}
			
		 case "EPRAElectronicPaymentNo":  
		    {

		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Electronic Payment Number from 'Payment Number' dropdown");
		    	Browser.wait(testConfig, 5);
		    	Element.clickByJS(testConfig,paymentNumber, "Payment No text box");
		    	String dspl_consl_pay_nbr = testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
                Element.enterData(paymentNumber, dspl_consl_pay_nbr, "Enter Electronic payment number as: " + dspl_consl_pay_nbr, "payment number");
		    	break;
		    	
		    }
		 case "byElectronicPaymentNo":  
		    {
                //Priyanka
		    	
                dataRequiredForSearch=dataProvider(criteriaType);
		    	
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Electronic Payment Number from 'Payment Number' dropdown");
		    	Element.clickByJS(testConfig,paymentNumber, "Payment No text box");
		    	Element.enterData(paymentNumber, dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString(), "Enter Electronic payment number as: " +dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString(), "payment number");
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }		    	
		    	testConfig.putRunTimeProperty("key1", "ELECTRONIC_PAYMENT_NUMBER");
		    	testConfig.putRunTimeProperty("value1", dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString());
		    	testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterYears(-2,"yyyy-MM-dd"));
		    	testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		    	break;
		    	
		    }

		 case "byElectronicPayNum":  
		    {

		    	//Rahul
		    	
             dataRequiredForSearch=dataProvider(criteriaType);
		    	
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Electronic Payment Number from 'Payment Number' dropdown");
		    	Element.clickByJS(testConfig,paymentNumber, "Payment No text box");
		    	Element.enterData(paymentNumber, dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString(), "Enter Electronic payment number as: " +dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString(), "payment number");
		    	Element.selectByVisibleText(drpDwnPayer, dataRequiredForSearch.get("PAYR_DSPL_NM").toString().trim(), "Payer Selected from dropdown");
		    	testConfig.putRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER", dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString());
		    	
		    	testConfig.putRunTimeProperty("key1", "ELECTRONIC_PAYMENT_NUMBER");
		    	testConfig.putRunTimeProperty("value1", dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString());
		    	testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterYears(-2,"yyyy-MM-dd"));
		    	testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		    	break;
		    	
		    	
		    	
		    }    


		    case "byCheckNo":
		    {
		    	dataRequiredForSearch=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Check Number", "Check Number from 'Payment Number' dropdown");
		    	Element.clickByJS(testConfig,checkNumber, "Check No text box");
		    	Element.enterData(checkNumber, dataRequiredForSearch.get("UCONSL_PAY_NBR").toString(), "Enter Check No as: " + dataRequiredForSearch.get("UCONSL_PAY_NBR").toString(), "payment number");
		    	Element.selectByVisibleText(drpDwnPayer, "UnitedHealthcare", "United Health Care from Payer dropdown");
		    	
		    	testConfig.putRunTimeProperty("key1", "CHECK_NUMBER");
		    	testConfig.putRunTimeProperty("value1", dataRequiredForSearch.get("UCONSL_PAY_NBR").toString());
		    	testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterYears(-2,"yyyy-MM-dd"));
		    	testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		    	break;		    	
		    }

		    case "byDOS":
		    {
		    	
		    	testConfig.putRunTimeProperty("key","MARKET_TYPE");
		    	testConfig.putRunTimeProperty("value","ALL");
		    	String fromDateDos =  Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	String toDateDos = Helper.changeDateFormat(testConfig.getRunTimeProperty("toDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	
		    	
		    	//For selecting date into calendar
		    	clickFromDateIcon(criteriaType).setDate(fromDateDos, criteriaType).clickToDateIcon(criteriaType).setDate(toDateDos, criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }		    	break;		    	
		    }
		    
		    
		    
		    case "byDOP":
		    {
		    	sqlRow = 42;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");

		    	
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }		    	date=Helper.changeDateFormat(date, "mm/dd/yyyy", "yyyy-mm-dd");
		    	testConfig.putRunTimeProperty("fromDate",date);
		    	testConfig.putRunTimeProperty("toDate",date);
		    	testConfig.putRunTimeProperty("key", "MARKET_TYPE");
		    	testConfig.putRunTimeProperty("value", "ALL");		    	
		    	
		    	break;	
		    }
		    
		    case "EPRADOPAndAccountNo":
		    {
		    	String ptnt_acct_nbr = System.getProperty("ptnt_acct_nbr");
		    	Element.enterData(accountNo, ptnt_acct_nbr, "Enter patient account no as : "+ptnt_acct_nbr, "Account Number");
		    	String fromDate =  System.getProperty("fromDate");
		    	String toDate =  System.getProperty("toDate");
		    	
                if("EPRAgenerated".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayergeneratedAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayergeneratedGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAgeneratedBSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedBSGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVAdmin".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    	Element.enterData(startDOPDate, Helper.changeDateFormat(fromDate, "yyyy-mm-dd", "mm/dd/yyyy"), "Start Date", "Start Date");
         		Element.enterData(endDOPDate, Helper.changeDateFormat(toDate, "yyyy-mm-dd", "mm/dd/yyyy"), "End Date", "End Date");
		    	}
		    	else if("EPRA".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayerAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayerGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRABSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRABGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayer".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    		Element.enterData(startDOPDate, fromDate, "Start Date", "Start Date");
		    		Element.enterData(endDOPDate, toDate, "Start Date", "Start Date");
		    	}

		    	break;
		    }
		   
		    
		    //Priyanka
		    case "byDOPAndAccountNo":
		    {
		    	sqlRow = 42;
		    	String acntNo;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	acntNo=srchData.get("PTNT_ACCT_NBR").toString();
				date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
		    	Element.enterData(accountNo, acntNo, "Enter patient account no as : "+acntNo, "Account Number");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }		    	date=Helper.changeDateFormat(date, "mm/dd/yyyy", "yyyy-mm-dd");
		    	testConfig.putRunTimeProperty("key", "ACCOUNT_NUMBER");
		    	testConfig.putRunTimeProperty("value", acntNo);	
		    	testConfig.putRunTimeProperty("fromDate",date);
		    	testConfig.putRunTimeProperty("toDate",date);
		    	
		    	break;
		    }
		    
		    
		    case "EPRADOP&SubscriberID":
		    {

		    	String sbscrId = System.getProperty("sbscr_id");
		    	String fromDate =  System.getProperty("fromDate");
		    	String toDate =  System.getProperty("toDate");
		    	
		    	Element.enterData(subscriberID, sbscrId, "Enter Subscriber ID no as : "+sbscrId, "Subscriber ID");
		    	

		    	if("EPRAgenerated".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayergeneratedAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayergeneratedGen".equals(testConfig.getRunTimeProperty("suite"))
		    	||"EPRAgeneratedBSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedBSGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVAdmin".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    	Element.enterData(startDOPDate, Helper.changeDateFormat(fromDate, "yyyy-mm-dd", "mm/dd/yyyy"), "Start Date", "Start Date");
         		Element.enterData(endDOPDate, Helper.changeDateFormat(toDate, "yyyy-mm-dd", "mm/dd/yyyy"), "End Date", "End Date");
		    	}
		    	else if("EPRA".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayerAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayerGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRABSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRABGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayer".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    		Element.enterData(startDOPDate, fromDate, "Start Date", "Start Date");
		    		Element.enterData(endDOPDate, toDate, "Start Date", "Start Date");
		    	}
         		

		    	break;
		    }
		    
		    
		    case "byDOP&SubscriberID":
		    {
		    	sqlRow = 43;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	String sbscrId=srchData.get("SBSCR_ID").toString();
		    	
		    	testConfig.putRunTimeProperty("fromDate",srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("key", "SUBSCRIBER_IDENTIFIER");
		    	testConfig.putRunTimeProperty("value", sbscrId);
		    	
		    	
				date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
		    	Element.enterData(subscriberID, sbscrId, "Filling patient subscriber Id: "+sbscrId, "subscriber Id");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }		    	
		    	
		    	break;
		    }

		   case "EPRADOPAndNpi":
		    {
		    	String dspl_consl_pay_nbr = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
		    	String fromDate = System.getProperty("fromDate");
		    	String toDate = System.getProperty("toDate");
		    	String npi = System.getProperty("npi");
		    	Element.clickByJS(testConfig,NPI, "NPItext box");
		    	Element.enterData(NPI, npi, "Filling NPI No: "+ npi, "NPI");
		    	
		    	if("EPRAgenerated".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayergeneratedAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayergeneratedGen".equals(testConfig.getRunTimeProperty("suite"))
		    	||"EPRAgeneratedBSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedBSGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVAdmin".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    	Element.enterData(startDOPDate, Helper.changeDateFormat(fromDate, "yyyy-mm-dd", "mm/dd/yyyy"), "Start Date", "Start Date");
         		Element.enterData(endDOPDate, Helper.changeDateFormat(toDate, "yyyy-mm-dd", "mm/dd/yyyy"), "End Date", "End Date");
		    	}
		    	else if("EPRA".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayerAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayerGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRABSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRBSGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayer".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    		Element.enterData(startDOPDate, fromDate, "Start Date", "Start Date");
		    		Element.enterData(endDOPDate, toDate, "Start Date", "Start Date");
		    	}
		    	
		    	break;
		    }
		    
		    
		    

		    case "byDOPAndNpi":
		    {
		    	sqlRow = 44;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	String fromDate=Helper.addDays(srchData.get("SETL_DT").toString(), -10);
		    	
		    	testConfig.putRunTimeProperty("fromDate",fromDate);
		    	testConfig.putRunTimeProperty("toDate", srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("NPI", srchData.get("PROV_NPI_NBR").toString());
		    	Element.clickByJS(testConfig,NPI, "NPItext box");
		    	Element.enterData(NPI, srchData.get("PROV_NPI_NBR").toString(), "Filling NPI No: "+ srchData.get("PROV_NPI_NBR").toString(), "NPI");
		    	clickFromDateIcon(criteriaType).setDate(Helper.changeDateFormat(fromDate, "yyyy-mm-dd", "mm/dd/yyyy"), criteriaType).clickToDateIcon(criteriaType).setDate(Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy"), criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }		    	break;
		    }
		    
		    case "EPRADOPAndClaimNo":
		    {

		    	String clm_nbr = System.getProperty("clm_nbr");
		    	String fromDate = System.getProperty("fromDate");
		    	String toDate = System.getProperty("toDate");
		    	Element.clickByJS(testConfig,claimNumber, "Claim Number text box");
		    	Element.enterData(claimNumber, clm_nbr, "Enter claim no as : "+clm_nbr, "Claim Number");
		    	
		    	if("EPRAgenerated".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayergeneratedAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayergeneratedGen".equals(testConfig.getRunTimeProperty("suite"))
		    	||"EPRAgeneratedBSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedBSGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVAdmin".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    	Element.enterData(startDOPDate, Helper.changeDateFormat(fromDate, "yyyy-mm-dd", "mm/dd/yyyy"), "Start Date", "Start Date");
         		Element.enterData(endDOPDate, Helper.changeDateFormat(toDate, "yyyy-mm-dd", "mm/dd/yyyy"), "End Date", "End Date");
		    	}
		    	else if("EPRA".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayerAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayerGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRABSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRABGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayer".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    		Element.enterData(startDOPDate, fromDate, "Start Date", "Start Date");
		    		Element.enterData(endDOPDate, toDate, "Start Date", "Start Date");
		    	}
		    	
		    	break;		    	
		    }
		    
		    case "byDOPAndClaimNo":
		    {
		    	sqlRow = 45;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	testConfig.putRunTimeProperty("fromDate",srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("key", "CLAIM_IDENTIFIER");
		    	testConfig.putRunTimeProperty("value", srchData.get("CLM_NBR").toString());
				
		    	Element.clickByJS(testConfig,claimNumber, "Claim Number text box");
		    	Element.enterData(claimNumber, srchData.get("CLM_NBR").toString(), "Enter claim no as : "+srchData.get("CLM_NBR").toString(), "Claim Number");
		    	clickFromDateIcon(criteriaType).setDate(Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy"), criteriaType).clickToDateIcon(criteriaType).setDate(Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy"), criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }		    	
		    	break;		    	
		    }
		    
		    case "EPRADOPAndPatientNm":
		    {

		    	String ptnt_fst_nm = System.getProperty("ptnt_fst_nm");
		    	String ptnt_lst_nm = System.getProperty("ptnt_lst_nm");
		    	String fromDate = System.getProperty("fromDate");
		    	String toDate = System.getProperty("toDate");
		    	
		    	Element.enterData(patientFirstName, ptnt_fst_nm, "Enter First Name as : "+ptnt_lst_nm, "First Name");
		    	Element.enterData(patientLastName, ptnt_lst_nm, "Enter Last Name as: "+ptnt_lst_nm, "Last Name");
		    	
		    	if("EPRAgenerated".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayergeneratedAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayergeneratedGen".equals(testConfig.getRunTimeProperty("suite"))
		    	||"EPRAgeneratedBSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedBSGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVAdmin".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    	Element.enterData(startDOPDate, Helper.changeDateFormat(fromDate, "yyyy-mm-dd", "mm/dd/yyyy"), "Start Date", "Start Date");
         		Element.enterData(endDOPDate, Helper.changeDateFormat(toDate, "yyyy-mm-dd", "mm/dd/yyyy"), "End Date", "End Date");
		    	}
		    	else if("EPRA".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayerAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayerGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRABSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRABGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayer".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    		Element.enterData(startDOPDate, fromDate, "Start Date", "Start Date");
		    		Element.enterData(endDOPDate, toDate, "Start Date", "Start Date");
		    	}
         		

		    	break;		    	
		    }
		    
		    case "byDOPAndPatientNm":
		    {
		    	sqlRow = 46;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	testConfig.putRunTimeProperty("key", "PATIENT_FIRST_NAME");
		    	testConfig.putRunTimeProperty("value", srchData.get("PTNT_FST_NM").toString());
		    	testConfig.putRunTimeProperty("key1", "PATIENT_LAST_NAME");
		    	testConfig.putRunTimeProperty("value1", srchData.get("PTNT_LST_NM").toString());
		    	testConfig.putRunTimeProperty("fromDate",srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("SETL_DT").toString());
		    	
				date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");					
		    	Element.enterData(patientFirstName, srchData.get("PTNT_FST_NM").toString(), "Enter First Name as : "+srchData.get("PTNT_FST_NM").toString(), "First Name");
		    	Element.enterData(patientLastName, srchData.get("PTNT_LST_NM").toString(), "Enter Last Name as: "+srchData.get("PTNT_LST_NM").toString(), "Last Name");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }		    	break;		    	
		    }

		    
		    case "byDOPAndZeroPaymentClaims":
		    {   
		    	
		    	testConfig.putRunTimeProperty("key", "ZERO_PAYMENT_CLAIMS");
		    	testConfig.putRunTimeProperty("value", "Y");
		    	
		    	date=Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	Element.click(zeroPaymentClaims, "Zero Payment Claims");
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }		    	
		    	break;		    	
		    }
		    
		    
		    case "byDOPAndMarketType":
		    {   
		    	date=Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	Element.click(testConfig.driver.findElement(By.xpath("//input[@value=" + "'" + testConfig.getRunTimeProperty("value") + "'" + "]")), "Market checkbox :" + testConfig.getRunTimeProperty("value"));
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }		    	
		    	break;		    	
		    }
		    
		    case "byDOSAndMarketType":
		    {   
		    	String dosFrom=Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	String dosTo=Helper.changeDateFormat(testConfig.getRunTimeProperty("toDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	Element.click(testConfig.driver.findElement(By.xpath("//input[@value=" + "'" + testConfig.getRunTimeProperty("value") + "'" + "]")), "Market checkbox :" + testConfig.getRunTimeProperty("value"));
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }
		    	break;		    	
		    }

		    case "byDOSAndAcntNo":
		    {
		    	String dosFrom=Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	String dosTo=Helper.changeDateFormat(testConfig.getRunTimeProperty("toDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	
		    	Element.enterData(accountNo, testConfig.getRunTimeProperty("value"), "Filling patient account no: "+ testConfig.getRunTimeProperty("value"), "Account Number");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }
		    	break;
		    }
		    

		    case "byDOSAndSubscriberId":
		    {

		    	String dosFrom=Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	String dosTo=Helper.changeDateFormat(testConfig.getRunTimeProperty("toDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	Element.enterData(subscriberID, testConfig.getRunTimeProperty("value"), "Filling patient subscriber Id: "+testConfig.getRunTimeProperty("value"), "subscriber Id");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }
		    	testConfig.putRunTimeProperty("appIdentifier", "EPS");
		    	testConfig.putRunTimeProperty("version", "1.0");
		    	break;
		    }
		    
		    case "byDOSAndNpi":
		    {
		    	testConfig.putRunTimeProperty("key","MARKET_TYPE");
		    	testConfig.putRunTimeProperty("value","ALL");
		    	String dosFrom=Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate"), "yyyy-mm-dd", "mm/dd/yyyy");
				String dosTo=Helper.changeDateFormat(testConfig.getRunTimeProperty("toDate"), "yyyy-mm-dd", "mm/dd/yyyy");
				
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	try {
					//new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }
		    	Element.click(NPI, "NPI");
		    	Element.enterData(NPI,testConfig.getRunTimeProperty("NPI"),"Enter NPI No as : "+ testConfig.getRunTimeProperty("NPI"), "NPI");
		    	break;
		    }

		    case "byDOSAndClmNo":
		    {
		    	String dosFrom=Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	String dosTo=Helper.changeDateFormat(testConfig.getRunTimeProperty("toDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	
		    	Element.clickByJS(testConfig,claimNumber, "Claim Number text box");
		    	Element.enterData(claimNumber, testConfig.getRunTimeProperty("value"), "Enter claim no as : "+testConfig.getRunTimeProperty("value"), "Claim Number");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }
		    	break;
		    }
		    
		    case "byDOSAndPtntNm":
		    {
		    	String dosFrom=Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	String dosTo=Helper.changeDateFormat(testConfig.getRunTimeProperty("toDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	
		    	Element.enterData(patientFirstName, testConfig.getRunTimeProperty("value"), "Enter First Name as : "+testConfig.getRunTimeProperty("value"), "First Name");
		    	Element.enterData(patientLastName, testConfig.getRunTimeProperty("value1"), "Enter Last Name as: "+testConfig.getRunTimeProperty("value1"), "Last Name");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }
		    	break;
		    }

		    case "byDOSAndZeroPmntClms":
		    {
		    	String dosFrom=Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	String dosTo=Helper.changeDateFormat(testConfig.getRunTimeProperty("toDate"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	Element.click(zeroPaymentClaims, "Zero Payment Claims");
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }
		    	break;
		    }
		    
		    case "DD":
		    	srchData=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
		    	Element.enterData(paymentNumber,srchData.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }
		    	break;
		    	
		    case "byElectronicPaymenForACH":
		    case "byElectronicPaymenForCHK":
		    	srchData=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
		    	Element.enterData(paymentNumber, srchData.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
		    	try {
					new Select(drpDwnPayer).selectByVisibleText("UnitedHealthcare");
					Log.Comment("Selected" + " " +  "United Health Care from Payer dropdown");
		    	}
			    catch(org.openqa.selenium.NoSuchElementException e) {
					new Select(drpDwnPayer).selectByVisibleText("Optum VA CCN");
					Log.Comment("Selected" + " " +  "UOptum VA CCN from Payer dropdown");
			    }
		    	break;
		    	
		    case "byElectronicPaymenForNON":
		    case "byElectronicPaymentForVCP":
		    	srchData=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
		    	Element.enterData(paymentNumber, srchData.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
		    	Element.selectByVisibleText(drpDwnPayer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	testConfig.putRunTimeProperty("typeDescription",srchData.get("TYP_DESC").toString());
		    	testConfig.putRunTimeProperty("paymentMethCode",srchData.get("PAY_METH_CD").toString());
		    	testConfig.putRunTimeProperty("paymentStatusTypeID",srchData.get("PAY_STS_TYP_ID").toString());
		    	break;

		    case "byCheckNoOfReoriginNacha":
		    case "byCheckNoOfConslPayDtl":
		    
		    	Element.selectByVisibleText(paymentNumberType, "Check Number", "Check Number from 'Payment Number' dropdown");
		    	Element.clickByJS(testConfig,checkNumber, "Check No text box");
		    	Element.enterData(checkNumber,testConfig.getRunTimeProperty("value"), "Enter Check No as: " + testConfig.getRunTimeProperty("value"), "payment number");
		    	testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterYears(-2,"yyyy-MM-dd"));
		    	testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		    	break;
		    	
		   case "EPRADOPAndRenderingProvider":

		    	String lst_nm = System.getProperty("lst_nm");
		    	String fromDate = System.getProperty("fromDate");
		    	String toDate = System.getProperty("toDate");
		    	Element.enterData(renderingProvName, lst_nm, "Filling Rendering Provider Name: "+lst_nm, "Rendering Prov");
		    	
		    	if("EPRAgenerated".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayergeneratedAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayergeneratedGen".equals(testConfig.getRunTimeProperty("suite"))
		    	||"EPRAgeneratedBSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedBSGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgeneratedPROVAdmin".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    	Element.enterData(startDOPDate, Helper.changeDateFormat(fromDate, "yyyy-mm-dd", "mm/dd/yyyy"), "Start Date", "Start Date");
         		Element.enterData(endDOPDate, Helper.changeDateFormat(toDate, "yyyy-mm-dd", "mm/dd/yyyy"), "End Date", "End Date");
		    	}
		    	else if("EPRA".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPROVGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRAPayerAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayerGen".equals(testConfig.getRunTimeProperty("suite"))
		    			||"EPRABSAdmin".equals(testConfig.getRunTimeProperty("suite"))||"EPRABGen".equals(testConfig.getRunTimeProperty("suite"))||"EPRAPayer".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    		Element.enterData(startDOPDate, fromDate, "Start Date", "Start Date");
		    		Element.enterData(endDOPDate, toDate, "Start Date", "Start Date");
		    	}

	 			break;
	 			
		    case "byDOPAndRenderingProvider":
				date=Helper.changeDateFormat(testConfig.getRunTimeProperty("fromDate").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
		    	Element.enterData(renderingProvName, testConfig.getRunTimeProperty("value"), "Filling Rendering Provider Name: "+testConfig.getRunTimeProperty("value"), "Rendering Prov");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	Element.selectByVisibleText(drpDwnPayer, "UMR",  "UMR");
	 			break;
	 			
	 			
			 case "byHCPayment_Number":
				{
					Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Electronic Payment Number from 'Payment Number' dropdown");
					Element.waitForElementTobeClickAble(testConfig, paymentNumber, 10);
					Element.clickByJS(testConfig,paymentNumber, "Payment No text box");
					Element.enterData(paymentNumber, System.getProperty("CONSL_PAY_NBR"), "Enter Electronic payment number as: " +System.getProperty("CONSL_PAY_NBR"), "payment number");
					break;
				}	
	 	
		    case "byHCDOPAndNpi":
			{
				Element.waitForElementTobeClickAble(testConfig, NPI, 10);
				Element.clickByJS(testConfig,NPI, "NPItext box");
				Element.enterData(NPI, System.getProperty("NPI"), "Filling NPI No: "+ System.getProperty("NPI"), "NPI");
				Element.waitForElementTobeClickAble(testConfig, dopFromDate, 10);
				Element.enterData(dopFromDate, System.getProperty("DOPFromDate"), "DoP From Date", "NPI");
				Element.waitForElementTobeClickAble(testConfig, dopToDate, 10);
				Element.enterData(dopToDate, System.getProperty("DOPToDate"), "DoP To Date", "NPI");

				break;	    	
			}		
		    default:
		    	Log.Comment("Criteria Type " + criteriaType + " not found");		
		 }
		
		return clickSearchBtn();
	
	}
	
	
	
	public SearchRemittance doSearchForPayer(String criteriaType) throws ParseException {
		
		String date="";
		Map srchData=null;
		int sqlRow;
		
		Log.Comment(testConfig.getRunTimeProperty("suite"));
		
		switch(criteriaType)
		 {
		 case "byElectronicPaymentNo":  
		    {
		    	if("EPRAPayer".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    		 sqlRow = 210;
		    		dataRequiredForSearch = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	}        
		    	else if("EPRAgenerated".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    		 sqlRow = 205;
		    		dataRequiredForSearch = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	}
		    	else		    		
		    		dataRequiredForSearch=dataProvider(criteriaType);
		    	
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Electronic Payment Number from 'Payment Number' dropdown");
		    	Element.clickByJS(testConfig,paymentNumber, "Payment No text box");
		    	Element.enterData(paymentNumber, dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString(), "Enter Electronic payment number as: " +dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString(), "payment number");
		    	
		    	
		    	//testConfig.putRunTimeProperty("CONSL_PAY_NBR", dataRequiredForSearch.get("CONSL_PAY_NBR").toString());
		    	testConfig.putRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER", dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString());
		    	testConfig.putRunTimeProperty("key1", "ELECTRONIC_PAYMENT_NUMBER");
		    	testConfig.putRunTimeProperty("value1", dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString());
		    	testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterYears(-2,"yyyy-MM-dd"));
		    	testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		    	break;
		    }
		    
		    case "byCheckNo":
		    {
		    	dataRequiredForSearch=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Check Number", "Check Number from 'Payment Number' dropdown");
		    	Element.clickByJS(testConfig,checkNumber, "Check No text box");
		    	Element.enterData(checkNumber, dataRequiredForSearch.get("UCONSL_PAY_NBR").toString(), "Enter Check No as: " + dataRequiredForSearch.get("UCONSL_PAY_NBR").toString(), "payment number");
		    	
		    	
		    	testConfig.putRunTimeProperty("key1", "CHECK_NUMBER");
		    	testConfig.putRunTimeProperty("value1", dataRequiredForSearch.get("UCONSL_PAY_NBR").toString());
		    	testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterYears(-2,"yyyy-MM-dd"));
		    	testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		    	break;		    	
		    }
		    
		    case "byDOS":
		    {
		    	String toDateDos = Helper.getCurrentDate("MM/dd/yyyy");
		    	String fromDateDos = Helper.getDateBeforeOrAfterDays(-30,"MM/dd/yyyy");
		    	
		    	clickFromDateIcon(criteriaType).setDate(fromDateDos, criteriaType).clickToDateIcon(criteriaType).setDate(toDateDos, criteriaType);
		    	System.out.println(Helper.changeDateFormat(testConfig, fromDateDos, "MM/dd/yyyy", "yyyy-MM-dd"));
		    	
		    	testConfig.putRunTimeProperty("fromDate",Helper.changeDateFormat(testConfig, fromDateDos, "MM/dd/yyyy", "yyyy-MM-dd"));
		    	testConfig.putRunTimeProperty("toDate", Helper.changeDateFormat(testConfig, toDateDos, "MM/dd/yyyy", "yyyy-MM-dd"));
		    	
		    	break;		    	
		    }
		    
		    case "byDOP":
		    {
		    	 sqlRow = 42;
		    	 
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
                clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		        date=Helper.changeDateFormat(date, "mm/dd/yyyy", "yyyy-mm-dd");
		    	testConfig.putRunTimeProperty("fromDate",date);
		    	testConfig.putRunTimeProperty("toDate",date);
		    	testConfig.putRunTimeProperty("key", "MARKET_TYPE");
		    	testConfig.putRunTimeProperty("value", "ALL");		    	
		    	
		    	break;	
		    }
		    
		    case "byDOPAndAccountNo":
		    {
		    	 sqlRow = 42;
		    	String acntNo;
		    	
		    	System.getProperty("tin");
		    	testConfig.putRunTimeProperty("tin", System.getProperty("tin"));
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	acntNo=srchData.get("PTNT_ACCT_NBR").toString();
				date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
		    	Element.enterData(accountNo, acntNo, "Enter patient account no as : "+acntNo, "Account Number");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	date=Helper.changeDateFormat(date, "mm/dd/yyyy", "yyyy-mm-dd");
		    	testConfig.putRunTimeProperty("key", "ACCOUNT_NUMBER");
		    	testConfig.putRunTimeProperty("value", acntNo);	
		    	testConfig.putRunTimeProperty("fromDate",date);
		    	testConfig.putRunTimeProperty("toDate",date);
		    	
		    	break;
		    }
		    
		    
		    case "byDOP&SubscriberID":
		    {
		    	sqlRow = 43;
		    	System.getProperty("tin");
			    testConfig.putRunTimeProperty("tin", System.getProperty("tin"));
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	String sbscrId=srchData.get("SBSCR_ID").toString();
		    	
		    	testConfig.putRunTimeProperty("fromDate",srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("key", "SUBSCRIBER_IDENTIFIER");
		    	testConfig.putRunTimeProperty("value", sbscrId);
		    	
		    	
				date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
		    	Element.enterData(subscriberID, sbscrId, "Filling patient subscriber Id: "+sbscrId, "subscriber Id");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	break;
		    }
		    

		  case "byDOPAndNpi":
		    {
		    	
		    	if("EPRA".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    		 sqlRow = 204;
		    		dataRequiredForSearch = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    		
		    	}
		    	else if("EPRAgenerated".equals(testConfig.getRunTimeProperty("suite"))){
		    		 sqlRow = 205;
		    		dataRequiredForSearch = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	}
		    	else		    		
		    		dataRequiredForSearch=dataProvider(criteriaType);

		    	
		    	System.setProperty("ELECTRONIC_PAYMENT_NUMBER", dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString());
		    	
		    	System.out.println(System.getProperty("ELECTRONIC_PAYMENT_NUMBER"));
		    	
		    
		    	if("EPRA".equals(testConfig.getRunTimeProperty("suite"))||"EPRAgenerated".equals(testConfig.getRunTimeProperty("suite")))
		    	{
		    		sqlRow = 208;
			    	dataRequiredForSearch = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
			    	String fromDate=Helper.addDays(dataRequiredForSearch.get("SETL_DT").toString(), -10);
			    	System.out.println(fromDate);
			    	testConfig.putRunTimeProperty("fromDate",fromDate);
			    	testConfig.putRunTimeProperty("toDate", dataRequiredForSearch.get("SETL_DT").toString());
			    	testConfig.putRunTimeProperty("key", "NATIONAL_PROVIDER_IDENTIFIER");
			    	testConfig.putRunTimeProperty("value", dataRequiredForSearch.get("PROV_NPI_NBR").toString());
			    	
			    	
			    	
			    		
			    	Element.clickByJS(testConfig,NPI, "NPItext box");
			    	Element.enterData(NPI, dataRequiredForSearch.get("PROV_NPI_NBR").toString(), "Filling NPI No: "+ dataRequiredForSearch.get("PROV_NPI_NBR").toString(), "NPI");
			    	clickFromDateIcon(criteriaType).setDate(Helper.changeDateFormat(fromDate, "yyyy-mm-dd", "mm/dd/yyyy"), criteriaType).clickToDateIcon(criteriaType).setDate(Helper.changeDateFormat(dataRequiredForSearch.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy"), criteriaType);
			    	
		    	}
		    	
		    	else
		    	{
		    		Log.Comment("Page didnt display correctly");
		    	}
		    	 
		    	
		    	break;
		    }
		    
		    case "byDOPAndClaimNo":
		    {
		    	 sqlRow = 45;
		    	 System.getProperty("tin");
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	testConfig.putRunTimeProperty("fromDate",srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("key", "CLAIM_IDENTIFIER");
		    	testConfig.putRunTimeProperty("value", srchData.get("CLM_NBR").toString());
				
		    	Element.clickByJS(testConfig,claimNumber, "Claim Number text box");
		    	Element.enterData(claimNumber, srchData.get("CLM_NBR").toString(), "Enter claim no as : "+srchData.get("CLM_NBR").toString(), "Claim Number");
		    	clickFromDateIcon(criteriaType).setDate(Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy"), criteriaType).clickToDateIcon(criteriaType).setDate(Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy"), criteriaType);
		    	
		    	
		    	break;		    	
		    }
		    
		    case "byDOPAndPatientNm":
		    {
		    	 sqlRow = 46;
		    	 System.getProperty("tin");
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	testConfig.putRunTimeProperty("key", "PATIENT_FIRST_NAME");
		    	testConfig.putRunTimeProperty("value", srchData.get("PTNT_FST_NM").toString());
		    	testConfig.putRunTimeProperty("key1", "PATIENT_LAST_NAME");
		    	testConfig.putRunTimeProperty("value1", srchData.get("PTNT_LST_NM").toString());
		    	testConfig.putRunTimeProperty("fromDate",srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("SETL_DT").toString());
		    	
				date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");					
		    	Element.enterData(patientFirstName, srchData.get("PTNT_FST_NM").toString(), "Enter First Name as : "+srchData.get("PTNT_FST_NM").toString(), "First Name");
		    	Element.enterData(patientLastName, srchData.get("PTNT_LST_NM").toString(), "Enter Last Name as: "+srchData.get("PTNT_LST_NM").toString(), "Last Name");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	
		    	break;		    	
		    }
		    
		    case "byDOPAndZeroPaymentClaims":
		    {   
		    	
		    	testConfig.putRunTimeProperty("key", "ZERO_PAYMENT_CLAIMS");
		    	testConfig.putRunTimeProperty("value", "Y");
		    	testConfig.putRunTimeProperty("fromDate",testConfig.getRunTimeProperty("setl_dt"));
		    	testConfig.putRunTimeProperty("toDate", testConfig.getRunTimeProperty("setl_dt"));
		    	
		    	date=Helper.changeDateFormat(testConfig.getRunTimeProperty("setl_dt"), "yyyy-mm-dd", "mm/dd/yyyy");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		        Element.click(zeroPaymentClaims, "Zero Payment Claims");
		    	
		    	
		    	break;		    	
		    }
		    
		    case "byDOSAndAcntNo":
		    {
		    	 sqlRow = 58;
		    	String dosFrom = null;
		    	String dosTo = null;
		    	String acntNo;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	acntNo=srchData.get("PTNT_ACCT_NBR").toString();
		    	
		    	dosFrom=Helper.changeDateFormat(srchData.get("CLM_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
		    	dosTo=Helper.changeDateFormat(srchData.get("CLM_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				
		    	Element.enterData(accountNo, acntNo, "Filling patient account no: "+acntNo, "Account Number");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	
		    	
		    	testConfig.putRunTimeProperty("fromDate", srchData.get("CLM_STRT_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("CLM_END_DT").toString());
		    	testConfig.putRunTimeProperty("key", "ACCOUNT_NUMBER");
		    	testConfig.putRunTimeProperty("value", acntNo);
		    	testConfig.putRunTimeProperty("appIdentifier", "EPS");
		    	testConfig.putRunTimeProperty("version", "1.0");
		    	break;
		    }
		    
		    case "byDOSAndSubscriberId":
		    {
		    	 sqlRow = 157;
		    	String dosFrom = null;
		    	String dosTo = null;
		    	String sbscrId;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	sbscrId=srchData.get("SBSCR_ID").toString();
		    	try {
					dosFrom=Helper.changeDateFormat(srchData.get("CLM_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
					dosTo=Helper.changeDateFormat(srchData.get("CLM_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
					
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
		    	Element.enterData(subscriberID, sbscrId, "Filling patient subscriber Id: "+sbscrId, "subscriber Id");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	
		    	
		    	
		    	
		    	testConfig.putRunTimeProperty("fromDate", srchData.get("CLM_STRT_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("CLM_END_DT").toString());
		    	testConfig.putRunTimeProperty("key", "SUBSCRIBER_IDENTIFIER");
		    	testConfig.putRunTimeProperty("value", sbscrId);
		    	testConfig.putRunTimeProperty("appIdentifier", "EPS");
		    	testConfig.putRunTimeProperty("version", "1.0");
		    	break;
		    }
		    
		    case "byDOSAndNpi":
		    {
		    	 sqlRow = 59;
		    	String dosFrom = null;
		    	String dosTo = null;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	dosFrom=Helper.changeDateFormat(srchData.get("CLM_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				dosTo=Helper.changeDateFormat(srchData.get("CLM_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				
		    	Element.enterData(NPI, srchData.get("PROV_NPI_NBR").toString(), "Enter NPI No as : "+srchData.get("PROV_NPI_NBR").toString(), "NPI");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	
		    	
		    	testConfig.putRunTimeProperty("fromDate", srchData.get("CLM_STRT_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("CLM_END_DT").toString());
		    	testConfig.putRunTimeProperty("key", "NATIONAL_PROVIDER_IDENTIFIER");
		    	testConfig.putRunTimeProperty("value", srchData.get("PROV_NPI_NBR").toString());
		    	testConfig.putRunTimeProperty("appIdentifier", "EPS");
		    	testConfig.putRunTimeProperty("version", "1.0");
		    	break;
		    }
		    
		    case "byDOSAndClaimNo":
		    {
		    	 sqlRow = 60;
		    	String dosFrom = null;
		    	String dosTo = null;
		    	String clmNo;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	clmNo=srchData.get("CLM_NBR").toString();
		    	
		    	dosFrom=Helper.changeDateFormat(srchData.get("CLM_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				dosTo=Helper.changeDateFormat(srchData.get("CLM_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				
		    	Element.enterData(claimNumber, clmNo, "Filling claim no: "+clmNo, "Claim Number");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	
		    	
		    	testConfig.putRunTimeProperty("fromDate", srchData.get("CLM_STRT_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("CLM_END_DT").toString());
		    	testConfig.putRunTimeProperty("key", "CLAIM_IDENTIFIER");
		    	testConfig.putRunTimeProperty("value", clmNo);
		    	testConfig.putRunTimeProperty("appIdentifier", "EPS");
		    	testConfig.putRunTimeProperty("version", "1.0");
		    	break;
		    }
		    
		    case "byDOSAndZeroPaymentClaims":
		    {
		    	 sqlRow = 60;
		    	String dosFrom = null;
		    	String dosTo = null;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	
		    	dosFrom=Helper.changeDateFormat(srchData.get("CLM_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				dosTo=Helper.changeDateFormat(srchData.get("CLM_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	Element.click(zeroPaymentClaims, "Zero Payment Claims");
		    	
		    	
		    	testConfig.putRunTimeProperty("fromDate",srchData.get("CLM_STRT_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("CLM_END_DT").toString());
		    	testConfig.putRunTimeProperty("key", "ZERO_PAYMENT_CLAIMS");
		    	testConfig.putRunTimeProperty("value", "Y");
		    	testConfig.putRunTimeProperty("appIdentifier", "EPS");
		    	testConfig.putRunTimeProperty("version", "1.0");
		    	break;		    	
		    }
		    
		    case "DD":
		    	srchData=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
		    	Element.enterData(paymentNumber,srchData.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
		    	
		    	break;
		    	
		    case "byElectronicPaymenForACH":
		    case "byElectronicPaymenForCHK":
		    	srchData=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
		    	Element.enterData(paymentNumber, srchData.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
		    	
		    	break;
		    	
		    case "byElectronicPaymenForNON":
		    case "byElectronicPaymentForVCP":
		    	srchData=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
		    	Element.enterData(paymentNumber, srchData.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
		    	
		    	testConfig.putRunTimeProperty("typeDescription",srchData.get("TYP_DESC").toString());
		    	testConfig.putRunTimeProperty("paymentMethCode",srchData.get("PAY_METH_CD").toString());
		    	testConfig.putRunTimeProperty("paymentStatusTypeID",srchData.get("PAY_STS_TYP_ID").toString());
		    	break;
		    
		    case "byCheckNoOfConslPayDtl":
		    	dataRequiredForSearch=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Check Number", "Check Number from 'Payment Number' dropdown");
		    	Element.clickByJS(testConfig,checkNumber, "Check No text box");
		    	Element.enterData(checkNumber, dataRequiredForSearch.get("CHK_NBR").toString(), "Enter Check No as: " + dataRequiredForSearch.get("CHK_NBR").toString(), "payment number");
		    	testConfig.putRunTimeProperty("key1", "CHK_NBR");
		    	testConfig.putRunTimeProperty("value1", dataRequiredForSearch.get("CHK_NBR").toString());
		    	testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterYears(-2,"yyyy-MM-dd"));
		    	testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		    	break;
		    	
		    case "byCheckNoOfReoriginNacha":
		    	dataRequiredForSearch=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Check Number", "Check Number from 'Payment Number' dropdown");
		    	Element.clickByJS(testConfig,checkNumber, "Check No text box");
		    	Element.enterData(checkNumber, dataRequiredForSearch.get("CHECK_NBR").toString(), "Enter Check No as: " + dataRequiredForSearch.get("CHECK_NBR").toString(), "payment number");
		    	testConfig.putRunTimeProperty("key1", "CHECK_NBR");
		    	testConfig.putRunTimeProperty("value1", dataRequiredForSearch.get("CHECK_NBR").toString());
		    	testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterYears(-2,"yyyy-MM-dd"));
		    	testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		    	break;
		    	
		    case "byDOPAndRenderingProvider":
		    	 sqlRow = 70;
		    	 srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	String renderingProv=srchData.get("LST_NM").toString(); 
		    	renderingProv=renderingProv.replace(" null", "");
		    	
		    	testConfig.putRunTimeProperty("fromDate",srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("SETL_DT").toString());
		    	testConfig.putRunTimeProperty("key", "RENDERING_PROVIDER");
		    	testConfig.putRunTimeProperty("value", renderingProv);
		    	
		    	
				date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
		    	Element.enterData(renderingProvName, renderingProv, "Filling Rendering Provider Name: "+renderingProv, "Rendering Prov");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	
	 			break;
		    default:
		    	Log.Comment("Criteria Type " + criteriaType + " not found");		
		 }
		
		return clickSearchBtn();
	}
	
	public SearchRemittance searchByElectronicPaymentToVerifyPaymentStatusforACH(String criteriaType)
	{
		dataRequiredForSearch=dataProvider(criteriaType);
    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
    	Element.enterData(paymentNumber, dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString(), "Enter Electronic payment number as: " + dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString(), "payment number");
    	Element.selectByVisibleText(drpDwnPayer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		return clickSearchBtn();
	}
	
	public SearchRemittance searchByElectronicPaymentToVerifyPaymentStatusforVCP(String criteriaType)
	{
    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
    	Element.enterData(paymentNumber, dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
    	Element.selectByVisibleText(drpDwnPayer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
    	testConfig.putRunTimeProperty("typeDescription",dataRequiredForSearch.get("TYP_DESC").toString());
    	testConfig.putRunTimeProperty("paymentMethCode",dataRequiredForSearch.get("PAY_METH_CD").toString());
    	testConfig.putRunTimeProperty("paymentStatusTypeID",dataRequiredForSearch.get("PAY_STS_TYP_ID").toString());
		return clickSearchBtn();
	}
	
	public SearchRemittance searchByElectronicPaymentToVerifyPaymentStatusforDD(String criteriaType)
	{
		//data=dataProvider(criteriaType);
    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
    	Element.enterData(paymentNumber,"1QG78728391" /*data.get("DSPL_CONSL_PAY_NBR").toString()*/, "Filling Electronic payment number", "payment number");
    	Element.selectByVisibleText(drpDwnPayer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		return clickSearchBtn();
	}
	

	public SearchRemittance searchByElectronicPaymentToVerifyReturnedReason(String criteriaType)
	{
		dataRequiredForSearch=dataProvider(criteriaType);
    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
    	Element.enterData(paymentNumber, dataRequiredForSearch.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
    	Element.selectByVisibleText(drpDwnPayer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
    	testConfig.putRunTimeProperty("returnedReason",dataRequiredForSearch.get("RET_REASON_CD").toString());
		return clickSearchBtn();
	}
	
	public SearchRemittanceSearchCriteria getPaymentStatusFromDB(String criteriaType)
	{
		dataRequiredForSearch=dataProvider(criteriaType);
		testConfig.putRunTimeProperty("typeDescription",dataRequiredForSearch.get("TYP_DESC").toString());
		testConfig.putRunTimeProperty("paymentMethCode",dataRequiredForSearch.get("PAY_METH_CD").toString());
    	testConfig.putRunTimeProperty("paymentStatusTypeID",dataRequiredForSearch.get("PAY_STS_TYP_ID").toString());
		return this;
	}
	
	public SearchRemittance searchByCheckNumberToVerifyReturnedReason(String criteriaType)
	{
		dataRequiredForSearch=dataProvider(criteriaType);
    	Element.selectByVisibleText(paymentNumberType, "Check Number", "Select payment number type");
    	Element.clickByJS(testConfig,checkNumber, "Selecting Filter Criteria");
    	Element.enterData(checkNumber, dataRequiredForSearch.get("UCONSL_PAY_NBR").toString(), "Filling Check payment number", "payment number");  	
    	Element.selectByVisibleText(drpDwnPayer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		return clickSearchBtn();
	}
	
	public SearchRemittance clickSearchBtn() {
		Element.clickByJS(testConfig,btnSearchRemittance, "Search Remittance Button");
		return new SearchRemittance(testConfig);
	}
	
	public Map<String, String> dataProvider(String criteriaType) {
		int sqlRowNo=0;
		
		switch(criteriaType)
		{
			case "byElectronicPaymentNo":
				sqlRowNo=49;
				break;
			case "byCheckNo":
				sqlRowNo=51;
				break;
			case "byElectronicPaymenForNON":
			case "byElectronicPaymentForVCP":
				sqlRowNo=53;
				break;		
			case "DD":
				sqlRowNo=55;
				break;
			case "byElectronicPaymenForACH":
			case "byElectronicPaymenForCHK":
				sqlRowNo=57;
				break;
			case "byCheckNoOfReoriginNacha":
				sqlRowNo=63;
				break;
			case "byCheckNoOfConslPayDtl":
				sqlRowNo=64;
				break;
			case "byDOPAndRenderingProvider":
				sqlRowNo=70;
				break;
			case "byElectronicPayNum":
				sqlRowNo=1610;
				break;	
		}
		
		Map data=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);		
		return data;
	}
	
	public SearchRemittanceSearchCriteria setDate(String date, String criteriaType)
	{
		
		
		if(BrowserType.CHROME.contains("chrome"))
		{
			
		
		for(int i =0;i<3;i++){
			
			if(!(Browser.getNoOfWindowHandles(testConfig)<2))
				break;
			else
				clickFromDateIcon(criteriaType);			   
		}
		
		
		String oldWindow=Browser.switchToNewWindow(testConfig, "/calendar.html");
		selectDate(testConfig,date);
		Browser.switchToParentWindow(testConfig,oldWindow);
		
		}
		else
		{
			selectDateForIE(testConfig,date);
		}
		
		
		return this;
	}
	
	
	public SearchRemittanceSearchCriteria clickFromDateIcon(String criteriaType)
	{
		if(criteriaType.contains("byDOS")){  
			Element.clickByJS(testConfig, dosFrom, "From date calendar");
			Browser.wait(testConfig, 2);	    	
	    }
		else {
			Element.expectedWait(dopFrom, testConfig, "Clicked calendar", "Calendar");
	    	Element.clickByJS(testConfig, dopFrom, "From date calendar");
			Browser.wait(testConfig, 2);	 
		}
		return this;
	}
	
	public SearchRemittanceSearchCriteria clickToDateIcon(String criteriaType)
	{
		if(criteriaType.contains("byDOS")){  
	    	Element.expectedWait(dosTo, testConfig, "Calendar Present", "calendar");
	    	Element.clickByJS(testConfig,dosTo, "To date calendar for Date of service");
			Browser.wait(testConfig, 2);	    	
	     }
		else{
			Element.expectedWait(dopTo, testConfig, "Calendar Present", "calendar");
	    	Element.clickByJS(testConfig,dopTo, "To date calendar");
			Browser.wait(testConfig, 2);	 
		}
		return this;
	}
	
	public SearchRemittanceSearchCriteria selectDate(TestBase testConfig, String requiredDate)
	{
	    String curr[] = Helper.getCurrentDate("MM/dd/yyyy").split("/");
	    String req[] = requiredDate.split("/");

//	    int currDate = Integer.parseInt(curr[0]);
	    int reqDate = Integer.parseInt(req[1]);
	    int currMonth = Integer.parseInt(curr[0]);
	    int reqMonth = Integer.parseInt(req[0]);
	    int currYr = Integer.parseInt(curr[2]);
	    int reqYr = Integer.parseInt(req[2]);
	    String date=String.valueOf(reqDate);
	    String monthAndYearInCal[]={};

	    
	    // Select required year
	    if (currYr > reqYr){
	        for (int i=0;i<(currYr-reqYr);i++){
	            //decrease year
	        	Element.clickByJS(testConfig,btnPreviousYear, "Previous Year button to go back one year..year is now : " + String.valueOf(currYr-(i+1)));
	        	Browser.wait(testConfig,3);
	        	monthAndYearInCal=monthYearInCal.getText().split(" ");
	        	Helper.compareEquals(testConfig, "Selected Year", monthAndYearInCal[1], String.valueOf(currYr-(i+1)));
	        }   
	    } else if (currYr < reqYr){
	        for (int j=0;j<(reqYr-currYr);j++){
	            //increase year
	        	Element.clickByJS(testConfig,btnNxtYear, "Next Year button to go ahead one year..year is now : " + String.valueOf(currYr+(j+1)));
	        	Browser.wait(testConfig,3);
	        	monthAndYearInCal=monthYearInCal.getText().split(" ");
	        	Helper.compareEquals(testConfig, "Selected Year", monthAndYearInCal[1], String.valueOf(currYr+(j+1)));
	        }
	    }

	    
	    if (currMonth > reqMonth){
	        for (int i=0;i<(currMonth-reqMonth);i++){
	            //decrease month
	        	Element.clickByJS(testConfig,btnPreviousMonth, "Previous month button to go back one month..month is now : " + String.valueOf(currMonth-(i+1)));
	        	Browser.wait(testConfig,3);
	        	
	        }
	    } else if (currMonth < reqMonth){
	        for (int j=0;j<(reqMonth-currMonth);j++){
	            // increase month
	        	Element.clickByJS(testConfig,btnNextMonth, "Next month to go ahead one month..month is now : " + String.valueOf(currMonth+(j+1)));
	        	Browser.wait(testConfig, 2);
	        }
	    }
	    monthAndYearInCal=monthYearInCal.getText().split(" ");
	    Log.Comment("Date to be selected is : " +  testConfig.driver.findElement(By.xpath("//a//font[contains(text()," + "'" + date + "'"+ ")"+ " " + "and @color='#000000']")).getText() + monthAndYearInCal[0] + monthAndYearInCal[1] );
	    WebElement dateToBeClicked=Element.findElement(testConfig, "xpath", "//a//font[contains(text()," + "'" + date + "'"+ ")"+ " " + "and @color='#000000']");
	    Element.clickByJS(testConfig, dateToBeClicked, "date to be clicked");
	    return this;
	}
	
	
	public SearchRemittanceSearchCriteria selectDateForIE(TestBase testConfig, String requiredDate)
	{
	    String curr[] = Helper.getCurrentDate("MM/dd/yyyy").split("/");
	    String req[] = requiredDate.split("/");

//	    int currDate = Integer.parseInt(curr[0]);
	    int reqDate = Integer.parseInt(req[1]);
	    int currMonth = Integer.parseInt(curr[0]);
	    int reqMonth = Integer.parseInt(req[0]);
	    int currYr = Integer.parseInt(curr[2]);
	    int reqYr = Integer.parseInt(req[2]);
	    String date=String.valueOf(reqDate);
	    String monthAndYearInCal[]={};

	    
	    monthAndYearInCal=monthYearInCal.getText().split(" ");
	    Log.Comment("Date to be selected is : " +  testConfig.driver.findElement(By.xpath("//a//font[contains(text()," + "'" + date + "'"+ ")"+ " " + "and @color='#000000']")).getText() + monthAndYearInCal[0] + monthAndYearInCal[1] );
	    String dateToBeClicked=Element.findElement(testConfig, "xpath", "//a//font[contains(text()," + "'" + date + "'"+ ")"+ " " + "and @color='#000000']").getText();
	    System.out.println(dateToBeClicked);
	    Element.enterData(startDOPDate, dateToBeClicked, "Start Date", "Start Date");
	    //Element.clickByJS(testConfig, dateToBeClicked, "date to be clicked");
	    return this;
	}
	
	
	//amit
	
    public SearchRemittanceSearchCriteria selectPayer(String payerName)
	 {
		 Element.selectByVisibleText(drpDwnPayer, payerName, "Payer selected on search remittance search criteria page is : " + payerName);
		 Element.clickByJS(testConfig,btnSearchRemittance, "Search Remittance Button");
	    return this;
	 }
		
    public void verifyErrorMsgs()
    {
           
           //by date of Payment for date range more than 30 days
           String expectedMsg="Date(s) of Payment date range must be 30 days or less";
         clickFromDateIcon("byDOP").setDate(Helper.getDateBeforeOrAfterDays(-40,"MM/dd/yyyy"), "byDOP").clickToDateIcon("byDOP").setDate(Helper.getCurrentDate("MM/dd/yyyy"), "byDOP");
     selectPayer("UnitedHealthcare");
     Helper.compareEquals(testConfig, "Error Message",expectedMsg,POSErrorMsg.getText());
           
     //now by date of service for date range more than 30 days
     expectedMsg="Date(s) of Service date range must be 30 days or less";
         clickFromDateIcon("byDOS").setDate(Helper.getDateBeforeOrAfterDays(-40,"MM/dd/yyyy"), "byDOS").clickToDateIcon("byDOS").setDate(Helper.getCurrentDate("MM/dd/yyyy"), "byDOS");
     selectPayer("UnitedHealthcare");
     Element.expectedWait(DOSErrorMsg, testConfig, "Date of Service Error message" , "Date of Service Error message");
     Helper.compareEquals(testConfig, "Error Message",expectedMsg,DOSErrorMsg.getText());
     
     //by date of Payment before 14 month
     expectedMsg="Start Date should not be earlier than the rolling 36 months.";
           clickFromDateIcon("byDOP").setDate(Helper.getDateBeforeOrAfterDays(-1100,"MM/dd/yyyy"), "byDOP").clickToDateIcon("byDOP").setDate(Helper.getDateBeforeOrAfterDays(-490,"MM/dd/yyyy"), "byDOP");
     selectPayer("UnitedHealthcare");
     Helper.compareEquals(testConfig, "Error Message",expectedMsg,strtDateErrorMsg.getText());
     
     expectedMsg="End Date should not be earlier than the rolling 36 months.";
     Helper.compareEquals(testConfig, "Error Message",expectedMsg,endDateErrorMsg.getText());

     //now by date of service before 14 month      
         clickFromDateIcon("byDOS").setDate(Helper.getDateBeforeOrAfterDays(-430,"MM/dd/yyyy"), "byDOS").clickToDateIcon("byDOS").setDate(Helper.getDateBeforeOrAfterDays(-430,"MM/dd/yyyy"), "byDOS");
         Element.selectByVisibleText(drpDwnPayer,"UnitedHealthcare", "Payer selected on search remittance search criteria page");
         clickSearchBtn();
    }
    
    //Review to be done by- Priyanka (for amit)
    public SearchRemittanceSearchCriteria selectTin(String paymentType,String userType)
    {
           Element.enterData(txtboxTinNo, getTin(paymentType,userType), "Enter Tin to proceed", "Tin Textbox");
           Element.click(btnSearch, "Search button Clicked");
           return this;
    }
    
    public String getTin(String paymentType,String userType)
    {
           int sqlRowNo=62;
           int insertQueryRowNo=61;
           dataProvider=new ViewPaymentsDataProvider(testConfig);
           if(userType=="SUBPAYER"||userType.equals("PAY"))
        	   return "";//dataProvider.getTinForPaymentType(paymentType);
           else
           return "";//dataProvider.associateTinWithUser(userType,dataProvider.getTinForPaymentType(paymentType));
    }
    
    public void verifyLargeNonLargeTin() throws IOException
    {
    	Map srchRslt=DataBase.executeSelectQuery(testConfig, 65, 1);
    	int threshHoldValue=Integer.parseInt(srchRslt.get("PROC_DATA").toString());
    	
    	srchRslt=DataBase.executeSelectQuery(testConfig, 66, 1);
    	int days=Integer.parseInt(srchRslt.get("PROC_DATA").toString());
    	String expected,actual;
    		
    	actual = Element.getFirstSelectedOption(testConfig, drpDwnPayer, "text");
    	
    	HashMap<Integer, HashMap<String, String>> srchData = DataBase.executeSelectQueryALL(testConfig, 67);
		
    	List<String> l =new ArrayList<String>();
    	
    	for (int i = 1; i <= srchData.size(); i++) 
			l.add(srchData.get(i).get("PROV_KEY_ID"));
		
    	
    	String listString = "";
    	
    	for (String s : l)
    	    listString += "\'"+s+"\'" + " ,";
 
    	listString=listString.substring(0, listString.length()-1);
    	testConfig.putRunTimeProperty("list", listString);
    	
    	srchRslt=DataBase.executeSelectQuery(testConfig, 68, 1);
    	
    	int noOfPayments=Integer.parseInt(srchRslt.get("REC_COUNT").toString());
    	
    	if(noOfPayments<threshHoldValue)
    	{
    		//for non large tin --> Show all
    		expected ="Show All";
    		Helper.compareEquals(testConfig, "Default Option in Payer drop down", expected, actual);
    		
    	}
    	else
    	{
    		//for large tin --> Select a payer
    		expected ="Select a Payer";
    		Helper.compareEquals(testConfig, "Default Option in Payer drop down", expected, actual);
    		
    	}
    }
    
    
    
    public void verifyTopMsgProv_Premium(String msgTop)
    {
    	switch (msgTop)
    	{
    	case "PremiumPrvAdm":
    	{
    		Helper.compareEquals(testConfig, "Validate Provider Admin Top Msg Premium TIN", msgTop_Prov, premiumMsgTop_Provider.getText().trim());
    		break;
    	}
    	case "PremiumPrvGen":
    	{
    		Helper.compareEquals(testConfig, "Validate Provider Admin Top Msg Standard TIN", msgTop_Prov, premiumMsgTop_Provider.getText().trim());
    		break;
    	}
    	}
    }
    	
    	
    
    public void verifyMsgProv_Standard(String msgTopStd)
    {
    	switch (msgTopStd)
    	{
    	case "StandardPrvAdm":
    	{
    		Helper.compareEquals(testConfig, "Validate Provider Admin Top Msg Header Standard TIN", standardMsgTop_Header_Prov, standardMsgTop_Header.getText().trim());
    		Helper.compareEquals(testConfig, "Validate Provider Admin Top Msg Content Standard TIN", standardMsgTop_Content_Prov_Adm, standardMsgTop_Content.getText().trim());
    		break;
    	}
    	case "StandardPrvGen":
    	{
    		Helper.compareEquals(testConfig, "Validate Provider Admin Top Msg Standard TIN", msgTop_Prov, premiumMsgTop_Provider.getText().trim());
    		break;
    	}
    	}
    }
    
    public SearchRemittanceSearchCriteria verifySearchBtnEnabledOrDisabled(String portalAccess){
    	if("Standard".equalsIgnoreCase(portalAccess))
    		Helper.compareEquals(testConfig, "Button Disabled", "true", btnSearchRemittance.getAttribute("disabled"));
    	else if("Premium".equalsIgnoreCase(portalAccess))
    		Helper.compareEquals(testConfig, "Button Enabled", null, btnSearchRemittance.getAttribute("disabled"));
    	return this;
    }

	/**
	 * Author : Vinay Raghumanda
	 * Validates page text on Search Remittance screen for different types of users and roles.
	 * @param accessType
	 * @param portalAccess
	 */
	public void validatePageText(String accessType, String portalAccess) {

		String expectedParagraph, expectedHeader, actualButtonText, expectedButtonText;
		WebElement button = null;

		switch (accessType + "_" + portalAccess + "_" + testConfig.getRunTimeProperty("tinType")) {
			case "PROV_Admin_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.premium.ao.searchRemittance.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "PROV_Admin_Standard_AO":
				expectedHeader = TestBase.contentMessages.getProperty("prov.admin.standard.ao.searchRemittance.header");
				expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.standard.ao.searchRemittance.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				button = Element.findElement(testConfig, "xpath", "//*[@type=\"button\"]/span[text()='Get Started']");
				actualButtonText = button.getText().trim();
				expectedButtonText = TestBase.contentMessages.getProperty("prov.admin.standard.ao.searchRemittance.buttonText");
				Helper.compareEquals(testConfig, "Page Text", expectedButtonText, actualButtonText);
				break;
			case "PROV_Gen_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("prov.general.premium.ao.searchRemittance.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "PROV_Gen_Standard_AO":
				expectedHeader = TestBase.contentMessages.getProperty("prov.general.standard.ao.searchRemittance.header");
				expectedParagraph = TestBase.contentMessages.getProperty("prov.general.standard.ao.searchRemittance.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				break;
			case "BS_Admin_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.premium.ao.searchRemittance.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "BS_Admin_Standard_AO":
				expectedHeader = TestBase.contentMessages.getProperty("bs.admin.standard.ao.searchRemittance.header");
				expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.standard.ao.searchRemittance.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				break;
			case "BS_Gen_Premium_AO":
				expectedParagraph = TestBase.contentMessages.getProperty("bs.general.premium.ao.searchRemittance.paragraph");
				validatePremiumUsers(expectedParagraph);
				break;
			case "BS_Gen_Standard_AO":
				expectedHeader = TestBase.contentMessages.getProperty("bs.general.standard.ao.searchRemittance.header");
				expectedParagraph = TestBase.contentMessages.getProperty("bs.general.standard.ao.searchRemittance.paragraph");
				validateStandardUsers(expectedParagraph, expectedHeader);
				break;
			default:
				break;
		}
	}

	private void validateStandardUsers(String expectedParagraph, String expectedHeader) {
		WebElement headerTag;
		WebElement paragraphTag;
		String actualHeader;
		String actualParagraph;
		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//*[@id=\"seachRemittancePremium\"]/h2"), 30);
		headerTag = Element.findElement(testConfig, "xpath", "//*[@id=\"seachRemittancePremium\"]/h2");
		paragraphTag=Element.findElement(testConfig, "xpath", "//*[@id=\"seachRemittancePremium\"]/p[2]");
		actualHeader = headerTag.getText().trim();
		actualParagraph = paragraphTag.getText().trim();
		Helper.compareEquals(testConfig, "PageText", expectedHeader, actualHeader);
		Helper.compareEquals(testConfig, "PageText", expectedParagraph, actualParagraph);
	}

	private void validatePremiumUsers(String expectedParagraph) {
		WebElement paragraphTag;
		String actualParagraph;
		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//*[@class=\"topMessaggeDiv\"]"), 30);
		paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]");
		actualParagraph = paragraphTag.getText().trim();
		Helper.compareEquals(testConfig, "Page Text", expectedParagraph, actualParagraph);
	}
}

