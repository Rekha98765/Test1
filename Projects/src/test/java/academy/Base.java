package academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	WebDriver driver;
	@Test
	public void initializeDriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream("E:\\SeleniumByMudea.Rekha\\Eclipse-workspace\\cucumber1\\src\\test\\java\\academy\\data.properties");
		
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Koush\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
			driver=new ChromeDriver();
		}
	}
	

}
