package com.syntax.pages;

import com.syntax.utils.CommonMethods1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends CommonMethods1 {


    @FindBy (id="welcome")
    public WebElement welcomeAdmin;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }

}
