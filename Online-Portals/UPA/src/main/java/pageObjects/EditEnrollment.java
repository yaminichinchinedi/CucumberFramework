package main.java.pageObjects;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class EditEnrollment {
	
	
	@FindBy(id="tabmenu")
	WebElement tabsMenu;
	
	@FindBy(name="orgName")
	WebElement txtBoxOrgName;
	
	@FindBy(name="orgAddress")
	WebElement txtBoxOrgAddr;
	
	@FindBy(name="orgCity")
	WebElement txtBoxOrgCity;
	
	@FindBy(name="orgState")
	WebElement drpDwnOrgState;
	
	@FindBy(name="orgZip1")
	WebElement txtBoxorgZip1;
	
	@FindBy(name="orgZip2")
	WebElement txtBoxorgZip2;
	
	@FindBy(name="provType")
	List <WebElement> rdoProvTypes;
	
	@FindBy(name="selectedItems")
	List <WebElement> marketTypes;
	
	@FindBy(xpath="//b[contains(text(),'TIN:')]")
	WebElement txtTinNo;
	
	@FindBy(xpath="//td[contains(text(),'Enrollment ID:')]//following-sibling::td")
	WebElement txtEnrollmentID;
	
	@FindBy(xpath="//td[contains(text(),'Enrollment Date:')]//following-sibling::td")
	WebElement enrollmentDate;
	
	@FindBy(xpath="//td[contains(text(),'Enrollment Status:')]//following-sibling::td")
	WebElement enrollmentStatus;
	
	@FindBy(xpath="//td[contains(text(),'Are you sure you want to cancel')]")
	WebElement txtCancel;
	
	
	@FindBy(xpath="//td[contains(text(),'You have elected to change Payment Method(s) for the following Payer(s)')]")
	WebElement txtChangePayment;
	
	@FindBy(name="Yes")
	WebElement btnYes;
	
	@FindBy(name="No")
	WebElement btnNo;
	
	@FindBy(id="tinLevelInfoMsgBlock")
	WebElement tinLevelBlock;
	
	@FindBy(id="payerLevelInfoMsgBlock")
	WebElement payerLevelBlock;
	
	@FindBy(id="npiLevelInfoMsgBlock")
	WebElement npiLevelBlock;
	

	
	@FindBy(xpath="//input[@value=' Yes ']")
	WebElement btnYes1;
	
	@FindBy(xpath="//input[@value=' No ']")
	WebElement btnNo1;
	
	@FindBy(xpath="//input[@value='Cancel']")
	WebElement btnCancel;
	
	@FindBy(xpath="//input[contains(@value,'Continue')]")
	WebElement btnContinue;
	
	@FindBy(id="resetButton")
	WebElement btnReset;
	
	@FindBy(id="updateButton")
	WebElement btnUpdate;
	
	
	
	@FindBy(xpath="//form[@name='enrollmentForm']//table//tr[@class='subheadernormal']//tr")
	List<WebElement> payerTable;
	
	
	@FindBy(xpath="//form[@name='enrollmentForm']//table//tr")
	List<WebElement> payerTableOnMethChange;
	
	
	@FindBy(name="bankName")
	WebElement txtBankName;
	
	@FindBy(name="bankRoutTranNumber")
	WebElement txtRoutingNo;
	
	@FindBy(name="bankAddress")
	WebElement txtBankAdr;
	
	@FindBy(name="bankAccNumber")
	WebElement txtAccNo;
	
	@FindBy(xpath="//td[contains(text(),'Account Type:')]//following-sibling::td")
	WebElement txtAccType;
	
	@FindBy(name="bankCity")
	WebElement txtBankCity;
	
	@FindBy(name="bankState")
	WebElement drpDwnBankState;
	
	@FindBy(name="bankZip1")
	WebElement txtZip1;
	
	@FindBy(name="bankZip2")
	WebElement txtZip2;
	
	@FindBy(name="bankPhoneNumber1")
	WebElement txtPhNo1;
	
	@FindBy(name="bankPhoneNumber2")
	WebElement txtPhNo2;
	
	@FindBy(name="bankPhoneNumber3")
	WebElement txtPhNo3;
	
	@FindBy(name="achType")
	WebElement drpDwnRecordType;
	
	@FindBy(partialLinkText="View Bank Letter")
	WebElement lnkViewBankLetter;
	
	@FindBy(xpath="//input[@value='VC']")
	WebElement rdoVoidedChk;
	
	@FindBy(xpath="//input[@value='BL']")
	WebElement rdoBankLetter;
	
	@FindBy(name="msgFile")
	WebElement btnChooseFile;
	
	@FindBy(xpath="//input[@value='Change Banking Data']")
	WebElement btnChngBankData;
	
	
	@FindBy(xpath="//td[contains(text(),'Update Bank Account')]")
	WebElement txtUpdateBankAcc;
	
	
	@FindBy(name="usrInfoUName")
	WebElement txtBoxUserName;
	
	
	@FindBy(name="usrInfoFName")
	WebElement txtBoxFName;
	
	@FindBy(name="usrInfoLName")
	WebElement txtBoxLName;
	
	@FindBy(name="usrInfoTitle")
	WebElement txtBoxTitle;
	
	@FindBy(name="usrInfoPhoneNum1")
	WebElement txtBoxPhoneNum1;
	
	@FindBy(name="usrInfoPhoneNum2")
	WebElement txtBoxPhoneNum2;
	
	@FindBy(name="usrInfoPhoneNum3")
	WebElement txtBoxPhoneNum3;
	
	@FindBy(name="usrInfoEmailAddr")
	WebElement txtBoxEmail;
	
	@FindBy(name="usrInfoReTypEmailAddr")
	WebElement txtBoxVerifyEmail;
	
	@FindBy(id="tinLevelUpdateButton")
	WebElement btnUpdateBankAcc;
	
	@FindBy(id="tinLevelResetButton")
	WebElement btnResetBankDetails;
	
	@FindBy(xpath="//td[@class='Tableheader1bold'][contains(text(),'Payer')]")
	WebElement payerPatientBankingInformationHeader;
	

	@FindBy(xpath="	//td[contains(text(),'Select Payer')]")
	WebElement selectPayerPatientdropdowntitle;
	
	
	@FindBy(name="bankAccountTO.payerTinNbr")
	WebElement drpDwnSelectPayerPatient;
	
	@FindBy(xpath="//th[@class='Tableheader4bold'][contains(text(),'Payer/Patient')]")
	WebElement bankingInformationHeader;
	
	@FindBy(id="payerPayerId")
	WebElement drpDwnPayerPatient;
	
	
	@FindBy(name="payerBankAccount.bnkNm")
	WebElement txtPayerBankAccName;
	
	@FindBy(id="payerCtyNmId")
	WebElement txtPayerBankAccCity;
	
	
	@FindBy(name="payerBankAccount.adrTxt")
	WebElement txtPayerBankAccAdr;
	
	
	@FindBy(id="payerStNmId")
	WebElement drpDwnPayerState;
	
	
	@FindBy(name="payerBankAccount.zipCd1")
	WebElement txtBankPayerZip1;
	
	@FindBy(name="payerBankAccount.zipCd2")
	WebElement txtBankPayerZip2;
	
	@FindBy(id="payerPhoneNumber1Id")
	WebElement txtBankPayerPh1;
	
	@FindBy(id="payerPhoneNumber2Id")
	WebElement txtBankPayerPh2;
	
	@FindBy(id="payerPhoneNumber3Id")
	WebElement txtBankPayerPh3;
	
	
	@FindBy(id="payerRteTrnsNbrId")
	WebElement txtBankRoutingNo;
	
	@FindBy(name="payerBankAccount.bnkAcctNbr")
	WebElement txtBankPayerAccNo;
	
	@FindBy(name="payerBankAccount.selectedBnkAccType")
	List <WebElement> rdoChkSavings;
	
	@FindBy(name="npiBankAccount.selectedBnkAccType")
	List <WebElement> rdoNPIAccountType;
	
//	@FindBy(id="payerAchTypeId")
//	WebElement drpDwnBankPayerRecordType;
//	
//	@FindBy(id="payerBankAccountId")
//	WebElement drpDwnBankPayerRecordType;
//	
	
	@FindBy(name="payerUploadDocType")
	List <WebElement> rdoLetterType;
	
	@FindBy(id="flow")
	WebElement divPayerBankInfo;
	
	
	@FindBy(id="npiPayerTinNbrId")
	WebElement drpDwnSelectNPIBankAccPayer;
	
	
	
	@FindBy(id="npiNbrId")
	WebElement drpDwnSelectNPI;
	
	@FindBy(id="npiBnkNmId")
	WebElement txtBoxNPIBankNm;
	
	@FindBy(id="npiAdrTxtId")
	WebElement txtBoxNPIBankAdr;
	
	
	@FindBy(id="npiCtyNmId")
	WebElement txtBoxNPIBankCity;
	
	@FindBy(id="npiStNmId")
	WebElement drpDwnNPIBankState;
	
	@FindBy(id="npiZipCd1Id")
	WebElement txtBoxNPIZIP1;
	
	@FindBy(id="npiZipCd2Id")
	WebElement txtBoxNPIZIP2;
	
	@FindBy(id="npiPhoneNumber1Id")
	WebElement txtBoxNPIPhNo1;
	
	
	@FindBy(id="npiPhoneNumber2Id")
	WebElement txtBoxNPIPhNo2;
	
	@FindBy(id="npiPhoneNumber3Id")
	WebElement txtBoxNPIPhNo3;
	
	@FindBy(id="npiBankAccountIdID")
	WebElement drpDwnExistingBankAccID;
	
	
	@FindBy(id="npiRteTrnsNbrId")
	WebElement txtBoxNPIRoutingTransitNo;
	
	@FindBy(id="npiBnkAcctNbrId")
	WebElement txtBoxNPIBankAccNo;
	
	
	@FindBy(name="npiBankAccount.selectedBnkAccType")
	List <WebElement> rdoAccountType;
	
	@FindBy(id="npiAchTypeId")
	WebElement drpDwnNPIRecordType;
	
	@FindBy(name="npiLevelDocType")
	List <WebElement> rdoDocType;
	
	@FindBy(xpath="//td[contains(text(),'Click on NPI Payer link ')]//parent::tr//following-sibling::tr//div[@id='flow']//tr")
	List <WebElement> NPItable;
	
	@FindBy(id="addNpiBnkAcctId")
	WebElement btnAddNPIAccount;
	
	@FindBy(id="clearNPIBankAccountId")
	WebElement btnClearAllFieldsNPI;
	
	@FindBy(id="npifileupload")
	WebElement btnNPIChooseFile;
	
	@FindBy(id="pendingw9")
	WebElement btnNPIPendingW9;
	
	@FindBy(name="btnYes")
	WebElement btnYesForW9;
	
	@FindBy(name="btnNo")
	WebElement btnNoForW9;
	
	@FindBy(xpath="//input[@value='Finish']")
	WebElement btnFinish;
	
	@FindBy(xpath="//td[contains(text(),'Patient Payment')]")
	WebElement payerName;
	
	@FindBy(xpath="//td[contains(text(),'HM801')]")
	WebElement payerId;
	
	
	
	
	
	
	
	
	
			
	
	protected TestBase testConfig;
	static final String firstNameTxt=Helper.generateRandomAlphabetsString(3);
	String phNo = Long.toString(Helper.generateRandomNumber(3));
	String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
	String userEmailAdr=Helper.getUniqueEmailId();
	

	public EditEnrollment(TestBase testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.fluentWait(testConfig, tabsMenu.findElements(By.tagName("li")).get(0), 200, 3, "organization tab");
		Browser.verifyURL(testConfig, "/editEnrollment.do");
		
	}
	
	public EditEnrollment()
	{
		
	}
	
	public EditEnrollment verifyTabsAreDisplayed()
	{
		Element.verifyElementPresent(tabsMenu.findElements(By.tagName("li")).get(0), "Organization tab");
		Element.verifyElementPresent(tabsMenu.findElements(By.tagName("li")).get(1), "Payer (s) tab");
		Element.verifyElementPresent(tabsMenu.findElements(By.tagName("li")).get(2), "Bank Accont (s) tab");
		return this;
	}


	public EditEnrollment verifyOrgInfo() throws ParseException, IOException
	{
		 int sqlRowNo=1;
          
		// Verifies count of records displayed in view payments tab from DB
		Map portalUserTable = DataBase.executeSelectQuery(testConfig, sqlRowNo,1);
		
		String orgAddressFromDB=portalUserTable.get("ADR_TXT").toString().trim().replaceAll("\\s", "");
		String orgAddrFromUI=txtBoxOrgAddr.getAttribute("value").trim().replaceAll("\\s", "");
		
		
		Helper.compareEquals(testConfig, "Organization Name", portalUserTable.get("ORG_NM").toString().trim(), txtBoxOrgName.getAttribute("value").trim());
		Helper.compareEquals(testConfig, "Organization Address", orgAddressFromDB,orgAddrFromUI);
		Helper.compareEquals(testConfig, "Organization City", portalUserTable.get("CTY_NM").toString().trim(),txtBoxOrgCity.getAttribute("value").trim());
		Helper.compareEquals(testConfig, "Organization State", portalUserTable.get("ST_NM").toString().trim(),Element.getFirstSelectedOption(testConfig, drpDwnOrgState, "text"));
		Helper.compareEquals(testConfig, "ZIP Code", portalUserTable.get("ZIP_CD").toString().trim(),txtBoxorgZip1.getAttribute("value").trim()+txtBoxorgZip2.getAttribute("value").trim());
		Helper.compareEquals(testConfig, "Tin number","TIN: " + testConfig.getRunTimeProperty("tin").toString(), txtTinNo.getText().trim());
		Helper.compareEquals(testConfig, "Enrollment ID", portalUserTable.get("ENRL_ID_NBR").toString().trim(), txtEnrollmentID.getText().trim());
		Helper.compareContains(testConfig, "Date of Enrollment",Helper.changeDateFormat(enrollmentDate.getText().toString(), "mm/dd/yyyy", "yyyy-mm-dd"),portalUserTable.get("ENRL_DTTM").toString().trim());
		Helper.compareEquals(testConfig, "Enrollment Status",portalUserTable.get("ENRL_STS_CD").toString().trim(),enrollmentStatus.getText().substring(0,1).trim());
		
		verifyProvAndMktRadioBoxes();
		return this;
		
	}
	
	
	public void verifyProvAndMktRadioBoxes() throws IOException
	{
		ArrayList<String> expectedMktTypes=new ArrayList<String>();
		HashMap<Integer, HashMap<String, String>>mktTypeTbl = DataBase.executeSelectQueryALL(testConfig,243);
		HashMap<Integer, HashMap<String, String>>provTbl = DataBase.executeSelectQueryALL(testConfig,244);
		
		String actual=testConfig.driver.findElement(By.xpath("//td[contains(text(),'Provider Type:')]//following-sibling::td")).getText();
		actual=actual.replace("\n", " ").replace(",", "").replace("[", "").replace("]", "").replace("  ", " ");
		
		 for (int i = 1; i <= mktTypeTbl.size(); i++) 
			 expectedMktTypes.add(mktTypeTbl.get(i).get("MKT_TYP_DESC").toString());
		
		 for (int i = 1; i <= provTbl.size(); i++) 
			 expectedMktTypes.add(provTbl.get(i).get("MKT_TYP_DESC").toString());
		 
		  String expectedMktTyp=expectedMktTypes.toString().replace(",", "").replace("[", "").replace("]", "").replace("", "");
		 Helper.compareContains(testConfig, "Prov and market types",expectedMktTyp, actual);
		
     }
	
	public UPAHomePage clickandVerifyCancelFunc()
	{
		String expectedText="Are you sure you want to cancel your EPS Enrollment Update?" + '\n' + "If you select 'Yes', your EPS Enrollment changes will" ;
		
		Element.click(btnCancel, "Cancel button");
		Browser.verifyURL(testConfig, "/cancel.do");
		Element.verifyTextPresent(txtCancel, expectedText);
		Element.verifyElementPresent(btnYes, "YES button");
		Element.verifyElementPresent(btnNo, "No button");
		Element.click(btnNo, "No button");
		Browser.verifyURL(testConfig, "cancel.portal");
		Element.verifyElementPresent(txtBoxOrgName, "Org name");
		Element.click(btnCancel, "Cancel button");
		Element.click(btnYes, "Yes button");
		return new UPAHomePage(testConfig);
	}
	
	public EditEnrollment clickContinue()
	{  
		Element.click(btnContinue, "continue button");
		Browser.verifyURL(testConfig, "validateOrgDetails.do");
  		Helper.compareEquals(testConfig, "Payers tab class", "activeclass", tabsMenu.findElements(By.tagName("li")).get(1).getAttribute("class"));
  		return this;
		
	}
	
	public EditEnrollment clickContinueBank()
	{  
		Element.click(btnContinue, "continue button");
		Browser.verifyURL(testConfig, "/updateProviderBankingDetails.do");
		return this;
	}
	
	
	public void verifyPayerTable() throws IOException 
	{
       
		String payMethod_UI=null; ;
		int sqlRow=245;
		HashMap<Integer, HashMap<String,String>> payerGridInfoDB=DataBase.executeSelectQueryALL(testConfig, sqlRow);
		int drpdwnEnabled=0;
		
		Element.verifyElementPresent(payerTable.get(0), "Payer table");
		Element.verifyTextPresent(payerTable.get(0).findElements(By.tagName("td")).get(0),"Payer Information");
		Element.verifyTextPresent(payerTable.get(0).findElements(By.tagName("td")).get(1),"Payment Method");
		Element.verifyTextPresent(payerTable.get(1).findElements(By.tagName("td")).get(0),"Payer Name");
		Element.verifyTextPresent(payerTable.get(1).findElements(By.tagName("td")).get(1),"Payer Id");
		Element.verifyTextPresent(payerTable.get(1).findElements(By.tagName("td")).get(2),"Payer Offers");
		
		for(int i=2,j=i-1;i<payerTable.size()-2;i++)
		{ 
			
			if(payerGridInfoDB.get(j).get("PAYR_DSPL_NM").toString().equals("UMR"))
				Helper.compareEquals(testConfig, "Payer Name", "*UMR",payerTable.get(i).findElements(By.tagName("td")).get(0).getText());
			else
			Helper.compareEquals(testConfig, "Payer Name", payerGridInfoDB.get(j).get("PAYR_DSPL_NM").toString(),payerTable.get(i).findElements(By.tagName("td")).get(0).getText());
			Helper.compareEquals(testConfig, "Payer ID", payerGridInfoDB.get(j).get("PAYR_835_ID").toString().trim(),payerTable.get(i).findElements(By.tagName("td")).get(1).getText());
			Helper.compareEquals(testConfig, "Payer Offers", getDisplayPayOfrCode(payerGridInfoDB.get(j).get("PAY_METH_OFR_CD").toString()),payerTable.get(i).findElements(By.tagName("td")).get(2).getText());
			
			
			if(payerTable.get(i).findElements(By.tagName("td")).get(2).getText().equalsIgnoreCase("ACH"))
				payMethod_UI=getDisplayMethodCode(payerGridInfoDB.get(j).get("PAY_METH_CD").toString()) +"-"+ "None";
			
			else if(payerTable.get(i).findElements(By.tagName("td")).get(2).getText().equalsIgnoreCase("ACH/VCP"))
			{
				if(getDisplayMethodCode(payerGridInfoDB.get(j).get("PAY_METH_CD").toString()).equals("ACH"))
				payMethod_UI=getDisplayMethodCode(payerGridInfoDB.get(j).get("PAY_METH_CD").toString()) +"-"+"VCP-None";
				else
					payMethod_UI=getDisplayMethodCode(payerGridInfoDB.get(j).get("PAY_METH_CD").toString()) +"-"+"ACH-None";
			}
			else if(payerTable.get(i).findElements(By.tagName("td")).get(2).getText().equalsIgnoreCase("VCP"))
				payMethod_UI=getDisplayMethodCode(payerGridInfoDB.get(j).get("PAY_METH_CD").toString()) +"-"+ "None";

            Helper.compareEquals(testConfig, "Payer Method dropdown Values", payMethod_UI,payerTable.get(i).findElements(By.tagName("td")).get(3).getText().replaceAll("\n", "-").replaceAll("\\s","").replace("--","-"));
        
    		Map  selectDrpdwn=Element.getAllAttributes(testConfig, payerTable.get(i).findElements(By.tagName("td")).get(3).findElement(By.tagName("select")), "Paymenth method for " + payerTable.get(i).findElements(By.tagName("td")).get(3).getText());
             if(!selectDrpdwn.containsKey("disabled"))
            	 drpdwnEnabled=i;
            	
            j++;
		}
		
		//Reset and update button are disabled
		Helper.compareEquals(testConfig, "Disabled attribute of reset button", "true", btnReset.getAttribute("disabled").toString());
		Helper.compareEquals(testConfig, "Disabled attribute of Update button", "true", btnUpdate.getAttribute("disabled").toString());
		
		//changing payment method
		String oldPayMeth=Element.getFirstSelectedOption(testConfig, payerTable.get(drpdwnEnabled).findElements(By.tagName("td")).get(3).findElement(By.tagName("select")), "value");
       
		Element.selectByIndex(payerTable.get(drpdwnEnabled).findElements(By.tagName("td")).get(3).findElement(By.tagName("select")), 1, "Selecting payer method as "+payerTable.get(drpdwnEnabled).findElements(By.tagName("td")).get(0).getText());
    	
        String newPayMeth=Element.getFirstSelectedOption(testConfig, payerTable.get(drpdwnEnabled).findElements(By.tagName("td")).get(3).findElement(By.tagName("select")), "value");
		String payerName=payerTable.get(drpdwnEnabled).findElements(By.tagName("td")).get(0).getText();
        clickUpdatePaymentMethod().verifyPayerOnPaymentChange(payerName, oldPayMeth, newPayMeth,drpdwnEnabled);
        
       
	}
		
	public EditEnrollment clickUpdatePaymentMethod()
	{
		Element.click(btnUpdate, "Update button");
		Browser.verifyURL(testConfig, "maintainPayerPaymentMethods.portal");
		Element.verifyTextPresent(payerTableOnMethChange.get(1).findElement(By.tagName("td")),"You have elected to change Payment Method(s) for the following Payer(s)");
      	Element.verifyElementPresent(btnYes1, "Yes button");
      	Element.verifyElementPresent(btnNo1, "No button");

      	return this;
	}
	
	public EditEnrollment verifyPayerOnPaymentChange(String expectedPayer,String oldPayMeth,String newPayMeth, int payerRowNo)
	{
		//Change payment method page
		
		Element.verifyTextPresent(payerTableOnMethChange.get(2).findElements(By.tagName("table")).get(2).findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).get(0),expectedPayer);
		Element.verifyTextPresent(payerTableOnMethChange.get(2).findElements(By.tagName("table")).get(2).findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).get(1),oldPayMeth);
		Element.verifyTextPresent(payerTableOnMethChange.get(2).findElements(By.tagName("table")).get(2).findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).get(2),newPayMeth);
		Element.click(btnNo1, "No button");
		
		//Back on Payers Tab
		Helper.compareEquals(testConfig, "Payment Method", oldPayMeth,Element.getFirstSelectedOption(testConfig,payerTable.get(payerRowNo).findElements(By.tagName("td")).get(3).findElement(By.tagName("select")),"value"));
		
		Element.selectByVisibleText(payerTable.get(payerRowNo).findElements(By.tagName("td")).get(3).findElement(By.tagName("select")), newPayMeth, "selected " +newPayMeth);
		Element.click(btnUpdate, "Update button");
		Element.click(btnYes1, "Yes button");
		Helper.compareEquals(testConfig, "Payment Method", newPayMeth,Element.getFirstSelectedOption(testConfig,payerTable.get(payerRowNo).findElements(By.tagName("td")).get(3).findElement(By.tagName("select")),"value"));
		
		
		
		return this;
	}

	private String getDisplayMethodCode(String payMethod) {
		
		if(payMethod!=null)
			{ 
			 if(payMethod.equalsIgnoreCase("CHK"))
				 return "None";
			 else if(payMethod.equalsIgnoreCase("ACH"))
				 return "ACH";
			 else if(payMethod.equalsIgnoreCase("VCP"))
				 return "VCP";
			}
		return "None";
	}

	public String getDisplayPayOfrCode(String payMeth_OfrCode) {
		if(payMeth_OfrCode.equalsIgnoreCase("004")||payMeth_OfrCode.equalsIgnoreCase("006"))
		   return "ACH/VCP";
		else if(payMeth_OfrCode.equalsIgnoreCase("001")||payMeth_OfrCode.equalsIgnoreCase("002"))
			   return "ACH";
		else
			return payMeth_OfrCode;
	}
	
	
	public EditEnrollment clickBankAccountTab()
	{
		Element.click(tabsMenu.findElements(By.tagName("li")).get(2), "Bank Account(s) Tab");
		return this;
	}
	
	public EditEnrollment clickPayersTab()
	{
		Element.click(tabsMenu.findElements(By.tagName("li")).get(1), "Payer (s) tab");
		return this;
	}
	
	public EditEnrollment clickPayerPRATab()
	{
		Element.click(tabsMenu.findElements(By.tagName("li")).get(3), "Payer PPRA's Tab");
		return this;
	}
	
	public void verifyPayersPagePayerNameandId()
	{
  		Element.verifyTextPresent(payerName, "Patient Payment");
  		Element.verifyTextPresent(payerId, "HM801");
	}
	
	public void verifyPayerPRAPagePayerName()
	{
  		Element.verifyTextPresent(payerName, "Patient Payment");
	}
	
	public void verifyPayerPatientBankingHeader()
	{
		Helper.compareContains(testConfig, "Payer Patient Banking Header", "Payer/Patient Level Banking Information   (Designate separate bank accounts by Payer or for Patient payments)", payerPatientBankingInformationHeader.getText());
	}
	
	public void verifySelectPayerPatientdropdowntitle()
	{
  		Browser.scrollTillAnElement(testConfig, selectPayerPatientdropdowntitle, "Select Payer/Patient");
		Helper.compareContains(testConfig, "Select Payer Patient", "Select Payer/Patient: ", selectPayerPatientdropdowntitle.getText());
  		List<String> values = Element.getAllOptionsInSelect(testConfig, drpDwnSelectPayerPatient);
  		if (values.contains("Patient Payment"))
  			Log.Pass("Pass");
  		else
  			Log.Fail("Fail");
  		Element.verifyTextPresent(bankingInformationHeader, "Payer/Patient");
  		
	}
	
	public EditEnrollment verifyTinLevelBankInfo()
	{
	   int sqlRowNo=2;         
	   Map provBankingTbl = DataBase.executeSelectQuery(testConfig, sqlRowNo,1);

	   Helper.compareEquals(testConfig, "Bank Name", provBankingTbl.get("BNK_NM").toString().trim(), txtBankName.getAttribute("value").trim());
	   Helper.compareEquals(testConfig, "Bank Address",provBankingTbl.get("ADR_TXT").toString().trim(),txtBankAdr.getAttribute("value").trim());
	   Helper.compareEquals(testConfig, "Bank City", provBankingTbl.get("CTY_NM").toString().trim(),txtBankCity.getAttribute("value").trim());
	   Helper.compareEquals(testConfig, "Bank State", provBankingTbl.get("ST_NM").toString().trim(),Element.getFirstSelectedOption(testConfig, drpDwnBankState, "text"));
	   Helper.compareEquals(testConfig, "ZIP CODE",provBankingTbl.get("ZIP_CD").toString().trim(),txtZip1.getAttribute("value").trim()+txtZip2.getAttribute("value").trim());
	   Helper.compareEquals(testConfig, "Routing transit No", provBankingTbl.get("RTE_TRNS_NBR").toString().trim(),txtRoutingNo.getAttribute("value").trim());
	   Helper.compareEquals(testConfig, "Account No", provBankingTbl.get("BNK_ACCT_NBR").toString().trim(),txtAccNo.getAttribute("value").trim());
	   Helper.compareEquals(testConfig, "Record Type", provBankingTbl.get("ACH_TYP_CD").toString().trim(),Element.getFirstSelectedOption(testConfig, drpDwnRecordType,"text"));
	   Helper.compareContains(testConfig, "Ph No",provBankingTbl.get("TEL_NBR").toString(),txtPhNo1.getAttribute("value").trim()+txtPhNo2.getAttribute("value").trim()+txtPhNo3.getAttribute("value").trim());
//	   Helper.compareEquals(testConfig, "Account Type",provBankingTbl.get("ACCT_TYP_ID"), txtAccType.getAttribute("value").trim());
	   Helper.compareEquals(testConfig, "Update button is disabled", "true", btnUpdateBankAcc.getAttribute("disabled"));	
	   Helper.compareEquals(testConfig, "Reset buttons is disabled", "true", btnResetBankDetails.getAttribute("disabled"));
			return this;
	}
	
	
	public EditEnrollment clickChangeBankData()
	{
		Element.click(btnChngBankData, "Change Banking Data");
		Browser.verifyURL(testConfig, "viewUserInfoBankAccts.do");
		Element.verifyElementPresent(txtBoxUserName, "User name textbox");
		Element.verifyElementPresent(txtUpdateBankAcc, "Update Bank account Info Header");
		return this;
		
	}
	
	public EditEnrollment fillDetails()
	{
		Element.enterData(txtBoxUserName, firstNameTxt+ Helper.getUniqueTinNumber(), "Enter Email address as:" + " " +userEmailAdr,"email");
        Element.enterData(txtBoxEmail, userEmailAdr, "Enter Email address as:" + " " +userEmailAdr,"email");
		Element.enterData(txtBoxVerifyEmail, userEmailAdr, "Re type email address as :" +" "+userEmailAdr ,"verifyEmail");
		Element.enterData(txtBoxFName, firstNameTxt, "Enter First Name as : " + firstNameTxt,"firstName");
		Element.enterData(txtBoxLName, firstNameTxt, "Enter Last Name as : " + firstNameTxt,"lastName");
	    Element.enterData(txtBoxPhoneNum1, phNo, "Enter Phone number in field 1 as:" + " "+phNo,"phoneNum");
		Element.enterData(txtBoxPhoneNum2, phNo, "Enter Phone number in field 2 as:" +" "+phNo,"phoneNum1");
		Element.enterData(txtBoxPhoneNum3, phNoLstField, "Enter Phone number in field 3 as:" + " "+phNoLstField ,"phoneNum2");
		Element.enterData(txtBoxTitle, "ms", "Enter title as : ms" ,"Title");
		return this;
	}
	
	public EditEnrollment updateBankName()
	{
		String initialBankName=txtBankName.getAttribute("value");
		Element.enterData(txtBankName,firstNameTxt ,"Enter name as : " +firstNameTxt, "Bank Name");
		Element.click(txtBankName, "bank name text box");
		Map attributes=Element.getAllAttributes(testConfig, btnUpdateBankAcc, "Update button");
		if(!attributes.containsKey("disabled"))
			Log.Pass("Update button is enabled now");
		else
			Log.Fail("Update button is disabled");
			
		attributes=Element.getAllAttributes(testConfig, btnResetBankDetails, "Update button");
		if(!attributes.containsKey("disabled"))
		  Log.Pass("Reset button is enabled now");
		else
		  Log.Fail("Reset button is disabled");
		Element.click(btnUpdateBankAcc, "Update button"); 
		
		Element.verifyTextPresent(testConfig.driver.findElement(By.xpath("//th[contains(text(),'Please correct the following fields')]")), "Please correct the following fields before submitting the EPS Online Enrollment form:");
		Element.verifyTextPresent(testConfig.driver.findElement(By.className("errors")), "Upload Document: Missing Data.");
		Element.click(btnResetBankDetails, "Reset button");
		Helper.compareEquals(testConfig, "Bank name is not updated as it is reset", initialBankName,txtBankName.getAttribute("value"));
		
		Element.enterData(txtBankName,firstNameTxt ,"Enter name as : " +firstNameTxt, "Bank Name");
		Element.click(rdoBankLetter, "Select bank letter");
		testConfig.driver.findElement(By.xpath("//form[@name='enrollmentForm']//table//tr//td//input[3]")).getText();
		
		Element.verifyElementPresent(btnChooseFile, "choose file");
		Element.enterData(btnChooseFile,System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"Entered path of pdf as : " + System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"),"choose btn");
		Element.click(btnUpdateBankAcc, "Update button");
		
		return this;
	}
	
	public void verifyNPILevelInfo() throws IOException
	{
       
		Helper.compareEquals(testConfig, "Default value is empty for NPI Payer dropdown", " ", Element.getFirstSelectedOption(testConfig,drpDwnSelectNPIBankAccPayer,"text"));
		Helper.compareEquals(testConfig, "Default value is empty for Select NPI  dropdown", " ", Element.getFirstSelectedOption(testConfig,drpDwnSelectNPI,"text"));
		Helper.compareEquals(testConfig, "NPI Bank Name", "", txtBoxNPIBankNm.getAttribute("value"));
		Helper.compareEquals(testConfig, "NPI Bank Address", "", txtBoxNPIBankAdr.getAttribute("value"));
		Helper.compareEquals(testConfig, "NPI Bank City", "", txtBoxNPIBankCity.getAttribute("value"));
		Helper.compareEquals(testConfig, "NPI Bank State", "", Element.getFirstSelectedOption(testConfig, drpDwnNPIBankState, "text"));
		Helper.compareEquals(testConfig, "NPI Bank ZIP", "", txtBoxNPIZIP1.getAttribute("value")+txtBoxNPIZIP2.getAttribute("value"));
		Element.verifyElementPresent(btnAddNPIAccount, "Add NPI Account");
		Element.verifyElementPresent(btnClearAllFieldsNPI, "Clear All Fields");
		verifyNPIListInDropdown().verifyNPIGridResults().addNPILevelBankAccount().verifyNPIGridResults();
		
	}


    public EditEnrollment verifyNPIGridResults() throws IOException
    {
    	int sqlRow=248;
	    HashMap<Integer, HashMap<String,String>> NPIFromDB=DataBase.executeSelectQueryALL(testConfig, sqlRow);
	    if(NPIFromDB.size()<1)
	    Helper.compareEquals(testConfig, "No NPI text","No NPI Bank Accounts have been added to this enrollment.",NPItable.get(0).getText());
	    else
	     {
	       for(int i=1;i<=NPItable.size();i++)
	        {
		      Helper.compareEquals(testConfig, " NPI Number", NPIFromDB.get(i).get(""), NPItable.get(i).findElements(By.tagName("td")).get(0).getText());
		      System.out.println(NPItable.get(i).getText());
		      System.out.println(NPItable.get(i).findElements(By.tagName("td")).get(0).getText());
		      System.out.println(NPItable.get(i).findElements(By.tagName("td")).get(1).getText());
		      System.out.println(NPItable.get(i).findElements(By.tagName("td")).get(2).getText());
		      System.out.println(NPItable.get(i).findElements(By.tagName("td")).get(3).getText());
		      System.out.println(NPItable.get(i).findElements(By.tagName("td")).get(4).getText());
		      System.out.println(NPItable.get(i).findElements(By.tagName("td")).get(5).getText());
	        }
	     }
		return this;
	 }
	    
		public EditEnrollment addNPILevelBankAccount() throws IOException
		{
			int rowNo=1;
			TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
			
			Element.selectByIndex(drpDwnSelectNPIBankAccPayer, 1, "Select Payer as :" + Element.getAllOptionsInSelect(testConfig, drpDwnSelectNPIBankAccPayer).get(1));
			Element.selectByIndex(drpDwnSelectNPI, 1, "Select NPI as : " + Element.getAllOptionsInSelect(testConfig, drpDwnSelectNPI).get(1));
			Element.enterData(txtBoxNPIBankNm,firstNameTxt ,"Enter bank name as : " +firstNameTxt, "NPI Bank Name");
			Element.enterData(txtBoxNPIBankNm,firstNameTxt ,"Enter bzzxank name as : " +firstNameTxt, "NPI Bank Name");
			Element.enterData(txtBoxNPIBankAdr,firstNameTxt ,"Enter Address as : " +firstNameTxt, "NPI Bank Address");
			Element.enterData(txtBoxNPIBankCity,data.GetData(rowNo, "City") ,"Enter City as :" + data.GetData(rowNo, "City"), "NPI city");
			Element.selectVisibleText(drpDwnNPIBankState, data.GetData(rowNo, "State"), "Selected CO as state");
			Element.enterData(txtBoxNPIZIP1, data.GetData(rowNo, "ZipCode"), "Entered zip code as :" + data.GetData(rowNo, "ZipCode"),"ZIP code");
			Element.enterData(txtBoxNPIPhNo1, phNo, "Enter Phone number in field 1 as:" + " "+phNo,"phoneNum");
			Element.enterData(txtBoxNPIPhNo2, phNo, "Enter Phone number in field 2 as:" +" "+phNo,"phoneNum1");
			Element.enterData(txtBoxNPIPhNo3, phNoLstField, "Enter Phone number in field 3 as:" + " "+phNoLstField ,"phoneNum2");
			Element.enterData(txtBoxNPIRoutingTransitNo, data.GetData(rowNo, "RoutingNumber"), "Enter  Routing no: " + data.GetData(rowNo, "RoutingNumber"), "Routing no");
			Element.enterData(txtBoxNPIBankAccNo, data.GetData(rowNo, "AccountNumber"), "Enter  Account no: " + data.GetData(rowNo, "AccountNumber"),"Account No");
			Element.click(rdoNPIAccountType.get(1), "Savings Radio button");
			Element.click(rdoDocType.get(0), "Voided Check button");
			Browser.wait(testConfig, 3);
			testConfig.driver.switchTo().frame("myFramebklnew");
			Element.enterData(btnNPIChooseFile, System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "Choose File", "Choose File");
			Browser.wait(testConfig, 3);
			testConfig.driver.switchTo().defaultContent();
			Element.click(btnAddNPIAccount, "Add NPI Account");
			Element.expectedWait(btnYesForW9, testConfig, "Yes button ", "Yes button ");
			testConfig.driver.switchTo().frame("myFrameorgactbkl");
			Element.enterData(btnNPIPendingW9, System.getProperty("user.dir")+testConfig.getRunTimeProperty("PdfPath"), "Upload W9", "Upload W9");
			Browser.wait(testConfig, 3);
			testConfig.driver.switchTo().defaultContent();
			Element.click(btnYesForW9, "Yes button for W9");
			Element.click(btnFinish, "Finish button");

			
			return this;
	
			
		
		}
		
		public EditEnrollment verifyNPIListInDropdown() throws IOException
		{
			int sqlRow=247;
			HashMap<Integer, HashMap<String,String>> NPIFromDB=DataBase.executeSelectQueryALL(testConfig, sqlRow);
			List<String> NPIListUI=Element.getAllOptionsInSelect(testConfig, drpDwnSelectNPI);
			String NPIUI=null;
			for(int i=1;i<=NPIFromDB.size();i++)
			{    
			     NPIUI=NPIListUI.get(i).replace("\n","");
			     String replacableSpace=NPIUI.substring(11,NPIUI.indexOf("-"));
			     NPIUI=NPIUI.replace(replacableSpace, "");
		    	 Helper.compareContains(testConfig, "NPI Number in UI dropdown and DB", NPIFromDB.get(i).get("NPI_NBR").toString() + " -" + NPIFromDB.get(i).get("PROV_PAY_UNIT_NM").toString(), NPIUI);
			}
			  return this;
			
		}
		
		public void verifyPayerLevelInfoUI() throws IOException
		{
			int sqlRow=245;
			HashMap<Integer, HashMap<String,String>> payerGridInfoDB=DataBase.executeSelectQueryALL(testConfig, sqlRow);
			List <String> payerNameDB= new ArrayList<String>();
			
			payerNameDB.add("--  Select  --");
			for(int i=1;i<=payerGridInfoDB.size();i++)
				payerNameDB.add(payerGridInfoDB.get(i).get("PAYR_DSPL_NM").toString());
				
			Helper.compareEquals(testConfig, "Default value is empty for Payer/Patient dropdown", "--  Select  --", Element.getFirstSelectedOption(testConfig,drpDwnPayerPatient,"text"));
			payerNameDB.remove("UnitedHealthcare");
			Helper.compareEquals(testConfig, "Payer name List", payerNameDB,Element.getAllOptionsInSelect(testConfig, drpDwnPayerPatient));

			
			
			Helper.compareEquals(testConfig, "Payer Bank Name", "", txtPayerBankAccName.getAttribute("value"));
			Helper.compareEquals(testConfig, "Payer Bank Address", "", txtPayerBankAccAdr.getAttribute("value"));
			Helper.compareEquals(testConfig, "Payer Bank City", "", txtPayerBankAccCity.getAttribute("value"));
			Helper.compareEquals(testConfig, "Payer Bank State", "", Element.getFirstSelectedOption(testConfig, drpDwnPayerState, "text"));
			Helper.compareEquals(testConfig, "Payer Bank ZIP", "", txtBankPayerZip1.getAttribute("value")+txtBankPayerZip2.getAttribute("value"));
			
			
			
			
			
			List<WebElement> noOFPayers=divPayerBankInfo.findElements(By.tagName("tr"));
			
			sqlRow=191;
			payerGridInfoDB=DataBase.executeSelectQueryALL(testConfig, sqlRow);
			
			for(int i=1;i<=noOFPayers.size();i++)
			{
				Helper.compareContains(testConfig, "Payer Name", payerGridInfoDB.get(i).get("PAYR_DSPL_NM"), noOFPayers.get(i-1).findElements(By.tagName("td")).get(0).getText());
				Helper.compareContains(testConfig, "Bank Name", payerGridInfoDB.get(i).get("BNK_NM"), noOFPayers.get(i-1).findElements(By.tagName("td")).get(1).getText());
				Helper.compareContains(testConfig, "RTE", payerGridInfoDB.get(i).get("RTE_TRNS_NBR"), noOFPayers.get(i-1).findElements(By.tagName("td")).get(2).getText());
				Helper.compareContains(testConfig, "BNK_ACCT_NBR", payerGridInfoDB.get(i).get("BNK_ACCT_NBR"), noOFPayers.get(i-1).findElements(By.tagName("td")).get(3).getText());
				Helper.compareContains(testConfig, "ACH_TYP_CD", payerGridInfoDB.get(i).get("ACH_TYP_CD"), noOFPayers.get(i-1).findElements(By.tagName("td")).get(4).getText());
//				Helper.compareContains(testConfig, "TEL_NBR", payerGridInfoDB.get(i).get("TEL_NBR"), noOFPayers.get(i-1).findElements(By.tagName("td")).get(5).getText().replace("-", "").replace("  ",""));
			}
//			
		
	}
	
	
	
	

	
	

}