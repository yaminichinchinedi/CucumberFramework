package main.java.api.pojo.debitFee;

import lombok.Data;

import java.util.List;

@Data
public class SubPayerLevel {

    private int totalCount;
    private List<SubPayerRate> rateList;
}

