package com.lely.stepDefinitions;

import com.lely.pages.searchButton;
import com.lely.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class searchFunction_stepDefinitions {

    searchButton searchButtonPage= new searchButton();

    @Given("user is on the web page")
    public void user_is_on_the_web_page() {
        Driver.getDriver().get("https://www.lely.com/en");
    }
    @When("User clicks the search button and verify search area appeared")
    public void user_clicks_the_search_button_and_verify_search_area_appeared() {
        searchButtonPage.searchIcon.click();
    }
    @When("User enters “happy” into the search area and click the search button")
    public void user_enters_happy_into_the_search_area_and_click_the_search_button() {
        searchButtonPage.searchArea.sendKeys("happy");
        searchButtonPage.searchButton.click();
    }
    @Then("User should see that the descriptions of each of the search results contain the searched word")
    public void user_should_see_that_the_descriptions_of_each_of_the_search_results_contain_the_searched_word() {
        for(WebElement result:searchButtonPage.searchResults){
            WebElement happyWord = result.findElement(By.className("item-description"));
            String description = happyWord.getText();

            if (description.contains("cucumber")) {
                System.out.println("The description contains the word 'happy'");
            } else {
                System.out.println("The description does not contain the word 'happy'");
            }
        }
    }

}
