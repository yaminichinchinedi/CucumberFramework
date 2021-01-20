package main.java.api.pojo.epspaymentsearch.jsonrequest;

public class Data {
	private SearchCriteria searchCriteria;
	private String taxIdentifier;
	private String userRole;

	public Data() {
		this.searchCriteria = new SearchCriteria();
	}

	public SearchCriteria getSearchCriteria() {
		return this.searchCriteria;
	}

	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public String getTaxIdentifier() {
		return this.taxIdentifier;
	}

	public void setTaxIdentifier(String taxIdentifier) {
		this.taxIdentifier = taxIdentifier;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}