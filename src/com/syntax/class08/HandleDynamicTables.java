package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleDynamicTables {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
        WebElement username = driver.findElement(By.xpath("//input[contains(@id, 'username')]"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type = 'password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Login']"));
        loginButton.click();

        List<WebElement> rowData=driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));

        for(int i=1;i< rowData.size();i++){
           String rowText= rowData.get(i).getText();
            System.out.println(rowText);
            if(!rowText.contains("Bob Feather")){
                List<WebElement> checkboxes=driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[1]"));
                checkboxes.get(i-1).click();
            }


        }


    }

}
