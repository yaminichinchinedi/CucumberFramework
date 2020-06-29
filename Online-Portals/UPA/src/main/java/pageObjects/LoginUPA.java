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
	   Element.clickByJS(testConfig,btnLogin,"click Login button");
	   return new UPAHomePage(testConfig); 
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
	
}
