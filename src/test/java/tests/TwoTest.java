package tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base_Class;

public class TwoTest extends Base_Class{
	
	public WebDriver driver;
	
	@Test
	public void testTwo() throws IOException, InterruptedException {
		
		driver = intializeDriver();
		driver.get(pro.getProperty("url"));
		Thread.sleep(3000);
	
		Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void close() {
		
		driver.quit();
	}

}
