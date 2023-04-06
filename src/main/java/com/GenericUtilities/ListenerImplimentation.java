package com.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener {
	ExtentReports report ;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"------>Testscript execution stated");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"------>Testscript execution started");
	}
	public void onTestFailure(ITestResult result) {
		/*String methodName=result.getMethod().getMethodName();
		String failedscript = methodName+new JavaUtility().getSystemDate();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		 File dst = new File("./screenshot/"+failedscript+".png");
		 try {
			 FileUtils.copyFile(src, dst);
		 }catch(IOException e) {
			 e.printStackTrace();
		 }*/
		try {
			String screenshotname=WebdriverUtility.getScreenShoot(BaseClass.sdriver,result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotname);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL,result.getThrowable());//this is for extent report
		Reporter.log("Testscript execution failed");//only for testng report*/
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"testscript execution skipped");
	}
   public void onStart(ITestContext context) {
	//create html Report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-47 Batch");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Life Insurance System");
		 report = new ExtentReports();
		 report.attachReporter(htmlreport);
		 report.setSystemInfo("Browser","chrome");
		 report.setSystemInfo("OS","windows-11");
		 report.setSystemInfo("Base_URL","https://localhost:8888");
		 report.setSystemInfo("Reporter Name","Akrati Sahu");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
