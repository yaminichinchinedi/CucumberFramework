package main.java.nativeFunctions;

public class DataProvider {
	
	 public static String EMAILID = "ddd";
	public  String id;
	public  String password;
	public  String optumId;
	public  String optumPwd;
	private  TestBase testConfig;
	
	
//	public static String UPA_ID_Provider_Gen_Stage2="USPROV7729";
//	public static String UPA_Pwd_Provider_Gen_Stage2="Test_123";
//	public static String UPA_OptumID_Provider_Gen_Stage2="provider5user";
//	public static String UPA_OptumPwd_Provider_Gen_Stage2="Test_123";
	
	public  String UPA_ID_Provider_Admin_Stage2="USPROV7729";
	public  String UPA_Pwd_Provider_Admin_Stage2="Test_123";
	public  String UPA_OptumID_Provider_Admin_Stage2="provider5user";
	public  String UPA_OptumPwd_Provider_Admin_Stage2="Test_123";
	
	
	
//	public static String UPA_ID_BS_Gen_Stage2="USPROV7729";
//	public static String UPA_Pwd_BS_Gen_Stage2="Test_123";
//	public static String UPA_OptumID_BS_Gen_Stage2="provider5user";
//	public static String UPA_OptumPwd_BS_Gen_Stage2="Test_123";
//	
//	public static String UPA_ID_BS_Admin_Stage2="USPROV7729";
//	public static String UPA_Pwd_BS_Admin_Stage2="Test_123";
//	public static String UPA_OptumID_BS_Admin_Stage2="provider5user";
//	public static String UPA_OptumPwd_BS_Admin_Stage2="Test_123";
	
	
	
	
	
	
	
	
	
	
	
//	
//	public static String UPA_ID_Provider_Gen_Stage="AUAUTO5896";
//	public static String UPA_Pwd_Provider_Gen_Stage="Test@12345";
//	public static String UPA_OptumID_Provider_Gen_Stage="aautomation1";
//	public static String UPA_OptumPwd_Provider_Gen_Stage="Test@12345";
//	
//	public static String UPA_ID_Provider_Admin_Stage="AUAUTO5896";
//	public static String UPA_Pwd_Provider_Admin_Stage="Test@12345";
//	public static String UPA_OptumID_Provider_Admin_Stage="aautomation1";
//	public static String UPA_OptumPwd_Provider_Admin_Stage="Test@12345";
//	
//	
//	public static String UPA_ID_BS_Gen_Stage="AUAUTO5896";
//	public static String UPA_Pwd_BS_Gen_Stage="Test@12345";
//	public static String UPA_OptumID_BS_Gen_Stage="aautomation1";
//	public static String UPA_OptumPwd_BS_Gen_Stage="Test@12345";
//	
//	public static String UPA_ID_BS_Admin_Stage="AUAUTO5896";
//	public static String UPA_Pwd_BS_Admin_Stage="Test@12345";
//	public static String UPA_OptumID_BS_Admin_Stage="aautomation1";
//	public static String UPA_OptumPwd_BS_Admin_Stage="Test@12345";
//	
	
//	public static int i=10;
//	public static String FIRSTPAGE_FIRSTNAME="TEST";
//	public static String FIRSTPAGE_LASTNAME="LAST";
//	public static String FIRSTPAGE_ADDRESSE="TESTING";
//	public static String EMAILID="EMAIL";

	
		
//	public DataProvider(TestBase testConfig,String userType, String accessType)
//	{
//		this.testConfig=testConfig;
//		String env=System.getProperty("env");
//		setUserCredentials(env,userType,accessType);
//		
//	}

	public  void setUserProperties(TestBase testConfig)
	{
		testConfig.putRunTimeProperty("id",id);
		testConfig.putRunTimeProperty("password",password);
		testConfig.putRunTimeProperty("optumId",optumId);
		testConfig.putRunTimeProperty("optumPwd",optumPwd);
	}

  public  void setUserCredentials(TestBase testConfig,String userType, String accessType)
   {            
	     String env=System.getProperty("env");
	     id="UPA_"+"ID_"+userType+"_"+accessType+"_"+env;
	     password="UPA_"+"Pwd_"+userType+"_"+accessType+"_"+env;
	     id=UPA_ID_Provider_Admin_Stage2;
	     optumId="UPA_"+"OptumID_"+userType+"_"+accessType+"_"+env;
	     optumPwd="UPA_"+"OptumPwd_"+userType+"_"+accessType+"_"+env;
		 setUserProperties(testConfig);
		
		    
		
   }
	
}