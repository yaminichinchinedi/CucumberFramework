package main.java.api.pojo.epspaymentsearch.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="EpsPaymentsSummarySearchResponse",namespace="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0")
@XmlAccessorType (XmlAccessType.FIELD)

public class EpsPaymentsSummarySearchResponse  

{
	
    ResponseReturnStatus ResponseReturnStatus;
    ResponseReturnCode ResponseReturnCode;
    private EpsConsolidatedClaimPaymentSummaries[] EpsConsolidatedClaimPaymentSummaries;    
 
    public ResponseReturnStatus getResponseReturnStatus ()
	 {
	        return ResponseReturnStatus;
	 }
	
    
    public ResponseReturnCode getResponseReturnCode ()
	 {
	        return ResponseReturnCode;
	 }
  
    public EpsConsolidatedClaimPaymentSummaries[] getEpsConsolidatedClaimPaymentSummaries ()
    {
        return EpsConsolidatedClaimPaymentSummaries;
    }
  
}
