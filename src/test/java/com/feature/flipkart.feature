Feature: Flipkart Application
@login
Scenario: Login Page
    Given User launch the application
    When User enter "username" as username in textfield
    And User enter "password" in password textfield
    And User click on the login button
    Then It Will Navigate To Home Page
@login
Scenario: Home Page
    When user Enter The "iphone 13" In Searchbox Textfield 
    Then user Click The Search Button And It Navigate To Search Result Page

Scenario: Adding First Product To Cart
    When user Click The First Product And It Navigate To Product Page
    And user Click The Add To Cart Button Of First Product And It Navigate To Cart Page
    Then user Closed The First Cart Page And It Will Back To Search Result Page 

Scenario: Adding Second Product To Cart
    When user Click The Second Product And It Navigate To Product Page
    And user Click The Add To Cart Button Of Second Product And It Navigate To Cart Page
    Then user Closed The Second Cart Page And It Will Back To Search Result Page

Scenario: Adding Third Product To Cart
    When user Click The Third Product  And It Navigate To Product Page
    And user Click The Add To Cart Button Of Third Product And It Navigate To Cart Page
    Then user Closed The Third Cart Page And It Will Back To Search Result Page 
    
Scenario: Moving To Cart Page
    When user Click The Cart Button And It Navigate To Cart Page
    And user remove all products from the cart