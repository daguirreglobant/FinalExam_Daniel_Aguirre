package com.automation.web.tests.account;

import com.automation.web.driver.Driver;
import com.automation.web.helpers.RandomString;
import com.automation.web.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class DeleteAccount {
    protected Driver driver;
    protected HomePage homePage;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void bootstrap(String browser, String url){
        driver = new Driver(browser);
        homePage = new HomePage(driver.getDriver(), url);
    }

    @BeforeClass
    public void createAccount(){
        String password = RandomString.getAlphaNumericString(20);
        String email = password + "@gmail.com";
        homePage.createAccount(email, password);

    }
    @BeforeMethod
    public void checkUserIsLogged(){
        try {
            boolean isLogged = homePage.usernameExists();
            if (!isLogged){
                throw new Exception("There is no user logged in");
            }
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

    @AfterClass
    public void close(){
        homePage.closeDriver();
    }
}
