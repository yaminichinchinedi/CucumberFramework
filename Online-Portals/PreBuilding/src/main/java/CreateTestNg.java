package main.java;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateTestNg {

					static String filepath = "C:\\jenkins\\workspace\\testingAutomation\\Online-Portals\\UPA\\testing.xml";
					public static void main(String argv[]) {
						String testSuiteName=System.getProperty("testSuite");
						String testClassName=System.getProperty("testModule");
						
						String[] testclasses=testClassName.split(",");
						
						
						Map<String, LinkedHashMap<String, ArrayList<String>>> map =getTestXML();
						try {

							DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
							DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
							Document doc = docBuilder.newDocument();
								Element rootEle = createSuite(doc, testSuiteName);
								doc.appendChild(rootEle);
								addListners(rootEle, doc);
								System.out.println("#####" + testSuiteName);
								for(String test :testclasses ){
									Element testEle = createTest(doc, test);
									System.out.println("*****" + map.get(testSuiteName).get(test));
									Element classes = doc.createElement("classes");
									rootEle.appendChild(testEle);
									testEle.appendChild(classes);
									for (String str : map.get(testSuiteName).get(test)) {
										classes.appendChild(createClass(doc, str));
										System.out.println(str);
									}
								}
							saveFile(doc);

						}catch (Exception e) {
							e.printStackTrace();
						}
					}

					public static Element createSuite(Document doc, String value) {
						Element rootElement = doc.createElement("suite");
						Attr attr = doc.createAttribute("name");
						attr.setValue(value);
						rootElement.setAttributeNode(attr);
						attr = doc.createAttribute("parallel");
						attr.setValue("tests");
						rootElement.setAttributeNode(attr);
						attr = doc.createAttribute("thread-count");
						attr.setValue("2");
						rootElement.setAttributeNode(attr);
						return rootElement;
					}

					public static Element createTest(Document doc, String value) {
						Element test = doc.createElement("test");
						// set attribute to staff element
						Attr attr1 = doc.createAttribute("name");
						attr1.setValue(value);
						test.setAttributeNode(attr1);
						return test;
					}

					public static Element createClass(Document doc, String value) {
						Element clas = doc.createElement("class");
						Attr attr2 = doc.createAttribute("name");
						attr2.setValue(value);
						clas.setAttributeNode(attr2);
						return clas;
					}

					public static void addListners(Element rootElement, Document doc) {
						Element Element1 = doc.createElement("listeners");
						rootElement.appendChild(Element1);

						Element Element2 = doc.createElement("listener");
						Attr attr = doc.createAttribute("class-name");
						attr.setValue("org.uncommons.reportng.HTMLReporter");
						Element2.setAttributeNode(attr);
						Element1.appendChild(Element2);

						Element Element3 = doc.createElement("listener");
						attr = doc.createAttribute("class-name");
						attr.setValue("org.uncommons.reportng.JUnitXMLReporter");
						Element3.setAttributeNode(attr);
						Element1.appendChild(Element3);

					}

					public static void saveFile(Document doc) {

						try {
							TransformerFactory transformerFactory = TransformerFactory.newInstance();
							Transformer transformer = transformerFactory.newTransformer();
							DOMSource source = new DOMSource(doc);
							StreamResult result = new StreamResult(new File(filepath));
							transformer.transform(source, result);
							System.out.println("File saved !! ");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				
						public static Map<String,LinkedHashMap<String,ArrayList<String>>> getTestXML(){
							Map<String,LinkedHashMap<String,ArrayList<String>>> map = new LinkedHashMap<String,LinkedHashMap<String,ArrayList<String>>>();
							LinkedHashMap<String,ArrayList<String>> mapList ;
							ArrayList<String> list;
							try{				
								File myFile = new File(System.getProperty("user.dir")+"\\Online-Portals\\PreBuilding\\TestCases.xlsx");
								FileInputStream fis = new FileInputStream(myFile);
							
								// Finds the workbook instance for XLSX file 
								XSSFWorkbook myWorkBook = new XSSFWorkbook (fis); 
								
								// Return first sheet from the XLSX 
								XSSFSheet mySheet = myWorkBook.getSheetAt(1);
								
								//Get iterator to all the rows in current sheet
							     Iterator<Row> rowIterator = mySheet.iterator();
							   
							     //Traversing over each row of XLSX file 
							 
							     
							     while (rowIterator.hasNext()) 
							     { 
								   Row row = rowIterator.next(); 
								   if(row.getRowNum()< 1){
									 continue;
								 }
								 
								 String suiteName=row.getCell(0).toString();
								 String testName=row.getCell(1).toString();
								 String className=row.getCell(2).toString();
								 
								 if(map.containsKey(suiteName)){
									 if(map.get(suiteName).containsKey(testName)){
										 map.get(suiteName).get(testName).add(className);
									 }else{
										 list= new ArrayList<String>();
										 list.add(className);
										 map.get(suiteName).put(testName, list);
									 }
								 }else
								 {
									 list= new ArrayList<String>();
									 mapList = new LinkedHashMap<String,ArrayList<String>>();
									 list.add(className);		
									 mapList.put(testName, list);
									 map.put(suiteName, mapList);
								 } 
							 }
							 System.out.println(map);
							 }catch(Exception e){e.printStackTrace();}
							return map;
						}
		

}
