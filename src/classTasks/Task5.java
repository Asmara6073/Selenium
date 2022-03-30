package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task5 {

    /*
    TC 1: Amazon link count:
    Open chrome browser
    Go to "https://www.amazon.com/"
    Get all links
    Get number of links that has text
    Print to console only the links that has text
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        String URL="https://www.amazon.com/";
        driver.get(URL);

        List<WebElement> allLinks=driver.findElements(By.tagName("a"));

        for(WebElement link:allLinks){
            String linkText=link.getText();
            String fullLink=link.getAttribute("href");
            if(!linkText.isEmpty()){
                System.out.println(linkText+" "+fullLink);
            }
        }

        driver.quit();


    }

}
