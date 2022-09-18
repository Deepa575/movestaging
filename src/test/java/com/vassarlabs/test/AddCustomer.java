package com.vassarlabs.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddCustomer {
		@Test
		public void addCustomer() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); 
		driver.get("https://moove-staging.vassarlabs.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Assert.assertEquals(driver.getTitle(),"User Management ");
		Reporter.log("User Management Page is Dispalyed, PASS", true);
		driver.findElement(By.xpath("//a[text()=' Login']")).click();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("usermgmtadmin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Usermgmt@123");
		driver.findElement(By.xpath("//input[@id='kc-login']")).click();
		
		driver.findElement(By.xpath("//span[text()='Customers ']")).click();
		driver.findElement(By.xpath("//button[text()=' Add Customer ']")).click();
		}
		
}
	
	

