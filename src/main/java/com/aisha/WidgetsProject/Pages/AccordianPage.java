package com.aisha.WidgetsProject.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aisha.WidgetsProject.Factory.DriverFactory;

public class AccordianPage {
	
	private WebDriver driver;
	
	private By widgetsOption = By.xpath("//div//h5[text()='Widgets']");
	private By accordianButton = By.xpath("//span[text()='Accordian']");
	
	private By accordianText = By.xpath("//div[text()='Accordian']");
	private By firstAccordian = By.xpath("//div[@id='section1Heading']");
	private By secondAccordian = By.xpath("//div[@id='section2Heading']");
	private By thirdAccordian = By.xpath("//div[@id='section3Heading']");
	
	private By firstAccordianText = By.xpath("//p[contains(text(),\"Lorem Ipsum is s\")]");
	private By secondAccordianText = By.xpath("//p[contains(text(),'Contrary to popular belief']");
	private By thirdAccordianText = By.xpath("//p[contains(text(),'It is a long established')]");
	
	String firstpath = "\"//div[@id='section";
	String secondPath = "Content']\"";
	
	public AccordianPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean launchingURL()
	{
		driver.get("https://www.demoqa.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		boolean result = js.executeScript("return document.readyState").equals("complete");
		js.executeScript("window.scrollBy(0,500)");
		return result;
	}

	public boolean selectWidget() {
		// TODO Auto-generated method stub
		driver.findElement(widgetsOption).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		boolean result = js.executeScript("return document.readyState").equals("complete");
		return result;
	}
	
	public boolean selectAccordian()
	{
		//driver.findElement(accordianButton).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement e = driver.findElement(accordianButton);
		js.executeScript("arguments[0].click();", e);
		boolean result = js.executeScript("return document.readyState").equals("complete");
		return result;
	}

	public boolean accordianPage() {
		return driver.findElement(accordianText).isDisplayed();
	}

	public boolean threeAccordians(String s) {
		return driver.getPageSource().contains(s);
	}

	public boolean selectAccordianWithText(String question) {
		boolean result = driver.getPageSource().contains(question);
		return result;
	}

	public boolean verifyAccordianText(String description) {
		String su;
		boolean result = false;
		WebDriverWait d = new WebDriverWait(driver, 30);
		d.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(text(),'"+description+"')]"))));
		su = driver.findElement(By.xpath("//p[contains(text(),'"+description+"')]")).getText();
		System.out.println(su);
		if(su.contains(description)) {
			result = true;
		}
		return result;
	}

	public boolean verifyAccordianIsClicked(String question, int number, String s) {
		boolean result = false;
		//String su;
		if(s.equalsIgnoreCase("firstAccordian"))
		{
			driver.findElement(firstAccordian).click();
			result = true;
		}
		else if(s.equalsIgnoreCase("secondAccordian"))
		{
			driver.findElement(secondAccordian).click();
			result = true;
		}
		else if(s.equalsIgnoreCase("thirdAccordian"))
		{
			driver.findElement(thirdAccordian).click();
			result = true;
		}
		return result;
	}
}
