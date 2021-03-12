package main.java.api.pojo.debitFee;

import lombok.Data;

import java.util.List;

@Data
public class GlobalLevel {
    private int totalCount;
    private List<GlobalRate> rateList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<GlobalRate> getRateList() {
        return rateList;
    }

    public void setRateList(List<GlobalRate> rateList) {
        this.rateList = rateList;
    }
}
