@CreateEmployee
Feature: Verifying create Employee Funtionalities

  Scenario Outline: Verifying create Employee with mandatory fields
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should click on create employee menu
    Then User should create employee with mandatory fields "<firstName>","<lastName>","<mailId>","<mobileNum>"
    And User should verify create employee success message "Search Employee"

    Examples: 
      | userName                 | passWord   | firstName | lastName | mailId              | mobileNum  |
      | training@jalaacademy.com | jobprogram | Inabesan  | A K      | inbanesan@gmail.com | 0987654321 |

  Scenario Outline: Verifying create Employee all fields
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should click on create employee menu
    Then User should create employee all fields "<firstName>","<lastName>","<mailId>","<mobileNum>","<DOB>","<gender>","<address>","<country>","<city>"
      | AWS         |
      | DevOps      |
      | WebServices |
    And User should verify create employee success message "Search Employee"

    Examples: 
      | userName                 | passWord   | firstName | lastName | mailId              | mobileNum  | DOB       | gender | address | country | city    |
      | training@jalaacademy.com | jobprogram | Inabesan  | A K      | inbanesan@gmail.com | 0987654321 | 6/11/1999 | Female   | Chennai | India   | Chenna  |

  Scenario: Verifying create Employee without entering any fields
     Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should click on create employee menu
    Then User should click on save button
    And User should verify create employee error messages "Please enter first name.","Please enter last name.","Please enter email.","Please enter mobile number."

    Examples: 
      | userName                 | passWord   |
      | training@jalaacademy.com | jobprogram |
