Feature: Profile information management
  As a logged-in user
  I need to be able to update my personal information (name, address, telephone number, password, etc.)
  Background:
    Given I am on the login section
    And I log with my "provi-test3@yopmail.com" and "P@ss1234"
    And I am on the PROFILE page


  Scenario: Modification of personal information
    When I update my personal informations
      |fName         |lName       |address|phone  |bilingAddres|deliveryAddres|title      |
      |Djekoundakom|Providence|Yasaa|65434|Cameroun  |Douala 237  |Monsieur |
    Then I can see the message "Votre profile a été mis à jour avec succes" confirming the update

  @profile
  Scenario: change password
    When I change my old password "P@ss1234" with the new one "P@New1234"
    Then I can see the message "Votre mot de passe a été mis à jour avec succes" confirming the update




