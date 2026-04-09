package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.DownloadUtils;

public class PaymentPage {

	public WebDriver driver;
	Select se;
	
	public PaymentPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='name_on_card']")
	private WebElement NameOnCard;
	
	@FindBy(xpath="//input[@name='card_number']")
	private WebElement CardNumber;
	
	@FindBy(xpath="//input[@name='cvc']")
	private WebElement cvc;
	
	@FindBy(xpath="//input[@name='expiry_month']")
	private WebElement expiryMonth;
	
	@FindBy(xpath="//input[@name='expiry_year']")
	private WebElement expiryYear;
	
	@FindBy(id="submit")
	private WebElement payAndConfirmOrder;
	
	@FindBy(xpath="//div[@class='col-sm-9 col-sm-offset-1']/p")
	private WebElement OrderText;
	
	@FindBy(xpath="//a[text()='Download Invoice']")
	private WebElement DownloadInvoice;
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement ContinueButton;
	
	@FindBy(xpath="//a[@href='/delete_account']")
	private WebElement deleteAccount;
	
	@FindBy(xpath="//h2[@data-qa='account-deleted']/b")
	private WebElement deleteAccountHeader;
	
	public void EnterNameOnCard(String name)
	{
		NameOnCard.sendKeys(name);
	}
	
	public void enterCardNo(String cardno)
	{
		CardNumber.sendKeys(cardno);
	}
	
	public void entercvv(String cvv)
	{
		cvc.sendKeys(cvv);
	}
	
	public void enterMonth(String month)
	{
		expiryMonth.sendKeys(month);
	}
	
	public void expiryYear(String year)
	{
		expiryYear.sendKeys(year);
	}
	
	public void payAndConfirmOrder()
	{
		payAndConfirmOrder.click();
	}
	
	public String orderText()
	{
		String ordertext = OrderText.getText();
		return ordertext;
	}
	
	public void downloadInvoice(String downloadPath, String fileName) throws InterruptedException
	{
		DownloadUtils.deleteFileIfExists(downloadPath, fileName);
		DownloadInvoice.click();
	
	 boolean isDownloaded = DownloadUtils.isFileDownloaded(downloadPath, fileName, 30);// wait max 30 sec
	    if (!isDownloaded) {
	        throw new RuntimeException("Invoice file not downloaded: " + fileName);
	    }
	}
	
	public void clickOnContinueButton()
	{
		ContinueButton.click();
	}
	
	public void ClickOnDeleteButton()
	{
		deleteAccount.click();
	}
	
	public String deletAccountHeader()
	{
		String text = deleteAccountHeader.getText();
		return text;
	}
	
	
	
	
	
	
}
