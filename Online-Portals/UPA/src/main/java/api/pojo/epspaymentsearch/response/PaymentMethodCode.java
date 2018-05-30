package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlElement;

public class PaymentMethodCode
{
	@XmlElement(name = "Description", required = true)
	private String Description;

    @XmlElement(name = "Code", required = true)
    private String Code;

    public String getDescription ()
    {
        return Description;
    }

    public void setDescription (String Description)
    {
        this.Description = Description;
    }

    public String getCode ()
    {
        return Code;
    }

    public void setCode (String Code)
    {
        this.Code = Code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Description = "+Description+", Code = "+Code+"]";
    }
}
	
