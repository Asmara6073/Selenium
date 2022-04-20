package UnveilAndReflectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnveilReflectHomePage {
WebDriver driver=null;

public UnveilReflectHomePage(WebDriver driver){
    this.driver=driver;
}


By button_About=By.xpath("//p[text()='About']");
By button_Blog=By.xpath("//p[text()='Blog']");
By button_Contact=By.xpath("//p[text()='Contact']");
By button_Reflect=By.xpath("//span[text()='Reflect']");

 public void clickAboutButton(){
     driver.findElement(button_About).click();
 }

 public void clickBlogButton(){
     driver.findElement(button_Blog).click();
 }

 public void clickContactButton(){
     driver.findElement(button_Contact).click();
 }

 public void clickReflectButton(){
     driver.findElement(button_Reflect).click();
 }


}
