package tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base_Class;
import pageobject.LoginPage;
import pageobject.MyAccount;

public class LoginTest2  extends Base_Class {

public WebDriver driver;
	
	@Test(dataProvider= "getLoginData")
	
	public void login(String mobileNo,String password) throws IOException, InterruptedException {
		
		driver = intializeDriver();
		driver.get(pro.getProperty("url"));
		
		MyAccount ac = new MyAccount(driver);
	    ac.login().click();
		
		
		LoginPage login = new LoginPage(driver);
		login.email().sendKeys(mobileNo);
		login.password().sendKeys(password);
		ac.submitButton().click();
		
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
	
		
		
		
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void close() {
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data = {{"8888996163","abhi@143"},{"888899726","abhi"}};
		
		return data;
				
	}
}
