package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlElement;

public class PayeePaymentMethod
{
	@XmlElement(name = "PaymentMethodCode", required = true)
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
	