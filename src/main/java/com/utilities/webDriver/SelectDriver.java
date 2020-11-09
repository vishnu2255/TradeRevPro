package com.utilities.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


public class SelectDriver {

    static WebDriver driver;

    public static WebDriver getDriver(String browser) throws Exception {
        if (browser.toLowerCase().equals("chrome")) {
            return getChromeDriver();
        }
        else if(browser.toLowerCase().equals("firefox")){
            return getGeckoDriver();
        }
        else
        {
            throw new Exception("browser not defined");
        }
    }

    public static WebDriver getChromeDriver()
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.acceptInsecureCerts();
//        desiredCapabilities.
        File resourcesDirectory = new File("src/test/resources");
        String path = resourcesDirectory.getAbsolutePath() + "/drivers/chromedriver";
        //setting relative path
        System.setProperty("webdriver.chrome.driver",path);
        driver = new ChromeDriver(desiredCapabilities);
        return driver;
    }

    public static WebDriver getGeckoDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.acceptInsecureCerts();
        File resourcesDirectory = new File("src/test/resources");
        String path = resourcesDirectory.getAbsolutePath() + "/drivers/geckodriver";
        //setting relative path
        System.setProperty("webdriver.gecko.driver",path);
        driver = new FirefoxDriver(desiredCapabilities);

        return driver;
    }

}
