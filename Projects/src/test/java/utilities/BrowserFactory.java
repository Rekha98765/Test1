package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory 
{
	static WebDriver driver1=null;
	public static WebDriver checkBrowser(WebDriver driver,String current_project_dir,String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",current_project_dir+"/Drivers/chromedriver.exe");
			/*
			 * ChromeOptions options = new ChromeOptions(); options.
			 * addArguments("user-data-dir=C:\\Users\\VINGLE\\AppData\\Local\\Google\\Chrome\\User Data"
			 * ); options.addArguments("disable-infobars");
			 * 
			 * driver = new ChromeDriver(options);
			 */
			if(driver1==null)
			driver1 = new ChromeDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", current_project_dir+"/Drivers/geckodriver.exe");
			if(driver1==null)
			driver1 = new FirefoxDriver();
				
		}
		
		return driver1;
		
		
	}
	
	
	
}
