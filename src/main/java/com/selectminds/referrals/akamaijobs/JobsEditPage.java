package com.selectminds.referrals.akamaijobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JobsEditPage extends PageObject
{
    @FindBy(id="keyword")
    public WebElement searchField;

    @FindBy(id="loc_placeholder")
    public WebElement locationField;

    @FindBy(id="jLocInputHldr")
    public WebElement locationHolder;

    @FindBy(className = "chzn-results")
    public WebElement locationsResults;

    @FindBy(tagName = "li")
    public List<WebElement> options;

    @FindBy(className = "search_btn_hldr")
    public WebElement searchButton;

    @FindBy(className = "total_results")
    public WebElement totalResults;

    @FindBy(xpath = "//div[@id='job_results_list_hldr']//a[@class='job_link font_bold']")
    public List<WebElement> jobs;

    @FindBy(xpath = "//div[@class='info_box_fields']//dd[@class='job_post_date']//span[@class='field_value']")
    public WebElement jobPostDate;

    public JobsEditPage(WebDriver driver)
    {
        super(driver);
    }
}
