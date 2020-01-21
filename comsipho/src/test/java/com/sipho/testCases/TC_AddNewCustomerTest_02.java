package com.sipho.testCases;

import com.sipho.pageObjects.LoginPage;
import com.sipho.pageObjects.addCustomerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddNewCustomerTest_02 extends BaseClass{

    @Test
    public void AddNewCustomer() throws InterruptedException, IOException {
        LoginPage loginPg = new LoginPage(driver);
        loginPg.setUserName(username);
        loginPg.setPassword(password);
        loginPg.clickSubmit();

        PageDelay();//page delay with ref in BaseCLass.java

        addCustomerPage addCust = new addCustomerPage(driver);

        addCust.clickAddNewCustomer();

        logger.info("providing customer details....");


        addCust.custName("Anathi");
        addCust.custgender("female");
        addCust.custdob("10","15","1990");
        Thread.sleep(5000);
        addCust.custaddress("South Africa");
        addCust.custcity("CPT");
        addCust.custstate("SA");
        addCust.custpinno("47503629");
        addCust.custtelephoneno("0847187202");
        String email=randomestring()+"@gmail.com";
        addCust.custemailid(email);
        addCust.custpassword("123456");
        addCust.custsubmit();

        Thread.sleep(3000);

        logger.info("validation started....");

        boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(res==true)
        {
            Assert.assertTrue(true);
            logger.info("test case passed....");

        }
        else
        {
            logger.info("test case failed....");
            takeScreenShot(driver,"addNewCustomer");
            Assert.assertTrue(false);
        }
    }
}
