package main.java.reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//Report path and settings

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getInstance() {
        if (extent == null)
        {
        	if(System.getProperty("OS")!=null)
                createInstance(System.getProperty("user.dir")+"//ExtentReports//ExtentReportResults.html");
        	else       
        		createInstance(System.getProperty("user.dir")+"\\ExtentReports\\ExtentReportResults.html");
        }

        return extent;
    }

    public synchronized static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        if(System.getProperty("OS")!=null)
        	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"//ExtentReports//extent-config.xml");
        else
        	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\ExtentReports\\extent-config.xml");
        htmlReporter.config().setReportName("Automation Report");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}