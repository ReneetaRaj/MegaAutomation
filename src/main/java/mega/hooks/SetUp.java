package mega.hooks;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import mega.base.BaseClass;

public class SetUp extends BaseClass{

	@Before
	public void Initialise() {

		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			
	}
	

	
}
