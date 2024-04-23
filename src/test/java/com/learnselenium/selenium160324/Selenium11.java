package com.learnselenium.selenium160324;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium11
{
    // Open app.vwo.com
    // Print the title and get the Current URL
    // VerIfy the Current URL is app.vwo.com

    @Test(groups = "QA")
    @Description("Verify the current url, title of VWO app")
    public void verifyVWOLogin()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


        driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify error message, by providing invalid username and password")
    public void testVWOLoginNegative() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //        **Project #1 - TC ( Negaative) - Invalid username, pass - Error message**
//
//        1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
//        2. **Find the Email id** and enter the email as admin@admin.com
//        3. **Find the pass inputbox** and enter passwrod as admin.
//        4. Find and Click on the submit button
//        5. Verify that the error message is shown "Your email, password, IP address or location did not match"
//

        // 2. **Find the Email id** and enter the email as admin@admin.com
        //  id, className, name, css Selector, xpath
        //  LinkText and PartialText which are onlu for <a>
        // <input
        // type="email"
        // class="text-input W(100%)"
        // name="username"
        // id="login-username"
        // data-qa="hocewoqisi">

        driver.get("https://app.vwo.com");
        driver.findElement(By.id("login-username")).sendKeys("admin@admin.com");
        driver.findElement(By.id("login-password")).sendKeys("admin");
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(3000);
        WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));
        String dataq = error_msg.getAttribute("data-qa");
        //rixawilomi
        System.out.println("-------------------");
        System.out.println(dataq);
        System.out.println("-------------------");
        System.out.println(driver.findElement(By.id("js-notification-box-msg")).getText());

        Assert.assertEquals(driver.findElement(By.id("js-notification-box-msg")).getText(), "Your email, password, IP address or location did not match");

    }
}
