package com.comcast.crm.configcontactTest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass {
	@Test(groups="Smoke")
	public void createContactTest() throws Throwable {
		System.out.println("Execute createContactTest & Verify");
		// read testScript data from Excel file
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);

		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// step2: navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContacts().click();

		// step3: click on "create contact" button
		ContactsPage cp = new ContactsPage(driver);
		cp.getNewContact().click();

		// step4: enter all the details and create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName);

		// verify lastname Expected Result
		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.verifyCreateContactTest(lastName);
	}

	@Test(groups="Regression")
	public void createContactWithSupportDateTest() throws Throwable {
		System.out.println("Execute createContactWithSupportDateTest & Verify");
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		// CurrentDate
		String currentDate = jLib.getSystemDateYYYYMMDD();

		// get 30 days after date
		String expectedDate = jLib.getRequiredDateYYYYMMDD(30);

		// read testScript data from Excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// step2: navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContacts().click();

		// step3: click on "create contact" button
		ContactsPage cp = new ContactsPage(driver);
		cp.getNewContact().click();

		// step4: enter all the details and create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContactWithSupportDate(lastName, currentDate, expectedDate);

		// verify lastname Expected Result
		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.verifyCreateContactTest(lastName);

		// verify current date Expected Result
		cip.verifyStartDate(currentDate);

		// verify support end date Expected Result
		cip.verifyEndDate(expectedDate);
	}

	@Test(groups="Regression")
	public void createContactWithOrganization() throws Throwable {
		wLib.waitForPageToLoad(driver);
		wLib.maximizeWindow(driver);
		// read testScript data from Excel file
		String lastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		// step2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrg().click();

		// step3: click on "create organization" button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getNewOrg().click();

		// step4: enter all the details and create new organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		Thread.sleep(5000);
		// step5: navigate to contact module
		hp.getContacts().click();

		// step6: click on "create contact" button
		ContactsPage cp = new ContactsPage(driver);
		cp.getNewContact().click();

		// step7: enter all the details and create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastName().sendKeys(lastName);
		;

		cncp.getAddBtn().click();
		wLib.switchToTabOnTitle(driver, "module=Accounts");
		op.getSearchEdt().sendKeys(orgName);
		op.getSearchButton().click();

		wLib.switchToTabOnTitle(driver, "Contacts&action");
		cncp.getSaveBtn().click();

		// verify lastname Expected Result
		ContactInformationPage cip = new ContactInformationPage(driver);
		cip.verifyCreateContactTest(lastName);

		// verify Header orgName info Expected Result
		// cip.verifyOrganizationHeader(orgName);
	}

}
