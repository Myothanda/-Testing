import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Loginpage {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver(); 
		driver.get("https://opensource-demo.orangehrmlive.com");
	}
	
	@Test
	public void logIn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
 	    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
 	    driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
	
	@Test
	public void verifyText() {
		     String expectedTitle ="OrangeHRM";
	         String actualTitle = driver.getTitle();
	        
	        // Assert that the actual title matches the expected title
	        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
	}
	
	   @AfterClass
	    public void tearDown() {
	        driver.quit(); // Close the browser
	    }
	
}
