package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReviewTables {

    public static String url="https://www.techlistic.com/p/demo-selenium-practice.html";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        //accessing the whole webtable
       //WebElement whole_table= driver.findElement(By.xpath("//table[@id='customers']"));
        //System.out.println(whole_table.getText());

        //Accessing the rows of the table
       /* List<WebElement> rows= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        for(WebElement row:rows){
            String rowText=row.getText();
            if(rowText.contains("Germany")){
                System.out.println(rowText);
            }

        }*/


        //Print all the company names that are located in the UK
        List<WebElement>countries=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[3]"));
        int i=2;
        for(WebElement country:countries){
            String countryName=country.getText();
            if(countryName.equals("UK")){
               WebElement company=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td[1]"));
                System.out.println(company.getText());
            }
            i+=1;
        }
    }



}
