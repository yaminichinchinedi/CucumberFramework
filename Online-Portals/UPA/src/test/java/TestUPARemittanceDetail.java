package test.java;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.HomePage;
import main.java.pageObjects.OptumIdLoginPage;
import main.java.pageObjects.UPARegistrationPage;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class TestUPARemittanceDetail extends TestBase {
	String userType="PROV";
	String accessType="Admin";
    
	@Test(priority=5,description="TS01_Hover Text Super CSR")
	public void testVerifyHoverText() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	{
		String criteriaType="byDOP";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).clickPaymentNo().verifyHoverTexts();;		
	}
	
	@Test(priority=5,description="TS02_PopUp for RMK Code")
	public void testVerifyPopUpforRMKCode() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOP";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).clickPaymentNo().verifyPopUpforRMKCode();
     }
	
	@Test(priority=5,description="TS03_PopUp for ADJ reason Code")
	public void testVerifyPopUpforADJCode() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOP";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).clickPaymentNo().verifyPopUpforADJCode();
     }
	
	@Test(priority=5,description="TS04_PLB Adjustment Only")
	public void testVerifyPLBAdjustment() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOP";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).clickPaymentNo().verifyPLBAdjustment();;
    }
	
	@Test(priority=5,description="TS05_Page Verification")
	public void testVerifyPageData() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOP";						
		UPARegistrationPage registrationPage = new UPARegistrationPage(testConfig);
	    OptumIdLoginPage optumIDLoginPage=registrationPage.clickSignInWithOptumId();
		HomePage home=optumIDLoginPage.loginWithOptumID(userType,accessType);
		home.selectTin().clickSearchRemittanceTab().doSearch(criteriaType).clickPaymentNo().verifyPageRemittanceDetail();
    }
}
