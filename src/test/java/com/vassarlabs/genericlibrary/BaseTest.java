package com.vassarlabs.genericlibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest implements IAutoConstants{
public static WebDriver driver;
	
 	@BeforeClass
	public void openBrowser() throws Throwable
	{
		FileLibrary flib=new FileLibrary();
		
		String browserName= flib.ReadDataFromPropertyFile(PROP_PATH, "browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver=new FirefoxDriver();
		}
		
		else
		{
			Reporter.log("Enter Proper browser name",true);
		}
		
		driver.manage().window().maximize();
		String appUrl = flib.ReadDataFromPropertyFile(PROP_PATH, "url");
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		wlib.verify(wlib.getPageTitle(), 
				flib.ReadDataFromPropertyFile(PROP_PATH, "SigninTitle"),
				"Sign In Page");
	}
	
 	@AfterClass(enabled = false)
	public void closeBrowser()
	{
		driver.quit();
	}
}
