package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    //navigate to fb.com
    //click on create new account
    //fill up all the textboxes
    //click on sign up button
    //close the pop up
    //close the browser

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        String URL="https://www.facebook.com/";

        driver.get(URL);
        WebElement createAcctBtn=driver.findElement(By.xpath("//a[text()='Create new account']"));
        createAcctBtn.click();
        Thread.sleep(3000);
        WebElement firstNameField=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameField.sendKeys("Kirat");
        WebElement lastNameField=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameField.sendKeys("Abe");
        WebElement numberOrEmailField=driver.findElement(By.xpath("//input[@name='reg_email__']"));
        numberOrEmailField.sendKeys("202-333-4444");
        WebElement newPasswordField=driver.findElement(By.cssSelector("input#password_step_input"));
        newPasswordField.sendKeys("Password123");
        WebElement signUpBtn=driver.findElement(By.xpath("//button[text()='Sign Up']"));

        if(signUpBtn.isDisplayed()&&signUpBtn.isEnabled()){
            signUpBtn.click();
        }

        WebElement xOutBtn=driver.findElement(By.xpath("//img[@src='https://static.xx.fbcdn.net/rsrc.php/v3/y2/r/__geKiQnSG-.png']"));

        if(xOutBtn.isEnabled()){
            System.out.println("x out button is enabled");
            xOutBtn.click();
        }else{
            System.out.println("x out button is not enabled");
        }

        driver.quit();





    }
}
