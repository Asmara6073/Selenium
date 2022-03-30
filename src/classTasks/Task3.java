package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    /*
     * Task
     * Navigate to http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx
     * Login
     * Get title and verify
     * logout
     * close the browser
     */

    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
    WebDriver driver=new ChromeDriver();

    String URL="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
    driver.get(URL);
        WebElement usernameField=driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        usernameField.sendKeys("Tester");
        WebElement passwordField=driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("test");
        WebElement loginBtn=driver.findElement(By.xpath("//input[@value='Login']"));
        if(loginBtn.isEnabled()){
            System.out.println("Login button is enabled");
            loginBtn.click();
        }else{
            System.out.println("Login button is disabled");
        }
        String webTitle=driver.getTitle();
        if(webTitle.equals("Web Orders")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        WebElement logoutBtn=driver.findElement(By.xpath("//a[text()='Logout']"));
        if(logoutBtn.isEnabled()){
            logoutBtn.click();
        }
        Thread.sleep(3000);
        driver.quit();


    }
}
