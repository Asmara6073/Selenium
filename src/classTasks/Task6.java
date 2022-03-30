package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task6 {

    /*
    HRMS Application Negative Login:
    Open chrome browser
    Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
    Enter valid username
    Leave password field empty
    Click on login button
    Verify error message with text "Password cannot be empty" is displayed.
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        String URL="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        WebDriver driver=new ChromeDriver();
        driver.get(URL);
        WebElement usernameField=driver.findElement(By.cssSelector("input#txtUsername"));
        usernameField.sendKeys("Admin");
        WebElement loginBtn=driver.findElement(By.cssSelector("input#btnLogin"));
        if(loginBtn.isEnabled()){
            loginBtn.click();
        }

        WebElement passwordErrorMessage=driver.findElement(By.cssSelector("span#spanMessage"));

        if(passwordErrorMessage.isDisplayed()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.quit();

    }
}
