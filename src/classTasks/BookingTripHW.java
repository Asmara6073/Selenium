package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingTripHW {

    /**
     * Go to aa.com/homePage.do
     * select depart date
     * select return date
     * select destination
     * click on search
     * quit the browser
     *
     */

    public static String url="https://www.aa.com/homePage.do";

    public static void main(String[] args) {
        //opening browser functions
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        //choosing the departure day functions
        WebElement departCalendar=driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]"));
        departCalendar.click();
        WebElement nxtBtn=driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
        WebElement departureMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
        String departureMonthText =departureMonth.getText();
       while(!departureMonthText.equals("July")){
           nxtBtn=driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
            nxtBtn.click();
           departureMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
           departureMonthText=departureMonth.getText();
        }
        List<WebElement> departDays=driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]/tbody/tr/td"));
       for(WebElement departureDay:departDays){
           if(departureDay.getText().equals("10")){
               departureDay.click();
               break;
           }
       }

       //returnDate functions
        WebElement returnCalendar=driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]"));
        returnCalendar.click();
        WebElement returnMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]"));
        String returnMonthtext=returnMonth.getText();
        while(!returnMonthtext.equals("September")){

           try{
               nxtBtn.click();
           }catch(StaleElementReferenceException e){
               nxtBtn=driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
           }

            try{
                returnMonthtext=returnMonth.getText();
            }catch(StaleElementReferenceException e){
                returnMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]"));
            }
        }
        List<WebElement> returndays=driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]/tbody/tr/td"));
        for(WebElement returnDate:returndays){
            if(returnDate.getText().equals("22")){
                returnDate.click();
                break;
            }
        }


        //select Destination Functions
        WebElement destinationSearch=driver.findElement(By.xpath("(//a[@class='widget aaAirportLookup'])[2]"));
        destinationSearch.click();
        WebElement countryDD=driver.findElement(By.xpath("//select[@id='countryCode']"));
        Select select=new Select(countryDD);
        List<WebElement> countries=select.getOptions();
        for(WebElement country: countries){
            String countryText=country.getText();

            if(countryText.equals("Bahamas")){
                select.selectByVisibleText(countryText);
            }
            break;

        }


        WebElement closeBtn=driver.findElement(By.xpath("(//button[@class='aa-btn btn ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'])[2]"));
        closeBtn.click();

        WebElement searchBtn=driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));
        searchBtn.click();

        driver.quit();





















    }



}
