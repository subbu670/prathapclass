package com.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.genericfunctions.GenericFunctions;
import com.pages.Admin;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_01_BrokenLinksValidation extends GenericFunctions {

	@Given("as an user I want to launch Firefox browser")

	public static void LaunchApplication() {
		// WebDriver driver;
		// driver = new FirefoxDriver();
		LaunchBrowser("FF", "http://server/bank/");
		System.out.println("Launching Application");
	}

	@When("browser is launched verify home page is displayed")

	public static void HomePageVerification() {

		try {

			String HP = driver.getTitle();
			System.out.println(HP);
			if (HP.contains("Online Banking System")) {

				System.out.println("Home page verified");
			} else {
				System.out.println("Home page is not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("verify the Home page Nav tabs order")

	public static void HomePageNavTabsVerified() {

		TabsOrder("//a[normalize-space(text())='Home']/ancestor::ul/li/a", HomePageNavTabnames);
	}

	@Then("verify broken links of the tabs")
	public static void verifybrokenlinksinHome()

	{
		// List<WebElement> navlinks=
		// driver.findElements(By.xpath("//a[normalize-space(text())='Home']/ancestor::ul/li/a"));
		// // for all navbar links
		List<WebElement> navlinks = driver.findElements(By.xpath("//a")); // for
																			// all
																			// links
																			// in
																			// a
																			// page
		System.out.println(navlinks.size());

		try {
			for (int i = 0; i < navlinks.size(); i++) {
				// navlinks.get(i).click();

				String url = navlinks.get(i).getAttribute("href");

				System.out.println(url);
				httpurlconnection(url);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// boolean status = true;
	//
	// String[] Pagetitles = {"Online Banking System", "Admin Login - Online
	// Banking", "Staff Login - Online Banking", "Features - Online Banking",
	// "Contact Us"};
	// String[] Imagelinktitles = {"Safe Online Banking", "Safe Online Banking",
	// "Contact Us"};
	//
	// List<WebElement> ImgLinks=
	// driver.findElements(By.xpath("//html/body/div[1]/div[4]/div/a"));
	// List<WebElement> NavLinks=
	// driver.findElements(By.xpath("//html/body/div[1]/div[2]/ul/li"));
	// int NumofLinks = NavLinks.size();
	// System.out.println(NavLinks.size());
	//
	//
	// for (int i=0; i<=NumofLinks-1; i++)
	// {
	// int j = i+1;
	//
	// driver.findElement(By.xpath("html/body/div[1]/div[2]/ul/li["+j+"]/a")).click();
	//
	//
	// System.out.println(driver.getTitle());
	// System.out.println(Pagetitles[i]);
	// if (Pagetitles[i].equals(driver.getTitle()))
	// {
	// status = true;
	// if (j>=2)
	// {
	// Thread.sleep(5000);
	// driver.navigate().back();
	// Thread.sleep(5000);
	// }
	// }
	// else
	// {
	// status = false;
	// System.out.println("Link is broken");
	// }
	// }
	//
	// for (int m = 0; m<=ImgLinks.size(); m++ )
	// {
	// int n= m+1;
	// driver.findElement(By.xpath("html/body/div[1]/div[4]/div/a["+n+"]/h3")).click();
	//
	//
	//
	// if (Imagelinktitles[m].equals(driver.getTitle()))
	// {
	// status = true;
	// Thread.sleep(5000);
	// driver.navigate().back();
	// Thread.sleep(5000);
	//
	// }
	// else
	// {
	// status =false;
	// System.out.println("Link broken");
	// }
	// }
	//

	@And("click on Admin page")
	public static void GoToAdminPage()

	{
		ClickonAdminPage();

	}

	@Then("Login to admin page with \"([^\"]*)\" and \"([^\"]*)\"")
	public static void LoginAdmin(String Uname, String Pwd, DataTable AdminLogin) {
		// EnterAdminCredentials("admin", "admin");
		// WebElement AdminLogin =
		// driver.findElement(By.xpath("//input[@name='submitBtn']"));
		// AdminLogin.click();
		List<List<String>> data = AdminLogin.raw();
		Uname = data.get(0).get(0);
		Pwd = data.get(0).get(1);
		EnterAdminCredentials(Uname, Pwd);
	}

	@Then("Enter mandatory fields in add staff member page")

	public static void Addstaffmember(DataTable staffdetails) {
		List<List<String>> details = staffdetails.raw();
		int rowcount = details.size();
		for (int i = 0; i <= rowcount; i++) {
			String staffname = details.get(i).get(0);
			String SGender = details.get(i).get(0);
			String DOB = details.get(i).get(1);
			String DOJ = details.get(i).get(2);
			String Address = details.get(i).get(3);
			String Mobile = details.get(i).get(4);
			String Email = details.get(i).get(5);
			String Password = details.get(i).get(6);

			EnterStaffmemberdetails(staffname, SGender, DOB, DOJ, Address, Mobile, Email, Password);
		}
		
		ClickonAddstaffmember();
	}

	@Then("verify the Admin page content tabs order")

	public static void AdminContentTabsVerified() {

		TabsOrder("//a[normalize-space(text())='Home']/ancestor::ul/li/a", AdminPageContentTabnames);
	}

	@Then("verify the broken links in admin page")

	public static void verifybrokenlinksinAdmin() {

		{
			// List<WebElement> navlinks=
			// driver.findElements(By.xpath("//a[normalize-space(text())='Home']/ancestor::ul/li/a"));
			// // for all navbar links
			List<WebElement> navlinks = driver
					.findElements(By.xpath("//a[text()='Admin Home']/ancestor::div[2]/div/ul/li/a")); // for
																										// all
																										// content
																										// links
																										// in
																										// a
																										// page
			System.out.println(navlinks.size());

			try {
				for (int i = 0; i < navlinks.size(); i++) {
					// navlinks.get(i).click();

					String url = navlinks.get(i).getAttribute("href");

					System.out.println(url);
					httpurlconnection(url);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@And("click on Add staff member in Admin page")
	public static void clickstaffmember() {
		ClickonAddstaffmember();
	}

	@Then("verify the fields order in add staff page")
	public static void StaffFieldsOrder() {

		TabsOrder("(//*[text()='Add Staff'])[2]/ancestor::td/following::tr/td[1]", AddStaffmemberfieldnames);
		// String[] feildelements = new String[10];
		// int rowcount =
		// driver.findElements(By.xpath("//form[@method='POST']/table/tbody/tr")).size();
		// System.out.println(rowcount);
		// int j=0;
		// WebElement fields = driver.findElement(By.xpath("//*[text()='Add
		// Staff'])[2]/ancestor::tr/following::tr/td[1]"));
		// feildelements[j] = fields.getText();
		// System.out.println(feildelements[j]);
		// j++;
		//
		//
		// for(int k=0; k<rowcount-3; k++)
		// if(feildelements[k].equals(AddStaffmemberfieldnames[k]))
		// {
		// System.out.println("Fields order is correct");
		//
		// }
		// else
		// {
		// System.out.println("Fields order is incorrect");
		// }
	}

	@Then("verify the number of invalid inputs in Add Staff member")
	public static void Fieldsverification()

	{
		String[] feildelements = new String[10];
		// int j=0;
		// for(int i=2; i<rowcount-1; i++)
		// WebElement fields =
		// driver.findElement(By.xpath("//form[@method='POST']/table/tbody/tr/td["+i+"]/input"));
		List<WebElement> inputfields = driver
				.findElements(By.xpath("//input[@name='staff_name']/ancestor::tbody/tr/td[2]/input"));
		List<WebElement> invalidinputs = driver.findElements(By.cssSelector("input:invalid"));
		int Listsize = invalidinputs.size();

		if (Listsize == 6) {

			int count = 0;
			for (int i = 0; i <= 6; i--) {

				driver.findElement(By.xpath("//input[@name='add_staff']")).click();
				String str1 = driver
						.findElement(By
								.xpath("//u[text()='Add Staff']/ancestor::tr/following::tr/td[2]/input[not(@name='staff_gender' or @type='date')]"))
						.getText();

				if (str1.equals("")) {
					count++;
					System.out.println(count);
				}

			}
		}

		else
			System.out.println("There are no invalid input fields");
	}

}
