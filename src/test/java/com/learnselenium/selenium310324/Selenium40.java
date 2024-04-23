package com.learnselenium.selenium310324;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium40
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
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement span_element = driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));
        //driver.findElement(with(By.id("exp-3")).toRightOf(span_element)).click();
        WebElement e = driver.findElement(By.id("exp-1"));
        driver.findElement(with(By.id("exp-3")).toRightOf(e).toRightOf(e)).click();
        Thread.sleep(10000);
    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
