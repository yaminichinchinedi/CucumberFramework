package main.java.pageObjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
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
import org.seleniumhq.jetty9.server.session.DatabaseAdaptor;

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

	@FindBy(xpath="//div[@class='authQuestionNavigation']//input[@id='authQuesSubmitButton']")
	WebElement btnNext;

	@FindBy(xpath = "//div[@class='authQuestionTitle']")
	WebElement txtUnrecognizedDevice;
	
	@FindBy(xpath="//div[@class='oui-pmsg-error-body']")
	WebElement txtErrorMsg;
	 
	@FindBy(xpath="//div[@class='pguide']")
	WebElement divTermsAndConditions;
		
	@FindBy(name="acceptTerms")
    WebElement chkBoxTerms;
		
	@FindBy(name="btnSubmit")
	WebElement btnSubmit;
	
	String id, password;
	String env=System.getProperty("env");
	Map<String,String> loggedInUserDetails=new HashMap<String, String>();
	
	private TestBase testConfig;
	

	public OptumIdLoginPage(TestBase testConfig) {
		
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.expectedWait(txtboxOptumID, testConfig, "Optum id Textbox", "Optum id Textbox");
	}
	
	
	public void setUserProperties() {
		
		testConfig.putRunTimeProperty("id",id);
		testConfig.putRunTimeProperty("password",password);
	}
	


