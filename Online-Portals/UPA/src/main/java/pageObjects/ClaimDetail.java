package main.java.pageObjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
import main.java.reporting.*;

import com.mysql.jdbc.StringUtils;
import org.openqa.selenium.Dimension;
//import main.java.Utils.Config;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
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

public class ClaimDetail {
	
	
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
	@FindBy(xpath = "//td[starts-with(text(),'Organization:')]") WebElement orgHeader;
	@FindBy(xpath = "//td[starts-with(text(),'Payment Date')]") WebElement paymentDate;
    @FindBy(xpath = "//td[contains(text(),'Payment Type:')]") WebElement paymentType;
	@FindBy(xpath = "//td[contains(text(),'Payment Number')]") WebElement paymentNumber;
	@FindBy(xpath = "//td[contains(text(),'NPI')]") WebElement  claimNPI;
	@FindBy(name="claimType")	WebElement filterClaims;
	//@FindBy(xpath = "//select[@name='claimType']") WebElement filterClaims;
	@FindBy(xpath = "//select[@name='claimType']//option") WebElement filterClaimsOptions;
	@FindBy(xpath = "//td[contains(text(),'Account Number')]") WebElement acctNum;
	@FindBy(xpath = "//a[contains(text(),'Patient Name')]") WebElement patientName;
	@FindBy(xpath = "//span[contains(text(),'Patient ID')]") WebElement patientID;
	@FindBy(xpath = "//span[contains(text(),'Subscriber ID')]") WebElement subscbrID;
	@FindBy(xpath = "//span[contains(text(),'Corrected ID')]") WebElement correctedID;
	@FindBy(xpath = "//td[contains(text(),'Rendering Provider')]") WebElement rendPrvdr;
	@FindBy(xpath = "//td[contains(text(),'Claim #')]") WebElement claimHeader;
	@FindBy(xpath = "//td[starts-with(text(),'Group')]") WebElement grpPolicy;
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
	@FindBy(xpath = "//td[contains(text(),'Remark Code')]") WebElement remarkCode;
	@FindBy(xpath = "//td[contains(text(),'Description')]") WebElement remarkDesc;
	@FindBy(xpath = "//td[contains(text(),'Adjustment Code')]") WebElement adjustmentCode;
	@FindBy(xpath = "//td[contains(text(),'Description')]") WebElement adjustmentDesc;
	@FindBy(xpath = "//span[@class='pageNo'][contains(text(),'1')]") WebElement paginationNo1;
	@FindBy(xpath = "//span[@class='pageNo'][contains(text(),'2')]") WebElement paginationNo2;
	@FindBy(xpath = "//tr[@class='rowDarkbold']/td[1]") WebElement subTotRecord;
	@FindBy(xpath = "//a[contains(text(),'Next')]") WebElement remitNext;
    @FindBy(xpath = "//form[1]/table[1]/tbody[1]/tr[7]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]") WebElement payernameUI;
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
	
	
	
	
	
	
	
private TestBase testConfig;

public ClaimDetail(TestBase testConfig)
{
	this.testConfig=testConfig;
	PageFactory.initElements(testConfig.driver, this);
}
	

public void verifyClaimDtlPageData() throws Exception
{
	Browser.wait(testConfig, 2);
	String ui_Payer = payerUI.getText();
    Log.Comment("The First Payer Name displayed is:" + ui_Payer);
	Element.click(paymentNo1, "Payment No");
	Browser.wait(testConfig, 2);
	String paymentNum1 = paymentno.getText();
	String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
	Log.Comment("The First Payment Number displayed is:" + paymentNum);
	Element.click(claimHash, "Claim Type");
    Browser.wait(testConfig, 3);
	List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
	
    for(WebElement patientNamesUI :patientNames) 
	{
    	Log.Comment(patientNamesUI.getText());
	}
	 
	int sqlRowNo = 184;
	testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
	Map payerSchema = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	Log.Comment("Message from DB for Payer Schema:" + payerSchema);
	
	if(null == payerSchema)
	{
		
		sqlRowNo = 203;
		testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
		Map payerSchema1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		
		String payerSchemaUI = (payerSchema1.toString()).substring(14,19);
		Log.Comment("Payer Schema is :" + payerSchemaUI);
		
	    sqlRowNo = 185;
		testConfig.putRunTimeProperty("paymentNum",paymentNum);
		Map paymentNumDB1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String paymentNumDB2 = (paymentNumDB1.toString());
		String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length() - 1);
		String paymentNumDB = paymentNumDB3.substring(18,paymentNumDB3.length());
		Log.Comment("The UCP_CONSL_PAY_NBR is :" + paymentNumDB);
	    
		sqlRowNo = 186;
		testConfig.putRunTimeProperty("paymentNum",paymentNum);
		Map orginDate = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String orginDateDB1 = orginDate.toString();
		String orginDateDB2 = orginDateDB1.substring(1, orginDateDB1.length() - 1);
		String orginDateDB3 = orginDateDB2.substring(11,orginDateDB2.length());
		String orginDateDB = orginDateDB3.replaceAll("-", "");
		Log.Comment("The Settlement Date is :" + orginDateDB);
		String finalidentifier = payerSchemaUI.concat("-").concat(paymentNumDB).concat("-").concat(orginDateDB);
		Log.Comment("The Final String is :" + finalidentifier);
		
		
		String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
                "<ns17:EpsClaimsRequest xmlns:ns10=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns1=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\">\r\n" +
                "<ns1:SearchCriteria ns1:FromRecord=\"-1\" ns1:MaxResult=\"10\" ns1:SortDirection=\"ASC\" ns1:SortFieldNumber=\"0\"/>\r\n" +
                "<ns3:PaymentIdentifier>"+finalidentifier+"</ns3:PaymentIdentifier>\r\n" + 
                "</ns17:EpsClaimsRequest>";
		
		
		String getResponse=new FISLConnection2().getEraResponse1(requestXml);
		
		String firstNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientFirstName>")+22, getResponse.indexOf("</ns0:PatientFirstName>"));
		
	    String firstPatientUI1 = firstPatient.getText();
	    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
	    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
	    
	    if(!firstNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient First Name FISL and UI", firstNameDB, firstPatientUI);
		
	    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
		String lastPatientUI1 = firstPatient.getText();
	    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));
	    
