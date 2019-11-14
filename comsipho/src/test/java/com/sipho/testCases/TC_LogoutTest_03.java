package com.sipho.testCases;

import com.sipho.pageObjects.LoginPage;
import com.sipho.pageObjects.LogoutPage;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LogoutTest_03 extends BaseClass {

    @Test
    public void LogoutTest() throws IOException{
        LoginPage loginPage = new LoginPage(driver);
        LogoutPage logoutPage = new LogoutPage(driver);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickSubmit();

        if(isAlertPresent()==true)
        {
            driver.switchTo().alert().accept();//close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warn("Login failed");
        }
        else
        {
            Assert.assertTrue(true);
            logger.info("Login passed");
            logoutPage.clickLogout();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.switchTo().alert().accept();//close logout alert
            driver.switchTo().defaultContent();

        }
    }

    private boolean isAlertPresent() {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException e)
        {
            return false;
        }
    }
}
