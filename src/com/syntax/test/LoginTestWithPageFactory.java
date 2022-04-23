package com.syntax.test;

import com.syntax.pages.DashboardPage;
import com.syntax.pages.LoginPageWithpageFactory;
import com.syntax.testbase.Base;
import com.syntax.utils.CommonMethods1;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LoginTestWithPageFactory {
    public static void main(String[] args) {


        Base.openWithSpecificURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/pim/viewEmployeeList");
        LoginPageWithpageFactory loginPageWithpageFactory = new LoginPageWithpageFactory();
        DashboardPage dashboardPage = new DashboardPage();
        CommonMethods1.sendText(loginPageWithpageFactory.username, "Admin");
        CommonMethods1.sendText(loginPageWithpageFactory.password, "Hum@nhrm123");

        //loginPageWithpageFactory.username.sendKeys("Admin");
        //loginPageWithpageFactory.password.sendKeys("Hum@nhrm123");
        loginPageWithpageFactory.loginBtn.click();

        TakesScreenshot ts = (TakesScreenshot) Base.driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File("screenshots/HRMS/dashboard.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String welcomeText = dashboardPage.welcomeAdmin.getText();
        System.out.println(welcomeText);
        Base.tearDown();


    }

}
