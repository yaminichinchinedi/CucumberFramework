package main.java.api.pojo.epsClaimsRequest.request;
 
//See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Any modifications to this file will be lost upon recompilation of the source schema. 
//Generated on: 2017.10.03 at 12:32:33 PM CDT 
//




import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import main.java.api.pojo.epspaymentsearch.request.SearchByCriteriaRequest;
import main.java.api.pojo.epspaymentsearch.request.ServiceData;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpsClaimsRequest", propOrder = {
 "serviceData",
 "paymentIdentifier",
 "claimFilterTypeCode"
})
public class EpsClaimsRequest
 extends SearchByCriteriaRequest
{

 @XmlElement(name = "ServiceData", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
 protected ServiceData serviceData;
 @XmlElement(name = "PaymentIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0", required = true)
 @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
 protected String paymentIdentifier;
 @XmlElement(name = "ClaimFilterTypeCode", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
 protected String claimFilterTypeCode;

 /**
  * Gets the value of the serviceData property.
  * 
  * @return
  *     possible object is
  *     {@link ServiceData }
  *     
  */
 public ServiceData getServiceData() {
     return serviceData;
 }

 /**
  * Sets the value of the serviceData property.
  * 
  * @param value
  *     allowed object is
  *     {@link ServiceData }
  *     
  */
 public void setServiceData(ServiceData value) {
     this.serviceData = value;
 }

 /**
  * Gets the value of the paymentIdentifier property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getPaymentIdentifier() {
     return paymentIdentifier;
 }

 /**
  * Sets the value of the paymentIdentifier property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setPaymentIdentifier(String value) {
     this.paymentIdentifier = value;
 }

 /**
  * Gets the value of the claimFilterTypeCode property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getClaimFilterTypeCode() {
     return claimFilterTypeCode;
 }

 /**
  * Sets the value of the claimFilterTypeCode property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setClaimFilterTypeCode(String value) {
     this.claimFilterTypeCode = value;
 }

}

