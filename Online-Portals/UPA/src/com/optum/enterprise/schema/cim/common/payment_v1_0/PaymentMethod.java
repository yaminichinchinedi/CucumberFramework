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
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.code_v1_0.PaymentMethodCode;


/**
 * 
 * 				
 * 				Represents a Payment Method by which a Payment is made.
 * 				
 * 			
 * 
 * <p>Java class for PaymentMethod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentMethod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Payment_v1_0}BankAccount"/>
 *           &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Payment_v1_0}CreditCardAccount"/>
 *           &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Payment_v1_0}BankCheck"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}PaymentMethodCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentMethod", propOrder = {
    "bankAccount",
    "creditCardAccount",
    "bankCheck",
    "paymentMethodCode"
})
public class PaymentMethod {

    @XmlElement(name = "BankAccount")
    protected BankAccount bankAccount;
    @XmlElement(name = "CreditCardAccount")
    protected CreditCardAccount creditCardAccount;
    @XmlElement(name = "BankCheck")
    protected BankCheck bankCheck;
    @XmlElement(name = "PaymentMethodCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected PaymentMethodCode paymentMethodCode;

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

    /**
     * Gets the value of the creditCardAccount property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardAccount }
     *     
     */
    public CreditCardAccount getCreditCardAccount() {
        return creditCardAccount;
    }

    /**
     * Sets the value of the creditCardAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardAccount }
     *     
     */
    public void setCreditCardAccount(CreditCardAccount value) {
        this.creditCardAccount = value;
    }

    /**
     * Gets the value of the bankCheck property.
     * 
     * @return
     *     possible object is
     *     {@link BankCheck }
     *     
     */
    public BankCheck getBankCheck() {
        return bankCheck;
    }

    /**
     * Sets the value of the bankCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankCheck }
     *     
     */
    public void setBankCheck(BankCheck value) {
        this.bankCheck = value;
    }

    /**
     * Gets the value of the paymentMethodCode property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethodCode }
     *     
     */
    public PaymentMethodCode getPaymentMethodCode() {
        return paymentMethodCode;
    }

    /**
     * Sets the value of the paymentMethodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethodCode }
     *     
     */
    public void setPaymentMethodCode(PaymentMethodCode value) {
        this.paymentMethodCode = value;
    }

}