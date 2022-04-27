package com.automation.web.data;

import org.testng.annotations.DataProvider;

public class DP {

    @DataProvider(name = "login-users")
    public Object[][] loginExamples(){
        Object [][] logins = {{"ex1754@gmail.com", "password123", true},{"example@gmail.com","ajdsdo", false},};
        return logins;
    }

}
