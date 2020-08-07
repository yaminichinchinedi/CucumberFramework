package main.java.pageObjects;

import java.io.IOException;
import java.util.Map;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.DataProvider;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.apache.xpath.operations.Or;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.TestDataReader;

public class LoginUPA {
	
	
	
	
	@FindBy(xpath = "//input[@id='userNameId_input']") WebElement txtboxUserName;
	@FindBy(xpath = "//input[@id='passwdId_input']") WebElement txtboxPwd;
	@FindBy(xpath = "//input[@id='SignIn']") WebElement btnLogin;

    
    @FindBy(xpath="//font[@class='errors']")
	private WebElement txtErrorMsg;
	
    
    
    @FindBy(xpath="//span[contains(text(),'The Optum ID or password that you entered is incorrect.')]")
	WebElement txtErrorMsg1;
    
    @FindBy(xpath=".//*[@id='signin-tile']/div/p[2]/a")
    public WebElement activateAccount;
    
    @FindBy(linkText="ACTIVATE")
    public WebElement btnActivate;
    
   @FindBy(xpath = "//a[contains(text(),'SIGN IN WITH OPTUM ID')]") WebElement clickUPASignIn;
	
	
    @FindBy(id="tabHome")
    public WebElement tabHome;
			
	@FindBy(linkText="How to Enroll")
	WebElement tabHowToEnroll;
			
    @FindBy(linkText="Benefits of EPS")
    WebElement tabBenefitsOfEPS;
	
    
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
	
	@FindBy(linkText="RETURN TO LOGIN")
	WebElement btnRtnLogin;
	
	@FindBy(name="userName")
	WebElement txtPIN;
	
	@FindBy(name="tinNumber")
	WebElement txtTin;
	
	@FindBy(linkText="CONTINUE")
	WebElement btnContinue;
	
	private TestBase testConfig;
	String id, password;
	String env=System.getProperty("env");
	
