package ExtraSeleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitPractice {

    public static String url="https://chercher.tech/practice/implicit-wait-example";


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        List<WebElement> boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));


        for(WebElement box:boxes){

            box.click();
        }






    }
}

class ExplicitWait{

    public static String url="https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        WebElement alertBtn=driver.findElement(By.cssSelector("button#alert"));

        alertBtn.click();

        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebElement changeTextBtn=driver.findElement(By.xpath("//button[contains(text(),'Change Text')]"));
        changeTextBtn.click();


        WebElement webMsg=driver.findElement(By.xpath("//h2[text()='Selenium Webdriver']"));



        System.out.println(webMsg.getText());





        driver.quit();



    }




}

class moreExplicitWait{

    public static String url="https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();

        WebElement displayBtn=driver.findElement(By.cssSelector("button#display-other-button"));
        displayBtn.click();

        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Enabled']")));

        WebElement hiddenBtn=driver.findElement(By.xpath("//button[text()='Enabled']"));

        System.out.println(hiddenBtn.isEnabled());

        WebElement enableBtn=driver.findElement(By.cssSelector("button#enable-button"));
        enableBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Button']")));

        WebElement enabledBtn=driver.findElement(By.xpath("//button[text()='Button']"));

        if(enabledBtn.isDisplayed()&&enabledBtn.isEnabled()){
            enabledBtn.click();
            System.out.println(enabledBtn.getText());
        }


        WebElement checkBoxAfterTenSec=driver.findElement(By.xpath("//button[text()='Check Checkbox after 10 seconds']"));
        checkBoxAfterTenSec.click();

        wait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("input#ch"),true));
        WebElement checkBox=driver.findElement(By.cssSelector("input#ch"));

        boolean status=checkBox.isSelected();
        System.out.println(status);




        driver.quit();







    }



}

