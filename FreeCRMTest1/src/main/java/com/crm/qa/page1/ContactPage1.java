package com.crm.qa.page1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base1.TestBase1;

public class ContactPage1 extends TestBase1 {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	 WebElement contatcsLable;
	
	//@FindBy(xpath="//a[contains(text(),'asit kumar')]/parent::td//preceding-sibling::td//input[@name='contact_id']")
	//WebElement
	
	
	
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement LastName;
	
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement ComapanyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement SaveBtn;
	
	public ContactPage1() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() 
	{
		return contatcsLable.isDisplayed();
	}
	
	public void selectContactsByName(String name) 
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}
	
	
	
	
	
	
	public void createNewContact(String title,String ftName ,String LtName , String comp) 
	{
		Select select = new  Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		
		firstName.sendKeys(ftName);
		LastName.sendKeys(LtName);
		ComapanyName.sendKeys(comp);
		SaveBtn.click();
	}
	
}
