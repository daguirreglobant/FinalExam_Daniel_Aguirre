package com.automation.web.tests.session;

import com.automation.web.helpers.RandomString;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logout extends Session{
    @BeforeMethod
    @Override
    public void createAccount(){
        super.createAccount();
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
    public void logOut(){
        homePage.logout();
        boolean isLoggedOut = !homePage.usernameExists();
        Assert.assertEquals(isLoggedOut, true);
    }

    @BeforeMethod
    public void close(){
        homePage.closeDriver();
    }
}
