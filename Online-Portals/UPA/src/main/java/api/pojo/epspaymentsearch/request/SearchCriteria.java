package main.java.api.pojo.epspaymentsearch.request;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchCriteria", propOrder = {
    "parameterMap"})

public class SearchCriteria extends ConstrainedSearch
{
	 @XmlElement(name = "ParameterMap", required = true)
	    protected ParameterMap parameterMap;

	    /**
	     * Gets the value of the parameterMap property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link ParameterMap }
	     *     
	     */
	    public ParameterMap getParameterMap() {
	        return parameterMap;
	    }

	    /**
	     * Sets the value of the parameterMap property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link ParameterMap }
	     *     
	     */
	    public void setParameterMap(ParameterMap value) {
	        this.parameterMap = value;
	    }

    @Override
    public String toString()
    {
        return "ClassPojo [ParameterMap = "+parameterMap+"]";
    }
}
