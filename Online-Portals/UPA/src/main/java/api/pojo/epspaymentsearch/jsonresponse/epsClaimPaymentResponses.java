package main.java.api.pojo.epspaymentsearch.jsonresponse;

import java.util.List;

import main.java.api.pojo.epspaymentsearch.jsonresponse.code.PaymentMethodCode;

public class epsClaimPaymentResponses {
	

    private String nachaResponseIdentifier;
    private String returnedOn;
    private String returnedPaymentTypeCodeText;
    private String returnedPaymentStatusCodeText;
    private PaymentMethodCode paymentMethodCode;
    private paymentReturnedReasonCode paymentReturnedReasonCode;
    private epsReturnedReoriginatedClaimPayment epsReturnedReoriginatedClaimPayment;


    public String getNachaResponseIdentifier() {
        return nachaResponseIdentifier;
    }

    public void setNachaResponseIdentifier(String NachaResponseIdentifier) {
        this.nachaResponseIdentifier = NachaResponseIdentifier;
    }
    
    public String getReturnedOn() {
        return returnedOn;
    }

    public void setReturnedOn(String ReturnedOn) {
        this.returnedOn = ReturnedOn;
    }
    
    public String getReturnedPaymentTypeCodeText() {
        return returnedPaymentTypeCodeText;
    }

    public void setReturnedPaymentTypeCodeText(String ReturnedPaymentTypeCodeText) {
        this.returnedPaymentTypeCodeText = ReturnedPaymentTypeCodeText;
    }
    public String getReturnedPaymentStatusCodeText() {
        return returnedPaymentStatusCodeText;
    }

    public void setReturnedPaymentStatusCodeText(String ReturnedPaymentStatusCodeText) {
        this.returnedPaymentStatusCodeText = ReturnedPaymentStatusCodeText;
    }
    
    public PaymentMethodCode getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(PaymentMethodCode paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }
    
    
    
    public paymentReturnedReasonCode getPaymentReturnedReasonCode() {
        return paymentReturnedReasonCode;
    }

    public void setPaymentReturnedReasonCode(paymentReturnedReasonCode PaymentReturnedReasonCode) {
        this.paymentReturnedReasonCode = PaymentReturnedReasonCode;
    }
    
    public epsReturnedReoriginatedClaimPayment getEpsReturnedReoriginatedClaimPayment() {
        return epsReturnedReoriginatedClaimPayment;
    }

    public void setEpsReturnedReoriginatedClaimPayment(epsReturnedReoriginatedClaimPayment EpsReturnedReoriginatedClaimPayment) {
        this.epsReturnedReoriginatedClaimPayment = EpsReturnedReoriginatedClaimPayment;
    }


}
