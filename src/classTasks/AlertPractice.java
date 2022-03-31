package classTasks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPractice {
/*Go to https://syntaxprojects.com/javascript-alert-box-demo.php
  click on each button and handle the alert accordingly
 */

    public static String url="https://syntaxprojects.com/javascript-alert-box-demo.php";
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement alertBtn=driver.findElement(By.xpath("//p[text()='Click the button to display an alert box:']/following-sibling::button"));
        alertBtn.click();

        Thread.sleep(3000);

       Alert alert= driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        WebElement confirmAlertBtn=driver.findElement(By.xpath("//p[@id='confirm-demo']/preceding-sibling::button"));
        confirmAlertBtn.click();

        Thread.sleep(2000);

        alert.dismiss();
        WebElement confirmMessage=driver.findElement(By.cssSelector("p#confirm-demo"));

        if(confirmMessage.isDisplayed()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        WebElement promptBox=driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
        promptBox.click();
        Thread.sleep(2000);

        String promptText=alert.getText();
        System.out.println(promptText);
        alert.sendKeys("Tarik Abraham");
        alert.accept();

        driver.quit();














    }


}
