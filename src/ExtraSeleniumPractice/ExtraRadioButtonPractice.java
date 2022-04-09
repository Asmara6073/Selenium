package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExtraRadioButtonPractice {

    public static String url="http://syntaxprojects.com/basic-radiobutton-demo.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");// First set the properties
        WebDriver driver=new ChromeDriver(); // Launch our browser
        driver.get(url);// go to the specified URL

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// implicit wait created

        List<WebElement> ageGroupRadioBtns=driver.findElements(By.cssSelector("input[name='optradio']"));
        // store all of the radio buttons in a list using the same name attribute

        for(WebElement radio:ageGroupRadioBtns){// loop through the list of radio buttons
            String radioTxt=radio.getAttribute("value");// find unique attribute for the list to click button

            if(radioTxt.equals("Female")){
                radio.click();
            }


        }




    }

}
