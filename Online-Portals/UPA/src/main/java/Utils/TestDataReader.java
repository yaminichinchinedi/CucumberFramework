package main.java.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.nativeFunctions.TestBase;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import main.java.reporting.Log;

public class TestDataReader {
	String filename;
	private FileOutputStream fileOut = null;
	private FileInputStream fis = null;
	String path;
	private String sheetName;
	private TestBase testConfig;
	private ArrayList<List<String>> testData;

	// constructor
	public TestDataReader(TestBase testConfig) {
		this.testConfig = testConfig;
	}

	//Overloaded constructor
	public TestDataReader(TestBase testConfig, String sheetName) throws IOException
	{
		String dataFilePath=testConfig.getRunTimeProperty("DataFile");
		testConfig.putRunTimeProperty("DataFilePath", System.getProperty("user.dir")+dataFilePath);
		readFile(testConfig, sheetName, testConfig.getRunTimeProperty("DataFilePath"));
	}
	
	//Overloaded constructor
	public TestDataReader(TestBase testConfig, String sheetName, String path) throws IOException
	{
		if(path.contains(".xls"))
			readFilexls(testConfig, sheetName, path);
		else 
		readFile(testConfig, sheetName, path);
	
	}
 
	public void readFilexls(TestBase testBaseSetup, String sheetName,String path) throws IOException
	{
		this.testConfig = testBaseSetup;
		int index = path.lastIndexOf("//");
		
		if (index != -1)
			Log.Comment("Read:-'" + path.substring(path.lastIndexOf("//"))+ "', Sheet:- '" + sheetName + "'");
		else
			Log.Comment("Read:-'" + path + "', Sheet:- '" + sheetName + "'");
			
		filename = path;
		testData = new ArrayList<List<String>>();
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;
				fis = new FileInputStream(filename);
				workbook = new HSSFWorkbook(fis);
				sheet = workbook.getSheet(sheetName);
		
		  int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		  System.out.println("Row count is:"+rowCount);
		    //Create a loop over all the rows of excel file to read it

		    for (int i = 1; i < rowCount; i++) {

		        Row row = sheet.getRow(i);

		        //Create a loop to print cell values in a row

		        for (int j = 0; j < row.getLastCellNum(); j++) {

		            //Print Excel data in console

		            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

		        }

		        System.out.println();
		    } 
				this.sheetName = sheetName;

			}
	private String convertXSSFCellToString(XSSFCell cell) {
		String value = null;
		try {
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				value = Double.toString(cell.getNumericCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				value = cell.getRichStringCellValue().toString();
			} else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
				value = "";
			} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				value = Boolean.toString(cell.getBooleanCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				value = "";
			}
		} catch (NullPointerException ex) {
			value = "";
		}
		
