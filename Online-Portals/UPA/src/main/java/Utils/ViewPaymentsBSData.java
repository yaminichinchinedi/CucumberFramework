package main.java.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

/**
 * @author schandy
 *
 */
public class ViewPaymentsBSData {

	public TestBase testConfig;
	public HashMap<String, HashMap<String, String>> assignedTins = new HashMap<String,HashMap<String, String>>();
	public HashMap<String, List<String>> tinNewlyAssigned = new HashMap<String, List<String>>(); 
	public HashMap<String,HashMap<String, String>> userInformation = new HashMap<String,HashMap<String, String>>();
	
	public ViewPaymentsBSData(TestBase config) {
		testConfig = config;
	}
	
		
	public void initializeData()
	{


		Log.Comment("Assigning Test TIN to the given user for test cases");
		String userId = userInformation.get("bsId").toString();
		
	}
	
	
	/**
	 * This method identifies and saved the Billing Service ID and TIN for a given username
	 * @param userName The username (Optum ID) of the user
	 * */
	public void setBsIdAndTinOfBSUser( String userName) {
		
		int sqlRow = 40;
		boolean setBsID = false;
		String bsId = "";
		String associatedTins = "";

		Log.Comment("Identifying the Billing Service ID and TINs associated to the Billing Service ID");
		Object input[] = new Object[1];
		input[0] = userName;
		List<HashMap<String, String>> dbData = DataBase.executeSelectPreparedStatement(testConfig, sqlRow, input);

		for (HashMap<String, String> data : dbData) {
			if (setBsID == false) {
				bsId = data.get("BILLING_SERVICE_ID");
				setBsID = true;
			}
			associatedTins = associatedTins + data.get("PROV_TIN_NBR") + ",";
		}

		HashMap<String, String> association = new HashMap<String, String>();
		association.put("associatedTins", associatedTins);
		association.put("bsId", bsId);
		userInformation.put(userName, association);
	}
	
	
	
