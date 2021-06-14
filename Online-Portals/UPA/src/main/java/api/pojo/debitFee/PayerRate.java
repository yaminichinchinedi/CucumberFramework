package main.java.api.pojo.debitFee;

import lombok.Data;

@Data
public class PayerRate {

    private String primaryPayerID;
    private String secondaryPayerID;
    private String payerRate;
    private String rateDesc;
    private String startDate;
    private String endDate;

    public String getPrimaryPayerID() {
        return primaryPayerID;
    }

    public void setPrimaryPayerID(String primaryPayerID) {
        this.primaryPayerID = primaryPayerID;
    }

    public String getSecondaryPayerID() {
        return secondaryPayerID;
    }

    public void setSecondaryPayerID(String secondaryPayerID) {
        this.secondaryPayerID = secondaryPayerID;
    }

    public String getPayerRate() {
        return payerRate;
    }

    public void setPayerRate(String payerRate) {
        this.payerRate = payerRate;
    }

    public String getRateDesc() {
        return rateDesc;
    }

    public void setRateDesc(String rateDesc) {
        this.rateDesc = rateDesc;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
