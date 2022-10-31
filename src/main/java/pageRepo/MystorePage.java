package pageRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystorePage {

	public MystorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "login")
	private WebElement logIn;
	
	public void navigateToLogInPage()
	{
		logIn.click();
	}
	
}
