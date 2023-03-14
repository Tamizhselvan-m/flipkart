package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[text()='Enter Email/Mobile number']//ancestor::div/input")
	private WebElement username;
	public WebElement getUsername() {
		return username;
	}
	
	@FindBy(xpath = "//span[text()='Enter Password']//ancestor::div/input")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(xpath = "//button[text()='✕']")
	private WebElement login;
	public WebElement getLogin() {
		return login;
	}
}
