package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class VersionPage {

	
	
   @FindBy(xpath = "//body[contains(text(),'Deployed Version: ')]") 
   WebElement txtDeployedBranch;
	
	
	private TestBase testConfig;
	String env=System.getProperty("env");
	
	public VersionPage(TestBase testConfig)
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		testConfig.driver.navigate().to(System.getProperty("URL"));
	}

	public String getDevDeployedBranchVersion()
	{
		int index=txtDeployedBranch.getText().indexOf(":"); 
		return txtDeployedBranch.getText().substring(index+2, txtDeployedBranch.getText().length());
	}
	
	
	public void verifyDevAndQABranchVersionIsSame()
	{
		if(getDevDeployedBranchVersion().equalsIgnoreCase(System.getProperty("QABranchVersion")))
				Log.Pass(" Dev & QA Branch version matches");
				else
					Log.Fail("Mismatch between Dev and QA branch , Dev branch is :" +getDevDeployedBranchVersion() + "\n" +  "QA branch is" + System.getProperty("QABranchVersion"));
	}
}

