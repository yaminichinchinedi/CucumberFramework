package main.java.api.pojo.epspaymentsearch.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import main.java.api.pojo.epsClaimsRequest.request.EpsClaimsRequest;
import main.java.api.pojo.epsPaymentDetailRequest.request.EpsPaymentDetailRequest;



/**
* 
* 				These request are by nature synchronous, so no need
* 				to extend the
* 				Request type.
* 			
* 
* <p>Java class for SearchByCriteriaRequest complex type.
* 
* <p>The following schema fragment specifies the expected content contained within this class.
* 
* <pre>
* &lt;complexType name="SearchByCriteriaRequest">
*   &lt;complexContent>
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
*       &lt;sequence>
*         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Service_v1_0}SearchCriteria"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchByCriteriaRequest", propOrder = {
 "searchCriteria"
})
@XmlSeeAlso({
    EpsClaimsRequest.class,
    EpsPaymentDetailRequest.class,
    EpsPaymentsSearchRequest.class
})
public class SearchByCriteriaRequest {

 @XmlElement(name = "SearchCriteria", required = true)
 protected SearchCriteria searchCriteria;

 /**
  * Gets the value of the searchCriteria property.
  * 
  * @return
  *     possible object is
  *     {@link SearchCriteria }
  *     
  */
 public SearchCriteria getSearchCriteria() {
     return searchCriteria;
 }

 /**
  * Sets the value of the searchCriteria property.
  * 
  * @param value
  *     allowed object is
  *     {@link SearchCriteria }
  *     
  */
 public void setSearchCriteria(SearchCriteria value) {
     this.searchCriteria = value;
 }

}

