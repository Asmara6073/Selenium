package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NewFacebookAccount {

    public static String url="https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        WebElement createAccountBtn=driver.findElement(By.xpath("//a[text()='Create new account']"));
        createAccountBtn.click();
        Thread.sleep(3000);
        WebElement firstNameField=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameField.sendKeys("Kirat");
        WebElement lastNameField=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameField.sendKeys("Ozkan");
        WebElement numberOrEmailField=driver.findElement(By.xpath("//input[@name='reg_email__']"));
        numberOrEmailField.sendKeys("202-111-2222");
        WebElement newPasswordField=driver.findElement(By.cssSelector("input#password_step_input"));
        newPasswordField.sendKeys("Abraham1234");

        // create find Webelements of the drop down menus for month,day,and year
        WebElement monthDD=driver.findElement(By.cssSelector("select#month"));
        WebElement daysDD=driver.findElement(By.cssSelector("select#day"));
        WebElement yearsDD=driver.findElement(By.cssSelector("select#year"));

        //Create object of select class using that WebElement and selecting value I need from drop down
        Select monthSelect=new Select(monthDD);
        monthSelect.selectByVisibleText("Apr");

        Select daySelect=new Select(daysDD);
        daySelect.selectByValue("21");

        Select yearSelect=new Select(yearsDD);
        yearSelect.selectByValue("1997");

        //Create a list of WebElements that contains the radio buttons
        //Then loop through them and choose the radio button by attribute

        List<WebElement> genderRadioBtns=driver.findElements(By.className("_8esa"));

        for(WebElement radio:genderRadioBtns){
            String value=radio.getAttribute("value");
            String male="2";
            String female="1";
            String custome="-1";
            if(value.equals(male)){
                radio.click();
                break;
            }
        }

        WebElement signupBtn=driver.findElement(By.xpath("//button[@name='websubmit']"));
        signupBtn.click();
        WebElement xOutBtn=driver.findElement(By.xpath("//img[@src='https://static.xx.fbcdn.net/rsrc.php/v3/y2/r/__geKiQnSG-.png']"));
        xOutBtn.click();

        Thread.sleep(3000);
        driver.quit();









    }

}
