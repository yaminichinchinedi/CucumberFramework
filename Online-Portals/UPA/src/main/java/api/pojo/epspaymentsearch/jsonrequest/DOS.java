package main.java.api.pojo.epspaymentsearch.jsonrequest;

import java.util.StringJoiner;

public class DOS extends Data {
	private ClaimServiceDateRange claimServiceDateRange;
	private String[] epsSecondaryPayerReferenceIdentifiers;
	private String[] epsNationalProviderIdentifiers;


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
	
	public String[] getEpsNationalProviderIdentifiers() {
		return this.epsNationalProviderIdentifiers;
	}

	public void setEpsNationalProviderIdentifiers(String[] epsNationalProviderIdentifiers) {
		this.epsNationalProviderIdentifiers = epsNationalProviderIdentifiers;
	}

	@Override
    public String toString() {
    	StringJoiner sj = new StringJoiner(",", "[", "]");
    	//StringJoiner stj = new StringJoiner("\",\"", "[\"", "\"]");
    	StringJoiner stj = new StringJoiner(",", "[", "]");;

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
        		this.claimServiceDateRange.toString() + "," +
        		"\"epsSecondaryPayerReferenceIdentifiers\": " + stj.toString() +
        		"}}";
    }
}