package main.java.api.pojo.epsRemittanceDetail.response;

import main.java.reporting.Log;

public class EpsClaimsRequest {
    private String epsClaimsRequestWithIdentifier = "";
    private String epsClaimsRequestWithCOB = "";
    private String epsClaimsRequestWithReversal = "";

    public String getEpsClaimsRequestWithIdentifier(String finalIdentifier) {
        epsClaimsRequestWithIdentifier = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<ns21:EpsClaimsRequest xmlns=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns20=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/Edi835ContentService_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns10=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns21=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentDetailService_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns19=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns18=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0\">\n" +
                "\t<ns19:SearchCriteria ns19:FromRecord=\"-1\" ns19:MaxResult=\"10\" ns19:SortDirection=\"ASC\" ns19:SortFieldNumber=\"0\"/>\n" +
                "\t<ns3:PaymentIdentifier>" + finalIdentifier + "</ns3:PaymentIdentifier>\n" +
                "</ns21:EpsClaimsRequest>";
        Log.Comment("XML Request :"+epsClaimsRequestWithIdentifier);
        return epsClaimsRequestWithIdentifier;
    }

    public String getEpsClaimsRequestWithCOB(String finalIdentifier) {
        epsClaimsRequestWithCOB = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<ns21:EpsClaimsRequest xmlns=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns20=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/Edi835ContentService_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns10=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns21=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentDetailService_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns19=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns18=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0\">\n" +
                "\t<ns19:SearchCriteria ns19:FromRecord=\"-1\" ns19:MaxResult=\"10\" ns19:SortDirection=\"ASC\" ns19:SortFieldNumber=\"0\"/>\n" +
                "\t<ns3:PaymentIdentifier>"+finalIdentifier+"</ns3:PaymentIdentifier>\n" +
                "    <ns2:ClaimFilterTypeCode>2,3</ns2:ClaimFilterTypeCode>\n" +
                "</ns21:EpsClaimsRequest>";
        Log.Comment("XML Request :"+epsClaimsRequestWithCOB);
        return epsClaimsRequestWithCOB;
    }

    public String getEpsClaimsRequestWithReversal(String finalIdentifier) {
        epsClaimsRequestWithReversal = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<ns21:EpsClaimsRequest xmlns=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/EpsPaymentMaintenanceService_v1_0\" xmlns:ns2=\"http://enterprise.optum.com/schema/cim/common/Person_v1_0\" xmlns:ns4=\"http://enterprise.optum.com/schema/cim/common/Common_v1_0\" xmlns:ns3=\"http://enterprise.optum.com/schema/cim/common/Identifier_v1_0\" xmlns:ns6=\"http://enterprise.optum.com/schema/cim/common/Phone_v1_0\" xmlns:ns20=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/Edi835ContentService_v1_0\" xmlns:ns5=\"http://enterprise.optum.com/schema/cim/common/Code_v1_0\" xmlns:ns8=\"http://enterprise.optum.com/schema/cim/common/Address_v1_0\" xmlns:ns7=\"http://enterprise.optum.com/schema/cim/common/Contact_v1_0\" xmlns:ns13=\"http://enterprise.optum.com/schema/cim/common/Payer_v1_0\" xmlns:ns9=\"http://enterprise.optum.com/schema/cim/member/Member_v1_0\" xmlns:ns12=\"http://enterprise.optum.com/schema/cim/common/Payee_v1_0\" xmlns:ns11=\"http://enterprise.optum.com/schema/cim/common/Payment_v1_0\" xmlns:ns10=\"http://enterprise.optum.com/schema/cim/product/Group_v1_0\" xmlns:ns21=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/ClaimsService_v1_0\" xmlns:ns17=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentsService_v1_0\" xmlns:ns16=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentDetailService_v1_0\" xmlns:ns15=\"http://enterprise.optum.com/schema/cim/common/ServiceMessage_v1_0\" xmlns:ns14=\"http://enterprise.optum.com/schema/cim/provider/Provider_v1_0\" xmlns:ns19=\"http://enterprise.optum.com/schema/cim/common/Service_v1_0\" xmlns:ns18=\"http://enterprise.optum.com/schema/cim/api/finance/payables/provider/PaymentUpdateService_v1_0\">\n" +
                "\t<ns19:SearchCriteria ns19:FromRecord=\"-1\" ns19:MaxResult=\"10\" ns19:SortDirection=\"ASC\" ns19:SortFieldNumber=\"0\"/>\n" +
                "\t<ns3:PaymentIdentifier>" + finalIdentifier + "</ns3:PaymentIdentifier>\n" +
                "    <ns2:ClaimFilterTypeCode>22</ns2:ClaimFilterTypeCode>\n" +
                "</ns21:EpsClaimsRequest>";
        Log.Comment("XML Request :"+epsClaimsRequestWithReversal);
        return epsClaimsRequestWithReversal;
    }
}
