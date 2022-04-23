package classTasks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UITestPracticeHW {

    public static String url="http://www.uitestpractice.com/";
    static WebDriver driver=null;

   public static By draggable= By.cssSelector("div#draggable");
    public static By droppable=By.cssSelector("div#droppable");

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement drag=driver.findElement(draggable);
        WebElement drop=driver.findElement(droppable);

        Actions action=new Actions(driver);
        action.dragAndDrop(drag,drop).perform();

        WebElement doubleClickBtn=driver.findElement(By.xpath("//button[text()='Double Click ME !']"));
        action.doubleClick(doubleClickBtn).perform();

        Alert alert=driver.switchTo().alert();
        alert.accept();

        WebElement iframe=driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
        driver.switchTo().frame(iframe);
        WebElement iframeTxtBox=driver.findElement(By.xpath("//label[text()='Enter your name:']/following-sibling::input"));
        iframeTxtBox.sendKeys("Tarik Abraham");

        driver.switchTo().defaultContent();
        driver.manage().window().fullscreen();
        WebElement homeBtn=driver.findElement(By.xpath("//a[text()='Home']"));
        homeBtn.click();
        driver.manage().window().fullscreen();


        boolean flag=true;
        while(flag){
            List<WebElement> tableRows=driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
            for(int i=0;i<tableRows.size();i++){
                String rowText=tableRows.get(i).getText();
                if(rowText.contains("Carsen")){
                    flag=false;
                    WebElement deleteBtn=driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td/button[3]"));
                    action.click(deleteBtn);
                    //deleteBtn.click();
                    break;
                }
            }
            if(flag){

                driver.navigate().refresh();

                Actions action2=new Actions(driver);
                WebElement nxtBtn=driver.findElement(By.xpath("//a[@rel='next']"));
                action2.click(nxtBtn).perform();
                //nxtBtn.click();
            }
        }
        WebElement finalDelete=driver.findElement(By.xpath("//input[@value='Delete']"));
        finalDelete.click();

        WebElement ajaxCallBtn=driver.findElement(By.xpath("//a[text()='AjaxCall']"));
        ajaxCallBtn.click();

        WebElement ajaxLink=driver.findElement(By.xpath("//a[text()='This is a Ajax link']"));
        ajaxLink.click();
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ContactUs']/p")));

        WebElement ajaxText=driver.findElement(By.xpath("//div[@class='ContactUs']/p"));
        System.out.println(ajaxText.isDisplayed());













    }


}
