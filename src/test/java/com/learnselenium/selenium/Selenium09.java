package com.learnselenium.selenium;

import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenium09
{
    public static void main(String[] args) throws MalformedURLException {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://google.com");

        driver.navigate().to("https://bing.com");
        driver.navigate().to(new URL("https://pixabay.com/images/search/nature%20wallpaper/"));
        //driver.navigate().to(new URL("https://google.com"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.quit();
    }
}
