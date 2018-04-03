package main.java.pageObjects;

import java.io.IOException;

import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.LogTemp;

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

	private TestBase testConfig;
	String id, password;

	public OptumIdLoginPage(TestBase testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.verifyElementPresent(txtboxOptumID, "Optum id Textbox");
	}

	//Will use if required later

//	public HomePage loginWithOptumID(int rowNo) throws InterruptedException,IOException 
//	{
//		TestDataReader data = testConfig.cacheTestDataReaderObject("Login");
//
//		Element.enterData(txtboxOptumID, data.GetData(rowNo, "OptumID"),"Entered Optum ID as:" + " " + data.GetData(rowNo, "OptumID"),"txtboxOptumID");
//		Element.enterData(txtboxPwd,data.GetData(rowNo, "OptumPwd"),"Entered Optum ID password as :" + " "+ data.GetData(rowNo, "OptumPwd"), "txtboxPwd");
//		Element.click(btnSignIn, "Sign In");
//		Browser.waitForLoad(testConfig.driver);
//		Browser.wait(testConfig, 5);
//		if (testConfig.driver.getPageSource().contains("Unrecognized")) {
//			System.out.println("yesss");
//			fillAns();
//		}
//		return new HomePage(testConfig);
//	}
//	
	
	public HomePage loginWithOptumID(String userType,String accessType) throws InterruptedException,IOException
	{
	  String env=testConfig.getRunTimeProperty("Env");
	  id=testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+userType+"_"+accessType+"_"+env);
	  password=testConfig.runtimeProperties.getProperty("UPA_"+"OptumPwd_"+userType+"_"+accessType+"_"+env);
	  
	  Element.enterData(txtboxOptumID,id, "Entered Optum ID as:" + " " +id, "txtboxOptumID"); 
	  if(txtboxOptumID.getText()==null)
	  {
		  Element.enterData(txtboxOptumID,id, "Entered Optum ID as:" + " " +id, "txtboxOptumID");
	  }
	  Element.enterData(txtboxPwd,password, "Entered Optum ID password  as :" + " "+ password, "txtboxPwd");
	  
	  Element.click(btnSignIn, "Sign In");
      Browser.waitForLoad(testConfig.driver);
      Browser.wait(testConfig, 5);
      if (testConfig.driver.getPageSource().contains("Unrecognized")) 
    	  fillAns();
     return new HomePage(testConfig);
   }


	public void fillAns() {
		if (securityQuestion.getText().contains("color")) {
			fillColorAns();
		} else if (securityQuestion.getText().contains("sports team")) {
			fillSportsAns();
		}

		else if (securityQuestion.getText().contains("best friend")) {
			fillBestFriendAns();
		} else if (securityQuestion.getText().contains("father's")) {
			fillFatherAns();
		}

		else {
			LogTemp.Comment("Unidentified Question :"+ " " + securityQuestion.getText(),"Red");
		}
		if (!chkBoxRememberDevice.isSelected()) {
			Element.click(chkBoxRememberDevice,
					"check Remeber my device checkbox");
		}

		Element.click(btnNext, "Click Next to submit answer");
	}

	private void fillFatherAns() {
		Element.enterData(txtboxSecurityAns, "Sharma",
				"Entered 'Sharma' as Father's  Name", "txtboxSecurityAns");

	}

	private void fillBestFriendAns() {
		{
			Element.enterData(txtboxSecurityAns, "Sahil",
					"Entered 'Sahil' as Best Friend's Name",
					"txtboxSecurityAns");
			// Element.enterData(txtboxSecurityAns, "test",
			// "Entered 'test' as Best Friend's Name", "txtboxSecurityAns");
		}
	}

	private void fillSportsAns() {
		Element.enterData(txtboxSecurityAns, "tester",
				"Entered 'tester' as Favorite Sports team", "txtboxSecurityAns");
	}

	public void fillColorAns() {
		// Element.enterData(txtboxSecurityAns, "testing",
		// "Entered 'testing' as Favorite Color answer","txtboxSecurityAns");
		Element.enterData(txtboxSecurityAns, "Green",
				"Entered 'Green' as Favorite Color answer", "txtboxSecurityAns");
	}

}
