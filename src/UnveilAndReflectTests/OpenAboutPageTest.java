package UnveilAndReflectTests;

import UnveilAndReflectPages.UnveilReflectHomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class OpenAboutPageTest {

    public static String url="https://www.unveilandreflect.com/blog";
     static WebDriver driver=null;


    @Test
    public static void openAboutPageTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        UnveilReflectHomePage unveilReflectHomePage=new UnveilReflectHomePage(driver);
        unveilReflectHomePage.clickAboutButton();

        TakesScreenshot ts=(TakesScreenshot)driver;
        File srcFile=ts.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcFile,new File("screenshots/openAboutPageTest.png"));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Screen shot was not taken");
        }

        driver.close();




    }

}
