package mavenpractise;

import org.testng.annotations.Test;

public class PractiseMaven {
	@Test
	public void learn()
	{
		String url = System.getProperty("URL");
		String browser = System.getProperty("BROWSER");
		String un = System.getProperty("USERNAME");
		String pwd = System.getProperty("PASSWORD");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(un);
		System.out.println(pwd);
	}
}
