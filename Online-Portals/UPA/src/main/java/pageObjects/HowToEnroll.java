package main.java.pageObjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

public class HowToEnroll {
	
	@FindBy(xpath="//h1[contains(text(),'How to Enroll')]")
	WebElement textHowToEnroll;	
	
	@FindBy(xpath=".//*[@id='signInForm']/article/a/span[2]")
	private WebElement dwnldEPSInstructions;
	
	@FindBy(xpath=".//*[@id='signInForm']/article/div/a")
	private WebElement enrollNowBtn;
	
	@FindBy(css="a.white-header__logo.latest--optumbank-logo")
	private WebElement lnkOptumLogo;
	
	@FindBy(xpath="//p[@class='copyrights copyright__text']/span")
	private WebElement footerText;
	
	@FindBy(linkText="Download ACH/Direct Deposit Enrollment Guide")
	private WebElement downloadACHDirect;
	
	@FindBy(linkText="Download Billing Service Enrollment Guide")
	private WebElement downloadBillingService;
	
	@FindBy(linkText="Download VCP Enrollment Guide")
	private WebElement downloadVCP;
	
	@FindBy(xpath="//form[@id='signInForm']/article/p[1]")
	private WebElement para1line1text;
	
	@FindBy(xpath="//form[@id='signInForm']/article/p[2]")
	private WebElement para1line2text;
	
	@FindBy(xpath="//ul[1]//li[1]//p[1]")
	private WebElement greenTick1ParagraphText;
	
	@FindBy(xpath="//ul[1]//li[2]//p[1]")
	private WebElement greenTick2ParagraphText;
	
	@FindBy(xpath="//ul[1]//li[3]//p[1]")
	private WebElement greenTick3ParagraphText;
	
	@FindBy(xpath="//ul[1]//li[4]//p[1]")
	private WebElement greenTick4ParagraphText;
	
	@FindBy(xpath="//ul[2]//li[1]//p[1]")
	private WebElement greenTick5ParagraphText;
	
	@FindBy(xpath="//ul[2]//li[2]//p[1]")
	private WebElement greenTick6ParagraphText;
			
	@FindBy(xpath="//p[3]")
	WebElement firstParagraphAfterLastCheckMark;
	
	@FindBy(xpath="//p[5]")
	WebElement secondParagraphAfterLastCheckMark;
	
	@FindBy(xpath="//p[8]")
	WebElement thirdParagraphAfterLastCheckMark;
		
	@FindBy(xpath="//p[11]")
	WebElement fourthParagraphAfterLastCheckMark;
	
	private TestBase testConfig;
	static Map data=null;
	int sqlRowNo;
	
	public HowToEnroll(TestBase testConfig) {
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		String expectedURL="HowToEnroll.do";
		Browser.verifyURL(testConfig, expectedURL);
		
		Element.expectedWait(textHowToEnroll, testConfig, "How to Enroll", "How to Enroll");
	}
	
	public BeginEnrollment validateEnrollNowBtn() {
		Element.click(enrollNowBtn, "Enroll Now Button");
		return new BeginEnrollment(testConfig);
	}

	public void verifyOptumLogo()
	{
		
		Element.verifyElementPresent(lnkOptumLogo,"Optum Logo at header");
	}
	
	public void verifyFooter()
	
	{
		Helper.compareEquals(testConfig, "Footer Text", footerText.getText(), "Optum Pay solutions are made possible by Optum Financial, Inc. and its subsidiary Optum Bank, Inc., Member FDIC");
	}
	
	public void verifyHowToEnrollHeader()
	
	{
		Helper.compareEquals(testConfig, "How To Enroll Text", textHowToEnroll.getText(), "How to Enroll");
	}
	
	public void verifyEnrollNowButton()
	
	{
		Helper.compareEquals(testConfig, "Enroll Now button text", enrollNowBtn.getText(), "ENROLL NOW");
	}
	
	
	public void verifyEnrollmentInstructions()
	
	{
		Helper.compareEquals(testConfig, "Download ACH/Direct Deposit Enrollment Guide Text", downloadACHDirect.getText(), "Download ACH/Direct Deposit Enrollment Guide");
		Helper.compareEquals(testConfig, "Download Billing Service Enrollment Guide Text", downloadBillingService.getText(), "Download Billing Service Enrollment Guide");
		Helper.compareEquals(testConfig, "Download VCP Enrollment Guide Text", downloadVCP.getText(), "Download VCP Enrollment Guide");
	}
	
	
	
