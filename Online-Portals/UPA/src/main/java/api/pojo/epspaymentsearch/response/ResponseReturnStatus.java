package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlElement;

public class ResponseReturnStatus
{
    private String requestIdentifier;

    @XmlElement(name = "TotalCount", required = true)
    private String TotalCount;

    private ResponseReturnCode responseReturnCode;

    private String responseDetail;
    
    public String getRequestIdentifier ()
    {
        return requestIdentifier;
    }

    public void setRequestIdentifier (String requestIdentifier)
    {
        this.requestIdentifier = requestIdentifier;
    }

    public String getTotalCount()
    {
        return TotalCount;
    }

    public void setTotalCount (String TotalCount)
    {
        this.TotalCount = TotalCount;
    }

    public ResponseReturnCode getResponseReturnCode ()
    {
        return responseReturnCode;
    }

    public void setResponseReturnCode (ResponseReturnCode responseReturnCode)
    {
        this.responseReturnCode = responseReturnCode;
    }

    public String getResponseDetail ()
    {
        return responseDetail;
    }

    public void setResponseDetail (String responseDetail)
    {
        this.responseDetail = responseDetail;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [requestIdentifier = "+requestIdentifier+", TotalCount = "+TotalCount+", responseReturnCode = "+responseReturnCode+", responseDetail = "+responseDetail+"]";
    }
}