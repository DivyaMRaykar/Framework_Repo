package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage
{
	
	@FindBy(name="lastname")
	private WebElement LastName;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement currentDateEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement addBtn;
	
	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getCurrentDateEdt() {
		return currentDateEdt;
	}

	public WebElement getSupportDateEdt() {
		return supportDateEdt;
	}

	@FindBy(name="support_end_date")
	private WebElement supportDateEdt;

	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public void createContact(String lastName)
	{
		LastName.sendKeys(lastName);
		SaveBtn.click();
	}
	
	public void createContactWithSupportDate(String lastname, String currentDate,String expectedDate)
	{
		LastName.sendKeys(lastname);
		currentDateEdt.clear();
		currentDateEdt.sendKeys(currentDate);
		supportDateEdt.clear();
		supportDateEdt.sendKeys(expectedDate);
		SaveBtn.click();
	}
}
