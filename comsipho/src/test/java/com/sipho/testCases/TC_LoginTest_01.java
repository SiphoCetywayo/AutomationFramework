package com.sipho.testCases;

import com.sipho.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

class TC_LoginTest_01 extends BaseClass {


    @Test
    public void LoginTest() throws IOException {
        logger.info("URL is reached");

        LoginPage loginPg = new LoginPage(driver);
        loginPg.setUserName(username);
        loginPg.setPassword(password);
        loginPg.clickSubmit();

        if (driver.getTitle().equals(actualResults)) {
            Assert.assertTrue(true);
            logger.info("Login test passed");

        } else {
            takeScreenShot(driver, "LoginTest");
            Assert.assertFalse(false);
            logger.info("Login test failed");
        }
    }

}