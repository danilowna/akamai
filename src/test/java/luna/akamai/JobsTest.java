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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JobsTest
{
    Logger logger = LoggerFactory.getLogger(JobsTest.class);

    @Test
    public void test001_Jobs_test_search() throws Exception {

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

        for (WebElement option : options) {

            if (option.getText().equalsIgnoreCase("Krakow, Poland")) {

                option.click();
            }
        }

        WebElement searchButton = driver.findElement(By.className("search_btn_hldr"));
        searchButton.click();

        WebElement totalResults = driver.findElement(By.className("total_results"));
        totalResults.getText();

        //
        List<WebElement> jobs = driver.findElements(By.xpath("//div[@id='job_results_list_hldr']//a[@class='job_link font_bold']"));
        logger.info("Total jobs " + jobs.size());

        // Now using Iterator we will iterate all elements
        int count = 0;
        Iterator<WebElement> iter = jobs.iterator();
        while (iter.hasNext()) {

            // Iterate one by one
            WebElement item = iter.next();

            // get the text
            String label = item.getText();
            if (label.contains("Software Development Engineer in Test"))
            // print the text
            {
                logger.info("Row label is " + label);
                count ++;
            }
        }
        System.out.println("Nubmer of 'Software Development Engineer in Test' jobs is: " + count);

        WebElement luna = driver.findElement(By.linkText("Software Development Engineer in Test - LUNA"));
        luna.click();

            driver.close();
            driver.quit();


    }
}
