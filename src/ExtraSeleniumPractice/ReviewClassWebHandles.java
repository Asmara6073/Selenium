package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ReviewClassWebHandles {

    public static String url = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

//        find all the buttons that open up new windows or tabs

        WebElement helpBtn = driver.findElement(By.xpath("//a[text()='Help']"));
        WebElement privacyBtn = driver.findElement(By.xpath("//a[text()='Privacy']"));
        WebElement termsBtn = driver.findElement(By.xpath("//a[text()='Terms']"));

//        clicking on the btns
        helpBtn.click();
        privacyBtn.click();
        termsBtn.click();

 //get main page handle
       String mainpageHandle= driver.getWindowHandle();
        System.out.println("The handle for the main page is "+mainpageHandle);

        // get all the window handles
        Set<String> allHandles=driver.getWindowHandles();
        Iterator<String> itr=allHandles.iterator();
        while(itr.hasNext()){
            String handle=itr.next();
            if(!mainpageHandle.equals(handle)){
                driver.switchTo().window(handle);
               String secondHandle= driver.getWindowHandle();
                driver.getTitle();

            }
        }

//


}
}
