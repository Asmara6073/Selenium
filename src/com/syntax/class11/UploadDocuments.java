package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadDocuments {
    public static String url="https://the-internet.herokuapp.com/";


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement fileUploadLink= driver.findElement(By.xpath("//a[text()='File Upload']"));
        fileUploadLink.click();

        WebElement chooseFile=driver.findElement(By.cssSelector("input#file-upload"));
        chooseFile.sendKeys("/Users/tarikabraham/Desktop/Batch12/Test2.xlsx");

        WebElement uploadBtn=driver.findElement(By.cssSelector("input#file-submit"));
        uploadBtn.click();




    }
}
