package com.automation.web.tests.session;

import com.automation.web.data.DP;
import com.automation.web.helpers.RandomString;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends Session{


    /*@BeforeMethod
    public void checkUserIsLogged(){
        try {
            if (homePage.usernameExists()) {
                throw new Exception("A user is already logged in");
            }
        }
        catch (Exception ignore){}
    }*/

    @Test(dataProvider = "login-users", dataProviderClass = DP.class)
    public void login(String email, String password, boolean expected){
        homePage.login(email, password);
        Assert.assertEquals(homePage.usernameExists(), expected, "An error occured in the log in!");
    }

    @AfterMethod
    public void logOutAfterTest(){
        try {
            homePage.logout();
        }
        catch (Exception ignore){}
        homePage.closeDriver();
    }
}
