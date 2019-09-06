package com.crm.qa.testcase1;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base1.TestBase1;
import com.crm.qa.page1.ContactPage1;
import com.crm.qa.page1.HomePage1;
import com.crm.qa.page1.LoginPage1;
import com.crm.qa.utill.TestUtill1;

public class HomePageTest extends TestBase1  {

	LoginPage1  loginpage1;
	HomePage1  homepage1;
	TestUtill1 testUtill1;
	ContactPage1 contactPage1;
	
	public  HomePageTest() 
	{
		super(); // for calling super class constructor()
		
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException 
	
	{
		
		initilization();
		 testUtill1 = new TestUtill1();
		 loginpage1 = new LoginPage1();
		 
		 homepage1= loginpage1.Login(prop.getProperty("username"),prop.getProperty("password") ); 
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() 
	{
	String homepageTilte = homepage1.validateHomepageTilte();
		
	Assert.assertEquals(homepageTilte, "CRMPRO","Home page tille is not match");
	}
	
	@Test(priority=2)
	public void verifyUserTest() 
	{
		testUtill1.switchToFrame();
		Assert.assertTrue(homepage1.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void VreifyContactsLinkTest() 
	{
		testUtill1.switchToFrame();
		contactPage1=	homepage1.ClickOnContactLink();
	}
	
	
	@Test(priority=4)
	public void VreifyDelasLinkTest()
	{
		homepage1.ClickOnDealsLink();
	}
	

	@AfterMethod
	public void tearDown() 
	{
		
		driver.quit();
	}
	
	
	
	
	
}
