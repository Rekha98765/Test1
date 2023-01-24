package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import utilities.TestUtil;

public class TechMoniotrStepDefiniton extends TestBase {
	
	@Before
	public void setUp()
	{
		logger = Logger.getLogger("TechMonitor");
		current_project_dir=System.getProperty("user.dir");
		PropertyConfigurator.configure(current_project_dir+"/log4j.properties");
		
		
		try
		{
			current_project_dir=System.getProperty("user.dir");
			File propFile = new File(current_project_dir+"/config.properties");
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			logger.info("Loading config Properties file");
			
			
		}
		catch(IOException e)
		{
			e.getMessage();
			e.getStackTrace();
		}
		
		String browserName = prop.getProperty("browser");
		logger.info("Using browser- "+browserName);
		
		logger.info("Getting "+browserName+" webdriver");
		driver = utilities.BrowserFactory.checkBrowser(driver, current_project_dir,browserName);
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
	}


@Given("Open the Tech Monitor website")
public void open_the_tech_monitor_website() throws InterruptedException {
	testUtil = new TestUtil(driver);
//	String username, password;
//	driver.get("https://uat.techmonitor.ai/");

	String username = "permutive";
	String password = "Permutive@123";
	//String URL = "https://" +username +":" +password +"@uat.techmonitor.ai/";
	driver.get("https://" +username +":" +password +"@uat.techmonitor.ai/");
	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	logger.info("Launched an application Url: using "+"https://uat.techmonitor.ai/");

}
}


