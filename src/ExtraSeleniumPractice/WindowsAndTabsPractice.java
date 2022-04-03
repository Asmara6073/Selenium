package ExtraSeleniumPractice;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsAndTabsPractice {


    public static String url="https://syntaxprojects.com/window-popup-modal-demo.php";
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        System.out.println("Main Page Title: "+driver.getTitle());
        WebElement likeUsOnFbBtn=driver.findElement(By.xpath("//a[text()=' Like us On Facebook ']"));
            Thread.sleep(3000);
        if(likeUsOnFbBtn.isDisplayed()&&likeUsOnFbBtn.isEnabled()){
            likeUsOnFbBtn.click();// open new page
        }

        Set<String> pageIds=driver.getWindowHandles();

        System.out.println("The amount of pages open right now are "+pageIds.size());

        Iterator<String> itr=pageIds.iterator();

        String mainPageHandle=itr.next();
        String childPageHandle=itr.next();

        driver.switchTo().window(childPageHandle);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String childtitle=driver.getTitle();
        System.out.println("Child Page Title: "+childtitle);
        WebElement fbPageName=driver.findElement(By.xpath("//h1[text()='Syntax Technologies']"));

        if(fbPageName.isDisplayed()){
            System.out.println("Page name is being displayed");
        }else{
            System.out.println("Page name is not being displayed");
        }

        WebElement contactUsBtn=driver.findElement(By.xpath("(//div[@data-visualcompletion='ignore'])[5]"));

        if(contactUsBtn.isDisplayed()){
            System.out.println("button is displayed on facebook page");
        }else{
            System.out.println("FAIL");
        }
        if (contactUsBtn.isEnabled()){
            System.out.println("button is enabled on the page ");
        }else{
            System.out.println("FAIL");
        }

        driver.switchTo().window("");

        String mainPageTitle=driver.getTitle();

        if(mainPageTitle.equals("Syntax - Website to practice Syntax Automation Platform")){
            System.out.println("TEST PASS");
            driver.quit();
        }















    }


}
