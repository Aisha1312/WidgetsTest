package com.aisha.WidgetsProject.Parallel;

import java.io.File;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aisha.WidgetsProject.Factory.DriverFactory;
import com.aisha.WidgetsProject.Util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class ApplicationHooks {
	
	private ConfigReader configReader;
	private DriverFactory driverFactory;
	
	Properties prop;
	private WebDriver driver;
	
	@Before(order = 0)
	public void getProperty()
	{
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	@Before(order =1)
	public void launchBrowser()
	{
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order = 1)
	public void takeScreenshot(Scenario scenario)
	{
		if(scenario.isFailed()==true)
		{
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			
		}
	}
	

}
