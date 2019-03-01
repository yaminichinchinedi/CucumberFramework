package main.java.common.pojo.createEnrollment;

public  class EnrollmentInfo {
	/**
	 * This class stores all the information while enrolling as BS or HealthOrganization.
	 * @author akushw10
	 */
	
		
	private static volatile EnrollmentInfo instance;
	private static Object mutex = new Object();

	private EnrollmentInfo() {
		
	}

	public static EnrollmentInfo getInstance() {
		
		/*if(instance == null){
            instance = new EnrollmentInfo();
        }
        return instance;*/	
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

	public static void clear() {
	    instance = null;
	}
	
	//Tin Info
	protected String enrollType;
	protected String tinIdentifier;
	protected String tin;
	
	//ORG name
	protected String businessName;
	protected String street;
	protected String city;
	protected String zipCode;
	protected String stateName;
	protected String mrktType;
	protected String npi;
	protected String provType;

	//Primary Admin Info
	protected String frstName;
	protected String lstName;
	protected String email;
	protected String phnNumbr;
	
	
	//Authorized Enrollers Info
	protected String authFrstName;
	protected String authLstName;
	protected String authPhnNbr;
	protected String authEmail;
	protected String authTitle;
	
	//Financial Inst
	protected String finInstName;
	protected String finStreet;
	protected String finCity;
	protected String finState;
	protected String finZip;
	protected String finRoutingNo;
	protected String finAcntNo;
	protected String finPhoneNo;
	protected String finDocCode;
	
	//W9
	protected String w9DocCode;
	
	public String getEnrollType() {
		return enrollType;
	}

	public void setEnrollType(String enrollType) {
		this.enrollType = enrollType;
	}

	public String getProvType() {
		return provType;
	}

	public void setProvType(String provType) {
		this.provType = provType;
	}
	
	public String getMrktType() {
		return mrktType;
	}

	public void setMrktType(String mrktType) {
		this.mrktType = mrktType;
	}

	public String getNpi() {
		return npi;
	}

	public void setNpi(String npi) {
		this.npi = npi;
	}

	public String getFinDocCode() {
		return finDocCode;
	}

	public void setFinDocCode(String finDocCode) {
		this.finDocCode = finDocCode;
	}

	public String getW9DocCode() {
		return w9DocCode;
	}

	public void setW9DocCode(String w9DocCode) {
		this.w9DocCode = w9DocCode;
	}
	
	public String getFinInstName() {
		return finInstName;
	}

	public void setFinInstName(String finInstName) {
		this.finInstName = finInstName;
	}

	public String getFinStreet() {
		return finStreet;
	}

	public void setFinStreet(String finStreet) {
		this.finStreet = finStreet;
	}

	public String getFinCity() {
		return finCity;
	}

	public void setFinCity(String finCity) {
		this.finCity = finCity;
	}

	public String getFinState() {
		return finState;
	}

	public void setFinState(String finState) {
		this.finState = finState;
	}

	public String getFinZip() {
		return finZip;
	}

	public void setFinZip(String finZip) {
		this.finZip = finZip;
	}

	public String getFinRoutingNo() {
		return finRoutingNo;
	}

	public void setFinRoutingNo(String finRoutingNo) {
		this.finRoutingNo = finRoutingNo;
	}

	public String getFinAcntNo() {
		return finAcntNo;
	}

	public void setFinAcntNo(String finAcntNo) {
		this.finAcntNo = finAcntNo;
	}

	public String getFinPhoneNo() {
		return finPhoneNo;
	}

	public void setFinPhoneNo(String finPhoneNo) {
		this.finPhoneNo = finPhoneNo;
	}

	public String getAuthTitle() {
		return authTitle;
	}

	public void setAuthTitle(String authTitle) {
		this.authTitle = authTitle;
	}

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

	public String getTinIdentifier() {
		return tinIdentifier;
	}

	public void setTinIdentifier(String tinIdentifier) {
		this.tinIdentifier = tinIdentifier;
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