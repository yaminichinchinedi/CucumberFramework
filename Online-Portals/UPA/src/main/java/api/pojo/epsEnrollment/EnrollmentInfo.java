package main.java.api.pojo.epsEnrollment;

public  class EnrollmentInfo {
	
	private static volatile EnrollmentInfo instance;
	private static Object mutex = new Object();

	private EnrollmentInfo() {
		
	}

	public static EnrollmentInfo getInstance() {
		EnrollmentInfo result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if (result == null)
					instance = result = new EnrollmentInfo();
			}
		}
		return result;
	}

	
	public String bsTinIdentifier;
	public String tin;
	public String businessName;
	public String street;
	public String city;
	public String zipCode;
	public String stateName;
	public String frstName;
	public String lstName;
	public String email;
	public String phnNumbr;
	public String authFrstName;
	public String authLstName;
	public String authPhnNbr;
	public String authEmail;
	
	
	public String getFrstName() {
		return frstName;
	}

	public void setFrstName(String frstName) {
		this.frstName = frstName;
	}

	public String getLstName() {
		return lstName;
	}

	public void setLstName(String lstName) {
		this.lstName = lstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnNumbr() {
		return phnNumbr;
	}

	public void setPhnNumbr(String phnNumbr) {
		this.phnNumbr = phnNumbr;
	}

	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getBsTinIdentifier() {
		return bsTinIdentifier;
	}

	public void setBsTinIdentifier(String bsTinIdentifier) {
		this.bsTinIdentifier = bsTinIdentifier;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getAuthFrstName() {
		return authFrstName;
	}

	public void setAuthFrstName(String authFrstName) {
		this.authFrstName = authFrstName;
	}

	public String getAuthLstName() {
		return authLstName;
	}

	public void setAuthLstName(String authLstName) {
		this.authLstName = authLstName;
	}

	public String getAuthPhnNbr() {
		return authPhnNbr;
	}

	public void setAuthPhnNbr(String authPhnNbr) {
		this.authPhnNbr = authPhnNbr;
	}

	public String getAuthEmail() {
		return authEmail;
	}

	public void setAuthEmail(String authEmail) {
		this.authEmail = authEmail;
	}
	
}
