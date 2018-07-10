package main.java.api.pojo.epspaymentsearch.request;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterMap", propOrder = {
    "entries"
})
public class ParameterMap
{
	@XmlElement(name = "Entries",namespace="http://enterprise.optum.com/schema/cim/common/Service_v1_0", required = true)
    protected List<MapEntry> entries;
	
	
	public List<MapEntry> getEntries() {
        if (entries == null) {
            entries = new ArrayList<MapEntry>();
        }
        return this.entries;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [Entries = "+entries+"]";
    }
}
