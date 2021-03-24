
package main.java.Utils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.nativeFunctions.DataProvider;
import main.java.nativeFunctions.Element;
import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.ViewPayments;
import main.java.queries.QUERY;
import main.java.reporting.Log;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;



public class Helper
{
	/**
	 * Function to change the given date value from given old Date Format to
	 * desired new Date Format.
	 * 
	 * @param testConfig
	 * @param date
	 *            -> date which needs to be converted ex: 26/11/2014
	 * @param oldDateFomat
	 *            -> is the format which we are giving as input ex: yyyy-mm-dd
	 * @param newDateFomat
	 *            -> is the format which we get after converting ex: dd MMM yy
	 * @return
	 */
	public static String changeDateFormat(TestBase testConfig, String date, String oldDateFomat, String newDateFomat)
	{

		String desiredDate = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat(newDateFomat);
		SimpleDateFormat oldFormat = new SimpleDateFormat(oldDateFomat);

		try
		{
			desiredDate = dateFormat.format(oldFormat.parse(date)).toString();

		}
		catch (ParseException e)
		{
			Log.Comment(e.getMessage());
		}
		return desiredDate;
	}

	public static String changeDateFormat(String oldDateString)
	{
		String OLD_FORMAT = "dd/MM/yyyy";
		String NEW_FORMAT = "yyyy/MM/dd";
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d = null;
		try
		{
			d = sdf.parse(oldDateString);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		sdf.applyPattern(NEW_FORMAT);
		return sdf.format(d);
	}
	
	
	public static String changeDateFormat(Date date)
	{
		SimpleDateFormat  formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate = formatter.format(date);  
	    return strDate;
	}

	/**
	 * Method used to change dd/mm/yyyy to yyyy-mm-dd
	 * 
	 * @param date
	 *            which needs to be converted ex: 26/11/2014
	 * @param initDateFormat
	 *            is the format which we are giving as input ex: dd/mm/yyyy
	 * @param expectedDateFormat
	 *            is the format which we get after converting ex: yyyy-mm-dd
	 * @return
	 * @throws ParseException
	 */
	public static String changeDateFormat(String date, String initialDateFormat, String expectedDateFormat) throws ParseException
	{

		Date initDate = new SimpleDateFormat(initialDateFormat).parse(date);
		SimpleDateFormat formatter = new SimpleDateFormat(expectedDateFormat);
		String parsedDate = formatter.format(initDate);

		return parsedDate;
	}

	
	/**
	 * Method used to convert a string "dd/mm/yyyy" to Date formatdd/mm/yyyy
	 * 
	 * @param date
	 *            which needs to be converted ex: "26/11/2014"
	 *            */
   public static Date changeStringToDate(String dateInString) throws ParseException
	{
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(dateInString);
	    return date;
   }
	
	/**
	 * Method used to convert a Date dd/mm/yyyy to String "dd/mm/yyyy"
	 * 
	 * @param date
	 *            which needs to be converted ex: 26/11/2014
	 *            */
  public static String changeDateToString(Date date) throws ParseException
	{
	    return date.toString();
  }
   
   
   
   
	/**
	 * Function to change Date from 20-12-15 to 20/12/15 
	 * 
	 * @param date
	 * @return
	 */
	public static String changeDateFormatSeperator(String date)
	{
		String dateOnly = "";
		dateOnly = date.replaceAll("-", "/");
		return dateOnly;
	}

	/**
	 * Function to change Date from 20/12/15 to 20-12-15 and to merge Date &
	 * Time to make 1 field.
	 * 
	 * @param date
	 * @param time
	 * @return
	 */
	public static String changeDateTimeFormat(String date, String time)
	{
		String dateTime = "";
		dateTime = changeDateFormatSeperator(date);
		dateTime = dateTime.concat(" ");
		dateTime = dateTime.concat(time);
		return dateTime;
	}

	
	/**
	 * Check given String is in given date format 
	 * @param date
	 * @return boolean value
	 */
	public static boolean verifyDateFormat(String date,String format)
	{	

		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			df.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}

	}

	/**
	 * To change the filePath containing \\ to /
	 * 
	 * @param existingFilePath
	 * @return new FilePath
	 */
	public static String changeFilePath(String existingFilePath)
	{
		// format filePath
		StringBuffer newText = new StringBuffer();
		for (int i = 0; i < existingFilePath.length(); i++)
		{
			boolean flag = false;
			// newText.append(filePath.charAt(i));
			if (existingFilePath.charAt(i) == '/')
			{
				if (existingFilePath.charAt(i + 1) == '/')
				{
					flag = true;
					newText.append('\\');
					i++;
				}
				else
					newText.append(existingFilePath.charAt(i));
			}
			if (!flag)
				newText.append(existingFilePath.charAt(i));

		}
		String newFilePath = newText.toString();

		return newFilePath;
	}
	
	public static int getFirstMatchingPoint(Pattern regex, String str)
	{
		Matcher m = regex.matcher(str);
		if (m.find())
		{
			return m.start();
		}
		else
		{
			return -1;
		}
	}
	
	public static void compareContains(TestBase testConfig, String what, String expected, String actual)
	{
		actual = actual.trim();
		if (actual != null)
		{
			if(actual.contains(expected.trim()))
			{
		     Log.Pass(what, expected, actual);	
			}
			else
				Log.Fail(what, expected, actual);
		}
		
		else
			System.out.println("Page not loaded");
	}

	
	/**
	 * Compare two integer, double or float type values using a generic function.
	 * @param testConfig
	 * @param what
	 * @param expected
	 * @param actual
	 */
	public static <T> void compareEquals(TestBase testConfig, String what, T expected, T actual)
	{
		if (expected == null & actual == null)
		{
			Log.Pass(testConfig, what, expected, actual);
			return;
		}

		if (actual != null)
		{
			if (!actual.equals(expected))
			{
				Log.Fail(testConfig, what, expected, actual);
			}
			else
			{
				Log.Pass(testConfig,what,expected, actual);
			}
		}
		else
		{
			Log.Fail(testConfig,what,expected, actual);
		}
	}
	
