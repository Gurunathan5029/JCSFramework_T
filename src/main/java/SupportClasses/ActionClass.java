package SupportClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.pages.PageObject;

public class ActionClass extends PageObject {

	Actions action = new Actions(getDriver());
	public ActionClass(WebDriver driver) {
	    super(driver);
	}		
	public void executeaction()
	{
		action.build().perform();
	}
	
	public void movetoelement(WebElement element)
	{
		action.moveToElement(element).perform();		
	}
	
	public void clickonthelement(WebElement element)
	{		
		action.moveToElement(element).click().build().perform();
	}
	
	public void clickandhold(WebElement element)
	{
		action.clickAndHold(element);
		executeaction();
	}
	
	public void rightclick(WebElement element)
	{
		action.contextClick(element);
		executeaction();
	}
	
	public void doubleclick(WebElement element)
	{
		action.doubleClick(element);
		executeaction();
	}
	
	public void draganddrop(WebElement sourceelement, WebElement destinationelement)
	{
		action.dragAndDrop(sourceelement, destinationelement);
		executeaction();
	}
	
	public void openlinkinnewwindow(WebElement element)
	{
		rightclick(element);
        action.sendKeys("w").perform();
	}
	
	public void sendkeystoelements(WebElement element, String value)	
	{
		action.sendKeys(element, value);
	}
	
	public void sendkeys(Keys value)	
	{
		action.keyDown(value);
		action.keyUp(value);
	}
	
	public void enterkeysincaps(WebElement element, String value)
	{
		Actions moreActions = action
		           .moveToElement(element)
		           .click()
		           .keyDown(element,Keys.SHIFT)
		           .sendKeys(element,value);
		executeaction();
		Action enterInCaps= moreActions.build();
		enterInCaps.perform();
	}
}
