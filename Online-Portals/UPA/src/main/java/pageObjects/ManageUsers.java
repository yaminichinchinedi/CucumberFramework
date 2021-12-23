package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.queries.QUERY;
import main.java.reporting.Log;

public class ManageUsers extends AddUserDetails
{

	@FindBy(linkText="User List")
	WebElement lnkUserList;

	@FindBy(id="allProvAssocyes")
	WebElement rdoYes;

	@FindBy(xpath="//span[contains(text(),'User Name')]")
	WebElement csrUserName;

	@FindBy(id="allProvAssocno")
	WebElement rdoNo;

	WebElement emailChkbox=null;
	WebElement dltChkbox;

	@FindBy(xpath="//input[@value='Add User']")
	WebElement btnAddUser;

	@FindBy(xpath="//input[@value='Unlink Optum ID']")
	WebElement btnUnlinkOptumId;

	@FindBy(xpath="//span[@class='noTooltipIcon wrapperTooltip']")
	WebElement btnAddUserdisabled;

	@FindBy(xpath="//input[@class='px-3 m-1 btn-secondary' and @value = ' + Add User'] ")
	WebElement btnAddUserUPA;

	@FindBy(xpath="//button[@class='px-3 m-1 btn-secondary']")
	WebElement addUserBtn;

	@FindBy(xpath="//input[@value='+ Add User']")
	WebElement btnAddUserPAY;

	@FindBy(xpath="//input[@value='Resend Registration Email']")
	WebElement btnRsndRegEmail;

	@FindBy(name="fname")
	WebElement fname;

	@FindBy(name="lname")
	WebElement lname;

	@FindBy(name="phoneNum")
	WebElement phoneNum;

	@FindBy(name="phoneNum1")
	WebElement phoneNum1;

	@FindBy(name="phoneNum2")
	WebElement phoneNum2;

	@FindBy(name="email")
	WebElement email;

	@FindBy(name="verifyEmail")
	WebElement verifyEmail;

	@FindBy(id="addTincsr")
	WebElement txtboxTin;

	@FindBy(xpath="//input[@value='Search']")
	WebElement btnSearch;

	@FindBy(xpath="//input[@value='Add TIN/NPI']")
	WebElement btnAddTINNPI;

	@FindBy(name="GridListResults[0].removeTinNpi")
	WebElement chkRemoveTin;

	@FindBy(xpath="//input[contains(@value,'Save')]")
	WebElement btnSave;

	@FindBy(xpath="//input[@value='Delete User']")
	WebElement btnDelete;

	@FindBy(xpath="//input[@value='Delete Fraud User']")
	WebElement btnDltFraudUser;

	@FindBy(id="viewfrauduser")
	WebElement chkboxFraudUser;

	@FindBy(id="viewpurgeduser")
	WebElement chkboxPurgedUser;

	@FindBy(id="notu")
	WebElement lnkNotYou;

	@FindBy(css="input[value='Cancel']")
	WebElement btnCancel;

	@FindBy(xpath="//th[text()='Provider Name']//ancestor::table[2]")
	WebElement userDetailsTableForProviderOrBS;

	@FindBy(xpath="//th[text()='Sub Payer Name ']//ancestor::table[2]")
	WebElement userDetailsTableForPayer;

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

	@FindBy(id="viewpurgeduser") 
	WebElement chkBoxProvPurge;

	@FindBy(name="purgedUser")
	WebElement chkBoxPurgedUser;

	@FindBy(name="fetchPurgedUser")
	WebElement chkBoxPurgedUserBS;

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

	@FindBy(xpath="//input[@id='viewpurgeduser']")
	WebElement viewPurge;

	@FindBy(xpath="//input[@value='Reset Password']") 
	WebElement resetPwdBtn;

	@FindBy(xpath="//span[contains(text(),'Terms and Conditions Acceptance:')]")
	WebElement termsAndCond;

	@FindBy(xpath="//span[contains(text(),'Terms and Conditions Acceptance Date:')]")
	WebElement termsAndCondDate;

	@FindBy(xpath = "//td[contains(text(),'Your user changes were updated successfully')]")
	WebElement yourChangesWereUpdatedSuccessfully;

	@FindBy(id="provTinAssociateId")
	WebElement provTinAssociate;

	@FindBy(name="genEmailNotification")
	List<WebElement> chkBoxgenEmailNotification;

	@FindBy(id="provTinAssociateId")
	WebElement txtAddProviderAssociation;

	@FindBy(xpath="//*[@id=\"bsForm\"]/div[2]/table[1]/tbody/tr[6]/td/table/tbody/tr[3]/td[2]/table/tbody/tr[4]/td/table[3]/tbody/tr/td[3]/div/input[2]")
	WebElement btnAddProviderAssociation;

	@FindBy(xpath="//th[contains(text(),'Delete User')]")
	WebElement txtDeleteUser ;

	@FindBy(xpath="//input[@name='GridListResults[0].removeTinNpi']")
	WebElement chkDeleteUser;

	@FindBy(xpath="//a[contains(text(),'Ganti, Sunanda')]")
	WebElement lnkreqUser;

	@FindBy(linkText="Manage Users")
	WebElement lnkManageUsers;

	@FindBy(id="tabManageusers")
	WebElement manageUsersTab;

	@FindBy(name="addNpi")
	WebElement drpDwnSelectNpi;

	@FindBy(xpath="//input[@name='GridListResults[0].emailNotify']") 
	WebElement chckEmail;

	@FindBy(xpath="//input[@name='GridListResults[0].genEmailNotification']") 
	WebElement chckBsEmail;

	@FindBy(xpath="//select[@name='GridListResults[0].accessLevel']") 
	WebElement provPayUserAccessLvl ;

	@FindBy(xpath="//select[@name='bsUserAccessLvl']") 
	WebElement bsUserAccessLvl ;

	@FindBy(xpath="//input[@name='GridListResults[0].fundingEmailNotify']") 
	WebElement chckPayEmail1 ;

	@FindBy(xpath="//input[@name='GridListResults[0].nonEnrolledEmailNotify']") 
	WebElement chckPayEmail2 ;

	@FindBy(xpath="//input[@name='GridListResults[0].inActiveEmailNotify']") 
	WebElement chckPayEmail3 ;

	@FindBy(xpath="//input[@name='email']") 
	WebElement txtUserEmail ;

	@FindBy(xpath="//input[@name='Yes']") 
	WebElement btnDeleteuserYes ;

	@FindBy(xpath="//input[@type='checkbox' and @value='on']") 
	WebElement emailcheckboxUI ;

	@FindBy(xpath="//div[@class='manageUsers__userListTable_rows']/table/tbody/tr[1]/td") 
	WebElement usernameUI;

	@FindBy(xpath="//a[contains(text(), 'User List')]//ancestor::table[1]//tr") 
	List<WebElement> userList;

	@FindBy(xpath="//input[@value=' Save ']") 
	WebElement savebtn;

	@FindBy(xpath="//input[@class='px-3 m-1 btn-secondary' and @value = '+ Add User']")
	WebElement btnAddUserpayer;

	@FindBy(xpath="//div[@id=\"manage-users-tabs\"]/div[1]/h2")
	WebElement pageTextHeader;

	@FindBy(xpath="//div[@id=\"manage-users-tabs\"]/div[1]/p")
	WebElement pageText;

	@FindBy(xpath="//div[@id=\"manage-users-tabs\"]/div[3]/h2")
	WebElement footerTitle;

	@FindBy(xpath="//div[@id=\"manage-users-tabs\"]/div[3]/p")
	WebElement footerText;

	@FindBy(linkText="Logout")
	WebElement lnkLogout;

	@FindBy(linkText="Home")
	WebElement lnkHome;

	@FindBy(xpath="//div[@id='confirmRedirectToMFA']/h2")
	WebElement mfaDialogBoxTitle;

	@FindBy(xpath="//div[@id='confirmRedirectToMFA']/p")
	WebElement mfaDialogBoxMessage;

	@FindBy(xpath="(//div[@class='ui-dialog-buttonset']/button)[1]")
	WebElement mfaDialogBoxNoButton;

	@FindBy(xpath="(//div[@class='ui-dialog-buttonset']/button)[2]")
	WebElement mfaDialogBoxYesButton;

	private TestBase testConfig;
	LoginCSR csrPage;

	public ManageUsers(TestBase testConfig)
	{
		super(testConfig);
		if(testConfig.getRunTimeProperty("App").equalsIgnoreCase("CSR"))
		{
			this.testConfig=testConfig;
			PageFactory.initElements(testConfig.driver, this);
			Element.expectedWait(lnkUserList, testConfig, "User List", "User List");
		}
		else if(testConfig.getRunTimeProperty("App").equalsIgnoreCase("UPA"))
		{

			this.testConfig=testConfig;
			PageFactory.initElements(testConfig.driver, this);
			boolean flag = checkMFAflag();
			if (!flag)
				Browser.verifyURL(testConfig, "/viewEnrollment.do");
		}
	}

	public void clickPurgeUsers()
	{
		Element.clickByJS(testConfig, viewPurge, "Purged Users Checkbox");
		Browser.wait(testConfig, 4);
	}

	public void checkPurgedUser(String LoginType)
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

