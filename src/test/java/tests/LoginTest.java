package tests;





import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base_Class;
import pageobject.LoginPage;
import pageobject.MyAccount;

public class LoginTest extends Base_Class {

	
	public  WebDriver driver;
	Logger log;
	
	@Test
	
	public void login() throws InterruptedException {
		
       
	
		MyAccount ac = new MyAccount(driver);
	    ac.login().click();
	    log.debug("click on Login button ");
		
		
	    LoginPage login = new LoginPage(driver);
		
		login.email().sendKeys(pro.getProperty("mobileNo"));
		log.debug("Mobile Number got entered");
		login.password().sendKeys(pro.getProperty("password"));
		log.debug("password got entered");
		
		ac.submitButton().click();
		log.debug("Click on Submit button");
		
		
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		log.debug("Click on the Alert");
	
		log.debug("User got logged in");
		
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'abhijeet ghodke')]")).isDisplayed());
		
		
	}
	@BeforeMethod
	public void openAppliction() throws IOException {
		
		log= LogManager.getLogger(LoginTest.class.getName());
		driver = intializeDriver();
		log.debug("Browser got launched");
		driver.get(pro.getProperty("url"));
		log.debug("navigate the Appliction URL");
	}
	
	@AfterMethod
	public void close() {
		
		driver.quit();
		log.debug("Browser got closed");
	}
	
	
}
