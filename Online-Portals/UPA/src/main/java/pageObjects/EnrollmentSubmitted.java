package main.java.pageObjects;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import main.java.queries.QUERY;
import main.java.reporting.Log;
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;




import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class EnrollmentSubmitted  {
	protected TestBase testConfig;
	
	@FindBy(partialLinkText = "What is the ACH Addenfum Record")
	WebElement lnkACHAddndmRcrd;

	@FindBy(xpath = "//a[@class='button--primary margin-left float-right btn-close']")
	WebElement closetip;

	@FindBy(xpath = "//span[@class='progress-indicator__circle']")
	List<WebElement> OrgCircle;

	@FindBy(xpath = "//span[@class='progress-indicator__title']")
	List<WebElement> OrgInfoHeaders;
	
	@FindBy(xpath = "//a[@class='progress-indicator__title']")
	List<WebElement> OrgInfoHeadersBS;

	
	
	
	@FindBy(xpath="//fieldset" )
	WebElement fieldset;
	


	@FindBy(xpath = "//a[@class='button--primary enrollment-container-footer__btn-margin float-right']")
	WebElement exitEnrollment;
	
	@FindBy(xpath=".//*[@id='EFTERAregForm']//div[1]/p[4]/span")
	WebElement imgPDF;

	
	@FindBy(linkText="Print Completed Enrollment Form")
	WebElement lnkPrintPdf;
	
	@FindBy(id="BSETForm")
	List<WebElement> pageBody;
 	
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();
	String subjectData=null;
	static Map data=null;
	static HashMap<Integer,HashMap<String,String>> dataTest=null;
	public EnrollmentSubmitted(TestBase testConfig) 
	{
		String expectedURL = "/validateEFTERASubmit";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
			expectedURL="/validateBSSubmit";
	
		Browser.checkPageReadyState(testConfig.driver);
		Element.waitForPresenceOfElementLocated(this.testConfig,By.linkText("Print Completed Enrollment Form"),120);
		
		Element.expectedWait(lnkPrintPdf, testConfig, "Print Completed Enrollment Form", "Print Completed Enrollment Form");
		Browser.waitTillSpecificPageIsLoaded(testConfig, testConfig.getDriver().getTitle());
		
		Browser.verifyURL(testConfig, expectedURL);
	}
	public EnrollmentSubmitted validateRowfrVOTIN() throws IOException
	{
		if(enrollmentInfoPageObj.getTinIdentifier().equals("VO"))
		  {
			int sqlRowNo=1614;
			testConfig.putRunTimeProperty("Prov_Tin", enrollmentInfoPageObj.getTin());
			data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			if (data.size()!=0)
			Log.Pass("Row inserted in Product Selection Table");
			else
			{
				Log.Fail("Fail to insert row in Product Selection Table");
			}
			
		  }
	return this;
	}
	
	public EnrollmentSubmitted validateEnrollmentInfo() throws IOException
	{
		int sqlRowNo;
		testConfig.putRunTimeProperty("tin",enrollmentInfoPageObj.getTin());
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
		
		enrollmentInfoPageObj.clear();
		return this;
	}
	
	
	public void verifyPDFData() throws IOException
	{
		if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
			verifyEnrollmentFormIsDownloaded("EnrollmentPDF.pdf");
		else
			verifyEnrollmentFormIsDownloaded("OnlineBillingServiceEnroll_PDF.pdf");
		String pdfData=readPDF();
		verifyTinMasking(pdfData).verifyOrgInfoInPDF(pdfData).verifyAdministrators(pdfData).verifAuthInfoInPDF(pdfData).verifyW9FormAndAuthSectionInPDF(pdfData).verifyTermsAndConditionInPDF(pdfData);
		if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
			verifyFinancialInfoInPDF(pdfData).verifyPayerSectionInPDF(pdfData);
	}
	
	public EnrollmentSubmitted verifyTinMasking(String pdfData)throws IOException
	{
		//subjectData contains TIN details from PDF
		Log.Comment("Expected data contains masked Tin and Actual Data contains Masked Tin Segment");
		if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
			subjectData=StringUtils.substringBetween(pdfData, "TIN:", "\n");
		else
			subjectData=StringUtils.substringBetween(pdfData, "Billing Service Tax Identification Number:", "\n"); 
		Helper.compareContains(testConfig, "Masked TIN", "*****"+data.get("PROV_TIN_NBR").toString().substring(5).toString(),subjectData);
		return this;
	}
	
	public EnrollmentSubmitted verifyAdministrators(String pdfData)throws IOException
	{
		//subjectData contains Administrators info from PDF
		Log.Comment("Expected data contains Administrators Info from DB and Actual Data contains Administrators info paragraph from PDF");
		if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
			subjectData=StringUtils.substringBetween(pdfData, "Identify Administrators", "Financial");
		else
			subjectData=StringUtils.substringBetween(pdfData, "Identify Administrators", "Authorization");
		
		Helper.compareContains(testConfig, "First Name",  data.get("PRI_ADM_FST_NM").toString(),subjectData);
		Helper.compareContains(testConfig, "Last Name",  data.get("PRI_ADM_LST_NM").toString(),subjectData);
		Helper.compareContains(testConfig, "Phone Number", data.get("PRI_ADM_TEL").toString().substring(0,3),subjectData);
		Helper.compareContains(testConfig, "Phone Number", data.get("PRI_ADM_TEL").toString().substring(3,6),subjectData);
		//Helper.compareContains(testConfig, "Phone Number", data.get("PRI_ADM_TEL").toString().substring(6),subjectData);
		Helper.compareContains(testConfig, "Email",  data.get("PRI_ADM_EML").toString(),subjectData);
		
		return this;
	}
	
	public EnrollmentSubmitted verifyTermsAndConditionInPDF(String pdfData)throws IOException
	{
		//subjectData contains Terms And Condition Block from PDF
		Log.Comment("Expected data contains Terms and Condition and Actual Data contains Terms and Condition paragraph from PDF");
		if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
			subjectData=StringUtils.substringBetween(pdfData, "Optum Pay Enrollment Agreement", "\n");
		else
			subjectData=StringUtils.substringBetween(pdfData, "EPS Billing Service Authorization", "\n");
		Helper.compareContains(testConfig, "T&C", "Terms and Conditions",subjectData);
		return this;
	}
	
	public EnrollmentSubmitted verifyW9FormAndAuthSectionInPDF(String pdfData)throws IOException
	{
		//subjectData contains Authorization section 
		Log.Comment("Expected data contains Auth Name Info from DB, Accept Terms and condition and Actual Data contains w9Form and Auth Section info paragraph from PDF");
		subjectData=StringUtils.substringBetween(pdfData, "Authorization", "Authorized Enroller's");
		Helper.compareContains(testConfig, "W9", "A copy of your W9 was uploaded with your Enrollment submission",subjectData);
		Helper.compareContains(testConfig, "Authorization Section", "I accept these Terms and Conditions",subjectData);
		Helper.compareContains(testConfig, "Auth Frst Name",data.get("AUTH_FST_NM").toString(),subjectData);
		Helper.compareContains(testConfig, "Auth Lst Name", data.get("AUTH_LST_NM").toString(),subjectData);
		return this;
	}
	
	public EnrollmentSubmitted verifyPayerSectionInPDF(String pdfData)throws IOException
	{
		//subjectData contains PayerSection Info in PDF
		Log.Comment("Expected data contains Payer Info and Actual Data contains Payer info paragraph from PDF");
		subjectData=StringUtils.substringBetween(pdfData, "Payer", "Page");
		Helper.compareContains(testConfig, "Payer", "Information",subjectData);
		switch(data.get("PAY_METH_TYP_CD").toString())
		{
		case "AO":
			Helper.compareContains(testConfig, "Payment Method", "ACH",subjectData);
			break;
		case "AV":
			Helper.compareContains(testConfig, "Payment Method", "VCP",subjectData);
			Helper.compareContains(testConfig, "Payment Method", "ACH",subjectData);
			break;
		case "VO":
			Helper.compareContains(testConfig, "Payment Method", "VCP",subjectData);
			break;
		}
		return this;
	}
	
	
	public EnrollmentSubmitted verifyOrgInfoInPDF(String pdfData)throws IOException
	{
		//subjectData contains Organization info from PDF
		Log.Comment("Expected data contains Organisation Info from DB and Actual Data contains organisation info paragraph from PDF");
		if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
			subjectData=StringUtils.substringBetween(pdfData, "Organization Information", "Identify");
		else
			subjectData=StringUtils.substringBetween(pdfData, "Billing Service Information", "Identify");
		switch(data.get("PAY_METH_TYP_CD").toString())
		{
		case "AO":
			Helper.compareContains(testConfig, "Enrollment type", "ACH Only",subjectData);
			break;
		case "AV":
			Helper.compareContains(testConfig, "Enrollment type", "ACH and VCP",subjectData);
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
		if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
		{
			Helper.compareContains(testConfig, "Provider Type",dataTest.get(2).get("MKT_TYP_DESC").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Market Type",dataTest.get(1).get("MKT_TYP_DESC").toString().trim(),subjectData);
		}
		return this;
	}
	
	public EnrollmentSubmitted verifAuthInfoInPDF(String pdfData)throws IOException
	{
		//subjectData contains authorization info in PDF
		Log.Comment("Expected data contains Authorization Info from DB and Actual Data contains Authorization info paragraph from PDF");
		subjectData=StringUtils.substringBetween(pdfData, "Authorized Enroller's Information", "Page");
		Helper.compareContains(testConfig, "Auth Frst Name",data.get("AUTH_FST_NM").toString(),subjectData);
		Helper.compareContains(testConfig, "Auth Lst Name", data.get("AUTH_LST_NM").toString(),subjectData);
		Helper.compareContains(testConfig, "Auth_Phn Number",data.get("AUTH_TEL_NBR").toString().substring(0, 3),subjectData);
		Helper.compareContains(testConfig, "Auth_Phn Number",data.get("AUTH_TEL_NBR").toString().substring(3, 6),subjectData);
		Helper.compareContains(testConfig, "Auth_Phn Number",data.get("AUTH_TEL_NBR").toString().substring(6),subjectData);
		//Helper.compareContains(testConfig, "Auth_Email",data.get("AUTH_EMAIL").toString().trim(),subjectData);
	
		return this;
	}
	
	public EnrollmentSubmitted verifyFinancialInfoInPDF(String pdfData)throws IOException
	{
		//subjectData contains FinancialInfo in PDF
		Log.Comment("Expected data contains Financial Info from DB and Actual Data contains Financial info paragraph from PDF");
		subjectData=StringUtils.substringBetween(pdfData, "Financial Institution", "Page");
		
		if(enrollmentInfoPageObj.getTinIdentifier().equals("VO") || enrollmentInfoPageObj.getEnrollType().equals("BS"))
		{
			if(subjectData==null) 
				subjectData="";
			Helper.compareEquals(testConfig, "Financial Information is not present", "", subjectData);
		}
		else
		{
			Helper.compareContains(testConfig, "Fin City", data.get("FIN_CTY").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin Street", data.get("FIN_STR").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin State",  data.get("FIN_ST").toString().trim(),subjectData);
			//Helper.compareContains(testConfig, "Fin Zip",data.get("FIN_ZIP").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin Tel", data.get("FIN_TEL").toString().trim().substring(0, 3),subjectData);
			Helper.compareContains(testConfig, "Fin Tel", data.get("FIN_TEL").toString().trim().substring(3, 6),subjectData);
			Helper.compareContains(testConfig, "Fin Tel", data.get("FIN_TEL").toString().trim().substring(6),subjectData);
			Helper.compareContains(testConfig, "Fin Bank Name", data.get("FIN_BNK_NM").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin Acnt Nbr",  data.get("ACNT_NBR").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin Rte nmbr",  data.get("RTE_NBR").toString().trim(),subjectData);
			
			int sqlRowNo=154;
			Map npiData=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			Helper.compareContains(testConfig, "Fin NPI City", npiData.get("CTY_NPI").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin NPI Street", npiData.get("ADR_NPI").toString().trim(),subjectData);
			Helper.compareContains(testConfig, "Fin NPI State",  npiData.get("ST_NPI").toString().trim(),subjectData);
			//Helper.compareContains(testConfig, "Fin NPI Zip",npiData.get("ZIP_NPI").toString().trim(),subjectData);
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
		
		//Verify Business phone and extension		
		Map BPData=DataBase.executeSelectQuery(testConfig, QUERY.BusinessPhone_ENROLLED_PROVIDER, 1);
		Helper.compareEquals(testConfig, "Business Phone", enrollmentInfoPageObj.getBusinessPhone1().trim()+enrollmentInfoPageObj.getBusinessPhone2().trim()+enrollmentInfoPageObj.getBusinessPhone3().trim(), BPData.get("BUSINESS_PHONE").toString().trim());
		Helper.compareEquals(testConfig, "Business Phone Extension", enrollmentInfoPageObj.getBusinessPhoneExt().trim(), BPData.get("BUSINESS_PHONE_EXT").toString().trim());
		
		
		//verify BL or VC
		int sqlRowNo=105;
		Map BLdata=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "BL or VC", enrollmentInfoPageObj.getFinDocCode(), BLdata.get("DOC_TYP_CD").toString());
		Helper.compareContains(testConfig, "BL or VC FILE NAME", enrollmentInfoPageObj.getTin(), BLdata.get("FILE_NM").toString());
	}
	

	public void verifyPageUI(TestBase testBase)  {
		
		ApprovdUIPage agreedpage=new ApprovdUIPage();
		
		ArrayList<String> lstofexpectedUIText=new ArrayList<String>();
		ArrayList<String> lstofexpectedUIFont=new ArrayList<String>();
		ArrayList<String> lstofexpectedUIColor=new ArrayList<String>();

		ArrayList<String> lstofEnrolmntSbmtpage=new ArrayList<String>();
		ArrayList<String> lstofEnrolmntSbmtpageFont=new ArrayList<String>();
		ArrayList<String> lstofEnrolmntSbmtpageColr=new ArrayList<String>();

		for (WebElement wblt:agreedpage.OrgInfoforAO)
		{
			lstofexpectedUIText.add(wblt.getText().replace("\n", " "));
			lstofexpectedUIColor.add(Color.fromString((wblt.getCssValue("color"))).asHex());
			lstofexpectedUIFont.add (wblt.getCssValue("font-weight"));
		}
		
		for (WebElement wblt:OrgInfoHeaders)
		{
			
			lstofEnrolmntSbmtpage.add(wblt.getText().replace("\n", " "));
			lstofEnrolmntSbmtpageColr.add(Color.fromString((wblt.getCssValue("color"))).asHex());
			lstofEnrolmntSbmtpageFont.add (wblt.getCssValue("font-weight"));
		}

		 Helper.compareEquals(testConfig, "Headrs text Comparison",lstofexpectedUIText, lstofEnrolmntSbmtpage);
		 Helper.compareEquals(testConfig, "Headrs text color Comparison",lstofexpectedUIColor, lstofEnrolmntSbmtpageColr);
		 Helper.compareEquals(testConfig, "Headers text font Comparison",lstofexpectedUIFont, lstofEnrolmntSbmtpageFont);


		 if ((agreedpage.fieldset.getText().substring(0, 457)).equalsIgnoreCase(fieldset.getText().substring(0, 457))  
				 && (agreedpage.fieldset.getText().substring(458, 477)).equalsIgnoreCase(fieldset.getText().substring(458, 477)) 
				 && (agreedpage.fieldset.getText().substring(479)).equalsIgnoreCase(fieldset.getText().substring(479)) 
				 )
		 {
			 Log.Pass("Passes the text comparision of Enrollment Submitted Page and Approved HTML page ");
		 }
		 else
		 {
			 Log.Fail("Failed the text comparision of Enrollment Submitted Page and Approved HTML page ");
		 }
		
		
	}
	

	
	
	


	public String readPDF() throws IOException {
		Browser.wait(testConfig, 2);
		String output="";
		String filedir=System.getProperty("user.dir")+"\\Downloads";
		if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
			testConfig.driver.get("file:///"+filedir+"\\EnrollmentPDF.pdf");
		else
			testConfig.driver.get("file:///"+filedir+"\\OnlineBillingServiceEnroll_PDF.pdf");
		Browser.wait(testConfig, 2);
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

	/*public  EnrollmentSubmitted verifyHeaders() 
	 {
		  List<String> headers = Arrays.asList("Organization Information","Identify Administrators", "Financial Institution Information","Select Payment Methods", "Upload W9", "Review and Submit");
		  for (int i = 0; i < (OrgInfoHeaders.size()); i++) {
		  
		  if (!(OrgInfoHeaders.get(i).getText().replace("\n", " ")).equalsIgnoreCase("Enrollment Submitted")&& headers.get(i).equalsIgnoreCase((OrgInfoHeaders.get(i).getText().replace("\n", " "))))
			{
				Helper.compareEquals(testConfig,"Color Value for "+ (OrgInfoHeaders.get(i).getText().replace("\n", " ")) + " Information is:","#e87722",Color.fromString(OrgInfoHeaders.get(i).getCssValue("color")).asHex());
				Helper.compareEquals(testConfig, "font weight for "+ (OrgInfoHeaders.get(i).getText().replace("\n", " "))+ " Information is:", "400", OrgInfoHeaders.get(i).getCssValue("font-weight"));
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
	}*/


	public void verifyHeadersFunctionality(List<String> headers)
	{
		List<WebElement> Headers;
		if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
			Headers=OrgInfoHeaders;
		else
			Headers=OrgInfoHeadersBS;
		for (int i = 0; i < (Headers.size()); i++) {
			if ( !(Headers.get(i).getText().replace("\n", " ")).equalsIgnoreCase("Enrollment Submitted") 
					&& headers.get(i).equalsIgnoreCase((Headers.get(i).getText().replace("\n", " "))))
				{
					Helper.compareEquals(testConfig, "font weight for "+ (Headers.get(i).getText().replace("\n", " "))+ " Information is:", "400", Headers.get(i).getCssValue("font-weight"));
				}
			if ((Headers.get(i).getText().replace("\n", " ")).equalsIgnoreCase("Enrollment Submitted")&& OrgCircle.get(i).isDisplayed() == true) 
				Helper.compareEquals(testConfig,"Bold font with circle is present for "+ (Headers.get(i).getText().replace("\n", " ")), "900",Headers.get(i).getCssValue("font-weight"));		

			Helper.compareEquals(testConfig,"Color Value for "+ (Headers.get(i).getText().replace("\n", " ")) + " Information is:","#e87722",Color.fromString(Headers.get(i).getCssValue("color")).asHex());
		}
	}
	
	public  EnrollmentSubmitted verifyHeaders() {

	     List<String> headersAV = Arrays.asList("Organization Information","Identify Administrators", "Financial Institution Information","Select Payment Methods", "Upload W9", "Review and Submit");
		 List<String> headersAO = Arrays.asList("Organization Information","Identify Administrators", "Financial Institution Information", "Upload W9", "Review and Submit");
		 List<String> headersVO = Arrays.asList("Organization Information","Identify Administrators", "Upload W9", "Review and Submit");
		 List<String> headersBS = Arrays.asList("Billing Service Information","Identify Administrators", "Upload W9", "Review and Submit");
			
		 
		 switch(enrollmentInfoPageObj.getTinIdentifier())
		 {
		 case "AV":
			 verifyHeadersFunctionality(headersAV);
			 break;

		 case "AO":
			 verifyHeadersFunctionality(headersAO);
			 break;			 
		 case "VO":
			 verifyHeadersFunctionality(headersVO);
			 break;			 

		 default:
			 verifyHeadersFunctionality(headersBS);
			 break;
			 
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
			Element.verifyElementNotPresent(closetip, "Close Tip Button");
			
		}
		

		public void verifyExitEnrollemnt() throws IOException 
		{

			String expected = "EXIT ENROLLMENT"; 
			String expecteHOMEURL = "returnToLoginPage.do";
			Element.expectedWait(exitEnrollment, testConfig, "EXIT ENROLLMENT Button Text", "EXIT ENROLLMENT Button Text");
            Helper.compareEquals(testConfig, "EXIT ENROLLMENT Button Text",expected, exitEnrollment.getText());
			Element.click(exitEnrollment, "EXIT ENROLLMENT");
			if(System.getProperty("Application").contains("CSR"))
			Browser.verifyURL(testConfig, "viewwelcome.do");
			else
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
		
		
		public EnrollmentSubmitted verifyPageContextforBS() throws IOException
		{
			int sqlRowNo=162;
			HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
			Element.expectedWait(pageBody.get(0).findElement(By.tagName("h1")), testConfig, "Heading", "Heading");
			Helper.compareEquals(testConfig, " Heading", pageBody.get(0).findElements(By.tagName("h1")).get(0).getText(), dataTest.get(1).get("TEXT_VAL"));
			Helper.compareEquals(testConfig, "Paragraph 1", pageBody.get(0).findElements(By.tagName("p")).get(0).getText(), dataTest.get(2).get("TEXT_VAL"));
			Helper.compareEquals(testConfig, "Paragraph 2", pageBody.get(0).findElements(By.tagName("p")).get(1).getText(), dataTest.get(3).get("TEXT_VAL")+"\n"+dataTest.get(4).get("TEXT_VAL"));
			Helper.compareEquals(testConfig, "Paragraph 3", pageBody.get(0).findElements(By.tagName("p")).get(2).getText(), dataTest.get(5).get("CLOBVAL"));
			Helper.compareEquals(testConfig, "PDF link",pageBody.get(0).findElements(By.tagName("a")).get(0).getText(), dataTest.get(6).get("TEXT_VAL"));
			Helper.compareEquals(testConfig, "Sub Heading", pageBody.get(0).findElements(By.tagName("h1")).get(1).getText(), dataTest.get(7).get("TEXT_VAL"));
			Helper.compareEquals(testConfig, " Paragraph 4", pageBody.get(0).findElements(By.tagName("li")).get(0).getText(), dataTest.get(8).get("CLOBVAL"));
			Helper.compareEquals(testConfig, " Paragraph 5", pageBody.get(0).findElements(By.tagName("li")).get(1).getText(), dataTest.get(9).get("CLOBVAL"));
			Helper.compareEquals(testConfig, " Exit button", pageBody.get(0).findElements(By.tagName("a")).get(1).getText(), dataTest.get(10).get("TEXT_VAL"));
			
			return this;
		}
		
		
		
}
