package main.java.api.pojo.debitFee;

import lombok.Data;

import java.util.List;

@Data
public class GlobalLevel {
    private int totalCount;
    private List<GlobalRate> rateList;
}
