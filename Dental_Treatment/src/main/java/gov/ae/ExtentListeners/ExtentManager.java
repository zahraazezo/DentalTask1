package gov.ae.ExtentListeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager {

	private static ExtentReports extent;
	public static ExtentTest test;
	
	

	    public static ExtentReports createInstance(String fileName) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Rahul Arora");
	        extent.setSystemInfo("Organization", "Way2Automation");
	        extent.setSystemInfo("Build no", "W2A-1234");
	        
	        
	        return extent;
	    }


	public static ExtentReports getExtentReports() {

		return extent ;

	}
	public static ExtentTest getExtentTest() {

		return test ;

	}


	public static void setExtentTest(ExtentTest ExtentTest) {
		test = ExtentTest;

	}

	public static void setExtentReport(ExtentReports ExtentTest) {
		extent = ExtentTest;

	}



	

	}
