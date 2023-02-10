package uoa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import uoa.pages.SearchPage;
import uoa.utilities.ConfigurationReader;
import uoa.utilities.Driver;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();

    String name="";

    String FULLNAME="";

    @Given("that the user is on the homepage")
    public void that_the_user_is_on_the_homepage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("universityOfAlberta"));

    }

    @When("the user clicks the search and more sign")
    public void the_user_clicks_the_search_and_more_sign() {

        searchPage.searchAndMoreSign.click();

    }

    @When("the user clicks the Find a Person button")
    public void the_user_clicks_the_find_a_person_button() {

        searchPage.FindAPersonButton.click();

    }


    @When("the user inputs the person's name {string} into the search box")
    public void the_user_inputs_the_person_s_name_into_the_search_box(String name) {

        this.name = name;
        searchPage.searchBox.sendKeys(name);

    }

    @When("the user clicks the Search button")
    public void the_user_clicks_the_search_button() {

        searchPage.SearchButton.click();

    }
    @Then("the user should see the information about the searched person, including their name.")
    public void the_user_should_see_the_information_about_the_searched_person_including_their_name() {

        String expectedName= name; // Scenario

        String actualName= searchPage.fullName.getText();

        Assert.assertTrue(actualName.contains(expectedName));

        String expectedNames = FULLNAME;

        Assert.assertTrue(actualName.contains(expectedNames)); //Scenario Outline



    }

    @When("the user inputs the person's {string} into the search box")
    public void the_user_inputs_the_person_s_into_the_search_box(String FULLNAME) {

        this.FULLNAME=FULLNAME;
        searchPage.searchBox.sendKeys(FULLNAME);
    }

    @When("the user  user enters an invalid name {string} into the search field")
    public void the_user_user_enters_an_invalid_name_into_the_search_field(String invalidName) {

        searchPage.searchBox.sendKeys(invalidName);

    }
    @Then("the user should be displayed with the message {string}")
    public void the_user_should_be_displayed_with_the_message(String expMessage) {

        String actualMessage = searchPage.message.getText();

        System.out.println(actualMessage);

        Assert.assertEquals(expMessage,actualMessage);


    }



}
