//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.payment_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.optum.enterprise.schema.cim.common.common_v1_0.Currency;


/**
 * <p>Java class for BankCheck complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BankCheck">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}CheckNumber"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}CheckDate"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}CheckAmount"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Payment_v1_0}BankAccount"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankCheck", propOrder = {
    "checkNumber",
    "checkDate",
    "checkAmount",
    "bankAccount"
})
public class BankCheck {

    @XmlElement(name = "CheckNumber", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0")
    protected long checkNumber;
    @XmlElement(name = "CheckDate", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkDate;
    @XmlElement(name = "CheckAmount", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected Currency checkAmount;
    @XmlElement(name = "BankAccount", required = true)
    protected BankAccount bankAccount;

    /**
     * Gets the value of the checkNumber property.
     * 
     */
    public long getCheckNumber() {
        return checkNumber;
    }

    /**
     * Sets the value of the checkNumber property.
     * 
     */
    public void setCheckNumber(long value) {
        this.checkNumber = value;
    }

    /**
     * Gets the value of the checkDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckDate() {
        return checkDate;
    }

    /**
     * Sets the value of the checkDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckDate(XMLGregorianCalendar value) {
        this.checkDate = value;
    }

    /**
     * Gets the value of the checkAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCheckAmount() {
        return checkAmount;
    }

    /**
     * Sets the value of the checkAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCheckAmount(Currency value) {
        this.checkAmount = value;
    }

    /**
     * Gets the value of the bankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link BankAccount }
     *     
     */
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the value of the bankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccount }
     *     
     */
    public void setBankAccount(BankAccount value) {
        this.bankAccount = value;
    }

}
