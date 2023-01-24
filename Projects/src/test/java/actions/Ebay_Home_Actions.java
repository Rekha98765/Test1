package actions;

import org.openqa.selenium.WebDriver;

import elements.Ebay_Home_Elements;
import steps.CommonActions;

public class Ebay_Home_Actions {

	
	private WebDriver driver;
	Ebay_Home_Elements ebay_Home_Elements;
	
	public Ebay_Home_Actions(CommonActions commonActions) {
		this.driver=commonActions.getDriver();
		ebay_Home_Elements=new Ebay_Home_Elements(driver);
		
	}
	
public void clickAdvancedLink() {
	
	
	
}
}
