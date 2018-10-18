//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.product.group_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for GroupSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://enterprise.optum.com/schema/cim/product/Group_v1_0}GroupSummaryGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupSummary", propOrder = {
    "groupIdentifier",
    "subGroupIdentifier",
    "name"
})
public class GroupSummary {

    @XmlElement(name = "GroupIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String groupIdentifier;
    @XmlElement(name = "SubGroupIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String subGroupIdentifier;
    @XmlElement(name = "Name", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0")
    protected String name;

    /**
     * 
     * 						This is the Business Identifier for the Group
     * 						which can also be saved/held in the parent type's
     * 						BusinessIdentifier field.We can use this field
     * 						or the parent type's BusinessIdentifier field
     * 						interchangeably. Service providers must fill in both of 
     * 						them with the same value.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupIdentifier() {
        return groupIdentifier;
    }

    /**
     * Sets the value of the groupIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupIdentifier(String value) {
        this.groupIdentifier = value;
    }

    /**
     * Gets the value of the subGroupIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubGroupIdentifier() {
        return subGroupIdentifier;
    }

    /**
     * Sets the value of the subGroupIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubGroupIdentifier(String value) {
        this.subGroupIdentifier = value;
    }

    /**
     * 
     * 						
     * 						Systems at Optum may not have Names of Groups. 
     * 						Oct, 3, 2016. Changing required to optional.
     * 						
     * 					
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

}
