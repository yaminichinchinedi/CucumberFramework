package main.java.api.pojo.epspaymentsearch.response;

public class PayerPaymentMethod
{
    private BankAccount BankAccount;

    public BankAccount getBankAccount ()
    {
        return BankAccount;
    }

    public void setBankAccount (BankAccount BankAccount)
    {
        this.BankAccount = BankAccount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [BankAccount = "+BankAccount+"]";
    }
}

