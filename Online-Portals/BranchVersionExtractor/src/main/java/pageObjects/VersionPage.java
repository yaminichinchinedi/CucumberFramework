package main.java.pageObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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
		Log.Comment("Navigated to App Version URL for stage " + System.getProperty("URL"));
	}

	public String getDevDeployedBranchVersion()
	{
		int index=txtDeployedBranch.getText().indexOf(":"); 
		System.out.println("current version is : " + txtDeployedBranch.getText().substring(index+2, txtDeployedBranch.getText().length()));
		return txtDeployedBranch.getText().substring(index+2, txtDeployedBranch.getText().length());
	}
	
	
	public void verifyDevAndQABranchVersionIsSame()
	{
		if(getDevDeployedBranchVersion().equalsIgnoreCase(System.getProperty("automationBranch")))
				Log.Pass(" Dev & QA Branch version matches");
				else
					Log.Fail("Mismatch between Dev and QA branch , Dev branch is :" +getDevDeployedBranchVersion() + "\n" +  "Automation branch is" + System.getProperty("automationBranch"));
	}

	public void verifyCommitIDfromYesterday() throws IOException {
		if(getDevCodeCommitIDfromYesterday()!="")
		 {
	        if(getDevCodeCommitIDfromYesterday().equals(getDevDeployedBranchVersion()))
	        	Log.Fail("Yesterday DEVcommit ID and Today DEVcommit are same which is :" + getDevDeployedBranchVersion() + "hence not running regression JOB");
	        	else
	        	{
	        		Log.Pass("Yesterday DEV commit ID and Today DEV commit are  NOT same ,hence starting RUNNING regression JOB");
	        		Log.Comment("Yesterday DEVcommit ID is :" + getDevCodeCommitIDfromYesterday());
	        		Log.Comment("Today DEVcommit ID is :" + getDevDeployedBranchVersion());
	        		writeDeployedVersionInFile();
	        	}
		 }
	        		
		
}

	public String getDevCodeCommitIDfromYesterday() throws IOException {
	
		String versionFromFile="";
		String fileLocation=("C:\\Users\\rkrish38\\Jenkins\\DeployedVersion.txt");
		File file =new File(fileLocation);
		if(file.exists())
		{
		 Log.Comment("Deplyed version file already exists");
		 FileReader reader = new FileReader(fileLocation); 
	     int i; 
	     while ((i=reader.read()) != -1) 
	     versionFromFile=versionFromFile+(char)i;
	     
	     
	     
		}
		else
		{
			Log.Comment("Deployed version file does not exist. ence creating a new one");
			writeDeployedVersionInFile();
		}
	   
		System.out.println("Verion is : " + versionFromFile);
	    return versionFromFile;
	  
	}

  public void writeDeployedVersionInFile()
  {
    try  
    {
//    	FileWriter fileWriter = new FileWriter(System.getProperty("user.dir")+"\\DeployedVersion.txt");
    	
    	FileWriter fileWriter = new FileWriter("C:\\Users\\rkrish38\\Jenkins\\DeployedVersion.txt");
    	String devCommitID = getDevDeployedBranchVersion();
        fileWriter.write(devCommitID);
        fileWriter.close();
        Log.Comment("Writing  code commitdd " + devCommitID);
   
    } 
    catch (IOException e) {}
    
}
}
		
	

