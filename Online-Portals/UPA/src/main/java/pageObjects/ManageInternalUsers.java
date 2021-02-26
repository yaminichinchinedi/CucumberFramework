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
		
	@FindBy(name="Remove")
	List <WebElement> btnRemove;
	
	@FindBy(name="Add")
	List <WebElement> btnAdd;
	
	@FindBy(name="submit")
	WebElement btnSubmit;
	
	@FindBy(linkText="Optum Pay Solutions")
	WebElement lnkOptPaySoln;
	
	@FindBy(id="logOutId")
	WebElement lnkLogOut;
	
	@FindBy(xpath="//option[@value='0028']")
	WebElement optumPaySolutionsTransaction;
	
	@FindBy(xpath="//td[contains(text(),'The CSR User Id belongs to Super User Group. Pleas')]")
	WebElement errorEnteringSuperUser;
	
	String env=System.getProperty("env");
	String userIdForTransactions,id;
	public ManageInternalUsers(TestBase testConfig) 
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		
		Browser.wait(testConfig, 2);
	}

	
	public void enterUserId(String userId) {
		id=testConfig.runtimeProperties.getProperty("CSR_"+"ID_"+userId+"_"+env);
		userIdForTransactions=userId;
		Element.enterDataByJS(testConfig, txtboxUserId, id, "csr USERID");
		Element.clickByJS(testConfig, btnSearchManagInternalUser , "search for userid");
		if (userId.equalsIgnoreCase("Super"))
		{Element.verifyElementPresent(errorEnteringSuperUser, "error is thrown");
		}
		
	}

	public void editSelectedTransactions(String Action) {
		if (!userIdForTransactions.equalsIgnoreCase("Super"))
		{
		 if(Action.equalsIgnoreCase("Remove"))
			 {Element.click(optumPaySolutionsTransaction,"OPSOl transaction");
			 Element.clickByJS(testConfig, btnRemove.get(1),"btnremove");
			 Browser.wait(testConfig,2);
			 }
		else if(Action.equalsIgnoreCase("Add"))
			{Element.click(optumPaySolutionsTransaction,"OPSOl transaction");
			 Element.clickByJS(testConfig, btnAdd.get(1),"btnremove");
			 Browser.wait(testConfig,2);
			}	
		Element.clickByJS(testConfig, btnSubmit, "Save");
		Browser.wait(testConfig,2);
		Element.clickByJS(testConfig,lnkLogOut,"logging Out of the portal");
	   }
		else
			Element.clickByJS(testConfig,lnkLogOut,"logging Out of the portal");
		
	}

	public void optumPaySolutionsLinkPresentorNot(String Action) {
		if (!userIdForTransactions.equalsIgnoreCase("Super"))
		{
		if(Action.equalsIgnoreCase("Remove"))
			Element.verifyElementNotPresent(lnkOptPaySoln, "OptumPaySol link");
		if(Action.equalsIgnoreCase("Add"))
			Element.verifyElementPresent(lnkOptPaySoln, "OptumPaySol link");
		}
		Element.clickByJS(testConfig,lnkLogOut , "logging Out of the portal");
		
	}
	

	
}