//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.service_v1_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SortDirectionEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SortDirectionEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="ASC"/>
 *     &lt;enumeration value="DESC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SortDirectionEnum")
@XmlEnum
public enum SortDirectionEnum {

    ASC,
    DESC;

    public String value() {
        return name();
    }

    public static SortDirectionEnum fromValue(String v) {
        return valueOf(v);
    }

}
