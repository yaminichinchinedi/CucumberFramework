package main.java.api.pojo.epspaymentsearch.jsonrequest;

import java.util.ArrayList;
import java.util.StringJoiner;

public class SearchCriteria {

	private int fromRecord = 0;
	private int maxResult = 30;
	private String sortDirection = "DESC";
	private int sortFieldNumber = 12;
	private ArrayList<ParameterMap> parameterMap;

	public SearchCriteria() {
		this.parameterMap = new ArrayList<>();
	}

	public int getFromRecord() {
		return this.fromRecord;
	}

	public void setFromRecord(int fromRecord) {
		this.fromRecord = fromRecord;
	}

	public int getMaxResult() {
		return this.maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public String getSortDirection() {
		return this.sortDirection;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

	public int getSortFieldNumber() {
		return this.sortFieldNumber;
	}

	public void setSortFieldNumber(int sortFieldNumber) {
		this.sortFieldNumber = sortFieldNumber;
	}

	public ArrayList<ParameterMap> getParameterMap() {
		return this.parameterMap;
	}

	public void setParameterMap(ArrayList<ParameterMap> parameterMap) {
		this.parameterMap = parameterMap;
	}

	@Override
    public String toString() {
    	StringJoiner sj = new StringJoiner(",");

    	for (ParameterMap parameterMap : this.parameterMap) {
    		sj.add(parameterMap.toString());
    	}

        return "\"searchCriteria\": {" +
        		"\"fromRecord\":"  + this.fromRecord + "," +
        		"\"maxResult\": " + this.maxResult + "," +
        		"\"sortDirection\": \"" + this.sortDirection + "\"," +
        		"\"sortFieldNumber\": " + this.sortFieldNumber + "," +
        		"\"parameterMaps\": [" + sj.toString() + "]" +
        		"}";
    }
	
}