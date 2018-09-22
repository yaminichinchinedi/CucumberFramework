//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.entity_v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.address_v1_0.Address;
import com.optum.enterprise.schema.cim.common.contact_v1_0.Email;
import com.optum.enterprise.schema.cim.common.payee_v1_0.Payee;
import com.optum.enterprise.schema.cim.common.payer_v1_0.Payer;
import com.optum.enterprise.schema.cim.common.phone_v1_0.Phone;
import com.optum.enterprise.schema.cim.provider.provider_v1_0.Provider;


/**
 * 
 * 				Entity is an organization. It represents a Company, or a School,
 * 				or a Law Firm etc.
 * 			
 * 
 * <p>Java class for Entity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Entity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://enterprise.optum.com/schema/cim/common/Entity_v1_0}EntitySummaryGroup"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Phone_v1_0}Phones" maxOccurs="4"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Contact_v1_0}Emails" maxOccurs="2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Entity", propOrder = {
    "name",
    "addresses",
    "phones",
    "emails"
})
@XmlSeeAlso({
    Payee.class,
    Payer.class,
    Provider.class
})
public abstract class Entity {

    @XmlElement(name = "Name", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected String name;
    @XmlElement(name = "Addresses", namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", required = true)
    protected List<Address> addresses;
    @XmlElement(name = "Phones", namespace = "http://enterprise.optum.com/schema/cim/common/Phone_v1_0", required = true)
    protected List<Phone> phones;
    @XmlElement(name = "Emails", namespace = "http://enterprise.optum.com/schema/cim/common/Contact_v1_0")
    protected List<Email> emails;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 
     * 						Specifies different addresses for a person. Total 6
     * 						which is the number of enums in address:AddressTypeEnum.
     * 						PRIMARY_ADDRESS, SECONDARY_ADDRESS, RESIDENCE, 
     * 						BUSINESS_ADDRESS, SHIPPING_ADDRESS, 
     * 						BILLING_ADDRESS.
     * 					Gets the value of the addresses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addresses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddresses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Address }
     * 
     * 
     */
    public List<Address> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<Address>();
        }
        return this.addresses;
    }

    /**
     * 
     * 						Specifies different phone numbers for a person. FAX,
     * 						HOME_PHONE, MOBILE_PHONE, WORK_PHONE.
     * 					Gets the value of the phones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Phone }
     * 
     * 
     */
    public List<Phone> getPhones() {
        if (phones == null) {
            phones = new ArrayList<Phone>();
        }
        return this.phones;
    }

    /**
     * 
     * 						Specifies different email addresses for a person. Total
     * 						2 which is the number of enums in address:EmailTypeEnum.
     * 						WORK_EMAIL, PERSONAL_EMAIL.
     * 					Gets the value of the emails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Email }
     * 
     * 
     */
    public List<Email> getEmails() {
        if (emails == null) {
            emails = new ArrayList<Email>();
        }
        return this.emails;
    }

}