		return value;
	}

	public String GetcolumnData(String column, String value, String path,
			int columnNum, Boolean newPennyFlow) {
		String data = "";
		column = column.trim();
		List<String> headerRow = testData.get(0);
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;
		filename = path;
		try {
			
			fis = new FileInputStream(filename);
			workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			
			if (headerRow.get(columnNum).equals(column)) {
				int rowNum = 0;
				int totalRows = getRecordsNum();
				if (newPennyFlow) {
					totalRows = totalRows - 1;
				}
				System.out.println(totalRows);
				for (rowNum = totalRows; rowNum >= 1; --rowNum) {
					data = GetData(rowNum, column);
					if (data.equals(value)) {
						data = GetData(rowNum, column);
						String row = String.valueOf(rowNum);
						testConfig.putRunTimeProperty("Row", row);
						main.java.reporting.Log.Pass(column + " contains the value " + value);
						break;
					}
				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return data;
	}

	/**
	 * Gets the data value in column=correspondingColumnToRead for the row where
	 * value=inputColumnValue and column=inputColumn
	 * 
	 * @param inputColumn
	 *            Column name corresponding to which value is to be read
	 * @param inputColumnValue
	 *            Column value for which value is to be read
	 * @param correspondingColumnToRead
	 *            Column name whose value is required
	 * @return corresponding column value
	 */
	public String GetCorrespondingColumnValue(String inputColumn,
			String inputColumnValue, String correspondingColumnToRead) {
		String correspondingColumnValue = "";
		List<String> headerRow = testData.get(0);
		for (int col = 0; col < headerRow.size(); col++) {
			if (headerRow.get(col).equalsIgnoreCase(inputColumn)) {
				try {
					int row = 1;
					List<String> rowToRead = null;
					String inputval = null;
					while (true) {
						rowToRead = testData.get(row);
						inputval = rowToRead.get(col);
						if (inputval.equalsIgnoreCase(inputColumnValue)) {
							correspondingColumnValue = GetData(row,
									correspondingColumnToRead);
							return correspondingColumnValue;
						}
						row++;
					}
				} catch (Exception e) {
					return "";
				}
			}
		}
		return correspondingColumnValue;
	}


	/**
	 * Returns the Excel sheet data value (returns {skip} if the excel value is
	 * blank, which means no operation)
	 * 
	 * @param row
	 *            Excel Row number to read
	 * @param column
	 *            Excel column name to read
	 * @return The value read
	 */
	public String GetData(int row, String column) {
		String data = "";
		
		//test data contains Value of all columns of all Rows, here we are getting the first row which contains Headings.
		
		List<String> headerRow = testData.get(0); //testdata[0]->headings row
		
		//Gets the value of all columns for passed row number
		
		List<String> dataRow = testData.get(row); // testdata[row]->for which row we need to pass column values
		
		for (int i = 0; i < headerRow.size(); i++) {
			if (headerRow.get(i).equalsIgnoreCase(column)) {
				try {
					data = dataRow.get(i);
				} catch (IndexOutOfBoundsException e) {
					data = "";
				}
				break;
			}
		}
		data = data.trim();
		return data;
			}

	/**
	 * Returns the Excel header value
	 * 
	 * @param row
	 *            Excel Row number to read
	 * @param column
	 *            Excel column name to read
	 * @return The value read
	 */
	public String GetHeaderData(int i) {
		String data = "";
		List<String> headerRow = testData.get(0);
		List<String> dataRow = testData.get(0);
		try {
			data = dataRow.get(i);
		} catch (IndexOutOfBoundsException e) {
			data = "";
		}
		data = data.trim();
		if (data.equals("")) {
			data = "{skip}";
			return data;
		} else {
			if (data.contains("{empty}"))
				data = data.replace("{empty}", "");
			if (data.contains("{space}"))
				data = data.replace("{space}", " ");
			if (data.contains("{random")) {
				int start = data.indexOf("Num:") + 4;
				int end = data.indexOf("}");
				int length = Integer.parseInt(data.substring(start, end));
				if (data.contains("{randomAlphaNum:" + length + "}"))
					data = data.replace("{randomAlphaNum:" + length + "}",
							Helper.generateRandomAlphaNumericString(length));
				if (data.contains("{randomNum:" + length + "}"))
					data = data.replace("{randomNum:" + length + "}",
							Long.toString(Helper.generateRandomNumber(length)));
			}
		}
		return data;
	}

	/**
	 * This method returns the number of records present in the datasheet
	 * 
	 * @return number of records
	 */
	public int getRecordsNum() {
		return testData.size();
	}

	/**
	 * This method returns the number of columns of the datasheet (It counts the
	 * header and returns the number)
	 * 
	 * @return number of columns
	 */
	public int getColumnNum() {
		List<String> headerRow = testData.get(0);
		return headerRow.size();
	}

	// Ignore number format exception in reading String/Float value from excel
	// if excel cell value is blank and format is not string
	public String ignoreNumberFormatException(String returnType, String value) {
		if (value.equalsIgnoreCase("{skip}")) {
			switch (returnType) {
			case "stringType":
				return "";
			case "floatType":
				return "0.0";
			default:
				return value;
			}
		} else
			return value;
	}

	private void readFile(TestBase testBaseSetup, String sheetName,String path) throws IOException
	{
		this.testConfig = testBaseSetup;
		int index = path.lastIndexOf("//");
		
		if (index != -1)
			Log.Comment("Read:-'" + path.substring(path.lastIndexOf("//"))+ "', Sheet:- '" + sheetName + "'");
		else
			Log.Comment("Read:-'" + path + "', Sheet:- '" + sheetName + "'");
		
		filename = path;
		testData = new ArrayList<List<String>>();
				XSSFWorkbook workbook = null;
				XSSFSheet sheet = null;
				fis = new FileInputStream(filename);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet(sheetName);
				Iterator<Row> rows = sheet.rowIterator();
				while (rows.hasNext()) {
					XSSFRow row = (XSSFRow) rows.next();
					List<String> data = new ArrayList<String>();
					for (int z = 0; z < row.getLastCellNum(); z++) {
						String str = convertXSSFCellToString(row.getCell(z));
						data.add(str);
					}
					testData.add(data);
				}
				this.sheetName = sheetName;

			}
	

	public void setCellData(int row, String column, String data,
			String description) throws IOException {
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;
		HSSFRow dataRow = null;
		HSSFCell cell = null;
		int colNum = -1;
		if (row <= 0)
			Log.Fail("Invalid row number:" + row);
		List<String> headerRow = testData.get(0);
		for (int i = 0; i < headerRow.size(); i++) {
			if (headerRow.get(i).equalsIgnoreCase(column)) {
				try {
					colNum = i;
					if (colNum == -1)
						main.java.reporting.Log.Fail("Invalid column name:" + column);
				} catch (IndexOutOfBoundsException e) {
					main.java.reporting.Log.Fail(e.getMessage());
				}
			}
		}
		fis = new FileInputStream(filename);
		workbook = new HSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		dataRow = sheet.getRow(row);
		cell = dataRow.getCell(colNum);
		cell.setCellValue(data.trim());
		fileOut = new FileOutputStream(filename);
		workbook.write(fileOut);
		fileOut.close();
	}
}