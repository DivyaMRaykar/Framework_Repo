package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriveUtility;

public class CreateNewOrganizationPage extends WebDriveUtility
{
	
	@FindBy(name="accountname")
	private WebElement OrgName;
					
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(name="phone")
	private WebElement phoneNumberEdt;

	public WebElement getPhoneNumberEdt() {
		return phoneNumberEdt;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getIndustryEdt() {
		return industryDD;
	}

	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public void createOrg(String orgName)
	{
		OrgName.sendKeys(orgName);
		SaveBtn.click();
	}
	
	public void createOrg(String orgName, String industry,String type)
	{
		OrgName.sendKeys(orgName);
		selectDropdownByVisibleText(industryDD,industry );
		selectDropdownByVisibleText(typeDD, type);
		SaveBtn.click();
	}
	
	public void createOrg(String orgName,String phoneNo)
	{
		OrgName.sendKeys(orgName);
		phoneNumberEdt.sendKeys(phoneNo);
		SaveBtn.click();
	}
	
}
