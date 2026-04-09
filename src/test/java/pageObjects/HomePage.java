package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	public WebDriver driver;
	Select se;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Website for automation practice']")
	private WebElement homePageLogo;
	
	@FindBy(xpath="//a[@href='/logout']")
	private WebElement LogOutButton;
	
	@FindBy(xpath="//a[@href='/delete_account']")
	private WebElement deleteButton;
	
	@FindBy(xpath="(//a[@class='btn btn-default add-to-cart'][text()='Add to cart'])[1]")
	private WebElement AddtoCartButton;
	
	@FindBy(xpath="//p[@class='text-center']/a[@href='/view_cart']")
	private WebElement ViewCartButton;
	
	@FindBy(xpath="//div[@class='single-widget']/h2")
	private WebElement subscription;
	
	@FindBy(id="scrollUp")
	private WebElement scrollup;
	
	@FindBy(xpath="//div[@class='col-sm-6']/h2")
	private WebElement automationDescription;
	
	public boolean verifyHomePage()
	{
		boolean homepage = homePageLogo.isDisplayed();
		return homepage;
	}
	
	public void clickOnLogOutButton()
	{
		LogOutButton.click();
	}
	
	public void clickOnDeleteAccountButton()
	{
		deleteButton.click();
	}
	
	public void clickOnAddtoCartButton()
	{
		AddtoCartButton.click();	
	}
	
	public void clickOnViewCartButton()
	{
		ViewCartButton.click();	
	}
	
	public String validateSubscription()
	{
		String subs = subscription.getText();
		return subs;
	}
	
	public void clickOnScrollUp()
	{
		scrollup.click();
	}
	
	public WebElement getAutoDescriptionElement()
	{
		return automationDescription;
	}
	
	public String autoDescription()
	{
		String desc = automationDescription.getText();
		return desc;
	}
	
	
	
	
	
	
	
	
	
}
