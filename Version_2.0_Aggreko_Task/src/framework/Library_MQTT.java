package framework;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.*;
import java.awt.datatransfer.DataFlavor;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;


public class Library_MQTT extends MQTT_elements {
	public static ArrayList<String> list = new ArrayList<String>();
	
public static void launch_MQTTFX(String Destination_path){
	
	try {
		Runtime.getRuntime().exec(Destination_path+"\\mqttfx.exe");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
}	

public static void wait(int time) {
	try {
		Thread.sleep(time*1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}

public static boolean check_element_presence (String element_name, int wait_period_seconds) {
	
	Pattern element_obj  = new Pattern(elements_path + "\\"+element_name+".PNG").exact();
	  
	  try {
		  screen_obj.wait(element_obj,wait_period_seconds);
		screen_obj.find(element_obj);
		
		return true;
	} catch (FindFailed e) {
		return false;
	}
				
}
	
/*public static void click_maximize_screen()   {
		
		
		try {
			//screen_obj.wait(maximize_screen,10);
		//	screen_obj.find(maximize_screen);
		//	screen_obj.click(maximize_screen);
		} catch (FindFailed e) {
			
			e.printStackTrace();
		}
	
}*/

public static void click_broker_select_menu()   {
	
	
	try {
		screen_obj.wait(broker_profile_select,10);
		screen_obj.find(broker_profile_select);
		screen_obj.click(broker_profile_select);
	} catch (FindFailed e) {
		
		e.printStackTrace();
	}

}

public static void click_1()   {
	
	
	try {
		screen_obj.wait(desktop,10);
		screen_obj.find(desktop);
		screen_obj.click(desktop);
	} catch (FindFailed e) {
		
		e.printStackTrace();
	}

}

public static void select_LH_Notifications_broker()    {
	
	boolean check_LH_notification = Library_MQTT.check_element_presence("LH_Notifications",3);
	if (check_LH_notification==false) {
		Library_MQTT.click_broker_select_menu();
		try {
			screen_obj.wait(LH_Notifications,4);
			screen_obj.find(LH_Notifications);
			screen_obj.click(LH_Notifications);
		} catch (FindFailed e) {
			System.out.println("Please make the broker name LH_Notifications");
		}
				
	}
	else {
		
	}
	
}



	
	public static void click_connect()   {
		
		
		try {
			screen_obj.wait(connect_btn,60*3);
			screen_obj.find(connect_btn);
			screen_obj.click(connect_btn);
		} catch (FindFailed e) {
			
			e.printStackTrace();
		}
	
}
	
	
public static void click_subscribe_btn()   {
		
		
		try {
			screen_obj.wait(subscribe_btn,4);
			screen_obj.find(subscribe_btn);
			screen_obj.click(subscribe_btn);
		} catch (FindFailed e) {
			
			e.printStackTrace();
		}
	
}

public static void click_subscribe_tab()   {
	
	
	try {
		screen_obj.wait(subscribe_tab,4);
		screen_obj.find(subscribe_tab);
		screen_obj.click(subscribe_tab);
	} catch (FindFailed e) {
		
		e.printStackTrace();
	}

}


public static void disable_autoscroll()   {
	
	
	try {
		screen_obj.wait(autoscroll_btn,4);
		screen_obj.find(autoscroll_btn);
		screen_obj.click(autoscroll_btn);
	} catch (FindFailed e) {
		
		e.printStackTrace();
	}

}

public static void clear_subscribe_topic_input()  {
	try {
		screen_obj.wait(subscribe_input_to_be_cleared,10);
		screen_obj.find(subscribe_input_to_be_cleared);
		screen_obj.click(subscribe_input_to_be_cleared);
	} catch (FindFailed e) {
		
		e.printStackTrace();
	}
	
	Robot robot;
	try {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_A);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_DELETE);
	} catch (AWTException e) {
		
		e.printStackTrace();
	}
	
}


public static void type_topic_to_be_subscribed()  {
	
	try {
		screen_obj.wait(Topic_input_field_after_clear,10);
		screen_obj.find(Topic_input_field_after_clear);
		screen_obj.type(Topic_input_field_after_clear,"prd/FlightUpdate/LH/#");
	} catch (FindFailed e) {
		
		e.printStackTrace();
	}
	
}

public static void type_topic_to_be_subscribed_with_current_date()  {
	long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis);  
	
	try {
		screen_obj.wait(Topic_input_field_after_clear,10);
		screen_obj.find(Topic_input_field_after_clear);
		screen_obj.type(Topic_input_field_after_clear,"prd/FlightUpdate/LH/+/"+date);
	} catch (FindFailed e) {
		
		e.printStackTrace();
	}
	
}


public static void select_JSON_format()    {
	
	boolean check_Json_Format= Library_MQTT.check_element_presence("Json_Format",4);
	if (check_Json_Format==false) {
		boolean check_plain_text= Library_MQTT.check_element_presence("plain_text",4);
		if (check_plain_text==false) {
			boolean check_Base_64= Library_MQTT.check_element_presence("Base_64",4);
			if (check_Base_64==false) {
				boolean check_Hex_format= Library_MQTT.check_element_presence("Hex_format",4);
				if (check_Hex_format==false) {
					boolean check_sparkplug_decoder= Library_MQTT.check_element_presence("sparkplug_decoder",4);
					if (check_sparkplug_decoder==true) {
						try {
							screen_obj.wait(sparkplug_decoder,4);
							screen_obj.find(sparkplug_decoder);
							screen_obj.click(sparkplug_decoder);
							screen_obj.wait(Json_Format,2);
							screen_obj.find(Json_Format);
							screen_obj.click(Json_Format);
						} catch (FindFailed e) {
							
							e.printStackTrace();
						}
					}
				}
				else {
					try {
						screen_obj.wait(Hex_format,4);
						screen_obj.find(Hex_format);
						screen_obj.click(Hex_format);
						screen_obj.wait(Json_Format,4);
						screen_obj.find(Json_Format);
						screen_obj.click(Json_Format);
					} catch (FindFailed e) {
						
						e.printStackTrace();
					}
				}
			}
			else {
				try {
					screen_obj.wait(Base_64,4);
					screen_obj.find(Base_64);
					screen_obj.click(Base_64);
					screen_obj.wait(Json_Format,4);
					screen_obj.find(Json_Format);
					screen_obj.click(Json_Format);
				} catch (FindFailed e) {
					
					e.printStackTrace();
				}
			}
			
		}	
		
		else {
			

			try {
				screen_obj.wait(plain_text,4);
				screen_obj.find(plain_text);
				screen_obj.click(plain_text);
				screen_obj.wait(Json_Format,4);
				screen_obj.find(Json_Format);
				screen_obj.click(Json_Format);
			} catch (FindFailed e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	
}

public static void copying_flight_number_adding_to_list()  {
	

	try {
		screen_obj.wait(flight_number,10);
		screen_obj.find(flight_number);
		screen_obj.doubleClick(flight_number);
	} catch (FindFailed e) {
		
		e.printStackTrace();
	}
	Robot robot;
	try {
		
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_C);
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.keyRelease(KeyEvent.VK_C);
		

	} catch (AWTException e) {
		
		e.printStackTrace();
	}
	

	Toolkit toolkit = Toolkit.getDefaultToolkit();
    Clipboard clipboard = toolkit.getSystemClipboard();
    String result;
	try {
		result = (String) clipboard.getData(DataFlavor.stringFlavor);
	    list.add(result);
	} catch (UnsupportedFlavorException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
}


public static void pasting_flight_number()  {
	
	Robot robot;
	try {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
	} catch (AWTException e) {
		
		e.printStackTrace();
	}
		 
}


public static void selecting_next_flight_update_notification() {
	
	try {
		screen_obj.wait(flight_update_notificaction_selected,10);
		screen_obj.find(flight_update_notificaction_selected);
		screen_obj.click(flight_update_notificaction_selected);
	} catch (FindFailed e) {
		
		e.printStackTrace();
	}
	Robot robot;
	try {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		 robot.keyRelease(KeyEvent.VK_DOWN);
	} catch (AWTException e) {
		
		e.printStackTrace();
	}
}


public static void selecting_first_flight_update_notification() {
	
	try {
		screen_obj.wait(flight_update_notificaction_base,60*5);
		screen_obj.find(flight_update_notificaction_base);
		screen_obj.click(flight_update_notificaction_base);
	} catch (FindFailed e) {
		
		e.printStackTrace();
	}
	
}

public static boolean notifications_update_still_exist() {
	
	boolean new_notification_pattern_01 =Library_MQTT.check_element_presence("notification_update_01",3);
	boolean new_notification_pattern_02 =Library_MQTT.check_element_presence("notification_update_02",3);
	boolean notification_update_exist = new_notification_pattern_01 || new_notification_pattern_02;
	return notification_update_exist;
}

public static boolean notification_message_New_estimated_Departure_arrival_presence_check() {
	
	boolean new_estimated_arrival =Library_MQTT.check_element_presence("New_estimated_arrival",2);
	boolean New_estimated_departure =Library_MQTT.check_element_presence("New_estimated_departure",2);
	boolean notification_departure_arrival_change_exist = New_estimated_departure ||new_estimated_arrival;
	return notification_departure_arrival_change_exist;
}

public static int check_list_size() {
	
	int size_list = list.size();
	return size_list;
}

public static void print_list_of_flight_numbers() {
	/*for(int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));
    }*/
	
	System.out.println(Arrays.toString(list.toArray()));
	
}

public static boolean check_app_launch() {
	
	boolean app_launched = Library_MQTT.check_element_presence("connect_btn",120);
	if (app_launched==true) {
		System.out.println("MQTT.FX is launched successfully");
	return app_launched;	
	
	}
	else {
		System.out.println("MQTT.FX didnot launch successfully");
		return app_launched;
	}
	
}

public static boolean check_connection_is_connected_to_broker() {
	
	boolean broker_connected = Library_MQTT.check_element_presence("connection_success",60);
	if (broker_connected==true) {
		System.out.println("MQTT.FX is connected successfully");
		return broker_connected;
		
	
	}
	else {
		System.out.println("MQTT.FX didnot connect successfully");
		return broker_connected;
	}
	
}

public static boolean check_LH_Notifications_broker_selected() {
	
	boolean broker_selected = Library_MQTT.check_element_presence("LH_Notifications",60);
	if (broker_selected==true) {
		System.out.println("LH_Notifications is selected successfully");
		return broker_selected;
		
	
	}
	else {
		System.out.println("Please select LH_Notifications broker profile");
		return broker_selected;
	}
	
}


}




