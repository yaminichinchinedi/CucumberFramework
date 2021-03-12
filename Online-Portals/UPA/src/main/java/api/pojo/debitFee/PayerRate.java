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

}