	    if(!lastNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient Last Name FISL and UI", lastNameDB, lastPatientUI);
		
	    
	    
	    String amountChargedUI1 = amntChargedUI.getText();
	    String amountChargedUI = "";
	    if(amountChargedUI1.contains("-"))
	    {

	    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
	    	{
	    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
	    		
	    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    		amountChargedUI = Double.toString(amountChargedUI4);
	    	 }
	    	
	    	else if (amountChargedUI1.contains("$")) 
	    	{
			 
	    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
	    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    	  amountChargedUI = Double.toString(amountChargedUI4);
	    	 }
	    	
	    	else if (amountChargedUI1.contains(",")) {
	    		
	    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
	    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    		amountChargedUI = Double.toString(amountChargedUI4);
		     }
	    }
	    
	    else if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
	    {
	    	String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
	    	double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    	amountChargedUI = Double.toString(amountChargedUI4);
	    }
	   
	    else if(amountChargedUI1.contains("$"))
	    {
	    	String amountChargedUI3 = (amountChargedUI1.replace("$", ""));
	    	double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    	amountChargedUI = Double.toString(amountChargedUI4);
	    }
	    
	    else if(amountChargedUI1.contains(","))
	    {
	    	String amountChargedUI3 = (amountChargedUI1.replace("$", ""));
	    	double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    	amountChargedUI = Double.toString(amountChargedUI4);
	    }
 
	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns0:LineItemChargeAmount>")+26, getResponse.indexOf("</ns0:LineItemChargeAmount>"));
	    
	    if(!amountChargedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Amounts Charged FISL and UI", amountChargedDB, amountChargedUI);

	    String grp = testConfig.driver.findElement(By.xpath("//span[@id='grpID_']")).getText();
	    
	   if(!grp.contains(""))
	    {
	   	 String grpPolicyUI1 = grpPolicyUI.getText();
	   	 if(grpPolicyUI1.contains("/"))
	   	 {
	            String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
	        	 
	        	 if(grpPolicyOnline.length()!=0)
	        	 {
	        		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
		             if(!grpPolicyDB.equalsIgnoreCase("0"))
		             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyOnline);
	        	 }
	        	 
	        	 else
	        	 {
	        	    Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	        	 }
	        }
	   	 else
	   	 {
	   		  String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	            
	            if(!grpPolicyDB.equalsIgnoreCase("0"))
	             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyUI1);
	        }
	     }
	   else
	   {
	      Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	   }

	    if(testConfig.driver.findElements(By.xpath("//span[@id='grpID_']")).size() != 0)
	    {
	   	 
	   	 String grpPolicyUI1 = grpPolicyUI.getText();
	    
	       if(grpPolicyUI1.contains("/"))
	        {
	    
	          if(!grpPolicyUI1.isEmpty())
	           {
			        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
			        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
			        if(!productNameDB.equalsIgnoreCase("0"))
			          	Helper.compareEquals(testConfig, "Comparing Product Name FISL and UI", productNameDB, productNameUI);
	            }
	        }
	    }
	    
	    else
	    {
	      Log.Comment("The Product Name doesnt exists for this Criteria");
	    }
	    
