@wip
Feature: Retrieve Information about a Person on the University of Alberta Website
  Agile Story: As a user, I should be able to search for information about a person.

  Background: user search a person successfully
    Given that the user is on the homepage
    When the user clicks the search and more sign
    And the user clicks the Find a Person button


  Scenario: Search for a Person by Name
    And the user inputs the person's name "Sepideh Emam" into the search box
    And the user clicks the Search button
    Then the user should see the information about the searched person, including their name.

  Scenario: Incorrect Person Search
    And the user  user enters an invalid name "***** *****" into the search field
    And the user clicks the Search button
    Then the user should be displayed with the message "Please enter a valid search query in the box below."

  Scenario Outline: Search for a Person by Name_Data Driven testing
    And the user inputs the person's "<full name>" into the search box
    And the user clicks the Search button
    Then the user should see the information about the searched person, including their name.
    Examples:
      | full name         |
      | Sepideh Emam      |
      | Jason Lorenz      |
      | Joey Tolentino    |


