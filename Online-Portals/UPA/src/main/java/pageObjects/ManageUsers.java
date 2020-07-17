package main.java.pageObjects;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.spi.Elements;
import com.ibm.db2.jcc.am.tn;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.TestDataReader;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.nativeFunctions.Element;
import main.java.reporting.Log;
import main.java.reporting.Log;
import main.java.reporting.Log;

public class ManageUsers extends AddUserDetails  {
	
	//private static final boolean String = false;

	@FindBy(linkText="User List")
	WebElement lnkUserList;
	
	@FindBy(id="allProvAssocyes")
	WebElement rdoYes;
	
	
	@FindBy(xpath="//span[contains(text(),'User Name')]")
	WebElement csrUserName;
	
	
	@FindBy(id="allProvAssocno")
	WebElement rdoNo;
	
	WebElement emailChkbox=null;
	
	@FindBy(xpath="//input[@value='Add User']")
	WebElement btnAddUser;
	
	@FindBy(name="GridListResults[0].removeTinNpi")
	WebElement chkRemoveTin;
	
	
	@FindBy(xpath="//input[contains(@value,'Save')]")
	WebElement btnSave;
	
	@FindBy(xpath="//input[@value='Delete User']")
	WebElement btnDelete;
	
	@FindBy(id="notu")
	WebElement lnkNotYou;
	
	@FindBy(css="input[value='Cancel']")
	WebElement btnCancel;
	
	@FindBy(xpath="//div[@id='flow']//tbody//a")
	List <WebElement> userNames;
	
	@FindBy(xpath="//select[not(contains(@id,'accessLevel'))]/parent::td//select")
	List <WebElement> accessLvls;
	
	@FindBy(xpath="//select[not(contains(@id,'accessLevel'))]/parent::td//select/../preceding-sibling::td[2]")
	List <WebElement> accessLvlChangedTin;

	@FindBy(xpath="//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr")
	List<WebElement> tinGridRows;
	
	@FindBy(xpath="//a[contains(text(),'TIN')]")
	WebElement lnkTinInGrid;
	
	
	@FindBy(name="bsUserAccessLvl")
	WebElement drpDwnBSaccessLvl;
	
	@FindBy(name="No")
	WebElement btnNo;
	
	@FindBy(name="Yes")
	WebElement btnYes;
	
	@FindBy(xpath="//input[@value='Reset Password']")
	WebElement btnResetPwd;
	
	@FindBy(xpath=".//*[contains(text(),' been reset')]")
	WebElement txtResetPwd;
	
	@FindBy(name="purgedUser")
	WebElement chkBoxPurgedUser;
	
	@FindBy(id="limitPayerAccessyes")
	WebElement btnYesSubPayerDataOnly;
	
	@FindBy(id="limitPayerAccessno")
	WebElement btnNoSubPayerDataOnly;
	
	
	@FindBy(name="fundingEmailNotify")
	List<WebElement> chkBoxFundingEmail;
	
	@FindBy(name="nonEnrolledEmailNotify")
	List<WebElement> chkBoxNonEnrolledEmailNotify;
	
	@FindBy(name="inActiveEmailNotify")
	List<WebElement> chkInActiveEmailNotify;
	
	@FindBy(xpath=".//*[contains(text(),'Status')]")
	WebElement txtStatus;
	
	private TestBase testConfig;
	LoginCSR csrPage;
	
	
	public ManageUsers(TestBase testConfig)
	{
		super(testConfig);
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.expectedWait(lnkUserList, testConfig, "User List", "User List");	

	}
	
	public AddUserDetails clickAddNewUser()
	{
		Element.clickByJS(testConfig,btnAddUser, "Add User");
		return new AddUserDetails(testConfig);
	}

	
	public ManageUsers clickSave()
	{
		btnSave=Element.findElement(testConfig, "xpath", "//input[contains(@value,'Save')]");
		Element.clickByJS(testConfig,btnSave, "Save Button");
		return new ManageUsers(testConfig);
	}
	
	public CancelManageUser clickCancel()
	{
		Element.clickByJS(testConfig,btnCancel, "Cancel Button");
		return new CancelManageUser(testConfig);
	}
	
	public ManageUsers clickCSRDelete()
	{
		Element.clickByJS(testConfig,btnDelete, "Delete Button");
		Element.clickByJS(testConfig,btnYes, "Yes button");
		return new ManageUsers(testConfig);
	}
	
	
	/*
	 * This function verifies the user list is sorted
	 * in ascending order initially
	 * but when we click user list link, 
	 * user names are sorted into descending order
	 * 
	 */
	public void doUserListSorting() throws InterruptedException
	{
	    ArrayList<String>expectedUsersList=new ArrayList<String>();
	    ArrayList<String> UsersListUI=getListOfAllUsersFromUI(testConfig);
	    expectedUsersList.addAll(UsersListUI);
	    
	    
	    //sorts list in ascending order
	    Collections.sort(expectedUsersList);

	    //Verifies list after sorting is same as list appearing on UI i.e. names are in ascending order
	    Helper.compareEquals(testConfig, "User List Comparison", expectedUsersList, UsersListUI);
	    
	    //Click on user list link to get descending order user list
	    Element.click(lnkUserList, "User List Link");
	    
	    //method removes all the elements of a single ArrayList 
	    UsersListUI.clear();
	    Log.Comment("Cleared previous User List");
	   
	    Browser.wait(testConfig, 2);
	    UsersListUI=getListOfAllUsersFromUI(testConfig);
	  
	    //method reverses the elements of the given ArrayList in linear time i.e. gives descending order list
	    Collections.reverse(expectedUsersList);
	    
	    //Verifies list is now in descending order
	    Helper.compareEquals(testConfig, "User List Comparison", expectedUsersList, UsersListUI);   
		
	}	
	
		
	/**
	 * This function gets the list of all users 
	 * displayed in user list in left nav
	 */
	
