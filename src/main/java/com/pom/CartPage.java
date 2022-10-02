package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public static WebDriver driver;
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[text()='Remove']")
	private WebElement remove;
	public WebElement getRemove() {
		return remove;
	}
	
	@FindBy(xpath = "//div[text()='Cancel']/following-sibling::div[text()='Remove']")
	private WebElement popRemove;
	public WebElement getPopRemove() {
		return popRemove;
	}


}
