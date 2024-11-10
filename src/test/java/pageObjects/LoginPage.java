package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public  LoginPage(WebDriver driver)
	{ 
		super(driver);
	}
@FindBy (xpath = "//input[@id='input-email']")
WebElement txtEmail;

@FindBy (xpath = "//input[@id='input-password']")
WebElement txtpassword;

@FindBy (xpath = "//button[normalize-space()='Login']")
WebElement clickloginbtn;



public void  setEmail (String Email) {
	txtEmail.sendKeys(Email);
}

public void   setPassword (String pwd) {
	txtpassword.sendKeys(pwd);
}


public void clickloginbtn() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", clickloginbtn );		
}

}

