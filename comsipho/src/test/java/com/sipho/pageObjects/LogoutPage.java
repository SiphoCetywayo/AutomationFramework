package com.sipho.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    WebDriver localDriver;

    public LogoutPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);

    }

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
    @CacheLookup
    WebElement lnkLogout;

    public void clickLogout() {
        JavascriptExecutor js = (JavascriptExecutor)localDriver;
        js.executeScript("arguments[0].click();",lnkLogout);
    }
}

