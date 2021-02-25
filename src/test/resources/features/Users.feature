@wip
Feature: User Management module
  Log in as a librarian,
  I should be able to see book records and 6 columns on user page

  Background:
    Given I am on the login page
    When I login as a librarian
    And I'm on the User Management page


  Scenario:Verify that the default record display is 10
    Then I should see 10 records on the page


  Scenario: Show records for count options
    When I click on records
    Then I can see count records on the page
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |


  Scenario: Verify User management table columns names
    Then the user should see the following column names
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |



  Scenario: verify user status
    And the user click Status dropdown
    Then the user should see the following options
      |ACTIVE      |
      |INACTIVE    |

