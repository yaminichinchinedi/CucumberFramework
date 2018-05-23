package main.java.api.pojo.epspaymentsearch.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlRootElement(name="PaymentMadeOnDateRange",namespace="http://enterprise.optum.com/schema/cim/common/Common_v1_0")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateRange", propOrder = {
    "fromDate",
    "toDate"
})
public class PaymentMadeOnDateRange {

	
    @XmlElement(name = "FromDate",namespace="http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    @XmlSchemaType(name = "date")
   // protected XMLGregorianCalendar fromDate;
    protected String fromDate;
    
    @XmlElement(name = "ToDate",namespace="http://enterprise.optum.com/schema/cim/common/Common_v1_0", required = true)
    @XmlSchemaType(name = "date")
   // protected XMLGregorianCalendar toDate;
    protected String toDate;

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
//    public void setFromDate(XMLGregorianCalendar value) {
//        this.fromDate = value;
//    }
    
    
    public void setFromDate(String value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
//    public XMLGregorianCalendar getToDate() {
//        return toDate;
//    }
    
    
    public String getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDate(String value) {
        this.toDate = value;
    }

}