package main.java.api.pojo.debitFee;

import lombok.Data;

import java.util.List;

@Data
public class SubPayerLevel {

    private int totalCount;
    private List<SubPayerRate> rateList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<SubPayerRate> getRateList() {
        return rateList;
    }

    public void setRateList(List<SubPayerRate> rateList) {
        this.rateList = rateList;
    }
}

