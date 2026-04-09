package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDeletePage {

	public WebDriver driver;
	Select se;
	
	public AccountDeletePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[@data-qa='account-created']")
	private WebElement AccountCreated;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	private WebElement continueButton;
	
	@FindBy(xpath="//a[contains(text(),' Logged in as ')]")
	private WebElement loggedInName;
	
	@FindBy(xpath="//a[@href='/delete_account']")
	private WebElement deleteAccount;
	
	@FindBy(xpath="//h2[@data-qa='account-deleted']")
	private WebElement accountdeletemsg;
	
	public String checkAccountCreated()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(AccountCreated));
		String acctcreatedmsg = AccountCreated.getText();
		return acctcreatedmsg;
	}
	
	public void continueButton()
	{
		continueButton.click();
	}
	
	public String verifyLoggedInName()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(loggedInName));
		
	   String loggedinname = loggedInName.getText();
	   return loggedinname.replace("Logged in as ", "").trim();
	}
	
	public void deleteAcct()
	{
		deleteAccount.click();
	}
	
	public String acctdeletemsg()
	{
		String acctdeletemsg = accountdeletemsg.getText();
		return acctdeletemsg;
	}
	
	public void continueButtonAfterDelete()
	{
		continueButton.click();
	}
	
	
	
}
