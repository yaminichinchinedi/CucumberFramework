package main.java.Utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.java.reporting.Log;
import main.java.nativeFunctions.TestBase;

public class DataBase

{
	public static Connection con;
	static Statement statement = null;
	static ResultSet rs;
	
	
	
	public enum DatabaseType
	{
		IMPL(1),Stage(2), PROD(3),Stage2(4),Automation(5), Test1(6),Test2(7);

	  public final int values;
	  
	  DatabaseType(final int value){
	  this.values = value;
		}
	};

	static Connection connection;

	public static Map<String, String> addToRunTimeProperties(TestBase testConfig, ResultSet sqlResultSet)
	{
		HashMap<String, String> mapData = new HashMap<String, String>();

		try
		{
			ResultSetMetaData meta = sqlResultSet.getMetaData();
			for (int col = 1; col <= meta.getColumnCount(); col++)
			{
				try
				{
					String columnName = meta.getColumnLabel(col);
					String columnValue = sqlResultSet.getObject(col).toString();
				

					//Code to handle TINYINT case
					if(meta.getColumnTypeName(col).equalsIgnoreCase("TINYINT"))
						columnValue = Integer.toString(sqlResultSet.getInt(col));

					mapData.put(columnName, columnValue);
				}
				catch (Exception e)
				{
					mapData.put(meta.getColumnLabel(col), "");
				}
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
			//testConfig.logException(e);
		}

		Set<String> keys = mapData.keySet();
		for (String key : keys)
		{
			testConfig.putRunTimeProperty(key, mapData.get(key));
		}
		return mapData;
	}

	/**
	 * Executes the select db query and returns complete
	 * Resultset
	 * 
	 * @param Config
	 *            test config instance
	 * @param sqlRow
	 *            row number of the 'Query' column of 'SQL' sheet of Test data
	 *            excel having the query to be executed
	 * @return ResultSet -- Complete Result which is fetched is returned
	 * @throws IOException 
	 */
	public static ResultSet executeSelectQuery(TestBase testConfig, int sqlRow, DatabaseType dbType) throws IOException
	{
		// Read the Query column of SQL sheet of Test data excel
		
		TestDataReader sqlData = testConfig.cacheTestDataReaderObject("SQL");
		String selectQuery = sqlData.GetData(sqlRow, "Query");
		selectQuery = Helper.replaceArgumentsWithRunTimeProperties(testConfig, selectQuery);
		Log.Comment("Executing the query - '" + selectQuery + "'", testConfig);
		return executeSelectQuery(testConfig, selectQuery, dbType);
	}

	
	
	public static ResultSet testExecuteSelectQuery(TestBase testConfig, String query, DatabaseType dbType) throws IOException
	{
		// Read the Query column of SQL sheet of Test data excel
		String selectQuery = query;
		selectQuery = Helper.replaceArgumentsWithRunTimeProperties(testConfig, selectQuery);
		Log.Comment("Executing the query - '" + selectQuery + "'", testConfig);
		return executeSelectQuery(testConfig, selectQuery, dbType);
	}
	/**
	 * Executes the select db query , and saves the result in
	 * Config.runtimeProperties as well as returns Map
	 * 
	 * @param Config
	 *            test config instance
	 * @param sqlRow
	 *            row number of the 'Query' column of 'SQL' sheet of Test data
	 *            excel having the query to be executed
	 * @param rowNumber
	 *            row number to be returned (use 1 for first row and -1 for last
	 *            row)
	 * @return Map containing key:value pairs of specified row
	 */
	public static Map<String, String> executeSelectQuery(TestBase testConfig, int sqlRow, int rowNumber)
	{
		// Read the Query column of SQL sheet of Test data excel
		TestDataReader sqlData = null;
		try {
			sqlData = testConfig.cacheTestDataReaderObject("SQL");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String selectQuery = sqlData.GetData(sqlRow, "Query");
		selectQuery = Helper.replaceArgumentsWithRunTimeProperties(testConfig, selectQuery);
		Log.Comment("Executing the query - '" + selectQuery + "'", testConfig);
		
		
		if(System.getProperty("Database").equalsIgnoreCase("Stage"))
          return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.Stage);
	
		 else if (System.getProperty("Database").equalsIgnoreCase("Stage2"))
	     return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.Stage2);
      
         else if (System.getProperty("Database").equalsIgnoreCase("PROD"))
	     return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.PROD);
         
