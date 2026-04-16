package stepDefinations;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import utils.TestContextSetup;

public class ContactUsSteps {

	TestContextSetup testContextSetup;
    HomePage homePage;
    ContactUsPage contactuspage;
	
	public ContactUsSteps(TestContextSetup testContextSetup)
	{
		 this.testContextSetup = testContextSetup;
	     this.homePage = testContextSetup.pageobjectmanager.gethomepage();
	     this.contactuspage = testContextSetup.pageobjectmanager.getcontactuspage();
	}
	
	 @When("Click on Contact Us button")
	    public void Click_on_Contact_Us_button() {
		 contactuspage.clickOnContactUsButton();
	    }
	
	 @When("Verify {string} is visible")
	 public void Verify_GetIn_Touch_Visible(String expectedtext)
	 {
		 String actualtext = contactuspage.getInTouch();
		 Assert.assertEquals(actualtext, expectedtext);
	 }
	
	 @When("Enter name, email, subject and message")
	 public void Enter_name_email_subject_and_message(DataTable table)
	 {
		 Map<String,String> map = table.asMap(String.class, String.class);
		 String name = map.get("Name");
		 String email = map.get("Email");
		 String subject = map.get("Subject");
		 String message = map.get("Message");		
		 
		 contactuspage.enterContactUsName(name);
		 contactuspage.enterContactUsEmail(email);
		 contactuspage.enterSubject(subject);
		 contactuspage.enterMessage(message);
	 }
	
	 @When ("Upload file")
	 public void uploadFile()
	 {
		 contactuspage.uploadFile();
	 }
	 
	 @Then ("Click Submit button and accept popup")
	 public void clickSubmitButton()
	 {
		 contactuspage.submitButton();
         testContextSetup.driver.switchTo().alert().accept();
	 }
	 
	@Then ("Verify success message {string} is visible")
	public void successMsgIsVisible(String expectedText)
	{
		String actualtext =contactuspage.successMsg();
		Assert.assertEquals(actualtext, expectedText);
	}
	
	@Then ("Click Home button and verify that landed to home page successfully")
	public void clickOnHomeButton()
	{
		contactuspage.homePage();
	}
	
	
	 
	 
	 
	 
	 
	
	
	
	
}
