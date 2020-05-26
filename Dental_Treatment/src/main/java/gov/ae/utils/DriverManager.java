package gov.ae.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	public static WebDriver driver;

	public static WebDriver getDriver() {

		return driver ;

	}

	public static void setWebDriver(WebDriver webDriver) {

		driver = webDriver;
	}

}
