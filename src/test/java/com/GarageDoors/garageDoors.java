package com.GarageDoors;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.driverSetup;

public class garageDoors extends driverSetup {
	// WebDriver driver; 

		// Title and text for assert
	    String pageTitle = "Amarr Garage Doors & Commercial Doors";
		String navTitleGarageDoors = "Garage Doors";
		
		// Locators
		By NavGarageDoors = By.xpath("//a[contains(text(),'Garage Doors')][1]");
		By NavGarageDoorsss = By.xpath("//a[contains(text(),'Garage Doors')][1]");
		By AcceptAllCookie = By.xpath("//button[text()='Accept All']");

	@BeforeSuite
	public void Browser() throws InterruptedException {
		Driversetup();

	}
	

	@Test(priority = 1)
	public void titleNacceptCook() throws InterruptedException {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, actualTitle);
		Thread.sleep(1000);

		driver.findElement(AcceptAllCookie).click();
		Thread.sleep(1000);

	}

	@Test(priority = 2)
	public void NavMatch() throws InterruptedException {
		String NavTex = driver.findElement(NavGarageDoors).getText();
		Assert.assertEquals(navTitleGarageDoors, NavTex);
		Thread.sleep(1000);
		
		WebElement hover = driver.findElement(NavGarageDoorsss);
		Actions action = new Actions(driver);
        action.clickAndHold(hover).build().perform();
        Thread.sleep(3000);
        
        
		driver.findElement(NavGarageDoors).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
	
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}

}
