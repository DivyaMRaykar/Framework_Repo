package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrganizationInformationPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeader;

	@FindBy(id = "dtlview_Organization Name")
	private WebElement actOrgName;

	@FindBy(id = "mouseArea_Industry")
	private WebElement actIndustries;

	@FindBy(id = "mouseArea_Type")
	private WebElement actType;

	@FindBy(id = "dtlview_Phone")
	private WebElement ActPhoneNumber;

	public WebElement getActPhoneNumber() {
		return ActPhoneNumber;
	}

	public WebElement getActIndustries() {
		return actIndustries;
	}

	public WebElement getActType() {
		return actType;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}

	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeader() {
		return OrgHeader;
	}

	public void verifyCreateOrganizationTest(String orgName) {
		String actOrgName = getActOrgName().getText();
		boolean status=actOrgName.contains(orgName);
		Assert.assertEquals(status, true);
//		if (actOrgName.equals(orgName)) {
//			System.out.println(orgName + " is created--PASS");
//		} else {
//			System.out.println(orgName + " is not created--FAIL");
//		}
	}

	public void verifyOrganizationHeader(String orgName) {
		String headerInfo = getOrgHeader().getText();
		boolean status=headerInfo.contains(orgName);
		Assert.assertEquals(status, true);
//		if (headerInfo.contains(orgName)) {
//			System.out.println(orgName + " is created--PASS");
//		} else {
//			System.out.println(orgName + " is not created--FAIL");
//		}
	}

	public void verifyIndustry(String industry) {
		String actIndustries = getActIndustries().getText();
		boolean status=actIndustries.contains(industry);
		Assert.assertEquals(status, true);
//		if (actIndustries.contains(industry)) {
//			System.out.println(industry + " is verified--PASS");
//		} else {
//			System.out.println(industry + " is not verified--FAIL");
//		}
	}

	public void verifyType(String type) {
		String actType = getActType().getText();
		boolean status=actType.contains(type);
		Assert.assertEquals(status, true);
//		if (actType.contains(type)) {
//			System.out.println(type + " is verified--PASS");
//		} else {
//			System.out.println(type + " is not verified--FAIL");
//		}
	}

	public void verifyPhoneNumber(String phoneNumber) {
		String actPhoneNumber = getActPhoneNumber().getText();
		boolean status=actPhoneNumber.contains(phoneNumber);
		Assert.assertEquals(status, true);
//		if (actPhoneNumber.equals(phoneNumber)) {
//			System.out.println(phoneNumber + " is verified--PASS");
//		} else {
//			System.out.println(phoneNumber + " is not verified--FAIL");
//		}
	}
}
