package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Admin {
	
//=================================================ClickAdminTab=========================================//
	
	@FindBy(how=How.XPATH, using="//a[text()='Admin']")
	public static WebElement AdminTab;
		
//=================================================Set_Admin_Username=========================================//
	
	@FindBy(how=How.XPATH, using="//input[@name='uname']")
	public static WebElement EnterAdminUN;
		
//=================================================Set_Admin_Password=========================================//
	
	@FindBy(how=How.XPATH, using="//input[@name='pwd']")
	public static WebElement EnteradminPW;
	
//=================================================Click_Admin_Login_Button=========================================//
		
	@FindBy(how=How.XPATH, using="//input[@name='submitBtn']")
	public static WebElement AdminLoginBTN;
	
//=================================================Click_Admin_Home_Link=========================================//
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Admin Home')]")
	public static WebElement Admin_Home;
				
//=================================================Click_Admin_Change_Password_Link=========================================//
			
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Change password')]")
	public static WebElement ChangeAdminPW;
		
//=================================================Set_Old_Admin_Password=========================================//
	
	@FindBy(how=How.XPATH, using="//input[@name='old_password']")
	public static WebElement EnterOldAdminPW;
	
//=================================================Set_New_Admin_Password=========================================//
		
	@FindBy(how=How.XPATH, using="//input[@name='new_password']")
	public static WebElement EnterNewAdminPW;
	
//=================================================Set_New_Admin_Password_again=========================================//
	
	@FindBy(how=How.XPATH, using="//input[@name='again_password']")
	public static WebElement EnterNewAdminPWAgain;

			
//=================================================Click_Change_Password_Button=========================================//
		
	@FindBy(how=How.XPATH, using="//input[@name='change_password']")
	public static WebElement ChangePasswordBtn;

	
//=================================================Click_Logout_Link=========================================//
	
	@FindBy(how=How.XPATH, using="//a[text()='Logout']")
	public static WebElement Logout;
	
//=================================================Click_Staff_Add_staff_member=========================================//
	
	@FindBy(how=How.XPATH, using="//a[text()='Add staff member']")
	public static WebElement StaffAddstaffmember;
	
//=================================================Enter_Staff_Add_staff_member_Staff's_name==================================//
	
	@FindBy(how=How.XPATH, using="//input[@name='staff_name']")
	public static WebElement StaffAddstaffmemberStaffname;
	
	
//=================================================Select_Staff_Add_staff_member_Gender_Male==================================//
	
	@FindBy(how=How.XPATH, using="//input[@value='M']")
	public static WebElement StaffAddstaffmemberGenderM;
	
	
//=================================================Select_Staff_Add_staff_member_Gender_FeMale==================================//
	
	@FindBy(how=How.XPATH, using="//input[@value='F']")
	public static WebElement StaffAddstaffmemberGenderF;
	
	
//=================================================Enter_Staff_Add_staff_member_DOB==================================//
	
	@FindBy(how=How.XPATH, using="//input[@name='staff_dob']")
	public static WebElement StaffAddstaffmemberDOB;
	
//=====================================Select_Staff_Add_staff_member_Relationship_UnMarried==================================//
	
	@FindBy(how=How.XPATH, using="//select[@name='staff_status']/option[1]")
	public static WebElement StaffAddstaffmemberRelationshipUM;
	
	
//======================================Select_Staff_Add_staff_member_Relationship_Married==================================//
	
	@FindBy(how=How.XPATH, using="//select[@name='staff_status']/option[2]")
	public static WebElement StaffAddstaffmemberRelationshipM;
	
	
//======================================Select_Staff_Add_staff_member_Relationship_Divorced==================================//
	
	@FindBy(how=How.XPATH, using="//select[@name='staff_status']/option[3]")
	public static WebElement StaffAddstaffmemberRelationshipD;
	
	
//=================================================Enter_Staff_Add_staff_member_DOJ==================================//
	
	@FindBy(how=How.XPATH, using="//input[@name='staff_doj']")
	public static WebElement StaffAddstaffmemberDOJ;
	
	
//=================================================Enter_Staff_Add_staff_member_Address==================================//
	
	@FindBy(how=How.XPATH, using="//textarea[@name='staff_address']")
	public static WebElement StaffAddstaffmemberAddress;
	
	
//=================================================Enter_Staff_Add_staff_member_Mobile==================================//
	
	@FindBy(how=How.XPATH, using="//input[@name='staff_mobile']")
	public static WebElement StaffAddstaffmemberMobile;
		
		
//=================================================Enter_Staff_Add_staff_member_EmailID==================================//
		
	@FindBy(how=How.XPATH, using="//input[@name='staff_email']")
	public static WebElement StaffAddstaffmemberEmailID;
		
//=================================================Enter_Staff_Add_staff_member_Password==================================//
		
	@FindBy(how=How.XPATH, using="//input[@name='staff_pwd']")
	public static WebElement StaffAddstaffmemberPWD;
	
//=================================================Click_Staff_Add_staff_member_Addstaffmember_button==================================//
	
	@FindBy(how=How.XPATH, using="//input[@name='add_staff']")
	public static WebElement StaffAddstaffmemberBTN;

//=================================================Click_Staff_Edit_staff_member=========================================//
	
	@FindBy(how=How.XPATH, using="//a[text()='Edit staff member']")
	public static WebElement StaffEditstaffmember;
	
//=================================================Click_Staff_Delete_staff=========================================//
	
	@FindBy(how=How.XPATH, using="//a[text()='Delete staff']")
	public static WebElement StaffDeletestaff;
	
//=================================================Click_Customer_Add_Customer=========================================//
	
	@FindBy(how=How.XPATH, using="//a[text()='Add Customer']]")
	public static WebElement CustomerAddCustomer;

//=================================================Click_Customer_Edit_customer=========================================//
		
	@FindBy(how=How.XPATH, using="//a[text()='Edit customer']")
	public static WebElement CustomerEditcustomer;
		
//=================================================Click_Customer_Delete_customer=========================================//
		
	@FindBy(how=How.XPATH, using="//a[text()='Delete customer']")
	public static WebElement CustomerDeletecustomer;
	
	
	
	
public static boolean LoginAdmin(String username, String password){
	
	boolean status = true;
	
	try {
		
		//AdminTab.click();
		EnterAdminUN.clear();
		EnterAdminUN.sendKeys(username);
		EnteradminPW.clear();
		EnteradminPW.sendKeys(password);
		AdminLoginBTN.click();
		
	}
	
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
	return status;	
}
	
public static boolean AddStaffmemberdetails(String staffname, String Gender, String DOB, String DOJ, String Address, String Mobile, String Email, String Password){
	boolean status = true;
	
	try {
	StaffAddstaffmemberStaffname.sendKeys(staffname);
	
	if (Gender == "M")
	StaffAddstaffmemberGenderM.click();
	else
		StaffAddstaffmemberGenderF.click();
	
	StaffAddstaffmemberDOB.sendKeys(DOB);
	StaffAddstaffmemberDOJ.sendKeys(DOJ);
	StaffAddstaffmemberAddress.sendKeys(Address);
	StaffAddstaffmemberMobile.sendKeys(Mobile);
	StaffAddstaffmemberEmailID.sendKeys(Email);
	StaffAddstaffmemberPWD.sendKeys(Password);
	StaffAddstaffmemberBTN.click();
	}
	
	catch(Exception e) {
		status = false;
	}
	
	
	return status;
}

	
}
