package com.ecommerce.PageObjects;

import org.openqa.selenium.By;

import com.ecommerce.util.Base;

public class ShoppingCartPage extends Base{
	private String subTotalItems="//span[@id='sc-subtotal-label-activecart']"; //Subtotal (1 item)
	private String deleteItem="//input[@value='Delete'][1]";
	private String emptyCartTextForVerification="//h2[@class='a-size-extra-large a-spacing-mini a-spacing-top-base a-text-normal']"; //Your Amazon Cart is empty.
	////h2[@class='a-size-extra-large a-spacing-mini a-spacing-top-base a-text-normal']
	public boolean isCartEmpty() {
		if(driver.findElement(By.xpath(emptyCartTextForVerification)).getText().equalsIgnoreCase("Your Amazon Cart is empty."))
			return true;
		else 
			return false;
	}
	public void deleteItem() {
		driver.findElement(By.xpath(deleteItem)).click();
	}
	public boolean verifyItemsCount() {
		String str=driver.findElement(By.xpath(subTotalItems)).getText();
		if(str.contains("Subtotal (1 item)"))
			return true;
		else return false;
	}
}
