package StepDefinition;

import java.util.Map;

import org.junit.runner.RunWith;

import Steps.CommonSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Commonstepdefinition {
	StringBuilder sb = new StringBuilder(50);
	static String ItemType;
	static String constant;

	@Steps
	CommonSteps common;

	@Given("^I am in a (.*) Page$")
	public void i_am_in_a_Page(String pagename) throws Throwable {

		common.pagedisplay(pagename);
		// common.Progressbardisplay();
	}

	@Given("^I Login to (.*) Application$")
	public void i_Login_to_Application(String application, DataTable table) throws Throwable {
		for (Map<String, String> map : table.asMaps(String.class, String.class)) {
			String Application = map.get("Application");
			String Username = map.get("Username");
			String Password = map.get("Password");
			common.login(application);
			i_Enter_EmployeeID_Text_value_with("Username", Username);
			i_Enter_EmployeeID_Text_value_with("Password", Password);
			i_Click_on_button("Login");
			common.Loginverify(application);
		}
	}

	@Then("^(.*) Page should be displayed$")
	public void Page_should_be_displayed(String pagename) throws Throwable {

		common.pagedisplay(pagename);
	}

	

	@Given("^I have logged in to (.*)$")
	public void i_have_logged_in_to_Page(String apllication) throws Throwable {

		common.Loginverify(apllication);
	}

	@When("^I Click on (.*) button$")
	public void i_Click_on_button(String button) throws Throwable {
		common.buttonclick(button.trim());
		// common.Progressbardisplay();
	}

	@When("^I Navigate to (.*) in secondlevel menu$")
	public void i_Navigate_secondlevel_menu(String value) throws Throwable {
		if (!value.isEmpty()) {
			common.NavigateSecondlevelmenuoption(value.trim());
		}
	}

	@When("^I Navigate to (.*) in firstlevel menu in (.+)$")
	public void i_Navigate_firstlevel_menu(String value, String list) throws Throwable {

		common.NavigateFirstlevelmenuoption(value.trim(), list.trim());
	}

	@When("^I Navigate to (.*) in thirdlevel menu$")
	public void i_Navigate_thirdlevel_menu(String value) throws Throwable {

		if (!value.isEmpty()) {
			common.NavigateThirdlevelmenuoption(value.trim());
		}

	}

	@When("^I select (.*) from (.*) table$")
	public void i_select_from_table(String value, String tablename) throws Throwable {
		System.out.println("Va" + value + "Table" + tablename);
		common.TableGridSelection(value.trim(), tablename);
	}

	/*
	 * @When("^I execute (.*) Ranorex Smoke Test$") public void
	 * i_execute_IWS_Ranorex_Smoke_Test(String exe) throws Throwable {
	 * common.exceuteranorextestsuite(exe); }
	 */

	@When("^I Click on (.*) button Which has (.*) value$")
	public void i_Click_on_button_Which_has_value(String button, String value) throws Throwable {
		if (value.equals("Stored")) {
			common.TableGridClickButton(button, constant);
		} else {
			common.TableGridClickButton(button, value);
		}
	}

	@When("^I Navigate to (.*) in firsttree menu$")
	public void i_Navigate_in_firsttree_menu(String value) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!value.isEmpty()) {
			common.FirstTreeitemselection(value);
		}
	}

	@When("^I Navigate to (.*) in secondtree menu$")
	public void i_Navigate_in_secondtree_menu(String value) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!value.isEmpty()) {
			common.SecondTreeitemselection(value);
		}
	}

	@When("^I Navigate to (.*) in thirdtree menu$")
	public void i_Navigate_to_thirdtree_menu(String value) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!value.isEmpty()) {
			common.ThirdTreeitemselection(value);
		}
	}

	@When("^I Navigate to (.*) in Listtree$")
	public void i_Navigate_to_Report_in_Listtree(String value) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!value.isEmpty()) {
			common.ReportTreeitemselection(value);
		}
	}

	@When("^I Navigate to (.*) in Listtree and wait till progress disapper$")
	public void i_Navigate_to_Account_Analysis_in_Listtree_and_wait_till_progress_disapper(String value)
			throws Throwable {
		if (!value.isEmpty()) {
			common.ReportTreeitemselection(value);
			// common.Progressbardisplay();
		}

	}

	@When("^I Click on (.*) (.*) hub$")
	public void i_Click_on_EmployeeClassification_List_hub(String list, String type) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ItemType = type;
		common.Menuhubclick(list.trim());
	}

	@When("^I Click on (.*) button and wait till progress disapper$")
	public void i_Click_on_button_and_wait_till_progress_disapper(String button) throws Throwable {
		common.buttonclick(button);
		// common.Progressbardisplay();
	}

	@When("^I Click on (.*) button and wait till multiple progress disapper$")
	public void i_Click_on_button_and_wait_till_multiple_progress_disapper(String button) throws Throwable {
		common.buttonclick(button);
		// common.MultipleProgressbardisplay();
	}

	@When("^I Click on (.*) button and wait till small progress disapper$")
	public void i_Click_on_button_and_wait_till_small_progress_disapper(String button) throws Throwable {
		common.buttonclick(button);
		// common.smallProgressbardisplay();
	}

	@When("^I Enter (.*) Text value with \"([^\"]*)\"$")
	public void i_Enter_EmployeeID_Text_value_with(String textbox, String value) throws Throwable {
		common.Entertextboxvalue(textbox, value);
		// common.Progressbardisplay();
	}

	@When("^I Enter (.*) Text value with \"([^\"]*)\" and wait till multiple progress disapper$")
	public void i_Enter_EmployeeID_Text_value_withmultipleprogressbar(String textbox, String value) throws Throwable {
		common.Entertextboxvalue(textbox, value);
		// common.MultipleProgressbardisplay();
	}

	@When("^I Click on (.*) List hub and wait till progress disapper$")
	public void i_Click_on_List_hub_and_wait_till_progress_disapper(String listhub) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		common.buttonclick(listhub);
		// common.Progressbardisplay();
	}

	@When("^I Click on (.*) List hub and Select \"([^\"]*)\"$")
	public void i_Click_on_List_hub_and_Select(String listhub, String value) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		common.Menuhubclick(listhub);
		// common.Progressbardisplay();
		common.listitemselection(value);
		// common.Progressbardisplay();
	}

	@When("^I Select Item in an Expanded (.+) List$")
	public void i_Select_Item_in_an_Expanded_List(String List, DataTable table) throws Throwable {
		for (Map<String, String> map : table.asMaps(String.class, String.class)) {
			String Item = map.get("Item");
			common.Menuhubclick(List);
			common.listitemselection(Item);
		}
	}

	@When("^I Click on (.+) List hub and Select based on Conditional Value$")
	public void i_Click_on_SerializedMain_List_hub_and_Select_based_on_Conditional_Value(String List, DataTable table)
			throws Throwable {
		for (Map<String, String> map : table.asMaps(String.class, String.class)) {
			String value = map.get("Value");
			common.Menuhubclick(List);
			common.listitemselectionForCondtionalValue(value);
		}

	}

	@When("^I Enter (.*) Text value with Stored Value$")
	public void i_Enter_OrderInput_Text_value_with_Stored_Value(String textbox) throws Throwable {
		common.Entertextboxvalue(textbox, constant);
	}

	@When("^I Click on (.*) List hub and Select \"([^\"]*)\" and wait till progress disapper$")
	public void i_Click_on_List_hub_and_Select_and_wait_till_progress_disapper(String listhub, String value)
			throws Throwable {

		common.Menuhubclick(listhub);
		common.listitemselection(value);
		// common.Progressbardisplay();
	}

	@When("^I Click on (.*) List hub and Select \"([^\"]*)\" Using CSS values$")
	public void i_Click_on_LineType_List_hub_and_Select_Using_CSS_values(String listhub, String value)
			throws Throwable {
		common.Menuhubclick(listhub);
		common.listitemselectionCSS(value);
		// common.Progressbardisplay();
	}
	

	@When("^I Click on (.*) Textbox and wait till progress disapper$")
	public void i_Click_on_Textbox_and_wait_till_progress_disapper(String textbox) throws Throwable {

		common.buttonclick(textbox);
		// common.Progressbardisplay();
	}

	

	@Then("^(.*) tab should be displayed$")
	public void tab_should_be_displayed(String Element) throws Throwable {
		common.EelemntPresence(Element);
	}

	@Then("^\"([^\"]*)\" should be displayed (.+)$")
	public void should_be_displayed(String Errormessage, String errorwindow) throws Throwable {
		common.labelverify(errorwindow, Errormessage);
	}

	@Then("^\"([^\"]*)\"\"([^\"]*)\" should be thrown for (.+) for stored value$")
	public void should_be_displayed_for_ReopenedOrder_for_stored_value(String Errormessage1, String Errormessage2,
			String errorwindow) throws Throwable {
		common.labelverify(errorwindow, Errormessage1 + " " + constant + " " + Errormessage2);
	}

	@Then("^(.*) form should be displayed$")
	public void add_New_Employee_form_should_be_displayed(String form) throws Throwable {

		common.pagedisplay(form);
	}

	@When("^I Drag and Drop TableListItems in (.+) Dialog$")
	public void i_Drag_and_Drop_TableListItems_in_SerializedParts_Dialog(String dialog, DataTable table)
			throws Throwable {
		for (Map<String, String> map : table.asMaps(String.class, String.class)) {
			String itemvalue = map.get("TableListItem");
			common.DragandDropTable(dialog, itemvalue);
		}
	}

	@Then("^(.*) should be successfully created with \"([^\"]*)\", \"([^\"]*)\"$")
	public void should_be_successfully_created_with(String label, String firstname, String lastname) throws Throwable {

		sb.append(firstname);
		sb.append(" ");
		sb.append(lastname);
		String verifytext = sb.toString();
		common.labelverify(label, verifytext);
	}

	@Then("^(.*) textbox should be successfully updated with (.*)$")
	public void shop_textbox_should_be_successfully_updated_with(String label, String verifytext) throws Throwable {
		common.labelverify(label, verifytext);
	}

	@Then("^(.*) should be displayed with (.*)$")
	public void report_Title_should_be_displayed_with_Account_Analysis(String label, String verifytext)
			throws Throwable {
		Thread.sleep(1000);
		if (verifytext.trim().equals("Stored Value")) {
			common.labelverify(label.trim(), constant.trim());
		} else {
			common.labelverify(label.trim(), verifytext.trim());
		}
	}

}
