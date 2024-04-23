package com.learnselenium.selenium160324;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium12
{
    // Locators
    // 1. ID, ClassName, Name, byTag F(n) -> GetText and GetAttribute (Webelements)

    // 2. LinkText & Partial Text
    // 3.Css Selectors
    // 4. Xpath

    @Test
    @Description("verify the current url, title of the app.vwologin")
    public void testVWOLogin()
    {
        WebDriver driver = new EdgeDriver();

        driver.get("https://app.vwo.com");
        WebElement anchor_tag = driver.findElement(By.linkText("Start a free trial"));
        String s = anchor_tag.getText().toString();
        System.out.println(s);
        String s2 = driver.findElement(By.partialLinkText("Start a free")).getText().toString();
        System.out.println(s2);
        //String s3 = driver.findElement(By.tagName("a"));
        //System.out.println(s3);
        String s4 = driver.findElement(By.xpath("//a[@href='https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage']")).getText().toString();
        System.out.println(s4);
        String s5 = driver.findElement(By.cssSelector("[href*='https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage']")).getText().toString();
        System.out.println(s5);
        String s6 = driver.findElement(By.cssSelector("[href^='https://vwo.com/free-trial/?utm_medium=website&utm_source=login-p']")).getText().toString();
        System.out.println(s6);
        String s7 = driver.findElement(By.cssSelector("[href$='ampaign=mof_eg_loginpage']")).getText().toString();
        System.out.println(s7);

        anchor_tag.click();





    }
}