	public void verifyGreenTickMarkTexts(int paraNum)
    {

        WebElement tickele = null;
        String paraText = null;
        
        switch (paraNum)
        {
        case 1:
        {
        	tickele = greenTick1ParagraphText;
            paraText = "Determine the payment method for your organization: ACH (direct deposit) or Virtual Card Payments (VCP), based on Payer offering";
            break;
        }
        case 2:
        {
        	tickele = greenTick2ParagraphText;
            paraText = "Organization name, mailing information and tax identification number (TIN)";
            break;
        }
        
        case 3:
        {
        	tickele = greenTick3ParagraphText;
            paraText = "Contact information for your designated Optum Pay contacts";
            break;
        }
        case 4:
        {
        	tickele = greenTick4ParagraphText;
            paraText = "Banking information (for the ACH option)";
            break;
        }
        
        case 5:
        {
        	tickele = greenTick5ParagraphText;
            paraText = "Your organization's federal W-9 form";
            break;
        }
        
        case 6:
        {
        	tickele = greenTick6ParagraphText;
            paraText = "A voided check or bank letter for each account where payments will be deposited (for the ACH option)";
            break;
        }
        
        } 
     
        String text = tickele.getText();
        if (text.contains(paraText))
        Log.Pass("green tick "+paraNum + " " +"contains text" + " " + paraText);
        
        else
        Log.Fail("green tick "+paraNum + " " + "does not contains text" + " " + paraText);
        
    }
	
	public void verifyHowtoEnrollParaText(String paraName)
    {
        
        WebElement paraele = null;
        String paraText = null;
        
        
        switch (paraName)
        {
        case "Para1 line1":
        {
        	paraele = para1line1text;
            paraText = "Enrollment in Optum PayTM is secure, simple and smart";
            break;
        }
        
        
        case "Para1 line2":
        {
        	paraele = para1line2text;
            paraText = "If you are a Healthcare Organization you will need to have the following information to complete your enrollment online:";
            break;
        }
                
        case "Para1 after last check":
        {
        	paraele = firstParagraphAfterLastCheckMark;
            paraText = "If you don't have a W9, you can download the W9 form here. You can type directly into the form, save it and then upload it to complete the Optum Pay enrollment process.";
            break;
        }
        
        case "Para2 after last check":
        {
        	paraele = secondParagraphAfterLastCheckMark;
            paraText = "The Optum Pay service currently supports more than 50 Payers covering traditional medical, worker's compensations, Medicare supplement, dental, vision and behavioral health - with new Payers continually joining our electronic payment network.";
            break;
        }
        
        case "Para3 after last check":
        {
        	paraele = thirdParagraphAfterLastCheckMark;
            paraText = "After you accept the Optum Pay terms and conditions of use, we'll process your application and notify the contacts in your organization about how to log into Optum Pay for the first time.";
            break;
        }
        
        case "Para4 after last check":
        {
        	paraele = fourthParagraphAfterLastCheckMark;
            paraText = "If you are a 3rd Party Billing Service, Optum Pay now offers a secure registration process that enables you to easily connect and support all of your providers. Simply complete the online registration form and then identify the Provider TINs that you support once the registration is confirmed. Upon approval of each provider, Optum Pay will then link your provider TINs to your Billing Service Account for safe and simple access to Optum Pay.";
            break;
        }
        }
        
        
        String text = paraele.getText();
        if (text.contains(paraText))        
        Log.Pass(paraName + " " +"contains text" + " " + paraText);
        
        else        
        Log.Fail(paraName + " " + "does not contains text" + " " + paraText);
        
        
    }
    
	
	public void verifyHowToEnrollPage() 
	{
		this.verifyOptumLogo();
		this.verifyFooter();
		this.verifyHowToEnrollHeader();
		this.verifyEnrollmentInstructions();
		this.verifyEnrollNowButton();
		
	}

	
	public void verifyHowtoEnrollPara()
	{
		this.verifyGreenTickMarkTexts(1);
		this.verifyGreenTickMarkTexts(2);
		this.verifyGreenTickMarkTexts(3);
		this.verifyGreenTickMarkTexts(4);
		this.verifyGreenTickMarkTexts(5);
		this.verifyGreenTickMarkTexts(6);
		this.verifyHowtoEnrollParaText("Para1 line1");
		this.verifyHowtoEnrollParaText("Para1 line2");
		this.verifyHowtoEnrollParaText("Para1 after last check");
		this.verifyHowtoEnrollParaText("Para2 after last check");
		this.verifyHowtoEnrollParaText("Para3 after last check");
		this.verifyHowtoEnrollParaText("Para4 after last check");
		
			
	}
	
