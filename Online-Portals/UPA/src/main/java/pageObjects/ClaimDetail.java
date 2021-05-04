package main.java.pageObjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;

import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.xml.sax.SAXException;

import main.java.reporting.*;

import com.mysql.jdbc.StringUtils;

import cucumber.deps.com.thoughtworks.xstream.converters.basic.DateConverter;

import org.openqa.selenium.Dimension;
//import main.java.Utils.Config;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.api.manage.EpsPaymentsSearch.EpsRemittanceDetailHelper;
import main.java.api.pojo.epsRemittanceDetail.response.EPSClaimsResponseUI;
import main.java.api.pojo.epsRemittanceDetail.response.EpsClaimsRequest;
import main.java.api.pojo.epsRemittanceDetail.response.EpsClaimsResponse;
import main.java.fislServices.FISLConnection2;
import main.java.fislServices.ReadTagsfromFISLResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.stepDefinitions.Login.CSRHomePageSteps;
import main.java.stepDefinitions.RemittanceDetail.RemittanceDetailSteps;
import main.java.stepDefinitions.ViewPayments.SearchTinPageViewPaymentsSteps;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.HomePage;
import main.java.queries.QUERY;

public class ClaimDetail {
	EpsRemittanceDetailHelper epsRemittanceDetailHelper = new EpsRemittanceDetailHelper();
	EPSClaimsResponseUI epsClaimsResponseUI = new EPSClaimsResponseUI();
	EpsClaimsRequest epsClaimsRequest = new EpsClaimsRequest();