	/** Compare two string and log as warning if strings are not same
	 * @param testConfig
	 * @param what
	 * @param expected
	 * @param actual
	 */
	public static void compareEquals(TestBase testConfig, String what, String expected, String actual)
	{
		if (expected == null & actual == null)
		{
			Log.Pass(what,expected, actual);
			return;
		}
		
			if (!actual.equals(expected))
			{
				Log.Fail(what, expected, actual);
			}
			else
			{
				Log.Pass(what,expected, actual);
			}
		
	}


	/**
	 * This utility method returns Date in readable format. Converts from Unix
	 * Format.
	 * 
	 * @param unixformat
	 *            - unix format to be converted
	 * @param format
	 *            - Format in which the date will be returned
	 * @return
	 */
	// Convert to readable format from Unixdatetime stamp
	public static String convertDatefromUnix(long unixformat, String format)
	{
		Date date = new Date(unixformat);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String convertedDate = formatter.format(date);
		return convertedDate;
	}


	/**
	 * Method is used to calculate difference in hrs between 2 Date Time passed
	 * as parameters
	 * 
	 * @param date
	 *            1
	 * @param date
	 *            2
	 * @return difference between 2 dates in hours
	 */
	public static long dateTimeDifferenceInHours(String date1, String date2)
	{

		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date d1 = null;
		Date d2 = null;
		try
		{
			d1 = format.parse(date1);
			d2 = format.parse(date2);
		}
		catch (ParseException e)
		{

		}
		// in milliseconds
		long diffHours = (d2.getTime() - d1.getTime()) / (60 * 60 * 1000) % 24;
		return diffHours;
	}
	
	/**
	 * Method is used to calculate difference in days between 2 Dates
	 * as parameters
	 * 
	 * @param date
	 *            1
	 * @param date
	 *            2
	 * @return difference between 2 dates in hours
	 */
	public static long dateTimeDifferenceInDays(String date1, String date2)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		Date d2 = null;
		try
		{
			d1 = format.parse(date1);
			d2 = format.parse(date2);
		}
		catch (ParseException e)
		{

		}
		// in milliseconds
		long diff = (d2.getTime() - d1.getTime());
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		return diffDays;
	}
	
	/**
	 * Method is used to calculate difference in days between passed and current date
	 * as parameters
	 * 
	 * @param date
	 *            1
	 * @return difference between 2 dates in hours
	 */
	public static long dateTimeDifferenceInDaysFromCurrentDate(String date1)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		Date d2 = null;
		try
		{
			d1 = format.parse(date1);
			d2 = format.parse(getCurrentDate("yyyy-MM-dd"));
		}
		catch (ParseException e)
		{

		}
		// in milliseconds
		long diff = (d2.getTime() - d1.getTime());
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		return diffDays;
	}

	/**
	 * Method is used to calculate difference in hrs between 2 Date Time passed
	 * as parameters
	 * 
	 * @param date
	 *            1
	 * @param date
	 *            2
	 * @return difference between 2 dates in hours
	 */
	public static long dateTimeDifferenceInMinutes(String date1, String date2)
	{

		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date d1 = null;
		Date d2 = null;
		try
		{
			d1 = format.parse(date1);
			d2 = format.parse(date2);
		}
		catch (ParseException e)
		{

		}
		// in milliseconds
		long diffMinutes = (d2.getTime() - d1.getTime()) / (60 * 1000);
		return diffMinutes;
	}
	
	/**
	 * Method is used to calculate difference in hrs between 2 Date Time passed
	 * as parameters
	 * 
	 * @param date
	 *            1
	 * @param date
	 *            2
	 * @return difference between 2 dates in hours
	 */
	public static long dateTimeDifferenceInSeconds(String date1, String date2)
	{

		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date d1 = null;
		Date d2 = null;
		try
		{
			d1 = format.parse(date1);
			d2 = format.parse(date2);
		}
		catch (ParseException e)
		{

		}
		// in milliseconds
		long diffSeconds = (d2.getTime() - d1.getTime()) / (1000);
		return diffSeconds;
	}

	
	/**
	 * Generate a random Alphabets string of given length
	 * 
	 * @param length
	 *            Length of string to be generated
	 */
	public static String generateRandomAlphabetsString(int length)
	{
		Random rd = new Random();
		String aphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++)
		{
			sb.append(aphaNumericString.charAt(rd.nextInt(aphaNumericString.length())));
		}

		return sb.toString();
	}

	/**
	 * Generate a random Alpha-Numeric string of given length
	 * 
	 * @param length
	 *            Length of string to be generated
	 */
	public static String generateRandomAlphaNumericString(int length)
	{
		Random rd = new Random();
		String aphaNumericString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++)
		{
			sb.append(aphaNumericString.charAt(rd.nextInt(aphaNumericString.length())));
		}

		return sb.toString();
	}
	
	/**
	 * Generate a random Special Character string of given length
	 * 
	 * @param length
	 *            Length of string to be generated
	 */

	public static String generateRandomSpecialCharacterString(int length)
	{
		Random rd = new Random();
		String specialCharString =  "~!@#$%^*()_<>?/{}[]|\";";
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++)
		{
			sb.append(specialCharString.charAt(rd.nextInt(specialCharString.length())));
		}

		return sb.toString();
	}
	
	/**
	 * Generate a random decimal number
	 *
	 * @param integer lower bound value
	 * @param integer Upper bound value
	 * @param integer decimal points
	 *      
	 * @return an decimal number between that bound upto given decimal points
	 */
	
	public static String generateRandomDecimalValue(int lowerBound, int upperBound,int decimalPlaces) {
		Random random = new Random();
	    double dbl;
	    dbl = random.nextDouble()  * (upperBound - lowerBound) + lowerBound;
	    return String.format("%." + decimalPlaces + "f", dbl);

	}

	/**
	 * Generate a random number of given length
	 * 
	 * @param length
	 *            Length of number to be generated
	 * @return
	 */
	public static long generateRandomNumber(int length)
	{
		long randomNumber = 1;
		int retryCount = 1;

		// retryCount added for generating specified length's number
		while (retryCount > 0)
		{
			String strNum = Double.toString(Math.random());
			
			strNum = strNum.replace(".", "");

			if (strNum.length() > length)
			{
				strNum = strNum.substring(0, length);
			}
			else
			{
				int remainingLength = length - strNum.length() + 1;
				randomNumber = generateRandomNumber(remainingLength);
				strNum = strNum.concat(Long.toString(randomNumber));
			}

			randomNumber = Long.parseLong(strNum);

			if (String.valueOf(randomNumber).length() < length)
			{
				retryCount++;
			}
			else
			{
				retryCount = 0;
			}

		}
		

		return randomNumber;
	}




	public static String getCurrentDate(String format)
	{
		// get current date
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getCurrentDateTime(String format)
	{
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}

	// get current time in given format
	public static String getCurrentTime(String format)
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String currentTime = formatter.format(cal.getTime());

		return currentTime;
	}
	
	//public 

	public static String getDate(int dd, int mm, int yyyy, String format)
	{
		Calendar date = new GregorianCalendar(yyyy, mm - 1, dd);
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date.getTime());
	}

	/**
	 * This utility method returns a future or past date after/before number of
	 * days.
	 * 
	 * @param days
	 * @param format
	 *            sample format yyyy-MM-dd
	 * @return
	 */
	public static String getDateBeforeOrAfterDays(int days, String format)
	{
		Date tomorrow = new Date();
		DateFormat dateFormat = new SimpleDateFormat(format);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		tomorrow = cal.getTime();

		return dateFormat.format(tomorrow);
	}
	
	
	public static Map<String, String> getStartAndEndPeriod(String argPeriod) {
		
		Map<String, String> startAndEndDatesMap = new HashMap<String, String>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = getCurrentDate();
		String[] periods = argPeriod.split("-");
		int include91stAnd92ndDayInt = 0;
		
		if(argPeriod.contains("4-6"))
		include91stAnd92ndDayInt = 2;

		Date toDate = addMonths(currentDate, -Integer.parseInt(periods[0])+1);
		Date fromDate = addMonths(currentDate, -Integer.parseInt(periods[1]));
		Integer endPeriod = getNumberOfDays(toDate, currentDate)-include91stAnd92ndDayInt;
		Integer startPeriod = getNumberOfDays(fromDate, currentDate);
		
		fromDate=getPreviousDate(startPeriod);
		toDate=getPreviousDate(endPeriod);

		startAndEndDatesMap.put("fromDate", dateFormat.format(fromDate).toString());
		startAndEndDatesMap.put("toDate", dateFormat.format(toDate).toString());

		return startAndEndDatesMap;
	}



