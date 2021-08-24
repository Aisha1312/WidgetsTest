package com.aisha.WidgetsProject.Parallel;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.aisha.WidgetsProject.Factory.DriverFactory;
import com.aisha.WidgetsProject.Pages.AccordianPage;
import com.aisha.WidgetsProject.Pages.AutoCompletePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Data;

public class AutoCompleteTest {
	
		private AutoCompletePage autoCompletePage = new AutoCompletePage(DriverFactory.getDriver());
	 	
		@Given("user launches url for autocomplete test")
	    public void user_launches_url_for_autoComplete() {
	 		Assert.assertTrue(autoCompletePage.launchingURLForAutoComplete());
	    }

	    @Given("text box is selected")
	    public void text_box_is_selected(DataTable data) throws Throwable {
	    	List<String> l = new ArrayList<String>(data.asList());
	    	Assert.assertTrue(autoCompletePage.selectTextBox(l));
	    	
	    }

	    @When("AutoComplete is selected")
	    public void autocomplete_is_selected() throws Throwable {
	    	Assert.assertTrue(autoCompletePage.selectAutoComplete());
	    }

	    @When("colour value is typed")
	    public void colour_value_is_typed(DataTable data) throws Throwable {
	    	//List<List<String,String>> names = new ArrayList<List<String,String>>(data.asLists());
	    	autoCompletePage.typeColour(data);
	    
	    }

	    @Then("AutoComplete page should be visible")
	    public void autocomplete_page_should_be_visible() throws Throwable {
	    	Assert.assertTrue(autoCompletePage.autocompletePage());
	    }

	    @Then("multiple colours should get accepted")
	    public void multiple_colours_should_get_accepted(DataTable data) throws Throwable {
	    	
	    	List<List<String>> colors = new ArrayList<List<String>>(data.asLists());
	    		autoCompletePage.checkColour(colors);
	        
	    }

	    @Then("verify the text box is empty")
	    public void verify_the_text_box_is_empty() throws Throwable {
	        Assert.assertTrue(autoCompletePage.verifyEmpty());
	    }

	    /*@Then("verify color value is present as suggestion")
	    public void verify_color_value_is_present_as_suggestion() throws Throwable {
	        Assert.assertTrue(autoCompletePage.verifySuggestion());
	    }*/

	    @Then("verify the colour is present")
	    public void verify_the_colour_is_present(DataTable data) throws Throwable {
	    	Assert.assertTrue(autoCompletePage.verifyColour(data)); 
	    }

	    @And("user selects Widgets from list of options for autocomplete test")
	    public void user_selects_widgets_from_list_of_options() throws Throwable {
	    	 Assert.assertTrue(autoCompletePage.selectWidgetForAutoComplete());
	    }

	    @And("colors are deleted")
	    public void colors_are_deleted() throws Throwable {
	    	Assert.assertTrue(autoCompletePage.deleteColor());
	    }
	    
	    @When("common delete is clicked")
	    public void common_delete_is_clicked() throws Throwable {
	    	autoCompletePage.commonDelete();
	    }
}
