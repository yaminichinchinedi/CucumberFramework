package main.java.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ibm.db2.jcc.t4.ac;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

public class RemittanceDetail {
	private TestBase testConfig;
	
	@FindBy(xpath=".//*[@id='hideheader']/table//tr[1]/td[1]")
	WebElement verifyPageLoad;
	
	@FindBy(xpath=".//*[@id='hideheader']/table//tr[1]/td[2]/span")
	WebElement patientID;
	
	@FindBy(xpath=".//*[@id='hideheader']/table//tr[1]/td[3]/span[1]")
	WebElement subscriberID;
	
	@FindBy(xpath=".//*[@id='hideheader']/table//tr[1]/td[3]/span[2]")
	WebElement correctedID;
	
	@FindBy(xpath=".//*[@id='flow1']/table")
	List<WebElement> plbSegment;
	
	@FindBy(xpath="//div[@id='hideheader']//table//tr")
	List<WebElement> pageHeader;
	
	@FindBy(xpath="//div[@id='flow1']/table")
	List<WebElement> pageBody;
	
	@FindBy(linkText="RMK Code")
	WebElement rmkCode;	
	
	@FindBy(linkText="Adj Reason Code")
	WebElement adjCode;	
	
	List<String> actual=new ArrayList<String>();
	List<String> expected=new ArrayList<String>();
	
	
	public RemittanceDetail(TestBase testConfig)
	{
		this.testConfig=testConfig;
		PageFactory.initElements(testConfig.driver, this);
		Element.expectedWait(verifyPageLoad, testConfig, "Remittance Detail Section","Remittance Detail Section");	
	}
	
	public void verifyHoverTexts()
	{
		String expected="Patient ID : Unique ID assigned by the payer to a member,  which could also be the same as the Subscriber ID, if the subscriber is also the patient.";
		Element.mouseHoverByJS(testConfig, patientID, "Patient ID");
		WebElement popUp=Element.findElement(testConfig, "xpath", ".//*[@id='hideheader']/table//tr[1]/td[2]/span[contains(text(),PatientId)]");
		String actual=popUp.getAttribute("onmouseover");
		actual=actual.substring(23, actual.length()-9);
		Helper.compareContains(testConfig, "Patient Id tooltip", expected, actual);
		
		expected="Subscriber ID : Unique ID assigned by the payer to the subscriber/insured/primary card holder.";
		Element.mouseHoverByJS(testConfig, subscriberID, "Subscriver ID");
		popUp=Element.findElement(testConfig, "xpath", ".//*[@id='hideheader']/table//tr[1]/td[3]/span[1][contains(text(),SubscriberId)]");
		actual=popUp.getAttribute("onmouseover");
		actual=actual.substring(23, actual.length()-9);
		Helper.compareContains(testConfig, "Subscriber Id tooltip", expected, actual);
		
		expected="Corrected ID : The Subscriber/Insured ID received on the claim was not correct. The payer is returning the corrected ID assigned by the payer. This value will only display if the ID received on the claim was incorrect.";
		Element.mouseHoverByJS(testConfig, correctedID, "Corrected ID");
		popUp=Element.findElement(testConfig, "xpath", ".//*[@id='hideheader']/table//tr[1]/td[3]/span[2][contains(text(),CorrectedId)]");
		actual=popUp.getAttribute("onmouseover");
		actual=actual.substring(23, actual.length()-9);
		Helper.compareEquals(testConfig, "Corrected Id tooltip", expected, actual);
	}
	
	public void verifyPopUpforRMKCode()
	{
		Element.clickByJS(testConfig, rmkCode, "RMK CODE");
		Browser.switchToNewWindow(testConfig);
//		String expected="https://ppsp-stage2-e-csr.optumhealthfinancial.com/remarkCode.do";
//		String actual=Browser.getURL(testConfig);	
//		Helper.compareEquals(testConfig, "RMK Window URL", expected, actual);
		
		String expected="Remark Type Reason Codes";
		String actual=testConfig.driver.getTitle();
		Helper.compareEquals(testConfig, "RMK Window Title", expected, actual);
	}
	
	public void verifyPopUpforADJCode()
	{
		Element.clickByJS(testConfig, adjCode, "Adjustment Reason Code Link");
		Browser.switchToNewWindow(testConfig);
//		String expected="https://ppsp-stage2-e-csr.optumhealthfinancial.com/adjustmentCode.do";
//		String actual=Browser.getURL(testConfig);
//		Helper.compareEquals(testConfig, "RMK Window URL", expected, actual);
		
		String expected="Adjustment Reason Codes";
		String actual=testConfig.driver.getTitle();
		Helper.compareEquals(testConfig, "RMK Window Title", expected, actual);
	}
	
