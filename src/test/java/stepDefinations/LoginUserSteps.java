package stepDefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountDeletePage;
import pageObjects.HomePage;
import pageObjects.SignupLoginPage;
import utils.TestContextSetup;

public class LoginUserSteps {

    TestContextSetup testContextSetup;
    HomePage homePage;
    SignupLoginPage loginpage;
    AccountDeletePage accountDeletedPage;

    public LoginUserSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageobjectmanager.gethomepage();
        this.loginpage = testContextSetup.pageobjectmanager.getSignupLoginPage();
        this.accountDeletedPage = testContextSetup.pageobjectmanager.getaccountdeletedpage();
    }

    @When ("Scroll down page to bottom")
    public void scrollDownpageToBottom()
    {
    	JavascriptExecutor js = (JavascriptExecutor) testContextSetup.driver;
    	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
    }
    
    @Given("Logout from created account")
    public void logout_from_created_account() {
        homePage.clickOnLogOutButton();
    }

    @When("The user clicks on Login button")
    public void the_user_clicks_on_login_button_page() {
        loginpage.clickOnLoginButton();
    }

    @Then("Login to your account should be visible")
    public void login_to_your_account_should_be_visible() {
        String loginheader = loginpage.loginHeader();
        Assert.assertEquals(loginheader, "Login to your account");
    }

    @When("the user enters correct email address and password")
    public void the_user_enters_correct_email_address_and_password() {
        loginpage.LoginEmailAndPass(testContextSetup.email, testContextSetup.password);
    }

    @When("The user enters incorrect email address {string} and password {string}")
    public void the_user_enters_incorrect_email_address_and_password(String email, String pass) {
        loginpage.LoginEmailAndPass(email, pass);
    }

    @And("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        loginpage.loginbutton();
    }
    
    @Then ("Verify error {string} is visible")
    public void Verify_Error_Msg(String expectedtext) {
         String	logininvalidtext = loginpage.ValidateLoginText();
         Assert.assertEquals(logininvalidtext, expectedtext);
    }
    
    @When("the user clicks on Delete Account button")
    public void the_user_clicks_on_delete_account_button() {
        homePage.clickOnDeleteAccountButton();
    }

    @Then("ACCOUNT DELETED! should be visible")
    public void account_deleted_should_be_visible() {
        String actualText = accountDeletedPage.acctdeletemsg();
        Assert.assertEquals(actualText, "ACCOUNT DELETED!");
    }
    
    @When ("User enters name and email")
    public void User_enters_name_and_email(DataTable table)
    {
        List<Map<String, String>> data = table.asMaps(String.class,String.class);	
        String name = data.get(0).get("Name");
        String email = data.get(0).get("Email");        
    	loginpage.signUp(name, email);
    }
    
    
    
    
}