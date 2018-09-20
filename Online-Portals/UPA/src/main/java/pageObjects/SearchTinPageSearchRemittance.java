package main.java.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.ViewPaymentsDataProvider;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

public class SearchTinPageSearchRemittance extends TestBase{
	
	private ViewPaymentsDataProvider dataProvider;
	
	@FindBy(name="providerTIN")
	public WebElement txtboxTinNo;
	
	@FindBy(name="btnSubmit")
	public WebElement btnSubmit;
	
	//private TestBase testConfig;
	
	public SearchTinPageSearchRemittance(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(testConfig.driver, this);
	  Element.verifyElementPresent(txtboxTinNo, "Enter Tin Text Box is present");
    }
	
	public SearchTinPageSearchRemittance enterTin(String paymentType)
    {
      Element.enterData(txtboxTinNo, getTin(paymentType), "Enter Tin to proceed for View Payments", "Tin Textbox");
      return this;
    }
	
	public SearchRemittanceSearchCriteria clickSearchBtn()
    {
      Element.click(btnSubmit, "Search Button");
      return new SearchRemittanceSearchCriteria(testConfig);
    }
	
	public String getTin(String paymentType)
	{
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		return dataProvider.getTinForPaymentType(paymentType);
	}

}