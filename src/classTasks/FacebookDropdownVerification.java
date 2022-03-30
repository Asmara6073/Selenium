package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FacebookDropdownVerification {
    /*Go to "https://www.facebook.com"
    click on create new account
    Verify:
    month dd has 12 month options
    day dd has 31 day options
    year dd has 115 year options
    Select your date of birth
    Quit browser
     */

    public static String url="https://www.facebook.com";


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        WebElement createAccountBTn=driver.findElement(By.xpath("//a[text()='Create new account']"));
        createAccountBTn.click();
        Thread.sleep(2000);
        WebElement monthDD=driver.findElement(By.cssSelector("select#month"));
        Select monthSelect=new Select(monthDD);

        List<WebElement> monthOptions=monthSelect.getOptions();
        int monthDDSize=monthOptions.size();
      if(monthDDSize==12){
          System.out.println("PASS");
      }else{
          System.out.println("FAIL");
      }


        WebElement daysDD=driver.findElement(By.cssSelector("select#day"));
        Select daysSelect=new Select(daysDD);
        List<WebElement> daysOptions=daysSelect.getOptions();
        int dayDDSize= daysOptions.size();
       if(dayDDSize==31){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
       }

        WebElement yearsDD=driver.findElement(By.cssSelector("select#year"));
        Select yearsSelect=new Select(yearsDD);
        List <WebElement> yearsOptions=yearsSelect.getOptions();
        int yearsDDSize= yearsOptions.size();
       if(yearsDDSize==118){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
       }
        monthSelect.selectByValue("4");
       Thread.sleep(2000);
       daysSelect.selectByVisibleText("21");
       Thread.sleep(2000);
       yearsSelect.selectByValue("1997");
       Thread.sleep(3000);
        driver.quit();



    }


}
