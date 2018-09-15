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
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.junit.Assert;

public class homePageTestsBASE extends ExtentBase{
	private static WebDriver webDriver;
	WebElement element;
	
	WebDriver driver;
	
    @BeforeClass
    public static void openBrowser() {
    	System.setProperty( "webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        // Open the Chrome browser
        webDriver = new ChromeDriver();
        
        extent = ExtentBase.GetExtent();
        
    }
    
    @Test
    public void onHomePage( ) {
   
    	test = extent.createTest("MAIN PAGE TESTS X", "Verify HomePage");
    	
    	test.pass("onHomePageBASE" );
    	test.log(Status.FAIL, "Yahoo");
    	
    	webDriver.navigate().to("http://www.manchester.gov.uk/");
    	
    	// Can we find cookie?
    	try {
    		element = webDriver.findElement(By.className("close"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Close : " + exc.getMessage().toString());
    	}
    	
    	Assert.assertNotNull(element);
    	//Switch off cookie
        element.click();
		
    }
    
    @Test
    public void findTicketsAndFinesLink() {
    	//Can we find the 'Tickets and fines'  link on the home page?
    	
		try {
    		element = webDriver.findElement(By.linkText("Tickets and fines"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Tickets and fines : " + exc.getMessage().toString());
    	}
    	
    	Assert.assertNotNull(element);
       
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
    	
    	Assert.assertNotNull(element);
       
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
    	
    	Assert.assertNotNull(element);
       
    }
    
    
    
    @AfterClass
    public static void closeBrowser() {
    	
    	extent.flush();
		
    	  // Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
    }


}
