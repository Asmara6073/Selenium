package com.syntax.pages;

import com.syntax.utils.CommonMethods1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class LoginPage extends CommonMethods1 {

    public WebElement username=driver.findElement(By.id("ctl00_MainContent_username"));
    public  WebElement password=driver.findElement(By.id("ctl00_MainContent_password"));
    public WebElement loginBtn=driver.findElement(By.className("button"));
}
