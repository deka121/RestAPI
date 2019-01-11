package com.qa.api.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop1;
	
	public TestBase() {
		try {
			 prop1 = new Properties();
			FileInputStream fls = new FileInputStream("C:\\Users\\Samsung\\eclipse-workspace\\RestAPI\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop1.load(fls);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
