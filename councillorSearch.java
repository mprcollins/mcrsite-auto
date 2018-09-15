package jUnit_tests;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class councillorSearch extends ExtentBase{
	
	private static WebDriver webDriver;
	WebElement element;
	
    @BeforeClass
    public static void openBrowser() {
    	System.setProperty( "webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        // Open the Chrome browser
        webDriver = new ChromeDriver();
        extent = ExtentBase.GetExtent();
        test = extent.createTest("COUNCILLOR SEARCH", "");
    }


    @Test
    public void byPostcode( ) {
    	
    	//Will start at main page and click on Find your councillor
    	webDriver.navigate().to("http://www.manchester.gov.uk/");
    	
    	try {
    		element = webDriver.findElement(By.linkText("Find your councillor"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Find your councillor by postcode: " + exc.getMessage().toString());
    	}
    	
    	try { 
    		Assert.assertNotNull(element);
    		test.pass(MarkupHelper.createLabel("LINK: Find your councillor", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("LINK: Find your councillor", ExtentColor.GREEN));
    	}

    	
    	//Scroll to Find your councillor link into view, otherwise unclickable
        
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        
        //Click on Find your councillor
        JavascriptExecutor executor = (JavascriptExecutor)webDriver; 
        executor.executeScript("arguments[0].click();", element);
        
        //Have we landed on page? 
        try { 
        	assertTrue(webDriver.findElement(By.id("mcc-cllr-postcode")).isDisplayed());
    		test.pass(MarkupHelper.createLabel("PAGE: Find your councillor by postcode", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("PAGE: Find your councillor by postcode", ExtentColor.GREEN));
    	}

        
        element = webDriver.findElement(By.id("mcc-cllr-postcode"));
        
        element.sendKeys("M14 7QA"); 
        //Click on postcode search button 
        //Visibility issue with tabindex 2, go with easier solution :-)
        //element = webDriver.findElement(By.cssSelector("[tabindex='2']"));
        
        element = webDriver.findElement(By.className("mcc-cllr-form-25"));
        element.click();
        
        //Have we landed on councillor page for given postcode?
        
        try { 
        	assertTrue(webDriver.getPageSource().contains("Find your councillor by postcode"));
            assertTrue(webDriver.getPageSource().contains("The local councillors are:"));
            
    		test.pass(MarkupHelper.createLabel("Postcode search", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("Postcode search", ExtentColor.GREEN));
    	}
        
    }
    
    @Test
    public void byWard( ) {
    	
    	//Will start at councillor search page 
    	webDriver.navigate().to("http://www.manchester.gov.uk/manchestercouncillors");
    	
    	try {
    		element = webDriver.findElement(By.linkText("Find your councillor"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Find your councillor by ward: " + exc.getMessage().toString());
    	}
    	
    	try { 
        	Assert.assertNotNull(element);
    		test.pass(MarkupHelper.createLabel("PAGE: Find your councillor by ward", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("PAGE: Find your councillor by ward", ExtentColor.GREEN));
    	}
    	
        
        //Have we landed on page? 
        assertTrue(webDriver.findElement(By.id("mcc-cllr-ward")).isDisplayed());
        
        
        element = webDriver.findElement(By.id("mcc-cllr-ward"));
        
        element.sendKeys("Burnage"); 
        
        //Click on ward search button 
        
        webDriver.findElement(By.cssSelector("[tabindex='4']")).click();
     
        
        //Have we landed on councillor page for given WARD?
        try { 
            assertTrue(webDriver.getPageSource().contains("Find your councillor by ward"));
            assertTrue(webDriver.getPageSource().contains("The local councillors are:"));
            
    		test.pass(MarkupHelper.createLabel("SEARCH: Find your councillor by ward", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("SEARCH: Find your councillor by ward", ExtentColor.GREEN));
    	}
       
    }
    

    @Test
    public void byPoliticalParty( ) {
    	
    	//Will start at councillor search page 
    	webDriver.navigate().to("http://www.manchester.gov.uk/manchestercouncillors");
    	
    	try {
    		element = webDriver.findElement(By.linkText("Find your councillor"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Find your councillor by political party: " + exc.getMessage().toString());
    	}
    	
    	try { 
        	Assert.assertNotNull(element);
    		test.pass(MarkupHelper.createLabel("PAGE: Find your councillor by political party", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("PAGE: Find your councillor by political party:", ExtentColor.GREEN));
    	}
        
        //Have we landed on page? 
        assertTrue(webDriver.findElement(By.id("mcc-cllr-party")).isDisplayed());
        
        
        element = webDriver.findElement(By.id("mcc-cllr-party"));
        
        //Scroll to make sure in  view, otherwise unclickable
        //This is needed when we don't enforce test call sequence
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        
        element.sendKeys("Labour"); 
        
        //Click on political party  search button 
        
        element = webDriver.findElement(By.cssSelector("[tabindex='6']"));
        
        element.click();
     
        
        //Have we landed on councillor page for given postcode?
        try { 
            assertTrue(webDriver.getPageSource().contains("Find your councillor by political party"));
            assertTrue(webDriver.getPageSource().contains("The councillors in this party are:"));
            
    		test.pass(MarkupHelper.createLabel("SEARCH: Find your councillor by political party", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("SEARCH: Find your councillor by political party", ExtentColor.GREEN));
    	}

        
    } 
    
    @Test
    public void byName( ) {
    	
    	//Will start at councillor search page 
    	webDriver.navigate().to("http://www.manchester.gov.uk/manchestercouncillors");
    	
    	try {
    		element = webDriver.findElement(By.linkText("Find your councillor"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Find your councillor by name: " + exc.getMessage().toString());
    	}
    	
    	try { 
        	Assert.assertNotNull(element);
    		test.pass(MarkupHelper.createLabel("PAGE: Find your councillor by name", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("PAGE: Find your councillor by name:", ExtentColor.GREEN));
    	}
    	
    	//Search for "Akbar, Rabnawaz" first in list.
    	
    	assertTrue(webDriver.findElement(By.id("mcc-cllr-id")).isDisplayed());
    	element = webDriver.findElement(By.id("mcc-cllr-id"));
        element.sendKeys("Akbar, Rabnawaz"); 

	
		//Scroll into view, otherwise unclickable
         
         ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
       
         
		//Click on ward search button
		webDriver.findElement(By.cssSelector("[tabindex='8']")).click();
    	
        
        //Have we landed on councillor page for given postcode?
		
		try { 
	        assertTrue(webDriver.getPageSource().contains("Find your councillor by name"));
	        assertTrue(webDriver.getPageSource().contains("Showing details for councillor"));
            
    		test.pass(MarkupHelper.createLabel("SEARCH: Find your councillor by name", ExtentColor.GREEN));
    		
    	}
    	catch (Exception exc){
    		test.fail(MarkupHelper.createLabel("SEARCH: Find your councillor by name", ExtentColor.GREEN));
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
