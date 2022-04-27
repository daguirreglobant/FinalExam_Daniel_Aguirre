package com.automation.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{
    @FindBy(id = "global-user-trigger")
    WebElement globalAccount;

    @FindBy(css = ".display-user span")
    WebElement userName;

    @FindBy(css = "[tref='/members/v3_1/login']")
    WebElement loginRef;

    @FindBy(css=".input-wrapper input[type='email']")
    WebElement emailInput;

    @FindBy(css=".input-wrapper [type='password']")
    WebElement passwordInput;

    @FindBy(css=".btn.btn-primary.btn-submit.ng-isolate-scope")
    WebElement loginButton;

    @FindBy(css=".account-management li:last-child a")
    WebElement logoutButton;

    @FindBy(css = "a[tref='/members/v3_1/modifyAccount']")
    WebElement modifyAccount;

    @FindBy(css=".input-wrapper input[name='current-password']")
    WebElement cancelAccountRef;

    @FindBy(css = "button[type='submit']")
    WebElement confirmCancelation;

    @FindBy(css = "a[did-translate='login.label.CREATE_ACCOUNT']")
    WebElement signUpRef;

    @FindBy(css = "input[name='firstName']")
    WebElement firstNameInput;

    @FindBy(css = "input[name='lastName']")
    WebElement lastNameInput;

    @FindBy(css = ".btn.btn-primary.ng-scope.ng-isolate-scope")
    WebElement signUpButton;

    @FindBy(css = ".title.title-primary.ng-isolate-scope")
    WebElement updateYourAccount;

    public HomePage(WebDriver driver, String url){
        super(driver);
        driver.get(url);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password){
        this.globalAccount.click();
        this.loginRef.click();
        driver.switchTo().frame("disneyid-iframe");
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();

    }

    public void logout(){
        this.globalAccount.click();
        this.logoutButton.click();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        //this.getWait().until(ExpectedConditions.elementToBeClickable(this.globalAccount));
        //this.globalAccount.click();
        //return !this.usernameExists();
    }

    public boolean cancelAccount(){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.globalAccount));
        this.globalAccount.click();
        this.modifyAccount.click();
        driver.switchTo().frame("disneyid-iframe");
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.updateYourAccount));
        //this is not working, I tried multiple approaches but none of them worked.
        //this.getJs().executeScript("window.scrollBy(0,document.body.height)");
        //this.getJs().executeScript("arguments[0].scrollIntoView(true);", this.cancelAccountRef);
        try{
            this.cancelAccountRef.click();
            this.confirmCancelation.click();
            return true;
        }
        catch (Exception ignore){
            return false;
        }
    }

    public void createAccount(String email, String password){
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.globalAccount));
        this.globalAccount.click();
        this.loginRef.click();
        driver.switchTo().frame("disneyid-iframe");
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.signUpRef));
        this.signUpRef.click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.firstNameInput));
        this.firstNameInput.sendKeys("firstName example");
        this.lastNameInput.sendKeys("lastName example");
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
        this.getJs().executeScript("arguments[0].scrollIntoView();", this.signUpButton);
        this.signUpButton.click();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.globalAccount));

    }

    public boolean usernameExists(){
        try {
            this.getWait(5).until(ExpectedConditions.elementToBeClickable(this.globalAccount));
            this.globalAccount.click();
            return this.userName.getText().length() > 0 ? true : false;
        }
        catch (Exception ignore){
            return false;
        }
    }

    public void closeDriver(){
        this.driver.close();
    }
}
