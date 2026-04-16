Feature: TC05 Register user with existing email

Scenario: TC05 Register user with existing email

    Then User should see the home page successfully

    When User clicks on Signup or Login button
    Then User should see New User Signup! section
    When User enters name and email
     | Name      | Email         |
     | shrirang  | shrirang@123  |
    
    
    And User clicks on Signup button
    Then Verify signup error "Email Address already exist!" is visible
    
   
 
    
    
 