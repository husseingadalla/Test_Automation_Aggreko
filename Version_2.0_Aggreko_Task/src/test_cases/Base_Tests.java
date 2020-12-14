package test_cases;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeSuite;


public class Base_Tests {
	
	public static WebDriver drivver;
	@BeforeSuite
	 public void start_driver() {
	String firefox_path=System.getProperty("user.dir")+"\\Drivers\\FireFox\\geckodriver.exe";
	System.setProperty("webdriver.gecko.driver", firefox_path);
	//drivver=new FirefoxDriver();
	//drivver.navigate().to("https://uk.flightaware.com");
	
}
}
