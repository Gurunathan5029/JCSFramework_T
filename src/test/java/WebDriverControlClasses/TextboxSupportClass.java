package WebDriverControlClasses;

import org.openqa.selenium.WebElement;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import ParserMain.parser;
import SupportClasses.ActionClass;
import SupportClasses.Robotclass;
import SupportLibraryClasses.ExcelHandling;
import net.serenitybdd.core.pages.PageObject;

public class TextboxSupportClass extends PageObject {	
	String Page;
	ActionClass action;
	Robotclass robot;
	static String Pagetitle;
	static WebElement webelement;
	WebElement textboxelement;
	static WebElement ele;
	parser parse = new parser();
	ExcelHandling Report = new ExcelHandling();

	// Parameter - Textbox name // Clear the Textbox Values: Created by GG
	public void cleartextbox(WebElement textbox) {
		if (textbox.getText() != null) {
			textbox.clear();
		}
	}

	// Parameter - Textbox name // Click on the Textbox : Created by GG
	public void clicktextbox(WebElement textbox) {
		textbox.click();
	}

	// Parameter - Textbox Name and Value to be entered // This will enter the
	// specified value in specified Textbox: Created by GG
	public void textboxmain(String element, String value) {
		try {
			textboxelement = parse.locator(element, getDriver(),"textbox");
			entertextboxvalue(textboxelement, value);
		} catch (JsonSyntaxException | JsonIOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

	}

	// Parameter - Textbox name and Value // Textbox value will be entered : Created
	// by GG
	public void entertextboxvalue(WebElement textbox, String value) {
		System.out.println(textbox + value);
		clicktextbox(textbox);
		System.out.println("AfterClick" + textbox + value);
		cleartextbox(textbox);
		System.out.println("AfterClear" + textbox + value);
		textbox.sendKeys(value);
	}

	public void TextBoxArrow(WebElement element, int value) {
		while (value > 0) {
			action.movetoelement(element);
			element.click();
			System.out.println("AfterClick" + value);
			value = value - 1;
		}
	}

	// Return the Text box Value : Created by GG
	public String gettextboxvalue(String element) {
		textboxelement = parse.locator(element, getDriver(),"textbox");
		String txtValue =  textboxelement.getText();
		 if(txtValue.isEmpty())
			{
			 txtValue = textboxelement.getAttribute("value").toString();
			}
		 return txtValue;
	}
}
