package mega.automation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.Before;
import mega.base.BaseClass;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseClass {


	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */


	
	@BeforeMethod
	public void Login() {

		
		
	}

	@Test (testName="Create a text file a.txt with content megatesting on it")
	public void CreateAFile() throws IOException, InterruptedException {

	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
	    Actions actions = new Actions(driver);
	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fmholder\"]/div[*]/div[*]/div[*]/div[contains(@class,'fm-right-header fm')]/div[*]/div/span"))) ;
		
	  WebElement hoverover =   driver.findElement(By.xpath("//*[@id=\"fmholder\"]/div[*]/div[*]/div[*]/div[contains(@class,'fm-right-header fm')]/div[*]/div/span"));
	  WebElement clickupload =   driver.findElement(By.xpath("//*[@id='fmholder']/div[4]/div[1]/div[5]/div[9]/div[1]/div/div/button[2]/span"));

	    actions.moveToElement(hoverover);
	    actions.click(clickupload).build().perform();
	
	    Thread.sleep(6000);
	   Runtime.getRuntime().exec("testData/FileUpload.exe");	
	   
	   Thread.sleep(8000);
	   
	 
	}

}
