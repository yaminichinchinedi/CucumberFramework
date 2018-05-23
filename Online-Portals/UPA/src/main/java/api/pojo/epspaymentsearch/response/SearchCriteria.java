package main.java.api.pojo.epspaymentsearch.response;

public class SearchCriteria
{
    private ParameterMap ParameterMap;

    public ParameterMap getParameterMap ()
    {
        return ParameterMap;
    }

    public void setParameterMap (ParameterMap ParameterMap)
    {
        this.ParameterMap = ParameterMap;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ParameterMap = "+ParameterMap+"]";
    }
}