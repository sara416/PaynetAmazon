package tests;

//import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;

import pageObjects.HomePage;
import pageObjects.LocationPopup;

public class TestSet1_DeliverToScenarios extends BaseDriver{

	/*public TestSet1_USZipCode(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 */

	/*@BeforeMethod
	public void beforeTest(){
		System.out.println("Before actual test");
	}*/

	@Test (groups = "zipcode")
	public void validateUSZipCode(){
		WebDriver driver = returnDriver();
		HomePage homepage = new HomePage(driver);
		LocationPopup updateLocation = new LocationPopup(driver);
		//		ExtentReports reports = returnReports();
		System.out.println(new Object(){ }.getClass().getEnclosingMethod().getName()+ " - Validation with valid Zip code");
		homepage.changeLocation();
		//		reports.createTest(new Object(){ }.getClass().getEnclosingMethod().getName(), "Test Method");
		updateLocation.changeUSZipCode("90201");
		updateLocation.closeAckPopup();

		Assert.assertTrue(homepage.getCurrentLocation().contains( "Bell Gardens 90201"));

	}



	@Test(groups = "zipcode")
	public void validateInvalidUSZipCode(){
		WebDriver driver = returnDriver();
		HomePage homepage = new HomePage(driver);
		LocationPopup updateLocation = new LocationPopup(driver);
		//		ExtentReports reports = returnReports();
		System.out.println(new Object(){ }.getClass().getEnclosingMethod().getName() + " - Validation with invalid Zip code");
		String currentLocation = homepage.getCurrentLocation();
		homepage.changeLocation();
		//		reports.createTest(new Object(){ }.getClass().getEnclosingMethod().getName(), "Test Method");
		updateLocation.changeUSZipCode("11111");
		Assert.assertEquals(updateLocation.getZipCodeError(), "Please enter a valid US zip code");
		updateLocation.closePopup();
		Assert.assertEquals(homepage.getCurrentLocation(), currentLocation);

	}

	@Test(groups = "SignIn")
	public void changeLocationSignIN(){

		WebDriver driver = returnDriver();
		HomePage homepage = new HomePage(driver);
		LocationPopup updateLocation = new LocationPopup(driver);
		System.out.println(new Object(){ }.getClass().getEnclosingMethod().getName() + " - Validation with Signing In option");
		//		String currentLocation = homepage.getCurrentLocation();
		homepage.changeLocation();
		updateLocation.selectSigninOption();
		Assert.assertEquals(driver.getTitle(), "Amazon Sign-In");
	}

	@Test(groups = "ForeignCountry")
	public void changeLocationForeignCountry(){

		WebDriver driver = returnDriver();
		HomePage homepage = new HomePage(driver);
		LocationPopup updateLocation = new LocationPopup(driver);
		System.out.println(new Object(){ }.getClass().getEnclosingMethod().getName() + " - Validation with Signing In option");
		
		homepage.changeLocation();
		updateLocation.selectOtherCountry("Singapore");
		updateLocation.closePopup();
		
		System.out.println("new country - " + homepage.getCurrentLocation());
		Assert.assertTrue(homepage.getCurrentLocation().contains("Singapore"));
		
	}

}
