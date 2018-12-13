//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.person_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.optum.enterprise.schema.cim.common.code_v1_0.CitizenshipStatusCode;
import com.optum.enterprise.schema.cim.common.code_v1_0.EmploymentStatusCode;
import com.optum.enterprise.schema.cim.common.code_v1_0.EthnicityCode;
import com.optum.enterprise.schema.cim.common.code_v1_0.GenderCode;
import com.optum.enterprise.schema.cim.common.code_v1_0.HandicapStatusCode;
import com.optum.enterprise.schema.cim.common.code_v1_0.MaritalStatusCode;
import com.optum.enterprise.schema.cim.common.code_v1_0.StudentStatusCode;


/**
 * <p>Java class for Demographics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Demographics">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Person_v1_0}BirthDate" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}GenderCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Person_v1_0}DeathDate" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}StudentStatusCode" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}HandicapStatusCode" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}EmploymentStatusCode" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}MaritalStatusCode" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}EthnicityCode" minOccurs="0"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}CitizenshipStatusCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Demographics", propOrder = {
    "birthDate",
    "genderCode",
    "deathDate",
    "studentStatusCode",
    "handicapStatusCode",
    "employmentStatusCode",
    "maritalStatusCode",
    "ethnicityCode",
    "citizenshipStatusCode"
})
public class Demographics {

    @XmlElement(name = "BirthDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDate;
    @XmlElement(name = "GenderCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected GenderCode genderCode;
    @XmlElement(name = "DeathDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deathDate;
    @XmlElement(name = "StudentStatusCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected StudentStatusCode studentStatusCode;
    @XmlElement(name = "HandicapStatusCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected HandicapStatusCode handicapStatusCode;
    @XmlElement(name = "EmploymentStatusCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected EmploymentStatusCode employmentStatusCode;
    @XmlElement(name = "MaritalStatusCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected MaritalStatusCode maritalStatusCode;
    @XmlElement(name = "EthnicityCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected EthnicityCode ethnicityCode;
    @XmlElement(name = "CitizenshipStatusCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0")
    protected CitizenshipStatusCode citizenshipStatusCode;

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the genderCode property.
     * 
     * @return
     *     possible object is
     *     {@link GenderCode }
     *     
     */
    public GenderCode getGenderCode() {
        return genderCode;
    }

    /**
     * Sets the value of the genderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenderCode }
     *     
     */
    public void setGenderCode(GenderCode value) {
        this.genderCode = value;
    }

    /**
     * 
     * 						MASOOD: From EDI specs:
     * 						If MaintenanceType=024
     * 						(Cancellation) and the member has died,
     * 						the date of death is sent
     * 						in this
     * 						field.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeathDate() {
        return deathDate;
    }

    /**
     * Sets the value of the deathDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeathDate(XMLGregorianCalendar value) {
        this.deathDate = value;
    }

    /**
     * 
     * 						MASOOD: From EDI spec:
     * 						Use an allowable code from
     * 						Implementation
     * 						guide 5010 X220A1. Will be sent if available
     * 						regardless of
     * 						age.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link StudentStatusCode }
     *     
     */
    public StudentStatusCode getStudentStatusCode() {
        return studentStatusCode;
    }

    /**
     * Sets the value of the studentStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentStatusCode }
     *     
     */
    public void setStudentStatusCode(StudentStatusCode value) {
        this.studentStatusCode = value;
    }

    /**
     * Gets the value of the handicapStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link HandicapStatusCode }
     *     
     */
    public HandicapStatusCode getHandicapStatusCode() {
        return handicapStatusCode;
    }

    /**
     * Sets the value of the handicapStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link HandicapStatusCode }
     *     
     */
    public void setHandicapStatusCode(HandicapStatusCode value) {
        this.handicapStatusCode = value;
    }

    /**
     * Gets the value of the employmentStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link EmploymentStatusCode }
     *     
     */
    public EmploymentStatusCode getEmploymentStatusCode() {
        return employmentStatusCode;
    }

    /**
     * Sets the value of the employmentStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmploymentStatusCode }
     *     
     */
    public void setEmploymentStatusCode(EmploymentStatusCode value) {
        this.employmentStatusCode = value;
    }

    /**
     * Gets the value of the maritalStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link MaritalStatusCode }
     *     
     */
    public MaritalStatusCode getMaritalStatusCode() {
        return maritalStatusCode;
    }

    /**
     * Sets the value of the maritalStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaritalStatusCode }
     *     
     */
    public void setMaritalStatusCode(MaritalStatusCode value) {
        this.maritalStatusCode = value;
    }

    /**
     * Gets the value of the ethnicityCode property.
     * 
     * @return
     *     possible object is
     *     {@link EthnicityCode }
     *     
     */
    public EthnicityCode getEthnicityCode() {
        return ethnicityCode;
    }

    /**
     * Sets the value of the ethnicityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EthnicityCode }
     *     
     */
    public void setEthnicityCode(EthnicityCode value) {
        this.ethnicityCode = value;
    }

    /**
     * Gets the value of the citizenshipStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link CitizenshipStatusCode }
     *     
     */
    public CitizenshipStatusCode getCitizenshipStatusCode() {
        return citizenshipStatusCode;
    }

    /**
     * Sets the value of the citizenshipStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitizenshipStatusCode }
     *     
     */
    public void setCitizenshipStatusCode(CitizenshipStatusCode value) {
        this.citizenshipStatusCode = value;
    }

}