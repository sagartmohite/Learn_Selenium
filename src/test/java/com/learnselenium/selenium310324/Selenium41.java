package com.learnselenium.selenium310324;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium41
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
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement searchelement = driver.findElement(By.xpath("//input[@id=\"search_city\"]"));
        searchelement.sendKeys("India" + Keys.ENTER);

        ////table[@id='example']/tbody/tr/td[2]

        Thread.sleep(5000);
//        List<WebElement> list_of_states = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
//
//
//        for (WebElement l : list_of_states) {
//            String s1 = driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();
//            String s2 = driver.findElement(with(By.tagName("p")).toLeftOf(l)).getText();
//            String s3 = driver.findElement(with(By.tagName("p")).below(l)).getText();
//            String s4 = driver.findElement(with(By.tagName("p")).above(l)).getText();
//            System.out.println(l.getText() + " | " + s1 + " | " + s2);
//            System.out.println(l.getText() + " | " + s3 + " | " + s4);
//        }

        WebElement l = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[5]/td[2]"));

            String s1 = driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();
            String s2 = driver.findElement(with(By.tagName("p")).toLeftOf(l)).getText();
            String s3 = driver.findElement(with(By.tagName("p")).below(l)).getText();
            String s4 = driver.findElement(with(By.tagName("p")).above(l)).getText();
            System.out.println(l.getText() + " | " + s1 + " | " + s2);
            System.out.println(l.getText() + " | " + s3 + " | " + s4);



        Thread.sleep(5000);

    }


    //@AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
