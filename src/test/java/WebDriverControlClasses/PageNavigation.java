package WebDriverControlClasses;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import ParserMain.parser;
import SupportLibraryClasses.ExcelHandling;
import SupportLibraryClasses.PropertyFileHandling;
import net.serenitybdd.core.pages.PageObject;

public class PageNavigation extends PageObject {
	
	static String Application;
	WebElement formelement;
	WebElement pageelement;
	String Page;
	Object page;
	Object Login;
	static parser parse;
	ExcelHandling Report = new ExcelHandling();
	static WebDriver pageDriver;
	static WebDriverWait wait;
	PropertyFileHandling prop = new PropertyFileHandling();
	// Parameter - Application Name // Launch the URL based on application name :
	// Created by GG
	public void launchURL(String value) {
		switch (value) {
		case "AMS":
			getDriver().get(prop.getProperty("webdriver.base.url").trim());
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			Application = value;
		}
	}

	// Return Application Name: Created by GG
	public String Applicationname() {
		return Application;
	}

	// Return Application page title: Created by GG
	public String ApplicationPage() {
		System.out.println(getDriver().getTitle().toString().trim());
		return getDriver().getTitle().toString().trim();
	}

	// Return Application page title: Created by GG
	public String ApplicationPage(WebDriver driver) {
		pageDriver = driver;
		System.out.println(pageDriver.getTitle().toString().trim());
		return pageDriver.getTitle().toString().trim();
	}

	// Parameter - Expected Page name //Compare actaul page title with expected page
	// title: Created by GG
	public void assertpagedisplay(String expected) {
		String page = ApplicationPage();
		Assert.assertEquals(expected.toUpperCase().trim(), page.toUpperCase().trim());

	}

	// Verify the user is logged in to Application : Created by GG
	public void loggedintoAppVerify(String pagename) {
		String Application = Applicationname();
		switch (Application) {
		case "AMS": {
			try {
				parse = new parser();
				pageelement = parse.locator("tmwLogo", pageDriver, "logo");
				System.out.println(pageDriver.toString()+pageelement.toString());
				pageelement.isDisplayed();
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				System.out.println("Check");
			}
			break;
		}
		}
	}

	public void Pageverification(String pagename) {
		String Application = Applicationname();
		waitForPageLoad(pageDriver);
		switch (Application) {
		case "AMS": {			
			assertpagedisplay(pagename);
		}
		}

	}

	public void waitForPageLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		wait = new WebDriverWait(driver, 1000);
		wait.until(pageLoadCondition);
	}
}