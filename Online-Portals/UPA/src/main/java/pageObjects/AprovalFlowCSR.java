package main.java.pageObjects;

import java.util.ArrayList;
import java.util.List;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AprovalFlowCSR {

	
	@FindBy(id="userNameId")
    public WebElement txtboxUserName;
	
	@FindBy(name="j_field2")
    public WebElement txtboxPwd;
	
	@FindBy(name="userName")
    public WebElement txtUserName;
	
	@FindBy(name="tinNumber")
    public WebElement txtTinNo;
	
	@FindBy(name="emailAddress")
    public WebElement txtboxEmailAdd;
	
	@FindBy(name="btnSubmit")
	public WebElement btnContinue;
	
	@FindBy(name="password")
    public WebElement newPwd;
	
	@FindBy(name="retypePassword")
    public WebElement newRetypePwd;
	
	
	@FindBy(xpath=".//*[@id='signInForm']/table/tbody/tr[4]/td/table/tbody/tr")
	public List <WebElement> securityQues;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement btnLogin;
			
	
	
	private TestBase testConfig;
	String id, password;

	public AprovalFlowCSR(TestBase testConfig)
	{
		
	   this.testConfig=testConfig;
	   testConfig.driver.navigate().to(System.getProperty("URL"));
	   Log.Comment("Navigated to CSR with URL :" +" " + System.getProperty("URL")) ;
       PageFactory.initElements(testConfig.driver, this);
	
	}
	
	//Default constructor
	public AprovalFlowCSR()
	{
	
	}
	
	@Test
	public void getUserApproved(TestBase testConfig,String username,String tinNo, String emailAddr)
	{
		//Opening a new tab
		testConfig.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		testConfig.driver.switchTo().window(testConfig.driver.getTitle());
		
		//Storing window handles
		ArrayList<String> tabs = new ArrayList<String> (testConfig.driver.getWindowHandles());
		
		//Switching to new tab
		testConfig.driver.switchTo().window(tabs.get(1));
		
		
		
		((JavascriptExecutor) testConfig.driver).executeScript("window.focus();");
		
		
		testConfig.driver.navigate().to(System.getProperty("UserActiveURL"));
		Element.enterData(txtUserName, username, "Enter username as :" + " " +username , "userName");
		Element.enterData(txtTinNo, tinNo, "Enter Tin number as :" + " " +tinNo , "tinNo");
		Element.enterData(txtboxEmailAdd, emailAddr, "Enter email address as :" + " " +emailAddr , "emailAddr");
		Element.click(btnContinue, "Continue button");
		
		while(securityQues.size()>0)
		{
			int i=0;
			int securityQuestionToBeSelected=32;
			Element.selectByValue(securityQues.get(i).findElement(By.tagName("select")),Integer.toString(securityQuestionToBeSelected), "Selected security question");
			i=i+2;
			securityQuestionToBeSelected++;
		}
		
		
	}

	
}
