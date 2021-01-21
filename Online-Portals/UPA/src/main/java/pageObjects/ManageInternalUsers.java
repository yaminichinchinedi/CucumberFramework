package main.java.pageObjects;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import main.java.Utils.Helper;

public class ManageInternalUsers {
	
	private WebDriver driver;
	private TestBase testConfig;
	
	@FindBy(name="CSRUserId")
	WebElement txtboxUserId;
	
	@FindBy(name="buttonS")
	WebElement btnSearchManagInternalUser;
	
	@FindBy(xpath="//option[@value='0028']")
	WebElement tt;
		
	@FindBy(name="Remove")
	List <WebElement> btnRemove;
	
	@FindBy(name="Add")
	List <WebElement> btnAdd;
	
	@FindBy(name="submit")
	WebElement btnSubmit;
	
	@FindBy(linkText="Optum Pay Solutions")
	WebElement lnkOptPaySoln;
	
	@FindBy(id="logOutId")
	WebElement linklogOut;
	//Element.findElement(testConfig, "id", "logOutId")
	public ManageInternalUsers(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		
		Browser.wait(testConfig, 2);
	}

	
	public void enterUserId(String userId) {
		 String env=System.getProperty("env");		 
		String id=testConfig.runtimeProperties.getProperty("CSR_"+"ID_"+userId+"_"+env);
		Element.enterDataByJS(testConfig, txtboxUserId, id, "csr USERID");
		Element.clickByJS(testConfig, btnSearchManagInternalUser , "search for userid");
		testConfig.putRunTimeProperty("userId", userId);
		if (userId.equalsIgnoreCase("Super"))
		{  
			
			Element.verifyElementPresent(Element.findElement(testConfig, "xpath", "//td[contains(text(),'The CSR User Id belongs to Super User Group. Pleas')]"), "error is thrown");
			
		}
		
	}

	public void editSelectedTransactions(String buttonType) {
		String userId=testConfig.getRunTimeProperty("userId");
		if (!userId.equalsIgnoreCase("Super"))
		{
		if(buttonType.equalsIgnoreCase("Remove"))
			{Element.click(Element.findElement(testConfig, "xpath", "//option[@value='0028']"),"OPSOl transaction");
			Element.clickByJS(testConfig, btnRemove.get(1),"btnremove");
			Browser.wait(testConfig,2);
			}
		else if(buttonType.equalsIgnoreCase("Add"))
			{
			Element.click(Element.findElement(testConfig, "xpath", "//*[@id=\"availableTransaction\"]/option"),"OPSOl transaction");
			Element.clickByJS(testConfig, btnAdd.get(1),"btnremove");
			Browser.wait(testConfig,2);
			}
		
			
		Element.clickByJS(testConfig, btnSubmit, "Save");
		Browser.wait(testConfig,3);
	    Element.clickByJS(testConfig, Element.findElement(testConfig, "id", "logOutId"), "logOutId");
	}
		else
			Element.clickByJS(testConfig,linklogOut , "logOut of the portal");
		
	}

	public void optumPaySollinkPresentorNot(String Action) {
		Browser.wait(testConfig,2);
		String userId=testConfig.getRunTimeProperty("userId");
		if (!userId.equalsIgnoreCase("Super"))
		{
		if(Action.equalsIgnoreCase("Remove"))
			Element.verifyElementNotPresent(lnkOptPaySoln, "OptumPaySol link");
		if(Action.equalsIgnoreCase("Add"))
			Element.verifyElementPresent(lnkOptPaySoln, "OptumPaySol link");
		}
		Element.clickByJS(testConfig,linklogOut , "logOut of the portal");
		
	}
	

	
}