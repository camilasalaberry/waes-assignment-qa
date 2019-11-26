Feature: SignUp
  As an user I want to register in waes heros page

  Scenario: Should be possible sign up
    Given the user is at sign up page
    And user fill the form to become a hero with username "Analyst"
    And password "docs"
    And name "camila"
    And email "salaberry.camila@gmail.com"
    And day of birth "19"
    And month of birth "May"
    And year of birth "1990"
    When user attempts to register
    Then he should see a message "Welcome to your new profile page, Camila!" 
    And he should see the status "Logged in as Camila Salaberry Paula (camila@gmail.com)! log out"
    
 #   And should be possible access profile page

  Scenario Outline: The email must be valid to register
    Given the user is at sign up page
    And user fill the form to become a hero
    And the entered email is <email>
    When user attempts to register
		Then a validation should be presented ""
    Examples: 
      | email              |
      | "camila.gmail.com" |
      | "salaberry@"       |

#This hero is already registered. Try another one!

  Scenario Outline: All fields are mandatory
    Given the user is at sign up page
    And user fill the form to become a hero with username <username>
    And password <password>
    And name <name>
    And email <email>
    And day of birth <day_date_of_birth>
    And month of birth <month_date_of_birth>
    And year of birth <year_date_of_birth>
    When user attempts to register
    Then a validation should be presented ""

    Examples: 
      | username  | password | name     | email                        | day_date_of_birth | month_date_of_birth | year_date_of_birth |
      | ""        | "DOCS"   | "Camila" | "salaberry.camila@gmail.com" | "19"              | "May"               | "1990"             |
      | "ANALYST" | "DOCS"   | "Camila" | "salaberry.camila@gmail.com" | ""                | ""                  | ""                 |
      
