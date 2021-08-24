package com.aisha.WidgetsProject.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"resources/com/aisha/WidgetsProject/Parallel"},
		glue = {"com/aisha/WidgetsProject/Parallel"},
		plugin= {"pretty","html:target/cucumber-html-report","json:target/cucumber.json"},
		monochrome = true,
		//tags = "@t1",
		publish = true,
		dryRun = false,
		strict = true
		)
public class RunnerTest {

}
