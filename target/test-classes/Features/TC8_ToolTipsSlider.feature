@Tool
Feature: Verifying Tooltips and slider Funtionalities

  Scenario Outline: Verifying Tooltips functionality
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Tooltips"
    Then User should verify message before click "You have not clicked this BUTTON yet. Please Click me and check the tooltip"
    And User should click on button and verify mesage "Thank you for being here!"

    Examples: 
      | userName                 | passWord   |
      | training@jalaacademy.com | jobprogram |

  Scenario Outline: Verifying slider functionality
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Slider"
    Then User should move slider to desired position 2
    Then User should verify the position 2

    Examples: 
      | userName                 | passWord   |
      | training@jalaacademy.com | jobprogram |
