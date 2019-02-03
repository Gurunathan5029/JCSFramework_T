package WebDriverControlClasses;

import org.openqa.selenium.WebElement;

public class CheckboxSupportClass {
	
	public void checkcheckbox(WebElement checkbox)
	{
		if(checkbox.isSelected())
		{
			System.out.println("Checkbox is already Checked");
		}
		else
		{
			checkbox.click();
		}
	}
	
	public void uncheckcheckbox(WebElement checkbox)
	{
		if(checkbox.isSelected())
		{
			checkbox.click();
		}
		else
		{
			System.out.println("Checkbox is already Unchecked");
		}
	}

}