/**
* Gives number of days between two dates
* @param argStart for Start Date
* @param argEnd for End Date
* @return number of Days between two dates
*/
public static int getNumberOfDays(Date argStart, Date argEnd)
{
if (argStart.getTime() > argEnd.getTime())
{
    Date tmp = argStart;
    argStart = argEnd;
    argEnd = tmp;
}
GregorianCalendar cal = new GregorianCalendar();
cal.setTime(argStart);
int counter;
for (counter = 0; cal.getTime().before(argEnd); counter++)
{
    cal.add(Calendar.DAY_OF_MONTH, 1);
}
return counter;
}



/**
* Gives the current date and time.
* 
* @return Date
*/
public static java.util.Date getCurrentDate()
{
java.util.Date date = new java.util.Date();
Calendar cal = new GregorianCalendar();
cal.setTime(date);
return date;
}

public static Date addMonths(Date argStartDate, int argMonthsToAdd)
{
GregorianCalendar gc = new GregorianCalendar();
gc.setTime(argStartDate);
gc.add(Calendar.MONTH, argMonthsToAdd);
return gc.getTime();
}


public static java.util.Date getPreviousDate(int noOfDays)
{
Calendar currentDate = Calendar.getInstance();
Calendar previousDate = Calendar.getInstance();
previousDate.set(
    currentDate.get(Calendar.YEAR),
    currentDate.get(Calendar.MONTH),
    currentDate.get(Calendar.DATE) - noOfDays,
    currentDate.get(Calendar.HOUR_OF_DAY),
    currentDate.get(Calendar.MINUTE),
    currentDate.get(Calendar.SECOND));
return previousDate.getTime();
}


	
	
	
	
	/**
	 * This utility method returns a future or past datetime after/before number of
	 * seconds. 
	 * @param seconds
	 * @param format 
	 * 				sample format yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDateTimeAfterOrBeforeSeconds(int seconds, String format) {
		
		Date newDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat(format);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MILLISECOND, seconds);
		newDate = cal.getTime();

		return dateFormat.format(newDate);
	}

	
	/**
	 * This utility method returns a future or past Time after/before number of
	 * minutes.
	 * 
	 * @param minutes
	 * @param format
	 *            sample format yyyy-MM-dd
	 * @return
	 */
	public static String getTimeBeforeOrAfterMinutes(int minutes, String format)
	{
		Date tomorrow = new Date();
		DateFormat dateFormat = new SimpleDateFormat(format);

		Calendar cal = Calendar.getInstance();
		cal.setTime(tomorrow);
		cal.add(Calendar.MINUTE, minutes);
		tomorrow = cal.getTime();

		return dateFormat.format(tomorrow);
	}


	/**
	 * This method converts input to the NEW_FORMAT
	 * 		input should be in dd/MM/yyyy
	 * @param days
	 * @param NEW_FORMAT
	 * @param date
	 * @return
	 */
	public static String getDateBeforeOrAfterDays(int days, String NEW_FORMAT, String date)
	{

		String OLD_FORMAT = "dd/MM/yyyy";
		String newDateString = null;
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d = null;
		try
		{
			d = sdf.parse(date);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		sdf.applyPattern(NEW_FORMAT);
		newDateString = sdf.format(d);
		Calendar c = Calendar.getInstance();
		try
		{
			c.setTime(sdf.parse(newDateString));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		c.add(Calendar.DATE, days); // number of days to add
		return sdf.format(c.getTime()); // dt is now the new date

	}
	
	
	
	public static String getDateBeforeOrAfterDays(int days, String NEW_FORMAT, String date,String oldFormat)
	{

		String OLD_FORMAT = oldFormat;
		String newDateString = null;
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d = null;
		try
		{
			d = sdf.parse(date);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		sdf.applyPattern(NEW_FORMAT);
		newDateString = sdf.format(d);
		Calendar c = Calendar.getInstance();
		try
		{
			c.setTime(sdf.parse(newDateString));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		c.add(Calendar.DATE, days); // number of days to add
		return sdf.format(c.getTime()); // dt is now the new date

	}

	public static String getDateBeforeOrAfterYears(int years, String format)
	{
		Date tomorrow = new Date();
		DateFormat dateFormat = new SimpleDateFormat(format);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, years);
		tomorrow = cal.getTime();

		return dateFormat.format(tomorrow);
	}

	public static String getDatePreviousTo(int dd, int mm, int yyyy, String format)
	{
		Calendar date = new GregorianCalendar(yyyy, mm - 1, dd);
		date.add(Calendar.DAY_OF_YEAR, -1);
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date.getTime());
	}
	
	public static String getFourWeekStartingDate(String format)
	{
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(format);
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
		if (day_of_week == 1)
			day_of_week = 6;
		else
			day_of_week -= 2;
		cal.add(Calendar.DAY_OF_YEAR, (0 - day_of_week));
		cal.add(Calendar.WEEK_OF_YEAR, -3);
		return dateFormat.format(cal.getTime());
	}

	// Allure Attachment Helpers
	/**
	 * Generates HTML for RS
	 * 
	 * @param rs
	 *            - Result set from select query
	 * @return - HTML Table with data
	 */
	private static String getHtmlFor(ResultSet rs)
	{
		String htmlTable = "";
		java.sql.ResultSetMetaData rsmd = null;
		try
		{
			rsmd = rs.getMetaData();
			String tableName = rsmd.getTableName(1) + " Table";
			htmlTable = htmlTable + "<b>" + tableName + "</b> at " + Helper.getCurrentDateTime("hh:mm:ss a");
			boolean isEmpty = !rs.first();
			if (isEmpty)
			{
				return "<br>Resultset Is Empty</br>";
			}
			else
			{
				//int rowCount = 0;
				htmlTable = htmlTable + "<P ALIGN='center'><TABLE border='1px' style='border-collapse:collapse;' cellpadding='0' cellspacing='0'>";
				int columnCount;
				columnCount = rsmd.getColumnCount();
				// table header
				htmlTable = htmlTable + "<TR>";
				for (int i = 0; i < columnCount; i++)
				{
					htmlTable = htmlTable + "<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>";
				}
				htmlTable = htmlTable + "</TR>";
				// the data
				do
				{
					//rowCount++;
					htmlTable = htmlTable + "<TR>";
					for (int i = 0; i < columnCount; i++)
					{
						htmlTable = htmlTable + "<TD>" + rs.getString(i + 1) + "</TD>";
					}
					htmlTable = htmlTable + "</TR>";
				} while (rs.next());
				htmlTable = htmlTable + "</TABLE></P>";
				return htmlTable;
			}
		}
		catch (SQLException e2)
		{
			e2.printStackTrace();
			return "<br> SQL Exception <br>";
		}
	}

	/**
	 * Returns DateTime before or after based on days param
	 * 
	 * @param days
	 * @return
	 */
	public static String getNDaysBackMidNightTime(Integer days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -(days));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 00);
		cal.add(Calendar.MINUTE, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	/**
	 * Returns DateTime before or after based on days param
	 * 
	 * @param days
	 * @return
	 */
	public static String getNDaysBackTime(Integer days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -(days));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	/***
	 * Get end date of transactions ending at 00:00:00
	 * 
	 * @return
	 */
	public static String getTodayMidnightEndTime()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	public static String getThisWeekEndingDate(String format)
	{
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(format);
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DAY_OF_YEAR, (7 - day_of_week));
		return dateFormat.format(cal.getTime());
	}

	public static String getThisWeekStartingDate(String format)
	{
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(format);
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DAY_OF_YEAR, (1 - day_of_week));
		return dateFormat.format(cal.getTime());
	}

	/**
	 * Replaces the arguments like {$someArg} present in input string with its
	 * value from RuntimeProperties
	 * 
	 * @param input
	 *            string in which some Argument is present
	 * @return replaced string
	 */
	public static String replaceArgumentsWithRunTimeProperties(TestBase testBaseSetup, String input)
	{ 
		if (input.contains("{$"))
		{
			int firstIndex = input.indexOf("{$");
			int lastIndex=input.indexOf("}", firstIndex);
			String key = input.substring(firstIndex + 2, lastIndex);
			String value = testBaseSetup.getRunTimeProperty(key);
			input = input.replace("{$" + key + "}", value);
			return replaceArgumentsWithRunTimeProperties(testBaseSetup, input);
		}
		else
		{
			return input;
		}

	}

	/**
	 * Get the roundOff value to desired minimum fraction of digits.
	 * 
	 * @param roundOffValue
	 * @param minimumFractionDigits
	 * @return
	 */
	public static String roundOff(double roundOffValue, int minimumFractionDigits)
	{

		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(minimumFractionDigits);
		df.setRoundingMode(RoundingMode.HALF_UP);
		String strRoundOffValue = df.format(roundOffValue);
		return strRoundOffValue;
	}

	/**
	 * Get the roundOff value to desired maximum fraction of digits.
	 * 
	 * @param roundOffValue
	 * @param maxFractionDigits
	 * @return
	 */
	public static String roundOffToMaxDigits(double roundOffValue, int maxFractionDigits)
	{

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(maxFractionDigits);
		df.setRoundingMode(RoundingMode.HALF_UP);
		String strRoundOffValue = df.format(roundOffValue).replaceAll(",", "");
		return strRoundOffValue;
	}

	/**
	 * This method truncates/sacles the given number to specified number of
	 * decimals given
	 * 
	 * @param dNumber
	 * @param numberofDecimals
	 * @return
	 */
	public static String truncateDecimal(double dNumber, int numberofDecimals)
	{

		String trucatedValue = "";
		if (dNumber > 0)
		{
			BigDecimal number = new BigDecimal(String.valueOf(dNumber)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
			trucatedValue = String.valueOf(number);
			return trucatedValue;
		}
		else
		{
			BigDecimal number = new BigDecimal(String.valueOf(dNumber)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
			trucatedValue = String.valueOf(number);
			return trucatedValue;
		}
	}

	/**
	 * This Method is used to fetch number of day's in current month
	 * @return	: No .of days 
	 */
	public static int getNoOfDaysInParticularMonth()
	{
		int noOfDays = 0;
		String currentDate = Helper.getCurrentDate("yyyy/MM/dd HH:mm:ss");
		String currentMonths[] = currentDate.split("/");
		
		int currentMonth = Integer.parseInt(currentMonths[1]);

		switch (currentMonth)
		{
		case 1:
		case 2:
		case 4:
		case 6:
		case 8:
		case 9:
		case 11:
			noOfDays = -31;
			break;

		case 5:
		case 7:
		case 10:
		case 12:
			noOfDays = -30;
			break;

		case 3:
			if(isLeapYear(Integer.parseInt(currentMonths[0])))
			noOfDays = -29;
			else 
				noOfDays = -28;

		}
		return noOfDays;
	}
/**
 * Method is use to check is leap year
 * @param year
 * @return
 */
	public static boolean isLeapYear(int year)
	{
		boolean returnValue = false;
		 if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
			 returnValue =  true;
		 return returnValue;
		 
	}
	/**
	 * Get comma separated string from array
	 * @param testConfig
	 * @param actualArray
	 * 			 - Array to convert in comma separated string
	 * @return comma separated string
	 */
	public static String getCommaSeparatedStringFromArray(main.java.nativeFunctions.TestBase testConfig, String[] actualArray)
	{
		String comma = "";
		String commaSeperatedString = "";
		for(String value : actualArray)
		{
			commaSeperatedString = comma + value;
			comma = ",";
		}

		return commaSeperatedString;
	}
	/**
	 * This Method is used to create folder at given path
	 * @param path
	 * @return
	 */
	public static boolean createFolder(String path)
	{
		File newdir = new File(path);
		boolean result = false;
		if (!newdir.exists()) 
		{
			//System.out.println("Creating Directory : " + path);		  
			try
			{
				Files.createDirectories(Paths.get(path));
				System.out.println("Directory created successfully : " + path);
				result = true;
			}
			catch(Exception se)
			{
				System.out.println("========>>Exception while creating Directory : " + path);
				se.printStackTrace();
			}
		}
		else
		{
			System.out.println("Directory: " + path + " already Exist");
			result = true;
		}
		return result;
	}

	/**
	 * This function is used to update in an existing text file. (If file is not present then will create new file also)
	 * @param testConfig
	 * @param location
	 * @param textToUpdate
	 */
    public static void updateTextFile(main.java.nativeFunctions.TestBase testConfig, String location, String textToUpdate)
    {
		try
		{
			Path pathToFile = Paths.get(location);
			Files.createDirectories(pathToFile.getParent());
			
			File file = new File(location);
			if (!file.exists()) 
			{
				file.createNewFile();
			}
	 
			FileWriter fstream = new FileWriter(location, true);
			BufferedWriter out = new BufferedWriter(fstream);
	 
			out.write(textToUpdate+",");
			out.close();
			fstream.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
   	}

    /**
    * @param argv
    * this function returns hash-SHA-512
    * if passed arguments are abc,def,ghi
    * it will calculate hash for abc|def|ghi
    * @return hash
    */
    public static String getSHA512(String... argv){
    String hash = new String();
    String currentParamter = new String();
    if(null == argv[0]){
    hash = "";
    }
    else{
    hash = argv[0];
    }	
    for(int i = 1; i < argv.length; i++){
    	if(null == argv[i]){
    		currentParamter = "";
    	}
    	else{
    		currentParamter = argv[i];
    	}
    	hash = hash + "|" + currentParamter;
    }
    hash = DigestUtils.sha512Hex(hash);
    return hash;	
    }
    
    /** to extract values from postParameters from key passed in hash and generate hash string
     * @param apiPostParameter
     * @return SHA512 hashString
     */
    public static String getHashFromParameters(HashMap<String, String> apiPostParameter){
		
	String hash =apiPostParameter.get("hash");
	String hashString = new String();
	hashString = "";
	String parameters[] = hash.split("[|]");
	for(String currentKey:parameters){
		currentKey = currentKey.trim();
		String currentValue = apiPostParameter.get(currentKey).toString();
		if(StringUtils.isBlank(currentValue)){
			currentValue = "";
		}
		hashString += currentValue + "|"; 
	}
	hashString = hashString.substring(0, hashString.length()-1);
	String hashValue = new String();
	hashValue = Helper.getSHA512(hashString);
	return hashValue;
	}
    
    /**
     * Update given dateTime string
     * @param dateTime -> to be updated
     * @param hour -> to be updated with
     * @return dateTime String
     */
    public static String getDateTimeWithHourDifference(String dateTime, int hour)
    {
    	String[] actualdateTime = dateTime.split("\\."); //split dateTime string if passed as 2015-09-12 23:45:78.0
    	Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            date = formatter.parse(actualdateTime[0]); //parse actualDateTime given
            formatter.format(date); //change format of actualdateTime string to date
        }
        catch ( Exception e ){
            System.out.println(e);
        }
    
        Calendar cal = Calendar.getInstance();
        cal.setTime(date); //set dateTime into calendar
        cal.add(Calendar.HOUR, hour); //update dateTime with specified hours
        Date requireddateTime = cal.getTime(); //get dateTime after updating
        String updatedDateTime = formatter.format(requireddateTime); //change format of dateTime to dateTime string
        
        return updatedDateTime;
    }
    
    /**
     * Check List Contains Given String
     * @param list
     * @param stringToMatch
     * @return true/false
     */
    public static boolean listContainsString(List<String> list, String stringToMatch)
    {
        Iterator<String> iter = list.iterator();
        while(iter.hasNext())
        {
            String tempString = iter.next();
            if (tempString.contains(stringToMatch))
                return true;
        }
        return false;
    }
    
   /** Get last date of current month
     * @param format
     * @return lastDate
     */
    public static String getLastDateOfMonth(String format)
    {
    	Date today = new Date(); 

        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(today);  

        calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        Date lastDayOfMonth = calendar.getTime();  

        DateFormat sdf = new SimpleDateFormat(format);  
        return sdf.format(lastDayOfMonth);  
    }
    
    /**
     * Check whether two dates to be compared are same or not
     * @param testConfig
     * @param date1 
     * @param date2
     * @return true/false
     */
//    public static boolean isSameMonthDate(Config testConfig, String date1, String date2) {
//		String date1YearMonth = date1.substring(0, 7);
//		String date2YearMonth = date2.substring(0, 7);		
//		
//		testConfig.logComment("Comparing " + date1YearMonth + " with " + date2YearMonth);
//		
//		return date1YearMonth.equalsIgnoreCase(date2YearMonth);
//	}
    
    /**
     * Add two or more amounts and return amount rounded to two decimal places
     * @param testConfig
     * @param amount
     * @return
     */
    public static Double sumRoundedOff(main.java.nativeFunctions.TestBase testConfig, Double... amount) {

    	Double sum = amount[0];

    	for(int i = 1; i < amount.length; i++){

    		sum += amount[i];

    	}

    	return Double.valueOf(roundOffToMaxDigits(sum, 2));
    }

    /**Add two or more amounts and return amount rounded to two decimal places
     * @param testConfig
     * @param amount
     * @return
     */
    public static String sumRoundedOff(main.java.nativeFunctions.TestBase testConfig, String... amount) {

    	String sum = amount[0];

    	for(int i = 1; i < amount.length; i++){

    		sum = sumRoundedOff(testConfig, Double.valueOf(sum), Double.valueOf(amount[i])).toString();

    	}

    	return sum;
    }
    
    /**Subtract two or more amounts from first amount and return amount rounded to two decimal places
     * @param testConfig
     * @param amount
     * @return
     */
    public static Double subtractRoundedOff(main.java.nativeFunctions.TestBase testConfig, Double... amount) {

    	Double sum = amount[0];

    	for(int i = 1; i < amount.length; i++){

    		sum -= amount[i];

    	}

    	return Double.valueOf(roundOffToMaxDigits(sum, 2));
    }

    /**Subtract two or more amounts from first amount and return amount rounded to two decimal places
     * @param testConfig
     * @param amount
     * @return
     */
    public static String subtractRoundedOff(main.java.nativeFunctions.TestBase testConfig, String... amount) {

    	String sum = amount[0];

    	for(int i = 1; i < amount.length; i++){

    		sum = subtractRoundedOff(testConfig, Double.valueOf(sum), Double.valueOf(amount[i])).toString();

    	}

    	return sum;
    }

    /**
     * Replace String in File
     * @param testConfig
     * @param filePath
     * @param search
     * @param replacement
     */
//    public static void replaceStringInFile(Config testConfig, String filePath, String search, String replacement)
//    {
//    	File htmlFile= new File(filePath);
//    	try{
//    		
//	    	    FileReader fr = new FileReader(htmlFile);
//	    	    String s;
//	    	    String totalStr = "";
//	    	    try (BufferedReader br = new BufferedReader(fr)) {
//	
//	    	        while ((s = br.readLine()) != null) {
//	    	            totalStr += s;
//	    	        }
//	    	        totalStr = totalStr.replaceAll(search, replacement);
//	    	        FileWriter fw = new FileWriter(htmlFile);
//	    	    fw.write(totalStr);
//	    	    fw.close();
//	    	    
//    	    }
//    	}catch(Exception e){
//    	    testConfig.logException(e);
//    	}
//    }
    
    /**
     * Format Amount To Indian Currency
     * @param decimalValue
     * @param format
     * @return
     */
    public static String formatAmountToIndianCurrency(String decimalValue, int roundOffValue)
    {
    	String decimalFormat = "";
    	if(roundOffValue > 0)
    		decimalFormat = "." + StringUtils.repeat("0", roundOffValue);
    	
    	double value = Double.parseDouble(decimalValue);
    	if(value < 1000)
    	{
            return new DecimalFormat("##0" + decimalFormat).format(value);
        }
    	else
    	{
            double hundreds = value % 1000;
            int other = (int) (value / 1000);
            return new DecimalFormat(",##").format(other) + ',' + new DecimalFormat("000"+decimalFormat).format(hundreds);
        }
    }
    
    /**
     * Insert character on every n distance
     * @param original
     * @param distance
     * @param character
     * @return
     */
    public static String insertCharacterOnEveryNDistance(String original, int distance, String character)
    {
        StringBuilder sb = new StringBuilder();
        char[] charArrayOfOriginal = original.toCharArray();
        for(int ch = 0 ; ch < charArrayOfOriginal.length ; ch++)
        {
            if(ch % distance == 0)
                sb.append(character).append(charArrayOfOriginal[ch]);
            else
                sb.append(charArrayOfOriginal[ch]);
        }
        return sb.toString();
    }
    
    /**
	 * Function to return string with left padding
	 *
	 * @param data   Data that is to be converted
	 * @param length Length of converted data
	 * @param symbol Symbol that is to be appended
	 */
	public static String leftPad(String data, int length, String symbol) {
		
		if(data.length() > length)
			return data;
		while (data.length() < length)
			data = symbol + data;
		return data;
	}


	/**
	 * Function to return string with left padding
	 *
	 * @param data   Data that is to be converted
	 * @param length Length of converted data
	 * @param symbol Symbol that is to be appended
	 */
	public static String rightPad(String data, int length, String symbol) {
		
		if(data.length() > length)
			return data;
		while (data.length() < length)
			data = data + symbol;
		return data;
	}

	/**
	 * This method converts dateTime to date with time as 00:00:00
	 * @param dateToModify
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateTimeWithTimeAsZero(Date dateToModify) throws ParseException {
		Calendar cal = Calendar.getInstance();
        cal.setTime(dateToModify);
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime();
	}
	
	/**
	 * This method updates date time object by seconds passed as parameters
	 * 		Assumption: format is yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @param seconds
	 * @param format
	 * @return
	 */
	public static String updateDateTimeBySecs(String date, int seconds) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		Date tempDate = null;
		try{
			tempDate = dateFormat.parse(date);
			cal.setTime(tempDate);
			cal.add(Calendar.SECOND, seconds);
			date = dateFormat.format(cal.getTime());
		}catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/** This method returns the date after given number of days for the given date.
	 * @param date
	 * @return
	 */
	public static String changeDateTimeWRTDays(String date, int noOfDays) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, noOfDays);
		return sdf.format(c.getTime());
	}
	/**
	 *  Match string of list in given String
	 * @param fileString 
	 *      ---> String in which substring need to searach
	 * @param regex
	 *
	 * @return
	 *     ---> count of total match found
	 */
	public static int matchPDFText(String pdfText, String regex)
	{
		int count=0;
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(pdfText);
		while (m.find()){
		   count +=1;
		}
		return count;
	}

	
	
	public static long getEpochTime()
	{
	    return new Date().getTime();
	}
	
	public static String getUniqueEmailId()
	{
		long l=getEpochTime();
		return (DataProvider.EMAILID+l+"@abc.com");
	}
	
	public static int getUniqueTinNumber()
	{
		Random random = new Random(System.nanoTime());
        int randomInt=random.nextInt(1000000000)+1;
        while (String.valueOf(randomInt).length()!=9)
        {
        	randomInt=random.nextInt(1000000000)+1;
        }
		return randomInt;
	}

	public static int getUniqueNPINumber()
	{
		Random random = new Random(System.nanoTime());
        int randomInt=random.nextInt(1000000000)+1;
        while (String.valueOf(randomInt).length()!=10)
        {
        	randomInt=random.nextInt(1000000000)+1;
        }
		return randomInt;
	}
	
	public static void compareEquals(TestBase testConfig, String what,ArrayList<String> expected, ArrayList<String> actual) 
	{ 
		separateListValues(expected,";");
		if(expected.equals(actual))
			Log.Pass("Passed comparison of" + " " + what + ":" + "" + '\n' + "Expected was :" +" " + separateListValues(expected,";") + '\n' + "Actual is :" +" " +separateListValues(actual,";") );
		else 
			Log.Fail("Failed comparison of" + " " + what + ":" + "" + '\n' + "Expected was :" +" " + separateListValues(expected,";") + '\n' + "Actual is :" +" " +separateListValues(actual,";"));
	}

	public static void compareEquals(TestBase testConfig, String what,Map<String, String> expected, Map<String, String> actual) {
		if(expected.equals(actual))
			Log.Pass("Passed" + " " + what + ":" + "" + '\n' + "Expected was :" +" " + expected + '\n' + "Actual is :" +" " +actual );
		else 
			Log.Fail(what + ":" + "" + '\n' + "Expected was :" +" " + expected + '\n' + "Actual is :" +" " +actual);
		}


