package main.java.api.pojo.epspaymentsearch.jsonresponse;

import main.java.api.pojo.epspaymentsearch.jsonresponse.amount.ClaimAmount;
import main.java.api.pojo.epspaymentsearch.jsonresponse.code.EpsPaymentStatusCode;
import main.java.api.pojo.epspaymentsearch.jsonresponse.code.PaymentStatusCode;
import main.java.api.pojo.epspaymentsearch.jsonresponse.details.UnconsolidatedPaymentDetails;
import main.java.api.pojo.epspaymentsearch.jsonresponse.method.PayeePaymentMethod;
import main.java.api.pojo.epspaymentsearch.jsonresponse.method.PayerPaymentMethod;
import main.java.api.pojo.epspaymentsearch.jsonresponse.summary.PayerSummary;
import main.java.api.pojo.epspaymentsearch.jsonresponse.summary.ProviderSummary;

import java.util.HashSet;
import java.util.Set;

public class EpsConsolidatedClaimPaymentSummaries {

    private String paymentIdentifier;
    private Double totalAmount;
    private String paymentMadeOn;
    private String displayConsolidatedPaymentNumber;
    private String consolidatedPaymentNumber;
    private String epsPrimaryPayerIdentifier;
    private String epsSecondaryPayerReferenceIdentifier;
    private String paymentTypeIndicator;
    private String archiveIndicator;
    private String patientFirstName;
    private String patientMiddleName;
    private String patientLastName;
    private String subscriberIdentifier;
    private String patientAccountNumber;
    private String claimIdentifier;
    private ClaimAmount claimAmount;
    private String claimDate;
    private Long claimOrder;
    private String depositDate;
    private String processDateTime;
    private String internalControlIdentifier;
    private Long claimCountTotal;
    private Long epsClaimCount;
    private String nationalProviderIdentifier;
    private String traceNumber;
    private PayerSummary payerSummary;
    private ProviderSummary providerSummary;
    private PayerPaymentMethod payerPaymentMethod;
    private PayeePaymentMethod payeePaymentMethod;
    private PaymentStatusCode paymentStatusCode;
    private EpsPaymentStatusCode epsPaymentStatusCode;
    private UnconsolidatedPaymentDetails[] unconsolidatedPaymentDetails;

    public EpsConsolidatedClaimPaymentSummaries() {
    }

    public String getPaymentIdentifier() {
        return paymentIdentifier;
    }

