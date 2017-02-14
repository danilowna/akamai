package com.selectminds.referrals.akamaijobs;

import com.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class JobsBasePage extends BaseTest
{

    public static void selectLocation (String location) throws Exception
    {
        List<WebElement> options = JobsEditPage.locationsResults.findElements(By.tagName("li"));
        for (WebElement option : options)
        {
            if (option.getText().equalsIgnoreCase(location))
            {
                option.click();
            }
        }
    }

    public static int countJobs (String name) throws Exception
    {
        List<WebElement> jobs = driver.findElements(By.xpath("//div[@id='job_results_list_hldr']//a[@class='job_link font_bold']"));
        int count = 0;
        Iterator<WebElement> iter = jobs.iterator();
        while (iter.hasNext())
        {
            WebElement item = iter.next();
            String label = item.getText();
            if (label.contains(name))
            {
                count ++;
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
