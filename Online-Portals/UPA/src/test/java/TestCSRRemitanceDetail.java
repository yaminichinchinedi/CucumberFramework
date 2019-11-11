package test.java;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.CSRHomePage;
import main.java.pageObjects.LoginCSR;
import main.java.pageObjects.SearchTinPageSearchRemittance;

public class TestCSRRemitanceDetail extends TestBase{
	String loginUserType="Super";
	
	@Test(priority=5,description="TS01_Hover Text Super CSR")
	public void testVerifyHoverText() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOP"; 
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
		srchTinPage.clickSearchBtn().doSearch(criteriaType).clickPaymentNo().verifyHoverTexts();
     }
	
	@Test(priority=5,description="TS02_PopUp for RMK Code")
	public void testVerifyPopUpforRMKCode() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOP"; 
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
		srchTinPage.clickSearchBtn().doSearch(criteriaType).clickPaymentNo().verifyPopUpforRMKCode();
     }
	
	@Test(priority=5,description="TS03_PopUp for ADJ reason Code")
	public void testVerifyPopUpforADJCode() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOP"; 
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
		srchTinPage.clickSearchBtn().doSearch(criteriaType).clickPaymentNo().verifyPopUpforADJCode();
     }
	
	@Test(priority=5,description="TS04_PLB Adjustment Only")
	public void testVerifyPLBAdjustment() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOP"; 
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
		srchTinPage.clickSearchBtn().doSearch(criteriaType).clickPaymentNo().verifyPLBAdjustment();;
    }
	
	//verify Page Data
	@Test(priority=5,description="TS05_Page Verification")
	public void testVerifyPageData() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String criteriaType="byDOP"; 
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink().enterTin(criteriaType);	
		srchTinPage.clickSearchBtn().doSearch(criteriaType).clickPaymentNo().verifyPageRemittanceDetail();
    }
}
