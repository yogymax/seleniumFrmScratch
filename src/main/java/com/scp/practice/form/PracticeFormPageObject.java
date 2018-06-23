package com.scp.practice.form;

import java.util.List;


/**
 * Id based -- Multiple values--
 * 
 * 
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.scp.practice.form.AppUtil.Genders;

public class PracticeFormPageObject {
	
		@FindBy(name="firstname")
    	WebElement firstName;  //Webelement fnm = driver.findElement(By.name('firstname'))
		
		@FindBy(name="lastname")
    	WebElement lastName;
    	
    	@FindBy(name="sex")
    	List<WebElement> genderType;//List<Webelement> fnm = driver.findElements(By.name('firstname'))
    	
    	//@FindBy(name="exp")
    	@FindBy(xpath="//*[contains(@id,'exp')] ")
    	List<WebElement> yearsOfExp;
    	
    	@FindBy(id="datepicker")
    	WebElement dateInput;
    	
    	
    	@FindBy(name="profession")
    	List<WebElement> profession;
    	
    	@FindBy(id="photo")
    	WebElement profilePicture;
    	
    	@FindBy(name="tool")
    	List<WebElement> tools;
    	
    	@FindBy(id="continents")
    	WebElement countries;
    	
    	@FindBy(id="selenium_commands")
    	WebElement seleniumCmds;
    	
	 
    	public void enterFirstName(String firstnm){
    		this.firstName.clear();
    		this.firstName.sendKeys(firstnm);
    	}
    	
    	public void enterLastName(String lastnm){
    		this.lastName.clear();
    		this.lastName.sendKeys(lastnm);
    	}

    	public void selectGender(Genders gen) throws Exception{
    		boolean isGenderSelected=false;
    			for(WebElement item :genderType){
    				if(item.getAttribute("value").equals(gen.toString())){
    					item.click();
    					isGenderSelected=true;
    					System.out.println("Selecting -- " +item.getAttribute("value"));
    					break;
    				}
    			}
    			
    			if(!isGenderSelected){
    				throw new Exception("invalid gender type");
    			}
    	}

    	
    	public void selectYearOfExp(String exprc) throws Exception{
    		boolean isExprSelected =false;
			for(WebElement item :yearsOfExp){
				if(item.getAttribute("value").equals(exprc)){
					item.click();
					isExprSelected=true;
					System.out.println("Selecting -- " +item.getAttribute("value"));
					break;
				}
			}
			
			if(!isExprSelected){
				throw new Exception("Invalid year of exprc");
			}
			
	}


    public void enterDate(String date){
    	this.dateInput.clear();
    	this.dateInput.sendKeys(date);
    }
    	
    	
    public void selectProfession(String... prof){
    	for (String p : prof) { //2 , z b
    		for (WebElement item : profession) { //5  .. x Y z a b
					if(item.getAttribute("value").equals(p)){
						item.click();
						break;
					}
			}
		}
    	
    }
   
    	
    	 public void selectTools(String... uTools){
    	    	for (String p : uTools) { //2 , z b
    	    		for (WebElement item : tools) { //5  .. x Y z a b
    						if(item.getAttribute("value").equals(p)){
    							item.click();
    							break;
    						}
    				}
    			}
    	
    }
    	
    	 
    	 public void selectCountry(String country){
    		 Select selectList = new Select(countries);
    		 selectList.selectByVisibleText(country);
    	 }
    	 
    	 public void selectSeleniumCmds(String ...cmds){
    		 Select select = new Select(seleniumCmds);
    		 for (String item : cmds) {
				select.selectByVisibleText(item);
			}
    		 
    	 }
    	 
    	 
    	 
}
