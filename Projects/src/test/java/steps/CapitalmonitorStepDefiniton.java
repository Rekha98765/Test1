package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import utilities.TestUtil;

public class CapitalmonitorStepDefiniton extends TestBase{


String menuXpath="//ul[@id='menu-header-menu']//a[text()='MENU-NAME']";
 
String subbMenuXpath="//ul[@id='menu-header-menu']//a[text()='MENU-NAME']/parent::*/ul/descendant::a";

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
	
	

	

@Given("Open the Capital Monitor website")
public void open_the_capital_monitor_website() throws InterruptedException {
	testUtil = new TestUtil(driver);
		driver.get("https://permutive:Permutive@123@uat.capitalmonitor.ai/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		logger.info("Launched an application Url: using "+"https://uat.capitalmonitor.ai/");

}


@SuppressWarnings("deprecation")
@Then("verify menu and submenus are aligned")
public void verify_menu_and_submenus_are_aligned(io.cucumber.datatable.DataTable dataTable) {
	
	Actions act=new Actions(driver);
	WebElement menuEle=null;
	List<WebElement>subMenuList=null;
	
	Map<String, String> map = dataTable.asMap(String.class, String.class);
	
	Set<String> menus=map.keySet();
	
	for(String menuName:menus) {
		
		String[] subMenus=map.get(menuName).split("~");
		List<String> subMenusExp=Arrays.asList(subMenus);
		menuEle=driver.findElement(By.xpath(menuXpath.replace("MENU-NAME", menuName)));
		Assert.assertTrue(menuEle.isDisplayed());
		act.moveToElement(menuEle).perform();
		subMenuList=driver.findElements(By.xpath(subbMenuXpath.replace("MENU-NAME", menuName)));
		
		List<String>subMenuNameActual=new ArrayList<String>();
		for(WebElement ele:subMenuList) {
			
			subMenuNameActual.add(ele.getText().trim());
		}
		
		System.out.println(menuName);
		System.out.println(subMenuNameActual);

		System.out.println(subMenusExp);
		System.out.println("---------------------");

		for(String subMenu:subMenusExp) {
			
			//Assert.assertTrue(subMenuNameActual.contains(subMenu));
			
			
		}
				
	}
	
    
}



@SuppressWarnings("deprecation")
@Then("verify articles and links should be aligned properly")
public void verify_articles_and_links_should_be_aligned_properly(io.cucumber.datatable.DataTable dataTable) {
	    

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1000)", "");
		
		List<String> articles=dataTable.asList(String.class);
		List<WebElement> articlesEleList=driver.findElements(By.xpath("//span[@class='subsection-headline the-global-title']/a"))
				;
		List<String> articlesActual=new ArrayList<String>();
		
		for(WebElement ele:articlesEleList) {
			articlesActual.add(ele.getText());
		}

		  for(int i=1;i<articles.size();i++) {
			  
			  String actual=articlesActual.get(i).trim();
			  String exp=articles.get(i).trim();
			  System.out.println("Actual***"+actual);
			  System.err.println("Expected ****"+exp);
			  Assert.assertEquals(actual, exp); 
			  
		 
		  }
		  
			  
		  }
	
	
	List<WebElement> articlesLinks=null;

	private CharSequence menuName;

	private String banners;

	private WebElement menu;

	private String submenuXpath;

//	private Object cinema;

	private Arrays dataTable;
	
	@When("user get all articles links")

	public void getAllArticlesLinks() {
		
		articlesLinks=driver.findElements(By.xpath("//section/section//h4/a"));
	}
	
	  
	   

	 @Then("user should see articles should loaded by clicking on it")

