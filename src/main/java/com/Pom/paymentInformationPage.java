package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paymentInformationPage {
	@FindBy(linkText = "Add Payment")
	private WebElement Addpayment;
	
	  public paymentInformationPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		}
	public void Addpayment() {
		Addpayment.click();
}
}
