package WebDriverControlClasses;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ParserMain.parser;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class TableGridSupportClass extends PageObject {

	PageNavigation page;
	
	ButtonSupportClass button;
	String Page;
	static String ElementSelection;
	static String Pagetitle;
	static String valueitem;
	static String childpath;
	static String selection;
	HashMap<String, String> tableItemsPath = new HashMap<String, String>();
	parser parse = new parser();

	// Parameter - Table Header Name //This will select the table header element
	// based on Header name : Created by GG
	public void Tablegridparentselection(String Header) {
		tableItemsPath = parse.listorTableLocator(Header, getDriver(), "table");
		ElementSelection = tableItemsPath.get("mainElement");
		childpath = tableItemsPath.get("childPath");
		selection = tableItemsPath.get("subPath");
		waitforgridsize(ElementSelection);
	}

	public void waitforgridsize(String elementpath) {
		int size = getDriver().findElements(By.xpath(elementpath)).size();
		for (int k = 1; k < 200; k++) {
			if (size <= 1) {
				System.out.println(size + ElementSelection);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				size = getDriver().findElements(By.xpath(ElementSelection)).size();
			} else {
				break;
			}
		}
	}

	// Parameter -Value to be selected in the table // This will select the value in
	// specified table : Created by GG
	public WebElement TableGridmain(String value) {
		System.out.println(ElementSelection);
		int size = getDriver().findElements(By.xpath(ElementSelection)).size();
		System.out.println(size + ElementSelection);
		for (int i = 1; i <= size; i++) {
			String elementpath = ElementSelection + "[" + i + "]/td";
			int cellsize = getDriver().findElements(By.xpath(elementpath)).size();
			System.out.println(cellsize + elementpath);
			for (int j = 1; j <= cellsize; j++) {
				String cellpath = elementpath + "[" + j + "]";
				WebElement cellelement = getDriver().findElement(By.xpath(cellpath));
				System.out.println(cellelement.getText() + "    " + value);
				if (cellelement.getText().trim().equals(value.trim())) {
					return cellelement;
				}
			}
		}
		return null;
	}

	// Parameter -Value to be clicked in the table // This will click the value in
	// specified table : Created by GG
	public WebElement TableGridSelectmain(String value) {
		System.out.println(ElementSelection);
		int size = getDriver().findElements(By.xpath(ElementSelection)).size();
		System.out.println(size + ElementSelection);
		for (int i = 1; i <= size; i++) {
			String elementpath = ElementSelection + "[" + i + "]";
			System.out.println(elementpath);
			WebElement cellelement = getDriver().findElement(By.xpath(elementpath + selection));
			System.out.println(cellelement.getText() + value);
			if (cellelement.getText().trim().equals(value.trim())) {
				System.out.println("Third" + elementpath + childpath);
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(elementpath + childpath)));
				waitFor(ExpectedConditions.elementToBeClickable(By.xpath(elementpath + childpath)));
				WebElement element = getDriver().findElement(By.xpath(elementpath + childpath));
				return element;
			}
		}
		return null;
	}
}
