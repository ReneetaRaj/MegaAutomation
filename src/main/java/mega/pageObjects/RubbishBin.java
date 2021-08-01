package mega.pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mega.Util.Utility;

public class RubbishBin {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	Utility utility;
	
	static final String rubbishBinXpath = "//*/section/div/div/button[contains(@class, 'rubbish-bin')]";
	static final String clearRubbishBinXpath = ".//*/div[*]/div[*]/button[contains(@class, 'clearbin')]/span";
	static String restoreHoverOverXpath = ".//*/a[contains(@title,'stringToReplace')]/span[*]/span[contains(@class,'settings')]/i";
	@FindBy(xpath = rubbishBinXpath)
	public WebElement rubbishBin;
	
	@FindBy(xpath = ("//*[@id='fmholder']/div[*]/div[*]/div[*]/div[contains(@class,'fm-right-header fm')]/div[*]/div/span"))
	public WebElement uploadHoverOver;
	
	@FindBy(xpath = clearRubbishBinXpath)
	public WebElement clearBin;
	
	@FindBy(css = (".dropdown-section > .revert-item > span"))
	public WebElement restore;
	
	@FindBy(css = (".dropdown-section > .move-item > span"))
	public WebElement move;
	
	
	@FindBy(css = ("#csb_move > .cloud-item > i"))
	public WebElement moveToCloudDrive;
	
	
	@FindBy(xpath = (".//*/div[*]/div[*]/div[contains(@class,'fm-breadcrumbs-block')]/a/span/span"))
	public WebElement rootHeader;
	
	public RubbishBin(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		utility =  new Utility();
		actions = new Actions(driver);
		
	}
	
	public String RestoreFile() throws IOException, InterruptedException {
		
		   restoreHoverOverXpath =  restoreHoverOverXpath.replace("stringToReplace", utility.getTestData("fileName"));
		   wait.until(ExpectedConditions.visibilityOf(clearBin));
		   actions.moveToElement(driver.findElement(By.xpath(restoreHoverOverXpath))).build();
		   actions.click(driver.findElement(By.xpath(restoreHoverOverXpath))).build().perform();
		   
		   Thread.sleep(5000);
		   actions.moveToElement(restore).build();
		    actions.click(restore).build().perform();
//		   actions.moveToElement(move).build().perform();;
//		    actions.click(moveToCloudDrive).build().perform();
		    
	       wait.until(ExpectedConditions.visibilityOf(uploadHoverOver));
	       
	       return rootHeader.getText();
	}


}
