Feature: Validate login

Background:  Register new user and delete the account successfully

    Then User should see the home page successfully

    When User clicks on Signup or Login button
    Then User should see New User Signup! section

    When User enters name "Shrirang" and email "random"
    And User clicks on Signup button
    Then User should see ENTER ACCOUNT INFORMATION section

    When User fills account information details:
      | Password | Test@12345  |
      | Day      | 10     |
      | Month    | May    |
      | Year     | 1999   |

    And User selects newsletter checkbox
    And User selects special offers checkbox

    When User fills address details:
      | FirstName | Shrirang    |
      | LastName  | Ladda      |
      | Company   | ABC Ltd     |
      | Address1  | Pune Main Road  |
      | Address2  | Near Mall    |
      | Country   | India        |
      | State     | Maharashtra  |
      | City      | Pune         |
      | Zipcode   | 411011       |
      | Mobile    | 9876543210   |

    And User clicks on Create Account button
    Then User should see ACCOUNT CREATED! message

    When User clicks on Continue button
    Then User should see logged in as "Shrirang"

    

Scenario: Login User with correct email and password 
    Given Logout from created account
    When The user clicks on Login button
    Then Login to your account should be visible
    When the user enters correct email address and password 
    And the user clicks on login button
    Then User should see logged in as "Shrirang"
    When the user clicks on Delete Account button
    Then ACCOUNT DELETED! should be visible



