package com.aisha.WidgetsProject.Parallel;

import org.junit.Assert;

import com.aisha.WidgetsProject.Factory.DriverFactory;
import com.aisha.WidgetsProject.Pages.AccordianPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AccordianTest {
	
	private AccordianPage accordianPage = new AccordianPage(DriverFactory.getDriver());
	
	@Given("user launches url")
    public void user_launches_url() {
		Assert.assertTrue(accordianPage.launchingURL());
    }

    @Given("accordian page is loaded")
    public void accordian_page_is_loaded()  {
    	Assert.assertTrue(accordianPage.accordianPage());
     }

    @When("Accordian is selected")
    public void accordian_is_selected() {
    	Assert.assertTrue(accordianPage.selectAccordian());
    }

    @When("question {string} number {int} {string} accordian is clicked")
    public void _accordian_is_clicked(String question, int number, String sample)  {
        Assert.assertTrue(accordianPage.verifyAccordianIsClicked(question,number,sample));
    }

    @Then("verify the text contains {string} text")
    public void verify_the_text_contains_(String description) {
    	Assert.assertTrue(accordianPage.verifyAccordianText(description));
    }


    @Then("Accordian page should be visible")
    public void accordian_page_should_be_visible()  {
        Assert.assertTrue(accordianPage.accordianPage());
    }

    @Then("verify accordian {string} are visible")
    public void verify_three_accordian_are_visible(String s) {
        Assert.assertTrue(accordianPage.threeAccordians(s));
    }

    @And("user selects Widgets from list of options")
    public void user_selects_widgets_from_list_of_options() {
      Assert.assertTrue(accordianPage.selectWidget());
    }


}
