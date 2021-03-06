//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.api.finance.payables.provider.epspaymentmaintenanceservice_v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.multimedia_v1_0.TextFileContent;
import com.optum.enterprise.schema.cim.member.member_v1_0.MemberPayment;


/**
 * 
 * 				
 * 				Request for creating EPS Payment Data in Hadoop data store. Follows
 * 				the naming convention:<br/>
 * 				<DomainEntity><Operation><DatastoreName>Request.
 * 				<p/> 
 * 				Following describes the API usage scenarios for this CIM Request:
 * 				<ul>
 * 				<li>
 * 					Request URL: <b>http://localhost:8080/payment-hadoop-maintenance-rest-api-{version}/fisl/payment</b>
 * 					<br/>
 * 					Example Request URL: <b>http://localhost:8080/payment-hadoop-maintenance-rest-api-v1.0/fisl/payment</b>
 * 					<br/>
 * 					HTTP Method: <b>POST</b>
 * 					<br/>
 * 					HTTP Request Header If payload is XML: <b>Content-Type: application/vnd.optum.cim+xml</b>
 * 					HTTP Request Header If payload is XML: <b>application/vnd.optum.cim+json</b>
 * 					<br/>
 * 					HTTP Request Body Content containing CIM (XML) Request: <i>PaymentCreateHadoopRequest</i>.
 * 					<br/>
 * 					HTTP Response Body Content containing CIM Response: <b>PaymentMaintenanceService_v1_0.xsd->PaymentCreateHadoopResponse</b>
 * 				</li>
 * 				</ul>
 * 				
 * 			
 * 
 * <p>Java class for EpsPaymentDataCreateHadoopRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpsPaymentDataCreateHadoopRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}EpsConsolidatedClaimPayments" maxOccurs="500000"/>
 *           &lt;element ref="{http://enterprise.optum.com/schema/cim/member/Member_v1_0}MemberPayments" maxOccurs="500000"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}Edi835FileContent"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpsPaymentDataCreateHadoopRequest", propOrder = {
    "epsConsolidatedClaimPayments",
    "memberPayments",
    "edi835FileContent"
})
public class EpsPaymentDataCreateHadoopRequest {

    @XmlElement(name = "EpsConsolidatedClaimPayments")
    protected List<EpsConsolidatedClaimPayment> epsConsolidatedClaimPayments;
    @XmlElement(name = "MemberPayments", namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0")
    protected List<MemberPayment> memberPayments;
    @XmlElement(name = "Edi835FileContent", required = true)
    protected TextFileContent edi835FileContent;

    /**
     * Gets the value of the epsConsolidatedClaimPayments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the epsConsolidatedClaimPayments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpsConsolidatedClaimPayments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EpsConsolidatedClaimPayment }
     * 
     * 
     */
    public List<EpsConsolidatedClaimPayment> getEpsConsolidatedClaimPayments() {
        if (epsConsolidatedClaimPayments == null) {
            epsConsolidatedClaimPayments = new ArrayList<EpsConsolidatedClaimPayment>();
        }
        return this.epsConsolidatedClaimPayments;
    }

    /**
     * Gets the value of the memberPayments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the memberPayments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMemberPayments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MemberPayment }
     * 
     * 
     */
    public List<MemberPayment> getMemberPayments() {
        if (memberPayments == null) {
            memberPayments = new ArrayList<MemberPayment>();
        }
        return this.memberPayments;
    }

    /**
     * 
     * 						
     * 						MASOOD TBD: 
     * 						
     * 					
     * 
     * @return
     *     possible object is
     *     {@link TextFileContent }
     *     
     */
    public TextFileContent getEdi835FileContent() {
        return edi835FileContent;
    }

    /**
     * Sets the value of the edi835FileContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextFileContent }
     *     
     */
    public void setEdi835FileContent(TextFileContent value) {
        this.edi835FileContent = value;
    }

}
