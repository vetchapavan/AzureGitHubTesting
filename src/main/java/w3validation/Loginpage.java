package w3validation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	public WebDriver driver;
	public Loginpage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	@FindBy(xpath="//input[@name='email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	public void login() throws InterruptedException
	{
	
	username.sendKeys("eluri.avinash@capgemini.com");
    Thread.sleep(2000);
    password.sendKeys("Avinash@123");
    Thread.sleep(3000);
   // JavascriptExecutor js = (JavascriptExecutor) driver;
    //js.executeScript("window.scrollBy(0,250)");
	WebElement elem = driver.findElement(By.xpath("//button[@type='submit']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elem);
    Thread.sleep(2000);
    submit.click();
    Thread.sleep(6000);
	}

}
