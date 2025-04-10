package StepDefinitions;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utils.Base1;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import w3validation.Loginpage;
import w3validation.SignInButon;
import w3validation.UserHomePageValidation;

public class w3schoolsloginpage extends Base1 {
	WebDriver driver;
	String ss= UUID.randomUUID().toString();
    private static ThreadLocal<Scenario> scenarioThreadLocal = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        scenarioThreadLocal.set(scenario);
    }

    public static Scenario getScenario() {
        return scenarioThreadLocal.get();
    }

	@Given("User is in w3 home page")
	public void user_is_in_w3_home_page() throws Exception {
		
		Scenario scenario=w3schoolsloginpage.getScenario();
			
		//Base1 be=new Base1(driver);
		driver=getdriver();
		
			
	    System.out.println("W3 home page opened successfully");
	    byte[] screenshot = captureScreenshot();
        scenario.attach(screenshot, "image/png", "ss");
	}
	@When("User  Clicked sign in button")
	public void user_clicked_sign_in_button() throws Exception {
		Scenario scenario=w3schoolsloginpage.getScenario();
		SignInButon lp = new SignInButon(driver);
	     System.out.println("sign1 in Button clicked successfully");

	     lp.getloginpage();
	     System.out.println("sign in Button clicked successfully");
	     byte[] screenshot = captureScreenshot();
	     scenario.attach(screenshot, "image/png", "ss");
	}
	@Then("Login page is Displayed")
	public void login_page_is_displayed() {
		
		System.out.println("Login page displayed successfully");
	}
	@When("User Enter the credentials in login page")
	public void user_enter_the_credentials_in_login_page() throws Exception {
		Scenario scenario=w3schoolsloginpage.getScenario();
		Loginpage lp=new Loginpage(driver);
		lp.login();
		 byte[] screenshot = captureScreenshot();
	     scenario.attach(screenshot, "image/png", "ss");
	}
	@Then("user home page Displayed")
	public void user_home_page_displayed() {
		Scenario scenario=w3schoolsloginpage.getScenario();
		UserHomePageValidation uhpv=new UserHomePageValidation(driver);
		String Expected="Learn to Code";
		String Actual =uhpv.getTextValidate();
		Assert.assertEquals(Expected, Actual);
	    System.out.println("User Home page displayed successfully");
	    byte[] screenshot = captureScreenshot();
	     scenario.attach(screenshot, "image/png", "ss");
	}
	@Then("user home page is Displayed")
	public void user_home_page_is_displayed() {
		Scenario scenario=w3schoolsloginpage.getScenario();
		UserHomePageValidation uhpv=new UserHomePageValidation(driver);
		String Expected="Learn to Code";
		String Actual =uhpv.getTextValidate();
		Assert.assertEquals(Expected, Actual);
	    System.out.println("User Home page displayed successfully");
	    byte[] screenshot = captureScreenshot();
	     scenario.attach(screenshot, "image/png", "ss");
	}
	
	
	@Then("when user clicked on css css page is displayed")
	public void when_user_clicked_on_css_css_page_is_displayed() throws InterruptedException {
		Scenario scenario=w3schoolsloginpage.getScenario();
	    // Write code here that turns the phrase above into concrete actions
		String Expected="CSS HOME";
		UserHomePageValidation uhpv=new UserHomePageValidation(driver);
		String Actual=uhpv.getcssValidate();
		Assert.assertEquals(Expected, Actual);
		System.out.println("CSS page Validated successfully");
		byte[] screenshot = captureScreenshot();
	     scenario.attach(screenshot, "image/png", "ss");
	    
	}
	@Then("when user clicked on python python page is displayed")
	public void when_user_clicked_on_Python_python_page_is_displayed() throws InterruptedException {
		Scenario scenario=w3schoolsloginpage.getScenario();
	    // Write code here that turns the phrase above into concrete actions
		String Expected="Python HOME";
		UserHomePageValidation uhpv=new UserHomePageValidation(driver);
		String Actual=uhpv.getpythonValidate();
		Assert.assertEquals(Expected, Actual);
		System.out.println("Python page Validated successfully");
		byte[] screenshot = captureScreenshot();
	     scenario.attach(screenshot, "image/png", "ss");
	    
	}
	@Then("when user clicked on Java Java page is displayed")
	public void when_user_clicked_on_java_java_page_is_displayed() throws InterruptedException {
		Scenario scenario=w3schoolsloginpage.getScenario();
		String Expected="Java HOME";
		UserHomePageValidation uhpv=new UserHomePageValidation(driver);
		String Actual=uhpv.getJavaValidate();
		Assert.assertEquals(Expected, Actual);
		System.out.println("Java page Validated successfully");
		byte[] screenshot = captureScreenshot();
	     scenario.attach(screenshot, "image/png", "ss");
	}

	@After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
            	
                ((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '80%'");

                byte[] screenshot = captureScreenshot();
                scenario.attach(screenshot, "image/png", "ss");
               
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if (driver != null) {
            driver.quit();
        }
    }
    public  byte[] captureScreenshot() {
        try {
            
            TakesScreenshot ts = (TakesScreenshot) driver;
            return ts.getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
