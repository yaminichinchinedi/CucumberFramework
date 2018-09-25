package main.java.pageObjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OptumIdLoginPage {

	@FindBy(id = "userNameId_input")
	WebElement txtboxOptumID;

	@FindBy(id = "passwdId_input")
	WebElement txtboxPwd;

	@FindBy(id = "SignIn")
	WebElement btnSignIn;

	@FindBy(xpath = "//label[@contains(text(),'favorite color')]")
	WebElement favColorQuestion;

	@FindBy(id = "challengeQuestionLabelId")
	WebElement securityQuestion;

	@FindBy(xpath = "//div[@id='challengeSecurityAnswerId']/input")
	WebElement txtboxSecurityAns;

	@FindBy(name = "rememberMyDevice")
	WebElement chkBoxRememberDevice;

	@FindBy(id = "authQuesSubmitButton")
	WebElement btnNext;

	@FindBy(xpath = "//div[@class='authQuestionTitle']")
	WebElement txtUnrecognizedDevice;
	
	 @FindBy(xpath="//div[@class='oui-pmsg-error-body']")
	 WebElement txtErrorMsg;

	String id, password;
	String env=System.getProperty("env");
	Map<String,String> loggedInUserDetails=new HashMap<String, String>();
	
	private TestBase testConfig;
	

	public OptumIdLoginPage(TestBase testConfig) {
		
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.verifyElementPresent(txtboxOptumID, "Optum id Textbox");
	}
	
	
	public void setUserProperties() {
		
		testConfig.putRunTimeProperty("id",id);
		testConfig.putRunTimeProperty("password",password);
	}
	

   public Map<String,String> getDetailOfUserToBeLoggedIn(String userType,String accessType)
	{
		id=testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+userType+"_"+accessType+"_"+env);
		password=testConfig.runtimeProperties.getProperty("UPA_"+"OptumPwd_"+userType+"_"+accessType+"_"+env);
		loggedInUserDetails.put("id", id);
		loggedInUserDetails.put("password", password);
		setUserProperties();
		
		return loggedInUserDetails;
	}
	
	public HomePage loginWithOptumID(String userType,String accessType) 
	{
		Map <String,String> details=new HashMap<String,String>();
		
		details=getDetailOfUserToBeLoggedIn(userType, accessType);
		
	    Element.enterData(txtboxOptumID,details.get("id"), "Entered Optum ID as:" + " " +details.get("id"), "txtboxOptumID"); 
	    Element.enterData(txtboxPwd,details.get("password"), "Entered Optum ID password  as :" + " "+ details.get("password"), "txtboxPwd");
	    Element.click(btnSignIn, "Sign In");
	    Browser.waitForLoad(testConfig.driver);
	    Browser.wait(testConfig, 3);
	    
	    WebElement welcomeTxt=Element.findElement(testConfig, "xpath", "//span[contains(text(),'Welcome Screen')]");
	    if(welcomeTxt!=null)
	    	Log.Comment("Security Question not present");
	    else
	    {
          for(int i=0;i<2;i++)
           {
             securityQuestion=Element.findElement(testConfig, "id", "challengeQuestionLabelId");
             if(securityQuestion!=null)
             { 
    	       fillAns();
               break;
             }
           }
	    }
           

        
     return new HomePage(testConfig);
   }


	public void fillAns() {
		
		if (securityQuestion.getText().contains("color")) 
			fillColorAns();
		
		else if (securityQuestion.getText().contains("sports")) 
			fillSportsAns();

		else if (securityQuestion.getText().contains("best friend")) 
			fillBestFriendAns();
		
		else if (securityQuestion.getText().contains("father")) 
			fillFatherAns();

		else 
			Log.Comment("Unidentified Question :"+ " " + securityQuestion.getText(),"Red");
	
		if (!chkBoxRememberDevice.isSelected())
			Element.click(chkBoxRememberDevice,"'Remember my device' checkbox");
		
		Element.click(btnNext, "Next to submit answer");
	}

	
	private void fillFatherAns() {
	 Element.enterData(txtboxSecurityAns, "Sharma","Entered 'Sharma' as Father's  Name", "txtboxSecurityAns");
	}

	private void fillBestFriendAns() {
			 Element.enterData(txtboxSecurityAns, "sahil", "Entered 'test' as Best Friend's Name", "txtboxSecurityAns");
	}

	private void fillSportsAns() {
	//	Element.enterData(txtboxSecurityAns, "tester","Entered 'tester' as Favorite Sports team", "txtboxSecurityAns");
		Element.enterData(txtboxSecurityAns, "india","Entered 'tester' as Favorite Sports team", "txtboxSecurityAns");
	}

	public void fillColorAns() {
		Element.enterData(txtboxSecurityAns, "Green","Entered 'Green' as Favorite Color answer", "txtboxSecurityAns");
	}

	
	
	public void doInvalidLoginAndVerifyValidation(int rowNo) throws IOException
	{
		TestDataReader data=testConfig.cacheTestDataReaderObject("Login");
		id=data.GetData(rowNo,"Username");
		password=data.GetData(rowNo,"Password");
		
	    
		Element.enterData(txtboxOptumID, id, " Optum ID entered as :"+" " + id, "txtboxOptumID");	
		Element.enterData(txtboxPwd, password, " Password entered :" + " " + password, "txtboxPwd");
		Element.click(btnSignIn, "Sign In button");
		
		verifyLoginErrorMessage();
		
	}
	
	public void verifyLoginErrorMessage()
	{
		Element.verifyTextPresent(txtErrorMsg, "The Optum ID or password that you entered is incorrect.");
	}
}
