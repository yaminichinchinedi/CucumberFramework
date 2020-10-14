package main.java.pageObjects;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class MaintainEnrollment extends HomePage  {
	
	private WebDriver driver;
	public TestBase testConfig;


	@FindBy(xpath="//td[@id='orgNameId']/following-sibling::td[2]")
	WebElement txtTinNo;
	
	@FindBy(xpath="//td[@id='orgNameId']/following-sibling::td[4]")
	WebElement txtEnrollmentID;
	
	
	@FindBy(xpath="//td[@id='addrId']/following-sibling::td[4]")
	WebElement enrollmentDate;
	
	@FindBy(xpath="//td[@id='addrId']/following-sibling::td[2]")
	WebElement enrollmentStatus;
	
	
	@FindBy(xpath="//parent::tr[@class='subheadernormal'][1]/../../../../../tr[4]/td//table//tbody//tr[2]//td[3]")
	WebElement txtBankName;
	
	
	@FindBy(xpath="//parent::tr[@class='subheadernormal'][1]/../../../../../tr[4]/td//table//tbody//tr[2]//td[5]")
	WebElement txtRoutingNo;
	
	@FindBy(xpath="//parent::tr[@class='subheadernormal'][1]/../../../../../tr[4]/td//table//tbody//tr[3]//td[2]")
	WebElement txtBankAddr;
	
	@FindBy(xpath="//parent::tr[@class='subheadernormal'][1]/../../../../../tr[4]/td//table//tbody//tr[3]//td[4]")
	WebElement txtAccNo;
	
	@FindBy(xpath="//parent::tr[@class='subheadernormal'][1]/../../../../../tr[4]/td//table//tbody//tr[5]//td[4]")
	WebElement txtACHType;
	
	@FindBy(xpath="//parent::tr[@class='subheadernormal'][1]/../../../../../tr[4]/td//table//tbody//tr[4]//td[4]")
	WebElement txtAccType;
	
	@FindBy(css="#orgNameId>strong")
	WebElement orgName;
	
	@FindBy(css="#addrId>strong")
	WebElement orgAddress;
	
	@FindBy(xpath="//td[@align='right']//input[@name='Edit']")
	WebElement btnEdit;
	 
	@FindBy(linkText="View W9")
	WebElement lnkw9;
	 
	@FindBy(linkText="View Voided Check")
	WebElement lnkvoidChk;
 
	@FindBy(xpath="//td[@align='right']//input[@value='  Edit  ']")
   	WebElement btnEdit1;
 
	@FindBy(xpath="//td[@align='right']//input[@value='Cancel']")
	WebElement btnCancel1;
 
	@FindBy(xpath="//input[@value='  Edit  '][1]")
	WebElement btnEdit2;
 
	@FindBy(xpath="//input[@value='Cancel'][1]")
	WebElement btnCancel2;
   
	@FindBy(xpath="//td[contains(text(),'Organization Information')]")
	WebElement divOrgInfo;
	       
	@FindBy(xpath="//td[contains(text(),'Payer Information')]")
	WebElement divPayerInfo;
	
	@FindBy(id="payerInfoControl")
   	WebElement payrInfo;
       
   	@FindBy(xpath="//td[@align='right']//input[@value='  Edit  ']")
  	WebElement editButton;
	
 	public MaintainEnrollment(TestBase testConfig)
	{
 		super(testConfig);
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, "/viewEnrollment.do");
	}

	
	public MaintainEnrollment verifyEnrollmentUI(String accessType)
	  {
	      Helper.compareContains(testConfig, "Selected tin on maintain enrollment page", Element.getFirstSelectedOption(testConfig, drpDwnTin, "text"), testConfig.getRunTimeProperty("tin")+" - Enrolled");
	      if(accessType.equalsIgnoreCase("PROV_Admin"))
	      {
	          Element.verifyElementPresent(btnEdit1, "Edit button on top right");
	          Element.verifyElementPresent(btnEdit2, "Edit button at bottom");
	       }
	      else
	      {
	          Element.verifyElementNotPresent(btnEdit1, "Edit button on top right");
	          Element.verifyElementNotPresent(btnEdit2, "Edit button at bottom");
	      }
	     
	       Element.verifyElementPresent(btnCancel2, "Cancel button at bottom");
	       Element.verifyElementPresent(btnCancel1, "Cancel button at top right");
	       Element.verifyElementPresent(divOrgInfo, "Organization info bar");
	       Element.verifyElementPresent(divPayerInfo, "Payer info bar");
	       Element.verifyElementPresent(lnkw9, "W9 link");
	       return this;
	  }
	
	
   public MaintainEnrollment click_w9link()
	{
	   Element.click(lnkw9, "w9 link");
	   return this;
	}

	      public MaintainEnrollment verifyw9IsDownloaded()
	            {
	                    Helper.PDFDownloadVerification(testConfig, lnkw9, "w9 link", "W9");
	                    return this;
	            }
	      
	            public MaintainEnrollment verifyVoidedCheckIsDownloaded(String accessType)
	            {
	            	    if(accessType.equalsIgnoreCase("PROV_Admin"))
	                    Helper.PDFDownloadVerification(testConfig, lnkvoidChk, "Void check link", "Void check ");
	            	    else
	            	    	Element.verifyElementNotPresent(lnkvoidChk,"Void check link");
	                    return this;
	            }
	      
	            public EditEnrollment clickEditBtn()
	            {
	                    Element.click(btnEdit1, "Edit button");
	                    return new EditEnrollment(testConfig);
	      
	            }

	
	public MaintainEnrollment verifyOrgInfoOfSelectedTin() throws ParseException
	{
		 int sqlRowNo=1;
          
		// Verifies count of records displayed in view payments tab from DB
		Map portalUserTable = DataBase.executeSelectQuery(testConfig, sqlRowNo,1);
		
		String orgAddressFromDB=portalUserTable.get("ADR_TXT").toString().trim().replaceAll("\\s", "");
		String orgAddrFromUI=orgAddress.getText().trim().replaceAll("\\s", "");
		
		Helper.compareEquals(testConfig, "Tin number", testConfig.getRunTimeProperty("tin").toString().trim(), txtTinNo.getText().trim());
		Helper.compareEquals(testConfig, "Organization Name", portalUserTable.get("ORG_NM").toString().trim(), orgName.getText().trim());
		Helper.compareEquals(testConfig, "Organization Address", orgAddressFromDB,orgAddrFromUI);
		Helper.compareEquals(testConfig, "Enrollment ID", portalUserTable.get("ENRL_ID_NBR").toString().trim(), txtEnrollmentID.getText().trim());
		Helper.compareContains(testConfig, "Date of Enrollment",Helper.changeDateFormat(enrollmentDate.getText().toString(), "mm/dd/yyyy", "yyyy-mm-dd"),portalUserTable.get("ENRL_DTTM").toString().trim());
		Helper.compareEquals(testConfig, "Enrollment Status",convertEnrollmentStatus(portalUserTable.get("ENRL_STS_CD").toString().trim()),enrollmentStatus.getText().trim());
		return new MaintainEnrollment(testConfig);
		
	}
	
	
	
	public MaintainEnrollment verifyOrgBankAccountInfo(String accessType) throws ParseException
	{
		int sqlRowNo=2;       
		Map provBankAccount = DataBase.executeSelectQuery(testConfig, sqlRowNo,1);
		if(accessType.equalsIgnoreCase("PROV_Admin"))
		{
		Helper.compareEquals(testConfig, "Bank Name", provBankAccount.get("BNK_NM").toString().trim(), txtBankName.getText().trim());
		Helper.compareEquals(testConfig, "Bank Address", provBankAccount.get("ADR_TXT").toString().trim(), txtBankAddr.getText().trim());
		Helper.compareEquals(testConfig, "Routing Transit Number", provBankAccount.get("RTE_TRNS_NBR").toString().trim(), txtRoutingNo.getText().trim());
		Helper.compareEquals(testConfig, "Account Number",provBankAccount.get("BNK_ACCT_NBR").toString().trim(),txtAccNo.getText().trim());
		Helper.compareEquals(testConfig, "ACH Type",provBankAccount.get("ACH_TYP_CD").toString().trim(),txtACHType.getText().trim());
		Helper.compareEquals(testConfig, "Account Type",provBankAccount.get("ACCT_TYP_ID").toString().trim(),convertAcctType(txtAccType.getText().trim()));
		}
		return new MaintainEnrollment(testConfig);
	}
	
	public String convertEnrollmentStatus(String DBStatus)
	{
		switch(DBStatus)
		{
		case "A":
			return "Active";
			
		case "PE":
			return "Pending";
		
		default:
		return DBStatus;
		}
	}
	
	public String convertAcctType(String DBStatus)
	{
		switch(DBStatus)
		{
		case "Checking":
			return "1";
			
		case "Savings":
			return "2";
		
		default:
		return DBStatus;
		}
	}

