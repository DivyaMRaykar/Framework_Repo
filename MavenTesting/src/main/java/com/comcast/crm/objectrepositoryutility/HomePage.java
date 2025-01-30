package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriveUtility;

public class HomePage extends WebDriveUtility
{
	
	@FindBy(linkText="Organizations")
	private WebElement Org;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement element;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement SignOut;

	@FindBy(linkText="Contacts")
	private WebElement Contacts;

	public WebElement getContacts() {
		return Contacts;
	}

	public WebElement getElement() {
		return element;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getOrg() {
		return Org;
	}
	
	public void SignOut(WebDriver driver) throws InterruptedException
	{
		moveToElement(driver, element);
		SignOut.click();
	}
}