	//Writing all Locators here
	@FindBy(xpath = "//a[contains(text(),'View Payments')]") WebElement viewPaymentsTab;
	@FindBy(name="providerTIN")	WebElement enterTIN;
	//@FindBy(xpath = "//input[@name='providerTIN']") WebElement enterTIN;
	@FindBy(name="btnSubmit")	WebElement searchBtn;
	//@FindBy(xpath = "//input[@name='btnSubmit']") WebElement searchBtn;
	@FindBy(id="periodId")	WebElement quickSeacrhDrpDwn;
	//@FindBy(xpath = "//select[@id='periodId']") WebElement quickSeacrhDrpDwn;
	@FindBy(name="filterPayments")	WebElement filterPaymentsDrpDwn;
	//@FindBy(xpath = "//select[@name='filterPayments']") WebElement filterPaymentsDrpDwn;
	@FindBy(id="mktTypeId")	WebElement mrktTypeDrpDwn;
	//@FindBy(xpath = "//select[@id='mktTypeId']") WebElement mrktTypeDrpDwn;
	@FindBy(id="payerFilterType")	WebElement payerDrpDwn;
	//@FindBy(xpath = "//select[@id='payerFilterType']") WebElement payerDrpDwn;
	@FindBy(id="archiveFilterType")	WebElement archiveDrpDwn;
	//@FindBy(xpath = "//select[@id='archiveFilterType']") WebElement archiveDrpDwn;
	@FindBy(xpath = "//td[contains(text(),'Record Count:')]") WebElement record;
	@FindBy(id="paymentNbr_1")	WebElement firstPaymentNumber;
	//@FindBy(xpath = "//a[@id='paymentNbr_1']") WebElement firstPaymentNumber;
	@FindBy(className="subheader")	WebElement claimHeader1;
	//@FindBy(xpath = "//td[@class='subheader']") WebElement claimHeader1;
	@FindBy(xpath = "//*[starts-with(text(),'Organization:')]") WebElement orgHeader;
	@FindBy(xpath = "//*[starts-with(text(),'Payment Date:')]") WebElement paymentDate;
    @FindBy(xpath = "//*[contains(text(),'Payment Type:')]") WebElement paymentType;
	@FindBy(xpath = "//*[contains(text(),'Payment Number :')]") WebElement paymentNumber;
	@FindBy(xpath = "//*[contains(text(),'NPI:')]") WebElement  claimNPI;
	@FindBy(name="claimType")	WebElement filterClaims;
	//@FindBy(xpath = "//select[@name='claimType']") WebElement filterClaims;
	@FindBy(xpath = "//select[@name='claimType']//option") WebElement filterClaimsOptions;
	@FindBy(xpath = "//td[contains(text(),'Account Number')]") WebElement acctNum;
	@FindBy(xpath = "//*[contains(text(),'Patient Name/')]") WebElement patientName;
	@FindBy(xpath = "//span[contains(text(),'Patient ID')]") WebElement patientID;
	@FindBy(xpath = "//*[contains(text(),'Subscriber ID')]") WebElement subscbrID;
	@FindBy(xpath = "//span[contains(text(),'Corrected ID')]") WebElement correctedID;
	@FindBy(xpath = "//td[contains(text(),'Rendering Provider')]") WebElement rendPrvdr;
	@FindBy(xpath = "//td[contains(text(),'Claim #')]") WebElement claimHeader;
	@FindBy(xpath = "//td[starts-with(text(),'Group Policy Number/')]") WebElement grpPolicy;
	@FindBy(xpath = "//td[contains(text(),'Date(s) of Service')]") WebElement claimDOS;
	@FindBy(xpath = "//td[contains(text(),'Description of Service')]") WebElement descService;
	@FindBy(xpath = "//td[contains(text(),'Amount Charged')]") WebElement amntCharged;
	@FindBy(xpath = "//td[contains(text(),'Claim / Service Adj')]") WebElement serviceAdj;
	@FindBy(xpath = "//td[contains(text(),'Prov Adj Discount')]") WebElement provAdj;
	@FindBy(xpath = "//td[contains(text(),'Amount Allowed')]") WebElement amntAllowed;
	@FindBy(xpath = "//td[contains(text(),'Deduct/ Coins/ Copay')]") WebElement copay;
	@FindBy(xpath = "//tr[@class='columnHeaderText']//td[contains(text(),'Paid to Provider')]") WebElement paidPrvdr;
	@FindBy(xpath = "//a[contains(text(),'Adj Reason Code')]") WebElement adj_code;
	@FindBy(xpath = "//a[contains(text(),'RMK Code')]") WebElement rmk_code;
	@FindBy(xpath = "//td[contains(text(),'Patient Resp')]") WebElement patientResp;
	@FindBy(xpath = "//*[contains(text(),'Total Claim Paid')]") WebElement totalClaimTxt;
	@FindBy(xpath = "//td[contains(text(),'Remark Code')]") WebElement remarkCode;
	@FindBy(xpath = "//td[contains(text(),'Description')]") WebElement remarkDesc;
	@FindBy(xpath = "//td[contains(text(),'Adjustment Code')]") WebElement adjustmentCode;
	@FindBy(xpath = "//td[contains(text(),'Description')]") WebElement adjustmentDesc;
	@FindBy(xpath = "//a[contains(text(),'Adobe Reader')]") WebElement adobeReaderLink;
	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]") WebElement privacyPolicyLink;
	@FindBy(xpath = "//a[contains(text(),'Terms of Use')]") WebElement termsOfUseUiLink;
	@FindBy(xpath = "//input[@value='Return to Remittance Detail']") WebElement returnToRemittanceDetailButton;
	@FindBy(xpath = "//input[@value='Print Claim Detail']") WebElement printClaimDetailButton;
	@FindBy(xpath = "//span[@class='pageNo'][contains(text(),'1')]") WebElement paginationNo1;
	@FindBy(xpath = "//span[@class='pageNo'][contains(text(),'2')]") WebElement paginationNo2;
	@FindBy(xpath = "//tr[@class='rowDarkbold']/td[1]") WebElement subTotRecord;
	@FindBy(xpath = "//a[contains(text(),'Next')]") WebElement remitNext;
    @FindBy(xpath = "//*[@class='ellipsis wrapperTooltip'][1]") WebElement payernameUI;
	@FindBy(xpath = "//table[@class='tableborder']/tbody/tr/td/table/tbody/tr[2]/td[1]/span[1]") WebElement payerUI;
	@FindBy(id="paymentNbr_2")	WebElement paymentNo2;
	//@FindBy(xpath = "//a[@id='paymentNbr_2']") WebElement paymentNo2;
	@FindBy(id="paymentNbr_1")	WebElement paymentNo1;
	//@FindBy(xpath = "//a[@id='paymentNbr_1']") WebElement paymentNo1;
	@FindBy(xpath = "//p[contains(text(),'Payment Number :')]/a") WebElement paymentno;
	@FindBy(xpath = "//input[@value='Download 835']") WebElement download;
	@FindBy(xpath = "//span[@id='epra-print-1']//input[@value='Print Request']") WebElement printBtn;
	@FindBy(xpath = "//input[@value='Return to Payment Summary']") WebElement returnBtn;
	@FindBy(className="subheaderbold")	WebElement totPaidSubHdr;
	//@FindBy(xpath = "//td[@class='subheaderbold']") WebElement totPaidSubHdr;
	@FindBy(xpath = "//div[@id='msgforplb']//span[@class='Subheaderbold']") WebElement cob_Msg;
	@FindBy(xpath = "//div[@id='msgforplb']//span[@class='Subheaderbold']") WebElement reversalMsg;
	@FindBy(id="periodId")	WebElement quickSearch;
	//@FindBy(xpath = "//select[@id='periodId']") WebElement quickSearch;
	@FindBy(id="mktTypeId")	WebElement marketTyp;
	//@FindBy(xpath = "//select[@id='mktTypeId']") WebElement marketTyp;
	@FindBy(id="payerFilterType")	WebElement payerDrpDown;
	//@FindBy(xpath = "//select[@id='payerFilterType']") WebElement payerDrpDown;
	@FindBy(xpath = "//select[@name='claimType']//option") List<WebElement> filterClaimsOptionUI;
	@FindBy(name="filterPayments")	WebElement filterDrpDown;
	//@FindBy(xpath = "//select[@name='filterPayments']") WebElement filterDrpDown;
	@FindBy(xpath = "//a[contains(text(),'First Page')]") WebElement firstPage;
	@FindBy(xpath = "//a[contains(text(),'Last Page')]") WebElement lastPage;
	@FindBy(id="outerTable") WebElement remitOuterTable;
	//@FindBy(xpath = "//table[@id='outerTable']") WebElement remitOuterTable;
	@FindBy(id="patientName_") WebElement firstPatient;
	//@FindBy(xpath = "//td[@id='patientName_']") WebElement firstPatient;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]") WebElement amntChargedUI;
	@FindBy(id="grpID_") WebElement grpPolicyUI;
	//@FindBy(xpath = "//span[@id='grpID_']") WebElement grpPolicyUI;
	@FindBy(id="subscriberID_") WebElement subscriberUI1;
	//@FindBy(xpath = "//td[@id='subscriberID_']") WebElement subscriberUI1;
	@FindBy(xpath = "//span[@id='claimID_1']/a") WebElement claimHash;
	@FindBy(xpath = "//span[@id='claimID_']/span[1]") WebElement claimHash1;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[3]/td[5]/span[1]/span[1]") WebElement claimHashno;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]") WebElement accntNum;
	@FindBy(xpath = "//span[@id='claimID_1']/a") WebElement claimType;
	@FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]") WebElement amntallowed;
	@FindBy(xpath = "//tr[@class='rowDarkbold']//td[7]") WebElement copayUI;
	@FindBy(xpath = "//tr[contains(@class,'rowDarkbold')]//td[11]") WebElement patientresp;
	@FindBy(xpath = "//tr[contains(@class,'rowDarkbold')]//td[5]") WebElement provAdjDis;
	@FindBy(xpath = "//a[@class='exante-default-header-txt-bold'][contains(text(),'Home')]") WebElement homeBtn;
	@FindBy(xpath = "//a[contains(text(),'Search Remittance')]") WebElement srchRemit;
	@FindBy(id="paymentNbrTypeSelection") WebElement payNumdrpdwn;
	//@FindBy(xpath = "//select[@id='paymentNbrTypeSelection']") WebElement payNumdrpdwn;
	@FindBy(id="paymentNumberInputId") WebElement elcPayNum;
	//@FindBy(xpath = "//input[@id='paymentNumberInputId']") WebElement elcPayNum;
	@FindBy(name="searchRemittance") WebElement srchRemitBtn;
	//@FindBy(xpath = "//input[@name='searchRemittance']") WebElement srchRemitBtn;
	@FindBy(xpath = "//tr[@class='rowDarkbold']/td[1]") WebElement subTotal;
	@FindBy(xpath = "//td[contains(text(),'Adj Reason Code')]") WebElement adjCodePLB;
	@FindBy(xpath = "//td[contains(text(),'Reference #')]") WebElement refCodePLB;
	@FindBy(xpath = "//table[@class='tableborder']/tbody/tr/td[3]") WebElement amntPLBHeader;
	@FindBy(xpath = "//td[starts-with(@id,'patientName_')]") List<WebElement> patientNameList;
	@FindBy(xpath = "//div[@id='msgforplb']//span[1]") WebElement claimmsg;
	@FindBy(xpath = "//a[text()='EPS']") WebElement rmksessionoutmsg;
	@FindBy(xpath = "//tr[@class='rowDarkbold']/td[contains(text(), 'Subtotal')]") List<WebElement> subTotalCount;
	@FindBy(xpath = "//*[contains(text(),'Payment Number:')]") WebElement paymentNo;
	
	@FindBy(xpath="//a[@id='paymentNbr_1']")
	private WebElement enterRemittanceDtlPage;
	
	@FindBy(xpath="//span[@id='claimID_1']//a")
	private WebElement enterClaimDtlPage;
	@FindBy(xpath = "//*[contains(text(),'technical difficulties')]") WebElement errorPageUI;

	
