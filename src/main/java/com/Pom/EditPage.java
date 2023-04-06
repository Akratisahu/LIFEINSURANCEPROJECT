package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {
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
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	@FindBy(linkText="Delete Client")
	private WebElement deleteclient;
	
	 public EditPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		}

	public WebElement getClientpwd() {
		return clientpwd;
	}

	public void setClientpwd(String clientpw) {
		clientpwd.clear();
		clientpwd.sendKeys(clientpw);
	}

	public WebElement getName() {
		return name;
	}

	public void setName(String nameedit) {
			name.clear();
			name.sendKeys(nameedit);
		}

	

	public WebElement getFileupload() {
		return fileupload;
	}
	public void setfileupload(String file) {
		fileupload.clear();
		fileupload.sendKeys(file);
	}

	public WebElement getSex() {
		return sex;
	}
	public void setsex(String sexedit) {
		sex.clear();
		sex.sendKeys(sexedit);
	}

	public WebElement getBirthdate() {
		return birthdate;
	}
	public void setbirthdate(String birthdateedit) {
		birthdate.clear();
		birthdate.sendKeys(birthdateedit);
	}
    public WebElement getMaritialstatus() {
		return maritialstatus;
	}
    public void setmaritalstatus(String maritalstatusedit) {
    	maritialstatus.clear();
    	maritialstatus.sendKeys(maritalstatusedit);
	}

	public WebElement getNid() {
		return nid;
	}
	public void setNid(String nidedit) {
		nid.clear();
		nid.sendKeys(nidedit);
	}
     public WebElement getPhone() {
		return phone;
	}
     public void setphone(String phoneedit) {
			phone.clear();
			phone.sendKeys(phoneedit);
		}
    public WebElement getAddress() {
		return address;
	}
    public void setaddress(String addressedit) {
		address.clear();
		address.sendKeys(addressedit);
	}
    public WebElement getPolicyid() {
		return policyid;
	}
    public void setpolicyid(String editid) {
		policyid.clear();
		policyid.sendKeys(editid);
	}
public void submitedit() {
	submit.click();
}
public void deleteclient() {
	deleteclient.click();
}
	
	

}
