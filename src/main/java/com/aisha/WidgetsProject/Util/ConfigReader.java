package com.aisha.WidgetsProject.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	public String path= "resources/com/aisha/WidgetsProject/Config/configuration.properties";
	public Properties init_prop()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
			}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			} 
		catch (IOException e) {
				e.printStackTrace();
				}
		
		return prop;
		
	}
	

}
