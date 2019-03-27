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
 * <p>Java class for MaintenanceTypeCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MaintenanceTypeCodeEnum">
 *   &lt;restriction base="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CodeType">
 *     &lt;enumeration value="ADDITION"/>
 *     &lt;enumeration value="CANCELLATION"/>
 *     &lt;enumeration value="CHANGE"/>
 *     &lt;enumeration value="CORRECTION"/>
 *     &lt;enumeration value="DELETE"/>
 *     &lt;enumeration value="REINSTATEMENT"/>
 *     &lt;enumeration value="TERMINATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MaintenanceTypeCodeEnum")
@XmlEnum
public enum MaintenanceTypeCodeEnum {


    /**
     * 
     * 						Addition/creation.
     * 					
     * 
     */
    ADDITION,

    /**
     * 
     * 						Maintenance resulting from Cancellation.
     * 						Cancellation is
     * 						different from Termination , as such that Cancellation
     * 						happens before the "privileges of membership" has
     * 						started, And Termination happens after the
     * 						"privileges of membership" has already started .
     * 					
     * 
     */
    CANCELLATION,

    /**
     * 
     * 						Change/modification.
     * 					
     * 
     */
    CHANGE,

    /**
     * 
     * 						Maintenance resulting from Correction of data.
     * 					
     * 
     */
    CORRECTION,

    /**
     * 
     * 						Maintenance resulting from Deletion of data.
     * 					
     * 
     */
    DELETE,

    /**
     * 
     * 						Maintenance resulting from
     * 						Cancellation/Termination,
     * 						and then subsequent reinstatement.
     * 					
     * 
     */
    REINSTATEMENT,

    /**
     * 
     * 						Maintenance resulting from Termination.
     * 						Termination is
     * 						different from Cancellation, as such that Termination
     * 						happens after the "privileges of membership" has already
     * 						started, whereas
     * 						Cancellation happens before the
     * 						"privileges of membership" has started.
     * 					
     * 
     */
    TERMINATION;

    public String value() {
        return name();
    }

    public static MaintenanceTypeCodeEnum fromValue(String v) {
        return valueOf(v);
    }

}
