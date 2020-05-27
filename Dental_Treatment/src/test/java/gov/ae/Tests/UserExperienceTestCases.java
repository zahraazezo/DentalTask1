package gov.ae.Tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import gov.ae.Cases.*;
import gov.ae.ExtentListeners.ExtentManager;
import gov.ae.base.TestBase;
import gov.ae.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UserExperienceTestCases extends TestBase {



    ExtentReports report ;
    ExtentTest test;
    ExtentTest parentTest;

    @Test(priority = 1 )
    public void validate_three_clicks_navigation() {
        report = ExtentManager.getExtentReports();
        test = report.createTest("Validate user can navigate to service page by 3 clicks");
        ExtentManager.setExtentTest(test);
        NavigateToServiceIn3Clicks userCases = new NavigateToServiceIn3Clicks(DriverManager.getDriver());
        int count = userCases.validate_three_clicks_navigation();
        Assert.assertTrue(count == 3);
    }

    @Test(priority = 2 )
    public void validate_national_identity_option() {
        test = report.createTest("Validate user can access services via national ID");
        ExtentManager.setExtentTest(test);
        UserCanLoginViaNationalID userCases = new UserCanLoginViaNationalID(DriverManager.getDriver());
        boolean valid = userCases.validate_national_identity_option();
        Assert.assertTrue(valid);

    }
    @Test(priority = 3 )
    public void Ability_to_max_and_min_the_font_size() {
        test = report.createTest("Validate user can access services via national ID");
        ExtentManager.setExtentTest(test);
        AbilityToMaxAndMinTheFontSize userCases = new AbilityToMaxAndMinTheFontSize(DriverManager.getDriver());
         userCases.Ability_to_max_and_min_the_font_size();

    }

    @Test(priority = 4)
    public void validate_symptoms_required_field() {
        test = report.createTest("Validate that the required fields have validation messages");
        ExtentManager.setExtentTest(test);
        ExtentTest node = test.createNode("validate symptoms validations");
        ExtentManager.setExtentTest(node);
        ValidateReuiredFields userCases = new ValidateReuiredFields(DriverManager.getDriver());
        userCases.confirm_appointment();
        Assert.assertEquals(userCases.get_actual_contactsymptomserrorlbl(),userCases.get_expected_contactsymptomserrorlbl());




    }
    @Test(priority = 5 )
    public void validate_contact_required_field() {
        ValidateReuiredFields userCases = new ValidateReuiredFields(DriverManager.getDriver());
        test = test.createNode("validate contact method validations");
        ExtentManager.setExtentTest(test);
        userCases.confirm_appointment();
        Assert.assertEquals(userCases.get_actual_contactprefererrorlbl(),userCases.get_expected_contactprefererrorlbl());



    }

    @Test(priority = 6)
    public void validate_phone_required_field() {
        ValidateReuiredFields userCases = new ValidateReuiredFields(DriverManager.getDriver());
        test = test.createNode("validate contact method validations");
        ExtentManager.setExtentTest(test);
        userCases.confirm_appointment();
        userCases.check_phone_contact();
        Assert.assertEquals(userCases.get_actual_contactbyphoneerrorlbl(),userCases.get_expected_contactbyphoneerrorlbl());

    }

    @Test(priority = 7)
    public void validateAccessibilityIcon() {
        test = report.createTest("validate Accessibility Icon");
        ExtentManager.setExtentTest(test);
        ValidateAccessibilityIcon validate = new ValidateAccessibilityIcon();
        validate.checkAccessibilityIcon();
    }




}
