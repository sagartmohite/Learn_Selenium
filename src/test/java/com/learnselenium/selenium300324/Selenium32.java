package com.learnselenium.selenium300324;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium32
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
        driver.manage().window().maximize();
    }


    @Test
    @Description("Test case Description")
    public void positiveTest() throws InterruptedException {
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);

        // THETESTINGACADEMY
        // Shift Keydown -> thtestingacademy + Shift KeyUp

        WebElement firstName = driver.findElement(By.name("firstname"));
        //firstName.sendKeys("afafa");
        Actions actions = new Actions(driver);
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(firstName,"thetestingacademy")
                .keyUp(Keys.SHIFT).build().perform();
        Thread.sleep(13000);
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),\"Click here to Download File\")]"));
        actions.contextClick(link).build().perform();

        Thread.sleep(13000);

    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
