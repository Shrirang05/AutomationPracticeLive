Feature: TC06 Contact Us

Scenario: TC06 Contact Us

Then User should see the home page successfully
When Click on Contact Us button
When Verify "GET IN TOUCH" is visible
When Enter name, email, subject and message 
| Name      |   Shrirang    |
| Email     |   shrirang@123 |
| Subject   |   My Subject   |
| Message   |   My Message   |
 
When Upload file
Then Click Submit button and accept popup
Then Verify success message "Success! Your details have been submitted successfully." is visible
Then Click Home button and verify that landed to home page successfully
Then User should see the home page successfully