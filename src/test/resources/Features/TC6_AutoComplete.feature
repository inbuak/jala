@Auto
Feature: Verifying Auto complete Funtionalities
 
  Scenario Outline: Verifying single values functionality
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Autocomplete"
    Then User should select the value "<value>"
    And User should enter letters and verify suggestions have those letters "<letters>"

    Examples: 
      | userName                 | passWord   | value         | letters |
      | training@jalaacademy.com | jobprogram | Single Values | as      |

 
  Scenario Outline: Verifying multiple values functionality
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Autocomplete"
    Then User should select the value "<value>"
    And User should enter letters and verify suggestions have those letters "<letters>"
    Then User should enter letters and verify suggestions have those letters "<addletters>"

    Examples: 
      | userName                 | passWord   | value           | letters | addletters |
      | training@jalaacademy.com | jobprogram | Multiple Values | a       | b          |