		for (int i=0;i<userNames.size();i++)
		{
			if ( (LoginType.equals("UPA") && userNames.get(i).getText().contains("Purged"))||
					( (LoginType.equals("CSR") && userNames.get(i).getText().equals(testConfig.getRunTimeProperty("PurgedUser"))))
					)
			{
				Element.click(userNames.get(i), "Purged User List");
				Browser.wait(testConfig, 5);
				break;
			}
		}	
	}

	public void validatePurgeUsers(String LoginType,String Credentials) throws InterruptedException
	{
		checkPurgedUser(LoginType);
		if (LoginType.equals("CSR") && !(Credentials.equals("ROOnly")|| Credentials.equals("RO")|| Credentials.equals("RW") ) )
		{	
			Helper.compareEquals(testConfig, "Save Button", "true",  btnSave.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Cancel Button", "true",  btnCancel.getAttribute("disabled"));
		}
		if (LoginType.equals("CSR"))
		{
			if (Credentials.equals("Super")||Credentials.equals("RWOnly"))
			{	
				if (Credentials.equals("Super"))
				{		
					Helper.compareEquals(testConfig, "Delete Button", "true",  btnDelete.getAttribute("disabled"));
					Helper.compareEquals(testConfig, "Resend Email Button", "true",  btnRsndRegEmail.getAttribute("disabled"));
				}
				else
					Helper.compareEquals(testConfig, "Resend Email Button", "true",  btnRsndRegEmail.getAttribute("disabled"));
			}
			Browser.wait(testConfig, 3);
			Helper.compareEquals(testConfig, "First Name", "true",  fname.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Last Name", "true",  lname.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "phoneNum", "true",  phoneNum.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "phoneNum1", "true",  phoneNum1.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "phoneNum2", "true",  phoneNum2.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Email", "true",  email.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Verify Email", "true",  verifyEmail.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Search Button", "true",  btnSearch.getAttribute("disabled"));
		}
		Helper.compareEquals(testConfig, "Add TIN/NPI Button", "true",  btnAddTINNPI.getAttribute("disabled"));
		Helper.compareEquals(testConfig, "First Name", "true",  fname.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "Last Name", "true",  lname.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "phoneNum", "true",  phoneNum.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "phoneNum1", "true",  phoneNum1.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "phoneNum2", "true",  phoneNum2.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "Email", "true",  email.getAttribute("readonly"));
		Helper.compareEquals(testConfig, "Verify Email", "true",  verifyEmail.getAttribute("readonly"));
		List<WebElement> details=Element.findElements(testConfig, "xpath", "//span[@class='subheadernormal']");
		if (LoginType.equals("UPA") )
			Helper.compareContains(testConfig, "Status matching", "Purged", details.get(0).getText());
		if (LoginType.equals("CSR")&& Credentials.equals("Super"))
		{
			Helper.compareContains(testConfig, "Status matching", "Purged", details.get(1).getText()); 
			Helper.compareContains(testConfig, "Job Name", testConfig.getRunTimeProperty("JobName"), details.get(5).getText());
			Helper.compareContains(testConfig, "DateTime", testConfig.getRunTimeProperty("Timestamp"), details.get(6).getText());
		}	
		if (LoginType.equals("CSR")&& (Credentials.equals("ROOnly")||Credentials.equals("RO") ||Credentials.equals("RWOnly")||Credentials.equals("RW") ))
		{
			Helper.compareContains(testConfig, "Status matching", "Purged", details.get(0).getText()); 
			Helper.compareContains(testConfig, "Job Name", testConfig.getRunTimeProperty("JobName"), details.get(4).getText());
			Helper.compareContains(testConfig, "DateTime", testConfig.getRunTimeProperty("Timestamp"), details.get(5).getText());
		}	
		Element.findElement(testConfig, "xpath", "//*[@name='GridListResults[0].accessLevel']").getAttribute("disabled") ;
		Element.findElement(testConfig, "xpath", "//*[@name='GridListResults[0].emailNotify']").getAttribute("disabled") ;
		Element.findElement(testConfig, "xpath", "//*[@name='GridListResults[0].removeTinNpi']").getAttribute("disabled") ;

		if (LoginType.equals("CSR"))
		{
			Element.clickByJS(testConfig,  Element.findElement(testConfig, "id", "logOutId"), "Logout");
			Browser.wait(testConfig, 2);
		}
	}

	public void validateUserEntrybySameTIN(){
		getTinsListFromUI();
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
		return this;
	}

	public CancelManageUser clickCancel()
	{
		Element.clickByJS(testConfig,btnCancel, "Cancel Button");
		return new CancelManageUser(testConfig);
	}

	public AddUserDetails clickAddNewUserUPA()
	{
		//Element.clickByJS(testConfig,btnAddUserUPA, "Add User");
		if(testConfig.driver.findElements(By.xpath("//input[@class='px-3 m-1 btn-secondary' and @value = ' + Add User']")).size() != 0)
			Element.clickByJS(testConfig,btnAddUserUPA, "Add User");
		else
			Element.clickByJS(testConfig,addUserBtn, "Add User");

		return new AddUserDetails(testConfig);
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
	public ArrayList<String> getListOfAllUsersFromUI(TestBase testConfig)
	{  
		List <WebElement> userNamesElementsList=null;
		LinkedHashSet<String> userNamesList = new LinkedHashSet<>();
		try{
			userNamesElementsList=TestBase.driver.findElements(By.xpath("//div[@class='manageUsers__userListTable_rows']/table/tbody/tr"));
		}
		catch(Exception e){
			Log.Comment("Finding user List again");
			userNamesElementsList=testConfig.driver.findElements(By.xpath("//div[@class='manageUsers__userListTable_rows']/table/tbody/tr"));
		}
		try{
			for(WebElement userName:userNamesElementsList)
			{ 
				userNamesList.add(userName.getText().toString().toUpperCase().trim());
			}		
		}
		catch(Exception e)
		{
			Log.Comment("Exception occured : " +  e);
		}
		return new ArrayList<String>(userNamesList);			
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

	public ManageUsers verifyUserInList(String userType) throws InterruptedException
	{
		ArrayList<String> usersListUI=getListOfAllUsersFromUI(testConfig);
		String userName=testConfig.getRunTimeProperty("lName").toUpperCase()
				+", "+testConfig.getRunTimeProperty("fName").toUpperCase()+"   - PURGED";
		if(!usersListUI.contains(userName)) 
		{
			Log.Pass("User with name : " + " " + "'" +userName + "'" + "is not present in User List");
		}
		else if(usersListUI.contains(userName))
		{
			for(WebElement name:userNames)
			{ 
				if(name.getText().toString().contains(userName))
				{
					Element.click(name, "UserName: "+ " " +userName);
					Browser.wait(testConfig, 2);
					break;
				}
			}

			if(email.getAttribute("value").toString().equalsIgnoreCase(testConfig.getRunTimeProperty("purgedEmail")))
				Log.Fail("User with name : " + " " + "'" +userName + "'" + " present");
			else
				Log.Pass("User with name : " + " " + "'" +userName + "'" + "is not present in User List");
		}
		else
			Log.Fail("User with name : " + " " + "'" +userName + "'" + " present");
		return this;
	}

	/*
	 * This function fetches the name of an active user
	 * which is associated with the logged in tin 
	 * i.e. the tin that you selected on Home Page 
	 */
	public String getActiveUser(Map<String, String> tinAndUserDetails) {
		String activeUser = "";

		if (null == tinAndUserDetails)
			Log.Fail("No active user available in Database for " + testConfig.getRunTimeProperty("tin") + '\n'
					+ "Please execute the test case manually");
		else {
			testConfig.putRunTimeProperty("user", tinAndUserDetails.get("USERNAME").toString());
			activeUser = tinAndUserDetails.get("LST_NM").toString().toUpperCase() + "," + " "
					+ tinAndUserDetails.get("FST_NM").toString().toUpperCase();
			Log.Comment("Active user returned is :" + " " + activeUser);
			testConfig.putRunTimeProperty("activeUserID", tinAndUserDetails.get("SSO_ID").toString());
		}
		return activeUser;
	}

	/**
	 * This function clicks the active user 
	 * to view its details on 
	 * Manage user Page
	 */

	public ManageUsers clickActiveUserName(String userType)
	{
		String emailadr = email.getText();
		testConfig.putRunTimeProperty("emailadr", emailadr);
		int sqlRowNo=1923;
		Map Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Searchedtin.get("PROV_TIN_NBR").toString();
		return new ManageUsers(testConfig);
	}

	public ManageUsers validateAddingSameTIN()
	{
		int sqlNo = 416;
		String newAddedTin=selectAndAddTin(sqlNo);
		Log.Comment("Tin number for whom access level is to be changed is :" + " "+ newAddedTin);
		Browser.wait(testConfig, 2);
		String actual=Element.findElement(testConfig, "xpath", "//div[@id='manage-users']//td[contains(text(),'TIN-NPI cannot')]").getText();
		Helper.compareEquals(testConfig, "Error Message comparision", "TIN-NPI cannot be added, already exist in the grid.", actual.trim());
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
		for (WebElement userName : userNames) {
			if (userName.getText().toString().toUpperCase().contains(nameOfUser)
					|| userName.getText().toString().toLowerCase().contains(nameOfUser)
					|| userName.getText().toString().contains(nameOfUser)) {
				Element.clickByJS(testConfig, userName, "UserName: " + " " + nameOfUser);
				break;
			}
		}
		return this;
	}

	/**
	 * This function is used to change Access Level of an Active user which is
	 * fetched from DB
	 */

	public ManageUsers changeAndSaveAccessLevel(String userType) throws InterruptedException {
		// int sqlNo=257;
		int sqlRowNo = 11;
		int sqlNo = 416;

		// Clicks on an active user displayed in User List
		clickActiveUserName(userType);
		String newAddedTin = selectAndAddTin(sqlNo);
		Log.Comment("Tin number for whom access level is to be changed is :" + " " + newAddedTin);
		testConfig.putRunTimeProperty("tinNo", newAddedTin);
		WebElement accessLvlDrpDwn = null;
		List<WebElement> tinGridRows = testConfig.driver
				.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
		for (int i = 1; i < tinGridRows.size(); i++) {
			String tinNo = tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
			if (tinNo.equalsIgnoreCase(newAddedTin)) {
				accessLvlDrpDwn = tinGridRows.get(i).findElement(By.tagName("select"));

				// Select Access Level as General for the new added tin
				Element.selectByVisibleText(accessLvlDrpDwn, "General", "Select General as access level");
				Browser.waitForLoad(testConfig.driver);
				clickSave();
				Browser.waitTillSpecificPageIsLoaded(testConfig, "Manage User");
				Map portalUserData = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
				Helper.compareEquals(testConfig, "Access Level", "G", portalUserData.get("ACCESS_LVL").toString());

				// Handling stale element
				tinGridRows = testConfig.driver.findElements(
						By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
				accessLvlDrpDwn = tinGridRows.get(i).findElement(By.tagName("select"));

				Element.selectByVisibleText(accessLvlDrpDwn, "Administrator", "Admin as access level");
				HomePage home = clickCancel().clickYes();

				Browser.waitForLoad(testConfig.driver);
				Helper.compareEquals(testConfig, "Access Level", "G", portalUserData.get("ACCESS_LVL").toString());

				home.clickManageUsersTab().clickActiveUserName(userType);

				// Handling stale element
				tinGridRows = testConfig.driver.findElements(
						By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
				accessLvlDrpDwn = tinGridRows.get(i).findElement(By.tagName("select"));

				Element.selectByVisibleText(accessLvlDrpDwn, "General", "Select General as access level");
				clickCancel().clickNo();
				Helper.compareEquals(testConfig, "Access Level", "G", portalUserData.get("ACCESS_LVL").toString());
				break;
			}
		}

		return this;
	}

	/**
	 * This function is used to change 
	 * Access Level of an Active user 
	 * which is fetched from DB
	 */
	public ManageUsers changeAndVerifyAccLvlEmailNotify(String userType) throws InterruptedException
	{
		int sqlNo=416;
		clickActiveUserName(userType);
		String newAddedTin=selectAndAddTin(sqlNo);
		Log.Comment("Tin number for whom access level is to be changed is :" + " "+ newAddedTin);
		testConfig.putRunTimeProperty("tinNo",newAddedTin);
		int tinIndex=getTinIndexfromTinGrid(newAddedTin);
		String tin = testConfig.getRunTimeProperty("tinNo");
		WebElement list = testConfig.driver.findElement(By.xpath("//div[@id='manage-users']//table[@class='manageUsers__tinGrid datatables']//td[contains(text(),'"+tin+"')]/following-sibling::td/select[contains(@name,'GridListResults')]"));
		Element.selectByValue(list, "G", "Selecting General From Dropdown");
		tinIndex=getTinIndexfromTinGrid(newAddedTin);
		verifyEmailNotifyAccLvlFromDB(userType, newAddedTin,tinIndex);
		changeEmailNotifyInd(userType, newAddedTin,tinIndex);
		verifyEmailNotifyAccLvlForN(userType, newAddedTin,tinIndex);
		HomePage home=clickCancel().clickYes();
		home.clickManageUsersTab().clickSpecificUserName(testConfig.getRunTimeProperty("activeUser"));

		return this;
	}
	
	public ManageUsers changeEmailNotifyInd(String userType,String newAddedTin, int tinIndex)
	{
		tinGridRows = testConfig.driver.findElements(By.xpath("//div[@class='manageUsers__tinGrid_container_div']/table/tbody/tr"));
		if(userType.contains("PROV"))
		{	 
			String tin = testConfig.getRunTimeProperty("tinNo");
			WebElement emailChkbox = testConfig.driver.findElement(By.xpath("//div[@id='manage-users']//table[@class='manageUsers__tinGrid datatables']//td[contains(text(),'"+tin+"')]/following-sibling::td/input[contains(@type,'checkbox')]"));
			Element.click(emailChkbox, "Email Check box");
		}
		clickSave();
		return this;
	}

	public ManageUsers chooseAccessLvl(String accessLvl,String newAddedTin,int tinIndex)
	{
		int index=0;
		WebElement accessLvlDrpDwn=null;
		Browser.wait(testConfig, 2);
		int i = testConfig.driver.findElements(By.xpath("//select[@id='accessLevel']")).size();
		accessLvlDrpDwn= testConfig.driver.findElement(By.xpath("//select[@name='GridListResults["+i+"].accessLevel']"));
		Element.selectByVisibleText(accessLvlDrpDwn, accessLvl, "Select "+ accessLvl+" as access level");
		Browser.waitForLoad(testConfig.driver);
		return this;
	}
	public void verifyEmailNotifyAccLvlFromDB(String userType,String newAddedTin,int tinIndex)
	{
		String emailChkboxUI = null;
		if(userType.contains("PROV"))
		{
			String tin = testConfig.getRunTimeProperty("tinNo");
			WebElement  emailChkboxUI1 = testConfig.driver.findElement(By.xpath("//div[@id='manage-users']//table[@class='manageUsers__tinGrid datatables']//td[contains(text(),'"+tin+"')]/following-sibling::td/input[contains(@type,'checkbox') and @checked='checked']"));
			boolean emailChkboxUI2 = emailChkboxUI1.isEnabled();
			String emailChkboxes=Boolean.toString(emailChkboxUI2);
			if(emailChkboxUI1.isSelected())
				emailChkboxUI = "Y";
			else
				emailChkboxUI = "N";
			Element.click(savebtn, "Save Button");
			String activeuser = usernameUI.getText();
			String lst_nm = activeuser.substring(0, activeuser.lastIndexOf(','));
			String fst_nm = activeuser.substring(activeuser.lastIndexOf(',')+1,activeuser.length()).trim();

			int sqlRowNo=279;
			testConfig.putRunTimeProperty("lst_nm", lst_nm);
			testConfig.putRunTimeProperty("fst_nm", fst_nm);
			Map portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Helper.compareEquals(testConfig, "Access Level", emailChkboxUI, portalUserData.get("EMAIL_NTFY_IND").toString());

			tin = testConfig.getRunTimeProperty("tinNo");
			String  access_lvl1 = testConfig.driver.findElement(By.xpath("//div[@id='manage-users']//table[@class='manageUsers__tinGrid datatables']//td[contains(text(),'"+tin+"')]/following-sibling::td/select[contains(@name,'GridListResults')]/option[@selected='selected']")).getText();
			String access_lvl = null;
			if(access_lvl1.contains("General"))
				access_lvl = "G";
			else
				Log.Fail("Access Level for that TIN");

			Helper.compareEquals(testConfig, "Access Level", access_lvl, portalUserData.get("ACCESS_LVL").toString().trim());
		}
	}
	
	public int getTinIndexfromTinGrid(String newAddedTin){
		int index=0;
		List<WebElement> tinGridRows = testConfig.driver.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
		for(int i=1;i<tinGridRows.size();i++)
		{
			String tinNo=tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
			if(tinNo.equalsIgnoreCase(newAddedTin))
				index=i;
		}
		return index;
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
		System.out.println("Initial Access level: "+initialAccessLvl);

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

	public ManageUsers removeFistTinInGrid()
	{
		Element.click(chkRemoveTin, "Remove tin checkbox");
		if(tinGridRows.size()>2)
			Log.Fail("Tin not removed");
		else
			Log.Pass("Tin removed");
		return this;
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

		if(userType.contains("PAY"))
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

		if(userType.contains("BS"))
		{
			Helper.compareEquals(testConfig, "Associate Billing Service Users to all Providers - Yes button", expectedValue, rdoYes.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Associate Billing Service Users to all Providers - No button", expectedValue, rdoNo.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Add Provider Association - textbox", expectedValue, txtAddProviderAssociation.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Add TIN Association - button", expectedValue, btnAddProviderAssociation.getAttribute("disabled"));Helper.compareEquals(testConfig, "Save - button", expectedValue, btnSave.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Cancel - button", expectedValue, btnCancel.getAttribute("disabled"));
			Helper.compareEquals(testConfig, "Delete - button", expectedValue, btnDelete.getAttribute("disabled"));
			accessLvls =Element.findElements(testConfig, "xpath","//select[not(contains(@id,'accessLevel'))]/parent::td//select");

			for(WebElement accessLevel:accessLvls )
				Helper.compareEquals(testConfig, "Access Level is Disabled ", expectedValue, accessLevel.getAttribute("disabled"));

			for(WebElement genEmailNotification:chkBoxgenEmailNotification )

				Helper.compareEquals(testConfig, "Funding Email Checkbox is Disabled ", expectedValue, genEmailNotification.getAttribute("disabled"));
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
		Map<String, String> portalUserData = DataBase.executeSelectQuery(testConfig,QUERY.BS_OR_PAY_PORTAL_USER, 1);
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
	public ManageUsers verifyDisabledItemsForTin(String expectedTinNo, String expectedValue) {
		List<WebElement> tinGridRows = Element.findElements(testConfig, "xpath",
				"//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr");
		for (int i = 0; i < tinGridRows.size(); i++) {
			String tinNo = tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
			if (tinNo.equals(expectedTinNo)) {
				Map attMap = Element.getAllAttributes(testConfig,
						tinGridRows.get(i).findElements(By.tagName("td")).get(2).findElement(By.tagName("select")),
						"Access Level Attributes");
				Helper.compareEquals(testConfig, "Access Level Disabled Attribute Value", expectedValue,
						attMap.get("disabled"));

				attMap = Element.getAllAttributes(testConfig,
						tinGridRows.get(i).findElements(By.tagName("td")).get(5).findElement(By.tagName("input")),
						"Email Checkbox");
				Helper.compareEquals(testConfig, "Email Checkbox Disabled Attribute Value", expectedValue,
						attMap.get("disabled"));

				attMap = Element.getAllAttributes(testConfig,
						tinGridRows.get(i).findElements(By.tagName("td")).get(6).findElement(By.tagName("input")),
						"Tin/Npi Checkbox");
				Helper.compareEquals(testConfig, "Remove Tin/Npi Disabled Attribute Value", expectedValue,
						attMap.get("disabled"));
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
		Element.enterDataByJS(testConfig,lastName,newName,"Enter new first name as : " + newName);
		clickSave();
		return this;
	}


	public ManageUsers verifyPurgedUserStatus(String userType) {
		int sqlNo = 258;
		Map data = DataBase.executeSelectQuery(testConfig, sqlNo, 1);
		Helper.compareEquals(testConfig, "No record in Portal user table", data, null);
		switch (userType) {
		case "PROV":
		case "PROV_Admin":
			testConfig.putRunTimeProperty("tbl", "portal_user_tin");
			break;
		case "BS":
		case "BS_Admin":
			testConfig.putRunTimeProperty("tbl", "portal_user_bs_tin");
			break;
		case "PAY":
		case "PAY_Admin":
			testConfig.putRunTimeProperty("tbl", "portal_user_payer_tin");
			break;
		}
		sqlNo = 266;
		data = DataBase.executeSelectQuery(testConfig, sqlNo, 1);
		Helper.compareEquals(testConfig, "No record in Portal user table", data, null);

		sqlNo = 267;
		data = DataBase.executeSelectQuery(testConfig, sqlNo, 1);
		Helper.compareEquals(testConfig, "Status Code of purged user", "PZ", data.get("STS_CD").toString());
		Helper.compareEquals(testConfig, "Status Code of purged user", "", data.get("MOD_TYP_CD").toString());

		sqlNo=268;
		data=DataBase.executeSelectQuery(testConfig, sqlNo, 1);
		Helper.compareEquals(testConfig, "Status Code of purged user", "PU", data.get("STS_CD").toString());
		Helper.compareEquals(testConfig, "Status Code of purged user", "PUP", data.get("MOD_TYP_CD").toString());

		return this;
	}

	public ManageUsers clickPurgedChkBox(String userType)
	{
		if("PAY".equals(userType))
			Element.click(chkBoxPurgedUser, "View Purged Users Check Box");
		else
			Element.click(chkBoxProvPurge, "View Purged Users Check Box");
		return this;
	}

	public ManageUsers getPurgedEmail() {
		clickSpecificUserName("Purged");
		testConfig.putRunTimeProperty("phnNo", phoneNum.getAttribute("value").toString()
				+ phoneNum1.getAttribute("value").toString() + phoneNum2.getAttribute("value").toString());
		testConfig.putRunTimeProperty("emailOfUsr", email.getAttribute("value").toString());
		testConfig.putRunTimeProperty("fName", firstName.getAttribute("value").toString());
		testConfig.putRunTimeProperty("lName", lastName.getAttribute("value").toString());

		//to avoid the conflict of already existing user with same email address
		// purged user email address is updated to a random email address 
		String purgedEmail=userEmailAdr+"##PU##"; 
		testConfig.putRunTimeProperty("purgedEmail", purgedEmail);
		testConfig.putRunTimeProperty("email", userEmailAdr);

		int sqlRowNo=259;
		Map Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		testConfig.putRunTimeProperty("portalUserID", Searchedtin.get("PORTAL_USER_ID").toString().trim());

		sqlRowNo=262;
		DataBase.executeUpdateQuery(testConfig,sqlRowNo );
		Browser.wait(testConfig, 3);
		Browser.browserRefresh(testConfig);
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

	public void purgedUserChecbox(String userTyp) throws IOException, InterruptedException{
		Element.findElements(testConfig, "xpath", "//td[@class='subheadernormal']").get(2).getText();
		Helper.compareEquals(testConfig, "Purge User checkbox", "View Purged Users:", Element.findElements(testConfig, "xpath", "//td[@class='subheadernormal']").get(2).getText().trim());	
		//if(Element.findElements(testConfig, "xpath", "//td[@class='subheadernormal']").get(2).getAttribute("disabled").equals(null))
		if(userTyp.contains("PAY"))
		{
			selectPurgedCheckbox();
			checkPurgedUser("UPA");
			deSelectPurgedCheckbox();
			checkPurgedUser("UPA");
		}
		if(userTyp.contains("PROV"))
		{
			clickPurgedChkBox("PROV");
			checkPurgedUser("UPA");
			Map listOfAttributes=Element.getAllAttributes(testConfig, chkBoxProvPurge, "Purged User Checkbox");
			if(listOfAttributes.containsKey("checked"))
			{
				Log.Comment("Puged user chekcbox is already checked, unchecking it now");
				Element.click(chkBoxProvPurge, "Purged User checkbox");
				Browser.waitForLoad(testConfig.driver);
			}
		}
		if(userTyp.contains("BS"))
		{
			Element.click(chkBoxPurgedUserBS, "View Purged Users Check Box");
			checkPurgedUser("UPA");
			Map listOfAttributesBS=Element.getAllAttributes(testConfig, chkBoxPurgedUserBS, "Purged User Checkbox");
			if(listOfAttributesBS.containsKey("checked"))
			{
				Log.Comment("Puged user chekcbox is already checked, unchecking it now");
				Element.click(chkBoxPurgedUserBS, "Purged User checkbox");
				Browser.waitForLoad(testConfig.driver);
			}
			checkPurgedUser("UPA");
		}
		//else
		{
			Log.Comment("View Purged checkbox not enabled");
		}

	}
	public void verifyUserList(String userType,String searchCriteria) throws IOException, InterruptedException
	{  
		int sql=123; //need to update this..check from other branches
		ArrayList<String> usersFromDB=new ArrayList<>();

		if(searchCriteria.equalsIgnoreCase("purgedUsers")&&userType.contains("PAY"))
		{
			HashMap<Integer,HashMap<String, String>> userDetails=DataBase.executeSelectQueryALL(testConfig, sql);
			Helper.compareEquals(testConfig, "Total No of users (incuding Purged) from DB and UI",userDetails.size(), getListOfAllUsersFromUI(testConfig).size());
			for(int i=1;i<=userDetails.size();i++)
			{
				if(userDetails.get(i).get("STS_CD").equalsIgnoreCase("PU"))
					usersFromDB.add((userDetails.get(i).get("LST_NM")+", "+ userDetails.get(i).get("FST_NM")+" "+userDetails.get(i).get("MIDDLE_INIT")).toUpperCase() +"  - PURGED");
				else
					usersFromDB.add((userDetails.get(i).get("LST_NM")+", "+ userDetails.get(i).get("FST_NM")+" "+userDetails.get(i).get("MIDDLE_INIT")).toUpperCase().trim());
			}
			Helper.compareEquals(testConfig, "User name in DB and UI (incuding Purged)", usersFromDB,getListOfAllUsersFromUI(testConfig));

			sql=253;
			try {
				if(System.getProperty("App").equalsIgnoreCase("CSR"))
				{
					deSelectPurgedCheckbox();
					usersFromDB.clear();
					userDetails=DataBase.executeSelectQueryALL(testConfig, sql);
					Helper.compareEquals(testConfig, "Total No of users (EXCLUDING Purged) from DB and UI",userDetails.size(), getListOfAllUsersFromUI(testConfig).size());
					for(int i=1;i<=userDetails.size();i++)
						usersFromDB.add((userDetails.get(i).get("LST_NM")+", "+ userDetails.get(i).get("FST_NM")+" "+userDetails.get(i).get("MIDDLE_INIT")).toUpperCase().trim());
					Helper.compareEquals(testConfig, "User name in DB and UI (EXCLUDING Purged)", usersFromDB,getListOfAllUsersFromUI(testConfig));
				}
			}
			catch (Exception e) {
				Log.Comment("App is UPA");
			}
		}
		
		if(userType.contains("PROV"))
		{
			ArrayList<String> usersFromUI=new ArrayList<String>();
			int sqlRowNo=1505;
			HashMap<Integer, HashMap<String, String>>  userListFromDB=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
			for(int i=1;i<=userListFromDB.size();i++)
				usersFromDB.add(userListFromDB.get(i).get("FULLNAME").toUpperCase().toString());
			usersFromUI=getListOfAllUsersFromUI(testConfig);
			Helper.compareEquals(testConfig, "User List", usersFromDB, usersFromUI);
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
			//sqlRowNo=256;
			sqlRowNo=18;
		else if(userType.contains("PAY"))
			//sqlRowNo=254;
			sqlRowNo=413;
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
		try {
			if(System.getProperty("App").equalsIgnoreCase("CSR"))
				selectPurgedCheckbox();
		}
		catch (Exception e) {
			Log.Comment("App is UPA");
		}
		clickSpecificUserName(getPurgedUser(userType)).verifyUserDetailsAreReadOnly(userType).verifyUserStatus(userType, expectedStatus);
	}

	public ManageUsers validateTandCFields(){
		String termAndCond=termsAndCond.getText().substring(termsAndCond.getText().indexOf(":")+1, termsAndCond.getText().length()).trim();
		String termAndCondDate=termsAndCondDate.getText().substring(termsAndCondDate.getText().indexOf(":")+1, termsAndCondDate.getText().length());
		int sqlRowNo=258;
		Map portalUserDetails = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		Helper.compareEquals(testConfig, "", portalUserDetails.get("TC_ACCEPT_IND").toString(), termAndCond);
		Helper.compareContains(testConfig, "", portalUserDetails.get("TC_ACCEPT_DTTM").toString(), termAndCondDate);
		return this;
	}

	public void verifyUserDetailsAreReadOnly() throws InterruptedException
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
	}

	public void deleteInsertedUser(){
		if (testConfig.getRunTimeProperty("TobeDeleted")!=null && testConfig.getRunTimeProperty("TobeDeleted").equals("deletedTINProv"))
			DataBase.executeDeleteQuery(testConfig, 25);
	}

	public void deleteInsertedUserportal()
	{
		//int sqlRowNo = 1920;
		int sqlRowNo = 13;
		String email = System.getProperty("email");
		testConfig.putRunTimeProperty("email", email);
		Map portal_id = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		String portal_user_id = portal_id.get("PORTAL_USER_ID").toString();
		sqlRowNo = 1921;
		testConfig.putRunTimeProperty("portal_user_id", portal_user_id);
		DataBase.executeDeleteQuery(testConfig, 1921);
		sqlRowNo = 1922;
		testConfig.putRunTimeProperty("portal_user_id", portal_user_id);
		DataBase.executeDeleteQuery(testConfig, 1922);
	}

	public ManageUsers verifyAddUsrBtnVsblBySystem_Mode(String systemMode,String portalAccess)
	{
		int sqlRowNoupdate=1607;
		DataBase.executeUpdateQuery(testConfig,sqlRowNoupdate );
		int sqlRowNo=1606;
		Map system_Mode = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		if((system_Mode.get("PROC_DATA").toString().equalsIgnoreCase("FEEBASED")|| system_Mode.get("PROC_DATA").toString().equalsIgnoreCase("LEGACY")) &&
				portalAccess.equalsIgnoreCase("Premium")||portalAccess.equalsIgnoreCase("Standard")||portalAccess.equalsIgnoreCase("Legacy"))
			verifyAddUserBtnEnabled(portalAccess);
		if((system_Mode.get("PROC_DATA").toString().equalsIgnoreCase("FEEBASED")|| system_Mode.get("PROC_DATA").toString().equalsIgnoreCase("LEGACY")) &&
				portalAccess.equalsIgnoreCase("BillingService"))
			verifyAddUserBtnEnabled(portalAccess);
		if((system_Mode.get("PROC_DATA").toString().equalsIgnoreCase("FEEBASED") && (( portalAccess.equalsIgnoreCase("Premium")||  portalAccess.equalsIgnoreCase("Legacy")) && (portalAccess.equalsIgnoreCase("Payer")))))
			verifyAddUserBtnEnabled(portalAccess);

		return this;
	} 

	public ManageUsers verifyAddUserBtnEnabled(String portalAccess){
		try{

			if(portalAccess.equalsIgnoreCase("Premium"))
				Helper.compareEquals(testConfig, "Add User Button is enabled", true, btnAddUser.isEnabled());
			else if(portalAccess.equalsIgnoreCase("Standard"))
				Helper.compareEquals(testConfig, "Add User Button is disabled", "true", btnAddUser.getAttribute("disabled").trim());
			else
				Log.Comment("It is Legacy Mode and from Jan 16th it wont be present");
		}catch(Exception e){
			Log.Fail("User button is enabled");
		}
		return this;
	}

	public ManageUsers verifyAddUserBtnDisabled(){
		Helper.compareEquals(testConfig, "Add User button disabled", "true", btnAddUser.getAttribute("disabled"));
		return this;
	}

	public void validateTermsNConditionsforBS() throws InterruptedException
	{
		List <WebElement> userNames=null;
		List <WebElement> userNamesanother=null;
		ArrayList<String> UsersListUI=new ArrayList<String>();
		try{
			userNames=testConfig.driver.findElements(By.xpath("//div[@id='flow']//tbody//a"));
			userNamesanother= userNames;
		}
		catch(Exception e){
			Log.Comment("Finding user List again");
			userNames=testConfig.driver.findElements(By.xpath("//div[@id='flow']//tbody//a"));
		}
		Browser.wait(testConfig, 5);
		for (int i=0;i<=userNames.size();i++)
		{
			//Browser.browserRefresh(testConfig);
			//Element.findElement(testConfig, "id", "tabManageusers").click();
			userNames=testConfig.driver.findElements(By.xpath("//div[@id='flow']//tbody//a"));
			if ( ! userNames.get(i).getText().contains("Purged"))

			{
				testConfig.putRunTimeProperty("LST_NM",userNames.get(i).getText().substring(0, userNames.get(i).getText().indexOf(',')));
				testConfig.putRunTimeProperty("FST_NM",userNames.get(i).getText().substring(userNames.get(i).getText().indexOf(',')+2));
				Element.click(userNames.get(i), "ClickUser List");
				Browser.wait(testConfig, 5);
				List<WebElement> details=Element.findElements(testConfig, "xpath", "//span[@class='subheadernormal']");
				String TnC=details.get(2).getText();
				if ( TnC.contains("Terms and Conditions Acceptance") && TnC.contains(":  Y"))
				{	
					if ( details.get(3).getText().contains("Terms and Conditions Acceptance Date:") &&
							! (details.get(3).getText().substring(38).equals(null)))
					{
						int sqlRowNo=262;
						Map TnCData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
						Helper.compareContains(testConfig, "TnC Indicator", TnCData.get("TC_ACCEPT_IND").toString(), TnC);	
						Helper.compareContains(testConfig, "DateTimeStamp", TnCData.get("TC_ACCEPT_DTTM").toString(), details.get(3).getText().substring(38));	
					}

				}
				if ( TnC.contains("Terms and Conditions Acceptance") && TnC.contains(":  N"))
				{	
					details.get(3).getText().equals("Terms and Conditions Acceptance Date:");
					break;
				}
			}
		}
		//		for (int i=0;i<=userNamesanother.size();i++)
		//		{	
		//		if (  userNamesanother.get(i).getText().contains("Purged"))
		//			 
		//			{
		//				Element.click(userNamesanother.get(i), "Purged User List");
		//				Browser.wait(testConfig, 5);
		//				List<WebElement> details=Element.findElements(testConfig, "xpath", "//span[@class='subheadernormal']");
		//				String TnC=details.get(2).getText();
		//				if ( TnC.contains("Terms and Conditions Acceptance") && TnC.contains(":  N"))
		//				details.get(3).getText().equals("Terms and Conditions Acceptance Date:");
		//				break;
		//			}
		//		
		//		}
	}

	public void verifyResetPwdButtonUPA()
	{
		Element.verifyElementNotPresent(resetPwdBtn, "Reset Password");
	}

	public ManageUsers verifyDeleteUserInTinGrid() {
		Element.findElement(testConfig, "xpath", "//th[contains(text(),'Delete User')]");
		Element.verifyTextPresent(txtDeleteUser, "Delete User");
		if(!txtDeleteUser.getText().toString().equalsIgnoreCase("Remove Row"))
			Log.Pass("Remove Row is relabled as Delete User");
		else
			Log.Fail("Remove Row is not relabled as Delete User");

		return this;
	}

	String fstname;
	String emaildb;
	public ManageUsers verifyAbilityOfTinItems(String accessLevel)
	{
		int sqlRowNo;
		Map portalUserData=null;

		if(accessLevel.equalsIgnoreCase("Administrator"))
		{
			sqlRowNo=1302;
			portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		}
		else if(accessLevel.equalsIgnoreCase("General")) {
			sqlRowNo=1301;
			portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			fstname=portalUserData.get("FST_NM").toString();
			emaildb=portalUserData.get("EMAIL_ADR_TXT").toString();
			testConfig.putRunTimeProperty("emaildb", emaildb);
		}
		String username= portalUserData.get("LST_NM").toString().toUpperCase() + "," +" " + portalUserData.get("FST_NM").toString().toUpperCase();
		testConfig.putRunTimeProperty("username", username);	
		clickSpecificUserName(testConfig.getRunTimeProperty("username"));	
		verifyEnabledOrDisabledForPROV();
		return this;
	}

	public void verifyEnabledOrDisabledForPROV()
	{
		accessLvls=Element.findElements(testConfig, "xpath","//input[@name='GridListResults[0].accessLevel']"); 
		String initialAccessLvl=accessLvls.get(0).getAttribute("value");
		if(initialAccessLvl.contains("A")) {
			Map attributes=Element.getAllAttributes(testConfig, chkDeleteUser, "Delete User checkbox");
			if(attributes.containsKey("disabled"))
				Log.Pass("Delete User checkbox is disabled for PROV Admin");
			else
				Log.Fail("Delete User checkbox is enabled PROV Admin");

			attributes=Element.getAllAttributes(testConfig, chckEmail, "Email checkbox");
			if(attributes.containsKey("disabled"))
				Log.Pass("Email checkbox disabled for PROV Admin");
			else
				Log.Fail("Email checkbox enabled PROV Admin");

			attributes=Element.getAllAttributes(testConfig, provPayUserAccessLvl, "PROV User AccessLvl");
			if(attributes.containsKey("disabled"))
				Log.Pass("Access level is disabled for PROV Admin");
			else
				Log.Fail("Access level is enabled PROV Admin");
		}
		else{
			Map attributes=Element.getAllAttributes(testConfig, chkDeleteUser, "Delete User checkbox");
			if(!attributes.containsKey("disabled"))
				Log.Pass("Delete User checkbox is enabled for PROV Gen ");
			else
				Log.Fail("Delete User checkbox is disabled PROV Gen");

			attributes=Element.getAllAttributes(testConfig, chckEmail, "Email checkbox");
			if(!attributes.containsKey("disabled"))
				Log.Pass("Email checkbox enabled for PROV Gen ");
			else
				Log.Fail("Email checkbox disabled PROV Gen");

			attributes=Element.getAllAttributes(testConfig, provPayUserAccessLvl, "PROV User AccessLvl");
			if(!attributes.containsKey("disabled"))
				Log.Pass("Access level is enabled for PROV Gen");
			else
				Log.Fail("Access level is disabled PROV Gen");
		}
	}

	public ManageUsers deleteUserAndVerify(String accessType, String accessLevel) throws InterruptedException {
		int sqlNo= 1304;
		clickSpecificUserName(testConfig.getRunTimeProperty("username"));
		if(accessLevel.equalsIgnoreCase("General")) {
			ArrayList<String> UsersListUI=getListOfAllUsersFromUI(testConfig); 
			Log.Comment("Current User List before  deleting user is" + '\n'  + UsersListUI);

			testConfig.getRunTimeProperty("emaildb");
			Map data= DataBase.executeSelectQuery(testConfig,sqlNo, 1);
			String portalUserID=data.get("PORTAL_USER_ID").toString();
			testConfig.putRunTimeProperty("portalUserID", portalUserID);
			Element.findElement(testConfig, "xpath", "//input[@name='GridListResults[0].removeTinNpi']");		 
			Browser.wait(testConfig, 3);
			if(accessType.equalsIgnoreCase("PROV")){
				Element.click(chkDeleteUser, "GridListResults[0].removeTinNpi");
				clickSave();
			}
			else if(accessType.equalsIgnoreCase("PAY")) {
				Element.click(chkDeleteUser, "GridListResults[0].removeTinNpi");
				Browser.wait(testConfig, 3);
				Element.click(btnDeleteuserYes, "Yes");
			}
			else {
				Log.Fail("The accessType of the user is neither PROV nor PAY");
			}
			UsersListUI.clear();
			UsersListUI=getListOfAllUsersFromUI(testConfig);

			if(!UsersListUI.contains(fstname))
				Log.Pass("User with first name : " + " " + "'" +fstname + "'" + "and email id"+ emaildb + "is deleted successfully");
			else 
				Log.Fail("User with first name : " + " " + "'" +fstname + "'" + "and email id "+ emaildb + "not deleted");

			Log.Comment("User List after deleting user is" + '\n'  + UsersListUI);

			checkForDeletedUserInDB();
		}
		else if(accessLevel.equalsIgnoreCase("Administrator"))
			Log.Pass("PROV/PAY Admin user cannot delete other Admin user, checkbox is disabled for admin");

		else {
			Log.Fail("The user's accessLevel is neither General nor Administrator");
		}		
		return this;
	}

	public void checkForDeletedUserInDB(){
		int sqlRowNo=1303;
		int rowNo= 1305;
		testConfig.getRunTimeProperty("emaildb");
		Map portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String rowcount=portalUserData.get("ROWNUM").toString();
		int rowCount=Integer.parseInt(rowcount);
		if(rowCount==0)
			Log.Pass("Zero records found for the given condition");
		else
			Log.Fail("More than zero records found for the given condition");

		testConfig.getRunTimeProperty("portalUserID");
		Map ModTypeData=DataBase.executeSelectQuery(testConfig,rowNo, 1);
		String modTypCd=ModTypeData.get("MOD_TYP_CD").toString();
		if(modTypCd.equalsIgnoreCase("PCD"))
			Log.Pass("The MOD_TYP_CD is PCD ");
		else
			Log.Fail("The MOD_TYP_CD is not PCD");
	}


	public ManageUsers verifyAdminPrivileges(String accessLevel) throws InterruptedException {
		clickSpecificUserName(testConfig.getRunTimeProperty("username"));
		if(accessLevel.equalsIgnoreCase("General")){
			List <WebElement> accessLvls=Element.findElements(testConfig, "xpath","//select[@name='GridListResults[0].accessLevel']"); 
			Element.selectByVisibleText(accessLvls.get(0), "Administrator", "Admin as access level"); 
			accessLvls=Element.findElements(testConfig, "xpath","//input[@name='GridListResults[0].accessLevel']"); 
			String changedAccessLvl=accessLvls.get(0).getAttribute("value");
			Helper.compareEquals(testConfig, "Access Level after reselecting", "A", changedAccessLvl );
			clickCancel().clickYes();
		}
		else if(accessLevel.equalsIgnoreCase("Administrator"))  {
			Log.Pass("AccessLevel is not editable for Admin"); 
		}
		else {
			Log.Fail("The user's accessLevel is neither General nor Administrator");
		}
		return this;
	}

	public ManageUsers fillUserInfo(String accessType, String accessLevel) {
		if(accessLevel.equalsIgnoreCase("General")) {
			String phNo = Long.toString(Helper.generateRandomNumber(5));
			String phNoLstField = Long.toString(Helper.generateRandomNumber(4));
			final String firstNameTxt=Helper.generateRandomAlphabetsString(5);
			Element.findElement(testConfig, "name", "fname");
			Element.expectedWait(firstName, testConfig, "First Name textbox", "First Name textbox"); 			
			Browser.wait(testConfig, 2);
			testConfig.getRunTimeProperty("emaildb");
			Element.enterData(email,emaildb, "Enter Email address as:" + " " +emaildb,"email");
			Element.enterData(verifyEmail, emaildb, "Re type email address as :" +" "+emaildb ,"verifyEmail");
			Element.enterData(firstName, firstNameTxt, "Enter First Name as : " + firstNameTxt,"firstName");
			Element.enterData(lastName, firstNameTxt, "Enter Last Name as : " + firstNameTxt,"lastName");
			Element.enterData(phoneNum, phNo, "Enter Phone number in field 1 as:" + " "+phNo,"phoneNum");
			Element.enterData(phoneNum1, phNo, "Enter Phone number in field 2 as:" +" "+phNo,"phoneNum1");
			Element.enterData(phoneNum2, phNoLstField, "Enter Phone number in field 3 as:" + " "+phNoLstField ,"phoneNum2");
			if(accessType.equalsIgnoreCase("PROV")) {
				Element.selectByValue(drpDwnSelectTin, testConfig.getRunTimeProperty("tin"), "select tin");
				Browser.wait(testConfig,2);
				clickAddTin();
				Browser.wait(testConfig,2);
				List <WebElement> accessLvls=Element.findElements(testConfig, "xpath", "//select[not(contains(@id,'accessLevel'))]/parent::td//select");
				Element.selectByVisibleText(accessLvls.get(0), "General", "General as access level");
			}
			else if(accessType.equalsIgnoreCase("PAY")) {
				List <WebElement> accessLvls=Element.findElements(testConfig, "xpath", "//select[not(contains(@id,'accessLevel'))]/parent::td//select");
				Element.selectByVisibleText(accessLvls.get(0), "General", "General as access level");	
			}
			else 
				Log.Fail("The accessType is neither PROV nor PAY");

			Browser.wait(testConfig, 3);
			Element.findElement(testConfig, "xpath", "//input[@value=' Save ']");
			clickSave();
			Element.findElement(testConfig, "xpath", "//td[contains(text(),'User successfully added. Pre-registration material')]");
			String username= firstNameTxt + "," +" " + firstNameTxt;
			testConfig.putRunTimeProperty("username", username);
		}
		else if(accessLevel.equalsIgnoreCase("Administrator"))
			Log.Pass("User cannot be added with the deleted user's email ID since PROV/PAY Admin user cannot delete other admin user");
		else
			Log.Fail("The user's accessLevel is neither General nor Administrator");
		return this;
	}

	public void clickbtnAddNewUser(String accessLevel) {
		if(accessLevel.equalsIgnoreCase("General")) {
			Element.expectedWait(btnAddUser, testConfig, "Add User", "Add User");
			Element.click(btnAddUser, "Add User");
			Browser.wait(testConfig, 3);
		}
		else if(accessLevel.equalsIgnoreCase("Administrator")) {
			Log.Pass("User cannot be added usig existing email address");
		}
		else {
			Log.Fail("The user's accessLevel is neither General nor Administrator");
		}
	}

	public ManageUsers abilityOfFields(String accessLevel) {
		int sqlRowNo;
		Map portalUserData=null;
		if(accessLevel.equalsIgnoreCase("Administrator"))
		{
			sqlRowNo=1309;
			portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		}
		else if(accessLevel.equalsIgnoreCase("General")) {
			sqlRowNo=1308;
			portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		}
		else
			Log.Fail("The user's accessLevel is neither General nor Administrator");

		String bsUsername= portalUserData.get("LST_NM").toString().toUpperCase() + "," +" " + portalUserData.get("FST_NM").toString().toUpperCase();
		testConfig.putRunTimeProperty("bsUsername", bsUsername);	
		clickSpecificUserName(testConfig.getRunTimeProperty("bsUsername"));	
		verifyEnabledOrDisabledForBS(accessLevel);
		return this;	
	}

	public void verifyEnabledOrDisabledForBS(String accessLevel){
		if(accessLevel.equalsIgnoreCase("Administrator")) {
			Map attributes=Element.getAllAttributes(testConfig, bsUserAccessLvl, "BS User AccessLvl");
			if(attributes.containsKey("disabled"))
				Log.Pass("Access level is disabled for BS Admin");
			else
				Log.Fail("Access level is enabled BS Admin");

			attributes=Element.getAllAttributes(testConfig, chckBsEmail, "Email checkbox");
			if(attributes.containsKey("disabled"))
				Log.Pass("Email checkbox disabled for BS Admin");
			else
				Log.Fail("Email checkbox enabled BS Admin");
		}	
		else if(accessLevel.equalsIgnoreCase("General")){
			Map attributes=Element.getAllAttributes(testConfig, bsUserAccessLvl, "BS User AccessLvl");
			if(!attributes.containsKey("disabled"))
				Log.Pass("Access level is enabled for BS Gen");
			else
				Log.Fail("Access level is disabled BS Gen");

			attributes=Element.getAllAttributes(testConfig, chckBsEmail, "Email checkbox");
			if(!attributes.containsKey("disabled"))
				Log.Pass("Email checkbox enabled for BS Gen ");
			else
				Log.Fail("Email checkbox disabled BS Gen ");
		}
		else
			Log.Fail("The user's accessLevel is neither General nor Administrator");
	}

	public ManageUsers bsAdminPrivilages(String accessLevel) {
		clickSpecificUserName(testConfig.getRunTimeProperty("bsUsername"));
		if(accessLevel.equalsIgnoreCase("General")){
			Element.selectByVisibleText(accessLvls.get(0), "Administrator", "Admin as access level"); 
			clickSave();
			accessLvls=Element.findElements(testConfig, "xpath","//input[@name='bsUserAccessLvl']"); 
			String changedAccessLvl=accessLvls.get(0).getAttribute("value");
			Helper.compareEquals(testConfig, "Access Level after reselecting", "A", changedAccessLvl );
			clickCancel().clickYes();
		}
		else if(accessLevel.equalsIgnoreCase("Administrator"))
			Log.Pass("Access level is not editable for Administrator");

		else
			Log.Fail("The user's accessLevel is neither General nor Administrator");

		return this;
	}

	public ManageUsers abilityOfFieldsForPayer(String accessLevel) {
		int sqlRowNo;
		Map portalUserData=null;
		if(accessLevel.equalsIgnoreCase("Administrator"))
		{
			sqlRowNo=1307;
			portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		}
		else if(accessLevel.equalsIgnoreCase("General")) {
			sqlRowNo=1306;
			portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			fstname=portalUserData.get("FST_NM").toString();
			emaildb=portalUserData.get("EMAIL_ADR_TXT").toString();
			testConfig.putRunTimeProperty("emaildb", emaildb);
		}
		else
			Log.Fail("The user's accessLevel is neither General nor Administrator");

		String username= portalUserData.get("LST_NM").toString().toUpperCase() + "," +" " + portalUserData.get("FST_NM").toString().toUpperCase();
		testConfig.putRunTimeProperty("username", username);	
		clickSpecificUserName(testConfig.getRunTimeProperty("username"));	
		verifyEnabledOrDisabledForPAY(accessLevel);
		return this;
	}
	
	public void verifyEnabledOrDisabledForPAY(String accessLevel){
		if(accessLevel.equals("Administrator")) {
			Map attributes=Element.getAllAttributes(testConfig, chkDeleteUser, "Delete User checkbox");
			if(attributes.containsKey("disabled"))
				Log.Pass("Delete User checkbox is disabled for PAY Admin");
			else
				Log.Fail("Delete User checkbox is enabled PAY Admin");

			attributes=Element.getAllAttributes(testConfig, chckPayEmail1, "Email checkbox funding notification");
			if(attributes.containsKey("disabled"))
				Log.Pass("Email checkbox1 disabled for PAY Admin");
			else
				Log.Fail("Email checkbox1 enabled PAY Admin");

			attributes=Element.getAllAttributes(testConfig, chckPayEmail2, "Email checkbox non enrolled providers notification");
			if(attributes.containsKey("disabled"))
				Log.Pass("Email checkbox2 disabled for PAY Admin");
			else
				Log.Fail("Email checkbox12 enabled PAY Admin");

			attributes=Element.getAllAttributes(testConfig, chckPayEmail2, "Email checkbox inactive providers notification");
			if(attributes.containsKey("disabled"))
				Log.Pass("Email checkbox3 disabled for PAY Admin");
			else
				Log.Fail("Email checkbox3 enabled PAY Admin");

			attributes=Element.getAllAttributes(testConfig, provPayUserAccessLvl, "PROV User AccessLvl");
			if(attributes.containsKey("disabled"))
				Log.Pass("Access level is disabled for PAY Admin");
			else
				Log.Fail("Access level is enabled PAY Admin");
		}
		else if(accessLevel.equals("General")){
			Map attributes=Element.getAllAttributes(testConfig, chkDeleteUser, "Delete User checkbox");
			if(!attributes.containsKey("disabled"))
				Log.Pass("Delete User checkbox is enabled for PAY Gen");
			else
				Log.Fail("Delete User checkbox is disabled PAY Gen");

			attributes=Element.getAllAttributes(testConfig, chckPayEmail1, "Email checkbox funding notification");
			if(!attributes.containsKey("disabled"))
				Log.Pass("Email checkbox1 enabled for PAY Gen");
			else
				Log.Fail("Email checkbox1 disabled PAY Gen");

			attributes=Element.getAllAttributes(testConfig, chckPayEmail2, "Email checkbox non enrolled providers notification");
			if(!attributes.containsKey("disabled"))
				Log.Pass("Email checkbox2 enabled for PAY Gen");
			else
				Log.Fail("Email checkbox2 disabled PAY Gen");

			attributes=Element.getAllAttributes(testConfig, chckPayEmail2, "Email checkbox inactive providers notification");
			if(!attributes.containsKey("disabled"))
				Log.Pass("Email checkbox3 enabled for PAY Gen");
			else
				Log.Fail("Email checkbox3 disabled PAY Gen");

			attributes=Element.getAllAttributes(testConfig, provPayUserAccessLvl, "PROV User AccessLvl");
			if(!attributes.containsKey("disabled"))
				Log.Pass("Access level is enabled for PAY Gen");
			else
				Log.Fail("Access level is disabled PAY Gen");
		}
		else
			Log.Fail("The user's accessLevel is neither General nor Administrator");
	}

	public ManageUsers getPortalUserIdOfNewUser() {
		clickSave();
		int sqlNo= 1310;
		testConfig.getRunTimeProperty("email");
		Map userData=DataBase.executeSelectQuery(testConfig, sqlNo, 1);
		String portalUserID=userData.get("PORTAL_USER_ID").toString();
		testConfig.putRunTimeProperty("portalUserID",portalUserID);
		return this;
	}
	
	public ManageUsers verifyModTypCdCodeForDeletedUser(String userType) {
		clickSave();
		int sqlrowNo= 1311;
		testConfig.getRunTimeProperty("portalUserID");
		testConfig.getRunTimeProperty("email");
		Map userData=DataBase.executeSelectQuery(testConfig, sqlrowNo, 1);
		String modTypeCD=userData.get("MOD_TYP_CD").toString();
		if(userType.equals("PROV") || userType.equals("BS")){
			if(modTypeCD.equalsIgnoreCase("PCD"))
				Log.Pass("MOD_TYP_CD value is PCD");
			else
				Log.Fail("MOD_TYP_CD value is not PCD");	
		}
		else{
			if(modTypeCD.length()==0)
				Log.Pass("MOD_TYP_CD value is null");
			else
				Log.Fail("MOD_TYP_CD value is not null");		
		}
		return this;
	}

	public ManageUsers deleteCheckbox(String accessType) {

		findDeleteCheckbox(accessType,1).click();
		clickSave();
		return this;
	}

	public ManageUsers clickUserListLink()
	{
		Element.click(lnkUserList, "User List Link");
		return this;
	}	

	public void verifyResetPwdButton()
	{
		Element.verifyElementNotPresent(resetPwdBtn, "Reset Password");
	}

	public void verifyDbBeforeTinDeletion() {
		int sqlNo= 13;
		testConfig.putRunTimeProperty("email",super.userEmailAdr );
		Map dbPortal=DataBase.executeSelectQuery(testConfig, sqlNo, 1);
		if(dbPortal != null ){
			Log.Pass("User Added Successfully in Database");
		}
		else
			Log.Fail("User not Added Successfully in Database");

		String portalUserId=dbPortal.get("PORTAL_USER_ID").toString();
		testConfig.putRunTimeProperty("portalUserID",portalUserId);
	}

	public void verifyDbAfterTinDeletion() {
		int sqlNo= 13;
		Map dbPortal=DataBase.executeSelectQuery(testConfig, sqlNo, 1);
		if(dbPortal == null ){
			Log.Pass("User deleted successfully");
		}
		else
			Log.Fail("User failed to delete");
	}

	public void verifyDbHistoryAfterTinDeletion() {
		int sqlRowNo=1311;
		Map dbPortal = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String modTypeCd;
		if(dbPortal!=null) {
			modTypeCd = dbPortal.get("MOD_TYP_CD").toString();
			if(modTypeCd.compareTo("PCD")==0) 
				Log.Pass("Deleted User updated in History table");
			else 
				Log.Fail("Deleted User failed to update History table");
		}
	}

	public ManageUsers enterTinSaveAndVerify(String accessType){
		Element.selectByValue(drpDwnSelectTin, testConfig.getRunTimeProperty("tin"), "select tin");

		clickAddTin();

		Element.selectByVisibleText(accessLvls.get(0), "General", "General as access level");
		clickSave();
		verifyDetailsOfNewUser(accessType);	
		return this;
	}

	public WebElement findDeleteCheckbox(String userType, int i)
	{

		if(userType.equals("PROV"))
		{
			dltChkbox=tinGridRows.get(i).findElements(By.tagName("td")).get(6).findElement(By.tagName("input"));
		}
		else if(userType.equals("BS"))
		{ 
			dltChkbox=tinGridRows.get(i).findElements(By.tagName("td")).get(5).findElement(By.tagName("input"));
		}

		return dltChkbox;
	}

	public ManageUsers addTin() {
		int sqlRowNo = 423;
		Map Searchedtin = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		String tin1 = Searchedtin.get("PROV_TIN_NBR").toString().trim();
		Element.enterData(addTinTxtbox, tin1, "Associate to tin", "addTin");
		clickAddTin();
		testConfig.putRunTimeProperty("tin1", tin1);
		return this;
	}

	public ManageUsers AddTinAndVerifyDB(String accessLevel)

	{
		String tin1 = testConfig.getRunTimeProperty("tin1");
		List<WebElement> tinGridRows = Element.findElements(testConfig, "xpath",
				"//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr");
		for (int i = 0; i < tinGridRows.size(); i++) {
			String tinNo = tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
			if (tinNo.equals(tin1)) {
				Element.selectByVisibleText(
						tinGridRows.get(i).findElements(By.tagName("td")).get(2).findElement(By.tagName("select")),
						accessLevel, "Select" + accessLevel + "from access Level dropdown");
				clickSave();
			}
		}
		return this;
	}

	public int fetchRecordCount() {
		int sqlRow = 425;
		Map portaluserhistorydata = DataBase.executeSelectQuery(testConfig, sqlRow, 1);
		int rowcount = Integer.parseInt(portaluserhistorydata.get("ROWCOUNT").toString().trim());
		return rowcount;
	}

	public void verifyRowCount(int rowcount_beforeusercreation) {
		int rowcount_afterusercreation = fetchRecordCount();
		if (rowcount_afterusercreation > rowcount_beforeusercreation)
			Log.Pass("New Row  is Created Successfully");
		else
			Log.Fail("New Row is Not Created");
	}

	public void changeAccessLevel() {
		String userName = testConfig.getRunTimeProperty("firstName");
		String tin = testConfig.getRunTimeProperty("tin");
		this.clickSpecificUserName(userName);
		int sqlRowNo = 424;
		WebElement accessLvlDrpDwn = null;
		List<WebElement> tinGridRows = testConfig.driver
				.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
		for (int i = 1; i < tinGridRows.size(); i++) {
			String tinNo = tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
			if (tinNo.equalsIgnoreCase(tin)) {
				accessLvlDrpDwn = tinGridRows.get(i).findElement(By.tagName("select"));
				Element.selectByVisibleText(accessLvlDrpDwn, "Administrator", "Admin as access level");
				clickSave();
				Map portalUserData = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
				Helper.compareEquals(testConfig, "Access Level Validation", "A",
						portalUserData.get("ACCESS_LVL").toString());
				Helper.compareEquals(testConfig, "MOD TYPE CODE Validation", "PCLU",
						portalUserData.get("MOD_TYP_CD").toString());
				break;
			}
		}
	}

	public ManageUsers changeEmailNotificationAndValidateinDB() {
		String userName = testConfig.getRunTimeProperty("firstName");
		String tin = testConfig.getRunTimeProperty("tin");
		this.clickSpecificUserName(userName);
		int sqlRowNo = 424;
		WebElement accessLvlDrpDwn = null;
		List<WebElement> tinGridRows = testConfig.driver
				.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
		for (int i = 1; i < tinGridRows.size(); i++) {
			String tinNo = tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
			if (tinNo.equalsIgnoreCase(tin)) {
				emailChkbox = findEmailCheckbox("PROV");
				emailChkbox.click();
				clickSave();
				Map portalUserData = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
				Helper.compareEquals(testConfig, "Email Notification Validation", "PCC",
						portalUserData.get("MOD_TYP_CD").toString());
				Element.findElement(testConfig, "xpath", "//input[@name='GridListResults[0].removeTinNpi']");
				Browser.wait(testConfig, 3);
				Element.click(chkDeleteUser, "GridListResults[0].removeTinNpi");
				clickSave();
			}
			break;
		}
		return this;
	}

	public ManageUsers deleteUserandValidateinDB() {
		String userName = testConfig.getRunTimeProperty("firstName");
		String tin = testConfig.getRunTimeProperty("tin");
		this.clickSpecificUserName(userName);
		int sqlRowNo = 424;
		WebElement accessLvlDrpDwn = null;
		List<WebElement> tinGridRows = testConfig.driver
				.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
		for (int i = 1; i < tinGridRows.size(); i++) {
			String tinNo = tinGridRows.get(i).findElements(By.tagName("td")).get(0).getText();
			if (tinNo.equalsIgnoreCase(tin)) {
				Element.findElement(testConfig, "xpath", "//input[@name='GridListResults[0].removeTinNpi']");
				Browser.wait(testConfig, 3);
				Element.click(chkDeleteUser, "removeTinNpi");
				clickSave();
				Map portalUserData = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
				Helper.compareEquals(testConfig, "Remove User Validation", "PCD",
						portalUserData.get("MOD_TYP_CD").toString());
			}
			break;
		}
		return this;
	}

	public void verifyBSManageUserUpdates() {
		String userName = testConfig.getRunTimeProperty("firstName");
		String tin = testConfig.getRunTimeProperty("tin");
		this.clickSpecificUserName(userName);
		int sqlRowNo = 426;
		Map portalUserData = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "MOD_TYP_CD", "BSAY", portalUserData.get("MOD_TYP_CD").toString());
		emailChkbox = findEmailCheckbox("BS");
		emailChkbox.click();
		clickSave();
		Map portalUserEmail = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "Email Notification Validation", "PCC",
				portalUserEmail.get("MOD_TYP_CD").toString());
		Element.click(btnDelete, "Delete Button");
		Element.click(btnYes, "Delete Button");
		Map portalUserDelete = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "Email Notification Validation", "PCD",
				portalUserDelete.get("MOD_TYP_CD").toString());
	}

	public void verifyAccessLevelChangeBS() {
		String userName = testConfig.getRunTimeProperty("firstName");
		String tin = testConfig.getRunTimeProperty("tin");
		this.clickSpecificUserName(userName).selectTinAccessLvl("Administrator").clickSave();
		int sqlRowNo = 426;
		Map portalUserData = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "MOD_TYP_CD", "PCLU", portalUserData.get("MOD_TYP_CD").toString());
	}

	public void addTinDoNotAssociate() {
		int sql = 428;
		Map user = DataBase.executeSelectQuery(testConfig, sql, 1);
		String userName = user.get("LST_NM").toString();
		this.clickSpecificUserName(userName);
		clickAsscociateNoButton().addProviderAssociation();
		int sqlRowNo = 427;
		Map provDetails = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		String tin2 = provDetails.get("PROV_TIN_NBR").toString();
		Element.click(associateBSNoButton, "No Button");
		Element.enterData(addProviderAssociation, tin2, "EnterTin", "Add provider Association");
		Element.click(addTinAssociationButton, "add Tin Association Button");
		clickSave();
		int sqlRowNo1 = 426;
		Map portalUserData = DataBase.executeSelectQuery(testConfig, sqlRowNo1, 1);
		Helper.compareEquals(testConfig, "MOD_TYP_CD", "BSPA", portalUserData.get("MOD_TYP_CD").toString());
		List<WebElement> tinGridRows = testConfig.driver
				.findElements(By.xpath("//div[@class='subheadernormal' and not(contains(@id,'flow'))]//table//tr"));
		for (int i = 1; i < tinGridRows.size(); i++) {
			String tinNo = tinGridRows.get(i).findElements(By.tagName("td")).get(2).getText();
			if (tinNo.equalsIgnoreCase(tin2)) {
				tinGridRows.get(i).findElements(By.tagName("td")).get(5).click();
				clickSave();
				Map portalUserData1 = DataBase.executeSelectQuery(testConfig, sqlRowNo1, 1);
				Helper.compareEquals(testConfig, "Remove User Validation", "BSPD",
						portalUserData1.get("MOD_TYP_CD").toString());
				break;
			}
		}
	}


	public void verifyMutlipleChangesBS() {
		String nameOfUser = testConfig.getRunTimeProperty("firstName");
		int sqlRowNo = 426;
		Map portalUserData = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "MOD_TYP_CD", "BSAN", portalUserData.get("MOD_TYP_CD").toString());
		List<WebElement> users = testConfig.driver.findElements(By.partialLinkText(nameOfUser));
		users.get(1).click();
		selectTinAccessLvl("Administrator");
		emailChkbox = findEmailCheckbox("BS");
		emailChkbox.click();
		clickSave();
		Helper.compareEquals(testConfig, "MOD_TYP_CD", "PCM", portalUserData.get("MOD_TYP_CD").toString());
	}

	public ManageUsers updateAccessLevel() {
		int sqlRowNo = 426;
		String tin1 = testConfig.getRunTimeProperty("tin1");
		Browser.wait(testConfig, 3);
		Map result = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		// Helper.compareEquals(testConfig, "MOD_TYP_CD", "PCNT",
		// result.get("MOD_TYP_CD").toString().trim());
		selectAccessLvl("Administrator", tin1);
		clickSave();
		Browser.wait(testConfig, 3);

		Map accessLevel = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "MOD_TYP_CD", "PCLU", accessLevel.get("MOD_TYP_CD").toString().trim());
		chckEmail.click();
		clickSave();
		Browser.wait(testConfig, 3);

		Map email = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		// Helper.compareEquals(testConfig, "MOD_TYP_CD", "PCC",
		// email.get("MOD_TYP_CD").toString().trim());
		removeFistTinInGrid();
		clickSave();
		Browser.wait(testConfig, 3);

		Map delete = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "MOD_TYP_CD", "PCD", delete.get("MOD_TYP_CD").toString().trim());

		addTin().AddTinAndVerifyDB("General");
		Browser.wait(testConfig, 3);

		selectAccessLvl("Administrator", tin1);
		Browser.wait(testConfig, 3);
		chckEmail.click();
		clickSave();
		Browser.wait(testConfig, 3);
		Map multiple = DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		// Helper.compareEquals(testConfig, "MOD_TYP_CD", "PCM",
		// multiple.get("MOD_TYP_CD").toString().trim());
		return this;
	}

	public void verifyYourChangesWereUpdatedSuccessfully()
	{
		Log.Comment("Verifying yourChangesWereUpdatedSuccessfully Message");
		Element.verifyElementPresent(yourChangesWereUpdatedSuccessfully,"Your Changes Were Updated Successfully Message");
	}

	public void enterPortalTIN(String portalAccess, String tinTyp)
	{
		Element.click(rdoNo, "No Radio Button");
		Browser.wait(testConfig, 2);
		int sqlRowNo=0;
		if (portalAccess.equalsIgnoreCase("Premium") && (tinTyp.equalsIgnoreCase("AO")||tinTyp.equalsIgnoreCase("AV")))
			sqlRowNo=1601;
		if (portalAccess.equalsIgnoreCase("Premium") && tinTyp.equalsIgnoreCase("VO"))
			sqlRowNo=1602;
		Map portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		testConfig.putRunTimeProperty("tin", portalUserData.get("PROV_TIN_NBR").toString());

		int sqlRowNo1=1604;
		int isTinAssociated=0;
		Map associatedTins = DataBase.executeSelectQuery(testConfig,sqlRowNo1, 1);
		isTinAssociated=Integer.valueOf((String) associatedTins.get("TIN_COUNT"));
		if(isTinAssociated == 0) 

		{
			int insertQueryRowNo=61;
			DataBase.executeInsertQuery(testConfig, insertQueryRowNo);
			Log.Comment("Associated tin " + portalUserData.get("PROV_TIN_NBR").toString() + "With Logged in user");
			// testConfig.putRunTimeProperty("TobeDeleted", userType);
		}
		Element.enterData( Element.findElement(testConfig, "name", "provTinAssociate"), portalUserData.get("PROV_TIN_NBR").toString(), "Prov TIN", "PROV TIN");
		Element.findElement(testConfig, "xpath", "//input[@type='button' and @value='Add TIN Association']").click();

		btnSave.click();
		Helper.compareEquals(testConfig, "Updated msg",  Element.findElement(testConfig, "xpath", "//td[contains(text(),'Your user changes were updated successfully')]").getText(), "Your user changes were updated successfully");
		removetinadded();
	}

	public void removetinadded()
	{
		WebElement delete = testConfig.driver.findElement(By.xpath("//div[@class='manageUsers__tinGrid_container_div']//td[contains(text(),'521362758')]/following-sibling::td/div[contains(@class,'delete')]"));
		delete.click();
	}



	public ManageUsers verifyAddUsrBtnVsblBySystem_ModeUPA(String portalAccess, String systemMode, String userType)
	{
		int sqlRowNo=1606;
		Map system_Mode = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);

		if(system_Mode.get("PROC_DATA").toString().equalsIgnoreCase("FEEBASED") && (portalAccess.equalsIgnoreCase("Premium")||  portalAccess.equalsIgnoreCase("Legacy")) && (userType.contains("PROV")))
		{
			verifyAddUserBtnEnabledUPA(portalAccess);
			deleteInsertedUserportal();
		}

		else if((system_Mode.get("PROC_DATA").toString().equalsIgnoreCase("FEEBASED")) && (portalAccess.equalsIgnoreCase("Standard") &&  (userType.contains("PROV"))))
		{
			int sqlRowNoStandardTinCount=1608;
			Map noofRecords = DataBase.executeSelectQuery(testConfig,sqlRowNoStandardTinCount, 1);
			int recordCount=Integer.valueOf((String) noofRecords.get("TOTALACTPR"));

			if (recordCount >= 2)
				verifyAddUserBtnDisabledUPA();
			else
			{
				verifyAddUserBtnEnabledUPA(portalAccess);	
				clickAddNewUserUPA().fillNewUserInfo().selectAndAddTin();
				deleteInsertedUserportal();
			}
		}

		else if((system_Mode.get("PROC_DATA").toString().equalsIgnoreCase("FEEBASED") || system_Mode.get("PROC_DATA").toString().equalsIgnoreCase("LEGACY") 
				&&  (portalAccess.equalsIgnoreCase("Premium") &&  (userType.contains("BS") || (userType.contains("PAY"))))))

			verifyAddUserBtnEnabledUPA(portalAccess);
		else
			Log.failure("Condition criteria mismatch");
		
		return this;
	} 

	public void verifyAddUserBtnEnabledUPA(String portalAccess){
		try{

			if(testConfig.driver.findElements(By.xpath("//button[@class='px-3 m-1 btn-secondary' ]/b")).size() != 0)
				Helper.compareEquals(testConfig, "Add User Button is enabled", true, addUserBtn.isEnabled());
			else if (testConfig.driver.findElements(By.xpath("//input[@class='px-3 m-1 btn-secondary' and @value = ' + Add User']")).size() != 0)
				Helper.compareEquals(testConfig, "Add User Button is enabled", true, btnAddUserUPA.isEnabled());
			else if (testConfig.driver.findElements(By.xpath("//input[@class='px-3 m-1 btn-secondary' and @value = '+ Add User']")).size() != 0)
				Helper.compareEquals(testConfig, "Add User Button is enabled", true, btnAddUserpayer.isEnabled());
			else
				Log.failure("Add User Button is disabled for Premium User");
		}catch(Exception e){
			Log.Fail("User button is not enabled so entered catch block");
		}
	}

	public void verifyAddUserBtnDisabledUPA()
	{
		if(addUserBtn.getAttribute("disabled").toString().equalsIgnoreCase("true"))
		{
			String value = "true";
			Helper.compareEquals(testConfig, "Add User button is not enabled", "true", value);
		}
		else
			Log.Fail("User Button is Enabled");
	}

	//		 public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
	//		    { 
	//		  
	//		        // Create a new ArrayList 
	//		        ArrayList<T> newList = new ArrayList<T>(); 
	//		  
	//		        // Traverse through the first list 
	//		        for (T element : list) { 
	//		  
	//		            // If this element is not present in newList 
	//		            // then add it 
	//		            if (!newList.contains(element)) { 
	//		  
	//		                newList.add(element); 
	//		            } 
	//		        } 
	//		  
	//		        // return the new list 
	//		        return newList; 
	//		    } 

	public void verifyFooterMessageOnManageUsers() {
		String footerTextUI= "A business issued email is required when adding a new user. Personal emails will not be accepted. New users that fail to complete the registration process will be removed from Optum Pay. In addition, existing users with no login activity after six months will be purged. Please review your user list periodically to ensure that all contact information is accurate. If at any time you need to remove a user, please contact our Provider Support Center at 1-877-620-6194.";
		Helper.compareEquals(testConfig, "Footer title for post trail premium TIN", "Enrollment & Account Security Reminder", footerTitle.getText().trim());
		Helper.compareEquals(testConfig, "Footer text for post trail premium TIN", footerTextUI, footerText.getText().trim());
	}

	public void verifyEmailNotifyAccLvlForN(String userType,String newAddedTin,int tinIndex)
	{
		String emailChkboxUI = null;
		if(userType.contains("PROV"))
		{

			Element.click(savebtn, "Save Button");
			String activeuser = usernameUI.getText();
			String lst_nm = activeuser.substring(0, activeuser.lastIndexOf(','));
			String fst_nm = activeuser.substring(activeuser.lastIndexOf(',')+1,activeuser.length()).trim();

			int sqlRowNo=279;
			testConfig.putRunTimeProperty("lst_nm", lst_nm);
			testConfig.putRunTimeProperty("fst_nm", fst_nm);
			Map portalUserData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			Helper.compareEquals(testConfig, "Access Level", "N", portalUserData.get("EMAIL_NTFY_IND").toString());

			String tin = testConfig.getRunTimeProperty("tinNo");
			String  access_lvl1 = testConfig.driver.findElement(By.xpath("//div[@id='manage-users']//table[@class='manageUsers__tinGrid datatables']//td[contains(text(),'"+tin+"')]/following-sibling::td/select[contains(@name,'GridListResults')]/option[@selected='selected']")).getText();
			String access_lvl = null;
			if(access_lvl1.contains("General"))
				access_lvl = "G";
			else
				Log.Fail("Access Level for that TIN");

			Helper.compareEquals(testConfig, "Access Level", access_lvl, portalUserData.get("ACCESS_LVL").toString().trim());
		}
	}

	public void deleteaddedtin()
	{
		String tin = testConfig.getRunTimeProperty("tinNo");
		WebElement delete = testConfig.driver.findElement(By.xpath("//div[@id='manage-users']//table[@class='manageUsers__tinGrid datatables']//td[contains(text(),'"+tin+"')]/following-sibling::td/div[contains(@class,'delete')]"));
		delete.click();
		Browser.waitForPageLoad(testConfig.driver);
		btnSave.click();
	}
	
	public ManageUsers verifyModTypeCd(String userType, String value) {

		String modTypCdDB="";
		Map SearchedData=null;
		int flag=1;
		if(userType.equalsIgnoreCase("PROV"))
		{
			int sqlRowNo=1114;
			testConfig.getRunTimeProperty("tin");
			testConfig.getRunTimeProperty("email");
			SearchedData=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			modTypCdDB=SearchedData.get("MOD_TYP_CD").toString().trim();

		}
		else if(userType.equalsIgnoreCase("BS"))
		{
			int sqlRowNo=1117;
			testConfig.getRunTimeProperty("billing_service_id");
			SearchedData=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			modTypCdDB=SearchedData.get("MOD_TYP_CD").toString().trim();

		}
		if(value.equalsIgnoreCase("null"))
		{
			if(modTypCdDB.length()==0)
				flag=0;
		}
		if(value.equalsIgnoreCase(modTypCdDB)|| flag==0)
			Log.Comment("mod type cd is correct" + modTypCdDB);
		else
			Log.Fail("mod type cd is incorrect "+modTypCdDB);
		return this;
	}

	/**
	 * Author : Vinay Raghumanda
	 * Validates Page Text for Manage Users for Different types of users.
	 * @param credentials
	 * @param portalAccess
	 */
	public void validatePageText(String accessType, String portalAccess) {

		String expectedParagraph, expectedFooterHeaderText, expectedFooterParaText;
		WebElement footerParagraphTag = null;

		switch (accessType + "_" + portalAccess + "_" + testConfig.getRunTimeProperty("tinType")){
		case "PROV_Admin_Premium_AO":
			expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.premium.ao.manageUsers.paragraph");
			expectedFooterHeaderText = TestBase.contentMessages.getProperty("prov.admin.premium.ao.manageUsers.footer.header");
			expectedFooterParaText = TestBase.contentMessages.getProperty("prov.admin.premium.ao.manageUsers.footer.para");
			footerParagraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"bottomMessageDiv\"]/p");
			manageUserPageValidation(expectedParagraph, expectedFooterHeaderText, expectedFooterParaText, footerParagraphTag);
			break;
		case "PROV_Admin_Premium_VO":
			expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.premium.vo.manageUsers.paragraph");
			expectedFooterHeaderText = TestBase.contentMessages.getProperty("prov.admin.premium.vo.manageUsers.footer.header");
			expectedFooterParaText = TestBase.contentMessages.getProperty("prov.admin.premium.vo.manageUsers.footer.para");
			footerParagraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"bottomMessageDiv\"]/p");
			manageUserPageValidation(expectedParagraph, expectedFooterHeaderText, expectedFooterParaText, footerParagraphTag);
			break;	
		case "PROV_Admin_Standard_AO":
			expectedParagraph = TestBase.contentMessages.getProperty("prov.admin.standard.ao.manageUsers.paragraph");
			expectedFooterHeaderText = TestBase.contentMessages.getProperty("prov.admin.standard.ao.manageUsers.footer.header");
			expectedFooterParaText = TestBase.contentMessages.getProperty("prov.admin.standard.ao.manageUsers.footer.para");
			footerParagraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"bottomMessageDiv\"]/p");
			manageUserPageValidation(expectedParagraph, expectedFooterHeaderText, expectedFooterParaText, footerParagraphTag);
			break;
		case "BS_Admin_Premium_AO":
			expectedParagraph = TestBase.contentMessages.getProperty("bs.admin.premium.ao.manageUsers.paragraph");
			expectedFooterHeaderText = TestBase.contentMessages.getProperty("bs.admin.premium.ao.manageUsers.footer.header");
			expectedFooterParaText = TestBase.contentMessages.getProperty("bs.admin.premium.ao.manageUsers.footer.para");
			footerParagraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"bottomMessageDiv\"]/p[2]");
			manageUserPageValidation(expectedParagraph, expectedFooterHeaderText, expectedFooterParaText, footerParagraphTag);
			break;
		default:
			break;
		}
	}

	private void manageUserPageValidation(String expectedParagraph, String expectedFooterHeaderText, String expectedFooterParaText, WebElement footerPara) {
		WebElement paragraphTag;
		WebElement footerHeader;
		String actualParagraph;
		String actualFooterHeaderText;
		String actualFooterParaText;
		Element.waitForPresenceOfElementLocated(testConfig, By.xpath("//*[@class=\"topMessaggeDiv\"]"), 30);
		paragraphTag = Element.findElement(testConfig, "xpath", "//*[@class=\"topMessaggeDiv\"]/p");
		footerHeader = Element.findElement(testConfig, "xpath", "//*[@class=\"bottomMessageDiv\"]/h2");
		actualParagraph = paragraphTag.getText().trim();
		actualFooterHeaderText = footerHeader.getText().trim();
		actualFooterParaText = footerPara.getText().trim();
		Helper.compareEquals(testConfig, "Page Text", actualParagraph, expectedParagraph);
		Helper.compareEquals(testConfig, "Page Text", actualFooterHeaderText, expectedFooterHeaderText);
		Helper.compareEquals(testConfig, "Page Text", actualFooterParaText, expectedFooterParaText);
	}

	public  void clickHome() {
		WebElement linkHome=testConfig.driver.findElement(By.linkText("Home"));
		Element.clickByJS(testConfig, linkHome, "home link clicked");
	}

	public ManageUsers clickSpecificUserNametoedit(String userType) {
		int sqlRowNo;

		if(userType.equalsIgnoreCase("PROV"))
			sqlRowNo=1116;

		else
			sqlRowNo=1118;

		Map portalBSData = DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
		String username= portalBSData.get("LST_NM").toString() + ", " +portalBSData.get("FST_NM").toString();
		testConfig.putRunTimeProperty("username", username);	

		if(userType.equalsIgnoreCase("PROV"))
			testConfig.putRunTimeProperty("email", portalBSData.get("EMAIL_ADR_TXT").toString());

		clickSpecificUserName(testConfig.getRunTimeProperty("username"));	
		return this;
	}

	/******
	 * Author: Mohammad Khalid
	 * This methods validates the title, message content, Yes and No buttons on the MFA Dialog Box
	 * *********/

	public ManageUsers validateMFADialogBoxContentMUtab()
	{
		Helper.compareEquals(testConfig, "MFA Dialog Box Title", TestBase.contentMessages.getProperty("prov.mfadialogbox.title"), mfaDialogBoxTitle.getText().trim());
		Helper.compareEquals(testConfig, "MFA Dialog Box Title", TestBase.contentMessages.getProperty("prov.mfadialogbox.messageContent"), mfaDialogBoxMessage.getText().trim());

		Element.verifyElementPresent(mfaDialogBoxNoButton, "No Button on MFA Dialog Box");
		Element.verifyElementPresent(mfaDialogBoxYesButton, "Yes Button on MFA Dialog Box");

		return this;

	}

	/******
	 * Author: Mohammad Khalid
	 * This methods checks for the MFA flag 
	 * *********/
	public boolean checkMFAflag()
	{
		String query = QUERY.MFA_SWITCH_CHECK;
		boolean mfaFlag = false;
		String mfa_Proc_Data = null;
		Map<String, String> results = DataBase.executeSelectQuery(testConfig, query, 1);
		mfa_Proc_Data = (String) results.get("PROC_DATA").trim();
		if (StringUtils.equals(mfa_Proc_Data, "Y"))
			mfaFlag = true;
		return mfaFlag;
	}

	public ManageUsers	deleteFraudUser() {
		String username= testConfig.getRunTimeProperty("last_name").toString() + "," +" " + testConfig.getRunTimeProperty("first_name").toString();
		testConfig.putRunTimeProperty("username", username);
		clickSpecificUserName(testConfig.getRunTimeProperty("username"));
		Element.clickByJS(testConfig,btnDltFraudUser, "Delete fraud Button");
		Element.clickByJS(testConfig,btnYes, "Yes button");
		return this;
	}

	public ManageUsers selectActiveUser(String userName)
	{
		for(WebElement element : userList) {
			String uname = element.getText().trim();
			if(uname.equalsIgnoreCase(userName)) {
				Element.click(element.findElement(By.tagName("a")), "User name web element");
				if(txtStatus.getText().contains("Active")) {
					break;
				}
			}
		}
		return new ManageUsers(testConfig);
	}

	public void verifyCsrManageUserUI(String userType)
	{
		Log.Comment("Verifying Elements for CSR Manage User Page");
		String title = "";
		selectActiveUser(testConfig.getRunTimeProperty("userName"));
		Element.verifyElementPresent(lnkUserList,"User list");
		Element.verifyElementPresent(btnUnlinkOptumId,"Unlink optum Id button");
		Element.verifyElementPresent(btnAddUser,"Add user button");
		Element.verifyElementPresent(btnRsndRegEmail,"Resend registration mail button");
		Element.verifyElementPresent(fname,"First name textbox");
		Element.verifyElementPresent(middleName,"Middle name textbox");
		Element.verifyElementPresent(lname,"Last name textbox");
		Element.verifyElementPresent(phoneNum,"Phone number1 textbox");
		Element.verifyElementPresent(phoneNum1,"Phone number2 textbox");
		Element.verifyElementPresent(phoneNum2,"Phone number3 textbox");
		Element.verifyElementPresent(extension,"Extension number textbox");
		Element.verifyElementPresent(email,"Email Id textbox");
		Element.verifyElementPresent(verifyEmail,"Retype email Id textbox");

		switch (userType) {
		case "PROV":
			title+="Manage Users";
			Element.verifyElementPresent(btnDltFraudUser,"Delete fraud user button");
			Element.verifyElementPresent(chkboxFraudUser,"View fraud user checkbox");
			Element.verifyElementPresent(chkBoxProvPurge,"View purged user checkbox for provider");
			Element.verifyElementPresent(txtboxTin,"Tin number texbox");
			Element.verifyElementPresent(btnSearch,"Tin search button");
			Element.verifyElementPresent(btnAddTINNPI,"Add TIN/NPI button");
			Element.verifyElementPresent(userDetailsTableForProviderOrBS,"User details table for provider");
			break;
		case "PAY":
			title+="Manage Payer Users";
			Element.verifyElementPresent(subPayerRadiobtnYes,"Sub payer radio button as Yes");
			Element.verifyElementPresent(subPayerRadiobtnNo,"Sub payer radio button as No");
			Element.verifyElementPresent(userDetailsTableForPayer,"User details table for payer");
			Element.verifyElementPresent(chkBoxPurgedUser,"View purged user checkbox for provider");
			break;
		case "BS":
			title+="Secure User- Manage Users";
			Element.verifyElementPresent(drpDwnBSaccessLvl,"Dropdown for access level BS");
			Element.verifyElementPresent(associateBSYesButton,"Associate Billing Service Users to all Providers as Yes radio button");
			Element.verifyElementPresent(associateBSNoButton,"Associate Billing Service Users to all Providers as No radio button");
			Element.clickByJS(testConfig,associateBSNoButton, "Clicking on associate BS no btton");
			Element.verifyElementPresent(addProviderAssociation,"Add Provider Association textbox");
			Element.verifyElementPresent(addTinAssociationButton,"Add Tin association button");
			Element.verifyElementPresent(userDetailsTableForProviderOrBS,"User details table for BS");
			Element.verifyElementPresent(chkBoxPurgedUserBS,"View purged user checkbox for provider");
			break;
		}
		Element.verifyElementPresent(btnSave,"Save button");
		Element.verifyElementPresent(btnCancel,"Cancel button");
		Element.verifyElementPresent(btnDelete,"Delete user button");
		Helper.compareEquals(testConfig, "Comparing Manage user page title for different users", title, testConfig.driver.getTitle());
	}

}

