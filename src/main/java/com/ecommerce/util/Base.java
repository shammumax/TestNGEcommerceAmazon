package com.ecommerce.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecommerce.PageObjects.AddAddressPage;
import com.ecommerce.PageObjects.HomePage;
import com.ecommerce.PageObjects.LoginPage;
import com.ecommerce.PageObjects.ShoppingCartPage;
import com.ecommerce.PageObjects.YourAccountPage;
import com.ecommerce.PageObjects.YourAddressPage;
public class  Base{
	//static block maintain all files loading here in this block ....
	public static  Properties environmentPropertiesFile;
	public static Properties centralProperties;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static LoginPage loginPage = new LoginPage();
	public static HomePage homePage=new HomePage();
	public static YourAccountPage yourAccountPage=new YourAccountPage();
	public static YourAddressPage yourAddressPage=new YourAddressPage();
	public static AddAddressPage addAddressPage=new AddAddressPage();
	public static CartUtilities cartUtilities=new CartUtilities();
	public static ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
	static {
		try {
			centralProperties=new Properties();
			centralProperties.load(new FileInputStream("./src/main/resources/central.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void  doDriverSetup() {
		driver=new ChromeDriver();
		//driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get(centralProperties.getProperty("url"));	
	}
	
	public static void logIn(){
		 homePage.clickAccountAndLists();
		 loginPage.setEmailBox(null);
		 loginPage.clickEmailSubmitButton();
		 loginPage.setPasswordBox("Code@129");
		 loginPage.clickSignInBtn();	
	}
	public static void logOut() {
		Actions act = new Actions(driver);
		act.moveToElement(homePage.mouseHoverOnAccountAndLists()).perform();
		driver.findElement(By.partialLinkText("Sign Out")).click();
		driver.close();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
}
