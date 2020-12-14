package playground;

import framework.Library_MQTT;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 
		//	Library_MQTT.wait();
			//Library_MQTT.selecting_first_flight_update_notification();
			Library_MQTT.select_JSON_format();
			
			boolean check_departure_arrival_change =Library_MQTT.notification_message_New_estimated_Departure_arrival_presence_check();
			if (check_departure_arrival_change==true) {
				Library_MQTT.copying_flight_number_adding_to_list();
			}
			else {
				
			}
			
			for (int i = 0; i <15; i++) {
				
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
				
		
	}

}
}
