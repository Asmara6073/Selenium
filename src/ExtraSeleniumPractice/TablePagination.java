package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TablePagination {
    public static String url="https://syntaxprojects.com/table-pagination-demo.php";

    public static void main(String[] args) {
        /**
         * navigate to https://syntaxprojects.com/table-pagination-demo.php
         * Find record that contains juan valdez
         * print the row
         */

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> tableRows=driver.findElements(By.xpath("//tbody[@id='myTable']/tr"));
        WebElement nextBtn=driver.findElement(By.cssSelector("a.next_link"));
        boolean flag=true;
        while(flag){
            for(WebElement rows:tableRows){
                String rowText=rows.getText();
                if(rowText.contains("Juan valdez")){
                    flag=false;
                    System.out.println(rowText);
                    break;
                }
            }

            if(flag){
                nextBtn.click();
            }
        }

        driver.quit();





    }
}
