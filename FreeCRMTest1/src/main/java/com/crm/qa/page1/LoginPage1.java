package com.crm.qa.page1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base1.TestBase1;
import com.crm.qa.page1.HomePage1;

public class LoginPage1 extends TestBase1{

	// page Factory   or  OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement CrmLogo;
	
	// initilization the page object
	public LoginPage1() 
	{
		PageFactory.initElements(driver, this);
	}
	// Action 
	public String  validateLoginPageTitle()
	{
		return driver.getTitle();

	}
	
	public boolean validateCRMImage()
	{
		return CrmLogo.isDisplayed();
	}
	
	public HomePage1 Login(String un , String pwd) throws InterruptedException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginBtn.click();

		return new HomePage1();
	}

}

