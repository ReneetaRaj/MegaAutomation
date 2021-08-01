package mega.base;



import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;





@RunWith(Cucumber.class)				
@CucumberOptions(features="src/test/java/mega.features",glue={"src/main/java/mega.stepDefinition"})	
public class BaseClass {

	  protected WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	

	  
	  

	 
	 

	 
	 
}
