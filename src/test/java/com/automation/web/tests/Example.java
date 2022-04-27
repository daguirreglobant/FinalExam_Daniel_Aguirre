package com.automation.web.tests;

import com.automation.web.data.DP;
import com.automation.web.driver.Driver;
import com.automation.web.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Example {
    protected Driver driver;
    protected HomePage homePage;


    @Test
    public void example(){
        driver = new Driver("chrome");
        homePage = new HomePage(driver.getDriver(), "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
        //System.out.println(homePage.login("ex1754@gmail.com", "password123"));
        homePage.logout();
    }
}
