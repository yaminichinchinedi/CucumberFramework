package main.java.api.pojo.epspaymentsearch.jsonresponse;

public class epsConsolidatedClaimPaymentDetails {
    private String checkNumber;
    private String consolidatedPaymentDetailIdentifier;
    private String checkDate;


    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String CheckNumber) {
        this.checkNumber = CheckNumber;
    }
    
    public String getConsolidatedPaymentDetailIdentifier() {
        return consolidatedPaymentDetailIdentifier;
    }

    public void setConsolidatedPaymentDetailIdentifier(String ConsolidatedPaymentDetailIdentifier) {
        this.consolidatedPaymentDetailIdentifier = ConsolidatedPaymentDetailIdentifier;
    }
    
    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String CheckDate) {
        this.checkDate = CheckDate;
    }
}
