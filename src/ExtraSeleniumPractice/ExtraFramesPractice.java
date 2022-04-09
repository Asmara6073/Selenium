package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExtraFramesPractice {

public static String url="https://chercher.tech/practice/frames";

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        WebElement frame1=driver.findElement(By.cssSelector("iframe#frame1"));

        driver.switchTo().frame(frame1);
        WebElement frame1TxtBox=driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input"));

        frame1TxtBox.sendKeys("Selenium is AWESOME!!!!");

        driver.switchTo().frame("frame3");

        WebElement innerFrameCheckBox= driver.findElement(By.cssSelector("input#a"));
        if(innerFrameCheckBox.isEnabled()){
            innerFrameCheckBox.click();
        }


        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame2");

        WebElement frame2DD=driver.findElement(By.cssSelector("select#animals"));

        Select select=new Select(frame2DD);

        List<WebElement> animals=select.getOptions();

        select.selectByValue("big baby cat");


       /* for(WebElement animal:animals){
            String value=animal.getAttribute("value");
            select.selectByValue(value);
        }*/















    }

}
