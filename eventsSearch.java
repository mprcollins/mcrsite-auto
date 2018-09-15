package jUnit_tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class eventsSearch extends ExtentBase{

	private static WebDriver webDriver;
	WebElement element;

	
    @BeforeClass
    public static void openBrowser() {
    	System.setProperty( "webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        // Open the Chrome browser
        webDriver = new ChromeDriver();
        extent = ExtentBase.GetExtent();
        test = extent.createTest("EVENT SEARCH", "Verify Event Search");
    }
    
    @Test
    public void evenstSearch( ) {
    	
    	
    	//test.pass("evenstSearch" );
    	//test.log(Status.PASS, "Yahoo MORE mike");
    	
    	//Can we find More Events link on home page and click on it?
    	
    	webDriver.navigate().to("http://www.manchester.gov.uk/");
    	
    	// Can we find cookie?
    	try {
    		element = webDriver.findElement(By.className("close"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Close : " + exc.getMessage().toString());
    	}

    	//First visit switch off cookie
        element.click();
        
        //Find More Events link
        
        try {
        	element = webDriver.findElement(By.linkText("More events"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Close : " + exc.getMessage().toString());
    	}
        
        //Fail if not found
        try {
        	Assert.assertNotNull(element);
        	test.pass(MarkupHelper.createLabel("Find More Events link", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("Find More Events link", ExtentColor.RED));
        }
        
        //This does not work
        //Actions actions = new Actions(webDriver);
        //actions.moveToElement(element).click();
        
        //Scroll More Events link into view, otherwise unclickable
       
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        
        //Click on Find your More events
        JavascriptExecutor executor = (JavascriptExecutor)webDriver; 
        executor.executeScript("arguments[0].click();", element);
        
        //Check we have landed on more events search page
        
        element = webDriver.findElement(By.className("homepage-title"));
        //Fail if not found
        try {
        	Assert.assertNotNull(element);
        	test.pass(MarkupHelper.createLabel("Find page title HTML", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("Find page title HTML", ExtentColor.RED));
        }
       
        
        String title = webDriver.findElement(By.className("homepage-title")).getText();
        
        System.out.println("TITLE = " + title);
        
        String expected = "Events & tourism";
        
        try {
        	assertEquals(title,expected);
        	test.pass(MarkupHelper.createLabel("Expected Title ", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("Expected Title ", ExtentColor.RED));
        }
       
    }
    
    @Test
    public void eventButtonsExist() {
    	
    	//Can we find Button 'Find a Gallery or Museum'?
    	//Note since we have run first test we are already on Events page
    	//but will navigate there during this test.
    	
    	webDriver.navigate().to("http://www.manchester.gov.uk/mcrevents");
    	
    	// Can we find the, Find a gallery or museum, Button?
    	
    	try {
    		element = webDriver.findElement(By.linkText("Find a gallery or museum"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Gallery Museum : " + exc.getMessage().toString());
    	}

    	String buttonText = webDriver.findElement(By.linkText("Find a gallery or museum")).getText();
        
        //System.out.println("BUTTON text = " + buttonText);
        String expected = "Find a gallery or museum";
        String actual = buttonText;
        
        try {
        	assertEquals(actual,expected);
        	test.pass(MarkupHelper.createLabel("BUTTON TEXT: Find a gallery or museum", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("BUTTON TEXT: Find a gallery or museum", ExtentColor.RED));
        }
        
        
        if(expected.equals(actual)){
            System.out.println("Found BUTTON: Find a gallery or museum");
        }
            else {
                System.out.println("Expected BUTTON: Find a gallery or museum not found.");
        }
        
      //Can we find Button 'Visit ancient monuments'?
        
        buttonText = webDriver.findElement(By.linkText("Visit ancient monuments")).getText();
        
        System.out.println("BUTTON text = " + buttonText);
        expected = "Visit ancient monuments";
        actual = buttonText;
        
        try {
        	assertEquals(actual,expected);
        	test.pass(MarkupHelper.createLabel("BUTTON TEXT: Visit ancient monuments", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("BUTTON TEXT: Visit ancient monuments", ExtentColor.RED));
        }
 
    }
    
 
    @Test
    public void checkAncientMonumentsButton() {
    	
    	webDriver.navigate().to("http://www.manchester.gov.uk/mcrevents");
    	
    	try {
    		element = webDriver.findElement(By.linkText("Visit ancient monuments"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Ancient Monuments : " + exc.getMessage().toString());
    	}
    	
    	
    	try {
    		Assert.assertNotNull(element);
        	test.pass(MarkupHelper.createLabel("Visit ancient monuments", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("Visit ancient monuments", ExtentColor.RED));
        }
    	
    	//Let's click it.
    	
    	webDriver.findElement(By.linkText("Visit ancient monuments")).click();
        
        //And check we have landed on ancient monuments page
        
        //Check title of page
        
        try {
        	assertTrue(webDriver.getTitle().contains("About ancient monuments"));
        	test.pass(MarkupHelper.createLabel("Title: About ancient monuments", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("Title: About ancient monuments", ExtentColor.RED));
        }
       //Check some text

        try {
        	assertTrue(webDriver.getPageSource().contains("six Scheduled Ancient Monuments"));
        	test.pass(MarkupHelper.createLabel("Page contains: six Scheduled Ancient Monuments", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("Page contains: six Scheduled Ancient Monuments", ExtentColor.RED));
        }
    	
    }
    
    @Test
    public void checkManchesterTownHallButton() {
    	
    	webDriver.navigate().to("http://www.manchester.gov.uk/mcrevents");
    	
    	//Click Manchester Town Hall
        
        try {
    		element = webDriver.findElement(By.linkText("Manchester Town Hall"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Manchester Town Hall : " + exc.getMessage().toString());
    	}
    	
        try {
        	Assert.assertNotNull(element);
        	test.pass(MarkupHelper.createLabel("BUTTON TEXT: Manchester Town Hall", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("BUTTON TEXT: Manchester Town Hall", ExtentColor.RED));
        }
   
    	
    	//Let's click it.
    	
    	element.click();
        
        //And check we have landed on ancient monuments page
        
        //Check title of page
    	 try {
    		 assertTrue(webDriver.getTitle().contains("Town Hall"));
         	 test.pass(MarkupHelper.createLabel("Page title: Town Hall", ExtentColor.GREEN));
         }
         catch (Exception exc) {
         	test.fail(MarkupHelper.createLabel("Page title: Town Hall", ExtentColor.RED));
         }
    	
    }
    
    @Test
    public void checkTownHallTransformationButton() {
    	
    	webDriver.navigate().to("http://www.manchester.gov.uk/townhall");
    	
    	//Click Manchester Town Hall
        
        try {
    		element = webDriver.findElement(By.linkText("Town Hall transformation"));
    	}
    	catch (Exception exc) {
    		System.out.println("WE HAVE EXCEPTION: Town Hall transformation : " + exc.getMessage().toString());
    	}
    	
        try {
        	Assert.assertNotNull(element);
        	 test.pass(MarkupHelper.createLabel("BUTTON EXISTS: Town Hall transformation", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("BUTTON EXISTS: Town Hall transformation", ExtentColor.RED));
        }
    	
    	//Let's click it.
    	
    	element.click();
        
        //And check we have landed on ancient monuments page
        
        //Check title of page
    	try {
    		assertTrue(webDriver.getPageSource().contains("our Town Hall"));
        	test.pass(MarkupHelper.createLabel("Page contains text: our Town Hall", ExtentColor.GREEN));
        }
        catch (Exception exc) {
        	test.fail(MarkupHelper.createLabel("Page contains text: our Town Hall", ExtentColor.RED));
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
