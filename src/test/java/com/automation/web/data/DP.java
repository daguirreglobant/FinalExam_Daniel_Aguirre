package com.automation.web.data;

import org.testng.annotations.DataProvider;

public class DP {

    @DataProvider(name = "login-users")
    public Object[][] loginExamples(){
        Object [][] logins = {{"example@gmail.com","ajdsdo", false}};
        return logins;
    }

}
