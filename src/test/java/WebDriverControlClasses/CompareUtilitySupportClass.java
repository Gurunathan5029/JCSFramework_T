package WebDriverControlClasses;

import java.util.ArrayList;
import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;

public class CompareUtilitySupportClass extends PageObject {	
	//Parameter - Actual and Expected ArrayList// This method compare two array list : Created by GG
	public void compareArrayList(ArrayList<String> Expected,ArrayList<String> Actual)
	{	
		for(int i=0;i<Expected.size();i++)
		{
			String expected = Expected.get(i).trim();
			String actual = Actual.get(i).trim();
			System.out.println("Expected"+expected);
			if(Expected.equals(actual))
			{
				Assert.assertEquals(Expected, actual);
			}
		}
	}
				

}