//	public static void compareMaps(TestBase testConfig,String what,Map<String, LinkedHashMap<String, String>> expected,Map<String, LinkedHashMap<String, String>> actual) 
//	{
//	   if(expected.equals(actual))
//			Log.Pass("Passed" + " " + what + "" + "<br>" + "Expected was :" +" " + expected + '\n' + "Actual is :" +" " +actual );
//			else 
//				Log.Fail("Failed" + what + ":" + "" + "<br>" + "Expected was :" +" " + expected + '\n' + "Actual is :" +" " +actual);
//	}
	
	public static void compareMaps(TestBase testConfig,String what,Map<String, LinkedHashMap<String, String>> expected,Map<String, LinkedHashMap<String, String>> actual) 
	{
		try{
		Set<String> expectedKeys = expected.keySet();	
		for (String key : expectedKeys) 
		{
	    	 if(expected.get(key).keySet() != null)
	    	  {
	    		 if(expected.get(key).keySet().equals(actual.get(key).keySet()))
	    		 { 
	    			Log.Comment("Verifying data for payment No : " + key);
	    	        for (String expectedInternalKey : expected.get(key).keySet()) 
	    		     {
	    	    	 if(expected.get(key).get(expectedInternalKey).equals(actual.get(key).get(expectedInternalKey)))
	    	    	   Log.Pass("Passed" + " " + what + "for " + " " + expectedInternalKey + '\n' + "Expected was :" + " " + expected.get(key).get(expectedInternalKey) + '\n' + "Actual is :" +" " +actual.get(key).get(expectedInternalKey));
	    	    	   else
	    	    		   Log.Fail("Failed" + " " + what + "for " + " " + expectedInternalKey + '\n' + "Expected was :" + " " + expected.get(key).get(expectedInternalKey) + '\n' + "Actual is :" +" " +actual.get(key).get(expectedInternalKey));
	    		      }
	    		  }
	    	  }
		}
	}	 
		catch (Exception e) {
			Log.Comment("Exception" + e);
		}
	}
	
	public static String separateListValues(List<String> list,String separator)
	{
		StringBuilder listOfString=new StringBuilder();
		for(String string:list)
			listOfString.append(StringUtils.join(string,"; "));
		return listOfString.toString();
	}
	
	public static void purgeDirectory(File dir)
	{
	    for (File file: dir.listFiles()) {
	        if (file.isFile()) 
	        	//purgeDirectory(file);
	        file.delete();
	    }
	    Log.Comment("Cleaned directory : " + dir.getAbsolutePath());
	}
	
	public static boolean isFileExist(File dir,String fileName)
	{
		boolean retun1=false;
		
		for (File file: dir.listFiles()) {
	        if (file.getName().equals(fileName))
	        {
	        Log.Pass(fileName+" File is downloaded successfully");
	       // file.delete();
	        retun1= true;
	        break;
	        }
//	        else
//	        {
//	        	retun1 = false;
//	        }
	    }	
		return retun1;
	}
	
	
	
	public static boolean PDFDownloadVerification(TestBase testConfig,WebElement elt,String namOfElement,String downloadedFile)
	{
		boolean isDownloaded=true;
		String filedir=System.getProperty("user.dir")+"\\Downloads";
		File fileDirectory=new File(filedir);
		purgeDirectory( fileDirectory);
		Element.clickByJS(testConfig, elt,downloadedFile);
		int i=0;
		while(! isFileExist(fileDirectory,downloadedFile))
		{
			i++;
			if (i>1000000)
			{
				isDownloaded=false;
				Log.Fail(downloadedFile+" File not downloaded");
				break;
			}
			else
			{
				Log.Pass(downloadedFile + "File is downloaded successfully" );
				break;
			}
		}
		return isDownloaded;
		
	}
	
	public static void compareLinkedMaps(TestBase testConfig,String what,LinkedHashMap<String, String> expected,LinkedHashMap<String, String> actual) 
	{
	   if(expected.keySet().equals(actual.keySet()))
	   {
		   for(String expectedKey : expected.keySet()) 
		   {
			   if(expected.get(expectedKey).equals(actual.get(expectedKey)))
	
				  Log.Pass("Passed" + " " + what + "for" + " " + expectedKey + '\n' + "Expected was :" + " " + expected.get(expectedKey) + '\n' + "Actual is :" +" " +actual.get(expectedKey));
    	    	   else
    	    		   Log.Fail("Failed" + " " + what + "for" + " " + expectedKey + '\n' + "Expected was :" + " " + expected.get(expectedKey) + '\n' + "Actual is :" +" " +actual.get(expectedKey));
    		     
			   }
				   
		   }
	   else 
	   {
		   Log.Fail("Expected key set was : " + expected.keySet() + " whereas actual key set is : " + actual.keySet());
	   }
	   }
	   


