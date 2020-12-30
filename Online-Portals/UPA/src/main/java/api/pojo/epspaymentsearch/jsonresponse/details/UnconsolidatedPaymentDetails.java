package main.java.api.pojo.epspaymentsearch.jsonresponse.details;

public class UnconsolidatedPaymentDetails {
    private String unconsolidatedPaymentIdentifier;
    private String uncpDepositDate;
    private String eobcreateDate;


    public String getUnconsolidatedPaymentIdentifier() {
        return unconsolidatedPaymentIdentifier;
    }

    public void setUnconsolidatedPaymentIdentifier(String unconsolidatedPaymentIdentifier) {
        this.unconsolidatedPaymentIdentifier = unconsolidatedPaymentIdentifier;
    }
    
    public String getUncpDepositDate() {
        return uncpDepositDate;
    }

    public void setUncpDepositDate(String uncpDepositDate) {
        this.uncpDepositDate = uncpDepositDate;
    }
    
    public String getEobcreateDate() {
        return eobcreateDate;
    }

    public void setEobcreateDate(String eobcreateDate) {
        this.eobcreateDate = eobcreateDate;
    }
}
