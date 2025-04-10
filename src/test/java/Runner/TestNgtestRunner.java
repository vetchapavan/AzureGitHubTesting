package Runner;

import java.io.IOException;
import java.io.InputStream;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

import java.nio.file.Paths;
import java.util.Properties;

import org.testng.ITest;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import junit.textui.TestRunner;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.textui.TestRunner;
		
		@CucumberOptions(features="src/test/java/feature/webtesting.feature",glue="StepDefinitions",monochrome=true,plugin= {"html:target/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

		

		public class TestNgtestRunner extends AbstractTestNGCucumberTests implements ITest  {
			
		    private static ExtentReports extent;
			static {
				try(InputStream input = TestRunner.class.getClassLoader().getResourceAsStream("extent.properties")){
					
					if(input==null) {
						
						System.err.println("Error: extent.properties is not found !");
						
					}else {
						Properties prop = new Properties();
						prop.load(input);
						System.out.println("DEBUG: extent.properties loaded succeessfully!");
					}
					
				} catch (IOException e) {
					System.err.println("Error:Failed to load extent.properties -" +e.getMessage());
				}
			}
				    
			
		//	public static void main(String[] args) {
		    private static ThreadLocal<String> testName = new ThreadLocal<>();

			@Override
			@DataProvider(parallel=false) 

			
			public Object[][] scenarios()
			{
				return super.scenarios();
			}

		    @Test(dataProvider = "scenarios")
		    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		        // Set the test name to the scenario name
		        String scenarioName = pickleWrapper.getPickle().getName();

		        testName.set(scenarioName);
		        System.out.println("Running scenario: " + scenarioName);
		        super.runScenario(pickleWrapper, featureWrapper);
		    }



			@Override
			public String getTestName() {
				// TODO Auto-generated method stub
		        return testName.get();

			}


					}	


