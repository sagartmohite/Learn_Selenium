package com.learnselenium.selenium310324;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium42
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

        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();
        Thread.sleep(15000);

        // iframe
        driver.switchTo().frame("result");
        ////form[@id="form"]/button

        WebElement submit = driver.findElement(By.xpath("//form[@id=\"form\"]/button"));

        submit.click();

        //

        WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement errorElement =  driver.findElement(with(By.tagName("small")).below(element));
        String errorText = errorElement.getText();
        System.out.println(errorText);
        Assert.assertTrue(errorElement.isDisplayed());
        Assert.assertEquals(errorText,"Username must be at least 3 characters");


        Thread.sleep(5000);


    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
