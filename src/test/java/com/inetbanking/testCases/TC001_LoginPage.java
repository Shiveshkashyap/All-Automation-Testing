package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_LoginPage extends BaseClass {
// here we extend base class
@Test
    public void LoginTest(){
      driver.get(baseURL);
//      logger.info("Url is opened");
    LoginPage Lp = new LoginPage(driver);
    Lp.setUserName(Username);
//    logger.info("Entered UserName");
    Lp.password(password);
//    logger.info("Enter Password");
    Lp.ClickOnLogin();
//    logger.info("Successfully Login");

    if (driver.getTitle().equals("Guru99 Bank Manager HomePage")){
        Assert.assertTrue(true);
    }
    else {
        Assert.assertTrue(false);
    }
    }


}
