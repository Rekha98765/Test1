package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvancedSearchElements {
	
	WebDriver driver;
	
	public EbayAdvancedSearchElements(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}
