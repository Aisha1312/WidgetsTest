package com.aisha.WidgetsProject.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

public class DatePickerPage {
	
	private WebDriver driver;
	private By widgetsOption = By.xpath("//div//h5[text()='Widgets']");
	private By datePickerButton = By.xpath("//span[text()='Date Picker']");

	private By datePickerView = By.className("react-datepicker");
	private By todaysDate = By.id("datePickerMonthYearInput");
	
	private By monthDates = By.xpath("//div[@class='react-datepicker__week']//div");
	private By monthDropdown = By.xpath("//*[@class='react-datepicker__month-select']");
	private By yearDropdown = By.xpath("//*[@class='react-datepicker__year-select']");
	
	private String startDatePicker = "(//*[@class='react-datepicker__month']//div//div[text()=";
	private String endDatePicker = "])[1]";
	
	private By backwardButton = By.xpath("//button[text()='Previous Month']");
	private By forwardButton = By.xpath("//button[text()='Next Month']");
	
	
	public DatePickerPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public boolean launchingURL() {
		// TODO Auto-generated method stub
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

	public boolean selectDatePicker() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement e = driver.findElement(datePickerButton);
		js.executeScript("arguments[0].click();", e);
		boolean result = js.executeScript("return document.readyState").equals("complete");
		return result;
	}

	public boolean isDatePickerPageVisible() {
		// TODO Auto-generated method stub
		String url = driver.getCurrentUrl();
		if(url.equalsIgnoreCase("https://www.demoqa.com/date-picker"))
			return true;
		else
			return false;		
	}

	public boolean isTodaysDate() {
		
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.format(d);
		String dateString = dateFormat.format(d).toString();
		System.out.println(dateString);
		String pageDate = driver.findElement(todaysDate).getAttribute("value");
		
		if(pageDate.equalsIgnoreCase(dateString))
			return true;
		else
			return false;
		
	}

	public void selectDatePickerTextBox() {
		
		driver.findElement(todaysDate).click();
	}

	public boolean isTodaysDateHighlighted() {
			Date d = new Date();
			DateFormat date = new SimpleDateFormat("dd");
			String todayDate = date.format(d).toString();
			
			System.out.println(todayDate);
			
			List<WebElement> e = driver.findElements(monthDates);
			for(WebElement ele : e)
			{
				String rgbColor = ele.getCssValue("background-color");
				String hexColour = Color.fromString(rgbColor).asHex();
				System.out.println(hexColour);
				if(hexColour.equalsIgnoreCase("#216ba5"))
				{
					//System.out.println(ele.getCssValue("background-color"));
					ele.getText().equalsIgnoreCase(todayDate);
					return true;
				}
					
			}
			
			return false;
	}

	public boolean checkMonths(DataTable data) {
		List<String> months = new ArrayList<String>(data.asList());
		for(String month : months)
			System.out.println(month);
		Select s = new Select(driver.findElement(monthDropdown));
		for(String month : months)
		{
			System.out.println(month);
			s.selectByVisibleText(month);
			if(driver.findElement(By.xpath("//*[contains(text(),'"+month+"')][1]")) != null)
				continue;
			else 
				return false;
		}
		return true;		
	}

	public boolean checkYears() {
		Select s = new Select(driver.findElement(yearDropdown));
		List<Integer> yearList = new ArrayList<Integer>();
		for(int i = 1900;i<=2100;i++)
		{
			yearList.add(i);
		}
		for(int year : yearList)
		{
			s.selectByValue(Integer.toString(year));
			if((driver.findElement(By.xpath("//*[contains(text(),'"+year+"')][1]")) != null))
					continue;
			else
				return false;
		}
		return true;
	}

	public boolean monthDropdown() {
		if(driver.findElement(monthDropdown)!=null)
			{
				driver.findElement(monthDropdown).click();
				return true;
			}
		return false;
	}

	public boolean selectYear(DataTable data) {
		
		Select s = new Select(driver.findElement(yearDropdown));
		s.selectByVisibleText(data.cell(1, 0));
		
		if((driver.findElement(By.xpath("//*[contains(text(),'"+data.cell(1, 0)+"')][1]")) != null))
		{
			return true;
		}
		return false;
	}

	public void selectDate(DataTable data) {
		
		driver.findElement(By.xpath(startDatePicker+data.cell(1, 0)+endDatePicker)).click();;
		
	}

	public boolean checkGivenDate(DataTable data) {
		
		String pageDate = driver.findElement(todaysDate).getAttribute("value");	
		if(pageDate.equalsIgnoreCase(data.cell(1, 0).toString()))
			return true;
		else
			return false;
	}

	public void selectForwardButton() {	
		driver.findElement(forwardButton).click();
		}

	public void selectBackwardButton() {
			driver.findElement(backwardButton).click();
		
	}

	public boolean buttonCheck(DataTable data) {
		
		LocalDate now = LocalDate.now();
		System.out.println(now.getMonth().toString());
		//Select s = new Select(driver.findElement(monthDropdown));
		
		if(data.cell(1, 0).equalsIgnoreCase("Forward"))
		{
			String nextMonthTemp = now.getMonth().plus(1).toString().toLowerCase();
			String nextMonth = nextMonthTemp.substring(0, 1).toUpperCase()+nextMonthTemp.substring(1);
			if( driver.findElement(By.xpath("//*[text()='"+nextMonth+"']")) !=null )
				return true;
		}
		if(data.cell(1, 0).equalsIgnoreCase("Backward"))
		{
			String prevMonthTemp = now.getMonth().minus(1).toString().toLowerCase();
			String prevMonth = prevMonthTemp.substring(0, 1).toUpperCase()+prevMonthTemp.substring(1);
			if( driver.findElement(By.xpath("//*[text()='"+prevMonth+"']")) !=null )
				return true;
		}
		return false;
		
		
	}
}
