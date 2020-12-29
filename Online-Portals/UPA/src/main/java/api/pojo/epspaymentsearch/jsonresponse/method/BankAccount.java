package main.java.api.pojo.epspaymentsearch.jsonresponse.method;

import main.java.api.pojo.epspaymentsearch.jsonresponse.code.BankAccountTypeCode;

public class BankAccount {
    private BankAccountTypeCode bankAccountTypeCode;

    public BankAccountTypeCode getBankAccountTypeCode() {
        return bankAccountTypeCode;
    }

    public void setBankAccountTypeCode(BankAccountTypeCode bankAccountTypeCode) {
        this.bankAccountTypeCode = bankAccountTypeCode;
    }
}