	public void verifyPLBAdjustment() throws IOException
	{
		List<Double> actual=new ArrayList<Double>();
		List<Double> expected=new ArrayList<Double>();
		int noOfRows=plbSegment.get(1).findElements(By.tagName("tr")).size();
		HashMap<Integer, HashMap<String, String>> remittanceDetail=DataBase.executeSelectQueryALL(testConfig, 63);
		for(int i=0;i<noOfRows-1;i++)
		{
			Double s=Double.valueOf(plbSegment.get(1).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(2).getText().substring(2));
			actual.add(s);
		}
		Collections.sort(actual);
		for(int i=1;i<=remittanceDetail.size();i++)
			expected.add(Double.valueOf(remittanceDetail.get(i).get("CLM_AMT_ALLW")));
		Collections.sort(expected);
		Helper.compareEquals(testConfig, "PLB Adjustment ", expected,actual);	
		
		verifyHeader();
	}
	
	public void verifyHeader(){
		List<String> expected = Arrays.asList("Account Number","Patient Name / Patient ID","Subscriber ID / Corrected ID","Rendering Provider","Claim #/ Claim Type","Group Policy Number/ Product Name");
		int noOfRows=pageHeader.size();
		int noOfColumns=pageHeader.get(0).findElements(By.tagName("td")).size();
		actual.clear();
		for(int j=0;j<noOfColumns;j++)
			actual.add(pageHeader.get(0).findElements(By.tagName("td")).get(j).getText().trim().replace("\n"," "));
		Helper.compareEquals(testConfig, "Row one of Header", expected, actual);
			
		expected = Arrays.asList("Date(s) of Service","Description of Service","Amount Charged","Claim / Service Adj","Prov Adj Discount","Amount Allowed","Deduct/ Coins/ Copay","Paid to Provider","Adj Reason Code","RMK Code","Patient Resp");
		noOfColumns=pageHeader.get(1).findElements(By.tagName("td")).size();
		actual.clear();
		for(int j=0;j<noOfColumns-1;j++)
			actual.add(pageHeader.get(1).findElements(By.tagName("td")).get(j).getText().trim());
		Helper.compareEquals(testConfig, "Row two of Header", expected, actual);
	}
	
	public void verifyPageRemittanceDetail() throws IOException
	{
		HashMap<Integer, HashMap<String, String>> remittanceDetail=getRemittanceDetail();
//		verifyAccountNumber(remittanceDetail).verifyPatientName(remittanceDetail).verifyClaimHash(remittanceDetail).verifySubscriberId(remittanceDetail).verifyPatientResp(remittanceDetail).verifyAmountCharged(remittanceDetail).verifyAmountAllowed(remittanceDetail).verifyAmountPaidToProvider(remittanceDetail).verifyHeader();
		verifyPatientName(remittanceDetail);
	}
	