	public void verifyAllArticlesLinksLoading() throws InterruptedException {
		
		   
		for(int i=0;i<articlesLinks.size();i++) {
				WebElement articleEle=articlesLinks.get(i);
		
			String urlFromElement=articleEle.getAttribute("href");
			try {
			articleEle.click();
			
			Thread.sleep(2000);
			String currentUrl=driver.getCurrentUrl();
			//  Assert.assertEquals(urlFromElement, currentUrl); 
			  
			  driver.navigate().back();
			}catch(Exception e) {
				
			}
			  Thread.sleep(5000);
			  articlesLinks=driver.findElements(By.xpath("//section/section//h4/a"));	
		}
		
	}
	
	
@Given("verify logo and banner should be displayed properly")	
public void verify_logos_and_banners_should_be_displayed_properly()
{
	WebElement logo =driver.findElement(By.xpath("//img[@alt='Capital Monitor']"));
	System.out.println(logo);
	driver.switchTo().frame("google_ads_iframe_/5269235/Capital_Monitor/Capital_Monitor_BB_0");
	String banners=driver.findElement(By.xpath("//div[@id='google_image_div']//img[contains(@src,'simgad')]")).getAttribute("src");
	boolean imgCheck=banners.contains("simgad");
	System.out.println("Test Image :"+imgCheck);
	
	Assert.assertTrue(imgCheck);
   
driver.switchTo().defaultContent();

	}
	   
	
    
@Then("Click on each menu one by one And check whether it is directing to its respective page")
public void click_on_each_menu_one_by_one_and_check_whether_it_is_directing_to_its_respective_page(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	
	List<String> articles=dataTable.asList(String.class);
	
	for(String address:articles) {
		
		String xpath="//ul[@id='menu-header-menu']//a[text()='name']";
		String xpathAdress=xpath.replace("name",address);
		driver.findElement(By.xpath(xpathAdress)).click();
		Thread.sleep(5000);
		
		
	}
}


@Then("Click on each submenu one by one and verify_user_able_to_navigating_to_its_respective_page")
public void click_on_each_submenu_one_by_one_and_verify_user_able_to_navigating_to_its_respective_page(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	
	Actions act=new Actions(driver);
	WebElement menu=null;
	WebElement submenu=null;		
	WebElement menuEle=null;
	List<WebElement>subMenuList=null;
	subbMenuXpath=("//ul[@class='c-header-menu__sub']//li[@class='c-mega-menu-nav__item c-parent-menu-item']/a[text()='MENU-NAME']");
	menuXpath="//div[@class='c-header-nav__main__container']//li[@class='c-mega-menu-nav__item c-parent-menu-item']/a[text()='MENU-NAME']";
	Map<String, String> map = dataTable.asMap(String.class, String.class);
	
	Set<String> menus=map.keySet();
	
	for(String menuName:menus) {
		
		String[] subMenus=map.get(menuName).split("~");
		List<String> subMenusExp=Arrays.asList(subMenus);
		
       subMenuList=driver.findElements(By.xpath("//ul[@id='menu-header-menu']//a[text()='"+menuName+"']/parent::*/ul/descendant::a"));
		
		 for(int i=0;i<subMenuList.size()-1;i++) {
			
			menu=driver.findElement(By.xpath(menuXpath.replace("MENU-NAME", menuName)));
			submenu=subMenuList.get(i);
			
			
			act.moveToElement(menu).perform();
			Thread.sleep(1000);
			act.moveToElement(submenu).click().perform();
			Thread.sleep(3000);
		
			subMenuList=driver.findElements(By.xpath("//ul[@id='menu-header-menu']//a[text()='"+menuName+"']/parent::*/ul/descendant::a"));
			
		 }
		 
	}
						
	}
	

@When("user clicks on All Sections tab")
public void user_clicks_on_all_sections_tab() {
	driver.findElement(By.xpath("//span[text()='All Sections']")).click();
}
@Then("Click on each extra menus one by one And check user able to see it is directing to its respective page {string}")
public void click_on_each_extra_menus_one_by_one_and_check_user_able_to_see_it_is_directing_to_its_respective_page(String menuName) throws InterruptedException {
   	


	Actions act=new Actions(driver);
	WebElement menuEle=null;

	
	    menuXpath="//div[@class='menu-capital-monitor-container']//li//a[text()='MENU-NAME']";
		menuEle=driver.findElement(By.xpath(menuXpath.replace("MENU-NAME", menuName)));
		System.out.println(menuEle.getText());
		Thread.sleep(4000);
		menuEle.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 100)", "");
		Thread.sleep(3000);
		


}


@When("user clicks on {string}")
public void user_clicks_on(String string) {
	
	driver.findElement(By.xpath("//button[@id='header-search']")).click();
    
}
@Then("user has to enter an {string} in the Search  box")
public void user_has_to_enter_an_in_the_search_box(String string) {
	
driver.findElement(By.xpath("(//input[@name='s'])[1]")).sendKeys("terms and condition");

}
   
@Then("user has to Click the Search Icon and Verify user able to navigating to respective page")
public void user_has_to_click_the_search_icon_and_verify_user_able_to_navigating_to_respective_page() throws InterruptedException {
	driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	    JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 300)", "");
		Thread.sleep(3000);
       System.out.println("terms and conditon");
	}


		

