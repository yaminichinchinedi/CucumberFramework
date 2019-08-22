package main.java.pageObjects;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import main.java.Utils.Helper;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderContentValidation {

	protected TestBase testConfig;

	@FindBy(xpath = "//span[@class='progress-indicator__circle']")
	List<WebElement> OrgCircle;

	@FindBy(xpath = "//span[@class='progress-indicator__title']")
	List<WebElement> OrgInfoHeaders;
	
	//@FindBy(xpath = "//span[@class='progress-indicator__title']")
	//List<WebElement> OrgInfoHeadersBS;
	
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();
	
	public HeaderContentValidation(TestBase testConfig) throws IOException 
	{
		String expectedURL = "/validateefteraproviderinfo";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
			expectedURL="/validateBSSubmit";
	
		
//		Browser.waitTillSpecificPageIsLoaded(testConfig, testConfig.getDriver().getTitle());
		
//		Browser.verifyURL(testConfig, expectedURL);
	}
	
	public void verifyHeadersFunctionality(List<String> headers,String BoldFontwthCircle)
	{
		List<WebElement> Headers;
		int indexOfBold=headers.indexOf(BoldFontwthCircle);
		//if(enrollmentInfoPageObj.getEnrollType().equals("HO"))
			Headers=OrgInfoHeaders;
		//else
			//Headers=OrgInfoHeadersBS;
		if (Headers.size()==0)
		Log.Fail("Unable to locate Headers path.");
		for (int i = 0; i < (Headers.size()); i++) {
			if ( !(Headers.get(i).getText().replace("\n", " ")).equalsIgnoreCase(BoldFontwthCircle) 
					&& headers.get(i).equalsIgnoreCase((Headers.get(i).getText().replace("\n", " "))))
				Helper.compareEquals(testConfig, "font weight for "+ (Headers.get(i).getText().replace("\n", " "))+ " Information is:", "400", Headers.get(i).getCssValue("font-weight"));
				
			if ((Headers.get(i).getText().replace("\n", " ")).equalsIgnoreCase(BoldFontwthCircle)&& OrgCircle.get(i).isDisplayed() == true)
				Helper.compareEquals(testConfig,"Bold font with circle is present for "+ (Headers.get(i).getText().replace("\n", " ")), "900",Headers.get(i).getCssValue("font-weight"));		
			if(i<=indexOfBold)
				Helper.compareEquals(testConfig,"Color Value for "+ (Headers.get(i).getText().replace("\n", " ")) + " Information is:","#e87722",Color.fromString(Headers.get(i).getCssValue("color")).asHex());
			else
				Helper.compareEquals(testConfig,"Color Value for "+ (Headers.get(i).getText().replace("\n", " ")) + " Information is:","#999999",Color.fromString(Headers.get(i).getCssValue("color")).asHex());
		}
	}
	
	public  HeaderContentValidation verifyHeaders(String BoldFontwthCircle) {

	     List<String> headersAV = Arrays.asList("Organization Information","Identify Administrators", "Financial Institution Information","Select Payment Methods", "Upload W9", "Review and Submit","Enrollment Submitted");
		 List<String> headersAO = Arrays.asList("Organization Information","Identify Administrators", "Financial Institution Information", "Upload W9", "Review and Submit","Enrollment Submitted");
		 List<String> headersVO = Arrays.asList("Organization Information","Identify Administrators", "Upload W9", "Review and Submit","Enrollment Submitted");
		 List<String> headersBS = Arrays.asList("Billing Service Information","Identify Administrators", "Upload W9", "Review and Submit","Enrollment Submitted");
			
		 
		 switch(enrollmentInfoPageObj.getTinIdentifier())
		 {
		 case "AV":
			 verifyHeadersFunctionality(headersAV,BoldFontwthCircle);
			 break;

		 case "AO":
			 verifyHeadersFunctionality(headersAO,BoldFontwthCircle);
			 break;			 
		 case "VO":
			 verifyHeadersFunctionality(headersVO,BoldFontwthCircle);
			 break;			 

		 default:
			 verifyHeadersFunctionality(headersBS,BoldFontwthCircle);
			 break;
			 
		 }
		return this;
	}
	
	
}
