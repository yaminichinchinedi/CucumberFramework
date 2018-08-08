package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlElement;
 
public class EpsPaymentStatusCode { 
	
    @XmlElement(name = "PaymentMode", required = true)
    private String PaymentMode;

 
    public String getPaymentMode ()
    {
        return PaymentMode;
    }

    public void setPaymentMode(String PaymentMode)
    {
        this.PaymentMode = PaymentMode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [PaymentMode = "+PaymentMode+"]";
    }
}
	
