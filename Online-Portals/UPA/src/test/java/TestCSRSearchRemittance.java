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
import main.java.pageObjects.SearchRemittanceSearchCriteria;
import main.java.pageObjects.SearchTinPageSearchRemittance;
import main.java.pageObjects.SearchTinPageViewPayments;
import main.java.pageObjects.paymentSummary;

public class TestCSRSearchRemittance extends TestBase {
	
	@Test(priority=5,description="TS004_Search by Electronic Payment Number only")
	public void testEpraByPaymentNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String accessLevelOfNewUser="Administrator";	
		String filterPayments="Show All";
		String criteriaType="byElectronicPaymentNumber";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.fillSearchCriteria(criteriaType);		
      }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByCheckNumber() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String accessLevelOfNewUser="Administrator";	
		String filterPayments="Show All";
		String criteriaType="byCheckNumber";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.fillSearchCriteria(criteriaType);		
      }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfService() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String accessLevelOfNewUser="Administrator";	
		String filterPayments="Show All";
		String criteriaType="byDateOfService";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.fillSearchCriteria(criteriaType);		
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfPayment() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String accessLevelOfNewUser="Administrator";	
		String filterPayments="Show All";
		String criteriaType="byDateOfPayment";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.fillSearchCriteria(criteriaType);		
     }
	
	@Test(priority=5,description="TS005_Search by Check Number only")
	public void testEpraByDateOfPaymentAndAcntNo() throws InterruptedException, IOException, AWTException, JAXBException, SAXException, ParserConfigurationException, ParseException
	 {
		String loginUserType="Super";
		String userType="PROV";	
		String accessLevelOfNewUser="Administrator";	
		String filterPayments="Show All";
		String criteriaType="byDateOfPayment";
					
		LoginCSR loginPage=new LoginCSR(testConfig);
		CSRHomePage homePage=loginPage.doLogin(loginUserType);
		SearchTinPageSearchRemittance srchTinPage = homePage.clickSearchRemittanceLink();		
		srchTinPage.enterTin(criteriaType);
		SearchRemittanceSearchCriteria srchCriteriaPage = srchTinPage.clickSearchBtn();
		srchCriteriaPage.fillSearchCriteria(criteriaType);		
     }

}
