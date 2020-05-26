package gov.ae.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	private static final Logger log = LogManager.getLogger(SeleniumUtils.class.getName());

	// generate name randomly
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	// Method to clear and enter data in text box
	public static void type(WebDriver driver, By txt_ID, String txt_Value, String ControlName) {
		WebElement txt = driver.findElement(txt_ID);
		try {
			txt.clear();
			txt.sendKeys(txt_Value);
			log.info("The" + txt_Value + " value is typed in the " + "'" + ControlName + "'" + " text box");
		} catch (Exception e) {
			log.error("The " + txt_Value + " value isn't typed in the " + "'" + ControlName + "'" + "text box due to:"
					+ e.getMessage());
		}

	}

	// Method to click on any button
	/**
	 * This function click on an element
	 * 
	 * @param driver
	 * @param btn_ID
	 * @param ctrlName
	 */
	public static void clickElement(WebDriver driver, By btn_ID, String ctrlName) {
		try {
			WebElement btn = driver.findElement(btn_ID);
			btn.click();
			wait(driver, btn_ID, ctrlName);
			log.info("The " + ctrlName + " is pressed");
		} catch (Exception e) {
			log.error("The " + ctrlName + " not pressed due to " + e.getMessage());
		}
	}

	// Method to check if the element present or not
	public static boolean isElementPresent(WebDriver driver, By by, String ControlName) {
		try {
			driver.findElement(by);
			log.info("'" + ControlName + "'" + " Element is Present");
			return true;
		} catch (NoSuchElementException e) {
			log.error("'" + ControlName + "'" + " Element is not Present due to" + e.getStackTrace());
			return false;
		}
	}

	// wait until drop down list options loaded
	public static void waitddl(WebDriver driver, final By by, String visibleText) {

		try {
			// Waits for 20 seconds
			WebDriverWait wait = new WebDriverWait(driver, 20);
			// Wait until expected condition size of the dropdown increases and becomes more
			// than 1
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					Select select = new Select(driver.findElement(by));
					return select.getOptions().size() > 1;
				}
			});

			// To select the first option
			Select select = new Select(driver.findElement(by));
			getAllOptions(by, driver);
			select.selectByVisibleText(visibleText);

			log.info("The " + visibleText + " was selected");
		} catch (Throwable e) {
			log.error("Error found: " + e.getMessage());
		}
	}

	// Method to wait for specific condition
	public static void wait(WebDriver driver, By itemToWaitFor, String ControlName) {

		int timeToWait = 30;
		log.info("Waiting for max:: " + timeToWait + " seconds for " + ControlName + " to be available");
		try {

			long start = System.currentTimeMillis();
			WebDriverWait waitForElement = new WebDriverWait(driver, timeToWait);
			waitForElement.until(ExpectedConditions.visibilityOfElementLocated(itemToWaitFor));
			long finish = System.currentTimeMillis();
			long totalTime = finish - start;
			log.info("The control took  -  " + totalTime + " to be loaded");

		} catch (Exception e) {
			log.error("The element" + ControlName + " not appeared due to" + e.getMessage());
		}
	}

	// press elemnet using javascript
	/**
	 * This function click on an element
	 * 
	 * @param driver
	 * @param btn_ID
	 * @param ctrlName
	 */
	public static void pressElement(WebDriver driver, By btn_ID, String ctrlName) {

		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("scroll(0, 250)");
			executor.executeScript("arguments[0].click();", driver.findElement(btn_ID));

			log.info("The " + ctrlName + " was pressed successfully");
		} catch (Exception e) {

			log.error("The " + ctrlName + " wasn't pressed as " + e.getMessage());
		}
	}

	// get current day number
	public static String getCurrentDay() {
		// Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);

		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);

		return todayStr;
	}

	// select n values from the combobox
	public static void selectComboValues(WebDriver driver, By by, int numberOfCheckedElements) {
		for (int i = 0; i <= numberOfCheckedElements; i++) {
			driver.findElement(by).click();// click on that combo

			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.DOWN).build().perform();// press down arrow key
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();// press enter
		}
	}

	// Method to double click on any button
	public static void doubleClickElement(WebDriver driver, By btn_ID, String ctrlName) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(btn_ID);
		// Double click
		for (int i = 0; i <= 2; i++) {
			action.doubleClick(element).perform();
		}
	}

	// scroll down
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 500);");

	}

	// Method to get the text of elements
	public static String getText(WebDriver driver, By lbl_Msg) {
		return driver.findElement(lbl_Msg).getText();
	}

	// scroll down
	public static void scrollUP(WebDriver driver) {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -500);");

	}

	// Get all the drop down list options text
	public static List<String> getAllOptions(By by, WebDriver driver) {
		List<String> options = new ArrayList<String>();
		for (WebElement option : new Select(driver.findElement(by)).getOptions()) {
			String txt = option.getText();
			if (option.getAttribute("value") != "")
				options.add(option.getText());
		}
		return options;
	}

	// remove element
	public static void removeElement(WebDriver driver, String elementName) {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("return document.getElementById('" + elementName + "').remove();");
	}

	public static void removeElementByVal(WebDriver driver, WebElement webelement) {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", webelement);
	}

	/**
	 * This function used to make a tab
	 * 
	 * @param driver
	 * @param element
	 */
	public static void pressTabButton(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		element.sendKeys(Keys.TAB);
	}

	/**
	 * Wait until element to be removed
	 * @param driver
	 * @param by
	 * @return
	 */
	final public static boolean waitForElementToBeRemove(WebDriver driver, final By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);

			boolean present = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

			return present;
		} catch (Exception e) {
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}
	}

	public  static void moveToTheNextTab(WebDriver driver)
	{
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}




	public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
