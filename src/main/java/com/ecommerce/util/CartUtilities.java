package com.ecommerce.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class CartUtilities extends Base{
	
	/*
	 * addFirstMatchingItem to cart
	 * verifyItem added to cart
	 * deleteItem from cart
	 */
	
	public void addFirstMatchingElementToCart(List<WebElement> result) throws InterruptedException {
		for(WebElement we : result) {
			System.out.println("\n items "+we.getText());
			if(we.getText().contains("iQOO")) {
				we.click();
				String parentHandle=driver.getWindowHandle();
				System.out.println("parent title is "+driver.getTitle());
				ArrayList<String> wid=new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(wid.get(1));
				System.out.println("child title is "+driver.getTitle());
				if(homePage.addToCartBtnAvailable()) {
					homePage.clickAddToCartBtn();
					Thread.sleep(6000);
					driver.close();
					driver.switchTo().window(wid.get(0));
					break;
				}
					driver.close();
					driver.switchTo().window(wid.get(0));
			}
		}
		
	}
}
