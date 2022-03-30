package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GetAllCategoriesFromEbay {

    public static String url="https://www.ebay.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        //navigates to Ebay
        driver.get(url);

        //click on dropdown menu and verify if it has "select" tag
        //if it has "select" tag, then you create a WebElement

        WebElement ebayDD=driver.findElement(By.cssSelector("select#gh-cat"));

        // get all drop down items using Select class
        //store all dropdown options in a list
        // loop through the list and print each individual drop down text

        Select ebaySelect=new Select(ebayDD);

        List<WebElement> ebayOptions=ebaySelect.getOptions();
        for(WebElement option:ebayOptions){
            String options=option.getText();
            System.out.println(options);
        }

        ebaySelect.selectByVisibleText("Computers/Tablets & Networking");
        WebElement searchBtn=driver.findElement(By.cssSelector("input#gh-btn"));
        searchBtn.click();
        WebElement header=driver.findElement(By.cssSelector("span.b-pageheader__text"));

        if(header.isDisplayed()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }






    }

}
