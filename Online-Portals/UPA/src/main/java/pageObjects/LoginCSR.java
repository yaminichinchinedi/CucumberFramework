package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginCSR {

	
	@FindBy(id="userNameId")
    public WebElement txtboxUserName;
	
	@FindBy(name="j_field2")
    public WebElement txtboxPwd;
	
	@FindBy(name="btnSubmit")
	public WebElement btnLogin;
			
	
	
	private main.java.nativeFunctions.TestBase testConfig;
	String id, password;

	public LoginCSR(main.java.nativeFunctions.TestBase testConfig)
	{
		
		this.testConfig=testConfig;
		String env=testConfig.getRunTimeProperty("Env");
		id=testConfig.runtimeProperties.getProperty("CSRID");
		password=testConfig.runtimeProperties.getProperty("CSRPwd");
		PageFactory.initElements(testConfig.driver, this);
		//Element.verifyElementPresent(tabHome,"Home tab");
	}
	
	
	
	public CSRHomePage doLogin()
	{
	   //verifyLoginUI();
		Element.enterData(txtboxUserName, id, "Username entered","txtboxUserName");	
		Element.enterData(txtboxPwd, password, "Password entered","txtboxPwd");
		Element.click(btnLogin,"click Login button");
		Browser.wait(testConfig, 50);
	   return new CSRHomePage(testConfig);
	}
	
}
