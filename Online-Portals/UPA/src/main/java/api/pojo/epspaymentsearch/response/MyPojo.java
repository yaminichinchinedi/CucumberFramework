package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name="EpsPaymentsSummarySearchResponse")

public class MyPojo
{
	
	private EpsPaymentsSummarySearchResponse EpsPaymentSummarySearchResponse;
	
    private EpsConsolidatedClaimPaymentSummaries[] EpsConsolidatedClaimPaymentSummaries;

    private ResponseReturnStatus ResponseReturnStatus;
    
    public EpsPaymentsSummarySearchResponse getEpsPaymentSummarySearchResponse ()
    {
        return EpsPaymentSummarySearchResponse;
    }

   
   
    public EpsConsolidatedClaimPaymentSummaries[] getEpsConsolidatedClaimPaymentSummaries ()
    {
        return EpsConsolidatedClaimPaymentSummaries;
    }

    public void setEpsConsolidatedClaimPaymentSummaries (EpsConsolidatedClaimPaymentSummaries[] EpsConsolidatedClaimPaymentSummaries)
    { 
        this.EpsConsolidatedClaimPaymentSummaries = EpsConsolidatedClaimPaymentSummaries;
    }

    public ResponseReturnStatus getResponseReturnStatus ()
    {
        return ResponseReturnStatus;
    }

    public void setResponseReturnStatus (ResponseReturnStatus ResponseReturnStatus)
    {
        this.ResponseReturnStatus = ResponseReturnStatus;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EpsConsolidatedClaimPaymentSummaries = "+EpsConsolidatedClaimPaymentSummaries+", ResponseReturnStatus = "+ResponseReturnStatus+"]";
    }
}