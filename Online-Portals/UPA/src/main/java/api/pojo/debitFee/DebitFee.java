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

    public String getResponseDetail() {
        return responseDetail;
    }

    public void setResponseDetail(String responseDetail) {
        this.responseDetail = responseDetail;
    }

    public String getResponseReturnCode() {
        return responseReturnCode;
    }

    public void setResponseReturnCode(String responseReturnCode) {
        this.responseReturnCode = responseReturnCode;
    }

    public String getResponseReturnDesc() {
        return responseReturnDesc;
    }

    public void setResponseReturnDesc(String responseReturnDesc) {
        this.responseReturnDesc = responseReturnDesc;
    }

    public DebitFeeRates getDebitFeeRates() {
        return debitFeeRates;
    }

    public void setDebitFeeRates(DebitFeeRates debitFeeRates) {
        this.debitFeeRates = debitFeeRates;
    }
}
