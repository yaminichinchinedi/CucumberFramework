package main.java.pageObjects;



import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.api.manage.EpsPaymentsSearch.EpsPaymentSearchRequestHelper;
import main.java.api.pojo.epspaymentsearch.jsonrequest.*;
import main.java.api.pojo.epspaymentsearch.request.EpsPaymentsSearchRequest;
import main.java.api.pojo.epspaymentsearch.request.SearchByCriteriaRequest;
import main.java.api.pojo.epspaymentsearch.jsonresponse.EpsConsolidatedClaimPaymentSummaries;
import main.java.api.pojo.epspaymentsearch.jsonresponse.EpsPaymentsSummarySearchResponse;
import main.java.fislServices.PaymentSummaryFislService;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.queries.QUERY;

import main.java.reporting.Log;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.xml.sax.SAXException;

public class ViewPayments extends ViewPaymentsDataProvider {

	@FindBy(xpath = "//a[contains(text(),'PDF')]")
	WebElement lnkEpraPDF;

	@FindBy(xpath = "//select[@id='periodId']")
	WebElement drpDwnQuickSearch;

	@FindBy(id = "mktTypeId")
	WebElement drpDwnMarketType;

	@FindBy(xpath = "//span[(contains(@onmouseover,'Please contact Provider Support at 1-877-620-6194 option 1.'))]")
	WebElement failedPopUpTxt;

	@FindBy(name = "filterPayments")
	WebElement drpDwnFilterPayments;

	@FindBy(id = "archiveFilterType")
	WebElement drpDwnArchiveFilter;

	@FindBy(xpath = "//div[@id='view-payments']//tr[2]/td//tr[2]//div[2]//div[4]/p")

	WebElement lblPaymentStatusProv;

	@FindBy(css = "#paymentsummaryform>table>tbody>tr>td>table>tbody")
	WebElement divSearchResults;

	@FindBy(xpath = "//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr")
	List<WebElement> searchResultRows;

	@FindBy(xpath = "//td[@class='errors']")
	WebElement errorMsg;

	@FindBy(id = "taxIndNbrId")
	WebElement drpDwnTin;

	@FindBy(id = "tabHome")
	WebElement homeTab;

	@FindBy(xpath = "//td[contains(text(),'Record Count')]")
	WebElement recordCount;

	@FindBy(xpath = ".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]//a[not(contains(text(),'Last Page'))]")
	List<WebElement> pageLinks;

	@FindBy(linkText = "Next")
	WebElement lnkNextPage;

	@FindBy(linkText = "Payment Date")
	WebElement lnkPaymentDate;

	@FindBy(name = "payerProvTin")
	WebElement txtBoxPayerTin;

	@FindBy(name = "providerTIN")
	WebElement txtBoxProvTin;

	@FindBy(name = "btnSearch")
	WebElement btnSearch;

	@FindBy(xpath = "//*[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]")
	WebElement payNo;

	@FindBy(name = "billingProvTin")
	WebElement txtBoxBSTin;

	@FindBy(xpath = "//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[1]/a")
	WebElement lnkPayer;

	@FindBy(xpath = "//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[3]/a")
	WebElement lnkNPI;

	@FindBy(xpath = "//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[4]/a")
	WebElement lnkPaymentNumber;

	@FindBy(xpath = "//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[6]/a")
	WebElement lnkAmount;

	@FindBy(xpath = "//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[7]/a")
	WebElement lnkType;

	@FindBy(xpath = "//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[10]/a")
	WebElement lnkMarketType;

	@FindBy(xpath = "//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[1]/th[13]/a")
	WebElement lnkArchive;

	@FindBy(xpath = "//span[contains(@title,'ePRA in process')]")
	WebElement mousehoverEPRA;

	@FindBy(name = "taxIdNbr")
	WebElement txtboxTinNo;

	@FindBy(xpath = "//*[contains(text(),'Payer PRA')]//following::tr[1]/td[1]")
	WebElement payerUI;

	@FindBy(xpath = "//td[contains(text(),'Payment Number')]")
	WebElement paymentNumremit;

	@FindBy(xpath = "//a[@id = 'paymentNbr_1']")
	WebElement paymntnumHeader;

	@FindBy(xpath = "//a[@id='paymentNbr_1']")
	WebElement paymentNo1;

	@FindBy(id = "savePaymentArchive")
	WebElement btnSave;

	@FindBy(name = "B3")
	WebElement btnPrntPaymntSummary;

	// @FindBy(xpath = "(//a[@class='pageNo' and contains(text(),'Last Page')])[1]")
	@FindBy(xpath = "//div[@id='view-payments']/table//tr[1]//div[2]/div[1]/span")
	WebElement divShowRslts;

	@FindBy(id = "viewPaymentsPremium")
	WebElement popUpViewPay;

	@FindBy(id = "getStartedModal")
	WebElement popUpGetStarted;

	@FindBy(xpath = "//span[contains(text(),'Get Started')]")
	WebElement btnGetStarted;

	@FindBy(xpath = "//span[contains(text(),'I Accept')]")
	WebElement btnIAccept;

	@FindBy(xpath = "//button[@title='Close']")
	WebElement btnClosePopup;

	@FindBy(xpath = "//span[contains(text(),'No, Thanks')]")
	WebElement btnNoThnx;

	@FindBy(xpath = "//*[@id='paymentsummaryform']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table/tbody/tr[2]/td/span/input[1]")
	WebElement txtBoxPayerTin2;

	@FindBy(xpath = "//a[contains(text(),'View Payments')]")
	WebElement viewPaymentsTab;
	@FindBy(xpath = "//input[@name='providerTIN']")
	WebElement enterTIN;
	@FindBy(xpath = "//input[@name='btnSubmit']")
	WebElement seacrhBtn;
	@FindBy(xpath = "//select[@id='periodId']")
	WebElement quickSeacrhDrpDwn;
	@FindBy(xpath = "//select[@name='filterPayments']")
	WebElement filterPaymentsDrpDwn;
	@FindBy(xpath = "//select[@id='mktTypeId']")
	WebElement mrktTypeDrpDwn;
	@FindBy(xpath = "//select[@id='payerFilterType']")
	WebElement payerDrpDwn;
	@FindBy(xpath = "//select[@id='archiveFilterType']")
	WebElement archiveDrpDwn;
	@FindBy(xpath = "//td[contains(text(),'Record Count:')]")
	WebElement record;
	@FindBy(xpath = "//input[@name='btnSubmit']")
	WebElement searchBtn;
	@FindBy(xpath = "//a[@id='paymentNbr_1']")
	WebElement firstPaymentNumber;
	@FindBy(xpath = "//table[@class='tableborder']/tbody/tr/td/table/tbody/tr[2]/td[1]/span[1]")
	WebElement firstPayerName;
	@FindBy(xpath = "//select[@id='periodId']")
	WebElement quickSearch;
	@FindBy(xpath = "//select[@id='mktTypeId']")
	WebElement marketTyp;
	@FindBy(xpath = "//select[@id='payerFilterType']")
	WebElement payerDrpDown;
	@FindBy(xpath = "//select[@name='filterPayments']")
	WebElement filterDrpDown;
	// @FindBy(xpath = "//a[contains(text(),'Payment Number')]") WebElement
	// paymentNumHyper;
	@FindBy(xpath = "//p[contains(text(),'Payment Number')]//a")
	WebElement paymentNumHyper;
	@FindBy(xpath = "//td[@class='subheader']")
	WebElement viewPaymentsSubHeader;
	@FindBy(xpath = "//td[starts-with(text(),'Organization:')]")
	WebElement orgHeader;
	@FindBy(xpath = "//select[@id='archiveFilterType']")
	WebElement activeDrpDown;
	@FindBy(xpath = "//a[contains(text(),'Payer')]")
	WebElement payerHeader;
	@FindBy(xpath = "//td[contains(text(),'Payer')]")
	WebElement payerHeaderPrintPaymentSummary;
	@FindBy(xpath = "//*[contains(text(),'Payment Date')]")
	WebElement payDateHeader;
	@FindBy(xpath = "//a[contains(text(),'NPI')]")
	WebElement npiHeader;
	@FindBy(xpath = "//a[contains(text(),'Payment Number')]")
	WebElement paymentNum;
	@FindBy(xpath = "//th[contains(text(),'Proxy')]")
	WebElement proxyNum;
	@FindBy(xpath = "//a[contains(text(),'Amount')]")
	WebElement amountHeader;
	@FindBy(xpath = "//a[contains(text(),'Market Type')]")
	WebElement typeHeader; //
	@FindBy(xpath = "//*[contains(text(),'Payment Status')][2]")
	WebElement paymentStatusHeader;
	@FindBy(xpath = "//th[contains(text(),'Redemption')]")
	WebElement redemptionHeader;
	@FindBy(xpath = "//a[contains(text(),'Market Type')]")
	WebElement marketTypeHeader;
	@FindBy(xpath = "//span[contains(text(),'Returned Reason')]")
	WebElement returnedReasonHeader;
	@FindBy(xpath = "//th[contains(text(),'Updated Payment Dt')]")
	WebElement updatedHeader;
	@FindBy(xpath = "//th[contains(text(),'Resend Payment')]")
	WebElement resendHeader;
	@FindBy(xpath = "//span[contains(text(),'835 / EPRA')]")
	WebElement epraHeader;
	@FindBy(xpath = "//span[contains(text(),'Payer')]")
	WebElement ppraHeader;
	@FindBy(xpath = "//a[contains(text(),'Archive')]")
	WebElement archiveHeader;
	@FindBy(xpath = "//input[@value='Print Payment Summary']")
	WebElement printBtn;
	@FindBy(xpath = "//*[starts-with(text(),'In order to print the ERA, you must have Adobe Reader installed on your machine. Please download')]")
	WebElement printTextFooterTxt;
	@FindBy(xpath = "//input[@id='saveArchive']")
	WebElement saveBtn;
	@FindBy(xpath = "//a[@class='exante-default-header-txt-bold'][contains(text(),'Home')]")
	WebElement homeBtn;
	@FindBy(xpath = "//input[@name='btnSearch']")
	WebElement srchBtn;
	@FindBy(xpath = "//td[contains(text(),'No payments')]")
	WebElement errormsg;
	@FindBy(xpath = "//td[@class='errors']")
	WebElement errormsgcsr;
	@FindBy(xpath = "//table[@class='tableborder']/tbody/tr/td/table/tbody/tr")
	List<WebElement> payerTable;

	// Added by Mohammad: WebElement Fee Amount Info Icon Message
	@FindBy(xpath = "//span[@class='wrapperTooltip']")
	WebElement iHoverMessageFeeAmount_UPA;

	@FindBy(xpath = "//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr")
	WebElement tableViewPayments;

	@FindBy(xpath = "//tr[@class='search-remittance__table_header']/../tr")
	List<WebElement> payNumber_SR_P1;

	@FindBy(xpath = "(//a[@class='pageNo' and contains(text(),'Next')])[1]")
	WebElement nextLink_SR;
	
	@FindBy(xpath = "//input[@name='Submit']") 
	WebElement PrintButton;
	
	@FindBy(xpath = "//select[@property='paymentArchiveValue']") 
	WebElement PaymentStatusDrpdwn;
	
	
	

	
	Map dataRequiredForSearch;
	public SearchRemittance searchRemittance;
	protected TestBase testConfig = TestBase.getInstance();
	public String totalRecordsFromFISL;
	public ValidateEnrollmentTypePage validateEnrollmentType;
	String[] expectedOptions = { "Last 30 days", "Last 60 days", "Last 90 days", "Last 4-6 months", "Last 6-9 months",
			"Last 9-13 months" };
	PaymentSummaryFislService service = null;
	EpsPaymentsSummarySearchResponse searchResponse; 
	static String PaymentNumber = null;
	static String PaymentDate = null;
	static String Amount = null;
	static String NPI = null;
	Map<String, LinkedHashMap<String, String>> FISLResponse = null;
	Map<String, LinkedHashMap<String, String>> UIResponse= null;
	
	
	
	
	public ViewPayments(TestBase testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}

	/*
	 * public ViewPayments(TestBase testConfig) { super(testConfig);
	 * PageFactory.initElements(TestBase.driver, this);
	 * if(System.getProperty("Application").contains("UPA")){
	 * drpDwnQuickSearch=Element.findElement(testConfig,"id", "periodId");
	 * if(drpDwnQuickSearch!=null)
	 * Element.verifyElementPresent(drpDwnQuickSearch,"Quick Search dropdown"); else
	 * { try { if(txtBoxPayerTin!=null)
	 * Log.Pass("Payer Prov tin text box is displayed"); else if(txtBoxBSTin !=null)
	 * Log.Pass("BS Prov tin text box is displayed"); } catch(Exception e){
	 * Log.Comment("Not payer/BS user"); } } } else
	 * if(System.getProperty("Application").contains("CSR")){
	 * Element.verifyElementPresent(drpDwnQuickSearch,"Quick Search dropdown"); } }
	 */

	public ViewPayments(TestBase testConfig, String filter) {
		super(testConfig);
	}

	public ViewPayments(TestBase testConfig, boolean flag) {
		PageFactory.initElements(TestBase.driver, this);
	}

	/**
	 * Sets quick search date range filter for the passed tin
	 * 
	 * @param tin
	 * @return payment sumary page
	 */
	public ViewPayments setQuickSearchFilter(String paymentType) {
		String setlDate = null;

		if (paymentType.equalsIgnoreCase("nonEpraPayment"))
			setlDate = testConfig.getRunTimeProperty("setlDate");
		else
			setlDate = getPaymentNoDetails(paymentType).get("setlDate");

		String filterToBeSelected = getQuickSearchFilterCriteria(setlDate);
		Browser.waitForLoad(TestBase.driver);
		Element.selectByVisibleText(drpDwnQuickSearch, filterToBeSelected,
				filterToBeSelected + " from 'Filter payments' dropdown");
		Browser.waitForLoad(TestBase.driver);
		Element.expectedWait(drpDwnQuickSearch, testConfig, "Quick Search Filter", "Quick Search Filter");
		return this;
	}

	public ViewPayments clickEpraPDFLinkSrchRemit(String srchType) {
		String actualPaymntNo = "";
		String expectedPaymntNo = "";
		boolean found = false;
		if (srchType.equals("byDOPAndNpi") || srchType.equals("EPRADOPAndNpi")) {
			expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");

			System.setProperty("paymentNum", expectedPaymntNo);
			searchResultRows = Element.findElements(testConfig, "xpath",
					"//*[@id='searchRemittanceResultsForm']/table//tr[8]/td/table/tbody/tr/td/table/tbody/tr");
		} else if (srchType.equals("byElectronicPaymentNo") || srchType.equals("EPRAElectronicPaymentNo")) {
			expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
			System.setProperty("paymentNum", expectedPaymntNo);
			searchResultRows = Element.findElements(testConfig, "xpath",
					"//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr");
		}

		WebElement popUp = null;
		WebElement lnkEpraPdf = null;
		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			if (testConfig.driver.getPageSource().toString().contains(expectedPaymntNo)) {
				for (int i = 1; i < searchResultRows.size(); i++) {
					actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
					actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");

					Log.Comment("Actual Payment No is:" + actualPaymntNo);
					Log.Comment("Expected Payment No is:" + expectedPaymntNo);

					if (actualPaymntNo.equals(expectedPaymntNo)) {
						found = true;
						if (srchType.equals("byDOPAndNpi") || srchType.equals("EPRADOPAndNpi"))
							lnkEpraPdf = Element.findElement(testConfig, "xpath",
									"//*[@id='searchRemittanceResultsForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr["
											+ (i + 1) + "]/td[4]/../td[8]/table/tbody/tr/td[3]/span[1]");
						else if (srchType.equals("byElectronicPaymentNo") || srchType.equals("EPRAElectronicPaymentNo"))
							lnkEpraPdf = Element.findElement(testConfig, "xpath",
									"//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr["
											+ (i + 1) + "]/td[4]/../td[8]/table/tbody/tr/td[3]/span[1]");
						else if (srchType.equals("byDOPAndNpiUPA"))
							lnkEpraPdf = Element.findElement(testConfig, "xpath",
									"//*[@id='searchRemittanceResultsForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr["
											+ (i + 1) + "]/td[4]/../td[8]/table/tbody/tr/td[3]/span[1]");
						Browser.scrollTillAnElement(testConfig, lnkEpraPdf,
								"Epra Link found for Display Consolidated No. :" + actualPaymntNo);
						Element.verifyElementPresent(lnkEpraPdf, "EPRA pdf Link");
						Element.click(lnkEpraPdf, "PDF Link for EPRA for Display Consolidated No. :" + actualPaymntNo);
						String oldWindow = Browser.switchToNewWindow(testConfig, "EPRADisplayWindow");
						Browser.switchToParentWindow(testConfig, oldWindow);
						Browser.wait(testConfig, 2);
						break;
					}
				}
			}
			if (found == true)
				break;
			else if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				Log.Comment("Non ePRA payment not found on page number " + pageNo);
				Element.findElement(testConfig, "xpath",
						".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
								+ pageToBeClicked + ")]")
						.click();
				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.waitForLoad(testConfig.driver);
			}

			else if (pageNo % 10 == 0 && totalNoOfPages != 2 && pageNo < totalNoOfPages) {
				Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.waitForLoad(testConfig.driver);
				Browser.wait(testConfig, 3);
			}

