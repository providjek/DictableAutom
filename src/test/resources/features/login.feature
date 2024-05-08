@login
Feature: Login
  As a user I want to be able to log in with my valid credentials In order to purchase items
  Background:
    Given I am on the login section

  Scenario: Login - passing
    When I log with my "provi-test3@yopmail.com" and "P@ss1234"
    Then I am logged with "provi-test3@yopmail.com" in and redirected to the home page

  Scenario Outline:
    When I log with my <email> and <password>
    Then The connection fails and I receive the message <message>
    Examples:
      | email                | password | message                          |
      |"provijek222@mail.com"|"Pass1234"|"Email ou mot de passe incorrect" |
      |"provijek222@mai"     |"P@ss1234"|"Le format de l'email est invalid"|
      |"providjek@gmail.com" |"Pz"      |"Email ou mot de passe incorrect" |

    Scenario:
      When I connect to my google account
      Then I am redirected to the google login page
      And I log in with my google account
