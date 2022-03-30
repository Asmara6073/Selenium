package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxPractice {
    public static void main(String[] args) {
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
        WebElement listOfAllOrdersSign=driver.findElement(By.xpath("//div[@class='cornerLeft']/following-sibling::h2"));
        if(listOfAllOrdersSign.isDisplayed()){
            System.out.println("PASS");
        }
        WebElement firstCheckBox=driver.findElement(By.cssSelector("input#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));

        boolean status=firstCheckBox.isEnabled();
        boolean checkStatus=firstCheckBox.isSelected();
        System.out.println(status);
        System.out.println(checkStatus);

        firstCheckBox.click();

        System.out.println(checkStatus);
        driver.quit();

    }
}
