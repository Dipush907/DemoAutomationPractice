package pageRepo;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TshirtPage {

	
	public TshirtPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='product-count']")
	private WebElement inStockLink;
	
	@FindBy(xpath = "//h5[@itemprop=\"name\"]/a[@class='product-name']")
	private WebElement NameOfProd;
	

	@FindBy(xpath = "//span[text()='Add to cart']")
	private WebElement addToCartLink;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public void clickOnAddToCart(WebDriver driver)
	{
		Actions act= new Actions(driver);
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		jse.executeScript("arguments[0].scrollIntoView(true);", inStockLink);
		
		act.moveToElement(NameOfProd).perform();
		wait.until(ExpectedConditions.elementToBeClickable(addToCartLink));
		
		addToCartLink.click();
	}
	
	public void prcdToCheckOut()
	{
		proceedToCheckOut.click();
	}
}
