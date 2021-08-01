package mega.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import mega.Util.Utility;
public class LandingPage {

	WebDriver driver;
	WebDriverWait wait;
	Utility utility;
	Actions actions;
  
	String uploadedFileName = ".//*/div[*]/div[*]/div[*]/div[*]/div[*]/div/a[contains(@title,'stringToReplace')]";
	@FindBy(xpath = ("//*[@id='fmholder']/div[*]/div[*]/div[*]/div[contains(@class,'fm-right-header fm')]/div[*]/div/span"))
	public WebElement uploadHoverOver;
	
	@FindBy(xpath = ("//*[@id='fmholder']/div[4]/div[1]/div[5]/div[9]/div[1]/div/div/button[2]/span"))
	public WebElement clickUpload;
	
		@FindBy(xpath = (".//*/div[*]/a[contains(@class,'newfile')]/span"))
		public WebElement newTextFile;
		
		@FindBy(xpath = ("//input[@name='dialog-new-file']"))
		public WebElement enterText;
		
		@FindBy(css = (".fm-dialog-new-file-button > span"))
		public WebElement createButton;
		
		@FindBy(css = (".CodeMirror textarea"))
		public WebElement inputText;
		
		@FindBy(css = (".gradient > span"))
		public WebElement saveButton;
		
		@FindBy(css = (".close-btn > .sprite-fm-mono"))
		public WebElement closeButton;
		
		@FindBy(xpath = ("//*[@id='create-file-dialog-title']"))
		public WebElement newFileXpath;
	
	@FindBy(xpath = (".//*/div[contains(@class,'float-widget transfer-progress tpw hidden')]"))
	public List<WebElement> progressSection;

	@FindBy(css = (".dropdown-section > .remove-item > span"))
	public WebElement remove;
	
	@FindBy(css = (".space-between > .confirm"))
	public WebElement confirmemove;

	@FindBy(xpath = (".//*/div/header/div[contains(@class,'editor')]/span"))
	public WebElement editorFileName;
	
	@FindBy(xpath = (".//*/div[contains(@class,'loading-spinner hidden')]"))
	public List<WebElement> loadingSpinner;
	
		
	@FindBy(xpath = ("//*[@id='fmholder']/div[*]/div[*]/div[*]/div[contains(@class,'fm-empty-cloud')]"))
	public WebElement emptyCloudDrive;
	

	static final String rubbishBinXpath = "//*/section/div/div/button[contains(@class, 'rubbish-bin')]";
	@FindBy(xpath = rubbishBinXpath)
	public WebElement rubbishBin;
	
	
	
	
	String deleteHoverOver = ".//*/a[contains(@title,'stringToReplace')]/span[*]/span[contains(@class,'settings')]/i";
	//String statusOfFileName = ".//section/div[*]/div[*]/div[*]/*/*/*/div/div[.='stringToReplace']/../div[4]";
	String uploadedFile = ".//*/a[contains(@title,'stringToReplace')]/span[1]";
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		utility =  new Utility();
		actions = new Actions(driver);
    }
	
	public String CreateFile() throws IOException, InterruptedException {

		 wait.until(ExpectedConditions.visibilityOf(uploadHoverOver));
		 actions.contextClick(emptyCloudDrive).perform();
		 
		 actions.moveToElement(newTextFile).build();
		 actions.click(newTextFile).build().perform();
		 
		 wait.until(ExpectedConditions.visibilityOf(newFileXpath));
			 
		 enterText.clear();
		 enterText.sendKeys(utility.getTestData("fileName"));
	
		 createButton.click();		 
		 wait.until(ExpectedConditions.visibilityOf(editorFileName));
		 
	 
		 inputText.sendKeys(utility.getTestData("fileContent"));
 
		 saveButton.click();
     	 Thread.sleep(8000);
		
		 closeButton.click();
 
		 uploadedFile = uploadedFile.replace("stringToReplace", utility.getTestData("fileName"));
		 
		return uploadedFile;

	 
	    	
	}
	
	public void assertIsDisplayed(String file) throws InterruptedException {
		 
		
		  Assert.assertTrue(driver.findElement(By.xpath(file)).isDisplayed());
	
	}
	
	
	public boolean DeleteFile() throws IOException, InterruptedException {
		
		  
		   deleteHoverOver =  deleteHoverOver.replace("stringToReplace", utility.getTestData("fileName"));
		   wait.until(ExpectedConditions.visibilityOf(uploadHoverOver));
		   
		   Thread.sleep(5000);
		   actions.moveToElement(driver.findElement(By.xpath(deleteHoverOver))).build();
		   actions.click(driver.findElement(By.xpath(deleteHoverOver))).build().perform();
		   
		   actions.moveToElement(remove).build();
	       actions.click(remove).build().perform();
	       
	       
		   
	       confirmemove.click();
	       
		   return wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(deleteHoverOver))));


    
	 //   uploadedFile = uploadedFile.replace("stringToReplace", utility.getTestData("fileName"));
	    
	 //   Assert.assertTrue(driver.findElement(By.xpath(uploadedFile)).isDisplayed());
	 
	    	
	}
	
	
	public RubbishBin navigateToRubbishBin() {
		
		wait.until(ExpectedConditions.visibilityOf(rubbishBin)) ;
		rubbishBin.click();
		return new RubbishBin(driver);
		
	}
	
	
	
}
