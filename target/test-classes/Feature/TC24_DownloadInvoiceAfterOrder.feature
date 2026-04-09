Feature: Validate download invoice

Scenario Outline: Contact US Form
Then User should see the home page successfully
When Add products to cart
When Click Cart button
Then Verify that cart page is displayed
When Click Proceed To Checkout
When Click Register or Login button
When User enters name "<Name>" and email "<Email>"
When Fill all details and create account
      | Password | <Password> |
      | Day      | <Day>      |
      | Month    | <Month>    |
      | Year     | <Year>     |
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

Then User should see ACCOUNT CREATED! message
When User clicks on Continue button
Then User should see logged in as "<Name>"
When Click cart button
When Click Proceed To Checkout
When Verify Address Details "<Address1>" and "<Mobile>" and Review Your Order
When Enter description in comment text area and click Place Order "Test text"
When Enter payment details: Name on Card, Card Number, CVC, Expiration date 
 | NameOnCard | Shrirang        |
  | CardNumber | 4111111111111111 |
  | CVC        | 123             |
  | ExpMonth   | 10              |
  | ExpYear    | 2026            |
When Click Pay and Confirm Order button
Then Verify success message Your order has been placed successfully!
When Click Download Invoice button and verify invoice is downloaded successfully.
Then Click Continue button
When User clicks on Delete Account button
Then User should see ACCOUNT DELETED! message
 And User clicks on Continue button after account deletion

Examples:
      | Title | Name     | Email   | Password   | Day | Month | Year | FirstName | LastName | Company | Address1       | Address2     | Country | State      | City   | Zipcode | Mobile     |
      | Mr    | Shrirang | random  | Test@12345 | 10  | May   | 1999 | Shrirang  | Ladda    | ABC Ltd | Pune Main Road | Near Mall    | India   | Maharashtra | Pune   | 411001  | 9876543210 |

