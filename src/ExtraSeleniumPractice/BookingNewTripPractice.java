package ExtraSeleniumPractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingNewTripPractice {

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

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement departCalendar=driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]"));
        departCalendar.click();

        WebElement departMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
        String departMonthText= departMonth.getText();

        WebElement nxtBtn=driver.findElement(By.xpath("//a[@aria-label='Next Month']"));


        while(!departMonthText.equals("August")){
            nxtBtn=driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
            nxtBtn.click();
            departMonth=driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            departMonthText= departMonth.getText();

        }

        List<WebElement> departureDays=driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]/tbody/tr/td"));

        for(WebElement day:departureDays){
            if(day.getText().equals("24")){
                day.click();
                break;
            }
        }

        TakesScreenshot ts= (TakesScreenshot) driver;
        File srcFile=ts.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcFile,new File("/Users/tarikabraham/Desktop/Batch12/departDate.png"));
        }catch(IOException e){
            e.printStackTrace();
        }




    }

}
