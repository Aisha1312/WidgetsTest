package com.aisha.WidgetsProject.Parallel;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.aisha.WidgetsProject.Factory.DriverFactory;
import com.aisha.WidgetsProject.Pages.DatePickerPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatePickerTest {
	
		private DatePickerPage DpPage = new DatePickerPage(DriverFactory.getDriver());
		
	 	@Given("user launches url for Date picker test")
	    public void user_launches_url_for_date_picker_test(){
	        Assert.assertTrue(DpPage.launchingURL());
	    }

	    @Given("Date picker is selected")
	    public void date_picker_is_selected() throws Throwable {
	    	Assert.assertTrue(DpPage.selectDatePicker());
	    }

	    @And("Month dropdown is selected")
	    public void month_dropdown_is_selected() throws Throwable {
	    	Assert.assertTrue(DpPage.monthDropdown());
	    }
	    
	    @And("year dropdown is selected")
	    public void year_dropdown_is_selected() throws Throwable {
	        
	    }

	    @When("Date text box is selected")
	    public void Date_text_box_is_selected(){
	        DpPage.selectDatePickerTextBox();
	    } 

	    @Then("Date picker should load properly")
	    public void date_picker_should_load_properly() {
	        Assert.assertTrue(DpPage.isDatePickerPageVisible());
	    }

	    @Then("todays date is present")
	    public void todays_date_is_present() {
	        Assert.assertTrue(DpPage.isTodaysDate());
	    }
	    
	    @Then("todays date should be highlighted")
	    public void todays_date_should_be_highlighted() throws Throwable {
	    	Assert.assertTrue(DpPage.isTodaysDateHighlighted());
	    }

	    @Then("verify month selected is visible in date picker")
	    public void verify_month_selected_is_visible_in_date_picker(DataTable data) {
	    	Assert.assertTrue(DpPage.checkMonths(data));
	    }

	    @Then("verify year selected is visible in date picker")
	    public void verify_year_selected_is_visible_in_date_picker() throws Throwable {
	    	Assert.assertTrue(DpPage.checkYears());
	    }

	    @Then("verify the date is visible in the date text box")
	    public void verify_the_date_is_visible_in_the_date_text_box(DataTable data) throws Throwable {
	    	Assert.assertTrue(DpPage.checkGivenDate(data));
	    }

	    @Then("verify the month value changes")
	    public void verify_the_month_value_changes(DataTable data) throws Throwable {
	    	
	    	Assert.assertTrue(DpPage.buttonCheck(data));

	    }

	    @And("user selects Widgets from list of options for date picker test")
	    public void user_selects_widgets_from_list_of_options_for_date_picker_test(){
	    	Assert.assertTrue(DpPage.selectWidget());
	    }
	    /*@And("verify month selected is visible in date picker")
	    public void verify_month_selected_is_visible_in_date_picker() throws Throwable {
	        throw new PendingException();
	    }
*/
	    @And("year is selected")
	    public void year_is_selected(DataTable data) throws Throwable {
	    	Assert.assertTrue(DpPage.selectYear(data));
	    }

	    @And("date is selected")
	    public void date_is_selected(DataTable data) throws Throwable {
	    	DpPage.selectDate(data);
	    }

	    @And("forward button is clicked")
	    public void forward_button_is_clicked() throws Throwable {
	    	DpPage.selectForwardButton();
	    }

	    @And("backward button is clicked")
	    public void backward_button_is_clicked() throws Throwable {
	    	DpPage.selectBackwardButton();
	    }


}
