package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameVerification {

    /*Navigate to https://syntaxprojects.com/bootstrap-iframe.php
      verify the header text AUTOMATION TESTING PLATFORM BY SYNTAX is displayed
      verify enroll today button is enabled
     */

    public static String url="https://syntaxprojects.com/bootstrap-iframe.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        Thread.sleep(3000);
        WebElement headerText=driver.findElement(By.xpath("//a[@href='index.php']"));

        if(headerText.isDisplayed()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        WebElement frameSearch=driver.findElement(By.xpath("//div[text()='Your search: Asksn']"));
        if(frameSearch.isDisplayed()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        WebElement frameTwo= driver.findElement(By.xpath("//iframe[@name='FrameTwo']"));
        driver.switchTo().frame(frameTwo);
        Thread.sleep(3000);
        WebElement enrollTodayBtn=driver.findElement(By.xpath("//p[@class='paragraph']/following-sibling::a"));

        if(enrollTodayBtn.isEnabled()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }


        driver.quit();







    }
}
