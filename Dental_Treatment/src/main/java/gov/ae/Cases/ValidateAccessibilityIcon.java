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
import org.openqa.selenium.WebElement;

public class ValidateAccessibilityIcon {
    private WebDriver driver;
    XMLReader xml = new XMLReader("./src/main/resources/checkAccessibilityLocators.xml");
    private By closebtn;
    private static By accessibilityIcon;
    private By plusbtn;
    private By minusbtn;

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
        SeleniumUtils.wait(driver, accessibilityIcon, "Close button of the welcome pop up");
        SeleniumUtils.pressElement(driver, accessibilityIcon, " The Welcome to Ministry of Health and Prevention Website close button");

        return SeleniumUtils.isElementPresent(driver, accessibilityIcon, "Accessibility Icon");
    }

    public void accessibility_plus_func()
    {

        plusbtn = By.xpath(xml.getLocator("plusbtn.xpath"));
        SeleniumUtils.wait(driver, plusbtn, "Close button of the welcome pop up");
        SeleniumUtils.pressElement(driver, plusbtn, " The Welcome to Ministry of Health and Prevention Website close button");
        plusbtn = By.xpath(xml.getLocator("changeTextSizeControl.xpath"));


    }

    public void accessibility_minus_func()
    {
        minusbtn = By.xpath(xml.getLocator("minusbtn.xpath"));
        SeleniumUtils.wait(driver, minusbtn, "Close button of the welcome pop up");
        SeleniumUtils.pressElement(driver, minusbtn, " The Welcome to Ministry of Health and Prevention Website close button");
        minusbtn = By.xpath(xml.getLocator("changeTextSizeControl.xpath"));

    }

    public void check_accessibility_minus_func(){

        WebElement body = driver.findElement(By.xpath(".//div[@id='ctl00_Refferences1']//parent::body"));
       System.out.println(body.getCssValue("font-size"));



    }


}
