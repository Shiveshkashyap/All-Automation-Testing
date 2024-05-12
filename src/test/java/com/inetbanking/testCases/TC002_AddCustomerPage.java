package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC002_AddCustomerPage extends BaseClass {

//    WebDriver driver;
    @Test
    public void NewCustomerDetails() throws InterruptedException, IOException {
        LoginPage Lp = new LoginPage(driver);
        Lp.setUserName(Username);
        Lp.password(password);
        Lp.ClickOnLogin();
        Thread.sleep(5000);

        AddCustomerPage ACP = new AddCustomerPage(driver);
        ACP.clickOnNewCustomer();
        ACP.enterCustomerName("Shivesh");
        ACP.SelectGender("Male");
        ACP.dateOfBirth("05","12","9999");
        ACP.address("India");
        ACP.enterCity("Kolkata");
        ACP.enterState("North24Praganas");
        ACP.enterPin("276483");
        ACP.enterMobileNo("7282332345");
        String CustomerEmail=randomString()+"@gmail.com";
        ACP.enterPassword("Qwerty123!");
        ACP.enterEmail(CustomerEmail);
        ACP.btnSelect();

        Thread.sleep(3000);

        boolean res =driver.getPageSource().contains("Customer Registered Successfully!!!");

//        if (res==true){
//            Assert.assertTrue(true);
//            System.out.println("Customer registered Successfully");;
//        }
//        else {
//            captureScreen(driver,"AddCustomerPage");
//            Assert.assertTrue(false);
//        }
    }

//    as email is valid one time only, we can using one email for one customer
//    so when we run this 2nd time, it will get error. For that we will create a mothod and
//    We will use Java to craete 5 or 8 digit random albhabetic, Example below

    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(8);// in this we way can generate random string in JAVA
        return (generatedString);
    }





}
