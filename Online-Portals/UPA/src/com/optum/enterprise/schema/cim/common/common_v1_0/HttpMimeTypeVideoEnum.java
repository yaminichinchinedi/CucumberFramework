//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.common_v1_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HttpMimeTypeVideoEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HttpMimeTypeVideoEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="video/avi"/>
 *     &lt;enumeration value="video/mp4"/>
 *     &lt;enumeration value="video/mpeg"/>
 *     &lt;enumeration value="video/quicktime"/>
 *     &lt;enumeration value="video/x-flv"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HttpMimeTypeVideoEnum")
@XmlEnum
public enum HttpMimeTypeVideoEnum {

    @XmlEnumValue("video/avi")
    VIDEO_AVI("video/avi"),
    @XmlEnumValue("video/mp4")
    VIDEO_MP_4("video/mp4"),
    @XmlEnumValue("video/mpeg")
    VIDEO_MPEG("video/mpeg"),
    @XmlEnumValue("video/quicktime")
    VIDEO_QUICKTIME("video/quicktime"),
    @XmlEnumValue("video/x-flv")
    VIDEO_X_FLV("video/x-flv");
    private final String value;

    HttpMimeTypeVideoEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HttpMimeTypeVideoEnum fromValue(String v) {
        for (HttpMimeTypeVideoEnum c: HttpMimeTypeVideoEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
