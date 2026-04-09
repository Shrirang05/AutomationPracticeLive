Feature: Verify scroll up 

Scenario: Verify scroll up using Arrow button
Then User should see the home page successfully
When Scroll down page to bottom
Then Verify subscription is visible
When click on arrow at bottom right side to move upward
Then Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