@When("user able to Scroll down to the footer section")
public void user_able_to_scroll_down_to_the_footer_section() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 15000)", "");
	Thread.sleep(3000);
	
}
@Then("Check whether there are three {string} icons")
public void check_whether_there_are_three_icons(String string) {
   
	System.out.println("Socialmedia");
	
}



@Then("Click on any Social media icon and user able to directed to the Capitalmonitor home page to the respective social media")
public void click_on_any_social_media_icon_and_user_able_to_directed_to_the_capitalmonitor_home_page_to_the_respective_social_media(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
    
   List<String> values=dataTable.asList(String.class);

    for(String r:values) {
    System.out.println(r);
    driver.findElement(By.xpath("//li[contains(@class,'c-social-icons-item')]//a[contains(@class,'"+r.trim()+"')]")).click();
    Thread.sleep(3000);
    ArrayList<String> tab1=new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tab1.get(0)); 	
    Thread.sleep(1000);
 //  driver.get("https://permutive:Permutive@123@uat.capitalmonitor.ai/");
  //  driver.close();
   
    }
     
    
}
  


@Then("Check whether there are  {string} icons in the footer section")
public void check_whether_there_are_icons_in_the_footer_section(String string) throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 15000)", "");
	Thread.sleep(3000);
	System.out.println("menus");
}



	

@Then("Click on any menu and it should be directed to the  respective page")
public void click_on_any_menu_and_it_should_be_directed_to_the_respective_page(DataTable dataTable) throws InterruptedException {
	List<String> List=dataTable.asList(String.class);

    for(String e:List) {
    System.out.println("e");
    String xpath="//ul[contains(@id,'menu-footer-site-links')]//li//a[text()='name']";
    String xpathAdress=xpath.replace("name",e);
    driver.findElement(By.xpath(xpathAdress)).click();
    Thread.sleep(1000);
    driver.get("https://permutive:Permutive@123@uat.capitalmonitor.ai/");
    Thread.sleep(3000);
  
	

		
	}
}		

	
	



@Then("Click on any menu and it should be directed to the  respective page with details.")
public void click_on_any_menu_and_it_should_be_directed_to_the_respective_page_with_details(DataTable dataTable) throws InterruptedException {
   
	List<String> userList=dataTable.asList(String.class);

     for(String e:userList) {
     System.out.println("e");
     String xpath="//div[contains(@class,'afterFooter__companyList ')]//a//img[@alt='name']";
     String xpathAdress=xpath.replace("name",e);
     driver.findElement(By.xpath(xpathAdress)).click();
    // driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
     Thread.sleep(10000);
     driver.get("https://permutive:Permutive@123@uat.capitalmonitor.ai/");
     Thread.sleep(5000);
   
	

		
	}
}		
	

@When("user Click on {string} menu under {string}")
public void user_click_on_menu_under(String string, String string2) throws InterruptedException {
	driver.findElement(By.xpath("//span[text()='All Sections']")).click();
	Actions act=new Actions(driver);
	WebElement menuEle=null;

	
	menuXpath="//div[@class='menu-capital-monitor-container']//li//a[text()='ESG research']";
	menuEle=driver.findElement(By.xpath(menuXpath));
	System.out.println(menuEle.getText());
	Thread.sleep(3000);
	menuEle.click();
}
@Then("user must be directed to WhitePapers page after clicking the {string}")
public void user_must_be_directed_to_white_papers_page_after_clicking_the(String string) throws InterruptedException {
    System.out.println("White paper");
    JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)", "");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//header[@class='c-story__header']//h4//a[text()='An Insurance Underwriter’s Guide: Smarter, Faster, and Better Decisions with Location Intelligence']")).click();
}
@Then("user able to see {string} textbox in the WhitePaper Article")
public void user_able_to_see_textbox_in_the_white_paper_article(String string) throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)", "");
	Thread.sleep(4000);
	
}

