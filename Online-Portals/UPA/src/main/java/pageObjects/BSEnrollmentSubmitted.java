package main.java.pageObjects;

import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.api.pojo.epsEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSEnrollmentSubmitted {
	
	private TestBase testConfig;
	
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();
	
	@FindBy(xpath=".//*[@id='BSETForm']/section/fieldset/legend/h1")
	WebElement txtEnrlmntSubmtd;
	
	public BSEnrollmentSubmitted(TestBase testConfig) 
	{
		String expectedURL = "/validateBSSubmit";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
		Element.verifyElementPresent(txtEnrlmntSubmtd, "Enrollment Submitted");
		validateBusinessOrgInfo();
	}
	
	public void validateBusinessOrgInfo()
	{
		int sqlRowNo=102;
		Map data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		
		Helper.compareEquals(testConfig, "BS Tin Or SSN",enrollmentInfoPageObj.getBsTinIdentifier() , data.get("IDENTIFIER_TYP_CD"));
		Helper.compareEquals(testConfig, "BS TIN",enrollmentInfoPageObj.getTin() , data.get("IDENTIFIER_NBR"));
		Helper.compareEquals(testConfig, "BS Name",enrollmentInfoPageObj.getBusinessName() , data.get("BS_NM"));
		Helper.compareEquals(testConfig, "Street", enrollmentInfoPageObj.getStreet(), data.get("ADR_TXT"));
		Helper.compareEquals(testConfig, "City", enrollmentInfoPageObj.getCity().trim(), data.get("CTY_NM").toString().trim());
		Helper.compareEquals(testConfig, "State", enrollmentInfoPageObj.getStateName(), data.get("ST_NM").toString());
		Helper.compareEquals(testConfig, "Zip", enrollmentInfoPageObj.getZipCode().trim(), data.get("ZIP_CD").toString().trim());
		Helper.compareEquals(testConfig, "First Name", enrollmentInfoPageObj.getFrstName(), data.get("FST_NM").toString());
		Helper.compareEquals(testConfig, "Last Name", enrollmentInfoPageObj.getLstName(), data.get("LST_NM").toString());
		Helper.compareEquals(testConfig, "Phone Number", enrollmentInfoPageObj.getPhnNumbr(), data.get("TEL_NBR").toString());
		Helper.compareEquals(testConfig, "Email", enrollmentInfoPageObj.getEmail(), data.get("EMAIL_ADR_TXT").toString());
		Helper.compareEquals(testConfig, "Auth Frst Name", enrollmentInfoPageObj.getAuthFrstName(), data.get("AUTH_FST_NM").toString());
		Helper.compareEquals(testConfig, "Auth Lst Name", enrollmentInfoPageObj.getAuthLstName(), data.get("AUTH_LST_NM").toString());
		Helper.compareEquals(testConfig, "Auth_Phn Number", enrollmentInfoPageObj.getAuthPhnNbr(), data.get("AUTH_TEL_NBR").toString());
		Helper.compareEquals(testConfig, "Auth_Email", enrollmentInfoPageObj.getAuthEmail(), data.get("AUTH_EMAIL").toString());
		
	}
}
