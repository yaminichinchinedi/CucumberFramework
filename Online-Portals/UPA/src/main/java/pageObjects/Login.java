package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	//Declare Page objects and methods
	
	@FindBy(id="userNameId")
	private WebElement csrId;
	
	@FindBy(name="j_field2")
	private WebElement csrPwd;
	
	@FindBy(name="btnSubmit")
	private WebElement loginbtn;
	
	public HomePage homepage;
    TestBase testConfig;
	String id,pwd;
	
	
	public Login(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		id=testConfig.runtimeProperties.getProperty("CSRID");
		pwd=testConfig.runtimeProperties.getProperty("CSRPwd");
		PageFactory.initElements(testConfig.driver, this);
		
	}


	public HomePage doLogin()
	{  
		Element.enterData(csrId,id,"Enter CSR id","csrId");
		Element.enterData(csrPwd,pwd,"Enter CSR id","csrPwd");
		Element.click(loginbtn,"Click Login button");
		return new HomePage(testConfig);
		
	}
	
	

}
