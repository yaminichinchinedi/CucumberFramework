package main.java.pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.java.Utils.DataBase;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class CreateMaintainEnrollment {
	
	@FindBy(id="userTypeSelection")
	WebElement drpDownUserType;
	
	
	@FindBy(xpath="//input[contains(@id,'taxNumber')]")
	List <WebElement> txtboxTinNo;
	
	
	@FindBy(name="btnSubmit")
	List <WebElement> btnSearch;
	
	
	@FindBy(id="payerdropdown")
	WebElement drpDownPayer;
	
	@FindBy(xpath="//td[contains(text(),'View Enrollment')]")
	WebElement viewEnrollment;
	
    @FindBy(xpath="//td[@align='right']//input[@value='     Edit     ']")
    WebElement btnEdit1;
    
	protected TestBase testConfig;
	

	public CreateMaintainEnrollment(TestBase testConfig) {
		this.testConfig = testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, "/enrollmentbsusertypeselection.do");
	}
	
	public CreateMaintainEnrollment()
	{
		
	}
	
	public void validateViewEnrollment() {
		String expectedURL = "validateTIN.do";
		Browser.verifyURL(testConfig, expectedURL);
		Element.verifyTextPresent(viewEnrollment, "View Enrollment");
	}
	public void selectUserType(String userType)
	{
		Element.selectByValue(drpDownUserType,userType, "User type as :" + " " + userType + " ");
	}

	public void doSearch(String userType)
	{
		int sqlRowNo;
		Map Searchedtin=null;
		String tin="";
		selectUserType(userType);
		
		switch(userType)
		{
		  case "PROV" :
		   {
			   sqlRowNo=15;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PROV_TIN_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(0), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(0), "Clicked search button");
			   break;
		   }
		   
		  case "BS" :
		   {
			   sqlRowNo=16;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("IDENTIFIER_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(1), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(2), "Clicked search button");
			   break;
		   }
		   
		  case "PAY" :
		   {
			   sqlRowNo=17;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PAYR_DSPL_NM").toString().trim();
			   Element.selectByVisibleText(drpDownPayer, tin, "Payer as :"+" " + tin );
			   Element.clickByJS(testConfig,btnSearch.get(1), "Clicked search button");
			   break;
		   }
		   
		   default:
			   break;
		}
		
		testConfig.putRunTimeProperty("tin", tin);
	}

    public void clickEditBtn()
    {
            Element.click(btnEdit1, "Edit button");

    }

	public void getTin(String userType, String tinType, String payMethodCode, String enrollmentStatusCode)
	{
		int sqlRowNo;
		Map Searchedtin=null;
		String tin="";
		selectUserType(userType);
		testConfig.putRunTimeProperty("tinType", tinType);
		testConfig.putRunTimeProperty("payMethodCode", payMethodCode);
		testConfig.putRunTimeProperty("enrollmentStatusCode", enrollmentStatusCode);
		switch(payMethodCode)
		{
		  case "ACH" :
		   {
			   sqlRowNo=403;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PROV_TIN_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(0), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(0), "Clicked search button");
			   break;
		   }
		   
		  case "NONE" :
		   {
			   sqlRowNo=406;
			   Searchedtin=DataBase.executeSelectQuery(testConfig,sqlRowNo, 1);
			   tin=Searchedtin.get("PROV_TIN_NBR").toString().trim();
			   Element.enterData(txtboxTinNo.get(0), tin,"Enter tin number as :" + " " + tin,"txtboxTinNo");
			   Element.clickByJS(testConfig,btnSearch.get(0), "Clicked search button");
			   break;
		   }
		   
		   default:
			   break;
		}
		
		testConfig.putRunTimeProperty("tin", tin);
	}

}