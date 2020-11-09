package com.steps.ui;

import com.pages.CanadianJobPage;
import com.pages.CareersPage;
import com.pages.HomePage;
import com.utilities.reader.TestDataReader;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions extends DriverFactory {

    public TestDataReader testDataReader;
    public HomePage homePage;
    public CanadianJobPage canadianJobPage;
    public CareersPage careersPage;

    public StepDefinitions(){
        testDataReader = new TestDataReader();
        homePage = new HomePage(driver);
        canadianJobPage = new CanadianJobPage(driver);
        careersPage = new CareersPage(driver);
    }

    @Given("^I launch TradeRev home page$")
    public void i_launch_TradeRev_home_page() {
        String url = testDataReader.readData("url");
        driver.navigate().to(url.trim());
    }

    @Given("^Navigate to (.*) page$")
    public void navigate_to_careers_page(String section){

        switch (section.trim().toLowerCase()){
            case "careers":
                homePage.navigateToCareersPage();
                break;
            case "news":
                System.out.println("news");
                break;
            case "faq":
                System.out.println("faq");
                break;
            case "contact":
                System.out.println("contact");
                break;
            case "about us":
                System.out.println("about us");
                break;
            default:
                System.out.println("not a valid section");
        }
    }

    @Given("^Validate the (.*) page is displayed correctly$")
    public void validate_the_careers_page_is_displayed_correctly(String section) {
        switch (section.trim().toLowerCase()){
            case "careers":
                careersPage.validateCareersPageLoaded();
                break;
            case "news":
                System.out.println("news");
                break;
            case "faq":
                System.out.println("faq");
                break;
            case "contact":
                System.out.println("contact");
                break;
            case "about us":
                System.out.println("about us");
                break;
            default:
                System.out.println("not a valid section");
        }
    }

    @When("^I click on (.*) job opportunities$")
    public void i_click_on_canadian_job_opportunities(String country) {

        if(country.toLowerCase().equalsIgnoreCase("canadian")){
            careersPage.navigateToCanadianJobPortal();
        }
        else if(country.toLowerCase().equalsIgnoreCase("us")){
            careersPage.navigateToUSJobPortal();
        }

    }

    @Then("^Validate (.*) job site is displayed correctly$")
    public void validate_canadian_job_site_is_displayed_correctly(String country) {
        if(country.toLowerCase().equalsIgnoreCase("canadian")){
            canadianJobPage.canadianJobPortalIsLoaded();
        }
    }

    @Given("^I launch TradeRev job portal$")
    public void i_launch_TradeRev_job_portal() {
        String url = testDataReader.readData("jobsportal");
        driver.navigate().to(url.trim());
    }

    @When("^I filter the search results by (.*) and (.*)$")
    public void i_filter_the_search_results_by_(String city, String team){
        canadianJobPage.searchByCityAndTeam(city.trim(),team.trim());
    }

    @Then("^Validate the listed jobs belong to (.*) and (.*)$")
    public void validate_the_listed_jobs_belong_to_Toronto_Ontario_Canada_and_Engineering(String city, String team) {
        canadianJobPage.validateListedJobsBelongToCityAndTeam(city.trim(),team.trim());
    }

    @Then("^Validate the listed job results should belong to (.*)$")
    public void validateTheListedJobResultsShouldBelongToCity(String city) {
        canadianJobPage.validateListedJobsBelongToCity(city.trim());
    }

    @When("^I filter the search results by location (.*)$")
    public void iFilterTheSearchResultsByCity(String city) {
        canadianJobPage.searchByCity(city.trim());
    }

    @And("^I check the job portal is loaded$")
    public void iCheckTheJobPortalIsLoaded() {
        canadianJobPage.jobPortalPageLoaded();
    }

    @And("^I log the total number of jobs listed$")
    public void iLogTheTotalNumberOfJobsListed() {
        canadianJobPage.printTotalNumberOfJobs();
    }
}
