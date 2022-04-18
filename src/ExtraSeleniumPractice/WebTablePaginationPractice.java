package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablePaginationPractice {

    /**
     * go to http://syntaxprojects.com/table-pagination-demo.php
     * Go through table and find name Bob V
     * Print the name
     */

    public static String url="http://syntaxprojects.com/table-pagination-demo.php";


    public static void main(String[] args) {
        //opening browser functions
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> rows=driver.findElements(By.xpath("//tbody[@id='myTable']/tr"));
        WebElement nextBtn=driver.findElement(By.xpath("//a[@class='next_link']"));
        boolean flag=true;

        while(flag){
            for(WebElement row:rows){
                String rowText=row.getText();
                if(rowText.contains("Bob V")){
                    flag=false;
                    System.out.println(rowText);
                    break;
                }

            }
            if(flag){
                nextBtn.click();
            }

        }



    }

}

class EmployeeListPagination{

    public static String url="http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
    public static void main(String[] args) throws InterruptedException {
        /**
         * Navigate to hrm website
         * login using valid credentials
         * Navigate to add employee
         * Create a new employee and save
         * Save the empID
         * Navigate to list of employees
         * Find employee that was added and delete it
         */

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //login actions
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        //creating a new Employee, retrieving employee id, and saving the new employee
        WebElement pimBtn=driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
        pimBtn.click();
        WebElement addEmployeeBtn=driver.findElement(By.xpath("//a[text()='Add Employee']"));
        addEmployeeBtn.click();
        WebElement firstNameTextBox=driver.findElement(By.cssSelector("input#firstName"));
        firstNameTextBox.sendKeys("Kobe");
        WebElement lastNameTextBox=driver.findElement(By.cssSelector("input#lastName"));
        lastNameTextBox.sendKeys("Bryant");
        WebElement employeeIDField=driver.findElement(By.cssSelector("input#employeeId"));
        String employeeIDText=employeeIDField.getAttribute("value");
        WebElement saveBtn=driver.findElement(By.cssSelector("input#btnSave"));
        saveBtn.click();
        Thread.sleep(5000);

        WebDriverWait wait=new WebDriverWait(driver,20);
        //wait.until(ExpectedConditions.)
        WebElement employeeListBtn=driver.findElement(By.xpath("//a[text()='Employee List']"));
        employeeListBtn.click();
        boolean flag=true;

        while(flag){
            List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for(int i=0;i< tableRows.size();i++){
                String rowText=tableRows.get(i).getText();
                if(rowText.contains(employeeIDText)){
                    flag=false;
                    WebElement checkbox=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" +i+ "]/td[1]"));
                    checkbox.click();
                    WebElement deleteBtn=driver.findElement(By.cssSelector("input#btnDelete"));
                    deleteBtn.click();
                    WebElement confirmDeleteBtn=driver.findElement(By.cssSelector("input#dialogDeleteBtn"));
                    confirmDeleteBtn.click();
                    break;
                }

            }
                if(flag){
                    WebElement nextBtn=driver.findElement(By.xpath("//a[text()='Next']"));
                    nextBtn.click();
                }
        }



    }




}
