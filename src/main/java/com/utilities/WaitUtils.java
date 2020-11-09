package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    WebDriver driver;

   public WaitUtils(WebDriver driver)
    {
        this.driver = driver;
    }

    private static final long SHORT_TIMEOUT = 10;
    private static final long LONG_TIMEOUT = 25;
    private static final long MEDIUM_TIMEOUT = 20;

    public WebElement getElementAfterShortWait(WebElement ele)
    {
        return getElementAfterWait(ele,SHORT_TIMEOUT);
    }

    public WebElement getElementAfterLongWait(WebElement ele)
    {
        return getElementAfterWait(ele,LONG_TIMEOUT);
    }

    public WebElement getElementAfterMediumWait(WebElement ele)
    {
        return getElementAfterWait(ele,MEDIUM_TIMEOUT);
    }

    private WebElement getElementAfterWait(WebElement ele , long timeout)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return  wait.until(ExpectedConditions.visibilityOf(ele));
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
