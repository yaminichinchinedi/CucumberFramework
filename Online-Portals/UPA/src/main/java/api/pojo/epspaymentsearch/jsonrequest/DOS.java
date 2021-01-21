package main.java.api.pojo.epspaymentsearch.jsonrequest;

public class DOS extends Data {
	private ClaimServiceDateRange claimServiceDateRange;
	private String[] epsSecondaryPayerReferenceIdentifiers;

	public DOS() {
		this.claimServiceDateRange = new ClaimServiceDateRange();
		// this.epsSecondaryPayerReferenceIdentifiers = new String[] {""};
	}

	public ClaimServiceDateRange getClaimServiceDateRange() {
		return this.claimServiceDateRange;
	}

	public void setClaimServiceDateRange(ClaimServiceDateRange claimServiceDateRange) {
		this.claimServiceDateRange = claimServiceDateRange;
	}

	public String[] getEpsSecondaryPayerReferenceIdentifiers() {
		return this.epsSecondaryPayerReferenceIdentifiers;
	}

	public void setEpsSecondaryPayerReferenceIdentifiers(String[] epsSecondaryPayerReferenceIdentifiers) {
		this.epsSecondaryPayerReferenceIdentifiers = epsSecondaryPayerReferenceIdentifiers;
	}

	@Override
    public String toString() {
        return "{\"data\": {" +
        		super.getSearchCriteria().toString() + "," +
        		"\"taxIdentifier\": \"" + super.getTaxIdentifier() + "\"," +
        		"\"userRole\": \"" + super.getUserRole() + "\"," +
        		this.claimServiceDateRange.toString() + "," +
        		"\"epsSecondaryPayerReferenceIdentifiers\": " + this.epsSecondaryPayerReferenceIdentifiers.toString() +
        		"}}";
    }
}