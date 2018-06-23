package com.scp.practiceform.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.scp.practice.form.AppUtil;
import com.scp.practice.form.PracticeFormPageObject;
import com.scp.practice.form.AppUtil.Genders;



public class PracticeFormTest {

	
	@Test
	public void fillPracticeForm() throws Exception{
		  System.out.println("Open Browser -- Browser should be opened");
		  WebDriver driver =AppUtil.initializeBrowser(AppUtil.BrowserTypes.Firefox, AppUtil.PRACTICEFORM_LANDING_PAGE);
		  PracticeFormPageObject po = PageFactory.initElements(driver, PracticeFormPageObject.class);
		  po.enterFirstName("Amit");
		  po.enterLastName("ABCD");
		  po.selectGender(Genders.Male);
		  po.selectYearOfExp("7");
		  po.enterDate("06/16/18");
		  po.selectProfession("Manual Tester","Automation Tester");
		  po.selectTools("Selenium Webdriver");
		  po.selectCountry("North America");
		  po.selectSeleniumCmds("Switch Commands","WebElement Commands");
	  }
	
}
