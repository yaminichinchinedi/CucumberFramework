package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlElement;

public class EpsConsolidatedClaimPaymentSummaries
{
	@XmlElement(name = "PayerSummary", required = true)
	private PayerSummary PayerSummary;

	@XmlElement(name = "PaymentTypeIndicator", required = true)
    private String PaymentTypeIndicator;

	@XmlElement(name = "PatientMiddleName", required = true)
    private String PatientMiddleName;

	@XmlElement(name = "PaymentStatusTypeDateTime", required = true)
    private String PaymentStatusTypeDateTime;

	@XmlElement(name = "PaymentIdentifier", required = true)
    private String PaymentIdentifier;

	@XmlElement(name = "PatientFirstName", required = true)
    private String PatientFirstName;

	@XmlElement(name = "EpsConsolidatedClaimPaymentDetails", required = true)
    private EpsConsolidatedClaimPaymentDetails EpsConsolidatedClaimPaymentDetails;

	@XmlElement(name = "ClaimIdentifier", required = true)
    private String ClaimIdentifier;

	@XmlElement(name = "EpsPrimaryPayerIdentifier", required = true)
    private String EpsPrimaryPayerIdentifier;

	@XmlElement(name = "DisplayConsolidatedPaymentNumber", required = true)
    private String DisplayConsolidatedPaymentNumber;

	@XmlElement(name = "ClaimOrder", required = true)
    private String ClaimOrder;

	@XmlElement(name = "PatientAccountNumber", required = true)
    private String PatientAccountNumber;

	@XmlElement(name = "ClaimDate", required = true)
    private String ClaimDate;

	@XmlElement(name = "PaymentMadeOn", required = true)
    private String PaymentMadeOn;

	@XmlElement(name = "SubscriberIdentifier", required = true)
    private String SubscriberIdentifier;

	@XmlElement(name = "EpsPaymentStatusCode", required = true)
    private EpsPaymentStatusCode EpsPaymentStatusCode;

	@XmlElement(name = "PatientLastName", required = true)
    private String PatientLastName;

	@XmlElement(name = "ClaimAmount", required = true)
    private String ClaimAmount;

	@XmlElement(name = "NationalProviderIdentifier", required = true)
    private String NationalProviderIdentifier;

	@XmlElement(name = "PaymentStatusCode", required = true)
	private PaymentStatusCode PaymentStatusCode;

	@XmlElement(name = "PayerPaymentMethod", required = true)
    private PayerPaymentMethod PayerPaymentMethod;

	@XmlElement(name = "EpsClaimCount", required = true)
    private String EpsClaimCount;

	@XmlElement(name = "ConsolidatedPaymentNumber", required = true)
    private String ConsolidatedPaymentNumber;

	@XmlElement(name = "PayeePaymentMethod", required = true)
    private PayeePaymentMethod PayeePaymentMethod;

	@XmlElement(name = "TotalAmount", required = true)
    private String TotalAmount;
	
	@XmlElement(name = "ArchiveIndicator", required = true)
	private String ArchiveIndicator;

	@XmlElement(name = "EpsSecondaryPayerReferenceIdentifier", required = true)
    private String EpsSecondaryPayerReferenceIdentifier;
	
	@XmlElement(name = "ClaimCountTotal", required = true)
	private String ClaimCountTotal;
	
	@XmlElement(name = "TraceNumber", required = true)
	private String TraceNumber;
	
	@XmlElement(name = "EpsClaimPaymentResponses", required = true)
	private EpsClaimPaymentResponses EpsClaimPaymentResponses;
	
	public String getTraceNumber() {
		return TraceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		TraceNumber = traceNumber;
	}

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

    public String getPatientMiddleName ()
    {
        return PatientMiddleName;
    }

    public void setPatientMiddleName (String PatientMiddleName)
    {
        this.PatientMiddleName = PatientMiddleName;
    }

    public String getPaymentStatusTypeDateTime ()
    {
        return PaymentStatusTypeDateTime;
    }

    public void setPaymentStatusTypeDateTime (String PaymentStatusTypeDateTime)
    {
        this.PaymentStatusTypeDateTime = PaymentStatusTypeDateTime;
    }

    public String getPaymentIdentifier ()
    {
        return PaymentIdentifier;
    }

    public void setPaymentIdentifier (String PaymentIdentifier)
    {
        this.PaymentIdentifier = PaymentIdentifier;
    }

