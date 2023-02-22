// 21/02/2023

package com.Actitime.test_script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assert {

	@Test
	public void demoassertion() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		expectedtitle=driver.getTitle();
		
	}
}
