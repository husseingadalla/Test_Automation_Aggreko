package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_page {
protected WebDriver draaiver;
	
	

	public Base_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

}
