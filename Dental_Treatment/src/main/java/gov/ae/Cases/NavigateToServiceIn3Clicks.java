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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigateToServiceIn3Clicks {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(NavigateToServiceIn3Clicks.class.getName());
    XMLReader xml = new XMLReader("./src/main/resources/NavigateToServiceIn3ClicksLocators.xml");

    private By closebtn;
    private By usernametxt;
    private By passwordtxt;
    private By loginbtn;
    private By serviceMenu;
    private By serviceli;
    private int clicksCount;
    private By servicesrchtxt;
    private By servicesrchresullink;
    private By gotoservicelink;
    private By serviceusernametxt;
    private By servicepasswordtxt;
    private By servicesigninbtn;
    private By serviceappointmentsicon;
    private Navigation nav;
    ExtentReports report;
    ExtentTest test;
    public NavigateToServiceIn3Clicks(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        report = ExtentManager.getExtentReports();
        test = ExtentManager.getExtentTest();

    }

    public int validate_three_clicks_navigation() {
nav = new Navigation(driver);
        nav.navigate_to_services_page();
        test.log(Status.INFO," search for the service name ");
        servicesrchtxt = By.xpath(xml.getLocator("servicesrchtxt.xpath"));
        SeleniumUtils.wait(driver, servicesrchtxt, " service search Textbox");
        if (SeleniumUtils.isElementPresent(driver, servicesrchtxt, "Serch service control")) {
            clicksCount++;
        }
        SeleniumUtils.type(driver, servicesrchtxt, xml.getLocator("servicesrchtxt.value"), "UserName");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();// press enter

        test.log(Status.INFO,"  Click the search result ");
        servicesrchresullink = By.xpath(xml.getLocator("servicesrchresullink.xpath"));
        SeleniumUtils.wait(driver, servicesrchresullink, " search result");
        SeleniumUtils.pressElement(driver, servicesrchresullink, " serviceMenu Menu");

        test.log(Status.INFO," Click the go to service ");
        gotoservicelink = By.xpath(xml.getLocator("gotoservicelink.xpath"));
        SeleniumUtils.wait(driver, gotoservicelink, "Go to service");
        if (SeleniumUtils.isElementPresent(driver, gotoservicelink, "Go to service button")) {
            clicksCount++;
        }
        SeleniumUtils.pressElement(driver, gotoservicelink, " Go to service");

        SeleniumUtils.moveToTheNextTab(driver);

        test.log(Status.INFO," Enter the service user name \n");
        serviceusernametxt = By.xpath(xml.getLocator("serviceusernametxt.xpath"));
        SeleniumUtils.wait(driver, serviceusernametxt, " UserName Textbox");
        SeleniumUtils.type(driver, serviceusernametxt, xml.getLocator("serviceusernametxt.value"), "UserName");

        test.log(Status.INFO," Enter the service password \n");
        servicepasswordtxt = By.xpath(xml.getLocator("servicepasswordtxt.xpath"));
        SeleniumUtils.wait(driver, servicepasswordtxt, " Password Textbox");
        SeleniumUtils.type(driver, servicepasswordtxt, xml.getLocator("servicepasswordtxt.value"), "Password Textbox");

        test.log(Status.INFO," Click sign in button \n");
        servicesigninbtn = By.xpath(xml.getLocator("servicesigninbtn.xpath"));
        SeleniumUtils.wait(driver, servicesigninbtn, " Login button");
        SeleniumUtils.pressElement(driver, servicesigninbtn, " Login button");

        test.log(Status.INFO," Click the go to service \n");

        serviceappointmentsicon = By.xpath(xml.getLocator("serviceappointmentsicon.xpath"));
        SeleniumUtils.wait(driver, serviceappointmentsicon, "Appointment icon");
        if (SeleniumUtils.isElementPresent(driver, serviceappointmentsicon, "Appointment Icon")) {
            clicksCount++;
        }
        test.log(Status.INFO," The count of clicks is " + clicksCount);
        return clicksCount;

    }



}



