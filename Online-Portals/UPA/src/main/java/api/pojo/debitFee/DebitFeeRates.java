package main.java.api.pojo.debitFee;

import lombok.Data;

@Data
public class DebitFeeRates {

    private TinLevel tinLevel;
    private PayerLevel payerLevel;
    private SubPayerLevel subPayerLevel;
    private GlobalLevel globalLevel;

    public TinLevel getTinLevel() {
        return tinLevel;
    }

    public void setTinLevel(TinLevel tinLevel) {
        this.tinLevel = tinLevel;
    }

    public PayerLevel getPayerLevel() {
        return payerLevel;
    }

    public void setPayerLevel(PayerLevel payerLevel) {
        this.payerLevel = payerLevel;
    }

    public SubPayerLevel getSubPayerLevel() {
        return subPayerLevel;
    }

    public void setSubPayerLevel(SubPayerLevel subPayerLevel) {
        this.subPayerLevel = subPayerLevel;
    }

    public GlobalLevel getGlobalLevel() {
        return globalLevel;
    }

    public void setGlobalLevel(GlobalLevel globalLevel) {
        this.globalLevel = globalLevel;
    }
}
