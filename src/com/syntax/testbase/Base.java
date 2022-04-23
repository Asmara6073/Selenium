package com.syntax.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {
    /**
     * method to open a browser
     * method to close the browser
     */

    public static WebDriver driver;

    /**
     * this method will navigate by the given url --> javadoc
     * @param url
     */
    public static void openWithSpecificURL(String url){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /**
     * this method will quit an open browser
     */
    public static void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }





}
