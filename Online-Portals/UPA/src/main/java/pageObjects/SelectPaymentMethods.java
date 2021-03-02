package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPaymentMethods {
	
private TestBase testConfig;
	
	@FindBy(linkText="CONTINUE")
	WebElement btnContinue;

	@FindBy(xpath=".//*[@id='EFTERAregForm']//td[1]//tr[5]/td[2]/select")
	WebElement drpPaytyp;
	
	@FindBy(linkText="terms and conditions.")
	WebElement lnkTrmsCndtn;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']//div[1]/p[4]/a")
	WebElement lnkOptnToChoose;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']/div[3]/div[1]")
	WebElement divTrmsCndtn;
	
	@FindBy(linkText="CLOSE")
	WebElement lnkClose;
	
	@FindBy(linkText="CLOSE TIP")
	WebElement lnkClosTip;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']/div[2]/div[1]")
	WebElement divOptnToChoose;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']/div[4]/div[1]")
	WebElement divCanclEnrlmnt;
	
	@FindBy(linkText="CANCEL ENROLLMENT")
	WebElement btnCanclEnrlmnt;
	
	@FindBy(linkText="NO")
	WebElement btnNo;
	
	@FindBy(linkText="YES")
	WebElement btnYes;
	
	@FindBy(linkText="BACK")
	WebElement btnBack;
	
	@FindBy(xpath="//fieldset/div")
	List<WebElement> divPara;
	
	@FindBy(xpath="//div[3]/div")
	List<WebElement> divTrmNCondtn;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']/div[2]/div[1]")
	List<WebElement> divOptn2Choose;
	
	@FindBy(xpath="//fieldset/legend")
	WebElement header;
	
	@FindBy(xpath="//form[@id='EFTERAregForm']//div[2]")
	List<WebElement> tblPayer;
	
	public SelectPaymentMethods(TestBase testConfig) 
	{
		String expectedURL = "/validateEFTERAFinancialInfo";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		Browser.verifyURL(testConfig, expectedURL);
	}

	public void chooseACHVCP()
	{
		drpPaytyp=Element.findElement(testConfig, "xpath", "//form[@id='EFTERAregForm']//div[2]//table//tr/td[1]//tr[1]/td[2]/select");
		Element.selectVisibleText(drpPaytyp, "VCP", "Choose VCP Option");
	}
	
	public UploadW9 clickContinue() {
		chooseACHVCP();
		Browser.wait(testConfig, 2);
		Element.clickByJS(testConfig, btnContinue, "Continue");
		return new UploadW9(testConfig) ;
	}
	
	public SelectPaymentMethods clickTrmsCondtn()
	{
		Element.click(lnkTrmsCndtn, "Terms and Condition link");
		Element.verifyElementPresent(divTrmsCndtn, "Terms and Condition Div");
		Element.click(lnkClose, "Close tip");
		Element.verifyElementNotPresent(divTrmsCndtn, "Terms and Condition Div");
		return this;
	}
	
	public SelectPaymentMethods clickPaymntChooseLnk()
	{
		Element.click(lnkOptnToChoose, "Which Payment option should i choose link");
		Element.verifyElementPresent(divOptnToChoose, "Which Payment option should i choose Div");
		Element.click(lnkClosTip, "Close tip");
		Element.verifyElementNotPresent(divOptnToChoose, "Which Payment option should i choose Div");
		return this;
	}
	
	public SelectPaymentMethods clickCanclEnrlmnt()
	{
		Element.click(btnCanclEnrlmnt, "Cancel Enrollment Button");
		Element.verifyElementPresent(divCanclEnrlmnt, "Cancel Enrollment Div");
		return this;
	}
	
	public SelectPaymentMethods clickNoCanclEnrlmnt()
	{
		String expectedURL = "/validateEFTERAFinancialInfo";
		Element.click(btnNo, "NO Button on Cancel Enrollment");
		Element.verifyElementNotPresent(divCanclEnrlmnt, "Cancel Enrollment Div");
		Browser.verifyURL(testConfig, expectedURL);
		return this;
	}
	
	public UPARegistrationPage clickYesCanclEnrlmnt()
	{
		Element.click(btnYes, "YES Button on Cancel Enrollment");
		return new UPARegistrationPage(testConfig);
	}
	
	public FinancialInstitutionInfoPage clickBackToFIIOrg()
	{
		Element.click(btnBack, "BACK button");
		return new FinancialInstitutionInfoPage(testConfig);
	}
	
	public FinancialInstitutionInfoPageNPI clickBackToFIINPI()
	{
		Element.click(btnBack, "BACK button");
		return new FinancialInstitutionInfoPageNPI(testConfig);
	}
	
	public SelectPaymentMethods verifyPageContent() throws IOException
	{
		int sqlRowNo=178;
		HashMap<Integer,HashMap<String,String>> pageData=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		
		
		Helper.compareEquals(testConfig, "Header",pageData.get(21).get("TEXT_VAL") , header.getText());
		Helper.compareEquals(testConfig, "Paragraph",pageData.get(20).get("CLOBVAL") , divPara.get(0).findElements(By.tagName("p")).get(0).getText());
		Helper.compareEquals(testConfig, "Paragraph",pageData.get(19).get("CLOBVAL").replaceAll("<.*>", "") , divPara.get(0).findElements(By.tagName("p")).get(1).getText());
		Helper.compareEquals(testConfig, "Paragraph",pageData.get(18).get("CLOBVAL").replaceAll("<.*>", "") , 
				divPara.get(0).findElements(By.tagName("p")).get(2).getText()+divPara.get(0).findElements(By.tagName("p")).get(3).getText());
		
		Element.click(lnkTrmsCndtn, "Terms and Condition");
		Helper.compareEquals(testConfig, "Terms and Condition Div",pageData.get(5).get("TEXT_VAL") ,divTrmNCondtn.get(0).findElements(By.tagName("div")).get(0).getText());
		Helper.compareEquals(testConfig, "Terms and Condition Div",pageData.get(4).get("CLOBVAL") ,divTrmNCondtn.get(0).findElements(By.tagName("div")).get(1).getText());
		Element.click(lnkClose, "Close Link");
		Element.click(lnkOptnToChoose, "How to Choose Payment Option");
		Helper.compareEquals(testConfig, "How to choose Payment Method",pageData.get(14).get("TEXT_VAL") ,divOptn2Choose.get(0).findElements(By.tagName("div")).get(0).getText());
		Helper.compareEquals(testConfig, "How to choose Payment Method",pageData.get(13).get("CLOBVAL").replaceAll("</?strong>", "")+"\n"+pageData.get(12).get("CLOBVAL").replaceAll("</?strong>", "")+"\n"+
				pageData.get(11).get("CLOBVAL")+"\n"+pageData.get(10).get("CLOBVAL")+"\n"+pageData.get(9).get("CLOBVAL")+"\n"+
				pageData.get(8).get("CLOBVAL")+"\n"+pageData.get(7).get("TEXT_VAL")+"\n"+pageData.get(6).get("TEXT_VAL")
				,divOptn2Choose.get(0).findElements(By.tagName("div")).get(1).getText());
		Element.click(lnkClosTip, "Close Tip");
		Element.click(btnCanclEnrlmnt, "Cancel Enrollment");
		Helper.compareEquals(testConfig, "Cancel Enrollment",pageData.get(3).get("TEXT_VAL")+"\n"+pageData.get(2).get("TEXT_VAL")
				+"\n"+pageData.get(1).get("TEXT_VAL")+"\nYES NO",divCanclEnrlmnt.getText());
		Element.click(btnNo, "No Button on cancel enrollment");
		Helper.compareEquals(testConfig, "Table Header",pageData.get(17).get("TEXT_VAL"),tblPayer.get(0).findElement(By.tagName("h4")).getText());
		Helper.compareEquals(testConfig, "Table Header",pageData.get(16).get("TEXT_VAL"),tblPayer.get(0).findElements(By.tagName("th")).get(0).getText());
		Helper.compareEquals(testConfig, "Table Header",pageData.get(15).get("TEXT_VAL"),tblPayer.get(0).findElements(By.tagName("th")).get(1).getText());
		return this;
	}
	
	public SelectPaymentMethods verifyPayerList() throws IOException
	{
		HashMap<Integer,HashMap<String, String>> map=null;
		List<String> AVPayr=new ArrayList<String>();
		List<String> ACHPayr=new ArrayList<String>();
		List<String> expectedPayr=new ArrayList<String>();
		ArrayList<String> actualPayrLst=new ArrayList<String>();
		
		int sqlRowNo=179;
		testConfig.putRunTimeProperty("ofrCod1", "001");
		testConfig.putRunTimeProperty("ofrCod2", "002");
		map=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		ACHPayr=map.values().stream().flatMap(x->x.values().stream()).collect(Collectors.toList());
		testConfig.putRunTimeProperty("ofrCod1", "004");
		testConfig.putRunTimeProperty("ofrCod2", "006");
		map=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		AVPayr=map.values().stream().flatMap(x->x.values().stream()).collect(Collectors.toList());
		
		sqlRowNo=180;
		map=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		expectedPayr=map.values().stream().flatMap(x->x.values().stream()).collect(Collectors.toList());
		
		int i;
		String PayrNm,OfrCd;
		int size=tblPayer.get(0).findElements(By.tagName("td")).get(0).findElements(By.tagName("td")).size();
		for (i =0;i<size;i++)
			if(i%2==0)
			{
				PayrNm=tblPayer.get(0).findElements(By.tagName("td")).get(0).findElements(By.tagName("td")).get(i).getText();
				OfrCd=tblPayer.get(0).findElements(By.tagName("td")).get(0).findElements(By.tagName("td")).get(i+1).getText().replaceAll("\n", "");
				actualPayrLst.add(PayrNm);
				if(ACHPayr.contains(PayrNm))
					Helper.compareEquals(testConfig, "Offer Code for "+PayrNm, "ACH", OfrCd);
				else if(AVPayr.contains(PayrNm))
					Helper.compareEquals(testConfig, "Offer Code for "+PayrNm, "ACH         VCP", OfrCd);
			}
		for (i =0;i<size;i++)
			if(i%2==0)
			{
				PayrNm=tblPayer.get(0).findElements(By.tagName("td")).get(49).findElements(By.tagName("td")).get(i).getText();
				OfrCd=tblPayer.get(0).findElements(By.tagName("td")).get(49).findElements(By.tagName("td")).get(i+1).getText().replaceAll("\n", "");
				actualPayrLst.add(PayrNm);
				if(ACHPayr.contains(PayrNm))
					Helper.compareEquals(testConfig, "Offer Code  for "+PayrNm, "ACH", OfrCd);
				else if(AVPayr.contains(PayrNm))
					Helper.compareEquals(testConfig, "Offer Code for "+PayrNm, "ACH         VCP", OfrCd);
			}
		
		Helper.compareEquals(testConfig, "Payers List", expectedPayr, actualPayrLst);
		return this;
	}
	
}
