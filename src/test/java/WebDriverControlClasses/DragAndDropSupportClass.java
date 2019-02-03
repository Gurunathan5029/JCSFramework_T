package WebDriverControlClasses;

import org.openqa.selenium.WebElement;

import SupportClasses.ActionClass;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.By;

public class DragAndDropSupportClass extends PageObject{
	//AMSHomePage home;
	//AMSLoginPage AMSLogin;
	//AMSRepairOrdersPage AMSrepair;
	//AMSRepairsPage repairs;
	PageNavigation page ;
	String Page;
	static String Pagetitle;
	WebElement buttonelement;
	ActionClass action;
	//AMSEmployeeCreationPage AMSEmployee;
	//AMSHomePage AMSHome;
	//AMSSSRSReportViewerPage SSRSViewer;
	static String Source;
	static String Destination;
	static String sourcechildpath="";
	public void DragAndDropMain(String element)
	{
		String Application = page.Applicationname();
		switch (Application)
		{
		case "AMS":
		{	
			Page = page.ApplicationPage();
			if(Page.equals("TMW Systems, Inc."))
			{
			//Pagetitle = home.AMSMasterPage_Verify().getText().toString();
			}
			else
			{
				Pagetitle = Page.toUpperCase();
			}
			switch(Pagetitle)
			{
			case "REPAIR ORDER DETAILS":			
				switch(element)
				{					
				case "SerializedParts":
					try {
						Thread.sleep(9000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Source = AMSrepair.AMSRepairOrders_DragSource();
					//Destination = AMSrepair.AMSRepairOrders_DragDestination(); 
					sourcechildpath="/td";
					break;
					
				}
				
				}
		}
		}
	}
	
	public void DragandDropTableItemstoOneDestination(String item)
	{
		int sourceelementsize = getDriver().findElements(By.xpath(Source)).size();	
		WebElement destinationelement = getDriver().findElement(By.xpath(Destination));
		for(int i=1;i<=sourceelementsize;i++)
		{
			String source = Source+"["+i+"]"+sourcechildpath;
			int childsize = getDriver().findElements(By.xpath(source)).size();
			for(int j=1;j<=childsize;j++)
			{
				WebElement sourcelement = getDriver().findElement(By.xpath(source+"["+j+"]"));				
				if(sourcelement.getText().toString().trim().equals(item))
				{					
					action.draganddrop(sourcelement, destinationelement);
					break;
				}
			}
		}
	}
}
