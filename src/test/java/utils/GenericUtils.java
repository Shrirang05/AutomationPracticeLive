package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	public WebDriver driver;

	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	
	public void SwitchWindowToChild()	
	{
		   Set<String> offerspageid = driver.getWindowHandles();
		   List<String> id = new ArrayList<>(offerspageid);
		   driver.switchTo().window(id.get(1)); 	
	}
	
//	public void ExlicitWait(WebElement element) 
//	{
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//	    
//	}
}
