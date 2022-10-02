package com.flipkart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver = null;

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void userClick(WebElement element) {
		element.click();
	}

	public static void elementText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static void isDisplay(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println("the webelement is visible " + displayed);
	}

	public static void isEnable(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println("the webelement is editable " + enabled);
	}

	public static void isSelect(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println("the webelement is selected " + selected);
	}

	public static void getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		System.out.println(attribute);
	}

	public static void clearInput(WebElement element) {
		element.clear();
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(10000);
	}

	public static WebDriver driverLaunch(String option) {

		if (option.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void urlLaunch(String url) {
		driver.get(url);
	}

	public static void title() {
		String title = driver.getTitle();
		System.out.println("title " + title);
	}

	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("current url " + currentUrl);
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigate(String option) {
		if (option.equalsIgnoreCase("back")) {
			driver.navigate().back();
		} else if (option.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		} else if (option.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		} else if (option.equalsIgnoreCase("close")) {
			driver.close();
		} else if (option.equalsIgnoreCase("quit")) {
			driver.quit();
		} else {
			System.out.println("Invalid Input");
		}
	}

	public static void select(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		} else if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		} else {
			System.out.println("Invalid Input");
		}
	}

	public static void deselect(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			s.deselectByIndex(index);
		} else if (option.equalsIgnoreCase("value")) {
			s.deselectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			s.deselectByVisibleText(value);
		} else if (option.equalsIgnoreCase("all")) {
			s.deselectAll();
		} else {
			System.out.println("Invalid Input");
		}
	}

	public static void multiple(WebElement element, String option) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("ismultiple")) {
			boolean multiple = s.isMultiple();
			System.out.println("the dropdown is multiple: " + multiple);
		} else if (option.equalsIgnoreCase("options")) {
			List<WebElement> options = s.getOptions();
			for (WebElement web : options) {
				System.out.println(web.getText());
			}
		} else if (option.equalsIgnoreCase("allselected")) {
			List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			for (WebElement we : allSelectedOptions) {
				System.out.println(we.getText());
			}
		} else if (option.equalsIgnoreCase("firstselected")) {
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
		}
	}

	public static void simpleAlert() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert text: " + text);
		alert.accept();
	}

	public static void confirmAlert(String option) {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert text: " + text);
		if (option.equalsIgnoreCase("accept")) {
			alert.accept();
		} else if (option.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		} else {
			System.out.println("Invalid Input");
		}
	}

	public static void promptAlert(String input, String option) throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert text: " + text);
		alert.sendKeys(input);
		Thread.sleep(3000);
		if (option.equalsIgnoreCase("accept")) {
			alert.accept();
		} else if (option.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		} else {
			System.out.println("Invalid Input");
		}
	}

	public static void actions(WebElement element, String option) {
		Actions act = new Actions(driver);
		if (option.equalsIgnoreCase("context")) {
			act.contextClick(element).build().perform();
		} else if (option.equalsIgnoreCase("double")) {
			act.doubleClick(element).build().perform();
		} else if (option.equalsIgnoreCase("moveto")) {
			act.moveToElement(element).build().perform();
		} else {
			System.out.println("Invalid Input");
		}
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, target).build().perform();
	}

	public static void down(int times) throws AWTException {
		Robot r = new Robot();
		for (int i = 1; i <= times; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
	}

	public static void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void radioButton(WebElement element) {
		element.click();
	}

	public static void frameIn(String option, String value) {
		if (option.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			driver.switchTo().frame(index);
		}
		if (option.equalsIgnoreCase("id")) {
			driver.switchTo().frame(value);
		} else {
			System.out.println("Invalid Input");
		}
	}

	public static void frameOut(String option) {
		if (option.equalsIgnoreCase("outer")) {
			driver.switchTo().parentFrame();
		}
		if (option.equalsIgnoreCase("main")) {
			driver.switchTo().defaultContent();
		} else {
			System.out.println("Invalid Input");
		}
	}

	public static void winHandle() {
		String tab = driver.getWindowHandle();
		String title = driver.switchTo().window(tab).getTitle();
		System.out.println(title);
	}

	public static void winHandles() {
		Set<String> tabs = driver.getWindowHandles();
		for (String urls : tabs) {
			String title = driver.switchTo().window(urls).getTitle();
			System.out.println(title);
		}
	}

	public static void goTO(String title) {
		Set<String> tabs = driver.getWindowHandles();
		for (String urls : tabs) {
			if (driver.switchTo().window(urls).getTitle().equals(title)) {
				break;
			}
		}
	}

	public static void switchTo() {
		String parent = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String id : windowHandles) {
			if (!id.equals(parent)) {
				driver.switchTo().window(id);
			}
		}
	}
	public static void switchBack() {
		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String id : windowHandles1) {
				driver.switchTo().window(id);
		}
	}
	public static void checkBox(WebElement element) {
		element.click();
	}

	public static void driverClose() {
		driver.close();
	}

	public static void driverQuit() {
		driver.quit();
	}
	
	public static void screenShot() throws IOException {
		Date d = new Date();
		String string = d.toString();
		String date = string.replaceAll(":", "-");
	
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") +"\\ScreenShots\\"+date+".png");
		FileUtils.copyFile(source, destination);
		
	}
}