    public String getPatientFirstName ()
    {
        return PatientFirstName;
    }

    public void setPatientFirstName (String PatientFirstName)
    {
        this.PatientFirstName = PatientFirstName;
    }

    public EpsConsolidatedClaimPaymentDetails getEpsConsolidatedClaimPaymentDetails ()
    {
        return EpsConsolidatedClaimPaymentDetails;
    }

    public void setEpsConsolidatedClaimPaymentDetails (EpsConsolidatedClaimPaymentDetails EpsConsolidatedClaimPaymentDetails)
    {
        this.EpsConsolidatedClaimPaymentDetails = EpsConsolidatedClaimPaymentDetails;
    }

    public String getClaimIdentifier ()
    {
        return ClaimIdentifier;
    }

    public void setClaimIdentifier (String ClaimIdentifier)
    {
        this.ClaimIdentifier = ClaimIdentifier;
    }

    public String getEpsPrimaryPayerIdentifier ()
    {
        return EpsPrimaryPayerIdentifier;
    }

    public void setEpsPrimaryPayerIdentifier (String EpsPrimaryPayerIdentifier)
    {
        this.EpsPrimaryPayerIdentifier = EpsPrimaryPayerIdentifier;
    }

    public String getDisplayConsolidatedPaymentNumber ()
    {
        return DisplayConsolidatedPaymentNumber;
    }

    public void setDisplayConsolidatedPaymentNumber (String DisplayConsolidatedPaymentNumber)
    {
        this.DisplayConsolidatedPaymentNumber = DisplayConsolidatedPaymentNumber;
    }

    public String getClaimOrder ()
    {
        return ClaimOrder;
    }

    public void setClaimOrder (String ClaimOrder)
    {
        this.ClaimOrder = ClaimOrder;
    }

    public String getPatientAccountNumber ()
    {
        return PatientAccountNumber;
    }

    public void setPatientAccountNumber (String PatientAccountNumber)
    {
        this.PatientAccountNumber = PatientAccountNumber;
    }

    public String getClaimDate ()
    {
        return ClaimDate;
    }

    public void setClaimDate (String ClaimDate)
    {
        this.ClaimDate = ClaimDate;
    }

    public String getPaymentMadeOn ()
    {
        return PaymentMadeOn;
    }

    public void setPaymentMadeOn (String PaymentMadeOn)
    {
        this.PaymentMadeOn = PaymentMadeOn;
    }

    public String getSubscriberIdentifier ()
    {
        return SubscriberIdentifier;
    }

    public void setSubscriberIdentifier (String SubscriberIdentifier)
    {
        this.SubscriberIdentifier = SubscriberIdentifier;
    }

    public EpsPaymentStatusCode getEpsPaymentStatusCode ()
    {
        return EpsPaymentStatusCode;
    }

    public void setEpsPaymentStatusCode (EpsPaymentStatusCode EpsPaymentStatusCode)
    {
        this.EpsPaymentStatusCode = EpsPaymentStatusCode;
    }

    public String getPatientLastName ()
    {
        return PatientLastName;
    }

    public void setPatientLastName (String PatientLastName)
    {
        this.PatientLastName = PatientLastName;
    }

    public String getClaimAmount ()
    {
        return ClaimAmount;
    }

    public void setClaimAmount (String ClaimAmount)
    {
        this.ClaimAmount = ClaimAmount;
    }

    public String getNationalProviderIdentifier ()
    {
        return NationalProviderIdentifier;
    }

    public void setNationalProviderIdentifier (String NationalProviderIdentifier)
    {
        this.NationalProviderIdentifier = NationalProviderIdentifier;
    }

    public PaymentStatusCode getPaymentStatusCode ()
    {
        return PaymentStatusCode;
    }

    public void setPaymentStatusCode (PaymentStatusCode PaymentStatusCode)
    {
        this.PaymentStatusCode = PaymentStatusCode;
    }

    public PayerPaymentMethod getPayerPaymentMethod ()
    {
        return PayerPaymentMethod;
    }

    public void setPayerPaymentMethod (PayerPaymentMethod PayerPaymentMethod)
    {
        this.PayerPaymentMethod = PayerPaymentMethod;
    }

    public String getEpsClaimCount ()
    {
        return EpsClaimCount;
    }

