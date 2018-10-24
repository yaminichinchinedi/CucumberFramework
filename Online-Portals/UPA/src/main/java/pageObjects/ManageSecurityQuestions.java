package main.java.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class ManageSecurityQuestions {
	
	@FindBy(xpath="//input[@value='Cancel']")
    public WebElement btnCancel;
	
	@FindBy(id="btnSubmit")
    public WebElement btnSubmit;
	
	@FindBy(xpath="//input[@name='Yes']")
    public WebElement btnYes;
	
	@FindBy(xpath="//input[@name='No']")
    public WebElement btnNo;
	
	@FindBy(xpath="//tr[2]/td/table/tbody/tr[3]/td")
    public WebElement cancelTxt;
	
	@FindBy(xpath="//div[2]/table/tbody/tr[2]/td")
	public WebElement securityQuestionsSaveTxt;
	
	@FindBy(xpath=".//*[@id='myProfileForm']/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr")
	public List <WebElement> securityQuesAns;

    

    private TestBase testConfig;
    
    
    public ManageSecurityQuestions(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(testConfig.driver, this);
	  Element.verifyElementPresent(securityQuesAns.get(0).findElement(By.id("selectSecQues"+1)), "Question 1");
    }

    /**
     * 
     * @return
     */
    public ManageSecurityQuestions fillSecurityQuestions() 
   	{
       	int i=0;
       	while(i<9)
		{
			Element.selectByIndex(securityQuesAns.get(i).findElement(By.tagName("select")),2, "Selected security question with index 2");
			i=i+1;
			Element.enterData(securityQuesAns.get(i).findElement(By.tagName("input")), "EPS", "Answer is EPS", "Answer textbox");
			i=i+1;
	}
   		return new ManageSecurityQuestions(testConfig);
   	}
    
    public MyProfile saveQuestion()
    { 
    	Element.clickByJS(testConfig,btnSubmit, "Save button"); //verify successfully saved text
    	return new MyProfile(testConfig);
    }
    
    public ManageSecurityQuestions saveQuestionDisabled()
    { 
    	
    	String expectedValue="true";
		String getDisabledAttribute="disabled";
		Element.selectByVisibleText(securityQuesAns.get(0).findElement(By.id("selectSecQues"+1)), "Select a security question", "Select a security question");		
		try {
		Helper.compareEquals(testConfig, "Save Button is disabled", expectedValue, btnSubmit.getAttribute(getDisabledAttribute));
		}
		catch(Exception e){
			Log.Fail("Exception occured : "+ e);
		}
    	return new ManageSecurityQuestions(testConfig);
    }
    
    public MyProfile verifySaveQuestionTxt()
    { 
    	String expectedTxt="Your security questions were successfully changed.";
    	Element.verifyTextPresent(securityQuestionsSaveTxt, expectedTxt);
    	return new MyProfile(testConfig);
    }
    
    public MyProfile cancelYesQuestion()
    { 
    	clickCancel();
  	  	Element.click(btnYes, "Yes Button");
    	return new MyProfile(testConfig);
    }
    
    public ManageSecurityQuestions cancelNoQuestion()
    { 
    	clickCancel();
  	  	Element.click(btnNo, "No Button");
    	return this;
    }
    
    public String clickCancel()
    { 
    	String expectedText="Are you sure you wish to cancel your update to your security questions?"; // need to check for this
    	Element.click(btnCancel, "Cancel button");
    	Element.verifyElementPresent(btnYes, "Yes Button");
  	  	Element.verifyElementPresent(btnNo, "No Button");
    	Element.verifyTextPresent(cancelTxt, expectedText);
    	return Browser.getURL(testConfig);
    }

}