//	public Map<String,String> getDetailOfUserToBeLoggedIn(String userType,String accessType)
//	{
//	id=testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+userType+"_"+accessType+"_"+env);
//	password=testConfig.runtimeProperties.getProperty("UPA_"+"OptumPwd_"+userType+"_"+accessType+"_"+env);
//	loggedInUserDetails.put("id", id);
//	loggedInUserDetails.put("password", password);
//	setUserProperties();
//
//	return loggedInUserDetails;
//	}
   
	
//   public HomePage loginWithOptumID(String userType,String accessType) 
//	{
//		
//		Map <String,String> details=new HashMap<String,String>(getDetailOfUserToBeLoggedIn(userType, accessType));
//		
//		fillCredsAndSignIn(details.get("id"), details.get("password"));
//	    
//	    WebElement welcomeTxt=Element.findElement(testConfig, "xpath", "//span[contains(text(),'Welcome Screen')]");
//	    
//	    divTermsAndConditions= Element.findElement(testConfig, "xpath","//div[@class='pguide']");
//	    
//	    
//	    if(welcomeTxt!=null)
//	      Log.Comment("Security Question not present");
//	    
//	    
//	    else if(divTermsAndConditions!=null)
//	    {
//	    	Element.click(chkBoxTerms, "Terms & Conditions check box");
//		    Element.click(btnSubmit, "Submit button");
//	    }
//	    
//	    else
//	    {
//         for(int i=0;i<2;i++)
//          {
//            securityQuestion=Element.findElement(testConfig, "id", "challengeQuestionLabelId");
//            Element.expectedWait(securityQuestion, testConfig, "securityQuestion", "securityQuestion");
//            if(securityQuestion!=null)
//            { 
//   	       fillAns();
//              break;
//            }
//          }
//	    }
//    return new HomePage(testConfig);
//  }

	
	 /*public HomePage loginWithOptumID(String userType,String accessType) 

	
	//uncomment in later after connection is made with MySQLDB
	
  public Map<String,String> getDetailOfUserToBeLoggedIn(String userType,String accessType)
   {   
	    id=testConfig.getUsername("UPA", userType, accessType, env);
	    password=testConfig.getPassword("UPA", userType, accessType, env);
		
		loggedInUserDetails.put("id", id);
		loggedInUserDetails.put("password", password);
		setUserProperties();
		
		return loggedInUserDetails;
	}*/
   
	
   /*public HomePage loginWithOptumID(String userType,String accessType) 

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
  }*/
	
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
		
		else if (securityQuestion.getText().contains("nickname")) 
			fillNicknameAns();
		
		else if (securityQuestion.getText().contains("state of your birth")) 
			fillStateOfBirthAns();

		else 
			Log.Comment("Unidentified Question :"+ " " + securityQuestion.getText(),"Red");
	
		if (!chkBoxRememberDevice.isSelected())
			Element.click(chkBoxRememberDevice,"'Remember my device' checkbox");
		
		Browser.wait(testConfig,3);
		List<WebElement> btnNxt=testConfig.driver.findElements(By.xpath("//div[@class='authQuestionNavigation']//input[@id='authQuesSubmitButton']"));
		System.out.println(btnNxt.size());
		for(WebElement e: btnNxt)
		{
			System.out.println(e.getText());
			
		}
		
		
		
		Element.click(Element.findElement(testConfig, "xpath","//div[@class='authQuestionNavigation']//input[@id='authQuesSubmitButton']"), "Next to submit answer");
	}
	

	
	private void fillNicknameAns() {
		 Element.enterData(txtboxSecurityAns, "Ginni","Entered 'Ginni' as Nick  Name", "txtboxSecurityAns");
		
	}
	
	private void fillStateOfBirthAns() {
		 Element.enterData(txtboxSecurityAns, "Faridabad","Entered 'Ginni' as Nick  Name", "txtboxSecurityAns");
		
	}


	private void fillFatherAns() {
		if(id.equals("TestPayerStage"))
	 Element.enterData(txtboxSecurityAns, "Lal","Entered 'Lal' as Father's  Name", "txtboxSecurityAns");
		else
			 Element.enterData(txtboxSecurityAns, "Sharma","Entered 'Sharma' as Father's  Name", "txtboxSecurityAns");
	}

	private void fillBestFriendAns() {
			 Element.enterData(txtboxSecurityAns, "sahil", "Entered 'test' as Best Friend's Name", "txtboxSecurityAns");
	}

	private void fillSportsAns() {
		if(testConfig.getRunTimeProperty("id").equals("PayerAuto"))
			Element.enterData(txtboxSecurityAns, "tester","Entered 'tester' as Favorite Sports team", "txtboxSecurityAns");
		else
		Element.enterData(txtboxSecurityAns, "india","Entered 'india' as Favorite Sports team", "txtboxSecurityAns");
		
	}

	public void fillColorAns() {
		if(id.equals("AVUHCPAYSTG1"))
			Element.enterData(txtboxSecurityAns, "Black","Entered 'Black' as Favorite Color answer", "txtboxSecurityAns");
		else
			Element.enterData(txtboxSecurityAns, "Green","Entered 'Green' as Favorite Color answer", "txtboxSecurityAns");
	}

	
	

	
	/*public void doInvalidLoginAndVerifyValidation(int rowNo) throws IOException
	{
		TestDataReader data=testConfig.cacheTestDataReaderObject("Login");
		id=data.GetData(rowNo,"Username");
		password=data.GetData(rowNo,"Password");
		
		fillCredsAndSignIn(id,password);
		
		verifyLoginErrorMessage();
		
	}*/
	
	
	/*public OptumIdLoginPage fillCredsAndSignIn(String id, String password)
	{
		if(id.isEmpty())
		{
		   id=testConfig.getUsername("UPA", testConfig.getRunTimeProperty("userType"), testConfig.getRunTimeProperty("accessType"), env);
		   password=testConfig.getPassword("UPA", testConfig.getRunTimeProperty("userType"), testConfig.getRunTimeProperty("accessType"), env);
		}
	
		Element.enterData(txtboxOptumID, id, " Optum ID entered as :"+" " + id, "txtboxOptumID");	
		Element.enterData(txtboxPwd, password, " Password entered :" + " " + password, "txtboxPwd");
		Element.click(btnSignIn, "Sign In button");
		Browser.waitForLoad(testConfig.driver);
		testConfig.putRunTimeProperty("id", id);
		
		
		return this;
	}*/

	
	
	public void verifyLoginErrorMessage()
	{
		Element.verifyTextPresent(txtErrorMsg, "The Optum ID or password that you entered is incorrect.");
	}
	
	
   /* public OptumIdLoginPage verifyTermsConditionsPage()
    {
		int sqlRow=7;
		Map portalUser=DataBase.executeSelectQuery(testConfig, sqlRow, 1);

		for(int i=0;i<2;i++)
        {
          securityQuestion=Element.findElement(testConfig, "id", "challengeQuestionLabelId");
          if(securityQuestion!=null)
          { 
 	       fillAns();
            break;
          }
        }
		
		if(portalUser.get("TC_ACCEPT_IND").equals("N"))
		{
		   Element.expectedWait(divTermsAndConditions, testConfig, "Terms and conditions page", "Terms and conditions page");
		  
		   Element.clickByJS(testConfig,chkBoxTerms, "Terms & Conditions check box");
	       Element.clickByJS(testConfig,btnSubmit, "Submit button");
	       portalUser=DataBase.executeSelectQuery(testConfig, sqlRow, 1);
	       Browser.wait(testConfig, 2);
	       Helper.compareEquals(testConfig, "Terms and Conditons Indicator", "Y", portalUser.get("TC_ACCEPT_IND"));
		}
		
		else if(portalUser.get("TC_ACCEPT_IND").equals("Y"))
		{
			int sqlToUpdate=44;
			Log.Comment("Updating terms indicator to N");
			DataBase.executeUpdateQuery(testConfig, sqlToUpdate);
			
			HomePage homePage=new HomePage(testConfig);
			homePage.logOutAndReLogin(testConfig);
			verifyTermsConditionsPage();
		}
		
		return this;
		


	}*/
    

    
}