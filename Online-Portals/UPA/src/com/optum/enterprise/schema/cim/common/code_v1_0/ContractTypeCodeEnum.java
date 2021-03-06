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
 * <p>Java class for ContractTypeCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContractTypeCodeEnum">
 *   &lt;restriction base="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CodeType">
 *     &lt;enumeration value="DEPENDENT"/>
 *     &lt;enumeration value="SPOUSE_AND_CHILDREN_ONLY"/>
 *     &lt;enumeration value="SPOUSE_ONLY"/>
 *     &lt;enumeration value="EMPLOYEE_AND_CHILD"/>
 *     &lt;enumeration value="EMPLOYEE_SPOUSE_AND_CHILDREN"/>
 *     &lt;enumeration value="EMPLOYEE_AND_CHILDREN"/>
 *     &lt;enumeration value="EMPLOYEE_ONLY"/>
 *     &lt;enumeration value="EMPLOYEE_AND_SPOUSE"/>
 *     &lt;enumeration value="FAMILY"/>
 *     &lt;enumeration value="INDIVIDUAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ContractTypeCodeEnum")
@XmlEnum
public enum ContractTypeCodeEnum {


    /**
     * 
     * 						Dependents Only
     * 					
     * 
     */
    DEPENDENT,

    /**
     * 
     * 						Spouse and children only
     * 					
     * 
     */
    SPOUSE_AND_CHILDREN_ONLY,

    /**
     * 
     * 						Spouse only
     * 					
     * 
     */
    SPOUSE_ONLY,

    /**
     * 
     * 						Employee and one child
     * 					
     * 
     */
    EMPLOYEE_AND_CHILD,

    /**
     * 
     * 						Employee Spouse and Children
     * 					
     * 
     */
    EMPLOYEE_SPOUSE_AND_CHILDREN,

    /**
     * 
     * 						Employee and Children
     * 					
     * 
     */
    EMPLOYEE_AND_CHILDREN,

    /**
     * 
     * 						Employee only
     * 					
     * 
     */
    EMPLOYEE_ONLY,

    /**
     * 
     * 						Employee and Spouse
     * 					
     * 
     */
    EMPLOYEE_AND_SPOUSE,

    /**
     * 
     * 						Family
     * 					
     * 
     */
    FAMILY,

    /**
     * 
     * 						Individual
     * 					
     * 
     */
    INDIVIDUAL;

    public String value() {
        return name();
    }

    public static ContractTypeCodeEnum fromValue(String v) {
        return valueOf(v);
    }

}
