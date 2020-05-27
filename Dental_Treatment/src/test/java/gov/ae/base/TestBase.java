package gov.ae.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import gov.ae.ExtentListeners.ExtentManager;
import gov.ae.utils.Constants;
import gov.ae.utils.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Date;

import static gov.ae.utils.SeleniumUtils.TakeScreenshot;

public class TestBase {
    private static WebDriver driver;
    private String baseUrl;
    static ExtentReports report;
    ExtentTest test;
    long start;
    long finish;
    long totalTime;

    private static final Logger log = LogManager.getLogger(TestBase.class.getName());

    @BeforeSuite
    public void setupExtendReport() {
        setExtentReports();

        ExtentManager.setExtentReport(report);
    }

    @BeforeMethod
    public void setUp() {

        setupChrome();
        DriverManager.setWebDriver(driver);
        try {
            Constants.setConstants();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage());
        }
        baseUrl = Constants.SITE_URL;
        driver.manage().window().maximize();
        driver.get(baseUrl);
        start = System.currentTimeMillis();

        log.info("Web application opened");

    }

    public void setupChrome() {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/executables/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        finish =System.currentTimeMillis();
        totalTime = finish-start;
        test = ExtentManager.getExtentTest();
        if (result.getStatus() == ITestResult.FAILURE) {
            //MarkupHelper is used to display the output in different colors
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.

            //	String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
            String screenshotPath = TakeScreenshot(driver, result.getName());
            //To add it in the extent report

            test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));


        } else if (result.getStatus() == ITestResult.SKIP) {
            //logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        }

        test.log(Status.INFO,"The testcase took" + totalTime+ " milliseconds to be executed");
        driver.quit();
    }

    public static void setExtentReports() {
        Date d = new Date();
        String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

        report = ExtentManager.createInstance(System.getProperty("user.dir") + "\\Reports\\" + fileName);

    }

    @AfterSuite
    public void afterClass() {
        report.flush();
    }


}
