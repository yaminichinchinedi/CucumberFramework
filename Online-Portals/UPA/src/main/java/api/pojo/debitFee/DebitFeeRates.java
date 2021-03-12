package main.java.api.pojo.debitFee;

import lombok.Data;

@Data
public class DebitFeeRates {

    private TinLevel tinLevel;
    private PayerLevel payerLevel;
    private SubPayerLevel subPayerLevel;
    private GlobalLevel globalLevel;

}
