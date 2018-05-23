package main.java.api.pojo.epspaymentsearch.response;

public class BankAccount
{
    private String BankAccountTypeCode;

    public String getBankAccountTypeCode ()
    {
        return BankAccountTypeCode;
    }

    public void setBankAccountTypeCode (String BankAccountTypeCode)
    {
        this.BankAccountTypeCode = BankAccountTypeCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [BankAccountTypeCode = "+BankAccountTypeCode+"]";
    }
}