	    String subscrbrUI = subscriberUI1.getText();
	    String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	    if(!subscrbrDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Subscriber ID FISL and UI", subscrbrDB, subscrbrUI);
	  
	    String claimHashUI = claimHash1.getText();
	    String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
	    if(!claimTypeDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Claim Identifier FISL and UI", claimTypeDB, claimHashUI);
	 	 
	    String accntNumUI = accntNum.getText();
	    String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
	    if(!accntNumDB.equalsIgnoreCase("0"))
	      	Helper.compareEquals(testConfig, "Comparing Account Number FISL and UI", accntNumDB, accntNumUI);
	   
	    String amntAllowedUI1 = amntallowed.getText();
	    String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
	    String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
	    if(!amntAllowedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Allowed Amounts FISL and UI", accntNumDB, accntNumUI);
	  
	   
	     /*
	     String CopayUI1 = copayUI.getText();
	     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
	     Log.Comment("Copay Amount from UI is :" + CopayUI);
	     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
	     Log.Comment("Copay Amount from FISL is :" + CopayDB);
	     if(!CopayDB.equalsIgnoreCase("0"))
	         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
	       */
	    // String patientrespUI1 = patientresp.getText();
//	     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//	     double patientrespU3 = Double.parseDouble(patientrespUI2);
//		 String patientrespUI = Double.toString(patientrespU3);
//	     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//	     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//	     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//	     if(!patientrespDB.equalsIgnoreCase("0"))
//	         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", patientrespDB, patientrespUI);
 
	}
	
	else
		
	{
		String payerSchemaUI = (payerSchema.toString()).substring(14, 19);
	    Log.Comment("Payer Schema is :" + payerSchemaUI);
	
	sqlRowNo = 185;
	testConfig.putRunTimeProperty("paymentNum",paymentNum);
	Map paymentNumDB1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String paymentNumDB2 = paymentNumDB1.toString();
	String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length()- 1);
	String paymentNumDB = paymentNumDB3.substring(18,paymentNumDB3.length());
	Log.Comment("The UCP_CONSL_PAY_NBR is :" + paymentNumDB);
    
	sqlRowNo = 186;
	testConfig.putRunTimeProperty("paymentNum",paymentNum);
	Map orginDate = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String orginDateDB1 = orginDate.toString();
	String orginDateDB2 = orginDateDB1.substring(1, orginDateDB1.length() - 1);
	String orginDateDB3 = orginDateDB2.substring(11,orginDateDB2.length());
    String orginDateDB = orginDateDB3.replaceAll("-","");
    Log.Comment("The Settlement Date is :" + orginDateDB);
    String finalidentifier = payerSchemaUI.concat("-").concat(paymentNumDB).concat("-").concat(orginDateDB);
    Log.Comment("The Final String is :" + finalidentifier);
	
	String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
                         "<ns17:EpsClaimsRequest xmlns:ns10=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns1=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\">\r\n" +
                         "<ns1:SearchCriteria ns1:FromRecord=\"-1\" ns1:MaxResult=\"10\" ns1:SortDirection=\"ASC\" ns1:SortFieldNumber=\"0\"/>\r\n" +
                         "<ns3:PaymentIdentifier>"+finalidentifier+"</ns3:PaymentIdentifier>\r\n" + 
                         "</ns17:EpsClaimsRequest>";
	
	String getResponse=new FISLConnection2().getEraResponse1(requestXml);
	
	String firstNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientFirstName>")+22, getResponse.indexOf("</ns0:PatientFirstName>"));
	String firstPatientUI1 = firstPatient.getText();
    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
    
    if(!firstNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
	
    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
	String lastPatientUI1 = firstPatient.getText();
    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));
    if(!lastNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient Last Name FISL and UI", lastNameDB, lastPatientUI);
	
    String amountChargedUI1 = amntChargedUI.getText();
    String amountChargedUI = "";
    if(amountChargedUI1.contains(","))
    {
	    String amountChargedUI2  = amountChargedUI1.substring(1, amountChargedUI1.length());
	    String amountChargedUI3 = amountChargedUI2.replace(",", "").trim();
	    double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    amountChargedUI = Double.toString(amountChargedUI4);
    }
    else if(amountChargedUI1.contains("$"))
    {     
    	 String amountChargedUI2 = amountChargedUI1.replace("$", "");
    	 amountChargedUI = amountChargedUI2.substring(0, amountChargedUI2.length()-1);
    }

    
//    String amountChargedUI1 = amntChargedUI.getText();
//    String amountChargedUI2  = amountChargedUI1.substring(1, amountChargedUI1.length());
//    String amountChargedUI3 = amountChargedUI2.replace(",", "").trim();
//    double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
//    String amountChargedUI = Double.toString(amountChargedUI4);
//    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns0:LineItemChargeAmount>")+26, getResponse.indexOf("</ns0:LineItemChargeAmount>"));
    
    if(!amountChargedDB.equalsIgnoreCase("0"))
       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);
   String grp = testConfig.driver.findElement(By.xpath("//span[@id='grpID_']")).getText();
    
   if(!grp.contains(""))
    {
   	 String grpPolicyUI1 = grpPolicyUI.getText();
   	 if(grpPolicyUI1.contains("/"))
   	 {
            String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
        	 
        	 if(grpPolicyOnline.length()!=0)
        	 {
        		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	             
	             if(!grpPolicyDB.equalsIgnoreCase("0"))
	             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyOnline);
        	 }
        	 
        	 else
        	 {
        	     Log.Comment("The Group Policy Number doesnt exists for this Criteria");
        	 }
        }
   	 else
   	 {
   		    String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
             if(!grpPolicyDB.equalsIgnoreCase("0"))
             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyUI1);
        }
     }
   else
   {
      Log.Comment("The Group Policy Number doesnt exists for this Criteria");
   }

    if(testConfig.driver.findElements(By.xpath("//span[@id='grpID_']")).size() != 0)
    {
   	 
   	 String grpPolicyUI1 = grpPolicyUI.getText();
    
       if(grpPolicyUI1.contains("/"))
        {
    
          if(!grpPolicyUI1.isEmpty())
           {
		        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n", "");
		        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
		        if(!productNameDB.equalsIgnoreCase("0"))
		          	Helper.compareEquals(testConfig, "Comparing Product Name FISL and UI", productNameDB, productNameUI);
            }
         }
    }
    
    else
    {
      Log.Comment("The Product Name doesnt exists for this Criteria");
    }
    
    String subscrbrUI = subscriberUI1.getText();
    String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
    if(!subscrbrDB.equalsIgnoreCase("0"))
       Helper.compareEquals(testConfig, "Comparing Subscriber ID FISL and UI", subscrbrDB, subscrbrUI);
  
    String claimHashUI = claimHash1.getText();
    String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
    if(!claimTypeDB.equalsIgnoreCase("0"))
       Helper.compareEquals(testConfig, "Comparing Claim Identifier FISL and UI", claimTypeDB, claimHashUI);
 	 
    String accntNumUI = accntNum.getText();
    String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
    if(!accntNumDB.equalsIgnoreCase("0"))
      	Helper.compareEquals(testConfig, "Comparing Account Number FISL and UI", accntNumDB, accntNumUI);
   
    String amntAllowedUI1 = amntallowed.getText();
    String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
    String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));

    if(!amntAllowedDB.equalsIgnoreCase("0"))
       Helper.compareEquals(testConfig, "Comparing Allowed Amounts FISL and UI", accntNumDB, accntNumUI);
  
    /*
    String CopayUI1 = copayUI.getText();
    String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
    Log.Comment("Copay Amount from UI is :" + CopayUI);
    String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
    Log.Comment("Copay Amount from FISL is :" + CopayDB);
    if(!CopayDB.equalsIgnoreCase("0"))
        Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
      */
//    String patientrespUI1 = patientresp.getText();
//    String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//    double patientrespU3 = Double.parseDouble(patientrespUI2);
//	 String patientrespUI = Double.toString(patientrespU3);
//    Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//    String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//    Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//    if(!patientrespDB.equalsIgnoreCase("0"))
//        Helper.compareEquals(testConfig, "Comparing Patient Responsibility Amount UI and DB", patientrespDB, patientrespUI);
//


	}
	
}

