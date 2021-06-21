package main.java.api.pojo.debitFee;

import lombok.Data;

@Data
public class TinRate {

    private String provTIN;
    private int tinRate;
    private String startDate;
    private String endDate;

    public String getProvTIN() {
        return provTIN;
    }

    public void setProvTIN(String provTIN) {
        this.provTIN = provTIN;
    }

    public int getTinRate() {
        return tinRate;
    }

    public void setTinRate(int tinRate) {
        this.tinRate = tinRate;
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
