package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SingletonDesignPattern {
	public static WebDriver driver;

	public SingletonDesignPattern(WebDriver driver2) {
		PageFactory.initElements(driver, this);
		this.driver = driver2;
	}
	
	public LoginPage getLoginPage() {
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	public HomePage getHomePage() {
		HomePage hp = new HomePage(driver);
		return hp;
	}
	
	public SearchResultPage getSearchResultPage() {
		SearchResultPage srp = new SearchResultPage(driver);
		return srp;
	}
	
	public ProductPage getProductPage() {
		ProductPage pp = new ProductPage(driver);
		return pp;

	}
	
	public CartPage getCartPage() {
		CartPage cp = new CartPage(driver);
		return cp;
	}
}
