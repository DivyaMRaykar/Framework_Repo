package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ContactInformationPage {
	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastNameEdt;

	@FindBy(id = "mouseArea_Support Start Date")
	private WebElement actDisplayedDate;

	@FindBy(id = "mouseArea_Support End Date")
	private WebElement actSupportEndDate;

	@FindBy(className = "dvtCellInfo")
	private WebElement actOrgName;

	@FindBy(id = "mouseArea_Last Name")
	private WebElement actLastName;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeader;

	public WebElement getActLastName() {
		return actLastName;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}

	public WebElement getActDisplayedDate() {
		return actDisplayedDate;
	}

	public WebElement getOrgHeader() {
		return OrgHeader;
	}

	public WebElement getActSupportEndDate() {
		return actSupportEndDate;
	}

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public void verifyCreateContactTest(String lastName) {
		String actLastName = getLastNameEdt().getText();
		SoftAssert sa=new SoftAssert();
		boolean status=actLastName.contains(lastName);
		sa.assertEquals(status, true);
//		if (actLastName.trim().equals(lastName)) {
//			System.out.println(lastName + " is created--PASS");
//		} else {
//			System.out.println(lastName + " is not created--FAIL");
//		}
	}

	public void verifyStartDate(String currentDate) {
		String actDisplayedDate = getActDisplayedDate().getText();
		boolean status=actDisplayedDate.contains(currentDate);
		Assert.assertEquals(status, true);
//		if (actDisplayedDate.contains(currentDate)) {
//			System.out.println(currentDate + " is displayed--PASS");
//		} else {
//			System.out.println(currentDate + " is not displayed--FAIL");
//		}
	}

	public void verifyEndDate(String expectedDate) {
		String actSupportEndDate = getActSupportEndDate().getText();
		boolean status=actSupportEndDate.contains(expectedDate);
		Assert.assertEquals(status, true);
//		if (actSupportEndDate.contains(expectedDate)) {
//			System.out.println(expectedDate + " is displayed--PASS");
//		} else {
//			System.out.println(expectedDate + " is not displayed--FAIL");
//		}
	}

	public void verifyOrganizationHeader(String orgName) {
		String headerInfo = getOrgHeader().getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " is created--PASS");
		} else {
			System.out.println(orgName + " is not created--FAIL");
		}
	}
}
