package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriveUtility;

public class LoginPage 	extends WebDriveUtility
{							//Rule-1 create a separate java class
							//Rule-2 Object creation
	
	@FindBy(name="user_name")		
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")		
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")		
	private WebElement loginBtn;
	
							//Rule-3 Object Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
							//Rule-4 Object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//run provide Action
	public void loginToApp(String username, String password)
	{
		
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
}
