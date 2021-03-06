//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.user_v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.code_v1_0.RoleCode;
import com.optum.enterprise.schema.cim.common.code_v1_0.SystemCode;


/**
 * 
 * 				
 * 				Represents User's Authorization metadata specifying what 
 * 				Systems and their respective Roles are assigned to a User.
 * 				<p/>
 * 				Each User is associated with this Authorization which
 * 				encapsulates what Systems the User can access, and what Roles 
 * 				within those Systems, the User is assigned, and what Geography
 * 				the Authorization is associated with. 
 * 					
 * 			
 * 
 * <p>Java class for Authorization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Authorization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}SystemCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}RoleCodes" maxOccurs="500000"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Authorization", propOrder = {
    "systemCode",
    "roleCodes"
})
public class Authorization {

    @XmlElement(name = "SystemCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected SystemCode systemCode;
    @XmlElement(name = "RoleCodes", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected List<RoleCode> roleCodes;

    /**
     * 
     * 						System associated with this Authorization.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link SystemCode }
     *     
     */
    public SystemCode getSystemCode() {
        return systemCode;
    }

    /**
     * Sets the value of the systemCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemCode }
     *     
     */
    public void setSystemCode(SystemCode value) {
        this.systemCode = value;
    }

    /**
     * 
     * 						The Roles associated with this System.
     *         			Gets the value of the roleCodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleCodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleCodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoleCode }
     * 
     * 
     */
    public List<RoleCode> getRoleCodes() {
        if (roleCodes == null) {
            roleCodes = new ArrayList<RoleCode>();
        }
        return this.roleCodes;
    }

}