	public ArrayList<String> getListOfAllUsersFromUI(TestBase testConfig) throws InterruptedException
	{  
		List <WebElement> userNames=null;
		ArrayList<String> UsersListUI=new ArrayList<String>();
		try{
			userNames=testConfig.driver.findElements(By.xpath("//div[@id='flow']//tbody//a"));
		   }
		catch(Exception e){
			Log.Comment("Finding user List again");
			userNames=testConfig.driver.findElements(By.xpath("//div[@id='flow']//tbody//a"));
		   }
	   
		try{
		for(WebElement userName:userNames)
		 { 
			UsersListUI.add(userName.getText().toString().toUpperCase().trim());	
		 }
		}
		catch(Exception e)
		{
			Log.Comment("Exception occured : " +  e);
		}
		return UsersListUI;			
	}
	
	public void deleteAndVerifyUserIsDeleted() throws InterruptedException
	{
		ArrayList<String> UsersListUI=getListOfAllUsersFromUI(testConfig); 
		Log.Comment("Current User List before  deleting user is" + '\n'  + UsersListUI);
		
		//Delete the user
		clickCSRDelete();
		
		//Retrieving the fresh user list again after deleting user
		UsersListUI.clear();
		UsersListUI=getListOfAllUsersFromUI(testConfig);
		
		if(!UsersListUI.contains(firstNameTxt))
		{
			Log.Pass("User with first name : " + " " + "'" +firstNameTxt + "'" + "is deleted successfully");
		}
		else 
			Log.Fail("User with first name : " + " " + "'" +firstNameTxt + "'" + "not deleted");
		Log.Comment("User List after deleting user is" + '\n'  + UsersListUI);
	}
	
	/*
	 * This function fetches the name of an active user
	 * which is associated with the logged in tin 
	 * i.e. the tin that you selected on Home Page 
	 */
	public String getActiveUser(String userType)
	{
        int sqlRowNo=10;
        String result="";
        
        if(userType.equalsIgnoreCase("PROV"))
        	sqlRowNo=10;
        else if(userType.equalsIgnoreCase("BS"))
        	sqlRowNo=18;
        else if(userType.equalsIgnoreCase("PAY"))
        	sqlRowNo=19;
        
		//Find an Active User associated with logged in Provider Tin number
		Map enrolledProvider = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		
		  if(null == enrolledProvider)
			Log.Fail("No active user available in Database for " + testConfig.getRunTimeProperty("tin") + '\n' + "Please execute the test case manually");
		
		 else
		 {
		   testConfig.putRunTimeProperty("user", enrolledProvider.get("USERNAME").toString());
		   String activeUser=enrolledProvider.get("LST_NM").toString().toUpperCase()+","+ " " +enrolledProvider.get("FST_NM").toString().toUpperCase();
		   Log.Comment("Active user returned is :" +" " + activeUser);
		   testConfig.putRunTimeProperty("activeUserID", enrolledProvider.get("SSO_ID").toString());
		   result= activeUser;
		 }
		return result;
	}
	
	/**
	 * This function clicks the active user 
	 * to view its details on 
	 * Manage user Page
	 */

	public ManageUsers clickActiveUserName(String userType)
	{
		String activeUser=getActiveUser(userType);
		for(WebElement userName:userNames)
		{ 
		  if(userName.getText().toString().toUpperCase().contains(activeUser))
		   {
			  Element.click(userName, "UserName: "+ " " +activeUser);
			  break;
		   }
	     }
		Browser.waitTillSpecificPageIsLoaded(testConfig, "Manage User");
		return new ManageUsers(testConfig);
	}
	
	
	
	/**
	 * This function clicks the specified user by 
	 * passing its username
	 * to view its details on 
	 * Manage user Page
	 */
	public ManageUsers clickSpecificUserName(String nameOfUser)
	{
		for(WebElement userName:userNames)
		{ 
		  if(userName.getText().toString().toUpperCase().contains(nameOfUser))
		   {
				      Element.clickByJS(testConfig,userName, "UserName: "+ " " +nameOfUser);
				      break;
		   }
	     }
		return new ManageUsers(testConfig);
	}
	
	/**
	 * This function is used to change 
	 * Access Level of an Active user 
	 * which is fetched from DB
	 */
	
