package WebDriverControlClasses;

import org.openqa.selenium.WebElement;

import ParserMain.parser;
import SupportLibraryClasses.ExcelHandling;

import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;

public class LabelSupportClass extends PageObject {
	String Page;	
	ExcelHandling Result = new ExcelHandling();
	WebElement element;
	static String Pagetitle;
	parser parse = new parser();

	// Compare label actual value with Expected value: Created by GG
	public void Labelcompare(WebElement element, String Expected) {
		String Actual = element.getText().toString();
		if(Actual.isEmpty())
		{
			Actual = element.getAttribute("value").toString();
		}
		Assert.assertEquals("Expected text presence verification", Expected.trim(), Actual.trim());		
	}

	// Compare label actual value with Expected attribute value: Created by GG
	public void LabelcompareAttributevalue(String label, String css, WebElement element, String Expected) {
		String Actual = element.getAttribute(css).toString();
		Assert.assertEquals("Expected text presence verification", Expected.trim(), Actual.trim());		
	}

	// Parameters - Label element name and Expected Label Value: Created by GG
	public void labelverifymain(String ele, String Expected) {
		element = parse.locator(ele, getDriver(), "label");
		Labelcompare(element, Expected);
	}
}
