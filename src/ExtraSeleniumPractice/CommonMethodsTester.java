package ExtraSeleniumPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

public class CommonMethodsTester {

    public static void main(String[] args) {

        CommonMethods.openBrowser("https://www.google.com/");
        CommonMethods.closeBrowser();
    }
}
