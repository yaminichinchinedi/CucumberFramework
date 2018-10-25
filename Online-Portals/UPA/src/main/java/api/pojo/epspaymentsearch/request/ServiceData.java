package main.java.api.pojo.epspaymentsearch.request;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="ServiceData",namespace="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceData", propOrder = {
    "applicationIdentifier",
    "version"
})
public class ServiceData {

    @XmlElement(name = "ApplicationIdentifier",namespace="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected String applicationIdentifier;
   
    @XmlElement(name = "Version",namespace="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0",required = true)
    protected String version;

    
    /**
     * Gets the value of the applicationIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationIdentifier() {
        return applicationIdentifier;
    }

    /**
     * Sets the value of the applicationIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationIdentifier(String value) {
        this.applicationIdentifier = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
