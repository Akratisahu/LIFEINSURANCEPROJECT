package practice_package;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtablexpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=WebDriverManager.chromedriver().create();
driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
//String teamname="singapore";
 //List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
 /*boolean flag=false;
for(WebElement name:teams) {
	String text=name.getText();
	if(text.equals(teamname)) {
		System.out.println("is present");
		flag=true;
		break;
	}
}
if(!flag) {
	System.out.println("not present");
}
	}*/
/*ArrayList<String> list=new ArrayList<String>();
for(int i=0;i<teams.size();i++) {
	list.add(teams.get(i).getText());
}
for(String myteams: list) {
	String rating="//span[.='"+myteams+"']/../following-sibling::td[3]";
	String Rating=driver.findElement(By.xpath(rating)).getText();
	System.out.println("team-->"+myteams+"->(rating is) ->"+Rating);
}*/
//String team="Pakistan";
//String rating=driver.findElement(By.xpath("//span[.='"+team+"']/../following-sibling::td[3]")).getText();
//System.out.println(rating);
 List<WebElement> rowcount = driver.findElements(By.tagName("tr"));
 int a = rowcount.size();
List<WebElement> colcount = driver.findElements(By.tagName("td"));
int b=colcount.size();
String expect="Pakistan";
}
}

