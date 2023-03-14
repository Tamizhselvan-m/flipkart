package com.test_runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.flipkart.BaseClass;
import com.properties.ConfigurationHelper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\feature\\flipkart.feature", 
				glue = "com.step_definition", dryRun = false, monochrome = true,
				plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner {
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws IOException {
		String browser = ConfigurationHelper.getInstance().getInstanceCR().getBrowser();
		driver = BaseClass.driverLaunch(browser);
	}
	
	@AfterClass
	public static void tearDown() {
		BaseClass.driverQuit();
	}
}
