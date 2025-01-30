package com.comcast.crm.generic.baseutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriveUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebDriveUtility wLib=new WebDriveUtility();
	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups= {"Smoke","Regression"})
	public void configBS() throws Throwable
	{
		System.out.println("==Connect to DB , Report Config==");
		dLib.getDbconnection();
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"Smoke","Regression"})
	public void configBC() throws Throwable
	{
		System.out.println("==Launch BROWSER==");
		//String browser=fLib.getDataFromPropertiesFile("Browser");
		String browser = System.getProperty("BROWSER","edge");//u can hardcode or fetch from fileUtility
		if(browser.equals("chrome")) { driver=new ChromeDriver(); } 
		else if(browser.equals("firefox")) { driver=new FirefoxDriver(); }
		else if(browser.equals("edge")) { driver=new EdgeDriver(); } 
		else { driver=new ChromeDriver(); }
		
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	
//		@Parameters("BROWSER")
//		@BeforeClass(groups= {"Smoke","Regression"})
//		public void configBC(String browser1) throws Throwable
//		{
//			System.out.println("==Launch BROWSER==");
//			String browser=browser1;
//			if(browser.equals("chrome")) { driver=new ChromeDriver(); } 
//			else if(browser.equals("firefox")) { driver=new FirefoxDriver(); }
//			else if(browser.equals("edge")) { driver=new EdgeDriver(); } 
//			else { driver=new ChromeDriver(); }
//		}
	
	@BeforeMethod(groups= {"Smoke","Regression"})
	public void configBM() throws Throwable
	{
		System.out.println("==Login==");
		//String url=fLib.getDataFromPropertiesFile("url");
		String url = System.getProperty("URL",fLib.getDataFromPropertiesFile("url"));
		driver.get(url);
//		String un=fLib.getDataFromPropertiesFile("UserName");
//		String pwd=fLib.getDataFromPropertiesFile("Password");
		String un = System.getProperty("USERNAME",fLib.getDataFromPropertiesFile("UserName"));
		String pwd = System.getProperty("PASSWORD",fLib.getDataFromPropertiesFile("Password"));
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp( un, pwd);
	}
	
	@AfterMethod(groups= {"Smoke","Regression"})
	public void configAM() throws Throwable
	{
		System.out.println("==Logout==");
		HomePage hp=new HomePage(driver);
		hp.SignOut(driver);
	}
	
	@AfterClass(groups= {"Smoke","Regression"})
	public void configAC()
	{
		System.out.println("==Close Browser==");
		driver.quit();
	}
	
	@AfterSuite(groups= {"Smoke","Regression"})
	public void configAS() throws Throwable
	{
		System.out.println("==Close DB , Report BackUp==");
		dLib.closeDbconnection();
	}
}