	public LoginUPA(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this); 
	}
	
	
	public UPAHomePage doLoginUPA(String userType)
	{
	   setUserProperties(userType);
	   Element.click(clickUPASignIn, "Click On Sign In UPA");
	   Element.enterData(txtboxUserName, id, "Username entered as : " + id,"txtboxUserName");
	   Element.enterData(txtboxPwd, password, "Password entered as : " + password ,"txtboxPwd");
	   Element.click(btnLogin,"click Login button");
       Browser.waitForPageLoad(testConfig);
	   
	   try{
	   if(txtErrorMsg1!=null)
	   {
	      if(txtErrorMsg1.isDisplayed())
	     {
	    	  Log.Comment("Authentication error message displayed..trying again");
	    	  Browser.wait(testConfig, 3);
	    	  Element.fluentWait(testConfig, txtboxPwd, 120,5, "txtboxOptumID");
	    	  Element.enterData(txtboxUserName,id, "Entered Optum ID as:" + " " +id, "txtboxOptumID"); 
	    	  Element.enterData(txtboxPwd,password, "Entered Optum ID password  as :" + " "+ password, "txtboxPwd");
	    	  Element.click(btnLogin, "Sign In");
	     }
	   }
	   }
	   catch(Exception e)
	   {
		   Log.Comment("Authentication Error not present");
	   }
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
     return new UPAHomePage(testConfig);
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
		
		Element.click(btnNext, "Next to submit answer");
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
			 Element.enterData(txtboxSecurityAns, "sahil", "Entered 'sahil' as Best Friend's Name", "txtboxSecurityAns");
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
	 
	
	
	
	//Deafult constructor
	public LoginUPA() 
	{
		
	}
	
	
	public void setUserProperties(String userType)
	{
		id=testConfig.runtimeProperties.getProperty("UPA_"+"OptumID_"+userType+"_"+env);
		password=testConfig.runtimeProperties.getProperty("UPA_"+"OptumPwd_"+userType+"_"+env);
		testConfig.putRunTimeProperty("id",id);
		testConfig.putRunTimeProperty("password",password);
	}
	
	public void verifyLoginUI()
	{
		Element.verifyElementPresent(tabHowToEnroll,"How to enroll tab");
		Element.verifyElementPresent(tabBenefitsOfEPS,"Benefits Of EPS tab");
	}

	
	public SplashPage3 doLogin(String userType,String accessType) throws IOException
	{
		String env=System.getProperty("env");
        id=testConfig.runtimeProperties.getProperty("UPA_"+"ID_"+userType+"_"+accessType+"_"+env);
        password=testConfig.runtimeProperties.getProperty("UPA_"+"Pwd_"+userType+"_"+accessType+"_"+env);
        Element.click(activateAccount, "Activate your account link on registartion page");
        
        if(!txtboxUserName.isDisplayed())
        	 Element.click(activateAccount, "Activate your account link on registartion page");
        
        Element.expectedWait(txtboxUserName, testConfig, "User Name", "User Name textbox");
		Element.enterData(txtboxUserName,id, "Username entered as:" + " " +id, "txtboxUserName");
		Element.enterData(txtboxPwd,password, "Password entered as :" + " "+ password, "txtboxPwd");
		Element.click(btnActivate, "Activate your account button");
		setUserProperties(userType);
	    return new SplashPage3(testConfig);
	}
	
	public void doInvalidLoginAndVerifyValidation(int rowNo) throws IOException
	{
		TestDataReader data=testConfig.cacheTestDataReaderObject("Login");
		id=data.GetData(rowNo,"Username");
		password=data.GetData(rowNo,"Password");
		
	    if(activateAccount.isDisplayed())
	    	clickActivateAccount();
		Element.enterData(txtboxUserName, id, "Correct Username entered as :"+" " + id, "txtboxUserName");	
		Element.enterData(txtboxPwd, password, "Invalid Password entered :" + " " + password, "txtboxPwd");
		Element.click(btnActivate, "Activate your account button");
		verifyLoginErrorMessage();
		
	}
	
	public void clickActivateAccount()
	{
		Element.click(activateAccount, "Activate your account link on registartion page");
	}
	
	public void verifyLoginErrorMessage()
	{
		Element.verifyTextPresent(txtErrorMsg, "The Temporary Username or Password you entered is not valid.");
	}
	
	public LoginUPA doLoginPurgedUPA(String userType)
	{
	   setUserProperties(userType);
	   if("prpurged".equals(testConfig.getRunTimeProperty("prpurged")));
	   else
		   Element.click(clickUPASignIn, "Click On Sign In UPA");
	   Element.enterData(txtboxUserName, id, "Username entered as : " + id,"txtboxUserName");
	   Element.enterData(txtboxPwd, password, "Password entered as : " + password ,"txtboxPwd");
	   Element.click(btnLogin,"click Login button");
       Browser.waitForPageLoad(testConfig);
	   
	   try{
	   if(txtErrorMsg1!=null)
	   {
	      if(txtErrorMsg1.isDisplayed())
	     {
	    	  Log.Comment("Authentication error message displayed..trying again");
	    	  Browser.wait(testConfig, 3);
	    	  Element.fluentWait(testConfig, txtboxPwd, 120,5, "txtboxOptumID");
	    	  Element.enterData(txtboxUserName,id, "Entered Optum ID as:" + " " +id, "txtboxOptumID"); 
	    	  Element.enterData(txtboxPwd,password, "Entered Optum ID password  as :" + " "+ password, "txtboxPwd");
	    	  Element.click(btnLogin, "Sign In");
	     }
	   }
	   }
	   catch(Exception e)
	   {
		   Log.Comment("Authentication Error not present");
	   }
     return this;
   }
	
	public LoginUPA enterSSOTin(String role)
	{
		int sqlRowNo=263;
		switch(role)
		{
			case "P":
				sqlRowNo=263;
				break;
			case "BS":
				sqlRowNo=264;
				break;
			case "PA":
				sqlRowNo=265;
				break;
		}
		Map data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Element.enterData(txtPIN, data.get("USERNAME").toString().trim(), "Security PIN", "Security PIN text Box");
		if("P".equals(role))
			Element.enterData(txtTin, data.get("PROV_TIN_NBR").toString().trim(), "Tin", "Tin Text Box");
		else if("BS".equals(role))
			Element.enterData(txtTin, data.get("IDENTIFIER_NBR").toString().trim(), "Tin", "Tin Text Box");
		else if("PA".equals(role))
			Element.enterData(txtTin, data.get("PAYR_TIN_NBR").toString().trim(), "Tin", "Tin Text Box");
		Element.click(btnContinue, "Continue btn");
		return this;
	}
	
	public LoginUPA verifyErrorPageAndClickReturn()
	{
		Element.verifyElementPresent(btnRtnLogin, "Return to Login");
		Element.click(btnRtnLogin, "Return to Landing Page");
		return this;
	}
	
	public LoginUPA verifyLandingPage()
	{
		Element.verifyElementPresent(clickUPASignIn, "Sign in Button");
		return this;
	}
	
}
