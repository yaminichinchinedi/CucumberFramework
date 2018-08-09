package main.java.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.Utils.ViewPaymentsDataProvider;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

public class SearchTinPageViewPayments extends TestBase{
	
	private ViewPaymentsDataProvider dataProvider;
	
	@FindBy(xpath=".//*[@id='navigateToProviderForm']/table/tbody/tr[2]/td/table[1]/tbody/tr/td[2]/input")
	public WebElement txtboxTinNo;
	
	@FindBy(xpath=".//*[@id='navigateToProviderForm']/table/tbody/tr[2]/td/table[2]/tbody/tr/td[2]/input")
	public WebElement btnSubmit;
	
	//private TestBase testConfig;
	
	public SearchTinPageViewPayments(TestBase testConfig)
    {
      this.testConfig=testConfig;
	  PageFactory.initElements(testConfig.driver, this);
	  Element.verifyElementPresent(txtboxTinNo, "Enter Tin Text Box is present");
    }
	
	public SearchTinPageViewPayments enterTin(String tin)
    {
      Element.enterData(txtboxTinNo, tin, "Enter Tin to proceed for View Payments", "Tin Textbox"); //need to fill tin here
      return this;
    }
	
	public paymentSummary clickSearchBtn()
    {
      Element.click(btnSubmit, "Search Button");
      return new paymentSummary(testConfig);
    }
	
	public String getTin(String paymentType)
	{
		dataProvider=new ViewPaymentsDataProvider(testConfig);
		return dataProvider.getTinForPaymentType(paymentType);
	}

}