package main.java.api.pojo.epspaymentsearch.request;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				This type is for doing constrained searches. They are by
 * 				definition constrained with FromRecord and MaxResults. It also
 * 				provides sorting related data to be used by the back-end service
 * 				to give data in some particular sort order.
 * 				
 * 				Any type of Search/Inquiry operations must extend this type.
 * 			
 * 
 * <p>Java class for ConstrainedSearch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConstrainedSearch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{http://enterprise.optum.com/schema/cim/common/Service_v1_0}ConstrainedSearchAttributeGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConstrainedSearch")
@XmlSeeAlso({
    SearchCriteria.class
})
public class ConstrainedSearch {

    @XmlAttribute(name = "FromRecord", namespace = "http://enterprise.optum.com/schema/cim/common/Service_v1_0", required = true)
    protected int fromRecord;
    
    @XmlAttribute(name = "MaxResult", namespace = "http://enterprise.optum.com/schema/cim/common/Service_v1_0", required = true)
    protected int maxResult;
    
    @XmlAttribute(name = "SortDirection", namespace = "http://enterprise.optum.com/schema/cim/common/Service_v1_0", required = true)
    protected SortDirectionEnum sortDirection;
    
    @XmlAttribute(name = "SortFieldNumber", namespace = "http://enterprise.optum.com/schema/cim/common/Service_v1_0", required = true)
    protected int sortFieldNumber;

    /**
     * Gets the value of the fromRecord property.
     * 
     */
    public int getFromRecord() {
        return fromRecord;
    }

    /**
     * Sets the value of the fromRecord property.
     * 
     */
    public void setFromRecord(int value) {
        this.fromRecord = value;
    }

    /**
     * Gets the value of the maxResult property.
     * 
     */
    public int getMaxResult() {
        return maxResult;
    }

    /**
     * Sets the value of the maxResult property.
     * 
     */
    public void setMaxResult(int value) {
        this.maxResult = value;
    }

    /**
     * Gets the value of the sortDirection property.
     * 
     * @return
     *     possible object is
     *     {@link SortDirectionEnum }
     *     
     */
    public SortDirectionEnum getSortDirection() {
        return sortDirection;
    }

    /**
     * Sets the value of the sortDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortDirectionEnum }
     *     
     */
    public void setSortDirection(SortDirectionEnum value) {
        this.sortDirection = value;
    }

    /**
     * Gets the value of the sortFieldNumber property.
     * 
     */
    public int getSortFieldNumber() {
        return sortFieldNumber;
    }

    /**
     * Sets the value of the sortFieldNumber property.
     * 
     */
    public void setSortFieldNumber(int value) {
        this.sortFieldNumber = value;
    }

}
