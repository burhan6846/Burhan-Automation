Feature: Create A SauceDemo

  Scenario: Open url and Create ADD_TO_CART
    When open SauceDemo url "https://www.saucedemo.com/"
    Then enter login details
    Then click on sign in button
    And click on My Add to Cart