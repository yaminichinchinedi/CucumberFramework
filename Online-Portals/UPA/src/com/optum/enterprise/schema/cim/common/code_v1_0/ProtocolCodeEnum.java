//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.code_v1_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProtocolCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProtocolCodeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="file"/>
 *     &lt;enumeration value="http"/>
 *     &lt;enumeration value="https"/>
 *     &lt;enumeration value="jms"/>
 *     &lt;enumeration value="tcp"/>
 *     &lt;enumeration value="ftp"/>
 *     &lt;enumeration value="ftps"/>
 *     &lt;enumeration value="sftp"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProtocolCodeEnum")
@XmlEnum
public enum ProtocolCodeEnum {

    @XmlEnumValue("file")
    FILE("file"),
    @XmlEnumValue("http")
    HTTP("http"),
    @XmlEnumValue("https")
    HTTPS("https"),
    @XmlEnumValue("jms")
    JMS("jms"),
    @XmlEnumValue("tcp")
    TCP("tcp"),
    @XmlEnumValue("ftp")
    FTP("ftp"),
    @XmlEnumValue("ftps")
    FTPS("ftps"),
    @XmlEnumValue("sftp")
    SFTP("sftp");
    private final String value;

    ProtocolCodeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProtocolCodeEnum fromValue(String v) {
        for (ProtocolCodeEnum c: ProtocolCodeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
