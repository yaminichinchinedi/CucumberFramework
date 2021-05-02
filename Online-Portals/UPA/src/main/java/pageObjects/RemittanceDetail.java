package main.java.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import main.java.reporting.Log;

//import main.java.Utils.Config;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.api.manage.EpsPaymentsSearch.EpsRemittanceDetailHelper;
import main.java.api.pojo.epsRemittanceDetail.response.EPSClaimsResponseUI;
import main.java.api.pojo.epsRemittanceDetail.response.EpsClaimsResponse;
import main.java.fislServices.FISLConnection2;
import main.java.fislServices.ReadTagsfromFISLResponse;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.queries.QUERY;

public class RemittanceDetail {
	
	@FindBy(xpath = ".//*[@id='hideheader']/table//tr[1]/td[1]")
    WebElement verifyPageLoad;
    @FindBy(xpath = ".//*[@id='hideheader']/table//tr[1]/td[3]/span[1]")
    WebElement subscriberID;
    @FindBy(xpath = ".//*[@id='flow1']/table")
    List<WebElement> plbSegment;
    @FindBy(xpath = "//a[contains(text(),'View Payments')]")
    WebElement viewPaymentsTab;
    @FindBy(name = "providerTIN")
    WebElement enterTIN;
    @FindBy(name = "btnSubmit")
    WebElement searchBtn;
    @FindBy(id = "periodId")
    WebElement quickSeacrhDrpDwn;
    @FindBy(name = "filterPayments")
    WebElement filterPaymentsDrpDwn;
    @FindBy(id = "mktTypeId")
    WebElement mrktTypeDrpDwn;
    @FindBy(id = "payerFilterType")
    WebElement payerDrpDwn;
    @FindBy(id = "archiveFilterType")
    WebElement archiveDrpDwn;
    @FindBy(xpath = "//td[contains(text(),'Record Count:')]")
    WebElement record;
    @FindBy(id = "paymentNbr_1")
    WebElement firstPaymentNumber;
    @FindBy(className = "subheader")
    WebElement remitHeader1;
    @FindBy(className = "Subheaderbold")
    WebElement orgHeader;
    @FindBy(xpath = "//td[contains(text(),'Date(s) of Service')]")
    WebElement dosHeader;
    @FindBy(xpath = "//tbody/tr[@class='columnHeaderText']/td[5]")
    WebElement renderingHeader;
    @FindBy(xpath = "//td[contains(text(),'Claim Number')]")
    WebElement claimnumHeader;
    @FindBy(xpath = "//div[@id='flow2']//td[7]")
    WebElement patientpayHeader;
    @FindBy(xpath = "//td[contains(text(),'Amount Paid')]")
    WebElement amntpaidHeader;
    @FindBy(xpath = "//*[starts-with(text(),'Payment Date')]")
    WebElement paymentDate;
    @FindBy(xpath = "//*[contains(text(),'Payment Type:')]")
    WebElement paymentType;
    @FindBy(xpath = "//*[contains(text(),'Payment Number')]")
    WebElement paymentNumber;
    @FindBy(xpath = "//*[contains(text(),'NPI')]")
    WebElement remitNPI;
    @FindBy(name = "claimType")
    WebElement filterClaims;
    @FindBy(xpath = "//select[@name='claimType']//option")
    WebElement filterClaimsOptions;
    @FindBy(xpath = "//td[contains(text(),'Account Number')]")
    WebElement acctNum;
    @FindBy(xpath = "//a[contains(text(),'Patient Name')]")
    WebElement patientName;
    @FindBy(xpath = "//span[contains(text(),'Patient ID')]")
    WebElement patientID;
    @FindBy(xpath = "//span[contains(text(),'Subscriber ID')]")
    WebElement subscbrID;
    @FindBy(xpath = "//span[contains(text(),'Corrected ID')]")
    WebElement correctedID;
    @FindBy(xpath = "//a[contains(text(),'Rendering Provider')]")
    WebElement rendPrvdr;
    @FindBy(xpath = "//td[contains(text(),'Claim #/')]")
    WebElement claimHeader;
    @FindBy(xpath = "//td[contains(text(),'Group Policy Number/')]")
    WebElement grpPolicy;
    @FindBy(xpath = "//td[contains(text(),'Date(s) of Service')]")
    WebElement remitDOS;
    @FindBy(xpath = "//td[contains(text(),'Description of Service')]")
    WebElement descService;
    @FindBy(xpath = "//td[contains(text(),'Amount Charged')]")
    WebElement amntCharged;
    @FindBy(xpath = "//td[contains(text(),'Claim / Service Adj')]")
    WebElement serviceAdj;
    @FindBy(xpath = "//td[contains(text(),'Prov Adj Discount')]")
    WebElement provAdj;
    @FindBy(xpath = "//td[contains(text(),'Amount Allowed')]")
    WebElement amntAllowed;
    @FindBy(xpath = "//td[contains(text(),'Deduct/ Coins/ Copay')]")
    WebElement copay;
    @FindBy(xpath = "//td[contains(text(),'Total Paid to Provider:')]")
    WebElement paidPrvdr;
    @FindBy(xpath = "//a[contains(text(),'Adj Reason Code')]")
    WebElement adj_code;
    @FindBy(xpath = "//a[contains(text(),'RMK Code')]")
    WebElement rmk_code;
    @FindBy(xpath = "//td[contains(text(),'Patient Resp')]")
    WebElement patientResp;
    @FindBy(xpath = "//td[contains(text(),'Remark Code')]")
    WebElement remarkCode;
    @FindBy(xpath = "//td[contains(text(),'Description')]")
    WebElement remarkDesc;
    @FindBy(xpath = "//td[contains(text(),'Adjustment Code')]")
    WebElement adjustmentCode;
    @FindBy(xpath = "//td[contains(text(),'Description')]")
    WebElement adjustmentDesc;
    @FindBy(xpath = "//span[@class='pageNo'][contains(text(),'1')]")
    WebElement paginationNo1;
    @FindBy(xpath = "//span[@class='pageNo'][contains(text(),'2')]")
    WebElement paginationNo2;
    @FindBy(xpath = "//tr[@class='rowDarkbold']/td[1]")
    WebElement subTotRecord;
    @FindBy(xpath = "//a[contains(text(),'Next')]")
    WebElement remitNext;
    @FindBy(xpath = "//form[1]/table[1]/tbody[1]/tr[7]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]")
    WebElement payerUI;
    @FindBy(xpath = "//*[@class=\"ellipsis wrapperTooltip\"]")
    WebElement payernameUI;
    @FindBy(id = "paymentNbr_2")
    WebElement paymentNo2;
    @FindBy(id = "paymentNbr_1")
    WebElement paymentNo1;
    @FindBy(xpath = "//*[contains(text(),'Payment Number:')]")
    WebElement paymentNo;
    @FindBy(xpath = "//input[@value='Download 835']")
    WebElement download;
    @FindBy(xpath = "//*[@id=\"epra-print-1\"]/input")
    WebElement printBtn;
    @FindBy(xpath = "//input[@value='Print Page']")
    WebElement printBtnPayer;
    @FindBy(xpath = "//input[starts-with(@value,'Return to')]")
    WebElement returnBtn;
    @FindBy(className = "subheaderbold")
    WebElement totPaidSubHdr;
    @FindBy(xpath = "//div[@id='msgforplb']//span[@class='Subheaderbold']")
    WebElement cob_Msg;
    @FindBy(xpath = "//div[@id='msgforplb']//span[@class='Subheaderbold']")
    WebElement reversalMsg;
    @FindBy(id = "periodId")
    WebElement quickSearch;
    @FindBy(id = "mktTypeId")
    WebElement marketTyp;
    @FindBy(id = "payerFilterType")
    WebElement payerDrpDown;
    @FindBy(xpath = "//select[@name='claimType']//option")
    List<WebElement> filterClaimsOptionUI;
    @FindBy(name = "filterPayments")
    WebElement filterDrpDown;
    @FindBy(xpath = "//a[contains(text(),'First Page')]")
    WebElement firstPage;
    @FindBy(xpath = "//a[contains(text(),'Last Page')]")
    WebElement lastPage;
    @FindBy(id = "outerTable")
    WebElement remitOuterTable;
    @FindBy(id = "patientName_1")
    WebElement firstPatient;
    @FindBy(xpath = "//tr[@class='rowDarkbold']//td[3]")
    WebElement amntChargedUI;
    @FindBy(xpath = "//tr[@class='rowDarkbold']//td[4]")
    WebElement amntChargedDRGCodeUI;
    @FindBy(id = "grpPolNo_1")
    WebElement grpPolicyUI;
    @FindBy(id = "subscriberID_1")
    WebElement subscriberUI1;
    @FindBy(xpath = "//span[@id='claimID_1']/a")
    WebElement claimHash;
    @FindBy(xpath = "//td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")
    WebElement accntNum;
    @FindBy(xpath = "//span[@id='claimID_1']/a")
    WebElement claimType;
    @FindBy(xpath = "//tr[@class='rowDarkbold']//td[6]")
    WebElement amntallowed;
    @FindBy(xpath = "//tr[@class='rowDarkbold']//td[7]")
    WebElement copayUI;
    @FindBy(xpath = "//tr[contains(@class,'rowDarkbold')]//td[11]")
    WebElement patientresp;
    @FindBy(xpath = "//tr[contains(@class,'rowDarkbold')]//td[5]")
    WebElement provAdjDis;
    @FindBy(xpath = "//a[@class='exante-default-header-txt-bold'][contains(text(),'Home')]")
    WebElement homeBtn;
    @FindBy(xpath = "//a[contains(text(),'Search Remittance')]")
    WebElement srchRemit;
    @FindBy(id = "paymentNbrTypeSelection")
    WebElement payNumdrpdwn;
    @FindBy(id = "paymentNumberInputId")
    WebElement elcPayNum;
    @FindBy(id = "checkNumberInputId")
    WebElement checkPayNum;
    @FindBy(name = "searchRemittance")
    WebElement srchRemitBtn;
    @FindBy(xpath = "//tr[@class='rowDarkbold']/td[1]")
    WebElement subTotal;
    @FindBy(xpath = "//td[contains(text(),'Adj Reason Code')]")
    WebElement adjCodePLB;
    @FindBy(xpath = "//td[contains(text(),'Reference #')]")
    WebElement refCodePLB;
    @FindBy(xpath = "//table[@class='tableborder']/tbody/tr/td[3]")
    WebElement amntPLBHeader;
    @FindBy(xpath = "//td[starts-with(@id,'patientName_')]")
    List<WebElement> patientNameList;
    @FindBy(xpath = "//div[@id='msgforplb']//span[1]")
    WebElement claimmsg;
    @FindBy(xpath = "//a[text()='EPS']")
    WebElement rmksessionoutmsg;
    @FindBy(xpath = "//tr[@class='rowDarkbold']/td[contains(text(), 'Subtotal')]")
    List<WebElement> subTotalCount;
    @FindBy(xpath = "//input[@value= 'Search']")
    WebElement srchTINUPA;
    @FindBy(xpath = "//div[@id='home']/a[contains(text(),'Home')]")
    WebElement homeBtnUPA;
    @FindBy(xpath = "//input[@value='Print Request' and @type = 'button']")
    WebElement btnPrint;
    @FindBy(id = "printProcessing")
    WebElement btnPrntProcessing;
    @FindBy(xpath = "//input[@value='Download 835' and @type = 'button']")
    WebElement download835;
    @FindBy(xpath = "//input[@value='Print Available']")
    WebElement btnPrntavailable;
    @FindBy(xpath = "//input[@value='Return to Search Results']")
    WebElement returnbtn;
    @FindBy(xpath = "//b[contains(text(),'Your PDF is now available. To access your document')]")
    WebElement msg;
    @FindBy(xpath = "//td[contains(text(),'Subscriber Name')]")
    WebElement subscrbrName;
    @FindBy(xpath = "//td[contains(text(),'Payment Number')]")
    WebElement remitpaymnthead;
    @FindBy(xpath = "//*[contains(text(),'Payer PRA')]//following::tr[1]/td[9]/table/tbody/tr/td/span[1]/a")
    WebElement PPRAPDFHyperlink;
    @FindBy(xpath = "//span[contains(@id,'ppra')]//img")
    WebElement pPRAPDFImage;
    @FindBy(xpath = "//div[@id='hideheader']//table//tr")
    List<WebElement> pageHeader;
    @FindBy(xpath = "//div[@id='flow1']/table")
    List<WebElement> pageBody;
    @FindBy(linkText = "RMK Code")
    WebElement rmkCode;
    @FindBy(linkText = "Adj Reason Code")
    WebElement adjCode;
    @FindBy(xpath = "//span[contains(text(),'DRG Code')]")
    WebElement drgCode;
    @FindBy(name = "taxIdNbr")
    WebElement prvdrTIN;
    @FindBy(name = "providerTIN")
    WebElement txtboxTinNo;
    @FindBy(id = "taxIndNbrId")
    WebElement tinDrpDwn;
    @FindBy(name = "taxIdNbr")
    WebElement bstinDrpDwn;
    @FindBy(name = "taxIdNbr")
    WebElement payertinDrpDwn;
    @FindBy(xpath = "//input[@value='Search']")
    WebElement submitBtn;
    @FindBy(xpath = "//*[contains(text(),'Note: Above information provided by the member']")
    WebElement noteMsg;
    @FindBy(xpath = "//*[contains(text(),'technical difficulties')]")
    WebElement errorPageUI;
    @FindBy(id="paymentNbrTypeSelection")
    WebElement paymentNumberType;
    @FindBy(xpath = "//input[@name='paymentNumber']")
    WebElement paymentNumberSearchRemit;
    @FindBy(name="searchRemittance")
    WebElement btnSearchRemittance;
	
	private ViewPaymentsDataProvider dataProvider;
	EpsRemittanceDetailHelper epsRemittanceDetailHelper = new EpsRemittanceDetailHelper();
    EPSClaimsResponseUI epsClaimsResponseUI = new EPSClaimsResponseUI();
	List<String> actual=new ArrayList<String>();
	List<String> expected=new ArrayList<String>();
	
	private TestBase testConfig;
	
	public RemittanceDetail(TestBase testConfig)
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}

	public void verifyHoverTexts()
	{
		String expected="Patient ID : Unique ID assigned by the payer to a member,  which could also be the same as the Subscriber ID, if the subscriber is also the patient.";
		Element.mouseHoverByJS(testConfig, patientID, "Patient ID");
		WebElement popUp=Element.findElement(testConfig, "xpath", ".//*[@id='hideheader']/table//tr[1]/td[2]/span[contains(text(),PatientId)]");
		String actual=popUp.getAttribute("onmouseover");
		actual=actual.substring(23, actual.length()-9);
		Helper.compareContains(testConfig, "Patient Id tooltip", expected, actual);
		
		expected="Subscriber ID : Unique ID assigned by the payer to the subscriber/insured/primary card holder.";
		Element.mouseHoverByJS(testConfig, subscriberID, "Subscriver ID");
		popUp=Element.findElement(testConfig, "xpath", ".//*[@id='hideheader']/table//tr[1]/td[3]/span[1][contains(text(),SubscriberId)]");
		actual=popUp.getAttribute("onmouseover");
		actual=actual.substring(23, actual.length()-9);
		Helper.compareContains(testConfig, "Subscriber Id tooltip", expected, actual);
		
		expected="Corrected ID : The Subscriber/Insured ID received on the claim was not correct. The payer is returning the corrected ID assigned by the payer. This value will only display if the ID received on the claim was incorrect.";
		Element.mouseHoverByJS(testConfig, correctedID, "Corrected ID");
		popUp=Element.findElement(testConfig, "xpath", ".//*[@id='hideheader']/table//tr[1]/td[3]/span[2][contains(text(),CorrectedId)]");
		actual=popUp.getAttribute("onmouseover");
		actual=actual.substring(23, actual.length()-9);
		Helper.compareEquals(testConfig, "Corrected Id tooltip", expected, actual);
	}
	
	public void verifyPopUpforRMKCode()
	{
		Element.clickByJS(testConfig, rmkCode, "RMK CODE");
		Browser.switchToNewWindow(testConfig);
//		String expected="https://ppsp-stage2-e-csr.optumhealthfinancial.com/remarkCode.do";
//		String actual=Browser.getURL(testConfig);	
//		Helper.compareEquals(testConfig, "RMK Window URL", expected, actual);
		
		String expected="Remark Type Reason Codes";
		String actual=testConfig.driver.getTitle();
		Helper.compareEquals(testConfig, "RMK Window Title", expected, actual);
	}
	
	public void verifyPopUpforADJCode()
	{
		Element.clickByJS(testConfig, adjCode, "Adjustment Reason Code Link");
		Browser.switchToNewWindow(testConfig);
//		String expected="https://ppsp-stage2-e-csr.optumhealthfinancial.com/adjustmentCode.do";
//		String actual=Browser.getURL(testConfig);
//		Helper.compareEquals(testConfig, "RMK Window URL", expected, actual);
		
		String expected="Adjustment Reason Codes";
		String actual=testConfig.driver.getTitle();
		Helper.compareEquals(testConfig, "RMK Window Title", expected, actual);
	}
	
	public void verifyPLBAdjustment() throws IOException
	{
		List<Double> actual=new ArrayList<Double>();
		List<Double> expected=new ArrayList<Double>();
		int noOfRows=plbSegment.get(1).findElements(By.tagName("tr")).size();
		HashMap<Integer, HashMap<String, String>> remittanceDetail=DataBase.executeSelectQueryALL(testConfig, 63);
		for(int i=0;i<noOfRows-1;i++)
		{
			Double s=Double.valueOf(plbSegment.get(1).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(2).getText().substring(2));
			actual.add(s);
		}
		Collections.sort(actual);
		for(int i=1;i<=remittanceDetail.size();i++)
			expected.add(Double.valueOf(remittanceDetail.get(i).get("CLM_AMT_ALLW")));
		Collections.sort(expected);
		Helper.compareEquals(testConfig, "PLB Adjustment ", expected,actual);	
		
		verifyHeader();
	}
	
	public void verifyHeader(){
		List<String> expected = Arrays.asList("Account Number","Patient Name / Patient ID","Subscriber ID / Corrected ID","Rendering Provider","Claim #/ Claim Type","Group Policy Number/ Product Name");
		int noOfRows=pageHeader.size();
		int noOfColumns=pageHeader.get(0).findElements(By.tagName("td")).size();
		actual.clear();
		for(int j=0;j<noOfColumns;j++)
			actual.add(pageHeader.get(0).findElements(By.tagName("td")).get(j).getText().trim().replace("\n"," "));
		Helper.compareEquals(testConfig, "Row one of Header", expected, actual);
			
		expected = Arrays.asList("Date(s) of Service","Description of Service","Amount Charged","Claim / Service Adj","Prov Adj Discount","Amount Allowed","Deduct/ Coins/ Copay","Paid to Provider","Adj Reason Code","RMK Code","Patient Resp");
		noOfColumns=pageHeader.get(1).findElements(By.tagName("td")).size();
		actual.clear();
		for(int j=0;j<noOfColumns-1;j++)
			actual.add(pageHeader.get(1).findElements(By.tagName("td")).get(j).getText().trim());
		Helper.compareEquals(testConfig, "Row two of Header", expected, actual);
	}
	
	public void verifyPageRemittanceDetail() throws IOException
	{
		HashMap<Integer, HashMap<String, String>> remittanceDetail=getRemittanceDetail();
//		verifyAccountNumber(remittanceDetail).verifyPatientName(remittanceDetail).verifyClaimHash(remittanceDetail).verifySubscriberId(remittanceDetail).verifyPatientResp(remittanceDetail).verifyAmountCharged(remittanceDetail).verifyAmountAllowed(remittanceDetail).verifyAmountPaidToProvider(remittanceDetail).verifyHeader();
		verifyPatientName(remittanceDetail);
	}
	
	public HashMap<Integer, HashMap<String, String>> getRemittanceDetail() throws IOException
	{
		HashMap<Integer, HashMap<String, String>> remittanceDetail=DataBase.executeSelectQueryALL(testConfig, 69);
		return remittanceDetail;
	}
	
	
	public RemittanceDetail verifyAccountNumber(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();	
		int noOfColumns;
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='Tableheaderbold']")).size();
		for(int i=0;i<noOfRows;i++)
		{
//			noOfColumns=plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size();
//			if(noOfColumns==6 || noOfColumns==7)
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText());
		}
		for(int i=1;i<=remittanceDetail.size();i++)
			expected.add(remittanceDetail.get(i).get("PTNT_ACCT_NBR"));
		Helper.compareEquals(testConfig, "Account Number", expected, actual);
		return this;
	}
	public RemittanceDetail verifyPatientName(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
        Log.Comment("No of rows are: "+noOfRows);
		for(int i=0;i<noOfRows;i++)
		{
			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==6 || plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==7)
			{
				String s=plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(1).getText();
				int index=s.indexOf("/");
				actual.add(s.substring(0, index));
			}
				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
			if(remittanceDetail.get(i).get("PTNT_MIDL_NM").equals(" "))
				expected.add(remittanceDetail.get(i).get("PTNT_FST_NM")+" "+remittanceDetail.get(i).get("PTNT_LST_NM"));
			else
				expected.add(remittanceDetail.get(i).get("PTNT_FST_NM")+" "+remittanceDetail.get(i).get("PTNT_MIDL_NM")+" "+remittanceDetail.get(i).get("PTNT_LST_NM"));
		}	
		Collections.sort(expected);
		Collections.sort(actual);
		Helper.compareEquals(testConfig, "Patient Name", expected, actual);
		return this;
	}
	
	public RemittanceDetail verifyClaimHash(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='Tableheaderbold']")).size();
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==6 || plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==7)
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(4).getText());				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
				expected.add(remittanceDetail.get(i).get("CLM_NBR"));	
		Helper.compareEquals(testConfig, "Claim Hash", expected, actual);
		return this;
	}
	public RemittanceDetail verifySubscriberId(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='Tableheaderbold']")).size();
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==6 || plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==7)
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(2).getText());				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
				expected.add(remittanceDetail.get(i).get("PTNT_ID"));	
		Helper.compareEquals(testConfig, "Claim Hash", expected, actual);
		return this;
	}
	
	public RemittanceDetail verifyPatientResp(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='rowDarkbold']")).size();
		Log.Comment("No Of Rows are: "+noOfRows);
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==12 &&
//			plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText().equals("Subtotal"))
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(10).getText().substring(1).replace(",",""));				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
			if(remittanceDetail.get(i).get("PTNT_RESP_AMT")=="")
				expected.add("0.00");
			else
				expected.add(remittanceDetail.get(i).get("PTNT_RESP_AMT"));
				
		}
		Helper.compareEquals(testConfig, "Patient Resp Amount", expected, actual);
		return this;
	}
	
	public RemittanceDetail verifyAmountCharged(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='rowDarkbold']")).size();
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==12 &&
//			plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText().equals("Subtotal"))
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(2).getText().substring(1).replace(",",""));				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
			if(remittanceDetail.get(i).get("CLM_CHRG_AMT")=="")
				expected.add("0.00");
			else
				expected.add(remittanceDetail.get(i).get("CLM_CHRG_AMT"));
				
		}
		Helper.compareEquals(testConfig, "Claim Charge Amount", expected, actual);
		return this;
	}
	
	public RemittanceDetail verifyAmountAllowed(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='rowDarkbold']")).size();
		
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==12 &&
//			plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText().equals("Subtotal"))
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(5).getText().substring(1).replace(",",""));				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
			if(remittanceDetail.get(i).get("COV_AMT")=="")
				expected.add("0.00");
			else
				expected.add(remittanceDetail.get(i).get("COV_AMT"));
				
		}
		Helper.compareEquals(testConfig, "Claim Charge Amount", expected, actual);
		return this;
	}
	
	
	public RemittanceDetail verifyAmountPaidToProvider(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='rowDarkbold']")).size();
		
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==12 &&
//			plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText().equals("Subtotal"))
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(7).getText().substring(1).replace(",",""));				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
			if(remittanceDetail.get(i).get("CLM_PAY_AMT")=="")
				expected.add("0.00");
			else
				expected.add(remittanceDetail.get(i).get("CLM_PAY_AMT"));
				
		}
		Helper.compareEquals(testConfig, "Claim Charge Amount", expected, actual);
		return this;
	}
	
	public RemittanceDetail verifyClaimDate(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='rowDarkbold']//following-sibling::")).size();
		
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==12 &&
//			!(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText().equals("Subtotal")))
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText());				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
				expected.add(remittanceDetail.get(i).get("CLM_STRT_DT")+" "+remittanceDetail.get(i).get("CLM_END_DT"));
				
		}
		Helper.compareEquals(testConfig, "Claim Charge Amount", expected, actual);
		return this;
	}
	
public void verifyAllOtherDrpDwns() throws Exception
{
	Element.selectVisibleText(quickSearch,"Last 9-13 months","Quick Search from View Payments");
	Log.Comment("Quick Search: Last 9-13 months option is selected");
	Element.expectedWait(marketTyp, testConfig, "Market Type DropDown", "Market Type DropDown");
	    		
	Element.selectVisibleText(marketTyp,"Show All","Market Type from View Payments");
	Log.Comment("Market Type: Show All is selected");
	Element.expectedWait(payerDrpDown, testConfig, "Payer DropDown", "Payer DropDown");
		
	Element.selectVisibleText(payerDrpDown,"Show All","Payer Dropdown from View Payments");
	Log.Comment("Payer: Show All is selected");
	Element.expectedWait(archiveDrpDwn, testConfig, "Active DropDown", "Active DropDown");
		
	Element.selectVisibleText(archiveDrpDwn,"Show All","Active/Archived Payments Dropdown from View Payments");
	Log.Comment("Active/Archived Payments: Show All is selected");
	Element.expectedWait(filterDrpDown, testConfig, "Filter DropDown", "Filter DropDown");
		
	Element.selectVisibleText(filterDrpDown,"Show All","Filter Payments Dropdown from View Payments");
	Log.Comment("Filter Payments: Show All is selected");
	
}

	
public void verifyAllHeaders() throws Exception
{
	String RemitHeader = remitHeader1.getText();
	if(!RemitHeader.equalsIgnoreCase("0"))
	     Helper.compareEquals(testConfig, "Comparing Remittance Header", RemitHeader, "Remittance Detail");
 
	Boolean org_UI = orgHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Organization Header", true, org_UI);

     Boolean paymentDateUI = paymentDate.isDisplayed();
	 Helper.compareEquals(testConfig, "Payment Date Header", true, paymentDateUI);
	
	 Boolean paymentNum = paymentNumber.isDisplayed();
	 Helper.compareEquals(testConfig, "Payment Number Header", true, paymentNum);
	 
     Boolean paymentTypeUI = paymentType.isDisplayed();
     Helper.compareEquals(testConfig, "Payment Type Header", true, paymentTypeUI);
    
     Boolean remitNPIUI = remitNPI.isDisplayed();
     Helper.compareEquals(testConfig, "Remit NPI Header", true, remitNPIUI);
	 
	 Boolean filterClaimsUI = filterClaims.isDisplayed();
	 Helper.compareEquals(testConfig, "Filter Claim Header", true, filterClaimsUI);
}


