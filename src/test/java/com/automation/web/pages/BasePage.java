package com.automation.web.pages;

import com.automation.web.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    protected JavascriptExecutor js;
    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 20);
        this.js = (JavascriptExecutor) driver;
        this.driver = driver;
    }

    protected WebDriver getDriver(){
        return this.driver;
    }

    protected WebDriverWait getWait(){
        return this.wait;
    }
    protected JavascriptExecutor getJs(){
        return this.js;
    }

    protected WebDriverWait getWait(int timeOut){
        return  new WebDriverWait(driver, timeOut);
    }


}
