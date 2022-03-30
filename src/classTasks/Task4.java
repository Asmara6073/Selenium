package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
    /*
    Open chrome browser
    Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
    Enter valid username and password (username - Admin, password - Hum@nhrm123)
    Click on login button
    Then verify Syntax Logo is displayed.
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        String URL="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        driver.get(URL);
        WebElement usernameField=driver.findElement(By.cssSelector("input#txtUsername"));
        usernameField.sendKeys("Admin");
        WebElement passwordField=driver.findElement(By.cssSelector("input#txtPassword"));
        passwordField.sendKeys("Hum@nhrm123");
        WebElement loginBtn=driver.findElement(By.cssSelector("input#btnLogin"));

        if(loginBtn.isEnabled()){
            loginBtn.click();
        }
        WebElement syntaxLogo=driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));

        if(syntaxLogo.isDisplayed()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();

    }


}
