package w3validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInButon {

	public WebDriver driver;

	public SignInButon(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//a[@aria-label='Login to your account']")
	private WebElement signinbutton;
	
	
	
	public void getloginpage() throws InterruptedException {
	System.out.println("login page need to click");
	signinbutton.click();
	Thread.sleep(5000);
	//String tesxt=driver.findElement(By.xpath("//a[@aria-label='Login to your account']")).getText();
	//System.out.println(tesxt);
	driver.getTitle();
	}

}
