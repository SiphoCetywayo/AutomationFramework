package com.sipho.testCases;

import com.sipho.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getMyApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static Logger logger;
    public String actualResults = readConfig.getSiteTitle();
    public static WebDriver driver;


    //The set up method is responsible to check which web browser a test is running against
    @Parameters("browser")
    @BeforeClass
    public void setUp(String wbBrowser) {
        logger = Logger.getLogger("onlineBanking");
        PropertyConfigurator.configure("Log4j.properties");
        if (wbBrowser.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());
            driver = new ChromeDriver();

        } else if (wbBrowser.equals("firefox")) {

            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }

        driver.get(baseURL);

    }

    public void takeScreenShot(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public String randomestring()
    {
        String generatedstring= RandomStringUtils.randomAlphabetic(8);
        return(generatedstring);
    }

    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return (generatedString2);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
