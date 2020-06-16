package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import supportMethods.HelperMethods;

public class HomePage {

	
	WebDriver  driver;
	HelperMethods generic = new HelperMethods();
	
	@FindBy(how = How.CSS, using = "#glow-ingress-line2")
	private WebElement location;
	
	@FindBy(how = How.ID, using ="nav-packard-glow-loc-icon")
	private WebElement locationIcon;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	
	public void changeLocation(){
		locationIcon.click();
		generic.driverWait(2000);
	}
	
	public String getCurrentLocation(){
		return location.getText();
	}
	
}
