
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)

	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement 	inkmyaccount;
	@FindBy (xpath = "//a[normalize-space()='Register']")
	WebElement inkregister;
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement 	inklogin;
	
	
	public void clickMyaccount() 
	{
		inkmyaccount.click();
		
	}
public void clickRegister()
{
	inkregister.click();
}

public void clickLogin()
{
	inklogin.click();
}
}
