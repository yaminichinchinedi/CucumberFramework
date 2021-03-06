//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.common_v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Template complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Template">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}TextString"/>
 *         &lt;element ref="{http://enterprise.optum.com/schema/cim/common/Common_v1_0}Parameters" maxOccurs="500000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Template", propOrder = {
    "textString",
    "parameters"
})
public class Template {

    @XmlElement(name = "TextString", required = true)
    protected String textString;
    @XmlElement(name = "Parameters")
    protected List<Parameter> parameters;

    /**
     * 
     * 						
     * 						This contains text with parameter names enclosed
     * 						in "{}". An example of such a template would be:
     * 						<p/>
     * 						Dear <customerName>,
     * 						We are pleased to announce your 
     * 						enrollment in the <planName> on <enrollmentDate>...
     * 						<p/>
     * 						These parameters can then be replaced with actual values.
     * 						from the Parameter list.				
     * 						
     * 					
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextString() {
        return textString;
    }

    /**
     * Sets the value of the textString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextString(String value) {
        this.textString = value;
    }

    /**
     * 
     * 						
     * 						The parameter names should match the template text 
     * 						parameter names enclosed
     * 						in "{}".				
     * 						
     * 					Gets the value of the parameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parameter }
     * 
     * 
     */
    public List<Parameter> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<Parameter>();
        }
        return this.parameters;
    }

}
