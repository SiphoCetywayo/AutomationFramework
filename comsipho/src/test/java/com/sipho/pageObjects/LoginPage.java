package com.sipho.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver localDriver;

    public LoginPage(WebDriver remoteDriver){
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(name="uid")
    @CacheLookup
    WebElement txtUserName;

    @CacheLookup
    @FindBy(name="password")
    WebElement txtPassword;

    @CacheLookup
    @FindBy(name="btnLogin")
    WebElement btnLogin;

    @CacheLookup
    @FindBy(name = "title")
    WebElement title;

    public void setUserName(String uName){
        txtUserName.sendKeys(uName);
    }

    public void setPassword(String uPassword){
        txtPassword.sendKeys(uPassword);
    }

    public void clickSubmit(){
        btnLogin.click();
    }
}
