package com.learnselenium.selenium300324;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium29
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
    public void positiveTest()
    {
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        driver.manage().window().maximize();

//        driver.findElement(By.name("q")).sendKeys("macmini");
//
//        // https://www.flipkart.com/
//        // //*[local-name()='svg']/*[local-name()='path']
//        // (//*[local-name()='svg'])[1]
//        // (//*[name()='svg'])[1]
//
//        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
//        //svgElements.get(0).click();
//        WebElement e = svgElements.get(0);
//        e.click();
//        String s = e.getText();
//        e.click();
//        System.out.println(s);

        driver.findElement(By.name("q")).sendKeys("macmini");

        // https://www.flipkart.com/
        // //*[local-name()='svg']/*[local-name()='path']
        // (//*[local-name()='svg'])[1]
        // (//*[name()='svg'])[1]
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();

    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
