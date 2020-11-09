package com.pages;

import com.utilities.WaitUtils;
import com.utilities.reader.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[text()=' Careers ']")
    WebElement careersLink;

    private WaitUtils waitUtils;
    private WebDriver driver;
    private TestDataReader testDataReader;

   public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        testDataReader = new TestDataReader();
    }

    public void navigateToCareersPage(){
       clickElement(careersLink);
    }

}
