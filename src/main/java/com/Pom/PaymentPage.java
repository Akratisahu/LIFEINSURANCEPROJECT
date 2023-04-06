package com.Pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	
	@FindBy(name="client_id")
	private WebElement clientpayment;
	
	@FindBy(name="month")
	private WebElement paymentmonth;
	
	@FindBy(name="amount")
	private WebElement paymentamount;
	
	@FindBy(name="due")
	private WebElement paymentdue;
	
	@FindBy(name="fine")
	private WebElement paymentfine;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	  public PaymentPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		}
	  
	  public void createpayment(HashMap<String,String> map, WebDriver driver) {
			for(Entry<String,String> set:map.entrySet()) {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
			
		}
			submit.click();
		}
}