package com.selectminds.referrals.akamaijobs;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JobsTest extends JobsBasePage
{
    Logger logger = LoggerFactory.getLogger(JobsTest.class);

    @Test
    public void test001_Jobs_test_search() throws Exception {

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://akamaijobs.referrals.selectminds.com");

        JobsEditPage.searchField.sendKeys("test");

        JobsEditPage.locationField.click();

        selectLocation("Krakow, Poland");

        JobsEditPage.searchButton.click();

        JobsEditPage.totalResults.getText();

        //??
        List<WebElement> jobs = driver.findElements(By.xpath("//div[@id='job_results_list_hldr']//a[@class='job_link font_bold']"));
        logger.info("Total jobs " + jobs.size());

        String jobName = "Software Development Engineer in Test";
        System.out.println("Nubmer of " + jobName + " jobs is: " + countJobs(jobName));

        selectLink("Software Development Engineer in Test - LUNA");

        JobsEditPage.jobPostDate.getText();
    }
}