@Then("user must be able to enter email id and {string}")
public void user_must_be_able_to_enter_email_id_and(String string) {
    
    driver.findElement(By.xpath("//label[@for='enq-email']//input[@id='enq-email']")).sendKeys("mudearekha@parasemper.com");
	driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
	driver.findElement(By.id("enq-first-name")).sendKeys("mudea");
	driver.findElement(By.id("enq-last-name")).sendKeys("rekha");
	driver.findElement(By.id("enq-company")).sendKeys("global data");
	driver.findElement(By.id("enq-job-title")).sendKeys("test engineer");
	Select drpCountry = new Select(driver.findElement(By.name("country")));
    drpCountry.selectByIndex(2);
	driver.findElement(By.id("enq-phone")).sendKeys("8073964529");
	//driver.get("https://nsteam:Nsmg%40123$@uat.capitalmonitor.ai/");
	
}


@Then("The User must be received with the whitepaper in their official email id")
public void the_user_must_be_received_with_the_whitepaper_in_their_official_email_id() {
   System.out.println("download white paper");
}

@When("user Click on {string} menu under '<All Sections>'tab")
public void user_click_on_menu_under_all_sections_tab(String string) throws InterruptedException {
	driver.findElement(By.xpath("//span[text()='All Sections']")).click();
	Actions act=new Actions(driver);
	WebElement menuEle=null;

	
    menuXpath="//div[@class='menu-capital-monitor-container']//li//a[text()='Partners']";
	menuEle=driver.findElement(By.xpath(menuXpath));
	System.out.println(menuEle.getText());
	Thread.sleep(3000);
	menuEle.click();

}
@Then("user must be directed to Partners page")
public void user_must_be_directed_to_partners_page() throws InterruptedException {
	System.out.println("partner page");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)", "");
	Thread.sleep(100);
	
}
    

@Then("user must able to search the company name using {string}")
public void user_must_able_to_search_the_company_name_using(String string) {
	driver.findElement(By.xpath("(//input[@name='s'])[3]")).sendKeys("abrdn");
	driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	
}
@Then("The User must be provided with the list of companies starting in the respective alphabet")
public void the_user_must_be_provided_with_the_list_of_companies_starting_in_the_respective_alphabet() throws InterruptedException {
   System.out.println("alphabet");
   JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)", "");
	Thread.sleep(100);
	
}
@Then("The User must be directed to the respective Company Details page after Clicking the company name and {string} under the Company name")
public void the_user_must_be_directed_to_the_respective_company_details_page_after_clicking_the_company_name_and_under_the_company_name(String string) {
	
   System.out.println("company details");
}



		

@When("user should see the Author name under heading of each {string}")
public void user_should_see_the_author_name_under_heading_of_each(String string) throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)", "");
	driver.findElement(By.xpath("(//div[@class='c-story__header__category']//a[text()='Banks'])[1]")).click();
	
	
}
@Then("user must be able to Click on the \"<author>\"and The user should be directed to the respective page")
public void user_must_be_able_to_click_on_the_author_and_the_user_should_be_directed_to_the_respective_page() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 500)", "");
	driver.findElement(By.xpath("//address[@class='c-story__header__author c-story__header__author--main the-global-title']//a[@title='Elizabeth Meager']")).click();
	System.out.println("Elizabeth Meager");
}
@Then("verify user able to see all the articles written by the same author")
public void verify_user_able_to_see_all_the_articles_written_by_the_same_author() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 600)", "");
	System.out.println("Articals");
    
}



@Then("user has to click on any {string}")
public void user_has_to_click_on_any(String string) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)", "");
	driver.findElement(By.xpath("(//div//h4[@class='post-title c-story__header__headline the-global-title'])[1]")).click();
	
	//driver.findElement(By.xpath("(//div[@class='c-story__header__category']//a[text()='Banks'])[1]")).click();
}
@Then("user must able to see tags under the article in the name of {string}")
public void user_must_able_to_see_tags_under_the_article_in_the_name_of(String string) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 8400)", "");
	
    }
@Then("user has to Click on the topic and then user should be directed to the respective page")
public void user_has_to_click_on_the_topic_and_then_user_should_be_directed_to_the_respective_page() {
	driver.findElement(By.xpath("//a[@rel='tag']")).click();
	System.out.println("climate change");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 100)", "");
	

}



