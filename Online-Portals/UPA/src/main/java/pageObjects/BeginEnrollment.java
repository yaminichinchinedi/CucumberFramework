package main.java.pageObjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeginEnrollment {
		
//	@FindBy(xpath="//input[@id=1]//following-sibling::label")
//	WebElement rdoHealthPlanCommunication;
	
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
	
	@FindBy(linkText="Continue")
	WebElement btnContinue;
	
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
	
	@FindBy(xpath=".//*[@id='EFTERAenrForm']/div[2]/div[1]/div[1]/h4")
	WebElement popUp1;
	
	@FindBy(xpath="//*[@id='EFTERAenrForm']/div[2]/div[1]/div[2]")
	WebElement popUp2;
	
	
	private TestBase testConfig;
		
	EnrollmentInfo enrollment =EnrollmentInfo.getInstance();
		
	public BeginEnrollment(TestBase testConfig) {
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	    Element.expectedWait(rdoHealthPlanCommunication, testConfig, "First Name textbox", "First Name textbox");	
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
		
		clickContinue();
		return new BeginEnrollmentContinue(testConfig);
			
	}
	
	public void clickContinue()
	{
		Element.click(btnContinue, "Continue button");
	}
	

	public void verifyPageContent() throws IOException
	{
		int sqlRowNo=107;
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
			
		Helper.compareEquals(testConfig, " Title", hdrTitle.getText(), dataTest.get(1).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, " SubTitle", hdrSubTitle.getText(), dataTest.get(2).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, " Heading", pageBody.get(0).findElement(By.tagName("h1")).getText(), dataTest.get(3).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Paragraph 1", pageBody.get(0).findElements(By.tagName("p")).get(1).getText(), dataTest.get(5).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Paragraph 2", pageBody.get(0).findElements(By.tagName("p")).get(2).getText(), dataTest.get(6).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Paragraph 3", pageBody.get(0).findElements(By.tagName("p")).get(3).getText(), dataTest.get(7).get("TEXT_VAL")+" "+dataTest.get(8).get("TEXT_VAL")+dataTest.get(9).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "PDF link 1 and 2",pageBody.get(0).findElements(By.tagName("p")).get(4).getText().toString().replace("\t", "").replace("\n", "").trim(), dataTest.get(10).get("TEXT_VAL")+"   "+dataTest.get(11).get("TEXT_VAL").replace("\t", "").trim());
		Helper.compareEquals(testConfig, "PDF link 3", pageBody.get(0).findElements(By.tagName("p")).get(5).getText().replace("\t", "").trim(), dataTest.get(12).get("TEXT_VAL"));
//		Helper.compareEquals(testConfig, "",test.getText(), dataTest.get(12).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Continue button",btnContinue.getText().toLowerCase(), dataTest.get(19).get("TEXT_VAL").toLowerCase());
		Helper.compareEquals(testConfig, "Cancel Button",btnCancelEnrollment.getText().toLowerCase(), dataTest.get(20).get("TEXT_VAL").toLowerCase());
		Helper.compareEquals(testConfig, "Policy link",lnkPolicy.getText(), dataTest.get(21).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "Terms of Use",lnkUseTerms.getText(), dataTest.get(22).get("TEXT_VAL"));
		Helper.compareContains(testConfig, "Optum copyright",dataTest.get(23).get("TEXT_VAL"),optum.getText());
		
		sqlRowNo=99;
		HashMap<Integer,HashMap<String,String>> options=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		Helper.compareEquals(testConfig, "Survey Options",pageBody.get(0).findElements(By.tagName("li")).get(0).getText(), options.get(1).get("ANSWER_TXT"));
		Helper.compareEquals(testConfig, "Survey Options",pageBody.get(0).findElements(By.tagName("li")).get(1).getText(), options.get(2).get("ANSWER_TXT"));
		Helper.compareEquals(testConfig, "Survey Options",pageBody.get(0).findElements(By.tagName("li")).get(2).getText(), options.get(3).get("ANSWER_TXT"));
		Helper.compareEquals(testConfig, "Survey Options",pageBody.get(0).findElements(By.tagName("li")).get(3).getText(), options.get(4).get("ANSWER_TXT"));
		Helper.compareEquals(testConfig, "Survey Options",pageBody.get(0).findElements(By.tagName("li")).get(4).getText(), options.get(5).get("ANSWER_TXT"));
		
		Helper.compareEquals(testConfig, "",popUp.get(0).findElement(By.tagName("h4")).getText(),  dataTest.get(14).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "",popUp.get(0).findElements(By.tagName("p")).get(0).getText(),  dataTest.get(15).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "",popUp.get(0).findElements(By.tagName("p")).get(1).getText(),  dataTest.get(16).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "",popUp.get(0).findElements(By.tagName("a")).get(0).getText(),  dataTest.get(17).get("TEXT_VAL"));
		Helper.compareEquals(testConfig, "",popUp.get(0).findElements(By.tagName("a")).get(1).getText(),  dataTest.get(18).get("TEXT_VAL"));
		
	}
}



