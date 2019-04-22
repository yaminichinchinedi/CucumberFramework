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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.optum.enterprise.schema.cim.common.code_v1_0.PersonRelationshipCode;
import com.optum.enterprise.schema.cim.common.person_v1_0.Person;


/**
 * <p>Java class for Member complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Member">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Person_v1_0}Person">
 *       &lt;sequence>
 *         &lt;group ref="{http://enterprise.optum.com/schema/cim/member/Member_v1_0}MemberSummaryGroup"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}PersonRelationshipCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Member", propOrder = {
    "memberIdentifier",
    "uniqueMemberSystemIdentifiers",
    "personRelationshipCode"
})
@XmlSeeAlso({
    Subscriber.class
})
public class Member
    extends Person
{

    @XmlElement(name = "MemberIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String memberIdentifier;
    @XmlElement(name = "UniqueMemberSystemIdentifiers")
    protected UniqueMemberSystemIdentifier uniqueMemberSystemIdentifiers;
    @XmlElement(name = "PersonRelationshipCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected PersonRelationshipCode personRelationshipCode;

    /**
     * Gets the value of the memberIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberIdentifier() {
        return memberIdentifier;
    }

    /**
     * Sets the value of the memberIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberIdentifier(String value) {
        this.memberIdentifier = value;
    }

    /**
     * Gets the value of the uniqueMemberSystemIdentifiers property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueMemberSystemIdentifier }
     *     
     */
    public UniqueMemberSystemIdentifier getUniqueMemberSystemIdentifiers() {
        return uniqueMemberSystemIdentifiers;
    }

    /**
     * Sets the value of the uniqueMemberSystemIdentifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueMemberSystemIdentifier }
     *     
     */
    public void setUniqueMemberSystemIdentifiers(UniqueMemberSystemIdentifier value) {
        this.uniqueMemberSystemIdentifiers = value;
    }

    /**
     * 
     * 								
     * 								Specifies relation of the member to the 
     * 								Subscriber.
     * 								
     * 							
     * 
     * @return
     *     possible object is
     *     {@link PersonRelationshipCode }
     *     
     */
    public PersonRelationshipCode getPersonRelationshipCode() {
        return personRelationshipCode;
    }

    /**
     * Sets the value of the personRelationshipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonRelationshipCode }
     *     
     */
    public void setPersonRelationshipCode(PersonRelationshipCode value) {
        this.personRelationshipCode = value;
    }

}
