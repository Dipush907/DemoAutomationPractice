package pageRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement UN;
	
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement PW;
	
	@FindBy(id = "SubmitLogin")
	private WebElement loginBttn;
	
	
	public void logInToApp()
	{
		UN.sendKeys("dipush908@gmail.com");
		PW.sendKeys("Bibhudatta");
		
		loginBttn.click();
	}
}
