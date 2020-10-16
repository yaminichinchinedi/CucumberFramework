package main.java.pageObjects;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.nativeFunctions.DataProvider;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.reporting.Log;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.Utils.ViewPaymentsDataProvider;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty9.server.session.DatabaseAdaptor;

public class PopularFaq {

	private WebDriver driver;
	private TestBase testConfig;
	
	@FindBy(xpath="//*[@id=\"signInForm\"]//h2['Popular FAQs']")
	WebElement popularFaqTitle;
	
	@FindBy(linkText="What is Optum Pay and why should I sign up?")
	WebElement what_is_OptumPay_why;

	@FindBy(linkText="What payment options are available?")
	WebElement what_payment_options_available;

	@FindBy(linkText="Which Payers are using Optum Pay to make electronic payments?")
	WebElement which_payer_using_OptumPay;

	@FindBy(linkText="Can we sign up for Optum Pay if our organization uses a billing service/3rd party billing service practice management?")
	WebElement can_we_signup;

	@FindBy(linkText="Who can access my information and how do I manage users?")
	WebElement who_can_access_manage_user;

	@FindBy(linkText="How can I easily identify Member/Patient payments from healthcare payments?")
	WebElement identify_healthcare_payments;

	@FindBy(linkText="How do I add my Billing/Practice Management Service to my Optum Pay account?")
	WebElement howto_add_bpms;

	@FindBy(linkText="What happens if I don't approve the request to associate my Account with my Billing Service Account?")
	WebElement if_donot_approve;

	@FindBy(linkText="What is a Virtual Card Payment?")
	WebElement what_is_vcp;
	
	@FindBy(linkText="What is the benefit of a virtual card payment?")
	WebElement what_is_the_benefit_of_vcp;

	
	@FindBy(className="button")
	WebElement viewAllFaqsButton;

	@FindBy(className="white-header__link")
	List<WebElement> tab_faq;
	

	@FindBy(id="what-is-OptumPay-why")
	WebElement faq_page_what_is_OptumPay_why;
	
	@FindBy(id="what-payment-options-available")
	WebElement faq_page_what_payment_options_available;
	
	@FindBy(id="which-payer-using-OptumPay")
	WebElement faq_page_which_payer_using_OptumPay;
	
	@FindBy(id="can-we-signup")
	WebElement faq_page_can_we_signup;

	@FindBy(id="who-can-access-manage-user")
	WebElement faq_page_who_can_access_manage_user;
	
	@FindBy(id="identify-healthcare-payments")
	WebElement faq_page_identify_healthcare_payments;
	
	@FindBy(id="howto-add-bpms")
	WebElement faq_page_howto_add_bpms;
	
	@FindBy(id="if-donot-approve")
	WebElement faq_page_if_donot_approve;
	
	@FindBy(id="what-is-vcp")
	WebElement faq_page_what_is_vcp;
	
	@FindBy(id="what-is-the-benefit-of-vcp")
	WebElement faq_page_what_is_the_benefit_of_vcp;
	
	public PopularFaq(TestBase testConfig)
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
	}
	
	public void verifyPopularFAQSectionPresent()
	{
		Element.verifyElementPresent(popularFaqTitle, "Popular FAQs Title");
	}
	
	public void verifyAllLinksPresent()
	{
		Element.verifyElementPresent(what_is_OptumPay_why, "What is Optum Pay and why should I sign up?" );
		Element.verifyElementPresent(what_payment_options_available, "What payment options are available?");
		Element.verifyElementPresent(which_payer_using_OptumPay, "Which Payers are using Optum Pay to make electronic payments?");
		Element.verifyElementPresent(can_we_signup, "Can we sign up for Optum Pay if our organization uses a billing service/3rd party billing service practice management?");
		Element.verifyElementPresent(who_can_access_manage_user, "Who can access my information and how do I manage users?");
		Element.verifyElementPresent(identify_healthcare_payments, "How can I easily identify Member/Patient payments from healthcare payments?");
		Element.verifyElementPresent(howto_add_bpms, "How do I add my Billing/Practice Management Service to my Optum Pay account?");
		Element.verifyElementPresent(if_donot_approve, "What happens if I don't approve the request to associate my Account with my Billing Service Account?");
		Element.verifyElementPresent(what_is_vcp, "What is a Virtual Card Payment?");
		Element.verifyElementPresent(what_is_the_benefit_of_vcp, "What is the benefit of a virtual card payment?");
	}

	public void viewAllFaqButtonAvailable()
	{
		Element.verifyElementPresent(viewAllFaqsButton, "View All Faqs button");
		Element.click(viewAllFaqsButton, "View All FAQs click");
	}

	public void linkRedirectToFaq()
	{
		Element.verifyElementPresent(tab_faq.get(3), "FAQ tab");

		Element.verifyElementPresent(faq_page_what_is_OptumPay_why, "Redirected: What is Optum Pay and why should I sign up?" );
		Element.verifyElementPresent(faq_page_what_payment_options_available, "Redirected: What payment options are available?");
		Element.verifyElementPresent(faq_page_which_payer_using_OptumPay, "Redirected: Which Payers are using Optum Pay to make electronic payments?");
		Element.verifyElementPresent(faq_page_can_we_signup, "Redirected: Can we sign up for Optum Pay if our organization uses a billing service/3rd party billing service practice management?");
		Element.verifyElementPresent(faq_page_who_can_access_manage_user, "Redirected: Who can access my information and how do I manage users?");
		Element.verifyElementPresent(faq_page_identify_healthcare_payments, "Redirected: How can I easily identify Member/Patient payments from healthcare payments?");
		Element.verifyElementPresent(faq_page_howto_add_bpms, "Redirected: How do I add my Billing/Practice Management Service to my Optum Pay account?");
		Element.verifyElementPresent(faq_page_if_donot_approve, "Redirected: What happens if I don't approve the request to associate my Account with my Billing Service Account?");
		Element.verifyElementPresent(faq_page_what_is_vcp, "Redirected: What is a Virtual Card Payment?");
		Element.verifyElementPresent(faq_page_what_is_the_benefit_of_vcp, "Redirected: What is the benefit of a virtual card payment?");	
	}
}