package jUnit_tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


//NOTES:
//WE only need to switch the cookie monster off once :-)


public class homePageSearchTests extends ExtentBase{

	private static WebDriver webDriver;
	WebElement element;
	
    @BeforeClass
    public static void openBrowser() {
    	System.setProperty( "webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        // Open the Chrome browser
        webDriver = new ChromeDriver();
        extent = ExtentBase.GetExtent();
        test = extent.createTest("HOME PAGE SEARCH", "Verify search tests");
    }
    
    @Test
    public void searchForManchester() {
    	
    	webDriver.navigate().to("http://www.manchester.gov.uk/");
    	
    	//Switch off cookie 
    	element = webDriver.findElement(By.className("close"));
        element.click();
        
    	//Carry out search
        
    	element = webDriver.findElement(By.id("SearchSite"));
    	element.sendKeys("Manchester"); 
    	element.submit();  

    	//Check search has worked by finding 'Information element' 

		try {
			element = webDriver.findElement(By.id("Information"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Manchester search " + exc.getMessage().toString());
    	}
    	
		try { 
    		Assert.assertNotNull(element);
    		test.pass(MarkupHelper.createLabel("Serch term: Manchester", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("Serch term: Manchester", ExtentColor.GREEN));
    	}
  	
    	System.out.println("Information id tag found on Manchester search page.");
    	
    }
    
 
    @Test
    public void searchForBin() {
    	
    	webDriver.navigate().to("http://www.manchester.gov.uk/");
    	
    	//Switch off cookie 
    	//element = webDriver.findElement(By.className("close"));
        //element.click();
        
    	//Carry out search
        
    	element = webDriver.findElement(By.id("SearchSite"));
    	element.sendKeys("Bin"); 
    	element.submit();  

    	//Check search has worked by finding 'Information element' 

		try {
			element = webDriver.findElement(By.id("Information"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Bin search " + exc.getMessage().toString());
    	}
    	
		try { 
    		Assert.assertNotNull(element);
    		test.pass(MarkupHelper.createLabel("Serch term: Bin", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("Serch term: Bin", ExtentColor.GREEN));
    	} 	
    	System.out.println("Information id tag found on Bin search page.");
    	
    }
    
    
    @AfterClass
    public static void closeBrowser() {
    	// Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
    }
 
}



