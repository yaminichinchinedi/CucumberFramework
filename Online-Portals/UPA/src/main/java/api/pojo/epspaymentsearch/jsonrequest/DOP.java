package main.java.api.pojo.epspaymentsearch.jsonrequest;

public class DOP extends Data {
	private PaymentMadeOnDateRange paymentMadeOnDateRange;

	public DOP() {
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