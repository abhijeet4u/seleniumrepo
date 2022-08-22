package Resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	     public  WebDriver driver;
	public Properties pro;
	
	
	public WebDriver intializeDriver() throws IOException {
	
		pro = new Properties();
		String proPath = System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties";
		FileInputStream fis = new FileInputStream(proPath);
		pro.load(fis);
	
		
		String browserName = pro.getProperty("browser");
		
	if(browserName.equalsIgnoreCase("chrome")) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		
		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	
	}
	else if(browserName.equalsIgnoreCase("edge")) {
		
		WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver();
	
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	
	return driver;
	
}
	public String takeScreenshot(String testName, WebDriver driver) throws InterruptedException, IOException {
		

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\ScreenShots\\"+testName+".png";
		Thread.sleep(2000);
		FileUtils.copyFile(file,new File(dest));
		Thread.sleep(2000);
		
		return dest;
	}
}
