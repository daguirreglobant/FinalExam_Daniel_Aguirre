package com.automation.web.tests.session;

import com.automation.web.driver.Driver;
import com.automation.web.helpers.RandomString;
import com.automation.web.pages.HomePage;
import org.testng.annotations.*;

public abstract class Session {
    protected Driver driver;
    protected HomePage homePage;
    protected String email;
    protected String password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void bootstrap(String browser, String url){
        driver = new Driver(browser);
        homePage = new HomePage(driver.getDriver(), url);
        //this.createAccount();
    }

    protected void createAccount(){
        this.password = RandomString.getAlphaNumericString(20);
        this.email = this.password + "@gmail.com";
        homePage.createAccount(this.email, this.password);
    }

    protected void checkUserIsLogged(){
        homePage.usernameExists();
    }

}
