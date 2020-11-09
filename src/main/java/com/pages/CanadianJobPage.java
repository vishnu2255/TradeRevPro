package com.pages;

import com.utilities.WaitUtils;
import com.utilities.reader.TestDataReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CanadianJobPage extends BasePage {

    private WebDriver driver;
    private WaitUtils waitUtils;
    private final TestDataReader testDataReader;

    public CanadianJobPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        testDataReader = new TestDataReader();
    }


    @FindBy(xpath = "//a[contains(text(),'Canadian Opportunities')]")
    WebElement canadianOpportunitiesLink;

    @FindBy(xpath = "//a[contains(text(),'U.S. Opportunities')]")
    WebElement usOpportunitiesLink;

    @FindBy(xpath = "//div[@aria-label='Filter by Location: All']")
    WebElement locationFilterButton;

    @FindBy(xpath = "//div[@aria-label='Filter by Team: All']")
    WebElement teamFilterButton;

    @FindBy(xpath = "//div[@class='filter-popup']/ul")
    WebElement locationsList;

    @FindBy(xpath = "//div[@class='postings-group']//div[@class='posting']//span[@class='sort-by-location posting-category small-category-label']")
    List<WebElement> locationsSpan;

    @FindBy(xpath = "//div[@class='postings-group']//div[@class='posting']//span[@class='sort-by-team posting-category small-category-label']")
    List<WebElement> teamSpan;

    @FindBy(xpath = "//div[@class='posting-apply']/a[text()='Apply']")
    List<WebElement> applyLinks;

    String locationXpath = "//div[@class='filter-popup']/ul//a[contains(text(),'city')]";
    String teamXpath = "//div[@class='filter-popup']/ul//a[contains(text(),'team')]";


    public void jobPortalPageLoaded(){
        Assert.assertTrue("Job portal page not loaded ",driver.getCurrentUrl().equalsIgnoreCase(testDataReader.readData("jobsportal")));
    }

    private Boolean validateSelectedCity(String city){
        return driver.getCurrentUrl().contains(city);
    }
    private Boolean validateSelectedTeam(String team){
        return driver.getCurrentUrl().contains(team);
    }

    public void searchByCity(String city){
        clickElement(locationFilterButton);
        String newLocationPath = locationXpath.replace("city", city.trim());
        WebElement cityElement = driver.findElement(By.xpath(newLocationPath));
        clickElement(cityElement);
        Assert.assertTrue("City is not selected ",validateSelectedCity(city.split(",")[0]));
    }

    public void searchByCityAndTeam(String city, String team){
        searchByCity(city);
        clickElement(teamFilterButton);
        String newTeamPath = teamXpath.replace("team", team.trim());
        WebElement cityElement = driver.findElement(By.xpath(newTeamPath));
        clickElement(cityElement);
        Assert.assertTrue("Team is not selected ",validateSelectedTeam(team));
    }


    public void canadianJobPortalIsLoaded(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        jobPortalPageLoaded();
    }

    public void validateListedJobsBelongToCity(String expectedCity){
        for(WebElement locationElement : locationsSpan){
            String actualCity = locationElement.getText();
            Assert.assertTrue("listed job location not matching with "+expectedCity,expectedCity.equalsIgnoreCase(actualCity));
        }
    }

    public void validateListedJobsBelongToCityAndTeam(String expectedCity,String expectedTeam){
        validateListedJobsBelongToCity(expectedCity);
        for(WebElement teamElement : teamSpan){
            String actualTeamName = teamElement.getText().trim();
            Assert.assertTrue("listed team not matching with "+expectedTeam,actualTeamName.toLowerCase().startsWith(expectedTeam.toLowerCase()));
        }
    }

    public void printTotalNumberOfJobs(){
        System.out.println("total number of jobs listed are "+applyLinks.size());
    }


}
