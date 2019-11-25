Feature: LogIn
  As an user I want to log in heros profiles page

  Scenario Outline: Login with valid user authentication
    Given the username <username> was registered with password <password>
    When the user attempts to login
    Then he should see a welcome message <message>

    Examples: 
      | username | password | message                                                                |
      | "dev"    | "wizard" | "Logged in as Zuper Dooper Dev (zd.dev@wearewaes.com)! log out" |
      | "admin"  | "hero"   | "Logged in as Amazing Admin (a.admin@wearewaes.com)! log out"        |
      | "tester" | "maniac" | "Logged in as Al Skept-Cal Tester (as.tester@wearewaes.com)! log out"  |

Scenario: Login with invalid user authentication
  Given the username "foreign" was not registered with password "test"
  When the user attempts to login
  Then he should see a not allowed message "Wrong credentials. You can do it, try again!"


Scenario Outline: Fields username and password are mandatory
  Given the username <username>
  And the password <password>
  When the user attempts to login
  Then the message "To get the full hero experience, you’ll need to log in." must be visible
  Examples:
  |username |password  |
  | ""     |  "wizard"|
  |"admin"  |       ""|
  |""      |       ""|
