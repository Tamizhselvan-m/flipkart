package com.step_definition;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.flipkart.BaseClass;
import com.pom.SingletonDesignPattern;
import com.properties.ConfigurationHelper;
import com.test_runner.TestRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	public static WebDriver driver = TestRunner.driver;
	SingletonDesignPattern s = new SingletonDesignPattern(driver);
	@Given("^User launch the application$")
	public void user_launch_the_application() throws Throwable {
		String url = ConfigurationHelper.getInstance().getInstanceCR().getUrl();
		urlLaunch(url);
	}

	@When("^User enter \"([^\"]*)\" as username in textfield$")
	public void user_enter_as_username_in_textfield(String username) throws Throwable {
		explicitWait(s.getLoginPage().getUsername());
		userInput(s.getLoginPage().getUsername(), username);
	}

	@When("^User enter \"([^\"]*)\" in password textfield$")
	public void user_enter_in_password_textfield(String password) throws Throwable {
		userInput(s.getLoginPage().getPassword(), password);
	}

	@When("^User click on the login button$")
	public void user_click_on_the_login_button() throws Throwable {
		userClick(s.getLoginPage().getLogin());
	}

	@Then("^It Will Navigate To Home Page$")
	public void it_Will_Navigate_To_Home_Page() throws Throwable {
		String expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	   assertEquals("Scenario passed", expected, driver.getTitle());
	}

	@When("^user Enter The \"([^\"]*)\" In Searchbox Textfield$")
	public void user_Enter_The_In_Searchbox_Textfield(String arg1) throws Throwable {
		Thread.sleep(2000);
		userInput(s.getHomePage().getSearchInput(), arg1);
	}

	@Then("^user Click The Search Button And It Navigate To Search Result Page$")
	public void user_Click_The_Search_Button_And_It_Navigate_To_Search_Result_Page() throws Throwable {
		Thread.sleep(2000);
		userClick(s.getHomePage().getSearch());
	}

	@When("^user Click The First Product And It Navigate To Product Page$")
	public void user_Click_The_First_Product_And_It_Navigate_To_Product_Page() throws Throwable {
		explicitWait(s.getSearchResultPage().getProduct1());
		userClick(s.getSearchResultPage().getProduct1());
	}

	@When("^user Click The Add To Cart Button Of First Product And It Navigate To Cart Page$")
	public void user_Click_The_Add_To_Cart_Button_Of_First_Product_And_It_Navigate_To_Cart_Page() throws Throwable {
		switchTo();
		explicitWait(s.getProductPage().getAdd());
		userClick(s.getProductPage().getAdd());
		Thread.sleep(2000);
	}

	@Then("^user Closed The First Cart Page And It Will Back To Search Result Page$")
	public void user_Closed_The_First_Cart_Page_And_It_Will_Back_To_Search_Result_Page() throws Throwable {
		driverClose();
	}
	
	@When("^user Click The Second Product And It Navigate To Product Page$")
	public void user_Click_The_Second_Product_And_It_Navigate_To_Product_Page() throws Throwable {
		switchBack();
		Thread.sleep(2000);
		userClick(s.getSearchResultPage().getProduct2());
	}

	@When("^user Click The Add To Cart Button Of Second Product And It Navigate To Cart Page$")
	public void user_Click_The_Add_To_Cart_Button_Of_Second_Product_And_It_Navigate_To_Cart_Page() throws Throwable {
		switchTo();
		explicitWait(s.getProductPage().getAdd());
		userClick(s.getProductPage().getAdd());
		Thread.sleep(2000);
	}

	@Then("^user Closed The Second Cart Page And It Will Back To Search Result Page$")
	public void user_Closed_The_Second_Cart_Page_And_It_Will_Back_To_Search_Result_Page() throws Throwable {
		driverClose();
	}
	
	@When("^user Click The Third Product  And It Navigate To Product Page$")
	public void user_Click_The_Third_Product_And_It_Navigate_To_Product_Page() throws Throwable {
		switchBack();
		Thread.sleep(2000);
		userClick(s.getSearchResultPage().getProduct3());
	}

	@When("^user Click The Add To Cart Button Of Third Product And It Navigate To Cart Page$")
	public void user_Click_The_Add_To_Cart_Button_Of_Third_Product_And_It_Navigate_To_Cart_Page() throws Throwable {
		switchTo();
		explicitWait(s.getProductPage().getAdd());
		userClick(s.getProductPage().getAdd());
		Thread.sleep(2000);
	}

	@Then("^user Closed The Third Cart Page And It Will Back To Search Result Page$")
	public void user_Closed_The_Third_Cart_Page_And_It_Will_Back_To_Search_Result_Page() throws Throwable {
		driverClose();
	}
	
	@When("^user Click The Cart Button And It Navigate To Cart Page$")
	public void user_Click_The_Cart_Button_And_It_Navigate_To_Cart_Page() throws Throwable {
	    switchBack();
	    Thread.sleep(2000);
		userClick(s.getSearchResultPage().getCart());
	}
	
	@When("^user remove all products from the cart$")
	public void user_remove_all_products_from_the_cart() throws Throwable {
	    userClick(s.getCartPage().getRemove());
	    explicitWait(s.getCartPage().getPopRemove());
	    userClick(s.getCartPage().getPopRemove());
	    
	    userClick(s.getCartPage().getRemove());
	    explicitWait(s.getCartPage().getPopRemove());
	    userClick(s.getCartPage().getPopRemove());
	    
	    userClick(s.getCartPage().getRemove());
	    explicitWait(s.getCartPage().getPopRemove());
	    userClick(s.getCartPage().getPopRemove());
	    
	    screenShot();

	}
}
