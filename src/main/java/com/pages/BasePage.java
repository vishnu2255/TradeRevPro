package com.pages;

import com.utilities.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver){
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickElement(WebElement element){
       try{
        waitUtils.getElementAfterMediumWait(element);
        element.click();
        }catch (Exception e){
           JavascriptExecutor js = (JavascriptExecutor)(driver);
           js.executeScript("arguments[0].click()",element);}
        }

}