public static String addDays(String date, int days) throws ParseException {
		
		//Given Date in String format
		String oldDate = date;  
		
		//Specifying date format that matches the given date
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try{
		   //Setting the date to the given date
		   c.setTime(sdf.parse(oldDate));
		}catch(ParseException e){
			e.printStackTrace();
		 }
		   
		//Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, days);  
		//Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());  

		return newDate;
	   }
		
	public static void getDatesForSearchCriteria(TestBase testConfig,String searchCriteria) 
	{
	    String split[]=searchCriteria.split(" "); 
		if(split[split.length-1].contains("days"))
		{
			int LastNoOfdays=Integer.parseInt(split[split.length-2]);
			testConfig.putRunTimeProperty("fromDate",Helper.getDateBeforeOrAfterDays(-LastNoOfdays,"yyyy-MM-dd"));
			testConfig.putRunTimeProperty("toDate",Helper.getCurrentDate("yyyy-MM-dd"));
		}
		else 
		{
			String monthRange=(split[split.length-2]);
			Map<String, String> startAndEndDates = Helper.getStartAndEndPeriod(monthRange);
			testConfig.putRunTimeProperty("fromDate",startAndEndDates.get("fromDate").toString());
			testConfig.putRunTimeProperty("toDate",startAndEndDates.get("toDate").toString());
	
		}	
	}	
	
	public static void getPayerSchema(TestBase testConfig,String searchCriteria)
	{
		Helper.getDatesForSearchCriteria(testConfig, searchCriteria);
	     Map schema = DataBase.executeSelectQuery(testConfig,QUERY.GET_SCHEMA, 1);
	     testConfig.putRunTimeProperty("schema", schema.get("PAYR_SCHM_NM").toString().trim());
	     testConfig.putRunTimeProperty("PAYR_DSPL_NM", schema.get("PAYR_DSPL_NM").toString().trim());
	     testConfig.putRunTimeProperty("PAYR_835_ID", schema.get("PAYR_835_ID").toString().trim());
	}
	

	}


