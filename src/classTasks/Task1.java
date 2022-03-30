package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    //HW
    //navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
    //fill out the form
    //click on register
    //close the browser




    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        String URL="https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0";
        driver.get(URL);
        Thread.sleep(3000);
        WebElement firstNameField=driver.findElement(By.id("customer.firstName"));
        firstNameField.sendKeys("Tarik");
        WebElement lastNameField=driver.findElement(By.xpath("//input[@id='customer.lastName']"));
        lastNameField.sendKeys("Abraham");
        WebElement addressField=driver.findElement(By.xpath("//input[contains(@name,'street')]"));
        addressField.sendKeys("123 Main Street");
        WebElement cityField=driver.findElement(By.xpath("//input[@id='customer.address.city']"));
        cityField.sendKeys("Washington");
        WebElement stateField=driver.findElement(By.xpath("//input[@id='customer.address.state']"));
        stateField.sendKeys("DC");
        WebElement zipCodeField=driver.findElement(By.cssSelector("input[id$='zipCode']"));
        zipCodeField.sendKeys("21116");
        WebElement phoneNumberField=driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
        phoneNumberField.sendKeys("202-123-4567");
        WebElement SSN=driver.findElement(By.cssSelector("input[id$='ssn']"));
        SSN.sendKeys("123-45-6789");
        WebElement usernameField=driver.findElement(By.cssSelector("input[id='customer.username']"));
        usernameField.sendKeys("Tarik12345");
        WebElement passwordField=driver.findElement(By.xpath("//input[@id='customer.password']"));
        passwordField.sendKeys("Password123");
        WebElement confirmPasswordField=driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
        confirmPasswordField.sendKeys("Password123");
        WebElement loginBtn=driver.findElement(By.xpath("//input[@value='Register']"));
        if(loginBtn.isEnabled()){
            loginBtn.click();
        }

        Thread.sleep(3000);
        WebElement loginSuccessMsg=driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));

        if(loginSuccessMsg.isDisplayed()){
            System.out.println("Login was successful. PASSED");
            driver.quit();
        }else{
            System.out.println("FAILED");
        }
        // test to see if it is enabled, and only then will you be able to click it


        //Test Script


















    }
}
