package main.java.api.pojo.epspaymentsearch.jsonrequest;

public class ParameterMap {

	private String key;
	private String value;
	private String comparator;

	public ParameterMap() {}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComparator() {
		return this.comparator;
	}

	public void setComparator(String comparator) {
		this.comparator = comparator;
	}

	@Override
    public String toString() {
        return "{" +
        		"\"key\": \""  + this.key + "\"," +
        		"\"value\": \"" + this.value + "\"," +
        		"\"comparator\": \"" + this.comparator + "\"" +
        		"}";
    }

}