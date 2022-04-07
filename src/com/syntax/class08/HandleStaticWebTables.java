package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class HandleStaticWebTables {

    public static String url = "http://syntaxprojects.com/table-search-filter-demo.php";


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

       List<WebElement> rowData= driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
        System.out.println(rowData.size());

        Iterator<WebElement> itr= rowData.iterator();

        while(itr.hasNext()){
            WebElement row=itr.next();
            String rowText=row.getText();
            System.out.println(rowText);
        }

        System.out.println("----------------------------");

        List<WebElement> columnData=driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
        System.out.println(columnData.size());

        for(WebElement columns:columnData){
            String colText=columns.getText();
            System.out.println(colText);
        }

}

}
