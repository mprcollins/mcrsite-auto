package jUnit_tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentBase {
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public static String filePath = "./automation_report.html";
	
	
	public static ExtentReports GetExtent(){
		
		if (extent != null) {
			//htmlReporter.setAppendExisting(true);
            return extent; //avoid creating new instance of html file               
		}
		
        extent = new ExtentReports();		
		extent.attachReporter(getHtmlReporter()); 
		return extent;
	}
	
 
	private static ExtentHtmlReporter getHtmlReporter() {
	
        htmlReporter = new ExtentHtmlReporter(filePath);
		
        // make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);
		
        htmlReporter.config().setDocumentTitle("Automation report");
        htmlReporter.config().setReportName("WEB & CRM Team Daily Checks");
        
        //To allow appending to report file as we run through tests
        htmlReporter.setAppendExisting(true); 
        return htmlReporter;
	}
	
	public static ExtentTest createTest(String name, String description){
		test = extent.createTest(name, description);
		return test;
	}


}


