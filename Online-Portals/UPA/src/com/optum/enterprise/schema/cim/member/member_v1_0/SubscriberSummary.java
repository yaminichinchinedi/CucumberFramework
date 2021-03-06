//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.member.member_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.optum.enterprise.schema.cim.product.group_v1_0.GroupThumbnail;


/**
 * <p>Java class for SubscriberSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/member/Member_v1_0}MemberSummary">
 *       &lt;sequence>
 *         &lt;group ref="{http://enterprise.optum.com/schema/cim/member/Member_v1_0}SubscriberSummaryGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberSummary", propOrder = {
    "subscriberIdentifier",
    "groupThumbnail"
})
public class SubscriberSummary
    extends MemberSummary
{

    @XmlElement(name = "SubscriberIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String subscriberIdentifier;
    @XmlElement(name = "GroupThumbnail", namespace = "http://enterprise.optum.com/schema/cim/product/Group_v1_0", required = true)
    protected GroupThumbnail groupThumbnail;

    /**
     * Gets the value of the subscriberIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberIdentifier() {
        return subscriberIdentifier;
    }

    /**
     * Sets the value of the subscriberIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberIdentifier(String value) {
        this.subscriberIdentifier = value;
    }

    /**
     * Gets the value of the groupThumbnail property.
     * 
     * @return
     *     possible object is
     *     {@link GroupThumbnail }
     *     
     */
    public GroupThumbnail getGroupThumbnail() {
        return groupThumbnail;
    }

    /**
     * Sets the value of the groupThumbnail property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupThumbnail }
     *     
     */
    public void setGroupThumbnail(GroupThumbnail value) {
        this.groupThumbnail = value;
    }

}
