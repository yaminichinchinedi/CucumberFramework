package main.java.api.pojo.epspaymentsearch.request;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import main.java.api.pojo.epspaymentsearch.request.SearchByCriteriaRequest;
import main.java.api.pojo.epspaymentsearch.request.ServiceData;
import main.java.api.pojo.epspaymentsearch.request.PaymentMadeOnDateRange;

@XmlRootElement(name ="EpsPaymentsSearchRequest", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0")
@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "EpsPaymentsSearchRequest", propOrder = {
    "serviceData",
    "taxIdentifierNumber",
    "userRole",
    "subPayerId",
    "paymentMadeOnDateRange",
    "claimServiceDateRange",
    "epsSecondaryPayerReferenceIdentifiers"
})

public class EpsPaymentsSearchRequest
    extends SearchByCriteriaRequest
{
	
    @XmlElement(name = "ServiceData", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected ServiceData serviceData;
    
    @XmlElement(name = "TaxIdentifierNumber", namespace = "http://enterprise.optum.com/schema/cim/common/Identifier_v1_0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String taxIdentifierNumber;
    
    @XmlElement(name = "UserRole", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected String userRole;
    
    @XmlElement(namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0", required = true)
    protected String subPayerId;
    
    @XmlElement(name = "PaymentMadeOnDateRange", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0",required = true)
    protected PaymentMadeOnDateRange paymentMadeOnDateRange;
    
    @XmlElement(name = "ClaimServiceDateRange", namespace = "http://enterprise.optum.com/schema/cim/common/Common_v1_0")
    protected PaymentMadeOnDateRange claimServiceDateRange;
    
    @XmlElement(name = "EpsSecondaryPayerReferenceIdentifiers", namespace = "http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected List<String> epsSecondaryPayerReferenceIdentifiers;

    /**
     * Gets the value of the serviceData property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceData }
     *     
     */
    public ServiceData getServiceData() {
        return serviceData;
    }

    /**
     * Sets the value of the serviceData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceData }
     *     
     */
    public void setServiceData(ServiceData value) {
        this.serviceData = value;
    }

    /**
     * Gets the value of the taxIdentifierNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxIdentifierNumber() {
        return taxIdentifierNumber;
    }

    /**
     * Sets the value of the taxIdentifierNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxIdentifierNumber(String value) {
        this.taxIdentifierNumber = value;
    }

    /**
     * Gets the value of the userRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * Sets the value of the userRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRole(String value) {
        this.userRole = value;
    }

    /**
     * Gets the value of the subPayerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubPayerId() {
        return subPayerId;
    }

    /**
     * Sets the value of the subPayerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubPayerId(String value) {
        this.subPayerId = value;
    }

    /**
     * Gets the value of the paymentMadeOnDateRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRange }
     *     
     */
    public PaymentMadeOnDateRange getPaymentMadeOnDateRange() {
        return paymentMadeOnDateRange;
    }

    /**
     * Sets the value of the paymentMadeOnDateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRange }
     *     
     */
    public void setPaymentMadeOnDateRange(PaymentMadeOnDateRange value) {
        this.paymentMadeOnDateRange = value;
    }

    /**
     * Gets the value of the claimServiceDateRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRange }
     *     
     */
    public PaymentMadeOnDateRange getClaimServiceDateRange() {
        return claimServiceDateRange;
    }

    /**
     * Sets the value of the claimServiceDateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRange }
     *     
     */
    public void setClaimServiceDateRange(PaymentMadeOnDateRange value) {
        this.claimServiceDateRange = value;
    }

 
    public List<String> getEpsSecondaryPayerReferenceIdentifiers() {
        if (epsSecondaryPayerReferenceIdentifiers == null) {
            epsSecondaryPayerReferenceIdentifiers = new ArrayList<String>();
        }
        return this.epsSecondaryPayerReferenceIdentifiers;
    }


}
