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
 * <p>Java class for HttpMimeTypeAudioEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HttpMimeTypeAudioEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="audio/basic"/>
 *     &lt;enumeration value="audio/mp4"/>
 *     &lt;enumeration value="audio/mpeg"/>
 *     &lt;enumeration value="audio/vnd.rn-realaudio"/>
 *     &lt;enumeration value="audio/vnd.wave"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HttpMimeTypeAudioEnum")
@XmlEnum
public enum HttpMimeTypeAudioEnum {

    @XmlEnumValue("audio/basic")
    AUDIO_BASIC("audio/basic"),
    @XmlEnumValue("audio/mp4")
    AUDIO_MP_4("audio/mp4"),
    @XmlEnumValue("audio/mpeg")
    AUDIO_MPEG("audio/mpeg"),
    @XmlEnumValue("audio/vnd.rn-realaudio")
    AUDIO_VND_RN_REALAUDIO("audio/vnd.rn-realaudio"),
    @XmlEnumValue("audio/vnd.wave")
    AUDIO_VND_WAVE("audio/vnd.wave");
    private final String value;

    HttpMimeTypeAudioEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HttpMimeTypeAudioEnum fromValue(String v) {
        for (HttpMimeTypeAudioEnum c: HttpMimeTypeAudioEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}