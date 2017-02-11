package luna.akamai;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.plugin.dom.DOMObject;
import org.openqa.selenium.WebDriver;



/**
 * Created by mdanilow on 2017-02-10.
 */
public class JobsEditPage {

    WebDriver driver = new FirefoxDriver();
    WebElement findJobField = driver.findElement(By.className("search_input font_bold jCatInput placeholder ui-autocomplete-input"));

}
