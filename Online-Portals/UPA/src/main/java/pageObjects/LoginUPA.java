package main.java.pageObjects;

import java.io.IOException;
import java.util.Map;

import main.java.nativeFunctions.DataProvider;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.apache.xpath.operations.Or;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.DataBase;
import main.java.Utils.TestDataReader;

public class LoginUPA {
	
	
	
	@FindBy(id="usnamefield" )
	WebElement txtboxUserName;
	
	@FindBy(id="pwdfield")
	WebElement txtboxPwd;
	
	//@FindBy(linkText="SIGN IN WITH EPS ID")
	
    @FindBy(linkText="SIGN IN WITH EPS ID" )
	WebElement btnLogin;
    
    @FindBy(xpath="//font[@class='errors']")
	private WebElement txtErrorMsg;
	
    @FindBy(xpath=".//*[@id='signin-tile']/div/p[2]/a")
    public WebElement activateAccount;
    
    @FindBy(linkText="ACTIVATE")
    public WebElement btnActivate;
    
	
	
    @FindBy(id="tabHome")
    public WebElement tabHome;
			
	@FindBy(linkText="How to Enroll")
	WebElement tabHowToEnroll;
			
    @FindBy(linkText="Benefits of EPS")
    WebElement tabBenefitsOfEPS;
	
	private TestBase testConfig;
	String id, password;

	public LoginUPA(TestBase testConfig) 
	{
		
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		
        
	}
	
	//Deafult constructor
	public LoginUPA() 
	{
		//this.testConfig=testConfig;
		//PageFactory.initElements(testConfig.driver, this);
	}
	
	
	public void setUserProperties()
	{
		testConfig.putRunTimeProperty("id",id);
		testConfig.putRunTimeProperty("password",password);
	}
	
	public void verifyLoginUI()
	{
		Element.verifyElementPresent(tabHowToEnroll,"How to enroll tab");
		Element.verifyElementPresent(tabBenefitsOfEPS,"Benefits Of EPS tab");
	}

	
//	public SplashPage3 doLogin(int rowNo) throws IOException
//	{
//		TestDataReader data=testConfig.cacheTestDataReaderObject("Login");
//		id=data.GetData(rowNo,"Username");
//		password=data.GetData(rowNo,"Password");
//		Element.enterData(txtboxUserName,id, "Username entered as:" + " " +id, "txtboxUserName");
//		Element.enterData(txtboxPwd,password, "Password entered as :" + " "+ password, "txtboxPwd");
//		Element.click(btnLogin,"Login button");
//		setUserProperties();
//		
//	   return new SplashPage3(testConfig);
//	}
	
	
	public SplashPage3 doLogin(String userType,String accessType) throws IOException
	{
//		DataProvider dataProvider=new DataProvider();
//		dataProvider.setUserCredentials(testConfig, userType, accessType);
		String env=System.getProperty("env");
        id=testConfig.runtimeProperties.getProperty("UPA_"+"ID_"+userType+"_"+accessType+"_"+env);
        password=testConfig.runtimeProperties.getProperty("UPA_"+"Pwd_"+userType+"_"+accessType+"_"+env);
        Element.click(activateAccount, "Click Activate your account link on registartion page");
		
		Element.enterData(txtboxUserName,id, "Username entered as:" + " " +id, "txtboxUserName");
		Element.enterData(txtboxPwd,password, "Password entered as :" + " "+ password, "txtboxPwd");
		
		Element.click(btnActivate, "Click Activate your account button");
		//Element.click(btnLogin,"Login button");
		setUserProperties();
		
	   return new SplashPage3(testConfig);
	}
	
	public void doInvalidLoginAndVerifyValidation(int rowNo) throws IOException
	{
		TestDataReader data=testConfig.cacheTestDataReaderObject("Login");
		id=data.GetData(rowNo,"Username");
		password=data.GetData(rowNo,"Password");
		
		Element.enterData(txtboxUserName, id, "Correct Username entered as :"+" " + id, "txtboxUserName");	
		Element.enterData(txtboxPwd, password, "Invalid Password entered :" + " " + password, "txtboxPwd");
		Element.click(btnLogin,"Login button");
		
		verifyLoginErrorMessage();
		
	}
	
	public void verifyLoginErrorMessage()
	{
		Element.verifyTextPresent(txtErrorMsg, "The Username or Password you entered is not valid.");
	}
	
}