	public void verifyHowToEnrollpage() {
		
		verifyHowToEnrollPage();
		verifyHowtoEnrollPara();
		verifyEnrollmentInstructions();
		
	}
	
	public void verifyHowToEnrollpageWithDataBase() throws IOException {
		HashMap<Integer, HashMap<String, String>> pageData = DataBase.executeSelectQueryALL(testConfig, QUERY.How_To_Enroll_Page );	
		Helper.compareEquals(testConfig, "Street",pageData.get(16).get("CLOBVAL").toString().trim().substring(3, pageData.get(16).get("CLOBVAL").toString().trim().length()-4)+"\n"+
				                                  pageData.get(17).get("CLOBVAL").toString().trim().substring(3, pageData.get(17).get("CLOBVAL").toString().trim().length()-4)+"\n"+
				                                  pageData.get(18).get("CLOBVAL").toString().trim().substring(3, pageData.get(18).get("CLOBVAL").toString().trim().length()-4)+"\n"+
				                                  pageData.get(19).get("CLOBVAL").toString().trim().substring(3, pageData.get(19).get("CLOBVAL").toString().trim().length()-4), Element.findElement(testConfig, "xpath", "//form[@id='signInForm']/article/ul").getText().trim());
		
		Helper.compareEquals(testConfig, "Street",pageData.get(2).get("CLOBVAL").toString().trim()+"\n"+
                                                  pageData.get(3).get("CLOBVAL").toString().trim(), Element.findElement(testConfig, "xpath", "//form[@id='signInForm']/article/ul[2]").getText().trim());

		Helper.compareEquals(testConfig, "Street",pageData.get(4).get("CLOBVAL").toString().trim()+" "+
				                                  pageData.get(5).get("CLOBVAL").toString().trim()+" "+
                                                  pageData.get(6).get("CLOBVAL").toString().trim(), Element.findElement(testConfig, "xpath", "(//ul[@class='tile margin-bottom-alpha'][2])/following-sibling::p").getText().trim());
		
		Helper.compareEquals(testConfig, "Street",pageData.get(7).get("CLOBVAL").toString().trim().substring(3, pageData.get(7).get("CLOBVAL").toString().trim().length()-4)
                                                                                                  , Element.findElement(testConfig, "xpath", "((//ul[@class='tile margin-bottom-alpha'][2])/following-sibling::p)[3]").getText().trim());

		Helper.compareEquals(testConfig, "Street",pageData.get(8).get("CLOBVAL").toString().trim().substring(3, pageData.get(8).get("CLOBVAL").toString().trim().length()-4)
                , Element.findElement(testConfig, "xpath", "((//ul[@class='tile margin-bottom-alpha'][2])/following-sibling::p)[6]").getText().trim());
		
		Helper.compareEquals(testConfig, "Street",pageData.get(9).get("CLOBVAL").toString().trim().substring(3, 17)+"rd"+pageData.get(9).get("CLOBVAL").toString().trim().substring(30, pageData.get(9).get("CLOBVAL").toString().trim().length()-4)
                , Element.findElement(testConfig, "xpath", "((//ul[@class='tile margin-bottom-alpha'][2])/following-sibling::p)[9]").getText().trim());// To print work "3rd" correctly..string trimmed

		Helper.compareEquals(testConfig, "Street",pageData.get(11).get("CLOBVAL").toString().trim(), Element.findElement(testConfig, "xpath", "//p[@flex='gutters']/span[2]").getText().trim());


	}
	
	public void navigateToBegineEnrollpage() {
		
		Element.click(enrollNowBtn, "Enroll now button");
		Browser.wait(testConfig, 1);
		Browser.verifyURL(testConfig, "beginEnrollment.do");
		
	}
	
	
	
}