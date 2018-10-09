package com.genericfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebLibrary {
	
	public static WebDriver driver;
	// click method
	
	public static void click(String xpath1) {
	
		driver.findElement(By.xpath(xpath1)).click();
		
		
	
	}

}
