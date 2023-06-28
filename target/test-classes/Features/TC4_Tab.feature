@Tab
Feature: Verifying Multiple Tabs Funtionalities

  Scenario Outline: Verifying multiple Tabs are selectable
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Multiple Tabs"
    Then User should select tab "<tab>"
    And User should verify text "<text>"

    Examples: 
      | userName                 | passWord   | tab                | text                                 |
      | training@jalaacademy.com | jobprogram | Plan to Succeed    | Congratulations, You are in the best |
      | training@jalaacademy.com | jobprogram | UnLearning         | Unlearning is the process of         |
      | training@jalaacademy.com | jobprogram | Ways of Unlearning | The first step towards becoming      |
      
      
