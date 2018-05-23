package main.java.api.pojo.epspaymentsearch.response;

public class ResponseReturnCode
{
    private String desc;

    private String code;

    public String getDesc ()
    {
        return desc;
    }

    public void setDesc (String desc)
    {
        this.desc = desc;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [desc = "+desc+", code = "+code+"]";
    }
}
