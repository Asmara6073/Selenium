package Pages.HRMSLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HRMSLoginPage {

    WebDriver driver=null;


 public HRMSLoginPage(WebDriver driver){
    this.driver=driver;
}

    By textbox_Username= By.cssSelector("input#txtUsername");
    By textbox_Password= By.cssSelector("input#txtPassword");
    By button_Login=By.cssSelector("input#btnLogin");
    By errorMessage_passwordNotEmpty=By.cssSelector("span#spanMessage");
    By errorMessage_usernameNotEmpty=By.xpath("//span[text()='Username cannot be empty']");
    By errorMessage_invalidCredentials=By.xpath("//span[text()='Invalid credentials']");
    public static String passwordNotEmptyText="Password cannot be empty";
    public static String usernameNotEmptyText="Username cannot be empty";
    public static String invalidCredentialsText="Invalid credentials";




  public void loginHRMS(String username,String password){
      driver.findElement(textbox_Username).sendKeys(username);
      driver.findElement(textbox_Password).sendKeys(password);
      driver.findElement(button_Login).click();
  }

  public boolean passwordNotEmptyIsDisplayed(String username,String password){
      boolean isDisplayed=false;
      loginHRMS(username,password);
      if(passwordNotEmptyText.equals(driver.findElement(errorMessage_passwordNotEmpty).getText())){
          isDisplayed=true;
      }else{
          isDisplayed=false;
      }
      return isDisplayed;
  }

  public boolean usernameNotEmptyIsDisplayed(String username,String password){
      boolean isDisplayed=false;
      loginHRMS(username,password);
      if(usernameNotEmptyText.equals(driver.findElement(errorMessage_usernameNotEmpty).getText())){
          isDisplayed=true;
      }else{
          isDisplayed=false;
      }
      return isDisplayed;
  }

  public boolean invalidCredentialsIsDisplayed(String username,String password){
      boolean isDisplayed=false;
      loginHRMS(username,password);
      if(invalidCredentialsText.equals(driver.findElement(errorMessage_invalidCredentials).getText())){
          isDisplayed=true;
      }else{
          isDisplayed=false;
      }
      return isDisplayed;
  }

}
