package main.java.pageObjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

public class SearchTinPageOptmPaySoln {

	
	
	@FindBy(name="taxIndNbr") 
	public WebElement txtboxTinNo;
	
	@FindBy(name="btnSubmit")
	public WebElement btnSubmit;
	@FindBy(name="btnSearch")
	public WebElement btnSearch;
	
	private TestBase testConfig;
	private ViewPaymentsDataProvider dataProvider;

	public SearchTinPageOptmPaySoln(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(testConfig.driver, this);
    }

	public SearchTinPageOptmPaySoln enterTinAndSrch(String userType) {
		switch (userType)
		{
			case "PROV": //This case comes from CSR for providers to Enter TIN, not UPA flow
				Browser.wait(testConfig, 2);
				Element.enterDataByJS(testConfig,txtboxTinNo, testConfig.getRunTimeProperty("tin"), "tin textbox");
			    Element.clickByJS(testConfig,btnSubmit, "Search Button");
				break;
			case "BS": 
				Browser.wait(testConfig, 1);
				Element.enterDataByJS(testConfig,txtboxTinNo, testConfig.getRunTimeProperty("tin"), "tin textbox");
				Element.clickByJS(testConfig,btnSearch, "Search Button");
				break;
			}
		return this;
		
	}
	
	public  OptumPaySolution changeToOptumPaySolutionPage() {
		testConfig.driver.getTitle().trim();
		return new OptumPaySolution(testConfig);
	}
	
}

