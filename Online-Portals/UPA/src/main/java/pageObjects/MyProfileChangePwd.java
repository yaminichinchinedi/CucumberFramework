package main.java.pageObjects;

import java.util.List;

import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.LogTemp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MyProfileChangePwd extends MyProfile{

    @FindBy(name="pwd")
    public WebElement txtBoxCurrentPwd;
    

    @FindBy(name="newPassword")
    public WebElement txtBoxNewPwd;
    

    @FindBy(name="retypeNewPassword")
    public WebElement txtBoxRetypeNewPwd;
    
    @FindBy(name="Yes")
    public WebElement btnYes;
    
    @FindBy(name="No")
    public WebElement btnNo;
    
    @FindBy(css="font.errors")
    public WebElement errorMsg;
    
    @FindBy(xpath="//tr[2]/td/table/tbody/tr[3]/td")
    public WebElement cancelTxt;
    
    @FindBy(xpath="//input[@value='Cancel']")
    public WebElement btnCancel;
    
    @FindBy(xpath="//input[@value=' Save ']")
    public WebElement btnSave;
    
    @FindBy(css="ul.pguide")
    public WebElement pwdGuide;
    
    
	private TestBase testConfig;
    
    
    public MyProfileChangePwd(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(testConfig.driver, this);
	  Element.verifyElementPresent(txtBoxCurrentPwd, "Current password textbox");
    }
    
    
    public MyProfile verifyCancelYesFunctionality()
    {   
    	clickCancel();
    	Element.click(btnYes, "Yes button");
    	Browser.wait(testConfig, 2);
    	Browser.verifyURL(testConfig, "returnmyprofile.do");
    	return this;
    }
    
    public MyProfile verifyCancelNoFunctionality()
    {
    	clickCancel();
    	Element.click(btnNo, "No button");
    	Browser.wait(testConfig, 2);
    	Browser.verifyURL(testConfig, "returnchangepwdpage.do");
    	return this;
    }
    
    public String clickCancel()
    { 
    	String expectedText="Are you sure you wish to cancel your password change?";
    	Element.click(btnCancel, "Cancel button");
    	Element.verifyTextPresent(cancelTxt, expectedText);
    	return Browser.getURL(testConfig);
    }
    
    public MyProfile savePwd()
    { 
    	
    	String currentPwd="Test@1234";
    	Element.enterData(txtBoxCurrentPwd,currentPwd ,"Enter Current Password as :"+" " + currentPwd, "Current Password");
    	Element.enterData(txtBoxNewPwd, currentPwd ,"Enter New Password as :"+" " + currentPwd, "New Password");
    	Element.enterData(txtBoxRetypeNewPwd,  currentPwd ,"Retype New Password as :"+" " + currentPwd, "Re type New Password");
    	Element.click(btnSave, "Save button");
    	
    	return new MyProfile(testConfig);
    }
    
    
    public MyProfileChangePwd verifyChangePwdValidations()
    { 
    	
    	String pwd="Test@1234";
    	
    	/**Leave current password field blank*/
    	
    	Element.enterData(txtBoxCurrentPwd,"","Enter Current Password as empty string", "Current Password");
    	
    	/**Enter valid password in new password fields*/
    	
    	Element.enterData(txtBoxNewPwd,pwd ,"Enter New Password as :"+" " + pwd, "New Password");
    	Element.enterData(txtBoxRetypeNewPwd,  pwd ,"Retype New Password as :"+" " + pwd, "Re type New Password");
    	
    	//Click Save button
    	Element.click(btnSave, "Save button");
    	
    	Element.verifyTextPresent(errorMsg, "Current Password: Invalid Data");
    	
    	/** Enter valid data in current password */
    	Element.enterData(txtBoxCurrentPwd,pwd ,"Enter Current Password as :"+" " + pwd, "Current Password");
    	
    	/**Leave new password blank */
    	
    	Element.enterData(txtBoxNewPwd,"" ,"Enter New Password as empty string", "New Password");
    	Element.enterData(txtBoxRetypeNewPwd,  pwd ,"Retype New Password as :"+" " + pwd, "Re type New Password");
    	Element.click(btnSave, "Save button");
    	
    	Element.verifyTextPresent(errorMsg, "New Password: Invalid Data");
    	
    	//Different passwords in new password and retype password textbox
    	Element.enterData(txtBoxCurrentPwd,pwd ,"Enter Current Password as :"+" " + pwd, "Current Password");
    	Element.enterData(txtBoxNewPwd, pwd ,"Enter New Password as :"+" " + pwd, "New Password");
    	Element.enterData(txtBoxRetypeNewPwd,  pwd+"1" ,"Retype New Password as :"+" " + pwd+"1", "Re type New Password");
    	
    	Element.click(btnSave, "Save button");
    	
    	Element.verifyTextPresent(errorMsg, "Retype New Password: Invalid Data.");
    	
    	return new MyProfileChangePwd(testConfig) ;
    	
    	
    }


    public void verifyPwdGuideLines()
    {
    	List<WebElement> pwdGuideLines=pwdGuide.findElements(By.tagName("li"));
    	LogTemp.Comment("Verifying password guidelines..");
    	Element.verifyTextPresent(pwdGuideLines.get(0), "be between 8 and 25 characters");
    	Element.verifyTextPresent(pwdGuideLines.get(1), "include at least one upper-case character, one lower-case character and one number");
    	Element.verifyTextPresent(pwdGuideLines.get(2), "be case-sensitive");
    	Element.verifyTextPresent(pwdGuideLines.get(3), "not contain your username");
    	Element.verifyTextPresent(pwdGuideLines.get(4), "not be same as any of the last 10 passwords");
   
    }
	
    
}
