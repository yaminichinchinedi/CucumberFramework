package main.java.api.pojo.epspaymentsearch.jsonresponse.amount;

public class ClaimAmount {
    private String currencyCode;
    private Double ammount;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }
}