public void verifyClaimDtlPageData(String usertype) throws Exception  
{
	if(usertype == "Payer")
	{
		Browser.wait(testConfig, 2);
		String ui_Payer = payerUI.getText();
		//String ui_Payer = payernameUI.getText();
	    Log.Comment("The First Payer Name displayed is:" + ui_Payer);
		Element.click(paymentNo1, "Payment No");
		Browser.wait(testConfig, 2);
		String paymentNum1 = paymentno.getText();
		String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
		Log.Comment("The First Payment Number displayed is:" + paymentNum);
		Element.click(claimHash, "Claim Type");
	    Browser.wait(testConfig, 3);
		List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
		
	    for(WebElement patientNamesUI :patientNames) 
		{
	    	Log.Comment(patientNamesUI.getText());
		}
		 
		int sqlRowNo = 184;
		testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
		Map payerSchema = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Log.Comment("Message from DB for Payer Schema:" + payerSchema);
		
		if(null == payerSchema)
		{
		    sqlRowNo = 203;
			testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
			Map payerSchema1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			
			String payerSchemaUI = (payerSchema1.toString()).substring(14,19);
			Log.Comment("Payer Schema is :" + payerSchemaUI);
			
		    sqlRowNo = 185;
			testConfig.putRunTimeProperty("paymentNum",paymentNum);
			Map paymentNumDB1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			String paymentNumDB2 = (paymentNumDB1.toString());
			String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length() - 1);
			String paymentNumDB = paymentNumDB3.substring(18,paymentNumDB3.length());
			Log.Comment("The UCP_CONSL_PAY_NBR is :" + paymentNumDB);
		    
			sqlRowNo = 186;
			testConfig.putRunTimeProperty("paymentNum",paymentNum);
			Map orginDate = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			String orginDateDB1 = orginDate.toString();
			String orginDateDB2 = orginDateDB1.substring(1, orginDateDB1.length() - 1);
			String orginDateDB3 = orginDateDB2.substring(11,orginDateDB2.length());
			String orginDateDB = orginDateDB3.replaceAll("-", "");
			Log.Comment("The Settlement Date is :" + orginDateDB);
			String finalidentifier = payerSchemaUI.concat("-").concat(paymentNumDB).concat("-").concat(orginDateDB);
			Log.Comment("The Final String is :" + finalidentifier);
			
			String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
	                "<ns17:EpsClaimsRequest xmlns:ns10=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns1=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\">\r\n" +
	                "<ns1:SearchCriteria ns1:FromRecord=\"-1\" ns1:MaxResult=\"10\" ns1:SortDirection=\"ASC\" ns1:SortFieldNumber=\"0\"/>\r\n" +
	                "<ns3:PaymentIdentifier>"+finalidentifier+"</ns3:PaymentIdentifier>\r\n" + 
	                "</ns17:EpsClaimsRequest>";
			
			String getResponse=new FISLConnection2().getEraResponse1(requestXml);
			
			String firstNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientFirstName>")+22, getResponse.indexOf("</ns0:PatientFirstName>"));
			String firstPatientUI1 = firstPatient.getText();
		    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
		    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
		    
		    if(!firstNameDB.equalsIgnoreCase("0"))
		    	Helper.compareEquals(testConfig, "Comparing Patient First Name FISL and UI", firstNameDB, firstPatientUI);
			
		    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
			String lastPatientUI1 = firstPatient.getText();
		    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));
            if(!lastNameDB.equalsIgnoreCase("0"))
		    	Helper.compareEquals(testConfig, "Comparing Patient Last Name FISL and UI", lastNameDB, lastPatientUI);
			
		    String amountChargedUI1 = amntChargedUI.getText();
		    String amountChargedUI = "";
		    if(amountChargedUI1.contains("-"))
		    {
                if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
		    	{
		    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
		    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    		amountChargedUI = Double.toString(amountChargedUI4);
		    	}
		    	
		    	else if (amountChargedUI1.contains("$")) 
		    	{
				 
		    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
		    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    	  amountChargedUI = Double.toString(amountChargedUI4);
		    	}
		    	else if (amountChargedUI1.contains(",")) {
		    		
		    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
		    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    		amountChargedUI = Double.toString(amountChargedUI4);
			   }
		    }
		    
		    else if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
		    {
		    	String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
		    	double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    	amountChargedUI = Double.toString(amountChargedUI4);
		    }
		   
		    else if(amountChargedUI1.contains("$"))
		    {
		    	String amountChargedUI3 = (amountChargedUI1.replace("$", ""));
		    	double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    	amountChargedUI = Double.toString(amountChargedUI4);
		    }
		    
		    else if(amountChargedUI1.contains(","))
		    {
		    	String amountChargedUI3 = (amountChargedUI1.replace("$", ""));
		    	double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    	amountChargedUI = Double.toString(amountChargedUI4);
		    }
		    
		    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>"));
		     if(!amountChargedDB.equalsIgnoreCase("0"))
		       Helper.compareEquals(testConfig, "Comparing Amounts Charged FISL and UI", amountChargedDB, amountChargedUI);
	
//		    String amountChargedUI1 = amntChargedUI.getText();
//		    String amountChargedUI2  = amountChargedUI1.substring(1, amountChargedUI1.length());
//		    String amountChargedUI3 = amountChargedUI2.replace(",", "").trim();
//		    double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
//		    String amountChargedUI = Double.toString(amountChargedUI4);
//		    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
//		    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns0:LineItemChargeAmount>")+26, getResponse.indexOf("</ns0:LineItemChargeAmount>"));
//		    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
//		    if(!amountChargedDB.equalsIgnoreCase("0"))
//		       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

		    
		    String grp = testConfig.driver.findElement(By.xpath("//span[@id='grpID_']")).getText();

		    if(!grp.contains(""))
		    {
		   	 String grpPolicyUI1 = grpPolicyUI.getText();
		   	 if(grpPolicyUI1.contains("/"))
		   	 {
		            String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
		        	 
		        	 if(grpPolicyOnline.length()!=0)
		        	 {
		        		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
			            if(!grpPolicyDB.equalsIgnoreCase("0"))
			             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyOnline);
		        	 }
		        	 
		        	 else
		        	 {
		        	      Log.Comment("The Group Policy Number doesnt exists for this Criteria");
		        	 }
		        }
		   	 else
		   	 {
		            String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
		            if(!grpPolicyDB.equalsIgnoreCase("0"))
		             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyUI1);
		      }
		     }
		   else
		   {
		      Log.Comment("The Group Policy Number doesnt exists for this Criteria");
		   }

		    if(testConfig.driver.findElements(By.xpath("//span[@id='grpID_']")).size() != 0)
		    {
		   	 
		   	 String grpPolicyUI1 = grpPolicyUI.getText();
		    
		       if(grpPolicyUI1.contains("/"))
		        {
		    
		          if(!grpPolicyUI1.isEmpty())
		           {
				        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n", "");
				        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
				         if(!productNameDB.equalsIgnoreCase("0"))
				          	Helper.compareEquals(testConfig, "Comparing Product Name FISL and UI", productNameDB, productNameUI);
		           }
		        }
		    }
		    
		    else
		    {
		      Log.Comment("The Product Name doesnt exists for this Criteria");
		    }
		    
		    String subscrbrUI = subscriberUI1.getText();
		    String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
		    if(!subscrbrDB.equalsIgnoreCase("0"))
		       Helper.compareEquals(testConfig, "Comparing Subscriber ID FISL and UI", subscrbrDB, subscrbrUI);
		  
		    String claimHashUI = claimHash1.getText();
		    String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
		    if(!claimTypeDB.equalsIgnoreCase("0"))
		       Helper.compareEquals(testConfig, "Comparing Claim Identifier FISL and UI", claimTypeDB, claimHashUI);
		 	 
		    String accntNumUI = accntNum.getText();
		    String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
		    if(!accntNumDB.equalsIgnoreCase("0"))
		      	Helper.compareEquals(testConfig, "Comparing Account Number FISL and UI", accntNumDB, accntNumUI);
		   
		    String amntAllowedUI1 = amntallowed.getText();
		    String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
		    String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
		    if(!amntAllowedDB.equalsIgnoreCase("0"))
		       Helper.compareEquals(testConfig, "Comparing Allowed Amounts FISL and UI", amntAllowedDB, amntAllowedUI);
		  
		   
		     /*
		     String CopayUI1 = copayUI.getText();
		     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
		     Log.Comment("Copay Amount from UI is :" + CopayUI);
		     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
		     Log.Comment("Copay Amount from FISL is :" + CopayDB);
		     if(!CopayDB.equalsIgnoreCase("0"))
		         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
		       */
		    // String patientrespUI1 = patientresp.getText();
