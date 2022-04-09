package ExtraSeleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPractice {

    public static String url="http://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");// set the properties
        WebDriver driver=new ChromeDriver();// launch the browser
        driver.get(url);// navigate to the webpage

        WebElement simpleAlert=driver.findElement(By.xpath("(//button[text()='Click me!'])[1]"));
        simpleAlert.click();

        Alert alert=driver.switchTo().alert();// switch focus to alert on the page

        System.out.println(alert.getText());
        alert.accept();

        driver.quit();


    }


}
class ConfirmAlert{

public static String url="http://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement confirmBox=driver.findElement(By.xpath("(//button[text()='Click me!'])[2]"));
        confirmBox.click();

        Alert alert=driver.switchTo().alert();
        String alertText=alert.getText();

        if(!alertText.isEmpty()){
            alert.dismiss();
        }
        WebElement message=driver.findElement(By.cssSelector("p#confirm-demo"));

        if(message.isDisplayed()){
            System.out.println(message.getText());
        }
        driver.quit();



    }

}

class PromptAlert{

    public static String url="http://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get(url);

        WebElement promptAlert=driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
        promptAlert.click();

        Alert alert=driver.switchTo().alert();


        String promptTxt=alert.getText();
        if(!promptTxt.isEmpty()){
            System.out.println(promptTxt);
            alert.sendKeys("Deez Nutssssssss");
            alert.accept();
        }

        WebElement promptMessage=driver.findElement(By.cssSelector("p#prompt-demo"));
        if(promptMessage.isDisplayed()){
            System.out.println(promptMessage.getText());
        }


    }


}