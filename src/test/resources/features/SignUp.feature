
Feature: SignUp
  As an user I want to register in waes heros page

  Scenario: Should be possible sign up
  Given the user is at sign up page
  And user fill the form to become a hero <username> , <password>, <name>, <email>, <day_date_of_birth> , <month_date_of_birth>, <year_date_of_birth>
  |username   | password| name     |email                         | day_date_of_birth| month_date_of_birth | year_date_of_birth|
  | "ANALYST" | "DOCS"  | "Camila" | "salaberry.camila@gmail.com" | "19"       |       "May"              |    "1990"          |
  When user attempts to register
  Then he should be a registered 
  And should be possible access profile page 

 Scenario Outline: The email must be valid to register
  Given the user is at sign up page
  And user fill the form to become a heros
  And the entered email is <email>
  When user attempts to register
  Examples:
  |email              |
  | "camila.gmail.com"|
  |"salaberry@"       |
  
 Scenario Outline: All fields are mandatory
  Given the user is at sign up page
  And user fill the form to become a hero with username <username> password <password>, name <name>, email <email>, date of birth <day_date_of_birth>, <month_date_of_birth>, <year_date_of_birth>
  When user attempts to register
  Then  he should see a message ""
Examples:
  |username   | password| name     |email                         | date_of_birth|
  | ""        | "DOCS"  | "Camila" | "salaberry.camila@gmail.com" | "19051990"   |
  | "ANALYST" | "DOCS"  | "Camila" | "salaberry.camila@gmail.com" | "19051990"   |