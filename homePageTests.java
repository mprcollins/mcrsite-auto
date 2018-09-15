package jUnit_tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.junit.Assert;

public class homePageTests extends ExtentBase{
	
	private static WebDriver webDriver;
	WebElement element;

	
    @BeforeClass
    public static void openBrowser() {
    	System.setProperty( "webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        // Open the Chrome browser
        webDriver = new ChromeDriver();
        
        extent = ExtentBase.GetExtent();
        test = extent.createTest("HOME PAGE INTEGRITY TESTS", "");
        
        
    }
    
    @Test
    public void onHomePage( ) {
   
    	//test = extent.createTest("Home page tests", "Verify method onHomePage");
    	
    	//test.pass("onHomePage" );
    	//test.fail(MarkupHelper.createLabel("YIKES", ExtentColor.YELLOW));
    	//test.log(Status.FAIL, "onHomePage");
    	
    	webDriver.navigate().to("http://www.manchester.gov.uk/");
    	
    	// Can we find cookie?
    	try {
    		element = webDriver.findElement(By.className("close"));
    	}
    	catch (Exception exc) {
    		
    		System.out.println("WE HAVE EXCEPTION: Close : " + exc.getMessage().toString());
    	}
    	
    	try { 
    		Assert.assertNotNull(element);
    		test.pass(MarkupHelper.createLabel("OnHomePage, COOKIE MONSTER", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("OnHomePage, COOKIE MONSTER", ExtentColor.GREEN));
    	}
    	//Switch off cookie
        element.click();
		
    }
    
    @Test
    public void findTicketsAndFinesLink() {
    	
    	//test = extent.createTest("Home page tests", "Verify findTicketsAndFinesLink");
    	//test.pass("findTicketsAndFinesLink" );
    	//test.log(Status.FAIL, "findTicketsAndFinesLink");
    	//Can we find the 'Tickets and fines'  link on the home page?
    	
		try {
    		element = webDriver.findElement(By.linkText("Tickets and fines"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Tickets and fines : " + exc.getMessage().toString());
    		test.fail(MarkupHelper.createLabel("WE HAVE EXCEPTION: Tickets and fines :", ExtentColor.RED));
    	}
    	
		try {
			Assert.assertNotNull(element);
			test.pass(MarkupHelper.createLabel("findTicketsAndFinesLink", ExtentColor.GREEN));
		}
		catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Tickets and fines : " + exc.getMessage().toString());
    		test.fail(MarkupHelper.createLabel("findTicketsAndFinesLink", ExtentColor.RED));
    	}
       
    }
    
    @Test
    public void findCouncillorsLink() {
    	//Can we find the 'Find your councillor'  link on the home page?
    	
		try {
    		element = webDriver.findElement(By.linkText("Find your councillor"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Find your councillor: " + exc.getMessage().toString());
    	}
    	
		try { 
			Assert.assertNotNull(element);
			test.pass(MarkupHelper.createLabel("findCouncillorsLink", ExtentColor.GREEN));
		}
		catch (Exception exc) {
			test.fail(MarkupHelper.createLabel("findCouncillorsLink", ExtentColor.RED));
		}
    	
       
    }
    
 
    @Test
    public void findSearchBox() {
    	//Can we find the Search box on the home page?
    	
		try {
    		element = webDriver.findElement(By.id("SearchSite"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: SearchBox" + exc.getMessage().toString());
    	}
    	
		try { 
			Assert.assertNotNull(element);
			test.pass(MarkupHelper.createLabel("findSearchBox", ExtentColor.GREEN));
		}
		catch (Exception exc) {
			test.fail(MarkupHelper.createLabel("findSearchBox", ExtentColor.RED));
		}
       
    }
    
    
    
    @AfterClass
    public static void closeBrowser() {
    	
    	//Flush to write to report
    	extent.flush();
		
    	  // Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
    }


}
