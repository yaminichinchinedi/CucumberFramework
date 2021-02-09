package main.java.pageObjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.ViewPaymentsDataProvider;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

public class SearchTinPageOptmPaySoln {

	
	
	@FindBy(name="taxIndNbr")
	public WebElement txtboxTinNo;
	
	@FindBy(name="btnSubmit")
	public WebElement btnSubmit;
	
	private TestBase testConfig;
	private ViewPaymentsDataProvider dataProvider;

	public SearchTinPageOptmPaySoln(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(testConfig.driver, this);
    }
	
	
	public SearchTinPageOptmPaySoln enterTin(String paymentType)
    {
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		String tin="";//dataProvider.getTinForPaymentType(paymentType);
		
		Element.enterData(txtboxTinNo, tin, "Enter Tin to proceed for Optum Pay Solutions", "Tin Textbox");
      return this;
    }
	
	
	public OptumPaySoln clickSearchBtn()
    {
      Element.clickByJS(testConfig,btnSubmit, "Search Button");
      return new OptumPaySoln(testConfig);
    }
	
	
}