//		     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//		     double patientrespU3 = Double.parseDouble(patientrespUI2);
//			 String patientrespUI = Double.toString(patientrespU3);
//		     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//		     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//		     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//		     if(!patientrespDB.equalsIgnoreCase("0"))
//		         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", patientrespDB, patientrespUI);
	 
		}
		
		else
			
		{
			String payerSchemaUI = (payerSchema.toString()).substring(14, 19);
		    Log.Comment("Payer Schema is :" + payerSchemaUI);
		
		sqlRowNo = 185;
		testConfig.putRunTimeProperty("paymentNum",paymentNum);
		Map paymentNumDB1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String paymentNumDB2 = paymentNumDB1.toString();
		String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length()- 1);
		String paymentNumDB = paymentNumDB3.substring(18,paymentNumDB3.length());
		Log.Comment("The UCP_CONSL_PAY_NBR is :" + paymentNumDB);
	    
		sqlRowNo = 186;
		testConfig.putRunTimeProperty("paymentNum",paymentNum);
		Map orginDate = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String orginDateDB1 = orginDate.toString();
		String orginDateDB2 = orginDateDB1.substring(1, orginDateDB1.length() - 1);
		String orginDateDB3 = orginDateDB2.substring(11,orginDateDB2.length());
	    String orginDateDB = orginDateDB3.replaceAll("-","");
	    Log.Comment("The Settlement Date is :" + orginDateDB);
	    String finalidentifier = payerSchemaUI.concat("-").concat(paymentNumDB).concat("-").concat(orginDateDB);
	    Log.Comment("The Final String is :" + finalidentifier);
		
		String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
	                         "<ns17:EpsClaimsRequest xmlns:ns10=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns1=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\">\r\n" +
	                         "<ns1:SearchCriteria ns1:FromRecord=\"-1\" ns1:MaxResult=\"10\" ns1:SortDirection=\"ASC\" ns1:SortFieldNumber=\"0\"/>\r\n" +
	                         "<ns3:PaymentIdentifier>"+finalidentifier+"</ns3:PaymentIdentifier>\r\n" + 
	                         "</ns17:EpsClaimsRequest>";
		String getResponse=new FISLConnection2().getEraResponse1(requestXml);
		
		String firstNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientFirstName>")+22, getResponse.indexOf("</ns0:PatientFirstName>"));
		String firstPatientUI1 = firstPatient.getText();
	    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
	    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
	    if(!firstNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient First Name FISL and UI", firstNameDB, firstPatientUI);
		
	    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
		String lastPatientUI1 = firstPatient.getText();
	    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));
        if(!lastNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient Last Name FISL and UI", lastNameDB, lastPatientUI);
		
	    String amountChargedUI1 = amntChargedUI.getText();
	    String amountChargedUI = "";
	    if(amountChargedUI1.contains(","))
	    {
		    String amountChargedUI2  = amountChargedUI1.substring(1, amountChargedUI1.length());
		    String amountChargedUI3 = amountChargedUI2.replace(",", "").trim();
		    double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    amountChargedUI = Double.toString(amountChargedUI4);
	    }
	    else if(amountChargedUI1.contains("$"))
	    {     
	    	 String amountChargedUI2 = amountChargedUI1.replace("$", "");
	    	 amountChargedUI = amountChargedUI2.substring(0, amountChargedUI2.length()-1);
	    }

//	    String amountChargedUI1 = amntChargedUI.getText();
//	    String amountChargedUI2  = amountChargedUI1.substring(1, amountChargedUI1.length());
//	    String amountChargedUI3 = amountChargedUI2.replace(",", "").trim();
//	    double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
//	    String amountChargedUI = Double.toString(amountChargedUI4);
//	    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns0:LineItemChargeAmount>")+26, getResponse.indexOf("</ns0:LineItemChargeAmount>"));
	    if(!amountChargedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Amounts Charged FISL and UI", amountChargedDB, amountChargedUI);

	   String grp = testConfig.driver.findElement(By.xpath("//span[@id='grpID_']")).getText();

	    if(!grp.contains(""))
	    {
	   	 String grpPolicyUI1 = grpPolicyUI.getText();
	   	 if(grpPolicyUI1.contains("/"))
	   	 {
	            String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
	        	 if(grpPolicyOnline.length()!=0)
	        	 {
	        		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
		             if(!grpPolicyDB.equalsIgnoreCase("0"))
		             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyOnline);
	        	 }
	        	 
	        	 else
	        	 {
	        	    Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	        	 }
	        }
	   	    else
	   	    {
	   		    String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	            if(!grpPolicyDB.equalsIgnoreCase("0"))
	             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyUI1);
	        }
	     }
	   else
	   {
	      Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	   }

	    if(testConfig.driver.findElements(By.xpath("//span[@id='grpID_']")).size() != 0)
	    {
	   	 
	   	 String grpPolicyUI1 = grpPolicyUI.getText();
	    
	       if(grpPolicyUI1.contains("/"))
	        {
	    
	          if(!grpPolicyUI1.isEmpty())
	           {
			        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n", "");
			        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
			        if(!productNameDB.equalsIgnoreCase("0"))
			          	Helper.compareEquals(testConfig, "Comparing Product Name FISL and UI", productNameDB, productNameUI);
	            }
	        }
	    }
	    
	    else
	    {
	      Log.Comment("The Product Name doesnt exists for this Criteria");
	    }
	    
	    String subscrbrUI = subscriberUI1.getText();
	    String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	    if(!subscrbrDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Subscriber ID FISL and UI", subscrbrDB, subscrbrUI);
	  
	    String claimHashUI = claimHash1.getText();
	    String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
	    if(!claimTypeDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Claim Identifier FISL and UI", claimTypeDB, claimHashUI);
	 	 
	    String accntNumUI = accntNum.getText();
	    String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
	    if(!accntNumDB.equalsIgnoreCase("0"))
	      	Helper.compareEquals(testConfig, "Comparing Account Number FISL and UI", accntNumDB, accntNumUI);
	   
	    String amntAllowedUI1 = amntallowed.getText();
	    String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
	    String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
	    if(!amntAllowedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Allowed Amounts FISL and UI", accntNumDB, accntNumUI);
	  
	    /*
	    String CopayUI1 = copayUI.getText();
	    String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
	    Log.Comment("Copay Amount from UI is :" + CopayUI);
	    String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
	    Log.Comment("Copay Amount from FISL is :" + CopayDB);
	    if(!CopayDB.equalsIgnoreCase("0"))
	        Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
	      */
//	    String patientrespUI1 = patientresp.getText();
//	    String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//	    double patientrespU3 = Double.parseDouble(patientrespUI2);
//		 String patientrespUI = Double.toString(patientrespU3);
//	    Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//	    String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//	    Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//	    if(!patientrespDB.equalsIgnoreCase("0"))
//	        Helper.compareEquals(testConfig, "Comparing Patient Responsibility Amount UI and DB", patientrespDB, patientrespUI);
	//


		
	}
	}
	
	else
		
	{
		Browser.wait(testConfig, 2);
		String ui_Payer = payernameUI.getText();
		//String ui_Payer = payerUI.getText();
	    Log.Comment("The First Payer Name displayed is:" + ui_Payer);
		Element.click(paymentNo1, "Payment No");
		Browser.wait(testConfig, 2);
		String paymentNum1 = paymentno.getText();
		String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
		Log.Comment("The First Payment Number displayed is:" + paymentNum);
		Element.click(claimHash, "Claim Type");
	    Browser.wait(testConfig, 3);
		List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
		
	    for(WebElement patientNamesUI :patientNames) 
		{
	    	Log.Comment(patientNamesUI.getText());
		}
		 
		int sqlRowNo = 184;
		testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
		Map payerSchema = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Log.Comment("Message from DB for Payer Schema:" + payerSchema);
		
		if(null == payerSchema)
		{
			
			sqlRowNo = 203;
			testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
			Map payerSchema1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			
			String payerSchemaUI = (payerSchema1.toString()).substring(14,19);
			Log.Comment("Payer Schema is :" + payerSchemaUI);
			
		    sqlRowNo = 185;
			testConfig.putRunTimeProperty("paymentNum",paymentNum);
			Map paymentNumDB1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			String paymentNumDB2 = (paymentNumDB1.toString());
			String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length() - 1);
			String paymentNumDB = paymentNumDB3.substring(18,paymentNumDB3.length());
			Log.Comment("The UCP_CONSL_PAY_NBR is :" + paymentNumDB);
		    
			sqlRowNo = 186;
			testConfig.putRunTimeProperty("paymentNum",paymentNum);
			Map orginDate = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			String orginDateDB1 = orginDate.toString();
			String orginDateDB2 = orginDateDB1.substring(1, orginDateDB1.length() - 1);
			String orginDateDB3 = orginDateDB2.substring(11,orginDateDB2.length());
			String orginDateDB = orginDateDB3.replaceAll("-", "");
			Log.Comment("The Settlement Date is :" + orginDateDB);
			String finalidentifier = payerSchemaUI.concat("-").concat(paymentNumDB).concat("-").concat(orginDateDB);
			Log.Comment("The Final String is :" + finalidentifier);
			
			
			String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
	                "<ns17:EpsClaimsRequest xmlns:ns10=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns1=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\">\r\n" +
	                "<ns1:SearchCriteria ns1:FromRecord=\"-1\" ns1:MaxResult=\"10\" ns1:SortDirection=\"ASC\" ns1:SortFieldNumber=\"0\"/>\r\n" +
	                "<ns3:PaymentIdentifier>"+finalidentifier+"</ns3:PaymentIdentifier>\r\n" + 
	                "</ns17:EpsClaimsRequest>";
			
			
			String getResponse=new FISLConnection2().getEraResponse1(requestXml);
			
			String firstNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientFirstName>")+22, getResponse.indexOf("</ns0:PatientFirstName>"));
			String firstPatientUI1 = firstPatient.getText();
		    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
		    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
		    if(!firstNameDB.equalsIgnoreCase("0"))
		    	Helper.compareEquals(testConfig, "Comparing Patient First Name FISL and UI", firstNameDB, firstPatientUI);
			
		    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
			String lastPatientUI1 = firstPatient.getText();
		    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));
            if(!lastNameDB.equalsIgnoreCase("0"))
		    	Helper.compareEquals(testConfig, "Comparing Patient Last Name FISL and UI", lastNameDB, lastPatientUI);
			
		    String amountChargedUI1 = amntChargedUI.getText();
		    String amountChargedUI = "";
		    if(amountChargedUI1.contains("-"))
		    {

		    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
		    	{
		    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
		    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    		amountChargedUI = Double.toString(amountChargedUI4);
		        }
		    	
		    	else if (amountChargedUI1.contains("$")) 
		    	{
				  String amountChargedUI3 = amountChargedUI1.replace("$", "");
		    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    	  amountChargedUI = Double.toString(amountChargedUI4);
		    	}
		    	else if (amountChargedUI1.contains(",")) {
		    		
		    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
		    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    		amountChargedUI = Double.toString(amountChargedUI4);
		    	}
		    }
		    
		    else if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
		    {
		    	String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
		    	double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    	amountChargedUI = Double.toString(amountChargedUI4);
		    }
		   
		    else if(amountChargedUI1.contains("$"))
		    {
		    	String amountChargedUI3 = (amountChargedUI1.replace("$", ""));
		    	double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    	amountChargedUI = Double.toString(amountChargedUI4);
		    }
		    
		    else if(amountChargedUI1.contains(","))
		    {
		    	String amountChargedUI3 = (amountChargedUI1.replace("$", ""));
		    	double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    	amountChargedUI = Double.toString(amountChargedUI4);
		    }

