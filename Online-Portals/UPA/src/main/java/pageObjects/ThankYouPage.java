package main.java.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;

public class ThankYouPage {

	private TestBase testConfig;

	@FindBy(linkText = "Print Completed Enrollment Form")
	WebElement lnkPrintPdf;

	@FindBy(partialLinkText = "What is the ACH Addenfum Record")
	WebElement lnkACHAddndmRcrd;

	@FindBy(xpath = "//a[@class='button--primary margin-left float-right btn-close']")
	WebElement closetip;

	@FindBy(xpath = "//span[@class='progress-indicator__circle']")
	List<WebElement> OrgCircle;

	@FindBy(xpath = "//span[@class='progress-indicator__title']")
	List<WebElement> OrgInfoHeaders;

	@FindBy(xpath = "//a[@class='button--primary enrollment-container-footer__btn-margin float-right']")
	WebElement exitEnrollment;

	public ThankYouPage(TestBase testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.expectedWait(lnkPrintPdf, testConfig,
				"Print Completed Enrollment Form",
				"Print Completed Enrollment Form");
	}

	public void verifyHeaders() {

		List<String> headers = Arrays.asList("Organization Information",
				"Identify Administrators", "Financial Institution Information",
				"Select Payment Methods", "Upload W9", "Review and Submit");
		for (int i = 0; i < (OrgInfoHeaders.size()); i++) {

			// Helper.compareEquals(testConfig, "Headers comparison for : " +
			// headers.get(i) , headers.get(i),
			// (OrgInfoHeaders.get(i).getText().replace("\n", " ")).trim());
			if (!(OrgInfoHeaders.get(i).getText().replace("\n", " "))
					.equalsIgnoreCase("Enrollment Submitted")
					&& headers.get(i)
							.equalsIgnoreCase(
									(OrgInfoHeaders.get(i).getText().replace(
											"\n", " ")))) {
				Helper.compareEquals(
						testConfig,
						"Color Value for "
								+ (OrgInfoHeaders.get(i).getText().replace(
										"\n", " ")) + " Information is:",
						"#e87722",
						Color.fromString(
								OrgInfoHeaders.get(i).getCssValue("color"))
								.asHex());

				Helper.compareEquals(testConfig, "font weight for "
						+ (OrgInfoHeaders.get(i).getText().replace("\n", " "))
						+ " Information is:", "400", OrgInfoHeaders.get(i)
						.getCssValue("font-weight"));
			}

			if ((OrgInfoHeaders.get(i).getText().replace("\n", " "))
					.equalsIgnoreCase("Enrollment Submitted")
					&& OrgCircle.get(i).isDisplayed() == true) {
				Helper.compareEquals(
						testConfig,
						"Color Value for "
								+ (OrgInfoHeaders.get(i).getText().replace(
										"\n", " ")) + " Information is:",
						"#e87722",
						Color.fromString(
								OrgInfoHeaders.get(i).getCssValue("color"))
								.asHex());

				Helper.compareEquals(
						testConfig,
						"Bold font with circle is present for "
								+ (OrgInfoHeaders.get(i).getText().replace(
										"\n", " ")), "900",
						OrgInfoHeaders.get(i).getCssValue("font-weight"));

			}

		}
	}

	public void VerifyPrntCompltEnrollmentFrmDwnldorVieworPrnt()
			throws IOException {
		//Element.click(lnkPrintPdf, "Print Completed Enrollment Form");
		Element.clickByJS(testConfig, lnkPrintPdf,"Print Completed Enrollment Form");
		

	}

	public void ClickOnLinkACHAddenfumRecord() throws IOException {
		Element.click(lnkACHAddndmRcrd, " What is the ACH Addenfum Record for");
        Element.click(closetip, "Close Tip Button");



	}

	public void verifyExitEnrollemnt() throws IOException {
		String expected = "EXIT ENROLLMENT";
		String actual = exitEnrollment.getText();

		Helper.compareEquals(testConfig, "EXIT ENROLLMENT Button Text",
				expected, actual);

		Element.click(exitEnrollment, "EXIT ENROLLMENT");
		String expecteHOMEURL = "returnToLoginPage.do";
		Browser.verifyURL(testConfig, expecteHOMEURL);

	}

	public void verifyEnrollmentInfoInDB() throws IOException {

		// Verify data from enrolled provider table
		int excelRowNo = 1;
		int sqlRowNo = 1;
		TestDataReader data = testConfig
				.cacheTestDataReaderObject("FinancialInfo");

		// Verifies information from Enrolled Provider table

		Map enrolledProviderTable = DataBase.executeSelectQuery(testConfig,
				sqlRowNo, 1);
		Helper.compareEquals(testConfig, "City Name ",
				data.GetData(excelRowNo, "City").toLowerCase().trim(),
				enrolledProviderTable.get("CTY_NM").toString().toLowerCase()
						.trim());
		Helper.compareEquals(testConfig, "City Name ",
				data.GetData(excelRowNo, "State").toLowerCase().trim(),
				enrolledProviderTable.get("ST_NM").toString().toLowerCase()
						.trim());
		Helper.compareEquals(testConfig, "City Name ",
				data.GetData(excelRowNo, "ZipCode").toLowerCase().trim(),
				enrolledProviderTable.get("ZIP_CD").toString().toLowerCase()
						.trim());

		// Verifies information from Provider Account table

		if (!testConfig.getRunTimeProperty("enrollmentType").equalsIgnoreCase(
				"VO")) {
			sqlRowNo = 2;
			Map provBankingActTable = DataBase.executeSelectQuery(testConfig,
					sqlRowNo, 1);
			Helper.compareEquals(testConfig, "City Name ",
					data.GetData(excelRowNo, "City").toLowerCase().trim(),
					provBankingActTable.get("CTY_NM").toString().toLowerCase()
							.trim());
			Helper.compareEquals(testConfig, "State Name",
					data.GetData(excelRowNo, "State").toLowerCase().trim(),
					provBankingActTable.get("ST_NM").toString().toLowerCase()
							.trim());
			Helper.compareEquals(testConfig, "Zip Code",
					data.GetData(excelRowNo, "ZipCode").toLowerCase().trim(),
					provBankingActTable.get("ZIP_CD").toString().toLowerCase()
							.trim());
		}
	}

	// public void verifyPDF() throws InvalidPasswordException, IOException
	// {
	// String
	// filePath="C:\\AutomationFinal\\TestAutomation\\Online-Portals\\UPA\\Downloads";
	// testConfig.purgeDirectory(new File(filePath));
	// Element.click(lnkPrintPdf, "Print PDF Link");
	//
	// String pdfText=Helper.readPDF(filePath);
	// if(pdfText.contains("Routing Transit Number: 107005319"))
	// Log.Pass("PDF contains the correct routing number");
	// }
}
