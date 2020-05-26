package gov.ae.Cases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import gov.ae.ExtentListeners.ExtentManager;
import gov.ae.utils.DriverManager;
import gov.ae.utils.SeleniumUtils;
import gov.ae.utils.XMLReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;

public class AbilityToMaxAndMinTheFontSize {
    private WebDriver driver;
    XMLReader xml = new XMLReader("./src/main/resources/AbilityToMaxAndMinThefFontSizeLocators.xml");
    private By closebtn;
    private By accessibilitybtn;
    private By plusbtn;
    private By minusbtn;
    ExtentReports report;
    ExtentTest test;
    public AbilityToMaxAndMinTheFontSize(WebDriver driver)
    {
        this.driver = DriverManager.getDriver();
        report = ExtentManager.getExtentReports();
        test = ExtentManager.getExtentTest();
    }
    public void Ability_to_max_and_min_the_font_size() {
        int fontsize = 0;

        test.log(Status.INFO,"Click close button");
        closebtn = By.xpath(xml.getLocator("closebtn.xpath"));
        SeleniumUtils.wait(driver, closebtn, "Close button of the welcome pop up");
        SeleniumUtils.pressElement(driver, closebtn, " The Welcome to Ministry of Health and Prevention Website close button");

        test.log(Status.INFO,"Click the accessibility button");
        accessibilitybtn = By.xpath(xml.getLocator("accessibilitybtn.xpath"));
        SeleniumUtils.wait(driver, accessibilitybtn, " accessibility button");
        SeleniumUtils.pressElement(driver, accessibilitybtn, "accessibility button");

        test.log(Status.INFO,"Click the + button");
        plusbtn = By.xpath(xml.getLocator("plusbtn.xpath"));
        SeleniumUtils.wait(driver, plusbtn, " accessibility button");
        SeleniumUtils.pressElement(driver, plusbtn, "accessibility button");

        WebElement domElement = driver.findElement(By.tagName("div"));
        String color = domElement.getCssValue("font-size");

        test.log(Status.INFO,"Click the - button");
        minusbtn = By.xpath(xml.getLocator("minusbtn.xpath"));
        SeleniumUtils.wait(driver, minusbtn, " minusbtn button");
        SeleniumUtils.pressElement(driver, minusbtn, "minusbtn button");

        WebElement domElement1 = driver.findElement(By.tagName("div"));
        String color1 = domElement.getCssValue("font-size");




    }

}
