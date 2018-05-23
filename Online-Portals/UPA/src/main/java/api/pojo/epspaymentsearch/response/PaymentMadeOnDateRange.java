package main.java.api.pojo.epspaymentsearch.response;

public class PaymentMadeOnDateRange
{
    private String ToDate;

    private String FromDate;

    public String getToDate ()
    {
        return ToDate;
    }

    public void setToDate (String ToDate)
    {
        this.ToDate = ToDate;
    }

    public String getFromDate ()
    {
        return FromDate;
    }

    public void setFromDate (String FromDate)
    {
        this.FromDate = FromDate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ToDate = "+ToDate+", FromDate = "+FromDate+"]";
    }
}