package pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Flight_details_page extends Base_page {

	public Flight_details_page(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(className = "flightPageDestinationDelayStatus")
	public static WebElement flight_status_Destination_arrival;
	
	@FindBy(className = "flightPageOriginDelayStatus")
	public static WebElement flight_status_source_departure;
	
	@FindBy(xpath = "//*[@class='flightPageSummaryDeparture flightTime']")
	public static WebElement flight_departure_time;
	
	
	@FindBy(xpath ="//*[@class='flightPageSummaryArrival flightTime']")
	public static WebElement flight_arrival_time;
	
	@FindBy(className = "flightPageSummaryDepartureDay")
	public static WebElement flight_departure_day;
	
	@FindBy(className = "flightPageSummaryArrivalDay")
	public static WebElement flight_arrival_day;
	
	
	@FindBy(xpath = "//*[@class='flightPageSummaryOrigin']")
	public static WebElement departing_airport;
	
	@FindBy(xpath = "//*[@class='flightPageSummaryDestination']")
	public static WebElement arriving_airport;
	
	@FindBy(xpath = "//div[@class='flightPageSummaryStatus delayed'][1]")
	public static WebElement flight_status_delayed;
	
	@FindBy(xpath = "//div[@class='flightPageSummaryStatus normal'][1]")
	public static WebElement flight_status_normal;
	
	 
	public  boolean check_destination_arrival_late_early_present () {
		
		String flight_status_Destination_arrival_text =flight_status_Destination_arrival.getText();
		boolean flight_status_Destination_arrival_text_early = flight_status_Destination_arrival_text.contains("early");
		boolean flight_status_Destination_arrival_text_late = flight_status_Destination_arrival_text.contains("late");
		
		String flight_status_source_departure_text =flight_status_source_departure.getText();
		boolean flight_status_source_departure_text_early = flight_status_source_departure_text.contains("early");
		boolean flight_status_source_departure_text_late= flight_status_source_departure_text.contains("late");
		
		boolean overall_flight_status_check_result = flight_status_source_departure_text_early||flight_status_source_departure_text_late||flight_status_Destination_arrival_text_early||flight_status_Destination_arrival_text_late;
		
		return overall_flight_status_check_result;
	}
	
	public void print_departing_airport(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String departing_airport_name = departing_airport.getText();
		System.out.println("departing airport is "+departing_airport_name);

	}
	
	public  void print_arriving_airport() {
		String arriving_airport_name = arriving_airport.getText();
		System.out.println("arriving airport is "+arriving_airport_name);
	}
	
	public  void print_departing_time() {
		String departing_time_text =  flight_departure_time.getText();
		System.out.println("departing time is "+departing_time_text);
	}
	
	public  void print_arriving_time() {
		String arrival_time_text =  flight_arrival_time.getText();
		System.out.println("arrival time is "+arrival_time_text);
	}
	
	public  void print_arriving_day() {
		String arrival_day_text =  flight_arrival_day.getText();
		System.out.println("arrival day is "+arrival_day_text);
	}
	
	public  void print_departure_day() {
		String departure_day_text =  flight_departure_day.getText();
		System.out.println("departure day is "+departure_day_text);
	}
	
	
	
	public  void print_current_flight_status() {
		
		try {
			
			String flight_status_text = flight_status_delayed.getText();
			System.out.println("The overall status of the flight is "+flight_status_text);
		} catch (Exception e) {
	
			String flight_status_text = flight_status_normal.getText();
			System.out.println("The overall status of the flight is "+flight_status_text);
		}
		
	}

}
