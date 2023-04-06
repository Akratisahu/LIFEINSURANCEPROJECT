package com.Pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtitlity;

public class NomineePage {

	@FindBy(name="client_id") 
	private WebElement nomineeid;
	
	@FindBy(name="name") 
	private WebElement nomineename;
	
	@FindBy(name="sex") 
	private WebElement nomineesex;
	
	@FindBy(name="birth_date") 
	private WebElement nomineebirthdate;
	
	@FindBy(name="nid") 
	private WebElement nomineenid;
	
	@FindBy(name="relationship") 
	private WebElement nomineerelationship;
	
	@FindBy(name="priority") 
	private WebElement nomineepriority;
	
	@FindBy(name="phone") 
	private WebElement nomineephone;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	public WebElement getNomineeid() {
		return nomineeid;
	}
	public WebElement getNomineename() {
		return nomineename;
	}
	public WebElement getNomineesex() {
		return nomineesex;
	}
	public WebElement getNomineebirthdate() {
		return nomineebirthdate;
	}
	public WebElement getNomineenid() {
		return nomineenid;
	}
	public WebElement getNomineerelationship() {
		return nomineerelationship;
	}
	public WebElement getNomineepriority() {
		return nomineepriority;
	}
	public WebElement getNomineephone() {
		return nomineephone;
	}
	public  NomineePage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		}
	
	public void createnominee(ExcelUtitlity ex, WebDriver driver) throws Throwable {
		 HashMap<String,String> map=ex.readMultipledata("Sheet2");
		for(Entry<String,String> set:map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
		
	}
		submit.click();
	}
	}
	
	
	

