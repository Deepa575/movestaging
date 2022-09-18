package com.vassarlabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersWebElements {
	@FindBy(xpath="//a[text()=' Login']")private WebElement loginBtn;
	@FindBy(xpath="//input[@id='username']")private WebElement userNameTb;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordTb;
	@FindBy(xpath="//input[@id='kc-login']")private WebElement submitBtn;
	
	public CustomersWebElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
