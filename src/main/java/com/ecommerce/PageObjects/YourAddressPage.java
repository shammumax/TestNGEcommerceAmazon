package com.ecommerce.PageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecommerce.util.Base;

public class YourAddressPage extends Base{
	
	private static String defaultAddress="//div[@id='ya-myab-display-address-block-0']";
	
	private static String addAdddressButton="//div[@class='a-box first-desktop-address-tile']";
	
	private static String addressSavedRibbonToVerify="//h4[contains(text(),'Address saved')]";
	
	private static String addressDeletedRibbonToVerify="//h4[contains(text(),'Address deleted')]";
	
	private static String editAddressButton="//a[@id='ya-myab-address-edit-btn-1']";
	
	//we are removing first non default address because we are adding same first non default address only....
	
	public static String removeAddressButton="//a[@id='ya-myab-address-delete-btn-1']";
	////span[@id='deleteAddressModal-1-submit-btn']//input[@type='submit']---selectors hub
	//////span[@id='deleteAddressModal-1-submit-btn-announce']
	
	public static String removeAddressConfirmYes="//span[@id='deleteAddressModal-1-submit-btn']//input[@type='submit']";
	
	public void addAddress() {
		driver.findElement(By.xpath(addAdddressButton)).click();
	}
	public boolean verifyAddressAddedOrNot() {
		if(driver.findElement(By.xpath(addressSavedRibbonToVerify)).getText().equalsIgnoreCase("Address saved")) 
			return true;
		else return false;
	}
	//Address deleted
	public boolean verifyAddressDeletedOrNot() {
		if(driver.findElement(By.xpath(addressDeletedRibbonToVerify)).getText().equalsIgnoreCase("Address deleted")) 
			return true;
		else return false;
	}
	public void editAddress() {
		driver.findElement(By.xpath(editAddressButton)).click();
	}
	public void removeAddress() {
		driver.findElement(By.xpath(removeAddressButton)).click();
	}
	public void getAddressSavedText() {
		driver.findElement(By.xpath(addressSavedRibbonToVerify)).getText();
	}
	public void clickRemoveAddressConfirmYes() {
		driver.findElement(By.xpath(removeAddressConfirmYes)).click();
	}
}
