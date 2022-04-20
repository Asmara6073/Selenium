package ExtraSeleniumPractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakingScreenShots {

    public static String url="https://syntaxprojects.com/basic-checkbox-demo.php";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement checkbox=driver.findElement(By.xpath("//input[@value='Option-4']"));
        checkbox.click();

        //downcasting
        TakesScreenshot ts=(TakesScreenshot)driver;
        //use getScreenShotAs() method to take the screen shot--> pass OutputType.File in the constructor
        File srcFile=ts.getScreenshotAs(OutputType.FILE);

        //copy file from source to another destination
        try{
            FileUtils.copyFile(srcFile,new File("screenshots/checkbox4checked.png"));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Screen shot was not taken");
        }

            driver.quit();

    }




}
