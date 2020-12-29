package main.java.api.pojo.epspaymentsearch.jsonresponse.method;

import main.java.api.pojo.epspaymentsearch.jsonresponse.code.PaymentMethodCode;

public class PayeePaymentMethod {
    private PaymentMethodCode paymentMethodCode;

    public PaymentMethodCode getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(PaymentMethodCode paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }
}
