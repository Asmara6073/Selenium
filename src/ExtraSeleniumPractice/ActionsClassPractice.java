package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsClassPractice {

    public static String url="https://jqueryui.com/droppable/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement iframe=driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);


       WebElement draggable1=driver.findElement(By.cssSelector("div#draggable"));
       WebElement droppable=driver.findElement(By.cssSelector("div#droppable"));

       Actions actions=new Actions(driver);

       actions.dragAndDrop(draggable1,droppable).perform();







    }

}
