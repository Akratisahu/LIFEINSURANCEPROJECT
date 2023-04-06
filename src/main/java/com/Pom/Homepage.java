package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	@FindBy(xpath="//i[@class='fa fa-users ']/ancestor::li")
	private WebElement clientclick;
	
	@FindBy(xpath="//i[@class='fa fa-life-saver ']/ancestor::li")
	private WebElement agentclick;
	
	@FindBy(xpath="//i[@class='fa fa-pencil-square-o ']/ancestor::li")
	private WebElement policyclick;
	
	@FindBy(xpath="//i[@class='fa fa-heart ']/ancestor::li")
	private WebElement nomineeclick;
	
	@FindBy(xpath="//i[@class='fa fa-credit-card ']/ancestor::li")
	private WebElement paymentsclick;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchtext;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath="//i[@class='fa fa-exclamation-circle fa-2x']")
	private WebElement logout;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getClientclick() {
		return clientclick;
	}


	public WebElement getAgentclick() {
		return agentclick;
	}


	public WebElement getPolicyclick() {
		return policyclick;
	}


	public WebElement getNomineeclick() {
		return nomineeclick;
	}


	public WebElement getPaymentsclick() {
		return paymentsclick;
	}


	public WebElement getLogout() {
		return logout;
	}
	
	public void client() {
		clientclick.click();
	}
	public void agent() {
		agentclick.click();
	}
	public void policy() {
		policyclick.click();
	}
	public void nominee() {
		nomineeclick.click();
	}
	public void payment() {
		paymentsclick.click();
	}
	public void logout() {
		logout.click();
	}
	public void search() {
		searchtext.sendKeys();
	    submit.click();
	}

	

	
}