    public void setEpsClaimCount (String EpsClaimCount)
    {
        this.EpsClaimCount = EpsClaimCount;
    }

    public String getConsolidatedPaymentNumber ()
    {
        return ConsolidatedPaymentNumber;
    }

    public void setConsolidatedPaymentNumber (String ConsolidatedPaymentNumber)
    {
        this.ConsolidatedPaymentNumber = ConsolidatedPaymentNumber;
    }

    public PayeePaymentMethod getPayeePaymentMethod ()
    {
        return PayeePaymentMethod;
    }

    public void setPayeePaymentMethod (PayeePaymentMethod PayeePaymentMethod)
    {
        this.PayeePaymentMethod = PayeePaymentMethod;
    }

    public String getTotalAmount ()
    {
        return TotalAmount;
    }

    public void setTotalAmount (String TotalAmount)
    {
        this.TotalAmount = TotalAmount;
    }

    public String getEpsSecondaryPayerReferenceIdentifier ()
    {
        return EpsSecondaryPayerReferenceIdentifier;
    }

    public void setEpsSecondaryPayerReferenceIdentifier (String EpsSecondaryPayerReferenceIdentifier)
    {
        this.EpsSecondaryPayerReferenceIdentifier = EpsSecondaryPayerReferenceIdentifier;
    }
    
    public EpsClaimPaymentResponses getEpsClaimPaymentResponses ()
    {
        return EpsClaimPaymentResponses;
    }

    public void setEpsClaimPaymentResponses (EpsClaimPaymentResponses EpsClaimPaymentResponses)
    {
        this.EpsClaimPaymentResponses = EpsClaimPaymentResponses;
    }

    public String getClaimCountTotal() {
		return ClaimCountTotal;
	}

	public void setClaimCountTotal(String claimCountTotal) {
		ClaimCountTotal = claimCountTotal;
	}
	

	public String getArchiveIndicator() {
		return ArchiveIndicator;
	}

	public void setArchiveIndicator(String archiveIndicator) {
		ArchiveIndicator = archiveIndicator;
	}

	@Override
	public String toString() {
		return "EpsConsolidatedClaimPaymentSummaries [PayerSummary="
				+ PayerSummary + ", PaymentTypeIndicator="
				+ PaymentTypeIndicator + ", PatientMiddleName="
				+ PatientMiddleName + ", PaymentStatusTypeDateTime="
				+ PaymentStatusTypeDateTime + ", PaymentIdentifier="
				+ PaymentIdentifier + ", PatientFirstName=" + PatientFirstName
				+ ", EpsConsolidatedClaimPaymentDetails="
				+ EpsConsolidatedClaimPaymentDetails + ", ClaimIdentifier="
				+ ClaimIdentifier + ", EpsPrimaryPayerIdentifier="
				+ EpsPrimaryPayerIdentifier
				+ ", DisplayConsolidatedPaymentNumber="
				+ DisplayConsolidatedPaymentNumber + ", ClaimOrder="
				+ ClaimOrder + ", PatientAccountNumber=" + PatientAccountNumber
				+ ", ClaimDate=" + ClaimDate + ", PaymentMadeOn="
				+ PaymentMadeOn + ", SubscriberIdentifier="
				+ SubscriberIdentifier + ", EpsPaymentStatusCode="
				+ EpsPaymentStatusCode + ", PatientLastName=" + PatientLastName
				+ ", ClaimAmount=" + ClaimAmount
				+ ", NationalProviderIdentifier=" + NationalProviderIdentifier
				+ ", PaymentStatusCode=" + PaymentStatusCode
				+ ", PayerPaymentMethod=" + PayerPaymentMethod
				+ ", EpsClaimCount=" + EpsClaimCount
				+ ", ConsolidatedPaymentNumber=" + ConsolidatedPaymentNumber
				+ ", PayeePaymentMethod=" + PayeePaymentMethod
				+ ", TotalAmount=" + TotalAmount + ", ArchiveIndicator="
				+ ArchiveIndicator + ", EpsSecondaryPayerReferenceIdentifier="
				+ EpsSecondaryPayerReferenceIdentifier + ", ClaimCountTotal="
				+ ClaimCountTotal + ", TraceNumber=" + TraceNumber
				+ ", EpsClaimPaymentResponses=" + EpsClaimPaymentResponses
				+ "]";
	}

	
}