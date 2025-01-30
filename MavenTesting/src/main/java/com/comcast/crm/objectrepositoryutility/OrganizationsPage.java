package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement NewOrg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement SearchDD;

	@FindBy(name="submit")
	private WebElement SearchBtn;
	
	@FindBy(name="search")
	private WebElement SearchButton;
	
	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return SearchDD;
	}

	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getNewOrg() {
		return NewOrg;
	}
	
	
}
