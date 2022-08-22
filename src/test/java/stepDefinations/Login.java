package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

import Resources.Base_Class;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.LoginPage;
import pageobject.MyAccount;

public class Login extends Base_Class{
	
	  MyAccount ac;
	  LoginPage login;
	  
	  @Before
	  public void openBroswer() throws IOException {
		  driver = intializeDriver();
		  
	  }

	  @Given("^Open any browser$")
	    public void open_any_browser() {
		  
		  driver.get(pro.getProperty("url"));
	    }
	  
	  @And("^Navigate to login page$")
	    public void navigate_to_login_page() {
		  
		    ac = new MyAccount(driver);
		    ac.login().click();
	    }

	    @When("^user enters Mobile Number as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	    public void user_enters_mobile_number_as_something_and_password_as_something_into_the_fields(String MobileNumber, String password) {
	    	login = new LoginPage(driver);
	 		
	 		login.email().sendKeys(MobileNumber);
	 		login.password().sendKeys(password);
	    }
	    
	    @And("^User click on submit button$")
	    public void user_click_on_submit_button()  {
	    	ac.submitButton().click();
	    }
	    
	    @And("^User click on  Alert$")
	    public void User_click_on_Alert() {
	    	
	    	Alert alt = driver.switchTo().alert();
	    	alt.accept();
	    }

	    @Then("^Verify user is able to successfully login$")
	    public void verify_user_is_able_to_successfully_login() {
	     
	    	Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'abhijeet ghodke')]")).isDisplayed());
	    }

	    @After
	    public void close() {
	    	
	    	driver.quit();
	    }
	  

	  
}
