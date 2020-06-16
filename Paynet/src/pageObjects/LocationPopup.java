package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import supportMethods.HelperMethods;

public class LocationPopup {

	WebDriver driver;
	HelperMethods generic = new HelperMethods();

	public LocationPopup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "a-popover-3")
	private WebElement popUp;
	
	@FindBy(how = How.ID, using = "a-popover-header-3")
	private WebElement popupHeader;
	
	@FindBy(how = How.CSS, using  = "#GLUXSignInButton input")
	private WebElement signinOption;
	
	@FindBy(how = How.ID, using = "GLUXZipUpdateInput")
	private WebElement zipCode;
	
	@FindBy(how = How.ID, using = "GLUXChangePostalCodeLink")
	private WebElement ChangeZipCode;
	
	@FindAll(@FindBy(how = How.ID, using = "GLUXChangePostalCodeLink"))
	private List<WebElement> ChangeZipCodeCount;
	
	@FindBy(how = How.CSS, using = "#GLUXZipUpdate Input")
	private WebElement ApplyZipCode;
	
	@FindBy(how = How.ID, using = "GLUXCountryList")
	private WebElement selectCountry;
	
	@FindBy(how = How.CSS, using = "#GLUXZipError i+div")
	private WebElement zipCodeError;
	
	public String getZipCodeError() {
		return zipCodeError.getText();
	}

	@FindBy(how = How.NAME, using = "glowDoneButton")
	private WebElement Done;

	@FindBy(how = How.ID ,using = "GLUXHiddenSuccessSelectedAddressPlaceholder")
	private WebElement LocationAcknowledgement_PinCode;
	
	
	@FindBy(how = How.XPATH, using = "(//*[@class='a-button-inner a-declarative'])[2]")
	private WebElement LocationAcknowledgement_Confirm;	
	
	
	public void changeUSZipCode(String zip){
		
		generic.driverWait(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(popUp));

		if(ChangeZipCodeCount.size() > 0)
		if (ChangeZipCode.isDisplayed())
			ChangeZipCode.click();
		generic.driverWait(1000);
		zipCode.sendKeys(zip);
		ApplyZipCode.click();
		generic.driverWait(2000);
	}
	
	public void selectOtherCountry(String country){
		
		Select countrySelect = new Select(selectCountry);
		countrySelect.selectByVisibleText(country);
		generic.driverWait(2000);
	}
	
	public void closePopup(){
		Done.click();
		generic.driverWait(2000);
	}
	
	public void closeAckPopup(){
		LocationAcknowledgement_Confirm.click();
		generic.driverWait(2000);
	}
	
	public void selectSigninOption(){
		signinOption.click();
		generic.driverWait(2000);
	}
	
}
