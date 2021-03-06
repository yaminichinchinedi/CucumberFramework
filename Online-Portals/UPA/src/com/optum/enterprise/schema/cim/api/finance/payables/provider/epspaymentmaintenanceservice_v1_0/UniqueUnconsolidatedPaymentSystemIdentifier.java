//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.api.finance.payables.provider.epspaymentmaintenanceservice_v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.optum.enterprise.schema.cim.common.identifier_v1_0.AbstractUniqueSystemIdentifier;


/**
 * 
 * 				The source systems when cannot provide unique business 
 * 				identifiers for any reason, this type provides means to store
 * 				those non-unique identifiers here.
 * 			
 * 
 * <p>Java class for UniqueUnconsolidatedPaymentSystemIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UniqueUnconsolidatedPaymentSystemIdentifier">
 *   &lt;complexContent>
 *     &lt;extension base="{http://enterprise.optum.com/schema/cim/common/Identifier_v1_0}AbstractUniqueSystemIdentifier">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UniqueUnconsolidatedPaymentSystemIdentifier")
public class UniqueUnconsolidatedPaymentSystemIdentifier
    extends AbstractUniqueSystemIdentifier
{


}
