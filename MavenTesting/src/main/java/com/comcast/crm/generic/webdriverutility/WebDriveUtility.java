package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriveUtility 
{
	//implicit wait
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	//explicit wait
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToDisapper(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeSelected(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void waitForNumberOfWindowsToBe(WebDriver driver,int count)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.numberOfWindowsToBe(count));
	}
	
	public void waitForElementStaleness(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.stalenessOf(element));
	}
	
	public void waitForAlertIsPresent(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForUrlContains(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	//maximize and minimize
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	//Dropdown
	public void selectDropdown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void selectDropdownByValue(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	public void selectDropdownByVisibleText(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void deselectDropdown(WebElement element)
	{
		Select s=new Select(element);
		s.deselectAll();
	}
	
	//Actions
	public void clickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.click(element).perform();
	}
	
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void sendKeysToElement(WebDriver driver,WebElement element, String data)
	{
		Actions act=new Actions(driver);
		act.sendKeys(element,data);
	}
	
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();;
	}
	
	public void scroll(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.scrollByAmount(x, y).perform();;
	}
	
	//Scrolldown
	public void scrollDown(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	//Parent to child index>0
	public void frame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	//child to mainframe
	public void childFrameToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	//child to parent
	public void frame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	public void frame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	//switch between windows
	public void switchToTabOnTitle(WebDriver driver,String partialURL)
	{
		Set<String> allwh=driver.getWindowHandles();
		  Iterator<String> it=allwh.iterator();
		  while(it.hasNext())
		  {
			  String windowId=it.next();
			  driver.switchTo().window(windowId);
			  String actUrl=driver.getCurrentUrl();
			  if(actUrl.contains(partialURL))
			  { break; }
		  }
	}
	
	//Alert pop ups
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void takeScreenShot(WebDriver driver, String testname) throws IOException 
	{
		Date d=new Date();
		String d1=d.toString().replaceAll(":", "_");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./photos/"+d1+"_"+testname+".jpeg");
		FileHandler.copy(src, dst);
	}
}
