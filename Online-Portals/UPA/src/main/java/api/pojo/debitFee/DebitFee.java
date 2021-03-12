package main.java.api.pojo.debitFee;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonInclude;


@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebitFee {
    private String responseDetail;
    private String responseReturnCode;
    private String responseReturnDesc;
    private DebitFeeRates debitFeeRates;
}
