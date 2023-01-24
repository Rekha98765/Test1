package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import utilities.TestUtil;

public class PmiStepDefinition  extends TestBase{

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



@Given("Open the PMI Website")
public void open_the_pmi_website() throws InterruptedException {
	   
    testUtil = new TestUtil(driver);
	driver.get("https://test-nsmg-events.pantheonsite.io/pmi-live/");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	logger.info("Launched an application Url: using "+"https://test-nsmg-events.pantheonsite.io/pmi-live/");


}

@Then("Verify the scroller buttons are working properly in the website")
public void verify_the_scroller_buttons_are_working_properly_in_the_website() {

	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 300)", "");
	
}

@Then("Verify the website logo in the header")
public void verify_the_website_logo_in_the_header() {
    
	driver.findElement(By.xpath("(//div[@class='logo'])[1]"));
	System.out.println("logo");
   
}


@Then("Check wether their are four menus in the header")
public void check_wether_their_are_four_menus_in_the_header() {
    
System.out.println("Menus");

}

@Then("Click each and every menu and it should be navigated to the respective pages")
public void click_each_and_every_menu_and_it_should_be_navigated_to_the_respective_pages(DataTable dataTable) throws InterruptedException {
   
	List<String> userList=dataTable.asList(String.class);

    for(String menu:userList) {
    	driver.findElement(By.xpath("(//ul[contains(@id,'menu-main-menu')]//li//a[text()='"+menu.trim()+"'])[1]")).click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0, 300)", "");
    	Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
        Thread.sleep(5000);
        System.out.println("menu");
   
}

}



@Then("Select data in the {string} under Find your community and click on Search button")
public void select_data_in_the_filters_under_find_your_community_and_click_on_search_button(String string) throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 200)", "");
	
	driver.findElement(By.xpath("//div[@class='form-field filter grid__col-6']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//ul[@id='filter-sectors']//li[text()='Banking, Financial Services & Insurance (BFSI)']")).click();  
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[text()='Search']")).click();
    driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("window.scrollBy(0, 300)", "");
	Thread.sleep(3000);
	//driver.quit();
    
    
    
}



@Then("Verify the following sections in the home page")
public void verify_the_following_sections_in_the_home_page(DataTable dataTable) {
	List<String> values=dataTable.asList(String.class);

    for(String r:values) {
    	boolean t = driver.findElement((By.xpath("//section//div//h2"))).isDisplayed();
    
        if (t) {
            System.out.println("Element is dispalyed");
         } else {
            System.out.println("Element is not dispalyed");
         }
          System.out.println("True");
    }
   
    
	
}

@Then("User has to Click on View more events button under Featured events section in home page")
public void user_has_to_click_on_view_more_events_button_under_featured_events_section_in_home_page() throws InterruptedException {
	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("window.scrollBy(0, 3000)", "");
	driver.findElement(By.xpath("//a[text()='View more events']")).click();
	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js1.executeScript("window.scrollBy(0, 300)", "");
	Thread.sleep(3000);
	
}


@Then("User Should click on Events menu on website and Verify if all the events are displaying as per their configuration")
public void user_should_click_on_events_menu_on_website_and_verify_if_all_the_events_are_displaying_as_per_their_configuration() {
	driver.findElement(By.xpath("//li[@id='menu-item-9']")).click();
	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)", "");
	System.out.println("All events");
}

@Then("User has to Click on any upcoming conference event and verify the date, time of the event")
public void user_has_to_click_on_any_upcoming_conference_event_and_verify_the_date_time_of_the_event() throws InterruptedException {
    
    driver.findElement(By.xpath("(//*[contains(@id,'upcoming-events')]//p[text()='Conference'])[1]")).click();
	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='date']")).isDisplayed();
	driver.findElement(By.xpath("//div[@class='time']")).isDisplayed();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)", "");
	Thread.sleep(12000);
	
}

@Then("Click each and every menu and it should be direct to the respective page")
public void click_each_and_every_menu_and_it_should_be_direct_to_the_respective_page(DataTable dataTable) throws InterruptedException {
    

	List<String> userList=dataTable.asList(String.class);

    for(String tabs:userList) {
    	driver.findElement(By.xpath("//*[@class='menu-footer-site-links-container']//*[text()='"+tabs.trim()+"']")).click();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//    	js.executeScript("window.scrollBy(0, 100)", "");
    	Thread.sleep(3000);
        
    }

    	
    }


