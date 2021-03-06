//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.api.finance.payables.provider.paymentsservice_v1_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchByParameterEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchByParameterEnum">
 *   &lt;restriction base="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CodeType">
 *     &lt;enumeration value="ELECTRONIC_PAYMENT_NUMBER"/>
 *     &lt;enumeration value="CHECK_NUMBER"/>
 *     &lt;enumeration value="ACCOUNT_NUMBER"/>
 *     &lt;enumeration value="PATIENT_FIRST_NAME"/>
 *     &lt;enumeration value="PATIENT_LAST_NAME"/>
 *     &lt;enumeration value="SUBSCRIBER_IDENTIFIER"/>
 *     &lt;enumeration value="RENDERING_PROVIDER_IDENTIFIER"/>
 *     &lt;enumeration value="NATIONAL_PROVIDER_IDENTIFIER"/>
 *     &lt;enumeration value="CLAIM_IDENTIFIER"/>
 *     &lt;enumeration value="MARKET_TYPE"/>
 *     &lt;enumeration value="ZERO_PAYMENT_CLAIMS"/>
 *     &lt;enumeration value="TAX_IDENTIFIER_TYPE"/>
 *     &lt;enumeration value="ACTIVE_ARCHIVE_PAYMENTS_INDICATOR"/>
 *     &lt;enumeration value="PAYMENT_LEVEL_DETAIL"/>
 *     &lt;enumeration value="CHECK_NUMBER_REORIG_NACHA"/>
 *     &lt;enumeration value="CHECK_NUMBER_PAY_DTL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchByParameterEnum")
@XmlEnum
public enum SearchByParameterEnum {

    ELECTRONIC_PAYMENT_NUMBER,
    CHECK_NUMBER,
    ACCOUNT_NUMBER,
    PATIENT_FIRST_NAME,
    PATIENT_LAST_NAME,
    SUBSCRIBER_IDENTIFIER,
    RENDERING_PROVIDER_IDENTIFIER,
    NATIONAL_PROVIDER_IDENTIFIER,
    CLAIM_IDENTIFIER,
    MARKET_TYPE,
    ZERO_PAYMENT_CLAIMS,
    TAX_IDENTIFIER_TYPE,
    ACTIVE_ARCHIVE_PAYMENTS_INDICATOR,
    PAYMENT_LEVEL_DETAIL,
    CHECK_NUMBER_REORIG_NACHA,
    CHECK_NUMBER_PAY_DTL;

    public String value() {
        return name();
    }

    public static SearchByParameterEnum fromValue(String v) {
        return valueOf(v);
    }

}
