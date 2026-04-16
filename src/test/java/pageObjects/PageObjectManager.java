package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

   public HomePage homepage;
   public SignupLoginPage signuppage;
   public AccountCreatedPage acctcreatedpage;
   public AccountDeletePage acctdeletedpage;
   public CartPage cartpage;
   public PaymentPage paymentpage;
   public ContactUsPage contactuspage;
   
   public WebDriver driver;


	public PageObjectManager(WebDriver driver)
	{
	    this.driver=driver;	
	}
     
     public HomePage gethomepage()
     {
    	 homepage = new HomePage(driver);
    	 return homepage;
     }
     
     public SignupLoginPage getSignupLoginPage()
     {
    	 signuppage = new SignupLoginPage(driver);
    	 return signuppage;
     }
     
     public AccountCreatedPage getAccountCreatedPage()
     {
    	 acctcreatedpage = new AccountCreatedPage(driver);
    	 return acctcreatedpage;
     }
    
     public AccountDeletePage getaccountdeletedpage()
     {
    	 acctdeletedpage = new AccountDeletePage(driver);
    	 return acctdeletedpage;
     }
    
     public CartPage getcartpage()
     {
    	 cartpage = new CartPage(driver);
    	 return cartpage;
     }
     
     public PaymentPage getpaymentpage()
     {
    	 paymentpage = new PaymentPage(driver);
    	 return paymentpage;
     }
     
     public ContactUsPage getcontactuspage()
     {
    	 contactuspage = new ContactUsPage(driver);
    	 return contactuspage;
     }
     
	
}
