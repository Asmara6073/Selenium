package com.syntax.test;

import com.syntax.pages.LoginPage;
import com.syntax.testbase.Base;

public class LoginPageTest {

    public static void main(String[] args) {

        Base.openWithSpecificURL("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        LoginPage loginPage=new LoginPage();
        loginPage.username.sendKeys("Tester");
        loginPage.password.sendKeys("test");
        loginPage.loginBtn.click();
        Base.tearDown();

    }
}
