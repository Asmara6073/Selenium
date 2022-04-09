package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicAndStaticTables {

    public static String url="http://syntaxprojects.com/table-search-filter-demo.php";

    public static void main(String[] args) {
        //Static Table
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> rowData=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));

        for(WebElement rows:rowData){
            String rowText=rows.getText();
            System.out.println(rowText);
        }

        System.out.println("-----------------");

        Iterator<WebElement> itr= rowData.iterator();

        while(itr.hasNext()){
            WebElement row=itr.next();
            String rowText=row.getText();
            System.out.println(rowText);
        }

        System.out.println("---------------------------");

        List<WebElement> columnData=driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));

        for(WebElement columns:columnData){
            String columnText= columns.getText();
            System.out.println(columnText);
        }

        Iterator<WebElement> itr1=columnData.iterator();

        while(itr1.hasNext()){
            WebElement column= itr1.next();
            String rowTxt=column.getText();
            System.out.println(rowTxt);
        }




    }

}
