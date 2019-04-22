//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.member.member_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.identifier_v1_0.AbstractUniqueSystemIdentifier;


/**
 * 
 * 				This type caters for the business requirement, wherein Member
 * 				may have several unique identifiers within the
 * 				enterprise, and on top of it, third-party assigned identifiers
 * 				as well. We need to cater for all those identifiers. This type
 * 				fills that role.
 * 			
 * 
 * <p>Java class for UniqueMemberSystemIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UniqueMemberSystemIdentifier">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}AbstractUniqueSystemIdentifier">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UniqueMemberSystemIdentifier")
public class UniqueMemberSystemIdentifier
    extends AbstractUniqueSystemIdentifier
{


}
