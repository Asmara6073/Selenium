package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatePicker {

    public static String url="https://jqueryui.com/datepicker/";

    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement iframe=driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement datePicker=driver.findElement(By.cssSelector("input#datepicker"));
        datePicker.click();
        WebElement monthDate=driver.findElement(By.cssSelector("span.ui-datepicker-month"));
        String monthDateText=monthDate.getText();
        WebElement nextBtn=driver.findElement(By.xpath("//span[text()='Next']"));

        while(!monthDateText.equals("July")){
            nextBtn=driver.findElement(By.xpath("//span[text()='Next']"));
            nextBtn.click();
            monthDate=driver.findElement(By.cssSelector("span.ui-datepicker-month"));
            monthDateText=monthDate.getText();

        }

        List<WebElement> calendarDays=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

        for(WebElement day:calendarDays){

            String dayText=day.getText();

            if(dayText.equals("21")){
                day.click();
                break;
            }

        }

        driver.quit();

    }


}
