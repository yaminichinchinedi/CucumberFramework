package main.java.api.pojo.epspaymentsearch.jsonrequest;

import java.util.StringJoiner;

public class DOP extends Data {
	private PaymentMadeOnDateRange paymentMadeOnDateRange;
	private String[] epsNationalProviderIdentifiers;
	private String[] epsSecondaryPayerReferenceIdentifiers;


	public DOP() {
		this.paymentMadeOnDateRange = new PaymentMadeOnDateRange();
	}

	public PaymentMadeOnDateRange getPaymentMadeOnDateRange() {
		return this.paymentMadeOnDateRange;
	}

	public void setPaymentMadeOnDateRange(PaymentMadeOnDateRange paymentMadeOnDateRange) {
		this.paymentMadeOnDateRange = paymentMadeOnDateRange;
	}

	public String[] getEpsNationalProviderIdentifiers() {
		return this.epsNationalProviderIdentifiers;
	}

	public void setEpsNationalProviderIdentifiers(String[] epsNationalProviderIdentifiers) {
		this.epsNationalProviderIdentifiers = epsNationalProviderIdentifiers;
	}
	
	public String[] getEpsSecondaryPayerReferenceIdentifiers() {
		return this.epsSecondaryPayerReferenceIdentifiers;
	}

	public void setEpsSecondaryPayerReferenceIdentifiers(String[] epsSecondaryPayerReferenceIdentifiers) {
		this.epsSecondaryPayerReferenceIdentifiers = epsSecondaryPayerReferenceIdentifiers;
	}

	@Override
    public String toString() {
    	//StringJoiner sj = new StringJoiner("\",\"", "[\"", "\"]");
    	StringJoiner sj = new StringJoiner(",", "[", "]");
    	StringJoiner stj = new StringJoiner(",", "[", "]");

    	for (String epsNationalProviderIdentifiers : this.epsNationalProviderIdentifiers) {
    		sj.add(epsNationalProviderIdentifiers);
    	}
    	for (String epsSecondaryPayerReferenceIdentifiers : this.epsSecondaryPayerReferenceIdentifiers) {
    		stj.add(epsSecondaryPayerReferenceIdentifiers);
    	}
        return "{\"data\": {" +
        		super.getSearchCriteria().toString() + "," +
        		"\"taxIdentifier\": \"" + super.getTaxIdentifier() + "\"," +
        		"\"userRole\": \"" + super.getUserRole() + "\"," +
        		"\"epsNationalProviderIdentifiers\": " + sj.toString() + "," +
        		this.paymentMadeOnDateRange.toString() + "," +
        		"\"epsSecondaryPayerReferenceIdentifiers\": " + stj.toString() +
        		"}}";
    }
}