			else
				Log.Fail("Could not find nonEpra payment on any of the pages, please execute test case manually");
		}
		return searchRemittance;
	}

	public ViewPayments clickEpraPDFLink(String srchType) {
		String actualPaymntNo = "";
		String expectedPaymntNo = "";
		boolean found = false;
		if (srchType.equals("byDOPAndNpiUPA")) {
			expectedPaymntNo = testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
			System.setProperty("paymentNum", expectedPaymntNo);
			searchResultRows = Element.findElements(testConfig, "xpath",
					"//*[@id='searchRemittanceResultsForm']/table//tr[8]/td/table/tbody/tr/td/table/tbody/tr");
		} else if (srchType.equals("byElectronicPaymentNo")) {
			expectedPaymntNo = testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
			System.setProperty("paymentNum", expectedPaymntNo);
			searchResultRows = Element.findElements(testConfig, "xpath",
					"//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr");
		}

		else if (srchType.equals("byDOPAndNpi")) {
			Browser.wait(testConfig, 7);
			String ui_Payer = payerUI.getText();
			Log.Comment("The First Payer Name displayed is:" + ui_Payer);
			expectedPaymntNo = paymentNo1.getText();
			String paymentNum = paymentNo1.getText();
			Log.Comment("The First Payment Number displayed is:" + expectedPaymntNo);
			Browser.wait(testConfig, 5);
			int sqlRowNo = 184;
			testConfig.putRunTimeProperty("ui_Payer", ui_Payer);
			Map payerSchema = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			Log.Comment("Message from DB for Payer Schema:" + payerSchema);

			if (null == payerSchema) {
				sqlRowNo = 203;
				testConfig.putRunTimeProperty("ui_Payer", ui_Payer);
				Map payerSchema1 = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
				String payerSchemaUI = (payerSchema1.toString()).substring(14, 19);
				Log.Comment("Payer Schema is :" + payerSchemaUI);
				sqlRowNo = 185;
				testConfig.putRunTimeProperty("paymentNum", paymentNum);
				Map paymentNumDB1 = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
				String paymentNumDB2 = (paymentNumDB1.toString());
				String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length() - 1);
				String paymentNumDB = paymentNumDB3.substring(18, paymentNumDB3.length());
				Log.Comment("The CONSL_PAY_NBR is :" + paymentNumDB);
				Log.Comment("The expected Payment No is:" + expectedPaymntNo);
				searchResultRows = Element.findElements(testConfig, "xpath",
						"//*[@id='searchRemittanceResultsForm']/table//tr[8]/td/table/tbody/tr/td/table/tbody/tr");
			}

			Log.Comment("The expected Payment No is:" + expectedPaymntNo);
			searchResultRows = Element.findElements(testConfig, "xpath",
					"//*[@id='searchRemittanceResultsForm']/table//tr[8]/td/table/tbody/tr/td/table/tbody/tr");
		}

		else if (srchType.equals("viewPayments")) {
			searchResultRows = Element.findElements(testConfig, "xpath",
					"//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr");
			expectedPaymntNo = testConfig.getRunTimeProperty("dspl_consl_pay_nbr");
			if (expectedPaymntNo.length() >= 15)
				expectedPaymntNo = expectedPaymntNo.substring(0, 15);
			Log.Comment("The DSP_CONSL_PAY_NBR is :" + expectedPaymntNo);
		}

		WebElement lnkEpraPdf = null;
		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			if (testConfig.driver.getPageSource().toString().contains(expectedPaymntNo)) {
				for (int i = 1; i < searchResultRows.size(); i++) {

					if (srchType.equals("viewPayments")) {
						String xpath = "//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr["
								+ (i + 1) + "]/td[4]";
						actualPaymntNo = Element.findElement(testConfig, "xpath", xpath).getText();
					} else {
						actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
						actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
					}
					if (actualPaymntNo.contains(expectedPaymntNo)) {
						found = true;
						if (srchType.equals("byDOPAndNpi"))
							lnkEpraPdf = Element.findElement(testConfig, "xpath",
									"//*[@id='searchRemittanceResultsForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr["
											+ (i + 1) + "]/td[4]/../td[8]/table/tbody/tr/td[3]/span[1]");
						else if (srchType.equals("byElectronicPaymentNo"))
							lnkEpraPdf = Element.findElement(testConfig, "xpath",
									"//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr["
											+ (i + 1) + "]/td[4]/../td[8]/table/tbody/tr/td[3]/span[1]");
						else if (srchType.equals("byDOPAndNpiUPA"))
							lnkEpraPdf = Element.findElement(testConfig, "xpath",
									"//*[@id='searchRemittanceResultsForm']/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr["
											+ (i + 1) + "]/td[4]/../td[8]/table/tbody/tr/td[3]/span[1]");
						else if (srchType.equals("viewPayments")) {
							lnkEpraPdf = Element.findElement(testConfig, "xpath",
									"//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr["
											+ (i + 1) + "]/td[11]/table/tbody/tr/td[3]/span[1]/a");
						}
						Browser.scrollTillAnElement(testConfig, lnkEpraPdf,
								"Epra Link found for Display Consolidated No. :" + actualPaymntNo);
						Element.verifyElementPresent(lnkEpraPdf, "EPRA pdf Link");

						Element.waitForElementTobeClickAble(testConfig, lnkEpraPdf, 60);
						Element.clickByJS(testConfig, lnkEpraPdf, "PDF Link for EPRA");
						String oldWindow = Browser.switchToNewWindow(testConfig, "EPRADisplayWindow");
						WebElement msg = Element.findElement(testConfig, "xpath", "//div[@id='message1']/b");

						Browser.switchToParentWindow(testConfig, oldWindow);
						Browser.wait(testConfig, 5);
						break;
					}
				}
			}

			if (found == true)
				break;
			else if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				Log.Comment("Non ePRA payment not found on page number " + pageNo);
				Element.findElement(testConfig, "xpath",
						".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
								+ pageToBeClicked + ")]")
						.click();
				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.waitForLoad(testConfig.driver);
			}

			else if (pageNo % 10 == 0 && totalNoOfPages != 2 && pageNo < totalNoOfPages) {
				Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.waitForLoad(testConfig.driver);
				Browser.wait(testConfig, 3);
			}

			else
				Log.Fail("Could not find nonEpra payment on any of the pages, please execute test case manually");
		}
		return searchRemittance;

	}

	public ViewPayments verifyEpraStatus(String expectedStatus) {
		Browser.browserRefresh(testConfig);
		Browser.wait(testConfig, 2);
		String paymentNumDB = System.getProperty("CONSL_PAY_NBR");
		int sqlRowNo = 206;
		testConfig.putRunTimeProperty("paymentNumDB", paymentNumDB);
		Map epraStatusTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig,
				"Status in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), expectedStatus,
				epraStatusTbl.get("REQ_STS").toString());
		System.setProperty("CONSL_PAY_NBR", epraStatusTbl.get("CONSL_PAY_NBR").toString());
		return this;
	}

	public ViewPayments verifyEpraStatus(String srchType, int dummy) {
		int sqlRowNo = 206;
		String expectedStatus = "";
		Map epraStatusTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		if (epraStatusTbl.get("REQ_STS").toString().equals("C"))
			expectedStatus = "C";
		if (epraStatusTbl.get("REQ_STS").toString().equals("S"))
			expectedStatus = "S";
		if (epraStatusTbl.get("REQ_STS").toString().equals("R"))
			expectedStatus = "R";
		if (epraStatusTbl.get("REQ_STS").toString().equals("E"))
			expectedStatus = "E";
		Helper.compareEquals(testConfig,
				"Status in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), expectedStatus,
				epraStatusTbl.get("REQ_STS").toString());

		if (srchType.equals("viewPayments")) {

			if (epraStatusTbl.get("REQ_STS").toString().equals("R")
					|| epraStatusTbl.get("REQ_STS").toString().equals("S")
					|| epraStatusTbl.get("REQ_STS").toString().equals("E")

			) {
				Browser.browserRefresh(testConfig);
				WebElement txtEpraPDf = Element.findElement(testConfig, "xpath",
						"//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[11]//span[contains(@class,'tip_holder')]");
			}
		}

		return this;
	}

	public ViewPayments getPDFfileNameEPRA() {

		int sqlRowNo = 206;
		Map epraStatusTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Log.Comment("----Converted-PDFFIleName-->" + epraStatusTbl.get("PDF_FL_NM"));
		System.setProperty("PDFFileName", (String) epraStatusTbl.get("PDF_FL_NM"));

		return this;
	}

	public ViewPayments verifyEpraClaimCntAndPriority() {
		Browser.wait(testConfig, 7);
		String ui_Payer = payerUI.getText();
		Log.Comment("The First Payer Name displayed is:" + ui_Payer);
		testConfig.putRunTimeProperty("ui_Payer", ui_Payer);
		String paymentNum = paymentNo1.getText();
		Log.Comment("The First Payment Number displayed is:" + paymentNum);
		Log.Comment("Payer Name in UI is:" + ui_Payer);
		int sqlRowNo = 184;
		testConfig.getRunTimeProperty("ui_Payer");
		Map payerSchema = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Log.Comment("Message from DB for Payer Schema:" + payerSchema);

		if (null == payerSchema) {
			sqlRowNo = 203;
			testConfig.getRunTimeProperty("ui_Payer");
			Map payerSchema1 = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			String payerSchemaUI = (payerSchema1.toString()).substring(14, 19);
			Log.Comment("Payer Schema is :" + payerSchemaUI);
			sqlRowNo = 185;
			testConfig.putRunTimeProperty("paymentNum", paymentNum);
			Map paymentNumDB1 = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			String paymentNumDB2 = (paymentNumDB1.toString());
			String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length() - 1);
			String paymentNumDB = paymentNumDB3.substring(18, paymentNumDB3.length());
			Log.Comment("The CONSL_PAY_NBR is :" + paymentNumDB);

			sqlRowNo = 206;
			testConfig.putRunTimeProperty("paymentNumDB", paymentNumDB);
			Map epraStatusTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			if (Integer.parseInt(epraStatusTbl.get("CLAIM_CNT").toString()) <= 75)
				Helper.compareEquals(testConfig,
						"Priority in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), "1",
						epraStatusTbl.get("PRIORITY").toString());
			else
				Helper.compareEquals(testConfig,
						"Priority in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), "2",
						epraStatusTbl.get("PRIORITY").toString());
		}

		else {
			String payerSchemaUI = (payerSchema.toString()).substring(14, 19);
			Log.Comment("Payer Schema is :" + payerSchemaUI);

			sqlRowNo = 185;
			testConfig.putRunTimeProperty("paymentNum", paymentNum);
			Map paymentNumDB1 = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			String paymentNumDB2 = paymentNumDB1.toString();
			String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length() - 1);
			String paymentNumDB = paymentNumDB3.substring(18, paymentNumDB3.length());
			Log.Comment("The CONSL_PAY_NBR is :" + paymentNumDB);

			sqlRowNo = 206;
			testConfig.putRunTimeProperty("paymentNumDB", paymentNumDB);
			Map epraStatusTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);

			if (Integer.parseInt(epraStatusTbl.get("CLAIM_CNT").toString()) <= 75)
				Helper.compareEquals(testConfig,
						"Priority in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), "1",
						epraStatusTbl.get("PRIORITY").toString());
			else
				Helper.compareEquals(testConfig,
						"Priority in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), "2",
						epraStatusTbl.get("PRIORITY").toString());
		}

		return this;
	}

	public ViewPayments verifyEpraClaimCntAndPrioritySrch() {

		String paymentNumDB = System.getProperty("CONSL_PAY_NBR");
		int sqlRowNo = 206;
		testConfig.putRunTimeProperty("paymentNumDB", paymentNumDB);
		Map epraStatusTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		if (Integer.parseInt(epraStatusTbl.get("CLAIM_CNT").toString()) <= 75)
			Helper.compareEquals(testConfig,
					"Priority in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), "1",
					epraStatusTbl.get("PRIORITY").toString());
		else
			Helper.compareEquals(testConfig,
					"Priority in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), "2",
					epraStatusTbl.get("PRIORITY").toString());

		return this;

	}

	public ViewPayments verifyEpraStatusSrchRemit(String expectedStatus) {
		Browser.browserRefresh(testConfig);
		String paymentNumDB = System.getProperty("CONSL_PAY_NBR");
		int sqlRowNo = 206;
		testConfig.putRunTimeProperty("paymentNumDB", paymentNumDB);
		Map epraStatusTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig,
				"Status in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), expectedStatus,
				epraStatusTbl.get("REQ_STS").toString());
		System.setProperty("CONSL_PAY_NBR", epraStatusTbl.get("CONSL_PAY_NBR").toString());

		return this;
	}

	public ViewPayments verifyEpraClaimCntAndPriority(String srchType) {

		String paymentNumDB = null;
		if (srchType.equals("viewPayments")) {
			paymentNumDB = testConfig.getRunTimeProperty("CONSL_PAY_NBR");
		} else

			paymentNumDB = System.getProperty("CONSL_PAY_NBR");

		System.out.println(paymentNumDB);
		int sqlRowNo = 206;
		testConfig.putRunTimeProperty("paymentNumDB", paymentNumDB);
		Map epraStatusTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);

		if (epraStatusTbl.get("CLAIM_CNT") == (null) || epraStatusTbl.get("CLAIM_CNT") == "")
			Helper.compareEquals(testConfig,
					"Priority in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), "1",
					epraStatusTbl.get("PRIORITY").toString());
		else if (Integer.parseInt(epraStatusTbl.get("CLAIM_CNT").toString()) <= 75)
			Helper.compareEquals(testConfig,
					"Priority in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), "1",
					epraStatusTbl.get("PRIORITY").toString());
		else
			Helper.compareEquals(testConfig,
					"Priority in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), "2",
					epraStatusTbl.get("PRIORITY").toString());

		return this;

	}

	public ViewPayments verifyEpraDownloadStatus(String expectedStatus) {
		String paymentNumDB = System.getProperty("CONSL_PAY_NBR");
		testConfig.putRunTimeProperty("paymentNumDB", paymentNumDB);
		int sqlRowNo = 206;
		Map epraStatusTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig,
				"Priority in Epra status for payment number : " + epraStatusTbl.get("CONSL_PAY_NBR"), expectedStatus,
				epraStatusTbl.get("DOWNLOADED").toString());
		return this;
	}

	/**
	 * Finds if a failed Payment is displayed on payment summary page if yes, hovers
	 * mouse over 'Failed Payment' text and verifies that a pop appears and verifies
	 * in it
	 */
	public void verifyFailedPaymentPopUp() {
		String paymentStatus = "";
		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			if (testConfig.driver.getPageSource().contains("Failed")) {
				for (int i = 1; i < searchResultRows.size(); i++) {
					paymentStatus = searchResultRows.get(i).findElements(By.tagName("td")).get(7).getText();
					paymentStatus = paymentStatus.replace("\n", "");
					if (paymentStatus.equals("Failed")) {
						Element.onMouseHover(testConfig, searchResultRows.get(i).findElements(By.tagName("td")).get(7),
								"Failed Payment with payment number : "
										+ searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText());
						break;
					}
				}
			}

			else if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				Log.Comment("Failed payment not found on page number " + pageNo);
				Element.findElement(testConfig, "xpath",
						".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
								+ pageToBeClicked + ")]")
						.click();
				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.waitForLoad(testConfig.driver);
			}

			else if (pageNo % 10 == 0 && totalNoOfPages != 2 && pageNo < totalNoOfPages) {
				Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.waitForLoad(testConfig.driver);
				Browser.wait(testConfig, 3);
			}

			else
				Log.Warning("Could not find failed payment on any of the pages, please execute test case manually",
						testConfig);
		}
	}

	public void verifyRemitPaymentPopUp() {
		String paymentType = "remitPayment";
		String expectedPaymntNo = getPaymentNoDetails(paymentType).get("paymentNo");
		String actualPaymntNo = "";

		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			if (testConfig.driver.getPageSource().contains(expectedPaymntNo)) {

				for (int i = 1; i < searchResultRows.size(); i++) {
					actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText(); // fetching
																												// payment
																												// number
																												// from
																												// UI
					actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
					if (actualPaymntNo.equals(expectedPaymntNo)) {
						Element.mouseHoverByJS(testConfig,
								searchResultRows.get(i).findElements(By.tagName("td")).get(3),
								"Remit Payment with payment number : " + actualPaymntNo);
						// add for text verification in pop up
						break;
					}
				}
			}

			else if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				Log.Comment("Remit payment " + actualPaymntNo + " not found on page number " + pageNo);
				Element.findElement(testConfig, "xpath",
						".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
								+ pageToBeClicked + ")]")
						.click();
				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.waitForLoad(testConfig.driver);
				Browser.wait(testConfig, 2);
			}

			else if (pageNo % 10 == 0 && totalNoOfPages != 2 && pageNo < totalNoOfPages) {
				Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.waitForLoad(testConfig.driver);
			} else
				Log.Warning("Could not find Remit payment with number" + expectedPaymntNo
						+ ", please execute test case manually", testConfig);
		}
	}

	public String getDisplayConsolidatedNumberFromUI(int rowNo) {
		return searchResultRows.get(rowNo).findElements(By.tagName("td")).get(3).getText();
	}

	/**
	 * Verifies the default selected filter drop down values
	 * 
	 * @return object of this page
	 * @throws JSONException
	 */

	public ViewPayments verifyDefaultSearchResultCount() throws JAXBException, IOException, SAXException,
			ParserConfigurationException, ParseException, JSONException {
		int i = 0;
		String expectedSelectedOption = "Show All";
		Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption,
				Element.getFirstSelectedOption(testConfig, drpDwnFilterPayments, "text"));
		Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption,
				Element.getFirstSelectedOption(testConfig, drpDwnMarketType, "text"));
		expectedSelectedOption = "New";
		Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption,
				Element.getFirstSelectedOption(testConfig, drpDwnArchiveFilter, "text"));

		// Verify all options are displayed in Quick search Filter dropdown
		List<String> quickSearchOptions = Element.getAllOptionsInSelect(testConfig, drpDwnQuickSearch);

		String[] expectedOptions = { "Last 30 days", "Last 60 days", "Last 90 days", "Last 4-6 months",
				"Last 6-9 months", "Last 9-13 months" };

		for (String option : quickSearchOptions) {
			Helper.compareEquals(testConfig, "dropdown option" + " " + i, expectedOptions[i], option);
			i++;
		}

		// Verify by default quick search is set to last 30 days
		expectedSelectedOption = "Last 30 days";
		Helper.compareEquals(testConfig, "Selected Option", expectedSelectedOption,
				Element.getFirstSelectedOption(testConfig, drpDwnQuickSearch, "text"));
		getQuickSearchDates(expectedSelectedOption);
		verifyDefaultSearchRecordCount();
		return this;
	}

	/**
	 * By default record count should be the number of payments for last 30 days
	 * 
	 * @throws JSONException
	 */

	public void verifyDefaultSearchRecordCount()
			throws JAXBException, IOException, SAXException, ParserConfigurationException, JSONException {
		if (!getRecordCountFromFISL("Last 30 days","show all", "show all", "New").equalsIgnoreCase("0"))
			Helper.compareEquals(testConfig, "Record count from FISL and UI where FISL for 30 days (by default) : ",
					getRecordCountFromFISL("Last 30 days","show all", "show all", "New"), getRecordCountFromUI());
		else
			Element.verifyTextPresent(errorMsg, "No payments have been made to this Organization");
	}

	/**
	 * Selecting all the required filters from respective dropdowns
	 * 
	 * @param filterPayments,quickSearchFilter,Archivefilter,MktTypeFilter
	 * @return
	 */

	/**
	 * Selecting all the required filters from respective dropdowns
	 * 
	 * @param filterPayments,quickSearchFilter,Archivefilter,MktTypeFilter
	 * @return
	 */

	public ViewPayments setSearchFilters(String filterPayments, String quickSearchFilter, String Archivefilter,
			String MktTypeFilter) {
		// Element.selectByVisibleText(drpDwnFilterPayments,filterPayments,filterPayments
		// + " " +" from 'Filter payments' dropdown");
		Browser.wait(testConfig, 3);
		Browser.waitForLoad(testConfig.driver);
		Element.waitForPresenceOfElementLocated(testConfig, By.id("archiveFilterType"), 60);
		WebElement checkArchiveFilter = Element.findElement(testConfig, "id", "archiveFilterType");
		if (checkArchiveFilter != null && checkArchiveFilter.isEnabled()) {
			Element.selectByVisibleText(drpDwnArchiveFilter, Archivefilter,
					Archivefilter + " " + " from Payment Status dropdown");
			Browser.waitForLoad(testConfig.driver);
			Browser.wait(testConfig, 2);
		}
		Element.waitForPresenceOfElementLocated(testConfig, By.id("periodId"), 60);
		Element.selectByVisibleText(drpDwnQuickSearch, quickSearchFilter,
				quickSearchFilter + " " + " from 'Quick Search' dropdown");
		Browser.waitForLoad(testConfig.driver);

		getQuickSearchDates(quickSearchFilter);

		Element.selectByVisibleText(drpDwnMarketType, MktTypeFilter,
				MktTypeFilter + " " + " from 'Market Type' dropdown");
		Browser.wait(testConfig, 2);
		return this;
	}

	/**
	 * Set payer Filters
	 * 
	 * @param filterPayments
	 * @param quickSearchFilter
	 * @param MktTypeFilter
	 * @return Payment Summary Page
	 */

	public ViewPayments setSearchFiltersPayer(String filterPayments, String quickSearchFilter, String MktTypeFilter) {
		Element.selectByVisibleText(drpDwnFilterPayments, filterPayments,
				filterPayments + " " + " from 'Filter payments' dropdown");
		Browser.waitForLoad(testConfig.driver);
		Element.selectByVisibleText(drpDwnQuickSearch, quickSearchFilter,
				quickSearchFilter + " " + " from 'Quick Search' dropdown");
		Browser.waitForLoad(testConfig.driver);

		getQuickSearchDates(quickSearchFilter);

		Element.selectByVisibleText(drpDwnMarketType, MktTypeFilter,
				MktTypeFilter + " " + " from 'Market Type' dropdown");
		Browser.wait(testConfig, 3);
		return this;
	}

	/**
	 * Finds to and from date according to the quick search filter selected
	 * 
	 * @param quick
	 *            search dropdown value
	 * @return payment summary page
	 */

	public ViewPayments getQuickSearchDates(String quickSearchFilter) {
		String split[] = quickSearchFilter.split(" ");
		if (split[split.length - 1].contains("days")) {
			int LastNoOfdays = Integer.parseInt(split[split.length - 2]);
			testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterDays(-LastNoOfdays, "yyyy-MM-dd"));
			testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		}

		else {
			String monthRange = (split[split.length - 2]);
			Map<String, String> startAndEndDates = Helper.getStartAndEndPeriod(monthRange);
			testConfig.putRunTimeProperty("fromDate", startAndEndDates.get("fromDate").toString());
			testConfig.putRunTimeProperty("toDate", startAndEndDates.get("toDate").toString());

		}
		return this;
	}

	/**
	 * gets the record count
	 * 
	 * @return number of payments
	 */
	public String getRecordCountUISR() {

		// on payment summary page
		try {
			String recordCountElement[] = recordCount.getText().split(":");
			return recordCountElement[recordCountElement.length - 1].trim();
		}

		// On search remittance page
		catch (org.openqa.selenium.NoSuchElementException e) {
			searchRemittance = new SearchRemittance(testConfig, true);
			searchRemittance.divSearchResults = Element.findElements(testConfig, "xpath",
					".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr");

			String criteria = testConfig.getRunTimeProperty("criteriaType");
			if (criteria != null) {
				if (criteria.equals("byElectronicPaymentNo") || criteria.equals("byCheckNo")
						|| criteria.equals("byDOPAndRenderingProvider") || criteria.equals("byDOSAndNpi"))
					return String.valueOf(searchRemittance.divSearchResults.size() - 1);
			}

		}
		return String.valueOf(searchRemittance.divSearchResults.size() - 1);

	}

	public String getRecordCountFromUI() {
		String resultCount = divShowRslts.getText().toString();
		resultCount = resultCount.substring("Showing".length(), resultCount.indexOf("Results"));
		return resultCount.trim();
	}

	public String getRecordCountFromUISR() {
		try {
			String recordCountElement[] = recordCount.getText().split(":");
			return recordCountElement[recordCountElement.length - 1].trim();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			searchRemittance = new SearchRemittance(testConfig, true);
			// searchRemittance.divSearchResults=Element.findElements(testConfig, "xpath",
			// ".//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr[not(contains(@class,'columnHeaderText'))]");
			searchRemittance.divSearchResults = Element.findElements(testConfig, "xpath",
					"//*[@id='search-remmitance']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr[not(contains(@class,'search-remittance__table_header'))]");
			return String.valueOf(searchRemittance.divSearchResults.size());
		} catch (Exception e) {
			Log.Fail("Exception occured : " + e);
			return null;
		}
	}

	public boolean areAllUnique() {
		ArrayList<String> list = getNPIDetails();
		Set<String> set = new HashSet<String>(list);
		if (set.size() != 1) {
			return false;
		} else {
			return true;
		}

	}

	public void verifyNPI(String paymentType) {
		Boolean NPI = areAllUnique();

		if (paymentType.contains("Single")) {
			Helper.compareEquals(testConfig, "NPI", true, NPI);
		}
		if (paymentType.contains("Multiple")) {
			Helper.compareEquals(testConfig, "NPI", false, NPI);
		}
	}

	public ArrayList<String> getNPIDetails() {
		List<String> list = new ArrayList<String>();
		ArrayList<String> headers = getHeadersFromResultTable();

		int totalNoOfPages = getNumberOfPages();

		if (totalNoOfPages > 2)
			totalNoOfPages = 1;
		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			Element.findElements(testConfig, "xpath",
					".//*[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr");

			for (int i = 1; i < searchResultRows.size(); i++) {
				String detail = searchResultRows.get(i).findElements(By.tagName("td")).get(2).getText();
				if (detail.matches("\\d{10}")) {
					String details = detail.replaceAll("\\s", "");
					list.add(details);
				}
			}

			if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				WebElement pageLink = Element.findElement(testConfig, "xpath",
						".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
								+ pageToBeClicked + ")]");
				if (pageLink != null)
					pageLink.click();
				else
					Element.findElement(testConfig, "xpath",
							".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
									+ pageToBeClicked + ")]")
							.click();
				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.wait(testConfig, 3);
			} else if (pageNo % 10 == 0 && totalNoOfPages != 2) {
				Browser.wait(testConfig, 1);
				Log.Comment("Page Number is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.wait(testConfig, 3);
				pageNo++;
			}
		}
		return (ArrayList<String>) list;
	}

	/**
	 * This function creates an outer map with Key as payment number and Value as
	 * another hash map i.e. inner map that contains all the details for key like
	 * payer name, amount etc
	 * 
	 * @return Outer map
	 */
	public Map<String, LinkedHashMap<String, String>> getPaymentDetailsFromUI() {
		/** Gets headers List which will be key for following map */

		LinkedHashMap<String, String> innerMap;

		Map<String, LinkedHashMap<String, String>> outerMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		ArrayList<String> headers = getHeadersFromResultTable();

		int totalNoOfPages = 1;// getNumberOfPages();
		String payNum = null;
		int totalNoOfRows;
		Log.Comment("Fetching all payments From UI..");

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			if ("printPaymentSummary".equals(testConfig.getRunTimeProperty("page"))) {
				Element.findElements(testConfig, "xpath", "//table//tr[2]/td/table//tr[4]/td/table//tr/td//tbody/tr");
				totalNoOfRows = searchResultRows.size();
				if(totalNoOfRows>=31)
					totalNoOfRows=31;
			}
			else {
				Element.findElements(testConfig, "xpath",
						"//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr");
				totalNoOfRows = searchResultRows.size();
			}
			for (int i = 1; i < totalNoOfRows ; i++) {
				innerMap = new LinkedHashMap<String, String>();

				for (int j = 0; j < headers.size(); j++) {
					WebElement colVal = null;
					String details = "";
					if ("printPaymentSummary".equals(testConfig.getRunTimeProperty("page")))
						details = searchResultRows.get(i).findElements(By.tagName("td")).get(j).getText();
					else {
						if (headers.get(j).equals("Payment Status")) {
							try {
								
								colVal = searchResultRows.get(i)
										.findElement(By.tagName("select"));
							} catch (Exception e) {
								colVal = searchResultRows.get(i).findElements(By.tagName("td")).get(j)
										.findElement(By.tagName("select"));
							}
							details = Element.getFirstSelectedOption(testConfig, colVal, "text");
						} 
						else if(headers.get(j).equals("Payment Number")){
						    payNum = searchResultRows.get(i).findElements(By.tagName("td")).get(j).getText();
							if(payNum.contains("Check"))
							 payNum = payNum.substring(0, payNum.indexOf("Check"));
							details =payNum;
						}
						else {
						
							 payNum =  searchResultRows.get(i).findElements(By.tagName("td")).get(j).getText();
							details =payNum;
						}
					}
					details = details.replace("\n", "");
					innerMap.put(headers.get(j), details);
				}

				String amount = innerMap.get("Amount").replace(",", "");
				innerMap.put("Amount", amount);
				innerMap.remove("Redemption Date");
				innerMap.remove("Proxy Number");
				innerMap.remove("Payment Status / Trace Number");
				innerMap.remove("Payer/Patient");
				innerMap.remove("Type");
				innerMap.remove("Payer");
				innerMap.remove("Fee Amount");
				innerMap.remove("Returned Reason");
				innerMap.remove("835 / EPRA");
				innerMap.remove("Updated Payment Dt");
				innerMap.remove("Resend Payment");
				innerMap.remove("Payer PRA");
				outerMap.put(innerMap.get("Payment Number")
						+ "_" + innerMap.get("Payment Date"), innerMap);
			}

			if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				WebElement pageLink = Element.findElement(testConfig, "xpath",
						".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
								+ pageToBeClicked + ")]");
				if (pageLink != null)
					pageLink.click();
				else
					Element.findElement(testConfig, "xpath",
							".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
									+ pageToBeClicked + ")]")
							.click();
				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.wait(testConfig, 3);
			} else if (pageNo % 10 == 0 && totalNoOfPages != 2) {
				Browser.wait(testConfig, 1);
				Log.Comment("Page Number is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.wait(testConfig, 3);
				pageNo++;
			}
		}
		// Log.Comment("Details from UI is: "+outerMap.toString());
		return outerMap;

	}

	/**
	 * Get Headers List till Market Type to store them as key in map
	 * 
	 * @return HeaderList
	 */
	public ArrayList<String> getHeadersFromResultTable() {
		List<String> headerList = new ArrayList<String>();
		int size = 0;
		WebElement headerRow = null;
		if ("printPaymentSummary".equals(testConfig.getRunTimeProperty("page"))) {
			// tr[@class='columnHeaderText']
			Element.waitForPresenceOfElementLocated(testConfig,
					By.xpath("/html/body/table//tr[2]/td/table//tr[4]/td/table//tr/td//tbody/tr"), 5);
			searchResultRows = Element.findElements(testConfig, "xpath",
					"/html/body/table//tr[2]/td/table//tr[4]/td/table//tr/td//tbody/tr");
			if (!searchResultRows.isEmpty()) {
				size = searchResultRows.get(0).findElements(By.tagName("td")).size();
			}
		} else {
			Element.waitForPresenceOfElementLocated(testConfig,
					By.xpath("//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr[1]"), 5);
			headerRow = Element.findElement(testConfig, "xpath",
					"//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr[1]");

			if (headerRow != null)
				size = headerRow.findElements(By.tagName("th")).size();
		}
		for (int i = 0; i < size; i++) {
			String header = "";
			if ("printPaymentSummary".equals(testConfig.getRunTimeProperty("page")))
				header = searchResultRows.get(0).findElements(By.tagName("td")).get(i).getText();
			else
				header = headerRow.findElements(By.tagName("th")).get(i).getText();
			if (header.equals("Original Payment Date"))
				header = "Payment Date";
			headerList.add(header);
		}
		return (ArrayList<String>) headerList;

	}

	public ArrayList<String> getUIValuesForSinglePaymentPage() {
		Browser.wait(testConfig, 2);
		ArrayList<String> headers = getHeadersFromResultTable();
		List<String> rowValues = new ArrayList<String>();
		int size = 0;
		WebElement dataRow = null;
		Browser.wait(testConfig, 2);
		if ("printPaymentSummary".equals(testConfig.getRunTimeProperty("page"))) {
			Element.waitForPresenceOfElementLocated(testConfig,
					By.xpath("/html/body/table//tr[2]/td/table//tr[4]/td/table//tr/td//tbody/tr"), 5);
			searchResultRows = Element.findElements(testConfig, "xpath",
					"/html/body/table//tr[2]/td/table//tr[4]/td/table//tr/td//tbody/tr");
			if (!searchResultRows.isEmpty()) {
				size = searchResultRows.get(0).findElements(By.tagName("td")).size();
			}
		} else {
			Element.waitForPresenceOfElementLocated(testConfig,
					By.xpath("//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr[2]"), 5);
			dataRow = Element.findElement(testConfig, "xpath",
					"//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr[2]");
			if (dataRow != null)
				size = dataRow.findElements(By.tagName("td")).size();
		}
		Browser.wait(testConfig, 2);
		for (int i = 0; i < size; i++) {
			String colValue = "";
			if ("printPaymentSummary".equals(testConfig.getRunTimeProperty("page"))) {
				colValue = searchResultRows.get(1).findElements(By.tagName("td")).get(i).getText();
				rowValues.add(colValue);
			} else {
				colValue = dataRow.findElements(By.tagName("td")).get(i).getText();
				if (i == size - 1 && !StringUtils.equals("PAY", testConfig.getRunTimeProperty("userType"))) {
					WebElement temp = dataRow.findElements(By.tagName("td")).get(i).findElement(By.tagName("select"));
					colValue = Element.getFirstSelectedOption(testConfig, temp, "text");
					rowValues.add(colValue);
				} else if (i >= headers.indexOf("835 / EPRA") && i < (size - 1))
					continue;
				else if (i != (size - 1))
					rowValues.add(colValue);
			}
		}
		testConfig.putRunTimeProperty("page", "");
		return (ArrayList<String>) rowValues;
	}

	/**
	 * Select all filters, takes arguments
	 * 
	 * @param filterPayments,quickSearchFilter,Archivefilter
	 *            & MktTypeFilter Gets the record count from UI and fISL api and
	 *            compares them.
	 * @throws ParseException
	 * @throws JSONException
	 */

	public ViewPayments verifySearchResultsWithFilters(String QuickSearch, String FilterPayments, String MarketType, 
			String PaymentStatus) throws IOException, InterruptedException, JAXBException,
			SAXException, ParserConfigurationException, ParseException, JSONException {
		searchResponse = (EpsPaymentsSummarySearchResponse) getFISLResponse(QuickSearch, FilterPayments, MarketType, PaymentStatus);
		 totalRecordsFromFISL = String.valueOf(searchResponse.getData().getTotalCount());
		 if (!totalRecordsFromFISL.equalsIgnoreCase("0")) {
			Helper.compareEquals(testConfig, "Record Count from FISL and UI :", totalRecordsFromFISL,
					getRecordCountFromUI());
			FISLResponse=	getPaymentDetailsFromFISL(searchResponse);
			UIResponse=getPaymentDetailsFromUI();
			Helper.compareMaps(testConfig, "Payments Details Comparison", FISLResponse,
					UIResponse);
			
		} else
			Element.verifyTextPresent(errorMsg, "No payments have been made to this Organization.");

		return this;
	}

	public String getRecordCountFromFISL(String QuickSearch, String FilterPayments, String MarketType, 
			String PaymentStatus)
			throws JAXBException, IOException, SAXException, ParserConfigurationException, JSONException {
		EpsPaymentsSummarySearchResponse responseFromFISL = (EpsPaymentsSummarySearchResponse) getFISLResponse(QuickSearch, FilterPayments, MarketType, PaymentStatus);
		return String.valueOf(responseFromFISL.getData().getTotalCount());
	}

	public Map<String, LinkedHashMap<String, String>> getPaymentDetailsFromFISL(Object FISLResponse)
			throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException {
		LinkedHashMap<String, String> innerMap;
		Map<String, LinkedHashMap<String, String>> outerMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();

		EpsConsolidatedClaimPaymentSummaries[] payments = ((EpsPaymentsSummarySearchResponse) FISLResponse).getData()
				.getEpsConsolidatedClaimPaymentSummaries();

		for (int i = 0; i < payments.length; i++) {
			innerMap = new LinkedHashMap<String, String>();

			try {
				String setlDate = payments[i].getPaymentMadeOn();
				innerMap.put("Payment Date", Helper
						.changeDateFormatSeperator(Helper.changeDateFormat(setlDate, "yyyy-dd-mm", "dd-mm-yyyy")));
			}

			catch (Exception e) {
				innerMap.put("Payment Date", Helper.changeDateFormatSeperator(
						Helper.changeDateFormat(payments[i].getPaymentMadeOn(), "yyyy-dd-mm", "dd-mm-yyyy")));
			}

			if (payments[i].getNationalProviderIdentifier() != null)
				innerMap.put("NPI", payments[i].getNationalProviderIdentifier());
			else
				innerMap.put("NPI", "");
			
			
			innerMap.put("Payment Number", payments[i].getDisplayConsolidatedPaymentNumber());

			if (payments[i].getTotalAmount() == 0.0)
				innerMap.put("Amount", "$" + "0.00");
			else {
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
				String amount = decimalFormat.format((payments[i].getTotalAmount()));
				innerMap.put("Amount", "$" + amount);
			}
			
			if(StringUtils.equalsIgnoreCase(testConfig.getRunTimeProperty("portalAccess"), "standard"))
					innerMap.put("Claim Count", "N/A");
			else
			innerMap.put("Claim Count", String.valueOf(payments[i].getClaimCountTotal()));
			// Reading ACH Trace number for UPA portal
			if (System.getProperty("Application").contains("UPA")) {
			    if (payments[i].getTraceNumber() != null)
				    innerMap.put("ACH Trace Number", payments[i].getTraceNumber());
			    else
				    innerMap.put("ACH Trace Number", "");
			}
			// Reading ACH Trace number for CSR portal
			else {
				 if (payments[i].getTraceNumber() != null)
					innerMap.put("ACH/Payment Status", payments[i].getTraceNumber());
				else
					innerMap.put("ACH/Payment Status", "");
			}
			innerMap.put("Market Type", getDisplayMarketType(payments[i].getPaymentTypeIndicator()));
			
			if(StringUtils.equalsIgnoreCase(testConfig.getRunTimeProperty("portalAccess"), "standard"))
					innerMap.put("Payment Status", "N/A");
			else if (payments[i].getArchiveIndicator() == null
					&& StringUtils.equals("N", testConfig.getRunTimeProperty("ACTIVE_ARCHIVE_PAYMENTS_INDICATOR"))
					|| StringUtils.equals("Show All",
							testConfig.getRunTimeProperty("ACTIVE_ARCHIVE_PAYMENTS_INDICATOR")))
				innerMap.put("Payment Status", getDisplayPaymentStatus(payments[i].getArchiveIndicator()));
			else if (StringUtils.equals(payments[i].getArchiveIndicator(),
					testConfig.getRunTimeProperty("ACTIVE_ARCHIVE_PAYMENTS_INDICATOR")))
				innerMap.put("Payment Status", getDisplayPaymentStatus(payments[i].getArchiveIndicator()));
			else if (StringUtils.equals("Show All", testConfig.getRunTimeProperty("ACTIVE_ARCHIVE_PAYMENTS_INDICATOR")))
				innerMap.put("Payment Status", getDisplayPaymentStatus(payments[i].getArchiveIndicator()));
			else
				innerMap.put("Payment Status", getDisplayPaymentStatus(payments[i].getArchiveIndicator()));

			outerMap.put(innerMap.get("Payment Number") + "_" + innerMap.get("Payment Date"), innerMap);
		}

		// Log.Comment("Details from FISL is: " +outerMap.toString());
		return outerMap;
	}

	/**
	 * Gets the payer name from DB to be displayed on UI
	 * 
	 * @param payerName
	 * @return display payer name
	 */

	public String getDisplayPayerNameFromDB(String payerNameFromFISL) {
		int sqlRowNo = 20;
		testConfig.putRunTimeProperty("payerName", payerNameFromFISL);
		Map payerTable = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		if (payerTable != null)
			return payerTable.get("PAYR_DSPL_NM").toString().trim();

		else if (payerNameFromFISL.toString().equals("Neighborhood Health Partnership Inc"))
			return "Neighborhood Health Partnership";

		else if (payerNameFromFISL.toString().equals("UnitedHealthcare Insurance Company of the River Valley"))
			return "UHC Insurance Company of the River Valley";

		else
			return payerNameFromFISL;

	}

	/**
	 * Converts Market Type From API to name that is displayed on UI
	 * 
	 * @param maketTypeFromFISL
	 * @return maketType to be displayed
	 */
	public String getDisplayMarketType(String maketTypeFromFISL) {
		if (maketTypeFromFISL.equalsIgnoreCase("M"))
			return "Medical";
		else if (maketTypeFromFISL.equalsIgnoreCase("H"))
			return "HRA";
		else if (maketTypeFromFISL.equalsIgnoreCase("Y"))
			return "Patient Payments";
		else if (maketTypeFromFISL.equalsIgnoreCase("W"))
			return "Workers Compensation";
		else if (maketTypeFromFISL.equalsIgnoreCase("P"))
			return "Property and Casualty";
		else if (maketTypeFromFISL.equalsIgnoreCase("O"))
			return "Other";
		else if (maketTypeFromFISL.equalsIgnoreCase("D"))
			return "Dental";
		else if (maketTypeFromFISL.equalsIgnoreCase("S"))
			return "CARES Act - Healthcare Relief Program";

		else
			return maketTypeFromFISL;

	}

	public String getArchiveIndicator(String archiveIndicatorFromFISL) {
		if (archiveIndicatorFromFISL.equalsIgnoreCase("Y"))
			return "true";
		else if (archiveIndicatorFromFISL.equalsIgnoreCase("N"))
			return "false";
		else
			return archiveIndicatorFromFISL;

	}

	public String getDisplayPaymentStatus(String paymentStatusFromFISL) {
		String displayName = "";
		if (paymentStatusFromFISL == null)
			paymentStatusFromFISL = "N";
		switch (paymentStatusFromFISL) {
		case "N":
			displayName = "New";
			break;
		case "Y":
			displayName = "Closed";
			break;
		case "P":
			displayName = "Pending";
			break;
		}
		return displayName;
	}

	/**
	 * Converts Type From API to name that is displayed on UI
	 * 
	 * @param paymentMethodTypefromFISL
	 * @return payment method to be displayed
	 */
	public String getDisplayPaymentMethod(String paymentMethodTypefromFISL) {
		if (paymentMethodTypefromFISL == null || paymentMethodTypefromFISL.equalsIgnoreCase("NON")
				|| paymentMethodTypefromFISL.equalsIgnoreCase("ACH"))
			return "ACH";

		else if (paymentMethodTypefromFISL.equalsIgnoreCase("VCP"))
			return "VCP";

		return "Unidentified";

	}

	public String getRecordCountFromDB() {
		int totalRecord = 0;
		int sqlRowNo = 128;

		Map srchConsolTable = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		totalRecord = totalRecord + Integer.parseInt(srchConsolTable.get("RECORD_COUNT").toString().trim());

		return String.valueOf(totalRecord);
	}

	public int getNumberOfPages() {
		int noOfPages = 0;
		int recordsCount = Integer.parseInt(getRecordCountFromUI());
		if (recordsCount > 30) {
			noOfPages = recordsCount / 30;
			if (recordsCount % 30 > 0)
				noOfPages = noOfPages + 1;
		} else
			noOfPages = 1;
		return noOfPages;
	}

	public int getNumberOfPagesSR() {
		int noOfPages = 0;
		int recordsCount = Integer.parseInt(getRecordCountUISR());
		if (recordsCount > 30) {
			noOfPages = recordsCount / 30;
			if (recordsCount % 30 > 0)
				noOfPages = noOfPages + 1;
		} else
			noOfPages = 1;
		return noOfPages;
	}

	/**
	 * Gets Payment Dates from Payment Results
	 * 
	 * @param columnNo->1
	 * @return
	 * @return list of data
	 * @throws ParseException
	 */
	public List<Date> getPaymentDates() throws ParseException {
		List<Date> listDates = new ArrayList<Date>();
		for (int i = 1; i < searchResultRows.size(); i++) {
			String date = searchResultRows.get(i).findElements(By.tagName("td")).get(1).getText();
			date = date.replace("\n", "");
			listDates.add(new SimpleDateFormat("MM/dd/yyyy").parse(date));
			// listDates.add(Helper.changeStringToDate(date));
		}
		return listDates;

	}

	public void verifyPaymentDateSorting(String sortingOrder) throws ParseException {
		List<Date> actualPaymentDates;
		List<Date> datesListFromUI = new ArrayList<Date>();
		List<Date> expectedPaymentDateList = new ArrayList<Date>();
		if (sortingOrder.contains("Asc")) {
			Log.Comment("Checking payment dates for Ascending order..");
			Element.click(lnkPaymentDate, "Payment Date Link");
			Browser.wait(testConfig, 3);
			actualPaymentDates = getPaymentDates();
			for (Date date : actualPaymentDates) {
				// String dates=Helper.changeDateFormat(date);
				datesListFromUI.add(date);
			}
			Collections.sort(actualPaymentDates);
		}

		else {
			Log.Comment("Checking payment dates for Descending order..");
			actualPaymentDates = getPaymentDates();
			for (Date date : actualPaymentDates) {
				datesListFromUI.add(date);
			}
			Collections.sort(actualPaymentDates, Collections.reverseOrder());
		}
		for (Date date : actualPaymentDates) {
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
	 * @throws JSONException
	 */

	public ViewPayments verifyZeroDollarPayments(String QuickSearch, String FilterPayments, String MarketType,String PaymentStatus)
			throws JAXBException, IOException, SAXException, ParserConfigurationException, JSONException {
		String actualPaymntNo = "";
		String ZeroDollar = "$0.00";
		

		// FISL Response
		EpsPaymentsSummarySearchResponse responseFromFISL = (EpsPaymentsSummarySearchResponse) getFISLResponse(QuickSearch,FilterPayments,MarketType,PaymentStatus);
		EpsConsolidatedClaimPaymentSummaries[] payments = responseFromFISL.getData()
				.getEpsConsolidatedClaimPaymentSummaries();
		totalRecordsFromFISL = String.valueOf(responseFromFISL.getData().getTotalCount());
		int paycount = 	Integer.parseInt(totalRecordsFromFISL);

		for(int i=0;i<paycount;i++) {
			System.out.println(payments[i].getTotalAmount().toString());
			if(payments[i].getTotalAmount().toString().equals("0.0")) {
				
					PaymentNumber = payments[i].getDisplayConsolidatedPaymentNumber();
					break;
			}
			
		}
		
		if(PaymentNumber==null) {
			Log.Fail(testConfig, "Zero doller payement not avilable for selectd TIN", true, false);
		}
		
		int totalNoOfPages = getNumberOfPages();
		
		OUTERLOOP: for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			for (int i = 1; i < searchResultRows.size(); i++) {
				String paymentAmountUI = searchResultRows.get(i).findElements(By.tagName("td")).get(5).getText();
				actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
				actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
				
				if(actualPaymntNo.contains("Check")) {
					actualPaymntNo = actualPaymntNo.substring(0, actualPaymntNo.indexOf("Check"));
				}
				if (PaymentNumber.equals(actualPaymntNo)
						&& paymentAmountUI.equalsIgnoreCase(ZeroDollar)) {
					
					String paymentTypeUI = searchResultRows.get(i).findElements(By.tagName("td")).get(6).getText();					
					Assert.assertEquals(ZeroDollar, paymentAmountUI, "Payment No: "+ PaymentNumber +"is ZeroDollar paymenyt number");
					break OUTERLOOP;
				}
			}

			if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				Log.Comment("Failed payment not found on page number " + pageNo);
				Element.findElement(testConfig, "xpath",
						".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
								+ pageToBeClicked + ")]")
						.click();
				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.waitForLoad(testConfig.driver);
			} else if (pageNo % 10 == 0 && totalNoOfPages != 2 && pageNo < totalNoOfPages) {
				Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.waitForLoad(testConfig.driver);
				Browser.wait(testConfig, 3);
			} else
				Log.Warning("Could not find Zero dollar payment on any of the pages, please execute test case manually",
						testConfig);
		}
	
		return this;
	}

	public ViewPayments payerTin() {

		int sqlRow = 35;

		Map payerDetails = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		String payerTin = payerDetails.get("PROV_TAX_ID_NBR").toString();
		testConfig.putRunTimeProperty("tin", payerTin);

		System.out.println("payerTin: " + payerTin);
		Element.enterData(txtBoxPayerTin, payerTin, "Entered TIN", "Payer Tin");
		Element.click(btnSearch, "Search Button");
		return this;
	}

	public ViewPayments payerTin(String paymentType) {
		ViewPaymentsDataProvider dataProvider = new ViewPaymentsDataProvider(testConfig);
		String tin = "";// dataProvider.getTinForPaymentType(paymentType);
		txtBoxPayerTin = Element.findElement(testConfig, "name", "payerProvTin");
		if (txtBoxPayerTin != null)
			Element.enterData(txtBoxPayerTin, tin, "Entered TIN", "Payer Tin");
		else if (txtBoxPayerTin2 != null)
			Element.enterData(txtBoxPayerTin2, tin, "Entered TIN", "Payer Tin");
		else
			Element.enterData(txtBoxBSTin, tin, "Entered TIN", "BS Tin");

		testConfig.putRunTimeProperty("tin", tin);
		Element.click(btnSearch, "Search Button");
		return this;
	}

	public ViewPayments enterBSTin(String userType, String paymentType) {
		ViewPaymentsDataProvider dataProvider = new ViewPaymentsDataProvider(testConfig);
		String tin = "";// dataProvider.getTinForPaymentType(paymentType);
		dataProvider.associateTinWithUser(userType, tin);
		txtBoxBSTin = Element.findElement(testConfig, "name", "billingProvTin");
		if (txtBoxBSTin != null)
			Element.enterData(txtBoxBSTin, tin, "Entered TIN", "BS Tin");
		else
			Element.enterData(txtboxTinNo, tin, "Entered TIN", "BS Tin");
		testConfig.putRunTimeProperty("tin", tin);
		Element.click(btnSearch, "Search Button");
		return this;
	}

	public Object getFISLResponse(String QuickSearch, String FilterPayments, String MarketType, 
			String PaymentStatus)
			throws JAXBException, IOException, SAXException, ParserConfigurationException, JSONException {
		Object request = null;
		String[] pay_835_id;
		if ("PAY".equals(testConfig.getRunTimeProperty("userType"))) {
			Map data = DataBase.executeSelectQuery(testConfig, QUERY.PAYR_DETAILS_FOR_PAYR_USER, 1);
			pay_835_id = new String[] { data.get("PAYR_835_ID").toString().trim() };
		} else {
			pay_835_id = new String[] {};
		}
		EpsPaymentSearchRequestHelper epsPaymentSearchRequestHelper = new EpsPaymentSearchRequestHelper();
		DOP epn = new DOP();
		epn.setEpsSecondaryPayerReferenceIdentifiers(pay_835_id);
		epn.setTaxIdentifier(testConfig.getRunTimeProperty("tin").trim());
		epn.setUserRole("PROVIDER");
		SearchCriteria searchCriteria = epn.getSearchCriteria();
		ArrayList<ParameterMap> parameterMapList = new ArrayList<>();
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.setKey("PAYMENT_LEVEL_DETAIL");
		parameterMap.setValue("Y");
		parameterMap.setComparator("Equals");
		parameterMapList.add(parameterMap);

		if (!PaymentStatus.equalsIgnoreCase("show all")) {
			parameterMap = new ParameterMap();
			parameterMap.setKey("ACTIVE_ARCHIVE_PAYMENTS_INDICATOR");
			parameterMap.setValue(keyValueForPaymentStatus(PaymentStatus));
			parameterMap.setComparator("Equals");
			parameterMapList.add(parameterMap);
		}
		
		if (!MarketType.equalsIgnoreCase("show all")) {
			parameterMap = new ParameterMap();
			parameterMap.setKey("MARKET_TYPE");
			parameterMap.setValue(keyValueForMarketType(MarketType));
			parameterMap.setComparator("Equals");
			parameterMapList.add(parameterMap);
		}
		
		if (!FilterPayments.equalsIgnoreCase("show all")) {
			parameterMap = new ParameterMap();
			parameterMap.setKey("TAX_IDENTIFIER_TYPE");
			parameterMap.setValue(keyValueForFilterPayments(FilterPayments));
			parameterMap.setComparator("Equals");
			parameterMapList.add(parameterMap);
		}
		searchCriteria.setParameterMap(parameterMapList);

		PaymentMadeOnDateRange paymentMadeOnDateRange = epn.getPaymentMadeOnDateRange();
		paymentMadeOnDateRange.setFromDate(testConfig.getRunTimeProperty("fromDate"));
		paymentMadeOnDateRange.setToDate(testConfig.getRunTimeProperty("toDate"));
		String[] identifiers = new String[] {};
		epn.setEpsNationalProviderIdentifiers(identifiers);
		Log.Comment("Request: " + epn.toString());
		request = epn;
		EpsPaymentsSummarySearchResponse searchResponse = (EpsPaymentsSummarySearchResponse) epsPaymentSearchRequestHelper
				.postRequestGetResponse(request);
		return searchResponse;
	}

	/**
	 * Getting response from EPSA
	 * 
	 * @return type object of search request
	 * @throws JSONException
	 */

	public Object getFISLResponse1()
			throws JAXBException, IOException, SAXException, ParserConfigurationException, JSONException {
		EpsPaymentSearchRequestHelper epsPaymentSearchRequestHelper = new EpsPaymentSearchRequestHelper();
		EpsPaymentsSearchRequest epsPaymentsSearchRequest = epsPaymentSearchRequestHelper.createRequestPojo();

		/** Creates POJO for Request.xml so that we can modify the elements */

		epsPaymentsSearchRequest = setTinNumber(epsPaymentsSearchRequest);
		setToAndFromDate(epsPaymentsSearchRequest);
		setMapEntryKey(epsPaymentsSearchRequest);

		if (testConfig.getRunTimeProperty("835ID") != null)
			setPayerID(epsPaymentsSearchRequest);

		/** Posting the modified request and getting response */
		EpsPaymentsSummarySearchResponse searchResponse = (EpsPaymentsSummarySearchResponse) epsPaymentSearchRequestHelper
				.postRequestGetResponse(epsPaymentsSearchRequest);
		return searchResponse;
	}

	// public Object createRequest() throws JAXBException
	// {
	// EpsPaymentSearchRequestHelper epsPaymentSearchRequestHelper = new
	// EpsPaymentSearchRequestHelper();
	// EpsPaymentsSearchRequest
	// epsPaymentsSearchRequest=epsPaymentSearchRequestHelper.createRequestPojo();
	// return epsPaymentsSearchRequest;
	// }

	public EpsPaymentsSearchRequest setTinNumber(Object object)
			throws JAXBException, IOException, SAXException, ParserConfigurationException {
		((EpsPaymentsSearchRequest) object).setTaxIdentifierNumber(testConfig.getRunTimeProperty("tin").trim());
		return (EpsPaymentsSearchRequest) object;
	}

	public EpsPaymentsSearchRequest setNPINumber(Object object)
			throws JAXBException, IOException, SAXException, ParserConfigurationException {

		((EpsPaymentsSearchRequest) object)
				.setEPSNationalProviderIdentifiers(testConfig.getRunTimeProperty("NPI").trim());
		return (EpsPaymentsSearchRequest) object;
	}

	public EpsPaymentsSearchRequest setToAndFromDate(Object object)
			throws JAXBException, IOException, SAXException, ParserConfigurationException {
		if (testConfig.getRunTimeProperty("fromDate") != null) {
			((EpsPaymentsSearchRequest) object).getPaymentMadeOnDateRange()
					.setFromDate(testConfig.getRunTimeProperty("fromDate"));
			((EpsPaymentsSearchRequest) object).getPaymentMadeOnDateRange()
					.setToDate(testConfig.getRunTimeProperty("toDate"));
		}
		return (EpsPaymentsSearchRequest) object;

	}

	public EpsPaymentsSearchRequest setTaxIdentifierType(Object object)
			throws JAXBException, IOException, SAXException, ParserConfigurationException {
		((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0)
				.setValue(testConfig.getRunTimeProperty("taxIdentifierType"));
		return (EpsPaymentsSearchRequest) object;
	}

	public EpsPaymentsSearchRequest setMapEntryKey(Object object)
			throws JAXBException, IOException, SAXException, ParserConfigurationException {
		if (testConfig.getRunTimeProperty("key") != null) {
			((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0)
					.setKey(testConfig.getRunTimeProperty("key"));
			((SearchByCriteriaRequest) object).getSearchCriteria().getParameterMap().getEntries().get(0)
					.setValue(testConfig.getRunTimeProperty("value"));
		}
		return (EpsPaymentsSearchRequest) object;
	}

	/**
	 * For example, to add a new item, do as follows: *
	 * 
	 * <pre>
	 * getEpsSecondaryPayerReferenceIdentifiers().add(newItem);
	 * </pre>
	 * 
	 */
	public EpsPaymentsSearchRequest setPayerID(Object object)
			throws JAXBException, IOException, SAXException, ParserConfigurationException {

		((EpsPaymentsSearchRequest) object)
				.setEpsSecondaryPayerReferenceIdentifiers(testConfig.getRunTimeProperty("835ID"));
		return (EpsPaymentsSearchRequest) object;

	}

	// Methods related to BS User

	public ViewPayments bsTin(String providerTIN) {
		testConfig.putRunTimeProperty("tin", providerTIN);
		Element.enterData(txtBoxBSTin, providerTIN, "Entered TIN", "Provider Tin");
		Element.click(btnSearch, "Search Button");
		Browser.waitForLoad(testConfig.driver);
		Browser.wait(testConfig, 2);
		return this;
	}

	public Object getSearchResults() {
		try {
			String response = getFislPaymentSearchResponse();
			Object convertedData = convertResponseObject(response);
			return convertedData;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Object convertResponseObject(String response) throws Exception {
		PaymentSummaryFislService service = new PaymentSummaryFislService();
		JAXBElement<com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0.EpsPaymentsSummarySearchResponse> result = (JAXBElement<com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0.EpsPaymentsSummarySearchResponse>) service
				.toObject(response);
		Object fislResponse = result.getValue();
		return fislResponse;
	}

	public String getFislPaymentSearchResponse()
			throws JAXBException, IOException, SAXException, ParserConfigurationException, JSONException {
		String response = "";
		EpsPaymentSearchRequestHelper epsPaymentSearchRequestHelper = new EpsPaymentSearchRequestHelper();
		EpsPaymentsSearchRequest epsPaymentsSearchRequest = epsPaymentSearchRequestHelper.createRequestPojo();
		epsPaymentsSearchRequest = setTinNumber(epsPaymentsSearchRequest);
		setToAndFromDate(epsPaymentsSearchRequest);
		setMapEntryKey(epsPaymentsSearchRequest);
		/** Posting the modified request and getting response */
		response = (String) epsPaymentSearchRequestHelper.postRequestGetResponse(epsPaymentsSearchRequest);
		return response;
	}

	/*
	 * public Map<String, LinkedHashMap<String, String>>
	 * getPaymentDetailsFromFISL(Object searchResult) throws JAXBException,
	 * IOException, SAXException, ParserConfigurationException, ParseException {
	 * PaymentSummaryFislService service= new PaymentSummaryFislService();
	 * 
	 * LinkedHashMap<String,String> innerMap; Map<String,
	 * LinkedHashMap<String,String> > outerMap = new
	 * LinkedHashMap<String,LinkedHashMap<String,String>>();
	 * 
	 * List<EpsConsolidatedClaimPaymentSummary> responseFromFISL=
	 * service.getEpsConsolidatedClaimPaymentSummaries(searchResult);
	 * EpsConsolidatedClaimPaymentSummary[] payments=responseFromFISL.toArray(new
	 * EpsConsolidatedClaimPaymentSummary[responseFromFISL.size()]);
	 * 
	 * int totalPayments;
	 * 
	 * if(Integer.parseInt(service.getTotalCounts(searchResult))>30)
	 * totalPayments=30; else totalPayments=payments.length;
	 * 
	 * for(int i=0;i<totalPayments;i++) { innerMap=new LinkedHashMap<String,
	 * String>();
	 * 
	 * //innerMap.put("Payer",getDisplayPayerNameFromDB(payments[i].getPayerSummary(
	 * ).getName()));
	 * innerMap.put("Payment Date",convertDateFromGregorianToString(payments[i].
	 * getPaymentMadeOn()));
	 * System.out.println(convertDateFromGregorianToString(payments[i].
	 * getPaymentMadeOn()));
	 * 
	 * if(payments[i].getNationalProviderIdentifier()!=null)
	 * innerMap.put("NPI",payments[i].getNationalProviderIdentifier()); else
	 * innerMap.put("NPI","");
	 * 
	 * innerMap.put("Payment Number",payments[i].getDisplayConsolidatedPaymentNumber
	 * ());
	 * 
	 * if(payments[i].getTotalAmount().getValue() == 0 ) {
	 * innerMap.put("Amount","$"+"0.00"); } else { DecimalFormat decimalFormat = new
	 * DecimalFormat("#.00"); String amount =
	 * decimalFormat.format(payments[i].getTotalAmount().getValue());
	 * innerMap.put("Amount","$"+amount); }
	 * 
	 * innerMap.put("Market Type",getDisplayMarketType(payments[i].
	 * getPaymentTypeIndicator())); outerMap.put(innerMap.get("Payment Number"),
	 * innerMap); } Log.Comment("Details from FISL is :" + '\n' +outerMap); return
	 * outerMap; }
	 */

	public void newVerifySearchResultsWithFilters(String filterPayments, String quickSearchFilter, String Archivefilter,
			String MktTypeFilter, Boolean changeDates) throws IOException, InterruptedException, JAXBException,
			SAXException, ParserConfigurationException, ParseException {
		Log.Comment("Setting Filters and drop downs in the view payments page");
		Browser.wait(testConfig, 2);
		newSetSearchFilters(filterPayments, quickSearchFilter, Archivefilter, MktTypeFilter);

		if (Integer.parseInt(newGetRecordCountFromUI()) <= 1) {
			if (changeDates) {
				quickSearchFilter = "Last 4-6 months";
				quickSearchFilter = setQuickSearchFilter(quickSearchFilter, false, 1);
			} else {
				Log.Fail("No payments exist for this TIN");
			}
		}

		Object searchResult = getSearchResults();
		PaymentSummaryFislService service = new PaymentSummaryFislService();
		Log.Comment("Getting the FISL and UI record counts");
		String totalFislRecordCount = service.getTotalCounts(searchResult);
		String totalUiRecordCount = newGetRecordCountFromUI();

		Map<String, LinkedHashMap<String, String>> paymentDetailsFromFISL = getPaymentDetailsFromFISL(searchResult);
		Map<String, LinkedHashMap<String, String>> paymentDetailsFromUI = getPaymentDetailsFromUI();

		paymentDetailsFromFISL = cleanUpAmount(paymentDetailsFromFISL);
		paymentDetailsFromUI = cleanUpAmount(paymentDetailsFromUI);

		Log.Comment("Comparing the FISL and UI Record counts in the view payments page");
		if (!totalFislRecordCount.equalsIgnoreCase("0")) {
			Helper.compareEquals(testConfig, "Record Count from FISL and UI :", totalUiRecordCount,
					totalFislRecordCount);
			Helper.compareEquals(testConfig, "Payment Records from FISL and UI :", paymentDetailsFromFISL,
					paymentDetailsFromUI);
		} else {
			Element.verifyTextPresent(errorMsg, "No payments in FISL have been made to this Organization.");
		}
	}

	private LinkedHashMap<String, LinkedHashMap<String, String>> cleanUpAmount(
			Map<String, LinkedHashMap<String, String>> paymentDetailsFromFISL) {
		LinkedHashMap<String, LinkedHashMap<String, String>> output = new LinkedHashMap();
		for (String key : paymentDetailsFromFISL.keySet()) {
			LinkedHashMap<String, String> data = paymentDetailsFromFISL.get(key);
			if (data.get("Amount").contains("$.")) {
				data.put("Amount", data.get("Amount").replace("$.", "$0."));
			}
			if (data.get("Market Type").equals("D")) {
				data.put("Market Type", "Dental");
			}
			if (data.get("Market Type").equals("M")) {
				data.put("Market Type", "Medical");
			}
			output.put(key, data);
		}
		return output;
	}

	public void newVerifyZeroDollarPayments(String expectedPaymentType)
			throws JAXBException, IOException, SAXException, ParserConfigurationException {
		Boolean foundZeroDollarPayment = false;
		String filterPayments = "Show All";
		String archiveFilter = "Show All";
		String mktTypeFilter = "Show All";
		String quickSearchFilter = "Last 90 days";
		Log.Comment("Setting Filters and drop downs in the view payments page");
		Browser.wait(testConfig, 3);
		setSearchFilters(filterPayments, quickSearchFilter, archiveFilter, mktTypeFilter);

		if (Integer.parseInt(newGetRecordCountFromUI()) <= 1) {
			quickSearchFilter = "Last 4-6 months";
			quickSearchFilter = setQuickSearchFilter(quickSearchFilter, false, 1);
		}

		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);
		Log.Comment("Fetching all payments From UI..");

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			Element.findElements(testConfig, "xpath",
					".//*[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr");

			for (int i = 1; i < searchResultRows.size(); i++) {
				String amount = searchResultRows.get(i).findElements(By.tagName("td")).get(5).getText();
				String paymentType = searchResultRows.get(i).findElements(By.tagName("td")).get(6).getText();
				String paymentStatus = searchResultRows.get(i).findElements(By.tagName("td")).get(7).getText();

				if (amount.equals("$0.00") && paymentType.equals(expectedPaymentType)) {
					Log.Comment("Identified a zero dollar ACH Payment in the view payments page");
					foundZeroDollarPayment = true;
					if (paymentStatus.equals("N/A") == false) {
						Assert.fail("ACH Zero payment not marked N/A as expected");
						return;
					}
				}
			}
			Log.Comment("Navigating to the next page");
			gotoNextPage(pageNo, totalNoOfPages);
		}

		if (foundZeroDollarPayment == false) {
			setQuickSearch(quickSearchFilter);
		}
	}

	public void newVerifyMaximumRecordsInAPage(String quickSearchFilter)
			throws JAXBException, IOException, SAXException, ParserConfigurationException {
		quickSearchFilter = setQuickSearchFilter(quickSearchFilter, true, 0);

		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);
		Log.Comment("Fetching all payments From UI..");

		Log.Comment("Checking to see if there are multiple pages in the view payments page");
		if (totalNoOfPages > 1) {
			// Since the header is also included in the searchResultsRows, the total row
			// count in searchResultRows would be 31. Hence, subtracting 1.
			Log.Comment("Checking to see if there 30 records in a single page");
			int totalRowsInPage = searchResultRows.size() - 1;
			if (totalRowsInPage == 30) {
				Log.Pass("Test case has passed. There are a total of 30 payments displayed on the screen.");
			} else if (totalRowsInPage != 30) {
				Assert.fail("Test case failed, number of records on first page is " + totalRowsInPage);
			}
		} else {
			Assert.fail("Test case failed, the TIN does not have sufficient payments to test this criteria");
		}
	}

	public void newVerifyPagination(String quickSearchFilter)
			throws JAXBException, IOException, SAXException, ParserConfigurationException {
		Log.Comment("Validating pagination in the view payments page");
		quickSearchFilter = setQuickSearchFilter(quickSearchFilter, true, 0);
		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);
		validateViewPaymentsPagination();
	}

	public String setQuickSearchFilter(String quickSearchFilter, Boolean needPagination, int minRecordsRequired) {
		switch (quickSearchFilter) {
		case "Last 30 days":

			if (Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true) {
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			} else {
				int totalNoOfPages = newGetNumberOfPages();
				if (totalNoOfPages <= 1) {
					quickSearchFilter = "Last 60 days";
					Log.Comment("Changing quick search filter to :" + quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter(quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;

		case "Last 60 days":
			setQuickSearch(quickSearchFilter);
			if (Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true) {
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			} else {
				int totalNoOfPages = newGetNumberOfPages();
				if (totalNoOfPages <= 1) {
					quickSearchFilter = "Last 90 days";
					Log.Comment("Changing quick search filter to :" + quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter(quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;

		case "Last 90 days":
			setQuickSearch(quickSearchFilter);
			if (Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true) {
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			} else {
				int totalNoOfPages = newGetNumberOfPages();
				if (totalNoOfPages <= 1) {
					quickSearchFilter = "Last 4-6 months";
					Log.Comment("Changing quick search filter to :" + quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter(quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;

		case "Last 4-6 months":
			setQuickSearch(quickSearchFilter);
			if (Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true) {
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			} else {
				int totalNoOfPages = newGetNumberOfPages();
				if (totalNoOfPages <= 1) {
					quickSearchFilter = "Last 6-9 months";
					Log.Comment("Changing quick search filter to :" + quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter(quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;

		case "Last 6-9 months":
			setQuickSearch(quickSearchFilter);
			if (Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true) {
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			} else {
				int totalNoOfPages = newGetNumberOfPages();
				if (totalNoOfPages <= 1) {
					quickSearchFilter = "Last 9-13 months";
					Log.Comment("Changing quick search filter to :" + quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter(quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;

		case "Last 9-13 months":
			setQuickSearch(quickSearchFilter);
			if (Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true) {
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			} else {
				int totalNoOfPages = newGetNumberOfPages();
				if (totalNoOfPages <= 1) {
					Assert.fail(
							"Test case failed, the TIN does not have sufficient payments to validate this test case. Cannot validate because the number of pages is only "
									+ totalNoOfPages);
				} else {
					return quickSearchFilter;
				}
			}
			break;
		default:
			if (Integer.parseInt(newGetRecordCountFromUI()) >= minRecordsRequired && needPagination != true) {
				setQuickSearchDateRange(quickSearchFilter);
				return quickSearchFilter;
			} else {
				int totalNoOfPages = newGetNumberOfPages();
				if (totalNoOfPages <= 1) {
					quickSearchFilter = "Last 60 days";
					Log.Comment("Changing quick search filter to :" + quickSearchFilter);
					quickSearchFilter = setQuickSearchFilter(quickSearchFilter, needPagination, minRecordsRequired);
					return quickSearchFilter;
				}
			}
			break;
		}
		return quickSearchFilter;
	}

	public String convertDateFromGregorianToString(XMLGregorianCalendar calendar) {
		Date date = calendar.toGregorianCalendar().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String finalResult = sdf.format(date);
		return finalResult;
	}

	public Map<String, LinkedHashMap<String, String>> getPaymentDetailsFromUIFirstPage() {
		/** Gets headers List which will be key for following map */

		LinkedHashMap<String, String> innerMap;

		Map<String, LinkedHashMap<String, String>> outerMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();

		ArrayList<String> headers = getHeadersFromResultTable();

		int totalNoOfPages = getNumberOfPages();

		if (totalNoOfPages > 2)
			totalNoOfPages = 1;

		Log.Comment("Fetching all payments From UI..");

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			Element.findElements(testConfig, "xpath",
					".//*[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr");

			for (int i = 1; i < searchResultRows.size(); i++) {
				innerMap = new LinkedHashMap<String, String>();

				for (int j = 0; j < headers.size(); j++) {
					String details = searchResultRows.get(i).findElements(By.tagName("td")).get(j).getText();
					details = details.replace("\n", "");
					innerMap.put(headers.get(j), details);
				}

				String amount = innerMap.get("Amount").replace(",", "");
				innerMap.put("Amount", amount);
				innerMap.remove("Redemption Date");
				innerMap.remove("Proxy Number");
				innerMap.remove("Payment Status / Trace Number");
				innerMap.remove("Payer");
				innerMap.remove("Type");
				outerMap.put(searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText().replace("\n", ""),
						innerMap);
			}

			if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				WebElement pageLink = Element.findElement(testConfig, "xpath",
						".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
								+ pageToBeClicked + ")]");
				if (pageLink != null)
					pageLink.click();
				else
					Element.findElement(testConfig, "xpath",
							".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
									+ pageToBeClicked + ")]")
							.click();
				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.wait(testConfig, 3);
			} else if (pageNo % 10 == 0 && totalNoOfPages != 2) {
				Browser.wait(testConfig, 1);
				Log.Comment("Page Number is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.wait(testConfig, 3);
				pageNo++;
			}
		}
		Log.Comment("Details from UI is : " + '\n' + outerMap);
		return outerMap;

	}

	/**
	 * This function creates an outer map with Key as payment number and Value as
	 * another hash map i.e. inner map that contains all the details for key like
	 * payer name, amount etc
	 * 
	 * @return Outer map
	 */
	public void validateViewPaymentsPagination() {
		HashSet<String> paymentNumbers = new HashSet<String>();

		int totalNoOfPages = getNumberOfPages();

		Log.Comment("Fetching payments and validating pagination in the UI..");
		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			ArrayList<String> paymentInfo = new ArrayList<String>();
			Integer numberOfPaymentsDisplayedInPage = searchResultRows.size() - 1;

			Log.Comment("Checking to see if there are more 30 records in the page");
			if (pageNo != totalNoOfPages && numberOfPaymentsDisplayedInPage != 30) {
				String msg = numberOfPaymentsDisplayedInPage > 30 ? "more than " : "less than";
				Log.Fail("Test failed. There are " + msg + "30 payments displayed in this page");
			}

			Log.Comment("Checking to see if there are duplicate payments in the page");
			for (int i = 1; i <= numberOfPaymentsDisplayedInPage; i++) {
				String paymentNumber = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
				paymentNumber = paymentNumber.replace("\n", "");
				if (!paymentNumbers.add(paymentNumber)) {
					Log.Fail("Testing Failed, duplicate payment number " + paymentNumber
							+ " found in the UI in the same of different page");
				}
			}
			gotoNextPage(pageNo, totalNoOfPages);
		}
		Log.Pass(
				"Pagination has been validated successfully. No duplicates found and every page has a maximum of 30 payments");
	}

	public void verifyOtherFieldSorting() {
		String quickSearchFilter = "Last 30 days";
		setQuickSearchFilter(quickSearchFilter, false, 5);
		ArrayList<Double> reverseAmountOriginalData = new ArrayList<Double>();
		ArrayList<Boolean> reverseArchiveOriginalData = new ArrayList<Boolean>();
		ArrayList<Double> sortedAmountOriginalData = new ArrayList<Double>();
		ArrayList<Boolean> sortedArchiveOriginalData = new ArrayList<Boolean>();

		ArrayList<String> originalStrData = new ArrayList<String>();
		ArrayList<String> sortedAscStrData = new ArrayList<String>();
		ArrayList<String> sortedDescStrData = new ArrayList<String>();

		int[] strColumns = { 0, 2, 3, 6, 9 };
		int[] numColumns = { 5 };
		int[] boolColumns = { 12 };

		String ascMessage = "Sorting the column in ascending order :";
		String descMessage = "Sorting the column in descending order :";

		HashMap<Integer, Object> originalData = getMultipleColumnValues(strColumns, numColumns, boolColumns);

		Log.Comment(ascMessage + " Payer");
		originalStrData = (ArrayList<String>) originalData.get(0);
		Collections.sort(originalStrData);
		SortElement(lnkPayer);
		sortedAscStrData = getAnyStringColumnValues(0);
		Helper.compareEquals(testConfig, "View Payments Payer Sorted Ascending", originalStrData, sortedAscStrData);

		Log.Comment(descMessage + " Payer");
		SortElement(lnkPayer);
		Collections.sort(originalStrData, Collections.reverseOrder());
		sortedDescStrData = getAnyStringColumnValues(0);
		Helper.compareEquals(testConfig, "View Payments Payer Sorted Descending", originalStrData, sortedDescStrData);

		originalStrData = new ArrayList<String>();
		sortedAscStrData = new ArrayList<String>();
		sortedDescStrData = new ArrayList<String>();

		Log.Comment(ascMessage + " NPI");
		originalStrData = (ArrayList<String>) originalData.get(2);
		Collections.sort(originalStrData);
		SortElement(lnkNPI);
		sortedAscStrData = getAnyStringColumnValues(2);
		Helper.compareEquals(testConfig, "View Payments NPI Sorted Ascending", originalStrData, sortedAscStrData);

		Log.Comment(descMessage + " NPI");
		SortElement(lnkNPI);
		Collections.sort(originalStrData, Collections.reverseOrder());
		sortedDescStrData = getAnyStringColumnValues(2);
		Helper.compareEquals(testConfig, "View Payments NPI Sorted Descending", originalStrData, sortedDescStrData);

		originalStrData = new ArrayList<String>();
		sortedAscStrData = new ArrayList<String>();
		sortedDescStrData = new ArrayList<String>();

		Log.Comment(ascMessage + " Payment Number");
		originalStrData = (ArrayList<String>) originalData.get(3);
		SortElement(lnkPaymentNumber);
		Collections.sort(originalStrData);
		sortedAscStrData = getAnyStringColumnValues(3);
		Helper.compareEquals(testConfig, "View Payments Payment Number Sorted Ascending", originalStrData,
				sortedAscStrData);

		Log.Comment(descMessage + " Payment Number");
		SortElement(lnkPaymentNumber);
		Collections.sort(originalStrData, Collections.reverseOrder());
		sortedDescStrData = getAnyStringColumnValues(3);
		Helper.compareEquals(testConfig, "View Payments Payment Number Sorted Descending", originalStrData,
				sortedDescStrData);

		originalStrData = new ArrayList<String>();
		sortedAscStrData = new ArrayList<String>();
		sortedDescStrData = new ArrayList<String>();

		Log.Comment(ascMessage + " Type");
		originalStrData = (ArrayList<String>) originalData.get(6);
		SortElement(lnkType);
		Collections.sort(originalStrData);
		sortedAscStrData = getAnyStringColumnValues(6);
		Helper.compareEquals(testConfig, "View Payments Payments Type Sorted Ascending", originalStrData,
				sortedAscStrData);

		Log.Comment(descMessage + " Type");
		SortElement(lnkType);
		Collections.sort(originalStrData, Collections.reverseOrder());
		sortedDescStrData = getAnyStringColumnValues(6);
		Helper.compareEquals(testConfig, "View Payments Payments Type Sorted Descending", originalStrData,
				sortedDescStrData);

		originalStrData = new ArrayList<String>();
		sortedAscStrData = new ArrayList<String>();
		sortedDescStrData = new ArrayList<String>();

		Log.Comment(ascMessage + " Market Type");
		originalStrData = (ArrayList<String>) originalData.get(9);
		SortElement(lnkMarketType);
		Collections.sort(originalStrData);
		sortedAscStrData = getAnyStringColumnValues(9);
		Helper.compareEquals(testConfig, "View Payments Market Type Sorted Ascending", originalStrData,
				sortedAscStrData);

		Log.Comment(descMessage + " Market Type");
		SortElement(lnkMarketType);
		Collections.sort(originalStrData, Collections.reverseOrder());
		sortedDescStrData = getAnyStringColumnValues(9);
		Helper.compareEquals(testConfig, "View Payments Market Type Sorted Descending", originalStrData,
				sortedDescStrData);

		Log.Comment(ascMessage + " Amount");
		ArrayList<Double> amountOriginalData = (ArrayList<Double>) originalData.get(5);
		Collections.sort(amountOriginalData);
		SortElement(lnkAmount);
		sortedAmountOriginalData = getAnyNumericColumnValues(5);
		Helper.compareEquals(testConfig, "View Payments Amount Sorted Ascending", amountOriginalData,
				sortedAmountOriginalData);

		Log.Comment(descMessage + "Amount");
		SortElement(lnkAmount);
		reverseAmountOriginalData = getAnyNumericColumnValues(5);
		Collections.sort(amountOriginalData, Collections.reverseOrder());
		Helper.compareEquals(testConfig, "View Payments Amount Sorted Descending", amountOriginalData,
				reverseAmountOriginalData);

		Log.Comment(ascMessage + " Archive");
		ArrayList<Boolean> archiveOriginalData = (ArrayList<Boolean>) originalData.get(12);
		Collections.sort(archiveOriginalData);
		SortElement(lnkArchive);
		sortedArchiveOriginalData = getAnyBooleanColumnValues(12);
		Helper.compareEquals(testConfig, "View Payments Archived Sorted Ascending", archiveOriginalData,
				sortedArchiveOriginalData);

		Log.Comment(descMessage + " Archive");
		SortElement(lnkArchive);
		Collections.sort(archiveOriginalData, Collections.reverseOrder());
		reverseArchiveOriginalData = getAnyBooleanColumnValues(12);
		Helper.compareEquals(testConfig, "View Payments Archived Sorted Descending", archiveOriginalData,
				reverseArchiveOriginalData);

	}

	public HashMap<Integer, Object> getMultipleColumnValues(int[] strColumns, int[] numColumns, int[] boolColumns) {
		HashMap<Integer, Object> returnData = new HashMap<Integer, Object>();
		HashMap<Integer, ArrayList<String>> strData = new HashMap<Integer, ArrayList<String>>();
		HashMap<Integer, ArrayList<Double>> numData = new HashMap<Integer, ArrayList<Double>>();
		HashMap<Integer, ArrayList<Boolean>> boolData = new HashMap<Integer, ArrayList<Boolean>>();

		if (strColumns != null) {
			for (int column : strColumns) {
				strData.put(column, new ArrayList<String>());
			}
		}

		if (numColumns != null) {
			for (int column : numColumns) {
				numData.put(column, new ArrayList<Double>());
			}
		}

		if (boolColumns != null) {
			for (int column : boolColumns) {
				boolData.put(column, new ArrayList<Boolean>());
			}
		}

		ArrayList<String> data = new ArrayList<String>();
		int totalNoOfPages = getNumberOfPages();

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			for (int i = 1; i < searchResultRows.size(); i++) {
				if (strColumns != null) {
					for (int column : strColumns) {
						String value = searchResultRows.get(i).findElements(By.tagName("td")).get(column).getText();
						strData.get(column).add(value);
					}
				}

				if (numColumns != null) {
					for (int column : numColumns) {

						Double value = Double.valueOf(searchResultRows.get(i).findElements(By.tagName("td")).get(column)
								.getText().replace("$", "").replace(",", "").replace("\n", "").trim());
						numData.get(column).add(value);
					}
				}

				if (boolColumns != null) {
					for (int column : boolColumns) {
						Boolean value = searchResultRows.get(i).findElements(By.tagName("td")).get(column).isSelected();
						boolData.get(column).add(value);
					}
				}
			}
			gotoNextPage(pageNo, totalNoOfPages);
		}

		if (strColumns != null) {
			for (Integer key : strData.keySet()) {
				returnData.put(key, strData.get(key));
			}
		}

		if (numColumns != null) {
			for (Integer key : numData.keySet()) {
				returnData.put(key, numData.get(key));
			}
		}

		if (boolColumns != null) {
			for (Integer key : boolData.keySet()) {
				returnData.put(key, boolData.get(key));
			}
		}

		return returnData;
	}

	public ArrayList<String> getAnyStringColumnValues(int columnNumber) {
		ArrayList<String> data = new ArrayList<String>();
		int totalNoOfPages = getNumberOfPages();

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			for (int i = 1; i < searchResultRows.size(); i++) {
				String values = searchResultRows.get(i).findElements(By.tagName("td")).get(columnNumber).getText();
				data.add(values);
			}
			gotoNextPage(pageNo, totalNoOfPages);
		}
		return data;
	}

	public ArrayList<Double> getAnyNumericColumnValues(int columnNumber) {
		ArrayList<Double> data = new ArrayList<Double>();
		int totalNoOfPages = getNumberOfPages();

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			for (int i = 1; i < searchResultRows.size(); i++) {
				Double values = Double.valueOf(searchResultRows.get(i).findElements(By.tagName("td")).get(columnNumber)
						.getText().replace("$", "").replace(",", "").replace("\n", "").trim());
				data.add(values);
			}
			gotoNextPage(pageNo, totalNoOfPages);
		}
		return data;
	}

	public ArrayList<Boolean> getAnyBooleanColumnValues(int columnNumber) {
		ArrayList<Boolean> data = new ArrayList<Boolean>();
		int totalNoOfPages = getNumberOfPages();

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			for (int i = 1; i < searchResultRows.size(); i++) {
				Boolean values = searchResultRows.get(i).findElements(By.tagName("td")).get(columnNumber).isSelected();
				data.add(values);
			}
			gotoNextPage(pageNo, totalNoOfPages);
		}
		return data;
	}

	public void setQuickSearch(String quickSearchFilter) {
		Element.selectByVisibleText(drpDwnQuickSearch, quickSearchFilter,
				quickSearchFilter + " " + " from 'Quick Search' dropdown");
		Browser.waitForLoad(testConfig.driver);
		Browser.wait(testConfig, 3);
	}

	public void setQuickSearchDateRange(String quickSearchFilter) {
		String split[] = quickSearchFilter.split(" ");
		if (split[split.length - 1].contains("days")) {
			int LastNoOfdays = Integer.parseInt(split[split.length - 2]);
			testConfig.putRunTimeProperty("fromDate", Helper.getDateBeforeOrAfterDays(-LastNoOfdays, "yyyy-MM-dd"));
			testConfig.putRunTimeProperty("toDate", Helper.getCurrentDate("yyyy-MM-dd"));
		} else {
			String monthRange = (split[split.length - 2]);
			Map<String, String> startAndEndDates = Helper.getStartAndEndPeriod(monthRange);
			testConfig.putRunTimeProperty("fromDate", startAndEndDates.get("fromDate").toString());
			testConfig.putRunTimeProperty("toDate", startAndEndDates.get("toDate").toString());
		}
	}

	public void gotoFirstPage() {
		WebElement firstPage = Element.findElement(testConfig, "xpath",
				".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),'First Page')]");
		if (firstPage != null) {
			firstPage.click();
			Browser.wait(testConfig, 3);
		}
	}

	public void gotoNextPage(int pageNo, int totalNoOfPages) {
		if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
			int pageToBeClicked = pageNo + 1;
			Element.findElement(testConfig, "xpath",
					"//div[@id='view-payments']/table//tr[1]/td/div[2]/div[2]/span/a[contains(text()," + pageToBeClicked
							+ ")]")
					.click();
			Log.Comment("Clicked Page number : " + pageToBeClicked);
			Browser.waitForLoad(testConfig.driver);
		} else if (pageNo % 10 == 0 && totalNoOfPages != 2 && pageNo < totalNoOfPages) {
			Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
			Element.click(lnkNextPage, "Next Link");
			Browser.waitForLoad(testConfig.driver);
		}
		Browser.wait(testConfig, 3);
	}

	public void SortElement(WebElement element) {
		gotoFirstPage();
		element.click();
		Browser.wait(testConfig, 3);
	}

	public void verifyBSRemitPaymentPopUp() {
		String paymentType = "remitPayment";
		String actualPaymntNo = "";

		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			for (int i = 1; i < searchResultRows.size(); i++) {
				WebElement element = Element.findElement(testConfig, "xpath",
						"//*[@id=\"paymentsummaryform\"]/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]");
				String content = element.getAttribute("innerHTML");
				if (content.contains("<span")) {
					Element.onMouseHover(testConfig, element,
							"Payment details have been suppressed for this payment since we have not received remittance information from the payer");
				}
			}
			gotoNextPage(pageNo, totalNoOfPages);
		}
	}

	/**
	 * gets the record count
	 * 
	 * @return number of payments
	 */
	public String newGetRecordCountFromUI() {
		try {
			if (!testConfig.driver.getPageSource().contains("No payments have been made to this Organization")) {
				String recordCountElement[] = recordCount.getText().split(":");
				return recordCountElement[recordCountElement.length - 1].trim();
			} else {
				return "0";
			}
		} catch (Exception e) {
			return "0";
		}

	}

	public int newGetNumberOfPages() {
		int noOfPages = 0;
		int recordsCount = Integer.parseInt(newGetRecordCountFromUI());
		if (recordsCount > 30) {
			noOfPages = recordsCount / 30;
			if (recordsCount % 30 > 0)
				noOfPages = noOfPages + 1;
		} else if (recordsCount % 30 >= 1) {
			noOfPages = 1;
		}

		return noOfPages;
	}

	/**
	 * Finds if a failed Payment is displayed on payment summary page if yes, hovers
	 * mouse over 'Failed Payment' text and verifies that a pop appears and verifies
	 * in it
	 */
	public void verifyFailedPaymentPopUp(String quickSearchFilter) {
		newSetSearchFilters(null, quickSearchFilter, "Show All", null);
		String paymentStatus = "";
		String totalNoOfPayments = newGetRecordCountFromUI();

		if (totalNoOfPayments.equals("0")) {
			quickSearchFilter = "Last 4-6 months";
			quickSearchFilter = setQuickSearchFilter(quickSearchFilter, false, 1);
		}

		int totalNoOfPages = newGetNumberOfPages();
		Boolean foundFailedPayment = false;
		Boolean checkedAllPageOptions = false;
		Log.Comment("Total No. of pages are :" + totalNoOfPages);

		while (foundFailedPayment != true && checkedAllPageOptions != true) {
			totalNoOfPages = newGetNumberOfPages();

			for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
				if (testConfig.driver.getPageSource().contains("Failed")) {
					for (int i = 1; i < searchResultRows.size(); i++) {
						paymentStatus = searchResultRows.get(i).findElements(By.tagName("td")).get(7).getText();
						paymentStatus = paymentStatus.replace("\n", "");
						if (paymentStatus.equals("Failed")) {
							foundFailedPayment = true;
							Element.onMouseHover(testConfig,
									searchResultRows.get(i).findElements(By.tagName("td")).get(7),
									"Failed Payment with payment number : "
											+ searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText());

							Log.Warning("Please validate this test case manually. ", testConfig);

							break;
						}
					}
				} else {
					gotoNextPage(pageNo, totalNoOfPages);
				}
			}

			if (foundFailedPayment == false) {
				switch (quickSearchFilter) {
				case "Last 90 days":
					quickSearchFilter = "Last 4-6 months";
					setQuickSearch(quickSearchFilter);
					break;
				case "Last 4-6 months":
					quickSearchFilter = "Last 6-9 months";
					setQuickSearch(quickSearchFilter);
					break;
				case "Last 6-9 months":
					quickSearchFilter = "Last 9-13 months";
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

	public ViewPayments newSetSearchFilters(String filterPayments, String quickSearchFilter, String Archivefilter,
			String MktTypeFilter) {
		if (filterPayments != null) {
			Element.selectByVisibleText(drpDwnFilterPayments, filterPayments,
					filterPayments + " " + " from 'Filter payments' dropdown");
			Browser.waitForLoad(testConfig.driver);
			Browser.wait(testConfig, 2);
		}

		if (quickSearchFilter != null) {
			Element.selectByVisibleText(drpDwnQuickSearch, quickSearchFilter,
					quickSearchFilter + " " + " from 'Quick Search' dropdown");
			getQuickSearchDates(quickSearchFilter);
			Browser.waitForLoad(testConfig.driver);
			Browser.wait(testConfig, 2);
		} else {
			quickSearchFilter = "Last 30 days";
			getQuickSearchDates(quickSearchFilter);
		}

		if (Archivefilter != null) {
			Element.selectByVisibleText(drpDwnArchiveFilter, Archivefilter,
					Archivefilter + " " + " from 'Archive payments' dropdown");
			Browser.waitForLoad(testConfig.driver);
			Browser.wait(testConfig, 2);
		}

		if (MktTypeFilter != null) {
			Element.selectByVisibleText(drpDwnMarketType, MktTypeFilter,
					MktTypeFilter + " " + " from 'Market Type' dropdown");
			Browser.waitForLoad(testConfig.driver);
			Browser.wait(testConfig, 2);
		}
		return this;
	}

	/**
	 * This function creates an outer map with Key as payment number and Value as
	 * another hash map i.e. inner map that contains all the details for key like
	 * payer name, amount etc
	 * 
	 * @return Outer map
	 * @throws IOException
	 */
	public ViewPayments verifyPayerRolePayments() throws IOException {

		ArrayList<String> payerListFromDB = new ArrayList<String>();
		/*
		 * List<String> payerListFromUI = new ArrayList<String>(); /*HashMap<Integer,
		 * HashMap<String, String>> payerMapFromDB =
		 * DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		 * 
		 * for (int i = 1; i <= payerMapFromDB.size(); i++) {
		 * payerListFromDB.add(payerMapFromDB.get(i).get("PAYR_NM"));
		 * payerListFromDB.add(payerMapFromDB.get(i).get("PAYR_DSPL_NM"));
		 * payerListFromDB.add(payerMapFromDB.get(i).get("SUB_PAYR_NM"));
		 * payerListFromDB.add(payerMapFromDB.get(i).get("SUB_PAYR_DSPL_NM")); }
		 * 
		 * Set<String> payersWithoutDuplicates = new
		 * LinkedHashSet<String>(payerListFromDB);
		 * 
		 * payerListFromDB.clear(); payerListFromDB.addAll(payersWithoutDuplicates);
		 */

		HashMap<Integer, HashMap<String, String>> payerMapFromDB = DataBase.executeSelectQueryALL(testConfig, 176);
		for (int i = 1; i <= payerMapFromDB.size(); i++) {
			payerListFromDB.add(payerMapFromDB.get(i).get("SUB_PAYR_DSPL_NM"));
		}
		payerMapFromDB.clear();
		payerMapFromDB = DataBase.executeSelectQueryALL(testConfig, 177);

		for (int i = 1; i <= payerMapFromDB.size(); i++) {
			payerListFromDB.add(payerMapFromDB.get(i).get("PAYR_DSPL_NM"));
		}

		Map<String, LinkedHashMap<String, String>> detailsFromUI = getPayerDetailsFromUI();

		for (Map.Entry<String, LinkedHashMap<String, String>> map : detailsFromUI.entrySet()) {
			if ((payerListFromDB).contains(map.getValue().get("Payer").toString()))
				Log.Pass("Verified Payer is  UnitedHealthcare ( " + map.getValue().get("Payer").toString()
						+ " ) for payment number : " + map.getKey());
			else
				Log.Fail("Payer is NOT UnitedHealthcare, it is " + map.getValue().get("Payer").toString()
						+ "for payment number : " + map.getKey());
		}

		/*
		 * for( Entry<String, LinkedHashMap<String, String>> entry :
		 * getPayerDetailsFromUI().entrySet() ){ LinkedHashMap<String, String> innerMap=
		 * new LinkedHashMap<String,String>();
		 * 
		 * innerMapKey=entry.getKey(); innerMap = entry.getValue();
		 * 
		 * Set<String> keys = innerMap.keySet();
		 * 
		 * for(String k:keys){ if(k.equalsIgnoreCase("Payer")){
		 * payerListFromUI.add(innerMap.get(k)); } } }
		 * 
		 * for (String payer : payerListFromUI) { if (payerListFromDB.contains(payer)) {
		 * Log.Pass("Payment is for " + payer ); } else { Log.Fail(payer + " :" + " " +
		 * "not present in DB"); } }
		 */
		return this;
	}

	public Map<String, LinkedHashMap<String, String>> getPayerDetailsFromUI() {
		LinkedHashMap<String, String> innerMap;
		Map<String, LinkedHashMap<String, String>> outerMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		ArrayList<String> headers = getHeadersFromResultTable();
		int totalNoOfPages = getNumberOfPages();

		if (totalNoOfPages > 2)
			totalNoOfPages = 1;

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			Element.findElements(testConfig, "xpath",
					".//*[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr");

			for (int i = 1; i < searchResultRows.size(); i++) {
				innerMap = new LinkedHashMap<String, String>();
				String details = searchResultRows.get(i).findElements(By.tagName("td")).get(0).getText();
				details = details.replace("\n", "");
				innerMap.put(headers.get(0), details);
				outerMap.put(searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText().replace("\n", ""),
						innerMap);
			}

			if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				WebElement pageLink = Element.findElement(testConfig, "xpath",
						".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
								+ pageToBeClicked + ")]");
				if (pageLink != null)
					pageLink.click();
				else
					Element.findElement(testConfig, "xpath",
							".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
									+ pageToBeClicked + ")]")
							.click();
				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.wait(testConfig, 3);
			} else if (pageNo % 10 == 0 && totalNoOfPages != 2) {
				Browser.wait(testConfig, 1);
				Log.Comment("Page Number is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.wait(testConfig, 3);
				pageNo++;
			}
		}
		return outerMap;
	}

	public ViewPayments verifyMktType(String marketType)
			throws JAXBException, IOException, SAXException, ParserConfigurationException, JSONException {
		String archiveFilter = "Show All";
		String dateToValidate = testConfig.getRunTimeProperty("setlDate");
		setSearchFilters(archiveFilter, getQuickSearchFilterCriteria(dateToValidate), archiveFilter, marketType);

		// FISL Response
		EpsPaymentsSummarySearchResponse responseFromFISL = (EpsPaymentsSummarySearchResponse) getFISLResponse(marketType, marketType, marketType, marketType);
		EpsConsolidatedClaimPaymentSummaries[] payments = responseFromFISL.getData()
				.getEpsConsolidatedClaimPaymentSummaries();
		Log.Comment("Total no.of payments with " + marketType + "filter are  :"
				+ responseFromFISL.getData().getTotalCount());

		if (getNumberOfPages() > 1)
			Log.Comment("Verifying market type for top 30 payments");

		// Verifying for 30 payments hence taken 1 page
		for (int pageNo = 1; pageNo <= 1; pageNo++) {
			for (int i = 1; i < searchResultRows.size(); i++) {
				Log.Comment("Verifying Market type for Payment No: "
						+ payments[i - 1].getDisplayConsolidatedPaymentNumber());
				Helper.compareContains(testConfig, "Market Type",
						getDisplayMarketType(payments[i - 1].getPaymentTypeIndicator()),
						searchResultRows.get(i).findElements(By.tagName("td")).get(9).getText());
			}
		}

		return this;
	}

	public RemittanceDetail clickPaymentNumber(String srchType) {

		String actualPaymntNo = "";
		String expectedPaymntNo = "";
		boolean found = false;
		int i = 1;

		if (srchType.equals("byDOPAndNpi") || srchType.equals("EPRADOPAndNpi")) {
			expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
			System.setProperty("DSPL_CONSL_PAY_NBR", expectedPaymntNo);
			searchResultRows = Element.findElements(testConfig, "xpath",
					"//form[@id='searchRemittanceResultsForm']/table//tr[8]/td/table/tbody/tr/td/table/tbody/tr");

		} else if (srchType.equals("byElectronicPaymentNo") || srchType.equals("EPRAElectronicPaymentNo")) {
			expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
			System.setProperty("DSPL_CONSL_PAY_NBR", expectedPaymntNo);
			searchResultRows = Element.findElements(testConfig, "xpath",
					"//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr");
		} else if (srchType.equals("EPRAViewPay") || srchType.equals("EPRABSViewPay")) {
			expectedPaymntNo = testConfig.getRunTimeProperty("dspl_consl_pay_nbr");
			System.setProperty("CONSL_PAY_NBR", expectedPaymntNo);
			// searchResultRows=Element.findElements(testConfig, "xpath",
			// "//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr");
		} else if (srchType.equals("View Payments")) {
			expectedPaymntNo = testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
		} else {
			i = 2;
			expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
			System.setProperty("DSPL_CONSL_PAY_NBR", expectedPaymntNo);
			searchResultRows = Element.findElements(testConfig, "xpath", "//div[@id='SearchHeader']//tr");
		}

		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);
		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {

			if (srchType.equals("byDOPAndNpi") || srchType.equals("EPRADOPAndNpi")) {
				expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
				searchResultRows = Element.findElements(testConfig, "xpath",
						"//form[@id='searchRemittanceResultsForm']/table//tr[8]/td/table/tbody/tr/td/table/tbody/tr");
			} else if (srchType.equals("byElectronicPaymentNo") || srchType.equals("EPRAElectronicPaymentNo")) {
				expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
				searchResultRows = Element.findElements(testConfig, "xpath",
						"//form[@id='searchRemittanceResultsForm']/table//tr[7]/td/table/tbody/tr/td/table/tbody/tr");
			} else if (srchType.equals("EPRAViewPay") || srchType.equals("EPRABSViewPay")) {
				searchResultRows = Element.findElements(testConfig, "xpath",
						"//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr");
				expectedPaymntNo = testConfig.getRunTimeProperty("dspl_consl_pay_nbr");
				if (expectedPaymntNo.length() >= 15)
					expectedPaymntNo = expectedPaymntNo.substring(0, 15);
				Log.Comment("The DSP_CONSL_PAY_NBR is :" + expectedPaymntNo);
			} else if (srchType.equals("View Payments")) {
				// searchResultRows=Element.findElements(testConfig, "xpath",
				// "//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr");

				// searchResultRows=Element.findElements(testConfig, "xpath",
				// "//*[@id='view-payments']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]");

				expectedPaymntNo = testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
				if (expectedPaymntNo.length() >= 15)
					expectedPaymntNo = expectedPaymntNo.substring(0, 15);
				Log.Comment("The DSP_CONSL_PAY_NBR is :" + expectedPaymntNo);
			} else {
				i = 2;
				expectedPaymntNo = System.getProperty("ELECTRONIC_PAYMENT_NUMBER");
				searchResultRows = Element.findElements(testConfig, "xpath", "//div[@id='SearchHeader']//tr");
			}

			if (testConfig.driver.getPageSource().toString().contains(expectedPaymntNo) && !found) {
				for (; i < searchResultRows.size(); i++) {
					// if(srchType.equals("viewPayments"))
					if (srchType.equals("EPRAViewPay") || srchType.equals("EPRABSViewPay")) {
						String xpath = "//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr["
								+ (i + 1) + "]/td[4]";
						actualPaymntNo = Element.findElement(testConfig, "xpath", xpath).getText();
					} else {
						actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
						actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
					}

					Log.Comment("The Actual Payment no is:" + actualPaymntNo);
					Log.Comment("The expected Payment no is:" + expectedPaymntNo);
					WebElement lnkPaymntNo = null;
					if (actualPaymntNo.contains(expectedPaymntNo)) {

						if (srchType.equals("EPRAViewPay") || srchType.equals("EPRABSViewPay")) {
							String xpath1 = "//form[@id='paymentsummaryform']/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr["
									+ (i + 1) + "]/td[4]/a";
							lnkPaymntNo = Element.findElement(testConfig, "xpath", xpath1);
						} else {
							lnkPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3)
									.findElement(By.tagName("a"));
						}
						Browser.scrollTillAnElement(testConfig, lnkPaymntNo,
								"Payment No. :" + lnkPaymntNo.getText() + " found on the page");
						Element.waitForElementTobeClickAble(testConfig, lnkPaymntNo, 60);
						Element.clickByJS(testConfig, lnkPaymntNo, "Payment No. :" + lnkPaymntNo.getText());
						found = true;
						Browser.wait(testConfig, 5);

						break;
					}
				}
			}
			if (found == true)
				break;

			else if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				Log.Comment("Payment Number not found on page number " + pageNo);
				System.out.println("The Page to be Clciked is :" + pageToBeClicked);

				// if(srchType.equals("viewPayments"))
				if (srchType.equals("EPRAViewPay") || srchType.equals("EPRABSViewPay"))
					Element.findElement(testConfig, "xpath",
							".//*[@id='paymentsummaryform']/table[1]/tbody/tr[4]/td/span//a[contains(text(),"
									+ pageToBeClicked + ")]")
							.click();
				else
					// Element.findElement(testConfig,"xpath","//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/span/a[contains(text(),"
					// + pageToBeClicked + ")]").click();
					Element.findElement(testConfig, "xpath",
							"//*[@id='view-payments']/table/tbody/tr[1]/td/div[2]/div[2]/span/a[contains(text(),"
									+ pageToBeClicked + ")]")
							.click();
				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.waitForLoad(testConfig.driver);

			}

			else if (pageNo % 10 == 0 && totalNoOfPages != 2 && pageNo < totalNoOfPages) {
				Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.waitForLoad(testConfig.driver);
				Browser.wait(testConfig, 3);

			} else
				Log.Fail("Unable to identify Payment Number");

		}
		return new RemittanceDetail(testConfig);
	}

	public ViewPayments verifyQuickSrchFilterOptions() {
		
		List<String> quickSrchOptions = new ArrayList<>(Arrays.asList("Last 30 days", "Last 60 days", "Last 90 days",
				"Last 4-6 months", "Last 6-9 months", "Last 9-13 months"));
		
		Element.verifyElementPresent(drpDwnQuickSearch, "Quick Search");
		String defaultVal = Element.getFirstSelectedOption(testConfig, drpDwnQuickSearch, "text");
		Helper.compareEquals(testConfig, "Default value of Quick Search filter", "Last 30 days", defaultVal);
	
			List<String> drpDownOptionsUI = Element.getAllOptionsInSelect(testConfig, drpDwnQuickSearch);
			Helper.compareEquals(testConfig, "Options of Quick Search Filter", quickSrchOptions, drpDownOptionsUI);
		
		return this;
	}

	public ViewPayments verifyPaymentStatusFilter(String portalAccess) {
		
		String label = lblPaymentStatusProv.getText().trim();
		Helper.compareEquals(testConfig, "Payment Status filter label", "Payment Status", label);
		Element.verifyElementPresent(drpDwnArchiveFilter, "Payment Status");

		if (portalAccess.equalsIgnoreCase("Standard")) {
			drpDwnArchiveFilter = Element.findElement(testConfig, "id", "archiveFilterType");
			Helper.compareEquals(testConfig, "Payment Status dropdown disablity", "true",
					drpDwnArchiveFilter.getAttribute("disabled"));
		}

		else if (portalAccess.equalsIgnoreCase("Premium")) {
			String defaultVal = Element.getFirstSelectedOption(testConfig, drpDwnArchiveFilter, "text");
			Helper.compareEquals(testConfig, "Default value of Payment Status filter", "New", defaultVal);
			List<String> paymntStatusOptions = new ArrayList<>(Arrays.asList("New", "Pending", "Closed", "Show All"));
			List<String> drpDownOptionsUI = Element.getAllOptionsInSelect(testConfig, drpDwnArchiveFilter);
			Helper.compareEquals(testConfig, "Options of Payment Status Filter", paymntStatusOptions, drpDownOptionsUI);
		}
		return this;
	}

	public ViewPayments verifyColumnPresent(String columnName) {
		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		if (tblHeader.contains(columnName))
			Log.Pass("Passed : " + columnName + " is present on Page in table Headers.");
		else
			Log.Fail("Failed : " + columnName + " is not present on Page in table Headers.");
		return this;
	}

	public ViewPayments verifyColumnIsNotPresent(String columnName) {
		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		if (tblHeader.contains(columnName))
			Log.Fail("Failed : " + columnName + " is present on Page in table Headers.");
		else
			Log.Pass("Passed : " + columnName + " is not present on Page in table Headers.");
		return this;
	}

	public void verifyClaimCountHyperlink(String columnName, String SearchCriteria) {
		WebElement claimCount = null;
		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		int columnIndex = tblHeader.indexOf(columnName);
		String actualPaymntNo = "";
		String expectedPaymntNo = testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
		Log.Comment("Expected Payment number is: " + expectedPaymntNo);
		boolean found = false;
		WebElement link = null;
		int totalNoOfPages = getNumberOfPagesSR();
		int i = 1;
		if (SearchCriteria.equals("Search Remittance")) {
			searchResultRows = Element.findElements(testConfig, "xpath",
					"//form[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr[2]");
			i = 0;
		}
		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			if (TestBase.driver.getPageSource().toString().contains(expectedPaymntNo)) {
				// verify if claim count is 0, hyperlink is not present and if its not 0 then
				// click
				for (; i < searchResultRows.size(); i++) {
					actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
					actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
					if (actualPaymntNo.contains(expectedPaymntNo)) {
						found = true;
						claimCount = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex);
						if (claimCount.getText().toString().equals("0")) {
							try {
								link = claimCount.findElement(By.tagName("a"));
							} catch (ElementNotVisibleException e) {
								Log.Pass("Claim count is 0 and hyperlink is not present");
							}
							break;
						} else if (!claimCount.getText().toString().equals("0")) {
							link = claimCount.findElement(By.tagName("a"));
							Element.verifyElementPresent(link, "Claim count link is present");
							Element.click(link, "Claim count hyperlink");
							Browser.wait(testConfig, 3);
							Helper.compareEquals(testConfig, "Text Compare",
									Element.findElement(testConfig, "xpath",
											"//div[@id='onlyplb']/table/tbody/tr[1]/td/table/tbody/tr[1]/td").getText(),
									"Remittance Detail");
							if (SearchCriteria.equals("Search Remittance"))
								Element.click(
										Element.findElement(testConfig, "xpath",
												"//input[@value='Return to Search Results']"),
										"Return to search results");
							break;
						}
					}
				}
			}
			if (found == true)
				break;
			gotoNextPage(pageNo, totalNoOfPages);
		}
	}

	public ViewPayments verify835EPRAlink() {
		String actualPaymntNo = "";
		String expectedPaymntNo = testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
		Log.Comment("Expected electronic payment number is: " + expectedPaymntNo);
		boolean found = false;
		WebElement link = null;
		WebElement epraLink = null;
		int totalNoOfPages = getNumberOfPages();

		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		int columnIndex = tblHeader.indexOf("835 / EPRA");

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			if (TestBase.driver.getPageSource().toString().contains(expectedPaymntNo)) {
				for (int i = 1; i < searchResultRows.size(); i++) {
					actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
					actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
					if (actualPaymntNo.contains(expectedPaymntNo)) {
						found = true;
						epraLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex)
								.findElements(By.tagName("td")).get(0);
						link = epraLink.findElement(By.tagName("a"));
						Element.verifyElementPresent(link, "835 link is present");

						epraLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex)
								.findElements(By.tagName("td")).get(2);
						link = epraLink.findElement(By.tagName("span"));
						if (link.getText().toString().contains("PDF"))
							Helper.compareEquals(testConfig, "EPRA", "PDF", link.getText().toString());
						else if (link.getText().toString().contains("N/A"))
							Helper.compareEquals(testConfig, "EPRA", "N/A", link.getText().toString());
						else {
							link = epraLink.findElement(By.tagName("img"));
							Element.verifyElementPresent(link, "EPRA pdf link");
						}

						columnIndex = tblHeader.indexOf("Payer PRA");
						epraLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex + 3);// .findElements(By.tagName("td")).get(0);
						link = epraLink.findElement(By.tagName("span"));
						if (link.getText().toString().contains("PDF"))
							Helper.compareEquals(testConfig, "PPRA", "PDF", epraLink.getText().toString());
						else if (link.getText().toString().contains("N/A"))
							Helper.compareEquals(testConfig, "PPRA", "N/A", link.getText().toString());
						else {
							link = epraLink.findElement(By.tagName("img"));
							Element.verifyElementPresent(link, "PPRA pdf link");
						}
					}
					if (found == true)
						break;
				}
			}

			if (found == true)
				break;
			gotoNextPage(pageNo, totalNoOfPages);
		}
		return this;
	}

	public ViewPayments verifySavArchbtnNotPresent() {
		String label = btnSave.getAttribute("value").trim();
		Helper.compareEquals(testConfig, "Save button relabeled", "Save", label);
		if (Element.findElement(testConfig, "xpath", "//*[contains(text(),'Save Archieve')]") == null)
			Log.Pass("\b Pass: Save Archieve button is not present");
		return this;

	}

	public ViewPayments verifySaveBtnDisplay(String portalAccess) {
		if ("Standard".equals(portalAccess))
			Element.verifyElementNotPresent(testConfig, "id", "savePaymentArchive", "Save Button");
		return this;

	}

	public ViewPayments verifyColumnValuesNA() {
		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		searchResultRows = Element.findElements(testConfig, "xpath",
				"//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr");

		Helper.compareEquals(testConfig, "Values compared Claim Count", "N/A",
				searchResultRows.get(1).findElements(By.tagName("td")).get(tblHeader.indexOf("Claim Count")).getText());
		if (searchResultRows.get(1).findElements(By.tagName("td")).get(tblHeader.indexOf("835 / EPRA"))
				.findElements(By.tagName("td")).get(0).getText().equals("835")) {
			Log.Pass("Passed comparison of 835 label");
			Helper.compareEquals(testConfig, "Values compared EPRA", "N/A",
					searchResultRows.get(1).findElements(By.tagName("td")).get(tblHeader.indexOf("835 / EPRA"))
							.findElements(By.tagName("td")).get(2).getText());
			Helper.compareEquals(testConfig, "Values compared pPRA", "N/A", searchResultRows.get(1)
					.findElements(By.tagName("td")).get(tblHeader.indexOf("Payer PRA") + 3).getText());
			Helper.compareEquals(testConfig, "Values compared Payment Status", "N/A", searchResultRows.get(1)
					.findElements(By.tagName("td")).get(tblHeader.indexOf("Payment Status") + 3).getText());
		} else if (searchResultRows.get(1).findElements(By.tagName("td")).get(tblHeader.indexOf("835 / EPRA")).getText()
				.equals("N/A")) {
			Log.Pass("Passed comparison of 835/EPRA label as: " + searchResultRows.get(1).findElements(By.tagName("td"))
					.get(tblHeader.indexOf("835 / EPRA")).getText());
			Helper.compareEquals(testConfig, "Values compared pPRA", "N/A", searchResultRows.get(1)
					.findElements(By.tagName("td")).get(tblHeader.indexOf("Payer PRA")).getText());
			Helper.compareEquals(testConfig, "Values compared Payment Status", "N/A", searchResultRows.get(1)
					.findElements(By.tagName("td")).get(tblHeader.indexOf("Payment Status")).getText());
		} else
			Log.Fail("Failed comparison of 835 label");

		Helper.compareEquals(testConfig, "Payment Status  dropdown disablity", "true",
				drpDwnArchiveFilter.getAttribute("disabled"));
		Helper.compareEquals(testConfig, "Payment Status  dropdown disablity", null, searchResultRows.get(1)
				.findElements(By.tagName("td")).get(tblHeader.indexOf("Payment Status")).getAttribute("disabled"));
		return this;
	}

	public ViewPayments selectTinNverfyPagRfrsh() {

		String tin = testConfig.getRunTimeProperty("tin") + " - Enrolled";
		List<String> tinList = Element.getAllOptionsInSelect(testConfig, drpDwnTin);
		tinList.remove(0);
		for (String Tin : tinList) {
			if (!Tin.equals(tin)) {
				int sqlrowno = 1609;
				testConfig.putRunTimeProperty("StandardTin", Tin.substring(0, 9));
				Map standardTin = DataBase.executeSelectQuery(testConfig, sqlrowno, 1);
				if (standardTin != null) {
					Element.selectByVisibleText(drpDwnTin, standardTin.get("PROV_TIN_NBR").toString() + " - Enrolled",
							" Selected Tin is : " + standardTin.get("PROV_TIN_NBR").toString());
					Browser.waitForLoad(testConfig.driver);
					break;
				} else {
					Log.Comment("Insert any Standard TIN from backend");
				}
			}
		}

		verifyQuickSrchFilterOptions();
		verifyPaymentStatusFilter("Standard");

		return this;
	}

	public ViewPayments verify835EPRAlink(String SearchCriteria) {
		String actualPaymntNo = "";
		String expectedPaymntNo = testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
		boolean found = false;
		WebElement link = null;
		WebElement epraLink = null;
		int totalNoOfPages = getNumberOfPagesSR();

		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		int columnIndex = tblHeader.indexOf("835 / EPRA");
		if (SearchCriteria.equals("Search Remittance"))
			searchResultRows = Element.findElements(testConfig, "xpath",
					"//form[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/table/tbody/tr/td/table/tbody/tr[2]");

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			if (TestBase.driver.getPageSource().toString().contains(expectedPaymntNo)) {
				for (int i = 0; i < searchResultRows.size(); i++) {
					actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
					actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
					if (actualPaymntNo.equals(expectedPaymntNo)) {
						epraLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex)
								.findElements(By.tagName("td")).get(0);
						link = epraLink.findElement(By.tagName("a"));
						Element.verifyElementPresent(link, "835 link is present");

						epraLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex)
								.findElements(By.tagName("td")).get(2);
						link = epraLink.findElement(By.tagName("a"));
						Element.verifyElementPresent(link, "EPRA link is present");

						columnIndex = tblHeader.indexOf("Payer PRA");
						link = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex + 3);
						Element.verifyElementPresent(link, "pPRA link is present");
					}
				}
			}
			if (found == true)
				break;
			gotoNextPage(pageNo, totalNoOfPages);
		}
		return this;
	}

	public ViewPayments verifyPaymentStatusColumnDropdwn() {
		String actualPaymntNo = "";
		String expectedPaymntNo = testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
		Log.Comment("Expected Payment number is " + expectedPaymntNo);
		boolean found = false;
		int totalNoOfPages = getNumberOfPages();
		WebElement drpDwnPaymntStatusCol = null;
		List<String> paymntStatusOptions = new ArrayList<>(Arrays.asList("New", "Pending", "Closed"));
		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		int columnIndex = tblHeader.indexOf("Payment Status");
		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			if (TestBase.driver.getPageSource().toString().contains(expectedPaymntNo)) {
				for (int i = 1; i < searchResultRows.size(); i++) {
					actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
					actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
					if (actualPaymntNo.contains(expectedPaymntNo)) {
						found = true;
						drpDwnPaymntStatusCol = searchResultRows.get(i).findElements(By.tagName("td"))
								.get(columnIndex + 4).findElement(By.tagName("select"));
						Helper.compareEquals(testConfig, "Options comparison", paymntStatusOptions,
								Element.getAllOptionsInSelect(testConfig, drpDwnPaymntStatusCol));
						changeAndVerifyPaymentStatus(expectedPaymntNo, drpDwnPaymntStatusCol, columnIndex);
					}
					if (found == true)
						break;
				}
			}
			if (found == true)
				break;
			gotoNextPage(pageNo, totalNoOfPages);
		}
		if (found == false)
			Log.Fail("Payment number not found on page");
		return this;
	}

	private void changeAndVerifyPaymentStatus(String expectedPaymntNo, WebElement drpDwnPaymntStatusCol,
			int columnIndex) {
		String actualPaymntNo;
		String defaultVal = "";
		Element.selectByVisibleText(drpDwnPaymntStatusCol, "Closed", "Choose Closed from dropdown");
		Element.click(btnSave, "Save button");
		Browser.wait(testConfig, 2);
		Element.selectByVisibleText(drpDwnArchiveFilter, "Closed", "Closed option from payment filter dropdown");
		Browser.wait(testConfig, 2);
		searchResultRows = Element.findElements(testConfig, "xpath",
				"//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr");
		for (int j = 1; j < searchResultRows.size(); j++) {
			actualPaymntNo = searchResultRows.get(j).findElements(By.tagName("td")).get(3).getText();
			actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
			if (actualPaymntNo.contains(expectedPaymntNo)) {
				drpDwnPaymntStatusCol = searchResultRows.get(j).findElements(By.tagName("td")).get(columnIndex + 4)
						.findElement(By.tagName("select"));
				defaultVal = Element.getFirstSelectedOption(testConfig, drpDwnPaymntStatusCol, "value");

				int sqlRowNo = 1506;
				Map results = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
				Helper.compareEquals(testConfig, "Payment Status indicator", results.get("ARCHV_IND"), defaultVal);
				break;
			}
		}
	}

	public ViewPayments clickPrintPaymentBtn() {
		Browser.wait(testConfig, 3);
		Element.click(btnPrntPaymntSummary, "Payment Summary Button");
		return this;
	}

	public ViewPayments verifyPrintPaymentSummaryPage() throws JAXBException, IOException, SAXException,
			ParserConfigurationException, ParseException, JSONException {
		String parentWin = Browser.switchToNewWindow(testConfig);
		Browser.waitForPageLoad(TestBase.driver);
		PrintButton.isDisplayed();
	//	FISLResponse was read already while verifying the View Payments screen, to avoid calling the FISL request multiple time written below if condition. 
		if(FISLResponse.equals(null)) {
			FISLResponse = getPaymentDetailsFromFISL(searchResponse);
		}
		UIResponse = getPaymentDetailsFromUI();
		Helper.compareMaps(testConfig, "Payments Details Comparison", FISLResponse,
				UIResponse);
		Browser.switchToParentWindow(testConfig, parentWin);
		return this;
	}

	public ViewPayments clickGrayedClaimCount() {
		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		int columnIndex = tblHeader.indexOf("Claim Count");
		Browser.wait(testConfig, 1);
		Element.clickByJS(testConfig, searchResultRows.get(1).findElements(By.tagName("td")).get(columnIndex),
				"Grayed Claim Count");
		return this;
	}

	public ViewPayments verifyPopUp(String userType) {
		Element.verifyElementPresent(popUpViewPay, "View Payments PopUp");
		String popUptext = "";

		switch (userType) {

		case "PROV_Admin":
			popUptext = "Activate Optum Pay for broader, deeper data\nMultiple features on this page, including the PDF remittance documents, are not available without activating Optum Pay.";
			Helper.compareEquals(testConfig, "Pop Up Text", popUptext, popUpViewPay.getText().toString());
			break;

		case "PROV_Gen":
			popUptext = "Activate Optum Pay for broader, deeper data\nMultiple features on this page, including the PDF remittance documents, are not available without activating Optum Pay. Ask your administrator to activate Optum Pay.";
			Helper.compareEquals(testConfig, "Pop Up Text", popUptext, popUpViewPay.getText().toString());
			Element.verifyElementNotPresent(btnGetStarted, "Get Started button");
			break;

		case "BS_Admin":
			popUptext = "Activate Optum Pay for broader, deeper data\nMultiple features on this page, including the PDF remittance documents, are not available without activating Optum Pay. Contact your provider client for access.";
			Helper.compareEquals(testConfig, "Pop Up Text", popUptext, popUpViewPay.getText().toString());
			Element.verifyElementNotPresent(btnGetStarted, "Get Started button");
			break;

		case "BS_Gen":
			popUptext = "Activate Optum Pay for broader, deeper data\nMultiple features on this page, including the PDF remittance documents, are not available without activating Optum Pay. Contact your provider client for access.";
			Helper.compareEquals(testConfig, "Pop Up Text", popUptext, popUpViewPay.getText().toString());
			Element.verifyElementNotPresent(btnGetStarted, "Get Started button");
			break;
		}

		return this;
	}

	public ViewPayments clickGetStarted() {
		Element.verifyElementPresent(popUpViewPay, "View Payments PopUp");
		Element.click(btnGetStarted, "Get started button");
		return this;
	}

	public ViewPayments verifyGetStartedModal() {
		Element.verifyElementPresent(popUpGetStarted, "Bring More power to you");
		Element.clickByJS(testConfig, btnNoThnx, "No Thanx Button");
		Element.verifyElementNotPresent(popUpGetStarted, "Bring More power to you");
		clickGrayedClaimCount();
		Element.clickByJS(testConfig, btnGetStarted, "Get Started button");
		Element.clickByJS(testConfig, btnIAccept, "I Accept Button");
		return this;
	}

	public ViewPayments verifyPrdctSlctnTbl() {
		int sqlRowNo = 1509;
		Map prdctSelection = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "Product Selection Active Record", "A",
				prdctSelection.get("PRTL_PRDCT_SELECTED_STS_CD"));
		return this;
	}

	public ViewPayments clickCloseOnPopUp() {
		Element.clickByJS(testConfig, btnClosePopup, "Close Pop Up");
		Element.verifyElementNotPresent(popUpViewPay, "View Payments PopUp");
		return this;
	}

	public ViewPayments validateSinglePaymentPageData()
			throws JAXBException, IOException, SAXException, ParserConfigurationException, ParseException {
		ArrayList<String> headers = getUIValuesForSinglePaymentPage();
		testConfig.putRunTimeProperty("page", "printPaymentSummary");
		clickPrintPaymentBtn();
		String parentWin = Browser.switchToNewWindow(testConfig);
		ArrayList<String> headersPop = getUIValuesForSinglePaymentPage();

		Browser.switchToParentWindow(testConfig, parentWin);
		Helper.compareEquals(testConfig, "Single payment Summary and print payment Summary ", headers, headersPop);
		return this;
	}

	public ViewPayments verifyFeeAmountDash() {
		String actualPaymntNo = "";
		String expectedPaymntNo = testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");
		String conslpayno = testConfig.getRunTimeProperty("CONSL_PAY_NBR");
		boolean found = false;
		int totalNoOfPages = getNumberOfPages();
		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		int columnIndex = tblHeader.indexOf("Fee Amount");
		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			if (TestBase.driver.getPageSource().toString().contains(expectedPaymntNo)) {
				for (int i = 1; i < searchResultRows.size(); i++) {
					actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
					actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
					if (actualPaymntNo.contains(expectedPaymntNo)) {
						found = true;
						String feeAmountUI = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex)
								.getText().toString();
						int sqlRowNo = 1121;// 1510;
						Map results = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
						if (results == null)
							Helper.compareEquals(testConfig, "Fee Amount on View Payments", "-", feeAmountUI);
						else
							Helper.compareEquals(testConfig, "Fee Amount on View Payments",
									"$" + results.get("DBT_FEE_ACCRD_AMT"), feeAmountUI);
					}
					if (found == true)
						break;
				}
			}
			if (found == true)
				break;
			else
				gotoNextPage(pageNo, totalNoOfPages);
		}
		if (found == false)
			Log.Fail("Payment number not found on page");
		return this;
	}

	public ViewPayments verifyMessages(String credentials, String trialStatus, String paidOption) {

		if (credentials.equalsIgnoreCase("PROV_Admin")) {
			credentials.substring(0, 4);
			testConfig.putRunTimeProperty("Maj_Cat", credentials.substring(5).toUpperCase());
		}
		if (credentials.equalsIgnoreCase("PROV_Gen")) {
			credentials.substring(0, 4);
			testConfig.putRunTimeProperty("Maj_Cat", "GENERAL");
		}
		if (trialStatus.equalsIgnoreCase("WithinTrial")) {
			testConfig.putRunTimeProperty("Cont_NM", "TR");
		}
		if (trialStatus.equalsIgnoreCase("PostTrial")) {
			testConfig.putRunTimeProperty("Cont_NM", "PT");
		}
		if (paidOption.equals("NotPaid") && !testConfig.getRunTimeProperty("tinType").equals("VO")) {
			testConfig.putRunTimeProperty("Min_Cat", "STANDARD");
		}
		if (paidOption.equals("Paid") && !testConfig.getRunTimeProperty("tinType").equals("VO")) {
			testConfig.putRunTimeProperty("Min_Cat", "PREMIUM");
		}
		if (testConfig.getRunTimeProperty("tinType").equals("VO")) {
			testConfig.putRunTimeProperty("Min_Cat", "VCP");
		}
		int sqlRowNo = 1621;
		Map messages = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		String msg = messages.get("CLOBVAL").toString();
		String UITextheader = Element.findElement(testConfig, "xpath", "//div[@id='view-payments-tabs']/div[1]/h2")
				.getText();
		Helper.compareContains(testConfig, "UI vs DB header ", UITextheader, msg);

		String UIText = Element.findElement(testConfig, "xpath", "//div[@id='view-payments-tabs']/div[1]/p[2]")
				.getText();
		if (paidOption.equals("NotPaid") && !testConfig.getRunTimeProperty("tinType").equals("VO")) {
			Helper.compareContains(testConfig, "UI vs DB ", UIText.substring(0, 119), msg);
			Helper.compareContains(testConfig, "UI vs DB ", UIText.substring(120), msg);
		}
		if (paidOption.equals("Paid") || testConfig.getRunTimeProperty("tinType").equals("VO")) {
			Helper.compareContains(testConfig, "UI vs DB text", UIText, msg);
		}
		if (paidOption.equals("NotPaid") && trialStatus.equalsIgnoreCase("PostTrial")
				&& !testConfig.getRunTimeProperty("tinType").equals("VO")) {

			// Click on Grey Area and compare messages
			WebElement greyArea = null;
			greyArea = searchResultRows.get(1).findElements(By.tagName("td")).get(6);
			Element.clickByJS(testConfig, greyArea, "GreyArea Portion clicked");

			int sqlRowNoPopup = 1623;
			if (credentials.equalsIgnoreCase("PROV_Admin")) {
				testConfig.putRunTimeProperty("Sub_Cat", "txt.VIEWP-POP-004");
			} else if (credentials.equalsIgnoreCase("PROV_Gen")) {
				testConfig.putRunTimeProperty("Sub_Cat", "txt.VIEWP-POP-003");
			}
			Map messagespopUp = DataBase.executeSelectQuery(testConfig, sqlRowNoPopup, 1);
			String msgPopup = messagespopUp.get("CLOBVAL").toString();

			// String UITextheader=Element.findElement(testConfig, "xpath",
			// "//div[@id='view-payments-tabs']/div[1]/h2").getText();
			// Helper.compareContains(testConfig, "UI vs DB header ", UITextheader, msg);
			//
			// String UIText=Element.findElement(testConfig, "xpath",
			// "//div[@id='view-payments-tabs']/div[1]/p[2]").getText();
			//

			String UIpopUPTextheader = Element.findElement(testConfig, "xpath", "//*[@id='viewPaymentsPremium']/h2")
					.getText();
			Helper.compareContains(testConfig, "UI vs DB popup header ", UIpopUPTextheader, msgPopup);
			String popUpUIText = Element.findElement(testConfig, "xpath", "//*[@id='viewPaymentsPremium']/p[2]")
					.getText();

			Helper.compareContains(testConfig, "UI vs DB popup ", popUpUIText, msgPopup);
			// Helper.compareContains(testConfig, "UI vs DB popup ",
			// popUpUIText.substring(79), msg);

		}
		return this;
	}

	public ViewPayments clickpPRAlink() {

		String actualPaymntNo = "";
		String expectedPaymntNo = "";
		boolean found = false;
		int i = 1;
		int totalNoOfPages = getNumberOfPages();
		Log.Comment("Total No. of pages are :" + totalNoOfPages);
		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {

			expectedPaymntNo = testConfig.getRunTimeProperty("dsp_consl_pay_nbr");
			if (expectedPaymntNo.length() >= 15)
				expectedPaymntNo = expectedPaymntNo.substring(0, 15);
			Log.Comment("The DSP_CONSL_PAY_NBR is :" + expectedPaymntNo);
			if (testConfig.driver.getPageSource().toString().contains(expectedPaymntNo) && !found) {
				for (; i < searchResultRows.size(); i++) {

					actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
					actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
					Log.Comment("The Actual Payment no is:" + actualPaymntNo);
					Log.Comment("The expected Payment no is:" + expectedPaymntNo);
					WebElement lnkPaymntNo = null;
					if (actualPaymntNo.contains(expectedPaymntNo)) {
						found = true;
						lnkPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3)
								.findElement(By.tagName("a"));
						WebElement lnkppraPdf = null;
						// if(testConfig.getRunTimeProperty("testSuite").equals("UPA"))
						if (System.getProperty("Application").contains("UPA"))
							lnkppraPdf = Element.findElement(testConfig, "xpath",
									"//div[@id='view-payments']/table/tbody/tr[2]/td/table/tbody/tr[" + (i + 1)
											+ "]/td[13]/table/tbody/tr/td/span/a");
						// lnkppraPdf=Element.findElement(testConfig, "xpath",
						// "//div[@id='view-payments']/table/tbody/tr[2]/td/table/tbody/tr["+(i+1)+"]/td[13]/table/tbody/tr/td[3]");

						// if(testConfig.getRunTimeProperty("testSuite").equals("CSR"))
						if (System.getProperty("Application").contains("CSR"))
							// lnkppraPdf=Element.findElement(testConfig, "xpath",
							// "//div[@id='view-payments']/table/tbody/tr[2]/td/table/tbody/tr["+(i+1)+"]/td[15]/table/tbody/tr/td/span/a");
							lnkppraPdf = Element.findElement(testConfig, "xpath",
									"//div[@id='view-payments']/table/tbody/tr[2]/td/table/tbody/tr[" + (i + 1)
											+ "]/td[16]/table/tbody/tr/td/span/a");

						Browser.scrollTillAnElement(testConfig, lnkppraPdf,
								"Ppra Link found for Display Consolidated No. :" + actualPaymntNo);
						Element.verifyElementPresent(lnkppraPdf, "PPRA pdf Link");

						Element.waitForElementTobeClickAble(testConfig, lnkppraPdf, 60);
						Element.clickByJS(testConfig, lnkppraPdf, "PDF Link for PPRA");
						if (testConfig.getRunTimeProperty("testSuite").equals("UPA")) {
							String oldWindow = Browser.switchToNewWindow(testConfig, "PPRADisplayWindow");
							// WebElement msg=Element.findElement(testConfig, "xpath",
							// "//div[@id='message1']/b");

							Browser.switchToParentWindow(testConfig, oldWindow);
						}
						Browser.wait(testConfig, 5);
						break;
					}
				}
			}
			if (found == true)
				break;

			else if (pageNo % 10 != 0 && pageNo < totalNoOfPages) {
				int pageToBeClicked = pageNo + 1;
				Log.Comment("Payment Number not found on page number " + pageNo);
				System.out.println("The Page to be Clciked is :" + pageToBeClicked);
				// Element.findElement(testConfig,"xpath","//*[@id='searchRemittanceResultsForm']/table/tbody/tr[7]/td/span/a[contains(text(),"
				// + pageToBeClicked + ")]").click();
				Element.findElement(testConfig, "xpath",
						"//*[@id='view-payments']/table/tbody/tr[1]/td/div[2]/div[2]/span/a[contains(text(),"
								+ pageToBeClicked + ")]")
						.click();

				Log.Comment("Clicked Page number : " + pageToBeClicked);
				Browser.waitForLoad(testConfig.driver);
			}

			else if (pageNo % 10 == 0 && totalNoOfPages != 2 && pageNo < totalNoOfPages) {
				Log.Comment("Page Number is " + pageNo + " which is multiple of 10..so clicking Next");
				Element.click(lnkNextPage, "Next Link");
				Browser.waitForLoad(testConfig.driver);
				Browser.wait(testConfig, 3);

			} else
				Log.Fail("Unable to identify Payment Number");

		}
		return this;
	}

	public ViewPayments verifyPPRA_Status() {
		int sqlRowNo = 1625;
		Map ppraStatusTbl = null;

		ppraStatusTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		if (ppraStatusTbl.get("SETL_DT").toString().isEmpty() || ppraStatusTbl.get("PROV_TIN_NBR").toString().isEmpty()
				|| ppraStatusTbl.get("DSPL_CONSL_PAY_NBR").toString().isEmpty())
			Log.Fail("One of the Column SETL_DT or PROV_TIN_NBR or DSPL_CONSL_PAY_NBR is empty");
		else
			Log.Pass("Record Inserted in PPRA_STATUS Table");

		int sqldeleteRow = 1626;
		DataBase.executeDeleteQuery(testConfig, 1626);
		return this;
	}

	public void verifyAllOtherDrpDwns() throws Exception {
		String[] arr = { "Last 30 days", "Last 60 days", "Last 90 days", "Last 4-6 months", "Last 6-9 months",
				"Last 9-13 months" };

		for (String s : arr) {
			Browser.wait(testConfig, 5);
			Element.selectVisibleText(quickSearch, s, "Quick Search from View Payments");
			Browser.wait(testConfig, 5);

			try {

				if (!errormsg.isDisplayed()) {
					System.out.println("Error Message is not displayed");
					break;
				}
			} catch (NoSuchElementException e) {
				break;
			}
		}

		Element.selectVisibleText(marketTyp, "Show All", "Market Type from View Payments");
		Log.Comment("Market Type Dropdown Selected: Show All");
		Browser.wait(testConfig, 7);

		Element.selectVisibleText(payerDrpDown, "Show All", "Payer Dropdown from View Payments");
		Log.Comment("PayerDrpDown Dropdown Selected: Show All");
		Browser.wait(testConfig, 5);

		Element.selectVisibleText(archiveDrpDwn, "Show All", "Active/Archived Payments Dropdown from View Payments");
		Log.Comment("Active/Archived Payments Dropdown Selected: Show All");
		Browser.wait(testConfig, 5);

		Element.selectVisibleText(filterDrpDown, "Show All", "Filter Payments Dropdown from View Payments");
		Log.Comment("Filter Payments Dropdown Selected: Show All");
		Browser.wait(testConfig, 5);

	}

	public void verifyAllOtherDrpDwnsinUPA() throws Exception {

		String[] arr = { "Last 30 days", "Last 60 days", "Last 90 days", "Last 4-6 months", "Last 6-9 months",
				"Last 9-13 months" };

		for (String s : arr) {
			Element.selectVisibleText(quickSearch, s, "Quick Search from View Payments");

			try {

				if (!errormsg.isDisplayed())
					break;
			} catch (NoSuchElementException e) {
				break;
			}

			Element.selectVisibleText(marketTyp, "Show All", "Market Type from View Payments");
			Log.Comment("Market Type Dropdown Selected: Show All");

			Element.selectVisibleText(filterDrpDown, "Show All", "Filter Payments Dropdown from View Payments");
			Log.Comment("Filter Payments Dropdown Selected: Show All");

		}
	}

	public void verifyAllColumnsViewPay(String TimePeriod) {

		String[] arr = { "Last 30 days", "Last 60 days", "Last 90 days", "Last 4-6 months", "Last 6-9 months",
				"Last 9-13 months" };

		if (TimePeriod.equals("Last 30 days"))
			Element.selectVisibleText(quickSearch, "Last 30 days", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 60 days"))
			Element.selectVisibleText(quickSearch, "Last 60 days", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 90 days"))
			Element.selectVisibleText(quickSearch, "Last 90 days", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 4-6 months"))
			Element.selectVisibleText(quickSearch, "Last 4-6 months", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 6-9 months"))
			Element.selectVisibleText(quickSearch, "Last 6-9 months", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 9-13 months"))
			Element.selectVisibleText(quickSearch, "Last 9-13 months", "Quick Search from View Payments");

		Element.selectVisibleText(marketTyp, "Show All", "Market Type from View Payments");
		Log.Comment("Market Type Dropdown Selected: Show All");

		Element.selectVisibleText(filterDrpDown, "Show All", "Filter Payments Dropdown from View Payments");
		Log.Comment("Filter Payments Dropdown Selected: Show All");
		Element.selectVisibleText(activeDrpDown, "Show All", "Payments type Dropdown from View Payments");
		Log.Comment("Payments Type Dropdown Selected: Show All");
	}

	public void verifyAllOtherDrpDwnsinUPAPayer() throws Exception {

		String[] arr = { "Last 30 days", "Last 60 days", "Last 90 days", "Last 4-6 months", "Last 6-9 months",
				"Last 9-13 months" };

		for (String s : arr) {
			Element.selectVisibleText(quickSearch, s, "Quick Search from View Payments");

			try {

				if (!errormsg.isDisplayed())
					break;
			} catch (NoSuchElementException e) {
				break;
			}

			Element.selectVisibleText(marketTyp, "Show All", "Market Type from View Payments");
			Log.Comment("Market Type Dropdown Selected: Show All");

			Element.selectVisibleText(filterDrpDown, "Show All", "Filter Payments Dropdown from View Payments");
			Log.Comment("Filter Payments Dropdown Selected: Show All");

		}
	}

	public void verifyPaymentNumberHypherLinkClaimDtl() throws Exception {

		Element.click(paymentNumHyper, "Payment Number Hyper Link");
		Browser.wait(testConfig, 5);

		Boolean filterDrpDownUI = filterDrpDown.isDisplayed();
		Helper.compareEquals(testConfig, "Filter Payments Drop Down", true, filterDrpDownUI);

		Boolean quickSearchUI = quickSearch.isDisplayed();
		Helper.compareEquals(testConfig, "Quick Search Drop Down", true, quickSearchUI);

		Boolean marketTypUI = marketTyp.isDisplayed();
		Helper.compareEquals(testConfig, "Market Type Drop Down", true, marketTypUI);

		Boolean activeDrpDownUI = activeDrpDown.isDisplayed();
		Helper.compareEquals(testConfig, "Active/Archived Payments Drop Down", true, activeDrpDownUI);

		Boolean payerHeaderUI = payerHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Payer Header", true, payerHeaderUI);

		Boolean npiHeaderUI = npiHeader.isDisplayed();
		Helper.compareEquals(testConfig, "NPI Header", true, npiHeaderUI);

		Boolean paymentNumUI = paymentNum.isDisplayed();
		Helper.compareEquals(testConfig, "Payment Number Header", true, paymentNumUI);

		Boolean proxyNumUI = proxyNum.isDisplayed();
		Helper.compareEquals(testConfig, "Proxy Number Header", true, proxyNumUI);

		Boolean amountHeaderUI = amountHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Amount Header", true, amountHeaderUI);

		Boolean typeHeaderUI = typeHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Type Header", true, typeHeaderUI);

		Boolean paymentStatusHeaderUI = paymentStatusHeader.isDisplayed();
		Helper.compareEquals(testConfig, "PaymentStatus Header", true, paymentStatusHeaderUI);

		Boolean redemptionHeaderUI = redemptionHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Redemption Date Header", true, redemptionHeaderUI);

		Boolean marketTypeHeaderUI = marketTypeHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Market Type Header", true, marketTypeHeaderUI);

		Boolean updatedHeaderUI = updatedHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Updated Payment Date Header", true, updatedHeaderUI);

		Boolean resendHeaderUI = resendHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Resend Payment Header", true, resendHeaderUI);

		Boolean epraHeaderUI = epraHeader.isDisplayed();
		Helper.compareEquals(testConfig, "835/EPRA Header", true, epraHeaderUI);

		Boolean ppraHeaderUI = ppraHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Payer PRA Header", true, ppraHeaderUI);

		Boolean archiveHeaderUI = archiveHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Archive Header", true, archiveHeaderUI);

		Boolean printBtnUI = printBtn.isDisplayed();
		Helper.compareEquals(testConfig, "Print Button", true, printBtnUI);

		Boolean saveBtnUI = saveBtn.isDisplayed();
		Helper.compareEquals(testConfig, "Save Button", true, saveBtnUI);

	}

	public void clickViewPaymentsTab() throws Exception {
		Browser.wait(testConfig, 5);
		Element.clickByJS(testConfig, viewPaymentsTab, "View Payments");
	}

	public void verifyPayNumHypherLinkClaimDtlUPA() throws Exception {

		Element.click(paymentNumHyper, "Payment Number Hyper Link");
		Browser.wait(testConfig, 5);

		Boolean filterDrpDownUI = filterDrpDown.isDisplayed();
		Helper.compareEquals(testConfig, "Filter Payments Drop Down", true, filterDrpDownUI);

		Boolean quickSearchUI = quickSearch.isDisplayed();
		Helper.compareEquals(testConfig, "Quick Search Drop Down", true, quickSearchUI);

		Boolean marketTypUI = marketTyp.isDisplayed();
		Helper.compareEquals(testConfig, "Market Type Drop Down", true, marketTypUI);

		Boolean activeDrpDownUI = activeDrpDown.isDisplayed();
		Helper.compareEquals(testConfig, "Active/Archived Payments Drop Down", true, activeDrpDownUI);

		Boolean payerHeaderUI = payerHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Payer Header", true, payerHeaderUI);

		Boolean npiHeaderUI = npiHeader.isDisplayed();
		Helper.compareEquals(testConfig, "NPI Header", true, npiHeaderUI);

		Boolean paymentNumUI = paymentNum.isDisplayed();
		Helper.compareEquals(testConfig, "Payment Number Header", true, paymentNumUI);

		Boolean proxyNumUI = proxyNum.isDisplayed();
		Helper.compareEquals(testConfig, "Proxy Number Header", true, proxyNumUI);

		Boolean amountHeaderUI = amountHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Amount Header", true, amountHeaderUI);

		Boolean typeHeaderUI = typeHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Type Header", true, typeHeaderUI);

		Boolean paymentStatusHeaderUI = paymentStatusHeader.isDisplayed();
		Helper.compareEquals(testConfig, "PaymentStatus Header", true, paymentStatusHeaderUI);

		Boolean redemptionHeaderUI = redemptionHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Redemption Date Header", true, redemptionHeaderUI);

		Boolean marketTypeHeaderUI = marketTypeHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Market Type Header", true, marketTypeHeaderUI);

		Boolean epraHeaderUI = epraHeader.isDisplayed();
		Helper.compareEquals(testConfig, "835/EPRA Header", true, epraHeaderUI);

		Boolean ppraHeaderUI = ppraHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Payer PRA Header", true, ppraHeaderUI);

		// Boolean archiveHeaderUI = archiveHeader.isDisplayed();
		// Helper.compareEquals(testConfig, "Archive Header", true, archiveHeaderUI);

		Boolean printBtnUI = printBtn.isDisplayed();
		Helper.compareEquals(testConfig, "Print Button", true, printBtnUI);

		Boolean printTextFooterUI = printTextFooterTxt.isDisplayed();
		Helper.compareEquals(testConfig, "Print Text Footer UI", true, printTextFooterUI);
	}

	public void verifyPayNumHypherLinkClaimDtlPayer() throws Exception {

		Element.click(paymentNumHyper, "Payment Number Hyper Link");
		Browser.wait(testConfig, 5);

		Boolean filterDrpDownUI = filterDrpDown.isDisplayed();
		Helper.compareEquals(testConfig, "Filter Payments Drop Down", true, filterDrpDownUI);

		Boolean quickSearchUI = quickSearch.isDisplayed();
		Helper.compareEquals(testConfig, "Quick Search Drop Down", true, quickSearchUI);

		Boolean marketTypUI = marketTyp.isDisplayed();
		Helper.compareEquals(testConfig, "Market Type Drop Down", true, marketTypUI);

		Boolean payerHeaderUI = payerHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Payer Header", true, payerHeaderUI);

		Boolean payDateHeaderUI = payDateHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Payment Date Header", true, payDateHeaderUI);

		Boolean npiHeaderUI = npiHeader.isDisplayed();
		Helper.compareEquals(testConfig, "NPI Header", true, npiHeaderUI);

		Boolean paymentNumUI = paymentNum.isDisplayed();
		Helper.compareEquals(testConfig, "Payment Number Header", true, paymentNumUI);

		Boolean proxyNumUI = proxyNum.isDisplayed();
		Helper.compareEquals(testConfig, "Proxy Number Header", true, proxyNumUI);

		Boolean amountHeaderUI = amountHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Amount Header", true, amountHeaderUI);

		Boolean typeHeaderUI = typeHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Type Header", true, typeHeaderUI);

		Boolean paymentStatusHeaderUI = paymentStatusHeader.isDisplayed();
		Helper.compareEquals(testConfig, "PaymentStatus Header", true, paymentStatusHeaderUI);

		Boolean redemptionHeaderUI = redemptionHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Redemption Date Header", true, redemptionHeaderUI);

		Boolean marketTypeHeaderUI = marketTypeHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Market Type Header", true, marketTypeHeaderUI);

		Boolean epraHeaderUI = epraHeader.isDisplayed();
		Helper.compareEquals(testConfig, "835/EPRA Header", true, epraHeaderUI);

		Boolean ppraHeaderUI = ppraHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Payer PRA Header", true, ppraHeaderUI);

		Boolean printBtnUI = printBtn.isDisplayed();
		Helper.compareEquals(testConfig, "Print Button", true, printBtnUI);

	}

	public void verifyDisable() {
		Boolean quickSearchUI = quickSearch.isDisplayed();
		Helper.compareEquals(testConfig, "Quick Search Drop Down", true, quickSearchUI);

		Boolean activeDrpDownUI = activeDrpDown.isDisplayed();
		Helper.compareEquals(testConfig, "Active/Archived Payments Drop Down", true, activeDrpDownUI);
		// if (archiveDrpDwn == null)
		// Log.Comment("Save Archive Changes button is not on the Page");
	}

	public void selectTimePeriod(String TimePeriod) {

		if (TimePeriod.equals("Last 30 days"))
			Element.selectVisibleText(quickSearch, "Last 30 days", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 60 days"))
			System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
		Element.selectVisibleText(quickSearch, "Last 60 days", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 90 days"))
			Element.selectVisibleText(quickSearch, "Last 90 days", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 4-6 months"))
			Element.selectVisibleText(quickSearch, "Last 4-6 months", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 6-9 months"))
			Element.selectVisibleText(quickSearch, "Last 6-9 months", "Quick Search from View Payments");
		if (TimePeriod.equals("Last 9-13 months"))
			Element.selectVisibleText(quickSearch, "Last 9-13 months", "Quick Search from View Payments");

	}

	public void selectMarketType(String filter) {
		Element.selectVisibleText(marketTyp, filter, "Market Type filter selected on View Payments as :" + filter);
	}

	public void verifyPayerText(String credentials) {
		if (credentials.equals("CSR")) {
			Helper.compareEquals(testConfig, "Payer Text", "Payer", payerHeader.getText());
		} else {
			Helper.compareEquals(testConfig, "Payer Text", "Payer", payerHeader.getText());
			Browser.scrollToBottom(testConfig);
			Element.click(printBtn, "Print Payment Summary");
			String oldWindow = Browser.switchToNewWindow(testConfig, "printPaymentSummary.do");
			Helper.compareEquals(testConfig, "Payer Text", "Payer", payerHeaderPrintPaymentSummary.getText());
			Browser.switchToParentWindow(testConfig, oldWindow);
		}
	}

	public void verifyEPRAAndPayerPRA(String credentials) {
		if (credentials.equals("CSR")) {
			if (payerTable.get(2).findElements(By.tagName("td")).get(9).getText().contentEquals("Patient Payments")) {
				Helper.compareEquals(testConfig, "Payer PRA", "N/A",
						payerTable.get(2).findElements(By.tagName("td")).get(17).getText());
				payerTable.get(2).findElements(By.tagName("td")).get(14).isDisplayed();
				Helper.compareEquals(testConfig, "835", "835",
						payerTable.get(2).findElements(By.tagName("td")).get(14).getText());
				Helper.compareEquals(testConfig, "EPRA", "N/A",
						payerTable.get(2).findElements(By.tagName("td")).get(16).getText());

			}
		} else {
			Helper.compareEquals(testConfig, "Payer PRA", "N/A",
					payerTable.get(2).findElements(By.tagName("td")).get(14).getText());
			payerTable.get(2).findElements(By.tagName("td")).get(11).isDisplayed();
			Helper.compareEquals(testConfig, "835", "835",
					payerTable.get(2).findElements(By.tagName("td")).get(11).getText());
			Helper.compareEquals(testConfig, "EPRA", "N/A",
					payerTable.get(2).findElements(By.tagName("td")).get(13).getText());
		}
	}

	public void verifyandClickPayment() throws Exception {
		Boolean firstPaymentNbr = firstPaymentNumber.isDisplayed();
		Helper.compareEquals(testConfig, "First payment Number", true, firstPaymentNbr);
		Element.clickByJS(testConfig, firstPaymentNumber, "First payment Number");

	}

	// Added by Mohammad
	public void verifyFeeAmountInfoHoverMessage() {
		String iHoverMessageFeeAmount = "If you are an administrator, you have access to the Optum Pay Solutions tab to view total accrued fees for the month. The fees do not include taxes. If your organization is tax exempt, please send your certificate to optumpay_taxexempt@optum.com to ensure correct billing.";
		Helper.compareEquals(testConfig, "Fee Amount Info Icon Hover Message", iHoverMessageFeeAmount,
				iHoverMessageFeeAmount_UPA.getAttribute("title"));
	}

	public void verifyColumnValuesForEachPayment(String columnName) {
		int columnNumber = 0;

		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();

		for (int i = 0; i < tblHeader.size(); i++) {
			Log.Comment("Col Name: " + tblHeader.get(i));
			if (tblHeader.get(i).equalsIgnoreCase(columnName)) {
				columnNumber = i + 1;
			}
		}

		List<WebElement> rowsForEachPayment = Element.findElements(testConfig, "xpath",
				"//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr");

		for (int j = 0; j < rowsForEachPayment.size() - 2; j++) {

			String xpathPayerName = "//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr[" + (j + 2)
					+ "]/td[1]";
			WebElement payerName = Element.findElement(testConfig, "xpath", xpathPayerName);

			String payerNameforEachPayment = payerName.getText();

			String xpathColumnNameRequired = "//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr["
					+ (j + 2) + "]/td[" + columnNumber + "]";
			WebElement xpathColumnName = Element.findElement(testConfig, "xpath", xpathColumnNameRequired);

			String xpathColumnNameRequiredforEachPayment = xpathColumnName.getText();

			Log.Comment("For Payer Name: " + payerNameforEachPayment + ", " + columnName
					+ " column value for each payment is: " + xpathColumnNameRequiredforEachPayment);

		}

	}

	/**
	 * Author : Vinay Raghumanda Validates page text in View Payments screen for
	 * different types of users.
	 * 
	 * @param credentials
	 * @param portalAccess
	 */
	public void verifyPageTextFor(String accessType, String portalAccess) {

		String actualParagraph, expectedHeader, expectedPara, expectedPara2;
		WebElement header, paragraphTag;

		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//div[@id='view-payments-tabs']/div[1]"), 30);

		switch (accessType + "_" + portalAccess + "_" + testConfig.getRunTimeProperty("tinType")) {
		case "PROV_Admin_Premium_AO":
			header = Element.findElement(testConfig, "xpath", "//div[@id='view-payments-tabs']/div[1]/p[2]");
			paragraphTag = Element.findElement(testConfig, "xpath", "//div[@id='view-payments-tabs']/div[1]/p[3]");
			expectedHeader = TestBase.contentMessages
					.getProperty("prov.admin.premium.ao.viewPayments.topMessageDiv.header").trim();
			expectedPara = TestBase.contentMessages
					.getProperty("prov.admin.premium.ao.viewPayments.topMessageDiv.paragraph").trim();
			validateForPageText(expectedHeader, expectedPara, header, paragraphTag);
			break;
		case "PROV_Admin_Standard_AO":
			header = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/h2");
			paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]");
			expectedHeader = TestBase.contentMessages
					.getProperty("prov.admin.standard.ao.viewPayments.topMessageDiv.header");
			expectedPara = TestBase.contentMessages
					.getProperty("prov.admin.standard.ao.viewPayments.topMessageDiv.paragraph");
			validateForPageText(expectedHeader, expectedPara, header, paragraphTag);
			break;
		case "PROV_Gen_Premium_AO":
			header = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]/b");
			paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[3]");
			expectedHeader = TestBase.contentMessages
					.getProperty("prov.general.premium.ao.viewPayments.topMessageDiv.header");
			expectedPara = TestBase.contentMessages
					.getProperty("prov.general.premium.ao.viewPayments.topMessageDiv.paragraph");
			validateForPageText(expectedHeader, expectedPara, header, paragraphTag);
			break;
		case "PROV_Gen_Standard_AO":
			header = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/h2");
			paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]");
			expectedHeader = TestBase.contentMessages
					.getProperty("prov.general.standard.ao.viewPayments.topmessageDiv.header");
			expectedPara = TestBase.contentMessages
					.getProperty("prov.general.standard.ao.viewPayments.topmessageDiv.paragraph");
			validateForPageText(expectedHeader, expectedPara, header, paragraphTag);
			break;
		case "PROV_Admin_Premium_VO":
			paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]");
			actualParagraph = paragraphTag.getText().trim();
			expectedPara = TestBase.contentMessages
					.getProperty("prov.admin.premium.vo.viewPayments.topmessageDiv.paragraph");
			Helper.compareEquals(testConfig, "Page Text", expectedPara.trim(), actualParagraph);
			break;
		case "PROV_Gen_Premium_VO":
			actualParagraph = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]").getText()
					.trim();
			expectedPara = TestBase.contentMessages
					.getProperty("prov.admin.premium.vo.viewPayments.topmessageDiv.paragraph");
			Helper.compareEquals(testConfig, "Page Text", expectedPara.trim(), actualParagraph);
			break;
		case "BS_Admin_Premium_AO":
			header = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]/b");
			paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[3]");
			expectedHeader = TestBase.contentMessages.getProperty("bs.admin.premium.ao.viewPayments.header");
			expectedPara = TestBase.contentMessages.getProperty("bs.admin.premium.ao.viewPayments.paragraph");
			validateForPageText(expectedHeader, expectedPara, header, paragraphTag);
			break;
		case "BS_Admin_Standard_AO":

			if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "WithinTrial and NotPaid"))

			{
				expectedHeader = TestBase.contentMessages
						.getProperty("bs.admin.standard.withinTrialNotPaid.ao.viewPayments.header");
				expectedPara = TestBase.contentMessages
						.getProperty("bs.admin.standard.withinTrialNotPaid.ao.viewPayments.paragraph");
				expectedPara2 = TestBase.contentMessages
						.getProperty("bs.admin.standard.withinTrialNotPaid.ao.viewPayments.paragraph2");
				validatePageText2(expectedHeader, expectedPara, expectedPara2);
			} else if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "PostTrial and NotPaid"))

			{
				expectedHeader = TestBase.contentMessages.getProperty("bs.admin.standard.ao.viewPayments.header");
				expectedPara = TestBase.contentMessages.getProperty("bs.admin.standard.ao.viewPayments.paragraph1");
				expectedPara2 = TestBase.contentMessages.getProperty("bs.admin.standard.ao.viewPayments.paragraph2");
				validatePageText2(expectedHeader, expectedPara, expectedPara2);
			} else if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "Last 30 days")) {
				expectedHeader = TestBase.contentMessages
						.getProperty("bs.admin.standard.ao.viewPayments.greyedout.header");
				expectedPara = TestBase.contentMessages
						.getProperty("bs.admin.standard.ao.viewPayments.greyedout.paragraph");
				VerifyGreyedOutText(expectedHeader, expectedPara);
			}
			break;
		case "BS_Gen_Premium_AO":
			header = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]/b");
			paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[3]");
			expectedHeader = TestBase.contentMessages.getProperty("bs.general.premium.ao.viewPayments.header");
			expectedPara = TestBase.contentMessages.getProperty("bs.general.premium.ao.viewPayments.paragraph");
			validateForPageText(expectedHeader, expectedPara, header, paragraphTag);
			break;
		case "BS_Gen_Standard_AO":
			if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "WithinTrial and NotPaid"))

			{
				expectedHeader = TestBase.contentMessages
						.getProperty("bs.general.standard.withinTrialNotPaid.ao.viewPayments.header");
				expectedPara = TestBase.contentMessages
						.getProperty("bs.general.standard.withinTrialNotPaid.ao.viewPayments.paragraph");
				expectedPara2 = TestBase.contentMessages
						.getProperty("bs.general.standard.withinTrialNotPaid.ao.viewPayments.paragraph2");
				validatePageText2(expectedHeader, expectedPara, expectedPara2);
			} else if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "PostTrial and NotPaid"))

			{
				expectedHeader = TestBase.contentMessages.getProperty("bs.general.standard.ao.viewPayments.header");
				expectedPara = TestBase.contentMessages.getProperty("bs.general.standard.ao.viewPayments.paragraph1");
				expectedPara2 = TestBase.contentMessages.getProperty("bs.general.standard.ao.viewPayments.paragraph2");
				validatePageText2(expectedHeader, expectedPara, expectedPara2);
			} else if (StringUtils.equals(testConfig.getRunTimeProperty("searchCriteria"), "Last 30 days")) {
				expectedHeader = TestBase.contentMessages
						.getProperty("bs.general.standard.ao.viewPayments.greyedout.header");
				expectedPara = TestBase.contentMessages
						.getProperty("bs.general.standard.ao.viewPayments.greyedout.paragraph");
				VerifyGreyedOutText(expectedHeader, expectedPara);
			}
			break;
		default:
			break;
		}

	}

	private void validatePageText2(String expectedHeader, String expectedPara, String expectedPara2) {
		WebElement header, paragraphTag, paragraphTag2;
		String actualHeader, actualParagraph, actualParagraph2;
		header = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/h2");
		paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[2]");
		paragraphTag2 = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p[3]");
		actualHeader = header.getText().trim();
		actualParagraph = paragraphTag.getText().trim();
		actualParagraph2 = paragraphTag2.getText().trim();
		Helper.compareEquals(testConfig, "Page Text", expectedHeader, actualHeader);
		Helper.compareEquals(testConfig, "Page Text", expectedPara, actualParagraph);
		if (expectedPara2 != null)
			Helper.compareEquals(testConfig, "Page Text", expectedPara2, actualParagraph2);
	}

	private void validateForPageText(String expectedHeader, String expectedPara, WebElement header,
			WebElement paragraphTag) {
		String actualHeader, actualParagraph;
		actualHeader = header.getText().trim();
		actualParagraph = paragraphTag.getText().trim();
		Helper.compareEquals(testConfig, "Page Text", expectedHeader, actualHeader);
		Helper.compareEquals(testConfig, "Page Text", expectedPara, actualParagraph);
	}

	public ViewPayments clickGreyedOut() {
		WebElement greyArea = null;
		greyArea = searchResultRows.get(1).findElements(By.tagName("td"))
				.get(getHeadersFromResultTable().indexOf("Claim Count"));
		Element.clickByJS(testConfig, greyArea, "GreyArea Portion clicked");
		return this;
	}

	public ViewPayments VerifyGreyedOutText(String expectedHeader, String expectedPara) {
		String actualHeader, actualParagraph;
		actualHeader = Element.findElement(testConfig, "xpath", "//div[@id=\"viewPaymentsPremium\"]/h2").getText()
				.trim();
		actualParagraph = Element.findElement(testConfig, "xpath", "//div[@id=\"viewPaymentsPremium\"]/p[2]").getText()
				.trim();

		Helper.compareEquals(testConfig, "Page Text", expectedHeader, actualHeader);
		Helper.compareEquals(testConfig, "Page Text", expectedPara, actualParagraph);

		return this;
	}

	public ViewPayments verify835EPRA() {
		String actualPaymntNo = "";
		boolean found = false;
		WebElement link = null;
		WebElement epraLink = null;
		int totalNoOfPages = getNumberOfPages();

		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		int columnIndex = tblHeader.indexOf("835 / EPRA");

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {
			// if(TestBase.driver.getPageSource().toString().contains(expectedPaymntNo))
			{
				for (int i = 1; i < searchResultRows.size(); i++) {
					actualPaymntNo = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
					actualPaymntNo = StringUtils.replace(actualPaymntNo, "\n", "");
					// if(actualPaymntNo.contains(expectedPaymntNo))
					{
						// found=true;
						// epraLink=searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex).findElements(By.tagName("td")).get(0);
						epraLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex);
						
						// if(searchCriteria.equalsIgnoreCase("vpay_835_disabled_ePRA_disabled"))vpay_835_enabled_ePRA_disabled
						// testConfig.putRunTimeProperty("nullStat", "= 'N' ");
						// if(searchCriteria.equalsIgnoreCase("vpay_835_enabled_ePRA_disabled"))
						// testConfig.putRunTimeProperty("nullStat", "IS NULL");

						if (testConfig.getRunTimeProperty("nullStat").equalsIgnoreCase("IS NULL"))// i.e.
																									// vpay_835_enabled_ePRA_disabled
						{
							Helper.compareEquals(testConfig, "835EPRA NA Comp", "835 | N/A", epraLink.getText());
							link = epraLink.findElement(By.tagName("a"));
							Element.verifyElementPresent(link, "835 link is present");

							epraLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex)
									.findElements(By.tagName("td")).get(2);

							if (epraLink.getText().toString().contains("N/A"))
								Helper.compareEquals(testConfig, "EPRA", "N/A", epraLink.getText().toString());
							link.click();// 835 linked clicked
							found = true;
						} else {
							Helper.compareEquals(testConfig, "835EPRA Comp", "N/A", epraLink.getText());
							found = true;
						}
					}
					if (found == true)
						break;
				}
			}

			// if(found==true)break;
			gotoNextPage(pageNo, totalNoOfPages);
		}
		return this;

	}
	
	public void viewPaymentUIVerification(String userType, String portalAccess, String TINtype) {
		
		Element.verifyElementPresent(drpDwnTin, "TIN Dropdown field present");
		
		
	}
	