@Then("Click on Register button")
public void click_on_register_button() {
	
 	
	driver.findElement(By.xpath("(//a[@class='btn-register'])[2]")).click();
 }
@Then("User has to Click on Register Now button, enter all details")
public void user_has_to_click_on_register_now_button_enter_all_details() throws InterruptedException {
	Thread.sleep(2000);
	ArrayList<String> tab=new ArrayList<String>(driver.getWindowHandles());
 	driver.switchTo().window(tab.get(1));
	driver.findElement(By.xpath("(//span[text()='Register Now'])[2]")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 600)", "");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[text()='*First Name']/..//input")).sendKeys("Jhanu");
	driver.findElement(By.xpath("//*[text()='*Last Name']/..//input")).sendKeys("mudea");
	driver.findElement(By.xpath("//*[text()='*Corporate Email']/..//input")).sendKeys("Rekhamudea21@gmail.com");
	driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("Rekhamudea21@gmail.com");
	driver.findElement(By.xpath("//*[text()='*Job Title']/..//input")).sendKeys("Test engineer");
	driver.findElement(By.xpath("//*[text()='*Company']/..//input")).sendKeys("Global data");
	driver.findElement(By.xpath("//*[text()='*Town/City']/..//input")).sendKeys("Hyderabad");
	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("window.scrollBy(0, 400)", "");
	Thread.sleep(5000);
	WebElement ele = driver.findElement(By.xpath("(//*[text()='*Select Country']/..//span)[6]"));
	JavascriptExecutor ps = (JavascriptExecutor)driver;
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	ps.executeScript("arguments[0].click();", ele);
	driver.findElement(By.xpath("(//*[text()='*Select Country']/..//span)[6]")).click();
//	driver.findElement(By.xpath("//*[@class='select2-search select2-search--dropdown']")).click();
	driver.findElement(By.xpath("//*[@class='select2-results__options']//li[contains(text(), 'India')]")).click();
	driver.findElement(By.xpath("//*[text()='*Mobile Number']/..//input")).sendKeys("8073964529");
	JavascriptExecutor js2 = (JavascriptExecutor)driver;
	js1.executeScript("window.scrollBy(0, 400)", "");
	Thread.sleep(4000);
	WebElement ele1 = driver.findElement(By.xpath("(//*[text()='*Seniority']/..//span)[6]"));
	JavascriptExecutor ps1 = (JavascriptExecutor)driver;
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
	ps.executeScript("arguments[0].click();", ele);
	driver.findElement(By.xpath("(//*[text()='*Seniority']/..//span)[6]")).click();
	driver.findElement(By.xpath("//*[@class='select2-results__options']//li[contains(text(), 'Manager')]")).click();
	js1.executeScript("window.scrollBy(0, 400)", "");
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//*[text()='*As a purchasing authority I can:']/..//span)[6]")).click();
	driver.findElement(By.xpath("//*[@class='select2-results__options']//li[contains(text(), 'Authorise')]")).click();
	driver.findElement(By.xpath("(//*[text()='*My geographical area covers:']/..//span)[6]")).click();
	driver.findElement(By.xpath("//*[@class='select2-results__options']//li[contains(text(), 'Other')]")).click();
	js1.executeScript("window.scrollBy(0, 500)", "");
	driver.findElement(By.xpath("//*[text()='Regulatory Intelligence']")).click();
	driver.findElement(By.xpath("//*[text()='*Dietary Requirements']/..//input")).sendKeys("Nothing");
	driver.findElement(By.xpath("(//*[text()='*How did you hear about this event?']/..//span)[6]")).click();
	driver.findElement(By.xpath("//*[@class='select2-results__options']//li[contains(text(), 'Newsletter')]")).click();
	driver.findElement(By.xpath("//*[text()='Reference Code']/..//input")).sendKeys("Nothing");
	js1.executeScript("window.scrollBy(0, 500)", "");
	driver.findElement(By.xpath("(//*[text()='I have read and accept'])[1]")).click();
	driver.findElement(By.xpath("(//*[text()='I have read and accept'])[2]")).click();
	Thread.sleep(2000);
	

}


