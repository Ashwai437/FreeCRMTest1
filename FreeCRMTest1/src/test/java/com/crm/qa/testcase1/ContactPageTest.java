package com.crm.qa.testcase1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base1.TestBase1;
import com.crm.qa.page1.ContactPage1;
import com.crm.qa.page1.HomePage1;
import com.crm.qa.page1.LoginPage1;
import com.crm.qa.utill.TestUtill1;

public class ContactPageTest extends TestBase1
{
	LoginPage1  loginpage1;
	HomePage1  homepage1;
	TestUtill1 testUtill1;
	ContactPage1 contactPage1;
	
	
	String sheetName = "contacts";
	
	public  ContactPageTest() 
	{
		super(); // for calling super class constructor()
		
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException 
	
	{
		
		initilization();
		 testUtill1 = new TestUtill1();
		 loginpage1 = new LoginPage1();
		 contactPage1  = new ContactPage1();
		 homepage1= loginpage1.Login(prop.getProperty("username"),prop.getProperty("password") ); 
		 testUtill1.switchToFrame();
		 contactPage1= homepage1.ClickOnContactLink();
		 
	}
	

	@Test(priority=1)
	
	public void verifyContactsPageLabel() 
	{
		Assert.assertTrue(contactPage1.verifyContactsLabel());
	}
	
	
	@Test(priority=2)
	
	public void selectContactTest() 
	{
		contactPage1.selectContactsByName("asit kumar");
	}
	
	
	
	@DataProvider
	public Object[][] getCrmTestData() {
	Object data[][]=TestUtill1.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=3,dataProvider="getCrmTestData")
	public void ValidateCreateNewContact(String title,String FirstName,String LastName,String Company) 
	{
		homepage1.clickOnNewContactLink();
		//contactPage1.createNewContact("Mr.", "Tom", "smith", "globus");
		contactPage1.createNewContact(title, FirstName, LastName, Company);
	}
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		
		driver.quit();
	}
	
	
	
}
