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
 * <p>Java class for UniquePersonIdentifierTypeCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UniquePersonIdentifierTypeCodeEnum">
 *   &lt;restriction base="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CodeType">
 *     &lt;enumeration value="SSN"/>
 *     &lt;enumeration value="TIN"/>
 *     &lt;enumeration value="EIN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UniquePersonIdentifierTypeCodeEnum")
@XmlEnum
public enum UniquePersonIdentifierTypeCodeEnum {


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
     * Employee or Person Identification Number
     * 					
     * 
     */
    EIN;

    public String value() {
        return name();
    }

    public static UniquePersonIdentifierTypeCodeEnum fromValue(String v) {
        return valueOf(v);
    }

}
