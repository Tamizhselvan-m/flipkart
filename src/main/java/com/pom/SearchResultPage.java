package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	public static WebDriver driver;
	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "(//div[contains(text(),'iPhone 13')]/ancestor::a)[1]")
	private WebElement product1;
	public WebElement getProduct1() {
		return product1;
	}
	
	@FindBy(xpath = "(//div[contains(text(),'iPhone 13')]/ancestor::a)[2]")
	private WebElement product2;
	public WebElement getProduct2() {
		return product2;
	}
	
	@FindBy(xpath = "(//div[contains(text(),'iPhone 13')]/ancestor::a)[3]")
	private WebElement product3;
	public WebElement getProduct3() {
		return product3;
	}
	
	@FindBy(xpath = "//span[text()='Cart']//parent::a")
	private WebElement cart;
	public WebElement getCart() {
		return cart;
	}
}
