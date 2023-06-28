@Login
Feature: Verifying Login Page Funtionalities

  Scenario Outline: Verifying Login with valid credentials
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"

    Examples: 
      | userName                 | passWord   |
      | training@jalaacademy.com | jobprogram |

  Scenario Outline: Verifying Login with invalid credentials
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login error pup-up "Invalid Email address or Password."
    Examples: 
      | userName        | passWord   |
      | jalaacademy.com | jobprogram |

  
  Scenario: Verifying Login without entering any credentials
    Given User is on the jala academy login page
    When User should click on sign-in button
    Then User should verify error messages "Please enter email or mobile no.","Please enter password."
 
 