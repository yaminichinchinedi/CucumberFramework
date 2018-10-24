//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.identifier_v1_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UniqueIdentifierTypeCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UniqueIdentifierTypeCodeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="PRIMARY"/>
 *     &lt;enumeration value="SSN"/>
 *     &lt;enumeration value="TIN"/>
 *     &lt;enumeration value="THIRD_PARTY"/>
 *     &lt;enumeration value="CARRIER_ASSIGNED"/>
 *     &lt;enumeration value="SENDER_ASSIGNED"/>
 *     &lt;enumeration value="RECEIVER_ASSIGNED"/>
 *     &lt;enumeration value="LEGACY"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UniqueIdentifierTypeCodeEnum")
@XmlEnum
public enum UniqueIdentifierTypeCodeEnum {


    /**
     * 
     * 						Primary unique identifier.This must be specified if no
     * 						other identifiers types are specified.
     * 					
     * 
     */
    PRIMARY,

    /**
     * Social Security Number
     * 
     */
    SSN,

    /**
     * Tax Identification Number
     * 
     */
    TIN,

    /**
     * Third party assigned
     * 
     */
    THIRD_PARTY,

    /**
     * 
     * 						Carrier/Insurer assigned. In Optum domain Carrier/Insurer
     * 						will always be considered as Optum.
     * 					
     * 
     */
    CARRIER_ASSIGNED,

    /**
     * 
     * 						Sender/submitter assigned. In Optum domain Sender/submitter
     * 						can be a State Health Insurance Exchange (HIX) for example.
     * 					
     * 
     */
    SENDER_ASSIGNED,

    /**
     * 
     * 						Receiver assigned. In Optum domain a Receiver
     * 						can be internal or external systems.
     * 					
     * 
     */
    RECEIVER_ASSIGNED,

    /**
     * Legacy system assigned
     * 
     */
    LEGACY,

    /**
     * Other not covered by types above
     * 					
     * 
     */
    OTHER;

    public String value() {
        return name();
    }

    public static UniqueIdentifierTypeCodeEnum fromValue(String v) {
        return valueOf(v);
    }

}