private TestBase testConfig;

public ClaimDetail(TestBase testConfig)
{
	this.testConfig=testConfig;
	PageFactory.initElements(testConfig.driver, this);
}


public void enterRemittancedetailPage() {
	Element.clickByJS(testConfig, enterRemittanceDtlPage, "Payment 1st link");
	handleTechnicalDifficultyError();
}

public void enterClaimdetailPage() {
	Element.clickByJS(testConfig, enterClaimDtlPage, "claim detail number link");
	handleTechnicalDifficultyError();
	String claimDetailPageTitle = testConfig.driver.getTitle().trim(); //View Claim Details
	Helper.compareEquals(testConfig, "View Claim Details page Title", "View Claim Details", claimDetailPageTitle);
}


public void verifyAllHeadersClaimDtl() throws Exception
{    
	 enterClaimdetailPage();
     String claimHeader1UI = claimHeader1.getText();
	 if(!claimHeader1UI.equalsIgnoreCase("0"))
	     Helper.compareEquals(testConfig, "Comparing Claim Detail Header", claimHeader1UI, "Claim Detail");
 
	 Boolean org_UI = orgHeader.isDisplayed();
	 Helper.compareEquals(testConfig, "Organization Header", true, org_UI);

     Boolean paymentDateUI = paymentDate.isDisplayed();
	 Helper.compareEquals(testConfig, "Payment Date Header", true, paymentDateUI);
	
	 Boolean paymentNum = paymentNumber.isDisplayed();
	 Helper.compareEquals(testConfig, "Payment Number Header", true, paymentNum);
	 
     Boolean paymentTypeUI = paymentType.isDisplayed();
     Helper.compareEquals(testConfig, "Payment Type Header", true, paymentTypeUI);
    
     Boolean claimNPIUI = claimNPI.isDisplayed();
     Helper.compareEquals(testConfig, "Claim NPI Header", true, claimNPIUI);
}



