package com.scp.demo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

/**
 * 
 * apache maven
 * Webdriver -- 
 * 			--
 * Webelement -- 
 * 			--
 * 
 *
 */

public class OrangeHRMLoginFunctions {
	static final String GECKO_DRIVER_PATH ;
	static{
		GECKO_DRIVER_PATH=new File("").getAbsolutePath()+"\\geckodriver.exe";
	}
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
		WebDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		
		username.sendKeys("Aadmin");
		password.sendKeys("admin");
		
		WebElement signBtn =driver.findElement(By.id("btnLogin"));
		signBtn.click();
		
		WebElement welCome = driver.findElement(By.id("welcome"));
		System.out.println(welCome.getText());

		Assert.assertNotNull(welCome);
		Assert.assertEquals(welCome.getText(), "Welcome Admin");
		
		
		
		
		
		
		
	}
	
}


/*
 * Webdriver -- Browser
 * Webelement -- Browser element
 */
