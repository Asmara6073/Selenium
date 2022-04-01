package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesPractice {

    public static String url="http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        driver.switchTo().frame("iframe_a");
        Thread.sleep(3000);
        WebElement iframeText=driver.findElement(By.xpath("//h1[text()='Iframe']"));
        WebElement iframeTextbox=driver.findElement(By.xpath("//label[text()='Enter your name:']/following-sibling::input"));
        if(iframeText.isDisplayed()){
            System.out.println(iframeText.getText());
            iframeTextbox.sendKeys("Tarik");
        }




        driver.quit();





    }

}
