package main.java.api.pojo.epspaymentsearch.jsonrequest;

import java.util.StringJoiner;

public class DOSNPI extends Data {
	private PaymentMadeOnDateRange paymentMadeOnDateRange;
	private String[] epsSecondaryPayerReferenceIdentifiers;

	public DOSNPI() {
		this.paymentMadeOnDateRange = new PaymentMadeOnDateRange();
	}

	public PaymentMadeOnDateRange getPaymentMadeOnDateRange() {
		return this.paymentMadeOnDateRange;
	}

	public void setPaymentMadeOnDateRange(PaymentMadeOnDateRange paymentMadeOnDateRange) {
		this.paymentMadeOnDateRange = paymentMadeOnDateRange;
	}

	public String[] getEpsSecondaryPayerReferenceIdentifiers() {
		return this.epsSecondaryPayerReferenceIdentifiers;
	}

	public void setEpsSecondaryPayerReferenceIdentifiers(String[] epsSecondaryPayerReferenceIdentifiers) {
		this.epsSecondaryPayerReferenceIdentifiers = epsSecondaryPayerReferenceIdentifiers;
	}

	@Override
    public String toString() {
    	StringJoiner sj = new StringJoiner("\",\"", "[\"", "\"]");

    	for (String epsSecondaryPayerReferenceIdentifiers : this.epsSecondaryPayerReferenceIdentifiers) {
    		sj.add(epsSecondaryPayerReferenceIdentifiers);
    	}

        return "{\"data\": {" +
        		super.getSearchCriteria().toString() + "," +
        		"\"taxIdentifier\": \"" + super.getTaxIdentifier() + "\"," +
        		"\"userRole\": \"" + super.getUserRole() + "\"," +
        		this.paymentMadeOnDateRange.toString() + "," +
        		"\"epsSecondaryPayerReferenceIdentifiers\": " + sj.toString() +
        		"}}";
    }
}