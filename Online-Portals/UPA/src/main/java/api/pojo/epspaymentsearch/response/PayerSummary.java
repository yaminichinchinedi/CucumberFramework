package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlElement;

public class PayerSummary
{
	@XmlElement(name = "Name", required = true)
	private String Name;

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Name = "+Name+"]";
    }
}

