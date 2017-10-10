package JD_Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAction_Perform {
	private static WebDriver driver;
	private static String baseUrl;

	public static void main(String[] args) {
		driver=new ChromeDriver();
		baseUrl="https://www.jd.com/";
	
		//SeachText(driver,baseUrl);
		Mobile_Selector(driver, baseUrl);
		
		//driver.quit();
	}
	
	public static void SeachText(WebDriver dr, String URL){
		dr.get(URL);
		dr.findElement(By.id("key")).clear();//clear text
		dr.findElement(By.id("key")).sendKeys("test");//input your test string
		
		dr.findElement(By.className("button")).click();//click search button
	}
	

	public static void Mobile_Selector(WebDriver dr, String URL){
		dr.get(URL);
		Actions actions =new Actions(dr);
		actions.moveToElement(dr.findElement(By.className("service_txt"))).perform();
		
		dr.switchTo().frame(0);
		actions.moveToElement(dr.findElement(By.linkText("话费充值"))).perform();
		
		
		dr.switchTo().frame(1);
		Select select = new Select(dr.findElement(By.id("select-price-money")));
		
		//int length = select.getOptions().size();
		//System.out.println(length);
		
		select.selectByIndex(1);
		//select.selectByIndex(length-1);
		
		//select.selectByValue("10");
		//select.selectByVisibleText("20元");
		
	}
}










































