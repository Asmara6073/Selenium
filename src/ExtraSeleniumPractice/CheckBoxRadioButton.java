package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxRadioButton {
    public static String url="https://jqueryui.com/checkboxradio/";

    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to https://jqueryui.com/droppable/
         * Store radio buttons in a list
         * iterate/loop through them and choose all options
         * iterate/loop through them and choose London
         */
        //navigate to website
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

        driver.switchTo().frame(iframe);

        // store all radio buttons in a list
        List<WebElement> radioBtns=driver.findElements(By.xpath("//label[@class='ui-checkboxradio-label ui-corner-all ui-button ui-widget ui-checkboxradio-radio-label']"));

        for(WebElement radio:radioBtns){
            String buttonAtr=radio.getAttribute("for");
            if(radio.isEnabled()&&buttonAtr.equals("radio-3")){
                radio.click();

            }
        }







    }

}