public void verifyAllHeadersClaimDtlPay() throws Exception
{
     String claimHeader1UI = claimHeader1.getText();
	 if(!claimHeader1UI.equalsIgnoreCase("0"))
	     Helper.compareEquals(testConfig, "Comparing Claim Detail Header", claimHeader1UI, "Claim Detail");
 
	 Boolean org_UI = orgHeader.isDisplayed();
	 Helper.compareEquals(testConfig, "Organization Header", true, org_UI);

     Boolean paymentDateUI = paymentDate.isDisplayed();
	 Helper.compareEquals(testConfig, "Payment Date Header", true, paymentDateUI);
	
	 Boolean paymentNum = paymentNumber.isDisplayed();
	 Helper.compareEquals(testConfig, "Payment Number Header", true, paymentNum);
	 
     Boolean paymentTypeUI = paymentType.isDisplayed();
     Helper.compareEquals(testConfig, "Payment Type Header", true, paymentTypeUI);

}



public void verifyColumnHeadersClaimDtl() throws Exception
{
	 Boolean acctNumUI = acctNum.isDisplayed(); 
	 Helper.compareEquals(testConfig, "Account Number Column", true, acctNumUI);
	 
	 Boolean patientNameUI = patientName.isDisplayed(); 
	 Helper.compareEquals(testConfig, "Patient Name Column", true, patientNameUI);
	 
	 Boolean subscbrIDUI = subscbrID.isDisplayed(); 
	 Helper.compareEquals(testConfig, "Subscriber ID Column", true, subscbrIDUI);
	 
	 Boolean correctedIDUI = correctedID.isDisplayed(); 
	 Helper.compareEquals(testConfig, "correctedID Column", true, correctedIDUI);
	 
	 Boolean rendPrvdrUI = rendPrvdr.isDisplayed(); 
	 Helper.compareEquals(testConfig, "Rendering Provider Column", true, rendPrvdrUI);
	 
	 Boolean claimHeaderUI = claimHeader.isDisplayed(); 
	 Helper.compareEquals(testConfig, "Claim #/Claim Type Column", true, claimHeaderUI);
	
	 Boolean grpPolicyUI = grpPolicy.isDisplayed(); 
	 Helper.compareEquals(testConfig, "Group Policy Number/Product Name Column", true, grpPolicyUI);
	
	 Boolean remitDOSUI = claimDOS.isDisplayed(); 
	 Helper.compareEquals(testConfig, "DOS Column", true, remitDOSUI);
	
	 Boolean descServiceUI = descService.isDisplayed(); 
	 Helper.compareEquals(testConfig, "Description of Service Column", true, descServiceUI);
	 
	 Boolean amntChargedUI = amntCharged.isDisplayed();  
	 Helper.compareEquals(testConfig, "Amount Charged Column", true, amntChargedUI);
	 
	 Boolean serviceAdjUI = serviceAdj.isDisplayed();  
	 Helper.compareEquals(testConfig, "Claim/Service Adj Charged Column", true, serviceAdjUI);
	 
	 Boolean provAdjUI = provAdj.isDisplayed();
	 Helper.compareEquals(testConfig, "Prov Adj Discount Column", true, provAdjUI);
	 
	 Boolean amntAllowedUI = amntAllowed.isDisplayed(); 
	 Helper.compareEquals(testConfig, "Amount Allowed Column", true, amntAllowedUI);
	 
	 Boolean copayUI = copay.isDisplayed();
	 Helper.compareEquals(testConfig, "Deduct/Coins/Copay Column", true, copayUI);
	 
	 Boolean paidPrvdrUI = paidPrvdr.isDisplayed();
	 Helper.compareEquals(testConfig, "Paid to Provider Column", true, paidPrvdrUI);
	 
	 Boolean adjcode_UI = adj_code.isDisplayed();
	 Helper.compareEquals(testConfig, "Adj Reason Code Column", true, adjcode_UI);
	 
	 Boolean rmkcode_UI = rmk_code.isDisplayed();
	 Helper.compareEquals(testConfig, "RMK Code Column", true, rmkcode_UI);
	
	 Boolean patientRespUI = patientResp.isDisplayed();
	 Helper.compareEquals(testConfig, "Patient Resp Column", true, patientRespUI);
	 
	 Boolean totalClaimTxtUI = totalClaimTxt.isDisplayed();
	 Helper.compareEquals(testConfig, "Total Claim Txt footer text", true, totalClaimTxtUI);
}

