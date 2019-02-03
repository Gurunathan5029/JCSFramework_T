package WebDriverControlClasses;

import org.openqa.selenium.WebElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import ParserMain.parser;
import SupportClasses.ActionClass;
import net.serenitybdd.core.pages.PageObject;

public class ButtonSupportClass extends PageObject {
	PageNavigation page;
	String Page;
	static String Pagetitle;
	WebElement buttonelement;
	ActionClass action;
	parser parse = new parser();

	// Click on a button using action class : Created by GG
	public void buttonclick(WebElement element) {
		action.movetoelement(element);
		element.click();
	}

	// Parameter - *button* name //Method find the currently Opened up page and
	// interact with PO Class to perform actions over button: Created by GG
	public void buttonmain(String element) {
		try {
			buttonelement = parse.locator(element, getDriver(),"button");
			buttonclick(buttonelement);
		} catch (JsonSyntaxException | JsonIOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}

}
