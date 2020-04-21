package main.java.fislServices;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;

import org.apache.poi.util.SystemOutLogger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.java.reporting.Log;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadTagsfromFISLResponse {
	

	private File fXmlFile = new File(System.getProperty("user.dir")+"\\testxml.xml");
	
	
	
	
	public Map<String, List<String>> getNodesXML(String getResponse) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		
			try
			{
				FileWriter fileWriter = new FileWriter(fXmlFile);
				fileWriter.write(getResponse);
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(fXmlFile);		
		doc.getDocumentElement().normalize();
		Log.Comment("Root element :" + doc.getDocumentElement().getNodeName());
								
        NodeList nList1 = doc.getElementsByTagName("ns0:EpsRenderingProviders");
		NodeList nList = doc.getElementsByTagName("ns0:EpsPatient");
		NodeList nList2 = doc.getElementsByTagName("ns0:EpsClaimServices");
		NodeList nList3 = doc.getElementsByTagName("ns0:EpsSubscriber");
		NodeList nList4 = doc.getElementsByTagName("ns0:EpsClaims");
		
		
		List<String> resultList1 = new ArrayList();
		List<String> resultList2 = new ArrayList();
		List<String> resultList3 = new ArrayList();
		List<String> resultList5 = new ArrayList();
		List<String> resultList6 = new ArrayList();
		List<String> resultList7 = new ArrayList();
		List<String> resultList8 = new ArrayList();

		
	
		
		Map<String, List<String>> map = new HashMap();
		
		
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
            Node nNode = nList.item(temp);
			Log.Comment("\nCurrent Element :" + nNode.getNodeName());		
			  if (nNode.getNodeType() == Node.ELEMENT_NODE) 
			  {
                 Element eElement = (Element) nNode;
                 Log.Comment("Last Name : " + eElement.getElementsByTagName("ns0:PatientLastName").item(0).getTextContent());
				 resultList1.add(eElement.getElementsByTagName("ns0:PatientLastName").item(0).getTextContent());
				 Log.Comment("Account Number : " + eElement.getElementsByTagName("ns0:PatientAccountNumber").item(0).getTextContent());
				 resultList5.add(eElement.getElementsByTagName("ns0:PatientAccountNumber").item(0).getTextContent());
			   }
			 
		}
		
		


       ArrayList<String> resultList9 = new ArrayList<String>(); 
        
        // Traverse through the first list 
        for (String element : resultList1) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!resultList9.contains(element)) { 
  
            	resultList9.add(element); 
            } 
        } 
  
        map.put("personLastName", resultList9);
		
		//map.put("personLastName", resultList1);
		map.put("PatientAccountNumber", resultList5);
		
		
		for (int temp = 0; temp < nList3.getLength(); temp++) 
		{
            Node nNode3 = nList3.item(temp);
			Log.Comment("\nCurrent Element :" + nNode3.getNodeName());		
			  if (nNode3.getNodeType() == Node.ELEMENT_NODE) 
			  {
                 Element eElement = (Element) nNode3;
                 Log.Comment("Subscriber First Name : " + eElement.getElementsByTagName("ns2:FirstName").item(0).getTextContent());
				 resultList6.add(eElement.getElementsByTagName("ns2:FirstName").item(0).getTextContent());
				 Log.Comment("Subscriber Last Name : " + eElement.getElementsByTagName("ns2:LastName").item(0).getTextContent());
				 resultList7.add(eElement.getElementsByTagName("ns2:LastName").item(0).getTextContent());
			   }
			 
		}
		
		map.put("subscriberFirstName", resultList6);
		map.put("subscriberLastName", resultList7);
		
		
		for (int temp = 0; temp < nList4.getLength(); temp++) 
		{
            Node nNode4 = nList4.item(temp);
			Log.Comment("\nCurrent Element :" + nNode4.getNodeName());		
			  if (nNode4.getNodeType() == Node.ELEMENT_NODE) 
			  {
                 Element eElement = (Element) nNode4;
                 Log.Comment("Claim Identifier : " + eElement.getElementsByTagName("ns3:ClaimIdentifier").item(0).getTextContent());
				 resultList8.add(eElement.getElementsByTagName("ns3:ClaimIdentifier").item(0).getTextContent());
				
			   }
			 
		}
		
		map.put("claimIdentifier", resultList8);
		
		
		
        for (int temp = 0; temp < nList1.getLength(); temp++) 
        {
            Node nNode1 = nList1.item(temp);
			Log.Comment("\nCurrent Element :" + nNode1.getNodeName());	
			  if (nNode1.getNodeType() == Node.ELEMENT_NODE) 
			  {

				Element eElement = (Element) nNode1;
                Log.Comment("Last Name : " + eElement.getElementsByTagName("ns2:LastName").item(0).getTextContent());
				resultList2.add(eElement.getElementsByTagName("ns2:LastName").item(0).getTextContent());
			  }
		 }
        
        
        ArrayList<String> resultList10 = new ArrayList<String>(); 
        
        // Traverse through the first list 
        for (String element : resultList2) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!resultList10.contains(element)) { 
  
            	resultList10.add(element);
            } 
        } 
  
        HashSet<String> listToSet = new HashSet<String>(resultList10);
        
        List<String> listWithoutDuplicates = new ArrayList<String>(listToSet);
        
        System.out.println(listWithoutDuplicates);
        
        map.put("epsRenderingProviders", listWithoutDuplicates);
        
      
      //  map.put("epsRenderingProviders", resultList2);
        
        
        for (int temp = 0; temp < nList2.getLength(); temp++) 
        {
            Node nNode2 = nList2.item(temp);
			Log.Comment("\nCurrent Element :" + nNode2.getNodeName());	
			  if (nNode2.getNodeType() == Node.ELEMENT_NODE) 
			  {

				Element eElement = (Element) nNode2;
                Log.Comment("Description of Service : " + eElement.getElementsByTagName("ns0:EpsServiceDescription").item(0).getTextContent());
				resultList3.add(eElement.getElementsByTagName("ns0:EpsServiceDescription").item(0).getTextContent());
				
			  }
		 }
        
        ArrayList<String> resultList4 = new ArrayList<String>(); 
        
        // Traverse through the first list 
        for (String element : resultList3) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!resultList4.contains(element)) { 
  
            	resultList4.add(element); 
            } 
        } 
  
        map.put("descOfServicesFISL", resultList4);
        
        return map;
	}
	
	
	public String deleteFileData() throws FileNotFoundException
	{
        PrintWriter writer = new PrintWriter(fXmlFile);
		writer.print("");
		writer.close();
		return "Successfully delete content from file";
	}
}
