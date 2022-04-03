package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class DropDownPractice {

    public static String url="https://syntaxprojects.com/basic-select-dropdown-demo.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement singleDD=driver.findElement(By.cssSelector("select#select-demo"));

        Select singleSelectDD=new Select(singleDD);

        List<WebElement> singleOptions=singleSelectDD.getOptions();

            for(WebElement options:singleOptions){
                String optionText= options.getText();
                System.out.println(optionText);
                singleSelectDD.selectByVisibleText(optionText);
                Thread.sleep(2000);
            }

    }
}

class MultipleSelectPractice{

    public static String url="https://syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get(url);
        WebElement multiSelectDD=driver.findElement(By.cssSelector("select#multi-select"));

        Select select=new Select(multiSelectDD);

        List<WebElement> multiOptions=select.getOptions();

        for(WebElement option:multiOptions){
            String optionText=option.getText();
            select.selectByVisibleText(optionText);
        }

        select.deselectByIndex(3);
        Thread.sleep(3000);

        driver.quit();



    }



}
