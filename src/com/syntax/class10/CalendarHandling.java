package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarHandling {

    // Navigating to Delta and choosing the departure and return date
    public static String url = "https://www.delta.com/";


        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get(url);

            WebElement calender = driver.findElement(By.id("input_departureDate_1"));
            calender.click();
            WebElement nextbutton = driver.findElement(By.xpath("//span[text()='Next']"));
            WebElement dMonth = driver.findElement(By.className("dl-datepicker-month-0"));
            String dMonthText = dMonth.getText();

            while (!dMonthText.equals("August")) {
                nextbutton.click();
                dMonthText=dMonth.getText();
            }
            List<WebElement> departureDates=driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-0']/tr/td"));
            for(WebElement departureDate:departureDates  ){
                if (departureDate.getText().equals("13")){
                    departureDate.click();
                    break;
                }
            }
            WebElement rMonth=driver.findElement(By.className("dl-datepicker-month-1"));
            String rMonthText= rMonth.getText();

            while (!rMonthText.equals("November")){
                nextbutton.click();
                rMonthText=rMonth.getText();
            }
            List<WebElement> returnDates=driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-1']/tr/td"));
            for(WebElement returnDate:returnDates) {
                if(returnDate.getText().equals("30")){
                    returnDate.click();
                    break;
                }
            }

            WebElement doneButton=driver.findElement(By.xpath("//button[@class='donebutton']")) ;
            doneButton.click();


        }





}
