package com.GenericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javaScriptExecutorUtility {
 public  void drawBorder(WebElement element,WebDriver driver) {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'",element);
 }
 public  String getTitle(WebDriver driver) {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
 }
 public  void clickElementByJs(WebElement element,WebDriver driver) {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
 }
 public  void generateAlert(WebDriver driver,String message) {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')");
 }
 public  void refereshBrowserByJs(WebDriver driver) {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
 }
 public  void scrollPageDown(WebDriver driver) {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
 }
 public  void scrollPageUp(WebDriver driver) {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
 }
 public  void zoomPageByJs(WebDriver driver) {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
 }
 public  void flash(WebElement element,WebDriver driver) {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
		   String bgcolor = element.getCssValue("backgroundcolor");
		   for(int i=0;i<10;i++) {
			   changeColor("#000000",element,driver);
			   changeColor(bgcolor,element,driver);
		   }
		  
 }
 public void changeColor(String color,WebElement element,WebDriver driver) {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
	 try {
		 Thread.sleep(20);
		 }catch(InterruptedException e) {
			 
		 }
 }
}
