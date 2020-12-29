package main.java.api.pojo.epspaymentsearch.jsonresponse;


public class Data {
    public Data() {}

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    private Long totalCount;

    public EpsConsolidatedClaimPaymentSummaries[] getEpsConsolidatedClaimPaymentSummaries() {
        return epsConsolidatedClaimPaymentSummaries;
    }

    public void setEpsConsolidatedClaimPaymentSummaries(EpsConsolidatedClaimPaymentSummaries[] epsConsolidatedClaimPaymentSummaries) {
        this.epsConsolidatedClaimPaymentSummaries = epsConsolidatedClaimPaymentSummaries;
    }

    private EpsConsolidatedClaimPaymentSummaries[] epsConsolidatedClaimPaymentSummaries;
}
