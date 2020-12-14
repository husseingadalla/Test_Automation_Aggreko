package test_cases;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import framework.Library_MQTT;
import pages.Home_page;
import pages.Flight_details_page;

public class Test_cases_consistency_check extends Base_Tests {
	
	String MQTT_FX_target_path = "C:\\Users\\hussein.gadallah\\AppData\\Local\\Programs\\mqttfx";
	int number_of_notifications_to_be_considered = 19;
	int period_of_time_to_wait_till_start_notifications_check = 60*5;
	
	Home_page home_obj ;
	Flight_details_page flight_details_obj;
	
	
	
	@Test(priority = 1)
	public void validate_early_late_departure_arrival() {
		
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
							Assert.assertEquals(false,true);
						}
						
						else {
							
							
							drivver=new FirefoxDriver();
							drivver.navigate().to("https://uk.flightaware.com");
							
							home_obj=new Home_page(drivver);
							flight_details_obj=new Flight_details_page(drivver);
							
							home_obj.search_by_flight_number(drivver);
							flight_details_obj.print_departing_airport(drivver);
							flight_details_obj.print_arriving_airport();
							flight_details_obj.print_arriving_day();
							flight_details_obj.print_departure_day();
							flight_details_obj.print_departing_time();
							flight_details_obj.print_arriving_time();
							flight_details_obj.print_current_flight_status();
							boolean check_late_early=flight_details_obj.check_destination_arrival_late_early_present();
							
							System.out.println("The number of changed_arrival_departure_flights is "+list_new_departure_arrival_size);
							
							Assert.assertEquals(check_late_early,true);
							
						}		
					}
					else {
						System.out.println("please select LH_Notifications broker profile");
						Assert.assertEquals(false,true);
					}		
				}
					
				   else {
					System.out.println("The connection to broker failed");
					Assert.assertEquals(false,true);
				}
					
				}
				
				else {
					System.out.println("The MQTT.FX app did not open correctly");
					Assert.assertEquals(false,true);
				}
		}
			
		}

						
						
		
		
		
	
		
		
		
		
	









