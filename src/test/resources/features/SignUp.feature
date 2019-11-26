Feature: SignUp
  As an user I want to register in waes heros page

  Background: User should be at sign up page
    Given the user is at sign up page

  Scenario: Should be possible sign up
    Given user fill the form to become a hero with username "Analyst"
    And password "docs"
    And name "Camila"
    And email "salaberry.camila@gmail.com"
    And day of birth "19"
    And month of birth "May"
    And year of birth "1990"
    When user attempts to register
    Then he should see a welcome message in his profile "Welcome to your new profile page, Camila!"
    And he should see the status "Logged in as Camila (salaberry.camila@gmail.com)! log out"

  Scenario: Once logged in should be possible access profile and details page
    Given user fill the form to become a hero with username "Analyst"
    And password "docs"
    And name "Camila"
    And email "salaberry.camila@gmail.com"
    And day of birth "19"
    And month of birth "May"
    And year of birth "1990"
    When user attempts to register
    Then should be possible access profile data like superpower "You have no super powers yet. =[."
    And details like name "Camila", email "salaberry.camila@gmail.com"

  Scenario Outline: The email must be valid to register
    Given user fill the form to become a hero
    And the entered email is <email>
    When user attempts to register
    Then a validation should be presented "Digite um endereço de e-mail."

    Examples: 
      | email              |
      | "camila.gmail.com" |
      | "salaberry@"       |
      | "12345"            |

  Scenario: Should not be possible register a user that is already registered
    Given user fill the form to become a hero with username "dev"
    And password "wizard"
    And name "camila"
    And email "salaberry.camila@gmail.com"
    And day of birth "19"
    And month of birth "May"
    And year of birth "1990"
    When user attempts to register
    Then he should see a message "This hero is already registered. Try another one!"

  Scenario Outline: All fields are mandatory
    Given user fill the form to become a hero with username <username>
    And password <password>
    And name <name>
    And email <email>
    And day of birth <day_date_of_birth>
    And month of birth <month_date_of_birth>
    And year of birth <year_date_of_birth>
    When user attempts to register
    Then a validation should be presented to mandatory fields <field>, <message>

    Examples: 
      | field              | username  | password | name     | email                        | day_date_of_birth | month_date_of_birth | year_date_of_birth | message                       |
      | "userName"         | ""        | "DOCS"   | "Camila" | "salaberry.camila@gmail.com" | "19"              | "May"               | "1990"             | "Preencha este campo."        |
      | "passWord"         | "ANALYST" | ""       | "Camila" | "salaberry.camila@gmail.com" | "19"              | "May"               | "1990"             | "Preencha este campo."        |
      | "name"             | "ANALYST" | "DOCS"   | ""       | "salaberry.camila@gmail.com" | "19"              | "May"               | "1990"             | "Preencha este campo."        |
      | "email"            | "ANALYST" | "DOCS"   | "Camila" | ""                           | "19"              | "May"               | "1990"             | "Preencha este campo."        |
      | "dayDateOfBirth"   | "ANALYST" | "DOCS"   | "Camila" | "salaberry.camila@gmail.com" | ""                | "May"               | "1990"             | "Selecione um item da lista." |
      | "monthDateOfBirth" | "ANALYST" | "DOCS"   | "Camila" | "salaberry.camila@gmail.com" | "19"              | ""                  | "1990"             | "Selecione um item da lista." |
      | "yearDateOfBirth"  | "ANALYST" | "DOCS"   | "Camila" | "salaberry.camila@gmail.com" | "19"              | "May"               | ""                 | "Selecione um item da lista." |
