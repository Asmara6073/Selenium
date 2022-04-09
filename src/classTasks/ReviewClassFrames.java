package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ReviewClassFrames {

    public static String url="https://chercher.tech/practice/frames";

    /**
     * Go to website
     * go inside frame
     * check the the box in the frame
     *
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        driver.manage().window().fullscreen();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        driver.switchTo().frame("frame1");



        driver.switchTo().frame("frame3");



        WebElement checkbox=driver.findElement(By.cssSelector("input#a"));
        checkbox.click();








    }
}
