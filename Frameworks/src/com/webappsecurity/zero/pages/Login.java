package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(id="user_login")
	private WebElement uName;
	
	
	@FindBy(id="user_password")
	private WebElement pass;
	
	@FindBy(name="submit")
	private WebElement signIn;
	
	
	@FindBy(css= "#login_form > div.alert.alert-error")
	private WebElement errMsgbox ;
	
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getErrorMsgtext() {
		String errMsg = errMsgbox.getText();
		return errMsg;
	}
	public void applicationLogin(String loginName, String loginPassword) {
		uName.sendKeys(loginName);
		pass.sendKeys(loginPassword);
		signIn.click();
		
	}

}
