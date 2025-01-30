package com.comcast.crm.configorgTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


@Listeners(com.comcast.crm.generic.listenerUtility.ListImp.class)
public class CreateOrgTest extends BaseClass {

	@Test(groups = "Smoke")
	public void createOrgTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read data from Excel");
		
		wLib.waitForPageToLoad(driver);
		wLib.maximizeWindow(driver);
		// read testScript data from Excel file
		System.out.println("Hi");
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		System.out.println("Bye");
		// step2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
		HomePage hp = new HomePage(driver);
		hp.getOrg().click();
		System.out.println("Org page navigated");

		// step3: click on "create organization" button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Create Org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getNewOrg().click();

		// step4: enter all the details and create new organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a New Org");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO,orgName+ "==>Create a new Org");

		// verify Header msg Expected Result

		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		oip.verifyOrganizationHeader(orgName);

		// verify Header orgName info Expected Result
		// oip.verifyCreateOrganizationTest(orgName);
	}

	@Test(groups = "Regression")
	public void createOrgWithIndustryTest() throws Throwable {
		System.out.println("Execute createOrgWithIndustryTest & Verify");
		// read testScript data from Excel file
		wLib.waitForPageToLoad(driver);
		wLib.maximizeWindow(driver);
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		// step2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrg().click();

		// step3: click on "create organization" button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getNewOrg().click();

		// step4: enter all the details and create new organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry, type);

		// verify the industries and type in Expected Result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		oip.verifyIndustry(industry);
		oip.verifyType(type);
	}

	@Test(groups = "Regression")
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		System.out.println("Execute createOrganizationWithPhoneNumberTest & Verify");
		wLib.waitForPageToLoad(driver);
		wLib.maximizeWindow(driver);
		// read testScript data from Excel file
		String orgName = eLib.getDataFromExcel("org", 12, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 12, 3);
		// step2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrg().click();

		// step3: click on "create organization" button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getNewOrg().click();

		// step4: enter all the details and create new organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName, phoneNumber);

		// verify the phone number in Expected Result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		oip.verifyPhoneNumber(phoneNumber);
	}

}
