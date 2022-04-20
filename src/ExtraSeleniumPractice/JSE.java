package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JSE {

    public static String url="https://syntaxprojects.com/basic-checkbox-demo.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement checkbox=driver.findElement(By.xpath("//input[@value='Option-4']"));

        JavascriptExecutor js=(JavascriptExecutor) driver;
        Thread.sleep(3000);
        //perform Scroll down on application using Selenium
        js.executeScript("window.scrollBy(0,250)");


        Thread.sleep(3000);
        // Vertical scroll
        js.executeScript("window.scrollBy(0,-250)");


        Thread.sleep(3000);
        JavascriptExecutor je=(JavascriptExecutor) driver;
        // To scroll an app to specified elements
        je.executeScript("arguments[0].scrollIntoView(true);",checkbox);


        //Click button using JavaScript executor

        je.executeScript("arguments[0].click();", checkbox);

        Thread.sleep(3000);
        //Get intertext of the entire webpage in Selenium

        String pageText=je.executeScript("return document.documentElement.innerText;").toString();










}

}
