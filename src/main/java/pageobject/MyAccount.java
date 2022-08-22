package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

	WebDriver driver;
	
	public MyAccount(WebDriver driver) {

	this.driver= driver;
	PageFactory.initElements(driver, this);
	
}

@FindBy(xpath="//div[@class='main-menu']//a[contains(text(),'Login')]")
private WebElement login	;



@FindBy(xpath="//button[@id='signinbtn']")

private WebElement submitButton;

public WebElement login() {
	
	return login;
	}


public WebElement submitButton() {
	
	return submitButton;
}

}
