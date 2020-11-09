package com.pages;


import com.utilities.WaitUtils;
import com.utilities.reader.TestDataReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class CareersPage extends BasePage {

    private WebDriver driver;
    private WaitUtils waitUtils;
    private TestDataReader testDataReader;

    public CareersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        testDataReader = new TestDataReader();
    }


    @FindBy(xpath = "//a[contains(text(),'Canadian Opportunities')]")
    WebElement canadianOpportunitiesLink;

    @FindBy(xpath = "//a[contains(text(),'U.S. Opportunities')]")
    WebElement usOpportunitiesLink;



    public void validateCareersPageLoaded(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Assert.assertTrue("careers page not loaded correctly ",currentURL.contains(testDataReader.readData("careersUrl")));
        Assert.assertTrue("careers page not loaded correctly ",canadianOpportunitiesLink.isDisplayed());
        Assert.assertTrue("careers page not loaded correctly ",usOpportunitiesLink.isDisplayed());
    }

    public void navigateToCanadianJobPortal(){
        clickElement(canadianOpportunitiesLink);
    }

    public void navigateToUSJobPortal(){
        clickElement(usOpportunitiesLink);
    }



}
