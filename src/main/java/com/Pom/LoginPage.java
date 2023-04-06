package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[.='login']")
	private WebElement login;
	
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getUsername() {
		return username;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLogin() {
		return login;
	}


	


	public void login(String usernm,String pwd) {
		username.sendKeys(usernm);
		password.sendKeys(pwd);
		login.click();
	}
	
}
