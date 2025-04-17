package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base1 {
	WebDriver driver;
	
	public WebDriver getdriver() throws Exception
	{
		
	
	//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Utils//url.properties");
	
	
	//String getdriver=prop.getProperty("driver");

	{	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--window-size=1920,1080");
		System.out.println("chr1");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    String devurl=CommonClass.getproperties("url") ;
	    driver.get(devurl);
	    Thread.sleep(6000);
	    return driver;

	}
	
	
	}
	
}
