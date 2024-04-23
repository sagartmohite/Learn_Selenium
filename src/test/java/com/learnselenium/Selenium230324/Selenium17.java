package com.learnselenium.Selenium230324;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium17
{
    // Atomic Test Cases
    // TC who don't have any dep.
    // They serve single purpose 0

    WebDriver driver;

    @BeforeTest()
    public void openBrowser()
    {
        // Create Session via the API and Session ID is generated
        driver = new EdgeDriver();

    }

    @BeforeTest()
    public void openBrowser2()
    {
        // Create Session via the API and Session ID is generated
        driver = new FirefoxDriver();

    }

    @Test(groups = "QA", priority = 1)
    public void vwoLogintest_Positive ()
    {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test(groups = "QA", priority = 2)
    @Description("Test Case Description")
    public void testVWOLogin_negative() throws InterruptedException {
        driver.get("https://google.com");
        //driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser()
    {
        // Create Session via the API and Session ID is generated
        driver.close();
    }
}
