//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.provider.provider_v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.optum.enterprise.schema.cim.common.entity_v1_0.EntitySummary;


/**
 * <p>Java class for ProviderSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProviderSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Entity_v1_0}EntitySummary">
 *       &lt;sequence>
 *         &lt;group ref="{http://enterprise.optum.com/schema/cim/provider/Provider_v1_0}ProviderSummaryGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderSummary", propOrder = {
    "providerIdentifier",
    "uniqueProviderSystemIdentifiers",
    "nationalProviderIdentifier"
})
public class ProviderSummary
    extends EntitySummary
{

    @XmlElement(name = "ProviderIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String providerIdentifier;
    @XmlElement(name = "UniqueProviderSystemIdentifiers")
    protected List<UniqueProviderSystemIdentifier> uniqueProviderSystemIdentifiers;
    @XmlElement(name = "NationalProviderIdentifier", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String nationalProviderIdentifier;

    /**
     * 
     * 							Provider Identifier as
     * 							assigned by the Service Provider (the API).
     * 							The implementation is free to use the National 
     * 							Provider Identifier value for this as well, as long 
     * 							as it can uniquely identify the Provider.
     * 						
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderIdentifier() {
        return providerIdentifier;
    }

    /**
     * Sets the value of the providerIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderIdentifier(String value) {
        this.providerIdentifier = value;
    }

    /**
     * 
     * 							
     * 							Either use <code>ProviderIdentifier</code> if the 
     * 							enterprise has one unique identifier for Provider across
     * 							all enteprise software systems i.e. A true Business 
     * 							Identifier.
     * 							<p/>
     * 							If the enterprise suffers from Multiple 
     * 							Business Identifiers syndrome, then use 
     * 							<code>UniqueProviderIdentifiers</code>.
     * 							
     * 						Gets the value of the uniqueProviderSystemIdentifiers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uniqueProviderSystemIdentifiers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniqueProviderSystemIdentifiers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UniqueProviderSystemIdentifier }
     * 
     * 
     */
    public List<UniqueProviderSystemIdentifier> getUniqueProviderSystemIdentifiers() {
        if (uniqueProviderSystemIdentifiers == null) {
            uniqueProviderSystemIdentifiers = new ArrayList<UniqueProviderSystemIdentifier>();
        }
        return this.uniqueProviderSystemIdentifiers;
    }

    /**
     * 
     * 						National Provider
     * 						Identifier is different than the
     * 						Provider Identifier.
     * 						MASOOD TBD:
     * 						Figure out NPN Level/Name??
     * 					
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalProviderIdentifier() {
        return nationalProviderIdentifier;
    }

    /**
     * Sets the value of the nationalProviderIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalProviderIdentifier(String value) {
        this.nationalProviderIdentifier = value;
    }

}
