package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlingPractice {

    public static String url="http://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        String mainPageHandle=driver.getWindowHandle();

        //All webelements to butttons that open new windows/tabs
        WebElement followIGBtn=driver.findElement(By.xpath("//a[text()=' Follow On Instagram ']"));
        WebElement followFBBtn=driver.findElement(By.xpath("//a[contains(text(),' Like us')]"));
        WebElement bothBtn= driver.findElement(By.xpath("//a[contains(text(),'& Facebook')]"));

        // clicking all buttons to open new windows and tabs
        followIGBtn.click();
        followFBBtn.click();
        bothBtn.click();


        Set<String> handles=driver.getWindowHandles();// storing all window handles that are open in a tab

        Iterator<String> itr=handles.iterator();// iterator to iterate through all the handles

        while(itr.hasNext()){
            String handle=itr.next();// storing each handle in a String
            String title=driver.getTitle();
            String URL=driver.getCurrentUrl();
            if(!mainPageHandle.equals(handle)){
            driver.switchTo().window(handle);
            System.out.println(title);
            System.out.println(URL);
            driver.switchTo().defaultContent();
        }







    }

}

}

class Windows{

    public static String url="https://chercher.tech/practice/popups#";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        String mainPageHandle=driver.getWindowHandle();

        WebElement openWindowBtn=driver.findElement(By.xpath("//input[@value='Open New Window']"));
        openWindowBtn.click();

        Set<String> windows=driver.getWindowHandles();

        Iterator<String> itr=windows.iterator();

        while(itr.hasNext()){
            mainPageHandle=itr.next();
            String childPage=itr.next();
            driver.switchTo().window(childPage);
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

        }






        }




    }




