package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebay_Home_Elements {
	
	WebDriver driver;
	
	public Ebay_Home_Elements(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Advanced")
	WebElement advancedLink;
	
	@FindBy(id="gh-ac")
	WebElement searchBox;
	
	@FindBy(id="gh-btn")
	WebElement searchButton;
	
	@FindBy(xpath="(//div[@id='mainContent']//h1//span[@class='BOLD'])[1]")
	WebElement numOfItems;

	
	@FindBy(id="gh-cat")
	WebElement categoryOption;
}
