package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import utilities.TestUtil;

public class CityMonitorStepDefinition extends TestBase {
	
//	@Before
//	public void setUp()
//	{
//		logger = Logger.getLogger("CapitalMonitor");
//		current_project_dir=System.getProperty("user.dir");
//		PropertyConfigurator.configure(current_project_dir+"/log4j.properties");
//		
//		
//		try
//		{
//			current_project_dir=System.getProperty("user.dir");
//			File propFile = new File(current_project_dir+"/config.properties");
//			FileInputStream fis = new FileInputStream(propFile);
//			prop.load(fis);
//			logger.info("Loading config Properties file");
//			
//			
//		}
//		catch(IOException e)
//		{
//			e.getMessage();
//			e.getStackTrace();
//		}
//		
//		String browserName = prop.getProperty("browser");
//		logger.info("Using browser- "+browserName);
//		
//		logger.info("Getting "+browserName+" webdriver");
//		driver = utilities.BrowserFactory.checkBrowser(driver, current_project_dir,browserName);
//		
//		
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
//		
//	}





@Given("Open the City Monitor website")
public void open_the_city_monitor_website() throws InterruptedException {
	testUtil = new TestUtil(driver);
	driver.get("https://citymonitor.ai/");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	logger.info("Launched an application Url: using "+"https://citymonitor.ai/");

}
@Then("Verify the menus are aligned properly")
public void verify_the_menus_are_aligned_properly(io.cucumber.datatable.DataTable dataTable) {

	List<String> menus=dataTable.asList(String.class);

    for(String m:menus) {
    	boolean t = driver.findElement((By.xpath("//*[@class='c-header-nav__main__container']//li//a[text()='"+m.trim()+"']"))).isDisplayed();
    
        if (t) {
            System.out.println("Element is dispalyed");
         } else {
            System.out.println("Element is not dispalyed");
         }
          System.out.println("True");
    }


}

@Then("Verify the submenus are aligned properly")
public void verify_the_submenus_are_aligned_properly(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	
	WebElement ele = driver.findElement(By.xpath("//*[@class='c-mega-menu__link__sub-link icon-chevron-down']"));
	Actions actions = new Actions(driver);
	actions.moveToElement(ele).perform();
	    
    	
    	}



@Then("verify articles should be aligned")
public void verify_articles_should_be_aligned(io.cucumber.datatable.DataTable dataTable) {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 1000)", "");
	
	List<String> articles=dataTable.asList(String.class);
	List<WebElement> articlesEleList=driver.findElements(By.xpath("//span[@class='subsection-headline the-global-title']/span"));
	//driver.findElement(By.xpath("//*[@title='Close']")).click();
	List<String> articlesActual=new ArrayList<String>();
	
	for(WebElement ele:articlesEleList) {
		articlesActual.add(ele.getText());
	}

	  for(int i=0;i<articles.size();i++) {
		  
		  String actual=articlesActual.get(i).trim();
		  String exp=articles.get(i).trim();
		  System.out.println("Actual***"+actual);
		  System.err.println("Expected ****"+exp);
		  Assert.assertEquals(actual, exp); 
		   }
	  }


	
@Then("user should be able to see articles should loaded by clicking on it")
public void user_should_be_able_to_see_articles_should_loaded_by_clicking_on_it() throws InterruptedException {
	
	List<WebElement> articlesLinks=driver.findElements(By.xpath("//section/section//h4/a"));
	String pageb = driver.getCurrentUrl();
	for(int i=0;i<articlesLinks.size();i++) {
		WebElement articleEle=articlesLinks.get(i);

	
	articleEle.click();
	Thread.sleep(2000);
	try {
	driver.findElement(By.xpath("//*[@title='Close']")).click();
	Thread.sleep(2000);
	
	}catch(Exception e) {
		
	}
	((JavascriptExecutor)driver).executeScript("history.go(-1)", "");
	driver.get(pageb);
	//driver.navigate().back();
	Thread.sleep(2000);
	articlesLinks=driver.findElements(By.xpath("//section/section//h4/a"));
	 
	}

}


@Then("verify logo should be displayed properly")
public void verify_logo_should_be_displayed_properly() {
	
	driver.findElement(By.xpath("//*[@id='logo']")).isDisplayed();
	System.out.println("logo");
}



@Then("Click each and every menu and it should be directed to the respective pages")
public void click_each_and_every_menu_and_it_should_be_directed_to_the_respective_pages(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	
	List<String> userList=dataTable.asList(String.class);

    for(String menu:userList) {
    	driver.findElement(By.xpath("//*[contains(@class,'c-header-nav__main__container')]//ul//li//a[text()='"+menu.trim()+"']")).click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0, 100)", "");
    	Thread.sleep(5000);
        System.out.println("menu");
   
}

}

@Then("Click on any artical")
public void click_on_any_artical() throws InterruptedException {
    
	driver.findElement(By.xpath("//*[contains(@class,'post-title c-story__header__headline the-global-title')]//a")).click();
	Thread.sleep(1000);
	try {
	driver.findElement(By.xpath("//*[@title='Close']")).click();
	}
	catch (Exception e){
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 100)", "");
	Thread.sleep(3000);
}


