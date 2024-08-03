package com.ecommerce.PageObjects;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.interactions.Actions;

import com.ecommerce.util.Base;

import org.openqa.selenium.WebElement;

public class LoginPage extends Base {

	private String emailBox = "//input[@name='email']";// by xpath
	private String emailSubmitButton = "a-button-input";// by classname
	private String passwordBox = "ap_password";// by id
	private String signInBtn = "signInSubmit";// by id
	private String enterPassworErrorText="//div[contains(text(),'Enter your password')]";//by xpath

	public void setEmailBox(String str) {
		str = "shammumax1999@gmail.com";
		driver.findElement(By.xpath(emailBox)).sendKeys(str);
	}
	public void clickEmailSubmitButton() {
		driver.findElement(By.className(emailSubmitButton)).click();
	}
	public void setPasswordBox(String str) {
		driver.findElement(By.id(passwordBox)).sendKeys(str);
	}
	public void clickSignInBtn() {
		driver.findElement(By.id(signInBtn)).click();
	}
	public void getTextWhenPasswordEmptySubmit() {
		driver.findElement(By.xpath(enterPassworErrorText)).getText();
	}
	public boolean isErrorTextMatching() {
		if(driver.findElement(By.xpath(enterPassworErrorText)).getText().contains("Enter your password"))
			return true;
		else
			return false;
	}
	public boolean isLoginSuccessfull() {
		Actions act = new Actions(driver);
		act.moveToElement(homePage.mouseHoverOnAccountAndLists()).perform();
		if(driver.findElement(By.partialLinkText("Sign Out")).isDisplayed())
			return true;
		else return false;
		
		
	}
	public boolean isLogoutSuccessfull() {
		logOut();
		if(driver.getTitle().contains("signin?"))
			return true;
		else
			return false;
	}

}
