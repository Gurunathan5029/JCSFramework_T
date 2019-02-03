package WebDriverControlClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ParserMain.parser;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class Selectelemantsfromlist extends PageObject {

	PageNavigation page;
	
	static String Pagetitle;
	
	String firstlistitem;
	String Listfirstlevel;
	static String secondlistitem;
	String ListSecondlevel;
	String ListThridlevel;
	static String Selectedtreepath;
	String elementmainpath;
	static String Mainmenu;
	static String Subpath;
	String Page;
	static String NextList = "/div";
	static String Childpath;
	static String DisplayPath;
	static String ConditionElementPath;
	HashMap<String, WebElement> menuitems = new HashMap<String, WebElement>();
	HashMap<String, String> menuItemsPath = new HashMap<String, String>();
	parser parse = new parser();
	public WebElement employeevaluesselection(String value, WebElement element) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> listvalues = new ArrayList<WebElement>();
		listvalues = element.findElements(By.tagName("li"));

		for (WebElement ele : listvalues) {

			if (ele.findElement(By.tagName("div")).findElement(By.tagName("span")).getText().equals(value)) {
				return ele.findElement(By.tagName("div")).findElement(By.tagName("span"));
			}

		}
		return null;
	}

	public void listitemwait(String path) {
		int size = getDriver().findElements(By.xpath(path)).size();
		for (int j = 1; j <= 100; j++) {
			size = getDriver().findElements(By.xpath(path)).size();
			if (size > 1) {
				break;
			} else {
				waitABit(1000);
			}
		}
	}

	// Parameter - list name // Based on the list name, this will assign the
	// list Paths : Created by GG
	public void parentlistitem(String list) {
		menuItemsPath = parse.listorTableLocator(list, getDriver(), "list");
		Mainmenu = menuItemsPath.get("mainElement");
		Childpath =  menuItemsPath.get("childPath");
		Subpath = menuItemsPath.get("subPath");
		listitemwait(Mainmenu);
	}

	// Parameter - list menu position and value to be selected // Select the
	// specified value on specified menu position: Created by GG
	public HashMap<String, WebElement> TMWMenuListItems(String value, String menu) {
		int size, i;
		if (menu == "first" && menu != null) {
			String ListfirstlevelPath = Mainmenu;
			size = getDriver().findElements(By.xpath(ListfirstlevelPath)).size();
			System.out.println(size);
			for (i = 1; i <= size; i++) {
				Listfirstlevel = ListfirstlevelPath + "[" + i + "]";
				String elementstring = Listfirstlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(elementstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.xpath(elementstring)));
				WebElement mainelement = getDriver().findElement(By.xpath(elementstring));
				waitFor(ExpectedConditions.visibilityOf(mainelement));
				if (getDriver().findElement(By.xpath(elementstring)).getText().trim().equals(value)) {
					firstlistitem = getDriver().findElement(By.xpath(elementstring)).getText();
					menuitems.put(getDriver().findElement(By.xpath(elementstring)).getText(), mainelement);
					DisplayPath = Listfirstlevel + NextList;
					break;
				}
			}
		} else if (menu == "second" && menu != null) {
			String ListSecondlevelPath = Listfirstlevel + Subpath;
			listitemwait(ListSecondlevelPath);
			int subsize = getDriver().findElements(By.xpath(ListSecondlevelPath)).size();
			for (int j = 1; j <= subsize; j++) {
				ListSecondlevel = ListSecondlevelPath + "[" + j + "]";
				String elementsubstring = ListSecondlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(elementsubstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.xpath(elementsubstring)));
				WebElement subelement = getDriver().findElement(By.xpath(elementsubstring));
				waitFor(ExpectedConditions.visibilityOf(subelement));
				if (getDriver().findElement(By.xpath(elementsubstring)).getText().trim().equals(value)) {
					menuitems.put(getDriver().findElement(By.xpath(elementsubstring)).getText(), subelement);
					break;
				}
			}
		}

		else if (menu == "third" && menu != null) {
			String ListThridlevelPath = ListSecondlevel + Subpath;
			int subchildsize = getDriver().findElements(By.xpath(ListThridlevelPath)).size();
			for (int k = 1; k <= subchildsize; k++) {
				String ListThirdlevel = ListThridlevelPath + "[" + k + "]";
				String elementchildsubstring = ListThirdlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(elementchildsubstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.xpath(elementchildsubstring)));
				WebElement childsubelement = getDriver().findElement(By.xpath(elementchildsubstring));
				waitFor(ExpectedConditions.visibilityOf(childsubelement));
				if (getDriver().findElement(By.xpath(elementchildsubstring)).getText().trim().equals(value)) {
					menuitems.put(getDriver().findElement(By.xpath(elementchildsubstring)).getText(), childsubelement);
					DisplayPath = ListThirdlevel + NextList;
					break;
				}
			}
		}
		return menuitems;
	}

	// Parameter - list menu position and value to be selected // Select the
	// specified value on specified menu position: Created by GG
	public HashMap<String, WebElement> TMWMenuListItemsBasedOnCondition(String value, String menu) {
		int size, i;
		if (menu == "first" && menu != null) {
			String ListfirstlevelPath = Mainmenu;
			size = getDriver().findElements(By.xpath(ListfirstlevelPath)).size();
			System.out.println(size);
			for (i = 1; i <= size; i++) {
				Listfirstlevel = ListfirstlevelPath + "[" + i + "]";
				String elementstring = Listfirstlevel + ConditionElementPath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(elementstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.xpath(elementstring)));
				WebElement mainelement = getDriver().findElement(By.xpath(Listfirstlevel + Childpath));
				waitFor(ExpectedConditions.visibilityOf(mainelement));
				if (getDriver().findElement(By.xpath(elementstring)).getText().equals(value)) {
					firstlistitem = getDriver().findElement(By.xpath(Listfirstlevel)).getText();
					menuitems.put(getDriver().findElement(By.xpath(elementstring)).getText(), mainelement);
					DisplayPath = Listfirstlevel + NextList;
					break;
				}
			}
		} else if (menu == "second" && menu != null) {
			String ListSecondlevelPath = Listfirstlevel + Subpath;
			listitemwait(ListSecondlevelPath);
			int subsize = getDriver().findElements(By.xpath(ListSecondlevelPath)).size();
			for (int j = 1; j <= subsize; j++) {
				ListSecondlevel = ListSecondlevelPath + "[" + j + "]";
				String elementsubstring = ListSecondlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(elementsubstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.xpath(elementsubstring)));
				WebElement subelement = getDriver().findElement(By.xpath(elementsubstring));
				waitFor(ExpectedConditions.visibilityOf(subelement));
				if (getDriver().findElement(By.xpath(elementsubstring)).getText().equals(value)) {
					menuitems.put(getDriver().findElement(By.xpath(elementsubstring)).getText(), subelement);
					break;
				}
			}
		}

		else if (menu == "third" && menu != null) {
			String ListThridlevelPath = ListSecondlevel + Subpath;
			int subchildsize = getDriver().findElements(By.xpath(ListThridlevelPath)).size();
			for (int k = 1; k <= subchildsize; k++) {
				String ListThirdlevel = ListThridlevelPath + "[" + k + "]";
				String elementchildsubstring = ListThirdlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(elementchildsubstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.xpath(elementchildsubstring)));
				WebElement childsubelement = getDriver().findElement(By.xpath(elementchildsubstring));
				waitFor(ExpectedConditions.visibilityOf(childsubelement));
				if (getDriver().findElement(By.xpath(elementchildsubstring)).getText().equals(value)) {
					menuitems.put(getDriver().findElement(By.xpath(elementchildsubstring)).getText(), childsubelement);
					DisplayPath = ListThirdlevel + NextList;
					break;
				}
			}
		}
		return menuitems;
	}

	// Parameter - list menu position and value to be selected // Select the
	// specified value on specified menu position: Created by GG
	public HashMap<String, WebElement> TMWMenuListItemsForCSS(String value, String menu) {
		int size, i;
		if (menu == "first" && menu != null) {
			String ListfirstlevelPath = Mainmenu;
			size = getDriver().findElements(By.cssSelector(ListfirstlevelPath)).size();
			System.out.println(size);
			for (i = 1; i <= size; i++) {
				Listfirstlevel = ListfirstlevelPath + ":nth-child(" + i + ")";
				String elementstring = Listfirstlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.cssSelector(elementstring)));
				WebElement mainelement = getDriver().findElement(By.cssSelector(elementstring));
				waitFor(ExpectedConditions.visibilityOf(mainelement));
				if (getDriver().findElement(By.cssSelector(elementstring)).getText().equals(value)) {
					firstlistitem = getDriver().findElement(By.cssSelector(elementstring)).getText();
					menuitems.put(getDriver().findElement(By.cssSelector(elementstring)).getText(), mainelement);
					DisplayPath = Listfirstlevel + NextList;
					break;
				}
			}
		} else if (menu == "second" && menu != null) {
			String ListSecondlevelPath = Listfirstlevel + Subpath;
			listitemwait(ListSecondlevelPath);
			int subsize = getDriver().findElements(By.cssSelector(ListSecondlevelPath)).size();
			for (int j = 1; j <= subsize; j++) {
				ListSecondlevel = ListSecondlevelPath + ":nth-child(" + j + ")";
				String elementsubstring = ListSecondlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementsubstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.cssSelector(elementsubstring)));
				WebElement subelement = getDriver().findElement(By.cssSelector(elementsubstring));
				waitFor(ExpectedConditions.visibilityOf(subelement));
				if (getDriver().findElement(By.cssSelector(elementsubstring)).getText().equals(value)) {
					menuitems.put(getDriver().findElement(By.cssSelector(elementsubstring)).getText(), subelement);
					break;
				}
			}
		}

		else if (menu == "third" && menu != null) {
			String ListThridlevelPath = ListSecondlevel + Subpath;
			int subchildsize = getDriver().findElements(By.cssSelector(ListThridlevelPath)).size();
			for (int k = 1; k <= subchildsize; k++) {
				String ListThirdlevel = ListThridlevelPath + ":nth-child(" + k + ")";
				String elementchildsubstring = ListThirdlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementchildsubstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.cssSelector(elementchildsubstring)));
				WebElement childsubelement = getDriver().findElement(By.cssSelector(elementchildsubstring));
				waitFor(ExpectedConditions.visibilityOf(childsubelement));
				if (getDriver().findElement(By.cssSelector(elementchildsubstring)).getText().equals(value)) {
					menuitems.put(getDriver().findElement(By.cssSelector(elementchildsubstring)).getText(),
							childsubelement);
					DisplayPath = ListThirdlevel + NextList;
					break;
				}
			}
		}
		return menuitems;
	}

	// Parameter - Tree list menu position and value to be selected // Select
	// the specified value on specified Tree menu position: Created by GG
	public HashMap<String, WebElement> TMWTreeListItems(String value, String menu) {
		int size, i;
		if (menu == "first" && menu != null) {
			String Firstlevel = Mainmenu;
			size = getDriver().findElements(By.xpath(Mainmenu)).size();
			for (i = 2; i <= size; i++) {
				Listfirstlevel = Mainmenu + "[" + i + "]";
				String elementstring = Listfirstlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(elementstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.xpath(elementstring)));
				waitFor(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elementstring))));
				if (getDriver().findElement(By.xpath(elementstring)).getText().equals(value)) {
					String treepath = Listfirstlevel + "/div/span[2]";
					WebElement firstelement = getDriver().findElement(By.xpath(treepath));
					firstlistitem = getDriver().findElement(By.xpath(elementstring)).getText();
					menuitems.put(getDriver().findElement(By.xpath(elementstring)).getText(), firstelement);
					DisplayPath = Listfirstlevel + "/ul";
					Selectedtreepath = Listfirstlevel;
					break;
				}
			}
		} else if (menu == "second" && menu != null) {
			String SecondLevel = Listfirstlevel + "/ul/li";
			int subsize = getDriver().findElements(By.xpath(SecondLevel)).size();
			for (int j = 1; j <= subsize; j++) {
				ListSecondlevel = SecondLevel + "[" + j + "]";
				String elementsubstring = ListSecondlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(elementsubstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.xpath(elementsubstring)));
				waitFor(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elementsubstring))));
				if (getDriver().findElement(By.xpath(elementsubstring)).getText().equals(value)) {
					String treepath = ListSecondlevel + "/div/span[2]";
					WebElement subelement = getDriver().findElement(By.xpath(treepath));
					menuitems.put(getDriver().findElement(By.xpath(elementsubstring)).getText(), subelement);
					DisplayPath = ListSecondlevel + "/ul";
					Selectedtreepath = ListSecondlevel;
					break;
				}
			}
		}

		else if (menu == "third" && menu != null) {
			String ThirdLevel = ListSecondlevel + "/ul/li";
			int subchildsize = getDriver().findElements(By.xpath(ThirdLevel)).size();
			for (int k = 1; k <= subchildsize; k++) {
				System.out.println("Answer Above" + Selectedtreepath);
				ListThridlevel = ThirdLevel + "[" + k + "]";
				System.out.println("Answer" + ListThridlevel + ThirdLevel);
				String elementchildsubstring = ListThridlevel + Childpath;
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(elementchildsubstring)));
				waitFor(ExpectedConditions.elementToBeClickable(By.xpath(elementchildsubstring)));
				waitFor(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(elementchildsubstring))));
				if (getDriver().findElement(By.xpath(elementchildsubstring)).getText().equals(value)) {
					String treepath = ListThridlevel + "/div/span[2]";
					WebElement childsubelement = getDriver().findElement(By.xpath(treepath));
					menuitems.put(getDriver().findElement(By.xpath(elementchildsubstring)).getText(), childsubelement);
					DisplayPath = ListThridlevel + "/ul";
					Selectedtreepath = ListThridlevel;
					break;
				}
			}
		} else if (menu == "report" && menu != null) {
			String reportpath = Selectedtreepath + "/ul/li";
			int listofreport = getDriver().findElements(By.xpath(reportpath)).size();
			for (int k = 1; k <= listofreport; k++) {
				String Reportselect = reportpath + "[" + k + "]";
				String Reportelement = Reportselect + "/div/span[2]";
				waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(Reportelement)));
				waitFor(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(Reportelement))));
				if (getDriver().findElement(By.xpath(Reportelement)).getText().equals(value)) {
					WebElement Report = getDriver().findElement(By.xpath(Reportelement));
					menuitems.put(getDriver().findElement(By.xpath(Reportelement)).getText(), Report);
					break;
				}
			}
		}
		return menuitems;
	}

	public String DisplayPathReturn() {
		return DisplayPath;
	}

}
