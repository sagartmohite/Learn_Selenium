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

import java.util.Set;

public class Selenium38
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
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.manage().window().maximize();
        driver.get(URL);

        String mainWindowHandle = driver.getWindowHandle();
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
        Thread.sleep(5000);
        Set<String> allWindowHandles = driver.getWindowHandles();

        for(String handle : allWindowHandles)
        {
            driver.switchTo().window(handle);
            String title = driver.getTitle();
            System.out.println(title);
            Thread.sleep(5000);
            if(title.equals("New Window"))
            {
                System.out.println("Test passed - switched to new window");
            }

            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test case Passed");
            }
        }

        Thread.sleep(5000);
        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(5000);

    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
