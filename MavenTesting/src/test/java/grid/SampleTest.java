package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest {
	
	@Test
	public void sampleTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
	
}