public void verifyColumnFootersClaimDtl() throws Exception
{	 
	 Boolean totalClaimTxtUI = totalClaimTxt.isDisplayed();
	 Helper.compareEquals(testConfig, "Total Claim Txt footer text", true, totalClaimTxtUI);
	 
	 String claimDtlDisc1 = "\"--\" indicates payer has not supplied this information.";
	 Element.verifyTextPresent(claimDtlDisc1);
	 
	 String claimDtlDisc2 = "In order to print the Claim, you must have Adobe Reader installed on your machine. Please download ";
	 Element.verifyTextPresent(claimDtlDisc2);
	 
	 String claimDtlDisc3 = " if it is not installed on your machine.";
	 Element.verifyTextPresent(claimDtlDisc3);
	 
	 Boolean adobeReaderLinkUI = adobeReaderLink.isDisplayed();
	 Helper.compareEquals(testConfig, "Adobe Reader link", true, adobeReaderLinkUI);
	 
	 Boolean privacyPolicyLinkUI = privacyPolicyLink.isDisplayed();
	 Helper.compareEquals(testConfig, "Privacy Policy Link", true, privacyPolicyLinkUI);
	 
	 Boolean termsOfUseUiLinkUI = termsOfUseUiLink.isDisplayed();
	 Helper.compareEquals(testConfig, "Terms of Use Link", true, termsOfUseUiLinkUI);
	 
	 Boolean returnToRemittanceDetailButtonUI = returnToRemittanceDetailButton.isDisplayed();
	 Helper.compareEquals(testConfig, "Return to Remittance Detail Button", true, returnToRemittanceDetailButtonUI);
	 
	 Boolean printClaimDetailButtonUI = printClaimDetailButton.isDisplayed();
	 Helper.compareEquals(testConfig, "print Claim Detail Button", true, printClaimDetailButtonUI);
	 
}

		public ViewPayments clickPaymentNumber(){
			paymentno=Element.findElement(testConfig, "xpath", "//p[contains(text(),'Payment Number :')]/a");
			Element.clickByJS(testConfig, paymentno, "Payment Number");
			return new ViewPayments(testConfig);
		}
		
		public void verifyClaimDtlPageData_latest(String usertype) throws Exception  {
			Browser.wait(testConfig, 2);
	        String ui_Payer = payernameUI.getText();
	        Log.Comment("The First Payer Name displayed is:" + ui_Payer);
	        testConfig.putRunTimeProperty("ui_Payer", ui_Payer);

	        Element.click(paymentNo1, "Payment No");
	        Browser.wait(testConfig, 2);
	        handleTechnicalDifficultyError();

	        String response = epsRemittanceDetailHelper.postRequestGetResponse(epsClaimsRequest.getEpsClaimsRequestWithIdentifier(getFinalIdentifier()));
	        Log.Comment("XML Response : \n"+response);
			coreFISLValidationWithClaimUI(response);
	 }
		
		private String getFinalIdentifier() {
	        String ucpConsolidatedPaymentNumber, payerSchemaUI, paymentNum, orginDateDB, finalidentifier;

	        if(testConfig.getRunTimeProperty("finalidentifier")==null) {
	            payerSchemaUI = DataBase.executeSelectQuery(testConfig, QUERY.GET_PAYER_SCHEMA, 1).get("PAYR_SCHM_NM").trim();
	            Log.Comment("Payer Schema is :" + payerSchemaUI);

	            String paymentNumberUI = paymentNo.getText();
	            paymentNum = paymentNo.getText().trim().substring(paymentNumberUI.lastIndexOf(":") + 1, paymentNumberUI.length()).trim();
	            testConfig.putRunTimeProperty("paymentNum", paymentNum);
	            ucpConsolidatedPaymentNumber = Browser.getURL(testConfig).split("ViewPaymentsPaymentNumber=")[1].substring(0, 10).trim();
	            testConfig.putRunTimeProperty("ucpConsolidatedPaymentNumber", ucpConsolidatedPaymentNumber);
	            Log.Comment("UCP consolidated payment number is :" + ucpConsolidatedPaymentNumber);

	            String[] dateUI = paymentDate.getText().split(": ")[1].split("/");
	            orginDateDB = dateUI[2] + dateUI[0] + dateUI[1];
	            Log.Comment("The Settlement Date is :" + orginDateDB);

	            finalidentifier = payerSchemaUI.concat("-").concat(ucpConsolidatedPaymentNumber).concat("-").concat(orginDateDB);
	            Log.Comment("The Final String is :" + finalidentifier);
	            testConfig.putRunTimeProperty("finalidentifier", finalidentifier);
	        }

	        return testConfig.getRunTimeProperty("finalidentifier");
	    }
		
		public void handleTechnicalDifficultyError() {
	        try {
	            int counter = 0;
	            while (errorPageUI.isDisplayed() && counter < 5) {
	                Browser.browserRefresh(testConfig);
	                counter++;
	            }
	        } catch (Throwable t) {
	            Log.Comment("Page Loaded successfully");
	        }
	    }
		
		private void coreFISLValidationWithClaimUI(String response) throws JAXBException{
			  EpsClaimsResponse epsClaimsResponse = epsRemittanceDetailHelper.convertXMLStringToPOJO(response);
             
			  if(epsClaimsResponse.getResponseReturnStatus().getResponseReturnCode().getCode().contentEquals("200")) {
				  int claimSize = epsClaimsResponse.getEpsClaims().size();
				  
				  for(int i=0; i<claimSize; i++){  
					  int r=1;
					  int c;
					  Log.Comment("claimSize is: "+ claimSize);				  
					  Element.findElement(testConfig, "xpath", String.format("//span[@id='claimID_%s']//a",i+1)).click();
					  
					  Log.Comment("Entered claim details page");
					  String firstName = epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getPersonName().getFirstName();			  
					  String middleName = epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getPersonName().getMiddleName();					  
					  String lastName = epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getPersonName().getLastName();
					  String subscriberIdentifier = epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getSubscriberIdentifier();
					  String accountNumber = epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getAccountNumber();
					  String claimIdentifier = epsClaimsResponse.getEpsClaims().get(i).getClaimIdentifier(); 
					  String groupIdentifier = epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getGroupThumbnail().getGroupIdentifier(); 
					  String productName = epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getProductName();
					  String claimPayAmount = addingZeroAtTheEnd(epsClaimsResponse.getEpsClaims().get(i).getClaimPayAmount());
					  String TotalClaimUI = Element.findElement(testConfig, "xpath", "//td[contains(text(),'Total Claim Paid')]").getText();
					  TotalClaimUI = TotalClaimUI.substring(TotalClaimUI.indexOf("$")+1, TotalClaimUI.length());
					  Helper.compareEquals(testConfig, "Total Claim UI", claimPayAmount, TotalClaimUI);
				
		//Adding claim list first row  
					  ArrayList<String> claimslist = new ArrayList<String>();
					  claimslist.add(accountNumber);
					  if(middleName.length() > 0) {
						  claimslist.add(firstName+" "+middleName+" "+lastName+"/"+subscriberIdentifier);
			    	  }
					  else {
						  claimslist.add(firstName+" "+lastName+"/"+subscriberIdentifier);
					  }
					  claimslist.add(subscriberIdentifier);
					  claimslist.add(null);
					  claimslist.add(claimIdentifier);
					  claimslist.add(groupIdentifier+"/"+productName);
					  
					  for(int q=1; q<=6; q++) {
						  if(q==4 || q==1) {
							  continue;
						  }
					      String claimListUI = Element.findElement(testConfig, "xpath", String.format("//p[contains(text(),'Payment Type:')]/../../../../../../../tr[3]//table[1]/tbody/tr[3]/td[%s][1]",q)).getText(); 
					      if(claimListUI.contains("/")) {
					    	  String[] nameUI1 = claimListUI.split("/");
					    	  String nameUI = nameUI1[0]; 
				              Helper.compareEquals(testConfig,"Validating Claim List details", true,claimslist.get(q-1).contains(nameUI));
					      }
					      else {
		                      Helper.compareEquals(testConfig, "Validating Claim List details", claimslist.get(q-1),claimListUI);
					      }      
					  } 
					  
					  int claimServicesSize = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().size();
					  Log.Comment("claimServicesSize is: "+ claimServicesSize);		  
		              Helper.compareEquals(testConfig,"Validating claim service size",String.valueOf(claimServicesSize),String.valueOf(Element.findElements(testConfig, "xpath", "//td[contains(text(),'Service Subtotal')]").size()));
			
					  for(int j=0; j<claimServicesSize; j++) {
						  String serviceStartDate = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getServiceStartDate(); 
						  String serviceEndDate = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getServiceEndDate();  
						  String epsServiceDescription = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsServiceDescription(); 
						  String lineItemChargeAmount = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getLineItemChargeAmount();  
						  lineItemChargeAmount = addingZeroAtTheEnd(lineItemChargeAmount);
						  String allowedAmount = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getAllowedAmount();   
						  allowedAmount = addingZeroAtTheEnd(allowedAmount);
						  String lineItemPaidAmount = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getLineItemPaidAmount();  
						  lineItemPaidAmount = addingZeroAtTheEnd(lineItemPaidAmount);
						  int ClaimPaymentServiceAdjustmentsSize = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().size();
						  Log.Comment("ClaimPaymentServiceAdjustmentsSize is: "+ ClaimPaymentServiceAdjustmentsSize);
						  String code1 = null;
						  String deductibleCoInsuranceCoPayAmount = null;
						  String amount;
						  String code2;
						  String PatientResponsibilityTotalAmount;
						  if(ClaimPaymentServiceAdjustmentsSize == 2) {
							  code1 = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().get(0).getEpsClaimPaymentAdjustmentReasonCodes().getCode(); 				  
							  deductibleCoInsuranceCoPayAmount = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().get(0).getDeductibleCoInsuranceCoPayAmount();  
							  amount = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().get(1).getAmount(); 
							  amount = addingZeroAtTheEnd(amount);					  
							  code2 = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().get(1).getEpsClaimPaymentAdjustmentReasonCodes().getCode(); 
							  PatientResponsibilityTotalAmount = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().get(1).getPatientResponsibilityTotalAmount();
							  PatientResponsibilityTotalAmount = addingZeroAtTheEnd(PatientResponsibilityTotalAmount);
						  }
						  else {
							  amount = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().get(0).getAmount();  
							  amount = addingZeroAtTheEnd(amount);						  
							  code2 = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().get(0).getEpsClaimPaymentAdjustmentReasonCodes().getCode(); 
							  PatientResponsibilityTotalAmount = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().get(0).getPatientResponsibilityTotalAmount();
							  PatientResponsibilityTotalAmount = addingZeroAtTheEnd(PatientResponsibilityTotalAmount);
						  }
						  
					      //Adding each cell value corresponding to each claim services details from the API which we want to validate dynamically
						  ArrayList<String> claimsServiceslist = new ArrayList<String>();
						  claimsServiceslist.add(Helper.changeDateFormat(testConfig, serviceStartDate, "yyyy-mm-dd", "mm/dd/yyyy")+" - "+Helper.changeDateFormat(testConfig, serviceEndDate, "yyyy-mm-dd", "mm/dd/yyyy"));
						  claimsServiceslist.add(epsServiceDescription);
						  
						  if(lineItemChargeAmount != null) {
							  claimsServiceslist.add("$"+lineItemChargeAmount);
						  };
						  if(allowedAmount != null) {
							  claimsServiceslist.add("$"+allowedAmount);
						  };
						  if(lineItemPaidAmount != null) {
							  claimsServiceslist.add("$"+lineItemPaidAmount);
						  };
						  if(ClaimPaymentServiceAdjustmentsSize==2) {
							  if(deductibleCoInsuranceCoPayAmount != null) {
								  claimsServiceslist.add("-$"+deductibleCoInsuranceCoPayAmount);
							  };
							  if(code1 != null) {
								  claimsServiceslist.add(code1);
							  };
							  if(deductibleCoInsuranceCoPayAmount != null) {
								  claimsServiceslist.add("$"+deductibleCoInsuranceCoPayAmount);
							  };
							  if(amount != null && !amount.contentEquals("0.00")) {
								  claimsServiceslist.add("-$"+amount);
							  };
							  if(code2 != null) {
								  claimsServiceslist.add(code2);
							  }
							  if(PatientResponsibilityTotalAmount != null && !PatientResponsibilityTotalAmount.contentEquals("0.00")) {
								  claimsServiceslist.add("$"+PatientResponsibilityTotalAmount);
							  }
						  }
						  else {
							  if(amount != null && !amount.contentEquals("0.00")) {  
								  claimsServiceslist.add("-$"+amount);
							  }
							  if(code2 != null) {
								  claimsServiceslist.add(code2);
							  }  
							  if(PatientResponsibilityTotalAmount != null && !PatientResponsibilityTotalAmount.contentEquals("0.00")) {
								  claimsServiceslist.add("$"+PatientResponsibilityTotalAmount);
							  }
						  }
						  int rowNum = Element.findElements(testConfig, "xpath", "//div[@id='flow1']//tr").size();  
						  int colNum = Element.findElements(testConfig, "xpath", "//div[@id='flow1']//tr[1]/td").size(); 
						  boolean flag=false;
						  int t=0;
					
						  //Iterating the UI elements and asserting API vs UI	  
						  for(; r<rowNum; r++) {
							  for(c=1; c<=colNum; c++) {
								  if(t < claimsServiceslist.size()) {
									  String claimListUI = Element.findElement(testConfig, "xpath", String.format("//div[@id='flow1']//tr[%s]/td[%s]",r,c)).getText().trim();
									  if(claimListUI.trim().contentEquals("--") || claimListUI.length() < 1) {
										  continue;
									  }
									  else {										    
										    Helper.compareEquals(testConfig, "Validating claim details in each cells in API vs UI", claimsServiceslist.get(t), claimListUI);
											t++;
											if(t == claimsServiceslist.size()) {
												 flag = true;
											} 
									  }  
								 }
								  if(flag==true) { break; }
							  }
							  if(flag==true) { break; }
						  }
						  r=r+2;
					  }	  					  
						  Log.Comment("#########################################################################################");			  
						  testConfig.driver.navigate().back();
					  }
				  }
			  }
		
		public String addingZeroAtTheEnd(String test) {
			if(test.trim().contentEquals("--") || test.length() < 1) {
				return null;
			}
			if(test.charAt(test.length()-2)=='.') {
				 test = test.concat("0");
			}
			return test;
	   }
	    
}






