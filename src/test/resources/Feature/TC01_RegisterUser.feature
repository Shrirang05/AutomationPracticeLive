Feature: User Registration and Account Deletion
  As a new user
  I want to register on AutomationExercise website
  So that I can create an account and delete it successfully
  

  @Regression @Smoke @RegisterUser
  Scenario Outline: Register new user and delete the account successfully
    Then User should see the home page successfully

    When User clicks on Signup or Login button
    Then User should see New User Signup! section

    When User enters name "<Name>" and email "<Email>"
    And User clicks on Signup button
    Then User should see ENTER ACCOUNT INFORMATION section

    When User fills account information details:
      | Password | <Password> |
      | Day      | <Day>      |
      | Month    | <Month>    |
      | Year     | <Year>     |

    And User selects newsletter checkbox
    And User selects special offers checkbox

    When User fills address details:
      | FirstName | <FirstName> |
      | LastName  | <LastName>  |
      | Company   | <Company>   |
      | Address1  | <Address1>  |
      | Address2  | <Address2>  |
      | Country   | <Country>   |
      | State     | <State>     |
      | City      | <City>      |
      | Zipcode   | <Zipcode>   |
      | Mobile    | <Mobile>    |

    And User clicks on Create Account button
    Then User should see ACCOUNT CREATED! message

    When User clicks on Continue button
    Then User should see logged in as "<Name>"

    When User clicks on Delete Account button
    Then User should see ACCOUNT DELETED! message
    And User clicks on Continue button after account deletion

    Examples:
      | Title | Name     | Email   | Password   | Day | Month | Year | FirstName | LastName | Company | Address1       | Address2     | Country | State      | City   | Zipcode | Mobile     |
      | Mr    | Shrirang | random  | Test@12345 | 10  | May   | 1999 | Shrirang  | Ladda    | ABC Ltd | Pune Main Road | Near Mall    | India   | Maharashtra | Pune   | 411001  | 9876543210 |