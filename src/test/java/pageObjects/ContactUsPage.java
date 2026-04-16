package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage 
{
	public WebDriver driver;
	Select se;
	
	public ContactUsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@href='/contact_us']")
	private WebElement contactUs;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	private WebElement name;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Subject']")
	private WebElement Subject;
	
	@FindBy(id="message")
	private WebElement messagebox;
	
	@FindBy(xpath="//input[@name='upload_file']")
	private WebElement uploadFiles;
		
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//div[@class='contact-form']//h2")
	private WebElement getInTouch;
	
	@FindBy(xpath = "//div[@class='status alert alert-success']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//a[@class='btn btn-success']")
	private WebElement homeButton;
	
	public void clickOnContactUsButton()
	{
		contactUs.click();
	}
	
	public String getInTouch()
	{
		String getintouch = getInTouch.getText();
		return getintouch;
	}
	
	public void enterContactUsName(String contactName)
	{
		name.sendKeys(contactName);	
	}
	
	public void enterContactUsEmail(String contactEmail)
	{
		email.sendKeys(contactEmail);	
	}
	
	public void enterSubject(String subject)
	{
		Subject.sendKeys(subject);	
	}
	
	public void enterMessage(String messageBoxText)
	{
		messagebox.sendKeys(messageBoxText);	
	}
	
	public void uploadFile()
	{
		uploadFiles.sendKeys("C:\\Users\\Gauri\\Downloads\\sample-local-pdf.pdf");	
	}
	
	public void submitButton()
	{
		submitButton.click();
	}
	
	public String successMsg()
	{
		String msg = successMessage.getText();
		return msg;
	}
	
	public void homePage()
	{
		homeButton.click();
	}
	
	

}