public void verifyAllHeadersPayer() throws Exception
{
	String RemitHeader = remitHeader1.getText();
	if(!RemitHeader.equalsIgnoreCase("0"))
	     Helper.compareEquals(testConfig, "Comparing Remittance Header", RemitHeader, "Remittance Detail");
 
	Boolean org_UI = orgHeader.isDisplayed();
	Helper.compareEquals(testConfig, "Organization Header", true, org_UI);

     Boolean paymentDateUI = paymentDate.isDisplayed();
	 Helper.compareEquals(testConfig, "Payment Date Header", true, paymentDateUI);
	
	 Boolean paymentNum = paymentNumber.isDisplayed();
	 Helper.compareEquals(testConfig, "Payment Number Header", true, paymentNum);
	 
     Boolean paymentTypeUI = paymentType.isDisplayed();
     Helper.compareEquals(testConfig, "Payment Type Header", true, paymentTypeUI);
  
}
	
public void verifyColumnHeaders() throws Exception
{
	 Boolean acctNumUI = acctNum.isDisplayed();
	 Helper.compareEquals(testConfig, "Account Number Column", true, acctNumUI);
	 
	 Boolean patientNameUI = patientName.isDisplayed();
	 Helper.compareEquals(testConfig, "Patient Name Column", true, patientNameUI);
	 
	 Boolean patientIDUI = patientID.isDisplayed();
	 Helper.compareEquals(testConfig, "Patient ID Column", true, patientIDUI);
	 
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
	
	 Boolean remitDOSUI = remitDOS.isDisplayed();
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
	

public void verifyColumnHeadersPayer() throws Exception
{
//	 Boolean acctNumUI = acctNum.isDisplayed();
//	 Helper.compareEquals(testConfig, "Account Number Column", true, acctNumUI);
//	 
//	 Boolean patientNameUI = patientName.isDisplayed();
//	 Helper.compareEquals(testConfig, "Patient Name Column", true, patientNameUI);
//
//	 Boolean subscrbrNameUI = subscrbrName.isDisplayed();
//	 Helper.compareEquals(testConfig, "Subscriber Name Column", true, subscrbrNameUI);
//	 
//	 Boolean dosHeaderUI = dosHeader.isDisplayed();
//	 Helper.compareEquals(testConfig, "Date(s) of Service Column", true, dosHeaderUI);
//	 
//	 Boolean renderingHeaderUI = renderingHeader.isDisplayed();
//	 Helper.compareEquals(testConfig, "Rendering Provider Column", true, renderingHeaderUI);
//	 
//	 
//	 Boolean claimnumHeaderUI = claimnumHeader.isDisplayed();
//	 Helper.compareEquals(testConfig, "Claim Number Column", true, claimnumHeaderUI);
//	 
//	 Boolean patientpayHeaderUI = patientpayHeader.isDisplayed();
//	 Helper.compareEquals(testConfig, "Patient Payment Column", true, patientpayHeaderUI);
//	 
//	 Boolean amntpaidHeaderUI = amntpaidHeader.isDisplayed();
//	 Helper.compareEquals(testConfig, "Amount Paid Column", true, amntpaidHeaderUI);
	
	Boolean acctNumUI = acctNum.isDisplayed();
	 Helper.compareEquals(testConfig, "Account Number Column", true, acctNumUI);
	 
	 Boolean patientNameUI = patientName.isDisplayed();
	 Helper.compareEquals(testConfig, "Patient Name Column", true, patientNameUI);
	 
	 Boolean patientIDUI = patientID.isDisplayed();
	 Helper.compareEquals(testConfig, "Patient ID Column", true, patientIDUI);
	 
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
	
	 Boolean remitDOSUI = remitDOS.isDisplayed();
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


public void verifyBottomHeaders() throws Exception
{
	 Boolean downloadBtn = download.isDisplayed();
	 Helper.compareEquals(testConfig, "Download Button", true, downloadBtn);
	 
     Boolean printBtnUI = printBtn.isDisplayed();
     Helper.compareEquals(testConfig, "Print Available Button", true, printBtnUI);
     
     Boolean returnBtnUI = returnBtn.isDisplayed();
     Helper.compareEquals(testConfig, "Return to Payment Summary Button", true, returnBtnUI);
     
	 Boolean totPaidSubHdrUI = totPaidSubHdr.isDisplayed();
	 Helper.compareEquals(testConfig, "Total Paid to Provider info", true, totPaidSubHdrUI);
}


public void verifyBottomHeadersPayer() throws Exception
{
	 Boolean downloadBtn = download.isDisplayed();
	 Helper.compareEquals(testConfig, "Download Button", true, downloadBtn);
	 
     Boolean printBtnPayerUI = printBtnPayer.isDisplayed();
     Helper.compareEquals(testConfig, "Print Page Button", true, printBtnPayerUI);
     
     Boolean returnBtnUI = returnBtn.isDisplayed();
     Helper.compareEquals(testConfig, "Return to Payment Summary Button", true, returnBtnUI);
     
	 Boolean totPaidSubHdrUI = totPaidSubHdr.isDisplayed();
	 Helper.compareEquals(testConfig, "Total Paid to Provider info", true, returnBtnUI);
}
	

	public void verifyHeadersRemittanceDetail() throws Exception {
		Boolean acctNumUI = acctNum.isDisplayed();
		Helper.compareEquals(testConfig, "Account Number Column", true, acctNumUI);

		Boolean patientNameUI = patientName.isDisplayed();
		Helper.compareEquals(testConfig, "Patient Name Column", true, patientNameUI);

		Boolean subscrbrNameUI = subscrbrName.isDisplayed();
		Helper.compareEquals(testConfig, "Subscriber Name Column", true, subscrbrNameUI);

		Boolean dosHeaderUI = dosHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Date(s) of Service Column", true, dosHeaderUI);

		Boolean renderingHeaderUI = renderingHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Rendering Provider Column", true, renderingHeaderUI);

		Boolean claimnumHeaderUI = claimnumHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Claim Number Column", true, claimnumHeaderUI);

		Boolean patientpayHeaderUI = patientpayHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Patient Payment Column", true, patientpayHeaderUI);

		Boolean amntpaidHeaderUI = amntpaidHeader.isDisplayed();
		Helper.compareEquals(testConfig, "Amount Paid Column", true, amntpaidHeaderUI);

		Boolean totPaidSubHdrUI = paidPrvdr.isDisplayed();
		if (totPaidSubHdrUI == true) {
			Helper.compareContains(testConfig, "Total Paid to Provider", "Total Paid to Provider",
					paidPrvdr.getText());
		} else {
			Log.Fail("Total Paid to Provider: is not displayed");
		}
	}

public void verifyRemitPaginationOptions() throws Exception
{
	  int subRecordCount = subTotalCount.size();
	  if(subRecordCount >10)
	  {
		  if(remitNext.isDisplayed())
		  {
		  Element.click(remitNext, "Next Button");
		  Log.Pass("Clicked on Next Button");
		  Browser.wait(testConfig, 2);
		  Element.click(firstPage, "First Page");
		  }
		  else
		  {
			  Log.Fail("Next Button Functionality");
		  }
	  }
	  
	  else
	   {
		  Log.Pass("Next Button Doesnt Present as the records are not more than 10");
	   }
	  
     if(subRecordCount >10)
     {
    	 if(paginationNo2.isDisplayed())
    	 {
    	    Element.click(paginationNo2, "Pagination");
    	    Browser.wait(testConfig, 2);
			Element.click(firstPage, "First Page");
			Log.Pass("Pagination Button functionality working as expected");
    	 }
    	 else
    	 {
    		 Log.Fail("Click on Pagination no 2");
    	 }
     }
     else
     {
    	 Log.Pass("Page No 2 Doesnt present as the records are not more than 10");
     }
	 
     if(subRecordCount >10)
     {
    	 if(lastPage.isDisplayed())
    	 {
    	    Element.click(lastPage, "Last Page");
			Browser.wait(testConfig, 2);
			Element.click(firstPage, "First Page");
			Browser.wait(testConfig, 2);
			Log.Pass("Last Page Button functionality working as expected");
    	 }
    	 else
    	 {
    		 Log.Fail("Last Page Functionality");
    	 }
     }
     
     else
     {
    	 Log.Pass("Last Page Doesnt present as the records are not more than 10");
     }
     
}
	
	
@SuppressWarnings("static-access")
public void verifyRMKCode() throws Exception
{
		Element.click(rmk_code, "RMK Code");
		Browser.wait(testConfig,2);
		@SuppressWarnings("unused")
		String oldWindow=Browser.switchToNewWindow(testConfig,"remarkCode.do");
	    String rmk_code = remarkCode.getText();
        Log.Comment("Remark Code Text is:" + rmk_code);
    
       if(("Remark Code").contains(rmk_code))
         {
		       Browser.wait(testConfig, 2);
		      //Element.verifyElementVisiblity(remarkCode, "Remark Code");
		      Boolean remarkCodeUI = remarkCode.isDisplayed();
		      Helper.compareEquals(testConfig, "Remark Code is Displayed in Child Window", true, remarkCodeUI);
		      
		      Browser.wait(testConfig, 2);
		      //Element.verifyElementVisiblity(remarkDesc, "Remark Desc");
		      Boolean remarkDescUI = remarkDesc.isDisplayed();
		      Helper.compareEquals(testConfig, "Remark Code Description Header", true, remarkDescUI);
		      
		      List<String> rmk_CodesUI = new ArrayList<>();
		      List<WebElement> rmk_CodesUI1 =testConfig.driver.findElements(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr"));
		      int rmkCodesUI1 = rmk_CodesUI1.size();
		      String rmkCodesUI = String.valueOf(rmkCodesUI1);
			  Log.Comment("The RMK Codes List Size from UI is :"+rmkCodesUI);
		      Browser.switchToParentWindow(testConfig,oldWindow);
			  int sqlRowNo = 192;
			  Map rmk_TYP_RSN_CD_DB1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			  String rmk_TYP_RSN_CD_DB = (rmk_TYP_RSN_CD_DB1.toString());
			  String rmkCodeDB = rmk_TYP_RSN_CD_DB.substring(rmk_TYP_RSN_CD_DB.indexOf("=")+1, rmk_TYP_RSN_CD_DB.length()-1);
             Log.Comment("The RMK Codes List Size from DB is :" + rmkCodeDB);
             Helper.compareEquals(testConfig, "Comparing RMK Codes UI and DB", rmkCodesUI, rmkCodeDB);
         }
       else
       {
    	   Log.Fail("Remark Code Functionality");
       }
}
	
public void verifyADJCode() throws Exception
{
	Element.click(adj_code, "ADJ Code");
	Browser.wait(testConfig, 3);
	@SuppressWarnings("unused")
	String oldWindow=Browser.switchToNewWindow(testConfig,"adjustmentCode.do");
    String adj_Code = (adjustmentCode.getText()).trim();
    Log.Comment("Adjustment Code Text is:" + adj_Code);
    
    if(adj_Code.equalsIgnoreCase("Adjustment Code"))
    	
     {
	    Browser.wait(testConfig, 2);
        Boolean adjCodeUI = adjustmentCode.isDisplayed();
        Helper.compareEquals(testConfig, "Adjustment Code Description Header", true, adjCodeUI);
      
    	Browser.wait(testConfig, 2);
    	Boolean adjustmentDescUI = adjustmentDesc.isDisplayed();
    	Helper.compareEquals(testConfig, "Adjustment Code is Displayed in Child Window", true, adjustmentDescUI);

        
        List<String> adj_CodesUI = new ArrayList<>();
        List<WebElement> adjustmentCodeUI2 =testConfig.driver.findElements(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr"));
        int adjustmentCodeUI1 = adjustmentCodeUI2.size();
        String adjCode = String.valueOf(adjustmentCodeUI1);
    	Log.Comment("The ADJ Reason Codes List Size from UI is :"+adjCode);
    	Browser.switchToParentWindow(testConfig,oldWindow);
    	int sqlRowNo = 193;
    	Map clm_ADJ_RSN_CD_DB1 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
    	String adj_TYP_RSN_CD_DB = (clm_ADJ_RSN_CD_DB1.toString());
		String adjCodeDB = adj_TYP_RSN_CD_DB.substring(adj_TYP_RSN_CD_DB.indexOf("=")+1, adj_TYP_RSN_CD_DB.length()-1);
        
        Log.Comment("The ADJ Reason Codes List Size from DB is :" + adjCodeDB);
        Helper.compareEquals(testConfig, "Comparing ADJ Codes UI and DB", adjCode, adjCodeDB);
    	
    }
    else
    {
    	Log.Fail("Adjustment Code Functionality");
    }
   
}
		
public void verifyRemittancePageData() throws Exception
{
	
	Browser.wait(testConfig, 2);
    String ui_Payer = payerUI.getText();
    Log.Comment("The First Payer Name displayed is:" + ui_Payer);
	Element.click(paymentNo1, "Payment No");
	Browser.wait(testConfig, 2);
	String paymentNum1 = paymentNo.getText();
	String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
	Log.Comment("The First Payment Number displayed is:" + paymentNum);
	List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
	Log.Comment("/************ List of Patient Names Present in Remittance Detail Page are as follows **********/");
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
		Log.Comment("FISL Patient First Name is:" + firstNameDB);
	    String firstPatientUI1 = firstPatient.getText();
	    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
	    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
	    Log.Comment("Online Patient First Name is:" + firstPatientUI);
	    if(!firstNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
		
	    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
		Log.Comment("FISL Patient Last Name is:" + lastNameDB);
	    String lastPatientUI1 = firstPatient.getText();
	    
	    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

	    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
	    if(!lastNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
		
	    
	    String amountChargedUI1 = amntChargedUI.getText();
	    String amountChargedUI = "";
    
	    if(amountChargedUI1.contains("-"))
	    {

	    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
	    	{
	    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
	    		
	    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    		amountChargedUI = Double.toString(amountChargedUI4);
	    		Log.Comment(amountChargedUI);
	    	}
	    	
	    	else if (amountChargedUI1.contains("$")) 
	    	{
			 
	    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
	    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    	  amountChargedUI = Double.toString(amountChargedUI4);
	    	  Log.Comment(amountChargedUI);
			}
	    	else if (amountChargedUI1.contains(",")) {
	    		
	    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
	    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    		amountChargedUI = Double.toString(amountChargedUI4);
	    		Log.Comment(amountChargedUI);
				
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
	    
	    Log.Comment("The Amount Charged from UI is :" + amountChargedUI); 
	    
	    
	    
	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>"));
	    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
	    if(!amountChargedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

	     String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();
	     
	     
	     Log.Comment("Size of Group[ Policy List is:" + grp);
	    
	     
	     if(!grp.contains(""))
	     {
	    	 String grpPolicyUI1 = grpPolicyUI.getText();
	    	 if(grpPolicyUI1.contains("/"))
	    	 {
	             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
	         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
	         	 
	         	 if(grpPolicyOnline.length()!=0)
	         	 {
	         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
		             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
		             if(!grpPolicyDB.equalsIgnoreCase("0"))
		             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
	         	 }
	         	 
	         	 else
	         	 {
	         	 
	         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	         	 }
	         }
	    	 else
	    	 {
	    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
	    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
	             if(!grpPolicyDB.equalsIgnoreCase("0"))
	              	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
	         }
	      }
	    else
	    {
	       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	    }

	     if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
	     {
	    	 
	    	 String grpPolicyUI1 = grpPolicyUI.getText();
	     
	        if(grpPolicyUI1.contains("/"))
	         {
	     
	           if(!grpPolicyUI1.isEmpty())
	            {
			        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
			        Log.Comment("Product Name from UI is :" + productNameUI);
			        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
			        Log.Comment("The Product Name from FISL is :" + productNameDB);
			        if(!productNameDB.equalsIgnoreCase("0"))
			          	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
	      }
	         }
	     }
	     
	     else
	     {
	       Log.Comment("The Product Name doesnt exists for this Criteria");
	     }
	     
	     
	     
	     String subscrbrUI1 = subscriberUI1.getText();

	     if(subscrbrUI1.contains("/"))
	     {
	    	 String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }

	     else
	     {
	     	String subscrbrUI = subscriberUI1.getText().trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }
	     
//	     Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
//	     String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
//	     Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
//	     if(!subscrbrDB.equalsIgnoreCase("0"))
//	        Helper.compareEquals(testConfig, "Comparing Subscriber ID UI and DB", subscrbrDB, subscrbrUI);
	   
	     String claimHashUI = claimHash.getText();
	     Log.Comment("Claim # from UI is :" + claimHashUI);
	     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
	     Log.Comment("Claim # from FISL is :" + claimTypeDB);
	     if(!claimTypeDB.equalsIgnoreCase("0"))
	        Helper.compareEquals(testConfig, "Comparing Claim Identifier UI and DB", claimTypeDB, claimHashUI);
	  	 
	     String accntNumUI = accntNum.getText();
	     Log.Comment("Account Number from UI is :" + accntNumUI);
	     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
	     Log.Comment("Account Number from FISL is :" + accntNumDB);
	     if(!accntNumDB.equalsIgnoreCase("0"))
	       	Helper.compareEquals(testConfig, "Comparing Account Number UI and DB", accntNumDB, accntNumUI);
	    
	     String amntAllowedUI1 = amntallowed.getText();
	     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
	     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
	     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
	     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
	     if(!amntAllowedDB.equalsIgnoreCase("0"))
	        Helper.compareEquals(testConfig, "Comparing Allowed Amounts DB and UI", amntAllowedDB, amntAllowedUI);
	   
	     /*
	     String CopayUI1 = copayUI.getText();
	     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
	     Log.Comment("Copay Amount from UI is :" + CopayUI);
	     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
	     Log.Comment("Copay Amount from FISL is :" + CopayDB);
	     if(!CopayDB.equalsIgnoreCase("0"))
	         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
	       */
//	     String patientrespUI1 = patientresp.getText();
//	     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//	     double patientrespU3 = Double.parseDouble(patientrespUI2);
//		 String patientrespUI = Double.toString(patientrespU3);
//	     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//	     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//	     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//	     if(!patientrespDB.equalsIgnoreCase("0"))
//	         Helper.compareEquals(testConfig, "Comparing Patient Responsibility Amount UI and DB", patientrespDB, patientrespUI);
// 
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
	Log.Comment("FISL Patient First Name is:" + firstNameDB);
    String firstPatientUI1 = firstPatient.getText();
    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
    Log.Comment("Online Patient First Name is:" + firstPatientUI);
    if(!firstNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
	
    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
	Log.Comment("FISL Patient Last Name is:" + lastNameDB);
    String lastPatientUI1 = firstPatient.getText();
    
    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
    if(!lastNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
	
    String amountChargedUI1 = amntChargedUI.getText();
    String amountChargedUI = "";
    
    if(amountChargedUI1.contains("-"))
    {

    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
    	{
    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
    		
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
    	}
    	
    	else if (amountChargedUI1.contains("$")) 
    	{
		 
    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    	  amountChargedUI = Double.toString(amountChargedUI4);
    	  Log.Comment(amountChargedUI);
		}
    	else if (amountChargedUI1.contains(",")) {
    		
    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
			
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
    
    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);    
    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>"));
    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
    if(!amountChargedDB.equalsIgnoreCase("0"))
       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

     
    String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();
    
    Log.Comment("Text of Group Policy List is:" + grp);
     
     if(!grp.contains(""))
     {
    	 String grpPolicyUI1 = grpPolicyUI.getText();
    	 if(grpPolicyUI1.contains("/"))
    	 {
             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
         	 
         	 if(grpPolicyOnline.length()!=0)
         	 {
         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
	             if(!grpPolicyDB.equalsIgnoreCase("0"))
	             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
         	 }
         	 
         	 else
         	 {
         	 
         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
         	 }
         }
    	 else
    	 {
    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
             if(!grpPolicyDB.equalsIgnoreCase("0"))
              	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
         }
      }
    else
    {
       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
    }
     

     if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
     {
    	 
    	 String grpPolicyUI1 = grpPolicyUI.getText();
     
        if(grpPolicyUI1.contains("/"))
         {
     
           if(!grpPolicyUI1.isEmpty())
            {
		        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
		        Log.Comment("Product Name from UI is :" + productNameUI);
		        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
		        Log.Comment("The Product Name from FISL is :" + productNameDB);
		        if(!productNameDB.equalsIgnoreCase("0"))
		        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
      }
         }
     }
     
     else
     {
       Log.Comment("The Product Name doesnt exists for this Criteria");
     }
     
     String subscrbrUI1 = subscriberUI1.getText();
     

	if(subscrbrUI1.contains("/"))
	{
	    String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
		Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
		String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
		Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
		if(!subscrbrDB.equalsIgnoreCase("0"))
		   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	}

	else
	{
		String subscrbrUI = subscriberUI1.getText().trim();
		Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
		String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
		Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
		if(!subscrbrDB.equalsIgnoreCase("0"))
		   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	}
     
//     Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
//     String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
//     Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
//     if(!subscrbrDB.equalsIgnoreCase("0"))
//        Helper.compareEquals(testConfig, "Comparing Subscriber ID UI and DB", subscrbrDB, subscrbrUI);
   
     String claimHashUI = claimHash.getText();
     Log.Comment("Claim # from UI is :" + claimHashUI);
     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
     Log.Comment("Claim # from FISL is :" + claimTypeDB);
     if(!claimTypeDB.equalsIgnoreCase("0"))
        Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", claimTypeDB, claimHashUI);
  	 
     String accntNumUI = accntNum.getText();
     Log.Comment("Account Number from UI is :" + accntNumUI);
     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
     Log.Comment("Account Number from FISL is :" + accntNumDB);
     if(!accntNumDB.equalsIgnoreCase("0"))
       	Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", accntNumDB, accntNumUI);
    
//     String amntAllowedUI1 = amntallowed.getText();
//     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
//     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
//     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
//     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
//     if(!amntAllowedDB.equalsIgnoreCase("0"))
//        Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amntAllowedDB, amntAllowedUI);
   
     /*
     String CopayUI1 = copayUI.getText();
     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
     Log.Comment("Copay Amount from UI is :" + CopayUI);
     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
     Log.Comment("Copay Amount from FISL is :" + CopayDB);
     if(!CopayDB.equalsIgnoreCase("0"))
         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
       */ 
//     String patientrespUI1 = patientresp.getText();
//     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//     double patientrespU3 = Double.parseDouble(patientrespUI2);
//	 String patientrespUI = Double.toString(patientrespU3);
//     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//     if(!patientrespDB.equalsIgnoreCase("0"))
//         Helper.compareEquals(testConfig, "Comparing Patient Responsibilty UI and DB", patientrespDB, patientrespUI);

	}
}


public void verifyRemittancePageDataSerachCriteria(String paymentType) throws Exception
{

Browser.wait(testConfig, 2);
String ui_Payer = payerUI.getText();
Log.Comment("The First Payer Name displayed is:" + ui_Payer);
Element.click(paymentNo1, "Payment No");
Browser.wait(testConfig, 2);
String paymentNum1 = paymentNo.getText();
String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
Log.Comment("The First Payment Number displayed is:" + paymentNum);
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
	Log.Comment("FISL Patient First Name is:" + firstNameDB);
    String firstPatientUI1 = firstPatient.getText();
    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
    Log.Comment("Online Patient First Name is:" + firstPatientUI);
    if(!firstNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
	
    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
	Log.Comment("FISL Patient Last Name is:" + lastNameDB);
    String lastPatientUI1 = firstPatient.getText();
    
    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
    if(!lastNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
	
    String amountChargedUI1 = amntChargedUI.getText();
    String amountChargedUI = "";
    if(amountChargedUI1.contains("-"))
    {

    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
    	{
    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
    		
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
    	}
    	
    	else if (amountChargedUI1.contains("$")) 
    	{
		 
    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    	  amountChargedUI = Double.toString(amountChargedUI4);
    	  Log.Comment(amountChargedUI);
		}
    	else if (amountChargedUI1.contains(",")) {
    		
    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
			
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
    
    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>"));
    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
    if(!amountChargedDB.equalsIgnoreCase("0"))
       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

    if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
     {
    	 String grpPolicyUI1 = grpPolicyUI.getText();
    	 if(grpPolicyUI1.contains("/"))
    	 {
             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
         	 
         	 if(grpPolicyOnline.length()!=0)
         	 {
         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
	             if(!grpPolicyDB.equalsIgnoreCase("0"))
	             	Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", grpPolicyDB, grpPolicyOnline);
         	 }
         	 
         	 else
         	 {
         	 
         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
         	 }
         }
    	 else
    	 {
    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
             if(!grpPolicyDB.equalsIgnoreCase("0"))
              	Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", grpPolicyDB, grpPolicyUI1);
         }
      }
    else
    {
       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
    }

    if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
     {
    	String grpPolicyUI1 = grpPolicyUI.getText();
     
        if(grpPolicyUI1.contains("/"))
         {
     
           if(!grpPolicyUI1.isEmpty())
            {
		        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
		        Log.Comment("Product Name from UI is :" + productNameUI);
		        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
		        Log.Comment("The Product Name from FISL is :" + productNameDB);
		        if(!productNameDB.equalsIgnoreCase("0"))
		        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
            }
         }
     }
     
     else
     {
       Log.Comment("The Product Name doesnt exists for this Criteria");
     }
     
    String subscrbrUI1 = subscriberUI1.getText();

    if(subscrbrUI1.contains("/"))
    {
                   String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
    	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
    	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
    	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
    	if(!subscrbrDB.equalsIgnoreCase("0"))
    	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
    }

    else
    {
    	String subscrbrUI = subscriberUI1.getText().trim();
    	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
    	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
    	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
    	if(!subscrbrDB.equalsIgnoreCase("0"))
    	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
    }
     
     
//     Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
//     String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
//     Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
//     if(!subscrbrDB.equalsIgnoreCase("0"))
//        Helper.compareEquals(testConfig, "Comparing Subscriber ID UI and DB", subscrbrDB, subscrbrUI);
   
     String claimHashUI = claimHash.getText();
     Log.Comment("Claim # from UI is :" + claimHashUI);
     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
     Log.Comment("Claim # from FISL is :" + claimTypeDB);
     if(!claimTypeDB.equalsIgnoreCase("0"))
        Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", claimTypeDB, claimHashUI);
  	 
     String accntNumUI = accntNum.getText();
     Log.Comment("Account Number from UI is :" + accntNumUI);
     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
     Log.Comment("Account Number from FISL is :" + accntNumDB);
     if(!accntNumDB.equalsIgnoreCase("0"))
       	Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", accntNumDB, accntNumUI);
    
     String amntAllowedUI1 = amntallowed.getText();
     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
     if(!amntAllowedDB.equalsIgnoreCase("0"))
        Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amntAllowedDB, amntAllowedUI);
   
     /*
     String CopayUI1 = copayUI.getText();
     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
     Log.Comment("Copay Amount from UI is :" + CopayUI);
     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
     Log.Comment("Copay Amount from FISL is :" + CopayDB);
     if(!CopayDB.equalsIgnoreCase("0"))
         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
       */ 
     String patientrespUI1 = patientresp.getText();
     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
     double patientrespU3 = Double.parseDouble(patientrespUI2);
	 String patientrespUI = Double.toString(patientrespU3);
     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
     if(!patientrespDB.equalsIgnoreCase("0"))
         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", patientrespDB, patientrespUI);

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
Log.Comment("FISL Patient First Name is:" + firstNameDB);
String firstPatientUI1 = firstPatient.getText();
String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
Log.Comment("Online Patient First Name is:" + firstPatientUI);
if(!firstNameDB.equalsIgnoreCase("0"))
	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);

String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
Log.Comment("FISL Patient Last Name is:" + lastNameDB);
String lastPatientUI1 = firstPatient.getText();

String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

Log.Comment("Online Patient Last Name is :" + lastPatientUI);
if(!lastNameDB.equalsIgnoreCase("0"))
	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);

String amountChargedUI1 = amntChargedUI.getText();
String amountChargedUI = "";
if(amountChargedUI1.contains("-"))
{

	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
	{
		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
		
		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		amountChargedUI = Double.toString(amountChargedUI4);
		Log.Comment(amountChargedUI);
	}
	
	else if (amountChargedUI1.contains("$")) 
	{
	 
	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	  amountChargedUI = Double.toString(amountChargedUI4);
	  Log.Comment(amountChargedUI);
	}
	else if (amountChargedUI1.contains(",")) {
		
		String amountChargedUI3 = amountChargedUI1.replace(",", "");
		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		amountChargedUI = Double.toString(amountChargedUI4);
		Log.Comment(amountChargedUI);
		
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

Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  


String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>"));
Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
if(!amountChargedDB.equalsIgnoreCase("0"))
   Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

 
if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
 {
	 String grpPolicyUI1 = grpPolicyUI.getText();
	 if(grpPolicyUI1.contains("/"))
	 {
         String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
     	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
     	 
     	 if(grpPolicyOnline.length()!=0)
     	 {
     		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
             if(!grpPolicyDB.equalsIgnoreCase("0"))
             	Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", grpPolicyDB, grpPolicyOnline);
     	 }
     	 
     	 else
     	 {
     	 
     		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
     	 }
     }
	 else
	 {
		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
         Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
         if(!grpPolicyDB.equalsIgnoreCase("0"))
          	Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", grpPolicyDB, grpPolicyUI1);
     }
  }
else
{
   Log.Comment("The Group Policy Number doesnt exists for this Criteria");
}

   
 if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
 {
	String grpPolicyUI1 = grpPolicyUI.getText();
 
    if(grpPolicyUI1.contains("/"))
     {
 
       if(!grpPolicyUI1.isEmpty())
        {
	        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
	        Log.Comment("Product Name from UI is :" + productNameUI);
	        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
	        Log.Comment("The Product Name from FISL is :" + productNameDB);
	        if(!productNameDB.equalsIgnoreCase("0"))
	        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
        }
     }
 }
 
 else
 {
   Log.Comment("The Product Name doesnt exists for this Criteria");
 }
 
// String subscrbrUI = subscriberUI1.getText();
// Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
// String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
// Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
// if(!subscrbrDB.equalsIgnoreCase("0"))
//    Helper.compareEquals(testConfig, "Comparing Subscriber ID UI and DB", subscrbrDB, subscrbrUI);

 
 String subscrbrUI1 = subscriberUI1.getText();

 if(subscrbrUI1.contains("/"))
 {
                String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
 	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
 	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
 	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
 	if(!subscrbrDB.equalsIgnoreCase("0"))
 	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
 }

 else
 {
 	String subscrbrUI = subscriberUI1.getText().trim();
 	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
 	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
 	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
 	if(!subscrbrDB.equalsIgnoreCase("0"))
 	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
 }
 
 String claimHashUI = claimHash.getText();
 Log.Comment("Claim # from UI is :" + claimHashUI);
 String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
 Log.Comment("Claim # from FISL is :" + claimTypeDB);
 if(!claimTypeDB.equalsIgnoreCase("0"))
    Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", claimTypeDB, claimHashUI);
	 
 String accntNumUI = accntNum.getText();
 Log.Comment("Account Number from UI is :" + accntNumUI);
 String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
 Log.Comment("Account Number from FISL is :" + accntNumDB);
 if(!accntNumDB.equalsIgnoreCase("0"))
   	Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", accntNumDB, accntNumUI);

 String amntAllowedUI1 = amntallowed.getText();
 String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
 Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
 String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
 Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
 if(!amntAllowedDB.equalsIgnoreCase("0"))
    Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amntAllowedDB, amntAllowedUI);

 /*
 String CopayUI1 = copayUI.getText();
 String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
 Log.Comment("Copay Amount from UI is :" + CopayUI);
 String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
 Log.Comment("Copay Amount from FISL is :" + CopayDB);
 if(!CopayDB.equalsIgnoreCase("0"))
     Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
   */ 
 String patientrespUI1 = patientresp.getText();
 String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
 double patientrespU3 = Double.parseDouble(patientrespUI2);
 String patientrespUI = Double.toString(patientrespU3);
 Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
 String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
 Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
 if(!patientrespDB.equalsIgnoreCase("0"))
     Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", patientrespDB, patientrespUI);
}
}

	
public void verifyCOBFilterClaimOption() throws Exception
{
	 Element.selectVisibleText(filterClaims,"COB Only","Claim Filter DropDown");
	 Log.Comment("Filter Claims Dropdown selected - COB Only");
}
    
    
public void verifyCOBFilterClaimData() throws Exception
{
	Element.click(returnBtn, "Return Button");
	Browser.wait(testConfig, 2);
        String ui_Payer = payerUI.getText();
	Log.Comment("The First Payer Name displayed is:" + ui_Payer);

	Element.click(paymentNo1, "Payment No");
	Browser.wait(testConfig, 2);
	
	
	Element.selectVisibleText(filterClaims,"COB Only","Claim Filter DropDown");
    Element.expectedWait(filterClaims, testConfig, "COB Only", "COB Only");
    Log.Comment("Filter Claims Dropdown selected - COB Only");
    
    Browser.wait(testConfig, 2);
  int size = testConfig.driver.findElements( By.xpath("//td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")).size();
  
  Log.Comment("Size of the tlist is:" + size);
	
    if(testConfig.driver.findElements( By.xpath("//td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")).size() != 0)
    {
		List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));

	      int sqlRowNo = 184;
	  	testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
	  	Map payerSchema = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	  	Log.Comment("Message from DB for Payer Schema:" + payerSchema);
	  	
	  	
	  	String paymentNum1 = paymentNo.getText();
		String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
		Log.Comment("The First  Payment Number displayed is:" + paymentNum);
	  	
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
	                  "<ns2:ClaimFilterTypeCode>2,3</ns2:ClaimFilterTypeCode>" +
	                  "</ns17:EpsClaimsRequest>";
	  		
	  		
	  		String getResponse=new FISLConnection2().getEraResponse1(requestXml);
	  		
	  		String firstNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientFirstName>")+22, getResponse.indexOf("</ns0:PatientFirstName>"));
	  		Log.Comment("FISL Patient First Name is:" + firstNameDB);
	  	    String firstPatientUI1 = firstPatient.getText();
	  	    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
	  	    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
	  	    Log.Comment("Online Patient First Name is:" + firstPatientUI);
	  	    if(!firstNameDB.equalsIgnoreCase("0"))
	  	    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
	  		
	  	    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
	  		Log.Comment("FISL Patient Last Name is:" + lastNameDB);
	  	    String lastPatientUI1 = firstPatient.getText();
	  	    
	  	    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

	  	    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
	  	    if(!lastNameDB.equalsIgnoreCase("0"))
	  	    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
	  		
	  	    String amountChargedUI1 = amntChargedUI.getText();
		    String amountChargedUI = "";
		   
		    if(amountChargedUI1.contains("-"))
		    {

		    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
		    	{
		    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
		    		
		    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    		amountChargedUI = Double.toString(amountChargedUI4);
		    		Log.Comment(amountChargedUI);
		    	}
		    	
		    	else if (amountChargedUI1.contains("$")) 
		    	{
				 
		    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
		    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    	  amountChargedUI = Double.toString(amountChargedUI4);
		    	  Log.Comment(amountChargedUI);
				}
		    	else if (amountChargedUI1.contains(",")) {
		    		
		    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
		    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		    		amountChargedUI = Double.toString(amountChargedUI4);
		    		Log.Comment(amountChargedUI);
					
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
		    
		    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
	  	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>")); 
	  	    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
	  	    if(!amountChargedDB.equalsIgnoreCase("0"))
	  	       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

	  	     
               String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();
      	     
      	     
      	     Log.Comment("Size of Group[ Policy List is:" + grp);
      	    
      	     
      	     if(!grp.contains(""))
      	     {
      	    	 String grpPolicyUI1 = grpPolicyUI.getText();
      	    	 if(grpPolicyUI1.contains("/"))
      	    	 {
      	             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
      	         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
      	         	 
      	         	 if(grpPolicyOnline.length()!=0)
      	         	 {
      	         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
      		             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
      		             if(!grpPolicyDB.equalsIgnoreCase("0"))
      		             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
      	         	 }
      	         	 
      	         	 else
      	         	 {
      	         	 
      	         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
      	         	 }
      	         }
      	    	 else
      	    	 {
      	    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
      	    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
      	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
      	             if(!grpPolicyDB.equalsIgnoreCase("0"))
      	              	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
      	         }
      	      }
      	    else
      	    {
      	       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
      	    }

      	     if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
      	     {
      	    	 
      	    	 String grpPolicyUI1 = grpPolicyUI.getText();
      	     
      	        if(grpPolicyUI1.contains("/"))
      	         {
      	     
      	           if(!grpPolicyUI1.isEmpty())
      	            {
      			        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
      			        Log.Comment("Product Name from UI is :" + productNameUI);
      			        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
      			        Log.Comment("The Product Name from FISL is :" + productNameDB);
      			        if(!productNameDB.equalsIgnoreCase("0"))
      			        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
      	      }
      	         }
      	     }
      	     
      	     else
      	     {
      	       Log.Comment("The Product Name doesnt exists for this Criteria");
      	     }
      	    
      	   String subscrbrUI1 = subscriberUI1.getText();

  	     if(subscrbrUI1.contains("/"))
  	     {
  	    	 String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
  	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
  	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
  	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
  	     	if(!subscrbrDB.equalsIgnoreCase("0"))
  	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
  	     }

  	     else
  	     {
  	     	String subscrbrUI = subscriberUI1.getText().trim();
  	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
  	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
  	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
  	     	if(!subscrbrDB.equalsIgnoreCase("0"))
  	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
  	     }
  	     
      	     String claimHashUI = claimHash.getText();
      	     Log.Comment("Claim # from UI is :" + claimHashUI);
      	     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
      	     Log.Comment("Claim # from FISL is :" + claimTypeDB);
      	     if(!claimTypeDB.equalsIgnoreCase("0"))
      	        Helper.compareEquals(testConfig, "Comparing Claim Identifier UI and DB", claimTypeDB, claimHashUI);
      	  	 
      	     String accntNumUI = accntNum.getText();
      	     Log.Comment("Account Number from UI is :" + accntNumUI);
      	     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
      	     Log.Comment("Account Number from FISL is :" + accntNumDB);
      	     if(!accntNumDB.equalsIgnoreCase("0"))
      	       	Helper.compareEquals(testConfig, "Comparing Account Number UI and DB", accntNumDB, accntNumUI);
      	    
      	     String amntAllowedUI1 = amntallowed.getText();
      	     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
      	     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
      	     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
      	     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
      	     if(!amntAllowedDB.equalsIgnoreCase("0"))
      	        Helper.compareEquals(testConfig, "Comparing Allowed Amounts DB and UI", amntAllowedDB, amntAllowedUI);
      	   
      	     /*
      	     String CopayUI1 = copayUI.getText();
      	     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
      	     Log.Comment("Copay Amount from UI is :" + CopayUI);
      	     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
      	     Log.Comment("Copay Amount from FISL is :" + CopayDB);
      	     if(!CopayDB.equalsIgnoreCase("0"))
      	         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
      	       */
//      	     String patientrespUI1 = patientresp.getText();
//      	     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//      	     double patientrespU3 = Double.parseDouble(patientrespUI2);
//      		 String patientrespUI = Double.toString(patientrespU3);
//      	     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//      	     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//      	     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//      	     if(!patientrespDB.equalsIgnoreCase("0"))
//      	         Helper.compareEquals(testConfig, "Comparing Patient Responsibility Amount UI and DB", patientrespDB, patientrespUI);
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
	                           "<ns2:ClaimFilterTypeCode>2,3</ns2:ClaimFilterTypeCode>" +
	                           "</ns17:EpsClaimsRequest>";
	  	
	  	String getResponse=new FISLConnection2().getEraResponse1(requestXml);
	  	
	  	String firstNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientFirstName>")+22, getResponse.indexOf("</ns0:PatientFirstName>"));
  		Log.Comment("FISL Patient First Name is:" + firstNameDB);
  	    String firstPatientUI1 = firstPatient.getText();
  	    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
  	    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
  	    Log.Comment("Online Patient First Name is:" + firstPatientUI);
  	    if(!firstNameDB.equalsIgnoreCase("0"))
  	    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
  		
  	    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
  		Log.Comment("FISL Patient Last Name is:" + lastNameDB);
  	    String lastPatientUI1 = firstPatient.getText();
  	    
  	    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

  	    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
  	    if(!lastNameDB.equalsIgnoreCase("0"))
  	    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
  		
  	    String amountChargedUI1 = amntChargedUI.getText();
	    String amountChargedUI = "";
	    
	    if(amountChargedUI1.contains("-"))
	    {

	    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
	    	{
	    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
	    		
	    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    		amountChargedUI = Double.toString(amountChargedUI4);
	    		Log.Comment(amountChargedUI);
	    	}
	    	
	    	else if (amountChargedUI1.contains("$")) 
	    	{
			 
	    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
	    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    	  amountChargedUI = Double.toString(amountChargedUI4);
	    	  Log.Comment(amountChargedUI);
			}
	    	else if (amountChargedUI1.contains(",")) {
	    		
	    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
	    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    		amountChargedUI = Double.toString(amountChargedUI4);
	    		Log.Comment(amountChargedUI);
				
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
	    
	    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
  	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>")); 
  	    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
  	    if(!amountChargedDB.equalsIgnoreCase("0"))
  	       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

           String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();
  	     
  	     
  	     Log.Comment("Size of Group[ Policy List is:" + grp);
  	    
  	     
  	     if(!grp.contains(""))
  	     {
  	    	 String grpPolicyUI1 = grpPolicyUI.getText();
  	    	 if(grpPolicyUI1.contains("/"))
  	    	 {
  	             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
  	         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
  	         	 
  	         	 if(grpPolicyOnline.length()!=0)
  	         	 {
  	         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
  		             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
  		             if(!grpPolicyDB.equalsIgnoreCase("0"))
  		             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
  	         	 }
  	         	 
  	         	 else
  	         	 {
  	         	 
  	         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
  	         	 }
  	         }
  	    	 else
  	    	 {
  	    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
  	    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
  	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
  	             if(!grpPolicyDB.equalsIgnoreCase("0"))
  	              	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
  	         }
  	      }
  	    else
  	    {
  	       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
  	    }

  	     if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
  	     {
  	    	 
  	    	 String grpPolicyUI1 = grpPolicyUI.getText();
  	     
  	        if(grpPolicyUI1.contains("/"))
  	         {
  	     
  	           if(!grpPolicyUI1.isEmpty())
  	            {
  			        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
  			        Log.Comment("Product Name from UI is :" + productNameUI);
  			        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
  			        Log.Comment("The Product Name from FISL is :" + productNameDB);
  			        if(!productNameDB.equalsIgnoreCase("0"))
  			        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
  	      }
  	         }
  	     }
  	     
  	     else
  	     {
  	       Log.Comment("The Product Name doesnt exists for this Criteria");
  	     }
  	     
  	     
  	   String subscrbrUI1 = subscriberUI1.getText();

	     if(subscrbrUI1.contains("/"))
	     {
	    	 String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }

	     else
	     {
	     	String subscrbrUI = subscriberUI1.getText().trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }
	     
  	     String claimHashUI = claimHash.getText();
  	     Log.Comment("Claim # from UI is :" + claimHashUI);
  	     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
  	     Log.Comment("Claim # from FISL is :" + claimTypeDB);
  	     if(!claimTypeDB.equalsIgnoreCase("0"))
  	        Helper.compareEquals(testConfig, "Comparing Claim Identifier UI and DB", claimTypeDB, claimHashUI);
  	  	 
  	     String accntNumUI = accntNum.getText();
  	     Log.Comment("Account Number from UI is :" + accntNumUI);
  	     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
  	     Log.Comment("Account Number from FISL is :" + accntNumDB);
  	     if(!accntNumDB.equalsIgnoreCase("0"))
  	       	Helper.compareEquals(testConfig, "Comparing Account Number UI and DB", accntNumDB, accntNumUI);
  	    
  	     String amntAllowedUI1 = amntallowed.getText();
  	     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
  	     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
  	     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
  	     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
  	     if(!amntAllowedDB.equalsIgnoreCase("0"))
  	        Helper.compareEquals(testConfig, "Comparing Allowed Amounts DB and UI", amntAllowedDB, amntAllowedUI);
  	   
  	     /*
  	     String CopayUI1 = copayUI.getText();
  	     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
  	     Log.Comment("Copay Amount from UI is :" + CopayUI);
  	     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
  	     Log.Comment("Copay Amount from FISL is :" + CopayDB);
  	     if(!CopayDB.equalsIgnoreCase("0"))
  	         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
  	       */
//  	     String patientrespUI1 = patientresp.getText();
//  	     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//  	     double patientrespU3 = Double.parseDouble(patientrespUI2);
//  		 String patientrespUI = Double.toString(patientrespU3);
//  	     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//  	     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//  	     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//  	     if(!patientrespDB.equalsIgnoreCase("0"))
//  	         Helper.compareEquals(testConfig, "Comparing Patient Responsibility Amount UI and DB", patientrespDB, patientrespUI);
	  	}
	}
	
	else
	{
	    String claim = testConfig.driver.findElement(By.xpath("//div[@id='msgforplb']/span[@class='Subheaderbold']")).getText().substring(6,46);
        Log.Comment("COB Only Message displaying on Remit Page is :" + claim);
		Helper.compareEquals(testConfig, "Checking data for COB Claim only", claim, "This payment contains adjustment(s) only");
	    Log.Comment("COB Claim doesnt contain data for this criteria");
	}
}


public void verifyReversalFilterClaimData(String usertype) throws Exception {
    Element.click(returnBtn, "Return Button");
    Browser.wait(testConfig, 2);

    String ui_Payer = payernameUI.getText();
    Log.Comment("The First Payer Name displayed is:" + ui_Payer);
    Element.click(paymentNo1, "Payment No");
    Browser.wait(testConfig, 2);
    handleTechnicalDifficultyError();

    Element.expectedWait(filterClaims, testConfig, "Filter Dropdown", "Filter Dropdown");
    Element.selectVisibleText(filterClaims, "Reversal Only", "Claim Filter DropDown");
    Log.Comment("Filter Claims Dropdown selected - Reversal Only");

    Browser.wait(testConfig, 2);
    handleTechnicalDifficultyError();

    if (testConfig.driver.findElements(By.xpath("//td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")).size() != 0) {
        String xmlRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<ns21:EpsClaimsRequest xmlns=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns20=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/Edi835ContentService_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns10=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns21=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentDetailService_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns19=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns18=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0\">\n" +
                "\t<ns19:SearchCriteria ns19:FromRecord=\"-1\" ns19:MaxResult=\"10\" ns19:SortDirection=\"ASC\" ns19:SortFieldNumber=\"0\"/>\n" +
                "\t<ns3:PaymentIdentifier>" + getFinalIdentifier() + "</ns3:PaymentIdentifier>\n" +
                "    <ns2:ClaimFilterTypeCode>22</ns2:ClaimFilterTypeCode>\n" +
                "</ns21:EpsClaimsRequest>";
        Log.Comment("XML Request : \n" + xmlRequest);

        String response = invokePostCall(xmlRequest);

        coreFISLvalidationWithUI(response);
    } else {
        String claim = testConfig.driver.findElement(By.xpath("//div[@id='msgforplb']/span[@class='Subheaderbold']")).getText().substring(6, 46);
        Log.Comment("Reversal Only Message displaying on Remit Page is :" + claim);
        Helper.compareEquals(testConfig, "Checking data for Reversal Claim only", claim, "This payment contains adjustment(s) only");
        Log.Comment("Reversal Claim doesnt contain data for this criteria");
    }

}


	public void enterTINMultiplePLBAdj() throws Exception {
		String prov_TAX_ID_NBR = DataBase
				.executeSelectQuery(testConfig, QUERY.GET_TIN_PAYMENT_NUMBER_FOR_MULTIPLE_PLB_ADJUSTMENTS, 1)
				.get("PROV_TAX_ID_NBR");
		Log.Comment("The TIN for Multiple PLB Adj is:" + prov_TAX_ID_NBR);
		testConfig.putRunTimeProperty("tin", prov_TAX_ID_NBR);
		Element.click(enterTIN, "Enter TIN");
		Element.enterData(enterTIN, prov_TAX_ID_NBR, "Entering TIN", "Enter TIN");
		Element.click(searchBtn, "Search");
	}

public RemittanceDetail enterTinCSR(String paymentType, String usertype)
{
	    String tin=getTinCSR(paymentType);
	    System.setProperty("tin", tin); 
	
	    switch(usertype) 
	 {
	 
case "PROV":
   {   
  	 //Element.selectVisibleText(txtboxTinNo,tin,"Enter TIN in CSR");
  	 Element.enterData(txtboxTinNo, tin, "Enter TIN", "Enter TIN in CSR");
  	 Element.click(submitBtn, "Click Search Button");
  	 break;
    }  
case "BS":
   {
  	 Element.enterData(bstinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
  	 Element.click(submitBtn, "Click Search Button");
  	 break;
    }
case "Payer":
   {
  	 Element.enterData(payertinDrpDwn, tin, "Enter TIN", "Enter TIN into Provider Column");
  	 Element.click(submitBtn, "Click Search Button");
  	 break;
    }
}
	return this; 
}

private String getTinCSR(String paymentType) {
	
	dataProvider=new ViewPaymentsDataProvider(testConfig);
	return "";//dataProvider.getTinForPaymentType(paymentType);
}

public void enterTINMultiplePLBAdjUPA() throws Exception
{
	
	int sqlRowNo = 200;
	Map prov_TAX_ID_NBRDB3 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String prov_TAX_ID_NBRDB1 = prov_TAX_ID_NBRDB3.toString();
	String prov_TAX_ID_NBRDB2 = prov_TAX_ID_NBRDB1.substring(prov_TAX_ID_NBRDB1.lastIndexOf("=")+1);
    String prov_TAX_ID_NBR = prov_TAX_ID_NBRDB2.substring(0, prov_TAX_ID_NBRDB2.length()-1);
    Log.Comment("The TIN for Multiple PLB Adj is:" + prov_TAX_ID_NBR);
    Element.click(prvdrTIN, "Enter TIN");
    Element.enterData(prvdrTIN, prov_TAX_ID_NBR, "Enter tin number as "+prov_TAX_ID_NBR, "tinNumber");
    Element.click(srchTINUPA, "Search");
}

public void enterElectronicNumForMultiplePLBCriteria() throws Exception
{
//    int sqlRowNo = 223;
//	System.getProperty("tin");
//	Map cp_DSPL_CONSL_PAY_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
//
//	String elctronicNum = cp_DSPL_CONSL_PAY_NBRDB.get("CP_DSPL_CONSL_PAY_NBR").toString();
//	Log.Comment("The Electronic Payment Number is :" + elctronicNum);
//	System.setProperty("consl_pay_nbr", cp_DSPL_CONSL_PAY_NBRDB.get("CONSL_PAY_NBR").toString());
//	
//	Element.expectedWait(payNumdrpdwn, testConfig, "Electronic Payment Dropdown", "Electronic Payment Dropdown");
//	Element.selectVisibleText(payNumdrpdwn,"Electronic Payment Number","Payment Dropdown");
//	Log.Comment("Payment Dropdown Selected: Electronic Payment Number is selected");
//	Element.click(elcPayNum, "Electronic Payment Number");
//	Element.enterData(elcPayNum, elctronicNum, "Enter Electronic number as "+elctronicNum, "Electonic Payment Number");
//	Element.click(srchRemitBtn, "Search Remit");
	
	String tin = System.getProperty("tin");
	 int sqlRowNo = 1902;
	//int sqlRowNo = 49;
	testConfig.putRunTimeProperty("tin",tin);
	Map cp_DSPL_CONSL_PAY_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);

	String elctronicNum = cp_DSPL_CONSL_PAY_NBRDB.get("CP_DSPL_CONSL_PAY_NBR").toString();
	Log.Comment("The Electronic Payment Number is :" + elctronicNum);
	//System.setProperty("consl_pay_nbr", cp_DSPL_CONSL_PAY_NBRDB.get("CONSL_PAY_NBR").toString());
	
	Element.expectedWait(payNumdrpdwn, testConfig, "Electronic Payment Dropdown", "Electronic Payment Dropdown");
	Element.selectVisibleText(payNumdrpdwn,"Electronic Payment Number","Payment Dropdown");
	Log.Comment("Payment Dropdown Selected: Electronic Payment Number is selected");
	Element.click(elcPayNum, "Electronic Payment Number");
	Element.enterData(elcPayNum, elctronicNum, "Enter Electronic number as "+elctronicNum, "Electonic Payment Number");
	Element.click(srchRemitBtn, "Search Remit");
	
}


	public void verifyRemitPageDataUPA(String criteriaType) throws Exception {
		if (criteriaType != "RemitDetail") {
			handleTechnicalDifficultyError();
			String cpDsplConslPayNbr = DataBase
					.executeSelectQuery(testConfig, QUERY.GET_CONSL_PAY_NBR_FOR_REMITTANCE_DETAIL, 1)
					.get("CP_DSPL_CONSL_PAY_NBR");
			Log.Comment("cpDsplConslPayNbr is :" + cpDsplConslPayNbr);
			testConfig.putRunTimeProperty("cpDsplConslPayNbr", cpDsplConslPayNbr);
			Element.selectByVisibleText(paymentNumberType, "Electronic Payment Number",
					"Electronic Payment Number from 'Payment Number' dropdown");
			Element.clickByJS(testConfig, paymentNumberSearchRemit, "Payment No text box");
			Element.enterData(paymentNumberSearchRemit, cpDsplConslPayNbr,
					"Enter Electronic payment number as: " + cpDsplConslPayNbr, "payment number");
			Element.clickByJS(testConfig, btnSearchRemittance, "Search Remittance Button");
		} else {
			String cpDsplConslPayNbr = DataBase
					.executeSelectQuery(testConfig, QUERY.GET_CONSL_PAY_NBR_FOR_REMITTANCE_DETAIL, 1)
					.get("CP_DSPL_CONSL_PAY_NBR");
			Log.Comment("cpDsplConslPayNbr is :" + cpDsplConslPayNbr);
			testConfig.putRunTimeProperty("cpDsplConslPayNbr", cpDsplConslPayNbr);
			Element.expectedWait(payNumdrpdwn, testConfig, "Electronic Payment Dropdown",
					"Electronic Payment Dropdown");
			Element.selectVisibleText(payNumdrpdwn, "Electronic Payment Number", "Payment Dropdown");
			Log.Comment("Payment Dropdown Selected: Electronic Payment Number is selected");
			Element.click(elcPayNum, "Electronic Payment Number");
			Element.enterData(elcPayNum, cpDsplConslPayNbr, "Enter Electronic number as " + cpDsplConslPayNbr,
					"Electonic Payment Number");
			Element.click(srchRemitBtn, "Search Remit");
		}
	}

public void verifyMultiplePLBAdj() throws Exception
{
    int sqlRowNo = 187;
	Map consl_PAY_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String consl_PAY_NBR1 = consl_PAY_NBRDB.toString();
    String consl_PAY_NBR2 = consl_PAY_NBR1.substring(consl_PAY_NBR1.lastIndexOf("=")+1);
    String consl_PAY_NBR = consl_PAY_NBR2.substring(0, consl_PAY_NBR2.length()-1);
    Log.Comment("The CP_DSPL_CONSL_PAY_NBR is :" + consl_PAY_NBR);
    Element.expectedWait(paymentNo1, testConfig, "Payment No", "Payment No");
    Element.click(paymentNo1, "Payment No");
    List<WebElement> subTotal_Count1 =testConfig.driver.findElements(By.xpath("//tr[@class='rowDarkbold']/td[1]")); 
    int subTotal_Count = subTotal_Count1.size();
    if(subTotal_Count >10)
    {
    	Element.click(lastPage, "Last Page");
    	Browser.wait(testConfig, 3);
    	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
    	
    	Boolean refCodePLBUI = refCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
    	
    	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
    	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);
    	Browser.wait(testConfig, 7);
    	List<WebElement> list=testConfig.driver.findElements(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table/tbody/tr"));
    	
    	int size = list.size();
    	Log.Comment("Size of PLB List is :" + size);
		List<String> plb_UI=new ArrayList<>();
		
		for(int i=1; i<=size; i++)
		{
			for(int j=1; j<=3; j++)
			{
				String sText=testConfig.driver.findElement(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(sText.contains("$"))
				{
					sText= sText.replace("$","").trim();
				}
				
				     plb_UI.add(sText.trim());
			   }
	     }
		
		Collections.sort(plb_UI);
	    Log.Comment("The Multiple PLB Adjustment Data from UI is" + plb_UI);
		sqlRowNo = 190;
    	testConfig.putRunTimeProperty("CP_DSPL_CONSL_PAY_NBR",consl_PAY_NBR);
    	ArrayList<String> plb_DB = new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
        for (int i = 1; i <= plb_DB1.size(); i++) 
		{
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
			plb_DB.add(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT"));
		}
		
	    Collections.sort(plb_DB);
		Log.Comment("The Multiple PLB Adjustment Data from DB is :" + plb_DB);
		
		Helper.compareEquals(testConfig, "The Multiple PLB Adjustment Data from DB", plb_DB, plb_UI);
    	
       }
    else
    {
    	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
    	
    	Boolean refCodePLBUI = refCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
    	
    	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
    	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);

    	List<WebElement> list=testConfig.driver.findElements(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table/tbody/tr"));
    	
    	int size = list.size();
    	Log.Comment("Size of PLB List is :" + size);
		List<String> plb_UI=new ArrayList<>();
		
		for(int i=1; i<=size; i++)
		{
			for(int j=1; j<=3; j++)
			{
				String sText=testConfig.driver.findElement(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(sText.contains("$"))
				{
					sText= sText.replace("$","").trim();
				}
				
				     plb_UI.add(sText.trim());
			   }
	     }
		
		Collections.sort(plb_UI);
	    Log.Comment("The Multiple PLB Adjustment Data from UI is" + plb_UI);
		sqlRowNo = 190;
    	testConfig.putRunTimeProperty("CP_DSPL_CONSL_PAY_NBR",consl_PAY_NBR);
    	ArrayList<String> plb_DB = new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
        for (int i = 1; i <= plb_DB1.size(); i++) 
		{
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
			plb_DB.add(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT"));
		}
		
	    Collections.sort(plb_DB);
		Log.Comment("The Multiple PLB Adjustment Data from DB is :" + plb_DB);
		
		Helper.compareEquals(testConfig, "The Multiple PLB Adjustment Data from DB", plb_DB, plb_UI);

    }

        Element.click(homeBtn, "Home Button");
}



public void verifyMultiplePLBAdjUPA() throws Exception
{
//    int sqlRowNo = 187;
//	Map consl_PAY_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
//	String consl_PAY_NBR1 = consl_PAY_NBRDB.toString();
//    String consl_PAY_NBR2 = consl_PAY_NBR1.substring(consl_PAY_NBR1.lastIndexOf("=")+1);
//    String consl_PAY_NBR = consl_PAY_NBR2.substring(0, consl_PAY_NBR2.length()-1);
//    Log.Comment("The CP_DSPL_CONSL_PAY_NBR is :" + consl_PAY_NBR);
    Element.expectedWait(paymentNo1, testConfig, "Payment No", "Payment No");
    Element.click(paymentNo1, "Payment No");
    List<WebElement> subTotal_Count1 =testConfig.driver.findElements(By.xpath("//tr[@class='rowDarkbold']/td[1]")); 
    int subTotal_Count = subTotal_Count1.size();
    if(subTotal_Count >=10)
    {
    	if(testConfig.driver.findElements(By.xpath("//a[contains(text(),'Last Page')]")).size() != 0)
    	{
    		Element.click(lastPage, "Last Page");
    		Browser.wait(testConfig, 3);
        	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
        	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
        	
        	Boolean refCodePLBUI = refCodePLB.isDisplayed();
        	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
        	
        	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
        	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);
    	}
    	else
    	{
    	
    		Browser.wait(testConfig, 3);
        	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
        	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
        	
        	Boolean refCodePLBUI = refCodePLB.isDisplayed();
        	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
        	
        	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
        	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);
    	}
    	
    	
    	List<WebElement> list=testConfig.driver.findElements(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table[1]/tbody/tr"));
    	                                                              
    	
    	int size = list.size();
    	Log.Comment("Size of PLB List is :" + size);
		List<String> plb_UI=new ArrayList<>();
		
		for(int i=1; i<=size; i++)
		{
			for(int j=1; j<=3; j++)
			{
				String sText=testConfig.driver.findElement(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table[1]/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(sText.contains("$"))
				{
					sText= sText.replace("$","").trim();
				}
				
				     plb_UI.add(sText.trim());
			   }
	     }
		
		Collections.sort(plb_UI);
	    Log.Comment("The Multiple PLB Adjustment Data from UI is" + plb_UI);
		
//    	sqlRowNo = 190;
//    	testConfig.putRunTimeProperty("CP_DSPL_CONSL_PAY_NBR",consl_PAY_NBR);
	    
	    int sqlRowNo = 241;
	    String consl_pay_nbr =  System.getProperty("consl_pay_nbr");
	    testConfig.putRunTimeProperty("consl_pay_nbr",consl_pay_nbr);
	    ArrayList<String> plb_DB = new ArrayList<String>();
        HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		
        for (int i = 1; i <= plb_DB1.size(); i++) 
		{
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
			plb_DB.add(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT"));
		}
		
	    Collections.sort(plb_DB);
		Log.Comment("The Multiple PLB Adjustment Data from DB is :" + plb_DB);
		
		Helper.compareEquals(testConfig, "The Multiple PLB Adjustment Data from DB", plb_DB, plb_UI);
    	
       }
    else
    {
    	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
    	
    	Boolean refCodePLBUI = refCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
    	
    	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
    	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);

    	List<WebElement> list=testConfig.driver.findElements(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table[1]/tbody/tr"));
    	
    	int size = list.size();
    	Log.Comment("Size of PLB List is :" + size);
		List<String> plb_UI=new ArrayList<>();
		
		for(int i=1; i<=size; i++)
		{
			for(int j=1; j<=3; j++)
			{
				String sText=testConfig.driver.findElement(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table[1]/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(sText.contains("$"))
				{
					sText= sText.replace("$","").trim();
				}
				
				     plb_UI.add(sText.trim());
			   }
	     }
		
		Collections.sort(plb_UI);
	    Log.Comment("The Multiple PLB Adjustment Data from UI is" + plb_UI);
		int sqlRowNo = 190;
    	//testConfig.putRunTimeProperty("CP_DSPL_CONSL_PAY_NBR",consl_PAY_NBR);
    	ArrayList<String> plb_DB = new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
        for (int i = 1; i <= plb_DB1.size(); i++) 
		{
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
			plb_DB.add(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT"));
		}
		
	    Collections.sort(plb_DB);
		Log.Comment("The Multiple PLB Adjustment Data from DB is :" + plb_DB);
		
		Helper.compareEquals(testConfig, "The Multiple PLB Adjustment Data from DB", plb_DB, plb_UI);

    }

    //Element.click(homeBtnUPA, "Home Button UPA");
}


public void enterTINPLBOnlyAdj() throws Exception
{
	int sqlRowNo = 188;
	Map prov_TAX_ID_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String prov_TAX_ID_NBRDB1 = prov_TAX_ID_NBRDB.toString();
	String prov_TAX_ID_NBR2 = prov_TAX_ID_NBRDB1.substring(prov_TAX_ID_NBRDB1.lastIndexOf("=")+1);
	String prov_TAX_ID_NBR = prov_TAX_ID_NBR2.substring(0, prov_TAX_ID_NBR2.length()-1);
	Log.Comment("The PROV_TIN_NBR is :" + prov_TAX_ID_NBR);
    Element.click(enterTIN, "Enter TIN");
    Element.enterData(enterTIN, prov_TAX_ID_NBR, "Enter tin number as "+prov_TAX_ID_NBR, "tinNumber");
    Element.click(searchBtn, "Search");
	
}


public void enterTINPLBOnlyAdjUPA() throws Exception
{
	int sqlRowNo = 188;
	Map prov_TAX_ID_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String prov_TAX_ID_NBRDB1 = prov_TAX_ID_NBRDB.toString();
	String prov_TAX_ID_NBR2 = prov_TAX_ID_NBRDB1.substring(prov_TAX_ID_NBRDB1.lastIndexOf("=")+1);
	String prov_TAX_ID_NBR = prov_TAX_ID_NBR2.substring(0, prov_TAX_ID_NBR2.length()-1);
	Log.Comment("The PROV_TIN_NBR is :" + prov_TAX_ID_NBR);
    Element.click(enterTIN, "Enter TIN");
    Element.enterData(enterTIN, prov_TAX_ID_NBR, "Enter tin number as "+prov_TAX_ID_NBR, "tinNumber");
    Element.click(srchTINUPA, "Search");
	
}


public void enterElectronicNumForPLBOnlyCriteria() throws Exception
{
//    int sqlRowNo = 201;
//	Map cp_DSPL_CONSL_PAY_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
//	String elctronicNum1 = cp_DSPL_CONSL_PAY_NBRDB.toString();
//	String elctronicNum2 = elctronicNum1.substring(elctronicNum1.lastIndexOf("=")+1);
//	String elctronicNum = elctronicNum2.substring(0, elctronicNum2.length()-1);
//	Log.Comment("The Electronic Payment Number is :" + elctronicNum);
//    Element.expectedWait(payNumdrpdwn, testConfig, "Electronic Payment Dropdown", "Electronic Payment Dropdown");
//	Element.selectVisibleText(payNumdrpdwn,"Electronic Payment Number","Payment Dropdown");
//	Log.Comment("Payment Dropdown Selected: Electronic Payment Number is selected");
//    Element.click(elcPayNum, "Electronic Payment Number");
//    Element.enterData(elcPayNum, elctronicNum, "Enter tin number as "+elctronicNum, "Electonic Payment Number");
//    Element.click(srchRemitBtn, "Search Remit");
    
	
    int sqlRowNo = 224;
    System.getProperty("tin");
	Map cp_DSPL_CONSL_PAY_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String elctronicNum1 = cp_DSPL_CONSL_PAY_NBRDB.toString();
	String elctronicNum2 = elctronicNum1.substring(elctronicNum1.lastIndexOf("=")+1);
	String elctronicNum = elctronicNum2.substring(0, elctronicNum2.length()-1);
	Log.Comment("The Electronic Payment Number is :" + elctronicNum);
    Element.expectedWait(payNumdrpdwn, testConfig, "Electronic Payment Dropdown", "Electronic Payment Dropdown");
	Element.selectVisibleText(payNumdrpdwn,"Electronic Payment Number","Payment Dropdown");
	Log.Comment("Payment Dropdown Selected: Electronic Payment Number is selected");
    Element.click(elcPayNum, "Electronic Payment Number");
    Element.enterData(elcPayNum, elctronicNum, "Enter Electronic Payment Number as "+elctronicNum, "Electonic Payment Number");
    Element.click(srchRemitBtn, "Search Remit");

}

	public void enterCheckNumber() throws Exception
	{
	    int sqlRowNo = 407;
	    System.getProperty("tin");
		Map UCONSL_PAY_NBR = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String checkNumber = UCONSL_PAY_NBR.get("UCONSL_PAY_NBR").toString();
		Log.Comment("The Electronic Payment Number is :" + checkNumber);
	    Element.expectedWait(payNumdrpdwn, testConfig, "Electronic Payment Dropdown", "Electronic Payment Dropdown");
		Element.selectVisibleText(payNumdrpdwn,"Check Number","Payment Dropdown");
		Log.Comment("Payment Dropdown Selected: Check Number is selected");
	    Element.click(checkPayNum, "Check Number");
	    Element.enterData(checkPayNum, checkNumber, "Enter Check Number as "+checkNumber, "Check Number");
	    Element.click(srchRemitBtn, "Search Remit");
	
	}


public void enterElectronicNumForPLBOnlyPayer() throws Exception
{
    int sqlRowNo = 215;
	Map cp_DSPL_CONSL_PAY_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String elctronicNum1 = cp_DSPL_CONSL_PAY_NBRDB.toString();
	String elctronicNum2 = elctronicNum1.substring(elctronicNum1.lastIndexOf("=")+1);
	String elctronicNum = elctronicNum2.substring(0, elctronicNum2.length()-1);
	Log.Comment("The Electronic Payment Number is :" + elctronicNum);
    Element.expectedWait(payNumdrpdwn, testConfig, "Electronic Payment Dropdown", "Electronic Payment Dropdown");
	Element.selectVisibleText(payNumdrpdwn,"Electronic Payment Number","Payment Dropdown");
	Log.Comment("Payment Dropdown Selected: Electronic Payment Number is selected");
    Element.click(elcPayNum, "Electronic Payment Number");
    Element.enterData(elcPayNum, elctronicNum, "Enter tin number as "+elctronicNum, "Electonic Payment Number");
    Element.click(srchRemitBtn, "Search Remit");

}

public void verifyPLBAdjOnly() throws Exception

{
    Element.expectedWait(paymentNo1, testConfig, "Payment No", "Payment No");
    Element.click(paymentNo1, "Payment No");
    List<WebElement> subTotal_Count1 =testConfig.driver.findElements(By.xpath("//tr[@class='rowDarkbold']/td[1]")); 
    int subTotal_Count = subTotal_Count1.size();
    if(subTotal_Count >10)
    {
    	Element.click(lastPage, "Last Page");
    	Browser.wait(testConfig, 3);
    	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
    	Boolean refCodePLBUI = refCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
    	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
    	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);
    	
    	List<WebElement> list=testConfig.driver.findElements(By.xpath("//div[@id='flow2']//tr"));
    	
    	int size = list.size();
    	Log.Comment("Size of PLB List is :" + size);
		List<String> plb_UI=new ArrayList<>();
		
		for(int i=1; i<=size; i++)
		{
			for(int j=1; j<=3; j++)
			{
				String sText=testConfig.driver.findElement(By.xpath("//div[@id='flow2']//tr["+i+"]//td["+j+"]")).getText();
				if(sText.contains("$"))
				{
					sText= sText.replace("$","").trim();
				}
				
				     plb_UI.add(sText.trim());
			   }
	     }
		
		Collections.sort(plb_UI);
	    Log.Comment("The Multiple PLB Adjustment Data from UI is" + plb_UI);
		
        int sqlRowNo = 202;
    	ArrayList<String> plb_DB = new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
        for (int i = 1; i <= plb_DB1.size(); i++) 
		{
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
			plb_DB.add(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT"));
		}
		
	    Collections.sort(plb_DB);
		Log.Comment("The PLB Adjustment Only Data from DB is :" + plb_DB);
	    Helper.compareEquals(testConfig, "The PLB Adjustment Only Data from DB", plb_DB, plb_UI);
    	
       }
    else
    {
    	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
    	
    	Boolean refCodePLBUI = refCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
    	
    	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
    	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);

    	List<WebElement> list=testConfig.driver.findElements(By.xpath("//div[@id='flow2']//tr"));
    	
    	int size = list.size();
    	Log.Comment("Size of PLB List is :" + size);
		List<String> plb_UI=new ArrayList<>();
		
		for(int i=1; i<=size; i++)
		{
			for(int j=1; j<=3; j++)
			{
				String sText=testConfig.driver.findElement(By.xpath("//div[@id='flow2']//tr["+i+"]//td["+j+"]")).getText();
						
			   if(sText.contains("$"))
				{
					sText= sText.replace("$","").trim();
				}
				
				     plb_UI.add(sText.trim());
			   }
	     }
		
		Collections.sort(plb_UI);
	    Log.Comment("The PLB Adjustment Only Data from UI is" + plb_UI);
		
    	int sqlRowNo = 202;
    	ArrayList<String> plb_DB = new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
        for (int i = 1; i <= plb_DB1.size(); i++) 
		{
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
			plb_DB.add(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT"));
		}
		
	    Collections.sort(plb_DB);
		Log.Comment("The PLB Adjustment Only Data from DB is :" + plb_DB);
		Helper.compareEquals(testConfig, "The PLB Adjustment Only Data from DB", plb_DB, plb_UI);
    }
    
    
}


public void verifyPLBAdjOnlyUPA() throws Exception

{
    Element.expectedWait(paymentNo1, testConfig, "Payment No", "Payment No");
    Element.click(paymentNo1, "Payment No");
    List<WebElement> subTotal_Count1 =testConfig.driver.findElements(By.xpath("//tr[@class='rowDarkbold']/td[1]")); 
    int subTotal_Count = subTotal_Count1.size();
    
    if(subTotal_Count >=10)
    {
    	if(testConfig.driver.findElements(By.xpath("//a[contains(text(),'Last Page')]")).size() != 0)
    	{
    		Element.click(lastPage, "Last Page");
    		Browser.wait(testConfig, 3);
        	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
        	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
        	
        	Boolean refCodePLBUI = refCodePLB.isDisplayed();
        	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
        	
        	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
        	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);
    	}
    	else
    	{
    	
    		Browser.wait(testConfig, 3);
        	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
        	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
        	
        	Boolean refCodePLBUI = refCodePLB.isDisplayed();
        	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
        	
        	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
        	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);
    	}

    
    	List<WebElement> list=testConfig.driver.findElements(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table[1]/tbody/tr"));
    	
    	int size = list.size();
    	Log.Comment("Size of PLB List is :" + size);
		List<String> plb_UI=new ArrayList<>();
		
		for(int i=1; i<=size; i++)
		{
			for(int j=1; j<=3; j++)
			{
				String sText=testConfig.driver.findElement(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table[1]/tbody/tr["+i+"]//td["+j+"]")).getText();
				if(sText.contains("$"))
				{
					sText= sText.replace("$","").trim();
				}
				
				     plb_UI.add(sText.trim());
			   }
	     }
		
		Collections.sort(plb_UI);
	    Log.Comment("The Multiple PLB Adjustment Data from UI is" + plb_UI);
		
		String consl_pay_nbr = System.getProperty("consl_pay_nbr");
		testConfig.putRunTimeProperty("consl_pay_nbr",consl_pay_nbr);
		int sqlRowNo = 202;
    	ArrayList<String> plb_DB = new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
        for (int i = 1; i <= plb_DB1.size(); i++) 
		{
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
			plb_DB.add(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT"));
		}
		
	    Collections.sort(plb_DB);
		Log.Comment("The PLB Adjustment Only Data from DB is :" + plb_DB);
	    Helper.compareEquals(testConfig, "The PLB Adjustment Only Data from DB", plb_DB, plb_UI);
    	
       }
    else
    {
        Browser.wait(testConfig, 3);
    	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
    	
    	Boolean refCodePLBUI = refCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
    	
    	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
    	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);

    	List<WebElement> list=testConfig.driver.findElements(By.xpath("//div[@id='flow2']//tr"));
    	
    	int size = list.size();
    	Log.Comment("Size of PLB List is :" + size);
		List<String> plb_UI=new ArrayList<>();
		
		for(int i=1; i<=size; i++)
		{
			for(int j=1; j<=3; j++)
			{
				String sText=testConfig.driver.findElement(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table[1]/tbody/tr["+i+"]//td["+j+"]")).getText();
						
			   if(sText.contains("$"))
				{
					sText= sText.replace("$","").trim();
				}
				
				     plb_UI.add(sText.trim());
			   }
	     }
		
		Collections.sort(plb_UI);
	    Log.Comment("The PLB Adjustment Only Data from UI is" + plb_UI);
		
    	int sqlRowNo = 202;
    	ArrayList<String> plb_DB = new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
        for (int i = 1; i <= plb_DB1.size(); i++) 
		{
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
			plb_DB.add(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT"));
		}
		
	    Collections.sort(plb_DB);
		Log.Comment("The PLB Adjustment Only Data from DB is :" + plb_DB);
		Helper.compareEquals(testConfig, "The PLB Adjustment Only Data from DB", plb_DB, plb_UI);
    }
    
    
}




public void verifyPLBAdjOnlyPayer() throws Exception

{
    Element.expectedWait(paymentNo1, testConfig, "Payment No", "Payment No");
    Element.click(paymentNo1, "Payment No");
    List<WebElement> subTotal_Count1 =testConfig.driver.findElements(By.xpath("//tr[@class='rowDarkbold']/td[1]")); 
    int subTotal_Count = subTotal_Count1.size();
    if(subTotal_Count >10)
    {
    	Element.click(lastPage, "Last Page");
    	Browser.wait(testConfig, 3);
    	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
    	Boolean refCodePLBUI = refCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
    	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
    	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);
    	
    	List<WebElement> list=testConfig.driver.findElements(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table/tbody/tr"));
    	
    	int size = list.size();
    	Log.Comment("Size of PLB List is :" + size);
		List<String> plb_UI=new ArrayList<>();
		
		for(int i=1; i<=size; i++)
		{
			for(int j=1; j<=3; j++)
			{
				String sText=testConfig.driver.findElement(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table/tbody/tr["+ i +"]/td["+ j +"]")).getText();
				
				if(sText.contains("$"))
				{
					sText= sText.replace("$","").trim();
				}
				
				     plb_UI.add(sText.trim());
			   }
	     }
		
		Collections.sort(plb_UI);
	    Log.Comment("The Multiple PLB Adjustment Data from UI is" + plb_UI);
		int sqlRowNo = 216;
    	ArrayList<String> plb_DB = new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
        for (int i = 1; i <= plb_DB1.size(); i++) 
		{
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
			plb_DB.add(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT"));
		}
		
	    Collections.sort(plb_DB);
		Log.Comment("The PLB Adjustment Only Data from DB is :" + plb_DB);
	    Helper.compareEquals(testConfig, "The PLB Adjustment Only Data from DB", plb_DB, plb_UI);
    	
       }
    else
    {
    	Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);
    	
    	Boolean refCodePLBUI = refCodePLB.isDisplayed();
    	Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);
    	
    	Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
    	Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);

    	List<WebElement> list=testConfig.driver.findElements(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table/tbody/tr"));
    	
    	int size = list.size();
    	Log.Comment("Size of PLB List is :" + size);
		List<String> plb_UI=new ArrayList<>();
		
		for(int i=1; i<=size; i++)
		{
			for(int j=1; j<=3; j++)
			{
				String sText=testConfig.driver.findElement(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table/tbody/tr["+ i +"]/td["+ j +"]")).getText();
						
			   if(sText.contains("$"))
				{
					sText= sText.replace("$","").trim();
				}
				
				     plb_UI.add(sText.trim());
			   }
	     }
		
		Collections.sort(plb_UI);
	    Log.Comment("The PLB Adjustment Only Data from UI is" + plb_UI);
		
    	int sqlRowNo = 216;
    	ArrayList<String> plb_DB = new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
        for (int i = 1; i <= plb_DB1.size(); i++) 
		{
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
			plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
			plb_DB.add(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT"));
		}
		
	    Collections.sort(plb_DB);
		Log.Comment("The PLB Adjustment Only Data from DB is :" + plb_DB);
		Helper.compareEquals(testConfig, "The PLB Adjustment Only Data from DB", plb_DB, plb_UI);
    }
    
    
}


public void verifySortByPatientLastName(String usertype) throws Exception
{
	
  if(usertype == "Payer")
  {
	Browser.wait(testConfig, 2);
	String ui_Payer = payerUI.getText();
	Log.Comment("The First Payer Name displayed is:" + ui_Payer);
	Element.click(paymentNo1, "Payment Number");
    String paymentNum1 = paymentNo.getText();
    String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
    Log.Comment("The First  Payment Number displayed is:" + paymentNum);
    Element.expectedWait(remitHeader1, testConfig, "Remit Page", "Remit Page");
    List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
    int patientNamesCount = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]")).size();
    Log.Comment("/************ List of Patient Names Present in Remittance Detail Page are as follows **********/");
	List<String> patientLastNames = new ArrayList<String>();
	Log.Comment("Size of Patient Name List is:" + patientNamesCount);
    String patientLastName1 = testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'patientName_1')]")).getText();
	Log.Comment("Patient Name is:" + patientLastName1);
	
	List<String> patientLastNameUI = new ArrayList<String>();
	if(patientLastName1.isEmpty())
	{
		Log.Pass("For this Particular TIN - Patient Names doesn't exists");
		
	}
	
	else
	{
		for(int i=1; i<= testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]")).size(); i++)
		{
			 Log.Comment(testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'patientName_"+i+"')]")).getText());
			
			String lastNames = testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'patientName_"+i+"')]")).getText();
			
			Log.Comment(lastNames);
			
			 if(lastNames.contains("/"))
			 {
			    String res = lastNames.substring(lastNames.lastIndexOf(" ")+1, lastNames.lastIndexOf("/"));

			    patientLastNames.add(res);
			 }
			 
			 else
			 {
			   
				String res = lastNames.substring(lastNames.lastIndexOf(" ")+1,lastNames.length() );
				 patientLastNames.add(res);
			 }
			
	
		}
		
		
          ArrayList<String> patientLastNamesUI1 = new ArrayList<String>(); 
        
        
           for (String element : patientLastNames) { 

            if (!patientLastNamesUI1.contains(element)) { 
  
            	patientLastNamesUI1.add(element); 
            } 
        } 
		
           ArrayList<String> patientLastNamesUI = new ArrayList<String>(); 

           for (String element : patientLastNamesUI1) { 

            if (!patientLastNamesUI.contains(element)) { 

            	patientLastNamesUI.add(element); 
            } 
        } 
   		
           StringBuffer sb = new StringBuffer();
           
           for (String s : patientLastNamesUI) {
              sb.append(s);
              sb.append(";");
             }
           String patientLastNameui = sb.toString();
           
           
              // String patientLastNamesUI = patientLastNamesUI1.toString();
		
//				boolean sort = new Element().isSorted(patientLastNames);
//				String patientLastNamesUI = patientLastNames.toString();
//				Log.Comment("Patient Last Names are in Sort Order");
//				Log.Comment(patientLastNamesUI);
				
				int sqlRowNo = 184;
				testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
				Map payerSchema = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	

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
			  
			  
			  Map<String, List<String>> response = new ReadTagsfromFISLResponse().getNodesXML(getResponse);
			  
			  ArrayList<String> patientLastNamesFISL1 = (ArrayList<String>) response.get("personLastName");
			  
			  StringBuffer sb1 = new StringBuffer();
		      
		      for (String s : patientLastNamesFISL1) {
		    	 
		         sb.append(s);
		         sb.append(";");
		        }
		      String patientLastNamesFISL3 = sb.toString();
		      
		      if(patientLastNamesFISL3.contains(" "))
		      {
		    	  String patientLastNamesFISL = patientLastNamesFISL3.substring(patientLastNamesFISL3.indexOf(" ")+1, patientLastNamesFISL3.length());
		    	  Helper.compareContains(testConfig,  "Comparing Patient Last Names from UI and FISL", patientLastNameui, patientLastNamesFISL);
		      }
		      else
		      {
		    	  String patientLastNamesFISL = sb.toString(); 
		    	  Helper.compareContains(testConfig,  "Comparing Patient Last Names from UI and FISL", patientLastNameui, patientLastNamesFISL);
		      }
		      //Helper.compareEquals(testConfig,"Comparing Patient List Name from UI and FISL", patientLastNamesUI1, patientLastNamesFISL);
		      String fileDeleteResponse = new ReadTagsfromFISLResponse().deleteFileData();
        }
	
	   else
	   {

				    String payerSchemaUI = (payerSchema.toString()).substring(14,19);
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
				   Map<String, List<String>> response = new ReadTagsfromFISLResponse().getNodesXML(getResponse);
				   
				  ArrayList<String> patientLastNamesFISL1 = (ArrayList<String>) response.get("personLastName");
					  
					  StringBuffer sb1 = new StringBuffer();
				      
				      for (String s : patientLastNamesFISL1) {
				         sb.append(s);
				         sb.append(";");
				        }
				      
					      String patientLastNamesFISL3 = sb.toString();
					      
					      if(patientLastNamesFISL3.contains(" "))
					      {
					    	  String patientLastNamesFISL = patientLastNamesFISL3.substring(patientLastNamesFISL3.indexOf(" ")+1, patientLastNamesFISL3.length());
					    	  Helper.compareContains(testConfig,  "Comparing Patient Last Names from UI and FISL", patientLastNameui, patientLastNamesFISL);
					      }
					      else
					      {
					    	  String patientLastNamesFISL = sb.toString(); 
					    	  Helper.compareContains(testConfig,  "Comparing Patient Last Names from UI and FISL", patientLastNameui, patientLastNamesFISL);
					      }
					      //Helper.compareEquals(testConfig,"Comparing Patient List Name from UI and FISL", patientLastNamesUI1, patientLastNamesFISL);
					      String fileDeleteResponse = new ReadTagsfromFISLResponse().deleteFileData();
				   
		}
}
  }
	else
	{
		Browser.wait(testConfig, 2);
		String ui_Payer = payernameUI.getText();
		Log.Comment("The First Payer Name displayed is:" + ui_Payer);
		Element.click(paymentNo1, "Payment Number");
	    String paymentNum1 = paymentNo.getText();
	    String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
	    Log.Comment("The First  Payment Number displayed is:" + paymentNum);
	    Element.expectedWait(remitHeader1, testConfig, "Remit Page", "Remit Page");
	    List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
	    int patientNamesCount = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]")).size();
	    Log.Comment("/************ List of Patient Names Present in Remittance Detail Page are as follows **********/");
		List<String> patientLastNames = new ArrayList<String>();
		Log.Comment("Size of Patient Name List is:" + patientNamesCount);
	    String patientLastName1 = testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'patientName_1')]")).getText();
		Log.Comment("Patient Name is:" + patientLastName1);
		
		List<String> patientLastNameUI = new ArrayList<String>();
		if(patientLastName1.isEmpty())
		{
			Log.Pass("For this Particular TIN - Patient Names doesn't exists");
			
		}
		
		else
		{
			for(int i=1; i<= testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]")).size(); i++)
			{
				 Log.Comment(testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'patientName_"+i+"')]")).getText());
				
				String lastNames = testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'patientName_"+i+"')]")).getText();
				
				Log.Comment(lastNames);
				
				 if(lastNames.contains("/"))
				 {
				    String res = lastNames.substring(lastNames.lastIndexOf(" ")+1, lastNames.lastIndexOf("/"));

				    patientLastNames.add(res);
				 }
				 
				 else
				 {
				   
					String res = lastNames.substring(lastNames.lastIndexOf(" ")+1,lastNames.length() );
					 patientLastNames.add(res);
				 }
				
		
			}
			
			
	          ArrayList<String> patientLastNamesUI1 = new ArrayList<String>(); 
	        
	        
	           for (String element : patientLastNames) { 

	            if (!patientLastNamesUI1.contains(element)) { 
	  
	            	patientLastNamesUI1.add(element); 
	            } 
	        } 
			
	           ArrayList<String> patientLastNamesUI = new ArrayList<String>(); 

	           for (String element : patientLastNamesUI1) { 

	            if (!patientLastNamesUI.contains(element)) { 

	            	patientLastNamesUI.add(element); 
	            } 
	        } 
	   		
	           StringBuffer sb = new StringBuffer();
	           
	           for (String s : patientLastNamesUI) {
	              sb.append(s);
	              sb.append(";");
	             }
	           String patientLastNameui = sb.toString();
	           
	           
	              // String patientLastNamesUI = patientLastNamesUI1.toString();
			
//					boolean sort = new Element().isSorted(patientLastNames);
//					String patientLastNamesUI = patientLastNames.toString();
//					Log.Comment("Patient Last Names are in Sort Order");
//					Log.Comment(patientLastNamesUI);
					
					int sqlRowNo = 184;
					testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
					Map payerSchema = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		

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
				  
				  
				  Map<String, List<String>> response = new ReadTagsfromFISLResponse().getNodesXML(getResponse);
				  
				  ArrayList<String> patientLastNamesFISL1 = (ArrayList<String>) response.get("personLastName");
				  
				  StringBuffer sb1 = new StringBuffer();
			      
			      for (String s : patientLastNamesFISL1) {
			    	 
			         sb.append(s);
			         sb.append(";");
			        }
			      String patientLastNamesFISL3 = sb.toString();
			      
			      if(patientLastNamesFISL3.contains(" "))
			      {
			    	  String patientLastNamesFISL = patientLastNamesFISL3.substring(patientLastNamesFISL3.indexOf(" ")+1, patientLastNamesFISL3.length());
			    	  Helper.compareContains(testConfig,  "Comparing Patient Last Names from UI and FISL", patientLastNameui, patientLastNamesFISL);
			      }
			      else
			      {
			    	  String patientLastNamesFISL = sb.toString(); 
			    	  Helper.compareContains(testConfig,  "Comparing Patient Last Names from UI and FISL", patientLastNameui, patientLastNamesFISL);
			      }
			      //Helper.compareEquals(testConfig,"Comparing Patient List Name from UI and FISL", patientLastNamesUI1, patientLastNamesFISL);
			      String fileDeleteResponse = new ReadTagsfromFISLResponse().deleteFileData();
	        }
		
		   else
		   {

					    String payerSchemaUI = (payerSchema.toString()).substring(14,19);
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
					   Map<String, List<String>> response = new ReadTagsfromFISLResponse().getNodesXML(getResponse);
					   
					  ArrayList<String> patientLastNamesFISL1 = (ArrayList<String>) response.get("personLastName");
						  
						  StringBuffer sb1 = new StringBuffer();
					      
					      for (String s : patientLastNamesFISL1) {
					         sb.append(s);
					         sb.append(";");
					        }
					      
						      String patientLastNamesFISL3 = sb.toString();
						      
						      if(patientLastNamesFISL3.contains(" "))
						      {
						    	  String patientLastNamesFISL = patientLastNamesFISL3.substring(patientLastNamesFISL3.indexOf(" ")+1, patientLastNamesFISL3.length());
						    	  Helper.compareContains(testConfig,  "Comparing Patient Last Names from UI and FISL", patientLastNameui, patientLastNamesFISL);
						      }
						      else
						      {
						    	  String patientLastNamesFISL = sb.toString(); 
						    	  Helper.compareContains(testConfig,  "Comparing Patient Last Names from UI and FISL", patientLastNameui, patientLastNamesFISL);
						      }
						      //Helper.compareEquals(testConfig,"Comparing Patient List Name from UI and FISL", patientLastNamesUI1, patientLastNamesFISL);
						      String fileDeleteResponse = new ReadTagsfromFISLResponse().deleteFileData();
	}
		}
	}
    
}



public void verifyRemittancePageDataUPA(String usertype) throws Exception  
{
Browser.wait(testConfig, 2);
if(usertype == "Payer")
{
	 String ui_Payer = payerUI.getText();
	 Log.Comment("The First Payer Name displayed is:" + ui_Payer);
	 Element.click(paymentNo1, "Payment No");
		Browser.wait(testConfig, 5);

String paymentNum1 = paymentNo.getText();
String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
Log.Comment("The First Payment Number displayed is:" + paymentNum);
List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
Log.Comment("/************ List of Patient Names Present in Remittance Detail Page are as follows **********/");
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
	Log.Comment("FISL Patient First Name is:" + firstNameDB);
    String firstPatientUI1 = firstPatient.getText();
    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
    Log.Comment("Online Patient First Name is:" + firstPatientUI);
    if(!firstNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
	
    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
	Log.Comment("FISL Patient Last Name is:" + lastNameDB);
    String lastPatientUI1 = firstPatient.getText();
    
    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
    if(!lastNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
	
    if(testConfig.driver.findElements(By.xpath("//span[contains(text(),'DRG Code')]")).size() != 0)
    {
    	Browser.scrollTillAnElement(testConfig, amntChargedDRGCodeUI, "Amount Charged");
        String amountChargedUI1 = amntChargedDRGCodeUI.getText();
        String amountChargedUI = "";

    if(amountChargedUI1.contains("-"))
    {

    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
    	{
    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
    		
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
    	}
    	
    	else if (amountChargedUI1.contains("$")) 
    	{
    	 
    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    	  amountChargedUI = Double.toString(amountChargedUI4);
    	  Log.Comment(amountChargedUI);
    	}
    	else if (amountChargedUI1.contains(",")) {
    		
    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
    		
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

    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
       String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>")); 
       Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
       if(!amountChargedDB.equalsIgnoreCase("0"))
          Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);
    }
    	
    else
    {
    	Browser.scrollTillAnElement(testConfig, amntChargedUI, "Amount Charged");
    	String amountChargedUI1 = amntChargedUI.getText();
        String amountChargedUI = "";
        
        if(amountChargedUI1.contains("-"))
        {

        	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
        	{
        		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
        		
        		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
        		amountChargedUI = Double.toString(amountChargedUI4);
        		Log.Comment(amountChargedUI);
        	}
        	
        	else if (amountChargedUI1.contains("$")) 
        	{
    		 
        	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
        	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
        	  amountChargedUI = Double.toString(amountChargedUI4);
        	  Log.Comment(amountChargedUI);
    		}
        	else if (amountChargedUI1.contains(",")) {
        		
        		String amountChargedUI3 = amountChargedUI1.replace(",", "");
        		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
        		amountChargedUI = Double.toString(amountChargedUI4);
        		Log.Comment(amountChargedUI);
    			
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
        
        Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
    	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>")); 
    	    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
    	    if(!amountChargedDB.equalsIgnoreCase("0"))
    	       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);
    }

    String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();
     
     
     Log.Comment("Size of Group[ Policy List is:" + grp);
    
     
     if(!grp.contains(""))
     {
    	 String grpPolicyUI1 = grpPolicyUI.getText();
    	 if(grpPolicyUI1.contains("/"))
    	 {
             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
         	 
         	 if(grpPolicyOnline.length()!=0)
         	 {
         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
	             if(!grpPolicyDB.equalsIgnoreCase("0"))
	             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
         	 }
         	 
         	 else
         	 {
         	 
         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
         	 }
         }
    	 else
    	 {
    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
             if(!grpPolicyDB.equalsIgnoreCase("0"))
              	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
         }
      }
    else
    {
       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
    }

     if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
     {
    	 
    	 String grpPolicyUI1 = grpPolicyUI.getText();
     
        if(grpPolicyUI1.contains("/"))
         {
     
           if(!grpPolicyUI1.isEmpty())
            {
		        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
		        Log.Comment("Product Name from UI is :" + productNameUI);
		        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
		        Log.Comment("The Product Name from FISL is :" + productNameDB);
		        if(!productNameDB.equalsIgnoreCase("0"))
		        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
      }
         }
     }
     
     else
     {
       Log.Comment("The Product Name doesnt exists for this Criteria");
     }
     
     String subscrbrUI1 = subscriberUI1.getText();

     if(subscrbrUI1.contains("/"))
     {
    	 String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
     	if(!subscrbrDB.equalsIgnoreCase("0"))
     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
     }

     else
     {
     	String subscrbrUI = subscriberUI1.getText().trim();
     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
     	if(!subscrbrDB.equalsIgnoreCase("0"))
     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
     }
   
     String claimHashUI = claimHash.getText();
     Log.Comment("Claim # from UI is :" + claimHashUI);
     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
     Log.Comment("Claim # from FISL is :" + claimTypeDB);
     if(!claimTypeDB.equalsIgnoreCase("0"))
        Helper.compareEquals(testConfig, "Comparing Claim Identifier UI and DB", claimTypeDB, claimHashUI);
  	 
     String accntNumUI = accntNum.getText();
     Log.Comment("Account Number from UI is :" + accntNumUI);
     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
     Log.Comment("Account Number from FISL is :" + accntNumDB);
     if(!accntNumDB.equalsIgnoreCase("0"))
       	Helper.compareEquals(testConfig, "Comparing Account Number UI and DB", accntNumDB, accntNumUI);
    
//     String amntAllowedUI1 = amntallowed.getText();
//     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
//     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
//     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
//     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
//     if(!amntAllowedDB.equalsIgnoreCase("0"))
//        Helper.compareEquals(testConfig, "Comparing Allowed Amounts DB and UI", amntAllowedDB, amntAllowedUI);
   
     /*
     String CopayUI1 = copayUI.getText();
     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
     Log.Comment("Copay Amount from UI is :" + CopayUI);
     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
     Log.Comment("Copay Amount from FISL is :" + CopayDB);
     if(!CopayDB.equalsIgnoreCase("0"))
         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
       */
//     String patientrespUI1 = patientresp.getText();
//     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//     double patientrespU3 = Double.parseDouble(patientrespUI2);
//	 String patientrespUI = Double.toString(patientrespU3);
//     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//     if(!patientrespDB.equalsIgnoreCase("0"))
//         Helper.compareEquals(testConfig, "Comparing Patient Responsibility Amount UI and DB", patientrespDB, patientrespUI);
//
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
Log.Comment("FISL Patient First Name is:" + firstNameDB);
String firstPatientUI1 = firstPatient.getText();
String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
Log.Comment("Online Patient First Name is:" + firstPatientUI);
if(!firstNameDB.equalsIgnoreCase("0"))
	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);

String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
Log.Comment("FISL Patient Last Name is:" + lastNameDB);
String lastPatientUI1 = firstPatient.getText();

String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

Log.Comment("Online Patient Last Name is :" + lastPatientUI);
if(!lastNameDB.equalsIgnoreCase("0"))
	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);


if(testConfig.driver.findElements(By.xpath("//span[contains(text(),'DRG Code')]")).size() != 0)
{
	Browser.scrollTillAnElement(testConfig, amntChargedDRGCodeUI, "Amount Charged");
    String amountChargedUI1 = amntChargedDRGCodeUI.getText();
    String amountChargedUI = "";

if(amountChargedUI1.contains("-"))
{

	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
	{
		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
		
		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		amountChargedUI = Double.toString(amountChargedUI4);
		Log.Comment(amountChargedUI);
	}
	
	else if (amountChargedUI1.contains("$")) 
	{
	 
	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	  amountChargedUI = Double.toString(amountChargedUI4);
	  Log.Comment(amountChargedUI);
	}
	else if (amountChargedUI1.contains(",")) {
		
		String amountChargedUI3 = amountChargedUI1.replace(",", "");
		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		amountChargedUI = Double.toString(amountChargedUI4);
		Log.Comment(amountChargedUI);
		
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

Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
   String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>")); 
   Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
   if(!amountChargedDB.equalsIgnoreCase("0"))
      Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);
}
	
else
{
	Browser.scrollTillAnElement(testConfig, amntChargedUI, "Amount Charged");
	String amountChargedUI1 = amntChargedUI.getText();
    String amountChargedUI = "";
    
    if(amountChargedUI1.contains("-"))
    {

    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
    	{
    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
    		
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
    	}
    	
    	else if (amountChargedUI1.contains("$")) 
    	{
		 
    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    	  amountChargedUI = Double.toString(amountChargedUI4);
    	  Log.Comment(amountChargedUI);
		}
    	else if (amountChargedUI1.contains(",")) {
    		
    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
			
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
    
    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>")); 
	    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
	    if(!amountChargedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);
}



String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();

Log.Comment("Text of Group Policy List is:" + grp);
 
 if(!grp.contains(""))
 {
	 String grpPolicyUI1 = grpPolicyUI.getText();
	 if(grpPolicyUI1.contains("/"))
	 {
         String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
     	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
     	 
     	 if(grpPolicyOnline.length()!=0)
     	 {
     		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
             if(!grpPolicyDB.equalsIgnoreCase("0"))
             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
     	 }
     	 
     	 else
     	 {
     	 
     		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
     	 }
     }
	 else
	 {
		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
         Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
         if(!grpPolicyDB.equalsIgnoreCase("0"))
          	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
     }
  }
else
{
   Log.Comment("The Group Policy Number doesnt exists for this Criteria");
}
 

 if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
 {
	 
	 String grpPolicyUI1 = grpPolicyUI.getText();
 
    if(grpPolicyUI1.contains("/"))
     {
 
       if(!grpPolicyUI1.isEmpty())
        {
	        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
	        Log.Comment("Product Name from UI is :" + productNameUI);
	        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
	        Log.Comment("The Product Name from FISL is :" + productNameDB);
	        if(!productNameDB.equalsIgnoreCase("0"))
	        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
  }
     }
 }
 
 else
 {
   Log.Comment("The Product Name doesnt exists for this Criteria");
 }
 

         String subscrbrUI1 = subscriberUI1.getText();

	     if(subscrbrUI1.contains("/"))
	     {
	    	 String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }

	     else
	     {
	     	String subscrbrUI = subscriberUI1.getText().trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }

 String claimHashUI = claimHash.getText();
 Log.Comment("Claim # from UI is :" + claimHashUI);
 String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
 Log.Comment("Claim # from FISL is :" + claimTypeDB);
 if(!claimTypeDB.equalsIgnoreCase("0"))
    Helper.compareEquals(testConfig, "Comparing Claim Type DB and UI", claimTypeDB, claimHashUI);
	 
 String accntNumUI = accntNum.getText();
 Log.Comment("Account Number from UI is :" + accntNumUI);
 String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
 Log.Comment("Account Number from FISL is :" + accntNumDB);
 if(!accntNumDB.equalsIgnoreCase("0"))
   	Helper.compareEquals(testConfig, "Comparing Account Number DB and UI", accntNumDB, accntNumUI);

// String amntAllowedUI1 = amntallowed.getText();
// String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
// Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
// String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
// Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
// if(!amntAllowedDB.equalsIgnoreCase("0"))
//    Helper.compareEquals(testConfig, "Comparing Amounts Charged DB and UI", amntAllowedDB, amntAllowedUI);

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
// String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
// double patientrespU3 = Double.parseDouble(patientrespUI2);
// String patientrespUI = Double.toString(patientrespU3);
// Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
// String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
// Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
// if(!patientrespDB.equalsIgnoreCase("0"))
//     Helper.compareEquals(testConfig, "Comparing Patient Responsibilty UI and DB", patientrespDB, patientrespUI);

}
}

else
{

	 String ui_Payer = payernameUI.getText();
	 Log.Comment("The First Payer Name displayed is:" + ui_Payer);
	 Element.click(paymentNo1, "Payment No");
	Browser.wait(testConfig, 2);
	
String paymentNum1 = paymentNo.getText();
String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
Log.Comment("The First Payment Number displayed is:" + paymentNum);
List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
Log.Comment("/************ List of Patient Names Present in Remittance Detail Page are as follows **********/");
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
	Log.Comment("FISL Patient First Name is:" + firstNameDB);
    String firstPatientUI1 = firstPatient.getText();
    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
    Log.Comment("Online Patient First Name is:" + firstPatientUI);
    if(!firstNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
	
    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
	Log.Comment("FISL Patient Last Name is:" + lastNameDB);
    String lastPatientUI1 = firstPatient.getText();
    
    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
    if(!lastNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
	
    if(testConfig.driver.findElements(By.xpath("//span[contains(text(),'DRG Code')]")).size() != 0)
    {
    	Browser.scrollTillAnElement(testConfig, amntChargedDRGCodeUI, "Amount Charged");
        String amountChargedUI1 = amntChargedDRGCodeUI.getText();
        String amountChargedUI = "";

    if(amountChargedUI1.contains("-"))
    {

    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
    	{
    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
    		
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
    	}
    	
    	else if (amountChargedUI1.contains("$")) 
    	{
    	 
    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    	  amountChargedUI = Double.toString(amountChargedUI4);
    	  Log.Comment(amountChargedUI);
    	}
    	else if (amountChargedUI1.contains(",")) {
    		
    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
    		
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

    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
       String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>")); 
       Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
       if(!amountChargedDB.equalsIgnoreCase("0"))
          Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);
    }
    	
    else
    {
    	Browser.scrollTillAnElement(testConfig, amntChargedUI, "Amount Charged");
    	String amountChargedUI1 = amntChargedUI.getText();
        String amountChargedUI = "";
        
        if(amountChargedUI1.contains("-"))
        {

        	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
        	{
        		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
        		
        		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
        		amountChargedUI = Double.toString(amountChargedUI4);
        		Log.Comment(amountChargedUI);
        	}
        	
        	else if (amountChargedUI1.contains("$")) 
        	{
    		 
        	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
        	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
        	  amountChargedUI = Double.toString(amountChargedUI4);
        	  Log.Comment(amountChargedUI);
    		}
        	else if (amountChargedUI1.contains(",")) {
        		
        		String amountChargedUI3 = amountChargedUI1.replace(",", "");
        		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
        		amountChargedUI = Double.toString(amountChargedUI4);
        		Log.Comment(amountChargedUI);
    			
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
        
        Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
    	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>")); 
    	    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
    	    if(!amountChargedDB.equalsIgnoreCase("0"))
    	       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);
    }


     String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();
     
     
     Log.Comment("Size of Group[ Policy List is:" + grp);
    
     
     if(!grp.contains(""))
     {
    	 String grpPolicyUI1 = grpPolicyUI.getText();
    	 if(grpPolicyUI1.contains("/"))
    	 {
             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
         	 
         	 if(grpPolicyOnline.length()!=0)
         	 {
         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
	             if(!grpPolicyDB.equalsIgnoreCase("0"))
	             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
         	 }
         	 
         	 else
         	 {
         	 
         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
         	 }
         }
    	 else
    	 {
    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
             if(!grpPolicyDB.equalsIgnoreCase("0"))
              	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
         }
      }
    else
    {
       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
    }

     if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
     {
    	 
    	 String grpPolicyUI1 = grpPolicyUI.getText();
     
        if(grpPolicyUI1.contains("/"))
         {
     
           if(!grpPolicyUI1.isEmpty())
            {
		        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
		        Log.Comment("Product Name from UI is :" + productNameUI);
		        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
		        Log.Comment("The Product Name from FISL is :" + productNameDB);
		        if(!productNameDB.equalsIgnoreCase("0"))
		        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
      }
         }
     }
     
     else
     {
       Log.Comment("The Product Name doesnt exists for this Criteria");
     }
     

     String subscrbrUI1 = subscriberUI1.getText();

   	     if(subscrbrUI1.contains("/"))
   	     {
   	    	 String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
   	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
   	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
   	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
   	     	if(!subscrbrDB.equalsIgnoreCase("0"))
   	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
   	     }

   	     else
   	     {
   	     	String subscrbrUI = subscriberUI1.getText().trim();
   	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
   	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
   	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
   	     	if(!subscrbrDB.equalsIgnoreCase("0"))
   	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
   	     }
     
   
     String claimHashUI = claimHash.getText();
     Log.Comment("Claim # from UI is :" + claimHashUI);
     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
     Log.Comment("Claim # from FISL is :" + claimTypeDB);
     if(!claimTypeDB.equalsIgnoreCase("0"))
        Helper.compareEquals(testConfig, "Comparing Claim Identifier DB and UI", claimTypeDB, claimHashUI);
  	 
     String accntNumUI = accntNum.getText();
     Log.Comment("Account Number from UI is :" + accntNumUI);
     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
     Log.Comment("Account Number from FISL is :" + accntNumDB);
     if(!accntNumDB.equalsIgnoreCase("0"))
       	Helper.compareEquals(testConfig, "Comparing Account Number DB and UI", accntNumDB, accntNumUI);
    
//     String amntAllowedUI1 = amntallowed.getText();
//     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
//     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
//     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
//     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
//     if(!amntAllowedDB.equalsIgnoreCase("0"))
//        Helper.compareEquals(testConfig, "Comparing Allowed Amounts DB and UI", amntAllowedDB, amntAllowedUI);
   
     /*
     String CopayUI1 = copayUI.getText();
     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
     Log.Comment("Copay Amount from UI is :" + CopayUI);
     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
     Log.Comment("Copay Amount from FISL is :" + CopayDB);
     if(!CopayDB.equalsIgnoreCase("0"))
         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
       */
//     String patientrespUI1 = patientresp.getText();
//     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//     double patientrespU3 = Double.parseDouble(patientrespUI2);
//	 String patientrespUI = Double.toString(patientrespU3);
//     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//     if(!patientrespDB.equalsIgnoreCase("0"))
//         Helper.compareEquals(testConfig, "Comparing Patient Responsibility Amount UI and DB", patientrespDB, patientrespUI);
//
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
Log.Comment("FISL Patient First Name is:" + firstNameDB);
String firstPatientUI1 = firstPatient.getText();
String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
Log.Comment("Online Patient First Name is:" + firstPatientUI);
if(!firstNameDB.equalsIgnoreCase("0"))
	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);

String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
Log.Comment("FISL Patient Last Name is:" + lastNameDB);
String lastPatientUI1 = firstPatient.getText();

String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

Log.Comment("Online Patient Last Name is :" + lastPatientUI);
if(!lastNameDB.equalsIgnoreCase("0"))
	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);




if(testConfig.driver.findElements(By.xpath("//span[contains(text(),'DRG Code')]")).size() != 0)
{
	Browser.scrollTillAnElement(testConfig, amntChargedDRGCodeUI, "Amount Charged");
    String amountChargedUI1 = amntChargedDRGCodeUI.getText();
    String amountChargedUI = "";

if(amountChargedUI1.contains("-"))
{

	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
	{
		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
		
		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		amountChargedUI = Double.toString(amountChargedUI4);
		Log.Comment(amountChargedUI);
	}
	
	else if (amountChargedUI1.contains("$")) 
	{
	 
	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	  amountChargedUI = Double.toString(amountChargedUI4);
	  Log.Comment(amountChargedUI);
	}
	else if (amountChargedUI1.contains(",")) {
		
		String amountChargedUI3 = amountChargedUI1.replace(",", "");
		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
		amountChargedUI = Double.toString(amountChargedUI4);
		Log.Comment(amountChargedUI);
		
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

Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
   String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>")); 
   Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
   if(!amountChargedDB.equalsIgnoreCase("0"))
      Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);
}
	
else
{
	Browser.scrollTillAnElement(testConfig, amntChargedUI, "Amount Charged");
	String amountChargedUI1 = amntChargedUI.getText();
    String amountChargedUI = "";
    
    if(amountChargedUI1.contains("-"))
    {

    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
    	{
    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
    		
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
    	}
    	
    	else if (amountChargedUI1.contains("$")) 
    	{
		 
    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    	  amountChargedUI = Double.toString(amountChargedUI4);
    	  Log.Comment(amountChargedUI);
		}
    	else if (amountChargedUI1.contains(",")) {
    		
    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
			
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
    
    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>")); 
	    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
	    if(!amountChargedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);
}


String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();

Log.Comment("Text of Group Policy List is:" + grp);

if(!grp.contains(""))
{
	 String grpPolicyUI1 = grpPolicyUI.getText();
	 if(grpPolicyUI1.contains("/"))
	 {
        String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
    	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
    	 
    	 if(grpPolicyOnline.length()!=0)
    	 {
    		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
             if(!grpPolicyDB.equalsIgnoreCase("0"))
             	Helper.compareEquals(testConfig, "Comparing Group Policy DB and UI", grpPolicyDB, grpPolicyOnline);
    	 }
    	 
    	 else
    	 {
    	 
    		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
    	 }
    }
	 else
	 {
		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
        Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
        if(!grpPolicyDB.equalsIgnoreCase("0"))
         	Helper.compareEquals(testConfig, "Comparing Group Policy DB and UI", grpPolicyDB, grpPolicyUI1);
    }
 }
else
{
  Log.Comment("The Group Policy Number doesnt exists for this Criteria");
}


if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
{
	 
	 String grpPolicyUI1 = grpPolicyUI.getText();

   if(grpPolicyUI1.contains("/"))
    {

      if(!grpPolicyUI1.isEmpty())
       {
	        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
	        Log.Comment("Product Name from UI is :" + productNameUI);
	        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
	        Log.Comment("The Product Name from FISL is :" + productNameDB);
	        if(!productNameDB.equalsIgnoreCase("0"))
	        	Helper.compareEquals(testConfig, "Comparing Product Name DB and UI", productNameDB, productNameUI);
 }
    }
}

else
{
  Log.Comment("The Product Name doesnt exists for this Criteria");
}

String subscrbrUI1 = subscriberUI1.getText();

if(subscrbrUI1.contains("/"))
{
	//String subscrbrUI = subscrbrUI1.replace("/", "");
	
	String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
	
	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	if(!subscrbrDB.equalsIgnoreCase("0"))
	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
}

else
{
	String subscrbrUI = subscriberUI1.getText();
	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	if(!subscrbrDB.equalsIgnoreCase("0"))
	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
}


//Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
//String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
//Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
//if(!subscrbrDB.equalsIgnoreCase("0"))
//   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);


String claimHashUI = claimHash.getText();
Log.Comment("Claim # from UI is :" + claimHashUI);
String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
Log.Comment("Claim # from FISL is :" + claimTypeDB);
if(!claimTypeDB.equalsIgnoreCase("0"))
   Helper.compareEquals(testConfig, "Comparing Claim Type DB and UI", claimTypeDB, claimHashUI);
	 
String accntNumUI = accntNum.getText();
Log.Comment("Account Number from UI is :" + accntNumUI);
String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
Log.Comment("Account Number from FISL is :" + accntNumDB);
if(!accntNumDB.equalsIgnoreCase("0"))
  	Helper.compareEquals(testConfig, "Comparing Account Number DB and UI", accntNumDB, accntNumUI);

//String amntAllowedUI1 = amntallowed.getText();
//String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
//Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
//String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
//Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
//if(!amntAllowedDB.equalsIgnoreCase("0"))
//   Helper.compareEquals(testConfig, "Comparing Amounts Charged DB and UI", amntAllowedDB, amntAllowedUI);

/*
String CopayUI1 = copayUI.getText();
String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
Log.Comment("Copay Amount from UI is :" + CopayUI);
String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
Log.Comment("Copay Amount from FISL is :" + CopayDB);
if(!CopayDB.equalsIgnoreCase("0"))
    Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
  */ 
//String patientrespUI1 = patientresp.getText();
//String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//double patientrespU3 = Double.parseDouble(patientrespUI2);
// String patientrespUI = Double.toString(patientrespU3);
//Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//if(!patientrespDB.equalsIgnoreCase("0"))
//    Helper.compareEquals(testConfig, "Comparing Patient Responsibilty UI and DB", patientrespDB, patientrespUI);
}
}
}



public void verifySortByRendPrvdrLastName(String usertype) throws Exception
{
	
	Element.click(returnBtn, "Return Button");
	Browser.wait(testConfig, 2);
	
 if(usertype == "Payer")
 {
    String ui_Payer = payerUI.getText();
	Log.Comment("The First Payer Name displayed is:" + ui_Payer);

    Element.click(paymentNo1, "Payment Number");
    Element.expectedWait(remitHeader1, testConfig, "Remit Page", "Remit Page");
	String paymentNum1 = paymentNo.getText();
	String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
	Log.Comment("The First  Payment Number displayed is:" + paymentNum);
	List<WebElement> rendrngLastName = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'rndrProvId_')]"));
	int size = rendrngLastName.size();
	String rendrngLastName1 = testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'rndrProvId_1')]")).getText();
	
	Log.Comment("Rendering Name is:" + rendrngLastName1);
	
	
	
	List<String> rendrngLastNameUI4 = new ArrayList<String>();
	
    if(rendrngLastName1.isEmpty()||rendrngLastName1 == "")
	{
		Log.Pass("For this Particular TIN - Rendering Provider Names doesn't exists");
	}
	
	else
	{
	
		for(int i=1; i<=size; i++)
		{
				 Log.Comment(testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'rndrProvId_"+i+"')]")).getText());
				 String lastNames = testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'rndrProvId_"+i+"')]")).getText();
				 Log.Comment(lastNames);
				 
				 if(lastNames.contains("/"))
				 {
				 String[] res = lastNames.split("/");
				 String result = (res[0].substring( res[0].lastIndexOf(" "),  res[0].length())).trim();
				 Log.Comment(result);
				 rendrngLastNameUI4.add(result);
				 }
				 else if(lastNames!= "")
				 {
					//String result = lastNames.trim();
					 String result = lastNames.substring(lastNames.lastIndexOf(" "), lastNames.length()).trim();
					Log.Comment(result);
					rendrngLastNameUI4.add(result);
					
				 }

		}
		
		ArrayList<String> rendrngLastNameUI1 = new ArrayList<String>(); 

        for (String element : rendrngLastNameUI4) { 

         if (!rendrngLastNameUI1.contains(element)) { 

        	 rendrngLastNameUI1.add(element); 
         } 
     } 
		
        StringBuffer sb = new StringBuffer();
        
        for (String s : rendrngLastNameUI1) {
           sb.append(s);
           sb.append(";");
          }
        String rendrngLastNameUI = sb.toString();
              
//		
//		boolean sort = new Element().isSorted(rendrngLastNameUI);
//		Log.Comment("Rendering Provider Names are in Sort Order");
	
    int sqlRowNo = 184;
	testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
	Map payerSchema = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
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
		String paymentNumDB2 = paymentNumDB1.toString();
		String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length()- 1);
		String paymentNumDB = paymentNumDB3.substring(18,paymentNumDB3.length());
		Log.Comment("The UCP_CONSL_PAY_NBR is :" + paymentNumDB);
	    
	    sqlRowNo = 186;
		testConfig.putRunTimeProperty("paymentNum",paymentNum);
		Map orginDate = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String orginDateDB1 = orginDate.toString();
		String orginDateDB2 = orginDateDB1.substring(1, orginDateDB1.length() - 1);
		String orginDateDB = orginDateDB2.substring(11,orginDateDB2.length()).replaceAll("-", "");
	    String finalidentifier = payerSchemaUI.concat("-").concat(paymentNumDB).concat("-").concat(orginDateDB);
	    Log.Comment("The Final String is :" + finalidentifier);
		
		String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
	                         "<ns17:EpsClaimsRequest xmlns:ns10=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns1=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\">\r\n" +
	                         "<ns1:SearchCriteria ns1:FromRecord=\"-1\" ns1:MaxResult=\"10\" ns1:SortDirection=\"ASC\" ns1:SortFieldNumber=\"0\"/>\r\n" +
	                         "<ns3:PaymentIdentifier>"+finalidentifier+"</ns3:PaymentIdentifier>\r\n" + 
	                         "</ns17:EpsClaimsRequest>";
		String getResponse=new FISLConnection2().getEraResponse1(requestXml);
	    Map<String, List<String>> response = new ReadTagsfromFISLResponse().getNodesXML(getResponse);
	    ArrayList<String> rendrngLastNameDB1 = (ArrayList<String>) response.get("epsRenderingProviders");
	    
	  //  List<String> rendrngLastNameDB1 = rendrngLastNameDB2.stream().distinct().collect(Collectors.toList()); 
	    
	    StringBuffer sb1 = new StringBuffer();
	      
	      for (String s : rendrngLastNameDB1) {
	         sb.append(s);
	         sb.append(";");
	        }
	      String rendrngLastNameDB = sb.toString();
	      
		Helper.compareContains(testConfig,  "Comparing Rendering Provider Last Names from UI and FISL", rendrngLastNameUI, rendrngLastNameDB);
		
	    String fileDeleteResponse = new ReadTagsfromFISLResponse().deleteFileData();
	}
	
	else
		
	{
		String payerSchemaUI = (payerSchema.toString()).substring(14,19);
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
	  Map<String, List<String>> response = new ReadTagsfromFISLResponse().getNodesXML(getResponse);
	  ArrayList<String> rendrngLastNameDB1 = (ArrayList<String>) response.get("epsRenderingProviders");
	  StringBuffer sb1 = new StringBuffer();
	      
	      for (String s : rendrngLastNameDB1) {
	         sb.append(s);
	        }
	      String rendrngLastNameDB = sb.toString();
	      
		Helper.compareContains(testConfig,  "Comparing Rendering Provider Last Names from UI and FISL", rendrngLastNameUI, rendrngLastNameDB);
	  
	  

	  String fileDeleteResponse = new ReadTagsfromFISLResponse().deleteFileData();
		
	}

}
}
 else
 {

	    String ui_Payer = payernameUI.getText();
		Log.Comment("The First Payer Name displayed is:" + ui_Payer);

	    Element.click(paymentNo1, "Payment Number");
	    Element.expectedWait(remitHeader1, testConfig, "Remit Page", "Remit Page");
		String paymentNum1 = paymentNo.getText();
		String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
		Log.Comment("The First  Payment Number displayed is:" + paymentNum);
		List<WebElement> rendrngLastName = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'rndrProvId_')]"));
		int size = rendrngLastName.size();
		String rendrngLastName1 = testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'rndrProvId_1')]")).getText();
		
		Log.Comment("Rendering Name is:" + rendrngLastName1);
		
		
		
		List<String> rendrngLastNameUI4 = new ArrayList<String>();
		
	    if(rendrngLastName1.isEmpty()||rendrngLastName1 == "")
		{
			Log.Pass("For this Particular TIN - Rendering Provider Names doesn't exists");
		}
		
		else
		{
		
			for(int i=1; i<=size; i++)
			{
					 Log.Comment(testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'rndrProvId_"+i+"')]")).getText());
					 String lastNames = testConfig.driver.findElement(By.xpath("//td[starts-with(@id,'rndrProvId_"+i+"')]")).getText();
					 Log.Comment(lastNames);
					 
					 if(lastNames.contains("/"))
					 {
					 String[] res = lastNames.split("/");
					 String result = (res[0].substring( res[0].lastIndexOf(" "),  res[0].length())).trim();
					 Log.Comment(result);
					 rendrngLastNameUI4.add(result);
					 }
					 else if(lastNames!= "")
					 {
						//String result = lastNames.trim();
						 String result = lastNames.substring(lastNames.lastIndexOf(" "), lastNames.length()).trim();
						Log.Comment(result);
						rendrngLastNameUI4.add(result);
						
					 }

			}
			
			ArrayList<String> rendrngLastNameUI1 = new ArrayList<String>(); 

	        for (String element : rendrngLastNameUI4) { 

	         if (!rendrngLastNameUI1.contains(element)) { 

	        	 rendrngLastNameUI1.add(element); 
	         } 
	     } 
			
	        StringBuffer sb = new StringBuffer();
	        
	        for (String s : rendrngLastNameUI1) {
	           sb.append(s);
	           sb.append(";");
	          }
	        String rendrngLastNameUI = sb.toString();
	              
//			
//			boolean sort = new Element().isSorted(rendrngLastNameUI);
//			Log.Comment("Rendering Provider Names are in Sort Order");
		
	    int sqlRowNo = 184;
		testConfig.putRunTimeProperty("ui_Payer",ui_Payer);
		Map payerSchema = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
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
			String paymentNumDB2 = paymentNumDB1.toString();
			String paymentNumDB3 = paymentNumDB2.substring(1, paymentNumDB2.length()- 1);
			String paymentNumDB = paymentNumDB3.substring(18,paymentNumDB3.length());
			Log.Comment("The UCP_CONSL_PAY_NBR is :" + paymentNumDB);
		    
		    sqlRowNo = 186;
			testConfig.putRunTimeProperty("paymentNum",paymentNum);
			Map orginDate = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			String orginDateDB1 = orginDate.toString();
			String orginDateDB2 = orginDateDB1.substring(1, orginDateDB1.length() - 1);
			String orginDateDB = orginDateDB2.substring(11,orginDateDB2.length()).replaceAll("-", "");
		    String finalidentifier = payerSchemaUI.concat("-").concat(paymentNumDB).concat("-").concat(orginDateDB);
		    Log.Comment("The Final String is :" + finalidentifier);
			
			String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
		                         "<ns17:EpsClaimsRequest xmlns:ns10=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns1=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\">\r\n" +
		                         "<ns1:SearchCriteria ns1:FromRecord=\"-1\" ns1:MaxResult=\"10\" ns1:SortDirection=\"ASC\" ns1:SortFieldNumber=\"0\"/>\r\n" +
		                         "<ns3:PaymentIdentifier>"+finalidentifier+"</ns3:PaymentIdentifier>\r\n" + 
		                         "</ns17:EpsClaimsRequest>";
			String getResponse=new FISLConnection2().getEraResponse1(requestXml);
		    Map<String, List<String>> response = new ReadTagsfromFISLResponse().getNodesXML(getResponse);
		    ArrayList<String> rendrngLastNameDB1 = (ArrayList<String>) response.get("epsRenderingProviders");
		    
		  //  List<String> rendrngLastNameDB1 = rendrngLastNameDB2.stream().distinct().collect(Collectors.toList()); 
		    
		    StringBuffer sb1 = new StringBuffer();
		      
		      for (String s : rendrngLastNameDB1) {
		         sb.append(s);
		         sb.append(";");
		        }
		      String rendrngLastNameDB = sb.toString();
		      
			Helper.compareContains(testConfig,  "Comparing Rendering Provider Last Names from UI and FISL", rendrngLastNameUI, rendrngLastNameDB);
			
		    String fileDeleteResponse = new ReadTagsfromFISLResponse().deleteFileData();
		}
		
		else
			
		{
			String payerSchemaUI = (payerSchema.toString()).substring(14,19);
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
		  Map<String, List<String>> response = new ReadTagsfromFISLResponse().getNodesXML(getResponse);
		  ArrayList<String> rendrngLastNameDB1 = (ArrayList<String>) response.get("epsRenderingProviders");
		  StringBuffer sb1 = new StringBuffer();
		      
		      for (String s : rendrngLastNameDB1) {
		         sb.append(s);
		        }
		      String rendrngLastNameDB = sb.toString();
		      
			Helper.compareContains(testConfig,  "Comparing Rendering Provider Last Names from UI and FISL", rendrngLastNameUI, rendrngLastNameDB);
		  
		  

		  String fileDeleteResponse = new ReadTagsfromFISLResponse().deleteFileData();
			
		}

	}

 }
}



public void enterTINForTricareMask() throws Exception
{
	int sqlRowNo = 196;
	Map prov_TIN_NBRDB3 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String prov_TIN_NBRDB2 = prov_TIN_NBRDB3.toString();
	String prov_TAX_ID_NBR1 = prov_TIN_NBRDB2.substring(prov_TIN_NBRDB2.lastIndexOf("=")+1);
	String prov_TAX_ID_NBR = prov_TAX_ID_NBR1.substring(0, prov_TAX_ID_NBR1.length()-1);
    Log.Comment("The PROV_TIN_NBR is :" + prov_TAX_ID_NBR);
	Element.click(enterTIN, "TIN");
    Element.enterData(enterTIN, prov_TAX_ID_NBR, "Enter tin number as "+prov_TAX_ID_NBR, "tinNumber");
    Element.click(searchBtn, "Search");
	
}




public void enterTINForTricareMaskUPA() throws Exception
{
	int sqlRowNo = 196;
	Map prov_TIN_NBRDB3 = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String prov_TIN_NBRDB2 = prov_TIN_NBRDB3.toString();
	String prov_TAX_ID_NBR1 = prov_TIN_NBRDB2.substring(prov_TIN_NBRDB2.lastIndexOf("=")+1);
	String prov_TAX_ID_NBR = prov_TAX_ID_NBR1.substring(0, prov_TAX_ID_NBR1.length()-1);
    Log.Comment("The PROV_TIN_NBR is :" + prov_TAX_ID_NBR);
	Element.click(prvdrTIN, "TIN");
    Element.enterData(prvdrTIN, prov_TAX_ID_NBR, "Enter tin number as "+prov_TAX_ID_NBR, "tinNumber");
    Element.click(srchTINUPA, "Search");
	
}


public void enterElectronicNumForTricareMaskCriteria() throws Exception
{
    int sqlRowNo = 197;
	Map cp_DSPL_CONSL_PAY_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	String elctronicNum1 = cp_DSPL_CONSL_PAY_NBRDB.toString();
	String elctronicNum2 = elctronicNum1.substring(elctronicNum1.lastIndexOf("=")+1);
	String elctronicNum = elctronicNum2.substring(0, elctronicNum2.length()-1);
	Log.Comment("The Electronic Payment Number is :" + elctronicNum);
	Element.expectedWait(payNumdrpdwn, testConfig, "Electronic Payment Number", "Electronic Payment Number");
	Element.selectVisibleText(payNumdrpdwn,"Electronic Payment Number","Payment Dropdown");
    Log.Comment("Payment Dropdown Selected: Electronic Payment Number is selected");
    Element.click(elcPayNum, "Electronic Payment Number");
	Element.enterData(elcPayNum, elctronicNum, "Enter Electronic Number as "+elctronicNum, "Electronic Payment Number");
	Element.click(srchRemitBtn, "Search Remit");
}



public void verifyTricareMasking() throws Exception
{
	Browser.wait(testConfig, 3);
	
	Boolean remitpaymntheadUI = remitpaymnthead.isDisplayed();
	Helper.compareEquals(testConfig, "Payment Number Header check for Tricare", true, remitpaymntheadUI);
    Element.click(paymentNo1, "Payment Number");
    Element.expectedWait(subscriberUI1, testConfig, "Subscriber ID", "Subscriber ID");
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

	public void verifyDownload835() throws Exception
	{
		Browser.wait(testConfig, 3);
		
		Boolean remitpaymntheadUI = remitpaymnthead.isDisplayed();
		Helper.compareEquals(testConfig, "Payment Number Header", true, remitpaymntheadUI);
	    Element.click(paymentNo1, "Payment Number");
	    Element.expectedWait(subscriberUI1, testConfig, "Subscriber ID", "Subscriber ID");
		Boolean download835Button = download835.isDisplayed();
		Helper.compareEquals(testConfig, "Download 835 Button", true, download835Button);
		Element.verifyElementNotPresent(noteMsg, "Note: Above information provided by the member");
	  }


public void verifyRemittancePageDataUPA() throws Exception
{
	
	Browser.wait(testConfig, 2);
    String ui_Payer = payerUI.getText();
    Log.Comment("The First Payer Name displayed is:" + ui_Payer);
	Element.click(paymentNo1, "Payment No");
	Browser.wait(testConfig, 2);
	String paymentNum1 = paymentNo.getText();
	String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
	Log.Comment("The First Payment Number displayed is:" + paymentNum);
	List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
	Log.Comment("/************ List of Patient Names Present in Remittance Detail Page are as follows **********/");
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
		Log.Comment("FISL Patient First Name is:" + firstNameDB);
	    String firstPatientUI1 = firstPatient.getText();
	    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
	    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
	    Log.Comment("Online Patient First Name is:" + firstPatientUI);
	    if(!firstNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
		
	    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
		Log.Comment("FISL Patient Last Name is:" + lastNameDB);
	    String lastPatientUI1 = firstPatient.getText();
	    
	    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

	    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
	    if(!lastNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
		
	    
	    String amountChargedUI1 = amntChargedUI.getText();
	    String amountChargedUI = "";
	    
	    if(amountChargedUI1.contains("-"))
	    {

	    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
	    	{
	    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
	    		
	    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    		amountChargedUI = Double.toString(amountChargedUI4);
	    		Log.Comment(amountChargedUI);
	    	}
	    	
	    	else if (amountChargedUI1.contains("$")) 
	    	{
			 
	    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
	    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    	  amountChargedUI = Double.toString(amountChargedUI4);
	    	  Log.Comment(amountChargedUI);
			}
	    	else if (amountChargedUI1.contains(",")) {
	    		
	    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
	    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    		amountChargedUI = Double.toString(amountChargedUI4);
	    		Log.Comment(amountChargedUI);
				
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
	    
	    Log.Comment("The Amount Charged from UI is :" + amountChargedUI); 
	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>"));
	    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
	    if(!amountChargedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

	     String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();
	     
	     
	     Log.Comment("Size of Group[ Policy List is:" + grp);
	    
	     
	     if(!grp.contains(""))
	     {
	    	 String grpPolicyUI1 = grpPolicyUI.getText();
	    	 if(grpPolicyUI1.contains("/"))
	    	 {
	             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
	         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
	         	 
	         	 if(grpPolicyOnline.length()!=0)
	         	 {
	         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
		             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
		             if(!grpPolicyDB.equalsIgnoreCase("0"))
		             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
	         	 }
	         	 
	         	 else
	         	 {
	         	 
	         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	         	 }
	         }
	    	 else
	    	 {
	    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
	    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
	             if(!grpPolicyDB.equalsIgnoreCase("0"))
	              	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
	         }
	      }
	    else
	    {
	       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	    }

	     if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
	     {
	    	 
	    	 String grpPolicyUI1 = grpPolicyUI.getText();
	     
	        if(grpPolicyUI1.contains("/"))
	         {
	     
	           if(!grpPolicyUI1.isEmpty())
	            {
			        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
			        Log.Comment("Product Name from UI is :" + productNameUI);
			        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
			        Log.Comment("The Product Name from FISL is :" + productNameDB);
			        if(!productNameDB.equalsIgnoreCase("0"))
			        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
	      }
	         }
	     }
	     
	     else
	     {
	       Log.Comment("The Product Name doesnt exists for this Criteria");
	     }
	     

        String subscrbrUI1 = subscriberUI1.getText();

	     if(subscrbrUI1.contains("/"))
	     {
	    	 String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }

	     else
	     {
	     	String subscrbrUI = subscriberUI1.getText().trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }
	   
	     String claimHashUI = claimHash.getText();
	     Log.Comment("Claim # from UI is :" + claimHashUI);
	     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
	     Log.Comment("Claim # from FISL is :" + claimTypeDB);
	     if(!claimTypeDB.equalsIgnoreCase("0"))
	        Helper.compareEquals(testConfig, "Comparing Claim Identifier UI and DB", claimTypeDB, claimHashUI);
	  	 
	     String accntNumUI = accntNum.getText();
	     Log.Comment("Account Number from UI is :" + accntNumUI);
	     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
	     Log.Comment("Account Number from FISL is :" + accntNumDB);
	     if(!accntNumDB.equalsIgnoreCase("0"))
	       	Helper.compareEquals(testConfig, "Comparing Account Number UI and DB", accntNumDB, accntNumUI);
	    
	     String amntAllowedUI1 = amntallowed.getText();
	     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
	     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
	     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
	     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
	     if(!amntAllowedDB.equalsIgnoreCase("0"))
	        Helper.compareEquals(testConfig, "Comparing Allowed Amounts DB and UI", amntAllowedDB, amntAllowedDB);
	   
	     /*
	     String CopayUI1 = copayUI.getText();
	     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
	     Log.Comment("Copay Amount from UI is :" + CopayUI);
	     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
	     Log.Comment("Copay Amount from FISL is :" + CopayDB);
	     if(!CopayDB.equalsIgnoreCase("0"))
	         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
	       */
//	     String patientrespUI1 = patientresp.getText();
//	     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//	     double patientrespU3 = Double.parseDouble(patientrespUI2);
//		 String patientrespUI = Double.toString(patientrespU3);
//	     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//	     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//	     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//	     if(!patientrespDB.equalsIgnoreCase("0"))
//	         Helper.compareEquals(testConfig, "Comparing Patient Responsibility Amount UI and DB", patientrespDB, patientrespUI);
// 
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
	Log.Comment("FISL Patient First Name is:" + firstNameDB);
    String firstPatientUI1 = firstPatient.getText();
    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
    Log.Comment("Online Patient First Name is:" + firstPatientUI);
    if(!firstNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
	
    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
	Log.Comment("FISL Patient Last Name is:" + lastNameDB);
    String lastPatientUI1 = firstPatient.getText();
    
    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
    if(!lastNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
	
    String amountChargedUI1 = amntChargedUI.getText();
    
    String amountChargedUI = "";
    
    if(amountChargedUI1.contains("-"))
    {

    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
    	{
    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
    		
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
    	}
    	
    	else if (amountChargedUI1.contains("$")) 
    	{
		 
    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    	  amountChargedUI = Double.toString(amountChargedUI4);
    	  Log.Comment(amountChargedUI);
		}
    	else if (amountChargedUI1.contains(",")) {
    		
    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
			
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
    
    Log.Comment("The Amount Charged from UI is :" + amountChargedUI); 
    
    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>"));
    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
    if(!amountChargedDB.equalsIgnoreCase("0"))
       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

    String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();
    
    Log.Comment("Text of Group Policy List is:" + grp);
     
     if(!grp.contains(""))
     {
    	 String grpPolicyUI1 = grpPolicyUI.getText();
    	 if(grpPolicyUI1.contains("/"))
    	 {
             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
         	 
         	 if(grpPolicyOnline.length()!=0)
         	 {
         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
	             if(!grpPolicyDB.equalsIgnoreCase("0"))
	             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
         	 }
         	 
         	 else
         	 {
         	 
         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
         	 }
         }
    	 else
    	 {
    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
             if(!grpPolicyDB.equalsIgnoreCase("0"))
              	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
         }
      }
    else
    {
       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
    }
     

     if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
     {
    	 
    	 String grpPolicyUI1 = grpPolicyUI.getText();
     
        if(grpPolicyUI1.contains("/"))
         {
     
           if(!grpPolicyUI1.isEmpty())
            {
		        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
		        Log.Comment("Product Name from UI is :" + productNameUI);
		        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
		        Log.Comment("The Product Name from FISL is :" + productNameDB);
		        if(!productNameDB.equalsIgnoreCase("0"))
		        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
      }
         }
     }
     
     else
     {
       Log.Comment("The Product Name doesnt exists for this Criteria");
     }
     

        String subscrbrUI1 = subscriberUI1.getText();

	     if(subscrbrUI1.contains("/"))
	     {
	    	 String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }

	     else
	     {
	     	String subscrbrUI = subscriberUI1.getText().trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }
     
   
     String claimHashUI = claimHash.getText();
     Log.Comment("Claim # from UI is :" + claimHashUI);
     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
     Log.Comment("Claim # from FISL is :" + claimTypeDB);
     if(!claimTypeDB.equalsIgnoreCase("0"))
        Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", claimTypeDB, claimHashUI);
  	 
     String accntNumUI = accntNum.getText();
     Log.Comment("Account Number from UI is :" + accntNumUI);
     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
     Log.Comment("Account Number from FISL is :" + accntNumDB);
     if(!accntNumDB.equalsIgnoreCase("0"))
       	Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", accntNumDB, accntNumUI);
    
     String amntAllowedUI1 = amntallowed.getText();
     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
     if(!amntAllowedDB.equalsIgnoreCase("0"))
        Helper.compareEquals(testConfig, "Comparing Amounts Charged DB and UI", amntAllowedDB, amntAllowedUI);
   
     /*
     String CopayUI1 = copayUI.getText();
     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
     Log.Comment("Copay Amount from UI is :" + CopayUI);
     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
     Log.Comment("Copay Amount from FISL is :" + CopayDB);
     if(!CopayDB.equalsIgnoreCase("0"))
         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
       */ 
//     String patientrespUI1 = patientresp.getText();
//     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//     double patientrespU3 = Double.parseDouble(patientrespUI2);
//	 String patientrespUI = Double.toString(patientrespU3);
//     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//     if(!patientrespDB.equalsIgnoreCase("0"))
//         Helper.compareEquals(testConfig, "Comparing Patient Responsibilty UI and DB", patientrespDB, patientrespUI);

	}
	
}
public RemittanceDetail verifyPrintAvilableRequestVisiblity()
{

	

	Element.verifyElementPresent(Element.findElement(testConfig, "xpath", "//input[@value='Print Request' and @type = 'button']"), "Print Request");
	Element.verifyElementPresent(btnPrint, "Print Request Button");
	Helper.compareEquals(testConfig, "Print Request button", "true", btnPrint.getAttribute("disabled"));
	//Insert record in OLE.EPRA_STATUS Table and check the Print Avilable button	
	String PAYR_SCHM_NM=testConfig.getRunTimeProperty("PAYR_SCHM_NM").trim();
	String CONSL_PAY_NBR=testConfig.getRunTimeProperty("CONSL_PAY_NBR").trim();
	String CLAIMCOUNT=testConfig.getRunTimeProperty("CLAIMCOUNT").trim();
	String PRIORITY=testConfig.getRunTimeProperty("PRIORITY");
	String PORTAL_USER_ID=testConfig.getRunTimeProperty("PORTAL_USER_ID");
	String SETL_DT=testConfig.getRunTimeProperty("SETL_DT");
	String ELECTRONIC_PAYMENT_NUMBER=testConfig.getRunTimeProperty("ELECTRONIC_PAYMENT_NUMBER");

	int insertQueryRowNo=1618;
    DataBase.executeInsertQuery(testConfig, insertQueryRowNo);
    
    Browser.browserRefresh(testConfig);
    Element.verifyElementPresent(Element.findElement(testConfig, "xpath", "//input[@value='Print Available' and @type = 'button']"), "Print Available");
	Element.verifyElementPresent(btnPrntavailable, "Print Available Button");
	Helper.compareEquals(testConfig, "Print Avilable button", "true", btnPrntavailable.getAttribute("disabled"));
	
	Browser.wait(testConfig, 2);
	DataBase.executeDeleteQuery(testConfig, 1619);

	return this;
}

public RemittanceDetail clickPrintRequestButton()
{
	Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//input[@value='Print Request' and @type = 'button']"), 60);
	Element.verifyElementPresent(btnPrint, "Print Request Button");
	Helper.compareEquals(testConfig, "Button", "Print Request", btnPrint.getAttribute("value"));
	Element.waitForElementTobeClickAble(testConfig, btnPrint, 60);
	Element.click(btnPrint, "Print Request Button");
	verifyDownloadWindow();
	Browser.browserRefresh(testConfig);
	Browser.browserRefresh(testConfig);
	Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//input[@value='Print Available']"), 60);
	Element.verifyElementPresent(btnPrntavailable, "Print Available");
	Helper.compareEquals(testConfig, "Button", "Print Available", btnPrntavailable.getAttribute("value"));
	
	return this;
}

public RemittanceDetail clickPrintButton()
{
	String filedir=System.getProperty("user.dir")+"\\Downloads";
	File fileDirectory=new File(filedir);
	Helper.purgeDirectory(fileDirectory);
	Browser.browserRefresh(testConfig);
	Element.waitForElementTobeClickAble(testConfig, btnPrntavailable, 60);
	Element.click(btnPrntavailable, "Print Available Button");
	Helper.compareEquals(testConfig, "Button", "Print Available", btnPrntavailable.getAttribute("value"));
	Helper.isFileExist(fileDirectory,testConfig.getRunTimeProperty("tin"));
	return this;
}

	public RemittanceDetail verifyDownloadWindow() {
		String oldWindow = Browser.switchToNewWindow(testConfig, "EPRADisplayWindow");

		if (msg.getText().contains("Your PDF is now available")) {
			Helper.compareContains(testConfig, "Epra PDF Text", "Your PDF is now available", msg.getText());
		} else if (msg.getText().contains("We're sorry,it looks like the requested PDF document")) {
			Helper.compareContains(testConfig, "Epra PDF Text", "We're sorry, it looks like the requested PDF document",
					msg.getText());
		} else if (msg.getText().contains("The PDF document that you")) {
			Helper.compareContains(testConfig, "Epra PDF Text", "The PDF document that you", msg.getText());
		}

		Browser.switchToParentWindow(testConfig, oldWindow);
		return this;
	}






public void verifyRemittancePageDataUPAPayer() throws Exception  
{
	
	Browser.wait(testConfig, 2);
    String ui_Payer = payernameUI.getText();
    Log.Comment("The First Payer Name displayed is:" + ui_Payer);
	Element.click(paymentNo1, "Payment No");
	Browser.wait(testConfig, 2);
	String paymentNum1 = paymentNo.getText();
	String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
	Log.Comment("The First Payment Number displayed is:" + paymentNum);
	List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
	Log.Comment("/************ List of Patient Names Present in Remittance Detail Page are as follows **********/");
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
		Log.Comment("FISL Patient First Name is:" + firstNameDB);
	    String firstPatientUI1 = firstPatient.getText();
	    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
	    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
	    Log.Comment("Online Patient First Name is:" + firstPatientUI);
	    if(!firstNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
		
	    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
		Log.Comment("FISL Patient Last Name is:" + lastNameDB);
	    String lastPatientUI1 = firstPatient.getText();
	    
	    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

	    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
	    if(!lastNameDB.equalsIgnoreCase("0"))
	    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
		
	    
	    String amountChargedUI1 = amntChargedUI.getText();
	    String amountChargedUI = "";
	    
	    if(amountChargedUI1.contains("-"))
	    {

	    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
	    	{
	    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
	    		
	    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    		amountChargedUI = Double.toString(amountChargedUI4);
	    		Log.Comment(amountChargedUI);
	    	}
	    	
	    	else if (amountChargedUI1.contains("$")) 
	    	{
			 
	    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
	    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    	  amountChargedUI = Double.toString(amountChargedUI4);
	    	  Log.Comment(amountChargedUI);
			}
	    	else if (amountChargedUI1.contains(",")) {
	    		
	    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
	    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
	    		amountChargedUI = Double.toString(amountChargedUI4);
	    		Log.Comment(amountChargedUI);
				
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
	    
	    Log.Comment("The Amount Charged from UI is :" + amountChargedUI);  
	    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>"));
	    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
	    if(!amountChargedDB.equalsIgnoreCase("0"))
	       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

	     String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();
	     
	     
	     Log.Comment("Size of Group[ Policy List is:" + grp);
	    
	     
	     if(!grp.contains(""))
	     {
	    	 String grpPolicyUI1 = grpPolicyUI.getText();
	    	 if(grpPolicyUI1.contains("/"))
	    	 {
	             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
	         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
	         	 
	         	 if(grpPolicyOnline.length()!=0)
	         	 {
	         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
		             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
		             if(!grpPolicyDB.equalsIgnoreCase("0"))
		             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
	         	 }
	         	 
	         	 else
	         	 {
	         	 
	         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	         	 }
	         }
	    	 else
	    	 {
	    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
	    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
	             if(!grpPolicyDB.equalsIgnoreCase("0"))
	              	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
	         }
	      }
	    else
	    {
	       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
	    }

	     if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
	     {
	    	 
	    	 String grpPolicyUI1 = grpPolicyUI.getText();
	     
	        if(grpPolicyUI1.contains("/"))
	         {
	     
	           if(!grpPolicyUI1.isEmpty())
	            {
			        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
			        Log.Comment("Product Name from UI is :" + productNameUI);
			        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
			        Log.Comment("The Product Name from FISL is :" + productNameDB);
			        if(!productNameDB.equalsIgnoreCase("0"))
			        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
	      }
	         }
	     }
	     
	     else
	     {
	       Log.Comment("The Product Name doesnt exists for this Criteria");
	     }
	     

        String subscrbrUI1 = subscriberUI1.getText();

	     if(subscrbrUI1.contains("/"))
	     {
	    	 String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }

	     else
	     {
	     	String subscrbrUI = subscriberUI1.getText().trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }
	   
	     String claimHashUI = claimHash.getText();
	     Log.Comment("Claim # from UI is :" + claimHashUI);
	     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
	     Log.Comment("Claim # from FISL is :" + claimTypeDB);
	     if(!claimTypeDB.equalsIgnoreCase("0"))
	        Helper.compareEquals(testConfig, "Comparing Claim Identifier UI and DB", claimTypeDB, claimHashUI);
	  	 
	     String accntNumUI = accntNum.getText();
	     Log.Comment("Account Number from UI is :" + accntNumUI);
	     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
	     Log.Comment("Account Number from FISL is :" + accntNumDB);
	     if(!accntNumDB.equalsIgnoreCase("0"))
	       	Helper.compareEquals(testConfig, "Comparing Account Number UI and DB", accntNumDB, accntNumUI);
	    
	     String amntAllowedUI1 = amntallowed.getText();
	     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
	     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
	    // String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
	     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:CoveredAmount>")+19, getResponse.indexOf("</ns4:CoveredAmount>"));
	     
	     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
	     if(!amntAllowedDB.equalsIgnoreCase("0"))
	        Helper.compareEquals(testConfig, "Comparing Allowed Amounts DB and UI", amntAllowedDB, amntAllowedUI);
	   
	     /*
	     String CopayUI1 = copayUI.getText();
	     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
	     Log.Comment("Copay Amount from UI is :" + CopayUI);
	     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
	     Log.Comment("Copay Amount from FISL is :" + CopayDB);
	     if(!CopayDB.equalsIgnoreCase("0"))
	         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
	       */
//	     String patientrespUI1 = patientresp.getText();
//	     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//	     double patientrespU3 = Double.parseDouble(patientrespUI2);
//		 String patientrespUI = Double.toString(patientrespU3);
//	     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//	     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//	     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//	     if(!patientrespDB.equalsIgnoreCase("0"))
//	         Helper.compareEquals(testConfig, "Comparing Patient Responsibility Amount UI and DB", patientrespDB, patientrespUI);
// 
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
	Log.Comment("FISL Patient First Name is:" + firstNameDB);
    String firstPatientUI1 = firstPatient.getText();
    String firstPatientUI2 = firstPatientUI1.substring(0, firstPatientUI1.indexOf("/"));
    String firstPatientUI = firstPatientUI2.substring(0, firstPatientUI2.indexOf(" "));
    Log.Comment("Online Patient First Name is:" + firstPatientUI);
    if(!firstNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient First Name UI and DB", firstNameDB, firstPatientUI);
	
    String lastNameDB = getResponse.substring(getResponse.indexOf("<ns0:PatientLastName>")+21, getResponse.indexOf("</ns0:PatientLastName>"));
	Log.Comment("FISL Patient Last Name is:" + lastNameDB);
    String lastPatientUI1 = firstPatient.getText();
    
    String lastPatientUI = lastPatientUI1.substring(lastPatientUI1.lastIndexOf(" ")+1, lastPatientUI1.lastIndexOf("/"));

    Log.Comment("Online Patient Last Name is :" + lastPatientUI);
    if(!lastNameDB.equalsIgnoreCase("0"))
    	Helper.compareEquals(testConfig, "Comparing Patient Last Name UI and DB", lastNameDB, lastPatientUI);
	
    String amountChargedUI1 = amntChargedUI.getText();
    String amountChargedUI = "";
    
    if(amountChargedUI1.contains("-"))
    {

    	if(amountChargedUI1.contains("$") && amountChargedUI1.contains(","))
    	{
    		String amountChargedUI3 = (amountChargedUI1.replace("$", "")).replace(",", "");
    		
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
    	}
    	
    	else if (amountChargedUI1.contains("$")) 
    	{
		 
    	  String amountChargedUI3 = amountChargedUI1.replace("$", "");
    	  double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    	  amountChargedUI = Double.toString(amountChargedUI4);
    	  Log.Comment(amountChargedUI);
		}
    	else if (amountChargedUI1.contains(",")) {
    		
    		String amountChargedUI3 = amountChargedUI1.replace(",", "");
    		double amountChargedUI4 = Double.parseDouble(amountChargedUI3);
    		amountChargedUI = Double.toString(amountChargedUI4);
    		Log.Comment(amountChargedUI);
			
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
    
    Log.Comment("The Amount Charged from UI is :" + amountChargedUI); 
    String amountChargedDB = getResponse.substring(getResponse.indexOf("<ns4:ChargedAmount>")+19, getResponse.indexOf("</ns4:ChargedAmount>"));
    Log.Comment("The Amount Charged from FISL is :" +amountChargedDB); 
    if(!amountChargedDB.equalsIgnoreCase("0"))
       Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", amountChargedDB, amountChargedUI);

    String grp = testConfig.driver.findElement(By.xpath("//td[@id='grpPolNo_1']")).getText();
    
    Log.Comment("Text of Group Policy List is:" + grp);
     
     if(!grp.contains(""))
     {
    	 String grpPolicyUI1 = grpPolicyUI.getText();
    	 if(grpPolicyUI1.contains("/"))
    	 {
             String grpPolicyOnline = grpPolicyUI1.substring(0, grpPolicyUI1.indexOf("/"));
         	 Log.Comment("Group Policy from UI is :" + grpPolicyOnline);
         	 
         	 if(grpPolicyOnline.length()!=0)
         	 {
         		String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
	             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
	             if(!grpPolicyDB.equalsIgnoreCase("0"))
	             	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyOnline);
         	 }
         	 
         	 else
         	 {
         	 
         		Log.Comment("The Group Policy Number doesnt exists for this Criteria");
         	 }
         }
    	 else
    	 {
    		 Log.Comment("Group Policy from UI is :" + grpPolicyUI1);
    		 String grpPolicyDB = getResponse.substring(getResponse.indexOf("<ns3:GroupIdentifier>")+21, getResponse.indexOf("</ns3:GroupIdentifier>"));
             Log.Comment("The Group Policy from FISL is :" + grpPolicyDB); 
             if(!grpPolicyDB.equalsIgnoreCase("0"))
              	Helper.compareEquals(testConfig, "Comparing Group Policy UI and DB", grpPolicyDB, grpPolicyUI1);
         }
      }
    else
    {
       Log.Comment("The Group Policy Number doesnt exists for this Criteria");
    }
     

     if(testConfig.driver.findElements(By.xpath("//td[@id='grpPolNo_1']")).size() != 0)
     {
    	 
    	 String grpPolicyUI1 = grpPolicyUI.getText();
     
        if(grpPolicyUI1.contains("/"))
         {
     
           if(!grpPolicyUI1.isEmpty())
            {
		        String productNameUI = (grpPolicyUI1.substring(grpPolicyUI1.indexOf("/")+1, grpPolicyUI1.length())).trim().replace("\n","");
		        Log.Comment("Product Name from UI is :" + productNameUI);
		        String productNameDB = getResponse.substring(getResponse.indexOf("<ns4:ProductName>")+17, getResponse.indexOf("</ns4:ProductName>"));
		        Log.Comment("The Product Name from FISL is :" + productNameDB);
		        if(!productNameDB.equalsIgnoreCase("0"))
		        	Helper.compareEquals(testConfig, "Comparing Product Name UI and FISL", productNameDB, productNameUI);
      }
         }
     }
     
     else
     {
       Log.Comment("The Product Name doesnt exists for this Criteria");
     }
     

       String subscrbrUI1 = subscriberUI1.getText();

	     if(subscrbrUI1.contains("/"))
	     {
	    	 String subscrbrUI = subscrbrUI1.substring(0, subscrbrUI1.indexOf("/")-1).trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }

	     else
	     {
	     	String subscrbrUI = subscriberUI1.getText().trim();
	     	Log.Comment("Subscriber ID from UI is :" + subscrbrUI);
	     	String subscrbrDB = getResponse.substring(getResponse.indexOf("<ns3:SubscriberIdentifier>")+26, getResponse.indexOf("</ns3:SubscriberIdentifier>"));
	     	Log.Comment("The SubscriberID from FISL is :" + subscrbrDB);
	     	if(!subscrbrDB.equalsIgnoreCase("0"))
	     	   Helper.compareEquals(testConfig, "Comparing Subscriber ID DB and UI", subscrbrDB, subscrbrUI);
	     }
   
     String claimHashUI = claimHash.getText();
     Log.Comment("Claim # from UI is :" + claimHashUI);
     String claimTypeDB = getResponse.substring(getResponse.indexOf("<ns3:ClaimIdentifier>")+21, getResponse.indexOf("</ns3:ClaimIdentifier>"));
     Log.Comment("Claim # from FISL is :" + claimTypeDB);
     if(!claimTypeDB.equalsIgnoreCase("0"))
        Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", claimTypeDB, claimHashUI);
  	 
     String accntNumUI = accntNum.getText();
     Log.Comment("Account Number from UI is :" + accntNumUI);
     String accntNumDB = getResponse.substring(getResponse.indexOf("<ns3:AccountNumber>")+19, getResponse.indexOf("</ns3:AccountNumber>"));
     Log.Comment("Account Number from FISL is :" + accntNumDB);
     if(!accntNumDB.equalsIgnoreCase("0"))
       	Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", accntNumDB, accntNumUI);
    
     String amntAllowedUI1 = amntallowed.getText();
     String amntAllowedUI = amntAllowedUI1.substring(amntAllowedUI1.indexOf("$")+1, amntAllowedUI1.length()-1);
     Log.Comment("Amount Allowed from UI is :" + amntAllowedUI);
     String amntAllowedDB = getResponse.substring(getResponse.indexOf("<ns4:AllowedAmount>")+19, getResponse.indexOf("</ns4:AllowedAmount>"));
     Log.Comment("Amount Allowed from FISL is :" + amntAllowedDB);
     if(!amntAllowedDB.equalsIgnoreCase("0"))
        Helper.compareEquals(testConfig, "Comparing Amounts Charged DB and UI", amntAllowedDB, amntAllowedUI);
   
     /*
     String CopayUI1 = copayUI.getText();
     String CopayUI = CopayUI1.substring(CopayUI1.indexOf("$")+1, CopayUI1.length()-1);
     Log.Comment("Copay Amount from UI is :" + CopayUI);
     String CopayDB = getResponse.substring(getResponse.indexOf("<ns4:DeductibleCoInsuranceCoPayAmount>")+38, getResponse.indexOf("</ns4:DeductibleCoInsuranceCoPayAmount>"));
     Log.Comment("Copay Amount from FISL is :" + CopayDB);
     if(!CopayDB.equalsIgnoreCase("0"))
         Helper.compareEquals(testConfig, "Comparing Amounts Charged UI and DB", CopayDB, CopayUI);
       */ 
//     String patientrespUI1 = patientresp.getText();
//     String patientrespUI2 = patientrespUI1.substring(patientrespUI1.indexOf("$")+1, patientrespUI1.length());
//     double patientrespU3 = Double.parseDouble(patientrespUI2);
//	 String patientrespUI = Double.toString(patientrespU3);
//     Log.Comment("Patient Responsibilty Amount in UI is :" + patientrespUI);
//     String patientrespDB = getResponse.substring(getResponse.indexOf("<ns4:PatientResponsibilityTotalAmount>")+38, getResponse.indexOf("</ns4:PatientResponsibilityTotalAmount>"));
//     Log.Comment("Patient Responsibilty Amount in FISL is :" + patientrespDB);
//     if(!patientrespDB.equalsIgnoreCase("0"))
//         Helper.compareEquals(testConfig, "Comparing Patient Responsibilty UI and DB", patientrespDB, patientrespUI);

	}
	
}

	public void verifyRemittanceDetailScreen() throws Exception
	// TODO verify subscriber first name and last name
	{
	  int size = testConfig.driver.findElements( By.xpath("//td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")).size();
	  
	  Log.Comment("Size of the tlist is:" + size);
		
	    if(testConfig.driver.findElements( By.xpath("//td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")).size() != 0)
	    {
			//List<WebElement> patientNames = testConfig.driver.findElements(By.xpath("//td[starts-with(@id,'patientName_')]"));
		      int sqlRowNo = 409;
		  	Map payerSchema = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		  	Log.Comment("Message from DB for Payer Schema:" + payerSchema);		  	
		  	String paymentNum1 = paymentNo.getText();
			String paymentNum = paymentNum1.substring(paymentNum1.lastIndexOf(":")+1, paymentNum1.length()).trim();
			Helper.compareEquals(testConfig, "First name", payerSchema.get("DSPL_CONSL_PAY_NBR").toString(), paymentNum);
	    }
	}
	    
 

	public RemittanceDetail SelectPDFLink() throws InterruptedException
	{
		Browser.wait(testConfig, 10);
		WebElement	lnkppraPdf=null;
		List<WebElement> ppRAElts=null;
		String xpath12=null;
		String srchCriteria=testConfig.getRunTimeProperty("srchCriteria");
		String expectedPaymntNo=testConfig.getRunTimeProperty("CONSL_PAY_NBR");
		String xpath1="//div[@id='search-remmitance']/table/tbody/";
		String xpath2="/td/table/tbody/tr/td/table/tbody/tr";

		if (srchCriteria.equals("byHCPayment_Number"))
		{
			 xpath12=xpath1+"tr[7]"+xpath2;
			ppRAElts=Element.findElements(testConfig, "xpath",xpath12 );}
		else if (srchCriteria.equals("byHCDOPAndNpi"))
		{
			 xpath12=xpath1+"tr[8]"+xpath2;
			ppRAElts=Element.findElements(testConfig, "xpath", xpath12);}
		for(int i=1;i<ppRAElts.size();i++)
		{
			String actualPaymntNo=ppRAElts.get(i).findElements(By.tagName("td")).get(3).getText();
			actualPaymntNo=org.apache.commons.lang3.StringUtils.replace(actualPaymntNo, "\n", "");
			 if(actualPaymntNo.contains(expectedPaymntNo))
			 {
				 lnkppraPdf=Element.findElement(testConfig, "xpath", xpath12+"["+(i+1)+"]"+"/td[9]/table/tbody/tr/td/span/a");
			 break;
			 }
			
		}
		 Element.waitForElementTobeClickAble(testConfig, lnkppraPdf, 60);	
		 Element.clickByJS(testConfig, lnkppraPdf, "PPRA link");
		 if(System.getProperty("Application").contains("UPA"))
		 {	 
		String oldWindow=Browser.switchToNewWindow(testConfig,"PRADisplayWindow");
		 Browser.wait(testConfig, 5);      
	      Browser.switchToParentWindow(testConfig,oldWindow);
		 }
		 else
			 Browser.wait(testConfig, 8); 	 
		return this;		
	}
	
	
	
	
	
	public void enterElecNumForRenderprov() throws Exception
	{
		String tin = System.getProperty("tin");
		 int sqlRowNo = 1903;
		//int sqlRowNo = 49;
		testConfig.putRunTimeProperty("tin",tin);
		Map cp_DSPL_CONSL_PAY_NBRDB = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);

		String elctronicNum = cp_DSPL_CONSL_PAY_NBRDB.get("DSPL_CONSL_PAY_NBR").toString();
		Log.Comment("The Electronic Payment Number is :" + elctronicNum);
		//System.setProperty("consl_pay_nbr", cp_DSPL_CONSL_PAY_NBRDB.get("CONSL_PAY_NBR").toString());
		
		Element.expectedWait(payNumdrpdwn, testConfig, "Electronic Payment Dropdown", "Electronic Payment Dropdown");
		Element.selectVisibleText(payNumdrpdwn,"Electronic Payment Number","Payment Dropdown");
		Log.Comment("Payment Dropdown Selected: Electronic Payment Number is selected");
		Element.click(elcPayNum, "Electronic Payment Number");
		Element.enterData(elcPayNum, elctronicNum, "Enter Electronic number as "+elctronicNum, "Electonic Payment Number");
		Element.click(srchRemitBtn, "Search Remit");
	}
    
	public RemittanceDetail isPDFAvailable(String Status) throws InterruptedException
	{
		
		if(Status.equalsIgnoreCase("Present"))
		{
			
			Log.Comment("inside if-1");
			Thread.sleep(8000);
			WebElement test = Element.findElement(testConfig, "xpath", "//span[contains(@id,'ppra')]//img");
			if(test.isEnabled())
			{
				WebElement element = Element.findElement(testConfig, "xpath", "//span[contains(@id,'ppra')]//img");						
					
				Log.Comment("PDF file name is --->"+System.getProperty("pPRAPDFFileName"));
			}				
			
		}
		else
		{
			
			Element.verifyElementNotPresent(pPRAPDFImage, "pPRA PDF Image");
		}
		
		return this;
	}
	
	
	public void clickPayNum() throws InterruptedException
	{
		
		Element.expectedWait(paymentNo1, testConfig, "Payment No", "Payment No");
	    Element.click(paymentNo1, "Payment No");
		
	}
	
	
	public void verifyCOBFilterClaimData(String userType) throws Exception {
        Element.click(returnBtn, "Return Button");
        Browser.wait(testConfig, 2);
        String ui_Payer = payernameUI.getText();
        Log.Comment("The First Payer Name displayed is:" + ui_Payer);

        Element.click(paymentNo1, "Payment No");
        Browser.wait(testConfig, 2);
        handleTechnicalDifficultyError();

        Element.selectVisibleText(filterClaims, "COB Only", "Claim Filter DropDown");
        Element.expectedWait(filterClaims, testConfig, "COB Only", "COB Only");
        Log.Comment("Filter Claims Dropdown selected - COB Only");

        Browser.wait(testConfig, 2);
        handleTechnicalDifficultyError();
        int size = testConfig.driver.findElements(By.xpath("//td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")).size();

        Log.Comment("Size of the tlist is:" + size);

        if (testConfig.driver.findElements(By.xpath("//td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")).size() != 0) {

            String xmlRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<ns21:EpsClaimsRequest xmlns=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns20=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/Edi835ContentService_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns10=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns21=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentDetailService_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns19=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns18=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0\">\n" +
                    "\t<ns19:SearchCriteria ns19:FromRecord=\"-1\" ns19:MaxResult=\"10\" ns19:SortDirection=\"ASC\" ns19:SortFieldNumber=\"0\"/>\n" +
                    "\t<ns3:PaymentIdentifier>"+getFinalIdentifier()+"</ns3:PaymentIdentifier>\n" +
                    "    <ns2:ClaimFilterTypeCode>2,3</ns2:ClaimFilterTypeCode>\n" +
                    "</ns21:EpsClaimsRequest>";
            Log.Comment("XML Request : \n" + xmlRequest);

            String response = invokePostCall(xmlRequest);

            coreFISLvalidationWithUI(response);
        }
        else {
            String claim = testConfig.driver.findElement(By.xpath("//div[@id='msgforplb']/span[@class='Subheaderbold']")).getText().substring(6, 46);
            Log.Comment("COB Only Message displaying on Remit Page is :" + claim);
            Helper.compareEquals(testConfig, "Checking data for COB Claim only", claim, "This payment contains adjustment(s) only");
            Log.Comment("COB Claim doesnt contain data for this criteria");
        }
    }
	
	public ClaimDetail clickClaimNumber(){
		Element.click(claimHash,"Claim Number");
		return new ClaimDetail(testConfig);
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
	
	public void validateFISLvsUI() throws SAXException, JAXBException, ParserConfigurationException, IOException {

        Browser.wait(testConfig, 2);
        String ui_Payer = payernameUI.getText();
        Log.Comment("The First Payer Name displayed is:" + ui_Payer);
        testConfig.putRunTimeProperty("ui_Payer", ui_Payer);

        Element.click(paymentNo1, "Payment No");
        Browser.wait(testConfig, 2);
        handleTechnicalDifficultyError();
        loadRemittanceDetailUIdata();

        String xmlRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<ns21:EpsClaimsRequest xmlns=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns20=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/Edi835ContentService_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns10=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns21=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentDetailService_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns19=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns18=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0\">\n" +
                "\t<ns19:SearchCriteria ns19:FromRecord=\"-1\" ns19:MaxResult=\"10\" ns19:SortDirection=\"ASC\" ns19:SortFieldNumber=\"0\"/>\n" +
                "\t<ns3:PaymentIdentifier>" + getFinalIdentifier() + "</ns3:PaymentIdentifier>\n" +
                "</ns21:EpsClaimsRequest>";
        Log.Comment("XML Request : \n" + xmlRequest);

        String response = invokePostCall(xmlRequest);

        coreFISLvalidationWithUI(response);
    }
	
	private void loadRemittanceDetailUIdata() {

        Browser.wait(testConfig, 5);

        List<String> accountNumbers = new ArrayList<String>();
        List<String> patientNamesAndPatientIds = new ArrayList<String>();
        List<String> subscriberIdsAndCorrectedIds = new ArrayList<String>();
        List<String> renderingProviders = new ArrayList<String>();
        List<String> claimsAndClaimsTypes = new ArrayList<String>();
        List<String> groupPolicyNumbersAndProductNames = new ArrayList<String>();

        List<String> subTotalDescriptionOfservices = new ArrayList<String>();
        List<String> subTotalAmountsCharged = new ArrayList<String>();
        List<String> subTotalClaimOrServiceAdjustments = new ArrayList<String>();
        List<String> subTotalProviderAdjDiscount = new ArrayList<String>();
        List<String> subTotalAllowedAmount = new ArrayList<String>();
        List<String> subTotalDeductCoinsCopay = new ArrayList<String>();
        List<String> subTotalPaidToProvider = new ArrayList<String>();
        List<String> subTotalAdjustmentReasonCode = new ArrayList<String>();
        List<String> subTotalRMKCode = new ArrayList<String>();
        List<String> subTotalPatientResponse = new ArrayList<String>();

        List<String> datesOfservices = new ArrayList<String>();
        List<String> descriptionOfservicwes = new ArrayList<String>();
        List<String> amountCharged = new ArrayList<String>();
        List<String> claimOrserviceAdj = new ArrayList<String>();
        List<String> providerAdjDiscount = new ArrayList<String>();
        List<String> amountAllowed = new ArrayList<String>();
        List<String> deductCoinsCopay = new ArrayList<String>();
        List<String> paidtoProvider = new ArrayList<String>();
        List<String> adjustmentReasonCode = new ArrayList<String>();
        List<String> rmkCode = new ArrayList<String>();
        List<String> patientResponse = new ArrayList<String>();

        int totalRows = Element.findElements(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr").size();
        StringBuilder rowData = new StringBuilder();
        for (int i = 1; i <= totalRows; i++) {
            int totalCols = Element.findElements(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td").size();
            if (totalCols == 6 || totalCols == 9) {
                accountNumbers.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[1]").getText().trim());
                patientNamesAndPatientIds.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[2]").getText().trim());
                subscriberIdsAndCorrectedIds.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[3]").getText().trim());
                renderingProviders.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[4]").getText().trim());
                claimsAndClaimsTypes.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[5]").getText().trim());
                groupPolicyNumbersAndProductNames.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[6]").getText().trim());
            } else if ((totalCols == 12 && Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[1]").getText().trim().contains("Subtotal"))
             || (totalCols == 15 && Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[1]").getText().trim().contains("Subtotal"))) {
                subTotalDescriptionOfservices.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[2]").getText().trim());
                subTotalAmountsCharged.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[3]").getText().trim());
                subTotalClaimOrServiceAdjustments.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[4]").getText().trim());
                subTotalProviderAdjDiscount.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[5]").getText().trim());
                subTotalAllowedAmount.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[6]").getText().trim());
                subTotalDeductCoinsCopay.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[7]").getText().trim());
                subTotalPaidToProvider.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[8]").getText().trim());
                subTotalAdjustmentReasonCode.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[9]").getText().trim());
                subTotalRMKCode.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[1]").getText().trim());
                subTotalPatientResponse.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[10]").getText().trim());
            } else if(totalCols == 12 || totalCols == 15){
                datesOfservices.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[1]").getText().trim());
                descriptionOfservicwes.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[2]").getText().trim());
                amountCharged.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[3]").getText().trim());
                claimOrserviceAdj.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[4]").getText().trim());
                providerAdjDiscount.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[5]").getText().trim());
                amountAllowed.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[6]").getText().trim());
                deductCoinsCopay.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[7]").getText().trim());
                paidtoProvider.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[8]").getText().trim());
                adjustmentReasonCode.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[9]").getText().trim());
                rmkCode.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[10]").getText().trim());
                patientResponse.add(Element.findElement(testConfig, "xpath", "//*[@id=\"flow1\"]/table/tbody/tr[" + i + "]/td[11]").getText().trim());
            }
        }

        epsClaimsResponseUI.setAccountNumbers(accountNumbers);
        epsClaimsResponseUI.setPatientNamesAndPatientIds(patientNamesAndPatientIds);
        epsClaimsResponseUI.setSubscriberIdsAndCorrectedIds(subscriberIdsAndCorrectedIds);
        epsClaimsResponseUI.setRenderingProviders(renderingProviders);
        epsClaimsResponseUI.setClaimsAndClaimsTypes(claimsAndClaimsTypes);
        epsClaimsResponseUI.setGroupPolicyNumbersAndProductNames(groupPolicyNumbersAndProductNames);

        epsClaimsResponseUI.setSubTotalDescriptionOfservices(subTotalDescriptionOfservices);
        epsClaimsResponseUI.setSubTotalAmountsCharged(subTotalAmountsCharged);
        epsClaimsResponseUI.setSubTotalClaimOrServiceAdjustments(subTotalClaimOrServiceAdjustments);
        epsClaimsResponseUI.setSubTotalProviderAdjDiscount(subTotalProviderAdjDiscount);
        epsClaimsResponseUI.setSubTotalAllowedAmount(subTotalAllowedAmount);
        epsClaimsResponseUI.setSubTotalDeductCoinsCopay(subTotalDeductCoinsCopay);
        epsClaimsResponseUI.setSubTotalPaidToProvider(subTotalPaidToProvider);
        epsClaimsResponseUI.setSubTotalAdjustmentReasonCode(subTotalAdjustmentReasonCode);
        epsClaimsResponseUI.setSubTotalRMKCode(subTotalRMKCode);
        epsClaimsResponseUI.setSubTotalPatientResponse(subTotalPatientResponse);

        epsClaimsResponseUI.setDatesOfservices(datesOfservices);
        epsClaimsResponseUI.setDescriptionOfservicwes(descriptionOfservicwes);
        epsClaimsResponseUI.setAmountCharged(amountCharged);
        epsClaimsResponseUI.setClaimOrserviceAdj(claimOrserviceAdj);
        epsClaimsResponseUI.setProviderAdjDiscount(providerAdjDiscount);
        epsClaimsResponseUI.setAmountAllowed(amountAllowed);
        epsClaimsResponseUI.setDeductCoinsCopay(deductCoinsCopay);
        epsClaimsResponseUI.setPaidtoProvider(paidtoProvider);
        epsClaimsResponseUI.setAdjustmentReasonCode(adjustmentReasonCode);
        epsClaimsResponseUI.setRmkCode(rmkCode);
        epsClaimsResponseUI.setPatientResponse(patientResponse);
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
	
	private String invokePostCall(String xmlRequest) throws IOException, SAXException, ParserConfigurationException, JAXBException {
        String response;
        int count = 0;
        do {
            Browser.wait(testConfig, 5);
            response = epsRemittanceDetailHelper.postRequestGetResponse(xmlRequest);
            Log.Comment("XML Response : \n" + response);
            count++;
        } while ((response.contains("code>005<") || response.contains("code>404<")) && count < 5);
        return response;
    }
	
	private void coreFISLvalidationWithUI(String response) throws JAXBException {
        EpsClaimsResponse epsClaimsResponse = epsRemittanceDetailHelper.convertXMLStringToPOJO(response);

        int uiCounter=0;
        if (epsClaimsResponse.getResponseReturnStatus().getResponseReturnCode().getCode().equals("200")) {
            int claimSize = epsClaimsResponse.getEpsClaims().size();
            for (int i = 0; i < claimSize; i++) {
                accountNumberValidation(epsClaimsResponse, i);
                patientNamesAndPatientIdValidation(epsClaimsResponse, i);
                subscriberIdValidation(epsClaimsResponse, i);
                claimsAndClaimsTypeValidations(epsClaimsResponse, i);
                groupPolicyNumbersAndProductNamesValidation(epsClaimsResponse, i);
                subTotalAmountChargedValidation(epsClaimsResponse, i);
                subTotalPaidToProviderValidation(epsClaimsResponse, i);
                int claimServicesSize = epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().size();
                for (int j = 0; j < claimServicesSize; j++) {
                    serviceStartAndEndDatesValidation(epsClaimsResponse, uiCounter, i, j);
                    serviceDescriptionValidation(epsClaimsResponse, uiCounter, i, j);
                    amountChargedValidation(epsClaimsResponse, uiCounter, i, j);
                    amountAllowedValidation(epsClaimsResponse, uiCounter, i, j);
                    paidToProviderValidation(epsClaimsResponse, uiCounter, i, j);
                    adjustmentReasonCodesValidation(epsClaimsResponse, i, j);
                    uiCounter++;
                }
            }

        } else {
            Log.Comment("Error response from FISL : \n" + epsRemittanceDetailHelper.getRemittanceDetailResponse());
        }
    }
	
	private void accountNumberValidation(EpsClaimsResponse epsClaimsResponse, int i) {
        Helper.compareEquals(testConfig, "Account Number Validation :", epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getAccountNumber(),
                epsClaimsResponseUI.getAccountNumbers().get(i));
    }
	
	private void patientNamesAndPatientIdValidation(EpsClaimsResponse epsClaimsResponse, int i) {

        String fullNameFisl = getFullName(epsClaimsResponse, i);
        String patientNamesAndIds = epsClaimsResponseUI.getPatientNamesAndPatientIds().get(i);
        String fullNameUI = patientNamesAndIds.split("/")[0];
        String patientID = removeNewLines(patientNamesAndIds.split("/")[1]);

        Helper.compareEquals(testConfig, "Patient Name Validation", fullNameFisl, fullNameUI);
        Helper.compareEquals(testConfig, "Patient ID validation", epsClaimsResponse.getEpsClaims().get(i).getEpsPatient().getEpsPatientIdentifier(), patientID);
    }
	
	private String getFullName(EpsClaimsResponse epsClaimsResponse, int i) {
        String fullName = "";
        if(!epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getPersonName().getFirstName().equals(""))
            fullName = epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getPersonName().getFirstName()+" ";
        if(!epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getPersonName().getMiddleName().equals(""))
            fullName = fullName+epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getPersonName().getMiddleName()+" ";
        if(!epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getPersonName().getLastName().equals(""))
            fullName = fullName+epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getPersonName().getLastName();
        return fullName;
    }
	
	private void subscriberIdValidation(EpsClaimsResponse epsClaimsResponse, int i) {
        if(epsClaimsResponseUI.getSubscriberIdsAndCorrectedIds().get(i).contains("/")){
            Helper.compareEquals(testConfig, "SubscriberIds and corrected Ids ", epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getSubscriberIdentifier(),
                    epsClaimsResponseUI.getSubscriberIdsAndCorrectedIds().get(i).split("/")[0]);
        }else {
            Helper.compareEquals(testConfig, "SubscriberIds and corrected Ids ", epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getSubscriberIdentifier(),
                    epsClaimsResponseUI.getSubscriberIdsAndCorrectedIds().get(i));
        }
    }
	
	private void claimsAndClaimsTypeValidations(EpsClaimsResponse epsClaimsResponse, int i) {
        String claimIdentifierUI = "";
        if(epsClaimsResponseUI.getClaimsAndClaimsTypes().get(i).contains("\n")){
            claimIdentifierUI = epsClaimsResponseUI.getClaimsAndClaimsTypes().get(i).split("\n")[0];
        }else{
            claimIdentifierUI = epsClaimsResponseUI.getClaimsAndClaimsTypes().get(i);
        }
        Helper.compareEquals(testConfig, "Claim Identifier", epsClaimsResponse.getEpsClaims().get(i).getClaimIdentifier(), claimIdentifierUI);
    }
	
	private void groupPolicyNumbersAndProductNamesValidation(EpsClaimsResponse epsClaimsResponse, int i) {
        String policyNumber = removeNewLines(epsClaimsResponseUI.getGroupPolicyNumbersAndProductNames().get(i)).split("/")[0];
        if(epsClaimsResponseUI.getGroupPolicyNumbersAndProductNames().get(i).contains(epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getGroupThumbnail().getGroupIdentifier())){
            Helper.compareEquals(testConfig, "group identifier validation", epsClaimsResponse.getEpsClaims().get(i).getEpsSubscriber().getGroupThumbnail().getGroupIdentifier(),
                    policyNumber);
        }
    }
	
	private String removeNewLines(String s) {
        if(s.contains("\n")){
            s = s.replace("\n", "");
        }
        return s;
    }
	
	private void subTotalAmountChargedValidation(EpsClaimsResponse epsClaimsResponse, int i) {
        Helper.compareEquals(testConfig, "Sub Total Amount Charged", epsClaimsResponse.getEpsClaims().get(i).getChargedAmount(),
                formatAmount(epsClaimsResponseUI.getSubTotalAmountsCharged().get(i)));
    }
	
	private String formatAmount(String s) {
        if(s.contains("$")){
            s = s.replace("$", "");
        }
        if(s.contains(",")){
            s = s.replace(",", "");
        }
        if(s.contains(".00")){
            s = s.replace(".00", ".0");
        }else if(s.contains(".")){
            s = s.contains(".") ? s.replaceAll("0*$","").replaceAll("\\.$","") : s;
        }
        if(s.contains("--")){
            s = s.replace("--", "");
        }
        return s;
    }
	
	private void subTotalPaidToProviderValidation(EpsClaimsResponse epsClaimsResponse, int i) {
        Helper.compareEquals(testConfig, "Sub Total Paid to provider", epsClaimsResponse.getEpsClaims().get(i).getClaimPayAmount(),
                formatAmount(epsClaimsResponseUI.getSubTotalPaidToProvider().get(i)));
    }
	
	private void serviceStartAndEndDatesValidation(EpsClaimsResponse epsClaimsResponse, int uiCounter, int i, int j) {
        Helper.compareEquals(testConfig, "Start Date and End date validation ",
                formatDate(epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getServiceStartDate())+" - "+
                        formatDate(epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getServiceEndDate()),
                epsClaimsResponseUI.getDatesOfservices().get(uiCounter));
    }
	
	private String formatDate(String date) {
        String[] split = date.split("-");
        return split[1]+"/"+split[2]+"/"+split[0];
    }
	
	private void serviceDescriptionValidation(EpsClaimsResponse epsClaimsResponse, int uiCounter, int i, int j) {
        Helper.compareEquals(testConfig, "Service Description ", epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsServiceDescription(),
                epsClaimsResponseUI.getDescriptionOfservicwes().get(uiCounter));
    }
	
	private void amountChargedValidation(EpsClaimsResponse epsClaimsResponse, int uiCounter, int i, int j) {
        Helper.compareEquals(testConfig, "Amount Charged", epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getLineItemChargeAmount(),
                formatAmount(epsClaimsResponseUI.getAmountCharged().get(uiCounter)));
    }
	
	private void amountAllowedValidation(EpsClaimsResponse epsClaimsResponse, int uiCounter, int i, int j) {
        Helper.compareEquals(testConfig, "Amount Allowed", epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getAllowedAmount(),
                formatAmount(epsClaimsResponseUI.getAmountAllowed().get(uiCounter)));
    }
	
	private void paidToProviderValidation(EpsClaimsResponse epsClaimsResponse, int uiCounter, int i, int j) {
        Helper.compareEquals(testConfig, "Paid To Provider", epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getLineItemPaidAmount(),
                formatAmount2(epsClaimsResponseUI.getPaidtoProvider().get(uiCounter)));
    }
	
	private String formatAmount2(String s) {
        if(s.contains("$")){
            s = s.replace("$", "");
        }
        if(s.contains(",")){
            s = s.replace(",", "");
        }
        if(s.contains(".00")){
            s = s.replace(".00", ".0");
        }else if(s.contains(".")){
            s = s.contains(".") ? s.replaceAll("0*$","").replaceAll("\\.$","") : s;
        }
        if(s.contains("--")){
            s = s.replace("--", "0.0");
        }
        return s;
    }
	
	private void adjustmentReasonCodesValidation(EpsClaimsResponse epsClaimsResponse, int i, int j) {
        String pageSource = testConfig.getDriver().getPageSource();
        if(pageSource.contains(epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().getEpsClaimPaymentAdjustmentReasonCodes().getCode())){
            Helper.compareEquals(testConfig, "Adjustment Reason Code Validation ", epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().getEpsClaimPaymentAdjustmentReasonCodes().getCode(),
                    epsClaimsResponse.getEpsClaims().get(i).getEpsClaimServices().get(j).getEpsClaimPaymentServiceAdjustments().getEpsClaimPaymentAdjustmentReasonCodes().getCode());
        }
    }
	
	public void validatePLBAdj() throws Exception {
        try {
            Boolean adjCodePLBUI = adjCodePLB.isDisplayed();
            Helper.compareEquals(testConfig, "Adj Reason Code Header is Present for PLB", true, adjCodePLBUI);

            Boolean refCodePLBUI = refCodePLB.isDisplayed();
            Helper.compareEquals(testConfig, "Reference # Header is Present for PLB", true, refCodePLBUI);

            Boolean amntPLBHeaderUI = amntPLBHeader.isDisplayed();
            Helper.compareEquals(testConfig, "Amount Header is Present for PLB", true, amntPLBHeaderUI);

            List<WebElement> list = testConfig.driver.findElements(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table/tbody/tr"));

            int size = list.size();
            Log.Comment("Size of PLB List is :" + size);
            List<String> plb_UI = new ArrayList<>();

            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= 3; j++) {
                    String sText = testConfig.driver.findElement(By.xpath("//div[@id='onlyplb']/table/tbody/tr/td/table/tbody/tr/td/div[@id='flow1']/table/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                    if (sText.contains("$")) {
                        sText = sText.replace("$", "").trim();
                        if (sText.contains("-")) {
                            sText = sText.replace("-", "").trim();
                        }
                        if (sText.contains(",")) {
                            sText = sText.replace(",", "").trim();
                        }
                        if (sText.contains(".00")) {
                            sText = sText.replace(".00", ".0").trim();
                        }
                    }

                    plb_UI.add(sText.trim());
                }
            }

            Collections.sort(plb_UI);
            Log.Comment("The Multiple PLB Adjustment Data from UI is" + plb_UI);

            ArrayList<String> plb_DB = new ArrayList<String>();
            HashMap<Integer, HashMap<String, String>> plb_DB1 = DataBase.executeSelectQueryALL(testConfig, QUERY.GET_PLB_DATA_FROM_DB);
            for (int i = 1; i <= plb_DB1.size(); i++) {
                plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_RSN_CD"));
                plb_DB.add(plb_DB1.get(i).get("PROV_ADJ_ID"));
                plb_DB.add(String.valueOf(Math.abs(Double.parseDouble(plb_DB1.get(i).get("PROV_PAYR_ADJ_AMT")))));
            }

            Collections.sort(plb_DB);
            Log.Comment("The Multiple PLB Adjustment Data from DB is :" + plb_DB);

            Helper.compareEquals(testConfig, "The Multiple PLB Adjustment Data from DB", plb_DB, plb_UI);
        }catch(Throwable throwable){
            Helper.compareEquals(testConfig, "PLB Table Not found", false, false);
        }

    }
	
	public void enterTINForCheckNumber(){
        Map<String, String> data = DataBase.executeSelectQuery(testConfig, QUERY.GET_CHECK_NUMBER_AND_TIN, 1);
        String prov_TAX_ID_NBR = data.get("PROV_TAX_ID_NBR").trim();
        String checkNBR = data.get("CHECK_NBR").trim();
        Log.Comment("The PROV_TIN_NBR is :" + prov_TAX_ID_NBR);
        Log.Comment("The Check Number is :" + checkNBR);
        testConfig.putRunTimeProperty("tin", prov_TAX_ID_NBR);
        testConfig.putRunTimeProperty("checkNumber", checkNBR);
        Element.click(enterTIN, "Enter TIN");
        Element.enterData(enterTIN, prov_TAX_ID_NBR, "Enter tin number as " + prov_TAX_ID_NBR, "tinNumber");
        Element.click(searchBtn, "Search");
    }
}