@Given("in quick menu \\(OR) all section menu,Click each menu one by one and check whether it is directing to its respective page")
public void in_quick_menu_or_all_section_menu_click_each_menu_one_by_one_and_check_whether_it_is_directing_to_its_respective_page(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

	List<String> userList=dataTable.asList(String.class);

    for(String menus:userList) {
    	driver.findElement(By.xpath("//*[@id='mega-menu-button']")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//div[contains(@class,'menu-header-menu-container')]//ul//li//a[text()='"+menus.trim()+"']")).click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0, 100)", "");
    	Thread.sleep(5000);
    	
}
}


@Given("Click each Extramenu one by one and check whether it is directing to its respective page")
public void click_each_extramenu_one_by_one_and_check_whether_it_is_directing_to_its_respective_page(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
    
	List<String> userList=dataTable.asList(String.class);

    for(String extra:userList) {
    	driver.findElement(By.xpath("//*[@id='mega-menu-button']")).click();
    	Thread.sleep(5000);
    	if(extra.trim().equalsIgnoreCase("Partner companies")) {
    		driver.findElement(By.xpath("//*[contains(@class,'menu-city-monitor-container')]//li//a[contains(@href,'partner-companies')]")).click();
    	}else {
    		driver.findElement(By.xpath("//*[contains(@class,'menu-city-monitor-container')]//li//a[text()='"+extra.trim()+"']")).click();
    	}
    	
    	try {
    	driver.findElement(By.xpath("//*[@title='Close']")).click();
    	}
    	catch(Exception e) {
    				
    	}
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0, 100)", "");
    	//Thread.sleep(1000);

	
}
}



@When("User able to clicks on {string} in the application")
public void user_able_to_clicks_on_in_the_application(String string) {
	
	
	driver.findElement(By.xpath("//*[@id='header-search']")).click();

}
@Then("User able to enter an {string} in the Search  box")
public void user_able_to_enter_an_in_the_search_box(String string) {
	
	driver.findElement(By.xpath("(//*[@type='text'])[1]")).sendKeys("Privacy Policy");
	
	}

@Then("User has to Click the Search Icon and it ashould be directed to the respective page")
public void user_has_to_click_the_search_icon_and_it_ashould_be_directed_to_the_respective_page() throws InterruptedException {
    
	driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
    JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 100)", "");
	Thread.sleep(3000);
    System.out.println("Privacy Policy");
}

@Then("Click on any menu and it should be navigate to the  respective page")
public void click_on_any_menu_and_it_should_be_navigate_to_the_respective_page(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    
	List<String> List=dataTable.asList(String.class);

    for(String b:List) {
    driver.findElement(By.xpath("//*[@class='menu-footer-site-links-container']//ul//li//a[text()='"+b.trim()+"']")).click();
    Thread.sleep(1000);
    	try {
        	driver.findElement(By.xpath("//*[@title='Close']")).click();
        	}
        	catch(Exception e) {
            }
        	driver.get("https://citymonitor.ai/");
        	JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0, 10000)", "");
            
    	}
  
     }

@Then("Click on any menu and it should be their in the  respective page")
public void click_on_any_menu_and_it_should_be_their_in_the_respective_page(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
   
	List<String> userList=dataTable.asList(String.class);

    for(String h:userList) {
    System.out.println("h");
    String xpath="//div[contains(@class,'afterFooter__companyList ')]//a//img[@alt='name']";
    String xpathAdress=xpath.replace("name",h);
    driver.findElement(By.xpath(xpathAdress)).click();
    try {
    	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
    	}
    	catch(Exception e) {
        }
    driver.get("https://citymonitor.ai/");
    }
   }

@When("user Click on {string} menu under {string} tab")
public void user_click_on_menu_under_tab(String string, String string2) throws InterruptedException {
	driver.findElement(By.xpath("//span[text()='All Sections']")).click();
	Actions act=new Actions(driver);
	WebElement menuEle=null;

	
	String menuXpath = "//*[contains(@class,'menu-city-monitor-container')]//li//a[text()='White papers']";
	menuEle=driver.findElement(By.xpath(menuXpath));
	System.out.println(menuEle.getText());
	Thread.sleep(3000);
	menuEle.click();


}

@Then("user must be directed to WhitePapers page after clicking the {string} in th site")
public void user_must_be_directed_to_white_papers_page_after_clicking_the_in_th_site(String string) throws InterruptedException {
	try {
    	driver.findElement(By.xpath("//*[@title='Close']")).click();
    	}
    catch(Exception e) {
        }
    System.out.println("White paper");
    JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)", "");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//header[@class='c-story__header']//h4//a[text()='How is the public sector contributing to the UK’s carbon reduction targets?']")).click();
}    


@When("user should see the Author name under heading of each {string} in site")
public void user_should_see_the_author_name_under_heading_of_each_in_site(String string) {
	
	driver.findElement(By.xpath("//*[@class='post-title c-story__header__headline the-global-title']//a[text()='How many cities are there in Wales?']")).click();
	
}

@Then("user must be able to Click on the \"<author>\"and The user should be navigeted to the respective page")
public void user_must_be_able_to_click_on_the_author_and_the_user_should_be_navigeted_to_the_respective_page() throws InterruptedException {
	driver.findElement(By.xpath("//*[text()='Silvia Pellegrino']")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,400)", "");
	Thread.sleep(3000);
	
}
}



