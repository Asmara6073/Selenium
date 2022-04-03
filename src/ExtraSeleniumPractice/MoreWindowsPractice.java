package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MoreWindowsPractice {

    public static String url="https://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement followIGAndFBBtn=driver.findElement(By.xpath("//a[text()='Follow Instagram & Facebook']"));

        followIGAndFBBtn.click();

        Set<String> pageIds=driver.getWindowHandles();

        Iterator<String> itr=pageIds.iterator();

        String mainPageHandle=itr.next();
        String secondPageHandle=itr.next();//facebook
       String thirdPageHandle=itr.next();//IG

       driver.switchTo().window(secondPageHandle);
       driver.manage().window().fullscreen();
        System.out.println("Second page handle is: "+secondPageHandle);
       String secondPageTitle=driver.getTitle();
        System.out.println("Title of second page is: "+secondPageTitle);
        String secondPageURL=driver.getCurrentUrl();
        System.out.println("URL of second page is: "+secondPageURL);


        driver.switchTo().window(thirdPageHandle);

        driver.manage().window().fullscreen();
        System.out.println("Third page handle is: "+thirdPageHandle);
        String thirdPageTitle=driver.getTitle();
        System.out.println("Title of third page is: "+thirdPageTitle);
        String thirdPageURL=driver.getCurrentUrl();
        System.out.println("URL of second page is: "+thirdPageURL);










    }
}
