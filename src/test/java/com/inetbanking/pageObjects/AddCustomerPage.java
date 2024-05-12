package com.inetbanking.pageObjects;

import com.inetbanking.testCases.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage  {

    WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
        ldriver= rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
    @CacheLookup
    WebElement linkAddNewMember;

    @FindBy(how = How.NAME,using = "name")
    @CacheLookup
    WebElement txtCustomerName;

    @FindBy(how = How.NAME,using = "rad1")
    @CacheLookup
    WebElement genderSelect;
    @FindBy(how = How.NAME,using = "dob")
    @CacheLookup
    WebElement dateOfBirth;
    @FindBy(how = How.NAME,using = "addr")
    @CacheLookup
    WebElement txtAddressDetail;
    @FindBy(how = How.NAME,using = "city")
    @CacheLookup
    WebElement txtCity;
    @FindBy(how = How.NAME,using = "state")
    @CacheLookup
    WebElement txtState;
    @FindBy(how = How.NAME,using = "pinno")
    @CacheLookup
    WebElement txtPIn;
    @FindBy(how = How.NAME,using = "telephoneno")
    @CacheLookup
    WebElement txtPhoneNumber;
    @FindBy(how = How.NAME,using = "emailid")
    @CacheLookup
    WebElement txtEmailId;
    @FindBy(how = How.NAME,using = "password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(how = How.XPATH,using = "//input[@type='submit']")
    @CacheLookup
    WebElement SelectBtn;

    public void clickOnNewCustomer(){
        linkAddNewMember.click();
    }
    public void enterCustomerName(String customerName){
        txtCustomerName.sendKeys(customerName);
    }
    public void SelectGender(String cgender){
        genderSelect.click();
    }
    public void dateOfBirth(String mm , String dd ,String yyyy ){
        dateOfBirth.sendKeys(mm);
        dateOfBirth.sendKeys(dd);
        dateOfBirth.sendKeys(yyyy);
    }
    public void address(String adrs){
        txtAddressDetail.sendKeys(adrs);
    }
    public void enterCity(String cityName){
        txtCity.sendKeys(cityName);
    }
    public void enterState(String stateName){
        txtState.sendKeys(stateName);
    }
    public void enterPin(String PINNum){
        txtPIn.sendKeys(PINNum);
    }
    public void enterMobileNo(String phnNumb){
        txtPhoneNumber.sendKeys(phnNumb);
    }
    public void enterEmail(String EmailId){
        txtEmailId.sendKeys(EmailId);
    }
    public void enterPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }
    public void btnSelect(){
        SelectBtn.click();
    }





}
