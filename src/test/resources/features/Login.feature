
Feature: Login feature
  As a user I should be able to login with correct credentials to different accounts.
  Dashboard should be displayed.
  Accounts are: librarian, student

  @librarian
  Scenario: Login as a librarian
    Given I am on the login page
    When I login as a librarian
    Then dashboard should be displayed

  @student
  Scenario: Login as a student
    Given I am on the login page
    When I login as a student
    Then books should be displayed