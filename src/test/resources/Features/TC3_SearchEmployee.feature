@SearchEmployee
Feature: Verifying Search employee Page Funtionalities

  Scenario Outline: Verifying Search Employee with firstName and mobileNumber
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should click on search employee menu
    Then User should search employee all fields "<firstName>","<mobile>"
    And User should verify all first name "<firstName>"
    Then User should verify all mobile number "<mobile>"

    Examples: 
      | userName                 | passWord   | firstName | mobile     | firstName | mobile     |
      | training@jalaacademy.com | jobprogram | Inabesan  | 0987654321 | Inabesan  | 0987654321 |

  Scenario Outline: Verifying Search Employee only with firstName
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should click on search employee menu
    Then User should search employee only with firstName "<firstName>"
    And User should verify all first name "<firstName>"

    Examples: 
      | userName                 | passWord   | firstName | firstName |
      | training@jalaacademy.com | jobprogram | Inabesan  | Inabesan  |

  Scenario Outline: Verifying Search Employee only with fullName
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should click on search employee menu
    Then User should search employee only with fullName "<fullName>"
    And User should verify all full name "<fullName>"

    Examples: 
      | userName                 | passWord   | fullName    | fullName    |
      | training@jalaacademy.com | jobprogram | InabesanA K | InabesanA K |

 
  Scenario Outline: Verifying Search Employee only with mobile number
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should click on search employee menu
    Then User should search employee only with mobile "<mobile>"
    And User should verify all mobile number "<mobile>"

    Examples: 
      | userName                 | passWord   | mobile     | mobile     |
      | training@jalaacademy.com | jobprogram | 0987654321 | 0987654321 |

  Scenario Outline: Verifying Search Employee with invalid credentials
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should click on search employee menu
    Then User should search employee all fields "<name>","<mobile>"
    And User should verify message "No matching records found"

    Examples: 
      | userName                 | passWord   | name  | mobile     |
      | training@jalaacademy.com | jobprogram | Insan | 0987654321 |

  Scenario Outline: Verifying Search Employee edit funtionality
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should click on search employee menu
    Then User should search employee only with firstName "<firstName>"
    And User should verify all first name "<firstName>"
    Then User should click on edit button
    And User should update details
    Then User should verify success edit message "Employee details updated successfully"

    Examples: 
      | userName                 | passWord   | name     | firstName |
      | training@jalaacademy.com | jobprogram | Inabesan | Inabesan  |

  Scenario Outline: Verifying Search Employee delete funtionality
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should click on search employee menu
    Then User should search employee only with firstName "<firstName>"
    And User should verify all first name "<firstName>"
    Then User should click on delete button
    And User should verify success delete message "Record deleted successfully"

    Examples: 
      | userName                 | passWord   | name     | firstName |
      | training@jalaacademy.com | jobprogram | Inabesan | Inabesan  |
