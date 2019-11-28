Feature: LogIn
  As an user I want to log in heros's profiles page

  Scenario Outline: Login with valid user authentication
    Given the username <username> was registered with password <password>
    When the user attempts to login
    Then he should see a welcome message <message>

    Examples: 
      | username | password | message                                                               |
      | "dev"    | "wizard" | "Logged in as Zuper Dooper Dev (zd.dev@wearewaes.com)! log out"       |
      | "admin"  | "hero"   | "Logged in as Amazing Admin (a.admin@wearewaes.com)! log out"         |
      | "tester" | "maniac" | "Logged in as Al Skept-Cal Tester (as.tester@wearewaes.com)! log out" |

  Scenario: Login with invalid user authentication
    Given the username "foreign" was not registered with password "test"
    When the user attempts to login
    Then he should see a not allowed message "Wrong credentials. You can do it, try again!"

  Scenario Outline: Fields username and password are mandatory
    Given the username <username>
    And the password <password>
    When the user attempts to login
    Then the message "To get the full hero experience, you’ll need to log in." must be visible
    And a validation into the field <field> must be present
    Examples: 
      |field                | username | password |
      |"userName"           | ""       | "wizard" |
      |"passWord"           | "admin"  | ""       |
      |"userName,passWord"  | ""       | ""       |

  Scenario Outline: Once logged in Profile page must provide user information
    Given the user is logged in as <username>, <password>
    When the user click to profile page
    Then profile information must be present <question> and , <superpower>

    Examples: 
      | username | password | question                                  | superpower                           |
      | "dev"    | "wizard" | "How are you doing, Zuper Dooper Dev?"    | "Debug a repellent factory storage." |
      | "admin"  | "hero"   | "How are you doing, Amazing Admin?"       | "Change the course of a waterfall."  |
      | "tester" | "maniac" | "How are you doing, Al Skept-Cal Tester?" | "Voltage AND Current."               |

  Scenario Outline: Once logged in Details page must provide user information
    Given the user is logged in as <username>, <password>
    When the user click to details page
    Then details of personal profile must be present <name>, <email_address>

    Examples: 
      | username | password | name                  | email_address             |
      | "dev"    | "wizard" | "Zuper Dooper Dev"    | "zd.dev@wearewaes.com"    |
      | "admin"  | "hero"   | "Amazing Admin"       | "a.admin@wearewaes.com"   |
      | "tester" | "maniac" | "Al Skept-Cal Tester" | "as.tester@wearewaes.com" |