	public ManageUsers changeAndSaveAccessLevel(String userType) throws InterruptedException
	{
		 

		int sqlNo=257;
		int sqlRowNo=11;

		//Clicks on an active user displayed in User List
		clickActiveUserName(userType);
		String newAddedTin=selectAndAddTin(sqlNo);
		
		Log.Comment("Tin number for whom access level is to be changed is :" + " "+ newAddedTin);
		testConfig.putRunTimeProperty("tinNo",newAddedTin);
        
		WebElement accessLvlDrpDwn=null;
		List<WebElement> tinGridRows = testConfig.driver.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
		for(int i=1;i<tinGridRows.size();i++)
		{
			String tinNo=tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
				if(tinNo.equalsIgnoreCase(newAddedTin))
				{
					accessLvlDrpDwn=tinGridRows.get(i).findElement(By.tagName("select"));
					
					//Select Access Level as General for the new added tin
					Element.selectByVisibleText(accessLvlDrpDwn, "General", "Select General as access level");
					Browser.waitForLoad(testConfig.driver);
				    clickSave();
				    Browser.waitTillSpecificPageIsLoaded(testConfig, "Manage User");
					Map portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
				    Helper.compareEquals(testConfig, "Access Level", "G", portalUserData.get("ACCESS_LVL").toString());
				  
				    
				    //Handling stale element
				    tinGridRows = testConfig.driver.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
				    accessLvlDrpDwn=tinGridRows.get(i).findElement(By.tagName("select"));
				    
				    Element.selectByVisibleText(accessLvlDrpDwn, "Administrator", "Admin as access level");
				    HomePage home=clickCancel().clickYes();
				    
				    Browser.waitForLoad(testConfig.driver);
				    Helper.compareEquals(testConfig, "Access Level", "G", portalUserData.get("ACCESS_LVL").toString());
				    
				    home.clickManageUsersTab().clickSpecificUserName(testConfig.getRunTimeProperty("activeUser"));
				    
				   //Handling stale element
				    tinGridRows = testConfig.driver.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
				    accessLvlDrpDwn=tinGridRows.get(i).findElement(By.tagName("select"));
				   
				    
				    Element.selectByVisibleText(accessLvlDrpDwn, "General", "Select General as access level");
				    clickCancel().clickNo();
				    Helper.compareEquals(testConfig, "Access Level", "G", portalUserData.get("ACCESS_LVL").toString());
					break;
					
				}
			}
       
	    
	    return this;
}
	
	public ManageUsers changeAndCancelAccessLevel(String userType) throws InterruptedException
	{    
		 int sqlRowNo=11;
		 clickActiveUserName(userType);
		 accessLvlChangedTin=Element.findElements(testConfig, "xpath","//select[not(contains(@id,'accessLevel'))]/parent::td//select/../preceding-sibling::td[2]");
		 
	       //Get the tin number for which access level is to be changed
		   testConfig.putRunTimeProperty("tinNo",accessLvlChangedTin.get(0).getText().toString());
		   Log.Comment("Tin number for whom access level is to be changed is :" + " "+  testConfig.getRunTimeProperty("tinNo"));
		   accessLvls=Element.findElements(testConfig, "xpath","//select[not(contains(@id,'accessLevel'))]/parent::td//select"); 
		   String initialAccessLvl=accessLvls.get(0).getAttribute("value");

		   //Get the Access Level already selected for first Active tin displayed in Grid
		   if(initialAccessLvl!="G")
		   Element.selectByVisibleText(accessLvls.get(0), "General", "Select General as access level");  
		   else
		   Element.selectByVisibleText(accessLvls.get(0), "Administrator", "Admin as access level");
		  
		   HomePage home=clickCancel().clickYes();
		   Map portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		   
		   //Verify Changes are not saved when Yes is clicked on Manage Users Page
		   Helper.compareEquals(testConfig, "Access Level", initialAccessLvl, portalUserData.get("ACCESS_LVL").toString());
		   
		   
		   //MAking changes again to access level 
		   home.clickManageUsersTab().clickActiveUserName(userType);
		   accessLvls= testConfig.driver.findElements(By.xpath("//select[not(contains(@id,'accessLevel'))]/parent::td//select"));
		   
		   if(initialAccessLvl!="G")
		    Element.selectByVisibleText(accessLvls.get(0), "General", "Select General as access level");  
		   else
		    Element.selectByVisibleText(accessLvls.get(0), "Administrator", "Admin as access level");
		   
		   accessLvls= testConfig.driver.findElements(By.xpath("//select[not(contains(@id,'accessLevel'))]/parent::td//select"));
		   String changedAccessLvl=accessLvls.get(0).getAttribute("value");
		   Log.Comment("After reselecting, the changed access level is : " + " " + changedAccessLvl );
		   
		   //Click Cancel and click No to get back on manage users page
		   clickCancel().clickNo();
		   
		   //handling stale element exception
		   accessLvls= testConfig.driver.findElements(By.xpath("//select[not(contains(@id,'accessLevel'))]/parent::td//select"));
		   
		   //Verifying the changed access level is still visible on manage users page
		   Helper.compareEquals(testConfig, "Access Level ", changedAccessLvl, accessLvls.get(0).getAttribute("value"));
		   return this;	
	}
	
	
	public void verifyTinGridSorting()
	{		
		 ArrayList<String> actualHeadersList=new ArrayList<String>();
		// ArrayList<String> expectedHeaderList=new ArrayList<>(Arrays.asList("tin", "provider name", "tin access level","npi","npi name","email notification","remove tin/npi"));
		 ArrayList<String> expectedHeaderList=new ArrayList<>(Arrays.asList("tin", "provider name", "tin access level","npi","npi name","email notification","delete user"));
	     List<WebElement> tinGridRows = testConfig.driver.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
		 List<WebElement> tinGridRowHeader=tinGridRows.get(0).findElements(By.xpath("//th"));

		
		 //Getting Headers of Tin Grid in a list 
		 for(WebElement col : tinGridRowHeader)
			   {
				  actualHeadersList.add(col.getText().toString().toLowerCase());
			   }
		 actualHeadersList.remove(0);
		 Helper.compareEquals(testConfig, "Grid Headers Comparison",expectedHeaderList, actualHeadersList);
		 
		 /**
		  * Verify on page load Tins are 
		  * sorted in Ascending order of Tin Values
		  */
		 Map<String,String> map=getTinsListFromUI();
		 
		 /**
		  * Tree map sorts the fetched tins
		  * from UI in ascending order
		  */
		 Map<String, String> treeMap = new TreeMap<String, String>(map);	
		 
		 /**
		  * Verifies tins displayed on UI
		  * are displayed in ascending tin number 
		  */
		 verifytinsAreSorted(treeMap,map);
		 
		 /*Getting tin clicked twice due to an existing bug
		  * Click on Tin link to check for descending order of tins
		  */
		 
		 Element.click(lnkTinInGrid, "Tin link");
		 Browser.wait(testConfig, 3);
		 Log.Comment("After one click " +'\n'+map);
		 Element.click(lnkTinInGrid, "Tin link");
		 Browser.wait(testConfig, 3);
		 map.clear();
		 map=getTinsListFromUI();
		 Log.Comment("After second click " +'\n'+map);
		 
		 treeMap = new TreeMap<String, String>(map).descendingMap();
		 verifytinsAreSorted(treeMap,map);
}
		
