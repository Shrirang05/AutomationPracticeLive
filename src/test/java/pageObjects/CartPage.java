package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

	public WebDriver driver;
	Select se;
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='breadcrumbs']//li[2]")
	private WebElement shoppingcartPage;
	
	@FindBy(xpath="//a[text()='Proceed To Checkout']")
	private WebElement ProceedToCheckout;
	
	@FindBy(xpath="(//a[@href='/login'])[2]")
    private WebElement RegisterorLogin;
	
	@FindBy(xpath="//a[@href='/view_cart']")
    private WebElement CartButton;
	
	@FindBy(xpath="(//ul[@id='address_delivery']//li)[4]")
    private WebElement Address1;
	
	@FindBy(xpath="//ul[@id='address_delivery']//li[@class='address_phone']")
    private WebElement ContactNo;
	
	@FindBy(xpath="//a[@href='/product_details/1']")
    private WebElement ItemName;
	
	@FindBy(xpath="//div[@id='ordermsg']//textarea")
    private WebElement commentBox;

	@FindBy(xpath="//a[@class='btn btn-default check_out']")
    private WebElement PlaceOrder;
	
	public String VerifyCartpage()
	{
		String text = shoppingcartPage.getText();
		return text;
	}
	
	public void clickOnProceedToCheckout()
	{
		ProceedToCheckout.click();
	}
	
	public void clickOnRegisterorLogin()
	{
		RegisterorLogin.click();
	}
	
	public void clickOnCartButton()
	{
		CartButton.click();
	}
	
	//checkout page element =
	public String ValidateAddress1()
	{
		String address1 = Address1.getText();
		return address1;
	}
	
	public String ContactNo()
	{
		String contactno = ContactNo.getText();
		return contactno;
	}
	
	public String validateItemName()
	{
		String itemname = ItemName.getText();
		return itemname;
	}
		
	public void EnterCommentIntoCommentBox(String text)
	{
		commentBox.sendKeys(text);
	}
	
	public void placeOrderButton()
	{
		PlaceOrder.click();
	}
	
	
	
	
	
}
