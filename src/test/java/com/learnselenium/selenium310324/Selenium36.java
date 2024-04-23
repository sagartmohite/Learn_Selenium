package com.learnselenium.selenium310324;

import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium36
{
    // Atomic Test Cases
    // TC who don't have any dep.
    // They serve single purpose 0


    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test
    @Description("Test case Description")
    public void positiveTest() throws InterruptedException {
        String url = "https://www.makemytrip.com/";
        driver.get(url);

        Actions actions = new Actions(driver);
        Thread.sleep(10000);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(10000);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(10000);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(10000);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(10000);
        System.out.println("Scroll Dowm");



    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
