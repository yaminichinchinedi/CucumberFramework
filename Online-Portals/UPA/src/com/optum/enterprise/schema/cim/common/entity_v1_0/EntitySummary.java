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
import com.optum.enterprise.schema.cim.common.payee_v1_0.PayeeSummary;
import com.optum.enterprise.schema.cim.common.payer_v1_0.PayerSummary;
import com.optum.enterprise.schema.cim.provider.provider_v1_0.ProviderSummary;


/**
 * <p>Java class for EntitySummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EntitySummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://enterprise.optum.com/schema/cim/common/Entity_v1_0}EntitySummaryGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntitySummary", propOrder = {
    "name",
    "addresses"
})
@XmlSeeAlso({
    PayeeSummary.class,
    PayerSummary.class,
    ProviderSummary.class
})
public class EntitySummary {

    @XmlElement(name = "Name", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    protected String name;
    @XmlElement(name = "Addresses", namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", required = true)
    protected List<Address> addresses;

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

}
