package main.java.pageObjects;

import java.text.ParseException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.TestBase;

public class MaintainEnrollment {
	
	private WebDriver driver;
	private TestBase testConfig;


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
	
	
	
	
	public MaintainEnrollment(TestBase testConfig)
	{
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	
	public MaintainEnrollment verifyOrgInfoOfSelectedTin() throws ParseException
	{
		 int sqlRowNo=1;
          
		// Verifies count of records displayed in view payments tab from DB
		Map portalUserTable = DataBase.executeSelectQuery(testConfig, sqlRowNo,1);
		
		
		Helper.compareEquals(testConfig, "Tin number", testConfig.getRunTimeProperty("tin").toString().trim(), txtTinNo.getText().trim());
		Helper.compareEquals(testConfig, "Organization Name", portalUserTable.get("ORG_NM").toString().trim(), orgName.getText().trim());
		Helper.compareEquals(testConfig, "Organization Address", portalUserTable.get("ADR_TXT").toString().trim(), orgAddress.getText().trim());
		Helper.compareEquals(testConfig, "Enrollment ID", portalUserTable.get("ENRL_ID_NBR").toString().trim(), txtEnrollmentID.getText().trim());
		Helper.compareContains(testConfig, "Date of Enrollment",Helper.changeDateFormat(enrollmentDate.getText().toString(), "mm/dd/yyyy", "yyyy-mm-dd"),portalUserTable.get("ENRL_DTTM").toString().trim());
		Helper.compareEquals(testConfig, "Enrollment Status",convertEnrollmentStatus(portalUserTable.get("ENRL_STS_CD").toString().trim()),enrollmentStatus.getText().trim());
		return new MaintainEnrollment(testConfig);
		
	}
	
	
	
	public MaintainEnrollment verifyOrgBankAccountInfo() throws ParseException
	{
		 int sqlRowNo=2;
         
		// Verifies count of records displayed in view payments tab from DB
		Map provBankAccount = DataBase.executeSelectQuery(testConfig, sqlRowNo,1);
		Helper.compareEquals(testConfig, "Bank Name", provBankAccount.get("BNK_NM").toString().trim(), txtBankName.getText().trim());
		Helper.compareEquals(testConfig, "Bank Address", provBankAccount.get("ADR_TXT").toString().trim(), txtBankAddr.getText().trim());
		Helper.compareEquals(testConfig, "Routing Transit Number", provBankAccount.get("RTE_TRNS_NBR").toString().trim(), txtRoutingNo.getText().trim());
		Helper.compareEquals(testConfig, "Account Number",provBankAccount.get("BNK_ACCT_NBR").toString().trim(),txtAccNo.getText().trim());
		Helper.compareEquals(testConfig, "ACH Type",provBankAccount.get("ACH_TYP_CD").toString().trim(),txtACHType.getText().trim());
		Helper.compareEquals(testConfig, "Account Type",provBankAccount.get("ACCT_TYP_ID").toString().trim(),convertAcctType(txtAccType.getText().trim()));
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

}
