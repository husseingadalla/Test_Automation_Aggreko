package playground;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import framework.Library_MQTT;

public class selenium_playground {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String chrome_path=System.getProperty("user.dir")+"\\Drivers\\Chrome\\chromedriver.exe";
System.setProperty("webdriver.chrome.driver", chrome_path);

String firefox_path=System.getProperty("user.dir")+"\\Drivers\\FireFox\\geckodriver.exe";
System.setProperty("webdriver.gecko.driver", firefox_path);

WebDriver driver_firefox = new FirefoxDriver();
driver_firefox.navigate().to("https://uk.flightaware.com");

driver_firefox.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

WebElement search_input_field= driver_firefox.findElement(By.id("s2id_autogen1"));
//search_input_field.sendKeys("LH 591");
search_input_field.click();
driver_firefox.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
Library_MQTT.pasting_flight_number();

WebElement track_btn = driver_firefox.findElement(By.className("orange_button"));
track_btn.click();

WebElement flight_status_Destination_arrival = driver_firefox.findElement(By.className("flightPageDestinationDelayStatus"));
String flight_status_Destination_arrival_text =flight_status_Destination_arrival.getText();
System.out.println("The flight status of arrival to destination is "+flight_status_Destination_arrival_text);
boolean flight_status_Destination_arrival_text_early = flight_status_Destination_arrival_text.contains("early");
boolean flight_status_Destination_arrival_text_late = flight_status_Destination_arrival_text.contains("late");

WebElement flight_status_source_departure = driver_firefox.findElement(By.className("flightPageOriginDelayStatus"));
String flight_status_source_departure_text =flight_status_source_departure.getText();
System.out.println("The flight status of departure from source is "+flight_status_source_departure_text);
boolean flight_status_source_departure_text_early = flight_status_source_departure_text.contains("early");
boolean flight_status_source_departure_text_late= flight_status_source_departure_text.contains("late");

 boolean overall_flight_status_check_result = flight_status_source_departure_text_early||flight_status_source_departure_text_late||flight_status_Destination_arrival_text_early||flight_status_Destination_arrival_text_late;
if (overall_flight_status_check_result==true) {
	System.out.println("TC pass");	
}
else {
	System.out.println("TC fail");
}

WebElement departing_airport = driver_firefox.findElement(By.xpath("//*[@class='flightPageSummaryOrigin']"));
String departing_airport_name = departing_airport.getText();
System.out.println("departing airport is "+departing_airport_name);

WebElement arriving_airport = driver_firefox.findElement(By.xpath("//*[@class='flightPageSummaryDestination']"));
String arriving_airport_name = arriving_airport.getText();
System.out.println("arriving airport is "+arriving_airport_name);

try {
	

	WebElement flight_status = driver_firefox.findElement(By.xpath("//div[@class='flightPageSummaryStatus delayed'][1]"));
	//WebElement flight_status = driver_firefox.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]"));
	String flight_status_text = flight_status.getText();
	System.out.println("The overall status of the flight is "+flight_status_text);
} catch (Exception e) {
	WebElement flight_status = driver_firefox.findElement(By.xpath("//div[@class='flightPageSummaryStatus normal'][1]"));
	String flight_status_text = flight_status.getText();
	System.out.println("The overall status of the flight is "+flight_status_text);
}


//THE class name for the status is flightPageSummaryStatus delayed or flightPageSummaryStatus normal or ,,,,,,

//The status is eiter early or late not delayed

	}
	
}
