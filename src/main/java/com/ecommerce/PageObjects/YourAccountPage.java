package com.ecommerce.PageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;

import com.ecommerce.util.Base;

public class YourAccountPage extends Base {
	private static String yourordersButton="//div[@data-card-identifier='YourOrders']";
	private static String loginAndSecurityButton="//div[@data-card-identifier='SignInAndSecurity']";
	private static String primeButton="//div[@data-card-identifier='Prime']";
	private static String yourAddressButton="//div[@data-card-identifier='AddressesAnd1Click']";
	
	public void clickYoursAddressBtn() {
		driver.findElement(By.xpath(yourAddressButton)).click();
	}
}
