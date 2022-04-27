package com.automation.web.tests.account;

import com.automation.web.driver.Driver;
import com.automation.web.helpers.RandomString;
import com.automation.web.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeleteAccount {
    protected Driver driver;
    protected HomePage homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void bootstrap(String browser, String url){
        driver = new Driver(browser);
        homePage = new HomePage(driver.getDriver(), url);
    }

    @BeforeMethod
    public void createAccount(){
        String password = RandomString.getAlphaNumericString(20);
        String email = password + "@gmail.com";
        homePage.createAccount(email, password);

    }
    @BeforeMethod
    public void checkUserIsLogged(){
        try {
            homePage.usernameExists();
        }
        catch (Exception e){
            System.out.println("There is no user logged in");
        }
    }

    @Test
    public void cancelAccount(){
        boolean result = homePage.cancelAccount();
        Assert.assertEquals(result, true);
    }
}
