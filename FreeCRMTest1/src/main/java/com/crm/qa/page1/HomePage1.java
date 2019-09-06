package com.crm.qa.page1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base1.TestBase1;

public class HomePage1 extends TestBase1 {

	@FindBy(xpath="//td[contains(text(),'kumar')]")
	WebElement userNameLabel;
	
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContatsLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TaksLink;
	

	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContatsLink;
	
	
	// initilization the page object
		public HomePage1() 
		{
			PageFactory.initElements(driver, this);
		}
	
	public String validateHomepageTilte() 
	{
		return driver.getTitle();
	}	
		
	
	public boolean verifyCorrectUserName() 
	{
		return userNameLabel.isDisplayed();
	}
	
	
	public ContactPage1 ClickOnContactLink()
	{
		ContatsLink.click();
		return new ContactPage1();
	}
	
	
	
	public DealsPage1 ClickOnDealsLink()
	{
		DealsLink.click();
		return new DealsPage1();
	}
	
	
	
	public TaskPage1 ClickOnTaskLink()
	{
		TaksLink.click();
		return new TaskPage1();
	}
	
	
	
	public void clickOnNewContactLink() 
	{
		Actions action =new Actions(driver);
		action.moveToElement(ContatsLink).build().perform();
		NewContatsLink.click();
	
	}	
	
}
