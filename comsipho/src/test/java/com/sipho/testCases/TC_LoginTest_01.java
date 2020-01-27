package com.sipho.testCases;

import com.sipho.pageObjects.LoginPage;
import junit.framework.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_01 extends BaseClass{

    @Test
    public void loginTest() throws InterruptedException, IOException {
        LoginPage loginPg = new LoginPage(driver);
        loginPg.setUserName(username);
        loginPg.setPassword(password);
        loginPg.clickSubmit();

        try {
            if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
                Assert.assertTrue(true);
                logger.info("Login test passed");

            } else {
                takeScreenShot(driver, "loginTest");
                Assert.assertTrue(false);
                logger.info("Login test failed");
            }
        } catch (Exception e) {
            logger.info("getTitle exception handler");
        }

        try {
            this.PageDelay();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (isAlertPresent() == true) {
            //this.takeScreenShot(driver, "LoginTest");
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            logger.info("Test failed as a result of incorrect Username OR password");
            Assert.assertTrue(false);
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
