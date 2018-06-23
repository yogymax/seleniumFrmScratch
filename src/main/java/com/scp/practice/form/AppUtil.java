package com.scp.practice.form;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppUtil {

	public enum BrowserTypes { // Enum -- holds predefined constants
		Firefox, Safari, Chrome, IE, Edge
	}

	public static String PRACTICEFORM_LANDING_PAGE="http://toolsqa.com/automation-practice-form/";
	public static String ORANAGEHRM_LOGIN_PAGE ="http://opensource.demo.orangehrmlive.com/";
	
	static public WebDriver driver  =null;	
	static final String GECKO_DRIVER_PATH ;
	static final String CHROME_DRIVER_PATH ;
	static{
		GECKO_DRIVER_PATH=new File("").getAbsolutePath()+"\\geckodriver.exe";
		CHROME_DRIVER_PATH=new File("").getAbsolutePath()+"\\chromedriver.exe";
	}
	
	public static WebDriver initializeBrowser(BrowserTypes bname,String url) {
		switch (bname) {
			case Firefox:
				System.out.println("Inilizing Firefox browser");
				System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
				driver = new FirefoxDriver();
				break;
			case Chrome:
				System.out.println("Inilizing Chrome browser");
				System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
				break;
			case Safari:
				System.out.println("");
				break;
			case Edge:
				System.out.println("");
				break;
			case IE:
				System.out.println("");
				break;
			default:
					System.out.println("Invaid browserName -- ");
		}
		
		driver.get(url);
		
		return driver;
	}
	
	public enum Genders{
		Male,
		Female
	}
	
	
	 public static void closeBrowser(){
		 if(driver!=null){
			 driver.close();
		 }
	 }
	
	
	
}