	public HashMap<Integer, HashMap<String, String>> getRemittanceDetail() throws IOException
	{
		HashMap<Integer, HashMap<String, String>> remittanceDetail=DataBase.executeSelectQueryALL(testConfig, 69);
		return remittanceDetail;
	}
	
	
	public RemittanceDetail verifyAccountNumber(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();	
		int noOfColumns;
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='Tableheaderbold']")).size();
		for(int i=0;i<noOfRows;i++)
		{
//			noOfColumns=plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size();
//			if(noOfColumns==6 || noOfColumns==7)
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText());
		}
		for(int i=1;i<=remittanceDetail.size();i++)
			expected.add(remittanceDetail.get(i).get("PTNT_ACCT_NBR"));
		Helper.compareEquals(testConfig, "Account Number", expected, actual);
		return this;
	}
	public RemittanceDetail verifyPatientName(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
//		int noOfRows=plbSegment.get(0).findElements(By.xpath(".//tr[@class='Tableheaderbold']")).size();
		System.out.println("No of rows are: "+noOfRows);
		for(int i=0;i<noOfRows;i++)
		{
			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==6 || plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==7)
			{
				String s=plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(1).getText();
				int index=s.indexOf("/");
				actual.add(s.substring(0, index));
			}
				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
			if(remittanceDetail.get(i).get("PTNT_MIDL_NM").equals(" "))
				expected.add(remittanceDetail.get(i).get("PTNT_FST_NM")+" "+remittanceDetail.get(i).get("PTNT_LST_NM"));
			else
				expected.add(remittanceDetail.get(i).get("PTNT_FST_NM")+" "+remittanceDetail.get(i).get("PTNT_MIDL_NM")+" "+remittanceDetail.get(i).get("PTNT_LST_NM"));
		}	
		Collections.sort(expected);
		Collections.sort(actual);
		Helper.compareEquals(testConfig, "Patient Name", expected, actual);
		return this;
	}
	
	public RemittanceDetail verifyClaimHash(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='Tableheaderbold']")).size();
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==6 || plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==7)
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(4).getText());				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
				expected.add(remittanceDetail.get(i).get("CLM_NBR"));	
		Helper.compareEquals(testConfig, "Claim Hash", expected, actual);
		return this;
	}
	public RemittanceDetail verifySubscriberId(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='Tableheaderbold']")).size();
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==6 || plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==7)
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(2).getText());				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
				expected.add(remittanceDetail.get(i).get("PTNT_ID"));	
		Helper.compareEquals(testConfig, "Claim Hash", expected, actual);
		return this;
	}
	
	public RemittanceDetail verifyPatientResp(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='rowDarkbold']")).size();
		System.out.println("No Of Rows ARE: "+noOfRows);
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==12 &&
//			plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText().equals("Subtotal"))
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(10).getText().substring(1).replace(",",""));				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
			if(remittanceDetail.get(i).get("PTNT_RESP_AMT")=="")
				expected.add("0.00");
			else
				expected.add(remittanceDetail.get(i).get("PTNT_RESP_AMT"));
				
		}
		Helper.compareEquals(testConfig, "Patient Resp Amount", expected, actual);
		return this;
	}
	
	public RemittanceDetail verifyAmountCharged(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='rowDarkbold']")).size();
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==12 &&
//			plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText().equals("Subtotal"))
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(2).getText().substring(1).replace(",",""));				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
			if(remittanceDetail.get(i).get("CLM_CHRG_AMT")=="")
				expected.add("0.00");
			else
				expected.add(remittanceDetail.get(i).get("CLM_CHRG_AMT"));
				
		}
		Helper.compareEquals(testConfig, "Claim Charge Amount", expected, actual);
		return this;
	}
	
	public RemittanceDetail verifyAmountAllowed(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='rowDarkbold']")).size();
		
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==12 &&
//			plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText().equals("Subtotal"))
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(5).getText().substring(1).replace(",",""));				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
			if(remittanceDetail.get(i).get("COV_AMT")=="")
				expected.add("0.00");
			else
				expected.add(remittanceDetail.get(i).get("COV_AMT"));
				
		}
		Helper.compareEquals(testConfig, "Claim Charge Amount", expected, actual);
		return this;
	}
	
	
	public RemittanceDetail verifyAmountPaidToProvider(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='rowDarkbold']")).size();
		
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==12 &&
//			plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText().equals("Subtotal"))
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(7).getText().substring(1).replace(",",""));				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
			if(remittanceDetail.get(i).get("CLM_PAY_AMT")=="")
				expected.add("0.00");
			else
				expected.add(remittanceDetail.get(i).get("CLM_PAY_AMT"));
				
		}
		Helper.compareEquals(testConfig, "Claim Charge Amount", expected, actual);
		return this;
	}
	
	public RemittanceDetail verifyClaimDate(HashMap<Integer, HashMap<String, String>> remittanceDetail) throws IOException
	{
		actual.clear();
//		int noOfRows=plbSegment.get(0).findElements(By.tagName("tr")).size();
		int noOfRows=plbSegment.get(0).findElements(By.xpath("tr[@class='rowDarkbold']//following-sibling::")).size();
		
		for(int i=0;i<noOfRows;i++)
		{
//			if(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).size()==12 &&
//			!(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText().equals("Subtotal")))
				actual.add(plbSegment.get(0).findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(0).getText());				
		}
		for(int i=1;i<=remittanceDetail.size();i++)
		{
				expected.add(remittanceDetail.get(i).get("CLM_STRT_DT")+" "+remittanceDetail.get(i).get("CLM_END_DT"));
				
		}
		Helper.compareEquals(testConfig, "Claim Charge Amount", expected, actual);
		return this;
	}
}
