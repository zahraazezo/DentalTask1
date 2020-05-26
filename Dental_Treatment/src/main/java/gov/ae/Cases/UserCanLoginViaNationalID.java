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

public class UserCanLoginViaNationalID {
    private WebDriver driver;
    XMLReader xml = new XMLReader("./src/main/resources/UserCanLoginViaNationalIDLocators.xml");
    ExtentReports report;
    ExtentTest test;
    private By loginlink;
    private By UAEPassLoginEnimg;
    private By userIdentifiertxt;
    private By closebtn;




    public UserCanLoginViaNationalID(WebDriver driver)
    {
        this.driver = DriverManager.getDriver();
        report = ExtentManager.getExtentReports();
        test = ExtentManager.getExtentTest();
    }

    public boolean validate_national_identity_option() {

        boolean valid = false;
        test.log(Status.INFO,"Click close button");
        closebtn = By.xpath(xml.getLocator("closebtn.xpath"));
        SeleniumUtils.wait(driver, closebtn, "Close button of the welcome pop up");
        SeleniumUtils.clickElement(driver, closebtn, " The Welcome to Ministry of Health and Prevention Website close button");

        test.log(Status.INFO,"Hit the login/register link");
        loginlink = By.xpath(xml.getLocator("loginlink.xpath"));
        SeleniumUtils.wait(driver, loginlink, " Register/Login link");
        SeleniumUtils.clickElement(driver, loginlink, " Register/Login");

        SeleniumUtils.moveToTheNextTab(driver);

        test.log(Status.INFO,"Click the UAE pass login image ");
        UAEPassLoginEnimg = By.xpath(xml.getLocator("UAEPassLoginEnimg.xpath"));
        SeleniumUtils.wait(driver, UAEPassLoginEnimg, " UAEPassLoginEnimg image");
        SeleniumUtils.clickElement(driver, UAEPassLoginEnimg, " UAEPassLoginEnimg");


        test.log(Status.INFO," search for user Identifier ");
        userIdentifiertxt = By.xpath(xml.getLocator("userIdentifiertxt.xpath"));
        SeleniumUtils.wait(driver, userIdentifiertxt, " user Identifier Textbox");
        if (SeleniumUtils.isElementPresent(driver, userIdentifiertxt, "user Identifier textbox")) {
            valid = true;
        }

        else {
            valid = false;
        }
        return valid;




    }
}
