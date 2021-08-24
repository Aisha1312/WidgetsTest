package com.aisha.WidgetsProject.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aisha.WidgetsProject.Factory.DriverFactory;

import io.cucumber.datatable.DataTable;

public class AutoCompletePage {

	private WebDriver driver;

	private By widgetsOption = By.xpath("//div//h5[text()='Widgets']");
	private By autocompleteButton = By.xpath("//span[@class='text' and contains(text(),'Auto Complete')]");

	private By multipleBox = By.id("autoCompleteMultipleInput");
	private By singleBox = By.id("autoCompleteSingleInput");
	
	private By xbuttons = By.xpath("//div[contains(@class,'remove')]");
	private By commonDelete = By.xpath("//*[contains(@class,'auto-complete__indicators')][1]//div");
	

	public AutoCompletePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean launchingURLForAutoComplete() {
		driver.get("https://www.demoqa.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean result = js.executeScript("return document.readyState").equals("complete");
		js.executeScript("window.scrollBy(0,500)");
		return result;
	}

	public boolean selectWidgetForAutoComplete() {
		// TODO Auto-generated method stub
		driver.findElement(widgetsOption).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean result = js.executeScript("return document.readyState").equals("complete");
		return result;
	}

	public boolean selectAutoComplete() {
		// driver.findElement(accordianButton).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement e = driver.findElement(autocompleteButton);
		js.executeScript("arguments[0].click();", e);
		boolean result = js.executeScript("return document.readyState").equals("complete");
		return result;
	}

	public boolean autocompletePage() {
		return driver.findElement(multipleBox).isDisplayed();
	}

	public boolean selectTextBox(List<String> l) {

		String boxType = l.get(0);
		if (boxType.equalsIgnoreCase("multiple colour")) {
			driver.findElement(multipleBox).click();
		}

		else if (boxType.equalsIgnoreCase("single colour")) {
			driver.findElement(singleBox).click();
		}
		return true;
	}

	public void typeColour(DataTable data) throws InterruptedException {
		for (Map<String, String> s : data.asMaps())
		{
			if ((s.get("boxtype")).equalsIgnoreCase("multiple colour")) 
			{
				driver.findElement(multipleBox).sendKeys(s.get("color") + Keys.ENTER);
				Thread.sleep(1000);
				System.out.println("PASS");
			} 
			else if ((s.get("boxtype")).equalsIgnoreCase("single colour")) 
				{
					driver.findElement(singleBox).sendKeys(s.get("color") + Keys.ENTER);
					Thread.sleep(1000);
					System.out.println("PASS");
				} 
			}

		}

	public boolean checkColour(List<List<String>> s) {

		boolean b = false;
		String boxType = s.get(0).get(1);
		if (boxType.equalsIgnoreCase("multiple colour") | boxType.equalsIgnoreCase("single colour")) {
			for (int i = 0; i < s.size(); i++) {
				WebElement e = driver.findElement(By.xpath("//*[text()='"+s.get(i).get(0)+"']"));
				if (e != null) {
					b = true;
				} else
					b = false;
			}

		}
		return b;
	}

	public boolean deleteColor() {
			List<WebElement> xButtons = driver.findElements(xbuttons);
			for(WebElement e : xButtons )
			{
				e.click();
			}
		
		return true;
	}

	public boolean verifyEmpty() {
		// TODO Auto-generated method stub
		try {
				driver.findElement(By.xpath("//*[text()='Green']"));
				return false;
		}
		catch(NoSuchElementException e )
		{
			return true;
		}
	}

	public boolean verifyColour(DataTable data) {
		List<Map<String, String>> color = data.asMaps();
		try {
			for(Map<String,String> m : color)
			{
				if(driver.findElement(By.xpath("//*[text()='"+ m.get("color")+"']"))!=null)
					System.out.println("colour present");
			}
		return true;
		}
		catch(NoSuchElementException e )
		{
			return false;
		}
	}
	
	public void commonDelete() {
		driver.findElement(commonDelete).click();
	}
}
