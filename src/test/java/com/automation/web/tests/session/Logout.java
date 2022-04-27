package com.automation.web.tests.session;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logout extends Session{
    @BeforeMethod
    public void createNewAccount(){
        super.createAccount();
    }


    @BeforeMethod
    @Override
    public void checkUserIsLogged(){
        try {
            super.checkUserIsLogged();
        }
        catch (Exception e){
            System.out.println("There is no user logged in");
        }
    }

    @Test
    public void logOut(){
        boolean result = homePage.logout();
        Assert.assertEquals(true, result);
    }
}
