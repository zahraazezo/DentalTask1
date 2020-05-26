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

public class ValidateReuiredFields {
    private WebDriver driver;
    XMLReader xml = new XMLReader("./src/main/resources/ValidateReuiredFields.xml");
    ExtentReports report;
    ExtentTest test;
    private By loginlink;
    private By UAEPassLoginEnimg;
    private By userIdentifiertxt;
    private By closebtn;
    private By confirmappointmentbtn;
    private By contactsymptomserrorlbl;
    private By contactprefererrorlbl;
    private By contactbyphonechk;
    private By contactbyphoneerrorlbl;
    Navigation nav;

    public ValidateReuiredFields(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        report = ExtentManager.getExtentReports();
        test = ExtentManager.getExtentTest();
    }

    public String get_actual_contactsymptomserrorlbl() {
        String symptomserrorMsg = SeleniumUtils.getText(driver, By.xpath(xml.getLocator("contactsymptomserrorlbl.xpath")));
        return symptomserrorMsg;
    }

    public String get_expected_contactsymptomserrorlbl() {
        String symptomserrorMsgtext = xml.getLocator("contactsymptomserrorlbl.value");
        return symptomserrorMsgtext;
    }


    public String get_actual_contactprefererrorlbl() {
        String preferredserrorMsg = SeleniumUtils.getText(driver, By.xpath(xml.getLocator("contactprefererrorlbl.xpath")));
        return preferredserrorMsg;
    }

    public String get_expected_contactprefererrorlbl() {
        String contactprefererrorMsgtext = xml.getLocator("contactprefererrorlbl.value");
        return contactprefererrorMsgtext;
    }

    public String get_actual_contactbyphoneerrorlbl() {
        String contactbyphoneerrorMsg = SeleniumUtils.getText(driver, By.xpath(xml.getLocator("contactbyphoneerrorlbl.xpath")));
        return contactbyphoneerrorMsg;
    }

    public String get_expected_contactbyphoneerrorlbl() {
        String contactbyphoneerrorMsgtext = xml.getLocator("contactbyphoneerrorlbl.value");
        return contactbyphoneerrorMsgtext;
    }


    public void confirm_appointment() {
         nav = new Navigation(driver);
        nav.navigate_to_add_appointment_page();
        test.log(Status.INFO, " Click the confirm appointment button");
        confirmappointmentbtn = By.xpath(xml.getLocator("confirmappointmentbtn.xpath"));
        SeleniumUtils.wait(driver, confirmappointmentbtn, "confirm appointment button");
        SeleniumUtils.pressElement(driver, confirmappointmentbtn, "confirm appointment button");
    }

    public void check_phone_contact() {
        test.log(Status.INFO, " select contact By phone ");
        contactbyphonechk = By.xpath(xml.getLocator("contactbyphonechk.xpath"));
        SeleniumUtils.wait(driver, contactbyphonechk, "contact by phone radio button");
        SeleniumUtils.pressElement(driver, contactbyphonechk, "contact by phone radio button");

        test.log(Status.INFO, " Click the confirm appointment button");
        confirmappointmentbtn = By.xpath(xml.getLocator("confirmappointmentbtn.xpath"));
        SeleniumUtils.wait(driver, confirmappointmentbtn, "confirm appointment button");
        SeleniumUtils.pressElement(driver, confirmappointmentbtn, "confirm appointment button");
    }



}
