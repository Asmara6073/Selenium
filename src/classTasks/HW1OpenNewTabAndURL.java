package classTasks;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HW1OpenNewTabAndURL {

    /**
     * open new browser
     * open a new tab
     * navigate to a different URL on a new tab
     */

    public static String url="http://google.com";
    public static String url2="http://amazon.com";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        String mainPageHandle=driver.getWindowHandle();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.open()");

        Set<String> allHandles=driver.getWindowHandles();

        Iterator<String> itr= allHandles.iterator();
        String childPageHandle = null;
        while(itr.hasNext()){
            mainPageHandle=itr.next();
             childPageHandle=itr.next();
        }

        driver.switchTo().window(childPageHandle);

        driver.get(url2);
        driver.quit();





    }
}
