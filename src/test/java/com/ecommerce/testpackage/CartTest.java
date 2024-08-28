package com.ecommerce.testpackage;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ecommerce.util.Base;

public class CartTest extends Base{
	 
	//span[@class='a-size-medium a-color-base a-text-normal']
		////div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']
	/*
	 * add to cart if option available and then delete from cart
	 */
	
	//select elements to cart
	//verify added to cart //span[@id='sc-subtotal-label-activecart']  Subtotal (1 item):
	//then delete from cart //input[@name='submit.delete.38591ae6-14fc-4970-a366-601ae925b605']
	//Your Amazon Cart is empty. ////h1[@class='a-spacing-mini a-spacing-top-base']

	
	
	@Test
	public void verifyAbleToAddToCart() throws InterruptedException {
		doDriverSetup();
		logIn();
		homePage.clickCartSection();
		assertTrue(shoppingCartPage.isCartEmpty());
		homePage.setSearchBarTextAndHit("iQOO");
		List<WebElement> result = homePage.getResultElements();
		cartUtilities.addFirstMatchingElementToCart(result);
		homePage.clickCartSection();
		assertTrue(shoppingCartPage.verifyItemsCount());
		
		
	}
	@Test
	public void verifyAbleToDeleteFromCart() {
		homePage.clickCartSection();
		shoppingCartPage.deleteItem();
		assertTrue(shoppingCartPage.isCartEmpty());
		
	}
}
