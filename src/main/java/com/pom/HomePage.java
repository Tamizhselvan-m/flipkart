package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(css = "input[title = 'Search for products, brands and more']")
	private WebElement searchInput;
	public WebElement getSearchInput() {
		return searchInput;
	}
	
	@FindBy(xpath = "//input[@title='Search for products, brands and more']//ancestor::div/button")
	private WebElement search;
	public WebElement getSearch() {
		return search;
	}
}
