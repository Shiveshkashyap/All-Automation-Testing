package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    WebDriver driver;
    ExtentReports extent;

    @BeforeTest
    public void config(){

      String Path=  System.getProperty("user.dir")+"\\Reports\\index.html";// creating a Dyanmics folder in this project for Extent Report

//        ExtentReports , ExtentSparkReporter -- these 2 are very helpful for generating the report
        ExtentSparkReporter reporter =new ExtentSparkReporter(Path);// we have to give path for this so first creating a folder Dyanmically using Java, Above
//        Using reporter object we can change or arrange many things , check below
        reporter.config().setReportName("Automation Status");
        reporter.config().setDocumentTitle("Test Result");
// Ye main class hai Extent report , upr isiliye SparkReporter kiya kyuki config kr paye report
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Shivesh");
    }
    @Test
    public void DriverInit(){
//        extent.createTest("Title Validation of Page"); without creating object it will create a test after a execution
       ExtentTest test= extent.createTest("Title Validation of Page");// creating a object and trying to fail it using screenshot to capture failure
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());

        extent.flush();// it helps to monitor the extent to record all the status,flush is stop all these. after test execution
    }
}
