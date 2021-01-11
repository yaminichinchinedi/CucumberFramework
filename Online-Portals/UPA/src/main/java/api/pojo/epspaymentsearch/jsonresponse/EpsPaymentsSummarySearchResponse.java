package main.java.api.pojo.epspaymentsearch.jsonresponse;

import main.java.api.pojo.epspaymentsearch.jsonresponse.EpsConsolidatedClaimPaymentSummaries;

public class EpsPaymentsSummarySearchResponse {
    public EpsPaymentsSummarySearchResponse() {}

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private Data data;
    
}
