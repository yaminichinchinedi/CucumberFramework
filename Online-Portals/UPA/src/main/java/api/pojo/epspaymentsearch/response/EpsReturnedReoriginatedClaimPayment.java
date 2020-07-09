package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlElement;

public class EpsReturnedReoriginatedClaimPayment
{
    private String ReturnedReoriginatedIdentifier;

    @XmlElement(name = "SettlementDate", required = true)
    private String SettlementDate;

    private String ReoriginatedStatusCodeText;

    private String TraceNumber;

    public String getReturnedReoriginatedIdentifier ()
    {
        return ReturnedReoriginatedIdentifier;
    }

    public void setReturnedReoriginatedIdentifier (String ReturnedReoriginatedIdentifier)
    {
        this.ReturnedReoriginatedIdentifier = ReturnedReoriginatedIdentifier;
    }

    public String getSettlementDate ()
    {
        return SettlementDate;
    }

    public void setSettlementDate (String SettlementDate)
    {
        this.SettlementDate = SettlementDate;
    }

    public String getReoriginatedStatusCodeText ()
    {
        return ReoriginatedStatusCodeText;
    }

    public void setReoriginatedStatusCodeText (String ReoriginatedStatusCodeText)
    {
        this.ReoriginatedStatusCodeText = ReoriginatedStatusCodeText;
    }

    public String getTraceNumber ()
    {
        return TraceNumber;
    }

    public void setTraceNumber (String TraceNumber)
    {
        this.TraceNumber = TraceNumber;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ReturnedReoriginatedIdentifier = "+ReturnedReoriginatedIdentifier+", SettlementDate = "+SettlementDate+", ReoriginatedStatusCodeText = "+ReoriginatedStatusCodeText+", TraceNumber = "+TraceNumber+"]";
    }
}