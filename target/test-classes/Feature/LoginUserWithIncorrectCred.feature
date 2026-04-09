Feature: Validate login scenario

Scenario: Login user with incorrect email and password

Then User should see the home page successfully
 When The user clicks on Login button
 Then Login to your account should be visible
 When The user enters incorrect email address "shri@34234" and password "42343"
 And the user clicks on login button
 Then Verify error 'Your email or password is incorrect!' is visible