	/**
	 * This method is called to identify the TINs for all possible test cases
	 * The mapped values can be used for user TIN association later
	 * @return No return value
	 */
	public void identifyTINsForAllViewPaymentTestCases()
	{
		Log.Comment("Starting: Identifying TIN's for Test Cases");
		
		identifyTINForAssociation("AllDays",  0, 0, 30, 10, "ALL");
		identifyTINForAssociation("TIN",  0, 0, 90, 10, "TIN");
		identifyTINForAssociation("NPI",  0, 0, 90, 30, "NPI");
		identifyTINForAssociation("FourToSixMonths",  4, 6, 0, 10, "ALL");
		identifyTINForAssociation("SixToNineMonths",  6, 9, 0, 10, "ALL");
		identifyTINForAssociation("NineToThirteenMonths",  9, 13, 0, 10, "ALL");
		identifyTINForAssociation("Dental",  0, 0, 0, 0, "Dental");
		identifyTINForAssociation("ZeroAch",  0, 0, 0, 0, "ZeroAch");
		identifyTINForAssociation("ZeroVcp",  0, 0, 0, 0, "ZeroVcp");
		identifyTINForAssociation("Pagination",  0, 0, 90, 0, "Pagination");
		identifyTINForAssociation("ArchiveActiveOnly",  0, 0, 90, 0, "ArchiveActiveOnly");
		identifyTINForAssociation("RemitACH",  0, 0, 90, 0, "RemitACH");
		identifyTINForAssociation("RemitVCP",  0, 0, 90, 0, "RemitVCP");
		identifyTINForAssociation("RemitCHK",  0, 0, 90, 0, "RemitCHK");
		identifyTINForAssociation("Failed", 0, 0, 90, 0, "Failed");
		
		Log.Comment("Completed : Identifying TIN's for Test Cases");
	}
	
	
	/**
	 * Method used to identify TIN for a specific Key, it sets the assignedTins variables for later reference
	 * 
	 * @param key The key to be used to retrieve the identified TIN
	 * @param startMonth To be used in date range in the query, its "From" value if search is by month 
	 * @param endMonth  To be used in date range in the query, its "To"  value if search is by month 
	 * @param numberOfDays To be used in date range in the query, its "Until"  value if search is by number of days 
	 * @param count Minimum number of occurrences in the table, value to be passed if required in query
	 * @param filter The flag used to identify the query that needs to be executed
	 * @return No return value
	 * */
	void identifyTINForAssociation(String key, int startMonth, int endMonth, int numberOfDays, int count, String filter) 
	{
		Log.Comment("Identifying TIN for "+key);
		HashMap<String,String> identifiedTinForAssociation = getTinForBsAssociationByType(startMonth, endMonth, numberOfDays, count, filter);
		
		Log.Comment("Identified TIN "+identifiedTinForAssociation.get("PROV_TAX_ID_NBR")+" for "+key);
		assignedTins.put(key, identifiedTinForAssociation);
	}
	
	
	/**
	 * This method is used to identify the SQL Query that needs to be executed and the values that needs to be passed to the query
	 * It also calls the method that retrieves the data from the database
	 *
	 * @param startMonth To be used in date range in the query, its "From" value if search is by month
	 * @param endMonth  To be used in date range in the query, its "To"  value if search is by month 
	 * @param numberOfDays To be used in date range in the query, its "Until"  value if search is by number of days 
	 * @param count Minimum number of occurrences in the table, value to be passed if required in query
	 * @param filter The flag used to identify the query that needs to be executed
	 * @return No return value
	 * */
	private HashMap<String,String> getTinForBsAssociationByType( int startMonth, int endMonth, int numberOfDays, int count,String filter) 
	{
		int sqlRow = 0;
		
		Object[] sqlParams = null;
		boolean checksDatesBackToFlag = false;

		switch (filter) 
		{
			case "NPI":
				sqlRow = 43;
				sqlParams = new Object[] { "XX" };
				break;
	
			case "TIN":
				sqlRow = 43;
				sqlParams = new Object[] {  "FI" };
				break;
	
			case "Dental":
				sqlRow = 44;
				sqlParams = null;
				break;
	
			case "ZeroAch":
				sqlRow = 45;
				sqlParams = new Object[] { "NON" };
				checksDatesBackToFlag = false;
				break;
	
			case "ZeroVcp":
				sqlRow = 45;
				sqlParams = new Object[] { "VCP" };
				checksDatesBackToFlag = false;
				break;
	
			case "Pagination":
				sqlRow = 48;
				sqlParams = null;
				break;

			case "ArchiveActiveOnly":
				sqlRow = 49;
				sqlParams = null;
				checksDatesBackToFlag = false;
				break;

			case "RemitACH":
				sqlRow = 50;
				sqlParams = new Object[] { "ACH" };
				checksDatesBackToFlag = false;
				break;

			case "RemitVCP":
				sqlRow = 50;
				sqlParams = new Object[] { "VCP" };
				checksDatesBackToFlag = false;
				break;

			case "RemitCHK":
				sqlRow = 50;
				sqlParams = new Object[] { "CHK" };
				checksDatesBackToFlag = false;
				break;

			case "Failed":
				sqlRow = 46;
				sqlParams = null;
				checksDatesBackToFlag = false;
				break;
	
			case "ALL":
				// Selects the row with time range in number of days (38), if number of days is given
				sqlRow = numberOfDays > 0 ? 38 : 39;
				count = count <= 0 ? 10 : count;
				if (sqlRow == 38) {
					sqlParams = new Object[] { numberOfDays };
				} else if (sqlRow == 39) {
					sqlParams = new Object[] { startMonth, endMonth };
				}
				checksDatesBackToFlag = false;
				break;
		}

		HashMap<String,String> newTin = runQueryAndGetTinData( sqlRow, sqlParams, checksDatesBackToFlag);
		return newTin;
	}
	
	
	/**
	 * This method retrieves the SQL query to be executed and executes it.
	 * It returns the provider TIN and date difference(depending on the flag checkDatesBackTo)
	 *  
	 *@param sqlRow The identified that identifies the sql query that needs to executed
	 *@param values The parameters used to create a prepared statemenet
	 *@param checkDatesBackTo Tells the method if the date difference is to be retrived from the result
	 *@return Returns the Prov_TAX_ID_NBR and DIFFDAYS from the query in the form of a hashmap
	 * 	 	
	 */
	public HashMap<String,String> runQueryAndGetTinData(int sqlRow, Object[] values, boolean checkDatesBackTo) {
		
		HashMap<String,String> returnData = new HashMap<String,String>();
		
		List<HashMap<String, String>> result = DataBase.executeSelectPreparedStatement(testConfig, sqlRow, values);
		
		if(result !=null )
		{
			if(result.size() > 0)
			{
				for (HashMap<String, String> data : result) {
					String dateFilter ="";
					String provTin = "";
					String tinDatesBackTo="";
					
					provTin = data.get("PROV_TAX_ID_NBR");
					
					if (checkDatesBackTo == true) {
						tinDatesBackTo = data.get("DIFFDAYS");
						dateFilter= getDateFilter(tinDatesBackTo);
					}			
					
					returnData.put("PROV_TAX_ID_NBR",provTin);
					returnData.put("DIFFDAYS",dateFilter);	
				}
				Log.Comment("Returning TIN from the database");
			}
			else {
				returnData.put("PROV_TAX_ID_NBR","");
				returnData.put("DIFFDAYS","");
				Log.Warning("No Tin found in the database", testConfig);	
			}
		}
		else 
		{
			returnData.put("PROV_TAX_ID_NBR","");
			returnData.put("DIFFDAYS","");	
			Log.Warning("No Tin found in the database", testConfig);
		}
		return returnData;		
	}

	

