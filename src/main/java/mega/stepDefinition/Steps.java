package mega.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mega.Util.Utility;
import mega.base.BaseClass;
import mega.pageObjects.LandingPage;
import mega.pageObjects.LoginPage;
import mega.pageObjects.RubbishBin;

public class Steps extends BaseClass {
	
	Utility utility = new Utility();
	LandingPage landingpage; 
    LoginPage login;
    RubbishBin rubbishbin;
     String createdFile; 
    String rootHeader; 
    boolean isFileExists;
    String expectedRootHeader = "Cloud Drive";

	
	@Given("the user has logged into mega")
	public void the_user_has_logged_into_mega() throws IOException {
	    // set the Chrome driver
		setDriver(new ChromeDriver());
			
		login = new LoginPage(getDriver());
		
		// get the test data - URL from properties and log
		getDriver().get(utility.getTestData("baseUrl"));
		getDriver().navigate().to(utility.getTestData("loginUrl"));
		getDriver().manage().window().maximize();
		
		
		landingpage = login.loginToApplication();

			
	}
	
	@When("the user removes a file")
	public void the_user_removes_a_file() {
	  

		try {
			isFileExists = landingpage.DeleteFile();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("the user should be allowed to remove a file successfully")
	public void the_user_should_be_allowed_to_remove_a_file_successfully() {
			Assert.assertTrue(isFileExists);
	}
	
	@When("the user navigates to Rubbish bin")
	public void the_user_navigates_to_rubbish_bin() {
		rubbishbin = landingpage.navigateToRubbishBin();
	}

	@When("the user restores a file")
	public void the_user_restores_a_file() throws InterruptedException {
		
		try {
		  rootHeader = rubbishbin.RestoreFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Then("the user should be allowed to restore a file successfully")
	public void the_user_should_be_allowed_to_restore_a_file_successfully() {
		Assert.assertEquals(rootHeader.replaceAll("\\s+", " "), expectedRootHeader);
	}
	
	@When("the user creates a file")
	public void the_user_creates_a_file() {


		try {
			createdFile = landingpage.CreateFile();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Then("the user should be allowed to create a file successfully")
	public void the_user_should_be_allowed_to_create_a_file_successfully() throws InterruptedException {
		landingpage.assertIsDisplayed(createdFile);
		
	}
	
	@After
	public void TearDown() {

	  getDriver().close();
		
			
	}


}
