package com.learnselenium.selenium310324;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium37
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
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
//        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        //actions.dragAndDrop(from,to).perform();


        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();


        Thread.sleep(4000);

        driver.get("https://awesomeqa.com/selenium/upload.html");
        WebElement filetoupload = driver.findElement(By.id("fileToUpload"));
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        //filetoupload.sendKeys(dir+"/src/test/java/com.thetestingacademy/selenium31032024/toUpload.txt");
        filetoupload.sendKeys(dir+"\\src\\test\\java\\com\\thetestingacademy\\selenium310324\\toUpload.txt");
        Thread.sleep(5000);
        driver.findElement(By.name("submit")).click();

        // Download File
        // Checked by the ChromeOption
        // Problem - Download a file and check in the dir if that is present.
        // ChromeOptions -> dir(Doc)
        // filename.doc ->  /User/pramod/Download/chrome
        // file exist - T

    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
