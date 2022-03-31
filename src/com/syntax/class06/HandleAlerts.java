package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
/*
*handle each alert on the page
 */

    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement simpleAlertBtn=driver.findElement(By.cssSelector("button#alert"));
        simpleAlertBtn.click();

        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        WebElement confirmAlertBtn=driver.findElement(By.cssSelector("button#confirm"));
        confirmAlertBtn.click();

        Alert confirmAlert=driver.switchTo().alert();
        Thread.sleep(3000);
        String confirmAlertText=confirmAlert.getText();
        System.out.println(confirmAlertText);
        Thread.sleep(2000);
        confirmAlert.dismiss();

        WebElement promptAlertBtn=driver.findElement(By.cssSelector("button#prompt"));
        promptAlertBtn.click();

        Alert promptAlert=driver.switchTo().alert();
        Thread.sleep(3000);
        promptAlert.sendKeys("Best batch ever");
        Thread.sleep(3000);
        promptAlert.accept();




    }
}