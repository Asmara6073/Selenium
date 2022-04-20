package com.syntax.class11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class RightAndDoubleClickActions {



    public static String url="https://demo.guru99.com/test/simple_context_menu.html";

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement rightClickBtn=driver.findElement(By.xpath("//span[text()='right click me']"));

        Actions action=new Actions(driver);
        action.contextClick(rightClickBtn).perform();

        WebElement editOption=driver.findElement(By.xpath("//span[text()='Edit']"));
        //editOption.click();
        action.click(editOption).perform();
       Alert alert= driver.switchTo().alert();
       alert.accept();

       WebElement doubleClickBtn=driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me')]"));
       action.doubleClick(doubleClickBtn).perform();

        System.out.println(alert.getText());
        alert.accept();




    }

}
