package ExtraSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class MoreDropDownPractice {

    public static String url="http://syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");// set the properties
        WebDriver driver=new ChromeDriver();// launch browser

        driver.get(url);//navigate to page
        WebElement singleSelectDD=driver.findElement(By.cssSelector("select#select-demo"));// dropdown element

        Select select=new Select(singleSelectDD);// calling select class to navigate drop down

        List<WebElement> options=select.getOptions();// storing all options in a list

      for(WebElement option:options){// looping through list of options in DropDown
            String optionText=option.getText();// getting text from each option
            select.selectByVisibleText(optionText);// selecting each option based on their text
        }

        Iterator<WebElement> itr=options.iterator();

       while(itr.hasNext()){
            WebElement option=itr.next();
            String optionValue=option.getAttribute("value");
            select.selectByValue(optionValue);

        }



    }

}

class MultipleDropDown{
    public static String url="http://syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");// set the properties
        WebDriver driver=new ChromeDriver();// launch browser

        driver.get(url);//navigate to page

        WebElement multipleSelect= driver.findElement(By.cssSelector("select#multi-select"));//locate the dropdown
        Select select=new Select(multipleSelect);// call select class to handle the dropdown

        List<WebElement> options=select.getOptions();// store all options of DD in a List

        for(WebElement option:options){// loop through all options in the list
            String value=option.getAttribute("value");// create a string that will hold all values from all options
            System.out.println(value);// print the values
            select.selectByValue(value);// select each option byValue

        }

        Iterator<WebElement> itr=options.iterator();

        while(itr.hasNext()){// iterate through each option in
            WebElement option=itr.next();// store each option in a webelement
            String optionTxt=option.getText();//storing the text of each option in a string
            select.selectByVisibleText(optionTxt);// select each option based on its visibleText
        }







}

    }
