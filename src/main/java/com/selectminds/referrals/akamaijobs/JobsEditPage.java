package com.selectminds.referrals.akamaijobs;

import com.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobsEditPage extends PageObject
{
    public static WebElement searchField = driver.findElement(By.id("keyword"));

    public static WebElement locationField = driver.findElement(By.id("loc_placeholder"));

    public static WebElement locationHolder = driver.findElement(By.id("jLocInputHldr"));
    public static WebElement locationsResults = locationHolder.findElement(By.className("chzn-results"));

// should I put this list on edit page, or on the base page????
    List<WebElement> options = JobsEditPage.locationsResults.findElements(By.tagName("li"));

    public static WebElement searchButton = driver.findElement(By.className("search_btn_hldr"));

    public static WebElement totalResults = driver.findElement(By.className("total_results"));

//  Edit or base page?
    List<WebElement> jobs = driver.findElements(By.xpath("//div[@id='job_results_list_hldr']//a[@class='job_link font_bold']"));

    public static WebElement jobPostDate = driver.findElement(By.xpath("//div[@class='info_box_fields']//dd[@class='job_post_date']//span[@class='field_value']"));

    public JobsEditPage(WebDriver driver) {
        super(driver);
    }
}
