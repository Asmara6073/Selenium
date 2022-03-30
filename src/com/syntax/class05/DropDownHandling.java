package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownHandling {
    public static String URL="https://syntaxprojects.com/basic-select-dropdown-demo.php";
    public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().fullscreen();
       WebElement daysDD= driver.findElement(By.id("select-demo"));
        Select select=new Select(daysDD);
        //select.selectByIndex(0);// indexing starts from 0

        Thread.sleep(2000);
        //select.selectByVisibleText("Thursday");
        select.selectByValue("Friday");
        Thread.sleep(2000);

        List<WebElement> ddOptions=select.getOptions();
        int size=ddOptions.size();
        System.out.println(size);

       for(int i=1;i< ddOptions.size();i++){
           String options=ddOptions.get(i).getText();
           System.out.println(options);
           select.selectByIndex(i);
           Thread.sleep(2000);
       }
           /* for(WebElement options:ddOptions){
                String allOptions=options.getText();
                System.out.println(allOptions);

            }
            */

    }
}