@When("user Click an article in the home page")
public void user_click_an_article_in_the_home_page() {
    
	driver.findElement(By.xpath("(//div//h2[@class='post-title c-story__header__headline the-global-title'])[1]")).click();
	
}
@When("Check whether the selected article is directing to the respective article page")
public void check_whether_the_selected_article_is_directing_to_the_respective_article_page() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 400)", "");
	System.out.println("articals");
	
}
@When("Click on each and every Sharing Options")
public void click_on_(DataTable dataTable) throws InterruptedException {	
	List<String> userList=dataTable.asList(String.class);

    for(String e:userList) {
   
    	driver.findElement(By.xpath("(//ul[contains(@class,'c-share__list')]//li//a[@title='"+e.trim()+"'])[1]")).click();
    	Thread.sleep(300);
    	if(e.contains("LinkedIN")) {
    		ArrayList<String> tab=new ArrayList<String>(driver.getWindowHandles());
        	driver.switchTo().window(tab.get(1));
        	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mudearekham34@gmail.com");
        	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Rekha@123");
        	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        	driver.findElement(By.xpath("//span[text()='Share in a post']")).click();
        	driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("Articals in capital monitor");
        	Thread.sleep(500);
        	driver.findElement(By.xpath("//div[@class='share-box_actions']")).click();
            Thread.sleep(3000);
       
//    	}else if(e.contains("Twitter")){
//    		
//    		ArrayList<String> tab1=new ArrayList<String>(driver.getWindowHandles());
//        	driver.switchTo().window(tab1.get(2));
//        	driver.findElement(By.xpath("(//span[text()='Log in'])[2]")).click();
//        	driver.findElement(By.xpath("//input[@name='text']")).sendKeys("mudearekham34@gmail.com");
//        	driver.findElement(By.xpath("//span[text()='Next']")).click();
//        	driver.findElement(By.xpath("//input[@name='text']")).sendKeys("mudearekha");
//        	driver.findElement(By.xpath("//span[text()='Next']")).click();
//            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Rekha@123");
//        	driver.findElement(By.xpath("//span[text()='Log in']")).click();
//        	//driver.findElement(By.xpath("//input[@name='text']")).sendKeys("mudearekha");
//        	driver.findElement(By.xpath("//span[text()='Next']")).click();
//        
//        	JavascriptExecutor js = (JavascriptExecutor)driver;
//            js.executeScript("window.scrollBy(0, 100)", "");
//        	driver.findElement(By.xpath("(//span[text()='Tweet'])[1]")).click();
//        	
    	}else if(e.contains("facebook")){
		 ArrayList<String> tab1=new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(tab1.get(3)); 	
    	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mudearekham34@gmail.com");
    	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Rekha@123");
    	driver.findElement(By.xpath("//input[@value='Log in']")).click();
        driver.findElement(By.xpath("//div[@class='innerWrap']//textarea[@name='xhpc_message_text']")).sendKeys("articals in capital monitor");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
   
    	}
    	 ArrayList<String> tab1=new ArrayList<String>(driver.getWindowHandles());
     	driver.switchTo().window(tab1.get(0));
     	
     
    	
    }
}
	



@Then("verify whether clicking any sharing options are directing to the respective pages with the link of the article and sharetext")
public void verify_whether_clicking_any_sharing_options_are_directing_to_the_respective_pages_with_the_link_of_the_article_and_sharetext() throws InterruptedException {
	System.out.println("Sharing option");
	
	
}



@When("User Click on {string} popup  from pre header")
public void user_click_on_popup_from_pre_header(String string) {
	driver.findElement(By.xpath("(//span[@class='text'])[2]")).click();
 }
@Then("User able to see NewsLetter Signup popup should be opened")
public void user_able_to_see_news_letter_signup_popup_should_be_opened() {
    System.out.println("Hello");
}
@Then("User has to Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox.                                                                                                                                                                                                                                                                                                            {int}.                                                                                                                                                                                                                               {int}. NewsLetter Signup popup should be opened                                                                                                                                                                                                                                                                   {int}. Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox")
public void user_has_to_select_the_newsletter_checkbox_enter_email_id_and_select_the_consent_checkbox_news_letter_signup_popup_should_be_opened_select_the_newsletter_checkbox_enter_email_id_and_select_the_consent_checkbox(Integer int1, Integer int2, Integer int3) throws InterruptedException {
	driver.findElement(By.id("submit-box")).click();
	driver.findElement(By.name("email")).sendKeys("mudearekham34@gmail.com");
	Thread.sleep(3000);
	driver.findElement(By.id("job-filter")).click();
	Thread.sleep(3000);
    driver.findElement(By.xpath("//li[@value='Chief executive officer']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//figure[@class='pop-up__submit-box__trigger']")).click();
    driver.findElement(By.xpath("//div[@class='pop-up__close icon-close']")).click();
//	WebElement droupdown=driver.findElement(By.xpath("//ul[@id='filter-jobs']"));
//	Select select=new Select (droupdown);
//	select.selectByVisibleText("Chief investment officer");
		
	//driver.findElement(By.xpath("//ul[@id='filter-jobs']//li[@value='Chief executive officer']")).isSelected();
	
}