@Then("User has to scroll down to the footer")
public void user_has_to_scroll_down_to_the_footer() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 10000)", "");
	

}

@Then("User has to Click on the footer elements and verify if visitor is navigating to respective pages")
public void user_has_to_click_on_the_footer_elements_and_verify_if_visitor_is_navigating_to_respective_pages(DataTable dataTable) throws InterruptedException {

	List<String> userList=dataTable.asList(String.class);

    for(String t:userList) {
    	driver.findElement(By.xpath("(//div[@class='menu-main-menu-container']//li//a[text()='"+t.trim()+"'])[2]")).click();
    	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
    	Thread.sleep(3000);
}
}




@Then("User has to Click on the footer elements and verify the visitor is navigating to respective page")
public void user_has_to_click_on_the_footer_elements_and_verify_the_visitor_is_navigating_to_respective_page(DataTable dataTable) throws InterruptedException {

	List<String> userList=dataTable.asList(String.class);

    for(String r:userList) {
    	driver.findElement(By.xpath("//ul[contains(@id,'menu-additional-menu')]//li//a[text()='"+r.trim()+"']")).click();
    	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
    	Thread.sleep(3000);


}
}




@Then("User has to Click on any upcoming Webinar event and verify the date, time of the event")
public void user_has_to_click_on_any_upcoming_webinar_event_and_verify_the_date_time_of_the_event() {
    
   driver.findElement(By.xpath("(//*[text()='Webinar'])[2]")).click();
   driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
   JavascriptExecutor js2 = (JavascriptExecutor)driver;
   js2.executeScript("window.scrollBy(0, 400)", "");
   System.out.println("Webinar");
}
@Then("Click on Speakers menu and it should be direct to the respective page")
public void click_on_speakers_menu_and_it_should_be_direct_to_the_respective_page() {
	driver.findElement(By.xpath("(//*[text()='Speakers'])[2]")).click();
	System.out.println("Speaker");

}



@Then("User has to Click on any on demand Webinar event and verify the date, time of the event")
public void user_has_to_click_on_any_on_demand_Webinar_event_and_verify_the_date_time_of_the_event() throws InterruptedException {
	driver.findElement(By.xpath("(//*[text()='Webinar'])[3]")).click();
	driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='date']")).isDisplayed();
	driver.findElement(By.xpath("//div[@class='time']")).isDisplayed();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)", "");
	Thread.sleep(3000);
	
	
}
@Then("Click Speakers menu and it should be direct to the respective page")
public void click_speakers_menu_and_it_should_be_direct_to_the_respective_page() throws InterruptedException {
	driver.findElement(By.xpath("//div[contains(@class,'container')]//ul//li[text()='Speakers']")).click();
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("window.scrollBy(0, 300)", "");
//	
	
}

@Then("Click on View on demand button and User has to enter all details on Register page")
public void click_on_view_on_demand_button_and_user_has_to_enter_all_details_on_register_page() throws InterruptedException {
	Thread.sleep(10000); 
    driver.findElement(By.xpath("//div[contains(@class,'container')]//li//a[text()='View on demand']")).click();
    ArrayList<String> tab=new ArrayList<String>(driver.getWindowHandles());
 	driver.switchTo().window(tab.get(2));
	Thread.sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0, 700)", "");
    driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("roopa");
	driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("rani");
	driver.findElement(By.xpath("//*[@id='tel']")).sendKeys("8073964529");
	driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Global data");
	driver.findElement(By.xpath("//*[@id='jobtitle']")).sendKeys("Test engineer");
	driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Bangloure");
//	Thread.sleep(2000);
	Select se= new Select(driver.findElement(By.id("no_id")));
    se.selectByVisibleText("India");
    Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("Rekhamudea21@gmail.com");
	Thread.sleep(2000);
	Select re= new Select(driver.findElement(By.name("ind_sector")));
	re.selectByVisibleText("Building Automation");
    Thread.sleep(2000);
    Select droupdown= new Select(driver.findElement(By.name("sub_sector")));
    droupdown.selectByVisibleText("Home Automation");
    Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='checkbox']")).click();
	driver.get("https://test-nsmg-events.pantheonsite.io/pmi-live/");
}

}



	






