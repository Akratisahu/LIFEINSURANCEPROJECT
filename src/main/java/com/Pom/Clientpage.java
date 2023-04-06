package com.Pom;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.ExcelUtitlity;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtility;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class Clientpage {
WebDriver driver;
	
      @FindBy(name="client_id")
     private WebElement clientid;
	@FindBy(name="client_password")
	private WebElement clientpwd;
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(name="fileToUpload")
	private WebElement fileupload;
	
	@FindBy(name="sex")
	private WebElement sex;
	
	@FindBy(name="birth_date")
	private WebElement birthdate;
	
	@FindBy(name="maritial_status")
	private WebElement maritialstatus;
	
	@FindBy(name="nid")
	private WebElement nid;
	
	@FindBy(name="phone")
	private WebElement phone;
	
	@FindBy(name="address")
	private WebElement address;
	
	@FindBy(name="policy_id")
	private WebElement policyid;
	
	@FindBy(name="nominee_name")
	private WebElement nomineename;
	
	@FindBy(name="nominee_sex")
	private WebElement nomimeesex;
	
	@FindBy(name="nominee_birth_date")
	private WebElement nomineebirthdate;
	
	@FindBy(name="nominee_nid")
	private WebElement nomineenid;
	
	@FindBy(name="nominee_relationship")
	private WebElement nomineerelationship;
	
	@FindBy(name="priority")
	private WebElement priority;
	
	@FindBy(name="nominee_phone")
	private WebElement nomineephone;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	public Clientpage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClientpwd() {
		return clientpwd;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getFileupload() {
		return fileupload;
	}

	public WebElement getSex() {
		return sex;
	}

	public WebElement getBirthdate() {
		return birthdate;
	}

	public WebElement getMaritialstatus() {
		return maritialstatus;
	}

	public WebElement getNid() {
		return nid;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getPolicyid() {
		return policyid;
	}

	public WebElement getNomineename() {
		return nomineename;
	}

	public WebElement getNomimeesex() {
		return nomimeesex;
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

	public WebElement getPriority() {
		return priority;
	}

	public WebElement getNomineephone() {
		return nomineephone;
	}

	public WebElement getSubmit() {
		return submit;
	}
	public String idvalue(String value) {
           String id=clientid.getAttribute("value");
	      return id;
		
	}

	public void createClient(HashMap<String,String> map, WebDriver driver,JavaUtility jlib,WebdriverUtility wlib) throws Throwable {
		int randomno=jlib.random();
		for(Entry<String,String> set:map.entrySet()) {
			if(set.getKey().equals("name")) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+randomno);	
			}
			else {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
			}
			}
		WebElement sb = wlib.elementToBeVisible(driver, submit);
		sb.click();
		//submit.click();
	}
}
