@Auto
Feature: Verifying Collapsible Content Funtionalities

  
  Scenario Outline: Verifying single Collapse functionality
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Collapsible Content"
    Then User should select the collapse "<collapse>"
    And User should click each collapse to verify only one text visible at a time

    Examples: 
      | userName                 | passWord   | collapse        |
      | training@jalaacademy.com | jobprogram | Single Collapse |

  
  Scenario Outline: Verifying Multiple Collapse functionality
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Collapsible Content"
    Then User should select the collapse "<collapse>"
    And User should click each collapse to verify all text are visible at a time

    Examples: 
      | userName                 | passWord   | collapse          |
      | training@jalaacademy.com | jobprogram | Multiple Collapse |
