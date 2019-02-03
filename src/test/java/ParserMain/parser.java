package ParserMain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.PageObject;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import Pages.Pages;
import WebDriverControlClasses.PageNavigation;
import net.thucydides.core.annotations.DefaultUrl;

public class parser {
	WebDriverWait driverWait;
	WebDriver localDriver;
	PageNavigation page = new PageNavigation();
	HashMap<String, String> hash = new HashMap<String, String>();

	public BufferedReader jsonString() throws FileNotFoundException {
		String filename = "";
		String Page = page.Applicationname().trim();
		switch (Page) {
		case "XX":
			String title = page.ApplicationPage(localDriver);
			switch (title) {
			case "Login":
				filename = "src\\test\\java\\Pages\\XX\\loginPage.json";
				break;			
			
			}
		}
		BufferedReader br = new BufferedReader(new FileReader(filename));
		return br;

	}

	public WebElement locator(String element, WebDriver driver, String type) {
		localDriver = driver;
		driverWait = new WebDriverWait(localDriver, 1000);
		Gson gson = new Gson();
		Pages[] page = null;
		try {
			page = gson.fromJson(jsonString(), Pages[].class);
		} catch (Exception e) {
			String ex = e.toString();
		}
		for (Pages p1 : page) {
			System.out.println(p1.name);
			if (p1.name.equalsIgnoreCase(element)) {
				if (type.equals("button")) {
					return webElementClickableLocator(pathCreator(p1.locatorType, p1.value));
				} else {
					return webElementLocator(pathCreator(p1.locatorType, p1.value));
				}
			}
		}
		return null;
	}

	public HashMap<String, String> listorTableLocator(String element, WebDriver driver, String type) {
		localDriver = driver;
		driverWait = new WebDriverWait(localDriver,10);
		Gson gson = new Gson();
		Pages[] page = null;
		try {
			page = gson.fromJson(jsonString(), Pages[].class);
		} catch (Exception e) {
			String ex = e.toString();
		}
		for (Pages p1 : page) {
			System.out.println(p1.name);
			if (p1.name.equalsIgnoreCase(element)) {
				hash.put("mainElement", p1.value);
				hash.put("childPath", p1.childPath);
				hash.put("subPath", p1.subPath);
			}
		}
		return hash;
	}

	public static By pathCreator(String identifierType, String value) {
		By path = null;
		switch (identifierType) {
		case "id":
			path = By.id(value);
			break;
		case "name":
			path = By.name(value);
			break;
		case "linkText":
			path = By.linkText(value);
			break;
		case "xpath":
			path = By.xpath(value);
			break;
		case "css":
			path = By.cssSelector(value);
			break;
		}
		return path;

	}

	public WebElement webElementLocator(By byPath) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(byPath));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(byPath));
		WebElement ele = localDriver.findElement(byPath);
		return ele;

	}

	public WebElement webElementClickableLocator(By byPath) {
		driverWait.until(ExpectedConditions.presenceOfElementLocated(byPath));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(byPath));
		driverWait.until(ExpectedConditions.elementToBeClickable(byPath));
		WebElement ele = localDriver.findElement(byPath);
		return ele;

	}

}
