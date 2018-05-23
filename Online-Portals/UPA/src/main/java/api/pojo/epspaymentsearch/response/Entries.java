package main.java.api.pojo.epspaymentsearch.response;

public class Entries {
	
	    private String Value;

	    private String Key;

	    private String Comparator;

	    public String getValue ()
	    {
	        return Value;
	    }

	    public void setValue (String Value)
	    {
	        this.Value = Value;
	    }

	    public String getKey ()
	    {
	        return Key;
	    }

	    public void setKey (String Key)
	    {
	        this.Key = Key;
	    }

	    public String getComparator ()
	    {
	        return Comparator;
	    }

	    public void setComparator (String Comparator)
	    {
	        this.Comparator = Comparator;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [Value = "+Value+", Key = "+Key+", Comparator = "+Comparator+"]";
	    }
	}


