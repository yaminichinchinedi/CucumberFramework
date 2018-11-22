package main.java.pageObjects;

import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

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
	
	
	private TestBase testConfig;
		
	
		
	public BeginEnrollment(TestBase testConfig) {
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	    Element.expectedWait(rdoHealthPlanCommunication, testConfig, "First Name textbox", "First Name textbox");	
	}
	
	
	public BeginEnrollmentContinue selectHowYouHeard(String option)
	{
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
}