public ViewPayments verifyFilterPaymentsOptions() {
		
		List<String> filterPayments = new ArrayList<>(Arrays.asList("Show All", "TIN Only", "NPI Only"));
		
		Element.verifyElementPresent(drpDwnFilterPayments, "Filter Payments");
		String defaultVal = Element.getFirstSelectedOption(testConfig, filterPaymentsDrpDwn, "text");
		Helper.compareEquals(testConfig, "Default value of Quick Search filter", "Show All", defaultVal);
	
			List<String> drpDownOptionsUI = Element.getAllOptionsInSelect(testConfig, filterPaymentsDrpDwn);
			Helper.compareEquals(testConfig, "Options of Filter Payments Options", filterPayments, drpDownOptionsUI);
		
		return this;
	}

public ViewPayments verifyMarketTypesOptions() {
	
	List<String> MaketTypeDrpDwnValues = new ArrayList<>(Arrays.asList("Show All", "CARES Act - Healthcare Relief Program", "Capitation",
			"Dental", "HRA", "Medical","Other", "Patient Payments", "Pharmacy Payments and Rebates","Property and Casualty", "UHC West", "Various","Vision","Workers Compensation"));
	
	Element.verifyElementPresent(drpDwnMarketType, "Market Type");
	String defaultVal = Element.getFirstSelectedOption(testConfig, drpDwnMarketType, "text");
	Helper.compareEquals(testConfig, "Default value of Quick Search filter", "Show All", defaultVal);

		List<String> drpDownOptionsUI = Element.getAllOptionsInSelect(testConfig, drpDwnMarketType);
		Helper.compareEquals(testConfig, "Options of verify MarketTypes Options", MaketTypeDrpDwnValues, drpDownOptionsUI);
	
	return this;
}

