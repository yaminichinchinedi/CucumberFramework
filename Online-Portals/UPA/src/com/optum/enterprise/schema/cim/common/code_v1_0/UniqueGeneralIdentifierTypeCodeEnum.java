//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.code_v1_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UniqueGeneralIdentifierTypeCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UniqueGeneralIdentifierTypeCodeEnum">
 *   &lt;restriction base="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CodeType">
 *     &lt;enumeration value="PRIMARY"/>
 *     &lt;enumeration value="SENDER_ASSIGNED"/>
 *     &lt;enumeration value="RECEIVER_ASSIGNED"/>
 *     &lt;enumeration value="LEGACY"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UniqueGeneralIdentifierTypeCodeEnum")
@XmlEnum
public enum UniqueGeneralIdentifierTypeCodeEnum {


    /**
     * 
     * 						Primary unique identifier.This must be specified
     * 						if no
     * 						other identifiers types are specified.
     * 					
     * 
     */
    PRIMARY,

    /**
     * 
     * 						Sender/submitter assigned. In Optum domain
     * 						Sender/submitter can be a Law School for example.
     * 					
     * 
     */
    SENDER_ASSIGNED,

    /**
     * 
     * 						Receiver assigned. In Optum domain a Receiver
     * 						can be Learnosity for example.
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
     * 
     * 						Other not covered by types above
     * 					
     * 
     */
    OTHER;

    public String value() {
        return name();
    }

    public static UniqueGeneralIdentifierTypeCodeEnum fromValue(String v) {
        return valueOf(v);
    }

}
