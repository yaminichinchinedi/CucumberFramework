//package test.java;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.swing.JToolBar.Separator;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.stream.StreamResult;
//import javax.xml.transform.stream.StreamSource;
//
//import net.sf.cglib.core.Transformer;
//
////import nl.fountain.xelem.excel.Workbook;
////import nl.fountain.xelem.lex.ExcelReader;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
////import EasyXLS.*;
//public class testReadExcel {
//
//	public static void main(String[] args) throws IOException, TransformerConfigurationException {
//		
//		ArrayList <String> c1 = new ArrayList <String> ();
//		ArrayList<String> p=new ArrayList<String>();
//		  c1.add("09/08/2018");
//		  c1.add("");
//		  c1.add("09/15/2018");
//		  c1.add("10/12/2018");
//		  c1.add("");
//		  System.out.println("\nOriginal array list: " + c1);
//		  
//		  for(String s: c1)
//			  if(s=="")
//				  continue;
//			  else 
//				  p.add(s);
//				  
//		  System.out.println("After iterating: "+p);
//		  
//		  
//		  /*
//		  System.out.println("\nPrint using index of an element: ");
//		  StringBuilder s=new StringBuilder("[");
//		  for(String s1: c1)
//			  s.append(s1+"; ");
//		  s.append("]");
//		  System.out.println(s);*/
//	}
//}
