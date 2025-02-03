package package2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BrowserStackCode {

	@Test
	public void sampleTest() throws MalformedURLException {
		String username = "divyaraykar_2lXY80";
		String password = "qcHXc71KSBQR6BwzzExc";
		
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
		capabilities.setCapability("browserName", "Firefox");
		bstackOptions.put("os", "Windows");
		bstackOptions.put("osVersion", "10");
		bstackOptions.put("browserVersion", "latest");
		
		capabilities.setCapability("bstack:options", bstackOptions);


		
		RemoteWebDriver driver = new RemoteWebDriver(
				new URL("https://" + username + ":" + password + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
	}
}
