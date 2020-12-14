package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.Library_MQTT;

public class Home_page extends Base_page {

	public Home_page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "s2id_autogen1")
	public static WebElement search_input_field;
	
	@FindBy(className = "orange_button")
	public static WebElement track_btn;

	
public  void search_by_flight_number(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	search_input_field.click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	Library_MQTT.pasting_flight_number();
	track_btn.click();
	
}



}