	package com.scp.orange.hrm.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
	
	public class OrangeHRMLoginPO {
			
				@FindBy(id="txtUsername")
				WebElement username;
				
				@FindBy(id="txtPassword")
				WebElement password;
				
				@FindBy(id="btnLogin")
				WebElement loginBtn;
				
				@FindBy(id="spanMessage")
				WebElement errorMessage;
		
				
				public void enterUsername(String unm){
					this.username.clear();
					this.username.sendKeys(unm);
				}
				
				public void enterPassword(String pwd){
					this.password.clear();
					this.password.sendKeys(pwd);
				}
				
				public void clickOnLoginButton(){
					this.loginBtn.click();
				}
				
				public String getErrorMessage(){
					if(checkForErrorMessage()){
						return errorMessage.getText();
					}
					return null;
				}
				
				public boolean checkForErrorMessage(){
					try{
						return	errorMessage.isDisplayed(); //true
					}catch(Exception e){
						return false; //false
					}
				}
				
				
				
				
				
				
				
				
				
				
				
				
	}
