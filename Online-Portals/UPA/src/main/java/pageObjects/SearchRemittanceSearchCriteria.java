package main.java.pageObjects;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.api.pojo.epspaymentsearch.response.EpsPaymentsSummarySearchResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;


public class SearchRemittanceSearchCriteria {
	
	private TestBase testConfig;
	private ViewPaymentsDataProvider dataProvider;
	@FindBy(id="checkNumberInputId")
	WebElement checkNumber;
	
	@FindBy(id="paymentNumberInputId")
	WebElement paymentNumber;
	
	@FindBy(id="paymentNbrTypeSelection")
	WebElement paymentNumberType;
	
	@FindBy(id="patientLastNameId")
	WebElement patientLastName;
	
	@FindBy(id="patientFirstNameId")
	WebElement patientFirstName;
	
	@FindBy(id="providerLastNameID")
	WebElement providerLastName;
	
	@FindBy(name="searchRemittance")
	WebElement btnSearchRemittance;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[3]/td[5]/a[2]/img")
	WebElement dosTo;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[3]/td[5]/a[1]/img")
	WebElement dosFrom;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[4]/td[5]/a[2]/img")
	WebElement dopTo;
	
	@FindBy(xpath = ".//*[@id='newSearchParamTable']/tbody/tr[4]/td[5]/a[1]/img")
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
	WebElement payer;
	
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
	
	@FindBy(xpath=".//*[@class='Subheaderbold']//input[2]")
	WebElement btnSearch;
	Map data;
	
