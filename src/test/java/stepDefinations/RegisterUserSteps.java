package stepDefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.AccountCreatedPage;
import pageObjects.AccountDeletePage;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.PaymentPage;
import pageObjects.SignupLoginPage;
import utils.TestContextSetup;


public class RegisterUserSteps {

	    TestContextSetup testContextSetup;
	    HomePage homePage;
	    SignupLoginPage loginPage;
	    AccountCreatedPage accountCreatedPage;
	    AccountDeletePage accountDeletedPage;
	    CartPage cartpage;
	    PaymentPage paymentpage;

	    public RegisterUserSteps(TestContextSetup testContextSetup) {
	        this.testContextSetup = testContextSetup;
	        this.homePage = testContextSetup.pageobjectmanager.gethomepage();
	        this.loginPage = testContextSetup.pageobjectmanager.getSignupLoginPage();
	        this.accountCreatedPage = testContextSetup.pageobjectmanager.getAccountCreatedPage();
	        this.accountDeletedPage = testContextSetup.pageobjectmanager.getaccountdeletedpage();	  
	        this.cartpage = testContextSetup.pageobjectmanager.getcartpage();
	        this.paymentpage = testContextSetup.pageobjectmanager.getpaymentpage();
	    }

	    @Then("User should see the home page successfully")
	    public void user_should_see_the_home_page_successfully() {
	    Assert.assertTrue(homePage.verifyHomePage());	
	    }

	    @When("User clicks on Signup or Login button")
	    public void user_clicks_on_signup_or_login_button() {
	    	loginPage.clickOnLoginButton();	    	
	    }

	    @Then("User should see New User Signup! section")
	    public void user_should_see_section() {
	    	
	        String actualtext = loginPage.verifySignupTitle();
	        Assert.assertEquals(actualtext, "New User Signup!");
	        
	    }

	    @When("User enters name {string} and email {string}")
	    public void user_enters_name_and_email(String name, String email) {	  	    	
	    	if(email.equalsIgnoreCase("random"))
	    	{
	    	   	email = generateRandomEmail();
	    	   	testContextSetup.email = email;
	    	   	System.out.println(testContextSetup.email);
	    	}
	    	
	        loginPage.signUp(name,email);
	    }
	    
	    public String generateRandomEmail()
	    {
	    	return "Shrirang"+ System.currentTimeMillis() + "@gmail.com";
	    }
	    

	    @When("User clicks on Signup button")
	    public void user_clicks_on_signup_button() {
	        loginPage.clickOnSignUp();
	    }
	    
	    @Then("Verify signup error {string} is visible")
	    public void verify_error_is_visible(String expectedText)
	    {
	    	String actualText = loginPage.validateSignupText();
	    	Assert.assertEquals(actualText, expectedText);
	    }
	    

	    @Then("User should see ENTER ACCOUNT INFORMATION section")
	    public void user_should_see_enter_account_information_section() {
	    	String actualText = accountCreatedPage.ValidateAccountInfoTitle();
	        Assert.assertEquals(actualText, "ENTER ACCOUNT INFORMATION");
	    }

	    @When("User fills account information details:")
	    public void user_fills_account_information_details(DataTable dataTable) {
	    	
	    	 Map<String, String> data = dataTable.asMap(String.class, String.class);

	    	    String password = data.get("Password");
	    	    String day = data.get("Day");
	    	    String month = data.get("Month");
	    	    String year = data.get("Year");

	    	    accountCreatedPage.enterDayMonthYear(password, day, month, year);
	    	    testContextSetup.password = password;
	    }

	    @When("User selects newsletter checkbox")
	    public void user_selects_newsletter_checkbox() {
	       
	    	accountCreatedPage.selectCheckbox();
	    }

	    @When("User selects special offers checkbox")
	    public void user_selects_special_offers_checkbox() {
	       
	    	accountCreatedPage.selectofferCheckbox();
	    }

	    @When("User fills address details:")
	    public void user_fills_address_details(DataTable dataTable) {

	        Map<String, String> data = dataTable.asMap(String.class, String.class);

	       String firstname = data.get("FirstName");
	       String lastname = data.get("LastName");
	       String company =  data.get("Company");
	       String address1 = data.get("Address1");
	       String address2 = data.get("Address2");
	       String country = data.get("Country");
	       String state = data.get("State");
	       String city = data.get("City");
	       String zipcode = data.get("Zipcode");
	       String mobile = data.get("Mobile");
	        
	        accountCreatedPage.enterPersonalInfo(firstname,lastname,company,address1,address2,country,state,city,zipcode,mobile);
	    }

	    @When("User clicks on Create Account button")
	    public void user_clicks_on_create_account_button() {
	    	accountCreatedPage.createAccount();
	    }

	    @Then("User should see ACCOUNT CREATED! message")
	    public void user_should_see_message() {            
	    	String actualtext = accountDeletedPage.checkAccountCreated();
	        Assert.assertEquals(actualtext, "ACCOUNT CREATED!");        
	    }

	    @When("User clicks on Continue button")
	    public void user_clicks_on_continue_button() {
	    	accountDeletedPage.continueButton();
	    }

	    @Then("User should see logged in as {string}")
	    public void user_should_see_logged_in_as(String name) {
	       String actualusername = accountDeletedPage.verifyLoggedInName();
	      Assert.assertEquals(actualusername, name);
	    }

	    @When("User clicks on Delete Account button")
	    public void user_clicks_on_delete_account_button() {
	    	accountDeletedPage.deleteAcct();
	    }

	    @Then("User should see ACCOUNT DELETED! message")
	    public void user_should_see_account_deleted_message() {

	    	String actualText = accountDeletedPage.acctdeletemsg();
	        Assert.assertEquals(actualText, "ACCOUNT DELETED!");
	    }

	    @Then("User clicks on Continue button after account deletion")
	    public void user_clicks_on_continue_button_after_account_deletion() {
	    	accountDeletedPage.continueButtonAfterDelete();
	    }
	    
	
	   
	    
	    
	    
	    
	    
	}
	
	
	
	

