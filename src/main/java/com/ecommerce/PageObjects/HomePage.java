package com.ecommerce.PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ecommerce.util.Base;

public class HomePage extends Base{
	
	private static String amazonLogo="//a[@id='nav-logo-sprites']";
	private static String searchBar="//input[@id='twotabsearchtextbox']";
	private static String magnifyingGlass="//input[@id='nav-search-submit-button']";
	private static String cartButton="//a[@class='nav-a nav-a-2 nav-progressive-attribute']";
	private static String returnAndOrdersButton="//a[@id='nav-orders']";
	private static String accountAndListsButton="//span[contains(text(),'Account & Lists')]";
	
	private static String listOfItems="//span[@class='a-size-medium a-color-base a-text-normal']";
	
	private static String addToCartBtn="//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']";
	
	
	public void clickAccountAndLists() {
		 driver.findElement(By.xpath("//span[contains(text(),'Account & Lists')]")).click();
	 }
	//below used to sign out
	public WebElement mouseHoverOnAccountAndLists() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Account & Lists')]")));
		return driver.findElement(By.xpath("//span[contains(text(),'Account & Lists')]"));
	}
	public void setSearchBarTextAndHit(String str) {
		driver.findElement(By.xpath(searchBar)).sendKeys(str);
		driver.findElement(By.xpath(magnifyingGlass)).click();
		
	}
	public List<WebElement> getResultElements(){
		List<WebElement> result=driver.findElements(By.xpath(listOfItems));
		return result;
	}
	public boolean addToCartBtnAvailable() {
		return driver.findElement(By.xpath(addToCartBtn)).isDisplayed();
		
	}
	public void clickAddToCartBtn(){
		 driver.findElement(By.xpath(addToCartBtn)).click();	
	}
	public void clickCartSection() {
		driver.findElement(By.xpath(cartButton)).click();
	}
	

}
