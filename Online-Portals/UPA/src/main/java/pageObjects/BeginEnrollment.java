package main.java.pageObjects;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.reporting.Log;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeginEnrollment {
	
	@FindBy(xpath="//label[contains(text(),'Health')]")
	WebElement rdoHealthPlanCommunication;

	@FindBy(xpath="//label[contains(text(),'Provider')]")
	WebElement rdoProviderAdvocateRecommendation;
	
	@FindBy(xpath="//label[contains(text(),'Optum outreach')]")
	WebElement rdoOptumOutreachTeam;
	
	@FindBy(xpath="//label[contains(text(),'Optum email')]")
	WebElement rdoOptumEmailOrCommunications;
	
	@FindBy(xpath="//label[contains(text(),'Other')]")
	WebElement rdoOther;
	
	@FindBy(linkText="CONTINUE")
	WebElement btnContinue;
	
	@FindBy(xpath=".//*[@id='EFTERAenrForm']/div[1]/p[5]/a[1]")
	WebElement dwnldAchGuide;
	
	@FindBy(xpath=".//*[@id='EFTERAenrForm']/div[1]/p[5]/a[2]")
	WebElement dwnldVcpGuide;
	
	@FindBy(xpath=".//*[@id='EFTERAenrForm']/div[1]/p[6]/a[1]")
	WebElement dwnldBSGuide;
	
	@FindBy(xpath=".//*[@id='EFTERAenrForm']/div[1]/div/div/span[2]")
	WebElement aboutEPS;
	
	@FindBy(id="text1")
	WebElement otherRadioTextBox;
	
	@FindBy(linkText="No")
	WebElement btnCancelEnrollmentNo;
	
	@FindBy(linkText="Yes")
	WebElement btnCancelEnrollmentYes;	
	
	@FindBy(xpath="//ul[@class='unstyled-list']//li")
	java.util.List<WebElement> beginEnrlmntAnswersOnline;
	
	@FindBy(xpath="//form[@id='EFTERAenrForm']/div/div/div/span[2]")
	WebElement beginEnrlmntQuesOnline;
	
	@FindBy(linkText="Cancel Enrollment")
	WebElement btnCancelEnrollment;
	
	@FindBy(linkText="Privacy Policy")
	WebElement lnkPolicy;
	
	@FindBy(linkText="Terms of Use")
	WebElement lnkUseTerms;
	
	@FindBy(xpath="//footer//nobr")
	WebElement optum;
	
	
	@FindBy(xpath="//header/div/div[1]")
	WebElement hdrTitle;
	
	@FindBy(xpath="//header/div/div[2]")
	WebElement hdrSubTitle; 
	
	@FindBy(xpath=".//*[@id='EFTERAenrForm']/div[1]/div/div/span[2]")
	WebElement ques;
	
	@FindBy(xpath=".//*[@id='EFTERAenrForm']/div[1]")
	List<WebElement> pageBody;
	
	@FindBy(xpath="//*[@id='EFTERAenrForm']/div[2]/div[1]")
	List<WebElement> popUp;
	
	private TestBase testConfig;
		
	EnrollmentInfo enrollment =EnrollmentInfo.getInstance();

		
	public BeginEnrollment(TestBase testConfig) {
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.expectedWait(btnContinue, testConfig, "Continue Button", "Continue Button");
		
	}
	
	
	public BeginEnrollmentContinue selectHowYouHeard(String option)
	{
		Browser.wait(testConfig, 2);
		Element.expectedWait(rdoHealthPlanCommunication, testConfig, "Health plan communication", "Health plan communication");
		
		if(option.equals("Health plan communication"))
		{
			Element.click(rdoHealthPlanCommunication, "Health plan communication");
			if(!rdoHealthPlanCommunication.isSelected())
				Element.click(rdoHealthPlanCommunication, "Health plan communication");	
		}
		else if(option.equals("Provider Advocate recommendation"))
			Element.click(rdoProviderAdvocateRecommendation, "Provider Advocate recommendation");
		else if(option.equals("Optum outreach team"))
			Element.click(rdoOptumOutreachTeam, "Optum outreach team");
		else if(option.equals("Optum email or communications"))
			Element.click(rdoOptumEmailOrCommunications, "Optum email or communications");
		else if(option.equals("Other"))
			Element.click(rdoOther, "Other");
		
//		clickContinue();
//		return new BeginEnrollmentContinue(testConfig);
		BeginEnrollmentContinue beginEnrollmentContinue=clickContinue();
		return  beginEnrollmentContinue;
	}
	
	public BeginEnrollmentContinue clickContinue()
	{
		Element.click(btnContinue, "Continue button");
		return new BeginEnrollmentContinue(testConfig);
	}
	
	public void validateBeginEnrollment() {
		String expectedURL = "beginEnrollment.do";
		Browser.verifyURL(testConfig, expectedURL);
		Element.verifyElementPresent(dwnldAchGuide, "Download ACH Enrollment Guide");
		Element.verifyElementPresent(dwnldVcpGuide, "Download VCP Enrollment Guide");
		Element.verifyElementPresent(dwnldBSGuide, "Download Billing Service Enrollment Guide");
		Element.verifyElementPresent(aboutEPS, "To get started, please let us know how you heard about EPS?");
		Element.verifyTextPresent(rdoHealthPlanCommunication, "Health plan communication");
	}
	
	public BeginEnrollmentContinue selectOtherToValidateErrorMessage() {
		Element.click(rdoOther, "Other Radio Button");
		Element.verifyElementPresent(otherRadioTextBox, "Text box appeared after selecting Other radio button");
		return clickContinue();	
	}
	
	public void validateTextBoxCharLmt() {
		int sqlRowNo=108;
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		String textToEnter="This text is to test limit of fifty chars. This text is to test limit of fifty chars.";
		String expectedText="This text is to test limit of fifty chars. This te";
		Element.click(rdoOther, "Other Radio Button");
		Element.verifyElementPresent(otherRadioTextBox, "Text box appreaded after selecting Other radio button");
		Element.enterData(otherRadioTextBox, textToEnter, "Testing char limit of text box - Max limit is 50 chars\n"
				+ "We are trying to enter - "+textToEnter+"\n"
				+ "But we would be able to enter only - "+expectedText, "Text box appeared after selecting other radion button");		
		Helper.compareEquals(testConfig, "", expectedText, otherRadioTextBox.getAttribute("value"));
		clickContinue();
		testConfig.putRunTimeProperty("timestamp", timeStamp.toString());
		Map surveyResponse = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		int recordCount=Integer.parseInt(surveyResponse.get("RECORD_COUNT").toString().trim());
		if(recordCount<1) {
			Log.Fail("Unable to found entry in survey response table");
		}
	}
	
	public BeginEnrollment validateCancelEnrollmentBtnNo() {
		Element.click(btnCancelEnrollment, "Cancel Enrollment");
		Browser.wait(testConfig, 1);
		Element.click(btnCancelEnrollmentNo, "Cancel Enrollment No Button");
		return this;
	}
	
	public UPARegistrationPage validateCancelEnrollmentBtnYes() {
		Element.click(btnCancelEnrollment, "Cancel Enrollment");
		Browser.wait(testConfig, 1);
		Element.click(btnCancelEnrollmentYes, "Cancel Enrollment Yes Button");	
		return new UPARegistrationPage(testConfig);
	}
	
	public void validateUserIsAbleToDwnldEnrlmntPdf() {
		validateBeginEnrollment();
		Element.click(dwnldAchGuide, "Download ACH Enrollment Guide");
		String handle =Browser.switchToNewWindow(testConfig, "EPS_Enrollment_guide_ACH_v6.pdf"); 

		Browser.switchToNewWindow(testConfig, "beginEnrollment.do");
		Element.click(dwnldVcpGuide, "Download VCP Enrollment Guide");
		Browser.switchToNewWindow(testConfig, "EPS_Enrollment_guide_VCP_v6.pdf");
		Browser.switchToParentWindow(testConfig, handle);
		Element.click(dwnldBSGuide, "Download Billing Service Enrollment Guide");
		Browser.switchToNewWindow(testConfig, "EPS_Enrollment_guide_Billing_Services_v4.pdf");
		}
	
	public void validateBeginEnrollmentQuestions() throws IOException {
		int sqlRowNo=110;
		boolean flag=false;
		Map<String, String> surveyQuestionDB = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		if(surveyQuestionDB.get("QUESTION_TXT").equals(beginEnrlmntQuesOnline.getText())) {
			Log.Comment("Survey question is matching between DB and online.");
			sqlRowNo=109;
			ArrayList<String> surveyAnswersDbList = new ArrayList<>();
			HashMap<Integer, HashMap<String, String>> surveyAnswersDB = DataBase.executeSelectQueryALL(testConfig,sqlRowNo);
			for(Integer tmp : surveyAnswersDB.keySet()){
				surveyAnswersDbList.add(surveyAnswersDB.get(tmp).get("ANSWER_TXT"));
			}
			if(surveyAnswersDbList.size()==beginEnrlmntAnswersOnline.size()) {
				for(int i=0; i<surveyAnswersDbList.size(); i++) {
					if(!surveyAnswersDbList.get(i).equals(beginEnrlmntAnswersOnline.get(i).getText())) 
						flag=true;
					}			
			}
			else
				flag=true;
			}
		else 
			Log.Fail("Survey question is not matching between DB and online");
		if(flag) {
			Log.Fail("Test case failed: Either count or order of survey answers online is not matching with DB");
		}
	}
	

	public void verifyPageContent() throws IOException
	{
		int sqlRowNo=107;
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
			
		Helper.compareEquals(testConfig, " Title", hdrTitle.getText(), dataTest.get(1).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, " SubTitle", hdrSubTitle.getText(), dataTest.get(2).get("TEXT_VAL"));
		Browser.wait(testConfig, 2);
		Element.expectedWait(pageBody.get(0).findElement(By.tagName("h1")), testConfig, "Heading", "Heading");
		Helper.compareEquals(testConfig, " Heading", pageBody.get(0).findElement(By.tagName("h1")).getText(), dataTest.get(3).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Paragraph 1", pageBody.get(0).findElements(By.tagName("p")).get(1).getText(), dataTest.get(5).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Paragraph 2", pageBody.get(0).findElements(By.tagName("p")).get(2).getText(), dataTest.get(6).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Paragraph 3", pageBody.get(0).findElements(By.tagName("p")).get(3).getText(), dataTest.get(7).get("TEXT_VAL")+" "+dataTest.get(8).get("TEXT_VAL")+dataTest.get(9).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "PDF link 1 and 2",pageBody.get(0).findElements(By.tagName("p")).get(4).getText().toString().replace("\t", "").replace("\n", "").trim(), dataTest.get(10).get("TEXT_VAL")+"   "+dataTest.get(11).get("TEXT_VAL").replace("\t", "").trim());
		Helper.compareEquals(testConfig, "PDF link 3", pageBody.get(0).findElements(By.tagName("p")).get(5).getText().replace("\t", "").trim(), dataTest.get(12).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Continue button",btnContinue.getText().toLowerCase(), dataTest.get(19).get("TEXT_VAL").toLowerCase());
		Helper.compareEquals(testConfig, "Cancel Button",btnCancelEnrollment.getText().toLowerCase(), dataTest.get(20).get("TEXT_VAL").toLowerCase());
		Helper.compareEquals(testConfig, "Policy link",lnkPolicy.getText(), dataTest.get(21).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Terms of Use",lnkUseTerms.getText(), dataTest.get(22).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Optum copyright",dataTest.get(23).get("TEXT_VAL"),optum.getText());
		
		
		sqlRowNo=98;
		Map queData=DataBase.executeSelectQuery(testConfig, sqlRowNo,1);
		Helper.compareEquals(testConfig, "Survey Question",ques.getText(), queData.get("QUESTION_TXT"));
		
		sqlRowNo=99;
		HashMap<Integer,HashMap<String,String>> options=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		Helper.compareEquals(testConfig, "Survey Options",pageBody.get(0).findElements(By.tagName("li")).get(0).getText(), options.get(1).get("ANSWER_TXT"));
		Helper.compareEquals(testConfig, "Survey Options",pageBody.get(0).findElements(By.tagName("li")).get(1).getText(), options.get(2).get("ANSWER_TXT"));
		Helper.compareEquals(testConfig, "Survey Options",pageBody.get(0).findElements(By.tagName("li")).get(2).getText(), options.get(3).get("ANSWER_TXT"));
		Helper.compareEquals(testConfig, "Survey Options",pageBody.get(0).findElements(By.tagName("li")).get(3).getText(), options.get(4).get("ANSWER_TXT"));
		Helper.compareEquals(testConfig, "Survey Options",pageBody.get(0).findElements(By.tagName("li")).get(4).getText(), options.get(5).get("ANSWER_TXT"));
		
		Element.click(btnCancelEnrollment, "Cancel Enrollment");

		
		Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up Header",popUp.get(0).findElement(By.tagName("h4")).getText(),  dataTest.get(14).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up para",popUp.get(0).findElements(By.tagName("p")).get(0).getText(),  dataTest.get(15).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up para",popUp.get(0).findElements(By.tagName("p")).get(1).getText(),  dataTest.get(16).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up No",popUp.get(0).findElements(By.tagName("a")).get(1).getText().toLowerCase(),  dataTest.get(18).get("TEXT_VAL").toLowerCase());
		Helper.compareEquals(testConfig, "Cancel Enrollment Pop Up Yes",popUp.get(0).findElements(By.tagName("a")).get(2).getText().toLowerCase(),  dataTest.get(17).get("TEXT_VAL").toLowerCase());

		
	}
	
	public String readPDF() throws IOException {
		String output="";
		String filedir=System.getProperty("user.dir")+"\\Downloads";
//        testConfig.driver.get("file:///C:/Users/akushw10/Downloads/EnrollmentPDF.pdf");
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
        String tin=StringUtils.substringBetween(output, "TIN:", "\n");
//        Helper.compareEquals(testConfig, "Tin Masked", "*****"+enrollmentInfoPageObj.getTin().substring(5), tin);
        System.out.println("TIN:\n"+StringUtils.substringBetween(output, "TIN:", "\n"));
        System.out.println("Organizational Information:\n"+StringUtils.substringBetween(output, "Organization Information", "Identify"));
        System.out.println("Identify Administration Information:\n"+StringUtils.substringBetween(output, "Identify Administrators", "Financial"));
        System.out.println("Financial Institution Information for TIN:\n"+StringUtils.substringBetween(output, "Financial Institution Information for TIN", "Financial"));
        System.out.println("Authorized Enroller's Information:\n"+StringUtils.substringBetween(output, "Authorized Enroller's Information", "Page"));
        System.out.println("Authorization section and W9 section:\n"+StringUtils.substringBetween(output, "Authorization", "Authorized Enroller's"));
        System.out.println("Terms and conditions :\n"+StringUtils.substringBetween(output, "EPS EFT Provider Authorization", "\n"));
        
        return tin;
    }
}



