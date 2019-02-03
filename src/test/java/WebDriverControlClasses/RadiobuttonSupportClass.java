package WebDriverControlClasses;

import org.openqa.selenium.WebElement;

public class RadiobuttonSupportClass {
	//Check the Radio button is Checked or not and perform the check: Created by GG
	public void clickradiobutton(WebElement radiobutton)
	{
		if(radiobutton.isSelected())
		{
			System.out.println("Radiobutton is already selected");
		}
		else
		{
			radiobutton.click();
		}
	}
		
}