	public SearchRemittanceSearchCriteria(TestBase testConfig)
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		WebElement check=Element.findElement(testConfig, "name", "taxIdNbr");
		if(check==null)
			Element.expectedWait(btnSearchRemittance, testConfig, "Search Remittance button", "Search Remittance button");
	}
	
	public SearchRemittance doSearch(String criteriaType) throws ParseException {
		
		String date="";
		Map srchData=null;
		
		switch(criteriaType)
		 {
		    case "byElectronicPaymentNo":
		    {
		    	data=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");
		    	Element.enterData(paymentNumber, data.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
		    	testConfig.putRunTimeProperty("key1", "ELECTRONIC_PAYMENT_NUMBER");
		    	testConfig.putRunTimeProperty("value1", data.get("DSPL_CONSL_PAY_NBR").toString());
		    	testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterYears(-2,"yyyy-MM-dd"));
		    	testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		    	break;
		    }
		    
		    case "byCheckNo":
		    {
		    	data=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Check Number", "Select payment number type");
		    	Element.click(checkNumber, "Selecting Filter Criteria");
		    	Element.enterData(checkNumber, data.get("UCONSL_PAY_NBR").toString(), "Filling Check payment number", "payment number");	
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
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
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "United Healthcare from Payer dropdown");
		    	break;		    	
		    }
		    
		    case "byDOP":
		    {
		    	int sqlRow = 42;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
		    	clickFromDateIcon(criteriaType).setDate("11/02/2018", criteriaType).clickToDateIcon(criteriaType).setDate("11/30/2018", criteriaType);
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");		    	
		    	date=Helper.changeDateFormat(date, "mm/dd/yyyy", "yyyy-mm-dd");
		    	testConfig.putRunTimeProperty("fromDate",date);
		    	testConfig.putRunTimeProperty("toDate",date);
		    	testConfig.putRunTimeProperty("key", "MARKET_TYPE");
		    	testConfig.putRunTimeProperty("value", "ALL");		    	
		    	
		    	break;	
		    }
		    
		    case "byDOPAndAcntNo":
		    {
		    	int sqlRow = 42;
		    	String acntNo;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	acntNo=srchData.get("PTNT_ACCT_NBR").toString();
		    	try {
					date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	Element.enterData(accountNo, acntNo, "Filling patient account no: "+acntNo, "Account Number");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	
		    	break;
		    }
		    
		    
		    case "byDOPAndSubscriberId":
		    {
		    	int sqlRow = 43;
		    	String sbscrId;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	sbscrId=srchData.get("SBSCR_ID").toString();
				date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				
		    	Element.enterData(subscriberID, sbscrId, "Filling patient subscriber Id: "+sbscrId, "subscriber Id");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	testConfig.putRunTimeProperty("key", "SUBSCRIBER_IDENTIFIER");
		    	testConfig.putRunTimeProperty("value", sbscrId);
		    	date=Helper.changeDateFormat(date,"mm/dd/yyyy" , "yyyy-mm-dd");
		    	testConfig.putRunTimeProperty("fromDate",date );
		    	testConfig.putRunTimeProperty("toDate", date);
		    	break;
		    }
		    
		    case "byDOPAndNpi":
		    {
		    	int sqlRow = 44;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	String toDate=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
		    	Element.click(NPI, "NPI");
		    	Element.enterData(NPI, srchData.get("PROV_NPI_NBR").toString(), "Filling NPI No: "+ srchData.get("PROV_NPI_NBR").toString(), "NPI");
		    	clickFromDateIcon(criteriaType).setDate(Helper.getDateBeforeOrAfterDays(-15, "mm/dd/yyyy", "mm/dd/yyyy", toDate), criteriaType).clickToDateIcon(criteriaType).setDate(toDate, criteriaType);
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	break;
		    }
		    
		    case "byDOPAndClmNo":
		    {
		    	int sqlRow = 45;
		    	String clmNo;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	clmNo=srchData.get("CLM_NBR").toString();
		    	try {
					date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				} catch (ParseException e) {
					e.printStackTrace();
				}
		    	Element.enterData(claimNumber, clmNo, "Filling claim no: "+clmNo, "Claim Number");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	
		    	break;		    	
		    }
		    
		    case "byDOP&PatientName":
		    {
		    	int sqlRow = 46;
		    	String fstNm, lstNm;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	
		    	fstNm=srchData.get("PTNT_FST_NM").toString();
		    	lstNm=srchData.get("PTNT_LST_NM").toString();
				date=Helper.changeDateFormat(srchData.get("SETL_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");					
				
				
		    	Element.enterData(patientFirstName, fstNm, "Filling First Name: "+fstNm, "First Name");
		    	Element.enterData(patientLastName, lstNm, "Filling Last Name: "+lstNm, "Last Name");
		    	clickFromDateIcon(criteriaType).setDate(date, criteriaType).clickToDateIcon(criteriaType).setDate(date, criteriaType);
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	
		    	testConfig.putRunTimeProperty("key", "PATIENT_FIRST_NAME");
		    	testConfig.putRunTimeProperty("value", fstNm);
		    	testConfig.putRunTimeProperty("key1", "PATIENT_LAST_NAME");
		    	testConfig.putRunTimeProperty("value1", lstNm);
		    	date=Helper.changeDateFormat(date,"mm/dd/yyyy" , "yyyy-mm-dd");
		    	testConfig.putRunTimeProperty("fromDate",date );
		    	testConfig.putRunTimeProperty("toDate", date);
		    	testConfig.putRunTimeProperty("appIdentifier", "EPS");
		    	testConfig.putRunTimeProperty("version", "1.0");
		    	break;		    	
		    }
		    
		    case "byDOPAndZeroPmntClms":
		    {
		    	String toDateDos = Helper.getCurrentDate("MM/dd/yyyy");
		    	String fromDateDos = Helper.getDateBeforeOrAfterDays(-30,"MM/dd/yyyy");
		    	clickFromDateIcon(criteriaType).setDate(fromDateDos, criteriaType).clickToDateIcon(criteriaType).setDate(toDateDos, criteriaType);
		    	Element.click(zeroPaymentClaims, "Zero Payment Claims");
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	
		    	break;		    	
		    }
		    
		    case "byDOSAndAccountNo":
		    {
		    	int sqlRow = 58;
		    	String dosFrom = null;
		    	String dosTo = null;
		    	String acntNo;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	acntNo=srchData.get("PTNT_ACCT_NBR").toString();
		    	
		    	dosFrom=Helper.changeDateFormat(srchData.get("CLM_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
		    	dosTo=Helper.changeDateFormat(srchData.get("CLM_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				
		    	Element.enterData(accountNo, acntNo, "Filling patient account no: "+acntNo, "Account Number");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	
		    	testConfig.putRunTimeProperty("fromDate", srchData.get("CLM_STRT_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("CLM_STRT_DT").toString());
		    	testConfig.putRunTimeProperty("key", "ACCOUNT_NUMBER");
		    	testConfig.putRunTimeProperty("value", acntNo);
		    	testConfig.putRunTimeProperty("appIdentifier", "EPS");
		    	testConfig.putRunTimeProperty("version", "1.0");
		    	break;
		    }
		    
		    case "DOSAndSubscriberId":
		    {
		    	int sqlRow = 50;
		    	String dosFrom = null;
		    	String dosTo = null;
		    	String sbscrId;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	sbscrId=srchData.get("SBSCR_ID").toString();
		    	try {
		    		System.out.println(srchData.get("CLM_STRT_DT").toString()+":"+srchData.get("CLM_END_DT").toString());
					dosFrom=Helper.changeDateFormat(srchData.get("CLM_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
					dosTo=Helper.changeDateFormat(srchData.get("CLM_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
					System.out.println(dosFrom+":"+dosTo);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("Exception occured");
					e.printStackTrace();
				}
		    	Element.enterData(subscriberID, sbscrId, "Filling patient subscriber Id: "+sbscrId, "subscriber Id");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	clickSearchBtn();
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
		    	int sqlRow = 59;
		    	String dosFrom = null;
		    	String dosTo = null;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	dosFrom=Helper.changeDateFormat(srchData.get("CLM_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				dosTo=Helper.changeDateFormat(srchData.get("CLM_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				
		    	Element.enterData(NPI, srchData.get("PROV_NPI_NBR").toString(), "Filling NPI No as : "+srchData.get("PROV_NPI_NBR").toString(), "NPI");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	
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
		    	int sqlRow = 60;
		    	String dosFrom = null;
		    	String dosTo = null;
		    	String clmNo;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	clmNo=srchData.get("CLM_NBR").toString();
		    	
		    	dosFrom=Helper.changeDateFormat(srchData.get("CLM_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				dosTo=Helper.changeDateFormat(srchData.get("CLM_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				
		    	Element.enterData(claimNumber, clmNo, "Filling claim no: "+clmNo, "Claim Number");
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	
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
		    	int sqlRow = 60;
		    	String dosFrom = null;
		    	String dosTo = null;
		    	srchData = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		    	
		    	dosFrom=Helper.changeDateFormat(srchData.get("CLM_STRT_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				dosTo=Helper.changeDateFormat(srchData.get("CLM_END_DT").toString(), "yyyy-mm-dd", "mm/dd/yyyy");
				
		    	clickFromDateIcon(criteriaType).setDate(dosFrom, criteriaType).clickToDateIcon(criteriaType).setDate(dosTo, criteriaType);
		    	Element.click(zeroPaymentClaims, "Zero Payment Claims");
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	
		    	testConfig.putRunTimeProperty("fromDate",srchData.get("CLM_STRT_DT").toString());
		    	testConfig.putRunTimeProperty("toDate", srchData.get("CLM_END_DT").toString());
		    	testConfig.putRunTimeProperty("key", "ZERO_PAYMENT_CLAIMS");
		    	testConfig.putRunTimeProperty("value", "Y");
		    	testConfig.putRunTimeProperty("appIdentifier", "EPS");
		    	testConfig.putRunTimeProperty("version", "1.0");
		    	break;		    	
		    }
		    
		    case "DD":
		    	data=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
		    	Element.enterData(paymentNumber,data.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	break;
		    	
		    case "byElectronicPaymenForACH":
		    case "byElectronicPaymenForCHK":
		    	data=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
		    	Element.enterData(paymentNumber, data.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	break;
		    	
		    case "byElectronicPaymenForNON":
		    case "byElectronicPaymenForVCP":
		    	data=dataProvider(criteriaType);
		    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
		    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
		    	Element.enterData(paymentNumber, data.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
		    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
		    	testConfig.putRunTimeProperty("typeDescription",data.get("TYP_DESC").toString());
		    	testConfig.putRunTimeProperty("paymentMethCode",data.get("PAY_METH_CD").toString());
		    	testConfig.putRunTimeProperty("paymentStatusTypeID",data.get("PAY_STS_TYP_ID").toString());
		    	break;
		    	
		    default:
		    	Log.Comment("Criteria Type " + criteriaType + " not found");		
		 }
		
		return clickSearchBtn();
	}
		
	public SearchRemittance searchByElectronicPaymentToVerifyReturnedReason(String criteriaType)
	{
		data=dataProvider(criteriaType);
    	Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number", "Select payment number type");
    	Element.clickByJS(testConfig,paymentNumber, "Selecting Filter Criteria");	
    	Element.enterData(paymentNumber, data.get("DSPL_CONSL_PAY_NBR").toString(), "Filling Electronic payment number", "payment number");
    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
    	testConfig.putRunTimeProperty("returnedReason",data.get("RET_REASON_CD").toString());
		return clickSearchBtn();
	}
	
	public SearchRemittanceSearchCriteria getPaymentStatusFromDB(String criteriaType)
	{
		data=dataProvider(criteriaType);
		testConfig.putRunTimeProperty("typeDescription",data.get("TYP_DESC").toString());
		testConfig.putRunTimeProperty("paymentMethCode",data.get("PAY_METH_CD").toString());
    	testConfig.putRunTimeProperty("paymentStatusTypeID",data.get("PAY_STS_TYP_ID").toString());
		return this;
	}
	
	public SearchRemittance searchByCheckNumberToVerifyReturnedReason(String criteriaType)
	{
		data=dataProvider(criteriaType);
    	Element.selectByVisibleText(paymentNumberType, "Check Number", "Select payment number type");
    	Element.clickByJS(testConfig,checkNumber, "Selecting Filter Criteria");
    	Element.enterData(checkNumber, data.get("UCONSL_PAY_NBR").toString(), "Filling Check payment number", "payment number");  	
    	Element.selectByVisibleText(payer, "UnitedHealthcare", "Payer selection on search remittance search criteria page");
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
				sqlRowNo=38;
				break;
			case "byCheckNo":
				sqlRowNo=40;
				break;
			case "byElectronicPmt":
				sqlRowNo=49;
				break;
			case "byCheckPmt":
				sqlRowNo=51;
				break;
			case "byElectronicPaymenForNON":
			case "byElectronicPaymenForVCP":
				sqlRowNo=53;
				break;		
			case "DD":
				sqlRowNo=55;
				break;
			case "byElectronicPaymenForACH":
			case "byElectronicPaymenForCHK":
				sqlRowNo=57;
			break;
		}
		
		Map data=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);		
		return data;
	}
	
	public SearchRemittanceSearchCriteria setDate(String date, String criteriaType)
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
		return this;
	}
	
	
	public SearchRemittanceSearchCriteria clickFromDateIcon(String criteriaType)
	{
		if(criteriaType.equalsIgnoreCase("byDOS")){  
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
		if(criteriaType.equalsIgnoreCase("byDOS")){  
	    	Element.expectedWait(dopTo, testConfig, "Calendar Present", "calendar");
	    	Element.clickByJS(testConfig,dosTo, "To date calendar");
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
	
	//amit
	
    public SearchRemittanceSearchCriteria selectPayer(String payerName)
	 {
		 Element.selectByVisibleText(payer, payerName, "Payer selected on search remittance search criteria page is : " + payerName);
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
     expectedMsg="Start Date should not be earlier than the rolling 13 months.";
           clickFromDateIcon("byDOP").setDate(Helper.getDateBeforeOrAfterDays(-490,"MM/dd/yyyy"), "byDOP").clickToDateIcon("byDOP").setDate(Helper.getDateBeforeOrAfterDays(-490,"MM/dd/yyyy"), "byDOP");
     selectPayer("UnitedHealthcare");
     Helper.compareEquals(testConfig, "Error Message",expectedMsg,strtDateErrorMsg.getText());
     
     expectedMsg="End Date should not be earlier than the rolling 13 months.";
     Helper.compareEquals(testConfig, "Error Message",expectedMsg,endDateErrorMsg.getText());

     //now by date of service before 14 month      
         clickFromDateIcon("byDOS").setDate(Helper.getDateBeforeOrAfterDays(-430,"MM/dd/yyyy"), "byDOS").clickToDateIcon("byDOS").setDate(Helper.getDateBeforeOrAfterDays(-430,"MM/dd/yyyy"), "byDOS");
     Element.selectByVisibleText(payer,"UnitedHealthcare", "Payer selected on search remittance search criteria page");
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
           if(userType=="SUBPAYER")
        	   return dataProvider.getTinForPaymentType(paymentType);
           else
           return dataProvider.associateTinWithUser(dataProvider.getTinForPaymentType(paymentType),sqlRowNo,insertQueryRowNo);
    }

}
