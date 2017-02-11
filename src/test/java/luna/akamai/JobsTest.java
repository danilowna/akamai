package luna.akamai;

import org.apache.xpath.operations.Equals;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runners.parameterized.TestWithParameters;
import org.junit.validator.*;
import org.junit.matchers.JUnitMatchers;
import org.openqa.selenium.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import junit.framework.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.name;

public class JobsTest
{

    @Test
    public void test001_Jobs_test_search() throws Exception
    {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://akamaijobs.referrals.selectminds.com");

        WebElement jobField = driver.findElement(By.id("keyword"));

        jobField.sendKeys("test");

        WebElement locations = driver.findElement(By.id("loc_placeholder"));
        locations.click();
        WebElement locations3 = driver.findElement(By.id("jLocInputHldr"));
        WebElement locations5 = locations3.findElement(By.className("chzn-results"));

        List<WebElement> options = locations5.findElements(By.tagName("li"));

        for(WebElement option: options) {

            if (option.getText().equalsIgnoreCase("Krakow, Poland")) {

                option.click();
            }
        }

        WebElement searchButton = driver.findElement(By.className("search_btn_hldr"));
        searchButton.click();

        WebElement totalResults = driver.findElement(By.className("total_results"));
        totalResults.getText();

        //

        driver.close();
        driver.quit();

    }
}
