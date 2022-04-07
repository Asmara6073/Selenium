package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsAndTabsPractice {
/*Go to https://demoqa.com/browser-windows
  click on New Tab and print the text from new tab in the console
  click on New Window and print the text from new window in the console
  click on New Window Message and print the text from new window in the console
  Verify (compare) the titles for each page
  Print out the title of the all pages
 */

 public static String url="https://demoqa.com/browser-windows";
public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
    WebDriver driver = new ChromeDriver();

    driver.get(url);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    String mainPageHandle = driver.getWindowHandle();

    WebElement newTabBtn = driver.findElement(By.xpath("//button[@id='tabButton']"));
    WebElement newWindowBtn = driver.findElement(By.xpath("//button[@id='windowButton']"));
    WebElement newWindowMsg = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));


    newTabBtn.click();
    newWindowBtn.click();
    newWindowMsg.click();

    Set<String> windows = driver.getWindowHandles();

    Iterator<String> itr = windows.iterator();
    mainPageHandle = itr.next();
    String newTabBtnID = itr.next();
    String newWindowBtnID = itr.next();
    String newWindowMessageID = itr.next();


    driver.switchTo().window(newTabBtnID);
    WebElement pageText = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
    System.out.println(pageText.getText());

    driver.switchTo().window(mainPageHandle);

    driver.switchTo().window(newWindowBtnID);
    WebElement windowText = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
    System.out.println(windowText.getText());

    driver.switchTo().window(mainPageHandle);


    driver.switchTo().window(newWindowMessageID);
    WebElement msgText = driver.findElement(By.tagName("body"));
    System.out.println(msgText.getText());


}


}
class PrintAllTitles{
    public static String url="https://demoqa.com/browser-windows";
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String mainPageHandle = driver.getWindowHandle();

        WebElement newTabBtn = driver.findElement(By.xpath("//button[@id='tabButton']"));
        WebElement newWindowBtn = driver.findElement(By.xpath("//button[@id='windowButton']"));
        WebElement newWindowMsg = driver.findElement(By.xpath("//button[@id='messageWindowButton']"));


        newTabBtn.click();
        newWindowBtn.click();
        newWindowMsg.click();

        Set<String> allHandles=driver.getWindowHandles();
        System.out.println(allHandles.size());

        Iterator<String> itr=allHandles.iterator();

        while(itr.hasNext()){
            String handle=itr.next();
            if(!mainPageHandle.equals(handle)){
                driver.switchTo().window(handle);
                driver.manage().window().fullscreen();
                WebElement text=driver.findElement(By.xpath("//body"));
                String pageText=text.getText();
                System.out.println(pageText);
            }
        }





    }

}