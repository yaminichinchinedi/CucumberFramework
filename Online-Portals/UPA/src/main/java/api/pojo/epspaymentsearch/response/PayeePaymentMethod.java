package main.java.api.pojo.epspaymentsearch.response;

public class PayeePaymentMethod
{
    private PaymentMethodCode PaymentMethodCode;

    public PaymentMethodCode getPaymentMethodCode ()
    {
        return PaymentMethodCode;
    }

    public void setPaymentMethodCode (PaymentMethodCode PaymentMethodCode)
    {
        this.PaymentMethodCode = PaymentMethodCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [PaymentMethodCode = "+PaymentMethodCode+"]";
    }
}
	