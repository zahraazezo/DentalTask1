package gov.ae.Cases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import gov.ae.ExtentListeners.ExtentManager;
import gov.ae.utils.DriverManager;
import gov.ae.utils.SeleniumUtils;
import gov.ae.utils.XMLReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidateAccessibilityIcon {
    private WebDriver driver;
    XMLReader xml = new XMLReader("./src/main/resources/checkAccessibilityLocators.xml");
    private By closebtn;
    private static By accessibilityIcon;

    public ValidateAccessibilityIcon ()
    {
        this.driver = DriverManager.getDriver();
    }
    public boolean checkAccessibilityIcon()
    {
        closebtn = By.xpath(xml.getLocator("closebtn.xpath"));
        SeleniumUtils.wait(driver, closebtn, "Close button of the welcome pop up");
        SeleniumUtils.pressElement(driver, closebtn, " The Welcome to Ministry of Health and Prevention Website close button");
        accessibilityIcon = By.xpath(xml.getLocator("changeTextSizeControl.xpath"));
        return SeleniumUtils.isElementPresent(driver, accessibilityIcon, "Accessibility Icon");
    }



}
