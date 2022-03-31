package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
    public static  String url = "http://www.uitestpractice.com/Students/Switchto";
    //username:password@

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.switchTo().frame(0);
        WebElement textbox= driver.findElement(By.cssSelector("input#name"));
        textbox.sendKeys("Batch 12 forever!!");
        driver.switchTo().defaultContent();

        WebElement alertBtn=driver.findElement(By.id("alert"));
        alertBtn.click();
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        alert.accept();

        driver.switchTo().frame("iframe_a");
        textbox.clear();
        textbox.sendKeys("Best batch ever");

        driver.switchTo().defaultContent();

        WebElement frameElement=driver.findElement(By.xpath("//iframe[@src='/Demo.html']"));
        driver.switchTo().frame(frameElement);
        textbox.clear();
        textbox.sendKeys("Hold your horses");

}
}
