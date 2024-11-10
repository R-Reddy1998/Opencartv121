package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	
		public AccountRegistrationPage(WebDriver driver)
		{
			
			super(driver);
		}

@FindBy (xpath = "//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy (xpath = "//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy (xpath = "//input[@id='input-email']")
WebElement txtEmail;

@FindBy (xpath = "//input[@id='input-password']")
WebElement txtPassword;

@FindBy (xpath = "//input[@id='input-newsletter']")
WebElement  Subscribechkbox;


@FindBy (xpath = "//input[@name='agree']")
WebElement chkdpolicy;

@FindBy(xpath = "//button[normalize-space()='Continue']")
WebElement btnContinue;

@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement  msgConfirmation;



public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);
}

public void  setLastname(String lname) {
	txtLastname.sendKeys(lname);
}


public void  setEmail (String Email) {
	txtEmail.sendKeys(Email);
}

public void   setPassword (String pwd) {
	txtPassword.sendKeys(pwd);
}


public void   setSubscribechkbox  () {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", Subscribechkbox);	
}

public void   setprivacypolicy() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", chkdpolicy );	
}

public void  clickContinue () {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", btnContinue );	
}


public String getConfirmationMsg() {
try {
	return(msgConfirmation.getText());
}catch(Exception e) {
	return (e.getMessage());
	
}
}
}























