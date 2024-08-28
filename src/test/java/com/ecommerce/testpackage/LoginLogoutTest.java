//import org.t
package com.ecommerce.testpackage;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ecommerce.PageObjects.HomePage;
import com.ecommerce.PageObjects.LoginPage;
import com.ecommerce.util.Base;


public class LoginLogoutTest extends Base {
	
	@BeforeMethod
	public void fun() {
		doDriverSetup();
	}
	
	@Test(priority = 1)
	public  void loginTest() throws InterruptedException {
	 homePage.clickAccountAndLists();
	 loginPage.setEmailBox(null);
	 loginPage.clickEmailSubmitButton();
	 loginPage.setPasswordBox("Code@129");
	 loginPage.clickSignInBtn();
	 assertTrue(loginPage.isLoginSuccessfull());
	}
	@Test(priority = 3)
	public void loginWithEmptyPassword() {
		homePage.clickAccountAndLists();
		loginPage.setEmailBox(null);
		loginPage.clickEmailSubmitButton();
		loginPage.setPasswordBox("");
		loginPage.clickSignInBtn();
		assertTrue(loginPage.isErrorTextMatching());
	}
	@Test(priority = 2)
	public  void logoutTest() {
		logIn();
		//WebElement we = homePage.mouseHoverOnAccountAndLists();
		Actions act = new Actions(driver);
		act.moveToElement(homePage.mouseHoverOnAccountAndLists()).perform();
		driver.findElement(By.partialLinkText("Sign Out")).click();
		assertTrue(loginPage.isLogoutSuccessfull());
			
	}
	@AfterMethod
	public void closeChrome() throws InterruptedException {
		Thread.sleep(6000);
		driver.close();
	}
}
