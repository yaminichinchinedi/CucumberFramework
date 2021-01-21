package main.java.api.pojo.epspaymentsearch.jsonrequest;

public class PaymentMadeOnDateRange {
	private String fromDate;
	private String toDate;

	public String getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return this.toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	@Override
    public String toString() {
        return "\"paymentMadeOnDateRange\": {" +
        		"\"fromDate\": \"" + fromDate + "\"," +
        		"\"toDate\": \"" + toDate + "\"" +
        		"}";
    }
}