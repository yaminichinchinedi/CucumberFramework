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
import com.optum.enterprise.schema.cim.common.address_v1_0.GeographicScope;
import com.optum.enterprise.schema.cim.common.code_v1_0.RoleCode;


/**
 * 
 * 				The scope of the role. The scope can be US state or country 
 * 				specific, or international state specific. 
 * 			
 * 
 * <p>Java class for RoleScope complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoleScope">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Code_v1_0}RoleCode"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Address_v1_0}GeographicScopes" maxOccurs="500000"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoleScope", propOrder = {
    "roleCode",
    "geographicScopes"
})
public class RoleScope {

    @XmlElement(name = "RoleCode", namespace = "http://enterprise.optum.com/schema/cim/common/Code_v1_0", required = true)
    protected RoleCode roleCode;
    @XmlElement(name = "GeographicScopes", namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", required = true)
    protected List<GeographicScope> geographicScopes;

    /**
     * 
     * 						The Role associated with this Scope.
     *         			
     * 
     * @return
     *     possible object is
     *     {@link RoleCode }
     *     
     */
    public RoleCode getRoleCode() {
        return roleCode;
    }

    /**
     * Sets the value of the roleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleCode }
     *     
     */
    public void setRoleCode(RoleCode value) {
        this.roleCode = value;
    }

    /**
     * 
     * 						The list of Geographic Scopes associated with this 
     * 						User's Authorization.
     *         			Gets the value of the geographicScopes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geographicScopes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeographicScopes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeographicScope }
     * 
     * 
     */
    public List<GeographicScope> getGeographicScopes() {
        if (geographicScopes == null) {
            geographicScopes = new ArrayList<GeographicScope>();
        }
        return this.geographicScopes;
    }

}