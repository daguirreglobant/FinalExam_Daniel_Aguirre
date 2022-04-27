package com.automation.web.tests.session;

import com.automation.web.driver.Driver;
import com.automation.web.helpers.RandomString;
import com.automation.web.pages.HomePage;
import org.testng.annotations.*;

public abstract class Session {
    protected Driver driver;
    protected HomePage homePage;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void bootstrap(String browser, String url){
        driver = new Driver(browser);
        homePage = new HomePage(driver.getDriver(), url);
    }

    public void createAccount(){
        String password = RandomString.getAlphaNumericString(20);
        String email = password + "@gmail.com";
        homePage.createAccount(email, password);

    }
}