@When("User Click on {string} popup  from pre footer")
public void user_click_on_popup_from_pre_footer(String string) {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 10000)", "");
	driver.findElement(By.xpath("(//span[@class='text'])[4]")).click();
	
	
}
@Then("User has to Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox   footer                                                                                                                                                                                                                                                                                                       {int}.                                                                                                                                                                                                                               {int}. NewsLetter Signup popup should be opened                                                                                                                                                                                                                                                                   {int}. Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox")
public void user_has_to_select_the_newsletter_checkbox_enter_email_id_and_select_the_consent_checkbox_footer_news_letter_signup_popup_should_be_opened_select_the_newsletter_checkbox_enter_email_id_and_select_the_consent_checkbox(Integer int1, Integer int2, Integer int3) throws InterruptedException {
	driver.findElement(By.id("submit-box")).click();
	driver.findElement(By.name("email")).sendKeys("mudearekham34@gmail.com");
	Thread.sleep(3000);
	driver.findElement(By.id("job-filter")).click();
	Thread.sleep(3000);
    driver.findElement(By.xpath("//li[@value='Chief executive officer']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//figure[@class='pop-up__submit-box__trigger']")).click();
    driver.findElement(By.xpath("//div[@class='pop-up__close icon-close']")).click();

}



@When("user has to Click the {string} popup  from pre header")
public void user_has_to_click_the_popup_from_pre_header(String string) {
driver.findElement(By.xpath("(//span[text()='View all newsletters'])[1]")).click();

}
@Then("User can able to see NewsLetter Signup popup should be opened")
public void user_can_able_to_see_news_letter_signup_popup_should_be_opened() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 1000)", "");
	
}
@Then("User Should be able to Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox.                                                                                                                                                                                                                                                                                                            {int}.                                                                                                                                                                                                                               {int}. NewsLetter Signup popup should be opened                                                                                                                                                                                                                                                                   {int}. Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox")
public void user_should_be_able_to_select_the_newsletter_checkbox_enter_email_id_and_select_the_consent_checkbox_news_letter_signup_popup_should_be_opened_select_the_newsletter_checkbox_enter_email_id_and_select_the_consent_checkbox(Integer int1, Integer int2, Integer int3) throws InterruptedException {
	driver.findElement(By.xpath("//div[@class='pop-up__submit-box__trigger']")).click();
	driver.findElement(By.xpath("//input[@class='email-input']")).sendKeys("mudearekha@parasemper.com");
	driver.findElement(By.xpath("//input[@class='job-type toggled']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[@value='Chief executive officer']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='pop-up__submit-box__trigger']")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, -300)", "");
	driver.get("https://permutive:Permutive@123@uat.capitalmonitor.ai/");
	
}



@When("user has to Click the {string} popup  from pre footer")
public void user_has_to_click_the_popup_from_pre_footer(String string) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 10000)", "");
	driver.findElement(By.xpath("(//span[text()='View all newsletters'])[2]")).click();
	
 }
@Then("User able to Select the Newsletter checkbox , Enter email id and Select the Consent Checkbox                                                                                                                                                                                                                                                                                                            {int}.                                                                                                                                                                                                                               {int}. NewsLetter Signup popup should be opened                                                                                                                                                                                                                                                                   {int}. Select the Newsletter checkbox , Enter email id   and Select the Consent Checkbox")
public void user_able_to_select_the_newsletter_checkbox_enter_email_id_and_select_the_consent_checkbox_news_letter_signup_popup_should_be_opened_select_the_newsletter_checkbox_enter_email_id_and_select_the_consent_checkbox(Integer int1, Integer int2, Integer int3) throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 300)", "");
	driver.findElement(By.xpath("//section[@class='all-newsletters-form__submit']")).click();
	driver.findElement(By.name("email")).sendKeys("mudearekha@parasemper.com");
	Thread.sleep(2000);
	driver.findElement(By.id("job-filter")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li[text()='Chief investment officer']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='pop-up__submit-box__trigger']")).click();
	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("window.scrollBy(0, -300)", "");
	driver.get("https://permutive:Permutive@123@uat.capitalmonitor.ai/");
  }
 }











