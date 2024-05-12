package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
     WebDriver driver;

    public   LoginPage(WebDriver rdriver){ // here constructor is public , so we will use this in another package as well

         driver = rdriver;
          PageFactory.initElements(rdriver,this);

     }

     @FindBy(name = "uid")
    WebElement txtUserName;

      @FindBy(name = "password")
    WebElement password;

      @FindBy(name = "btnLogin")
    WebElement LoginButton;

      public void setUserName(String UserName){
         txtUserName.sendKeys(UserName);
      }
    public void password(String pwd){
        password.sendKeys(pwd);
    }
    public void ClickOnLogin(){
        LoginButton.click();
    }


}
