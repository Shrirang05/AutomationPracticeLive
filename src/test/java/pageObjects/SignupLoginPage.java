package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupLoginPage {

	public WebDriver driver;
	Select se;
	
	public SignupLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@href='/login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='signup-form']//h2")
	private WebElement signupTitle;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	private WebElement signupName;

	@FindBy(xpath="//form[@action='/signup']//input[@placeholder='Email Address']")
	private WebElement emailaddress;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	private WebElement signup;
	
	@FindBy(xpath="//div[@class='login-form']//h2")
	private WebElement loginAccountHeader;
	
	@FindBy(xpath="//div[@class='login-form']//input[@placeholder='Email Address']")
	private WebElement loginEmail;

	@FindBy(xpath="//div[@class='login-form']//input[@placeholder='Password']")
	private WebElement loginPasword;

	@FindBy(xpath="//div[@class='login-form']//button[@type='submit']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//form[@action='/login']//p")
	private WebElement ValidateLoginText;
	
	@FindBy(xpath="//form[@action='/signup']//p")
	private WebElement validateSignUpText;
	
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	public String verifySignupTitle()
	{
		String signuptext = signupTitle.getText();
		return signuptext;
	}
	
	public void signUp(String name, String email)
	{
		signupName.sendKeys(name);
		emailaddress.sendKeys(email);
	}
	
	public void clickOnSignUp()
	{
		signup.click();
	}
	
	public String loginHeader()
	{
		String loginaccountheader = loginAccountHeader.getText();
		return loginaccountheader;
	}
	
	public void LoginEmailAndPass(String email, String pass)
	{
		loginEmail.sendKeys(email);
		loginPasword.sendKeys(pass);
	}
	
	public void loginbutton()
	{
		LoginButton.click();
	}
	
	public String ValidateLoginText()
	{
		String logintext = ValidateLoginText.getText();
		return logintext;
	}
	
	public String validateSignupText()
	{
		String signuptext = validateSignUpText.getText();	
		return signuptext;
	}
	
	
	
	
	
	
	
	
}
