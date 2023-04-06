package com.GenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void waitForPageLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	public WebElement elementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement sb = wait.until(ExpectedConditions.visibilityOf(element));
        return sb;

	}
	public void select1(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void select2(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void select(WebElement element,String visibletext) {
		Select s=new Select(element);
		s.selectByVisibleText(visibletext);
	}
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element);
	}
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst) {
		Actions act=new Actions(driver);
		act.dragAndDrop(src,dst);
	}
	public void doubleClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	public void rightClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	public void enterKeyPress(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void enterKey(WebDriver driver) throws Throwable {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	public void enterRelease(WebDriver driver) throws Throwable {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
}
	public void switchToFrame(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
	}
	public void switchToFrame(WebDriver driver,WebElement address) {
		driver.switchTo().frame(address);
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToWindow(WebDriver driver,String partialtitle) {
		//step1:use getwindowhandles to capture all window ids
		Set<String> windows=driver.getWindowHandles();
		//step2:iterate through the windows
		Iterator<String> it=windows.iterator();
		//step3:check whether there is next window
		while(it.hasNext()) {
			//step4:capture current window id
			String winid=it.next();
	//setp5:switch to current window and capture title
		String currentwintitle=driver.switchTo().window(winid).getTitle();
		
	//step6: check whether current window is expected
		if(currentwintitle.contains(partialtitle)) {
			break;
		}
		}
	}
	public static String getScreenShoot(WebDriver driver,String ScreenshotName) throws Throwable {
	 
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			String path=".//screenshot//"+ScreenshotName+".png";
			File dst=new File(path);
			FileUtils.copyFile(src, dst);
			return path;
			
			}
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,800)","");
			}
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("Window.scrollBy(0,"+y+")",element);
			}
}
