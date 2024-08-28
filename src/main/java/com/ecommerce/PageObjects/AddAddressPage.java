package com.ecommerce.PageObjects;

import org.openqa.selenium.By;

import com.ecommerce.util.Base;

public class AddAddressPage extends Base {
	private  String fullName ="//input[@id='address-ui-widgets-enterAddressFullName']";
	private  String mobileNumber="//input[@id='address-ui-widgets-enterAddressPhoneNumber']";
	private  String pinCode="//input[@id='address-ui-widgets-enterAddressPostalCode']";
	private  String flatHouseBuilding="//input[@id='address-ui-widgets-enterAddressLine1']";
	private  String areaSectorVillageStreet="//input[@id='address-ui-widgets-enterAddressLine2']";
	private  String landMark="//input[@id='address-ui-widgets-landmark']";
	private  String addAddressBtn="//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']";
	public String getFullName() {
		return driver.findElement(By.xpath(this.fullName)).getText();	
	}
	public void setFullName(String fullName) {
		driver.findElement(By.xpath(this.fullName)).sendKeys(fullName);
	}
	
	public void setMobileNumber(String mobileNumber) {
		driver.findElement(By.xpath(this.mobileNumber)).sendKeys(mobileNumber);
	}
	
	public void setPinCode(String pinCode) {
		driver.findElement(By.xpath(this.pinCode)).sendKeys(pinCode);
	}
	
	public void setFlatHouseBuilding(String flatHouseBuilding) {
		driver.findElement(By.xpath(this.flatHouseBuilding)).sendKeys(flatHouseBuilding);
	}
	
	public void setAreaSectorVillageStreet(String areaSectorVillageStreet) {
		driver.findElement(By.xpath(this.areaSectorVillageStreet)).sendKeys(areaSectorVillageStreet);
	}
	
	public void setLandMark(String landMark) {
		driver.findElement(By.xpath(this.landMark)).sendKeys(landMark);
	}
	
	public void clickAddAddressBtn() {
		driver.findElement(By.xpath(this.addAddressBtn)).click();
	}
	
	
}
