package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvancedWindowHandling {
    public static String url = "https://syntaxprojects.com/window-popup-modal-demo.php";


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String mainPageHandle=driver.getWindowHandle();// get window handle for the main page
        System.out.println(mainPageHandle);
        String mainPage=driver.getWindowHandle();
        WebElement igBtn=driver.findElement(By.linkText("Follow On Instagram"));
        WebElement fbBtn=driver.findElement(By.linkText("Like us On Facebook"));
        WebElement igAndFbBtn=driver.findElement(By.linkText("Like us On Facebook"));

        igBtn.click();
        Thread.sleep(2000);
        fbBtn.click();
        Thread.sleep(2000);
        igAndFbBtn.click();

        Set<String> allWindowHandles=driver.getWindowHandles();
        Iterator<String> itr=allWindowHandles.iterator();

        while(itr.hasNext()){ // start iterating through the handles
            String handle=itr.next();// getting the next handle available to me
            if(!mainPageHandle.equals(handle)){ // set a condition
                driver.switchTo().window(handle);// switch to a window which is not equal to main page handle
                //driver.manage().window().fullscreen();
                String title=driver.getTitle();
                System.out.println(title);
                driver.close();
            }
                driver.switchTo().window(mainPageHandle);// switching back to parent handle
                igBtn.click();
        }








}

}
