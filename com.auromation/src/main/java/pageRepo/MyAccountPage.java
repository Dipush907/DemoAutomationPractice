package pageRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='T-shirts']")
	private List<WebElement> tshirtLink;
	
	public void clickOnTshirtLink()
	{
		for (int i = 1; i < tshirtLink.size(); i++) {
			tshirtLink.get(i).click();
		}
	}
}
