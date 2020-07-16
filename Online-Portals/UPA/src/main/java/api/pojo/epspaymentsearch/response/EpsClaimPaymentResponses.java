package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlElement;

public class EpsClaimPaymentResponses
{
	@XmlElement(name = "EpsReturnedReoriginatedClaimPayment", required = true)
    private EpsReturnedReoriginatedClaimPayment EpsReturnedReoriginatedClaimPayment;

    private String ReturnedOn;

    private String ReturnedPaymentStatusCodeText;

    private PaymentReturnedReasonCode PaymentReturnedReasonCode;

    private String NachaResponseIdentifier;

    private PaymentMethodCode PaymentMethodCode;

    private String ReturnedPaymentTypeCodeText;

    public EpsReturnedReoriginatedClaimPayment getEpsReturnedReoriginatedClaimPayment ()
    {
        return EpsReturnedReoriginatedClaimPayment;
    }

    public void setEpsReturnedReoriginatedClaimPayment (EpsReturnedReoriginatedClaimPayment EpsReturnedReoriginatedClaimPayment)
    {
        this.EpsReturnedReoriginatedClaimPayment = EpsReturnedReoriginatedClaimPayment;
    }

    public String getReturnedOn ()
    {
        return ReturnedOn;
    }

    public void setReturnedOn (String ReturnedOn)
    {
        this.ReturnedOn = ReturnedOn;
    }

    public String getReturnedPaymentStatusCodeText ()
    {
        return ReturnedPaymentStatusCodeText;
    }

    public void setReturnedPaymentStatusCodeText (String ReturnedPaymentStatusCodeText)
    {
        this.ReturnedPaymentStatusCodeText = ReturnedPaymentStatusCodeText;
    }

    public PaymentReturnedReasonCode getPaymentReturnedReasonCode ()
    {
        return PaymentReturnedReasonCode;
    }

    public void setPaymentReturnedReasonCode (PaymentReturnedReasonCode PaymentReturnedReasonCode)
    {
        this.PaymentReturnedReasonCode = PaymentReturnedReasonCode;
    }

    public String getNachaResponseIdentifier ()
    {
        return NachaResponseIdentifier;
    }

    public void setNachaResponseIdentifier (String NachaResponseIdentifier)
    {
        this.NachaResponseIdentifier = NachaResponseIdentifier;
    }

    public PaymentMethodCode getPaymentMethodCode ()
    {
        return PaymentMethodCode;
    }

    public void setPaymentMethodCode (PaymentMethodCode PaymentMethodCode)
    {
        this.PaymentMethodCode = PaymentMethodCode;
    }

    public String getReturnedPaymentTypeCodeText ()
    {
        return ReturnedPaymentTypeCodeText;
    }

    public void setReturnedPaymentTypeCodeText (String ReturnedPaymentTypeCodeText)
    {
        this.ReturnedPaymentTypeCodeText = ReturnedPaymentTypeCodeText;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EpsReturnedReoriginatedClaimPayment = "+EpsReturnedReoriginatedClaimPayment+", ReturnedOn = "+ReturnedOn+", ReturnedPaymentStatusCodeText = "+ReturnedPaymentStatusCodeText+", PaymentReturnedReasonCode = "+PaymentReturnedReasonCode+", NachaResponseIdentifier = "+NachaResponseIdentifier+", PaymentMethodCode = "+PaymentMethodCode+", ReturnedPaymentTypeCodeText = "+ReturnedPaymentTypeCodeText+"]";
    }
}