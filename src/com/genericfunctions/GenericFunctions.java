package com.genericfunctions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.pages.Admin;

public class GenericFunctions extends Admin {
	
	public static WebDriver driver;
	public static String[] HomePageNavTabnames = {"Home", "Admin", "Staff", "Features", "Contact Us"};
	public static String[] AdminPageContentTabnames = {"Admin Home", "Change password", "Logout", "Add staff member", "Edit staff member", "Delete staff", "Add Customer", "Edit customer", "Delete customer"};
	public static String[] AddStaffmemberfieldnames = {"Staff's name", "gender", "DOB", "Relationship", "Department", "DOJ", "Address:", "Mobile", "Email id", "Password"};
	
	public static boolean LaunchBrowser(String browser, String URL) 
	{
		
		boolean status = true;
		
		try {
			switch (browser.toLowerCase())
			{
			case "ff":
				driver = new FirefoxDriver();
				break;
			
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			case "ie":
				break;
				
			default:
				break;
			}
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		}	
			catch (Exception e)
			{
				status = false;
				System.out.println(e.getMessage());
			}
		return status;
		
		
		}
	
	public static void TabsOrder(String xpath, String[] options)
	{ 
		boolean status = true;
		try {
			
		List<WebElement> Tabslist = driver.findElements(By.xpath(xpath));
		int Tabs = Tabslist.size();
		System.out.println(Tabs);
		
		for (int i=0; i<Tabs; i++) 
		{
			if (options[i].contentEquals(Tabslist.get(i).getText())) 
			{
				status = true;
				System.out.println(Tabslist.get(i).getText());
			}
			
			else 
			{
				status = false;
				break;
			}
		
		}
		
		if (status) {
			System.out.println("Order displayed correctly");
			
		}
		else
			System.out.println("order is not correct");
	}
	catch (Exception e) 
	{
		System.out.println(e.getMessage());
	}
}

	
public static boolean ClickonAdminPage() 
	{
		boolean status = true;
		try{
		WebElement adminlink = driver.findElement(By.xpath("//a[normalize-space(text())='Admin']"));
			//click("//a[normalize-space(text())='Admin']");
		adminlink.click();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return status;
	}

public static void ClickonAddstaffmember() {
	WebElement AddStaffmember = driver.findElement(By.xpath("//a[contains(text(),'Add staff member')]"));
	AddStaffmember.click();
	
}

public static void EnterAdminCredentials(String AdminUname, String AdminPass)
	{
	try{
		Admin Adminpage = PageFactory.initElements(driver, Admin.class);
		LoginAdmin(AdminUname, AdminPass);
	}
	catch(Exception e)
	{
		e.getMessage();
	}
		
	}


public static void EnterStaffmemberdetails(String Sname, String SGender, String DOB, String DOJ, String SAddress, String SMobile, String SEmail, String SPwd)
{
try{
	
	Admin Adminpage = PageFactory.initElements(driver, Admin.class);
	AddStaffmemberdetails(Sname, SGender, DOB, DOJ, SAddress, SMobile, SEmail, SPwd);
}
catch(Exception e)
{
	e.getMessage();
}
	
}
	
	
public static void httpurlconnection(String currenturl) {
	
	try{
		
	URL url = new URL(currenturl);
	
	HttpURLConnection connect = (HttpURLConnection)url.openConnection();
	connect.connect();
	
	int response_code = connect.getResponseCode();
	System.out.println(response_code);
	
	if (response_code == 200) 
		
	{
		System.out.println(currenturl + " Link is active");
	}
	else
	{
		System.out.println("Link is broken");
	}
	}
	catch (Exception e){
	System.out.println(e.getMessage());
		
	}
}

}