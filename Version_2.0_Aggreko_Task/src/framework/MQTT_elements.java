package framework;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class MQTT_elements {
	
	public static String elements_path = System.getProperty("user.dir")+"\\MQTT_elements";
	
	public static Screen screen_obj = new Screen();
	
	//public static Pattern maximize_screen = new Pattern(elements_path + "\\maximize_screen.PNG").similar(0.7f);
	public static Pattern subscribe_input_to_be_cleared = new Pattern(elements_path + "\\subscribe_input_to_be_cleared.PNG").exact();
	public static Pattern connect_btn = new Pattern(elements_path + "\\connect_btn.PNG").similar(0.7f);
	public static Pattern subscribe_tab = new Pattern(elements_path + "\\subscribe_tab.PNG").similar(0.7f);
	public static Pattern subscribe_btn = new Pattern(elements_path + "\\subscribe_btn.PNG").similar(0.7f);
	public static Pattern connection_success = new Pattern(elements_path + "\\connection_success.PNG").exact();
	public static Pattern autoscroll_btn = new Pattern(elements_path + "\\autoscroll_btn.PNG").exact();
	public static Pattern broker_profile_select = new Pattern(elements_path + "\\broker_profile_select.PNG").exact();
	public static Pattern LH_Notifications = new Pattern(elements_path + "\\LH_Notifications.PNG").exact();
	public static Pattern Topic_input_field_after_clear = new Pattern(elements_path + "\\Topic_input_field_after_clear.PNG").similar(0.7f);
	public static Pattern desktop = new Pattern(elements_path + "\\desktop.PNG").similar(0.6);
	public static Pattern flight_update_notificaction_base = new Pattern(elements_path + "\\flight_update_notificaction_base.PNG").exact();
	public static Pattern flight_update_notificaction_selected = new Pattern(elements_path + "\\flight_update_notificaction_selected.PNG").exact();
	public static Pattern New_estimated_arrival = new Pattern(elements_path + "\\New_estimated_arrival.PNG").exact();
	public static Pattern New_estimated_departure = new Pattern(elements_path + "\\New_estimated_departure.PNG").exact();
	public static Pattern flight_number_text = new Pattern(elements_path + "\\flight_number_text.PNG").similar(0.7f);
	public static Pattern flight_number = new Pattern(elements_path + "\\flight_number.PNG").similar(0.6f);
	public static Pattern Json_Format = new Pattern(elements_path + "\\Json_Format.PNG").similar(0.7f);
	public static Pattern plain_text = new Pattern(elements_path + "\\plain_text.PNG").similar(0.7f);
	public static Pattern Base_64 = new Pattern(elements_path + "\\Base_64.PNG").similar(0.7f);
	public static Pattern Hex_format = new Pattern(elements_path + "\\Hex_format.PNG").similar(0.7f);
	public static Pattern sparkplug_decoder = new Pattern(elements_path + "\\sparkplug_decoder.PNG").similar(0.7f);
	public static Pattern notification_update_01 = new Pattern(elements_path + "\\notification_update_01.PNG").exact();
	public static Pattern notification_update_02 = new Pattern(elements_path + "\\notification_update_02.PNG").exact();

}