public ViewPayments setSearchFiltersOnViewPaymentPage(String QuickSearch, String FilterPayments, String MarketType,String PaymentStatus) {
	
	Browser.wait(testConfig, 3);
	Browser.waitForLoad(TestBase.driver);
	Element.waitForPresenceOfElementLocated(testConfig, By.id("archiveFilterType"), 60);
	
	Element.selectByVisibleText(drpDwnQuickSearch,QuickSearch ,QuickSearch+" Selected in Quick Search");
	Browser.waitForLoad(testConfig.driver);
	Element.selectByVisibleText(drpDwnFilterPayments,FilterPayments ,FilterPayments+" Selected in Filter Payments");
	Browser.waitForLoad(testConfig.driver);
	Element.selectByVisibleText(mrktTypeDrpDwn,MarketType ,MarketType+" Selected in Market Type");
	Browser.waitForLoad(testConfig.driver);
	Element.selectByVisibleText(drpDwnArchiveFilter,PaymentStatus ,PaymentStatus+" Selected in Payment Status");
	Browser.waitForLoad(testConfig.driver);
	return this;
	
}

public void verifyResultsInChronologicalOrder() throws ParseException {
	
	ArrayList<Date> Datelist = new ArrayList<Date>();
	ArrayList<Date> SortedDatelist = new ArrayList<Date>();
	int paymentcount = searchResultRows.size();
	for(int i=2;i<=paymentcount;i++) {
		
		String date = Element.findElement(testConfig, "xpath", "//div[@id='view-payments'][2]/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[2]").getText();
		
		Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(date);
		Datelist.add(date1);
		
	}
	
	SortedDatelist.addAll(Datelist);
	Collections.sort(SortedDatelist, Collections.reverseOrder());
	Datelist.equals(SortedDatelist);
	
}

