package ExtraSeleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlertPractice {

    public static String url="https://demoqa.com/alerts";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement simpleAlertBtn=driver.findElement(By.cssSelector("button#alertButton"));// button for alert

        if(simpleAlertBtn.isDisplayed()&&simpleAlertBtn.isEnabled()){
            simpleAlertBtn.click();// click button for alert to pop up
            Alert alert=driver.switchTo().alert();// change focus to alert from main page
            Thread.sleep(3000);
            System.out.println(alert.getText());// get the text from Simple Alert
            alert.accept();// accept the alert
        }

       WebElement confirmationAlertBtn=driver.findElement(By.cssSelector("button#confirmButton"));


        if(confirmationAlertBtn.isEnabled()&&confirmationAlertBtn.isDisplayed()){
            confirmationAlertBtn.click();
            Alert alert=driver.switchTo().alert();
            Thread.sleep(3000);
            System.out.println(alert.getText());// get the text of the Confirmation Alert
            alert.dismiss();
        }

        WebElement confirmationAlertMessage=driver.findElement(By.cssSelector("span#confirmResult"));
        if(confirmationAlertMessage.isDisplayed()){
            System.out.println("Message is displayed");
        }

        WebElement promptAlertBT=driver.findElement(By.cssSelector("button#promtButton"));
        if(promptAlertBT.isDisplayed()&& promptAlertBT.isEnabled()){
            promptAlertBT.click();
            Alert alert=driver.switchTo().alert();
            Thread.sleep(2000);
            System.out.println(alert.getText());
            alert.sendKeys("Tarik Abraham");
            alert.accept();

            WebElement promptAlertMessage=driver.findElement(By.cssSelector("span#promptResult"));
            if(promptAlertMessage.isDisplayed()){
                System.out.println("PASS");
                System.out.println(promptAlertMessage.getText());
            }else{
                System.out.println("FAIL");
            }
        }

            driver.quit();

















    }

}
