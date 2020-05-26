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
import org.openqa.selenium.support.ui.Select;

public class Navigation {
    private static WebDriver driver;
    private static final Logger log = LogManager.getLogger(NavigateToServiceIn3Clicks.class.getName());
    private static XMLReader  xml = new XMLReader("./src/main/resources/NavigationLocators.xml"); ;

    private static By closebtn;
    private static By usernametxt;
    private static By passwordtxt;
    private static By loginbtn;
    private static By serviceMenu;
    private static By serviceli;
    private static int clicksCount;
    private static By servicesrchtxt;
    private static By servicesrchresullink;
    private static By gotoservicelink;
    private static By serviceusernametxt;
    private static By servicepasswordtxt;
    private static By servicesigninbtn;
    private static By serviceappointmentsicon;
    private static By  schedulenewappointmentbtn;
    private static By  reasonselect;
    private static By  searchreasonbtn;
    private static By viewallappointmentsbtn;
    private static By clinicselected;
    private static By selectappointmentbtn;

    private ExtentReports report;
    private ExtentTest test;
    public Navigation(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        report = ExtentManager.getExtentReports();
        test = ExtentManager.getExtentTest();

    }
    public  void navigate_to_services_page(){
        test.log(Status.INFO,"Click close button");
        closebtn = By.xpath(xml.getLocator("closebtn.xpath"));
        SeleniumUtils.wait(driver, closebtn, "Close button of the welcome pop up");
        SeleniumUtils.pressElement(driver, closebtn, " The Welcome to Ministry of Health and Prevention Website close button");

        test.log(Status.INFO," Hover over the service menu ");
        serviceMenu = By.xpath(xml.getLocator("serviceMenu.xpath"));
        SeleniumUtils.wait(driver, serviceMenu, " serviceMenu Menu");
        SeleniumUtils.pressElement(driver, serviceMenu, " serviceMenu Menu");

        test.log(Status.INFO,"  Click the service link ");
        serviceli = By.xpath(xml.getLocator("serviceli.xpath"));
        SeleniumUtils.wait(driver, serviceli, " Service list item");
        SeleniumUtils.pressElement(driver, serviceli, " Service list item");

        SeleniumUtils.scrollDown(driver);
    }

    public void navigate_to_dental_treatment_service()
    {
        test.log(Status.INFO," search for the service name ");
        servicesrchtxt = By.xpath(xml.getLocator("servicesrchtxt.xpath"));
        SeleniumUtils.wait(driver, servicesrchtxt, " service search Textbox");
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

        test.log(Status.INFO," Click appointments icon");
        serviceappointmentsicon = By.xpath(xml.getLocator("serviceappointmentsicon.xpath"));
        SeleniumUtils.wait(driver, serviceappointmentsicon, "appointments icon");
        SeleniumUtils.pressElement(driver, serviceappointmentsicon, "appointments icon");



    }

    public void navigate_to_add_appointment_page()
    {
        navigate_to_services_page();
        navigate_to_dental_treatment_service();




        test.log(Status.INFO," Click schedule an appointment button");
        schedulenewappointmentbtn = By.xpath(xml.getLocator("schedulenewappointmentbtn.xpath"));
        SeleniumUtils.wait(driver, schedulenewappointmentbtn, "schedule an appointment button");
        SeleniumUtils.pressElement(driver, schedulenewappointmentbtn, "schedule an appointment button");

        test.log(Status.INFO,"Select a value from reasons drop down list");
        reasonselect = By.xpath(xml.getLocator("reasonselect.xpath"));
        SeleniumUtils.wait(driver, reasonselect, "schedule an appointment button");
        SeleniumUtils.clickElement(driver, reasonselect, "schedule an appointment button");


        test.log(Status.INFO,"Select a value from reasons drop down list");
        reasonselect = By.xpath(xml.getLocator("reasonselect.value"));
        SeleniumUtils.wait(driver, reasonselect, "schedule an appointment button");
        SeleniumUtils.pressElement(driver, reasonselect, "schedule an appointment button");


        test.log(Status.INFO," Click the search button");
        searchreasonbtn = By.xpath(xml.getLocator("searchreasonbtn.xpath"));
        SeleniumUtils.wait(driver, searchreasonbtn, "schedule an appointment button");
        SeleniumUtils.pressElement(driver, searchreasonbtn, "schedule an appointment button");


        test.log(Status.INFO," Click the view all appointments button");
        viewallappointmentsbtn = By.xpath(xml.getLocator("viewallappointmentsbtn.xpath"));
        SeleniumUtils.wait(driver, viewallappointmentsbtn, "view all appointments button");
        SeleniumUtils.pressElement(driver, viewallappointmentsbtn, "view all appointments button");

        test.log(Status.INFO," Click the select appointment button");
        selectappointmentbtn = By.xpath(xml.getLocator("selectappointmentbtn.xpath"));
        SeleniumUtils.wait(driver, selectappointmentbtn, "select appointment button");
        SeleniumUtils.pressElement(driver, selectappointmentbtn, "select appointment button");




    }


}