public void verifyMaximumRecords() {
	
	int paymentcount = searchResultRows.size()-1;
	int recordcount = Integer.parseInt(totalRecordsFromFISL);
	
	if(recordcount>=30) {
		Assert.assertTrue(paymentcount==30);
	}
	
	if(recordcount<=30) {
		Assert.assertTrue(paymentcount==recordcount);
	}
	
	
}

public String keyValueForMarketType(String MrkType) {
	
	if(MrkType.equalsIgnoreCase("medical"))
		return "M";
	else if(MrkType.equalsIgnoreCase("dental"))
		return "D";
	else 
	return null;
	
}

public String keyValueForPaymentStatus(String PaymntType) {
	
	if(PaymntType.equalsIgnoreCase("new"))
		return "N";
	else if(PaymntType.equalsIgnoreCase("pending"))
		return "P";
	else if(PaymntType.equalsIgnoreCase("closed"))
		return "Y";
	else
	return null;
	
}

public String keyValueForFilterPayments(String PaymntType) {
	
	if(PaymntType.equalsIgnoreCase("TIN Only"))
		return "TIN";
	else if(PaymntType.equalsIgnoreCase("NPI Only"))
		return "NPI";
	else 
	return null;
	
}

public void changingPaymentStatus(String currentStatus, String UpdatedStatus) {
	
	btnSave.getAttribute("disabled").equalsIgnoreCase("disabled");
	Browser.waitForLoad(testConfig.driver);
	
	PaymentNumber = paymentNo1.getText();
	if(PaymentNumber.contains("Check"))
		PaymentNumber = PaymentNumber.substring(0, PaymentNumber.indexOf("Check"));
	
	Element.selectByVisibleText(PaymentStatusDrpdwn, UpdatedStatus, "Updating status to "+UpdatedStatus);
	Browser.waitForLoad(testConfig.driver);
	Element.waitForElementTobeClickAble(testConfig, btnSave, 3);
	btnSave.click();
	Browser.waitForLoad(TestBase.driver);
	
}

