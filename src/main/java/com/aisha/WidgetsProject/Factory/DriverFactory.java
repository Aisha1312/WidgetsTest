package com.aisha.WidgetsProject.Factory;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	Logger log = Logger.getLogger(DriverFactory.class);
	
	public static ThreadLocal<RemoteWebDriver> tldriver = new ThreadLocal<RemoteWebDriver>();
	
	public WebDriver init_driver(String browser)
	{
		if (browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("browserName", "chrome");
			
			tldriver.set(new ChromeDriver(cap));
			
			log.info("Chrome Driver exe is set");
			
			try {
				tldriver.set(new RemoteWebDriver(new URL("http://ec2-35-154-202-249.ap-south-1.compute.amazonaws.com:4444/"), cap));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			log.info("Chrome Driver is set");
		}
		else if(browser.equalsIgnoreCase("Internet Explorer"))
		{
			WebDriverManager.iedriver().setup();
			log.info("Edge Driver exe is set");
			tldriver.set(new InternetExplorerDriver());
			log.info("Internet Explorer Driver is set");
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			log.info("Edge Driver exe is set");
			tldriver.set(new EdgeDriver());
			log.info("Edge Driver is set");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			log.info("firefox driver exe is set");
			tldriver.set(new FirefoxDriver());
			log.info("firefox driver  is set");
		}
		else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}

}
