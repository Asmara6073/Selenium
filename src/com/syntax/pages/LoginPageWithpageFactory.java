package com.syntax.pages;

import com.syntax.utils.CommonMethods1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithpageFactory extends CommonMethods1 {

   @FindBy (id="txtUsername")
    public WebElement username;

   @FindBy (xpath="//input[@id='txtPassword']")
    public WebElement password;

   @FindBy(css = "input#btnLogin")
    public WebElement loginBtn;

   public LoginPageWithpageFactory(){
       PageFactory.initElements(driver,this);
   }

}
