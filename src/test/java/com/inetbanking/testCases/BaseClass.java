package com.inetbanking.testCases;

import com.inetbanking.testUtilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    public String baseURL= readConfig.getApplicationUrl();
    public String Username = readConfig.getUserName();
    public String password = readConfig.getPassword();
    public String Desc =readConfig.getTitle();

//    public static Logger logger;


    public static WebDriver driver;
    @Parameters("Browser")
    @BeforeClass
    public void setup(String br){
        /*
     WebDriverManager.chromedriver().setup();
        // Incase if we need another driver as well, this is example .
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        System.setProperty("webdriver.chrome.driver",System.getProperty(System.getProperty("user.dir")+"//Drivers//chromedriver.exe") );
         Once the configuration file is created then we can write like this
        System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
        // The above one is  not needed if we are using Webmanager.
        driver = new ChromeDriver();// initiated chrome driver
        driver = new EdgeDriver();
       driver = new FirefoxDriver();

       Logger setup Below: for extracting the log , part of Setup.
        logger = Logger.getLogger("ebanking");
       PropertyConfigurator.configure("log4j.properties");*/


//***********Below the neccessary only code*****
        if (br.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (br.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (br.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        driver.get(baseURL);
        // here we cam also right because this is also common, we can omit to right it in Test case

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void captureScreen(WebDriver driver,String tname) throws IOException{
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("./user.dir/ScreenShot"+tname+".png"));
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot taken");
    }

}
