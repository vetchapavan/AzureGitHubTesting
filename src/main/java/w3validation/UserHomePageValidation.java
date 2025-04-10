package w3validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePageValidation {

	private WebDriver driver;

	public UserHomePageValidation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
				
	}
	@FindBy(xpath="//a[@title='CSS Tutorial' and @class='ga-nav' ]")
	private WebElement css;
	
	@FindBy(xpath="//a[@title='Python Tutorial' and @class='ga-nav' ]")
	private WebElement python;
	
	@FindBy(xpath="//a[@title='Java Tutorial' and @class='ga-nav' ]")
	private WebElement java;
	
	
	//h1[@class='learntocodeh1']
	public String getTextValidate()
	{
		String Actual=driver.findElement(By.xpath("//h1[@class='learntocodeh1']")).getText();
		return Actual;
	}
	
	public String getcssValidate() throws InterruptedException
	{
		Thread.sleep(3000);
		css.click();
		Thread.sleep(3000);
		String Actual=driver.findElement(By.xpath("//a[@class='active done']")).getText();
		return Actual;
	}
	
	public String getpythonValidate() throws InterruptedException
	{
		Thread.sleep(3000);
		python.click();
		Thread.sleep(3000);
		String Actual=driver.findElement(By.xpath("//a[@class='active done']")).getText();
		return Actual;
		
	}
	
	public String getJavaValidate() throws InterruptedException
	{
		Thread.sleep(3000);
		java.click();
		Thread.sleep(3000);
		String Actual=driver.findElement(By.xpath("//a[@class='active done']")).getText();
		return Actual;
	}
	

}
