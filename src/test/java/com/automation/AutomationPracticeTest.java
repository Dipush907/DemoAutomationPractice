package com.automation;

import org.testng.annotations.Test;

import pageRepo.BaseClass;
import pageRepo.LoginPage;
import pageRepo.MyAccountPage;
import pageRepo.MystorePage;
import pageRepo.OrderPage;
import pageRepo.TshirtPage;

public class AutomationPracticeTest extends BaseClass {

	@Test
	public void automationPracTest() throws Throwable
	{
		MystorePage navigateToLogin= new MystorePage(driver);
		navigateToLogin.navigateToLogInPage();
	
		LoginPage login= new LoginPage(driver);
		login.logInToApp();
		
		MyAccountPage myAccnt = new MyAccountPage(driver);
		myAccnt.clickOnTshirtLink();
		
		TshirtPage tp= new TshirtPage(driver);
		tp.clickOnAddToCart(driver);
		tp.prcdToCheckOut();
		
		OrderPage op= new OrderPage(driver);
		op.clickOnAddMoreQtyIcon(driver);
		op.fetchInitialTotalPrice(driver);
		op.proceedToCheckOutBttnInQtyPAge();
		op.proceedToCheckOutBttnInAdressPage();
		op.clickOnAgreeTermsAndCondCheckBox(driver);
		op.proceedToCheckOutBttnInTermAndCondPage();
		op.fetchPaymentPageTotalPrice(driver);
		op.assertPrices();
	}
}