//		    String amountChargedUI1 = amntChargedUI.getText();
//		    String amountChargedUI2  = amountChargedUI1.substring(1, amountChargedUI1.length());
//		    String amountChargedUI3 = amountChargedUI2.replace(",", "").trim();
//		    double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
//		    String amountChargedUI = Double.toString(amountChargedUI4);
//		    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
//		    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns0:LineItemChargeAmount>")+26, getResponse.indexOf("</ns0:LineItemChargeAmount>"));
//		    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
//		    if(!amountChargedDB.equalsIgnoreCase("0"))
//		       Helper.compareEquals(testConfig, "Comparing Amounts Charged DB and UI", amountChargedDB, amountChargedUI);
		    
		    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>"));
		    if(!amountChargedDB.equalsIgnoreCase("0"))
		       Helper.compareEquals(testConfig, "Comparing Amounts Charged FISL and UI", amountChargedDB, amountChargedUI);
            
		    String grp = testConfig.driver.findElement(By.xpath("//span[@id='grpID_']")).getText();
		    if(!grp.contains(""))
		    {
		   	 String grpPolicyUI1 = grpPolicyUI.getText();
		   	 if(grpPolicyUI1.contains("/"))
		   	 {
		            String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
		        	 if(grpPolicyOnline.length()!=0)
		        	 {
		        		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
			             if(!grpPolicyDB.equalsIgnoreCase("0"))
			             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyOnline);
		        	 }
		        	 
		        	 else
		        	 {
		        	 
		        		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
		        	 }
		        }
		   	 else
		   	 {
		   		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
		         if(!grpPolicyDB.equalsIgnoreCase("0"))
		             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyUI1);
		        }
		     }
		   else
		   {
		      Log.Comment("The Group Policy Number doesnt exists for this Criteria");
		   }

		    if(testConfig.driver.findElements(By.xpath("//span[@id='grpID_']")).size() != 0)
		    {
		   	 
		   	 String grpPolicyUI1 = grpPolicyUI.getText();
		    
		       if(grpPolicyUI1.contains("/"))
		        {
		    
		          if(!grpPolicyUI1.isEmpty())
		           {
				        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
				        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
				        if(!productNameDB.equalsIgnoreCase("0"))
				          	Helper.compareEquals(testConfig, "Comparing Product Name FISL and UI", productNameDB, productNameUI);
		     }
		        }
		    }
		    
		    else
		    {
		      Log.Comment("The Product Name doesnt exists for this Criteria");
		    }
		    
		    String subscrbrUI = subscriberUI1.getText();
		    String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
		    if(!subscrbrDB.equalsIgnoreCase("0"))
		       Helper.compareEquals(testConfig, "Comparing Subscriber ID FISL and UI", subscrbrDB, subscrbrUI);
		  
		    String claimHashUI = claimHash1.getText();
		    String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
		    if(!claimTypeDB.equalsIgnoreCase("0"))
		       Helper.compareEquals(testConfig, "Comparing Claim Identifier FISL and UI", claimTypeDB, claimHashUI);
		 	 
		    String accntNumUI = accntNum.getText();
		    String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
		    if(!accntNumDB.equalsIgnoreCase("0"))
		      	Helper.compareEquals(testConfig, "Comparing Account Number FISL and UI", accntNumDB, accntNumUI);
		   
		    String amntAllowedUI1 = amntallowed.getText();
		    String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
		    String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
		    if(!amntAllowedDB.equalsIgnoreCase("0"))
		       Helper.compareEquals(testConfig, "Comparing Allowed Amounts FISL and UI", accntNumDB, accntNumUI);
		  
		   
		     /*
		     String CopayUI1 = copayUI.getText();
		     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
		     Log.Comment("Copay Amount from UI is :" + CopayUI);
		     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
		     Log.Comment("Copay Amount from FISL is :" + CopayDB);
		     if(!CopayDB.equalsIgnoreCase("0"))
		         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
		       */
		    // String patientrespUI1 = patientresp.getText();
