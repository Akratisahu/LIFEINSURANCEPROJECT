package com.Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientInformationPage {
	@FindBy(linkText ="Add Client")
	private WebElement addclient;
	
	public  ClientInformationPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		}
	public WebElement getAddclient() {
		return addclient;
	}
	public void Addclient() {
		addclient.click();
		}
		
		public void editdata(WebDriver driver,String id) {
			driver.findElement(By.xpath("//table/tbody/tr/td[.='"+id+"']/..//td[8]/a")).click();
		}

	
	}
	

