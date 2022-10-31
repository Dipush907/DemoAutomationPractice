package pageRepo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

	
	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@id,'cart_quantity_up')]")
	private WebElement addMoreQuantity;
	
	@FindBy (xpath = "//span[contains(@id,'total_price')]")
	private WebElement initialTotalPrice;
	
	@FindBy (xpath = "//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
	private WebElement proceedToChkOutInQtyPage;
	
	@FindBy (xpath = "//button[@name='processAddress']")
	private WebElement proceedToChkOutInAddressPage;
	
	@FindBy (xpath = "//input[@type='checkbox']")
	private WebElement agreeTermsAndCondCheckBox;
	
	@FindBy (xpath = "//button[@name='processCarrier']")
	private WebElement proceedToChkOutInAddressPageInTAndCPage;
	
	
	
	public void clickOnAddMoreQtyIcon(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(addMoreQuantity).click().perform();
	}
	
	String initialTotalPriceInString=null;
	public String fetchInitialTotalPrice(WebDriver driver) throws Throwable
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

		Thread.sleep(3000);
		jse.executeScript("arguments[0].scrollIntoView(true)", initialTotalPrice);
		initialTotalPriceInString= initialTotalPrice.getText();
		System.out.println(initialTotalPriceInString);
		return initialTotalPriceInString;
	}
	
	public void proceedToCheckOutBttnInQtyPAge()
	{
		proceedToChkOutInQtyPage.click();
	}
	
	public void proceedToCheckOutBttnInAdressPage()
	{
		proceedToChkOutInAddressPage.click();
	}
	
	
	public void clickOnAgreeTermsAndCondCheckBox(WebDriver driver)
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", agreeTermsAndCondCheckBox);
		agreeTermsAndCondCheckBox.click();
	}
	
	public void proceedToCheckOutBttnInTermAndCondPage()
	{
		proceedToChkOutInAddressPageInTAndCPage.click();
	}
	
	String paymentPageTotalPriceInString=null;
	public String fetchPaymentPageTotalPrice(WebDriver driver)
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", initialTotalPrice);
		
		paymentPageTotalPriceInString = initialTotalPrice.getText();
		System.out.println(paymentPageTotalPriceInString);
		return paymentPageTotalPriceInString;
	}
	
	public void assertPrices()
	{
		assertEquals(initialTotalPriceInString, paymentPageTotalPriceInString ,"Both Initial price and payment page price do match");
	}
	
}