	/**
	 * This method is used to associate the identified user to the identified TINs
	 * */
	public void associateBillingServiceUserToTIN( )
	{
		int sqlRow = 41;
				
		Log.Comment("Associating the billing service User ID's to the TIN's identified");
		
		HashSet<String> associatedBS = new HashSet<String>();
		
		for(String username : userInformation.keySet())
		{
			HashMap<String, String> bsUserInfo = userInformation.get(username);
			String billingServiceId = bsUserInfo.get("bsId").toString();
			
			if( associatedBS.contains(billingServiceId))
			{
				//This would mean that the TINs have already been associated to the given Billing Service ID
				continue;
			}
			else
			{
				String existingTins = bsUserInfo.get("associatedTins").toString();
				Integer bsId = Integer.valueOf(billingServiceId);
	
				Log.Comment("Associating the TIN's to the user "+ username);
				
				ArrayList<String> newTinList = new ArrayList<String>();
				
				for(String key : assignedTins.keySet())
				{
					String newTin = assignedTins.get(key).get("PROV_TAX_ID_NBR");
					if(newTin == null) {
						Log.Comment("No TIN found for this test case to associate to the billing service user "+username);
					}
					else 
					{
						if(!existingTins.contains(newTin))
						{
							Object values[] = new Object[2];
							values[0] = newTin;
							values[1] = bsId;
							DataBase.executeUpdatePreparedStatement(testConfig, sqlRow, values);
							existingTins = existingTins+ newTin+",";
							newTinList.add(newTin);
							Log.Comment("Associated "+ newTin+" to the billing service user in the DB for "+username);
						}
						else {
							Log.Comment(newTin+" is already associated to the billing service user "+username);
						}
					}
				}
				tinNewlyAssigned.put(billingServiceId, newTinList);
			}
		}		
	}
	
	
	
	/**
	 * This method is called to remove the association between a given Billing Service ID and TIN
	 * 
	 * */
	public void deleteAllAssociatedTINs()
	{
		for(String bsID : tinNewlyAssigned.keySet() )
		{
			Log.Comment("Start : Removing newly added TIN Association for Billing Service ID "+bsID);
			List<String> newTins = tinNewlyAssigned.get(bsID);
			for(String tin: newTins)
			{
				if(!tin.equals(""))
				{
					Log.Comment("Start : Removing TIN "+tin);
					ExceuteDeleteBSUserToTin(tin, bsID);
					Log.Comment("Complete : Removed TIN "+tin);
				}
			}
			Log.Comment("Complete : Removing newly added TIN Association for Billing Service ID "+bsID);
		}
	}
		

	public int ExceuteDeleteBSUserToTin(String provTin, String billingServiceId) {
		int sqlRow = 42;
		Integer bsId = Integer.valueOf(billingServiceId);

		Object values[] = new Object[2];
		values[0] = provTin;
		values[1] = bsId;

		int result = DataBase.executeUpdatePreparedStatement(testConfig, sqlRow, values);
		return result;
	}
	

	public String getDateFilter(String dateDiff ) {
		String quickSearchFilter = "Last 30 days";

		Integer tinDatesBackTo =  Integer.valueOf(dateDiff);
		
		if (tinDatesBackTo <= 30) {
			quickSearchFilter = "Last 30 days";
		} else if (tinDatesBackTo <= 60) {
			quickSearchFilter = "Last 60 days";
		} else if (tinDatesBackTo <= 90) {
			quickSearchFilter = "Last 90 days";
		} else if (tinDatesBackTo <= 180 && tinDatesBackTo > 90) {
			quickSearchFilter = "Last 4-6 months";
		} else if (tinDatesBackTo <= 270 && tinDatesBackTo > 180) {
			quickSearchFilter = "Last 6-9 months";
		} else if (tinDatesBackTo <= 390 && tinDatesBackTo > 270) {
			quickSearchFilter = "Last 9-13 months";
		} else {
			System.out.println("Did not find date range, setting to last 90 days");
			quickSearchFilter = "Last 90 days";
		}

		return quickSearchFilter;

	}

	
	
}
