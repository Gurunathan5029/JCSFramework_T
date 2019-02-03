package Steps;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import SupportClasses.ActionClass;
import SupportLibraryClasses.ExcelHandling;
import SupportLibraryClasses.ExcelHandling.status;
import WebDriverControlClasses.ButtonSupportClass;
import WebDriverControlClasses.CompareUtilitySupportClass;
import WebDriverControlClasses.DragAndDropSupportClass;
import WebDriverControlClasses.ElementORTabPresenceSupportClass;
import WebDriverControlClasses.LabelSupportClass;
import WebDriverControlClasses.PageNavigation;
import WebDriverControlClasses.Selectelemantsfromlist;
import WebDriverControlClasses.TableGridSupportClass;
import WebDriverControlClasses.TextboxSupportClass;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CommonSteps extends ScenarioSteps {
	PageNavigation page;
	ButtonSupportClass button;
	
	TableGridSupportClass table;
	LabelSupportClass labelverify;
	TextboxSupportClass TSC;
	ElementORTabPresenceSupportClass elementortab;
	ExcelHandling report = new ExcelHandling();
	String Parentwindow;
	Selectelemantsfromlist select;
	HashMap<String,WebElement> menuitemsops = new HashMap<String,WebElement>();
	ActionClass amsaction;
	CompareUtilitySupportClass compare;
	DragAndDropSupportClass dragdrop;
	repairOrderMain repair;
	
	File e = new File ("C:\\tr.png");
	static WebElement first;
	static WebElement second;
	static WebElement third;
	//Parameter - Application Name //This launches the Application URL: Created by GG
	@Step
	public void opens_home_page(String value) throws IOException {		
		page.launchURL(value);
		getDriver().manage().window().maximize();		
		if (getDriver().getTitle().equals("Login")) {
			report.resultstatus("URL launching", "Url is Launched Succefully", status.Pass);
		} else {
			report.resultstatus("URL launching", "Url is not Launched Succefully", status.Fail);
		}
	}
	//Parameter - Textbox name and Value // This enter textbox with specified value : Created by GG
	@Step
	public void Entertextboxvalue(String textbox,String value)
	{
		TSC.textboxmain(textbox, value);	
		
	}

//Parameter - Menu Hub Name //This clicks on the Menu hub and set as parent for rest of list operations: Created by GG	
	@Step
	public void Menuhubclick(String value)
	{
	
		select.parentlistitem(value);
	}
	
//Parameter - list value// This select the value from first list menu item : Created  by GG	
	@Step
	public void listitemselection(String value)
	{
		menuitemsops = select.TMWMenuListItems(value,"first");
		amsaction.movetoelement(menuitemsops.get(value));
		amsaction.clickonthelement(menuitemsops.get(value));
	}
	
	@Step
	public void listitemselectionForCondtionalValue(String value)
	{
		menuitemsops = select.TMWMenuListItemsBasedOnCondition(value,"first");
		amsaction.movetoelement(menuitemsops.get(value));
		amsaction.clickonthelement(menuitemsops.get(value));
	}
	//Parameter - list value// This select the value from first list menu item : Created  by GG	
		@Step
		public void listitemselectionCSS(String value)
		{
			menuitemsops = select.TMWMenuListItemsForCSS(value,"first");
			amsaction.movetoelement(menuitemsops.get(value));
			amsaction.clickonthelement(menuitemsops.get(value));
		}
	
	//Parameter - list value// This select the value from first list tree menu item : Created  by GG		
	@Step
	public void FirstTreeitemselection(String value)
	{
		menuitemsops = select.TMWTreeListItems(value,"first");
		if(!select.DisplayPathReturn().equals("NULL"))
		{
		WebElement element = getDriver().findElement(By.xpath(select.DisplayPathReturn()));
		
		if(element.getCssValue("display").equals("none"))
		{
		
		amsaction.movetoelement(menuitemsops.get(value));
		amsaction.clickonthelement(menuitemsops.get(value));
		}
		}
		else
		{
			amsaction.movetoelement(menuitemsops.get(value));
			amsaction.clickonthelement(menuitemsops.get(value));
		}
	}
	
	//Parameter - list value// This select the value from second list tree menu item : Created  by GG		
	@Step
	public void SecondTreeitemselection(String value)
	{
		menuitemsops = select.TMWTreeListItems(value,"second");
		if(!select.DisplayPathReturn().equals("NULL"))
		{
		WebElement element = getDriver().findElement(By.xpath(select.DisplayPathReturn()));		
		if(element.getCssValue("display").equals("none"))
		{
		amsaction.movetoelement(menuitemsops.get(value));
		amsaction.clickonthelement(menuitemsops.get(value));
		}
		}
		else
		{
			amsaction.movetoelement(menuitemsops.get(value));
			amsaction.clickonthelement(menuitemsops.get(value));
		}
	}
	
	//Parameter - list value// This select the value from Third list tree menu item : Created  by GG	
	@Step
	public void ThirdTreeitemselection(String value)
	{
		menuitemsops = select.TMWTreeListItems(value,"third");
		if(!select.DisplayPathReturn().equals("NULL"))
		{
		WebElement element = getDriver().findElement(By.xpath(select.DisplayPathReturn()));
		if(element.getCssValue("display").equals("none"))
		{		
		amsaction.movetoelement(menuitemsops.get(value));
		amsaction.clickonthelement(menuitemsops.get(value));	
		}
		}
		else
		{
			amsaction.movetoelement(menuitemsops.get(value));
			amsaction.clickonthelement(menuitemsops.get(value));
		}
	}
	
	//Parameter - Report Name// This select the report name from menu list: Created  by GG	
	@Step
	public void ReportTreeitemselection(String value)
	{
		menuitemsops = select.TMWTreeListItems(value,"report");	
		amsaction.movetoelement(menuitemsops.get(value));
		amsaction.clickonthelement(menuitemsops.get(value));

	}
	
	//Parameter - label name and expected label value// verify the presence of label with expected value: Created  by GG	
	@Test
	@Step
	public void labelverify(String label, String Expected)
	{		
		labelverify.labelverifymain(label.trim(), Expected.trim());
	}
	
	//Parameter - list value// This select the value from first list menu item : Created  by GG
	@Step
	public void NavigateFirstlevelmenuoption(String value,String list)
	{		
		select.parentlistitem(list);
		menuitemsops = select.TMWMenuListItems(value,"first");
		first = menuitemsops.get(value);
		amsaction.clickonthelement(menuitemsops.get(value));
		//menuitemsops.get(value).click();		
	}
	
	//Parameter - list value// This select the value from second list menu item : Created  by GG
	@Step
	public void NavigateSecondlevelmenuoption(String value)
	{			
		
		menuitemsops = select.TMWMenuListItems(value,"second");
		second = menuitemsops.get(value);
		amsaction.clickonthelement(menuitemsops.get(value));		
	}
	
	//Parameter - list value// This select the value from third list menu item : Created  by GG
	@Step
	public void NavigateThirdlevelmenuoption(String value)
	{
		menuitemsops = select.TMWMenuListItems(value,"third");		
		third = menuitemsops.get(value);
		amsaction.clickonthelement(menuitemsops.get(value));
		
	}
	
	//Parameter - Application Name // Verify whether user logged inside the application: Created by GG
	@Step
	public void Loginverify(String verify)
	{
		page.loggedintoAppVerify(verify);
	}
	
	//Parameter - Button Name // This will click on the button: Created by GG
	@Step
	public void buttonclick(String element) throws InterruptedException
	{
		
		button.buttonmain(element);
	}
	
	//Parameter - Page Title // This verify the page display with expected page title: Created by GG
	@Test
	@Step
	public void pagedisplay(String element) throws InterruptedException
	{
		page.Pageverification(element);
	}
	
	
	
	
	//Parameter - Application Name //Launch the Application: Created by GG 
	@Test
	@Step
	public void login(String application)
	{
		page.launchURL(application);
	}
	
	//Parameter - Textbox Name //This return the textbox value : Created by GG
	@Test
	@Step
	public void  roValidation()
	{
		repair.newRepairOrderValidation();
	}
	
	//Parameter - Table Name and Table value //This selects the value from the table : Created by GG
	@Test
	@Step
	public void TableGridSelection(String value, String tablename) throws InterruptedException
	{
		table.Tablegridparentselection(tablename);
		amsaction.clickonthelement(table.TableGridmain(value));
	}
	
	//Parameter - Table Name and Button name //This click on the button in the table : Created by GG
	@Test
	@Step
	public void TableGridClickButton(String button, String value) throws InterruptedException
	{
		table.Tablegridparentselection(button);
		amsaction.clickonthelement(table.TableGridSelectmain(value));
	}
	
	//Parameter - Element name //This check the presence of the required element: Created by GG
	@Test
	@Step
	public void EelemntPresence(String Element) throws InterruptedException
	{
		elementortab.elementmain(Element);
	}
	
	@Test
	@Step
	public void DragandDropTable(String dialog,String item) throws InterruptedException
	{
		dragdrop.DragAndDropMain(dialog);
		dragdrop.DragandDropTableItemstoOneDestination(item);
	}
	
	
	
	//Parameter - Feature/Page name//This compares the DB values with UI : Created by GG
	@Step
	public void CompareUIwithSQL(String Item) 
	{
		//compare.CompareUIandDatabase(Item);
	}
	
	//Parameter - exe name//This executes the specified exe : Created by GG
	//@Test
	//@Step
	/*public void exceuteranorextestsuite(String exe) throws InterruptedException, IOException
	{
		ranorex.ranorexmain(exe);
	}*/
}
