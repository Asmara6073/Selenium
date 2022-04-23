package Tests.HRMS;

import Pages.HRMSLogin.HRMSLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PasswordErrorMessageValidationTest {

    public static String url="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/pim/viewEmployeeList";
    public static String username="Admin";
    public static String password="";

    static WebDriver driver=null;

    public static void main(String[] args) {

        System.out.println(verifyPasswordErrorMessage());
    }
    public static boolean verifyPasswordErrorMessage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        HRMSLoginPage hrmsLoginPage = new HRMSLoginPage(driver);
        return hrmsLoginPage.passwordNotEmptyIsDisplayed(username,password);
    }



}
