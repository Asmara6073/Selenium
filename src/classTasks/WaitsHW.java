package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitsHW {

    /**
     * go to https://the-internet.herokuapp.com/dynamic_controls
     * click on checkbox and click on remove
     * verify the text
     * click on enable verify the textbox is enabled
     * enter text and click disable
     * verify the textbox is disabled
     */

   public static String url="https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();


        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        WebElement removeBtn=driver.findElement(By.xpath("//button[text()='Remove']"));
        removeBtn.click();

        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));

        WebElement removedTxt=driver.findElement(By.cssSelector("p#message"));

        System.out.println(removedTxt.getText());

        WebElement enableBtn=driver.findElement(By.xpath("//button[text()='Enable']"));
        enableBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        WebElement textbox=driver.findElement(By.xpath("//input[@type='text']"));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));


        textbox.sendKeys("Hello there");

        WebElement disableBtn=driver.findElement(By.xpath("//button[text()='Disable']"));
        disableBtn.click();

        System.out.println(textbox.isEnabled());









    }



}

