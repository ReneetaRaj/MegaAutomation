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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

	@BeforeTest
	public void SetUp() {

		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

	}

	@Test
	public void Login() throws IOException, InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://mega.nz/");

		driver.navigate().to("https://mega.nz/login");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 "#login-name2"))) ;
		 
		

		driver.findElement(By.xpath("//*[@id=\"bodyel\"]/section[1]/div[4]/div[1]/div[2]/button[1]")).click();
		driver.findElement(By.cssSelector("#login-name2")).sendKeys("ReneetaRaj@gmail.com");
		driver.findElement(By.cssSelector("#login-password2")).sendKeys("April_11@$!");
		driver.findElement(By.cssSelector("#login_form > button > span")).click();
		
		
		
	//	driver.findElement(By.cssSelector("#login_form > button > span")).click();
		
		
	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fmholder\"]/div[*]/div[*]/div[*]/div[contains(@class,'fm-right-header fm')]/div[*]/div/span"))) ;
		
	  WebElement hoverover =   driver.findElement(By.xpath("//*[@id=\"fmholder\"]/div[*]/div[*]/div[*]/div[contains(@class,'fm-right-header fm')]/div[*]/div/span"));
	  WebElement clickupload =   driver.findElement(By.xpath("//*[@id='fmholder']/div[4]/div[1]/div[5]/div[9]/div[1]/div/div/button[2]/span"));
		
	    Actions actions = new Actions(driver);
	    actions.moveToElement(hoverover);
	    actions.click(clickupload).build().perform();
	
	    Thread.sleep(6000);
	   Runtime.getRuntime().exec("testData/FileUpload.exe");	
	   
	   Thread.sleep(8000);
	   
	   
	   WebElement hoveroverfordelete =   driver.findElement(By.xpath(".//*/a[contains(@title,'a.txt')]/span[1]/span[3]/i"));
	   actions.moveToElement(hoveroverfordelete).build();
	   actions.click(hoveroverfordelete).build().perform();
	   
	   WebElement delete =   driver.findElement(By.cssSelector(".dropdown-section > .remove-item > span"));
       actions.moveToElement(delete).build();
       actions.click(delete).build().perform();
	   
	   
	   Thread.sleep(3000);
		driver.findElement(By.cssSelector(".space-between > .confirm")).click();
      

//		driver.close();

	}

}
