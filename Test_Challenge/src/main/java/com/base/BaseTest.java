package com.base;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private WebDriver driver;

    protected Properties prop = new PropertyReader().getDataProp();

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                new File("Drivers" + File.separator + "chromedriver.exe").getAbsolutePath());
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to(new PropertyReader().getSiteProp().getProperty("url"));
    }

    /**
     * Returns WebDriver Initialized
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Closes WebDriver Initialized
     */
    @AfterClass
    public void closeDriver() {
        driver.close();
    }

    /**
     * Quit WebDriver Initialized
     */
    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }
}
