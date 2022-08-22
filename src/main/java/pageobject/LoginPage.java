package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='mobileNo']")
	private WebElement mobileNo;
	
	public WebElement email() {
		
		
		return mobileNo;
	}
	
	@FindBy(xpath="//input[@name='Password']")
	private WebElement password;
	
	public WebElement password() {
		
		return password;
	}
	
}
