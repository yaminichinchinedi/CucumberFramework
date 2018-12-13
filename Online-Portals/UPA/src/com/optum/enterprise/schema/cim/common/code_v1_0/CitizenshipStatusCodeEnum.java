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
 * <p>Java class for CitizenshipStatusCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CitizenshipStatusCodeEnum">
 *   &lt;restriction base="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CodeType">
 *     &lt;enumeration value="US_CITIZEN"/>
 *     &lt;enumeration value="US_NATIONAL"/>
 *     &lt;enumeration value="LAWFULLY_PRESENT"/>
 *     &lt;enumeration value="QUALIFIED_ALIEN"/>
 *     &lt;enumeration value="NON_QUALIFIED_ALIEN"/>
 *     &lt;enumeration value="UNDOCUMENTED_ALIEN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CitizenshipStatusCodeEnum")
@XmlEnum
public enum CitizenshipStatusCodeEnum {


    /**
     * 
     * 						US Citizens. See
     * 						http://www.dshs.wa.gov/manuals/eaz/sections/CitizenshipAndAlienStatus/citizengenelig.shtml
     * 						for details.
     * 					
     * 
     */
    US_CITIZEN,

    /**
     * 
     * 						Persons who owe permanent allegiance to the U.S.
     * 						and may
     * 						enter and work in the U.S. without restriction.
     * 						The
     * 						following are the only persons classified as U.S.
     * 						nationals:
     * 						a.
     * 						Persons born in American Samoa or Swain's Island
     * 						after December 24,
     * 						1952; and
     * 						b. Residents of the Northern Mariana Islands who
     * 						did not
     * 						elect to become U.S. citizens.
     * 					
     * 
     */
    US_NATIONAL,

    /**
     * 
     * 						Immigrants or noncitizens who have been inspected
     * 						and admitted into the United States and not overstayed
     * 						the period
     * 						for which they were admitted, or have current
     * 						permission
     * 						from the
     * 						U.S. Citizenship and Immigrant
     * 						Services (CIS) to stay or live in
     * 						the U.S.
     * 					
     * 
     */
    LAWFULLY_PRESENT,

    /**
     * 
     * 						Immigrants or noncitizens who are "qualified".
     * 						See
     * 						http://www.dshs.wa.gov/manuals/eaz/sections/CitizenshipAndAlienStatus/citizengenelig.shtml
     * 						for details.
     * 					
     * 
     */
    QUALIFIED_ALIEN,

    /**
     * 
     * 						Immigrants or noncitizens who are
     * 						"non-qualified". See
     * 						http://www.dshs.wa.gov/manuals/eaz/sections/CitizenshipAndAlienStatus/citizengenelig.shtml
     * 						for details.
     * 					
     * 
     */
    NON_QUALIFIED_ALIEN,

    /**
     * 
     * 						Noncitizens without a lawful immigration status
     * 						as
     * 						defined US statutes, and who:
     * 						a. Entered the U.S. illegally; or
     * 						b. Were lawfully admitted but whose status expired or
     * 						was revoked
     * 						per United States Citizenship and
     * 						Immigration Services (USCIS).
     * 					
     * 
     */
    UNDOCUMENTED_ALIEN;

    public String value() {
        return name();
    }

    public static CitizenshipStatusCodeEnum fromValue(String v) {
        return valueOf(v);
    }

}