         else if (System.getProperty("Database").equalsIgnoreCase("Test1"))
	     return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.Test1);
		
         else if (System.getProperty("Database").equalsIgnoreCase("Test2"))
    	 return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.Test2);
           
       
      else
	  return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.IMPL); 
}
	
	public static Map<String, String> executeSelectQuery(TestBase testConfig, String selectQuery, int rowNumber)
	{
		// Read the Query column of SQL sheet of Test data excel
		TestDataReader sqlData = null;
		try {
			sqlData = testConfig.cacheTestDataReaderObject("SQL");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectQuery = Helper.replaceArgumentsWithRunTimeProperties(testConfig, selectQuery);
		Log.Comment("Executing the query - '" + selectQuery + "'", testConfig);
		
		
		if(System.getProperty("Database").equalsIgnoreCase("Stage"))
          return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.Stage);
	
		 else if (System.getProperty("Database").equalsIgnoreCase("Stage2"))
	     return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.Stage2);
      
         else if (System.getProperty("Database").equalsIgnoreCase("PROD"))
	     return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.PROD);
         
         else if (System.getProperty("Database").equalsIgnoreCase("Test1"))
	     return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.Test1);
		
         else if (System.getProperty("Database").equalsIgnoreCase("Test2"))
    	 return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.Test2);
           
       
      else
	  return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.IMPL); 
}

	/**
	 * Executes insert query in DB
	 * @param testConfig 	test config instance
	 * @param sqlRow 		row number of sql query in excel
	 * @param dbType		type of DB
	 * @return
	 */
	
	public static int executeInsertQuery(TestBase testConfig, int sqlRow)
	{
		TestDataReader sqlData = null;
		try {
			sqlData = testConfig.cacheTestDataReaderObject("SQL");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String insertQuery = sqlData.GetData(sqlRow, "Query");
		DatabaseType dbType=null;
		dbType=getDatabaseType();
		return executeUpdateQuery(testConfig, insertQuery, dbType);
	}
	public static int executeInsertQuery(TestBase testConfig, String query)
	{
		TestDataReader sqlData = null;
		try {
			sqlData = testConfig.cacheTestDataReaderObject("SQL");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatabaseType dbType=null;
		dbType=getDatabaseType();
		return executeUpdateQuery(testConfig, query, dbType);
	}
	public static DatabaseType getDatabaseType()
	{
		DatabaseType dbType=null;
		if(System.getProperty("Database").equalsIgnoreCase("Stage"))
			dbType=DatabaseType.Stage;
			else if (System.getProperty("Database").equalsIgnoreCase("Stage2"))
			dbType=DatabaseType.Stage2;
			else if (System.getProperty("Database").equalsIgnoreCase("Test1"))
				dbType=DatabaseType.Test1;
			else if (System.getProperty("Database").equalsIgnoreCase("Test2"))
				dbType=DatabaseType.Test2;
	        else if (System.getProperty("Database").equalsIgnoreCase("PROD"))
	        dbType=DatabaseType.PROD;
	        else if (System.getProperty("Database").equalsIgnoreCase("Automation"))
		        dbType=DatabaseType.Automation;
	        else
	    	dbType=DatabaseType.IMPL; 
		return dbType;
	}


	/**
	 * Executes the select db query, and saves the result in
	 * Config.runtimeProperties as well as returns Map
	 * 
	 * @param Config
	 *            test config instance
	 * @param sqlRow
	 *            row number of the 'Query' column of 'SQL' sheet of Test data
	 *            excel having the query to be executed
	 * @param rowNumber
	 *            row number to be returned (use 1 for first row and -1 for last
	 *            row)
	 * @return Map containing key:value pairs of specified row
	 */
	public static Map<String, String> executeSelectQuery(TestBase testConfig, int sqlRow, int rowNumber, DatabaseType dbType)
	{
		// Read the Query column of SQL sheet of Test data excel
		TestDataReader sqlData = testConfig.getCachedTestDataReaderObject("SQL");
		String selectQuery = sqlData.GetData(sqlRow, "Query");
		selectQuery = Helper.replaceArgumentsWithRunTimeProperties(testConfig, selectQuery);
		Log.Comment("Executing the query - '" + selectQuery + "'", testConfig);
		return executeSelectQuery(testConfig, selectQuery, rowNumber, dbType);
	}

	/**
	 * Executes the select db query and return the complete Result Set
	 * 
	 * @param Config
	 *            test config instance
	 * @param selectQuery
	 *            query to be executed
	 * @param DatabaseType
	 *            online/offline
	 * @return Resultset
	 */

	public static ResultSet executeSelectQuery(TestBase testConfig, String selectQuery, DatabaseType dbType)
	{
		Date startDate = new Date();

		selectQuery = Helper.replaceArgumentsWithRunTimeProperties(testConfig, selectQuery);
		Statement stmt = null;
		ResultSet resultSet = null;
		try
		{
			stmt = getConnection(testConfig, dbType).createStatement();
			resultSet = stmt.executeQuery(selectQuery);
		}
		catch (SQLException e)
		{
			//testConfig.logException(e);
		}

		if (null == resultSet)
			Log.Comment("No data was returned for this query");

		Date endDate = new Date();
		double timeDifference = (endDate.getTime() - startDate.getTime()) / 1000.00;

		if(timeDifference > 60)
			Log.Comment("<B>Time taken to run this query in minutes : " + timeDifference/60 + "</B>");
		//else
		//testConfig.logComment("Time taken to run this query in seconds : " + timeDifference);

		return resultSet;
	}


	private static HashMap<Integer, HashMap<String, String>> executeQueryHelper(TestBase testConfig,ResultSet resultSet)
	{
		// Convert that ResultSet into a HashMap
		
		HashMap<Integer, HashMap<String, String>> rowMapData = new HashMap<Integer, HashMap<String, String>>();
		
		//Starting Row Number 
		
		int row=1;
		try
		{
			while (resultSet.next())
			{			
				ResultSetMetaData meta = resultSet.getMetaData();

				HashMap<String, String> colMapData = new HashMap<String, String>();
				for (int col = 1; col <= meta.getColumnCount(); col++)
				{
					try{
						colMapData.put(meta.getColumnLabel(col), resultSet.getObject(col).toString());
					}
					catch(NullPointerException e){
						colMapData.put(meta.getColumnLabel(col), "");
					}
				}
				rowMapData.put(row,colMapData);	
				row++;
			}
		}catch (SQLException e){
			//testConfig.logException(e);
			}
		catch(NullPointerException e){
			//testConfig.logWarning("No data was returned for this query");
			rowMapData=null;
		}
		return rowMapData;
	}

	/**
	 * This Method is used to return all the rows return by a select query in a HashMap Structure
	 * 	Map<String,String> --> Map<Column Name,Column Data>
	 * @param testConfig
	 * @param DataBaseType  type 
	 * @param sqlRow Row number of SQl Query in dataSheet 
	 * @return HashMap <Integer, Map<String,String>>
	 * 	Integer --> Row Numbers
	 * 	Map->Column Name And Values 
	 */
	public static HashMap<Integer, HashMap<String, String>> executeSelectQuery(TestBase testConfig,DatabaseType type,int sqlRow,String sheetname)
	{	
		// Fetch Complete Result Set

		ResultSet resultSet=executeSelectQuery(testConfig, sqlRow, type,sheetname);
		return executeQueryHelper(testConfig,resultSet);
	}

	
	
	public static HashMap<Integer, HashMap<String, String>> executeSelectQueryALL(TestBase testConfig, int sqlRow) throws IOException
	{
		
		if(System.getProperty("Database").equalsIgnoreCase("Stage"))
          return executeSelectQuery(testConfig, DatabaseType.Stage,sqlRow);

		 else if (System.getProperty("Database").equalsIgnoreCase("Stage2"))
	     return executeSelectQuery(testConfig,DatabaseType.Stage2,sqlRow);

         else if (System.getProperty("Database").equalsIgnoreCase("PROD"))
	     return executeSelectQuery(testConfig,DatabaseType.PROD,sqlRow);
      
         else if (System.getProperty("Database").equalsIgnoreCase("Test1"))
         return executeSelectQuery(testConfig,DatabaseType.Test1,sqlRow);
		
         else if (System.getProperty("Database").equalsIgnoreCase("Test2"))
         return executeSelectQuery(testConfig,DatabaseType.Test2,sqlRow);
    
         else
	     return executeSelectQuery(testConfig,DatabaseType.IMPL,sqlRow); 
}
//56	
	public static HashMap<Integer, HashMap<String, String>> executeSelectQueryALL(TestBase testConfig, String selectQuery) throws IOException
	{
		
		if(System.getProperty("Database").equalsIgnoreCase("Stage"))
          return executeSelectQuery(testConfig, DatabaseType.Stage,selectQuery);

		 else if (System.getProperty("Database").equalsIgnoreCase("Stage2"))
	     return executeSelectQuery(testConfig,DatabaseType.Stage2,selectQuery);

         else if (System.getProperty("Database").equalsIgnoreCase("PROD"))
	     return executeSelectQuery(testConfig,DatabaseType.PROD,selectQuery);
      
         else if (System.getProperty("Database").equalsIgnoreCase("Test1"))
         return executeSelectQuery(testConfig,DatabaseType.Test1,selectQuery);
		
         else if (System.getProperty("Database").equalsIgnoreCase("Test2"))
         return executeSelectQuery(testConfig,DatabaseType.Test2,selectQuery);
    
         else
	     return executeSelectQuery(testConfig,DatabaseType.IMPL,selectQuery); 
}

	/**
	 * This Method is used to return all the rows return by a select query in a HashMap Structure
	 * 	Map<String,String> --> Map<Column Name,Column Data>
	 * @param testConfig
	 * @param DataBaseType  type 
	 * @param sqlRow Row number of SQl Query in dataSheet 
	 * @return HashMap <Integer, Map<String,String>>
	 * 	Integer --> Row Numbers
	 * 	Map->Column Name And Values 
	 * @throws IOException 
	 */
	public static HashMap<Integer, HashMap<String, String>> executeSelectQuery(TestBase testConfig,DatabaseType type,int sqlRow) throws IOException
	{	
		// Fetch Complete Result Set

		ResultSet resultSet=executeSelectQuery(testConfig, sqlRow, type);
		return executeQueryHelper(testConfig,resultSet);
	}
	public static HashMap<Integer, HashMap<String, String>> executeSelectQuery(TestBase testConfig,DatabaseType type,String selectQuery) throws IOException
	{	
		// Fetch Complete Result Set

		ResultSet resultSet=executeSelectQuery(testConfig, selectQuery, type);
		return executeQueryHelper(testConfig,resultSet);
	}
	/**
	 * Executes the select db query, and saves the result in
	 * Config.runtimeProperties as well as returns Map
	 * 
	 * @param Config
	 *            test config instance
	 * @param selectQuery
	 *            query to be executed
	 * @param rowNumber
	 *            row number to be returned (use 1 for first row and -1 for last
	 *            row)
	 * @return Map containing key:value pairs of specified row
	 */
	public static Map<String, String> executeSelectQuery(TestBase testConfig, String selectQuery, int rowNumber, DatabaseType dbType)
	{
		Date startDate = new Date();
		selectQuery = Helper.replaceArgumentsWithRunTimeProperties(testConfig, selectQuery);

		Statement stmt = null;
		ResultSet resultSet = null;
		try
		{
			stmt = getConnection(testConfig, dbType).createStatement();
			resultSet = stmt.executeQuery(selectQuery);
			
		}
		catch (SQLException e)
		{
			Log.Comment("Exception occured as :" + " " + e);
		}
		catch (NullPointerException ne) 
		{
			Log.Comment("Exception occured as :" + " " + ne);
			Log.Fail("<-----Unable to Create Connection With Database!! Please check your Internet----->");
		}
		Map<String, String> resultMap = null;

		int row = 1;
		try
		{
			if (rowNumber == -1)
			{
				if (resultSet.last())
					resultMap = addToRunTimeProperties(testConfig, resultSet);
			}
			else
			{
				while (resultSet.next())
				{
					if (row == rowNumber)
					{
						resultMap = addToRunTimeProperties(testConfig, resultSet);
						break;
					}
					else
					{
						row++;
					}
				}
			}
		}
		catch (SQLException e)
		{
			//testConfig.logException(e);
		}
		catch (NullPointerException ne) 
		{
			Log.Comment("<----------------No Data returned by Query!! Please check---------------->");
		}
		finally
		{
			try
			{
				resultSet.close();
				stmt.close();
			}
			catch (SQLException e)
			{
				//testConfig.logException(e);
			}
		}

		if (null == resultMap)
			Log.Comment("No data was returned for this query");

		Date endDate = new Date();
		double timeDifference = (endDate.getTime() - startDate.getTime()) / 1000.00;

		if(timeDifference > 60)
			Log.Comment("<B>Time taken to run this query in minutes : " + timeDifference/60 + "</B>");
//		else
//			Log.Comment("Time taken to run this query in seconds : " + timeDifference);

		return resultMap;
	}

	/**
	 * Executes the select db query, and saves the result in
	 * Config.runtimeProperties as well as returns Map
	 * 
	 * @param Config
	 *            test config instance
	 * @param sqlToUpdate
	 *            row number of the 'Query' column of 'SQL' sheet of Test data
	 *            excel having the query to be executed
	 * @param rowNumber
	 *            row number to be returned (use 1 for first row and -1 for last
	 *            row)
	 * @return Map containing key:value pairs of specified row
	 */
	public static int executeUpdateQuery(TestBase testConfig, int sqlToUpdate, DatabaseType dbType)
	{		
		// Read the Query column of SQL sheet of Test data excel
		TestDataReader sqlData = testConfig.getCachedTestDataReaderObject("SQL");
		String updateQuery = sqlData.GetData(sqlToUpdate, "Query");

		return executeUpdateQuery(testConfig, updateQuery, dbType);
	}
	
	public static int executeUpdateQuery(TestBase testConfig, int sqlToUpdate)
	{		
		// Read the Query column of SQL sheet of Test data excel
		TestDataReader sqlData = null;
		try {
			sqlData = testConfig.cacheTestDataReaderObject("SQL");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String updateQuery = sqlData.GetData(sqlToUpdate, "Query");
		DatabaseType dbType=getDatabaseType();
//		TestDataReader sqlData = testConfig.getCachedTestDataReaderObject("SQL");
//		String updateQuery = sqlData.GetData(sqlToUpdate, "Query");

		return executeUpdateQuery(testConfig, updateQuery, dbType);
	}
	
	public static int executeUpdateQuery(TestBase testConfig, String updateQuery)
	{		
		TestDataReader sqlData = null;
		try {
			sqlData = testConfig.cacheTestDataReaderObject("SQL");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatabaseType dbType=getDatabaseType();

		return executeUpdateQuery(testConfig, updateQuery, dbType);
	}
	/**
	 * 
	 * @param testConfig
	 * @param sqlRow
	 * @param dbType
	 * @return
	 */
	public static int executeUpdateQuery(TestBase testConfig,  String sheetPath, int sqlRow, DatabaseType dbType)
	{		
		// Read the Query column of SQL sheet of Test data excel
		TestDataReader sqlData = testConfig.getCachedTestDataReaderObject("SQL",sheetPath);
		String updateQuery = sqlData.GetData(sqlRow, "Query");

		return executeUpdateQuery(testConfig, updateQuery, dbType);
	}

	/**
	 * Executes the update db query
	 * 
	 * @param Config
	 *            test config instance
	 * @param updateQuery
	 *            query to be executed
	 * @return number of rows affected
	 */
	public static int executeUpdateQuery(TestBase testConfig, String updateQuery, DatabaseType dbType)
	{
		Date startDate = new Date();
		Statement stmt = null;
		int rows = 0;
		try
		{
			stmt = getConnection(testConfig, dbType).createStatement();
			updateQuery = Helper.replaceArgumentsWithRunTimeProperties(testConfig, updateQuery);

			if(testConfig.getRunTimeProperty("replaceNULLInQuery") != null && testConfig.getRunTimeProperty("replaceNULLInQuery").equalsIgnoreCase("true"))
			{
				if(updateQuery.contains("'(null)'") || updateQuery.contains("'(NULL)'") || updateQuery.contains("'null'") || updateQuery.contains("'NULL'"))
				{
					updateQuery = updateQuery.replace("'(null)'", "NULL").replace("'(NULL)'", "NULL").replace("'null'", "NULL").replace("'NULL'", "NULL");
				}
			}

			Log.Comment("\nExecuting the update query - '" + updateQuery + "'", testConfig);
			rows = stmt.executeUpdate(updateQuery);
		}
		catch (SQLException e)
		{
			Log.Comment("Exception is " +e);
		}
		finally
		{
			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					Log.Comment("Exception is " +e);
				}
			}
		}
		if (0 == rows)
		Log.Comment("No rows were updated by this query");
		else
		Log.Comment("No. of rows  updated by this query :" + rows);

		Date endDate = new Date();
		double timeDifference = (endDate.getTime() - startDate.getTime()) / 1000.00;

		if(timeDifference > 60)
			Log.Comment("<B>Time taken to run this query in minutes : " + timeDifference/60 + "</B>");
		else
			Log.Comment("Time taken to run this query in seconds : " + timeDifference);

		return rows;
	}
	/**
	 * Execute Query From Given Sheet
	 * @param testConfig
	 * @param sqlRow
	 * @param dbType
	 * @param sheetname
	 * @return
	 */
	public static ResultSet executeSelectQuery(TestBase testConfig, int sqlRow, DatabaseType dbType,String sheetname)
	{
		// Read the Query column of SQL sheet of Test data excel
		TestDataReader sqlData = testConfig.getCachedTestDataReaderObject(sheetname);
		String selectQuery = sqlData.GetData(sqlRow, "Query");
		selectQuery = Helper.replaceArgumentsWithRunTimeProperties(testConfig, selectQuery);
		Log.Comment("Executing the query - '" + selectQuery + "'", testConfig);
		return executeSelectQuery(testConfig, selectQuery, dbType);
	}

	/**
	 * Creates database connection using the Config parameters -
	 * 'DBConnectionString', 'DBConnectionUsername' and 'DBConnectionPassword'
	 * 
	 * @param Config
	 *            test config instance
	 * @return Db Connection
	 */
	private static Connection getConnection(TestBase testConfig, DatabaseType dbType)
	{
		Connection con = null;
		String connectString = null;
		String userName = null;
		String password = null;
		try
		{
			switch (dbType)
			{
			case Stage:
				connectString = testConfig.getRunTimeProperty("StageDBConnectionString");
				Log.Comment("Connecting to Stage DB:-" + connectString);
				userName = testConfig.getRunTimeProperty("StageDBUsername");
				password = testConfig.getRunTimeProperty("StageDBPassword");
				break;
				
			case Stage2:
				connectString = testConfig.getRunTimeProperty("Stage2DBConnectionString");
				Log.Comment("Connecting to Stage 2 DB:-" + connectString);
				userName = testConfig.getRunTimeProperty("Stage2DBUsername");
				password = testConfig.getRunTimeProperty("Stage2DBPassword");
				break;
				
			case IMPL:
				connectString = testConfig.getRunTimeProperty("IMPLConnectionString");
				Log.Comment("Connecting to IMPL DB:-" + connectString);
				userName = testConfig.getRunTimeProperty("IMPLDBUsername");
				password = testConfig.getRunTimeProperty("IMPLDBPassword");
				break;
				
			case PROD:
				connectString = testConfig.getRunTimeProperty("ProdDBConnectionString");
				Log.Comment("Connecting to Stage DB:-" + connectString);
				userName = testConfig.getRunTimeProperty("ProdDBUsername");
				password = testConfig.getRunTimeProperty("ProdDBPassword");
				break;
				
			case Test1:
				connectString = testConfig.getRunTimeProperty("Test1DBConnectionString");
				Log.Comment("Connecting to Test1 DB:-" + connectString);
				userName = testConfig.getRunTimeProperty("Test1DBUsername");
				password = testConfig.getRunTimeProperty("Test1DBPassword");
				break;
				
			case Test2:
				connectString = testConfig.getRunTimeProperty("Test2DBConnectionString");
				Log.Comment("Connecting to Test2 DB:-" + connectString);
				userName = testConfig.getRunTimeProperty("Test2DBUsername");
				password = testConfig.getRunTimeProperty("Test2DBPassword");
				break;
				
			case Automation:
				connectString = testConfig.getRunTimeProperty("AutomationDBConnectionString");
				Log.Comment("Connecting to Automation DB:-" + connectString);
				userName = testConfig.getRunTimeProperty("AutomationDBUsername");
				password = testConfig.getRunTimeProperty("AutomationDBPassword");
				break;
			
			default:
				break;
			}
					
			try
			{ 
				if(dbType.toString().equals("Automation"))
				Class.forName(testConfig.getRunTimeProperty("SQLConnectionDriver"));
				else
				Class.forName(testConfig.getRunTimeProperty("DBConnectionDriver"));
			}
			catch (ClassNotFoundException e)
			{
				con = null;
				Log.Warning("Exception occured" + e, testConfig);
			}		
			
			con = DriverManager.getConnection(connectString, userName, password);
			if(con != null)
			Log.Comment("Connection succeeded");
			else
			Log.Comment("Unable to establish connection");
			
		}
		catch (SQLException e)
		{
			Log.Comment("Exception occured : " + e);
		}

		testConfig.DBConnection = con;
		return testConfig.DBConnection;
	}
	
	/**
	 * Executes delete query in DB
	 * @param testConfig : test config instance
	 * @param sqlRow : row number of sql query in excel
	 * @param dbType : type of DB
	 * @return 
	 */
	public static int executeDeleteQuery(TestBase testConfig, int sqlRow)
	{		
		// Read the Query column of SQL sheet of Test data excel
		DatabaseType dbType=null;
		TestDataReader sqlData = null;
		try {
			sqlData = testConfig.cacheTestDataReaderObject("SQL");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String deleteQuery = sqlData.GetData(sqlRow, "Query");
		dbType=getDatabaseType();
		return executeUpdateQuery(testConfig, deleteQuery, dbType);
	}
	
	public static int executeDeleteQuery(TestBase testConfig, String deleteQuery)
	{		
		DatabaseType dbType=null;
		TestDataReader sqlData = null;
		try {
			sqlData = testConfig.cacheTestDataReaderObject("SQL");
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbType=getDatabaseType();
		return executeUpdateQuery(testConfig, deleteQuery, dbType);
	}

	
	/**
	 * This method converts resultset to list
	 * 
	 * @param resultset
	 *            SQL resultSet
	 * @return sql data in list<hashmap<string,string>
	 */
	public static List<HashMap<String, String>> convertResultSetToList(TestBase testConfig, ResultSet rs)
	{
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		try
		{
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			while (rs.next())
			{
				HashMap<String, String> row = new HashMap<String, String>(columns);
				for (int i = 1; i <= columns; ++i)
				{
					row.put(md.getColumnLabel(i), rs.getString(i));
				}
				list.add(row);
			}
		}
		catch(SQLException e)
		{
			Log.Comment(e.getMessage());
		}

		return list;
	}

	/**
	 * This method is used to run a query on a provided DB with given connection string, username and password.
	 * @param query
	 * @param connectString
	 * @param userName
	 * @param password
	 * @return
	 */
	public static ResultSet executeQueryWithoutClosingConnection(String query, String connectionString, String username, String password)
	{
		Date startDate = new Date();
		Statement stmt = null;
		ResultSet resultSet = null;
		try
		{
			connection = DriverManager.getConnection(connectionString, username, password);
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(query);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		if (null == resultSet)
			System.out.println("No data was returned for this query");

		Date endDate = new Date();
		double timeDifference = (endDate.getTime() - startDate.getTime()) / 1000.00;

		if(timeDifference > 60)
			Log.Comment("<B>Time taken to run this query in minutes : " + timeDifference/60 + "</B>");
		else
			Log.Comment("Time taken to run this query in seconds : " + timeDifference);
		return resultSet;
	}

	public static void closeDatabaseConnection()
	{
		if(connection != null)
		{
			try
			{
				connection.close();
				connection = null;
				System.out.println("Database connection closed successfully.");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static Map<String, String> executeSelectQueryDB(TestBase testConfig, int sqlRow, int rowNumber)
	{
		
		String selectQuery="select *  from eps_automation.queries_config where sqlRow=%d";
		selectQuery=String.format(selectQuery, sqlRow);
		
		Log.Comment("Executing the query - '" + selectQuery + "'", testConfig);
		
		
		if(System.getProperty("Database").equalsIgnoreCase("Stage"))
		{
          return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.Stage);
		}
		 else if (System.getProperty("Database").equalsIgnoreCase("Stage2"))
         {
	    return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.Stage2);
         }
         else if (System.getProperty("Database").equalsIgnoreCase("PROD"))
         {
	   return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.PROD);
       }
    else
	return executeSelectQuery(testConfig, selectQuery, rowNumber, DatabaseType.IMPL); 
}
	
	
	
	
	

	/**
	 * Executes the update db query
	 * 
	 * @param Config
	 *            test config instance
	 * @param dbType
	 *            the type of database
	 * @param updateStatement
	 *            query to be executed
	 * @param values
	 *            prepared statement values
	 * @return number of rows affected
	 */
	public static int executeUpdatePreparedStatement(TestBase testConfig, int sqlRow, Object[] values)
	{
		String updateStatement = getQuery(testConfig, sqlRow);
		PreparedStatement stmt = null;
		int rows = 0;
		try
		{	
			Log.Comment("\nExecuting the update query - '" + updateStatement + "'", testConfig);
			stmt = setPreparedStatementValues(testConfig, updateStatement, values);
			rows = stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			Log.Comment("Exception is " +e);
		}
		finally
		{
			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					Log.Comment("Exception is " +e);
				}
			}
		}
		
		if (0 == rows)
			Log.Comment("No rows were updated by this query");
		else
			Log.Comment("No. of rows  updated by this query :" + rows);

		return rows;
	}

	/**
	 * Executes the select query
	 * 
	 * @param Config
	 *            test config instance
	 * @param dbType
	 *            the type of database
	 * @param updateStatement
	 *            query to be executed
	 * @param values
	 *            prepared statement values
	 * @return number of rows affected
	 */
	public static List<HashMap<String, String>> executeSelectPreparedStatement(TestBase testConfig, int sqlRow, Object[] values)
	{
		String selectQuery = getQuery(testConfig, sqlRow);
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<HashMap<String, String>> finalResult =null;
		try
		{	
			Log.Comment("Executing the select query - '" + selectQuery + "'", testConfig);
			stmt = setPreparedStatementValues(testConfig, selectQuery, values);
			result = stmt.executeQuery();
			finalResult = convertResultSetToList(null, result);
		}
		catch (SQLException e)
		{
			Log.Comment("Exception is " +e);
		}
		finally
		{
			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					Log.Comment("Exception is " +e);
				}
			}
		}
		
		if (result == null)
			Log.Comment("No rows were returned by this query");
		else
			Log.Comment("Rows have been returned by this query" );

		return finalResult;
	}
	
	
	public static PreparedStatement setPreparedStatementValues(TestBase testConfig, String updateStatement, Object[] values)
	 {
		 Connection con = null;
		 PreparedStatement stmt= null;
		 try
		 {

			 Log.Comment("Creating the prepared statements for the query being executed '" + updateStatement + "'", testConfig);
			 DatabaseType dbType = getDatabaseType();
			 con = getConnection(testConfig, dbType);
			 stmt= con.prepareStatement(updateStatement);
			 if(values != null)
			 {
				 for(int index =0; index < values.length; index++)
				 {
					 if( values[index] instanceof Integer )
					 {
						 stmt.setInt(index+1, (int)values[index] );
					 }
					 else if(values[index] instanceof String )
					 {
						stmt.setString(index+1, (String)values[index]); 
					 }
					 else if(values[index] instanceof Double )
					 {
							stmt.setDouble(index+1, (double)values[index]);
					 }
					 else if(values[index] instanceof Boolean )
					 {
						 stmt.setBoolean(index+1, (boolean)values[index]);
					 }
				 }
			 }
		 }
		 catch(Exception ex)
		 {
			 Log.Comment("Exception generated while preparing Prepared Statement " +ex);
		 }
		 return stmt;
	 }


	public static String getQuery(TestBase testConfig, int sqlRow)
	{
		TestDataReader sqlData = null;
		try 
		{
			Log.Comment("Retrieving the query to be executed ", testConfig);
			sqlData = testConfig.cacheTestDataReaderObject("SQL");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		String query = sqlData.GetData(sqlRow, "Query");
		return query;
	}
	
	
	
	public synchronized static List<String> executeQuery(String query,String... sColumn) throws SQLException {
		String sb = "";
		List<String> alist=new ArrayList<String>();
		try {
			
		
			statement = con.createStatement();
			con.createStatement();
			statement.setQueryTimeout(1200);
			
	
			
			
			rs = statement.executeQuery(query);
			while(rs.next()){
				for(String sData:sColumn){
					sb=sb+rs.getString(sData);
					if(!sData.equalsIgnoreCase(sColumn[sColumn.length-1])){
					sb=sb+",";
					}
				}
				alist.add(sb);
				sb="";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return alist;

	
	
	}
	
	
}