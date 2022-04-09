package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExtraCheckBoxDemo {
    public static String url="http://syntaxprojects.com/basic-checkbox-demo.php";

    public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver","drivers/chromedriver");// set property
        WebDriver driver=new ChromeDriver();// launch the browser

        driver.get(url);// navigate to url
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // set implicit wait

        WebElement singleCheck=driver.findElement(By.cssSelector("input#isAgeSelected"));
        //single checkbox element

        if(singleCheck.isDisplayed()&& singleCheck.isEnabled()){// condition to see if check box is displayed and enabled
            singleCheck.click();// clicking the single checkbox if condition is true
        }

        WebElement singleMessage=driver.findElement(By.cssSelector("div#txtAge"));
        if(singleMessage.isDisplayed()&& singleCheck.isSelected()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.cb1-element")));
        List<WebElement> checkBoxes=driver.findElements(By.cssSelector("input.cb1-element"));
        //store all check boxes into a list using common class name

        Iterator<WebElement> itr=checkBoxes.iterator();

        while(itr.hasNext()){
            WebElement box=itr.next();
            String boxText=box.getAttribute("value");
            if(!boxText.equals("Option-1")){
                box.click();
            }
            }

        }














}
