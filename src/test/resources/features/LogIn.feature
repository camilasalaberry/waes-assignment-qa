Feature: LogIn
  As an user I want to log in heros profiles page

  Scenario Outline: Login with valid user authentication
    Given the username <username> was registered with password <password>
    When the user attempts to login
    Then he should see a welcome message <message>

    Examples: 
      | username | password | message                                                                |
      | "dev"    | "wizard" | "Logged in as A[l Skept-Cal Tester (as.tester@wearewaes.com)! log out" |
      | "admin"  | "hero"   | "Logged in as Zuper Dooper Dev (zd.dev@wearewaes.com)! log out"        |
      | "tester" | "maniac" | "Logged in as Al Skept-Cal Tester (as.tester@wearewaes.com)! log out"  |
