@Menu
Feature: Verifying Menu Funtionalities

  Scenario Outline: Verifying single menu functionality
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Menu"
    Then User should select menu "<menu>"
    And User should select the course "<course>"
    Then User should verify course success msg "<successMsg>"

    Examples: 
      | userName                 | passWord   | menu         | course | successMsg                          |
      | training@jalaacademy.com | jobprogram | Single Menus | .Net   | You Have Selected .Net Menu Option. |

  
  Scenario Outline: Verifying sub menu functionality
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Menu"
    Then User should select menu "<menu>"
    Then User should select subMenu "<subMenu>"
    And User should select the course "<course>"
    Then User should verify course success msg "<successMsg>"

    Examples: 
      | userName                 | passWord   | menu      | subMenu  | course | successMsg                         |
      | training@jalaacademy.com | jobprogram | Sub Menus | Database | SQL    | You Have Selected SQL Menu Option. |
