package main.java.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;

public class ThankYouPage {

	private TestBase testConfig;

	@FindBy(xpath = "//td[contains(text(),'Enrollment Completed Successfully')]")
	WebElement txtEnrollmentCompleted;
	

	@FindBy(linkText="Print Completed Enrollment Form")
	WebElement lnkPrintPdf;
	

	public ThankYouPage(TestBase testConfig) 
	{
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.expectedWait(txtEnrollmentCompleted, testConfig, "Enrollment Completed successfully", "Enrollment Completed successfully");
	}

	public void verifyEnrollmentInfoInDB() throws IOException {
		
		// Verify data from enrolled provider table
		int excelRowNo=1;
		int sqlRowNo=1;
		TestDataReader data = testConfig.cacheTestDataReaderObject("FinancialInfo");
		
		//Verifies information from Enrolled Provider table
		
		Map enrolledProviderTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Helper.compareEquals(testConfig, "City Name ",data.GetData(excelRowNo, "City").toLowerCase().trim(), enrolledProviderTable.get("CTY_NM").toString().toLowerCase().trim());
		Helper.compareEquals(testConfig, "City Name ",data.GetData(excelRowNo, "State").toLowerCase().trim(), enrolledProviderTable.get("ST_NM").toString().toLowerCase().trim());
		Helper.compareEquals(testConfig, "City Name ",data.GetData(excelRowNo, "ZipCode").toLowerCase().trim(), enrolledProviderTable.get("ZIP_CD").toString().toLowerCase().trim());
		 
		
		//Verifies information from Provider Account table
		
		 if(!testConfig.getRunTimeProperty("enrollmentType").equalsIgnoreCase("VO"))
		 {
		sqlRowNo=2;
		Map provBankingActTable =DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Helper.compareEquals(testConfig, "City Name ",data.GetData(excelRowNo, "City").toLowerCase().trim(), provBankingActTable.get("CTY_NM").toString().toLowerCase().trim());
		Helper.compareEquals(testConfig, "State Name",data.GetData(excelRowNo, "State").toLowerCase().trim(), provBankingActTable.get("ST_NM").toString().toLowerCase().trim());
		Helper.compareEquals(testConfig, "Zip Code",data.GetData(excelRowNo, "ZipCode").toLowerCase().trim(), provBankingActTable.get("ZIP_CD").toString().toLowerCase().trim());
		 }
	}
	
	public void verifyPDF() throws InvalidPasswordException, IOException
	{
		String filePath="C:\\AutomationFinal\\TestAutomation\\Online-Portals\\UPA\\Downloads";
		testConfig.purgeDirectory(new File(filePath));
		Element.click(lnkPrintPdf, "Print PDF Link");
		
		String pdfText=Helper.readPDF(filePath);
		if(pdfText.contains("Routing Transit Number: 107005319"))
			Log.Pass("PDF contains the correct routing number");
	}
}
