//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.api.finance.payables.provider.edi835contentservice_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.api.finance.payables.provider.epspaymentmaintenanceservice_v1_0.ResponseReturnStatusType;
import com.optum.enterprise.schema.cim.common.multimedia_v1_0.TextFileContent;


/**
 * 
 * 				Returns the EDI 835 contents as encoded string.
 * 			
 * 
 * <p>Java class for EpsEdi835ContentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpsEdi835ContentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0}ResponseReturnStatus"/>
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
@XmlType(name = "EpsEdi835ContentResponse", propOrder = {
    "responseReturnStatus",
    "edi835FileContent"
})
public class EpsEdi835ContentResponse {

    @XmlElement(name = "ResponseReturnStatus", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected ResponseReturnStatusType responseReturnStatus;
    @XmlElement(name = "Edi835FileContent", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected TextFileContent edi835FileContent;

    /**
     * Gets the value of the responseReturnStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseReturnStatusType }
     *     
     */
    public ResponseReturnStatusType getResponseReturnStatus() {
        return responseReturnStatus;
    }

    /**
     * Sets the value of the responseReturnStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseReturnStatusType }
     *     
     */
    public void setResponseReturnStatus(ResponseReturnStatusType value) {
        this.responseReturnStatus = value;
    }

    /**
     * Gets the value of the edi835FileContent property.
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
