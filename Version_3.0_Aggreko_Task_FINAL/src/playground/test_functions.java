package playground;

import java.io.IOException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.sikuli.script.FindFailed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import framework.Library_MQTT;


public class test_functions extends Library_MQTT {

	public static void main(String[] args) throws FindFailed, UnsupportedFlavorException, IOException {
	//Library_MQTT.select_JSON_format();
		
		/*
	        String[] newShortMonths = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN",
	            "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	       
	        
	        DateFormatSymbols symbols = new DateFormatSymbols();
	       
	        symbols.setShortMonths(newShortMonths);
	        

	        
	        DateFormat format = new SimpleDateFormat("dd MMM yyyy", symbols);
	        System.out.println(format.format(new Date()));
*/
	      
	//Library_MQTT.launch_MQTTFX();
//	Library_MQTT.wait(10);
	//Library_MQTT.click_maximize_screen();
	//boolean check_LH_notification = Library_MQTT.check_element_presence("LH_Notifications");
	//if (check_LH_notification==false) {
		
		//Library_MQTT.click_broker_select_menu();
		//Library_MQTT.click_LH_Notifications();
		
	//}

	//Library_MQTT.click_1();
		//Library_MQTT.clear_subscribe_topic_input();
	//Library_MQTT.type_topic_to_be_subscribed("Hussein");
	//Library_MQTT.click_autoscroll();
		
		String MQTT_FX_target_path = "C:\\Users\\hussein.gadallah\\AppData\\Local\\Programs\\mqttfx";
		int number_of_notifications_to_be_considered = 19;
		int period_of_time_to_wait_till_start_notifications_check = 30*5;
		
		Library_MQTT.launch_MQTTFX(MQTT_FX_target_path);
		boolean check_app_launch =Library_MQTT.check_app_launch();
		if (check_app_launch==true) {
			Library_MQTT.select_LH_Notifications_broker();
			boolean check_LH_Notifications_selected = Library_MQTT.check_LH_Notifications_broker_selected();
			if (check_LH_Notifications_selected==true) {
				Library_MQTT.click_connect();
				   boolean check_connection_broker = Library_MQTT.check_connection_is_connected_to_broker();
				   if (check_connection_broker==true) {
					   Library_MQTT.click_subscribe_tab();
						Library_MQTT.clear_subscribe_topic_input();
						Library_MQTT.type_topic_to_be_subscribed_with_current_date();
						Library_MQTT.click_subscribe_btn();
						Library_MQTT.disable_autoscroll();
						Library_MQTT.wait(period_of_time_to_wait_till_start_notifications_check);
						Library_MQTT.selecting_first_flight_update_notification();
						Library_MQTT.select_JSON_format();
						
						boolean check_departure_arrival_change =Library_MQTT.notification_message_New_estimated_Departure_arrival_presence_check();
						if (check_departure_arrival_change==true) {
							Library_MQTT.copying_flight_number_adding_to_list();
						}
						else {
							
						}
						
						for (int i = 0; i < number_of_notifications_to_be_considered; i++) {
							
							Library_MQTT.selecting_next_flight_update_notification();
							boolean check_arrival_departure_change =Library_MQTT.notification_message_New_estimated_Departure_arrival_presence_check();
							if (check_arrival_departure_change==true) {
								Library_MQTT.copying_flight_number_adding_to_list();
							}
							else {
								
							}
							
						}
						
						
						int list_new_departure_arrival_size= Library_MQTT.check_list_size();
						if (list_new_departure_arrival_size<1) {
							System.out.println("No new changes in departure or arrival at the moment");
						}
						else {
							System.out.println("The number of changed_arrival_departure_flights is "+list_new_departure_arrival_size);
							System.out.println("The flight numbers are");
							Library_MQTT. print_list_of_flight_numbers();
							// aktb kol code bt3 website hena
							/*
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

						*/	
						}		
			}
			else {
				System.out.println("please select LH_Notifications broker profile");
			}		
		}
			
		   else {
			System.out.println("The connection to broker failed");
		}
			
		}
		
		else {
			System.out.println("The MQTT.FX app did not open correctly");
		}
}
	
}


/*
home_obj.search_by_flight_number(drivver);
flight_details_obj.print_departing_airport(drivver);
flight_details_obj.print_arriving_airport();
flight_details_obj.print_arriving_day();
flight_details_obj.print_departure_day();
flight_details_obj.print_departing_time();
flight_details_obj.print_arriving_time();
flight_details_obj.print_current_flight_status();
boolean check_late_early=flight_details_obj.check_destination_arrival_late_early_present();
Assert.assertEquals(check_late_early,true);

*/
