package main.java.pageObjects;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import java.io.File;

import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class EnrollmentSubmitted {
	protected TestBase testConfig;
	@FindBy(linkText="Print Completed Enrollment Form")
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
	
	@FindBy(xpath=".//*[@id='EFTERAregForm']//div[1]/p[4]/span")
	WebElement imgPDF;
	
	@FindBy(linkText="Print Completed Enrollment Form")
	WebElement lnkPrintPdf;
	
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();
	

	public EnrollmentSubmitted(TestBase testConfig) throws IOException 
	{
		String expectedURL = "/validateEFTERASubmit";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
			expectedURL="/validateBSSubmit";
	
		Element.expectedWait(lnkPrintPdf, testConfig, "Print Completed Enrollment Form", "Print Completed Enrollment Form");
		Browser.waitTillSpecificPageIsLoaded(testConfig, testConfig.getDriver().getTitle());
		Element.expectedWait(imgPDF, testConfig, "PDF image", "PDF image");
		Browser.verifyURL(testConfig, expectedURL);
	}
	
	
	public EnrollmentSubmitted validateEnrollmentInfo() throws IOException
	{
		int sqlRowNo;
		Map data=null;
		//For BS
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
		{
			sqlRowNo=102;
			data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		}
		
		//For Healthcare
		else
		{
			  if(!enrollmentInfoPageObj.getTinIdentifier().equals("VO"))
			  {
				sqlRowNo=103;
				data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
				verifyFinancialInfo(data);
			  }
			  else
			  {
				sqlRowNo=104;
				data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			  }
		  
		  verifyMarketType();
		  verifyAuthEnrlTitle(data);
		  
		}
		
		
		//Organization Info
		Helper.compareEquals(testConfig, "Enrollment type",enrollmentInfoPageObj.getTinIdentifier() , data.get("PAY_METH_TYP_CD"));
		Helper.compareEquals(testConfig, "TIN",enrollmentInfoPageObj.getTin() , data.get("PROV_TIN_NBR"));
		Helper.compareEquals(testConfig, "Name",enrollmentInfoPageObj.getBusinessName() , data.get("ORG_NM"));
		Helper.compareEquals(testConfig, "Street", enrollmentInfoPageObj.getStreet(), data.get("ORG_STR"));
		Helper.compareEquals(testConfig, "City", enrollmentInfoPageObj.getCity().trim(), data.get("ORG_CTY").toString().trim());
		Helper.compareEquals(testConfig, "State", enrollmentInfoPageObj.getStateName(), data.get("ORG_ST").toString());
		Helper.compareEquals(testConfig, "Zip", enrollmentInfoPageObj.getZipCode().trim(), data.get("ORG_ZIP").toString().trim());
		
		/**
		 * NPI is not getting saved in DB in table PROVIDER PAYMENT UNIT so skipping this validation
		 */
//		Helper.compareEquals(testConfig, "NPI", enrollmentInfoPageObj.getNpi().trim(), data.get("NPI_NBR").toString().trim());
		
		
		//W9 Code
		Helper.compareEquals(testConfig, "W9 Code", enrollmentInfoPageObj.getW9DocCode(), data.get("W9_DOC_CD").toString());
		Helper.compareContains(testConfig, "W9 FILE NAME", enrollmentInfoPageObj.getTin(), data.get("FILE_NM").toString());
		
		//Primary Admin Info
		Helper.compareEquals(testConfig, "First Name", enrollmentInfoPageObj.getFrstName(), data.get("PRI_ADM_FST_NM").toString());
		Helper.compareEquals(testConfig, "Last Name", enrollmentInfoPageObj.getLstName(), data.get("PRI_ADM_LST_NM").toString());
		Helper.compareEquals(testConfig, "Phone Number", enrollmentInfoPageObj.getPhnNumbr(), data.get("PRI_ADM_TEL").toString());
		Helper.compareEquals(testConfig, "Email", enrollmentInfoPageObj.getEmail(), data.get("PRI_ADM_EML").toString());
		
		//Authorized Info
		Helper.compareEquals(testConfig, "Auth Frst Name", enrollmentInfoPageObj.getAuthFrstName(), data.get("AUTH_FST_NM").toString());
		Helper.compareEquals(testConfig, "Auth Lst Name", enrollmentInfoPageObj.getAuthLstName(), data.get("AUTH_LST_NM").toString());
		Helper.compareEquals(testConfig, "Auth_Phn Number", enrollmentInfoPageObj.getAuthPhnNbr(), data.get("AUTH_TEL_NBR").toString());
		Helper.compareEquals(testConfig, "Auth_Email", enrollmentInfoPageObj.getAuthEmail(), data.get("AUTH_EMAIL").toString());
		
//		readPDF();
		verifyEnrollmentFormIsDownloaded("EnrollmentPDF.pdf");
		enrollmentInfoPageObj.clear();
		return this;
	}
	
	public void verifyEnrollmentFormIsDownloaded(String downloadedFile) throws IOException  {
		boolean s=Helper.PDFDownloadVerification(testConfig,lnkPrintPdf,"Print Completed Enrollment Form",downloadedFile);
		System.out.println("File Downloaded: "+s);
//		if(s)
	}
	
	public void verifyAuthEnrlTitle(Map data)
	{
		Helper.compareEquals(testConfig, "Auth_Title", enrollmentInfoPageObj.getAuthTitle(), data.get("AUTH_TITLE").toString());
	}
	
	/*
	 * Verify Market type and provider type from DB
	 * Table Name- Market Designation and Market Type
	 */
	public void verifyMarketType() throws IOException
	{
		
		int	sqlRowNo=106;
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		if(!enrollmentInfoPageObj.getMrktType().trim().equals(dataTest.get(1).get("MKT_TYP_DESC").toString().trim()))
		 {
				Helper.compareEquals(testConfig, "Market Type", enrollmentInfoPageObj.getMrktType().trim(), dataTest.get(2).get("MKT_TYP_DESC").toString().trim());
				Helper.compareEquals(testConfig, "Provider Type", enrollmentInfoPageObj.getProvType().trim(), dataTest.get(1).get("MKT_TYP_DESC").toString().trim());
		 }
		else
		{
				Helper.compareEquals(testConfig, "Provider Type", enrollmentInfoPageObj.getProvType().trim(), dataTest.get(2).get("MKT_TYP_DESC").toString().trim());
				Helper.compareEquals(testConfig, "Market Type", enrollmentInfoPageObj.getMrktType().trim(), dataTest.get(1).get("MKT_TYP_DESC").toString().trim());
		}
		
	}
	
	/*
	 * data -- 
	 */
	public void verifyFinancialInfo(Map data)
	{
		Helper.compareEquals(testConfig, "Fin City", enrollmentInfoPageObj.getFinCity().trim(), data.get("FIN_CTY").toString().trim());
		Helper.compareEquals(testConfig, "Fin Street", enrollmentInfoPageObj.getFinStreet().trim(), data.get("FIN_STR").toString().trim());
		Helper.compareEquals(testConfig, "Fin State", enrollmentInfoPageObj.getFinState().trim(), data.get("FIN_ST").toString().trim());
		Helper.compareEquals(testConfig, "Fin Zip", enrollmentInfoPageObj.getFinZip().trim(), data.get("FIN_ZIP").toString().trim());
		Helper.compareEquals(testConfig, "Fin Tel", enrollmentInfoPageObj.getFinPhoneNo().trim(), data.get("FIN_TEL").toString().trim());
		Helper.compareEquals(testConfig, "Fin Bank Name", enrollmentInfoPageObj.getFinInstName().trim(), data.get("FIN_BNK_NM").toString().trim());
		Helper.compareEquals(testConfig, "Fin Acnt Nbr", enrollmentInfoPageObj.getFinAcntNo().trim(), data.get("ACNT_NBR").toString().trim());
		Helper.compareEquals(testConfig, "Fin Rte nmbr", enrollmentInfoPageObj.getFinRoutingNo().trim(), data.get("RTE_NBR").toString().trim());
		
		//verify BL or VC
		int sqlRowNo=105;
		Map BLdata=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "BL or VC", enrollmentInfoPageObj.getFinDocCode(), BLdata.get("DOC_TYP_CD").toString());
		Helper.compareContains(testConfig, "BL or VC FILE NAME", enrollmentInfoPageObj.getTin(), BLdata.get("FILE_NM").toString());
	}
	

	public String readPDF() throws IOException {
		String output="";
		String filedir=System.getProperty("user.dir")+"\\Downloads";
        testConfig.driver.get("file:///"+filedir+"\\EnrollmentPDF.pdf");
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
        return output;
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
	
	
		//camel casing and shorter name
		public void verifyEnrollmentFormIsDownloaded(String downloadedFile)  {
	
			//PDFDownloadVerification(WebElement elt,String namOfElement,String downloadedFile)
			Helper.PDFDownloadVerification(testConfig,lnkPrintPdf,"Print Completed Enrollment Form",downloadedFile);

		}

		//clickACHAddenfumRecord
		public void clickACHAddenfumRecrd() throws IOException {
			Element.click(lnkACHAddndmRcrd, " What is the ACH Addenfum Record for");
			closeTipButton();

		}

		
		//make close tip function and call in above
		public void closeTipButton() throws IOException
		{
			Element.click(closetip, "Close Tip Button");	
		}
			public void verifyExitEnrollemnt() throws IOException {
			String expected = "EXIT ENROLLMENT"; 
			String expecteHOMEURL = "returnToLoginPage.do";
			Helper.compareEquals(testConfig, "EXIT ENROLLMENT Button Text",expected, exitEnrollment.getText());
			Element.click(exitEnrollment, "EXIT ENROLLMENT");
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
