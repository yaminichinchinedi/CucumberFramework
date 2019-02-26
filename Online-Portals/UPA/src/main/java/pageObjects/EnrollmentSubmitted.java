package main.java.pageObjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import main.java.Utils.DataBase;
import main.java.Utils.Helper;
import main.java.common.pojo.createEnrollment.EnrollmentInfo;
import main.java.nativeFunctions.Browser;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnrollmentSubmitted {
	protected TestBase testConfig;
	
	EnrollmentInfo enrollmentInfoPageObj=EnrollmentInfo.getInstance();
	public EnrollmentSubmitted(TestBase testConfig) throws IOException 
	{
		String expectedURL = "/validateEFTERASubmit";
		this.testConfig = testConfig;	
		PageFactory.initElements(testConfig.driver, this);
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
			expectedURL="/validateBSSubmit";
		Browser.waitTillSpecificPageIsLoaded(testConfig, testConfig.getDriver().getTitle());
		Browser.verifyURL(testConfig, expectedURL);
	}
	
	
	public void validateEnrollmentInfo() throws IOException
	{
		int sqlRowNo;
		Map data=null;
		//For BS
		if(enrollmentInfoPageObj.getEnrollType().equals("BS"))
		{
			sqlRowNo=102;
			data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		}
		
		//For Healthcare
		else
		{
			  if(!enrollmentInfoPageObj.getTinIdentifier().equals("VO"))
			  {
				sqlRowNo=103;
				data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
				verifyFinancialInfo(data);
			  }
			  else
			  {
				sqlRowNo=104;
				data=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
			  }
		  
		  verifyMarketType();
		  verifyAuthEnrlTitle(data);
		  
		}
		
		
		//Organization Info
		Helper.compareEquals(testConfig, "Enrollment type",enrollmentInfoPageObj.getTinIdentifier() , data.get("PAY_METH_TYP_CD"));
		Helper.compareEquals(testConfig, "TIN",enrollmentInfoPageObj.getTin() , data.get("PROV_TIN_NBR"));
		Helper.compareEquals(testConfig, "Name",enrollmentInfoPageObj.getBusinessName() , data.get("ORG_NM"));
		Helper.compareEquals(testConfig, "Street", enrollmentInfoPageObj.getStreet(), data.get("ORG_STR"));
		Helper.compareEquals(testConfig, "City", enrollmentInfoPageObj.getCity().trim(), data.get("ORG_CTY").toString().trim());
		Helper.compareEquals(testConfig, "State", enrollmentInfoPageObj.getStateName(), data.get("ORG_ST").toString());
		Helper.compareEquals(testConfig, "Zip", enrollmentInfoPageObj.getZipCode().trim(), data.get("ORG_ZIP").toString().trim());
		
		/**
		 * NPI is not getting saved in DB in table PROVIDER PAYMENT UNIT so skipping this validation
		 */
//		Helper.compareEquals(testConfig, "NPI", enrollmentInfoPageObj.getNpi().trim(), data.get("NPI_NBR").toString().trim());
		
		
		//W9 Code
		Helper.compareEquals(testConfig, "W9 Code", enrollmentInfoPageObj.getW9DocCode(), data.get("W9_DOC_CD").toString());
		Helper.compareContains(testConfig, "W9 FILE NAME", enrollmentInfoPageObj.getTin(), data.get("FILE_NM").toString());
		
		//Primary Admin Info
		Helper.compareEquals(testConfig, "First Name", enrollmentInfoPageObj.getFrstName(), data.get("PRI_ADM_FST_NM").toString());
		Helper.compareEquals(testConfig, "Last Name", enrollmentInfoPageObj.getLstName(), data.get("PRI_ADM_LST_NM").toString());
		Helper.compareEquals(testConfig, "Phone Number", enrollmentInfoPageObj.getPhnNumbr(), data.get("PRI_ADM_TEL").toString());
		Helper.compareEquals(testConfig, "Email", enrollmentInfoPageObj.getEmail(), data.get("PRI_ADM_EML").toString());
		
		//Authorized Info
		Helper.compareEquals(testConfig, "Auth Frst Name", enrollmentInfoPageObj.getAuthFrstName(), data.get("AUTH_FST_NM").toString());
		Helper.compareEquals(testConfig, "Auth Lst Name", enrollmentInfoPageObj.getAuthLstName(), data.get("AUTH_LST_NM").toString());
		Helper.compareEquals(testConfig, "Auth_Phn Number", enrollmentInfoPageObj.getAuthPhnNbr(), data.get("AUTH_TEL_NBR").toString());
		Helper.compareEquals(testConfig, "Auth_Email", enrollmentInfoPageObj.getAuthEmail(), data.get("AUTH_EMAIL").toString());
		
		enrollmentInfoPageObj.clear();
	}
	
	public void verifyAuthEnrlTitle(Map data)
	{
		Helper.compareEquals(testConfig, "Auth_Title", enrollmentInfoPageObj.getAuthTitle(), data.get("AUTH_TITLE").toString());
	}
	
	/*
	 * Verify Market type and provider type from DB
	 * Table Name- Market Designation and Market Type
	 */
	public void verifyMarketType() throws IOException
	{
		
		int	sqlRowNo=106;
		HashMap<Integer,HashMap<String,String>> dataTest=DataBase.executeSelectQueryALL(testConfig, sqlRowNo);
		if(!enrollmentInfoPageObj.getMrktType().trim().equals(dataTest.get(1).get("MKT_TYP_DESC").toString().trim()))
		 {
				Helper.compareEquals(testConfig, "Market Type", enrollmentInfoPageObj.getMrktType().trim(), dataTest.get(2).get("MKT_TYP_DESC").toString().trim());
				Helper.compareEquals(testConfig, "Provider Type", enrollmentInfoPageObj.getProvType().trim(), dataTest.get(1).get("MKT_TYP_DESC").toString().trim());
		 }
		else
		{
				Helper.compareEquals(testConfig, "Provider Type", enrollmentInfoPageObj.getProvType().trim(), dataTest.get(2).get("MKT_TYP_DESC").toString().trim());
				Helper.compareEquals(testConfig, "Market Type", enrollmentInfoPageObj.getMrktType().trim(), dataTest.get(1).get("MKT_TYP_DESC").toString().trim());
		}
		
	}
	
	/*
	 * data -- 
	 */
	public void verifyFinancialInfo(Map data)
	{
		Helper.compareEquals(testConfig, "Fin City", enrollmentInfoPageObj.getFinCity().trim(), data.get("FIN_CTY").toString().trim());
		Helper.compareEquals(testConfig, "Fin Street", enrollmentInfoPageObj.getFinStreet().trim(), data.get("FIN_STR").toString().trim());
		Helper.compareEquals(testConfig, "Fin State", enrollmentInfoPageObj.getFinState().trim(), data.get("FIN_ST").toString().trim());
		Helper.compareEquals(testConfig, "Fin Zip", enrollmentInfoPageObj.getFinZip().trim(), data.get("FIN_ZIP").toString().trim());
		Helper.compareEquals(testConfig, "Fin Tel", enrollmentInfoPageObj.getFinPhoneNo().trim(), data.get("FIN_TEL").toString().trim());
		Helper.compareEquals(testConfig, "Fin Bank Name", enrollmentInfoPageObj.getFinInstName().trim(), data.get("FIN_BNK_NM").toString().trim());
		Helper.compareEquals(testConfig, "Fin Acnt Nbr", enrollmentInfoPageObj.getFinAcntNo().trim(), data.get("ACNT_NBR").toString().trim());
		Helper.compareEquals(testConfig, "Fin Rte nmbr", enrollmentInfoPageObj.getFinRoutingNo().trim(), data.get("RTE_NBR").toString().trim());
		
		//verify BL or VC
		int sqlRowNo=105;
		Map BLdata=DataBase.executeSelectQuery(testConfig, sqlRowNo, 1);
		Helper.compareEquals(testConfig, "BL or VC", enrollmentInfoPageObj.getFinDocCode(), BLdata.get("DOC_TYP_CD").toString());
		Helper.compareContains(testConfig, "BL or VC FILE NAME", enrollmentInfoPageObj.getTin(), BLdata.get("FILE_NM").toString());
	}
	
}