	/*
	 * Gets the tins from the tin grid
	 * in the order they are displayed on UI
	 */
	public Map<String,String> getTinsListFromUI()
	{
		   List<WebElement> tinGridRows =Element.findElements(testConfig, "xpath", "//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr");
				  
		   ArrayList<String> tinList= new ArrayList<String>();
		   Map<String,String> map = new LinkedHashMap<String,String>();
		   for(int i=1;i<tinGridRows.size();i++)
		{
			for(int j=0;j<2;j++)
			{
				String tinNo=tinGridRows.get(i).findElements(By.tagName("td")).get(j).getText();
				tinList.add(tinNo);
			}
			
			map.put(tinList.get(0), tinList.get(1));
			tinList.clear();
		}
		   
		   return map;
	}
	
	/**
	 * Verifying tins are appearing in sorted order
	 * here, tree map contains the sorted tin number with provider value 
	 * and map contains the order in which tins
	 * and provider number are appearing on UI
	 */
	public void verifytinsAreSorted(Map<String, String> treeMap, Map<String,String> map)
	{
    if(!treeMap.toString().equals(map.toString()))
    {
    	Log.Fail("Sorted order for Tin", treeMap.toString(), map.toString());
    }
    else
    	Log.Pass("Sorted order for Tin", treeMap.toString(), map.toString());	
	}

	
	public void verifyManageUserUI()
    {
		Log.Comment("Verifying Resources Link");
    	Element.verifyElementPresent(btnAddUser,"Add user");
    	Element.verifyElementPresent(btnSave,"Save");
    	Element.verifyElementPresent(btnCancel,"Cancel");
    	Element.verifyElementPresent(lnkNotYou,"Not you");
    	Element.click(lnkNotYou, "Not You");
    	Browser.waitForLoad(testConfig.driver);
    	Browser.wait(testConfig,5);
    	Browser.verifyURL(testConfig, "optumbank.com");
    	
    }
	
