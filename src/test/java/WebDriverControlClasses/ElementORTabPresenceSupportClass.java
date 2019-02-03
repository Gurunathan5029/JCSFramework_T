package WebDriverControlClasses;

import org.openqa.selenium.WebElement;

import ParserMain.parser;
import net.serenitybdd.core.pages.PageObject;

public class ElementORTabPresenceSupportClass extends PageObject{
	
	PageNavigation page ;
	String Page;
	static String Pagetitle;
	parser parse = new parser();
	static WebElement webelement ;
	//Parameter - Tab name//This Method checks the Tab presence:Created by GG
	public void elementmain(String element)
	{		
		webelement = parse.locator(element, getDriver(),"tab");
		webelement.isDisplayed();
	}
}
