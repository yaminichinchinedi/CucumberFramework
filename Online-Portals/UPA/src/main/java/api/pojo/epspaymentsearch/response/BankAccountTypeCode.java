package main.java.api.pojo.epspaymentsearch.response;

public class BankAccountTypeCode
{
    private String Name;

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Name = "+Name+"]";
    }
}