package com.crm.qa.testcase1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base1.TestBase1;
import com.crm.qa.page1.HomePage1;
import com.crm.qa.page1.LoginPage1;


public class LoginPageTests extends TestBase1 {

	LoginPage1  loginpage1;
	HomePage1  homepage1;
	
	public  LoginPageTests() 
	{
		super(); // for calling super class constructor()
		
	}
	
	
	@BeforeMethod
	public void setup() 
	
	{
		
		initilization();
		
		 loginpage1 = new LoginPage1();
		 
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() 
	{
	String title =	loginpage1.validateLoginPageTitle();
		
	Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
	
	}
	
	@Test(priority=2)
	public void crmlogoimageTest() {
		
		boolean flag= loginpage1.validateCRMImage();	
		Assert.assertTrue(flag);;
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homepage1= loginpage1.Login(prop.getProperty("username"),prop.getProperty("password") );
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
}
