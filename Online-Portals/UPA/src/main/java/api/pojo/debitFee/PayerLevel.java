package main.java.api.pojo.debitFee;

import lombok.Data;

import java.util.List;
@Data
public class PayerLevel {

    private int totalCount;
    private List<PayerRate> rateList;
}
