package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class HWTabs {

    public static String url=" http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            driver.manage().window().maximize();
            WebElement link = driver.findElement(By.linkText("This is a Ajax link"));
            link.click();

            WebElement text=driver.findElement(By.cssSelector("div.ContactUs"));
            String pageText=text.getText();
            System.out.println(pageText);
            driver.quit();



    }
}
