package com.selectminds.referrals.akamaijobs;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.Assert.*;

public class JobsTest extends BaseTest
{
    Logger logger = LoggerFactory.getLogger(JobsTest.class);
    JobsEditPage jobsEditPage = new JobsEditPage(driver);


    @Test
    public void test001_Jobs_test_search() throws Exception
    {
        String jobName1 = "Software Development Engineer in Test";
        String jobName2 = "Software Development Engineer in Test - LUNA";
        String lunaJobPostDate = "Jan 16, 2017";
        String jobNumber = "22";
        int lunaJobNumber = 4;

        logger.info("Go to akamaijobs.referrals.selectminds.com ");
        {
            driver.get("https://akamaijobs.referrals.selectminds.com");
        }

        logger.info("Enter search criteria: test, Krakow office");
        {
            assertTrue("Search Field is not present", jobsEditPage.searchField.isDisplayed());
            jobsEditPage.searchField.sendKeys("test");
            assertTrue("Location Field is not present", jobsEditPage.locationField.isDisplayed());
            jobsEditPage.locationField.click();
            selectLocation("Krakow, Poland");
        }

        logger.info("Click 'Search'.");
        {
            assertTrue("Search Button is not present", jobsEditPage.searchButton.isDisplayed());
            jobsEditPage.searchButton.click();
        }

        logger.info("Validate number of results");
        {
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(jobsEditPage.totalResults));
            assertTrue("Number of results is not present", jobsEditPage.totalResults.isDisplayed());
            Assert.assertEquals("Number of jobs does not match:", jobNumber, jobsEditPage.totalResults.getText());
        }

        logger.info("Validate number of 'Software Development Engineer in Test' results");
        {
            Assert.assertEquals("Number of LUNA jobs does not match:", lunaJobNumber, countJobs(jobName1));
        }

        logger.info("Validate creation date of selected job");
        {
            selectLink(jobName2);
            assertTrue("Post date is not present", jobsEditPage.jobPostDate.isDisplayed());
            Assert.assertEquals("Selected job date does not equal",lunaJobPostDate,jobsEditPage.jobPostDate.getText());
        }
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
