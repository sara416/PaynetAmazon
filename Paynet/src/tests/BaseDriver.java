package tests;

import org.testng.annotations.*;

//import com.aventstack.extentreports.ExtentReports;

import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;


public class BaseDriver {
	
	WebDriver driver;
//	ExtentReports logger;
//	ExtentReports reports;
//	public BaseDriver(WebDriver driver){
//		this.driver = driver;
//	}
/*

@Test
  public void f() {

	System.out.println("Actual Test");
	
  }*/
	
	public WebDriver returnDriver(){
		return driver;		
	}

	/*public ExtentReports returnReports(){
		return reports;
	}*/
	
  @BeforeSuite (groups = "All")
  public void beforeSuite() {
	  System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
//	  DesiredCapabilities capabilities = new DesiredCapabilities();
//	  capabilities.s
//	  capabilities.setBrowserName("chrome");
//	  capabilities.setPlatform(Platform.WIN8_1);
	  driver = new ChromeDriver();
//	  logger = new ExtentReports();
	  driver.get("https://www.amazon.com/");
//	  ExtentHtmlReporter html = new ExtentHtmlReporter("output/Extent.html");
//	  ExtentReports extent = new ExtentReports();
//	  extent.attachReporter(html);
	  
//	  reports.
	  driver.manage().window().maximize();
	  
  }

  @AfterSuite (groups = "All")
  public void afterSuite() {
//	  driver.close();
	  driver.quit();
//	  reports.flush();
  }
  
  @AfterMethod (groups = "All")
  public void siteRefresh(){
	  driver.navigate().to("https://www.amazon.com/");
  }
}