//		     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//		     double patientrespU3 = Double.parseDouble(patientrespUI2);
//			 String patientrespUI = Double.toString(patientrespU3);
//		     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//		     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//		     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//		     if(!patientrespDB.equalsIgnoreCase("0"))
//		         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", patientrespDB, patientrespUI);
	 
		}
		
		else
			
		{
			String payerSchemaUI = (payerSchema.toString()).substring(14, 19);
		    Log.Comment("Payer Schema is :" + payerSchemaUI);
		
		sqlRowNo = 185;
		testConfig.putRunTimeProperty("paymentNum",paymentNum);
		Map paymentNumDB1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String paymentNumDB2 = paymentNumDB1.toString();
		String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length()- 1);
		String paymentNumDB = paymentNumDB3.substring(18,paymentNumDB3.length());
		Log.Comment("The UCP_CONSL_PAY_NBR is :" + paymentNumDB);
	    
		sqlRowNo = 186;
		testConfig.putRunTimeProperty("paymentNum",paymentNum);
		Map orginDate = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String orginDateDB1 = orginDate.toString();
		String orginDateDB2 = orginDateDB1.substring(1, orginDateDB1.length() - 1);
		String orginDateDB3 = orginDateDB2.substring(11,orginDateDB2.length());
	    String orginDateDB = orginDateDB3.replaceAll("-","");
	    Log.Comment("The Settlement Date is :" + orginDateDB);
	    String finalidentifier = payerSchemaUI.concat("-").concat(paymentNumDB).concat("-").concat(orginDateDB);
	    Log.Comment("The Final String is :" + finalidentifier);
		
		String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
	                         "<ns17:EpsClaimsRequest xmlns:ns10=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns1=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\">\r\n" +
	                         "<ns1:SearchCriteria ns1:FromRecord=\"-1\" ns1:MaxResult=\"10\" ns1:SortDirection=\"ASC\" ns1:SortFieldNumber=\"0\"/>\r\n" +
	                         "<ns3:PaymentIdentifier>"+finalidentifier+"</ns3:PaymentIdentifier>\r\n" + 
	                         "</ns17:EpsClaimsRequest>";
		
		String getResponse=new FISLConnection2().getEraResponse1(requestXml);
		
		String firstNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientFirstName>")+22, getResponse.indexOf("</ns0:PatientFirstName>"));
		String firstPatientUI1 = firstPatient.getText();
	    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
	    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
	    if(!firstNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient First Name FISL and UI", firstNameDB, firstPatientUI);
		
	    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
		String lastPatientUI1 = firstPatient.getText();
	    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));
        if(!lastNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient Last Name FISL and UI", lastNameDB, lastPatientUI);
		
	    String amountChargedUI1 = amntChargedUI.getText();
	    String amountChargedUI = "";
	    if(amountChargedUI1.contains(","))
	    {
		    String amountChargedUI2  = amountChargedUI1.substring(1, amountChargedUI1.length());
		    String amountChargedUI3 = amountChargedUI2.replace(",", "").trim();
		    double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    amountChargedUI = Double.toString(amountChargedUI4);
	    }
	    else if(amountChargedUI1.contains("$"))
	    {     
	    	 String amountChargedUI2 = amountChargedUI1.replace("$", "");
	    	 amountChargedUI = amountChargedUI2.substring(0, amountChargedUI2.length()-1);
	     }

	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns0:LineItemChargeAmount>")+26, getResponse.indexOf("</ns0:LineItemChargeAmount>"));
	    if(!amountChargedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Amounts Charged FISL and UI", amountChargedDB, amountChargedUI);
        
	    String grp = testConfig.driver.findElement(By.xpath("//span[@id='grpID_']")).getText();
	    
	    if(!grp.contains(""))
	    {
	   	 String grpPolicyUI1 = grpPolicyUI.getText();
	   	 if(grpPolicyUI1.contains("/"))
	   	 {
	            String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
	        	 
	        	 if(grpPolicyOnline.length()!=0)
	        	 {
	        		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
		              if(!grpPolicyDB.equalsIgnoreCase("0"))
		             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyOnline);
	        	 }
	        	 
	        	 else
	        	 {
	        	   Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	        	 }
	        }
	   	 else
	   	 {
	   		  String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	           if(!grpPolicyDB.equalsIgnoreCase("0"))
	             	Helper.compareEquals(testConfig, "Comparing Group Policy FISL and UI", grpPolicyDB, grpPolicyUI1);
	        }
	     }
	   else
	   {
	      Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	   }

	    if(testConfig.driver.findElements(By.xpath("//span[@id='grpID_']")).size() != 0)
	    {
	   	 
	   	 String grpPolicyUI1 = grpPolicyUI.getText();
	    
	       if(grpPolicyUI1.contains("/"))
	        {
	    
	          if(!grpPolicyUI1.isEmpty())
	           {
			        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
			        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
			        if(!productNameDB.equalsIgnoreCase("0"))
			        	Helper.compareEquals(testConfig, "Comparing Product Name FISL and UI", productNameDB, productNameUI);
			    }
	        }
	    }
	    
	    else
	    {
	      Log.Comment("The Product Name doesnt exists for this Criteria");
	    }
	    
	    String subscrbrUI = subscriberUI1.getText();
	    String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	    if(!subscrbrDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Subscriber ID FISL and UI", subscrbrDB, subscrbrUI);
	  
	    String claimHashUI = claimHash1.getText();
	    String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
	    if(!claimTypeDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Claim Identifier FISL and UI", claimTypeDB, claimHashUI);
	 	 
	    String accntNumUI = accntNum.getText();
	    String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
	    if(!accntNumDB.equalsIgnoreCase("0"))
	      	Helper.compareEquals(testConfig, "Comparing Account Number FISL and UI", accntNumDB, accntNumUI);
	   
	    String amntAllowedUI1 = amntallowed.getText();
	    String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
	    String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
	    if(!amntAllowedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Allowed Amounts FISL and UI", accntNumDB, accntNumUI);
	  
	    /*
	    String CopayUI1 = copayUI.getText();
	    String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
	    Log.Comment("Copay Amount from UI is :" + CopayUI);
	    String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
	    Log.Comment("Copay Amount from FISL is :" + CopayDB);
	    if(!CopayDB.equalsIgnoreCase("0"))
	        Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
	      */
//	    String patientrespUI1 = patientresp.getText();
//	    String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//	    double patientrespU3 = Double.parseDouble(patientrespUI2);
//		 String patientrespUI = Double.toString(patientrespU3);
//	    Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//	    String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//	    Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//	    if(!patientrespDB.equalsIgnoreCase("0"))
//	        Helper.compareEquals(testConfig, "Comparing Patient Responsibility Amount UI and DB", patientrespDB, patientrespUI);
	//


		
	}
	
	}
	
}



public void verifyAllHeadersClaimDtl() throws Exception
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
	 
//	 Boolean patientNameUI = patientName.isDisplayed();
//	 Helper.compareEquals(testConfig, "Patient Name Column", true, patientNameUI);
	 
//	 Boolean patientIDUI = patientID.isDisplayed();
//	 Helper.compareEquals(testConfig, "Patient ID Column", true, patientIDUI);
	 
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
}



public void verifyTricareMaskingClaimDtl() throws Exception
{
	
	Element.click(paymentNo1, "Payment Number");
	Browser.wait(testConfig, 2);
	Element.click(claimHash, "Claim Number");
	Browser.wait(testConfig, 3);
	String subscrbrID = subscriberUI1.getText();
	Log.Comment("Subscriber ID in UI:" + subscrbrID);
	String mask = subscrbrID.substring(0, subscrbrID.length()-4);
    if(mask.contains("*"))
	    Log.Pass("Subscriber ID is masked");
	else
        Log.Fail("Subscriber ID is not masked");
    String mask2 = subscrbrID.substring(subscrbrID.lastIndexOf("*")+1, subscrbrID.length());
    int mask3  = mask2.length();
	if(mask3 == 4)
	    Log.Pass("Subscriber ID is masked and only last 4 digits are reavled");
	else
		Log.Fail("Subscriber ID is masked and only last 4 digits are reavled");
  }


		public ViewPayments clickPaymentNumber(){
			paymentno=Element.findElement(testConfig, "xpath", "//p[contains(text(),'Payment Number :')]/a");
			Element.clickByJS(testConfig, paymentno, "Payment Number");
			return new ViewPayments(testConfig);
		}
	
}




