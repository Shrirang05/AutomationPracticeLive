package stepDefinations;

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

public class PurchaseOrderSteps {

	 TestContextSetup testContextSetup;
	    HomePage homePage;
	    SignupLoginPage loginPage;
	    AccountCreatedPage accountCreatedPage;
	    AccountDeletePage accountDeletedPage;
	    CartPage cartpage;
	    PaymentPage paymentpage;
	    

	    public PurchaseOrderSteps(TestContextSetup testContextSetup) {
	        this.testContextSetup = testContextSetup;
	        this.homePage = testContextSetup.pageobjectmanager.gethomepage();
	        this.loginPage = testContextSetup.pageobjectmanager.getSignupLoginPage();
	        this.accountCreatedPage = testContextSetup.pageobjectmanager.getAccountCreatedPage();
	        this.accountDeletedPage = testContextSetup.pageobjectmanager.getaccountdeletedpage();
	        this.cartpage = testContextSetup.pageobjectmanager.getcartpage();
	        this.paymentpage = testContextSetup.pageobjectmanager.getpaymentpage();
	    }
	
	    @When("Add products to cart")
	    public void clickOnAddtoCart()
	    {
	    	homePage.clickOnAddtoCartButton();
	    }
	    
	    @When ("Click Cart button")
	    public void ClickOnCartButton()
	    {
	    	homePage.clickOnViewCartButton();
	    }
	       
	    @Then ("Verify that cart page is displayed")
	    public void VerifyCartPage()
	    {
	    	String actualtext = cartpage.VerifyCartpage();
	    	String expectedtext = "Shopping Cart";
	    	Assert.assertEquals(actualtext, expectedtext);
	    }
	    
	    @When("Click Proceed To Checkout")
	    public void ProceedToCheckout()
	    {
	    	cartpage.clickOnProceedToCheckout();
	    }
	        
	    @When ("Click Register or Login button")
	    public void ClickOnRegisterandlogin()
	    {
	    	cartpage.clickOnRegisterorLogin();
	    }
	    
	    @When("Fill all details and create account")
	    public void fillTheUserDetailsAndCreateAccount(DataTable dataTable)
	    {
	    	 Map<String, String> data = dataTable.asMap(String.class, String.class);

	    	    String pass = data.get("Password");
	    	    String day = data.get("Day");
	    	    String month = data.get("Month");
	    	    String year = data.get("Year");
	    	    String firname = data.get("FirstName");
	    	    String lasname = data.get("LastName");
	    	    String companyname = data.get("Company");
	    	    String address1T = data.get("Address1");
	    	    String address2T = data.get("Address2");
	    	    String countryname = data.get("Country");
	    	    String statename = data.get("State");
	    	    String cityname = data.get("City");
	    	    String zipcodetext = data.get("Zipcode");
	    	    String mobile = data.get("Mobile");

	    	    loginPage.clickOnSignUp();
	    	    accountCreatedPage.enterDayMonthYear(pass, day, month, year);
	    	    accountCreatedPage.selectCheckbox();
	    	    accountCreatedPage.selectofferCheckbox();
	    	    accountCreatedPage.enterPersonalInfo(firname, lasname, companyname, address1T, address2T,
	    	        countryname, statename, cityname, zipcodetext, mobile);
	    	    
	    	    accountCreatedPage.createAccount();
	    }
	    
	    @When("Click cart button")
	    public void ClickOnCartButtonheader()
	    {
	    	cartpage.clickOnCartButton();
	    }
	    
	    @When("Verify Address Details {string} and {string} and Review Your Order")
	    public void Verify_Details(String address1, String mobileno)
	    {
	      String Actualaddress = cartpage.ValidateAddress1();
	      Assert.assertEquals(Actualaddress, address1);
	      
	      String actualmobileno = cartpage.ContactNo();
	      Assert.assertEquals(actualmobileno, mobileno);	      
	    }
	    
	    @When("Enter description in comment text area and click Place Order {string}")
	    public void Enter_Description(String text)
	    {
	    	cartpage.EnterCommentIntoCommentBox(text);
	    	cartpage.placeOrderButton();
	    }
	    
	    @When("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
	    public void Enter_payment_Details(DataTable table)
	    {
	    	 Map<String, String> data = table.asMap(String.class, String.class);

	    	    String name = data.get("NameOnCard");
	    	    String card = data.get("CardNumber");
	    	    String cvc = data.get("CVC");
	    	    String month = data.get("ExpMonth");
	    	    String year = data.get("ExpYear");
	    	    
	    	paymentpage.EnterNameOnCard(name);
	    	paymentpage.enterCardNo(card);
	    	paymentpage.entercvv(cvc);
	    	paymentpage.enterMonth(month);
	    	paymentpage.expiryYear(year);    	
	    }
	    
	    @When("Click Pay and Confirm Order button")
	    public void clickAndConfirmOrderButton() {    
	    paymentpage.payAndConfirmOrder();
	    }
	    
	    @Then("Verify success message Your order has been placed successfully!")
	    public void verifySuccessMessage()
	    {
	    	String text = paymentpage.orderText();
	    	Assert.assertEquals(text, "Congratulations! Your order has been confirmed!");
	    }
	    
	    @When("Click Download Invoice button and verify invoice is downloaded successfully.")
	    public void ClickOnDownloadInvoice() throws InterruptedException
	    {
	    	String downloadPath = System.getProperty("user.home") + "\\Downloads"; // system download folder
	        String fileName = "invoice.txt"; // now .txt file

	        paymentpage.downloadInvoice(downloadPath, fileName);
	    }
	    
	    @Then("Click Continue button")
	    public void clickOnContinueButton()
	    {
	    	paymentpage.clickOnContinueButton();
	    }
	    
	    @Then("Verify subscription is visible")
	    public void verifySubscription()
	    {
	        String actualText	= homePage.validateSubscription();
	        Assert.assertEquals(actualText, "SUBSCRIPTION");
	    }
	    
	    @When("click on arrow at bottom right side to move upward")
	    public void clickOnUpArrow()
	    {
	    	homePage.clickOnScrollUp();
	    }
	    
	    @Then ("Verify that page is scrolled up and {string} text is visible on screen")
	    public void verifytext(String text)
	    {
	    	 Assert.assertTrue(homePage.getAutoDescriptionElement().isDisplayed(), 
	    	            "Text element is not visible on screen");
	    	
	    	String actualtext = homePage.autoDescription();
	    	Assert.assertEquals(actualtext, text);
	    }
	    
	    
	    
}
