package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlElement;   

public class EpsConsolidatedClaimPaymentSummaries
{
	@XmlElement(name = "PayerSummary", required = true)
    private PayerSummary PayerSummary;

    @XmlElement(name = "PaymentTypeIndicator", required = true)
    private String PaymentTypeIndicator;

    @XmlElement(name = "PaymentIdentifier", required = true)
    private String PaymentIdentifier;

    @XmlElement(name = "ConsolidatedPaymentNumber", required = true)
    private String ConsolidatedPaymentNumber;

    @XmlElement(name = "EpsPrimaryPayerIdentifier", required = true)
    private String EpsPrimaryPayerIdentifier;

    @XmlElement(name = "PayeePaymentMethod", required = true)
    private PayeePaymentMethod PayeePaymentMethod;

    @XmlElement(name = "DisplayConsolidatedPaymentNumber", required = true)
    private String DisplayConsolidatedPaymentNumber;

    @XmlElement(name = "ClaimCountTotal", required = true)
    private String ClaimCountTotal;

    @XmlElement(name = "PaymentMadeOn", required = true)
    private String PaymentMadeOn;

//    @XmlElement(name = "EpsPaymentStatusCode", required = true)
//    private String EpsPaymentStatusCode;
    
    @XmlElement(name = "EpsPaymentStatusCode", required = true)
    private EpsPaymentStatusCode EpsPaymentStatusCode;

    @XmlElement(name = "TotalAmount", required = true)
    private String TotalAmount;

    @XmlElement(name = "PaymentStatusCode", required = true)
    private String PaymentStatusCode;

    @XmlElement(name = "NationalProviderIdentifier", required = true)
    private String NationalProviderIdentifier;

    @XmlElement(name = "EpsSecondaryPayerReferenceIdentifier", required = true)
    private String EpsSecondaryPayerReferenceIdentifier;

    @XmlElement(name = "PayerPaymentMethod", required = true)
    private PayerPaymentMethod PayerPaymentMethod;

    public PayerSummary getPayerSummary ()
    {
        return PayerSummary;
    }

    public void setPayerSummary (PayerSummary PayerSummary)
    {
        this.PayerSummary = PayerSummary;
    }

    public String getPaymentTypeIndicator ()
    {
        return PaymentTypeIndicator;
    }

    public void setPaymentTypeIndicator (String PaymentTypeIndicator)
    {
        this.PaymentTypeIndicator = PaymentTypeIndicator;
    }

    public String getPaymentIdentifier ()
    {
        return PaymentIdentifier;
    }

    public void setPaymentIdentifier (String PaymentIdentifier)
    {
        this.PaymentIdentifier = PaymentIdentifier;
    }

    public String getConsolidatedPaymentNumber ()
    {
        return ConsolidatedPaymentNumber;
    }

    public void setConsolidatedPaymentNumber (String ConsolidatedPaymentNumber)
    {
        this.ConsolidatedPaymentNumber = ConsolidatedPaymentNumber;
    }

    public String getEpsPrimaryPayerIdentifier ()
    {
        return EpsPrimaryPayerIdentifier;
    }

    public void setEpsPrimaryPayerIdentifier (String EpsPrimaryPayerIdentifier)
    {
        this.EpsPrimaryPayerIdentifier = EpsPrimaryPayerIdentifier;
    }

    public PayeePaymentMethod getPayeePaymentMethod ()
    {
        return PayeePaymentMethod;
    }

    public void setPayeePaymentMethod (PayeePaymentMethod PayeePaymentMethod)
    {
        this.PayeePaymentMethod = PayeePaymentMethod;
    }

    public String getDisplayConsolidatedPaymentNumber ()
    {
        return DisplayConsolidatedPaymentNumber;
    }

    public void setDisplayConsolidatedPaymentNumber (String DisplayConsolidatedPaymentNumber)
    {
        this.DisplayConsolidatedPaymentNumber = DisplayConsolidatedPaymentNumber;
    }

    public String getClaimCountTotal ()
    {
        return ClaimCountTotal;
    }

    public void setClaimCountTotal (String ClaimCountTotal)
    {
        this.ClaimCountTotal = ClaimCountTotal;
    }

    public String getPaymentMadeOn ()
    {
        return PaymentMadeOn;
    }

    public void setPaymentMadeOn (String PaymentMadeOn)
    {
        this.PaymentMadeOn = PaymentMadeOn;
    }

     
    
    
    public EpsPaymentStatusCode getEpsPaymentStatusCode ()
    {
    	return EpsPaymentStatusCode ;
    }

    public void setEpsPaymentStatusCode (EpsPaymentStatusCode EpsPaymentStatusCode)
    {
        this.EpsPaymentStatusCode = EpsPaymentStatusCode;
    }

    public String getTotalAmount ()
    {
        return TotalAmount;
    }

    public void setTotalAmount (String TotalAmount)
    {
        this.TotalAmount = TotalAmount;
    }

    public String getPaymentStatusCode ()
    {
        return PaymentStatusCode;
    }

    public void setPaymentStatusCode (String PaymentStatusCode)
    {
        this.PaymentStatusCode = PaymentStatusCode;
    }

    public String getNationalProviderIdentifier ()
    {
        return NationalProviderIdentifier;
    }

    public void setNationalProviderIdentifier (String NationalProviderIdentifier)
    {
        this.NationalProviderIdentifier = NationalProviderIdentifier;
    }

    public String getEpsSecondaryPayerReferenceIdentifier ()
    {
        return EpsSecondaryPayerReferenceIdentifier;
    }

    public void setEpsSecondaryPayerReferenceIdentifier (String EpsSecondaryPayerReferenceIdentifier)
    {
        this.EpsSecondaryPayerReferenceIdentifier = EpsSecondaryPayerReferenceIdentifier;
    }

    public PayerPaymentMethod getPayerPaymentMethod ()
    {
        return PayerPaymentMethod;
    }

    public void setPayerPaymentMethod (PayerPaymentMethod PayerPaymentMethod)
    {
        this.PayerPaymentMethod = PayerPaymentMethod;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [PayerSummary = "+PayerSummary+", PaymentTypeIndicator = "+PaymentTypeIndicator+", PaymentIdentifier = "+PaymentIdentifier+", ConsolidatedPaymentNumber = "+ConsolidatedPaymentNumber+", EpsPrimaryPayerIdentifier = "+EpsPrimaryPayerIdentifier+", PayeePaymentMethod = "+PayeePaymentMethod+", DisplayConsolidatedPaymentNumber = "+DisplayConsolidatedPaymentNumber+", ClaimCountTotal = "+ClaimCountTotal+", PaymentMadeOn = "+PaymentMadeOn+", EpsPaymentStatusCode = "+EpsPaymentStatusCode+", TotalAmount = "+TotalAmount+", PaymentStatusCode = "+PaymentStatusCode+", NationalProviderIdentifier = "+NationalProviderIdentifier+", EpsSecondaryPayerReferenceIdentifier = "+EpsSecondaryPayerReferenceIdentifier+", PayerPaymentMethod = "+PayerPaymentMethod+"]";
    }
}
