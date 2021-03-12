package main.java.api.pojo.debitFee;

import lombok.Data;
import java.util.List;

@Data
public class TinLevel {

    private int totalCount;
    private List<TinRate> rateList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<TinRate> getRateList() {
        return rateList;
    }

    public void setRateList(List<TinRate> rateList) {
        this.rateList = rateList;
    }
}
