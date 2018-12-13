//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.person_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.code_v1_0.UniquePersonIdentifierTypeCode;
import com.optum.enterprise.schema.cim.common.identifier_v1_0.AbstractUniqueSystemIdentifier;


/**
 * 
 * 				This type caters for the business requirement, wherein Person
 * 				may have several unique identifiers within the
 * 				enterprise, and on top of it, third-party assigned identifiers
 * 				as well. We need to cater for all those identifiers. This type
 * 				fills that role.
 * 			
 * 
 * <p>Java class for UniquePersonSystemIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UniquePersonSystemIdentifier">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}AbstractUniqueSystemIdentifier">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}UniquePersonIdentifierTypeCode"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UniquePersonSystemIdentifier", propOrder = {
    "uniquePersonIdentifierTypeCode"
})
public class UniquePersonSystemIdentifier
    extends AbstractUniqueSystemIdentifier
{

    @XmlElement(name = "UniquePersonIdentifierTypeCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected UniquePersonIdentifierTypeCode uniquePersonIdentifierTypeCode;

    /**
     * 
     * 								Specifies type of Unique Person Identifier.
     * 							
     * 
     * @return
     *     possible object is
     *     {@link UniquePersonIdentifierTypeCode }
     *     
     */
    public UniquePersonIdentifierTypeCode getUniquePersonIdentifierTypeCode() {
        return uniquePersonIdentifierTypeCode;
    }

    /**
     * Sets the value of the uniquePersonIdentifierTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniquePersonIdentifierTypeCode }
     *     
     */
    public void setUniquePersonIdentifierTypeCode(UniquePersonIdentifierTypeCode value) {
        this.uniquePersonIdentifierTypeCode = value;
    }

}