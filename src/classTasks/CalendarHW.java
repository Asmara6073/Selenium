package classTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarHW {

    /**
     *Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
     * click on leave
     * click on leave list
     * choose from "From calendar"
     * choose from "To calendar"
     * click only on cancelled and rejected checkboxes
     * uncheck Pending Approval
     * select IT support from DD
     * click search
     * quit the browser
     */

    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //login functions
        WebElement username=driver.findElement(By.cssSelector("input#txtUsername"));
        WebElement password=driver.findElement(By.cssSelector("input#txtPassword"));
        WebElement loginBtn=driver.findElement(By.cssSelector("input#btnLogin"));
        username.sendKeys("Admin");
        password.sendKeys("Hum@nhrm123");
        loginBtn.click();

        WebElement leaveBtn=driver.findElement(By.xpath("(//a[@class='firstLevelMenu'])[3]"));

        leaveBtn.click();

        WebElement leaveListBtn=driver.findElement(By.cssSelector("a#menu_leave_viewLeaveList"));
        leaveListBtn.click();

        WebElement fromDate=driver.findElement(By.cssSelector("input#calFromDate"));
        fromDate.click();


        WebElement monthDD=driver.findElement(By.cssSelector("select.ui-datepicker-month"));
        Select select=new Select(monthDD);
        select.selectByVisibleText("Apr");


        List<WebElement> fromDays=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement day:fromDays){
            String dateText=day.getText();
            if(dateText.equals("21")){
                day.click();
                break;
            }
        }


        WebElement toDate=driver.findElement(By.cssSelector("input#calToDate"));
        toDate.click();

        WebElement toDateMonthDD=driver.findElement(By.cssSelector("select.ui-datepicker-month"));
        Select select2=new Select(toDateMonthDD);
        select2.selectByVisibleText("May");

        WebElement yearDD=driver.findElement(By.cssSelector("select.ui-datepicker-year"));
        Select select3=new Select(yearDD);
        select3.selectByVisibleText("2022");

        List <WebElement> toDays=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement toDates:toDays){
            String toDatesText=toDates.getText();

            if(toDatesText.equals("1")){
                toDates.click();
                break;
            }
        }
        List<WebElement> leaveStatusCheckBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));

        for(WebElement checkBox:leaveStatusCheckBoxes){
            String value=checkBox.getAttribute("value");
            if(value.equals("-1")&&value.equals("0")){
                checkBox.click();
                break;
            }
            if(value.equals("1")){
                checkBox.click();
                break;
            }
        }

        WebElement subUnitDD=driver.findElement(By.cssSelector("select#leaveList_cmbSubunit"));
        Select select4=new Select(subUnitDD);
        select4.selectByVisibleText("IT Support");

        WebElement searchBtn=driver.findElement(By.cssSelector("input#btnSearch"));
        searchBtn.click();

        driver.quit();


















    }


}
