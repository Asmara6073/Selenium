package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class CommonMethods {

    public static WebDriver driver;

    public static void openBrowser(String url){
    System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void closeBrowser(){
        if(driver!=null){
            driver.close();
        }
    }

    public static void quitBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }


}
