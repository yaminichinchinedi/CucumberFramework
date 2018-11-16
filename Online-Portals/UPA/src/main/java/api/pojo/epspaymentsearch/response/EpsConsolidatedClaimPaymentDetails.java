package main.java.api.pojo.epspaymentsearch.response;

public class EpsConsolidatedClaimPaymentDetails
{
    private String CheckNumber;

    private String ConsolidatedPaymentDetailIdentifier;

    public String getCheckNumber ()
    {
        return CheckNumber;
    }

    public void setCheckNumber (String CheckNumber)
    {
        this.CheckNumber = CheckNumber;
    }

    public String getConsolidatedPaymentDetailIdentifier ()
    {
        return ConsolidatedPaymentDetailIdentifier;
    }

    public void setConsolidatedPaymentDetailIdentifier (String ConsolidatedPaymentDetailIdentifier)
    {
        this.ConsolidatedPaymentDetailIdentifier = ConsolidatedPaymentDetailIdentifier;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CheckNumber = "+CheckNumber+", ConsolidatedPaymentDetailIdentifier = "+ConsolidatedPaymentDetailIdentifier+"]";
    }
}