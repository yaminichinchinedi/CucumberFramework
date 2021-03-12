package main.java.api.pojo.debitFee;

import lombok.Data;

@Data
public class TinRate {

    private String provTIN;
    private int tinRate;
    private String startDate;
    private String endDate;
}