    public void setPaymentIdentifier(String paymentIdentifier) {
        this.paymentIdentifier = paymentIdentifier;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PayerSummary getPayerSummary() {
        return payerSummary;
    }

    public void setPayerSummary(PayerSummary payerSummary) {
        this.payerSummary = payerSummary;
    }

    public ProviderSummary getProviderSummary() {
        return providerSummary;
    }

    public void setProviderSummary(ProviderSummary providerSummary) {
        this.providerSummary = providerSummary;
    }

    public PayerPaymentMethod getPayerPaymentMethod() {
        return payerPaymentMethod;
    }

    public void setPayerPaymentMethod(PayerPaymentMethod payerPaymentMethod) {
        this.payerPaymentMethod = payerPaymentMethod;
    }

    public String getPaymentMadeOn() {
        return paymentMadeOn;
    }

    public void setPaymentMadeOn(String paymentMadeOn) {
        this.paymentMadeOn = paymentMadeOn;
    }

    public String getDisplayConsolidatedPaymentNumber() {
        return displayConsolidatedPaymentNumber;
    }

    public void setDisplayConsolidatedPaymentNumber(String displayConsolidatedPaymentNumber) {
        this.displayConsolidatedPaymentNumber = displayConsolidatedPaymentNumber;
    }

    public String getConsolidatedPaymentNumber() {
        return consolidatedPaymentNumber;
    }

    public void setConsolidatedPaymentNumber(String consolidatedPaymentNumber) {
        this.consolidatedPaymentNumber = consolidatedPaymentNumber;
    }

    public String getEpsPrimaryPayerIdentifier() {
        return epsPrimaryPayerIdentifier;
    }

    public void setEpsPrimaryPayerIdentifier(String epsPrimaryPayerIdentifier) {
        this.epsPrimaryPayerIdentifier = epsPrimaryPayerIdentifier;
    }

    public String getEpsSecondaryPayerReferenceIdentifier() {
        return epsSecondaryPayerReferenceIdentifier;
    }

    public void setEpsSecondaryPayerReferenceIdentifier(String epsSecondaryPayerReferenceIdentifier) {
        this.epsSecondaryPayerReferenceIdentifier = epsSecondaryPayerReferenceIdentifier;
    }

    public String getPaymentTypeIndicator() {
        return paymentTypeIndicator;
    }

    public void setPaymentTypeIndicator(String paymentTypeIndicator) {
        this.paymentTypeIndicator = paymentTypeIndicator;
    }
    
    public String getArchiveIndicator() {
        return archiveIndicator;
    }

    public void setArchiveIndicator(String archiveIndicator) {
        this.archiveIndicator = archiveIndicator;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientMiddleName() {
        return patientMiddleName;
    }

    public void setPatientMiddleName(String patientMiddleName) {
        this.patientMiddleName = patientMiddleName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getSubscriberIdentifier() {
        return subscriberIdentifier;
    }

    public void setSubscriberIdentifier(String subscriberIdentifier) {
        this.subscriberIdentifier = subscriberIdentifier;
    }

    public String getPatientAccountNumber() {
        return patientAccountNumber;
    }

    public void setPatientAccountNumber(String patientAccountNumber) {
        this.patientAccountNumber = patientAccountNumber;
    }

    public String getClaimIdentifier() {
        return claimIdentifier;
    }

    public void setClaimIdentifier(String claimIdentifier) {
        this.claimIdentifier = claimIdentifier;
    }

    public ClaimAmount getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(ClaimAmount claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Long getClaimOrder() {
        return claimOrder;
    }

    public void setClaimOrder(Long claimOrder) {
        this.claimOrder = claimOrder;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public String getProcessDateTime() {
        return processDateTime;
    }

    public void setProcessDateTime(String processDateTime) {
        this.processDateTime = processDateTime;
    }
    
    public String getInternalControlIdentifier() {
        return internalControlIdentifier;
    }

    public void setInternalControlIdentifier(String internalControlIdentifier) {
        this.internalControlIdentifier = internalControlIdentifier;
    }

    public Long getClaimCountTotal() {
        return claimCountTotal;
    }

    public void setClaimCountTotal(Long claimCountTotal) {
        this.claimCountTotal = claimCountTotal;
    }

    public Long getEpsClaimCount() {
        return epsClaimCount;
    }

    public void setEpsClaimCount(Long epsClaimCount) {
        this.epsClaimCount = epsClaimCount;
    }

    public String getNationalProviderIdentifier() {
        return nationalProviderIdentifier;
    }

    public void setNationalProviderIdentifier(String nationalProviderIdentifier) {
        this.nationalProviderIdentifier = nationalProviderIdentifier;
    }
    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    public PayeePaymentMethod getPayeePaymentMethod() {
        return payeePaymentMethod;
    }

    public void setPayeePaymentMethod(PayeePaymentMethod payeePaymentMethod) {
        this.payeePaymentMethod = payeePaymentMethod;
    }

    public PaymentStatusCode getPaymentStatusCode() {
        return paymentStatusCode;
    }

    public void setPaymentStatusCode(PaymentStatusCode paymentStatusCode) {
        this.paymentStatusCode = paymentStatusCode;
    }

    public EpsPaymentStatusCode getEpsPaymentStatusCode() {
        return epsPaymentStatusCode;
    }

    public void setEpsPaymentStatusCode(EpsPaymentStatusCode epsPaymentStatusCode) {
        this.epsPaymentStatusCode = epsPaymentStatusCode;
    }

    public UnconsolidatedPaymentDetails[] getUnconsolidatedPaymentDetails() {
        return unconsolidatedPaymentDetails;
    }

    public void setUnconsolidatedPaymentDetails(UnconsolidatedPaymentDetails[] unconsolidatedPaymentDetails) {
        this.unconsolidatedPaymentDetails = unconsolidatedPaymentDetails;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }
}
