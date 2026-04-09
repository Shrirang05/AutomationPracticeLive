package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreatedPage {

	public WebDriver driver;
	Select se;
	
	public AccountCreatedPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//h2[@class='title text-center']//b)[1]")
	private WebElement EnterSignUpInfo;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	private WebElement Title;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="days")
	private WebElement days;
	
	@FindBy(id="months")
	private WebElement months;
	
	@FindBy(id="years")
	private WebElement years;
	
	@FindBy(id="optin")
	private WebElement specialoffer;
	
	@FindBy(id="newsletter")
	private WebElement newsletter;
	
	@FindBy(id="first_name")
	private WebElement firstname;
	
	@FindBy(id="last_name")
	private WebElement lastname;
	
	@FindBy(id="company")
	private WebElement company;
	
	@FindBy(id="address1")
	private WebElement address1;
	
	@FindBy(id="address2")
	private WebElement address2;
	
	@FindBy(id="country")
	private WebElement country;
	
	@FindBy(id="state")
	private WebElement state;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="zipcode")
	private WebElement zipcode;
	
	@FindBy(id="mobile_number")
	private WebElement mobilenumber;
	
	@FindBy(xpath="//button[@data-qa='create-account']")
	private WebElement CreateAccount;
	
	
	public String ValidateAccountInfoTitle()
	{
	  String accountInfoHeader = EnterSignUpInfo.getText();
	  return accountInfoHeader;
	}
	
	public void enterDayMonthYear(String pass, String day, String month, String year)
	{
		Title.click();
		password.sendKeys(pass);
		
		se = new Select(days);
		se.selectByVisibleText(day);
		
		se = new Select(months);
		se.selectByVisibleText(month);
		
		se = new Select(years);
		se.selectByVisibleText(year);		
	}
	
	public void selectCheckbox()
	{
		specialoffer.click();
	}
	
	public void selectofferCheckbox()
	{
		newsletter.click();
	}
	
	public void enterPersonalInfo(String firname, String lasname, String companyname, String address1T, String address2T, String countryname, String statename, String cityname, String zipcodetext, String mobile)
	{
		firstname.sendKeys(firname);
		lastname.sendKeys(lasname);
		company.sendKeys(companyname);
		address1.sendKeys(address1T);
		address2.sendKeys(address2T);	
		se = new Select(country);
		se.selectByVisibleText(countryname);
		state.sendKeys(statename);
		city.sendKeys(cityname);
		zipcode.sendKeys(zipcodetext);
		mobilenumber.sendKeys(mobile);
	}
	
	public void createAccount()
	{
		CreateAccount.click();
	}
	
	
	
	
	
}
