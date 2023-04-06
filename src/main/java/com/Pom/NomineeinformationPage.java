package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NomineeinformationPage {

	@FindBy(linkText = "Add Nominee")
	private WebElement Addnominee;
	
	public  NomineeinformationPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		}
	public void addnominee() {
		Addnominee.click();
}
}
