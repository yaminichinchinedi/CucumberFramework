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
 * <p>Java class for RoleCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleCodeEnum">
 *   &lt;restriction base="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CodeType">
 *     &lt;enumeration value="SYSTEM"/>
 *     &lt;enumeration value="SUPER_USER"/>
 *     &lt;enumeration value="ADMINISTRATOR"/>
 *     &lt;enumeration value="STUDENT"/>
 *     &lt;enumeration value="PROFESSOR"/>
 *     &lt;enumeration value="CONTENT_AUTHOR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleCodeEnum")
@XmlEnum
public enum RoleCodeEnum {


    /**
     * 
     * 						This role is a catch-all for any Users which are other 
     * 						software systems.
     * 					
     * 
     */
    SYSTEM,

    /**
     * 
     * 						Highest level access. User having this role can access
     * 						all functionality of the system.
     * 					
     * 
     */
    SUPER_USER,

    /**
     * 
     * 						Second highest level access. User having this role can 
     * 						access most if not all functionality of the system.
     * 					
     * 
     */
    ADMINISTRATOR,

    /**
     * 
     * 						Users who have a Student level access to the system.
     * 					
     * 
     */
    STUDENT,

    /**
     * 
     * 						Users who have a Professor level access to the system.
     * 					
     * 
     */
    PROFESSOR,

    /**
     * 
     * 						Users who have author Content for the system. An example
     * 						of such users would be soeone who writes the Questions
     * 						and their correct Answers for a Course related 
     * 						Test/Quiz. 
     * 					
     * 
     */
    CONTENT_AUTHOR;

    public String value() {
        return name();
    }

    public static RoleCodeEnum fromValue(String v) {
        return valueOf(v);
    }

}