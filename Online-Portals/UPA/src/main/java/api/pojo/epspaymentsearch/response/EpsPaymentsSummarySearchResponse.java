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

	
  
  
  
  
  
  
  
  
  
  
//	(namespace:uri="http://enterprise.optum.com/schema/cim/api/finance/payables/provider/"
//			+ "\EpsPaymentMaintenanceService_v1_0" | EpsConsolidatedClaimPaymentSummaries?)*
//	
//	
//
//}
//"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0" xmlns:ns0=
//		"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0" 
//		xmlns:ns2="http://enterprise.optum.com/schema/cim/common/Identifier_v1_0" 
//		xmlns:ns3="http://enterprise.optum.com/schema/cim/common/Payment_v1_0" 
//		xmlns:ns4="http://enterprise.optum.com/schema/cim/common/Common_v1_0" 
//		xmlns:ns5="http://enterprise.optum.com/schema/cim/common/Code_v1_0" 
//		xmlns:ns8="http://enterprise.optum.com/schema/cim/common/Payer_v1_0">

