package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindowsAndTabs {

    public static String url="https://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        WebElement followIGBtn=driver.findElement(By.xpath("//a[text()=' Follow On Instagram ']"));
        followIGBtn.click();
        Thread.sleep(2000);

        String signupTitle=driver.getTitle();// title of web page
        System.out.println("Main Page Title is: "+signupTitle);

        /*
         *How to get window handle?
         * In Selenium we have two methods to get the handle of window
         * getWindowHandle();
         * getWindowHandles();
         */

        Set<String> allWindowHandles=driver.getWindowHandles();
        // returns a set of string IDs of all windows currently opened by the current instance

        System.out.println("Number of windows open are:"+allWindowHandles.size());// gets size of set

        Iterator<String>itr=allWindowHandles.iterator();

        String mainWindowHandle=itr.next();// returns ID of main window
        System.out.println("ID of Main Window: "+mainWindowHandle);

        String childWindowHandle=itr.next();// returns ID of child window
        System.out.println("ID of Child Window: "+childWindowHandle);

        //Using switchTo method we switch to another window by passing the handle/ID of the window

        driver.switchTo().window(childWindowHandle);
        String childWindowTitle=driver.getTitle();
        System.out.println("Child Page Title is: "+childWindowTitle);

        driver.manage().window().maximize();

        Thread.sleep(4000);

        driver.switchTo().window(mainWindowHandle);
        //driver.switchTo().window("");// goes back to main window




    }



}
