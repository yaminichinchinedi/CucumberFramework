package main.java.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.LogTemp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginCSR {

	
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

	public LoginCSR(TestBase testConfig)
	{
		
	   this.testConfig=testConfig;
	   testConfig.driver.navigate().to(System.getProperty("URL"));
	   LogTemp.Comment("Navigated to CSR with URL :" +" " + System.getProperty("URL")) ;
       PageFactory.initElements(testConfig.driver, this);
	}
	
	//Default constructor
	public LoginCSR()
	{
	
	}
	
	public void getUserApproved(TestBase testConfig,String username,String tinNo, String emailAddr) throws InterruptedException
	{
		
		FirefoxDriver FFdriver=new FirefoxDriver();
		FFdriver.manage().window().maximize();
		
		//Navigating to URL in new tab
		
		FFdriver.navigate().to(System.getProperty("UserActiveURL"));
		
		FFdriver.findElement(By.name("userName")).sendKeys(username);
		LogTemp.Comment("Username is : " + username);
		FFdriver.findElement(By.name("tinNumber")).sendKeys(tinNo);
		LogTemp.Comment("Tin no is : " + tinNo);
		FFdriver.findElement(By.name("emailAddress")).sendKeys(emailAddr);
		LogTemp.Comment("Email address is : " + emailAddr);
		
		FFdriver.findElement(By.name("btnSubmit")).click();
		
		Thread.sleep(5000);
		FFdriver.findElement(By.name("password")).sendKeys("Test@123");
		LogTemp.Comment("Entered Password as : " + "Test@123");
		FFdriver.findElement(By.name("retypePassword")).sendKeys("Test@123");
		LogTemp.Comment("Re Entered Password as : " + "Test@123");
		FFdriver.findElement(By.name("btnSubmit")).click();
		LogTemp.Comment("Clicked Continue button");
		
		Browser.wait(testConfig, 5);
		List <WebElement> securityQues=FFdriver.findElements(By.xpath(".//*[@id='signInForm']/table/tbody/tr[4]/td/table/tbody/tr"));
		
		int i=0,j=1;
		int securityQuestionToBeSelected=32;
		
		while(i<9)
		{
			Element.selectByValue(securityQues.get(i).findElement(By.tagName("select")),Integer.toString(securityQuestionToBeSelected), "Selected security question with option value : " + securityQuestionToBeSelected );
			Element.enterData(securityQues.get(j).findElement(By.tagName("input")), "EPS", "Answer is EPS", "Answer textbox");
			i=i+2;
			securityQuestionToBeSelected++;
			j=j+2;
		}
		
		Browser.wait(testConfig, 2);
		FFdriver.findElement(By.name("btnSubmit")).click();
		
		Browser.wait(testConfig, 2);
		
		FFdriver.findElement(By.name("btnSubmit")).click();
		
		Browser.wait(testConfig, 2);
		
		LogTemp.Comment("Checking accept terms checkbox");
		FFdriver.findElement(By.name("acceptTerms")).click();
		
		Browser.wait(testConfig, 2);
		
		LogTemp.Comment("Click Submit registration");
		FFdriver.findElement(By.name("btnSubmit")).click();
		Browser.wait(testConfig, 2);
		
		FFdriver.quit();
	}
	
	public CSRHomePage doLogin(String userType)
	{
	   String env=System.getProperty("env");
       id=testConfig.runtimeProperties.getProperty("CSR_"+"ID_"+userType+"_"+env);
       password=testConfig.runtimeProperties.getProperty("CSR_"+"Pwd_"+userType+"_"+env);
		testConfig.putRunTimeProperty("id", id);
	   Element.enterData(txtboxUserName, id, "Username entered","txtboxUserName");	
	   Element.enterData(txtboxPwd, password, "Password entered","txtboxPwd");
	   Element.click(btnLogin,"click Login button");
	   return new CSRHomePage(testConfig);
	}
}
