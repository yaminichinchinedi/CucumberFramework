package test.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface TestDetails {
	
	    /**
	     * Returns the name of the test as specified in TestLink.
	     * 
	     * @return The name of the test as specified in TestLink.
	     */
	    public String testName() default "unspecified";
	    public String author() default "unspecified";

	    /**
	     * Returns the name of the product as specified in TestLink.
	     * 
	     * @return The name of the product as specified in TestLink.
	     */
	    public String productName() default "unspecified";

	    /**
	     * This attribute, specified, will store the summary to be stored in TestLink.
	     * 
	     * @return - the summary
	     */
	    public String summary() default "unspecified";

	    /**
	     * This attribute, specified, will store the steps to be stored in TestLink.
	     * 
	     * @return - the steps
	     */
	    public String steps() default "unspecified";

	    /**
	     * This attribute, specified, will store the expected results to be stored in TestLink.
	     * 
	     * @return - the expected results
	     */
	    public String expectedResults() default "unspecified";

	    /**
	     * This attribute, when specified, will denote the related "UseCase" for this test.
	     * 
	     * @return
	     */
	    public String usecase() default "unspecified";

	    /**
	     * This attribute, when specified, will denote the related SPEC for this test.
	     * 
	     * @return
	     */
	    public String spec() default "unspecified";

	    /**
	     * This attribute, when specified, will denote the related SPEC for this test.
	     * 
	     * @return
	     */
	    public String url() default "";

	    /**
	     * This attribute, when specified, will denote the subversion url for this test class.
	     * 
	     * @return
	     */
	    public String rev() default "";
	    /**
	     * This attribute, when specified, will denote the subversion rev for this test class.
	     * 
	     * @return
	     */

	}

