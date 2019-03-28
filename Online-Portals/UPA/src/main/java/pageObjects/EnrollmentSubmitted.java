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
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class EnrollmentSubmitted {
	protected TestBase testConfig;
	
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
	
	static Map data=null;
	static HashMap<Integer,HashMap<String,String>> dataTest=null;
	public EnrollmentSubmitted(TestBase testConfig) throws IOException 
	{
		String expectedURL = "/validateEFTERASubmit";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
//		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
//			expectedURL="/validateBSSubmit";
	
//		Element.expectedWait(lnkPrintPdf, testConfig, "Print Completed Enrollment Form", "Print Completed Enrollment Form");
//		Browser.waitTillSpecificPageIsLoaded(testConfig, testConfig.getDriver().getTitle());
//		Element.expectedWait(imgPDF, testConfig, "PDF image", "PDF image");
//		Browser.verifyURL(testConfig, expectedURL);
	}
	
	
	public EnrollmentSubmitted validateEnrollmentInfo() throws IOException
	{
		int sqlRowNo;
		Browser.wait(testConfig, 50);
//		testConfig.putRunTimeProperty("tin", "816532336"); //ACH
//		testConfig.putRunTimeProperty("tin", "784355039"); //VCP
		testConfig.putRunTimeProperty("tin", "645068088"); //BS
		//For BS
//		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
//		{
			sqlRowNo=102;
			data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
//		}
		
		//For Healthcare
//		else
		{
//			  if(!enrollmentInfoPageObj.getTinIdentifier().equals("VO"))
//			  {
//				sqlRowNo=103;
//				data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
//				verifyFinancialInfo(data);
//			  }
//			  else
//			  {
//				sqlRowNo=104;
//				data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
//			  }
		  
//		  verifyMarketType();
//		  verifyAuthEnrlTitle(data);
		  
		}
		
		
		//Organization Info
		/*Helper.compareEquals(testConfig, "Enrollment type",enrollmentInfoPageObj.getTinIdentifier() , data.get("PAY_METH_TYP_CD"));
		Helper.compareEquals(testConfig, "TIN",enrollmentInfoPageObj.getTin() , data.get("PROV_TIN_NBR"));
		Helper.compareEquals(testConfig, "Name",enrollmentInfoPageObj.getBusinessName() , data.get("ORG_NM"));
		Helper.compareEquals(testConfig, "Street", enrollmentInfoPageObj.getStreet(), data.get("ORG_STR"));
		Helper.compareEquals(testConfig, "City", enrollmentInfoPageObj.getCity().trim(), data.get("ORG_CTY").toString().trim());
		Helper.compareEquals(testConfig, "State", enrollmentInfoPageObj.getStateName(), data.get("ORG_ST").toString());
		Helper.compareEquals(testConfig, "Zip", enrollmentInfoPageObj.getZipCode().trim(), data.get("ORG_ZIP").toString().trim());
		
		*//**
		 * NPI is not getting saved in DB in table PROVIDER PAYMENT UNIT so skipping this validation
		 *//*
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
		
		System.out.println("Waiting for downloading file");
		Browser.wait(testConfig, 60);*/
//		Element.clickByJS(testConfig, lnkPrintPdf,"");
//		verifyEnrollmentFormIsDownloaded("EnrollmentPDF.pdf");
		enrollmentInfoPageObj.clear();
		return this;
	}
	
	
	public void verifyPDFData() throws IOException
	{
		String pdfData=readPDF();
		verifyTinMasking(pdfData).verifyOrgInfoInPDF(pdfData).verifyAdministrators(pdfData).verifAuthInfoInPDF(pdfData).verifyW9FormAndAuthSectionInPDF(pdfData).verifyPayerSectionInPDF(pdfData).verifyTermsAndConditionInPDF(pdfData);
		verifyFinancialInfoInPDF(pdfData);
	}
	
	public EnrollmentSubmitted verifyTinMasking(String pdfData)throws IOException
	{
		String subjectData=StringUtils.substringBetween(pdfData, "TIN:", "\n");
		Helper.compareContains(testConfig, "Masked TIN", "*****"+data.get("PROV_TIN_NBR").toString().substring(5).toString(),subjectData);
		return this;
	}
	
	public EnrollmentSubmitted verifyAdministrators(String pdfData)throws IOException
	{
		String subjectData=StringUtils.substringBetween(pdfData, "Identify Administrators", "Financial");
		Helper.compareContains(testConfig, "First Name",  data.get("PRI_ADM_FST_NM").toString(),subjectData);
		Helper.compareContains(testConfig, "Last Name",  data.get("PRI_ADM_LST_NM").toString(),subjectData);
		Helper.compareContains(testConfig, "Phone Number", data.get("PRI_ADM_TEL").toString().substring(0,3),subjectData);
		Helper.compareContains(testConfig, "Phone Number", data.get("PRI_ADM_TEL").toString().substring(3,6),subjectData);
		Helper.compareContains(testConfig, "Phone Number", data.get("PRI_ADM_TEL").toString().substring(6),subjectData);
//		Helper.compareContains(testConfig, "Email",  data.get("PRI_ADM_EML").toString(),subjectData);
		
		return this;
	}
	
	public EnrollmentSubmitted verifyTermsAndConditionInPDF(String pdfData)throws IOException
	{
		String subjectData=StringUtils.substringBetween(pdfData, "EPS EFT Provider Authorization", "\n");
		Helper.compareContains(testConfig, "T&C", "Terms and Conditions Agreement",subjectData);
		return this;
	}
	
	public EnrollmentSubmitted verifyW9FormAndAuthSectionInPDF(String pdfData)throws IOException
	{
		String subjectData=StringUtils.substringBetween(pdfData, "Authorization", "Authorized Enroller's");
		Helper.compareContains(testConfig, "W9", "A copy of your W9 was uploaded with your Enrollment submission",subjectData);
		Helper.compareContains(testConfig, "Authorization Section", "I accept these Terms and Conditions",subjectData);
		return this;
	}
	
	public EnrollmentSubmitted verifyPayerSectionInPDF(String pdfData)throws IOException
	{
		String subjectData=StringUtils.substringBetween(pdfData, "Payer", "Page");
		Helper.compareContains(testConfig, "Payer", "Information",subjectData);
		switch(data.get("PAY_METH_TYP_CD").toString())
		{
		case "AO":
			Helper.compareContains(testConfig, "Payment Method", "ACH",subjectData);
			break;
		case "AV":
			Helper.compareContains(testConfig, "Payment Method", "",subjectData);
			break;
		case "VO":
			Helper.compareContains(testConfig, "Payment Method", "VCP",subjectData);
			break;
		}
		return this;
	}
	
	
	public EnrollmentSubmitted verifyOrgInfoInPDF(String pdfData)throws IOException
	{
		String subjectData=StringUtils.substringBetween(pdfData, "Organization Information", "Identify");
		switch(data.get("PAY_METH_TYP_CD").toString())
		{
		case "AO":
			Helper.compareContains(testConfig, "Enrollment type", "ACH Only",subjectData);
			break;
		case "AV":
			Helper.compareContains(testConfig, "Enrollment type", "",subjectData);
			break;
		case "VO":
			Helper.compareContains(testConfig, "Enrollment type", "VCP Only",subjectData);
			break;
		}
		Helper.compareContains(testConfig, "Name", data.get("ORG_NM").toString(),subjectData);
		Helper.compareContains(testConfig, "Street",  data.get("ORG_STR").toString(),subjectData);
		Helper.compareContains(testConfig, "City",  data.get("ORG_CTY").toString().trim(),subjectData);
		Helper.compareContains(testConfig, "State", data.get("ORG_ST").toString(),subjectData);
		Helper.compareContains(testConfig, "Zip",  data.get("ORG_ZIP").toString().trim(),subjectData);
//		if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
		{
			Helper.compareContains(testConfig, "Provider Type",dataTest.get(2).get("MKT_TYP_DESC").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Market Type",dataTest.get(1).get("MKT_TYP_DESC").toString().trim(),subjectData);
		}
		return this;
	}
	
	public EnrollmentSubmitted verifAuthInfoInPDF(String pdfData)throws IOException
	{
		String subjectData=StringUtils.substringBetween(pdfData, "Authorized Enroller's Information", "Page");
		Helper.compareContains(testConfig, "Auth Frst Name",data.get("AUTH_FST_NM").toString(),subjectData);
		Helper.compareContains(testConfig, "Auth Lst Name", data.get("AUTH_LST_NM").toString(),subjectData);
		Helper.compareContains(testConfig, "Auth_Phn Number",data.get("AUTH_TEL_NBR").toString().substring(0, 3),subjectData);
		Helper.compareContains(testConfig, "Auth_Phn Number",data.get("AUTH_TEL_NBR").toString().substring(3, 6),subjectData);
		Helper.compareContains(testConfig, "Auth_Phn Number",data.get("AUTH_TEL_NBR").toString().substring(6),subjectData);
//		Helper.compareContains(testConfig, "Auth_Email",data.get("AUTH_EMAIL").toString().trim(),subjectData);
	
		return this;
	}
	
	public EnrollmentSubmitted verifyFinancialInfoInPDF(String pdfData)throws IOException
	{
		String subjectData=StringUtils.substringBetween(pdfData, "Financial Institution", "Page");
		
//		if(enrollmentInfoPageObj.getTinIdentifier().equals("VO"))
//		{
//			if(subjectData==null) 
//				subjectData="";
//			Helper.compareEquals(testConfig, "Financial Information is not present", "", subjectData);
//		}
//		else
		{
			Helper.compareContains(testConfig, "Fin City", data.get("FIN_CTY").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin Street", data.get("FIN_STR").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin State",  data.get("FIN_ST").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin Zip",data.get("FIN_ZIP").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin Tel", data.get("FIN_TEL").toString().trim().substring(0, 3),subjectData);
			Helper.compareContains(testConfig, "Fin Tel", data.get("FIN_TEL").toString().trim().substring(3, 6),subjectData);
			Helper.compareContains(testConfig, "Fin Tel", data.get("FIN_TEL").toString().trim().substring(6),subjectData);
			Helper.compareContains(testConfig, "Fin Bank Name", data.get("FIN_BNK_NM").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin Acnt Nbr",  data.get("ACNT_NBR").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin Rte nmbr",  data.get("RTE_NBR").toString().trim(),subjectData);
			
			int sqlRowNo=148;
			Map npiData=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			Helper.compareContains(testConfig, "Fin NPI City", npiData.get("CTY_NPI").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin NPI Street", npiData.get("ADR_NPI").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin NPI State",  npiData.get("ST_NPI").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin NPI Zip",npiData.get("ZIP_NPI").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin NPI Tel", npiData.get("TEL_NPI").toString().trim().substring(0, 3),subjectData);
			Helper.compareContains(testConfig, "Fin NPI Tel", npiData.get("TEL_NPI").toString().trim().substring(3, 6),subjectData);
			Helper.compareContains(testConfig, "Fin NPI Tel", npiData.get("TEL_NPI").toString().trim().substring(6),subjectData);
			Helper.compareContains(testConfig, "Fin NPI Bank Name", npiData.get("BNK_NM_NPI").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin NPI Acnt Nbr",  npiData.get("BNK_ACCT_NPI").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin NPI Rte nmbr",  npiData.get("RTE_NPI").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin NPI nmbr",  npiData.get("NPI_NBR").toString().trim(),subjectData);
			
		}
		return this;
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
		dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
//		if(!enrollmentInfoPageObj.getMrktType().trim().equals(dataTest.get(1).get("MKT_TYP_DESC").toString().trim()))
//		 {
//				Helper.compareEquals(testConfig, "Market Type", enrollmentInfoPageObj.getMrktType().trim(), dataTest.get(2).get("MKT_TYP_DESC").toString().trim());
//				Helper.compareEquals(testConfig, "Provider Type", enrollmentInfoPageObj.getProvType().trim(), dataTest.get(1).get("MKT_TYP_DESC").toString().trim());
//		 }
//		else
//		{
//				Helper.compareEquals(testConfig, "Provider Type", enrollmentInfoPageObj.getProvType().trim(), dataTest.get(2).get("MKT_TYP_DESC").toString().trim());
//				Helper.compareEquals(testConfig, "Market Type", enrollmentInfoPageObj.getMrktType().trim(), dataTest.get(1).get("MKT_TYP_DESC").toString().trim());
//		}
		
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
//        testConfig.driver.get("file:///"+filedir+"\\EnrollmentPDF.pdf"); //  OnlineBillingServiceEnroll_PDF
        testConfig.driver.get("file:///"+filedir+"\\OnlineBillingServiceEnroll_PDF.pdf");
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
	

		public  EnrollmentSubmitted verifyHeaders() {

		List<String> headers = Arrays.asList("Billing Service Information","Organization Information",
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
		return this;
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
