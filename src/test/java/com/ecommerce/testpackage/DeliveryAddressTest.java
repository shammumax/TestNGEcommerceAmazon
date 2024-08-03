package com.ecommerce.testpackage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ecommerce.PageObjects.AddAddressPage;
import com.ecommerce.PageObjects.HomePage;
import com.ecommerce.PageObjects.LoginPage;
import com.ecommerce.PageObjects.YourAccountPage;
import com.ecommerce.PageObjects.YourAddressPage;
import com.ecommerce.util.Base;

public class DeliveryAddressTest extends Base {
	/*
	 * add , edit , remove , try to add duplicate address and verify , invalid phone number then try 5 cases here only ..)
	 */
	
	@BeforeClass
	public void deliveryAddressTestLogin() throws InterruptedException {
		doDriverSetup();
		logIn();
	}

	@Test(priority = 1)
	public void createDeliveryAddress() {	
		homePage.clickAccountAndLists();
		yourAccountPage.clickYoursAddressBtn();
		yourAddressPage.addAddress();
		addAddressPage.setFullName("abinaya");
		addAddressPage.setMobileNumber("7095012822");
		addAddressPage.setPinCode("521105");
		addAddressPage.setFlatHouseBuilding("randombuilding");
		addAddressPage.setAreaSectorVillageStreet("randomstreet");
		addAddressPage.setLandMark("randomlandmark");
		addAddressPage.clickAddAddressBtn();
		assertTrue(yourAddressPage.verifyAddressAddedOrNot());	
	}
	//@Test(priority = 3)
	public void editDelieveryAddress() {
		homePage.clickAccountAndLists();
		yourAccountPage.clickYoursAddressBtn();
		yourAddressPage.editAddress();
		addAddressPage.setFullName(addAddressPage.getFullName()+" modified");
		addAddressPage.clickAddAddressBtn();
		assertTrue(yourAddressPage.verifyAddressAddedOrNot());
	}
	@Test(priority = 2)
	public void removeDeliveryAddress() throws InterruptedException {
		homePage.clickAccountAndLists();
		yourAccountPage.clickYoursAddressBtn();
		
		yourAddressPage.removeAddress();
		
		Thread.sleep(6000);//very critical approx it tooks 2 days of time to resolve ............
		
		
		yourAddressPage.clickRemoveAddressConfirmYes();
		assertTrue(yourAddressPage.verifyAddressDeletedOrNot());
	}
	//@Test(priority = 2)
	public void addDuplicateAddress() {
		
		homePage.clickAccountAndLists();
		yourAccountPage.clickYoursAddressBtn();
		yourAddressPage.addAddress();
		addAddressPage.setFullName("abinaya");
		addAddressPage.setMobileNumber("7095012822");
		addAddressPage.setPinCode("521105");
		addAddressPage.setFlatHouseBuilding("randombuilding");
		addAddressPage.setAreaSectorVillageStreet("randomstreet");
		addAddressPage.setLandMark("randomlandmark");
		addAddressPage.clickAddAddressBtn();
		assertFalse(yourAddressPage.verifyAddressAddedOrNot());	
		//You have submitted an address that is already in your address book
	}
	@AfterClass
	public void deliveryAddressTestLogOut() {
		//logOut();
	}
}
