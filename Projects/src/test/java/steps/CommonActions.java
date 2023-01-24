package steps;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 

public class CommonActions {
	
	private WebDriver driver;
	

//	@Before
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception 
	{
		
		Thread.sleep(3000);
		driver.quit();
		Thread.sleep(1000);
	}
	
 
	
	public  WebDriver getDriver()
	{
		
	return driver;
		
	}
}
