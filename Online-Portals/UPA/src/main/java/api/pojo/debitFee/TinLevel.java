package main.java.api.pojo.debitFee;

import lombok.Data;
import java.util.List;

@Data
public class TinLevel {

    private int totalCount;
    private List<TinRate> rateList;
}
