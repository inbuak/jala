@Links
Feature: Verifying links Funtionalities

  Scenario Outline: Verifying workiing links
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Links"
    Then User should select the links "<links>"
    And User should vrify all links are working links
      | Workinglinks.co.uk – A job, employment, work and occupation |
      | Google                                                      |
      | JALA Academy-Singapore and India                            |

    Examples: 
      | userName                 | passWord   | links         |
      | training@jalaacademy.com | jobprogram | Working Links |

  Scenario Outline: Verifying Broken links
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Links"
    Then User should select the links "<links>"
    And User should veriy all links are broken links

    Examples: 
      | userName                 | passWord   | links        |
      | training@jalaacademy.com | jobprogram | Broken Links |

  Scenario Outline: Verifying Image links
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Links"
    Then User should select the links "<links>"
    And User should verify all links are image links

    Examples: 
      | userName                 | passWord   | links       |
      | training@jalaacademy.com | jobprogram | Image Links |

  Scenario Outline: Verifying Status Codes
    Given User is on the jala academy login page
    When User should perform login "<userName>" , "<passWord>"
    Then User should verify after login success message "Welcome to JALA Academy"
    And User should select a menu in Home page "Links"
    Then User should select the links "<links>"
    And user should verify all status codes
      | 301 |
      | 301 |
      | 500 |
      | 500 |

    Examples: 
      | userName                 | passWord   | links        |
      | training@jalaacademy.com | jobprogram | Status Codes |