public void validateOptumPayText() {
		
		Element.click(payrInfo, "Payer Information");
		Browser.wait(testConfig, 2);
		Helper.compareContains(testConfig, "Optum Pay text", "Optum Pay", Element.findElement(testConfig, "id", "payerInfoMsgDiv").getText());

		if (Element.findElement(testConfig, "id", "payerInfoMsgDiv").getText().contains("EPS")|| 
			Element.findElement(testConfig, "id", "payerInfoMsgDiv").getText().contains("Electronic Payments and Statements") )
			Log.Fail("EPS text is present");
		
	}
	public void validateOptumPayTextonEdit() {
		
		Element.click(editButton, "Edit Button");
		Browser.wait(testConfig, 4);
		Element.click(Element.findElement(testConfig, "xpath", "//ul[@id='tabmenu']/li[2]"), "Payer Tab");
		Browser.wait(testConfig, 5);
		Helper.compareContains(testConfig, "Optum Pay text", "Optum Pay", Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[6]/td").getText());


		if (Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[6]/td").getText().contains("EPS") ||
			Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[6]/td").getText().contains("Electronic Payments and Statements")	)
			Log.Fail("EPS text is present");
		
	}
public void validateOptumPayTextonEditOrg(String UserTyp) {
		if (UserTyp.equals("BS"))
		{
		Element.click(Element.findElement(testConfig, "xpath", "//input[@type='button' and @value='     Edit     ']"), "Edit Button");
		Browser.wait(testConfig, 2);
		WebElement bsName=Element.findElement(testConfig, "name", "bsName");
		Element.enterData(bsName, "QWE@#$", "Billing Service Name", "BSName");
		Element.click(Element.findElement(testConfig, "xpath", "//input[@type='submit' and @value='Finish']"), "Finish Button");
		Browser.wait(testConfig, 3);
		Helper.compareContains(testConfig, "Optum Pay text", "Optum Pay", Element.findElement(testConfig, "xpath", "//form[@id='billingserviceenrollmentForm']/table/tbody/tr[3]/th").getText());


		if (Element.findElement(testConfig, "xpath", "//form[@id='billingserviceenrollmentForm']/table/tbody/tr[3]/th").getText().contains("EPS") ||
			Element.findElement(testConfig, "xpath", "//form[@id='billingserviceenrollmentForm']/table/tbody/tr[3]/th").getText().contains("Electronic Payments and Statements")	)
			Log.Fail("EPS text is present");
		}
		if (UserTyp.equals("PROV"))
		{	
		Element.click(editButton, "Edit Button");
		Browser.wait(testConfig, 4);
		WebElement orgName=Element.findElement(testConfig, "name", "orgName");
		Element.enterData(orgName, "QWE@#$", "Organisatin Name", "orgName");
		Element.click(Element.findElement(testConfig, "name", "continueBtn"), "Organization Name Field");
		Browser.wait(testConfig, 3);
		Helper.compareContains(testConfig, "Optum Pay text", "Optum Pay", Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[4]/th").getText());


		if (Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[4]/th").getText().contains("EPS") ||
			Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[4]/th").getText().contains("Electronic Payments and Statements")	)
			Log.Fail("EPS text is present");
		}
		Browser.wait(testConfig, 3);
		Element.click(Element.findElement(testConfig, "id", "tabMntnEnrl"), "Maintain Enrollment Tab");

	}
public void validateOptumPayTextonCancel() {
		
		//Element.click(editButton, "Edit Button");
		Browser.wait(testConfig, 2);
		Element.click(Element.findElement(testConfig, "xpath", "//input[@value=' Cancel ']"), "Cancel Button");
		Browser.wait(testConfig, 2);
		Helper.compareContains(testConfig, "Optum Pay text", "Optum Pay", Element.findElement(testConfig, "xpath", "//td[@class='subheadernormal'][1]").getText());

		if (Element.findElement(testConfig, "xpath", "//td[@class='subheadernormal'][1]").getText().contains("EPS") ||
			Element.findElement(testConfig, "xpath", "//td[@class='subheadernormal'][1]").getText().contains("Electronic Payments and Statements")	)
			Log.Fail("EPS text is present");
		
		
	}
public void validateOptumPayTextonCancelBS() {
	
	Element.click(Element.findElement(testConfig, "xpath", "//input[@type='button' and @value='     Edit     ']"), "Edit Button");
	Browser.wait(testConfig, 2);
	Element.click(Element.findElement(testConfig, "xpath", "//input[@value='Cancel']"), "Cancel Button");
	Browser.wait(testConfig, 2);
	Helper.compareContains(testConfig, "Optum Pay text", "Optum Pay", Element.findElement(testConfig, "xpath", "//form[@id='billingserviceenrollmentForm']/table/tbody/tr[3]/td").getText());


	if (Element.findElement(testConfig, "xpath", "//form[@id='billingserviceenrollmentForm']/table/tbody/tr[3]/td").getText().contains("EPS") ||
		Element.findElement(testConfig, "xpath", "//form[@id='billingserviceenrollmentForm']/table/tbody/tr[3]/td").getText().contains("Electronic Payments and Statements")	)
			Log.Fail("EPS text is present");
	
}
public void validateOptumPayTextonFinish() {
	Element.click(Element.findElement(testConfig, "xpath", "//input[@type='submit' and @name='No']"), "No Button");

	Browser.wait(testConfig, 2);
	Element.click(Element.findElement(testConfig, "xpath", "//input[@value=' Finish ']"), "Finish Button");
	
	Browser.wait(testConfig, 2);

	Element.click(Element.findElement(testConfig, "xpath", "//input[@type='submit' and @name='Submit']"), "Submit Button");
	Helper.compareContains(testConfig, "Optum Pay text", "Optum Pay", Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[2]/td/table/tbody").getText());

	if (Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[2]/td/table/tbody").getText().contains("EPS") ||
		Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[2]/td/table/tbody").getText().contains("Electronic Payments and Statements")	)
		Log.Fail("EPS text is present");
	}

public void readPDFFile(String UserTyp ) throws IOException{
	String output="";	
	String fileName="";
	String filedir=System.getProperty("user.dir")+"\\Downloads";
	File fileDirectory=new File(filedir);
	Helper.purgeDirectory(fileDirectory);
	Element.click(Element.findElement(testConfig, "xpath", "//input[@type='button' and @name='Print Enrollment Form']"), "Print Enrollment Button");
	Browser.wait(testConfig, 8);
	if (UserTyp.equals("PROV"))
	{
	int sqlRowNo=1;
     Map portalUserTable = DataBase.executeSelectQuery(testConfig, sqlRowNo,1);
		fileName=portalUserTable.get("ENRL_ID_NBR").toString().trim();
	}	
	if (UserTyp.equals("BS"))
	fileName=testConfig.getRunTimeProperty("BS TIN");
	fileName="\\"+fileName+".pdf";
	   testConfig.driver.get("file:///"+filedir+fileName);
	
	URL url = new URL(testConfig.driver.getCurrentUrl());
    InputStream is = url.openStream();
    BufferedInputStream fileToParse = new BufferedInputStream(is);
    PDDocument document = null;
    try {
        document = PDDocument.load(fileToParse);
        document.getNumberOfPages();
        output = new PDFTextStripper().getText(document);
    } finally {
        if (document != null) {
            document.close();
        }
        fileToParse.close();
        is.close();
    }
	Helper.compareContains(testConfig, "Optum Pay text", "Optum Pay", output);

}


public void validateOptumPayTextonFinishBS() {
	Element.click(Element.findElement(testConfig, "xpath", "//input[@type='submit' and @Value='No']"), "No Button");

	Browser.wait(testConfig, 2);
	Element.click(Element.findElement(testConfig, "xpath", "//input[@value='Finish']"), "Finish Button");
	Browser.wait(testConfig, 3);
	testConfig.putRunTimeProperty("BS TIN", Element.findElement(testConfig, "xpath", "//form[@id='billingserviceenrollmentForm']/span/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong").getText());
	Element.click(Element.findElement(testConfig, "xpath", "//input[@type='submit' and @name='Submit']"), "Submit Button");
	
	Helper.compareContains(testConfig, "Optum Pay text", "Optum Pay", Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[4]/td/table/tbody").getText());
	
	if (Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[4]/td/table/tbody").getText().contains("EPS") ||
			Element.findElement(testConfig, "xpath", "//form[@id='enrollmentForm']/table/tbody/tr[4]/td/table/tbody").getText().contains("Electronic Payments and Statements")	)
			Log.Fail("EPS text is present");
	
	
}


}
