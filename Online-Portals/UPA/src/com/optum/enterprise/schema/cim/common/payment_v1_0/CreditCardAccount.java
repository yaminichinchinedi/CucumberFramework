//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.payment_v1_0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.optum.enterprise.schema.cim.common.code_v1_0.CreditCardTypeCode;
import com.optum.enterprise.schema.cim.common.common_v1_0.AbstractNamedDescription;


/**
 * <p>Java class for CreditCardAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditCardAccount">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}AbstractNamedDescription">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CreditCardTypeCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}CreditCardNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}CreditCardExpirationMonth"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}CreditCardExpirationYear"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}CreditCardEncryptedToken" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditCardAccount", propOrder = {
    "creditCardTypeCode",
    "creditCardNumber",
    "creditCardExpirationMonth",
    "creditCardExpirationYear",
    "creditCardEncryptedToken"
})
public class CreditCardAccount
    extends AbstractNamedDescription
{

    @XmlElement(name = "CreditCardTypeCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected CreditCardTypeCode creditCardTypeCode;
    @XmlElement(name = "CreditCardNumber", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected String creditCardNumber;
    @XmlElement(name = "CreditCardExpirationMonth", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String creditCardExpirationMonth;
    @XmlElement(name = "CreditCardExpirationYear", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected BigInteger creditCardExpirationYear;
    @XmlElement(name = "CreditCardEncryptedToken", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0")
    protected String creditCardEncryptedToken;

    /**
     * Gets the value of the creditCardTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardTypeCode }
     *     
     */
    public CreditCardTypeCode getCreditCardTypeCode() {
        return creditCardTypeCode;
    }

    /**
     * Sets the value of the creditCardTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardTypeCode }
     *     
     */
    public void setCreditCardTypeCode(CreditCardTypeCode value) {
        this.creditCardTypeCode = value;
    }

    /**
     * 
     * 								
     * 								This can also serve as a <code>BusinessIdentifier</code>
     * 								for this object.
     * 								
     * 							
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Sets the value of the creditCardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardNumber(String value) {
        this.creditCardNumber = value;
    }

    /**
     * Gets the value of the creditCardExpirationMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardExpirationMonth() {
        return creditCardExpirationMonth;
    }

    /**
     * Sets the value of the creditCardExpirationMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardExpirationMonth(String value) {
        this.creditCardExpirationMonth = value;
    }

    /**
     * Gets the value of the creditCardExpirationYear property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCreditCardExpirationYear() {
        return creditCardExpirationYear;
    }

    /**
     * Sets the value of the creditCardExpirationYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCreditCardExpirationYear(BigInteger value) {
        this.creditCardExpirationYear = value;
    }

    /**
     * Gets the value of the creditCardEncryptedToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardEncryptedToken() {
        return creditCardEncryptedToken;
    }

    /**
     * Sets the value of the creditCardEncryptedToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardEncryptedToken(String value) {
        this.creditCardEncryptedToken = value;
    }

}