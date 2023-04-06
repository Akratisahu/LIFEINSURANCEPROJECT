package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtable1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disabled-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		//url of App
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		//maximize the browser
		driver.manage().window().maximize();
		//implicit wait 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//close popup
		driver.findElement(By.xpath("/")).click();
	}

}
