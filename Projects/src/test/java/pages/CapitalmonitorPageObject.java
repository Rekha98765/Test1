package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import steps.TestBase;
import utilities.TestUtil;

public class CapitalmonitorPageObject extends TestBase{
	
	private WebDriver driver;
	
	TestUtil testUtil;

	public CapitalmonitorPageObject(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
			testUtil = new TestUtil(driver);
			//waitHelper.WaitForElement(userName, 60);
		}
	
	
	public void verifyMenu(String menu)
	{
		
		String path="//ul[@id='menu-header-menu']//a[text()='placeHoder']";
		String xpathMenu=path.replace("placeHolder", menu);
		driver.findElement(By.xpath(menu)).click();
		
	}

}
