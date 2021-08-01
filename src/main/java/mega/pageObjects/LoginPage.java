package mega.pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mega.Util.Utility;




public class LoginPage 
{

	WebDriver driver;
	WebDriverWait wait;
	Utility utility;

	
	String loginForm = "#login_form > div.account.top-header.login";
	@FindBy(css = ("#login-name2"))
	public WebElement loginName;
	
	@FindBy(css = ("#login-password2"))
	public WebElement loginPassword;
	
	@FindBy(css = ("#login_form > button > span"))
	public WebElement loginSubmit;
	
	@FindBy(xpath = ("//*[@id='bodyel']/section[1]/div[4]/div[1]/div[2]/button[1]"))
	public WebElement acceptAllCookies;
	

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    utility =  new Utility();
		
	}
	 

	public LandingPage loginToApplication() throws IOException {
		
	
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginForm))) ;
		 
		acceptAllCookies.click();
		loginName.sendKeys(utility.getTestData("username"));
		loginPassword.sendKeys(utility.getTestData("password"));
		loginSubmit.click();
		
		return new LandingPage(driver);
	
	}
}
