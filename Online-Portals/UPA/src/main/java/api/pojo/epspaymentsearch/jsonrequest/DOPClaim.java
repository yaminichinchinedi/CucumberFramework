package main.java.api.pojo.epspaymentsearch.jsonrequest;


public class DOPClaim extends Data {
	private PaymentMadeOnDateRange paymentMadeOnDateRange;
	private String[] epsSecondaryPayerReferenceIdentifiers;

	public DOPClaim() {
		this.paymentMadeOnDateRange = new PaymentMadeOnDateRange();
	}

	public PaymentMadeOnDateRange getPaymentMadeOnDateRange() {
		return this.paymentMadeOnDateRange;
	}

	public void setPaymentMadeOnDateRange(PaymentMadeOnDateRange paymentMadeOnDateRange) {
		this.paymentMadeOnDateRange = paymentMadeOnDateRange;
	}

	@Override
    public String toString() {
        return "{\"data\": {" +
        		super.getSearchCriteria().toString() + "," +
        		"\"taxIdentifier\": \"" + super.getTaxIdentifier() + "\"," +
        		"\"userRole\": \"" + super.getUserRole() + "\"," +
        		this.paymentMadeOnDateRange.toString() +
        		"}}";
    }
}