package main.java.api.pojo.debitFee;

import lombok.Data;

import java.util.List;
@Data
public class PayerLevel {

    private int totalCount;
    private List<PayerRate> rateList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<PayerRate> getRateList() {
        return rateList;
    }

    public void setRateList(List<PayerRate> rateList) {
        this.rateList = rateList;
    }
}
