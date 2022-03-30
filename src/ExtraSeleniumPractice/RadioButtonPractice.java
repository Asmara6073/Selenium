package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtonPractice {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        String URL="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
        driver.get(URL);
        WebElement usernameField=driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        usernameField.sendKeys("Tester");
        WebElement passwordField=driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
        passwordField.sendKeys("test");
        WebElement loginBtn=driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button"));
        loginBtn.click();
        WebElement orderBtn=driver.findElement(By.xpath("//a[text()='Order']"));
        orderBtn.click();

        List<WebElement> radio=driver.findElements(By.name("ctl00$MainContent$fmwOrder$cardList"));

        for(WebElement radioBtns:radio){
            String value=radioBtns.getAttribute("value");
            if(value.equalsIgnoreCase("Visa")){
                if(radioBtns.isEnabled()){
                    radioBtns.click();
                    if(radioBtns.isSelected()){
                        System.out.println("CHECKED");
                    }else{
                        System.out.println("NOT CHECKED");
                    break;
                }

            }

            }
        }

        Thread.sleep(4000);
        driver.quit();

    }
}

