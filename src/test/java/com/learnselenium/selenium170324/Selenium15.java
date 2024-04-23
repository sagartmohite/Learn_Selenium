package com.learnselenium.selenium170324;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium15
{
    @Test
    public void testselenium15() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement btn_id = driver.findElement(By.id("btn-make-appointment"));
        //WebElement btn_name = driver.findElement(By.className("btn btn-dark btn-lg toggle"));
        //WebElement btn_xpath = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
        //WebElement btn_linkText = driver.findElement(By.linkText("Make Appointment"));
        //WebElement btn_partialLik = driver.findElement(By.partialLinkText("Make"));
        //WebElement btn_css = driver.findElement(By.cssSelector("[id*=btn-make-appointment]"));


        btn_id.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        //<input

        // type="text" - NR
        // class="form-control" - NR
        // id="txt-username" - R
        // name="username" - r
        // placeholder="Username" - R
        // value="" NR
        // autocomplete="off" - NR
        // >

        List<WebElement> list = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        list.get(1).sendKeys("John Doe");

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        driver.quit();

    }
}
