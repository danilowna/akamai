package com.selectminds.referrals.akamaijobs;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JobsTest extends BaseTest
{
    Logger logger = LoggerFactory.getLogger(JobsTest.class);
    JobsEditPage jobsEditPage = new JobsEditPage(driver);

    @Test
    public void test001_Jobs_test_search() throws Exception
    {

        driver.get("https://akamaijobs.referrals.selectminds.com");

        jobsEditPage.searchField.sendKeys("test");

        jobsEditPage.locationField.click();

        selectLocation("Krakow, Poland");

        jobsEditPage.searchButton.click();

        jobsEditPage.totalResults.getText();

        logger.info("Total jobs " + jobsEditPage.jobs.size());

        String jobName = "Software Development Engineer in Test";
        System.out.println("Nubmer of " + jobName + " jobs is: " + countJobs(jobName));

        selectLink("Software Development Engineer in Test - LUNA");

        jobsEditPage.jobPostDate.getText();

    }
    public void selectLocation (String location) throws Exception
    {
        for (WebElement option : jobsEditPage.options)
        {
            if (option.getText().equalsIgnoreCase(location))
            {
                option.click();
                break;
            }
        }
    }

    public int countJobs (String name) throws Exception
    {
        int count = 0;
        for (WebElement item : jobsEditPage.jobs)
        {
            String label = item.getText();
            if (label.contains(name)) {
                count++;
            }
        }
        return count;
    }

    public static void selectLink(String linkName) throws Exception
    {
        WebElement link = driver.findElement(By.linkText(linkName));
        link.click();
    }
}