public void verifyPaymentStatusUpdatedInDB(String UpdatedStatus) {
	PaymentNumber = StringUtils.replace(PaymentNumber, "\n", "");
	testConfig.putRunTimeProperty("PaymentNumber",PaymentNumber );
	testConfig.putRunTimeProperty("PaymentSchema",DataBase.executeSelectQuery(testConfig, QUERY.PaymentSchema, 1).get("PAYR_SCHM_NM").trim());
	Map<String, String> PayNumStatus = DataBase.executeSelectQuery(testConfig, QUERY.PaymentStatus, 1);
	PayNumStatus.get("DSPL_CONSL_PAY_NBR").equalsIgnoreCase("PaymentNumber");
	Helper.compareEquals(testConfig, "Payment status", PayNumStatus.get("ARCHV_IND"), keyValueForPaymentStatus(UpdatedStatus));
	
}

	public ViewPayments downloadRequiredFile(String fileType) {
		boolean found = false;
		WebElement link = null;
		WebElement epraLink = null;
		int totalNoOfPages = getNumberOfPages();

		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		int columnIndex = tblHeader.indexOf("835 / EPRA");

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {

			for (int i = 1; i < searchResultRows.size(); i++) {
				if(!fileType.equalsIgnoreCase("EPRAGenGivenPayNum")){
				PaymentNumber = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
				PaymentNumber = StringUtils.replace(PaymentNumber, "\n", "");
				if(PaymentNumber.contains("Check"))
					PaymentNumber = PaymentNumber.substring(0, PaymentNumber.indexOf("Check"));
				}
				epraLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex);
				String epraLinktext = StringUtils.replace(epraLink.getText(), "\n", "");
				
				switch (fileType) {

				case "835file":
					if (epraLinktext.equalsIgnoreCase("835 |PDF")) {
						link = epraLink.findElement(By.tagName("a"));
						Element.verifyElementPresent(link, "835 link is present");
						link.click();// 835 linked clicked
						found = true;
					}
					break;
				case "EPRAExistingPDF":
					if (epraLinktext.equalsIgnoreCase("835 |")) {

						link = epraLink.findElements(By.tagName("a")).get(2);
						Element.verifyElementPresent(link, "pdf icon is present");
						link.click();
						Browser.wait(testConfig, 5);
						found = true;
					}
					break;
				case "EPRAGeneration":
					if (epraLinktext.equalsIgnoreCase("835 |PDF")) {
						link = epraLink.findElements(By.tagName("a")).get(1);
						Element.verifyElementPresent(link, "pdf link");
						link.click();
						found = true;
					}
					break;
					
				case "EPRAGenGivenPayNum":
					if (Element.findElements(testConfig, "xpath", "(//a[contains(@href,'"+PaymentNumber+"')])/img").size()>0) {
						Browser.browserRefresh(testConfig);
						WebElement EPRApdfLink = Element.findElement(testConfig, "xpath", "(//a[contains(@href,'"+PaymentNumber+"')])/img");
						EPRApdfLink.isDisplayed();
						EPRApdfLink.click();
						Browser.wait(testConfig, 5);
						found = true;
					}
					break;
				}

				if (found == true)
					break;
			}

			if (found == true) {
				break;
			}

			gotoNextPage(pageNo, totalNoOfPages);
		}
		return this;

	}

	public void getNonZeroPaynumber() {

		boolean found = false;

		WebElement ClaimAmountLink = null;
		WebElement epraLink = null;
		int totalNoOfPages = getNumberOfPages();

		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		int columnIndex = tblHeader.indexOf("Amount");
		int columnIndex2 = tblHeader.indexOf("835 / EPRA");
		
		

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {

			for (int i = 1; i < searchResultRows.size(); i++) {
				
				epraLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex2);
				String epraLinktext = StringUtils.replace(epraLink.getText(), "\n", "");
				
				PaymentNumber = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
				PaymentNumber = StringUtils.replace(PaymentNumber, "\n", "");
				if(PaymentNumber.contains("Check"))
					PaymentNumber = PaymentNumber.substring(0, PaymentNumber.indexOf("Check"));

				ClaimAmountLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex);
				String ClaimAmount = ClaimAmountLink.getText();
				if (!ClaimAmount.equalsIgnoreCase("$0.00") && epraLinktext.equalsIgnoreCase("835 |PDF")) {
					found = true;
					break;
				}
			}

			if (found == true) {
				break;
			}
			
			gotoNextPage(pageNo, totalNoOfPages);
		}
		
		
		
	}
	
	public void openingPayment() {
		PaymentDate = getColumnValueforpaynum(PaymentNumber,"Payment Date");
		Amount = getColumnValueforpaynum(PaymentNumber,"Amount");
		NPI = getColumnValueforpaynum(PaymentNumber,"NPI");
		
		Element.findElement(testConfig, "xpath", "//a[contains(@href,'" + PaymentNumber + "')]").click();
		Browser.waitForPageLoad(testConfig.driver);
	}
	
	public String getColumnValueforpaynum(String payNum, String column) {
		boolean found = false;
		WebElement columnvalueLink = null;
		String columnvalue = null;
		int totalNoOfPages = getNumberOfPages();

		ArrayList<String> tblHeader = new ArrayList<String>();
		tblHeader = getHeadersFromResultTable();
		int columnIndex = tblHeader.indexOf(column);

		for (int pageNo = 1; pageNo <= totalNoOfPages; pageNo++) {

			for (int i = 1; i < searchResultRows.size(); i++) {

				PaymentNumber = searchResultRows.get(i).findElements(By.tagName("td")).get(3).getText();
				PaymentNumber = StringUtils.replace(PaymentNumber, "\n", "");
				if(PaymentNumber.contains("Check"))
					PaymentNumber = PaymentNumber.substring(0, PaymentNumber.indexOf("Check"));

				columnvalueLink = searchResultRows.get(i).findElements(By.tagName("td")).get(columnIndex);

				if (payNum.equalsIgnoreCase(PaymentNumber)) {
					columnvalue = columnvalueLink.getText();
					found = true;
					break;
				}
			}

			if (found == true)
				break;
			gotoNextPage(pageNo, totalNoOfPages);
		}

		return columnvalue;
	}
	
}