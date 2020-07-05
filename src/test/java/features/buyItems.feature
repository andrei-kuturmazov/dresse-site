Feature: I wanna buy 3 items from different categories on a selected site

  Scenario: Add three items to cart and then delete random item
    Given User open a start page
    When Add one item from Women page
    And Add one item from Dresses page
    And Add one item from Shirts page
    And Delete one random item from cart
    Then Items names and should be correct