	public void removeFistTinInGrid()
	{
		Element.click(chkRemoveTin, "Remove tin checkbox");
		if(tinGridRows.size()>2)
		Log.Fail("Tin not removed");
		else
		Log.Pass("Tin removed");
	}

	
	public ManageUsers verifyUserDetailsAreReadOnly(String userType) throws InterruptedException
	{
		String expectedValue="true";
		try
		{
		Helper.compareEquals(testConfig, "First Name is Read only", expectedValue, firstName.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "Last Name is Read only", expectedValue, lastName.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "Middle Name is Read only", expectedValue, middleName.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "Ph number field 1 is Read only", expectedValue, phoneNum.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "Ph number field 2 is Read only", expectedValue, phoneNum1.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "Ph number field 3 is Read only", expectedValue, phoneNum2.getAttribute("readonly"));
		if(extension.isDisplayed())
			try{
		Helper.compareEquals(testConfig, "Ext is Read only", expectedValue, extension.getAttribute("readonly"));
			}
		catch (Exception e) {
			Log.Comment("Extension is empty");
		}
		Helper.compareEquals(testConfig, "Email field is Read only", expectedValue, email.getAttribute("readonly"));
		}
		
		catch(Exception e)
		{
			Log.Fail("Failed due to an exception : " + e);
		}
		
		if(userType.equalsIgnoreCase("PAY"))
		{
			Helper.compareEquals(testConfig, "Limit User's Access to Sub Payer's Data Only - Yes button", expectedValue, btnYesSubPayerDataOnly.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Limit User's Access to Sub Payer's Data Only - No button", expectedValue, btnNoSubPayerDataOnly.getAttribute("disabled"));
			accessLvls =Element.findElements(testConfig, "xpath","//select[not(contains(@id,'accessLevel'))]/parent::td//select");
			for(WebElement accessLevel:accessLvls )
				Helper.compareEquals(testConfig, "Access Level is Disabled ", expectedValue, accessLevel.getAttribute("disabled"));
			for(WebElement fundingEmail:chkBoxFundingEmail )
				Helper.compareEquals(testConfig, "Funding Email Checkbox is Disabled ", expectedValue, fundingEmail.getAttribute("disabled"));
			for(WebElement nonEnrolledEmail:chkBoxNonEnrolledEmailNotify )
				Helper.compareEquals(testConfig, "NonEnrolled Email Notify Checkbox is Disabled ", expectedValue, nonEnrolledEmail.getAttribute("disabled"));
			for(WebElement inactiveEmail:chkInActiveEmailNotify )
				Helper.compareEquals(testConfig, "InActive Email Notify Checkbox is Disabled ", expectedValue, inactiveEmail.getAttribute("disabled"));
		}
		return this;
	}
	
	public ManageUsers verifyUserStatus(String userType,String expectedStatus)
	{
		if(userType.equalsIgnoreCase("PAY"))
			Helper.compareContains(testConfig, "Status of User", expectedStatus, txtStatus.getText());
		return this;
	}
	
	public void verifyPayerUserDetailsAreReadOnly() throws InterruptedException
	{
		String expectedValue="true";
		String getDisabledAttribute="readonly";
		
		try
		{
		Helper.compareEquals(testConfig, "First Name is Read only", expectedValue, firstName.getAttribute(getDisabledAttribute));
		Helper.compareEquals(testConfig, "Last Name is Read only", expectedValue, lastName.getAttribute(getDisabledAttribute));
		Helper.compareEquals(testConfig, "Middle Name is Read only", expectedValue, middleName.getAttribute(getDisabledAttribute));
		Helper.compareEquals(testConfig, "Ph number field 1 is Read only", expectedValue, phoneNum.getAttribute(getDisabledAttribute));
		Helper.compareEquals(testConfig, "Ph number field 2 is Read only", expectedValue, phoneNum1.getAttribute(getDisabledAttribute));
		Helper.compareEquals(testConfig, "Ph number field 3 is Read only", expectedValue, phoneNum2.getAttribute(getDisabledAttribute));
		Helper.compareEquals(testConfig, "Ext is Read only", expectedValue, extension.getAttribute(getDisabledAttribute));
		Helper.compareEquals(testConfig, "Email field is Read only", expectedValue, email.getAttribute(getDisabledAttribute));
		}
		catch(Exception e)
		{
			Log.Fail("Exception occured : "+ e);
		}
		
	}
	
	public void verifySuccessfulEmailNotificationChange(String userType)
	{
		//Getting number of tin rows including header row
		List<WebElement> tinGridRows = testConfig.driver.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
		

        //Get the tin number for which Email Notification is to be changed, we are taking first row here
		Log.Comment("Tin number for whom email notification is to be changed is :" + " "+ tinGridRows.get(1).findElements(By.tagName("td")).get(0).getText().toString());
		
		//Getting email checkbox element
		emailChkbox=findEmailCheckbox(userType);
		
		
		Log.Comment("Checking if email checkbox is checked or not...","Maroon");
		
		//If email check box is already checked, Unchecking it and saving and then verifying it is unchecked now
		
		if(!(emailChkbox.getAttribute("checked")==null))
		{
			Log.Comment("Email checkbox is already checked, so unschecking it to verify email notification is updated successfully","Maroon");
			emailChkbox.click();
			clickSave();
			Log.Comment("Unchecked email checkbox successfully","Green");

			emailChkbox=findEmailCheckbox(userType);
			
			Helper.compareEquals(testConfig, "Email check box is in Unchecked state now and saved successfully", null, emailChkbox.getAttribute("checked"));
		}
		
		//If email check box is not checked, Checking it and saving and then verifying it is Checked now
		else
		{
			Log.Comment("Email checkbox is  Unchecked, so checking it","Maroon");
			Element.expectedWait(emailChkbox, testConfig,"email checkbox", "email checkbox");
			Element.click(emailChkbox, "email checkbox");
			clickSave();
			Log.Comment("Checked email checbox successfully","Green");
			emailChkbox=findEmailCheckbox(userType);
			Helper.compareEquals(testConfig, "Email check box is in Checked state now and saved successfully ", "true", emailChkbox.getAttribute("checked"));
		}
	}
	
	public WebElement findEmailCheckbox(String userType)
	{
	
		if(userType.equals("PROV"))
		{
		   //getting email notification check box for provider of first row
		   emailChkbox=tinGridRows.get(1).findElements(By.tagName("td")).get(5).findElement(By.tagName("input"));
		}
		else if(userType.equals("BS"))
		{ 
			//getting email notification checkbox for Billing user of first row
			emailChkbox=tinGridRows.get(1).findElements(By.tagName("td")).get(4).findElement(By.tagName("input"));
		}
		
		return emailChkbox;
	
	}

	
	public void verifySuccessfulAssociateProvChange()
	{
		if(!(rdoYes.getAttribute("checked")==null))
		{
			Log.Comment("'Yes' is initially selected for Associate Billing Service Users to all Providers, hence clicking 'No' to verify successfull change");
			Element.click(rdoNo, "Click Radio button 'No' for Associate Billing Service Users to all Providers");
			clickSave();
			Helper.compareEquals(testConfig, "Radio button 'No' is selected and saved successfuly", "true", rdoNo.getAttribute("checked").toString());
		}
		
		else
		{
			Log.Comment("'No' is initially selected for Associate Billing Service Users to all Providers, hence clicking 'Yes' to verify successfull change");
			Element.click(rdoYes, "Click Radio button 'Yes' for Associate Billing Service Users to all Providers");
			clickSave();
			Helper.compareEquals(testConfig, "Radio button 'Yes' is selected and saved successfuly", "true", rdoYes.getAttribute("checked").toString());
		}
		
		Element.click(rdoYes, "Click Radio button 'Yes' for Associate Billing Service Users to all Providers");
		clickSave();
	}
	
	
	public void verifyBSaccessLvlChange()
	{
		
        testConfig.putRunTimeProperty("tinNo", tinGridRows.get(1).findElements(By.tagName("td")).get(0).getText().toString());
	   
        //Get the tin number for which Email Notification is to be changed, we are taking first row here
	
		Log.Comment("Tin number for whom access level is to be changed is :" + " "+  testConfig.getRunTimeProperty("tinNo"));
		
		Element.selectByVisibleText(accessLvls.get(0), "General", "Select General in BS access Level dropdown");
		clickSave();
		
		//Get access level value from DB to verify it has been changed to General
	    int sqlRowNo=12;
		Map portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	    
		//Verifies UI and DB both are changed to General
	    Helper.compareEquals(testConfig, "Access Level", "G", portalUserData.get("USER_LVL_ACCESS").toString());
	    
	    
	    //Changing user to Admin 
	    accessLvls=testConfig.driver.findElements(By.xpath("//select[not(contains(@id,'accessLevel'))]/parent::td//select"));
	    
	    //Select Access Level as Administrator
	    Element.selectByVisibleText(accessLvls.get(0), "Administrator", "Admin as access level");
	    clickSave();
	    
	    //Get access level value from DB to verify it has been changed to Administrator
	    portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
	    Helper.compareEquals(testConfig, "Access Level", "A", portalUserData.get("USER_LVL_ACCESS").toString());
		
	}
	
	
	public void verifyAccessLvlChange(String userType)
	{
		int sqlRowNo=0;
		Map portalUserData=null;	
		testConfig.putRunTimeProperty("email", email.getAttribute("value"));
		
		if(userType.equalsIgnoreCase("Billing Service"))
		{
			sqlRowNo=12;
			
			testConfig.putRunTimeProperty("tinNo", tinGridRows.get(1).findElements(By.tagName("td")).get(0).getText().toString());
			Log.Comment("Tin number for whom access level is to be changed is :" + " "+  testConfig.getRunTimeProperty("tinNo"));
			selectAccessLvl("General");
			portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			//Verifies UI and DB both are changed to General
			Helper.compareEquals(testConfig, "Access Level", "G", portalUserData.get("USER_LVL_ACCESS").toString());
		    
		   
			selectAccessLvl("Administrator");
		    //Get access level value from DB to verify it has been changed to Administrator
		    portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		    Helper.compareEquals(testConfig, "Access Level", "A", portalUserData.get("USER_LVL_ACCESS").toString());
		    
		}
		
		else if (userType.equalsIgnoreCase("Payer"))
		{
			sqlRowNo=14;
			testConfig.putRunTimeProperty("tinNo", tinGridRows.get(2).findElements(By.tagName("td")).get(0).getText().toString());
			Log.Comment("Tin number for whom access level is to be changed is :" + " "+  testConfig.getRunTimeProperty("tinNo"));
			selectAccessLvl("General");
			portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			//Verifies UI and DB both are changed to General
			Helper.compareEquals(testConfig, "Access Level", "G", portalUserData.get("ACCESS_LVL").toString());
			    
			   
			selectAccessLvl("Administrator");
			//Get access level value from DB to verify it has been changed to Administrator
			portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Helper.compareEquals(testConfig, "Access Level", "A", portalUserData.get("ACCESS_LVL").toString());
		}
	    		
	}
	
	
	public ManageUsers selectAccessLvl(String accessLevel)
	{
		Element.selectByVisibleText(accessLvls.get(0), accessLevel, "Select General in BS access Level dropdown");
		clickSave();
		return this;
	}
	
	
	/**
	 * Select access level for a particular tin
	 * @param accessLevel
	 * @param tin
	 * @return manage user page
	 */
	public ManageUsers selectAccessLvl(String accessLevel,String tin)
	{
	   List<WebElement> tinGridRows = Element.findElements(testConfig, "xpath", "//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr");
	   
	   for(int i=0;i<tinGridRows.size();i++)
	   {
	      String tinNo=tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
		  if(tinNo.equals(tin))    
		  {
		    Element.selectByVisibleText(tinGridRows.get(i).findElements(By.tagName("td")).get(2).findElement(By.tagName("select")), accessLevel, "Select" +accessLevel + "from access Level dropdown");
		    break;
		  }
	   }
	
	 return this;
	}
	
	/**
	 * Removes a particular tin row from the grid
	 * @param tin- tin row to be removed
	 * @return
	 */
	public ManageUsers removeTinNpi(String tin)
	{
		List<WebElement> tinGridRows = Element.findElements(testConfig, "xpath", "//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr");
		   
		   for(int i=0;i<tinGridRows.size();i++)
		   {
		      String tinNo=tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
			  if(tinNo.equals(tin))     
			  {
			  Element.clickByJS(testConfig,tinGridRows.get(i).findElements(By.tagName("td")).get(6).findElement(By.tagName("input")), "Remove tin/npi checkbox for tin number :" + tin);
			  break;
			  }
		   }
		   
	 return this;
	}
	
	
	public String getCSRUserName()
	{
		String [] getUserName= csrUserName.getText().split(":");
		return getUserName[1].toString().trim();
	}
	
	
	public ManageUsers approveNewUserFromCSR(String userType) throws InterruptedException
	{
		csrPage=new LoginCSR();
		if(userType.equalsIgnoreCase("PAY"))
		testConfig.putRunTimeProperty("tin",tinGridRows.get(2).findElements(By.tagName("td")).get(0).getText().toString());
		csrPage.getUserApproved(testConfig,getCSRUserName(),testConfig.getRunTimeProperty("tin"), testConfig.getRunTimeProperty("email"));
		Browser.wait(testConfig, 2);
		((JavascriptExecutor) testConfig.driver).executeScript("window.focus();");
		Browser.wait(testConfig, 2);
		return this;
	}
	
	
	public ManageUsers updateDemoInfo(String userType)
	{
		clickSpecificUserName(getFirstLastName());
		String userNameBeforeUpdation=getCSRUserName();
		fillNewUserInfo();
		Element.expectedWait(btnSave, testConfig, "Save button", "Save button");
		clickSave();
		verifyDetailsOfNewUser(userType);
		Helper.compareEquals(testConfig, "Username is same before and after updation", userNameBeforeUpdation,getCSRUserName());
		return this;
	}
	
	public ManageUsers doResetPassword()
	{
		clickSpecificUserName(getFirstLastName());
		String expectedText="The password for "+ getCSRUserName() +" " +"has successfully been reset, and an email has been sent to the user.";
		Element.clickByJS(testConfig,btnResetPwd, " Reset Password button");
		Element.waitTillTextAppears(txtResetPwd, expectedText, testConfig);
		
		return this;
	}
	
	public String getFirstLastName()
	{
		int sqlRowNo=13;
		Map portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		return portalUserData.get("FST_NM").toString().toUpperCase() + "," +" " + portalUserData.get("LST_NM").toString().toUpperCase();
		
	}
	
	/**
	 * Verifies if access level, email checkbox and tin/npi 
	 * are either enabled or disabled
	 * @param expectedTinNo and value of disable attribute
	 * which can be either true or false
	 * true- item is disabled
	 * false- it is enabled
	 * @return
	 */
	public ManageUsers verifyDisabledItemsForTin(String expectedTinNo ,String expectedValue )
	{
	    List<WebElement> tinGridRows = Element.findElements(testConfig, "xpath", "//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr");
	    for(int i=0;i<tinGridRows.size();i++)
		 {
		    String tinNo=tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
			if(tinNo.equals(expectedTinNo))
			 {    
			   Map attMap=Element.getAllAttributes(testConfig, tinGridRows.get(i).findElements(By.tagName("td")).get(2).findElement(By.tagName("select")), "Access Level Attributes");
			  
			   if(attMap.get("disabled").equals(expectedValue))
				   Log.Pass("Access Level Disabled Attribute Value", expectedValue, attMap.get("disabled").toString());
			   else
				   Log.Fail("Access Level Disabled Attribute Value", expectedValue, attMap.get("disabled").toString());
			   
			   attMap=Element.getAllAttributes(testConfig, tinGridRows.get(i).findElements(By.tagName("td")).get(5).findElement(By.tagName("input")), "Email Checkbox");
			   
			   if(attMap.get("disabled").equals(expectedValue))
				   Log.Pass("Email Checkbox Disabled Attribute Value", expectedValue, attMap.get("disabled").toString());
			   else
				   Log.Fail("Email Checkbox Disabled Attribute Value", expectedValue, attMap.get("disabled").toString());
			   
			   attMap=Element.getAllAttributes(testConfig, tinGridRows.get(i).findElements(By.tagName("td")).get(6).findElement(By.tagName("input")), "Tin/Npi Checkbox");
			   
			   if(attMap.get("disabled").equals(expectedValue))
				   Log.Pass("Remove Tin/Npi Disabled Attribute Value", expectedValue, attMap.get("disabled").toString());
			   else
				   Log.Fail("Remove Tin/Npi Disabled Attribute Value", expectedValue, attMap.get("disabled").toString());
			   
			 }	

		 }
	     return this;
	}
	
	
	public ManageUsers editEmailWithExistingAdress()
	{
		int sqlRowNo=6;
		Map enrolledProviderTable = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		
		String newEmail=enrolledProviderTable.get("EMAIL_ADR_TXT").toString().toLowerCase().trim();
		Log.Comment("Current Email is : " +email.getText());
		Element.enterData(email,newEmail, "Enter new email address as : " + newEmail, "email address");
		Element.enterData(verifyEmail,newEmail, "Re Verify new  email address as : " + newEmail, "email address");
		clickSave();
		return this;
	}
	
	public ManageUsers editFirstName(String newName)
	{
		Element.enterData(firstName,newName,"Enter new first name as : " + newName,"first name");
		clickSave();
		return this;
	}
	
	public ManageUsers editLastName(String newName)
	{
		Element.enterData(lastName,newName,"Enter new first name as : " + newName,"first name");
		clickSave();
		return this;
	}
	
	public ManageUsers verifyPurgedUserOptionState(String expectedState)
	{
		if(expectedState.equalsIgnoreCase("enabled"))
		{
			Map listOfAttributes=Element.getAllAttributes(testConfig, chkBoxPurgedUser, "Purged User option");
			if(!listOfAttributes.containsKey("disabled"))
				Log.Pass("Purged user option is in Enable State");
			else
				Log.Fail("Purged user option is in " + chkBoxPurgedUser.getAttribute("value") + " State" );
		}
		else
	   Helper.compareEquals(testConfig, "Purged Option Disabled Attribute Value", expectedState, chkBoxPurgedUser.getAttribute("disabled").toLowerCase().trim());
	   return this;
	}

	public ManageUsers selectPurgedCheckbox() throws IOException, InterruptedException {
		Map listOfAttributes=Element.getAllAttributes(testConfig, chkBoxPurgedUser, "Purged User Checkbox");
		if(!listOfAttributes.containsKey("checked"))
		{
			Log.Comment("Puged user checbox is not checked, checking it now");
			Element.click(chkBoxPurgedUser, "Purged User checkbox");
		}
			
		return this;
		
	}
	
	public ManageUsers deSelectPurgedCheckbox() throws IOException, InterruptedException {
		Map listOfAttributes=Element.getAllAttributes(testConfig, chkBoxPurgedUser, "Purged User Checkbox");
		if(listOfAttributes.containsKey("checked"))
		{
			Log.Comment("Puged user chekcbox is already checked, unchecking it now");
			Element.click(chkBoxPurgedUser, "Purged User checkbox");
			Browser.waitForLoad(testConfig.driver);
		}
			
		return this;
		
	}
	
	
	public void verifyUserList(String userType,String searchCriteria) throws IOException, InterruptedException
	{
		int sql=252;
		ArrayList<String> usersFromDB=new ArrayList<>();
		try {
		if(System.getProperty("App").equalsIgnoreCase("CSR"))
		selectPurgedCheckbox();
		}
		catch (Exception e) {
			Log.Comment("App is UPA");
		}
		if(searchCriteria.equalsIgnoreCase("purgedUsers")&&userType.contains("PAY"))
		{
			HashMap<Integer,HashMap<String, String>> userDetails=DataBase.executeSelectQueryALL(testConfig, sql);
			Helper.compareEquals(testConfig, "Total No of users (incuding Purged) from DB and UI",userDetails.size(), getListOfAllUsersFromUI(testConfig).size());
			for(int i=1;i<=userDetails.size();i++)
			{
				if(userDetails.get(i).get("STS_CD").equalsIgnoreCase("PU"))
					usersFromDB.add((userDetails.get(i).get("LST_NM")+", "+ userDetails.get(i).get("FST_NM")+" "+userDetails.get(i).get("MIDDLE_INIT")).toUpperCase().trim() +"   - PURGED");
				else
					usersFromDB.add((userDetails.get(i).get("LST_NM")+", "+ userDetails.get(i).get("FST_NM")+" "+userDetails.get(i).get("MIDDLE_INIT")).toUpperCase().trim());
			}
			Helper.compareEquals(testConfig, "User name in DB and UI (incuding Purged)", usersFromDB,getListOfAllUsersFromUI(testConfig));
			
			sql=253;
			try {
				if(System.getProperty("App").equalsIgnoreCase("CSR"))
				selectPurgedCheckbox();
				}
				catch (Exception e) {
					Log.Comment("App is UPA");
				}
			deSelectPurgedCheckbox();
			usersFromDB.clear();
			userDetails=DataBase.executeSelectQueryALL(testConfig, sql);
			Helper.compareEquals(testConfig, "Total No of users (EXCLUDING Purged) from DB and UI",userDetails.size(), getListOfAllUsersFromUI(testConfig).size());
			for(int i=1;i<=userDetails.size();i++)
			  usersFromDB.add((userDetails.get(i).get("LST_NM")+", "+ userDetails.get(i).get("FST_NM")+" "+userDetails.get(i).get("MIDDLE_INIT")).toUpperCase().trim());
			Helper.compareEquals(testConfig, "User name in DB and UI (EXCLUDING Purged)", usersFromDB,getListOfAllUsersFromUI(testConfig));
			
		}
			
	}

	
	/*
	 * This function fetches the name of a purged user
	 * which is associated with the logged in tin 
	 * i.e. the tin that you selected on Home Page 
	 */
	public String getPurgedUser(String userType)
	{
        int sqlRowNo=10;
        String purgedUser;
        
        if(userType.equalsIgnoreCase("PROV"))
        	sqlRowNo=10;
        else if(userType.equalsIgnoreCase("BS"))
        	sqlRowNo=18;
        else if(userType.contains("PAY"))
        	sqlRowNo=254;
        
        
		Map purgedUserDetails = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		testConfig.putRunTimeProperty("user", purgedUserDetails.get("USERNAME").toString());
		purgedUser=purgedUserDetails.get("LST_NM").toString().toUpperCase()+","+ " " +purgedUserDetails.get("FST_NM").toString().toUpperCase();
		Log.Comment("Purged user returned is :" +" " + purgedUser);
		return purgedUser;
	}
	
	/**
	 * FOR CSR
	 * @param userType
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void verifyDetailsForPurgedUser(String userType) throws InterruptedException, IOException {
		String expectedStatus="Purged";
		
		if(System.getProperty("App").equalsIgnoreCase("CSR"))
			selectPurgedCheckbox();
	   clickSpecificUserName(getPurgedUser(userType)).verifyUserDetailsAreReadOnly(userType).verifyUserStatus(userType, expectedStatus);
	}
	
	
	/**
	 * FOR UPA
	 * @param userType
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
//	public void verifyDetailsForPurgedUser(String userType) throws InterruptedException, IOException {
//		String expectedStatus="Purged";
//		clickSpecificUserName(getPurgedUser(userType)).verifyUserDetailsAreReadOnly(userType).verifyUserStatus(userType, expectedStatus);
//	}
}

